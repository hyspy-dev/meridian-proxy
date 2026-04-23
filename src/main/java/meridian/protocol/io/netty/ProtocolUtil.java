package meridian.protocol.io.netty;

import meridian.protocol.NetworkChannel;
import meridian.protocol.packets.connection.QuicApplicationErrorCode;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.AttributeKey;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import javax.annotation.Nonnull;

/**
 * Utility class for Hytale network protocol.
 * Modified to remove absolute QUIC dependencies for compatibility with official Netty Maven artifacts.
 */
public final class ProtocolUtil {
    public static final AttributeKey<NetworkChannel> STREAM_CHANNEL_KEY = AttributeKey.newInstance("STREAM_CHANNEL_ID");
    public static final AttributeKey<Duration> PACKET_TIMEOUT_KEY = AttributeKey.newInstance("PACKET_TIMEOUT");
    public static final ChannelFutureListener CLOSE_ON_COMPLETE = ProtocolUtil::closeApplicationOnComplete;

    private ProtocolUtil() {
    }

    public static void closeConnection(@Nonnull Channel channel) {
        channel.close();
    }

    // Stubbed out for compatibility
    public static void closeApplicationConnection(@Nonnull Channel channel) {
        channel.close();
    }

    public static void closeApplicationConnection(@Nonnull Channel channel, @Nonnull QuicApplicationErrorCode errorCode) {
        channel.close();
    }

    public static void closeApplicationConnection(@Nonnull Channel channel, @Nonnull QuicApplicationErrorCode errorCode, @Nonnull String reason) {
        channel.close();
    }

    private static void closeApplicationOnComplete(ChannelFuture future) {
        future.channel().close();
    }
}
