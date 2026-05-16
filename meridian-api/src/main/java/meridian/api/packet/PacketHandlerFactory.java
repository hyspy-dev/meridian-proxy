package meridian.api.packet;

import meridian.api.session.ProxySession;

/**
 * Creates {@link PacketHandler} instances, one per stream.
 *
 * <p>The factory receives the stream's {@link Direction} and its {@link ProxySession}.
 * It no longer leaks the proxy's internal forwarder — outbound writes go through
 * {@code ProxySession} instead.
 */
@FunctionalInterface
public interface PacketHandlerFactory {
    PacketHandler create(Direction direction, ProxySession session);
}
