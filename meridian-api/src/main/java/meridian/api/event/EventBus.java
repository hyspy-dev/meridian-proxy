package meridian.api.event;

import java.util.function.Consumer;

/**
 * Publish/subscribe bus for {@link ProxyEvent}s.
 *
 * <p>Subscribers are invoked in {@link EventPriority} order. The proxy emits
 * built-in events ({@link PhaseChangedEvent}, {@link AuthCompletedEvent}, ...);
 * modules typically subscribe rather than publish.
 */
public interface EventBus {
    <E extends ProxyEvent> void subscribe(Class<E> type, EventPriority priority, Consumer<E> handler);

    <E extends ProxyEvent> void publish(E event);
}
