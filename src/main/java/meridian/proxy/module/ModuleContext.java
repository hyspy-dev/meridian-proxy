package meridian.proxy.module;

import javax.swing.JPanel;
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
     * Registers a factory that creates packet handlers for each new stream.
     */
    void registerHandler(PacketHandlerFactory factory);

    /**
     * Registers a settings panel for this module.
     * @param panel The panel containing module-specific configuration.
     */
    void registerSettings(JPanel panel);

    /**
     * Returns the running core version (e.g. "v1.0.0" or "v1.0.0-3-gabc1234-dirty").
     * Hard compatibility should be expressed declaratively in {@code module.json} via
     * {@code minCoreVersion}/{@code maxCoreVersion} — that check runs before classloading
     * and protects against missing-API errors. Use this method only for soft feature
     * detection: enabling an optional behavior when the core is new enough.
     */
    String getCoreVersion();
}
