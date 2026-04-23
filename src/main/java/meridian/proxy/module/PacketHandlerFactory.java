package meridian.proxy.module;

import meridian.proxy.core.Direction;
import meridian.proxy.core.PacketForwarder;
import meridian.proxy.handler.PacketHandler;

/**
 * Creates packet handlers for a specific stream.
 */
@FunctionalInterface
public interface PacketHandlerFactory {
    PacketHandler create(Direction direction, PacketForwarder forwarder);
}
