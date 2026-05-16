package meridian.api.settings;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.regex.Pattern;

/**
 * Declarative description of a module's settings UI.
 *
 * <p>Built with {@link #builder()}; the proxy renders it into its native GUI
 * and persists each setting's value to {@code <dataDir>/settings.json}. The
 * spec is Swing-free — modules describe <em>what</em> they want, not how it
 * looks.
 *
 * <pre>{@code
 * ctx.registerSettings(SettingsSpec.builder()
 *     .bool("enabled", "Enable X-Ray", false, v -> enabled = v)
 *     .build());
 * }</pre>
 */
public final class SettingsSpec {
    private final List<SettingNode> nodes;

    private SettingsSpec(List<SettingNode> nodes) {
        this.nodes = List.copyOf(nodes);
    }

    /** Top-level nodes of this spec, in declaration order. */
    public List<SettingNode> nodes() {
        return nodes;
    }

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for a {@link SettingsSpec}. */
    public static final class Builder {
        private final List<SettingNode> nodes = new ArrayList<>();

        /** Adds a named group whose children come from {@code content}. */
        public Builder section(String name, SettingsSpec content) {
            nodes.add(new SettingNode.Section(name, content.nodes()));
            return this;
        }

        public Builder bool(String key, String label, boolean initial, Consumer<Boolean> onChange) {
            nodes.add(new SettingNode.Bool(key, label, initial, onChange));
            return this;
        }

        public Builder int_(String key, String label, int min, int max, int initial,
                             Consumer<Integer> onChange) {
            nodes.add(new SettingNode.IntValue(key, label, min, max, initial, onChange));
            return this;
        }

        public Builder string(String key, String label, String initial, Consumer<String> onChange) {
            nodes.add(new SettingNode.Text(key, label, initial, onChange));
            return this;
        }

        public <E extends Enum<E>> Builder enum_(String key, String label, Class<E> type,
                                                 E initial, Consumer<E> onChange) {
            nodes.add(new SettingNode.EnumChoice<>(key, label, type, initial, onChange));
            return this;
        }

        public Builder stringList(String key, String label, List<String> initial,
                                  Consumer<List<String>> onChange) {
            nodes.add(new SettingNode.StringList(key, label, List.copyOf(initial), onChange));
            return this;
        }

        public Builder regexList(String key, String label, List<String> initial,
                                 Consumer<List<Pattern>> onChange) {
            nodes.add(new SettingNode.RegexList(key, label, List.copyOf(initial), onChange));
            return this;
        }

        public Builder color(String key, String label, int initialRgba, IntConsumer onChange) {
            nodes.add(new SettingNode.ColorValue(key, label, initialRgba, onChange));
            return this;
        }

        public Builder playerList(String key, String label, Consumer<List<UUID>> onChange) {
            nodes.add(new SettingNode.PlayerList(key, label, onChange));
            return this;
        }

        public SettingsSpec build() {
            return new SettingsSpec(nodes);
        }
    }
}
