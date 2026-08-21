package meridian.protocol.io;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * No-op implementation of {@link PacketStatsRecorder} that discards all data.
 */
final class NoopPacketStatsRecorder implements PacketStatsRecorder {

    private static final PacketStatsEntry EMPTY_ENTRY = new PacketStatsEntry() {
        @Override public int getPacketId() { return 0; }
        @Override public @Nullable String getName() { return null; }
        @Override public boolean hasData() { return false; }

        @Override public int getSentCount() { return 0; }
        @Override public long getSentUncompressedTotal() { return 0; }
        @Override public long getSentCompressedTotal() { return 0; }
        @Override public long getSentUncompressedMin() { return 0; }
        @Override public long getSentUncompressedMax() { return 0; }
        @Override public long getSentCompressedMin() { return 0; }
        @Override public long getSentCompressedMax() { return 0; }
        @Override public double getSentUncompressedAvg() { return 0; }
        @Override public double getSentCompressedAvg() { return 0; }
        @Override public @Nonnull RecentStats getSentRecently() { return RecentStats.EMPTY; }

        @Override public int getReceivedCount() { return 0; }
        @Override public long getReceivedUncompressedTotal() { return 0; }
        @Override public long getReceivedCompressedTotal() { return 0; }
        @Override public long getReceivedUncompressedMin() { return 0; }
        @Override public long getReceivedUncompressedMax() { return 0; }
        @Override public long getReceivedCompressedMin() { return 0; }
        @Override public long getReceivedCompressedMax() { return 0; }
        @Override public double getReceivedUncompressedAvg() { return 0; }
        @Override public double getReceivedCompressedAvg() { return 0; }
        @Override public @Nonnull RecentStats getReceivedRecently() { return RecentStats.EMPTY; }
    };

    @Override
    public void recordSend(int packetId, int uncompressedSize, int compressedSize) {}

    @Override
    public void recordReceive(int packetId, int uncompressedSize, int compressedSize) {}

    @Override
    public @Nonnull PacketStatsEntry getEntry(int packetId) {
        return EMPTY_ENTRY;
    }
}
