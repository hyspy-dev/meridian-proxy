package meridian.internal.handler;

import meridian.api.packet.Packet;
import meridian.protocol.ProtocolSettings;
import meridian.protocol.packets.connection.Connect;
import meridian.api.packet.Direction;
import meridian.api.packet.PacketHandler;
import meridian.api.session.ProxySession;
import meridian.internal.Version;
import meridian.internal.core.ProxySessionImpl;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectObserver implements PacketHandler {
    private static final Logger log = LoggerFactory.getLogger(ConnectObserver.class);
    private final Direction direction;

    public ConnectObserver(Direction direction) {
        this.direction = direction;
    }

    @Override
    public Action handleC2S(ChannelHandlerContext ctx, Packet packet, ProxySession session) {
        if (direction != Direction.C2S) return Action.FORWARD;

        if (packet instanceof Connect c) {
            log.info("[C2S] Pkt 0 Connect: clientType={} clientVersion={} language={} hasIdentityToken={} referralSource={}",
                    c.clientType, c.clientVersion, c.language, c.identityToken != null,
                    c.referralSource != null ? (c.referralSource.host + ":" + (c.referralSource.port & 0xFFFF)) : "none");
            if (c.identityToken != null) {
                ((ProxySessionImpl) session).authState().setClientIdentityToken(c.identityToken);
            } else {
                log.warn("[C2S] Connect missing identityToken");
            }
            checkProtocolFreshness(c);
        }
        return Action.FORWARD;
    }

    /**
     * Notes whether the connecting client's protocol matches the one
     * meridian-protocol was generated for.
     *
     * <p>This is informational only. A mismatch is <em>not</em> "broken" — the
     * protocol CRC changes on every Hytale build, and unknown/changed packets
     * are forwarded raw. The loud "update the proxy" signal comes from actual
     * deserialization failures (see {@code ProxySessionImpl.recordDeserFailure}),
     * not from this fingerprint.
     */
    private static void checkProtocolFreshness(Connect c) {
        if (c.protocolCrc == ProtocolSettings.PROTOCOL_CRC
                && c.protocolBuildNumber == ProtocolSettings.PROTOCOL_BUILD_NUMBER) {
            log.info("[C2S] Protocol matches — client build {}.", c.protocolBuildNumber);
            return;
        }
        log.info("[C2S] Protocol differs — client build {}, proxy built for build {}. "
                        + "Usually harmless; if modules misbehave or auth fails, update the proxy: {}",
                c.protocolBuildNumber, ProtocolSettings.PROTOCOL_BUILD_NUMBER, Version.RELEASES_URL);
    }
}
