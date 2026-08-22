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
 * Range/multiplex mode: instead of one listen port → one server, the proxy binds <b>many</b>
 * local ports (one per server) — all sharing a single event-loop group, one module runtime,
 * and one self-signed cert — and relays each port to its own real server. This is how the
 * launcher redirects gameplay UDP automatically: it rewrites the in-game server list so each
 * server points at {@code 127.0.0.1:<port>}, and keeps a routes file mapping those ports back
 * to the real hosts; this proxy reads that file (and watches it for new entries) and binds.
 *
 * <p>Binding an idle port is cheap (a UDP socket + QUIC codec); the real work happens only on
 * the port a client actually connects to. So one process handles the whole range — no per-
 * server JVMs or event-loop groups.
 *
 * <p>Routes file format, one per line: {@code <localPort>=<host>:<port>} ({@code #} comments
 * and blank lines ignored). Tokens come from {@code --session-token} (the player session),
 * with the server-scope tokens derived once and reused for every route (same account).
 */
public final class MultiplexProxy {

    private static final Logger log = LoggerFactory.getLogger(MultiplexProxy.class);
    private static final long WATCH_INTERVAL_MS = 1000;

    private final ProxyConfig config;
    private final Path routesFile;
    private final Map<Integer, Channel> bound = new ConcurrentHashMap<>();

    // Shared, built once in run().
    private NioEventLoopGroup group;
    private SelfSignedCertificate ssc;
    private QuicSslContext sslContext;
    private String certFp;
    private String serverIdent;
    private HytaleSessionApi clientApi;
    private HytaleSessionApi serverApi;
    private HandlerRegistry handlerRegistry;
    private EventBus eventBus;

    public MultiplexProxy(ProxyConfig config, Path routesFile) {
        this.config = config;
        this.routesFile = routesFile;
    }

    /** Blocking: builds shared runtime, binds the current routes, watches for more, and holds. */
    public void run() throws Exception {
        log.info("Starting Meridian multiplex proxy — routes: {}", routesFile.toAbsolutePath());

        ModuleManager moduleManager = new ModuleManager();
        moduleManager.loadModules(ProxyConfig.jarDir().resolve("modules"));
        LogWindow.setModuleManager(moduleManager);
        LogWindow.updateModuleList();
        this.handlerRegistry = moduleManager.handlerRegistry();
        this.eventBus = moduleManager.eventBus();

        // One self-signed cert for every route; its fingerprint is the x509Fingerprint used
        // in the Hytale REST session calls (same as ConnectionScope).
        this.ssc = new SelfSignedCertificate("localhost");
        this.sslContext = QuicSslContextBuilder.forServer(ssc.key(), null, ssc.cert())
                .applicationProtocols(HytaleAlpn.CURRENT, HytaleAlpn.PREVIOUS)
                .clientAuth(ClientAuth.NONE)
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();
        byte[] sha256 = MessageDigest.getInstance("SHA-256").digest(ssc.cert().getEncoded());
        this.certFp = Base64.getUrlEncoder().withoutPadding().encodeToString(sha256);
        log.info("Proxy self-signed cert SHA-256 fingerprint (b64url): {}", certFp);

        this.serverIdent = config.identityToken();
        this.clientApi = new HytaleSessionApi(config.clientToken() != null ? config.clientToken() : "");
        this.serverApi = new HytaleSessionApi(config.serverToken() != null ? config.serverToken() : "");

        this.group = new NioEventLoopGroup();

        int n = loadRoutes();
        log.info("Multiplex bound {} route(s).", n);

        // Launcher-compat readiness marker.
        System.out.println(ProxyConfig.READY_SIGNAL);
        System.out.flush();

        startWatcher();

        // Hold the process open; routes are added by the watcher, connections by Netty.
        new CountDownLatch(1).await();
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

    /** Binds one local port that relays to {@code host:remotePort}, sharing the event loop. */
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
                                    // Read the route's current target at connect time (referrals repoint it).
                                    ch.pipeline().addLast(new ProxyFrontendHandler(
                                            route.currentRemoteHost(), route.currentRemotePort(), ssc,
                                            new HytaleAuthState(certFp, certFp, serverIdent, clientApi, serverApi),
                                            handlerRegistry, eventBus, route));
                                }
                            })
                            .streamHandler(new LoggingHandler("STREAM_RAW", LogLevel.DEBUG))
                            .build());
            Channel ch = b.bind(localPort).sync().channel();
            bound.put(localPort, ch);
            log.info("multiplex bound 127.0.0.1:{} -> {}:{}", localPort, host, remotePort);
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
