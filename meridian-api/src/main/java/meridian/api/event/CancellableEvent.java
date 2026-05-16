package meridian.api.event;

/**
 * A server-to-client event a module may veto before the proxy forwards it.
 *
 * <p>Skeleton for Phase 1 — concrete cancellable events arrive with the
 * {@code meridian-core} services in Phase 5+.
 */
public interface CancellableEvent extends ProxyEvent {
    /** Marks the event suppressed; the proxy will not forward the underlying packet. */
    void suppress();

    boolean isSuppressed();
}
