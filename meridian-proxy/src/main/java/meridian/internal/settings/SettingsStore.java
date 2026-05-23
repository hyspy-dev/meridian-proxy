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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Per-module settings persistence — a flat {@code key -> value} map backed by
 * {@code <dataDir>/settings.json}.
 *
 * <p>Values are stored with whatever JSON-native shape gson produces
 * (Boolean / Double / String / List); {@code SettingsRenderer} coerces them
 * back to the type each setting expects.
 *
 * <p><b>Persistence is opt-in.</b> The store starts with an empty whitelist;
 * {@link #markPersistent} adds keys to it. Only whitelisted keys survive a
 * {@link #set}; everything else is session-only — kept by the widget and
 * module state in memory but never written to disk. Stale keys found in the
 * file on load are dropped on the next save.
 */
public final class SettingsStore {
    private static final Logger log = LoggerFactory.getLogger(SettingsStore.class);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private final Path file;
    private final Map<String, Object> values;
    private final Set<String> persistentKeys = new HashSet<>();

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

    /**
     * Whitelists {@code key} for disk persistence — subsequent {@link #set}
     * calls write it through to {@code settings.json}.
     */
    public void markPersistent(String key) {
        persistentKeys.add(key);
    }

    /**
     * Raw stored value for {@code key}, or {@code null} if it isn't persistent
     * or was never written. Persistent keys with a previously-saved value are
     * returned; non-persistent keys always read as {@code null} so the
     * renderer falls back to the declared initial.
     */
    public Object get(String key) {
        return persistentKeys.contains(key) ? values.get(key) : null;
    }

    /** Stores {@code value} under {@code key} and flushes to disk if it's persistent. */
    public void set(String key, Object value) {
        if (!persistentKeys.contains(key)) {
            // Session-only setting — do not retain or write it.
            return;
        }
        values.put(key, value);
        save();
    }

    private void save() {
        try {
            if (file.getParent() != null) {
                Files.createDirectories(file.getParent());
            }
            // Drop any orphan keys the spec doesn't recognise as persistent —
            // they would otherwise hang around indefinitely from older builds.
            values.keySet().removeIf(k -> !persistentKeys.contains(k));
            try (Writer writer = Files.newBufferedWriter(file)) {
                GSON.toJson(values, writer);
            }
        } catch (Exception e) {
            log.error("Failed to save settings file {}: {}", file, e.toString());
        }
    }
}
