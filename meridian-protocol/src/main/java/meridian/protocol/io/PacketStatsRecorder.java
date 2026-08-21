package meridian.protocol.io;

import io.netty.util.AttributeKey;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Interface for recording packet statistics at the wire level.
 * Called by PacketIO during frame read/write to capture both
 * uncompressed (serialized) and compressed (wire) sizes.
 */
public interface PacketStatsRecorder {

    /** Channel attribute key for accessing the recorder from encoder/decoder. */
    AttributeKey<PacketStatsRecorder> CHANNEL_KEY = AttributeKey.valueOf("PacketStatsRecorder");

    /** No-op implementation for when stats recording is not needed. */
    PacketStatsRecorder NOOP = new NoopPacketStatsRecorder();

    /**
     * Record statistics for an outbound packet.
     *
     * @param packetId         the packet ID
     * @param uncompressedSize the serialized size before compression
     * @param compressedSize   the wire size after compression (same as uncompressed if not compressed)
     */
    void recordSend(int packetId, int uncompressedSize, int compressedSize);

    /**
     * Record statistics for an inbound packet.
     *
     * @param packetId         the packet ID
     * @param uncompressedSize the decompressed payload size
     * @param compressedSize   the wire size before decompression (same as uncompressed if not compressed)
     */
    void recordReceive(int packetId, int uncompressedSize, int compressedSize);

    /**
     * Get the stats entry for a specific packet ID.
     */
    @Nonnull
    PacketStatsEntry getEntry(int packetId);

    /**
     * Per-packet statistics entry.
     */
    interface PacketStatsEntry {
        /** Default time window for recent stats in seconds. */
        int RECENT_SECONDS = 30;
        int getPacketId();
        @Nullable String getName();
        boolean hasData();

        // Send stats
        int getSentCount();
        long getSentUncompressedTotal();
        long getSentCompressedTotal();
        long getSentUncompressedMin();
        long getSentUncompressedMax();
        long getSentCompressedMin();
        long getSentCompressedMax();
        double getSentUncompressedAvg();
        double getSentCompressedAvg();
        @Nonnull RecentStats getSentRecently();

        // Receive stats
        int getReceivedCount();
        long getReceivedUncompressedTotal();
        long getReceivedCompressedTotal();
        long getReceivedUncompressedMin();
        long getReceivedUncompressedMax();
        long getReceivedCompressedMin();
        long getReceivedCompressedMax();
        double getReceivedUncompressedAvg();
        double getReceivedCompressedAvg();
        @Nonnull RecentStats getReceivedRecently();
    }

    /**
     * Statistics for a recent time window.
     */
    record RecentStats(
        int count,
        long uncompressedTotal,
        long compressedTotal,
        int uncompressedMin,
        int uncompressedMax,
        int compressedMin,
        int compressedMax
    ) {
        public static final RecentStats EMPTY = new RecentStats(0, 0, 0, 0, 0, 0, 0);
    }
}
