package meridian.internal;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
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
import meridian.internal.auth.LauncherSessionMinter;
import meridian.internal.core.ProxyConfig;
import meridian.internal.core.QuicConfig;
import meridian.internal.module.ModuleManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.time.Instant;
import java.util.Base64;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Range/multiplex mode: bind <b>many</b> local ports (one per server) — all sharing a single
 * event-loop group and one cert — and relay each to its own real server. Used by the launcher
 * to auto-redirect gameplay UDP: the launcher rewrites the in-game server list so each server
 * points at {@code 127.0.0.1:<port>}, then drives this proxy over a control channel.
 *
 * <p><b>Control channel = the process's stdin</b> (a proper parent→child pipe, not files). The
 * launcher started this proxy, so it writes line commands to our stdin:
 * <ul>
 *   <li>{@code TOKEN <jwt>} — set/replace the player session token (a re-mint is pushed live,
 *       no restart); server-scope tokens are re-derived from it on the next connection.</li>
 *   <li>{@code ROUTE <localPort> <host> <port>} — bind a local port that relays to that
 *       server.</li>
 *   <li>{@code SCOPE <localPort> <name>} — load that port's modules from
 *       {@code <jar>/<name>/modules} instead of the server's own {@code <host_port>} folder. Sent
 *       before the ROUTE, for servers that are a new address every time (a matchmade minigame
 *       is a new server per match, but one module set per game type).</li>
 * </ul>
 *
 * <p>Lazy by design: binding an idle port is cheap; the heavy work — deriving tokens and loading
 * that server's own {@code <jar>/<host_port>/modules} — happens on the first client connection
 * to a port, fresh each connection (see {@link #loadModulesFor}).
 */
public final class MultiplexProxy {

    private static final Logger log = LoggerFactory.getLogger(MultiplexProxy.class);

    private final ProxyConfig config;
    private final Map<Integer, Channel> bound = new ConcurrentHashMap<>();
    /** Local port → module folder name, for routes whose modules are not kept per address. */
    private final Map<Integer, String> scopes = new ConcurrentHashMap<>();
    /** Live client connections across all routes — drives the shared Connect/Disconnect UI. */
    private final java.util.concurrent.atomic.AtomicInteger liveClients =
            new java.util.concurrent.atomic.AtomicInteger();

    /**
     * Drives the same Connect-bar state the standalone path uses: the first client connection
     * flips the window to the Connected bar (hiding Connect), and the last disconnect flips it
     * back — reusing {@link LogWindow#onProxyStarted}/{@link LogWindow#onProxyStopped}, not a
     * duplicate of that behaviour.
     */
    private final MultiplexRoute.Listener routeListener = new MultiplexRoute.Listener() {
        @Override
        public void onConnected(MultiplexRoute route) {
            liveClients.incrementAndGet();
            LogWindow.onProxyStarted(route.originalHost(), route.originalPort(), route.localPort());
        }

        @Override
        public void onClosed(MultiplexRoute route) {
            if (liveClients.decrementAndGet() <= 0) {
                LogWindow.onProxyStopped();
            }
        }
    };

    // Built eagerly (cheap, needed to bind a QUIC listener).
    private NioEventLoopGroup group;
    private SelfSignedCertificate ssc;
    private QuicSslContext sslContext;
    private String certFp;

    /** Current player session token, updated live by the {@code TOKEN} control command. */
    private volatile String playerToken;

    // Server-scope tokens derived from the player session; re-derived when the player token
    // changes or the derived ones near expiry, so the proxy never runs with a stale token.
    private String lastPlayerToken;
    private String serverIdent;
    private HytaleSessionApi clientApi;
    private HytaleSessionApi serverApi;
    private Instant tokensExpireAt;

    public MultiplexProxy(ProxyConfig config) {
        this.config = config;
        this.playerToken = config.clientToken();
    }

    /** Blocking: builds the cheap parts, prints READY, then processes control commands from stdin. */
    public void run() throws Exception {
        log.info("Starting Meridian MULTIPLEX proxy (stdin-controlled).");

        this.ssc = new SelfSignedCertificate("localhost");
        this.sslContext = QuicSslContextBuilder.forServer(ssc.key(), null, ssc.cert())
                .applicationProtocols(HytaleAlpn.CURRENT, HytaleAlpn.PREVIOUS)
                .clientAuth(ClientAuth.NONE)
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();
        byte[] sha256 = MessageDigest.getInstance("SHA-256").digest(ssc.cert().getEncoded());
        this.certFp = Base64.getUrlEncoder().withoutPadding().encodeToString(sha256);

        this.group = new NioEventLoopGroup();

        log.info("Multiplex idle — awaiting ROUTE/TOKEN commands on stdin. Modules & tokens load "
                + "on the first connection (not now).");
        System.out.println(ProxyConfig.READY_SIGNAL);
        System.out.flush();

        readControlCommands();   // blocks until the launcher closes stdin
    }

    // ------------------------------------------------------------------
    // Control channel (stdin)
    // ------------------------------------------------------------------

    private void readControlCommands() {
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
            String line;
            while ((line = r.readLine()) != null) {
                handleCommand(line.trim());
            }
        } catch (Exception e) {
            log.warn("Multiplex: control channel ended: {}", e.toString());
        }
        log.info("Multiplex: control channel closed.");
    }

    private void handleCommand(String line) {
        if (line.isEmpty() || line.startsWith("#")) {
            return;
        }
        String[] p = line.split("\\s+");
        String cmd = p[0].toUpperCase();
        try {
            switch (cmd) {
                case "TOKEN" -> {
                    if (p.length >= 2) {
                        playerToken = p[1];
                        log.info("Multiplex: player token updated via control channel.");
                        LogWindow.onLauncherToken(p[1]);
                    }
                }
                case "ROUTE" -> {
                    if (p.length >= 4) {
                        bindRoute(Integer.parseInt(p[1]), p[2], Integer.parseInt(p[3]));
                    } else {
                        log.warn("Multiplex: bad ROUTE command: {}", line);
                    }
                }
                case "SCOPE" -> {
                    if (p.length >= 3) {
                        scopes.put(Integer.parseInt(p[1]), p[2]);
                    } else {
                        log.warn("Multiplex: bad SCOPE command: {}", line);
                    }
                }
                default -> log.warn("Multiplex: unknown control command: {}", cmd);
            }
        } catch (RuntimeException e) {
            log.warn("Multiplex: failed to handle '{}': {}", line, e.toString());
        }
    }

    // ------------------------------------------------------------------
    // Per-connection pickup
    // ------------------------------------------------------------------

    /**
     * Ensures the server-scope tokens are current: re-derives them from the player session when
     * the player token changed (launcher pushed a new TOKEN) or the derived ones are near expiry.
     * Called on every connection (cheap when nothing changed — no network hop).
     */
    private synchronized void ensureTokens() {
        String player = playerToken != null ? playerToken : config.clientToken();
        boolean expired = tokensExpireAt != null && Instant.now().isAfter(tokensExpireAt.minusSeconds(60));
        boolean changed = !Objects.equals(player, lastPlayerToken);
        if (clientApi != null && !changed && !expired) {
            return;
        }
        log.info("Multiplex: (re)deriving session tokens (tokenChanged={}, nearExpiry={})", changed, expired);

        String serverToken = null;
        String identityToken = null;
        Instant exp = null;
        if (player != null && !player.isBlank()) {
            try {
                LauncherSessionMinter.ServerTokens t = new LauncherSessionMinter().deriveServerTokens(player);
                serverToken = t.sessionToken();
                identityToken = t.identityToken();
                exp = t.expiresAt();
            } catch (Exception e) {
                log.error("Multiplex: failed to derive server tokens from player session", e);
            }
        }
        this.serverIdent = identityToken;
        this.clientApi = new HytaleSessionApi(player != null ? player : "");
        this.serverApi = new HytaleSessionApi(serverToken != null ? serverToken : "");
        this.lastPlayerToken = player;
        this.tokensExpireAt = exp;
    }

    /**
     * A FRESH module runtime for one connection, loaded from that server's
     * {@code <jar>/<host_port>/modules} folder — or, for a route the launcher gave a scope, from
     * {@code <jar>/<scope>/modules} — exactly like {@link ConnectionScope}, which loads on connect
     * and shuts down on disconnect. Loading fresh each time means module jars dropped in between
     * sessions are picked up, and each connection gets a clean lifecycle.
     */
    private ModuleManager loadModulesFor(MultiplexRoute route) {
        String scope = scopes.get(route.localPort());
        Path dir = scope != null
                ? ProxyConfig.scopeModulesDir(scope)
                : ProxyConfig.serverModulesDir(route.originalHost(), route.originalPort());
        seedFromDefaultModules(dir);
        log.info("Multiplex: loading modules for {}:{} from {}",
                route.originalHost(), route.originalPort(), dir);
        ModuleManager mm = new ModuleManager();
        mm.loadModules(dir);
        LogWindow.setModuleManager(mm);
        LogWindow.updateModuleList();
        return mm;
    }

    /**
     * First time a server is seen (its {@code <host_port>/modules} folder doesn't exist yet),
     * seed it from the shared default {@code <jar>/modules} folder — so a new server starts
     * with the default module set, then can be customised per server.
     */
    private void seedFromDefaultModules(Path serverModulesDir) {
        try {
            if (ProxyConfig.createServerModulesDir(serverModulesDir)) {
                log.info("Multiplex: seeded {} from default modules {}",
                        serverModulesDir, ProxyConfig.defaultModulesDir());
            }
        } catch (IOException e) {
            log.warn("Multiplex: failed to seed modules for {}: {}", serverModulesDir, e.toString());
        }
    }

    /** Shut a connection's module runtime down off the event loop (onDisable may block). */
    private void shutdownModules(ModuleManager mm) {
        Thread t = new Thread(() -> {
            try {
                mm.shutdown();
            } catch (Exception e) {
                log.warn("module shutdown failed: {}", e.toString());
            }
            LogWindow.setModuleManager(null);
            LogWindow.updateModuleList();
        }, "Multiplex-ModuleShutdown");
        t.setDaemon(true);
        t.start();
    }

    // ------------------------------------------------------------------
    // Binding
    // ------------------------------------------------------------------

    /** Binds one idle local port that will relay to {@code host:remotePort} when connected. */
    private void bindRoute(int localPort, String host, int remotePort) {
        if (bound.containsKey(localPort)) {
            return;
        }
        final MultiplexRoute route = new MultiplexRoute(localPort, host, remotePort, routeListener);
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_RCVBUF, 8 * 1024 * 1024)
                    .option(ChannelOption.SO_SNDBUF, 4 * 1024 * 1024)
                    .handler(QuicConfig.configure(new QuicServerCodecBuilder()
                            .sslContext(sslContext)
                            .tokenHandler(null))
                            .handler(new ChannelInitializer<QuicChannel>() {
                                @Override
                                protected void initChannel(QuicChannel ch) {
                                    // Deferred pickup on each connection: fresh tokens (if changed)
                                    // + this server's own module runtime (torn down on close).
                                    ensureTokens();
                                    ModuleManager mm = loadModulesFor(route);
                                    ch.closeFuture().addListener(f -> shutdownModules(mm));
                                    ch.pipeline().addLast(new ProxyFrontendHandler(
                                            route.currentRemoteHost(), route.currentRemotePort(), ssc,
                                            new HytaleAuthState(certFp, certFp, serverIdent, clientApi, serverApi),
                                            mm.handlerRegistry(), mm.eventBus(), route));
                                }
                            })
                            .streamHandler(new LoggingHandler("STREAM_RAW", LogLevel.DEBUG))
                            .build());
            Channel ch = b.bind(localPort).sync().channel();
            bound.put(localPort, ch);
            log.info("multiplex listening 127.0.0.1:{} -> {}:{} (idle until connected)",
                    localPort, host, remotePort);
        } catch (Exception e) {
            log.warn("multiplex: failed to bind :{} -> {}:{} — {}", localPort, host, remotePort, e.toString());
        }
    }
}
