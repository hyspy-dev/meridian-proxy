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
import meridian.api.event.EventBus;
import meridian.internal.auth.LauncherSessionMinter;
import meridian.internal.core.ProxyConfig;
import meridian.internal.core.QuicConfig;
import meridian.internal.module.HandlerRegistry;
import meridian.internal.module.ModuleManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * Range/multiplex mode: bind <b>many</b> local ports (one per server) — all sharing a single
 * event-loop group and one cert — and relay each to its own real server. The launcher rewrites
 * the in-game server list so each server points at {@code 127.0.0.1:<port>} and maintains a
 * routes file mapping those ports back to real hosts; this proxy reads/watches it and binds.
 *
 * <p><b>Lazy by design.</b> On start it does the minimum: make the cert, bind the ports that
 * exist, and <em>wait</em>. The heavy pickup — loading modules and deriving the server-scope
 * session tokens from the player session — is deferred until the <em>first client actually
 * connects</em> to one of the ports. So starting the proxy with an empty/idle routes file costs
 * nothing (no module load, no token mint) until you join a server.
 *
 * <p>Routes file format, one per line: {@code <localPort>=<host>:<port>} ({@code #} comments and
 * blank lines ignored). The player session comes from {@code --session-token}.
 */
public final class MultiplexProxy {

    private static final Logger log = LoggerFactory.getLogger(MultiplexProxy.class);
    private static final long WATCH_INTERVAL_MS = 1000;

    private final ProxyConfig config;
    private final Path routesFile;
    private final Map<Integer, Channel> bound = new ConcurrentHashMap<>();

    // Built eagerly (cheap, needed to bind a QUIC listener).
    private NioEventLoopGroup group;
    private SelfSignedCertificate ssc;
    private QuicSslContext sslContext;
    private String certFp;

    // Session tokens are derived once (same account for every route) — lazily, on first connect.
    private volatile boolean tokensReady;
    private String serverIdent;
    private HytaleSessionApi clientApi;
    private HytaleSessionApi serverApi;

    public MultiplexProxy(ProxyConfig config, Path routesFile) {
        this.config = config;
        this.routesFile = routesFile;
    }

    /** Blocking: builds the cheap parts, binds current routes, watches for more, and holds. */
    public void run() throws Exception {
        log.info("Starting Meridian MULTIPLEX proxy — routes: {}", routesFile.toAbsolutePath());

        // One self-signed cert for every route; its fingerprint is the x509Fingerprint used in
        // the Hytale REST session calls (same as ConnectionScope). Cheap — kept eager so we can
        // bind listeners without any network/module work.
        this.ssc = new SelfSignedCertificate("localhost");
        this.sslContext = QuicSslContextBuilder.forServer(ssc.key(), null, ssc.cert())
                .applicationProtocols(HytaleAlpn.CURRENT, HytaleAlpn.PREVIOUS)
                .clientAuth(ClientAuth.NONE)
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();
        byte[] sha256 = MessageDigest.getInstance("SHA-256").digest(ssc.cert().getEncoded());
        this.certFp = Base64.getUrlEncoder().withoutPadding().encodeToString(sha256);

        this.group = new NioEventLoopGroup();

        int n = loadRoutes();
        log.info("Multiplex: {} port(s) bound, idle — session tokens load on the first connection, "
                + "each server's own <host_port>/modules (fresh) on every connection.", n);

        // Launcher-compat readiness marker.
        System.out.println(ProxyConfig.READY_SIGNAL);
        System.out.flush();

        startWatcher();
        new CountDownLatch(1).await();   // hold open; connections arrive via Netty
    }

    /**
     * Derives the server-scope tokens from the player session — once, shared by every route
     * (same account). Blocking (one HTTP hop), so only the very first connection pays for it.
     */
    private synchronized void ensureTokens() {
        if (tokensReady) {
            return;
        }
        log.info("Multiplex: first connection — deriving session tokens from the player session…");
        String clientToken = config.clientToken();
        String serverToken = config.serverToken();
        String identityToken = config.identityToken();
        if (clientToken != null && (serverToken == null || identityToken == null)) {
            try {
                LauncherSessionMinter.ServerTokens t =
                        new LauncherSessionMinter().deriveServerTokens(clientToken);
                serverToken = t.sessionToken();
                identityToken = t.identityToken();
            } catch (Exception e) {
                log.error("Multiplex: failed to derive server tokens from player session", e);
            }
        }
        this.serverIdent = identityToken;
        this.clientApi = new HytaleSessionApi(clientToken != null ? clientToken : "");
        this.serverApi = new HytaleSessionApi(serverToken != null ? serverToken : "");
        tokensReady = true;
    }

    /**
     * A FRESH module runtime for one connection, loaded from that server's
     * {@code <jar>/<host_port>/modules} folder — exactly like {@link ConnectionScope}, which
     * loads on connect and shuts down on disconnect. Loading fresh each time means module jars
     * dropped in between sessions are picked up, and each connection gets a clean lifecycle
     * ({@code onEnable}/{@code onDisable}) rather than a reused (possibly torn-down) one.
     */
    private ModuleManager loadModulesFor(MultiplexRoute route) {
        Path dir = ProxyConfig.serverModulesDir(route.originalHost(), route.originalPort());
        log.info("Multiplex: loading modules for {}:{} from {}",
                route.originalHost(), route.originalPort(), dir);
        ModuleManager mm = new ModuleManager();
        mm.loadModules(dir);
        LogWindow.setModuleManager(mm);   // show the just-connected server's modules
        LogWindow.updateModuleList();
        return mm;
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

    /** Reads the routes file and binds any port not already bound. Returns total bound. */
    private synchronized int loadRoutes() {
        if (!Files.exists(routesFile)) {
            return bound.size();
        }
        List<String> lines;
        try {
            lines = Files.readAllLines(routesFile, StandardCharsets.UTF_8);
        } catch (Exception e) {
            log.warn("Could not read routes file {}: {}", routesFile, e.toString());
            return bound.size();
        }
        for (String raw : lines) {
            String line = raw.trim();
            if (line.isEmpty() || line.startsWith("#")) {
                continue;
            }
            int eq = line.indexOf('=');
            if (eq <= 0) {
                continue;
            }
            int localPort;
            try {
                localPort = Integer.parseInt(line.substring(0, eq).trim());
            } catch (NumberFormatException e) {
                continue;
            }
            if (bound.containsKey(localPort)) {
                continue;
            }
            String hostPort = line.substring(eq + 1).trim();
            int colon = hostPort.lastIndexOf(':');
            String host = colon > 0 ? hostPort.substring(0, colon) : hostPort;
            int remotePort = 5520;
            if (colon > 0) {
                try {
                    remotePort = Integer.parseInt(hostPort.substring(colon + 1).trim());
                } catch (NumberFormatException ignored) {
                }
            }
            bindRoute(localPort, host, remotePort);
        }
        return bound.size();
    }

    /** Binds one idle local port that will relay to {@code host:remotePort} when connected. */
    private void bindRoute(int localPort, String host, int remotePort) {
        final MultiplexRoute route = new MultiplexRoute(localPort, host, remotePort);
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
                                    // Deferred pickup on each connection: shared session tokens
                                    // (once) + this server's own module runtime (fresh per connect,
                                    // torn down when the connection closes).
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

    /** Re-reads the routes file periodically so servers the game sees later get bound in time. */
    private void startWatcher() {
        Thread t = new Thread(() -> {
            while (!group.isShuttingDown()) {
                try {
                    Thread.sleep(WATCH_INTERVAL_MS);
                    loadRoutes();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                } catch (Exception e) {
                    log.debug("routes watch tick failed: {}", e.toString());
                }
            }
        }, "Multiplex-RoutesWatch");
        t.setDaemon(true);
        t.start();
    }
}
