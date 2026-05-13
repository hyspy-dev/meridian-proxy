package meridian.proxy.handler;

import meridian.protocol.HostAddress;
import meridian.protocol.Packet;
import meridian.protocol.packets.auth.ClientReferral;
import meridian.protocol.packets.interface_.ServerInfo;
import meridian.proxy.core.Direction;
import meridian.proxy.core.ProxySession;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Prevents the upstream from routing the client past the proxy.
 *
 * Two S2C packets carry a {@link HostAddress} that the client may follow
 * directly, bypassing the proxy:
 *  - id 18  ClientReferral.hostTo — hard redirect ("connect to X instead")
 *  - id 223 ServerInfo.fallbackServer — fallback used on disconnect
 *
 * Default policy: drop the referral, clear the fallback. Follow-referral
 * logic (proxy reconnects to the new upstream and rewrites hostTo to the
 * proxy's own address) is not implemented yet.
 */
public class RouteGuard implements PacketHandler {
    private static final Logger log = LoggerFactory.getLogger(RouteGuard.class);
    private final Direction direction;

    public RouteGuard(Direction direction) {
        this.direction = direction;
    }

    @Override
    public Action handleS2C(ChannelHandlerContext ctx, Packet packet, ProxySession session) {
        if (direction != Direction.S2C) return Action.FORWARD;

        if (packet instanceof ClientReferral cr) {
            String target = cr.hostTo != null ? (cr.hostTo.host + ":" + (cr.hostTo.port & 0xFFFF)) : "null";
            log.warn("[S2C] Pkt 18 ClientReferral to {} — DROPPING (follow-referral not implemented)", target);
            return Action.DROP;
        }

        if (packet instanceof ServerInfo si) {
            if (si.fallbackServer != null) {
                String fb = si.fallbackServer.host + ":" + (si.fallbackServer.port & 0xFFFF);
                log.warn("[S2C] Pkt 223 ServerInfo.fallbackServer={} — clearing", fb);
                si.fallbackServer = null;
                return Action.MODIFIED;
            }
        }

        return Action.FORWARD;
    }
}
