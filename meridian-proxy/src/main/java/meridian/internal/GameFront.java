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
import java.security.MessageDigest;
import java.util.Base64;
import java.util.concurrent.TimeUnit;
import meridian.api.event.EventBus;
import meridian.internal.core.ProxyConfig;
import meridian.internal.core.QuicConfig;
import meridian.internal.module.HandlerRegistry;
import meridian.internal.module.ModuleManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The game's side of a connection: a local QUIC port the game connects to, each client that does
 * bridged to the server ({@link ProxyFrontendHandler}). Its life - modules, window, disconnect -
 * is the {@link ConnectionScope}'s.
 */
final class GameFront implements Front {

    private static final Logger log = LoggerFactory.getLogger(GameFront.class);

    private final ProxyConfig config;
    private volatile Channel listener;
    private volatile NioEventLoopGroup group;

    GameFront(ProxyConfig config) {
        this.config = config;
    }

    @Override
    public Channel start(ConnectionScope scope, ModuleManager moduleManager) throws Exception {
        // One self-signed cert for both legs; its fingerprint is the x509Fingerprint used in every
        // REST call (see architecture.md).
        SelfSignedCertificate ssc = new SelfSignedCertificate("localhost");
        QuicSslContext sslContext = QuicSslContextBuilder.forServer(ssc.key(), null, ssc.cert())
                .applicationProtocols(HytaleAlpn.CURRENT, HytaleAlpn.PREVIOUS)
                .clientAuth(ClientAuth.NONE)
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();

        logEnv("HYTALE_SESSION_TOKEN", config.clientToken());
        logEnv("HYTALE_SERVER_SESSION_TOKEN", config.serverToken());
        logEnv("HYTALE_SERVER_IDENTITY_TOKEN", config.identityToken());
        byte[] certDer = ssc.cert().getEncoded();
        byte[] sha256 = MessageDigest.getInstance("SHA-256").digest(certDer);
        final String fp = Base64.getUrlEncoder().withoutPadding().encodeToString(sha256);
        log.info("Proxy self-signed cert SHA-256 fingerprint (b64url): {}", fp);

        final HytaleSessionApi clientApi =
                new HytaleSessionApi(config.clientToken() != null ? config.clientToken() : "");
        final HytaleSessionApi serverApi =
                new HytaleSessionApi(config.serverToken() != null ? config.serverToken() : "");
        final String serverIdent = config.identityToken();
        final HandlerRegistry handlerRegistry = moduleManager.handlerRegistry();
        final EventBus eventBus = moduleManager.eventBus();

        // Large UDP socket buffers: the Hytale setup payload arrives as a multi-megabyte burst.
        NioEventLoopGroup g = new NioEventLoopGroup();
        group = g;
        Bootstrap b = new Bootstrap();
        b.group(g)
                .channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_RCVBUF, 8 * 1024 * 1024)
                .option(ChannelOption.SO_SNDBUF, 4 * 1024 * 1024)
                .handler(new LoggingHandler("UDP_RAW", LogLevel.DEBUG))
                .handler(QuicConfig.configure(new QuicServerCodecBuilder()
                        .sslContext(sslContext)
                        .tokenHandler(null))
                        .handler(new ChannelInitializer<QuicChannel>() {
                            @Override
                            protected void initChannel(QuicChannel ch) {
                                log.info("New QUIC connection from {}", ch.remoteAddress());
                                ch.pipeline().addFirst(new LoggingHandler("FRONTEND_CONN", LogLevel.INFO));
                                // The backend target read at connect time: one that arrives after a
                                // referral targets the new server.
                                ch.pipeline().addLast(new ProxyFrontendHandler(scope.currentRemoteHost(),
                                        scope.currentRemotePort(), ssc,
                                        new HytaleAuthState(fp, fp, serverIdent, clientApi, serverApi),
                                        handlerRegistry, eventBus, scope)
                                        .commands(moduleManager.commandRegistry()));
                            }
                        })
                        .streamHandler(new LoggingHandler("STREAM_RAW", LogLevel.INFO))
                        .build());

        ChannelFuture f = b.bind(config.localPort()).sync();
        listener = f.channel();

        // Magic prints for launcher compatibility.
        System.out.println("Listening on /127.0.0.1:" + config.localPort());
        System.out.println("Listening on /[0:0:0:0:0:0:0:1]:" + config.localPort());
        System.out.println("-=|Enabled|0");
        System.out.println(ProxyConfig.READY_SIGNAL);
        System.out.flush();
        log.info("QUIC Proxy is ready and listening.");
        return listener;
    }

    @Override
    public void close() {
        Channel l = listener;
        if (l != null && l.isActive()) {
            l.close();
        }
    }

    @Override
    public void release() {
        NioEventLoopGroup g = group;
        if (g != null) {
            try {
                // Zero quiet period (vs the 2s default) so the UDP listen port is released quickly -
                // a reconnect to the same local port must be able to re-bind.
                g.shutdownGracefully(0, 2, TimeUnit.SECONDS).sync();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        listener = null;
        group = null;
    }

    @Override
    public String how() {
        return "(listening on localhost:" + config.localPort() + ")";
    }

    private static void logEnv(String name, String value) {
        if (value != null && !value.isEmpty()) {
            log.info("  {} = {}... (len={})", name, value.substring(0, Math.min(value.length(), 10)), value.length());
        } else {
            log.warn("  {} is empty. Auth may fail.", name);
        }
    }
}
