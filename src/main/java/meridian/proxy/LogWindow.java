package meridian.proxy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import meridian.proxy.module.ModuleManager;
import meridian.proxy.module.ModuleManager.ModuleEntry;

/**
 * Manages the proxy's log output: file logging, System.out/err tee, and optional Swing GUI.
 */
public final class LogWindow {
    private static JTextArea area;
    private static JFrame frame;
    private static FileOutputStream fileOut;
    private static volatile boolean guiEnabled = true;
    private static ModuleManager moduleManager;
    private static DefaultListModel<ModuleEntry> listModel;
    private static JList<ModuleEntry> moduleList;
    private static CardLayout cardLayout;
    private static JPanel mainContainer;
    private static JPanel settingsContainer;
    private static JLabel settingsTitle;
    private static JPanel settingsContent;

    private LogWindow() {}

    /**
     * Install log tee (file + optional GUI).
     *
     * @param showGui if false, runs in headless mode (no Swing window)
     */
    public static void install(boolean showGui) {
        guiEnabled = showGui;

        // File logging
        try {
            Path logPath = Paths.get("hytale-proxy.log").toAbsolutePath();
            fileOut = new FileOutputStream(logPath.toFile(), true);
        } catch (IOException e) {
            // Fallback: no file, only console
        }

        // GUI window
        if (showGui && !GraphicsEnvironment.isHeadless()) {
            try {
                if (SwingUtilities.isEventDispatchThread()) {
                    buildWindow();
                } else {
                    SwingUtilities.invokeAndWait(LogWindow::buildWindow);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Tee stdout/stderr
        System.setErr(new PrintStream(new TeeStream(System.err), true));
        System.setOut(new PrintStream(new TeeStream(System.out), true));

        // Shutdown hook for clean exit (Ctrl+C, SIGTERM, etc.)
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (fileOut != null) {
                try { fileOut.flush(); fileOut.close(); } catch (IOException ignored) {}
            }
        }, "LogWindow-shutdown"));
    }

    public static void setModuleManager(ModuleManager manager) {
        moduleManager = manager;
        updateModuleList();
    }

    public static void updateModuleList() {
        if (listModel == null || moduleManager == null) return;
        SwingUtilities.invokeLater(() -> {
            listModel.clear();
            for (ModuleEntry entry : moduleManager.getLoadedModules()) {
                listModel.addElement(entry);
            }
        });
    }



    private static void buildWindow() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        frame = new JFrame("Meridian Proxy — Management");
        frame.setSize(1200, 800);
        frame.setLocationByPlatform(true);

        // --- Log Panel ---
        area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        area.setBackground(new Color(18, 18, 18));
        area.setForeground(new Color(210, 210, 210));
        area.setMargin(new Insets(5, 5, 5, 5));

        JScrollPane logScroll = new JScrollPane(area,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        logScroll.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(40, 40, 40)), "System Log"));

        // --- Module Panel ---
        JPanel modulePanel = new JPanel(new BorderLayout());
        modulePanel.setPreferredSize(new Dimension(300, 0));
        modulePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(40, 40, 40)), "Modules"));
        modulePanel.setBackground(new Color(25, 25, 25));

        listModel = new DefaultListModel<>();
        moduleList = new JList<>(listModel);
        moduleList.setBackground(new Color(30, 30, 30));
        moduleList.setForeground(Color.WHITE);
        moduleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        moduleList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel l = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                l.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                return l;
            }
        });

        // Double-click to open settings
        moduleList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    openSettings(moduleList.getSelectedValue());
                }
            }
        });

        modulePanel.add(new JScrollPane(moduleList), BorderLayout.CENTER);

        // Toolbar for reordering
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);
        toolbar.setBackground(new Color(35, 35, 35));

        JButton btnUp = new JButton("▲ Up");
        JButton btnDown = new JButton("▼ Down");
        JButton btnSettings = new JButton("⚙ Settings");

        btnUp.addActionListener(e -> {
            int idx = moduleList.getSelectedIndex();
            if (idx != -1 && moduleManager != null) {
                moduleManager.moveUp(idx);
                updateModuleList();
                moduleList.setSelectedIndex(idx - 1);
            }
        });

        btnDown.addActionListener(e -> {
            int idx = moduleList.getSelectedIndex();
            if (idx != -1 && moduleManager != null) {
                moduleManager.moveDown(idx);
                updateModuleList();
                moduleList.setSelectedIndex(idx + 1);
            }
        });

        btnSettings.addActionListener(e -> openSettings(moduleList.getSelectedValue()));

        toolbar.add(btnUp);
        toolbar.add(btnDown);
        toolbar.addSeparator();
        toolbar.add(btnSettings);
        modulePanel.add(toolbar, BorderLayout.NORTH);

        // --- Main container with CardLayout ---
        cardLayout = new CardLayout();
        mainContainer = new JPanel(cardLayout);

        // Card 1: Console
        mainContainer.add(logScroll, "CONSOLE");

        // Card 2: Settings
        settingsContainer = new JPanel(new BorderLayout());
        settingsContainer.setBackground(new Color(25, 25, 25));
        
        JPanel settingsHeader = new JPanel(new BorderLayout());
        settingsHeader.setBackground(new Color(35, 35, 35));
        settingsHeader.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JButton btnBack = new JButton("← Back to Console");
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(e -> cardLayout.show(mainContainer, "CONSOLE"));
        
        settingsTitle = new JLabel("Module Settings");
        settingsTitle.setForeground(Color.WHITE);
        settingsTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));

        settingsHeader.add(btnBack, BorderLayout.WEST);
        settingsHeader.add(settingsTitle, BorderLayout.CENTER);

        settingsContent = new JPanel(new BorderLayout());
        settingsContent.setBackground(new Color(20, 20, 20));
        settingsContent.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        settingsContainer.add(settingsHeader, BorderLayout.NORTH);
        settingsContainer.add(settingsContent, BorderLayout.CENTER);

        mainContainer.add(settingsContainer, BorderLayout.CENTER);
        mainContainer.add(settingsContainer, "SETTINGS");

        // --- Main Layout ---
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, mainContainer, modulePanel);
        splitPane.setDividerLocation(850);
        splitPane.setDividerSize(5);
        splitPane.setResizeWeight(1.0);
        splitPane.setBorder(null);

        frame.add(splitPane);

        // Close window → terminate JVM
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                shutdown();
            }
        });

        frame.setVisible(true);
        updateModuleList();
    }

    private static void openSettings(ModuleEntry entry) {
        if (entry == null) return;
        if (entry.settingsPanel == null) {
            JOptionPane.showMessageDialog(frame, "This module has no settings.", entry.name, JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        settingsTitle.setText(" Settings: " + entry.name);
        settingsContent.removeAll();
        settingsContent.add(entry.settingsPanel, BorderLayout.NORTH);
        settingsContent.revalidate();
        settingsContent.repaint();

        cardLayout.show(mainContainer, "SETTINGS");
    }

    /**
     * Initiate a clean shutdown: close the window and exit the JVM.
     * Can be called from any thread (e.g. a module's UI action).
     */
    public static void shutdown() {
        if (frame != null) {
            frame.setVisible(false);
            frame.dispose();
        }
        System.exit(0);
    }

    private static final class TeeStream extends OutputStream {
        private final OutputStream orig;
        private final StringBuilder pending = new StringBuilder(256);

        TeeStream(OutputStream orig) { this.orig = orig; }

        @Override
        public synchronized void write(int b) throws IOException {
            orig.write(b);
            if (fileOut != null) fileOut.write(b);
            pending.append((char) b);
            if (b == '\n') flushLine();
        }

        @Override
        public synchronized void write(byte[] b, int off, int len) throws IOException {
            orig.write(b, off, len);
            if (fileOut != null) fileOut.write(b, off, len);
            for (int i = 0; i < len; i++) {
                char c = (char) (b[off + i] & 0xFF);
                pending.append(c);
                if (c == '\n') flushLine();
            }
        }

        @Override
        public synchronized void flush() throws IOException {
            orig.flush();
            if (fileOut != null) fileOut.flush();
            if (pending.length() > 0) flushLine();
        }

        private void flushLine() {
            final String chunk = pending.toString();
            pending.setLength(0);
            if (area == null) return;
            SwingUtilities.invokeLater(() -> {
                area.append(chunk);
                // Cap buffer at ~1MB to avoid memory blowup
                int max = 1_000_000;
                int overflow = area.getDocument().getLength() - max;
                if (overflow > 0) {
                    try { area.getDocument().remove(0, overflow); } catch (Exception ignored) {}
                }
                area.setCaretPosition(area.getDocument().getLength());
            });
        }
    }
}
