package meridian.api.settings;

import java.util.function.Consumer;

/**
 * Programmatic enable/disable handle for a single settings widget.
 *
 * <p>The module creates an instance, attaches it via
 * {@link SettingsSpec.Builder#enabled(EnabledControl)} right after declaring
 * a setting, and the proxy wires it to the rendered widget. Then
 * {@link #set} toggles the widget's enabled state on the Swing EDT (and
 * recursively for any wrappers — labels grey out alongside their field).
 *
 * <p>Typical use: greying out a "Convert" button while a long-running task
 * is in progress, or hiding the editability of a setting whose precondition
 * isn't satisfied.
 *
 * <p>Works on any widget — checkbox, spinner, text field, button, live list,
 * live text, a whole section. Initial state defaults to enabled.
 */
public final class EnabledControl {
    private volatile boolean enabled;
    private volatile Consumer<Boolean> uiSetter;

    public EnabledControl() {
        this(true);
    }

    public EnabledControl(boolean initial) {
        this.enabled = initial;
    }

    /** Current enabled state — kept current by the renderer on every {@link #set}. */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Toggles the widget's enabled state. Safe to call from any thread; the
     * renderer hops to the EDT itself. Before the widget has been rendered,
     * the value is held internally and applied on first paint.
     */
    public void set(boolean v) {
        enabled = v;
        Consumer<Boolean> setter = uiSetter;
        if (setter != null) {
            setter.accept(v);
        }
    }

    // ------------------------------------------------------------------
    // Renderer plumbing — not part of the public contract.
    // ------------------------------------------------------------------

    /**
     * Wires this control to its widget. Called once by the renderer; the
     * supplied setter updates the UI on the EDT.
     */
    public void __wireUiSetter(Consumer<Boolean> setter) {
        this.uiSetter = setter;
        // Apply the held state immediately so the widget paints in the
        // requested mode from the first frame.
        setter.accept(enabled);
    }
}
