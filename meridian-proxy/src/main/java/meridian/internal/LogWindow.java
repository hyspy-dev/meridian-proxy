package meridian.internal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import meridian.internal.auth.GameProcessSnooper;
import meridian.internal.module.ModuleManager;
import meridian.internal.module.ModuleManager.ModuleEntry;
import meridian.internal.module.ModuleManager.SkippedModule;

/**
 * Manages the proxy's log output: file logging, System.out/err tee, and optional Swing GUI.
 */
public final class LogWindow {
    /** Hard cap on lines kept in the log view — an unbounded (or megabyte-sized)
     *  document makes the JTextArea's layout/repaint crawl on every append, so
     *  under a flood of log lines the whole window appears to hang. */
    private static final int MAX_LINES = 1000;

    private static JTextArea area;
    private static JFrame frame;
    private static FileOutputStream fileOut;
    private static volatile boolean guiEnabled = true;
    private static ModuleManager moduleManager;
    private static DefaultListModel<Object> listModel;
    private static JList<Object> moduleList;
    private static CardLayout cardLayout;
    private static JPanel mainContainer;
    private static JPanel settingsContainer;
    private static JLabel settingsTitle;
    private static JPanel settingsContent;

    private static JPanel northCards;
    private static CardLayout northLayout;
    private static JPanel authBar;
    private static JLabel gameStatusDot;
    private static JLabel gameStatusText;
    private static JButton gameRefreshBtn;
    private static JTextField remoteField;
    private static JTextField localPortField;
    private static JTextField sessionTokenField;
    private static JButton connectButton;
    private static JLabel connectedLabel;
    private static JButton disconnectButton;
    private static volatile boolean standaloneMode = false;

    /** Card names for the north area: the Connect form vs. the Connected status bar. */
    private static final String CARD_CONNECT = "CONNECT";
    private static final String CARD_CONNECTED = "CONNECTED";

    private LogWindow() {}

    /**
     * Install log tee (file + optional GUI).
     *
     * @param showGui if false, runs in headless mode (no Swing window)
     */
    public static void install(boolean showGui) {
        guiEnabled = showGui;

        // File logging: <jar-dir>/logs/meridian.log, rotated on each launch.
        try {
            Path logDir = meridian.internal.core.ProxyConfig.jarDir().resolve("logs");
            Files.createDirectories(logDir);
            Path logFile = logDir.resolve("meridian.log");
            rotateLogs(logFile);
            fileOut = new FileOutputStream(logFile.toFile(), false);
        } catch (Exception e) {
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

    /** Rotates {@code meridian.log} → {@code .1} → {@code .2} (keeps two history files). */
    private static void rotateLogs(Path log) {
        try {
            Path l1 = log.resolveSibling("meridian.log.1");
            Path l2 = log.resolveSibling("meridian.log.2");
            if (Files.exists(l1)) {
                Files.move(l1, l2, StandardCopyOption.REPLACE_EXISTING);
            }
            if (Files.exists(log)) {
                Files.move(log, l1, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception ignored) {
            // best-effort rotation
        }
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
            // Incompatible modules appear after the loaded ones, flagged red.
            for (SkippedModule skipped : moduleManager.getSkippedModules()) {
                listModel.addElement(skipped);
            }
        });
    }



    private static void buildWindow() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        frame = new JFrame("Meridian Proxy " + Version.VERSION + " — Management");
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
                if (value instanceof SkippedModule s) {
                    l.setText("⚠ " + s.name() + " (v" + s.version() + ") — incompatible");
                    if (!isSelected) l.setForeground(new Color(224, 96, 96));
                }
                return l;
            }
        });

        // Double-click to open settings
        moduleList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    openModuleView(moduleList.getSelectedValue());
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
            if (idx != -1 && moduleManager != null && moduleList.getSelectedValue() instanceof ModuleEntry) {
                moduleManager.moveUp(idx);
                updateModuleList();
                moduleList.setSelectedIndex(idx - 1);
            }
        });

        btnDown.addActionListener(e -> {
            int idx = moduleList.getSelectedIndex();
            if (idx != -1 && moduleManager != null && moduleList.getSelectedValue() instanceof ModuleEntry) {
                moduleManager.moveDown(idx);
                updateModuleList();
                moduleList.setSelectedIndex(idx + 1);
            }
        });

        btnSettings.addActionListener(e -> openModuleView(moduleList.getSelectedValue()));

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

        frame.setLayout(new BorderLayout());
        authBar = buildAuthBar();
        JPanel connectedBar = buildConnectedBar();
        northLayout = new CardLayout();
        northCards = new JPanel(northLayout);
        northCards.add(authBar, CARD_CONNECT);
        northCards.add(connectedBar, CARD_CONNECTED);
        northCards.setVisible(false); // hidden until enterStandaloneMode() is called
        frame.add(northCards, BorderLayout.NORTH);
        frame.add(splitPane, BorderLayout.CENTER);
        frame.add(buildStatusBar(), BorderLayout.SOUTH);

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

    private static JPanel buildAuthBar() {
        JPanel bar = new JPanel();
        bar.setLayout(new BoxLayout(bar, BoxLayout.Y_AXIS));
        bar.setBackground(new Color(32, 32, 32));
        bar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(50, 50, 50)));

        javax.swing.event.DocumentListener docListener = new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { updateConnectEnabled(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { updateConnectEnabled(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { updateConnectEnabled(); }
        };

        // --- Row 1: game status | remote | local port | connect ---
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 6));
        row1.setOpaque(false);

        row1.add(buildGameStatusCell());
        row1.add(verticalSeparator());

        JLabel remoteLabel = new JLabel("Remote:");
        remoteLabel.setForeground(new Color(200, 200, 200));
        remoteLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        row1.add(remoteLabel);

        remoteField = new JTextField(20);
        remoteField.setToolTipText("Target server, e.g. 1.2.3.4:5520 or play.example.com:5520");
        remoteField.getDocument().addDocumentListener(docListener);
        row1.add(remoteField);

        JLabel localLabel = new JLabel("Local port:");
        localLabel.setForeground(new Color(200, 200, 200));
        localLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        row1.add(localLabel);

        localPortField = new JTextField(String.valueOf(meridian.internal.core.ProxyConfig.STANDALONE_LOCAL_PORT), 5);
        localPortField.setToolTipText("Local bind port; default 5520 matches Hytale's expected server port");
        localPortField.getDocument().addDocumentListener(docListener);
        row1.add(localPortField);

        connectButton = new JButton("Connect");
        connectButton.setFocusPainted(false);
        connectButton.setMargin(new Insets(2, 14, 2, 14));
        connectButton.addActionListener(e -> performConnect());
        connectButton.setEnabled(false);
        row1.add(connectButton);

        // --- Row 2: session token (auto-filled by snoop, or pasted manually) ---
        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 2));
        row2.setOpaque(false);

        JLabel tokenLabel = new JLabel("Session token:");
        tokenLabel.setForeground(new Color(200, 200, 200));
        tokenLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        row2.add(tokenLabel);

        sessionTokenField = new JTextField(52);
        sessionTokenField.setToolTipText("Auto-filled from the running Hytale game; or paste a player session token manually");
        sessionTokenField.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 11));
        sessionTokenField.getDocument().addDocumentListener(docListener);
        row2.add(sessionTokenField);

        bar.add(row1);
        bar.add(row2);

        refreshGameStatus();
        return bar;
    }

    private static JLabel verticalSeparator() {
        JLabel sep = new JLabel("│");
        sep.setForeground(new Color(60, 60, 60));
        return sep;
    }

    private static void performConnect() {
        String text = remoteField.getText().trim();
        String host;
        int remotePort;
        int localPort;
        try {
            int idx = text.lastIndexOf(':');
            if (idx <= 0 || idx >= text.length() - 1) throw new IllegalArgumentException("expected host:port");
            host = text.substring(0, idx);
            remotePort = Integer.parseInt(text.substring(idx + 1));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Bad remote address. Use host:port.", "Connect", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            localPort = Integer.parseInt(localPortField.getText().trim());
            if (localPort < 1 || localPort > 65535) throw new IllegalArgumentException();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Bad local port. Use 1-65535.", "Connect", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String sessionToken = sessionTokenField.getText().trim();
        if (sessionToken.isEmpty()) {
            JOptionPane.showMessageDialog(frame,
                    "No session token. Start the Hytale game and click Refresh, or paste a player session token.",
                    "Connect", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Remember the remote for next launch (tokens are never persisted).
        StandaloneState state = StandaloneState.load();
        state.lastHostPort = host + ":" + remotePort;
        state.save();

        connectButton.setEnabled(false);
        connectButton.setText("Deriving session…");
        Thread.startVirtualThread(() -> {
            try {
                meridian.internal.ProxyServer.connectStandalone(host, remotePort, localPort, sessionToken);
            } catch (Throwable ex) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Connect failed", JOptionPane.ERROR_MESSAGE);
                    connectButton.setText("Connect");
                    updateConnectEnabled();
                });
            }
        });
    }

    /** The "Connected to X — [Disconnect]" bar, shown in place of the Connect form while a session is live. */
    private static JPanel buildConnectedBar() {
        JPanel bar = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 8));
        bar.setBackground(new Color(32, 32, 32));
        bar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(50, 50, 50)));

        JLabel dot = new JLabel("●");
        dot.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        dot.setForeground(new Color(111, 207, 151));
        bar.add(dot);

        connectedLabel = new JLabel("Connected");
        connectedLabel.setForeground(new Color(210, 210, 210));
        connectedLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        bar.add(connectedLabel);

        bar.add(verticalSeparator());

        disconnectButton = new JButton("Disconnect");
        disconnectButton.setFocusPainted(false);
        disconnectButton.setMargin(new Insets(2, 14, 2, 14));
        disconnectButton.setToolTipText("Close the session and unload its modules; returns to the Connect form");
        disconnectButton.addActionListener(e -> performDisconnect());
        bar.add(disconnectButton);

        return bar;
    }

    private static void performDisconnect() {
        if (disconnectButton != null) {
            disconnectButton.setEnabled(false);
            disconnectButton.setText("Disconnecting…");
        }
        // requestDisconnect is non-blocking, but run it off the EDT to be safe; the
        // UI flips back to the Connect form when teardown fires onProxyStopped().
        Thread.startVirtualThread(() -> {
            try {
                meridian.internal.ProxyServer.disconnectStandalone();
            } catch (Throwable ex) {
                SwingUtilities.invokeLater(() -> {
                    if (disconnectButton != null) {
                        disconnectButton.setText("Disconnect");
                        disconnectButton.setEnabled(true);
                    }
                });
            }
        });
    }

    /** Called from ConnectionScope when bind fails (port in use, permission denied, etc.) */
    public static void onProxyFailed(String message) {
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(frame, message, "Proxy failed to start", JOptionPane.ERROR_MESSAGE);
            if (standaloneMode) showConnectCard();
        });
    }

    /** Called from ConnectionScope once the listener is bound — show the Connected bar, log target. */
    public static void onProxyStarted(String remoteHost, int remotePort, int localPort) {
        SwingUtilities.invokeLater(() -> {
            if (frame != null) {
                frame.setTitle("Meridian Proxy " + Version.VERSION + " — " + remoteHost + ":" + remotePort
                        + " (listening on localhost:" + localPort + ")");
            }
            if (standaloneMode) {
                if (connectedLabel != null) {
                    connectedLabel.setText("Connected to " + remoteHost + ":" + remotePort
                            + "   (listening on localhost:" + localPort + ")");
                }
                if (disconnectButton != null) {
                    disconnectButton.setText("Disconnect");
                    disconnectButton.setEnabled(true);
                }
                showCard(CARD_CONNECTED);
            }
        });
    }

    /** Called from ConnectionScope teardown — return to the Connect form in standalone mode. */
    public static void onProxyStopped() {
        SwingUtilities.invokeLater(() -> {
            if (frame != null) {
                frame.setTitle("Meridian Proxy " + Version.VERSION + " — Management");
            }
            if (standaloneMode) showConnectCard();
        });
    }

    /** Shows the Connect form card and resets its Connect button to a ready state. */
    private static void showConnectCard() {
        showCard(CARD_CONNECT);
        if (connectButton != null) {
            connectButton.setText("Connect");
            updateConnectEnabled();
        }
    }

    private static void showCard(String card) {
        if (northCards != null && northLayout != null) {
            northCards.setVisible(true);
            northLayout.show(northCards, card);
        }
    }

    /**
     * Called by ProxyServer.main() when standalone mode is detected. Optional CLI
     * overrides pre-fill the connection fields; both may be null.
     *
     * @param remoteHint value of {@code --remote} (host:port), or null
     * @param bindHint   value of {@code --bind} (host:port or bare port), or null
     */
    public static void enterStandaloneMode(String remoteHint, String bindHint) {
        standaloneMode = true;
        SwingUtilities.invokeLater(() -> {
            showCard(CARD_CONNECT);
            if (remoteHint != null && !remoteHint.isBlank() && remoteField != null) {
                remoteField.setText(remoteHint.trim());
            } else if (remoteField != null && remoteField.getText().isBlank()) {
                // No --remote override — pre-fill from the last session.
                String last = StandaloneState.load().lastHostPort;
                if (last != null && !last.isBlank()) {
                    remoteField.setText(last.trim());
                }
            }
            if (bindHint != null && !bindHint.isBlank() && localPortField != null) {
                String b = bindHint.trim();
                int colon = b.lastIndexOf(':');
                String port = colon >= 0 ? b.substring(colon + 1) : b;
                if (!port.isBlank()) localPortField.setText(port);
            }
            updateConnectEnabled();
        });
    }

    private static void updateConnectEnabled() {
        if (connectButton == null || remoteField == null || sessionTokenField == null) return;
        boolean hostFilled = remoteField.getText().trim().contains(":");
        boolean tokenPresent = !sessionTokenField.getText().trim().isEmpty();
        connectButton.setEnabled(tokenPresent && hostFilled);
        if (!tokenPresent) {
            connectButton.setToolTipText("Start the Hytale game and click Refresh, or paste a session token");
        } else if (!hostFilled) {
            connectButton.setToolTipText("Enter remote host:port");
        } else {
            connectButton.setToolTipText(null);
        }
    }

    private static JPanel buildGameStatusCell() {
        JPanel cell = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        cell.setOpaque(false);

        gameStatusDot = new JLabel("●");
        gameStatusDot.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        gameStatusDot.setForeground(new Color(120, 120, 120));

        JLabel title = new JLabel("Hytale game:");
        title.setForeground(new Color(200, 200, 200));
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));

        gameStatusText = new JLabel("checking…");
        gameStatusText.setForeground(new Color(160, 160, 160));
        gameStatusText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        gameRefreshBtn = new JButton("Refresh");
        gameRefreshBtn.setFocusPainted(false);
        gameRefreshBtn.setMargin(new Insets(2, 8, 2, 8));
        gameRefreshBtn.setToolTipText("Re-scan for a running Hytale game process");
        gameRefreshBtn.addActionListener(e -> refreshGameStatus());

        cell.add(gameStatusDot);
        cell.add(title);
        cell.add(gameStatusText);
        cell.add(gameRefreshBtn);
        return cell;
    }

    /** Scans for a running Hytale game process and reflects the result on the auth bar. */
    public static void refreshGameStatus() {
        if (gameStatusDot == null) return;
        SwingUtilities.invokeLater(() -> {
            gameStatusDot.setForeground(new Color(120, 120, 120));
            gameStatusText.setText("scanning…");
        });
        Thread.startVirtualThread(() -> {
            String text;
            Color dot;
            String foundToken = null;
            try {
                var creds = GameProcessSnooper.findRunningGameSession();
                if (creds.isPresent()) {
                    String profile = creds.get().profileUuid() != null
                            ? creds.get().profileUuid().toString().substring(0, 8)
                            : "session detected";
                    text = "running — " + profile;
                    dot = new Color(111, 207, 151);
                    foundToken = creds.get().sessionToken();
                } else {
                    text = "not running — paste a session token below, or open the launcher and Play";
                    dot = new Color(195, 25, 76);
                }
            } catch (UnsupportedOperationException e) {
                text = e.getMessage();
                dot = new Color(220, 180, 40);
            } catch (Exception e) {
                text = "scan failed: " + e.getMessage();
                dot = new Color(195, 25, 76);
            }
            String tt = text;
            Color td = dot;
            String tokenToFill = foundToken;
            SwingUtilities.invokeLater(() -> {
                gameStatusDot.setForeground(td);
                gameStatusText.setText(tt);
                // Auto-fill the token field when the snoop succeeds; leave a
                // manually-typed token untouched when it doesn't.
                if (tokenToFill != null && sessionTokenField != null) {
                    sessionTokenField.setText(tokenToFill);
                }
                updateConnectEnabled();
            });
        });
    }

    private static JPanel buildStatusBar() {
        JPanel bar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 3));
        bar.setBackground(new Color(28, 28, 28));
        bar.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(40, 40, 40)));

        JLabel versionLabel = new JLabel("Meridian Proxy " + Version.VERSION);
        versionLabel.setForeground(new Color(160, 160, 160));
        versionLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 11));

        bar.add(versionLabel);
        bar.add(separatorDot());
        bar.add(linkLabel("Releases ↗", Version.RELEASES_URL));
        bar.add(separatorDot());
        bar.add(linkLabel("Discord ↗", Version.DISCORD_URL));
        return bar;
    }

    private static JLabel separatorDot() {
        JLabel sep = new JLabel("•");
        sep.setForeground(new Color(80, 80, 80));
        return sep;
    }

    /** A clickable, browser-opening status-bar link. */
    private static JLabel linkLabel(String text, String url) {
        JLabel link = new JLabel("<html><u>" + text + "</u></html>");
        link.setForeground(new Color(100, 160, 220));
        link.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 11));
        link.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        link.setToolTipText(url);
        link.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (Desktop.isDesktopSupported()
                            && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                        Desktop.getDesktop().browse(new URI(url));
                    }
                } catch (Exception ignored) {
                }
            }
        });
        return link;
    }

    /** Routes a module-list selection to its settings page or its incompatible page. */
    private static void openModuleView(Object value) {
        if (value instanceof ModuleEntry e) {
            openSettings(e);
        } else if (value instanceof SkippedModule s) {
            openIncompatible(s);
        }
    }

    /** Shows why an incompatible module did not load, with its update link. */
    private static void openIncompatible(SkippedModule s) {
        settingsTitle.setText(" Incompatible: " + s.name());
        settingsContent.removeAll();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(20, 20, 20));

        JLabel heading = new JLabel("This module did not load.");
        heading.setForeground(new Color(224, 96, 96));
        heading.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        heading.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel reason = new JLabel("<html>" + s.version() + " &mdash; " + s.reason() + "</html>");
        reason.setForeground(new Color(200, 200, 200));
        reason.setAlignmentX(Component.LEFT_ALIGNMENT);
        reason.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));

        panel.add(heading);
        panel.add(reason);

        if (s.updateUrl() != null && !s.updateUrl().isBlank()) {
            JLabel link = new JLabel("<html><u>Get an updated build &#x2197;</u></html>");
            link.setForeground(new Color(100, 160, 220));
            link.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            link.setToolTipText(s.updateUrl());
            link.setAlignmentX(Component.LEFT_ALIGNMENT);
            link.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        if (Desktop.isDesktopSupported()
                                && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                            Desktop.getDesktop().browse(new URI(s.updateUrl()));
                        }
                    } catch (Exception ignored) {
                    }
                }
            });
            panel.add(link);
        } else {
            JLabel noLink = new JLabel("The module author did not provide an update link.");
            noLink.setForeground(new Color(140, 140, 140));
            noLink.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.add(noLink);
        }

        settingsContent.add(panel, BorderLayout.NORTH);
        settingsContent.revalidate();
        settingsContent.repaint();
        cardLayout.show(mainContainer, "SETTINGS");
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
                // Keep only the most recent MAX_LINES lines: drop everything up
                // to the end of the oldest line(s) that overflow the cap. A
                // line-bounded document keeps repaint cheap under a log flood.
                int excess = area.getLineCount() - MAX_LINES;
                if (excess > 0) {
                    try {
                        int removeTo = area.getLineEndOffset(excess - 1);
                        area.getDocument().remove(0, removeTo);
                    } catch (Exception ignored) {}
                }
                area.setCaretPosition(area.getDocument().getLength());
            });
        }
    }
}
