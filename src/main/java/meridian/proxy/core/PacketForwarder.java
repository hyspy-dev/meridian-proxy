package meridian.proxy.core;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * Last handler in the pipeline. Writes framed packets to the target channel,
 * polls for target readiness, queues pending writes, and gates the S2C side
 * during the auth handshake (controlled via {@link #setBuffering} +
 * {@link FlushBufferingEvent}).
 */
public class PacketForwarder extends ChannelInboundHandlerAdapter {
    private static final Logger log = LoggerFactory.getLogger(PacketForwarder.class);

    /** Fired by the C2S AuthHandler into the S2C pipeline once Pkt 13 has been sent. */
    public static class FlushBufferingEvent {}

    private final Channel target;
    private final Direction direction;
    private final Queue<ByteBuf> pendingForward = new ArrayDeque<>();
    private volatile boolean targetActive;
    private volatile boolean buffering = false;

    public PacketForwarder(Channel target, Direction direction) {
        this.target = target;
        this.direction = direction;
        this.targetActive = target.isActive();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        log.debug("[{}] forwarder active", direction);
        ctx.read();
        if (!targetActive) {
            pollTarget(ctx);
        } else {
            flush();
        }
    }

    public void forward(ByteBuf framed) {
        if (!targetActive || (direction == Direction.S2C && buffering)) {
            pendingForward.add(framed);
            return;
        }
        target.writeAndFlush(framed).addListener(writeListener("forward"));
    }

    /** Bypasses queue and buffering. For self-constructed packets (e.g. pkt 12 to server). */
    public void forwardDirect(ByteBuf framed) {
        target.writeAndFlush(framed).addListener(writeListener("forward-direct"));
    }

    public void setBuffering(boolean buffering) { this.buffering = buffering; }
    public boolean isBuffering() { return buffering; }
    public Channel target() { return target; }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof FlushBufferingEvent) {
            log.info("[{}] FlushBufferingEvent: flushing {} buffered packets", direction, pendingForward.size());
            this.buffering = false;
            flush();
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        while (!pendingForward.isEmpty()) pendingForward.poll().release();
        if (target.isActive()) target.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("[{}] forwarder error", direction, cause);
        ctx.close();
        target.close();
    }

    // --- internals ---

    private void flush() {
        ByteBuf m;
        while ((m = pendingForward.poll()) != null) {
            target.writeAndFlush(m).addListener(writeListener("flush"));
        }
    }

    private void pollTarget(ChannelHandlerContext ctx) {
        if (targetActive) return;
        if (target.isActive()) {
            log.debug("[{}] target became active", direction);
            targetActive = true;
            flush();
        } else {
            target.eventLoop().schedule(() -> pollTarget(ctx), 10, TimeUnit.MILLISECONDS);
        }
    }

    private ChannelFutureListener writeListener(String label) {
        return f -> {
            if (!f.isSuccess()) {
                log.error("[{}] {} write failed: {}", direction, label, f.cause().toString());
            }
        };
    }

    /** Serialize into a fresh framed ByteBuf [len|id|body]. Caller releases. */
    public static ByteBuf serializeFramed(int pktId, int bodySize, PacketSerializer serializer) {
        ByteBuf body = Unpooled.buffer(bodySize);
        serializer.serialize(body);
        int len = body.readableBytes();
        ByteBuf out = Unpooled.buffer(8 + len);
        out.writeIntLE(len);
        out.writeIntLE(pktId);
        out.writeBytes(body);
        body.release();
        return out;
    }

    @FunctionalInterface
    public interface PacketSerializer {
        void serialize(ByteBuf buf);
    }
}
