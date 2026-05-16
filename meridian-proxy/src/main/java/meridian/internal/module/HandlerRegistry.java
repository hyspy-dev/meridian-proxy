package meridian.internal.module;

import meridian.api.packet.Direction;
import meridian.api.packet.HandlerPosition;
import meridian.api.packet.PacketHandlerFactory;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

/**
 * Registry of module-supplied {@link PacketHandlerFactory factories}, keyed by
 * {@link Direction} and {@link HandlerPosition}.
 *
 * <p>One instance per proxy run, owned by {@link ModuleManager}. Replaces the
 * former global static registry — keeping it an instance keeps module state out
 * of static fields and makes the proxy unit-testable.
 */
public final class HandlerRegistry {

    private final EnumMap<Direction, EnumMap<HandlerPosition, List<PacketHandlerFactory>>> byDirection =
            new EnumMap<>(Direction.class);

    public HandlerRegistry() {
        for (Direction d : Direction.values()) {
            byDirection.put(d, new EnumMap<>(HandlerPosition.class));
        }
    }

    public synchronized void register(Direction direction, HandlerPosition position, PacketHandlerFactory factory) {
        byDirection.get(direction)
                .computeIfAbsent(position, p -> new ArrayList<>())
                .add(factory);
    }

    /**
     * Factories registered for {@code direction}, flattened into chain order
     * (EARLY → NORMAL → LATE → MONITOR). Returns a fresh list.
     */
    public synchronized List<PacketHandlerFactory> factoriesFor(Direction direction) {
        List<PacketHandlerFactory> out = new ArrayList<>();
        EnumMap<HandlerPosition, List<PacketHandlerFactory>> positions = byDirection.get(direction);
        for (HandlerPosition pos : HandlerPosition.values()) {
            List<PacketHandlerFactory> list = positions.get(pos);
            if (list != null) out.addAll(list);
        }
        return out;
    }
}
