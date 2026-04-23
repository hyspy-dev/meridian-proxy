package meridian.proxy.core;

import io.netty.incubator.codec.quic.QuicCodecBuilder;
import io.netty.incubator.codec.quic.QuicCongestionControlAlgorithm;

import java.util.concurrent.TimeUnit;

public final class QuicConfig {
    private QuicConfig() {}

    public static <T extends QuicCodecBuilder<T>> T configure(T builder) {
        return builder
                .maxIdleTimeout(30000, TimeUnit.MILLISECONDS)
                .initialMaxData(10485760)
                .initialMaxStreamDataBidirectionalLocal(1048576)
                .initialMaxStreamDataBidirectionalRemote(1048576)
                .initialMaxStreamsBidirectional(8)
                .initialMaxStreamDataUnidirectional(1048576)
                .initialMaxStreamsUnidirectional(8)
                .activeMigration(false)
                .ackDelayExponent(3)
                .congestionControlAlgorithm(QuicCongestionControlAlgorithm.BBR);
    }
}
