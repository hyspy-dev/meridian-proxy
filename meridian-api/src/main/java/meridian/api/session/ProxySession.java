package meridian.api.session;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import io.netty.buffer.ByteBuf;
import meridian.api.packet.Packet;

/**
 * Per-stream-pair context visible to modules.
 *
 * <p>This is the protocol-neutral, module-facing surface. The proxy's internal
 * implementation carries additional plumbing (channel wiring, auth state) that
 * is deliberately not exposed here.
 */
public interface ProxySession {

    /** Current lifecycle phase of this session. */
    SessionPhase phase();

    /** Closes both client and server channels asynchronously. */
    void disconnect();

    /**
     * High-level send to the client: frames and (where applicable) Zstd-compresses
     * {@code packet}, then writes it. <strong>Bypasses the handler chain</strong> —
     * Layer-1 trackers will not observe an injected packet as server truth.
     */
    void sendToClient(Packet packet);

    /** High-level send to the server. Bypasses the handler chain — see {@link #sendToClient}. */
    void sendToServer(Packet packet);

    /**
     * Sends {@code request} to the server and completes with the first
     * server-to-client packet of type {@code responseType} that satisfies
     * {@code matcher}, or fails with a timeout.
     *
     * @param request      packet sent to the server
     * @param responseType expected response packet type
     * @param matcher      predicate selecting the matching response
     * @param timeout      how long to wait before failing the future
     */
    <R extends Packet> CompletableFuture<R> sendAndAwait(
            Packet request, Class<R> responseType, Predicate<R> matcher, Duration timeout);

    /** Pre-framed {@code [len|id|payload]} write to the client. */
    void sendRawToClient(ByteBuf framed);

    /** Pre-framed {@code [len|id|payload]} write to the server. */
    void sendRawToServer(ByteBuf framed);

    /** Module-scoped state attached to this session, keyed by type. */
    <T> T getAttachment(Class<T> type);

    <T> void setAttachment(Class<T> type, T value);
}
