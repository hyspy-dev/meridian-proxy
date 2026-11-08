package meridian.internal.control;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import meridian.api.packet.Direction;
import meridian.internal.core.ProxySessionImpl;
import meridian.protocol.Packet;
import meridian.protocol.PacketRegistry;

/**
 * Lets the control channel see packets go by: each one the router handled, with what became of
 * it. Costs one empty-list check per packet while nobody is watching.
 */
public final class PacketTap {

    /** What the handler chain did with a packet. */
    public enum Outcome {
        /** Passed on as it came. */
        FORWARDED,
        /** Passed on, changed by a handler. */
        MODIFIED,
        /** Dropped by a handler. */
        DROPPED,
        /** Taken by a handler, which answers it itself. */
        HANDLED,
        /** Could not be decoded; passed on as raw bytes. */
        UNDECODED,
        /** Not passed on: made by the proxy itself (a module, core, or a {@code send}). */
        FORGED
    }

    /** Hears every packet; called on the connection's event loop, so it must not block. */
    public interface Listener {
        void packet(ProxySessionImpl session, Direction direction, int packetId, Packet packet, Outcome outcome);
    }

    private static final List<Listener> LISTENERS = new CopyOnWriteArrayList<>();

    private PacketTap() {
    }

    static void add(Listener l) {
        LISTENERS.add(l);
    }

    static void remove(Listener l) {
        LISTENERS.remove(l);
    }

    /** Called by the router for each packet it routed; cheap when nobody listens. */
    public static void offer(ProxySessionImpl session, Direction direction, int packetId, Packet packet,
                             Outcome outcome) {
        if (packet != null) {
            PacketRegistry.PacketInfo info = direction == Direction.C2S
                    ? PacketRegistry.getToServerPacketById(packetId)
                    : PacketRegistry.getToClientPacketById(packetId);
            if (info != null) {
                LiveConnections.sawChannel(session, info.channel());
            }
        }
        if (LISTENERS.isEmpty()) {
            return;
        }
        for (Listener l : LISTENERS) {
            try {
                l.packet(session, direction, packetId, packet, outcome);
            } catch (RuntimeException ignored) {
                // a watcher's trouble is its own; the game's packet goes on regardless
            }
        }
    }
}
