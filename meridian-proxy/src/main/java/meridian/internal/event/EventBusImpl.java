package meridian.internal.event;

import meridian.api.event.EventBus;
import meridian.api.event.EventPriority;
import meridian.api.event.ProxyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/**
 * Process-wide {@link EventBus}.
 *
 * <p>Subscribers run in {@link EventPriority} order on the publisher's thread,
 * except {@code OFFLOAD} subscribers which are dispatched on the offload
 * executor. Subscription is by type: a subscriber to a supertype (or interface)
 * receives every assignable event.
 */
public final class EventBusImpl implements EventBus {
    private static final Logger log = LoggerFactory.getLogger(EventBusImpl.class);

    private record Sub(EventPriority priority, Consumer<ProxyEvent> handler) {}

    private final Map<Class<?>, List<Sub>> subscriptions = new ConcurrentHashMap<>();
    private final Executor offloadExecutor;

    public EventBusImpl(Executor offloadExecutor) {
        this.offloadExecutor = offloadExecutor;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E extends ProxyEvent> void subscribe(Class<E> type, EventPriority priority, Consumer<E> handler) {
        subscriptions.computeIfAbsent(type, t -> new CopyOnWriteArrayList<>())
                .add(new Sub(priority, (Consumer<ProxyEvent>) handler));
    }

    @Override
    public <E extends ProxyEvent> void publish(E event) {
        List<Sub> matched = new ArrayList<>();
        for (Map.Entry<Class<?>, List<Sub>> entry : subscriptions.entrySet()) {
            if (entry.getKey().isInstance(event)) {
                matched.addAll(entry.getValue());
            }
        }
        if (matched.isEmpty()) return;
        matched.sort(Comparator.comparingInt(s -> s.priority().ordinal()));
        for (Sub sub : matched) {
            if (sub.priority() == EventPriority.OFFLOAD) {
                offloadExecutor.execute(() -> dispatch(sub, event));
            } else {
                dispatch(sub, event);
            }
        }
    }

    private void dispatch(Sub sub, ProxyEvent event) {
        try {
            sub.handler().accept(event);
        } catch (Exception e) {
            log.error("Event subscriber failed for {}: {}", event.getClass().getSimpleName(), e.toString());
        }
    }
}
