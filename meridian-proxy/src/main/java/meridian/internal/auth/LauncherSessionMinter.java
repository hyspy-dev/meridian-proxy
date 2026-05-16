package meridian.internal.auth;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.UUID;

/**
 * Builds the proxy's full token set from a player session token, deriving a
 * server-scope child session off it.
 *
 * <p>The player session token is supplied by the caller — either snooped from the
 * running game's environment block ({@link GameProcessSnooper}) or pasted by the
 * user / passed via {@code --session-token}. From it:
 * <pre>
 *   POST /game-session/child  → server sessionToken + identityToken
 *     Bearer: player sessionToken
 *     Body:   {"scopes":["hytale:server"]}
 * </pre>
 *
 * <p>We never call {@code /game-session/new} or {@code /oauth2/token refresh}
 * ourselves. Either would mint a fresh player session for the same account and
 * Hytale's "one active session per account" rule would invalidate the game's
 * session, dropping the game into offline mode. The {@code /child} endpoint
 * appears to allow multiple children per parent, so calling it from the proxy
 * coexists with the game's own usage.
 */
public final class LauncherSessionMinter {
    private static final Logger log = LoggerFactory.getLogger(LauncherSessionMinter.class);

    private static final String SESSIONS_BASE = "https://sessions.hytale.com";
    private static final String USER_AGENT = "MeridianProxy/1.0";

    private final HttpClient http = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(15))
            .build();

    public record SessionBundle(
            UUID profileUuid,
            String playerSessionToken,
            String playerIdentityToken,
            @Nullable Instant playerExpiresAt,
            String serverSessionToken,
            String serverIdentityToken,
            @Nullable Instant serverExpiresAt
    ) {}

    /**
     * Builds the full proxy token set from a player session token. The token is
     * either snooped from the running game or pasted by the user into the GUI.
     * Performs the {@code /game-session/child} hop to obtain the server-scope pair.
     */
    public SessionBundle mintFromPlayerSession(String playerSessionToken) throws Exception {
        if (playerSessionToken == null || playerSessionToken.isBlank()) {
            throw new IllegalStateException("No session token provided.");
        }
        Instant playerExpiresAt = jwtExpiry(playerSessionToken);
        UUID uuid = jwtSubject(playerSessionToken);

        log.info("[mint] player session supplied (profile={}, exp={})", uuid, playerExpiresAt);

        ChildSession child = newServerSessionFromParent(playerSessionToken);
        log.info("[mint] minted server (child) session (identityLen={}, sessionLen={}, exp={})",
                child.identityToken.length(), child.sessionToken.length(), child.expiresAt);

        return new SessionBundle(
                uuid,
                playerSessionToken, "", playerExpiresAt,
                child.sessionToken, child.identityToken, child.expiresAt
        );
    }

    /**
     * Mode 3: derive the two server-scope tokens from an externally supplied player
     * session token (e.g. passed via {@code --session-token} on a platform without
     * process-env snooping). Same {@code /game-session/child} hop as {@link #mintFromPlayerSession}.
     */
    public ServerTokens deriveServerTokens(String playerSessionToken) throws Exception {
        ChildSession child = newServerSessionFromParent(playerSessionToken);
        log.info("[mint] derived server tokens from supplied player session (identityLen={}, sessionLen={}, exp={})",
                child.identityToken.length(), child.sessionToken.length(), child.expiresAt);
        return new ServerTokens(child.sessionToken, child.identityToken, child.expiresAt);
    }

    public record ServerTokens(String sessionToken, String identityToken, @Nullable Instant expiresAt) {}

    /** POST /game-session/child Bearer=player-sessionToken body={"scopes":["hytale:server"]}. */
    private ChildSession newServerSessionFromParent(String playerSessionToken) throws Exception {
        String body = "{\"scopes\":[\"hytale:server\"]}";
        HttpRequest req = HttpRequest.newBuilder(URI.create(SESSIONS_BASE + "/game-session/child"))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + playerSessionToken)
                .header("User-Agent", USER_AGENT)
                .timeout(Duration.ofSeconds(15))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        HttpResponse<String> resp = http.send(req, HttpResponse.BodyHandlers.ofString());
        if (resp.statusCode() / 100 != 2) {
            throw new RuntimeException("game-session/child HTTP " + resp.statusCode() + ": " + resp.body());
        }
        JsonObject obj = JsonParser.parseString(resp.body()).getAsJsonObject();
        Instant exp = null;
        if (obj.has("expiresAt") && !obj.get("expiresAt").isJsonNull()) {
            try { exp = Instant.parse(obj.get("expiresAt").getAsString()); } catch (Exception ignored) {}
        }
        return new ChildSession(
                obj.get("identityToken").getAsString(),
                obj.get("sessionToken").getAsString(),
                exp);
    }

    private record ChildSession(String identityToken, String sessionToken, Instant expiresAt) {}

    @Nullable
    private static Instant jwtExpiry(String jwt) {
        try {
            JsonObject p = jwtPayload(jwt);
            if (p.has("exp")) return Instant.ofEpochSecond(p.get("exp").getAsLong());
        } catch (Exception ignored) {}
        return null;
    }

    @Nullable
    private static UUID jwtSubject(String jwt) {
        try {
            JsonObject p = jwtPayload(jwt);
            if (p.has("sub")) return UUID.fromString(p.get("sub").getAsString());
        } catch (Exception ignored) {}
        return null;
    }

    private static JsonObject jwtPayload(String jwt) {
        String[] parts = jwt.split("\\.");
        if (parts.length != 3) throw new IllegalArgumentException("not a JWT");
        byte[] payload = Base64.getUrlDecoder().decode(padBase64Url(parts[1]));
        return JsonParser.parseString(new String(payload, StandardCharsets.UTF_8)).getAsJsonObject();
    }

    private static String padBase64Url(String s) {
        int rem = s.length() % 4;
        return rem == 0 ? s : s + "===".substring(rem - 1);
    }
}
