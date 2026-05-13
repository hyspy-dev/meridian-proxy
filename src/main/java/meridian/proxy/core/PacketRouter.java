package meridian.proxy.core;

import meridian.protocol.Packet;
import meridian.protocol.PacketRegistry;
import meridian.proxy.handler.PacketHandler;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.PacketStatsRecorder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Runs each {@link PacketFrame} through the registered {@link PacketHandler} chain.
 * Performs automatic deserialization using {@link PacketRegistry}.
 */
public class PacketRouter extends ChannelInboundHandlerAdapter {
    private static final Logger log = LoggerFactory.getLogger(PacketRouter.class);

    private final List<PacketHandler> handlers;
    private final PacketForwarder forwarder;
    private final ProxySession session;
    private final Direction direction;

    public PacketRouter(PacketForwarder forwarder, ProxySession session,
                        Direction direction, List<PacketHandler> handlers) {
        this.forwarder = forwarder;
        this.session = session;
        this.direction = direction;
        this.handlers = Collections.unmodifiableList(new ArrayList<>(handlers));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        for (PacketHandler h : handlers) {
            h.onStreamActive(ctx, session);
        }
        ctx.fireChannelActive();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        for (PacketHandler h : handlers) {
            h.onStreamInactive(ctx, session);
        }
        ctx.fireChannelInactive();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if (!(msg instanceof PacketFrame frame)) {
            ctx.fireChannelRead(msg);
            return;
        }

        try {
            Packet packet = tryDeserialize(frame);
            boolean modified = false;
            if (packet != null) {
                for (PacketHandler handler : handlers) {
                    PacketHandler.Action action = (direction == Direction.C2S)
                            ? handler.handleC2S(ctx, packet, session)
                            : handler.handleS2C(ctx, packet, session);

                    if (action == PacketHandler.Action.DROP) return;
                    if (action == PacketHandler.Action.HANDLED) return;
                    if (action == PacketHandler.Action.MODIFIED) modified = true;
                }
            }

            if (modified) {
                ByteBuf reframed = reserialize(packet, frame);
                if (reframed != null) {
                    forwarder.forward(reframed);
                    return;
                }
                // Fallback: re-serialisation failed, ship the original bytes.
            }

            // Either deserialization failed, no handler mutated the packet,
            // or re-serialisation failed — forward the original frame.
            forwarder.forward(frame.reframe());
        } catch (Exception e) {
            log.error("Error in PacketRouter pipeline", e);
            forwarder.forward(frame.reframe());
        } finally {
            if (frame.payload().refCnt() > 0) frame.payload().release();
        }
    }

    private ByteBuf reserialize(Packet packet, PacketFrame frame) {
        PacketRegistry.PacketInfo info = (direction == Direction.C2S)
                ? PacketRegistry.getToServerPacketById(frame.packetId())
                : PacketRegistry.getToClientPacketById(frame.packetId());
        if (info == null) {
            log.warn("Cannot re-serialise packet {}: no PacketInfo", frame.packetId());
            return null;
        }
        ByteBuf out = Unpooled.buffer(8 + Math.min(info.maxSize(), 1024));
        try {
            PacketIO.writeFramedPacketWithInfo(packet, info, out, out.alloc(), PacketStatsRecorder.NOOP);
            return out;
        } catch (Exception e) {
            log.error("Re-serialisation of {} failed: {}", info.name(), e.toString());
            out.release();
            return null;
        }
    }

    private Packet tryDeserialize(PacketFrame frame) {
        PacketRegistry.PacketInfo info = (direction == Direction.C2S)
                ? PacketRegistry.getToServerPacketById(frame.packetId())
                : PacketRegistry.getToClientPacketById(frame.packetId());

        if (info == null) {
            // Unknown packet ID — typical for new Hytale versions or custom obfuscation
            return null;
        }

        try {
            ByteBuf payload = frame.payload();
            payload.markReaderIndex();
            Packet packet;
            if (info.compressed()) {
                packet = PacketIO.readFramedPacketWithInfo(payload, payload.readableBytes(), payload.alloc(), info, PacketStatsRecorder.NOOP);
            } else {
                packet = info.deserialize().deserialize(payload, payload.readerIndex());
            }
            payload.resetReaderIndex();
            return packet;
        } catch (Exception e) {
            log.warn("Failed to deserialize packet {} ({}): {}", frame.packetId(), info.name(), e.toString());
            frame.payload().resetReaderIndex();
            return null;
        }
    }
}

