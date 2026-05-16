package meridian.api.packet;

/**
 * Marker for a Hytale wire packet.
 *
 * <p>This interface is intentionally empty. Concrete packet classes
 * ({@code AuthGrant}, {@code UpdateBlockTypes}, ...) live in {@code meridian-protocol}
 * and implement this marker. A Layer-2 module that does not depend on
 * {@code meridian-protocol} may hold an opaque {@code Packet} reference but cannot
 * construct one or {@code instanceof}-test a concrete type.
 */
public interface Packet {
}
