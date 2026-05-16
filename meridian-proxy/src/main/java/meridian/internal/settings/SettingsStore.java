package meridian.internal.settings;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * Per-module settings persistence — a flat {@code key -> value} map backed by
 * {@code <dataDir>/settings.json}.
 *
 * <p>Values are stored with whatever JSON-native shape gson produces
 * (Boolean / Double / String / List); {@code SettingsRenderer} coerces them
 * back to the type each setting expects.
 */
public final class SettingsStore {
    private static final Logger log = LoggerFactory.getLogger(SettingsStore.class);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private final Path file;
    private final Map<String, Object> values;

    public SettingsStore(Path file) {
        this.file = file;
        this.values = load(file);
    }

    private static Map<String, Object> load(Path file) {
        if (!Files.exists(file)) {
            return new HashMap<>();
        }
        try (Reader reader = Files.newBufferedReader(file)) {
            Map<String, Object> loaded = GSON.fromJson(
                    reader, new TypeToken<Map<String, Object>>() {}.getType());
            return loaded != null ? loaded : new HashMap<>();
        } catch (Exception e) {
            log.warn("Failed to read settings file {}: {}", file, e.toString());
            return new HashMap<>();
        }
    }

    /** Raw stored value for {@code key}, or {@code null} if never persisted. */
    public Object get(String key) {
        return values.get(key);
    }

    /** Stores {@code value} under {@code key} and flushes to disk. */
    public void set(String key, Object value) {
        values.put(key, value);
        save();
    }

    private void save() {
        try {
            if (file.getParent() != null) {
                Files.createDirectories(file.getParent());
            }
            try (Writer writer = Files.newBufferedWriter(file)) {
                GSON.toJson(values, writer);
            }
        } catch (Exception e) {
            log.error("Failed to save settings file {}: {}", file, e.toString());
        }
    }
}
