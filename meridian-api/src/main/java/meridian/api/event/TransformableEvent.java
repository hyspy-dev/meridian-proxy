package meridian.api.event;

/**
 * A {@link CancellableEvent} whose payload may also be replaced before forward.
 *
 * @param <T> the mutable payload type
 */
public interface TransformableEvent<T> extends CancellableEvent {
    T body();

    void replace(T newBody);
}
