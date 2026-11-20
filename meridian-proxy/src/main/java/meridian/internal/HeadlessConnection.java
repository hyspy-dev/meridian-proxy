package meridian.internal;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.handler.ssl.util.SelfSignedCertificate;
import io.netty.incubator.codec.quic.QuicChannel;
import io.netty.incubator.codec.quic.QuicClientCodecBuilder;
import io.netty.incubator.codec.quic.QuicSslContext;
import io.netty.incubator.codec.quic.QuicSslContextBuilder;
import io.netty.incubator.codec.quic.QuicStreamChannel;
import io.netty.incubator.codec.quic.QuicStreamType;
import io.netty.util.ReferenceCountUtil;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import meridian.api.packet.Direction;
import meridian.api.packet.PacketHandler;
import meridian.api.packet.PacketHandlerFactory;
import meridian.api.session.HeadlessClient;
import meridian.internal.control.LiveConnections;
import meridian.internal.core.PacketCodec;
import meridian.internal.core.PacketForwarder;
import meridian.internal.core.PacketRouter;
import meridian.internal.core.ProxyConfig;
import meridian.internal.core.ProxySessionImpl;
import meridian.internal.core.QuicConfig;
import meridian.internal.handler.BackAuthHandler;
import meridian.internal.handler.ConnectObserver;
import meridian.internal.handler.FrontAuthHandler;
import meridian.internal.handler.PhaseTracker;
import meridian.internal.handler.ServerAccessLogger;
import meridian.internal.module.ModuleManager;
import meridian.protocol.packets.connection.ClientType;
import meridian.protocol.PacketRegistry;
import meridian.protocol.ProtocolSettings;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.PacketStatsRecorder;
import meridian.protocol.packets.connection.Connect;
import meridian.protocol.packets.connection.InsecurePlayerOptions;
import meridian.protocol.packets.connection.RequestInsecurePlayerOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A connection to a server with no game behind it: the proxy plays the client.
 *
 * <p>It is the server leg of an ordinary connection - its own QUIC connection and certificate,
 * the same handler chain, the module runtime loaded for it - with a stand-in where the client
 * would be. That stand-in is a channel with no socket: what the server sends ends there after
 * passing every handler, and what the client "sends" ({@link HeadlessClient#sendAsClient}) enters
 * the client-to-server chain there, so modules and core see it as the client's own.
 *
 * <p>The proxy does the handshake: {@code Connect}, then authentication - the player's tokens on
 * an authenticated server, a name and a made-up account on an insecure one. Everything after that
 * a client says is game behaviour, answered by whoever handles {@link meridian.api.session.ProxySession#headless}
 * sessions (core).
 *
 * <p>It is the client side of a {@link ConnectionScope} like the game's ({@link GameFront}): the
 * scope loads the server's modules, tells the window, disconnects and tears down - the same for a
 * connection with no game as for one with it ({@link #open}).
 */
public final class HeadlessConnection implements Front {

    private static final Logger log = LoggerFactory.getLogger(HeadlessConnection.class);

    /** The module set a headless connection runs: {@code <jar>/headless/modules}. */
    public static final String SCOPE = "headless";

    private static final NioEventLoopGroup GROUP = new NioEventLoopGroup(1, r -> {
        Thread t = new Thread(r, "Headless");
        t.setDaemon(true);
        return t;
    });

    /** How the client proves who it is. */
    public enum Auth {
        /** A server started with {@code --auth-mode insecure}: any name, no tokens. */
        INSECURE,
        /** An ordinary server: the player's own session and identity tokens. */
        AUTHENTICATED
    }

    private final String host;
    private final int port;
    private final String username;
    private final UUID uuid;
    private final Auth auth;
    private final String identityToken;
    private final String playerSession;
    private volatile HytaleAuthState authState;
    private volatile ModuleManager modules;

    private volatile QuicChannel quic;
    private volatile LiveConnections.Live live;
    /** The stand-in client end of the Default stream; packets the client sends enter here. */
    private volatile EmbeddedChannel clientEnd;
    private final HeadlessClient client = new Client();

    HeadlessConnection(String host, int port, String username, Auth auth, String playerSession,
                       String identityToken) {
        this.host = host;
        this.port = port;
        // On an authenticated server the player is whoever the identity token says.
        String[] who = auth == Auth.AUTHENTICATED ? claims(identityToken) : null;
        this.username = who != null && who[0] != null ? who[0] : username;
        this.uuid = who != null && who[1] != null ? UUID.fromString(who[1])
                : UUID.nameUUIDFromBytes(("MeridianHeadless:" + username).getBytes(StandardCharsets.UTF_8));
        this.auth = auth;
        this.identityToken = identityToken;
        this.playerSession = playerSession;
    }

    /**
     * A connection to {@code host:port} with no game, as {@code username}: a {@link ConnectionScope}
     * whose client side the proxy plays, run on a thread of its own. Its modules are the server's
     * own folder's for a player's own account (as the game's connection there), {@code <jar>/headless/modules}
     * for an insecure test bot. The scope's {@link ConnectionScope#started} completes once the bot is
     * in; {@link ConnectionScope#requestDisconnect} ends it.
     *
     * @param playerSession the player's session token (authenticated servers), else {@code null}
     * @param windowed      the window shows it (its modules in the panel, its Connected bar)
     */
    public static ConnectionScope open(String host, int port, String username, Auth auth,
                                                          String playerSession, String identityToken,
                                                          boolean windowed) {
        HeadlessConnection front = new HeadlessConnection(host, port, username, auth, playerSession, identityToken);
        ProxyConfig config = ProxyConfig.forHeadless(host, port, playerSession, identityToken,
                auth == Auth.AUTHENTICATED ? null : SCOPE);
        // A failure comes back through started() (the window says it once); not as a bind error.
        ConnectionScope scope = new ConnectionScope(config, false, front, windowed);
        Thread t = new Thread(() -> {
            try {
                scope.run();
            } catch (Exception e) {
                log.warn("Headless {}: {}", username, e.toString());
            }
        }, "Headless-" + username);
        t.setDaemon(true);
        t.start();
        return scope;
    }

    /** Run when the connection closes - whoever keeps a list of the bots takes it off. */
    public void whenClosed(Runnable r) {
        closedHooks.add(r);
    }

    private final java.util.List<Runnable> closedHooks = new java.util.concurrent.CopyOnWriteArrayList<>();

    /** {@code username} and {@code sub} of a JWT, unverified; {@code null} when it is not one. */
    private static String[] claims(String jwt) {
        if (jwt == null) {
            return null;
        }
        String[] parts = jwt.split("[.]");
        if (parts.length < 2) {
            return null;
        }
        try {
            com.google.gson.JsonObject o = com.google.gson.JsonParser.parseString(new String(
                    Base64.getUrlDecoder().decode(parts[1]), StandardCharsets.UTF_8)).getAsJsonObject();
            return new String[] {
                    o.has("username") ? o.get("username").getAsString() : null,
                    o.has("sub") ? o.get("sub").getAsString() : null};
        } catch (RuntimeException e) {
            return null;
        }
    }

    /** The modules this connection runs - the window's module panel shows them while it lives. */
    public ModuleManager modules() {
        return modules;
    }

    public int id() {
        LiveConnections.Live l = live;
        return l == null ? -1 : l.id();
    }

    public String describe() {
        return username + " -> " + host + ":" + port + " (" + auth.name().toLowerCase() + ")";
    }

    /** Leaves the server. */
    @Override
    public void close() {
        QuicChannel q = quic;
        if (q != null) {
            q.close();
        }
    }

    @Override
    public io.netty.channel.Channel start(ConnectionScope scope, ModuleManager modules) throws Exception {
        this.modules = modules;
        SelfSignedCertificate cert = new SelfSignedCertificate("localhost");
        byte[] sha256 = MessageDigest.getInstance("SHA-256").digest(cert.cert().getEncoded());
        String fp = Base64.getUrlEncoder().withoutPadding().encodeToString(sha256);
        // Only the server leg exists, so only its tokens matter; the front ones stay empty.
        authState = new HytaleAuthState(fp, fp, null,
                new HytaleSessionApi(playerSession != null ? playerSession : ""), new HytaleSessionApi(""));
        CompletableFuture<HeadlessConnection> done = new CompletableFuture<>();
        open(cert, done);
        try {
            done.get(60, java.util.concurrent.TimeUnit.SECONDS);
        } catch (java.util.concurrent.ExecutionException e) {
            throw e.getCause() instanceof Exception ex ? ex : e;
        }
        return quic;
    }

    @Override
    public String how() {
        return "(no game - the proxy plays as " + username + ")";
    }

    // ------------------------------------------------------------------

    private void open(SelfSignedCertificate cert, CompletableFuture<HeadlessConnection> done) throws Exception {
        QuicSslContext ssl = QuicSslContextBuilder.forClient()
                .keyManager(cert.key(), null, cert.cert())
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .applicationProtocols(HytaleAlpn.CURRENT, HytaleAlpn.PREVIOUS)
                .build();
        Bootstrap b = new Bootstrap();
        b.group(GROUP)
                .channel(io.netty.channel.socket.nio.NioDatagramChannel.class)
                .option(ChannelOption.SO_RCVBUF, 8 * 1024 * 1024)
                .option(ChannelOption.SO_SNDBUF, 4 * 1024 * 1024)
                .handler(QuicConfig.configure(new QuicClientCodecBuilder()
                        .sslContext(ssl)
                        .sslEngineProvider(q -> ssl.newEngine(q.alloc(), host, port)))
                        .build());
        b.connect(new InetSocketAddress(host, port)).addListener(f -> {
            if (!f.isSuccess()) {
                done.completeExceptionally(f.cause());
                return;
            }
            QuicChannel.newBootstrap(((io.netty.channel.ChannelFuture) f).channel())
                    .streamHandler(new ChannelInitializer<QuicStreamChannel>() {
                        @Override
                        protected void initChannel(QuicStreamChannel serverStream) {
                            // The chunk and world-map streams the server opens once we are in.
                            log.info("Headless {}: server opened stream {}", username, serverStream.streamId());
                            link(serverStream, false);
                        }
                    })
                    .connect()
                    .addListener(qf -> {
                        if (!qf.isSuccess()) {
                            done.completeExceptionally(qf.cause());
                            return;
                        }
                        QuicChannel q = (QuicChannel) qf.getNow();
                        quic = q;
                        live = LiveConnections.opened(host + ":" + port + " (headless " + username + ")", -1);
                        live.commands(modules.commandRegistry());
                        q.closeFuture().addListener(c -> closed());
                        log.info("Headless {}: connected to {}:{}", username, host, port);
                        q.createStream(QuicStreamType.BIDIRECTIONAL, new ChannelInitializer<QuicStreamChannel>() {
                            @Override
                            protected void initChannel(QuicStreamChannel serverStream) {
                                link(serverStream, true);
                            }
                        }).addListener(sf -> {
                            if (sf.isSuccess()) {
                                sayConnect();
                                done.complete(this);
                            } else {
                                done.completeExceptionally(sf.cause());
                                q.close();
                            }
                        });
                    });
        });
    }

    /**
     * Wires a stream the way an ordinary connection does, with the stand-in client at the far end.
     * {@code ours} is the Default stream we opened; on it the client's packets enter.
     */
    private void link(QuicStreamChannel serverStream, boolean ours) {
        EmbeddedChannel end = new EmbeddedChannel(new Sink());
        ProxySessionImpl session = new ProxySessionImpl(authState);
        session.setClientChannel(end);
        session.setServerChannel(serverStream);
        session.setHeadless(client);
        LiveConnections.streamLinked(live, session);

        PacketForwarder toServer = new PacketForwarder(serverStream, Direction.C2S);
        end.pipeline().addLast(new PacketCodec(Direction.C2S));
        end.pipeline().addLast(new PacketRouter(toServer, session, Direction.C2S,
                handlers(Direction.C2S, session, toServer), modules.eventBus()));
        end.pipeline().addLast(toServer);
        end.pipeline().fireChannelActive();

        PacketForwarder toClient = new PacketForwarder(end, Direction.S2C);
        serverStream.pipeline().addLast(new PacketCodec(Direction.S2C));
        serverStream.pipeline().addLast(new PacketRouter(toClient, session, Direction.S2C,
                handlers(Direction.S2C, session, toClient), modules.eventBus()));
        serverStream.pipeline().addLast(toClient);
        serverStream.config().setAutoRead(true);
        serverStream.read();
        if (ours) {
            clientEnd = end;
        }
    }

    private List<PacketHandler> handlers(Direction dir, ProxySessionImpl session, PacketForwarder forwarder) {
        List<PacketHandler> out = new ArrayList<>();
        out.add(new ConnectObserver(dir));
        out.add(new BackAuthHandler(dir, forwarder));
        out.add(new FrontAuthHandler(dir));
        out.add(new Handshake());
        out.add(new ServerAccessLogger(dir));
        out.add(new PhaseTracker(dir, modules.eventBus()));
        for (PacketHandlerFactory factory : modules.handlerRegistry().factoriesFor(dir)) {
            try {
                out.add(factory.create(dir, session));
            } catch (Exception e) {
                log.error("Headless: a module's handler failed to build", e);
            }
        }
        return out;
    }

    /** The first thing a client says. */
    private void sayConnect() {
        Connect c = new Connect();
        c.protocolCrc = ProtocolSettings.PROTOCOL_CRC;
        c.protocolBuildNumber = ProtocolSettings.PROTOCOL_BUILD_NUMBER;
        c.clientVersion = "meridian-headless";
        c.clientType = ClientType.Game;
        c.identityToken = auth == Auth.AUTHENTICATED ? identityToken : null;
        c.language = "en-US";
        authState.setClientIdentityToken(c.identityToken);
        client.sendAsClient(c);
        log.info("Headless {}: Connect sent ({} build {})", username, auth, ProtocolSettings.PROTOCOL_BUILD_NUMBER);
    }

    private void closed() {
        log.info("Headless {}: connection closed", username);
        LiveConnections.closed(live);
        EmbeddedChannel end = clientEnd;
        if (end != null) {
            end.finishAndReleaseAll();
        }
        // The scope, woken by the channel's close, unloads the modules and tells the window.
        for (Runnable r : closedHooks) {
            try {
                r.run();
            } catch (RuntimeException e) {
                log.warn("Headless: a close hook failed: {}", e.toString());
            }
        }
    }

    // ------------------------------------------------------------------

    /** The client's part, as modules see it. */
    private final class Client implements HeadlessClient {
        @Override
        public String username() {
            return username;
        }

        @Override
        public UUID uuid() {
            return uuid;
        }

        @Override
        public void sendAsClient(meridian.api.packet.Packet packet) {
            if (!(packet instanceof meridian.protocol.Packet p)) {
                log.warn("Headless: {} is not a protocol packet", packet);
                return;
            }
            Integer id = PacketRegistry.getId(p.getClass());
            PacketRegistry.PacketInfo info = id == null ? null : PacketRegistry.getToServerPacketById(id);
            if (info == null) {
                log.warn("Headless: {} is not a client-to-server packet", p.getClass().getSimpleName());
                return;
            }
            ByteBuf framed = Unpooled.buffer();
            try {
                PacketIO.writeFramedPacketWithInfo(p, info, framed, framed.alloc(), PacketStatsRecorder.NOOP);
            } catch (Exception e) {
                framed.release();
                log.warn("Headless: could not write {}: {}", info.name(), e.toString());
                return;
            }
            EmbeddedChannel end = clientEnd;
            QuicChannel q = quic;
            if (end == null || q == null) {
                framed.release();
                log.warn("Headless: {} before the connection is up - dropped", info.name());
                return;
            }
            // Through the client-to-server chain on the connection's own thread, like a real packet.
            EventLoop loop = q.eventLoop();
            loop.execute(() -> end.writeInbound(framed));
        }
    }

    /** Where the server's packets end: there is no game to show them to. */
    private static final class Sink extends ChannelOutboundHandlerAdapter {
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) {
            ReferenceCountUtil.release(msg);
            promise.setSuccess();
        }

        @Override
        public void flush(ChannelHandlerContext ctx) {
            // nothing buffered
        }
    }

    /** The client's part of the handshake the proxy owns: who it is, on an insecure server. */
    private final class Handshake implements PacketHandler {
        @Override
        public Action handleS2C(ChannelHandlerContext ctx, meridian.api.packet.Packet packet,
                                meridian.api.session.ProxySession session) {
            if (packet instanceof RequestInsecurePlayerOptions) {
                InsecurePlayerOptions o = new InsecurePlayerOptions();
                o.uuid = uuid;
                o.username = username;
                client.sendAsClient(o);
                log.info("Headless {}: insecure server - identified as {} ({})", username, username, uuid);
                return Action.HANDLED;
            }
            return Action.FORWARD;
        }
    }
}
