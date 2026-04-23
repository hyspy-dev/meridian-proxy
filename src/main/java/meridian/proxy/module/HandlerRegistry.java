package meridian.proxy.module;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Global registry for packet handler factories.
 */
public class HandlerRegistry {
    private static final List<PacketHandlerFactory> factories = new CopyOnWriteArrayList<>();

    public static void register(PacketHandlerFactory factory) {
        factories.add(factory);
    }

    public static List<PacketHandlerFactory> getFactories() {
        return Collections.unmodifiableList(factories);
    }
}
