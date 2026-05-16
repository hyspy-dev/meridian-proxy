package meridian.api.module;

import java.nio.file.Path;
import java.util.concurrent.Executor;
import javax.swing.JPanel;
import meridian.api.event.EventBus;
import meridian.api.packet.Direction;
import meridian.api.packet.HandlerPosition;
import meridian.api.packet.PacketHandlerFactory;
import meridian.api.service.ServiceRegistry;
import meridian.api.settings.SettingsSpec;
import org.slf4j.Logger;

/**
 * Context provided to a module during its lifecycle.
 */
public interface ModuleContext {
    /**
     * @return Logger scoped to this module.
     */
    Logger getLogger();

    /**
     * Registers a factory that creates packet handlers for each new stream of
     * the given {@code direction}, ordered by {@code position} within the chain.
     *
     * <p>The factory is invoked once per stream of {@code direction}; a handler
     * registered for {@link Direction#S2C} never sees C2S traffic.
     * {@link Direction#BOTH} registers the factory for both directions.
     */
    void registerHandler(Direction direction, HandlerPosition position, PacketHandlerFactory factory);

    /**
     * Registers a declarative settings spec for this module. The proxy renders
     * it into the native UI and persists each value to
     * {@code <dataDir>/settings.json}; persisted values are applied at startup.
     */
    void registerSettings(SettingsSpec spec);

    /**
     * Registers a raw Swing settings panel.
     *
     * @deprecated Use {@link #registerSettings(SettingsSpec)}. A raw panel
     *             cannot be persisted by the proxy and ties the module to Swing.
     */
    @Deprecated
    void registerSettings(JPanel panel);

    /**
     * Returns the running proxy version (e.g. "v1.0.0" or "v1.0.0-3-gabc1234-dirty").
     * Hard compatibility should be expressed declaratively in {@code module.json} via
     * {@code minProxyVersion}/{@code maxProxyVersion} — that check runs before classloading
     * and protects against missing-API errors. Use this method only for soft feature
     * detection: enabling an optional behavior when the proxy is new enough.
     */
    String getCoreVersion();

    /**
     * Per-module data directory ({@code <modulesDir>/<thisModule>/data/}).
     * Created on first call. Its contents are private to the module.
     */
    Path getDataDir();

    /**
     * Virtual-thread executor for blocking work (HTTP, disk, heavy logic).
     *
     * <p>Never block a {@code handle*()} method directly — hand blocking work
     * to this executor or {@link #scheduler()}.
     */
    Executor offloadExecutor();

    /**
     * Scheduler for tickers and deferred actions. Every future it hands out is
     * cancelled automatically when the process shuts down.
     */
    Scheduler scheduler();

    /** Registers a finalizer run when the process shuts down. */
    void onShutdown(Runnable hook);

    /** Event bus shared across all modules in this proxy. */
    EventBus events();

    /**
     * Service registry shared across all modules — Layer-1 modules publish
     * services here, Layer-2 modules consume them.
     */
    ServiceRegistry services();
}
