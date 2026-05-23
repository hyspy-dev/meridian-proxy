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
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Desktop;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.IntConsumer;
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

    /**
     * @param updateUrl The module's {@code updateUrl} from {@code module.json};
     *                  rendered as a clickable footer link. {@code null} or blank
     *                  to omit.
     */
    public static JPanel render(SettingsSpec spec, SettingsStore store, String updateUrl) {
        JPanel root = column();
        for (SettingNode node : spec.nodes()) {
            root.add(renderNode(node, store));
        }
        if (updateUrl != null && !updateUrl.isBlank()) {
            root.add(Box.createVerticalStrut(8));
            root.add(renderUpdateLink(updateUrl));
        }
        return root;
    }

    /** Back-compat overload — no footer link. */
    public static JPanel render(SettingsSpec spec, SettingsStore store) {
        return render(spec, store, null);
    }

    /**
     * Wraps a raw module panel into our standard column and appends the update
     * link if any. Used by the deprecated {@code registerSettings(JPanel)}
     * path so even legacy modules get the link rendered.
     */
    public static JPanel wrapWithUpdateLink(JPanel inner, String updateUrl) {
        if (updateUrl == null || updateUrl.isBlank()) {
            return inner;
        }
        JPanel wrapper = column();
        inner.setAlignmentX(Component.LEFT_ALIGNMENT);
        wrapper.add(inner);
        wrapper.add(Box.createVerticalStrut(8));
        wrapper.add(renderUpdateLink(updateUrl));
        return wrapper;
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
            case SettingNode.LiveList l -> renderLiveList(l);
            case SettingNode.Button b -> renderButton(b);
        };
    }

    // ------------------------------------------------------------------

    private static JComponent renderSection(SettingNode.Section section, SettingsStore store) {
        JPanel panel = column();
        TitledBorder line = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(70, 70, 70)), section.name());
        line.setTitleColor(FG);
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
        // A binding's pre-render set() wins over the persisted value — that's
        // how a module can prime the field before the spec is registered.
        String initial = t.initial();
        if (store.get(t.key()) instanceof String s) initial = s;
        if (t.binding() != null && t.binding().get() != null) initial = t.binding().get();
        t.onChange().accept(initial);
        if (t.binding() != null) t.binding().__record(initial);

        JTextField field = new JTextField(initial, 16);
        Runnable commit = () -> {
            String value = field.getText();
            store.set(t.key(), value);
            t.onChange().accept(value);
            if (t.binding() != null) t.binding().__record(value);
        };
        field.addFocusListener(new FocusAdapter() {
            @Override public void focusLost(FocusEvent e) {
                commit.run();
            }
        });
        if (t.binding() != null) {
            // The setter must touch the JTextField only on the EDT — hop if
            // a caller invokes binding.set() from a scheduler thread or a
            // SelectionBus listener.
            t.binding().__wireUiSetter(value -> {
                Runnable apply = () -> {
                    if (!java.util.Objects.equals(field.getText(), value)) {
                        field.setText(value);
                    }
                    commit.run();
                };
                if (javax.swing.SwingUtilities.isEventDispatchThread()) {
                    apply.run();
                } else {
                    javax.swing.SwingUtilities.invokeLater(apply);
                }
            });
        }
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

    /** Empty-border padding around every {@link SettingNode.Button} — adds the visual gap between stacked buttons. */
    private static final int BUTTON_MARGIN_PX = 3;
    /** Inset between the button's frame and its label — gives the click area some breathing room. */
    private static final int BUTTON_PADDING_PX = 4;

    private static JComponent renderButton(SettingNode.Button b) {
        JButton button = new JButton(b.label());
        // Same dark-LAF treatment used by interaction-test's hand-rolled
        // buttons — Swing LAFs ignore setBackground unless content-fill is off.
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBackground(new Color(55, 55, 60));
        button.setForeground(FG);
        button.setFocusPainted(false);
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
        // Outer empty border = visible margin between stacked buttons; inner
        // line+padding pair gives the button itself a touch of interior space.
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(BUTTON_MARGIN_PX, 0, BUTTON_MARGIN_PX, 0),
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(90, 90, 95)),
                        BorderFactory.createEmptyBorder(BUTTON_PADDING_PX, BUTTON_PADDING_PX,
                                BUTTON_PADDING_PX, BUTTON_PADDING_PX))));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> {
            try {
                b.onClick().run();
            } catch (Throwable t) {
                log.warn("Settings button '{}' threw", b.label(), t);
            }
        });
        return button;
    }

    private static JComponent renderUpdateLink(String url) {
        // GitHub-style underlined hyperlink, hand-cursor, opens the system
        // browser. Falls back to copying-to-clipboard isn't worth it: every
        // OS we ship on has Desktop browse() support.
        JLabel link = new JLabel("<html><a href=\"\">" + escapeHtml(url) + "</a></html>");
        link.setForeground(new Color(120, 170, 255));
        link.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        link.setAlignmentX(Component.LEFT_ALIGNMENT);
        link.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        link.addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) {
                try {
                    if (Desktop.isDesktopSupported()
                            && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                        Desktop.getDesktop().browse(URI.create(url));
                    }
                } catch (Exception ex) {
                    log.warn("Failed to open update URL {}: {}", url, ex.toString());
                }
            }
        });
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(BG);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(50, 50, 50)));
        JLabel caption = label("Updates:");
        caption.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 6));
        panel.add(caption, BorderLayout.WEST);
        panel.add(link, BorderLayout.CENTER);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 28));
        return panel;
    }

    private static String escapeHtml(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }

    /** Poll cadence for {@link SettingNode.LiveList} — twice a second. */
    private static final int LIVE_LIST_POLL_MS = 500;
    /** Visible height of a live list before it scrolls. */
    private static final int LIVE_LIST_HEIGHT_PX = 220;

    private static JComponent renderLiveList(SettingNode.LiveList l) {
        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> list = new JList<>(model);
        list.setBackground(new Color(35, 35, 35));
        list.setForeground(FG);
        list.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectionBackground(new Color(55, 90, 140));
        list.setSelectionForeground(FG);

        IntConsumer onClick = l.onRowClick();
        if (onClick != null) {
            list.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            list.addMouseListener(new MouseAdapter() {
                @Override public void mouseClicked(MouseEvent e) {
                    int idx = list.locationToIndex(e.getPoint());
                    // locationToIndex returns the closest row even if the click
                    // landed below the last one — verify the click was inside
                    // an actual row's bounds before dispatching.
                    if (idx < 0) return;
                    java.awt.Rectangle bounds = list.getCellBounds(idx, idx);
                    if (bounds == null || !bounds.contains(e.getPoint())) return;
                    onClick.accept(idx);
                }
            });
        }

        // Apply the snapshot diff-style so the JList doesn't drop the user's
        // current selection on every 500ms refresh. setListData would replace
        // the entire model and clear the selection.
        Runnable refresh = () -> {
            List<String> rows = l.source().get();
            if (rows == null) rows = List.of();
            int prev = model.size();
            for (int i = 0; i < rows.size(); i++) {
                String row = rows.get(i);
                if (i < prev) {
                    if (!row.equals(model.get(i))) model.set(i, row);
                } else {
                    model.addElement(row);
                }
            }
            // Trim any trailing rows that the new snapshot dropped.
            for (int i = prev - 1; i >= rows.size(); i--) {
                model.remove(i);
            }
        };
        refresh.run();

        Timer timer = new Timer(LIVE_LIST_POLL_MS, e -> refresh.run());
        timer.setRepeats(true);
        // Tie the timer to the panel being on screen: ticks while shown,
        // stops when the settings drawer is closed or the module unloads.
        list.addAncestorListener(new AncestorListener() {
            @Override public void ancestorAdded(AncestorEvent e) { timer.start(); }
            @Override public void ancestorRemoved(AncestorEvent e) { timer.stop(); }
            @Override public void ancestorMoved(AncestorEvent e) {}
        });

        JScrollPane scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(0, LIVE_LIST_HEIGHT_PX));
        JPanel panel = new JPanel(new BorderLayout(2, 2));
        panel.setBackground(BG);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(label(l.label()), BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, LIVE_LIST_HEIGHT_PX + 20));
        return panel;
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
