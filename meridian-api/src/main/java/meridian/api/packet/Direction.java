package meridian.api.packet;

/** Travel direction of a packet through the proxy. */
public enum Direction {
    /** Client to Server. */
    C2S,
    /** Server to Client. */
    S2C,
    /**
     * Registration-only sugar meaning "both C2S and S2C". A handler factory
     * registered with {@code BOTH} is expanded into one {@code C2S} and one
     * {@code S2C} registration; an actual {@link meridian.api.packet.PacketHandler}
     * and its stream are always either {@code C2S} or {@code S2C}, never this.
     */
    BOTH
}
