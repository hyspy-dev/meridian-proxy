package meridian.internal.core;

import io.netty.incubator.codec.quic.QuicCodecBuilder;
import io.netty.incubator.codec.quic.QuicCongestionControlAlgorithm;

import java.util.concurrent.TimeUnit;

public final class QuicConfig {
    private QuicConfig() {}

    public static <T extends QuicCodecBuilder<T>> T configure(T builder) {
        return builder
                .maxIdleTimeout(30000, TimeUnit.MILLISECONDS)
                // Flow-control windows kept generous: the Hytale setup payload
                // (block-type catalog + assets) is multi-megabyte, and a tight
                // per-stream window stalls the transfer if the proxy's read side
                // hiccups (GC pause, jitter). 64 MB connection / 16 MB per stream
                // gives the whole burst headroom instead of relying on the
                // sliding window keeping pace.
                .initialMaxData(67108864)
                .initialMaxStreamDataBidirectionalLocal(16777216)
                .initialMaxStreamDataBidirectionalRemote(16777216)
                .initialMaxStreamsBidirectional(128)
                .initialMaxStreamDataUnidirectional(16777216)
                .initialMaxStreamsUnidirectional(128)
                .activeMigration(false)
                .ackDelayExponent(3)
                .congestionControlAlgorithm(QuicCongestionControlAlgorithm.BBR);
    }
}
