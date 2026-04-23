package meridian.proxy.handler;

import meridian.protocol.Packet;
import meridian.proxy.core.ProxySession;
import io.netty.channel.ChannelHandlerContext;

/**
 * Pluggable per-stream packet processor.
 * Registered via HandlerRegistry and called by PacketRouter.
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
        /** Continue the chain; if all handlers FORWARD, the packet is sent to the target. */
        FORWARD,
        /** Stop and silently drop. */
        DROP,
        /** Stop. The handler is responsible for any substitute actions. */
        HANDLED
    }
}

