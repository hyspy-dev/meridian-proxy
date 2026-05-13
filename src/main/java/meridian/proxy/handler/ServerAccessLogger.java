package meridian.proxy.handler;

import meridian.protocol.HostAddress;
import meridian.protocol.Packet;
import meridian.protocol.packets.serveraccess.RequestServerAccess;
import meridian.protocol.packets.serveraccess.SetServerAccess;
import meridian.protocol.packets.serveraccess.UpdateServerAccess;
import meridian.proxy.core.Direction;
import meridian.proxy.core.ProxySession;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Observability for the server-access protocol:
 *  - id 250 RequestServerAccess (S2C): server asks the client for an access decision
 *  - id 251 UpdateServerAccess  (C2S): client publishes its allowed host list
 *  - id 252 SetServerAccess     (C2S): client sets server password
 *
 * Forwards unchanged; logs with the password redacted.
 */
public class ServerAccessLogger implements PacketHandler {
    private static final Logger log = LoggerFactory.getLogger(ServerAccessLogger.class);
    private final Direction direction;

    public ServerAccessLogger(Direction direction) {
        this.direction = direction;
    }

    @Override
    public Action handleC2S(ChannelHandlerContext ctx, Packet packet, ProxySession session) {
        if (direction != Direction.C2S) return Action.FORWARD;

        if (packet instanceof UpdateServerAccess up) {
            int n = up.hosts != null ? up.hosts.length : 0;
            log.info("[C2S] Pkt 251 UpdateServerAccess access={} hosts={}", up.access, n);
            for (int i = 0; i < n; i++) {
                HostAddress h = up.hosts[i];
                if (h != null) log.info("  host[{}] = {}:{}", i, h.host, h.port & 0xFFFF);
            }
        } else if (packet instanceof SetServerAccess set) {
            log.info("[C2S] Pkt 252 SetServerAccess access={} password={}",
                    set.access, set.password != null ? "<redacted>" : "null");
        }
        return Action.FORWARD;
    }

    @Override
    public Action handleS2C(ChannelHandlerContext ctx, Packet packet, ProxySession session) {
        if (direction != Direction.S2C) return Action.FORWARD;

        if (packet instanceof RequestServerAccess req) {
            log.info("[S2C] Pkt 250 RequestServerAccess access={} externalPort={}",
                    req.access, req.externalPort & 0xFFFF);
        }
        return Action.FORWARD;
    }
}
