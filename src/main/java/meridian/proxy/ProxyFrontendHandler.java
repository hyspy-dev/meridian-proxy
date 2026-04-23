package meridian.proxy;

import meridian.proxy.core.Direction;
import meridian.proxy.core.PacketCodec;
import meridian.proxy.core.PacketForwarder;
import meridian.proxy.core.PacketRouter;
import meridian.proxy.core.ProxySession;
import meridian.proxy.core.QuicConfig;
import meridian.proxy.handler.ConnectObserver;
import meridian.proxy.handler.BackAuthHandler;
import meridian.proxy.handler.FrontAuthHandler;
import meridian.proxy.handler.PacketHandler;
import meridian.proxy.module.HandlerRegistry;
import meridian.proxy.module.PacketHandlerFactory;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslHandshakeCompletionEvent;
import io.netty.handler.ssl.SniCompletionEvent;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.handler.ssl.util.SelfSignedCertificate;
import io.netty.incubator.codec.quic.*;
import io.netty.util.NetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SNIHostName;
import javax.net.ssl.SSLParameters;
import java.net.InetSocketAddress;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

/**
 * Owns one client-facing QUIC connection: opens a backend connection to the
 * real server,
 * bridges streams 1:1 in registration order, and installs the per-stream packet
 * pipeline.
 */
public class ProxyFrontendHandler extends ChannelInboundHandlerAdapter {
    private static final Logger log = LoggerFactory.getLogger(ProxyFrontendHandler.class);

    private final String remoteHost;
    private final int remotePort;
    private final SelfSignedCertificate ssc;
    private final HytaleAuthState auth;
    private volatile QuicChannel backendConnection;
    private volatile String sniHostname;
    private boolean backendInitiated = false;
    private final Queue<QuicStreamChannel> pendingClientStreams = new ArrayDeque<>();

    // Stream IDs per QUIC: bidi 0,4,8,... uni 2,6,10,... (client-initiated) and
    // 1,5,... / 3,7,... (server).
    // We keep separate next-expected counters per side to preserve registration
    // order across the bridge.
    private final Map<QuicStreamType, Long> nextExpectedBackStreamId = new EnumMap<>(QuicStreamType.class);
    private final Map<QuicStreamType, SortedMap<Long, QuicStreamChannel>> backStreamBuffer = new EnumMap<>(
            QuicStreamType.class);
    private final Map<QuicStreamType, Long> nextExpectedFrontStreamId = new EnumMap<>(QuicStreamType.class);
    private final Map<QuicStreamType, SortedMap<Long, QuicStreamChannel>> frontStreamBuffer = new EnumMap<>(
            QuicStreamType.class);

    public ProxyFrontendHandler(String remoteHost, int remotePort, SelfSignedCertificate ssc, HytaleAuthState auth) {
        this.remoteHost = remoteHost;
        this.remotePort = remotePort;
        this.ssc = ssc;
        this.auth = auth;

        nextExpectedBackStreamId.put(QuicStreamType.BIDIRECTIONAL, 1L);
        nextExpectedBackStreamId.put(QuicStreamType.UNIDIRECTIONAL, 3L);
        backStreamBuffer.put(QuicStreamType.BIDIRECTIONAL, new TreeMap<>());
        backStreamBuffer.put(QuicStreamType.UNIDIRECTIONAL, new TreeMap<>());

        nextExpectedFrontStreamId.put(QuicStreamType.BIDIRECTIONAL, 0L);
        nextExpectedFrontStreamId.put(QuicStreamType.UNIDIRECTIONAL, 2L);
        frontStreamBuffer.put(QuicStreamType.BIDIRECTIONAL, new TreeMap<>());
        frontStreamBuffer.put(QuicStreamType.UNIDIRECTIONAL, new TreeMap<>());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        log.info("Client connected. Waiting for handshake...");
    }

    private synchronized void initiateBackendConnection(ChannelHandlerContext ctx) {
        if (backendInitiated)
            return;
        backendInitiated = true;

        QuicChannel inboundChannel = (QuicChannel) ctx.channel();
        log.info("Handshake finished. Target SNI: {}", (sniHostname != null ? sniHostname : "NONE (null)"));

        // Use the same self-signed cert on both legs. The real server accepts any
        // client cert
        // (anonymous mTLS); sessions.hytale.com binds the back-side accessToken to
        // fp(ssc.cert()).
        connectBackend(ctx, inboundChannel, ssc.key(), ssc.cert());
    }

    private void connectBackend(ChannelHandlerContext ctx, QuicChannel inboundChannel,
            java.security.PrivateKey clientKey,
            java.security.cert.X509Certificate clientCert) {
        try {
            QuicSslContext clientSslContext = QuicSslContextBuilder.forClient()
                    .keyManager(clientKey, null, clientCert)
                    .trustManager(InsecureTrustManagerFactory.INSTANCE)
                    .applicationProtocols("hytale/2", "hytale/1")
                    .build();

            Bootstrap b = new Bootstrap();
            b.group(inboundChannel.eventLoop())
                    .channel(io.netty.channel.socket.nio.NioDatagramChannel.class)
                    .handler(new LoggingHandler("UDP_BACKEND_RAW", LogLevel.INFO)) // Track packets leaving toward the
                                                                                   // server
                    .handler(QuicConfig.configure(new QuicClientCodecBuilder()
                            .sslContext(clientSslContext)
                            .sslEngineProvider(q -> {
                                try {
                                    String targetSni = (sniHostname != null) ? sniHostname : remoteHost;
                                    QuicSslEngine engine = clientSslContext.newEngine(q.alloc(), targetSni, remotePort);

                                    // Only set SNI extension if we have a real hostname from the client
                                    if (sniHostname != null && !NetUtil.isValidIpV4Address(sniHostname)
                                            && !NetUtil.isValidIpV6Address(sniHostname)) {
                                        log.info("Backend TLS: Setting SNI = {}", sniHostname);
                                        SSLParameters params = engine.getSSLParameters();
                                        params.setServerNames(Collections.singletonList(new SNIHostName(sniHostname)));
                                        engine.setSSLParameters(params);
                                    } else {
                                        log.info("Backend TLS: Skipping SNI expansion (NULL or IP).");
                                    }
                                    return engine;
                                } catch (Exception e) {
                                    log.error("Backend TLS Error", e);
                                    throw new RuntimeException(e);
                                }
                            }))
                            .build());

            log.info("Bridge: Connecting to {}:{}", remoteHost, remotePort);
            b.connect(new InetSocketAddress(remoteHost, remotePort)).addListener((ChannelFutureListener) future -> {
                if (future.isSuccess()) {
                    QuicChannelBootstrap qb = QuicChannel.newBootstrap(future.channel());
                    qb.streamHandler(new ChannelInitializer<QuicStreamChannel>() {
                        @Override
                        protected void initChannel(QuicStreamChannel ch) {
                            log.info("Bridge: Server stream {} opened (type={}).", ch.streamId(), ch.type());
                            handleIncomingStream(ch, nextExpectedBackStreamId, backStreamBuffer, inboundChannel, true);
                        }
                    });

                    qb.connect().addListener(
                            (io.netty.util.concurrent.GenericFutureListener<io.netty.util.concurrent.Future<QuicChannel>>) f -> {
                                if (f.isSuccess()) {
                                    backendConnection = f.getNow();
                                    log.info("Bridge: Backend session ACTIVE (conn={}). Draining {} pending stream(s).",
                                            backendConnection, pendingClientStreams.size());
                                    drainPendingStreams();
                                    backendConnection.pipeline()
                                            .addFirst(new LoggingHandler("BACKEND_CONN", LogLevel.INFO));
                                    backendConnection.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                                        @Override
                                        public void userEventTriggered(ChannelHandlerContext c, Object evt) {
                                            if (evt instanceof SslHandshakeCompletionEvent) {
                                                SslHandshakeCompletionEvent e = (SslHandshakeCompletionEvent) evt;
                                                if (e.isSuccess()) {
                                                    log.info("Backend TLS: Handshake SUCCESS.");
                                                } else {
                                                    log.error("Backend TLS: Handshake FAILED", e.cause());
                                                }
                                            } else {
                                                log.info("Backend user event: {}", evt);
                                            }
                                            c.fireUserEventTriggered(evt);
                                        }

                                        @Override
                                        public void channelInactive(ChannelHandlerContext c) {
                                            log.warn("Backend connection INACTIVE (closed).");
                                            c.fireChannelInactive();
                                        }

                                        @Override
                                        public void exceptionCaught(ChannelHandlerContext c, Throwable cause) {
                                            log.error("Backend connection exception", cause);
                                            c.fireExceptionCaught(cause);
                                        }
                                    });
                                } else {
                                    log.error("Bridge: Backend connection failed", f.cause());
                                    ctx.close();
                                }
                            });
                } else {
                    log.error("Bridge: UDP connection failed", future.cause());
                    ctx.close();
                }
            });
        } catch (Exception e) {
            log.error("Bridge: Bootstrap failed", e);
            ctx.close();
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if (msg instanceof QuicStreamChannel) {
            QuicStreamChannel clientStream = (QuicStreamChannel) msg;
            log.info("Bridge: Game opened stream {}. pipeline={} isActive={} isRegistered={}",
                    clientStream.streamId(), clientStream.pipeline().names(),
                    clientStream.isActive(), clientStream.isRegistered());

            // Do NOT register or read() here yet — the forwarding handler
            // (ProxyBackendHandler)
            // is only added later inside linkStreams() after the backend stream is created.
            // If we read now, the first data frame would be dropped at pipeline tail before
            // the forwarder exists. linkStreams() is responsible for register + read.

            if (backendConnection != null) {
                handleIncomingStream(clientStream, nextExpectedFrontStreamId, frontStreamBuffer, backendConnection,
                        false);
            } else {
                log.warn("Bridge: Queuing client stream {} (backend not ready yet).", clientStream.id());
                pendingClientStreams.add(clientStream);
            }
        } else {
            ctx.fireChannelRead(msg);
        }
    }

    // Hytale's protocol assumes streams open in a fixed order even though QUIC
    // doesn't guarantee it.
    // Hold higher IDs until lower ones have been bridged, otherwise the client
    // errors with
    // "Packet not valid on channel".
    private synchronized void handleIncomingStream(QuicStreamChannel sourceStream,
            Map<QuicStreamType, Long> nextExpectedMap,
            Map<QuicStreamType, SortedMap<Long, QuicStreamChannel>> bufferMap,
            QuicChannel targetConn,
            boolean isServerInitiated) {
        QuicStreamType type = sourceStream.type();
        long id = sourceStream.streamId();
        long nextId = nextExpectedMap.get(type);

        if (id == nextId) {
            createTargetStream(sourceStream, targetConn, nextExpectedMap, bufferMap);
        } else if (id > nextId) {
            log.info("Bridge: Stream {} arrives ahead of {}. Buffering.", id, nextId);
            bufferMap.get(type).put(id, sourceStream);
        } else {
            // Already processed or skipped? Should not happen in strict sequential proto.
            log.info("Bridge: Stream {} already processed (expected >= {}). Link immediately.", id, nextId);
            bridgeStreamNow(sourceStream, targetConn);
        }
    }

    private void createTargetStream(QuicStreamChannel sourceStream,
            QuicChannel targetConn,
            Map<QuicStreamType, Long> nextExpectedMap,
            Map<QuicStreamType, SortedMap<Long, QuicStreamChannel>> bufferMap) {
        bridgeStreamNow(sourceStream, targetConn);

        QuicStreamType type = sourceStream.type();
        long nextId = nextExpectedMap.get(type) + 4;
        nextExpectedMap.put(type, nextId);

        SortedMap<Long, QuicStreamChannel> buffer = bufferMap.get(type);
        while (!buffer.isEmpty() && buffer.firstKey() == nextId) {
            QuicStreamChannel buffered = buffer.remove(nextId);
            log.info("Bridge: Draining buffered stream {}.", nextId);
            bridgeStreamNow(buffered, targetConn);
            nextId += 4;
            nextExpectedMap.put(type, nextId);
        }
    }

    private void bridgeStreamNow(QuicStreamChannel sourceStream, QuicChannel targetConn) {
        if (!targetConn.isActive()) {
            log.warn("Bridge: Cannot link stream {} -> target connection inactive.", sourceStream.streamId());
            return;
        }
        targetConn.createStream(sourceStream.type(), new ChannelInitializer<QuicStreamChannel>() {
            @Override
            protected void initChannel(QuicStreamChannel targetStream) {
                linkStreams(sourceStream, targetStream);
            }
        });
    }

    private void drainPendingStreams() {
        QuicStreamChannel s;
        while ((s = pendingClientStreams.poll()) != null) {
            log.info("Bridge: Bridging previously-queued client stream {}.", s.streamId());
            handleIncomingStream(s, nextExpectedFrontStreamId, frontStreamBuffer, backendConnection, false);
        }
    }

    private void linkStreams(QuicStreamChannel clientStream, QuicStreamChannel serverStream) {
        log.info("Bridge: LINKED {} <-> {}", clientStream.streamId(), serverStream.streamId());

        ProxySession session = new ProxySession(auth);
        session.setClientChannel(clientStream);
        session.setServerChannel(serverStream);

        setupStreamPipeline(clientStream, Direction.C2S, serverStream, session);
        setupStreamPipeline(serverStream, Direction.S2C, clientStream, session);

        clientStream.config().setAutoRead(true);
        serverStream.config().setAutoRead(true);
        serverStream.read();

        // Client stream arrives unregistered; register only after handlers are wired so
        // the
        // first READ event reaches the forwarder instead of falling off the pipeline
        // tail.
        if (!clientStream.isRegistered()) {
            log.info("Registering client stream {} to event loop.", clientStream.streamId());
            clientStream.eventLoop().register(clientStream).addListener(f -> {
                if (f.isSuccess()) {
                    log.info("Client stream {} registered. Triggering read.", clientStream.streamId());
                    clientStream.read();
                } else {
                    log.error("Client stream register failed", f.cause());
                }
            });
        } else {
            clientStream.read();
        }
    }

    private void setupStreamPipeline(QuicStreamChannel stream, Direction dir,
            QuicStreamChannel target, ProxySession session) {
        PacketForwarder forwarder = new PacketForwarder(target, dir);

        List<PacketHandler> handlers = new ArrayList<>();

        handlers.add(new ConnectObserver(dir));
        handlers.add(new BackAuthHandler(dir, forwarder));
        handlers.add(new FrontAuthHandler(dir));

        for (PacketHandlerFactory factory : HandlerRegistry.getFactories()) {
            try {
                handlers.add(factory.create(dir, forwarder));
            } catch (Exception e) {
                log.error("Failed to create handler from factory", e);
            }
        }

        stream.pipeline().addLast(new PacketCodec(dir));
        stream.pipeline().addLast(new PacketRouter(forwarder, session, dir, handlers));
        stream.pipeline().addLast(forwarder);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
        if (evt instanceof SniCompletionEvent) {
            this.sniHostname = ((SniCompletionEvent) evt).hostname();
            log.info("TLS Event: Captured SNI = {}", (sniHostname != null ? sniHostname : "null"));
        } else if (evt instanceof SslHandshakeCompletionEvent) {
            if (((SslHandshakeCompletionEvent) evt).isSuccess()) {
                log.info("TLS Event: Handshake SUCCESS.");
                initiateBackendConnection(ctx);
            } else {
                log.error("TLS Event: Handshake FAILED: {}", ((SslHandshakeCompletionEvent) evt).cause().getMessage());
                ctx.close();
            }
        } else if (evt instanceof QuicStreamChannel) {
            this.channelRead(ctx, evt);
        } else {
            ctx.fireUserEventTriggered(evt);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("Bridge Fatal Error: {}", cause.getMessage());
        ctx.close();
    }
}
