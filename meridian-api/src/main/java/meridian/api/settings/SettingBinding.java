package meridian.api.settings;

import java.util.function.Consumer;

/**
 * Two-way binding for a single setting — the module's hook for programmatic
 * mutation of a field whose source of truth is the UI.
 *
 * <p>Pass an instance to a binding-aware builder method (e.g.
 * {@link SettingsSpec.Builder#string(String, String, String, Consumer, SettingBinding)})
 * and the proxy wires it to the rendered widget. Then:
 *
 * <ul>
 *   <li>{@link #set} pushes a value into the widget — the UI updates, the
 *       value is persisted, and the {@code onChange} callback fires (just as
 *       if the user had typed it).</li>
 *   <li>{@link #get} returns the current value — kept current by the
 *       renderer on every user edit and every {@code set}.</li>
 * </ul>
 *
 * <p>{@link #set} is safe to call from any thread; the renderer hops to the
 * Swing EDT itself. Before the widget has been rendered, {@code set} stashes
 * the value so the first paint picks it up.
 *
 * <p>Typical use: a "Fill from clipboard" button, a SelectionBus listener
 * that needs to drop coordinates into X/Y/Z fields, anything else where a
 * field is the source of truth for the user but the module needs the
 * reverse channel.
 */
public final class SettingBinding<T> {
    private volatile T value;
    private volatile Consumer<T> uiSetter;

    public SettingBinding() {}

    public SettingBinding(T initial) {
        this.value = initial;
    }

    /** Last-known value — updated by the renderer on every change. */
    public T get() {
        return value;
    }

    /**
     * Pushes {@code v} into the UI. If the renderer hasn't wired the binding
     * yet (the spec hasn't been registered), the value is held internally and
     * applied on first render.
     */
    public void set(T v) {
        value = v;
        Consumer<T> setter = uiSetter;
        if (setter != null) {
            setter.accept(v);
        }
    }

    // ------------------------------------------------------------------
    // Renderer plumbing — not part of the public contract.
    // ------------------------------------------------------------------

    /**
     * Wires this binding to its widget. Called once by the renderer; the
     * supplied setter is responsible for updating the UI on the Swing EDT,
     * persisting through the store, and firing the module's {@code onChange}.
     */
    public void __wireUiSetter(Consumer<T> setter) {
        this.uiSetter = setter;
    }

    /** Called by the renderer whenever a new value is observed (UI edit or {@link #set}). */
    public void __record(T v) {
        this.value = v;
    }
}
