package meridian.api.event;

/**
 * Delivery order of an {@link EventBus} subscriber.
 *
 * <p>{@code HIGHEST} → {@code LOW} → {@code MONITOR} subscribers run
 * synchronously on the publisher's thread, in that order. {@code OFFLOAD}
 * subscribers are delivered asynchronously via the module's offload executor —
 * use it when the subscriber blocks.
 */
public enum EventPriority {
    HIGHEST,
    HIGH,
    NORMAL,
    LOW,
    MONITOR,
    OFFLOAD
}
