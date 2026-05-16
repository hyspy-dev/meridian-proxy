package meridian.internal;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class HytaleSessionApi {
    private static final Logger log = LoggerFactory.getLogger(HytaleSessionApi.class);
    private static final String BASE = "https://sessions.hytale.com";
    private static final String SERVER_GRANT_AUD = "8ff3538d-895e-4c6b-8cbf-c3e542887b66";

    private final HttpClient http = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10)).build();
    private final String sessionToken;

    public HytaleSessionApi(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public CompletableFuture<String> fetchAccessToken(String authorizationGrant, String fingerprintB64Url) {
        JsonObject body = new JsonObject();
        body.addProperty("authorizationGrant", authorizationGrant);
        body.addProperty("x509Fingerprint", fingerprintB64Url);
        log.info("POST /server-join/auth-token with fingerprint {}", fingerprintB64Url);
        return post("/server-join/auth-token", body.toString()).thenApply(s -> {
            String token = JsonParser.parseString(s).getAsJsonObject().get("accessToken").getAsString();
            log.info("accessToken received (len={})", token.length());
            return token;
        });
    }

    public CompletableFuture<String> fetchServerGrant(String serverIdentityToken) {
        JsonObject body = new JsonObject();
        body.addProperty("identityToken", serverIdentityToken);
        body.addProperty("aud", SERVER_GRANT_AUD);
        log.info("POST /server-join/auth-grant");
        return post("/server-join/auth-grant", body.toString()).thenApply(s -> {
            String grant = JsonParser.parseString(s).getAsJsonObject().get("authorizationGrant").getAsString();
            log.info("server authorizationGrant received (len={})", grant.length());
            return grant;
        });
    }

    private CompletableFuture<String> post(String path, String json) {
        HttpRequest req = HttpRequest.newBuilder(URI.create(BASE + path))
                .header("Authorization", "Bearer " + sessionToken)
                .header("User-Agent", "Go-http-client/1.1")
                .header("Content-Type", "application/json")
                .timeout(Duration.ofSeconds(15))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        return http.sendAsync(req, HttpResponse.BodyHandlers.ofString()).thenApply(resp -> {
            if (resp.statusCode() / 100 != 2) {
                throw new RuntimeException("HTTP " + resp.statusCode() + " from " + path + ": " + resp.body());
            }
            return resp.body();
        });
    }
}
