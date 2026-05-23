package meridian.api.settings;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.regex.Pattern;

/**
 * One node of a {@link SettingsSpec} tree — either a {@link Section} group or a
 * leaf setting. The proxy renders these into its native UI; modules never touch
 * Swing.
 *
 * <p>Every leaf carries a {@code key} (unique within the module) used to persist
 * its value, and an {@code onChange} callback invoked with the persisted value
 * at startup and again on every edit.
 */
public sealed interface SettingNode {

    /** A named group of child nodes. */
    record Section(String name, List<SettingNode> children) implements SettingNode {}

    /** Checkbox. */
    record Bool(String key, String label, boolean initial,
                Consumer<Boolean> onChange) implements SettingNode {}

    /** Bounded integer (spinner). */
    record IntValue(String key, String label, int min, int max, int initial,
                    Consumer<Integer> onChange) implements SettingNode {}

    /**
     * Free text field. When {@code binding} is non-null the module can mutate
     * the field's value from code — see {@link SettingBinding}.
     */
    record Text(String key, String label, String initial,
                Consumer<String> onChange,
                SettingBinding<String> binding) implements SettingNode {
        public Text(String key, String label, String initial, Consumer<String> onChange) {
            this(key, label, initial, onChange, null);
        }
    }

    /** One-of-enum choice (combo box). */
    record EnumChoice<E extends Enum<E>>(String key, String label, Class<E> type, E initial,
                                         Consumer<E> onChange) implements SettingNode {}

    /** Editable list of strings, one per line. */
    record StringList(String key, String label, List<String> initial,
                      Consumer<List<String>> onChange) implements SettingNode {}

    /** List of regular expressions — each line is validated before persisting. */
    record RegexList(String key, String label, List<String> initial,
                     Consumer<List<Pattern>> onChange) implements SettingNode {}

    /** RGBA colour, edited via a colour picker. */
    record ColorValue(String key, String label, int initialRgba,
                      IntConsumer onChange) implements SettingNode {}

    /**
     * List of player UUIDs. Renders with autocomplete when a
     * {@code PlayerRegistry} service is available, otherwise degrades to a
     * plain UUID-per-line editor.
     */
    record PlayerList(String key, String label,
                      Consumer<List<UUID>> onChange) implements SettingNode {}

    /**
     * Clickable button. No persistence — buttons are pure actions. The
     * {@code onClick} runs on the Swing EDT; offload anything blocking to
     * {@code ctx.offloadExecutor()} or {@code ctx.scheduler()}.
     */
    record Button(String label, Runnable onClick) implements SettingNode {}

    /**
     * Read-only live list — the proxy polls {@code source} on a UI timer and
     * shows each returned string as a row. No persistence, no edit; modules
     * use it to surface dynamic info (nearest entities/blocks, etc.).
     *
     * @param label       shown above the list
     * @param source      called on the UI thread at the proxy's poll cadence;
     *                    must be cheap and thread-safe — read a volatile
     *                    snapshot field, do not scan on every call
     * @param onRowClick  optional row-click handler (may be {@code null}); the
     *                    proxy calls it with the row index that was clicked.
     *                    The module is responsible for mapping the index back
     *                    to whatever payload it needs — typically by reading
     *                    the same volatile snapshot {@code source} pulled
     *                    from, parallelised with a payload list of the same
     *                    length
     */
    record LiveList(String label, Supplier<List<String>> source,
                    IntConsumer onRowClick) implements SettingNode {}
}
