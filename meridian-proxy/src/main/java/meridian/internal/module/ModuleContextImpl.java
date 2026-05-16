package meridian.internal.module;

import meridian.api.event.EventBus;
import meridian.api.module.ModuleContext;
import meridian.api.module.Scheduler;
import meridian.api.packet.Direction;
import meridian.api.packet.HandlerPosition;
import meridian.api.packet.PacketHandlerFactory;
import meridian.api.service.ServiceRegistry;
import meridian.api.settings.SettingsSpec;
import meridian.internal.Version;
import meridian.internal.gui.SettingsRenderer;
import meridian.internal.settings.SettingsStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.JPanel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/**
 * {@link ModuleContext} implementation handed to one module at {@code onEnable}.
 *
 * <p>Per-module state (data dir, scheduler, shutdown hooks, settings panel) is
 * owned here; cross-module facilities (handler registry, event bus, service
 * registry, offload executor) are shared instances passed in.
 */
final class ModuleContextImpl implements ModuleContext {
    private final String moduleName;
    private final Logger logger;
    private final Path dataDir;
    private final HandlerRegistry handlerRegistry;
    private final EventBus eventBus;
    private final ServiceRegistry serviceRegistry;
    private final Executor offloadExecutor;
    private final SchedulerImpl scheduler;
    private final List<Runnable> shutdownHooks = new CopyOnWriteArrayList<>();

    private volatile boolean dataDirReady;
    /** Set by {@link #registerSettings}; read by the management UI. */
    volatile JPanel settingsPanel;

    ModuleContextImpl(String moduleName, Path dataDir, HandlerRegistry handlerRegistry,
                      EventBus eventBus, ServiceRegistry serviceRegistry,
                      Executor offloadExecutor, SchedulerImpl scheduler) {
        this.moduleName = moduleName;
        this.logger = LoggerFactory.getLogger(moduleName);
        this.dataDir = dataDir;
        this.handlerRegistry = handlerRegistry;
        this.eventBus = eventBus;
        this.serviceRegistry = serviceRegistry;
        this.offloadExecutor = offloadExecutor;
        this.scheduler = scheduler;
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public void registerHandler(Direction direction, HandlerPosition position, PacketHandlerFactory factory) {
        if (direction == Direction.BOTH) {
            handlerRegistry.register(Direction.C2S, position, factory);
            handlerRegistry.register(Direction.S2C, position, factory);
        } else {
            handlerRegistry.register(direction, position, factory);
        }
        logger.info("Registered {} {} packet handler factory.", direction, position);
    }

    @Override
    public void registerSettings(SettingsSpec spec) {
        SettingsStore store = new SettingsStore(getDataDir().resolve("settings.json"));
        spec.nonPersistentKeys().forEach(store::markEphemeral);
        this.settingsPanel = SettingsRenderer.render(spec, store);
        logger.info("Registered declarative settings ({} top-level node(s)).", spec.nodes().size());
    }

    @Override
    @SuppressWarnings("deprecation")
    public void registerSettings(JPanel panel) {
        this.settingsPanel = panel;
        logger.info("Registered settings panel (deprecated JPanel path).");
    }

    @Override
    public String getCoreVersion() {
        return Version.VERSION;
    }

    @Override
    public Path getDataDir() {
        if (!dataDirReady) {
            synchronized (this) {
                if (!dataDirReady) {
                    try {
                        Files.createDirectories(dataDir);
                    } catch (Exception e) {
                        logger.error("Failed to create data dir {}: {}", dataDir, e.toString());
                    }
                    dataDirReady = true;
                }
            }
        }
        return dataDir;
    }

    @Override
    public Executor offloadExecutor() {
        return offloadExecutor;
    }

    @Override
    public Scheduler scheduler() {
        return scheduler;
    }

    @Override
    public void onShutdown(Runnable hook) {
        shutdownHooks.add(hook);
    }

    @Override
    public EventBus events() {
        return eventBus;
    }

    @Override
    public ServiceRegistry services() {
        return serviceRegistry;
    }

    /** Runs shutdown hooks and cancels all scheduled tasks. Invoked on process shutdown. */
    void runShutdown() {
        for (Runnable hook : shutdownHooks) {
            try {
                hook.run();
            } catch (Exception e) {
                logger.error("Shutdown hook of module {} failed: {}", moduleName, e.toString());
            }
        }
        scheduler.shutdown();
    }
}
