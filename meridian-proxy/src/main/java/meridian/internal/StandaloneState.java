package meridian.internal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import meridian.internal.core.ProxyConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Standalone-mode state persisted next to the jar as {@code state.json}.
 *
 * <p>Holds the remotes the user has connected to, so the Connect bar can pre-fill the
 * last one and offer the rest in its dropdown. Session tokens are deliberately
 * <em>not</em> stored — they are short-lived and are snooped fresh from the running
 * game on every launch.
 */
public final class StandaloneState {
    private static final Logger log = LoggerFactory.getLogger(StandaloneState.class);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /** How many remotes the dropdown remembers before the oldest falls off. */
    private static final int MAX_RECENTS = 10;

    /** Last entered remote, e.g. {@code "45.12.34.56:5520"}. */
    public String lastHostPort;

    /** Previously-connected remotes, most recent first. */
    public List<String> recentHostPorts;

    private static Path file() {
        return ProxyConfig.jarDir().resolve("state.json");
    }

    public static StandaloneState load() {
        Path f = file();
        if (Files.exists(f)) {
            try (Reader r = Files.newBufferedReader(f)) {
                StandaloneState s = GSON.fromJson(r, StandaloneState.class);
                if (s != null) return s;
            } catch (Exception e) {
                log.warn("Failed to read state.json: {}", e.toString());
            }
        }
        return new StandaloneState();
    }

    public void save() {
        try (Writer w = Files.newBufferedWriter(file())) {
            GSON.toJson(this, w);
        } catch (Exception e) {
            log.warn("Failed to write state.json: {}", e.toString());
        }
    }

    /**
     * The remembered remotes, most recent first. A state file written before the list
     * existed still carries {@code lastHostPort}, which is folded in so an upgrade does
     * not start the user with an empty dropdown.
     */
    public List<String> recents() {
        List<String> out = new ArrayList<>();
        if (recentHostPorts != null) {
            for (String s : recentHostPorts) {
                if (s != null && !s.isBlank() && !out.contains(s)) out.add(s);
            }
        }
        if (lastHostPort != null && !lastHostPort.isBlank() && !out.contains(lastHostPort)) {
            out.add(lastHostPort);
        }
        return out;
    }

    /** Moves {@code hostPort} to the front of the recents (no duplicates, capped). */
    public void remember(String hostPort) {
        if (hostPort == null || hostPort.isBlank()) return;
        List<String> updated = new ArrayList<>();
        updated.add(hostPort);
        for (String s : recents()) {
            if (!s.equals(hostPort)) updated.add(s);
        }
        while (updated.size() > MAX_RECENTS) {
            updated.remove(updated.size() - 1);
        }
        recentHostPorts = updated;
        lastHostPort = hostPort;
    }
}
