package meridian.protocol;

import meridian.protocol.io.PacketIO;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import javax.annotation.Nonnull;
import java.lang.foreign.MemorySegment;

/**
 * A pre-serialized packet for efficient broadcast to multiple recipients.
 * Caches the serialized bytes once, then writes them directly for each send.
 * <p>
 * Implements AutoCloseable for use with try-with-resources to prevent leaks:
 * <p>
 * <pre><code>
 *   try (var cached = CachedPacket.cache(myPacket)) {
 *       for (var player : players) {
 *           player.getPacketHandler().write(cached);
 *       }
 *   } // automatically released
 * </code></pre>
 */
public final class CachedPacket<T extends ToClientPacket> implements ToClientPacket, AutoCloseable {
    private final Class<T> packetType;
    private final int packetId;
    private final NetworkChannel packetChannel;
    private final ByteBuf cachedBytes;

    private CachedPacket(Class<T> packetType, int packetId, NetworkChannel packetChannel, ByteBuf cachedBytes) {
        this.packetType = packetType;
        this.packetId = packetId;
        this.packetChannel = packetChannel;
        this.cachedBytes = cachedBytes;
    }

    /**
     * Create a cached version of the given packet.
     * The packet is serialized immediately and the bytes are retained.
     */
    @SuppressWarnings("unchecked")
    public static <T extends ToClientPacket> CachedPacket<T> cache(@Nonnull T packet) {
        if (packet instanceof CachedPacket<?>) {
            throw new IllegalArgumentException("Cannot cache a CachedPacket");
        }
        // Heap buffer - safe for GC if not explicitly released (used with SoftReference caching)
        var bytes = new byte[packet.computeSize()];
        packet.serialize(MemorySegment.ofArray(bytes), 0);
        ByteBuf buf = Unpooled.wrappedBuffer(bytes);
        return new CachedPacket<>((Class<T>) packet.getClass(), packet.getId(), packet.getChannel(), buf);
    }

    @Override
    public int getId() {
        return packetId;
    }

    @Override
    public NetworkChannel getChannel() {
        return packetChannel;
    }


    @Override
    public int serialize(@Nonnull MemorySegment buffer, int offset) {
        requireNotReleased();
        MemorySegment.copy(cachedBytes.array(), cachedBytes.arrayOffset(), buffer, PacketIO.PROTO_BYTE, offset, cachedBytes.readableBytes());
        return cachedBytes.readableBytes();
    }

    @Override
    public int computeSize() {
        requireNotReleased();
        return cachedBytes.readableBytes();
    }

    /**
     * Unpooled.wrappedBuffer swaps in an empty backing array on release without clearing its indices,
     * so a released buffer still reports its old length and would copy nothing.
     */
    private void requireNotReleased() {
        if (cachedBytes.refCnt() <= 0) {
            throw new IllegalStateException("CachedPacket buffer was released before serialization completed");
        }
    }

    public Class<T> getPacketType() {
        return packetType;
    }

    public int getCachedSize() {
        return cachedBytes.readableBytes();
    }

    /**
     * Release the underlying buffer. Call when the cached packet is no longer needed.
     * Can also use try-with-resources for automatic cleanup.
     */
    @Override
    public void close() {
        if (cachedBytes.refCnt() > 0) {
            cachedBytes.release();
        }
    }
}
