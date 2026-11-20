package meridian.internal;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.ClientAuth;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.handler.ssl.util.SelfSignedCertificate;
import io.netty.incubator.codec.quic.QuicChannel;
import io.netty.incubator.codec.quic.QuicServerCodecBuilder;
import io.netty.incubator.codec.quic.QuicSslContext;
import io.netty.incubator.codec.quic.QuicSslContextBuilder;
import meridian.api.event.EventBus;
import meridian.internal.core.ProxyConfig;
import meridian.internal.core.QuicConfig;
import meridian.internal.module.HandlerRegistry;
import meridian.internal.module.ModuleManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Owns the lifecycle of <b>one</b> proxy connection: its module runtime, the QUIC
 * listener + event-loop group, and every live client connection through it. A
 * fresh scope is built for each Connect and fully torn down on Disconnect, so one
 * process can connect → disconnect → connect again (to the same or a different
 * server) with all connection-scoped state unloaded in between.
 *
 * <p>See {@code docs/private/connection-lifecycle.md} for the full design.
 *
 * <h2>State machine</h2>
 * <pre>
 *   DISCONNECTED --connect()--> CONNECTING --bind ok--> CONNECTED
 *        ^                           |                       |
 *        |          bind/setup fails |   requestDisconnect() | (user / client drop / server drop)
 *        +------- DISCONNECTING <-----+-----------------------+
 * </pre>
 * All transitions are CAS-guarded, which makes connect/disconnect idempotent:
 * a second disconnect (or a disconnect after the peer already dropped) is a no-op.
 */
public final class ConnectionScope implements FrontendScope {
    private static final Logger log = LoggerFactory.getLogger(ConnectionScope.class);

    public enum State { DISCONNECTED, CONNECTING, CONNECTED, DISCONNECTING }

    private final ProxyConfig config;
    /** True for the standalone GUI (reconnectable, surfaces failures in the UI);
     *  false for launcher/CLI where the process lifetime is the one connection. */
    private final boolean guiLifecycle;

    private final AtomicReference<State> state = new AtomicReference<>(State.DISCONNECTED);
    private final Set<QuicChannel> liveClients = ConcurrentHashMap.newKeySet();

    /** Backend target for the <em>next</em> client connection — starts at the config
     *  remote and is repointed by {@link #beginRedirect} on a server referral. */
    private volatile String currentRemoteHost;
    private volatile int currentRemotePort;
    /** True between intercepting a referral and the client's reconnect through the proxy;
     *  suppresses the normal teardown-on-drop so the listener survives the reconnect. */
    private volatile boolean redirectPending;
    /** Safety net: if the referred client never reconnects, tear down after this. */
    private static final int REDIRECT_TIMEOUT_SECONDS = 20;

    private volatile ModuleManager moduleManager;
    /** The channel whose closing ends the connection: the game's listener, the bot's QUIC connection. */
    private volatile Channel listener;
    private final Front front;
    private final boolean windowed;
    private final java.util.concurrent.CompletableFuture<ConnectionScope> started =
            new java.util.concurrent.CompletableFuture<>();

    /** The game's connection: a local port the game connects to, shown in the window. */
    public ConnectionScope(ProxyConfig config, boolean guiLifecycle) {
        this(config, guiLifecycle, new GameFront(config), true);
    }

    /**
     * A connection with its own client side: the game's ({@link GameFront}) or none - the proxy
     * playing ({@link HeadlessConnection}). {@code windowed}: the window shows it - its modules in
     * the panel, its Connected bar; a bot a script started over the command channel is not.
     */
    ConnectionScope(ProxyConfig config, boolean guiLifecycle, Front front, boolean windowed) {
        this.config = config;
        this.guiLifecycle = guiLifecycle;
        this.front = front;
        this.windowed = windowed;
        this.currentRemoteHost = config.remoteHost();
        this.currentRemotePort = config.remotePort();
    }

    /** Completes once the client side is up - with the scope - or with why it failed. */
    public java.util.concurrent.CompletableFuture<ConnectionScope> started() {
        return started;
    }

    /** The client side. */
    Front front() {
        return front;
    }

    /** The client side when the proxy plays it (no game); {@code null} for the game's. */
    public HeadlessConnection headless() {
        return front instanceof HeadlessConnection h ? h : null;
    }

    /** The server the next client connection goes to (a referral moves it). */
    String currentRemoteHost() {
        return currentRemoteHost;
    }

    int currentRemotePort() {
        return currentRemotePort;
    }

    public State state() { return state.get(); }
    public boolean isActive() { return state.get() == State.CONNECTED; }

    /** The module runtime for this connection — used by the pipeline to source handlers. */
    public ModuleManager moduleManager() { return moduleManager; }

    // ------------------------------------------------------------------
    // Lifecycle
    // ------------------------------------------------------------------

    /**
     * Blocking. Builds the per-connection module runtime, binds the QUIC listener,
     * and blocks until the listener closes (disconnect from any origin). The
     * {@code finally} always runs the full {@link #teardown()} on this (non-event-loop)
     * thread, so blocking work — group shutdown, module {@code onDisable} — is safe.
     *
     * @throws Exception on a setup/bind failure in non-GUI (launcher/CLI) mode, so
     *                   the caller can surface it; in GUI mode the failure is routed
     *                   to {@link LogWindow#onProxyFailed} instead.
     */
    public void run() throws Exception {
        if (!state.compareAndSet(State.DISCONNECTED, State.CONNECTING)) {
            log.warn("connect ignored — scope already {}", state.get());
            return;
        }
        log.info("Connecting to {}:{} {}", config.remoteHost(), config.remotePort(), front.how());

        Exception failure = null;
        try {
            // 1. Fresh module runtime for this server's module set - whatever the client side.
            Path modulesDir = resolveModulesDir();
            moduleManager = new ModuleManager();
            moduleManager.loadModules(modulesDir);
            if (windowed) {
                LogWindow.setModuleManager(moduleManager);
                LogWindow.updateModuleList();
            }

            // 2. The client side: the game's listener, or the proxy playing.
            Channel ch = front.start(this, moduleManager);
            listener = ch;

            state.set(State.CONNECTED);
            started.complete(this);
            if (windowed) {
                LogWindow.onProxyStarted(config.remoteHost(), config.remotePort(), front.how());
            }

            // 3. Block until it closes - disconnect from any origin lands here.
            ch.closeFuture().sync();
        } catch (Exception e) {
            failure = e;
            log.error("Connection scope error", e);
        } finally {
            started.completeExceptionally(failure != null ? failure : new IllegalStateException("closed"));
            teardown();
        }

        if (failure != null) {
            if (guiLifecycle) {
                LogWindow.onProxyFailed(formatBindError(failure, config.localPort()));
            } else {
                throw failure;
            }
        }
    }

    /**
     * Requests a disconnect from any thread (UI button, or a Netty event loop when a
     * peer drops). Non-blocking: it only flips the state and closes the channels; the
     * blocking {@link #run()} thread wakes from {@code closeFuture()} and finishes the
     * heavy teardown off the event loop. No-op if not currently connected/connecting.
     */
    public void requestDisconnect(boolean userInitiated) {
        State s = state.get();
        boolean moved = (s == State.CONNECTED && state.compareAndSet(State.CONNECTED, State.DISCONNECTING))
                || (s == State.CONNECTING && state.compareAndSet(State.CONNECTING, State.DISCONNECTING));
        if (!moved) return; // already disconnecting / disconnected
        log.info("Disconnect requested (userInitiated={}).", userInitiated);
        closeClientsAndListener();
    }

    /** Called by {@link ProxyFrontendHandler#channelActive} when a client connects. */
    public void onClientConnected(QuicChannel ch) {
        liveClients.add(ch);
        if (redirectPending) {
            redirectPending = false;
            log.info("Redirect reconnect established → backend {}:{}.", currentRemoteHost, currentRemotePort);
        }
        log.info("Client connection registered ({} live).", liveClients.size());
    }

    /**
     * Called by {@link ProxyFrontendHandler#channelInactive} when a client leg drops.
     * A real drop of the last connection triggers a full teardown. A drop while a
     * referral is in flight is expected — the listener is kept up for the reconnect.
     */
    public void onClientClosed(QuicChannel ch) {
        liveClients.remove(ch);
        log.info("Client connection closed ({} live).", liveClients.size());
        if (redirectPending) {
            // Expected drop from a server referral; the client is reconnecting to us.
            log.info("Referral in progress — keeping listener up for the client to reconnect.");
            scheduleRedirectTimeout();
            return;
        }
        if (!liveClients.isEmpty()) {
            // Another connection is still live (e.g. the redirect reconnect already
            // arrived before this old leg's close) — don't tear the scope down.
            return;
        }
        if (state.get() == State.CONNECTED) {
            requestDisconnect(false);
        }
    }

    /**
     * Arms a server referral: the next client connection's backend targets {@code host:port}
     * instead of the original remote, and the client's referral-induced drop is treated as
     * a reconnect rather than a disconnect. The scope stays {@code CONNECTED} throughout.
     */
    public void beginRedirect(String host, int port) {
        currentRemoteHost = host;
        currentRemotePort = port;
        redirectPending = true;
        log.info("Redirect armed → next backend target {}:{} (awaiting client reconnect).", host, port);
    }

    /** The local listen port — used by {@link meridian.internal.handler.RouteGuard} to rewrite a referral's hostTo. */
    public int localPort() {
        return config.localPort();
    }

    /** The address the client should reconnect to so a followed referral routes through the proxy. */
    public String selfHost() {
        return "127.0.0.1";
    }

    /** If a referred client never reconnects, fall back to a full teardown. */
    private void scheduleRedirectTimeout() {
        Channel l = listener;
        if (l == null) return;
        l.eventLoop().schedule(() -> {
            if (redirectPending && liveClients.isEmpty() && state.get() == State.CONNECTED) {
                log.warn("Redirect reconnect not received within {}s — tearing down.", REDIRECT_TIMEOUT_SECONDS);
                redirectPending = false;
                requestDisconnect(false);
            }
        }, REDIRECT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
    }

    // ------------------------------------------------------------------
    // Teardown
    // ------------------------------------------------------------------

    /**
     * Closes the live client connections first — each client's {@code channelInactive}
     * closes its backend leg gracefully (QUIC {@code CONNECTION_CLOSE} to the real
     * server) before the group is killed — then closes the listener, which unblocks
     * {@link #run()} so it can finish the teardown.
     */
    private void closeClientsAndListener() {
        for (QuicChannel c : liveClients) {
            if (c.isActive()) c.close();
        }
        front.close();
    }

    /** Full teardown — always runs on the {@link #run()} thread (never an event loop). */
    private void teardown() {
        state.set(State.DISCONNECTING);
        closeClientsAndListener();

        front.release();

        ModuleManager mm = moduleManager;
        if (mm != null) mm.shutdown();

        if (windowed) {
            LogWindow.setModuleManager(null);
            LogWindow.updateModuleList();
            LogWindow.onProxyStopped();
        }

        moduleManager = null;
        listener = null;
        liveClients.clear();
        state.set(State.DISCONNECTED);
        log.info("Connection scope torn down.");
    }

    // ------------------------------------------------------------------
    // Helpers
    // ------------------------------------------------------------------

    /**
     * Launcher mode keeps the world-local {@code ./modules}; everything else gets a
     * per-server workspace {@code <jar-dir>/<host_port>/modules}, so reconnecting to a
     * different server loads that server's module set.
     */
    private Path resolveModulesDir() {
        if (config.launchedByLauncher()) {
            return Paths.get("modules");
        }
        // A server connected to for the first time starts from the shared default set (jars,
        // disabled/, the launcher's modules.json offer) — same seeding the multiplex path does.
        Path dir = config.modulesScope() != null
                ? ProxyConfig.scopeModulesDir(config.modulesScope())
                : ProxyConfig.serverModulesDir(config.remoteHost(), config.remotePort());
        try {
            if (ProxyConfig.createServerModulesDir(dir)) {
                log.info("Seeded {} from default modules {}", dir, ProxyConfig.defaultModulesDir());
            }
        } catch (java.io.IOException e) {
            log.warn("Failed to seed modules for {}: {}", dir, e.toString());
        }
        return dir;
    }

    /** Turns a bind failure into a user-facing message (port-in-use gets a tailored hint). */
    static String formatBindError(Throwable e, int port) {
        Throwable cause = e;
        while (cause != null) {
            if (cause instanceof java.net.BindException
                    || (cause.getMessage() != null
                        && cause.getMessage().toLowerCase().contains("address already in use"))) {
                return "Local port " + port + " is already in use.\n\n"
                        + "If a Hytale single-player session is running, it occupies 5520. "
                        + "Either close it, or pick a different Local port and use it in Direct Connect.";
            }
            cause = cause.getCause();
        }
        String msg = e.getMessage() != null ? e.getMessage() : e.toString();
        return "Failed to start: " + msg;
    }
}
