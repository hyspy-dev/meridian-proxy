package meridian.internal.handler;

import meridian.api.packet.Packet;
import meridian.protocol.packets.auth.AuthToken;
import meridian.protocol.packets.auth.ServerAuthToken;
import meridian.internal.HytaleAuthState;
import meridian.api.packet.Direction;
import meridian.api.packet.PacketHandler;
import meridian.api.session.ProxySession;
import meridian.internal.core.ProxySessionImpl;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrontAuthHandler implements PacketHandler {
    private static final Logger log = LoggerFactory.getLogger(FrontAuthHandler.class);
    private final Direction direction;

    public FrontAuthHandler(Direction direction) {
        this.direction = direction;
    }

    @Override
    public Action handleC2S(ChannelHandlerContext ctx, Packet packet, ProxySession session) {
        if (direction != Direction.C2S) return Action.FORWARD;

        if (packet instanceof AuthToken at) {
            ProxySessionImpl impl = (ProxySessionImpl) session;
            HytaleAuthState auth = impl.authState();
            log.info("[C2S] Pkt 12 AuthToken intercepted");

            if (at.serverAuthorizationGrant == null) {
                log.warn("[C2S] Pkt 12 has no serverAuthorizationGrant");
                return Action.HANDLED;
            }

            auth.exchangeClientServerGrant(at.serverAuthorizationGrant).whenComplete((serverAccessToken, err) -> {
                if (err != null || serverAccessToken == null) {
                    log.error("[FRONT] Failed to obtain frontServerAccessToken", err);
                    impl.disconnect();
                    return;
                }
                ServerAuthToken pkt = new ServerAuthToken(serverAccessToken, auth.getLastServerPasswordChallenge());
                log.info("[FRONT] Sending Pkt 13 ServerAuthToken to client");

                impl.sendToClient(ServerAuthToken.PACKET_ID, pkt.computeSize(), pkt::serialize);
                log.info("[FRONT] Signaling S2C to flush buffered packets");
                impl.flushS2CBuffering();
            });

            return Action.HANDLED;
        }

        return Action.FORWARD;
    }

    @Override
    public Action handleS2C(ChannelHandlerContext ctx, Packet packet, ProxySession session) {
        if (direction != Direction.S2C) return Action.FORWARD;

        if (packet instanceof ServerAuthToken sat) {
            log.info("[S2C] Pkt 13 ServerAuthToken intercepted");
            ((ProxySessionImpl) session).authState().setLastServerPasswordChallenge(sat.passwordChallenge);
            return Action.HANDLED;
        }
        return Action.FORWARD;
    }
}
