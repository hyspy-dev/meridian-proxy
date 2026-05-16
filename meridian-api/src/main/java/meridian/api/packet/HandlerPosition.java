package meridian.api.packet;

/**
 * Ordering slot for a registered {@link PacketHandler}.
 *
 * <p>Handlers run EARLY → NORMAL → LATE → MONITOR. Built-in proxy handlers
 * (auth, route guards) occupy the equivalent of EARLY; module observers belong
 * in MONITOR.
 *
 * <p>This is an ordering hint only — there is no runtime validation. Returning
 * {@code Action.DROP} or {@code Action.MODIFIED} from a {@code MONITOR}-position
 * handler is considered a bug.
 */
public enum HandlerPosition {
    /** Token interceptors, route guards, auth. */
    EARLY,
    /** Module business logic — the default. */
    NORMAL,
    /** Final modifications, post-processing. */
    LATE,
    /** Observation only — must not mutate or drop the packet. */
    MONITOR
}
