package meridian.internal;

import meridian.internal.auth.LauncherSessionMinter;
import meridian.internal.core.ProxyConfig;
import meridian.internal.core.LauncherBridge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Entry point for the Hytale MITM Proxy (QUIC). Performs run-mode dispatch and
 * owns the <em>current</em> {@link ConnectionScope}; the scope owns everything
 * connection-scoped (module runtime, QUIC listener, live connections) and its
 * own teardown. The static {@code connect/disconnect} facade lets the GUI drive
 * the lifecycle without knowing about {@link ConnectionScope}.
 */
public class ProxyServer {
    // IMPORTANT: install Swing log window + tee System.err/out BEFORE slf4j-simple
    // class-inits,
    // because SimpleLoggerConfiguration captures System.err's PrintStream ref at
    // class load.
    // We parse --no-gui here because the Logger field below initializes immediately
    // after this block.
    static {
        try {
            boolean showGui = true;
            String cmdLine = System.getProperty("sun.java.command", "");
            if (cmdLine.contains("--no-gui")) {
                showGui = false;
            }
            LogWindow.install(showGui);
            System.setProperty("org.slf4j.simpleLogger.showDateTime", "true");
            System.setProperty("org.slf4j.simpleLogger.dateTimeFormat", "HH:mm:ss.SSS");
            System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "info");
            System.setProperty("org.slf4j.simpleLogger.log.io.netty", "warn");
        } catch (Throwable ignored) {
        }
    }

    private static final Logger log = LoggerFactory.getLogger(ProxyServer.class);

    /** The active connection lifecycle, or null when disconnected. */
    private static final AtomicReference<ConnectionScope> current = new AtomicReference<>();

    public static void main(String[] args) throws Exception {
        ProxyConfig config = ProxyConfig.fromArgs(args);

        log.info("Meridian Proxy {} — releases: {}", Version.VERSION, Version.RELEASES_URL);

        if (config.standalone()) {
            // GUI standalone — the target server is unknown until Connect, so the
            // connection scope (and its per-server modules) is built in
            // connectStandalone() once the user picks a remote.
            log.info("Standalone mode — waiting for Connect from the GUI.");
            LogWindow.enterStandaloneMode(
                    ProxyConfig.findArg(args, "--remote"),
                    ProxyConfig.findArg(args, "--bind"));
            return;
        }

        // Launcher / CLI: the remote is known now, so build the scope and run it
        // (blocking) on this thread — the process lifetime is the one connection.
        ProxyConfig.printLauncherProgress();

        // Mode 3 (CLI): only the player session was supplied (--session-token) — derive the
        // two server-scope tokens via /game-session/child, the same hop standalone mode uses.
        // Also covers a launcher env that carries only the player token.
        if (config.clientToken() != null
                && (config.serverToken() == null || config.identityToken() == null)) {
            log.info("Server tokens not supplied — deriving via /game-session/child from player session");
            try {
                LauncherSessionMinter.ServerTokens server =
                        new LauncherSessionMinter().deriveServerTokens(config.clientToken());
                config = config.withServerTokens(server.sessionToken(), server.identityToken());
            } catch (Exception e) {
                log.error("Failed to derive server tokens from player session", e);
                throw e;
            }
        }

        log.info("Resolved configuration:");
        log.info("  Local Port:  {}", config.localPort());
        log.info("  Remote Host: {}", config.remoteHost());
        log.info("  Remote Port: {}", config.remotePort());

        if (config.autoWrap()) {
            LauncherBridge bridge = new LauncherBridge(config);
            bridge.launchAndWait();
        }

        ConnectionScope scope = new ConnectionScope(config, false);
        current.set(scope);
        try {
            scope.run(); // blocks until disconnect / process end
        } finally {
            current.compareAndSet(scope, null);
        }
    }

    /**
     * Called from the GUI Connect button (standalone mode). Derives the server-scope
     * tokens from the player session, builds a fresh {@link ConnectionScope}, and runs
     * it on a background thread. No-op if a scope is already active.
     *
     * @throws IllegalStateException if the token is missing or the /child hop fails.
     */
    public static synchronized void connectStandalone(String remoteHost, int remotePort, int localPort,
                                                      String playerSessionToken) {
        ConnectionScope existing = current.get();
        if (existing != null && existing.state() != ConnectionScope.State.DISCONNECTED) {
            log.warn("connectStandalone: already connected; disconnect first.");
            return;
        }

        LauncherSessionMinter.SessionBundle bundle;
        try {
            bundle = new LauncherSessionMinter().mintFromPlayerSession(playerSessionToken);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to derive session: " + e.getMessage(), e);
        }
        ProxyConfig cfg = ProxyConfig.forStandaloneConnect(remoteHost, remotePort, localPort,
                bundle.playerSessionToken(),
                bundle.serverSessionToken(),
                bundle.serverIdentityToken());

        log.info("Standalone Connect: localhost:{} -> {}:{} (profile={})",
                cfg.localPort(), cfg.remoteHost(), cfg.remotePort(), bundle.profileUuid());

        ConnectionScope scope = new ConnectionScope(cfg, true);
        current.set(scope);
        Thread t = new Thread(() -> {
            try {
                scope.run();
            } catch (Exception e) {
                log.error("Standalone proxy thread terminated", e);
            } finally {
                current.compareAndSet(scope, null);
            }
        }, "MeridianProxy-Standalone");
        t.setDaemon(true);
        t.start();
    }

    /** Requests a clean disconnect of the active connection (UI Disconnect button). */
    public static synchronized void disconnectStandalone() {
        ConnectionScope scope = current.get();
        if (scope != null) {
            log.info("Disconnect requested via UI.");
            scope.requestDisconnect(true);
        }
    }

    public static boolean isStandaloneActive() {
        ConnectionScope scope = current.get();
        return scope != null && scope.isActive();
    }
}
