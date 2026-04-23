package meridian.proxy.module;

/**
 * Entry point for Hytale Proxy modules.
 * Implementations should have a no-args constructor.
 */
public interface ProxyModule {
    /**
     * Called when the module is loaded and enabled.
     * @param context API surface provided by the core.
     */
    void onEnable(ModuleContext context);

    /**
     * Called when the proxy is shutting down or the module is disabled.
     */
    default void onDisable() {}
}
