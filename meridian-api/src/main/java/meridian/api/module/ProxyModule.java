package meridian.api.module;

/**
 * Entry point for Meridian proxy modules.
 * Implementations must have a no-args constructor.
 */
public interface ProxyModule {
    /**
     * Called when the module is loaded and enabled.
     * @param context API surface provided by the proxy.
     */
    void onEnable(ModuleContext context);

    /**
     * Called when the proxy is shutting down or the module is disabled.
     */
    default void onDisable() {}
}
