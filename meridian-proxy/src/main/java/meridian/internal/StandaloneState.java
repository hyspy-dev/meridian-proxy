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

/**
 * Standalone-mode state persisted next to the jar as {@code state.json}.
 *
 * <p>Holds only the last-used remote so the Connect bar can pre-fill it.
 * Session tokens are deliberately <em>not</em> stored — they are short-lived and
 * are snooped fresh from the running game on every launch.
 */
public final class StandaloneState {
    private static final Logger log = LoggerFactory.getLogger(StandaloneState.class);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /** Last entered remote, e.g. {@code "45.12.34.56:5520"}. */
    public String lastHostPort;

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
}
