package meridian.internal.core;

import meridian.api.packet.Direction;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Accumulates QUIC stream bytes into {@link PacketFrame}s. Owns the accumulator buffer. */
public class PacketCodec extends ChannelInboundHandlerAdapter {
    private static final Logger log = LoggerFactory.getLogger(PacketCodec.class);
    private static final int HEADER_SIZE = 8;
    private static final int MAX_PAYLOAD = 64 * 1024 * 1024; // 64 MB sanity limit

    private final Direction direction;
    private ByteBuf acc;

    public PacketCodec(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        acc = ctx.alloc().buffer(8192);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        if (acc != null && acc.refCnt() > 0) {
            acc.release();
            acc = null;
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if (!(msg instanceof ByteBuf)) {
            ctx.fireChannelRead(msg);
            return;
        }
        ByteBuf in = (ByteBuf) msg;
        try {
            acc.writeBytes(in);
        } finally {
            in.release();
        }
        decode(ctx);
    }

    private void decode(ChannelHandlerContext ctx) {
        while (acc.readableBytes() >= HEADER_SIZE) {
            int mark = acc.readerIndex();
            int payloadLen = acc.readIntLE();
            int pktId = acc.readIntLE();

            if (payloadLen < 0 || payloadLen > MAX_PAYLOAD) {
                log.error("[{}] bogus payloadLen={} pktId={}, closing", direction, payloadLen, pktId);
                ctx.close();
                return;
            }
            if (acc.readableBytes() < payloadLen) {
                acc.readerIndex(mark);
                return;
            }

            ByteBuf payload = acc.readRetainedSlice(payloadLen);
            ctx.fireChannelRead(new PacketFrame(pktId, payload, direction));
        }
        acc.discardReadBytes();
    }
}
