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
}
