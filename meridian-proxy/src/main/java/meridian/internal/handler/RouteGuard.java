package meridian.internal.handler;

import meridian.protocol.HostAddress;
import meridian.api.packet.Packet;
import meridian.protocol.packets.auth.ClientReferral;
import meridian.protocol.packets.interface_.ServerInfo;
import meridian.api.packet.Direction;
import meridian.api.packet.PacketHandler;
import meridian.api.session.ProxySession;
import meridian.internal.ConnectionScope;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Keeps the client routed through the proxy across server-issued redirects.
 *
 * Two S2C packets carry a {@link HostAddress} the client may follow directly,
 * bypassing the proxy:
 *  - id 18  ClientReferral.hostTo — hard redirect ("connect to X instead")
 *  - id 223 ServerInfo.fallbackServer — fallback used on disconnect
 *
 * Policy:
 *  - {@code ClientReferral}: <b>follow it.</b> Repoint the scope's backend target at
 *    the real {@code hostTo}, then rewrite {@code hostTo} to the proxy's own address so
 *    the client reconnects through us. The client echoes the referral {@code data} blob
 *    back as {@code Connect.referralData} to the new server — relayed transparently, so
 *    no proxy-side handling of the grant is needed.
 *  - {@code ServerInfo.fallbackServer}: cleared — we don't yet route a fallback hop
 *    through the proxy, and an un-rewritten fallback would let the client bypass us.
 */
public class RouteGuard implements PacketHandler {
    private static final Logger log = LoggerFactory.getLogger(RouteGuard.class);
    private final Direction direction;
    private final ConnectionScope scope;

    public RouteGuard(Direction direction, ConnectionScope scope) {
        this.direction = direction;
        this.scope = scope;
    }

    @Override
    public Action handleS2C(ChannelHandlerContext ctx, Packet packet, ProxySession session) {
        if (direction != Direction.S2C) return Action.FORWARD;

        if (packet instanceof ClientReferral cr) {
            if (cr.hostTo == null) {
                log.warn("[S2C] Pkt 18 ClientReferral with null hostTo — forwarding unchanged");
                return Action.FORWARD;
            }
            String realHost = cr.hostTo.host;
            int realPort = cr.hostTo.port & 0xFFFF;
            log.info("[S2C] Pkt 18 ClientReferral to {}:{} — following: backend retargeted, "
                    + "rewriting hostTo to the proxy ({}:{}).",
                    realHost, realPort, scope.selfHost(), scope.localPort());
            scope.beginRedirect(realHost, realPort);
            // Point the client back at the proxy; leave the referral data blob intact —
            // the client replays it to the new server as Connect.referralData.
            cr.hostTo.host = scope.selfHost();
            cr.hostTo.port = (short) scope.localPort();
            return Action.MODIFIED;
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
