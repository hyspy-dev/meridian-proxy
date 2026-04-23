package meridian.proxy;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.ssl.ClientAuth;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.handler.ssl.util.SelfSignedCertificate;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.incubator.codec.quic.*;
import meridian.proxy.core.ProxyConfig;
import meridian.proxy.core.QuicConfig;
import meridian.proxy.core.LauncherBridge;
import meridian.proxy.module.ModuleManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

/**
 * Main entry point for the Hytale MITM Proxy (QUIC Implementation).
 * Listens for QUIC connections and proxies streams to the target server.
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

    private final String remoteHost;
    private final int remotePort;
    private final int localPort;
    private final String clientSessionToken;
    private final String serverSessionToken;
    private final String serverIdentityToken;
    private final ModuleManager moduleManager;

    public ProxyServer(ProxyConfig config, ModuleManager moduleManager) {
        this.remoteHost = config.remoteHost();
        this.remotePort = config.remotePort();
        this.localPort = config.localPort();
        this.clientSessionToken = config.clientToken();
        this.serverSessionToken = config.serverToken();
        this.serverIdentityToken = config.identityToken();
        this.moduleManager = moduleManager;
    }

    public void start() throws Exception {
        log.info("Starting Hytale MITM QUIC Proxy on port {} -> {}:{}", localPort, remoteHost, remotePort);

        SelfSignedCertificate ssc = new SelfSignedCertificate("localhost");
        QuicSslContext sslContext = QuicSslContextBuilder.forServer(ssc.key(), null, ssc.cert())
                .applicationProtocols("hytale/2", "hytale/1")
                .clientAuth(ClientAuth.NONE)
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();

        // ---- Prepare Hytale session auth state ----
        logEnv("HYTALE_SESSION_TOKEN", clientSessionToken);
        logEnv("HYTALE_SERVER_SESSION_TOKEN", serverSessionToken);
        logEnv("HYTALE_SERVER_IDENTITY_TOKEN", serverIdentityToken);
        byte[] certDer = ssc.cert().getEncoded();
        byte[] sha256 = MessageDigest.getInstance("SHA-256").digest(certDer);
        String fingerprintB64Url = Base64.getUrlEncoder().withoutPadding().encodeToString(sha256);
        log.info("Proxy self-signed cert SHA-256 fingerprint (b64url): {}", fingerprintB64Url);
        final HytaleSessionApi clientApi = new HytaleSessionApi(clientSessionToken != null ? clientSessionToken : "");
        final HytaleSessionApi serverApi = new HytaleSessionApi(serverSessionToken != null ? serverSessionToken : "");
        final String fp = fingerprintB64Url;
        final String serverIdent = serverIdentityToken;

        NioEventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(io.netty.channel.socket.nio.NioDatagramChannel.class)
                    .handler(new LoggingHandler("UDP_RAW", LogLevel.DEBUG))
                    .handler(QuicConfig.configure(new QuicServerCodecBuilder()
                            .sslContext(sslContext)
                            .tokenHandler(null))
                            .handler(new ChannelInitializer<QuicChannel>() {
                                @Override
                                protected void initChannel(QuicChannel ch) {
                                    log.info("New QUIC connection from {}", ch.remoteAddress());
                                    ch.pipeline().addFirst(new LoggingHandler("FRONTEND_CONN", LogLevel.INFO));
                                    ch.pipeline().addLast(new ProxyFrontendHandler(remoteHost, remotePort, ssc,
                                            new HytaleAuthState(fp, fp, serverIdent, clientApi, serverApi)));
                                }
                            })
                            .streamHandler(new LoggingHandler("STREAM_RAW", LogLevel.INFO))
                            .build());

            ChannelFuture f = b.bind(localPort).sync();

            // Magic prints for launcher compatibility
            System.out.println("Listening on /127.0.0.1:" + localPort);
            System.out.println("Listening on /[0:0:0:0:0:0:0:1]:" + localPort);
            System.out.println("-=|Enabled|0");
            System.out.println(ProxyConfig.READY_SIGNAL);
            System.out.flush();

            log.info("QUIC Proxy is ready and listening.");
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        ProxyConfig config = ProxyConfig.fromArgs(args);

        // Load modules early to show them in the Management UI
        ModuleManager mm = new ModuleManager();
        mm.loadModules(Paths.get("modules"));
        LogWindow.setModuleManager(mm);

        // Enforce magic progress bars for launcher compatibility
        ProxyConfig.printLauncherProgress();

        log.info("Resolved configuration:");
        log.info("  Local Port:  {}", config.localPort());
        log.info("  Remote Host: {}", config.remoteHost());
        log.info("  Remote Port: {}", config.remotePort());

        if (config.autoWrap()) {
            LauncherBridge bridge = new LauncherBridge(config);
            bridge.launchAndWait();
        }

        new ProxyServer(config, mm).start();
    }

    private static void logEnv(String name, String value) {
        if (value != null && !value.isEmpty()) {
            log.info("  {} = {}... (len={})", name, value.substring(0, Math.min(value.length(), 10)), value.length());
        } else {
            log.warn("  {} is empty. Auth may fail.", name);
        }
    }
}
