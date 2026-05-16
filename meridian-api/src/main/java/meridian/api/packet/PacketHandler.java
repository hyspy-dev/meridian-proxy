package meridian.api.packet;

import meridian.api.session.ProxySession;
import io.netty.channel.ChannelHandlerContext;

/**
 * Pluggable per-stream packet processor. A {@link PacketHandlerFactory} creates
 * one instance per stream; the proxy's router invokes it for every packet.
 */
public interface PacketHandler {

    /**
     * Called for packets traveling from Client to Server.
     */
    default Action handleC2S(ChannelHandlerContext ctx, Packet packet, ProxySession session) {
        return Action.FORWARD;
    }

    /**
     * Called for packets traveling from Server to Client.
     */
    default Action handleS2C(ChannelHandlerContext ctx, Packet packet, ProxySession session) {
        return Action.FORWARD;
    }

    default void onStreamActive(ChannelHandlerContext ctx, ProxySession session) {}
    default void onStreamInactive(ChannelHandlerContext ctx, ProxySession session) {}
    default String name() { return getClass().getSimpleName(); }

    enum Action {
        /** Continue the chain; if all handlers FORWARD, the original raw frame is sent to the target. */
        FORWARD,
        /**
         * Continue the chain, but mark the Packet object as mutated. After the chain finishes,
         * the router re-serialises the Packet (including Zstd compression where applicable)
         * and forwards the fresh frame instead of the original bytes.
         */
        MODIFIED,
        /** Stop and silently drop. */
        DROP,
        /** Stop. The handler is responsible for any substitute actions. */
        HANDLED
    }
}
