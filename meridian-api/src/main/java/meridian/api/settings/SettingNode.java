package meridian.api.settings;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
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

    /** Free text field. */
    record Text(String key, String label, String initial,
                Consumer<String> onChange) implements SettingNode {}

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
}
