package meridian.internal.core;

import meridian.api.packet.Packet;
import meridian.api.session.ProxySession;
import meridian.api.session.SessionPhase;
import meridian.internal.HytaleAuthState;
import meridian.internal.Version;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.PacketStatsRecorder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/**
 * Per-stream-pair context shared by C2S and S2C handlers.
 *
 * <p>Implements the module-facing {@link ProxySession} interface and adds the
 * proxy-internal plumbing (channel wiring, auth state, typed packet sends,
 * phase advancement) that modules must not see.
 */
public class ProxySessionImpl implements ProxySession {
    private static final Logger log = LoggerFactory.getLogger(ProxySessionImpl.class);

    private final HytaleAuthState authState;
    private volatile Channel clientChannel;
    private volatile Channel serverChannel;
    private volatile SessionPhase phase = SessionPhase.PRE_AUTH;
    private final Map<Class<?>, Object> attachments = new ConcurrentHashMap<>();

    public ProxySessionImpl(HytaleAuthState authState) {
        this.authState = authState;
    }

    public void setClientChannel(Channel ch) { this.clientChannel = ch; }
    public void setServerChannel(Channel ch) { this.serverChannel = ch; }
    public HytaleAuthState authState() { return authState; }
    public SessionPhase phase() { return phase; }

    /**
     * Advance the session phase. Only moves forward — out-of-order or repeated
     * triggers (e.g. AUTH_COMPLETE arriving after WORLD_LOADED) are ignored.
     * Returns true if the phase actually changed.
     */
    public boolean advancePhase(SessionPhase next) {
        if (next.ordinal() > phase.ordinal()) {
            phase = next;
            return true;
        }
        return false;
    }
    
    /** Internal access for pipeline assembly / emergency close. Normal handlers should not use these. */
    Channel clientChannelRaw() { return clientChannel; }
    Channel serverChannelRaw() { return serverChannel; }

    /** Closes both client and server channels asynchronously. */
    public void disconnect() {
        if (clientChannel != null && clientChannel.isActive()) {
            clientChannel.eventLoop().execute(clientChannel::close);
        }
        if (serverChannel != null && serverChannel.isActive()) {
            serverChannel.eventLoop().execute(serverChannel::close);
        }
    }

    public void flushS2CBuffering() {
        if (serverChannel != null && serverChannel.isActive()) {
            serverChannel.eventLoop().execute(() -> {
                serverChannel.pipeline().fireUserEventTriggered(new PacketForwarder.FlushBufferingEvent());
            });
        }
    }

    public void sendToClient(int pktId, int bodySize, PacketForwarder.PacketSerializer serializer) {
        Channel ch = clientChannel;
        if (ch == null || !ch.isActive()) {
            log.warn("sendToClient(pkt {}) failed — client channel not available", pktId);
            return;
        }
        ByteBuf framed = PacketForwarder.serializeFramed(pktId, bodySize, serializer);
        ch.eventLoop().execute(() -> ch.writeAndFlush(framed));
    }

    public void sendToServer(int pktId, int bodySize, PacketForwarder.PacketSerializer serializer) {
        Channel ch = serverChannel;
        if (ch == null || !ch.isActive()) {
            log.warn("sendToServer(pkt {}) failed — server channel not available", pktId);
            return;
        }
        ByteBuf framed = PacketForwarder.serializeFramed(pktId, bodySize, serializer);
        ch.eventLoop().execute(() -> ch.writeAndFlush(framed));
    }

    /** Pre-framed [len|id|payload] write to client. */
    public void sendRawToClient(ByteBuf framed) {
        Channel ch = clientChannel;
        if (ch == null || !ch.isActive()) {
            log.warn("sendRawToClient failed — client channel not available");
            if (framed.refCnt() > 0) framed.release();
            return;
        }
        ch.eventLoop().execute(() -> ch.writeAndFlush(framed));
    }

    /** Pre-framed [len|id|payload] write to server. */
    public void sendRawToServer(ByteBuf framed) {
        Channel ch = serverChannel;
        if (ch == null || !ch.isActive()) {
            log.warn("sendRawToServer failed — server channel not available");
            if (framed.refCnt() > 0) framed.release();
            return;
        }
        ch.eventLoop().execute(() -> ch.writeAndFlush(framed));
    }

    @SuppressWarnings("unchecked")
    public <T> T getAttachment(Class<T> type) {
        return (T) attachments.get(type);
    }

    public <T> void setAttachment(Class<T> type, T value) {
        attachments.put(type, value);
    }

    // ------------------------------------------------------------------
    // High-level send (api) — frames + compresses, bypasses the handler chain
    // ------------------------------------------------------------------

    @Override
    public void sendToClient(Packet packet) {
        ByteBuf framed = frame(packet);
        if (framed != null) sendRawToClient(framed);
    }

    @Override
    public void sendToServer(Packet packet) {
        ByteBuf framed = frame(packet);
        if (framed != null) sendRawToServer(framed);
    }

    /** Serialises a packet into a fresh framed buffer, or null on failure. */
    private ByteBuf frame(Packet packet) {
        if (!(packet instanceof meridian.protocol.Packet p)) {
            log.warn("sendTo*: {} is not a protocol packet — ignored", packet);
            return null;
        }
        ByteBuf out = Unpooled.buffer();
        try {
            PacketIO.writeFramedPacket(p, p.getClass(), out, out.alloc(), PacketStatsRecorder.NOOP);
            return out;
        } catch (Exception e) {
            log.error("sendTo*: failed to serialise {}: {}", p.getClass().getSimpleName(), e.toString());
            out.release();
            return null;
        }
    }

    // ------------------------------------------------------------------
    // Request/response over the S2C stream
    // ------------------------------------------------------------------

    private static final class PendingAwait {
        final Class<?> type;
        final Predicate<Object> matcher;
        final CompletableFuture<Object> future;

        PendingAwait(Class<?> type, Predicate<Object> matcher, CompletableFuture<Object> future) {
            this.type = type;
            this.matcher = matcher;
            this.future = future;
        }
    }

    private final List<PendingAwait> pendingAwaits = new CopyOnWriteArrayList<>();

    @Override
    public <R extends Packet> CompletableFuture<R> sendAndAwait(
            Packet request, Class<R> responseType, Predicate<R> matcher, Duration timeout) {
        CompletableFuture<R> future = new CompletableFuture<>();
        @SuppressWarnings("unchecked")
        PendingAwait pending = new PendingAwait(
                responseType,
                (Predicate<Object>) (Predicate<?>) matcher,
                (CompletableFuture<Object>) (CompletableFuture<?>) future);
        pendingAwaits.add(pending);
        future.whenComplete((r, e) -> pendingAwaits.remove(pending));
        future.orTimeout(timeout.toMillis(), TimeUnit.MILLISECONDS);
        sendToServer(request);
        return future;
    }

    /**
     * Offers an observed S2C packet to outstanding {@link #sendAndAwait} calls.
     * Invoked by the router on the server-to-client path.
     */
    public void tryCompleteAwaits(Packet packet) {
        if (pendingAwaits.isEmpty()) return;
        for (PendingAwait pending : pendingAwaits) {
            if (!pending.type.isInstance(packet)) continue;
            try {
                if (pending.matcher.test(packet)) {
                    pending.future.complete(packet);
                }
            } catch (Exception e) {
                log.error("sendAndAwait matcher threw: {}", e.toString());
            }
        }
    }

    // ------------------------------------------------------------------
    // Protocol-staleness signal
    // ------------------------------------------------------------------

    private static final int STALE_DESER_THRESHOLD = 25;
    private final AtomicInteger deserFailures = new AtomicInteger();
    private volatile boolean staleWarned = false;

    /**
     * Records a failed deserialization of a <em>known</em> packet. A burst of
     * these is the real evidence that meridian-protocol is out of date for this
     * Hytale build — unlike a CRC mismatch, which changes on every harmless
     * update. Warns once, when the count crosses the threshold.
     */
    public void recordDeserFailure() {
        int n = deserFailures.incrementAndGet();
        if (n == STALE_DESER_THRESHOLD && !staleWarned) {
            staleWarned = true;
            log.warn("{} known packets failed to parse this session — meridian-protocol is "
                            + "likely out of date for this Hytale build. Update the proxy: {}",
                    n, Version.RELEASES_URL);
        }
    }
}
