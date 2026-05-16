package meridian.internal.handler;

import meridian.api.packet.Packet;
import meridian.protocol.packets.auth.ConnectAccept;
import meridian.protocol.packets.player.ClientReady;
import meridian.protocol.packets.player.JoinWorld;
import meridian.protocol.packets.setup.WorldLoadFinished;
import meridian.api.event.AuthCompletedEvent;
import meridian.api.event.EventBus;
import meridian.api.event.PhaseChangedEvent;
import meridian.api.packet.Direction;
import meridian.api.packet.PacketHandler;
import meridian.api.session.ProxySession;
import meridian.internal.core.ProxySessionImpl;
import meridian.api.session.SessionPhase;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Pass-through observer that advances {@link SessionPhase} on trigger packets:
 *  - S2C Pkt 14  ConnectAccept     → AUTH_COMPLETE
 *  - S2C Pkt 22  WorldLoadFinished → WORLD_LOADED
 *  - S2C Pkt 104 JoinWorld         → JOINING
 *  - C2S Pkt 105 ClientReady       → PLAYING
 *
 * Logs every phase transition. Never modifies a packet.
 */
public class PhaseTracker implements PacketHandler {
    private static final Logger log = LoggerFactory.getLogger(PhaseTracker.class);
    private final Direction direction;
    private final EventBus eventBus;

    public PhaseTracker(Direction direction, EventBus eventBus) {
        this.direction = direction;
        this.eventBus = eventBus;
    }

    @Override
    public Action handleC2S(ChannelHandlerContext ctx, Packet packet, ProxySession session) {
        if (direction != Direction.C2S) return Action.FORWARD;
        if (packet instanceof ClientReady) {
            advance((ProxySessionImpl) session, SessionPhase.PLAYING, "Pkt 105 ClientReady");
        }
        return Action.FORWARD;
    }

    @Override
    public Action handleS2C(ChannelHandlerContext ctx, Packet packet, ProxySession session) {
        if (direction != Direction.S2C) return Action.FORWARD;
        if (packet instanceof ConnectAccept) {
            advance((ProxySessionImpl) session, SessionPhase.AUTH_COMPLETE, "Pkt 14 ConnectAccept");
        } else if (packet instanceof WorldLoadFinished) {
            advance((ProxySessionImpl) session, SessionPhase.WORLD_LOADED, "Pkt 22 WorldLoadFinished");
        } else if (packet instanceof JoinWorld) {
            advance((ProxySessionImpl) session, SessionPhase.JOINING, "Pkt 104 JoinWorld");
        }
        return Action.FORWARD;
    }

    private void advance(ProxySessionImpl session, SessionPhase next, String trigger) {
        SessionPhase before = session.phase();
        if (session.advancePhase(next)) {
            log.info("Phase {} -> {} (trigger: {})", before, next, trigger);
            eventBus.publish(new PhaseChangedEvent(before, next, session));
            if (next == SessionPhase.AUTH_COMPLETE) {
                eventBus.publish(new AuthCompletedEvent(session));
            }
        }
    }
}
