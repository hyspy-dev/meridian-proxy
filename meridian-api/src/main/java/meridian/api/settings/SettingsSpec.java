package meridian.api.settings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.regex.Pattern;

/**
 * Declarative description of a module's settings UI.
 *
 * <p>Built with {@link #builder()}; the proxy renders it into its native GUI.
 * The spec is Swing-free — modules describe <em>what</em> they want, not how
 * it looks.
 *
 * <pre>{@code
 * ctx.registerSettings(SettingsSpec.builder()
 *     .bool("enabled", "Enable X-Ray", false, v -> enabled = v)
 *     .build());
 * }</pre>
 *
 * <p><b>Persistence is opt-in.</b> By default no setting survives a proxy
 * restart — each `onChange` callback fires with the declared initial value at
 * registration time and again on every edit. Mark settings worth remembering
 * with {@link Builder#persistent()} (chain) or {@link Builder#persistent(String...)}
 * (by key); only those are written to {@code <dataDir>/settings.json} and
 * reloaded next start.
 *
 * <p>Full reference (lifecycle, every widget, live lists, cross-module wiring):
 * <a href="https://github.com/hyspy-dev/meridian-proxy/blob/main/meridian-proxy/docs/settings.md">docs/settings.md</a>.
 */
public final class SettingsSpec {
    private final List<SettingNode> nodes;
    private final Set<String> persistentKeys;

    private SettingsSpec(List<SettingNode> nodes, Set<String> persistentKeys) {
        this.nodes = List.copyOf(nodes);
        this.persistentKeys = Set.copyOf(persistentKeys);
    }

    /** Top-level nodes of this spec, in declaration order. */
    public List<SettingNode> nodes() {
        return nodes;
    }

    /**
     * Keys of settings that opted in to disk persistence via
     * {@link Builder#persistent()} / {@link Builder#persistent(String...)}.
     * Includes keys collected from nested sections.
     */
    public Set<String> persistentKeys() {
        return persistentKeys;
    }

    public static Builder builder() {
        return new Builder();
    }

    /** Fluent builder for a {@link SettingsSpec}. */
    public static final class Builder {
        private final List<SettingNode> nodes = new ArrayList<>();
        private final Set<String> persistentKeys = new HashSet<>();

        /** Adds a named group whose children come from {@code content}. */
        public Builder section(String name, SettingsSpec content) {
            nodes.add(new SettingNode.Section(name, content.nodes()));
            // A nested section may itself have opted children into persistence —
            // carry those decisions up.
            persistentKeys.addAll(content.persistentKeys());
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
            nodes.add(new SettingNode.Text(key, label, initial, onChange, null));
            return this;
        }

        /**
         * Text field with a two-way binding — the module can push values into
         * the UI via {@code binding.set(...)}. See {@link SettingBinding}.
         */
        public Builder string(String key, String label, String initial, Consumer<String> onChange,
                              SettingBinding<String> binding) {
            nodes.add(new SettingNode.Text(key, label, initial, onChange, binding));
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
         * Adds a clickable button. The {@code onClick} runs on the Swing EDT;
         * keep it cheap or offload via {@code ctx.offloadExecutor()}.
         */
        public Builder button(String label, Runnable onClick) {
            nodes.add(new SettingNode.Button(label, onClick));
            return this;
        }

        /**
         * Adds a read-only list whose rows come from {@code source}. The proxy
         * polls the supplier on its UI timer — see {@link SettingNode.LiveList}.
         */
        public Builder liveList(String label, Supplier<List<String>> source) {
            nodes.add(new SettingNode.LiveList(label, source, null));
            return this;
        }

        /**
         * Adds a clickable live list — {@code onRowClick} is invoked with the
         * row index (0-based) when the user clicks a row. See
         * {@link SettingNode.LiveList} for the row→payload contract.
         */
        public Builder liveList(String label, Supplier<List<String>> source,
                                IntConsumer onRowClick) {
            nodes.add(new SettingNode.LiveList(label, source, onRowClick));
            return this;
        }

        /**
         * Marks the most recently declared setting (or every setting under it
         * if it was a {@code section(...)}) as persistent: its value is
         * written to {@code settings.json} and reloaded on the next start.
         * Without this call a setting is session-only and always begins from
         * its declared initial.
         *
         * @throws IllegalStateException if no setting has been declared yet
         */
        public Builder persistent() {
            if (nodes.isEmpty()) {
                throw new IllegalStateException("persistent() called before any setting was declared");
            }
            collectKeys(nodes.get(nodes.size() - 1), persistentKeys);
            return this;
        }

        /**
         * Marks every setting whose key appears in {@code keys} as persistent.
         * Useful when many settings are declared in a row, or for marking a
         * setting that lives inside an already-built sub-spec.
         *
         * <p>Every key must already refer to a setting declared in this spec
         * (the search walks nested sections); otherwise registration fails
         * loud and the typo is caught at startup.
         *
         * @throws IllegalArgumentException if any key has no matching setting
         */
        public Builder persistent(String... keys) {
            for (String key : keys) {
                if (!findKey(nodes, key)) {
                    throw new IllegalArgumentException(
                            "persistent(\"" + key + "\"): no setting with that key has been declared");
                }
                persistentKeys.add(key);
            }
            return this;
        }

        public SettingsSpec build() {
            return new SettingsSpec(nodes, persistentKeys);
        }

        private static boolean findKey(List<SettingNode> nodes, String key) {
            for (SettingNode node : nodes) {
                String k = keyOf(node);
                if (k != null && key.equals(k)) return true;
                if (node instanceof SettingNode.Section s && findKey(s.children(), key)) {
                    return true;
                }
            }
            return false;
        }

        private static String keyOf(SettingNode node) {
            return switch (node) {
                case SettingNode.Bool b -> b.key();
                case SettingNode.IntValue i -> i.key();
                case SettingNode.Text t -> t.key();
                case SettingNode.EnumChoice<?> e -> e.key();
                case SettingNode.StringList l -> l.key();
                case SettingNode.RegexList r -> r.key();
                case SettingNode.ColorValue c -> c.key();
                case SettingNode.PlayerList p -> p.key();
                // Keyless nodes — sections, buttons, live-lists.
                case SettingNode.Section ignored -> null;
                case SettingNode.Button ignored -> null;
                case SettingNode.LiveList ignored -> null;
            };
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
                case SettingNode.LiveList ignored -> { /* read-only, no key */ }
                case SettingNode.Button ignored -> { /* action only, no key */ }
            }
        }
    }
}
