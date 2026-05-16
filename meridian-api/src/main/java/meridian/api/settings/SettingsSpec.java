package meridian.api.settings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
 *
 * <p>By default every setting is persisted. Call {@link Builder#ephemeral()}
 * right after declaring a setting to opt it out: its value is never written to
 * disk and it always starts from its declared initial value. Useful for
 * session-only toggles (an active camera mode, an X-Ray switch) that should not
 * survive a restart.
 */
public final class SettingsSpec {
    private final List<SettingNode> nodes;
    private final Set<String> nonPersistentKeys;

    private SettingsSpec(List<SettingNode> nodes, Set<String> nonPersistentKeys) {
        this.nodes = List.copyOf(nodes);
        this.nonPersistentKeys = Set.copyOf(nonPersistentKeys);
    }

    /** Top-level nodes of this spec, in declaration order. */
    public List<SettingNode> nodes() {
        return nodes;
    }

    /**
     * Keys of settings that must not be persisted — see {@link Builder#ephemeral()}.
     * Includes keys gathered from nested sections.
     */
    public Set<String> nonPersistentKeys() {
        return nonPersistentKeys;
    }

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for a {@link SettingsSpec}. */
    public static final class Builder {
        private final List<SettingNode> nodes = new ArrayList<>();
        private final Set<String> nonPersistentKeys = new HashSet<>();

        /** Adds a named group whose children come from {@code content}. */
        public Builder section(String name, SettingsSpec content) {
            nodes.add(new SettingNode.Section(name, content.nodes()));
            // A nested section may itself mark children ephemeral — carry those up.
            nonPersistentKeys.addAll(content.nonPersistentKeys());
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

        /**
         * Marks the most recently declared setting as non-persistent: its value
         * is never written to {@code settings.json} and it always starts from
         * its declared initial value. When applied to a {@code section(...)} it
         * marks every setting inside it.
         *
         * @throws IllegalStateException if no setting has been declared yet
         */
        public Builder ephemeral() {
            if (nodes.isEmpty()) {
                throw new IllegalStateException("ephemeral() called before any setting was declared");
            }
            collectKeys(nodes.get(nodes.size() - 1), nonPersistentKeys);
            return this;
        }

        public SettingsSpec build() {
            return new SettingsSpec(nodes, nonPersistentKeys);
        }

        private static void collectKeys(SettingNode node, Set<String> out) {
            switch (node) {
                case SettingNode.Section s -> {
                    for (SettingNode child : s.children()) {
                        collectKeys(child, out);
                    }
                }
                case SettingNode.Bool b -> out.add(b.key());
                case SettingNode.IntValue i -> out.add(i.key());
                case SettingNode.Text t -> out.add(t.key());
                case SettingNode.EnumChoice<?> e -> out.add(e.key());
                case SettingNode.StringList l -> out.add(l.key());
                case SettingNode.RegexList r -> out.add(r.key());
                case SettingNode.ColorValue c -> out.add(c.key());
                case SettingNode.PlayerList p -> out.add(p.key());
            }
        }
    }
}
