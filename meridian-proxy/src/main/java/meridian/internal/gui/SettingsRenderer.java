package meridian.internal.gui;

import meridian.api.settings.SettingNode;
import meridian.api.settings.SettingsSpec;
import meridian.internal.settings.SettingsStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Renders a {@link SettingsSpec} into a Swing {@link JPanel}.
 *
 * <p>The only place {@code SettingsSpec} meets Swing. For each leaf it applies
 * the persisted value (or the declared initial) to the module's callback at
 * render time, then wires edits back through the {@link SettingsStore}.
 */
public final class SettingsRenderer {
    private static final Logger log = LoggerFactory.getLogger(SettingsRenderer.class);

    private static final Color BG = new Color(20, 20, 20);
    private static final Color FG = Color.WHITE;
    private static final Color BAD = new Color(200, 80, 80);

    private SettingsRenderer() {}

    public static JPanel render(SettingsSpec spec, SettingsStore store) {
        JPanel root = column();
        for (SettingNode node : spec.nodes()) {
            root.add(renderNode(node, store));
        }
        return root;
    }

    private static JComponent renderNode(SettingNode node, SettingsStore store) {
        return switch (node) {
            case SettingNode.Section s -> renderSection(s, store);
            case SettingNode.Bool b -> renderBool(b, store);
            case SettingNode.IntValue i -> renderInt(i, store);
            case SettingNode.Text t -> renderText(t, store);
            case SettingNode.EnumChoice<?> e -> renderEnum(e, store);
            case SettingNode.StringList l -> renderStringList(l, store);
            case SettingNode.RegexList r -> renderRegexList(r, store);
            case SettingNode.ColorValue c -> renderColor(c, store);
            case SettingNode.PlayerList p -> renderPlayerList(p, store);
        };
    }

    // ------------------------------------------------------------------

    private static JComponent renderSection(SettingNode.Section section, SettingsStore store) {
        JPanel panel = column();
        Border line = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(70, 70, 70)), section.name());
        panel.setBorder(line);
        for (SettingNode child : section.children()) {
            panel.add(renderNode(child, store));
        }
        return panel;
    }

    private static JComponent renderBool(SettingNode.Bool b, SettingsStore store) {
        boolean current = store.get(b.key()) instanceof Boolean v ? v : b.initial();
        b.onChange().accept(current);

        JCheckBox box = new JCheckBox(b.label(), current);
        box.setBackground(BG);
        box.setForeground(FG);
        box.addActionListener(e -> {
            store.set(b.key(), box.isSelected());
            b.onChange().accept(box.isSelected());
        });
        return row(box);
    }

    private static JComponent renderInt(SettingNode.IntValue i, SettingsStore store) {
        int current = store.get(i.key()) instanceof Number n ? n.intValue() : i.initial();
        current = Math.max(i.min(), Math.min(i.max(), current));
        i.onChange().accept(current);

        JSpinner spinner = new JSpinner(new SpinnerNumberModel(current, i.min(), i.max(), 1));
        spinner.addChangeListener(e -> {
            int v = (Integer) spinner.getValue();
            store.set(i.key(), v);
            i.onChange().accept(v);
        });
        return labeled(i.label(), spinner);
    }

    private static JComponent renderText(SettingNode.Text t, SettingsStore store) {
        String current = store.get(t.key()) instanceof String s ? s : t.initial();
        t.onChange().accept(current);

        JTextField field = new JTextField(current, 16);
        field.addFocusListener(new FocusAdapter() {
            @Override public void focusLost(FocusEvent e) {
                store.set(t.key(), field.getText());
                t.onChange().accept(field.getText());
            }
        });
        return labeled(t.label(), field);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static JComponent renderEnum(SettingNode.EnumChoice<?> e, SettingsStore store) {
        Class type = e.type();
        Object[] constants = type.getEnumConstants();
        Object current = e.initial();
        if (store.get(e.key()) instanceof String name) {
            try {
                current = Enum.valueOf(type, name);
            } catch (IllegalArgumentException ignored) {
                // stale value — fall back to initial
            }
        }
        ((java.util.function.Consumer) e.onChange()).accept(current);

        JComboBox<Object> combo = new JComboBox<>(constants);
        combo.setSelectedItem(current);
        combo.addActionListener(ev -> {
            Object sel = combo.getSelectedItem();
            store.set(e.key(), ((Enum<?>) sel).name());
            ((java.util.function.Consumer) e.onChange()).accept(sel);
        });
        return labeled(e.label(), combo);
    }

    private static JComponent renderStringList(SettingNode.StringList l, SettingsStore store) {
        List<String> current = asStringList(store.get(l.key()), l.initial());
        l.onChange().accept(current);

        JTextArea area = textArea(String.join("\n", current));
        area.addFocusListener(new FocusAdapter() {
            @Override public void focusLost(FocusEvent e) {
                List<String> lines = nonBlankLines(area.getText());
                store.set(l.key(), lines);
                l.onChange().accept(lines);
            }
        });
        return labeledAbove(l.label(), new JScrollPane(area));
    }

    private static JComponent renderRegexList(SettingNode.RegexList r, SettingsStore store) {
        List<String> current = asStringList(store.get(r.key()), r.initial());
        r.onChange().accept(compile(current)); // initial values are assumed valid

        JTextArea area = textArea(String.join("\n", current));
        Border ok = area.getBorder();
        area.addFocusListener(new FocusAdapter() {
            @Override public void focusLost(FocusEvent e) {
                List<String> lines = nonBlankLines(area.getText());
                List<Pattern> patterns = new ArrayList<>();
                for (String line : lines) {
                    try {
                        patterns.add(Pattern.compile(line));
                    } catch (PatternSyntaxException ex) {
                        area.setBorder(BorderFactory.createLineBorder(BAD, 2));
                        area.setToolTipText("Invalid regex: " + line);
                        return; // do not persist an invalid set
                    }
                }
                area.setBorder(ok);
                area.setToolTipText(null);
                store.set(r.key(), lines);
                r.onChange().accept(patterns);
            }
        });
        return labeledAbove(r.label(), new JScrollPane(area));
    }

    private static JComponent renderColor(SettingNode.ColorValue c, SettingsStore store) {
        int current = store.get(c.key()) instanceof Number n ? n.intValue() : c.initialRgba();
        c.onChange().accept(current);

        JButton button = new JButton("Pick…");
        button.setBackground(new Color(current, true));
        final int[] value = {current};
        button.addActionListener(ev -> {
            Color picked = JColorChooser.showDialog(button, c.label(), new Color(value[0], true));
            if (picked != null) {
                value[0] = picked.getRGB();
                button.setBackground(picked);
                store.set(c.key(), value[0]);
                c.onChange().accept(value[0]);
            }
        });
        return labeled(c.label(), button);
    }

    private static JComponent renderPlayerList(SettingNode.PlayerList p, SettingsStore store) {
        // No PlayerRegistry service exists yet — degrade to a plain UUID editor.
        List<String> current = asStringList(store.get(p.key()), List.of());
        p.onChange().accept(parseUuids(current));

        JTextArea area = textArea(String.join("\n", current));
        area.addFocusListener(new FocusAdapter() {
            @Override public void focusLost(FocusEvent e) {
                List<String> lines = nonBlankLines(area.getText());
                List<UUID> uuids = parseUuids(lines);
                store.set(p.key(), lines);
                p.onChange().accept(uuids);
            }
        });
        return labeledAbove(p.label() + " (UUIDs, one per line)", new JScrollPane(area));
    }

    // ------------------------------------------------------------------
    // helpers
    // ------------------------------------------------------------------

    private static List<Pattern> compile(List<String> lines) {
        List<Pattern> out = new ArrayList<>();
        for (String line : lines) {
            try {
                out.add(Pattern.compile(line));
            } catch (PatternSyntaxException e) {
                log.warn("Skipping invalid persisted regex '{}': {}", line, e.getMessage());
            }
        }
        return out;
    }

    private static List<UUID> parseUuids(List<String> lines) {
        List<UUID> out = new ArrayList<>();
        for (String line : lines) {
            try {
                out.add(UUID.fromString(line.trim()));
            } catch (IllegalArgumentException ignored) {
                // not a UUID — drop silently
            }
        }
        return out;
    }

    @SuppressWarnings("unchecked")
    private static List<String> asStringList(Object raw, List<String> fallback) {
        if (raw instanceof List<?> list) {
            List<String> out = new ArrayList<>();
            for (Object o : list) {
                if (o != null) out.add(o.toString());
            }
            return out;
        }
        return new ArrayList<>(fallback);
    }

    private static List<String> nonBlankLines(String text) {
        List<String> out = new ArrayList<>();
        for (String line : text.split("\n")) {
            if (!line.isBlank()) out.add(line.trim());
        }
        return out;
    }

    private static JPanel column() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(BG);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        return panel;
    }

    private static JComponent row(JComponent widget) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 2));
        panel.setBackground(BG);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(widget);
        return panel;
    }

    private static JComponent labeled(String label, JComponent widget) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 2));
        panel.setBackground(BG);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(label(label));
        panel.add(widget);
        return panel;
    }

    private static JComponent labeledAbove(String label, JComponent widget) {
        JPanel panel = new JPanel(new BorderLayout(2, 2));
        panel.setBackground(BG);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(label(label), BorderLayout.NORTH);
        panel.add(widget, BorderLayout.CENTER);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
        return panel;
    }

    private static JLabel label(String text) {
        JLabel jl = new JLabel(text);
        jl.setForeground(FG);
        return jl;
    }

    private static JTextArea textArea(String text) {
        JTextArea area = new JTextArea(text, 3, 20);
        area.setBackground(new Color(35, 35, 35));
        area.setForeground(FG);
        area.setCaretColor(FG);
        return area;
    }
}
