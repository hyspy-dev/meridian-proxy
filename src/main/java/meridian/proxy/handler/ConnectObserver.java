package meridian.proxy.handler;

import meridian.protocol.Packet;
import meridian.protocol.packets.connection.Connect;
import meridian.proxy.core.Direction;
import meridian.proxy.core.ProxySession;
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
            log.info("[C2S] Pkt 0 Connect: uuid={} username={} hasIdentityToken={}",
                    c.uuid, c.username, c.identityToken != null);
            if (c.identityToken != null) {
                session.authState().setClientIdentityToken(c.identityToken);
            } else {
                log.warn("[C2S] Connect missing identityToken");
            }
        }
        return Action.FORWARD;
    }
}
