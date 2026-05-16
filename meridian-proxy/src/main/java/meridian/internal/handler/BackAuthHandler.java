package meridian.internal.handler;

import meridian.api.packet.Packet;
import meridian.protocol.packets.auth.AuthGrant;
import meridian.protocol.packets.auth.AuthToken;
import meridian.internal.HytaleAuthState;
import meridian.api.packet.Direction;
import meridian.internal.core.PacketForwarder;
import meridian.api.packet.PacketHandler;
import meridian.api.session.ProxySession;
import meridian.internal.core.ProxySessionImpl;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BackAuthHandler implements PacketHandler {
    private static final Logger log = LoggerFactory.getLogger(BackAuthHandler.class);
    private final Direction direction;
    private final PacketForwarder forwarder;

    public BackAuthHandler(Direction direction, PacketForwarder forwarder) {
        this.direction = direction;
        this.forwarder = forwarder;
    }

    @Override
    public Action handleS2C(ChannelHandlerContext ctx, Packet packet, ProxySession session) {
        if (direction != Direction.S2C) return Action.FORWARD;

        if (packet instanceof AuthGrant pkt) {
            log.info("[S2C] Pkt 11 from real server (authGrantLen={}, serverIdentityTokenLen={})",
                    pkt.authorizationGrant != null ? pkt.authorizationGrant.length() : -1,
                    pkt.serverIdentityToken != null ? pkt.serverIdentityToken.length() : -1);

            if (pkt.authorizationGrant == null) {
                log.warn("[S2C] Pkt 11 has no authGrant");
                return Action.FORWARD;
            }

            ProxySessionImpl impl = (ProxySessionImpl) session;
            HytaleAuthState auth = impl.authState();
            auth.onBackAuthGrantReceived(pkt.authorizationGrant, pkt.serverIdentityToken);

            forwarder.setBuffering(true);
            log.info("[S2C] Buffering enabled");

            kickOffFrontAuthGrant(impl);

            auth.backAccessToken().thenCombine(auth.backServerGrant(), (at, sg) -> new String[]{at, sg})
                    .whenComplete((arr, err) -> {
                        if (err != null || arr[0] == null) {
                            log.error("[BACK] Failed to obtain backAccessToken", err);
                            impl.disconnect();
                            return;
                        }
                        AuthToken out = new AuthToken(arr[0], arr[1]);
                        log.info("[BACK] Sending Pkt 12 to real server");
                        impl.sendToServer(AuthToken.PACKET_ID, out.computeSize(), out::serialize);
                    });

            return Action.HANDLED;
        }

        return Action.FORWARD;
    }

    private void kickOffFrontAuthGrant(ProxySessionImpl session) {
        HytaleAuthState auth = session.authState();
        auth.ensureFrontAuthGrant().whenComplete((grant, err) -> {
            if (err != null || grant == null) {
                log.error("[FRONT] Failed to obtain frontAuthGrant", err);
                session.disconnect();
                return;
            }
            AuthGrant pkt = new AuthGrant(grant, auth.proxyServerIdentityToken);
            log.info("[FRONT] Sending Pkt 11 AuthGrant to client");
            session.sendToClient(AuthGrant.PACKET_ID, pkt.computeSize(), pkt::serialize);
        });
    }
}
