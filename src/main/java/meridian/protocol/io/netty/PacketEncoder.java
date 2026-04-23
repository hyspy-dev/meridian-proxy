/*
 * Decompiled with CFR 0.152.
 */
package meridian.protocol.io.netty;

import meridian.protocol.CachedPacket;
import meridian.protocol.NetworkChannel;
import meridian.protocol.Packet;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.PacketStatsRecorder;
import meridian.protocol.io.netty.ProtocolUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import javax.annotation.Nonnull;

@ChannelHandler.Sharable
public class PacketEncoder
extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(@Nonnull ChannelHandlerContext ctx, @Nonnull Packet packet, @Nonnull ByteBuf out) {
        Class<? extends Packet> packetClass;
        if (packet instanceof CachedPacket) {
            CachedPacket cached = (CachedPacket)packet;
            packetClass = cached.getPacketType();
        } else {
            packetClass = packet.getClass();
        }
        NetworkChannel channelAttr = ctx.channel().attr(ProtocolUtil.STREAM_CHANNEL_KEY).get();
        if (channelAttr != null && channelAttr != packet.getChannel()) {
            throw new IllegalArgumentException("Packet channel " + String.valueOf((Object)packet.getChannel()) + " does not match stream channel " + String.valueOf((Object)channelAttr));
        }
        PacketStatsRecorder statsRecorder = ctx.channel().attr(PacketStatsRecorder.CHANNEL_KEY).get();
        if (statsRecorder == null) {
            statsRecorder = PacketStatsRecorder.NOOP;
        }
        PacketIO.writeFramedPacket(packet, packetClass, out, statsRecorder);
    }
}

