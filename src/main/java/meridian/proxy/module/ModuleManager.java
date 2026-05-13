package meridian.proxy.module;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import meridian.proxy.SemVer;
import meridian.proxy.Version;
import meridian.proxy.handler.PacketHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Discovers and loads external modules from JAR files.
 */
public class ModuleManager {
    private static final Logger log = LoggerFactory.getLogger(ModuleManager.class);
    private static final Gson gson = new Gson();
    private final List<ModuleEntry> loadedModules = new ArrayList<>();
    private Path currentPluginsDir;

    public void loadModules(Path pluginsDir) {
        this.currentPluginsDir = pluginsDir;
        log.info("Scanning for modules in {}...", pluginsDir.toAbsolutePath());

        try {
            if (!Files.exists(pluginsDir)) {
                log.info("Modules directory '{}' does not exist. Creating it...", pluginsDir.toAbsolutePath());
                Files.createDirectories(pluginsDir);
                log.info("Please place your module JARs (like test-xray-module.jar) in this folder and restart.");
                return;
            }

            File[] files = pluginsDir.toFile().listFiles((dir, name) -> name.endsWith(".jar"));
            if (files == null || files.length == 0) {
                log.warn("No .jar files found in the modules folder!");
                return;
            }

            // 1. Scan all JARs to get metadata
            Map<String, ModuleMetadataWrapper> discovered = new HashMap<>();
            for (File file : files) {
                try {
                    ModuleMetadataWrapper wrapper = readMetadata(file);
                    if (wrapper != null) {
                        discovered.put(wrapper.meta.name, wrapper);
                    }
                } catch (Exception e) {
                    log.error("Failed to read metadata from {}: {}", file.getName(), e.toString());
                }
            }

            // 2. Load and update order.json
            List<String> orderList = loadExternalOrderList(pluginsDir);
            boolean modified = false;

            // Remove missing modules
            modified |= orderList.removeIf(name -> !discovered.containsKey(name));

            // Insert new modules based on priority
            for (ModuleMetadataWrapper wrapper : discovered.values()) {
                if (!orderList.contains(wrapper.meta.name)) {
                    insertInOrder(orderList, discovered, wrapper.meta.name);
                    modified = true;
                }
            }

            if (modified) {
                saveExternalOrderList(pluginsDir, orderList);
            }

            // 3. Sort wrappers based on finalized orderList
            List<ModuleMetadataWrapper> sortedWrappers = new ArrayList<>();
            for (String moduleName : orderList) {
                ModuleMetadataWrapper wrapper = discovered.get(moduleName);
                if (wrapper != null) sortedWrappers.add(wrapper);
            }

            // 4. Load modules in order
            for (ModuleMetadataWrapper wrapper : sortedWrappers) {
                try {
                    loadModule(wrapper);
                } catch (Exception e) {
                    log.error("Failed to load module {}: {}", wrapper.file.getName(), e.toString());
                }
            }
        } catch (Exception e) {
            log.error("Error during module scanning: {}", e.toString());
        }
    }

    private void insertInOrder(List<String> order, Map<String, ModuleMetadataWrapper> discovered, String newName) {
        int newPriority = discovered.get(newName).meta.priority;
        for (int i = 0; i < order.size(); i++) {
            ModuleMetadataWrapper existing = discovered.get(order.get(i));
            if (existing != null && newPriority < existing.meta.priority) {
                order.add(i, newName);
                return;
            }
        }
        order.add(newName);
    }

    private List<String> loadExternalOrderList(Path pluginsDir) {
        Path orderFile = pluginsDir.resolve("order.json");
        if (!Files.exists(orderFile)) return new ArrayList<>();

        try (Reader reader = Files.newBufferedReader(orderFile)) {
            List<String> list = gson.fromJson(reader, new TypeToken<List<String>>() {}.getType());
            return list != null ? list : new ArrayList<>();
        } catch (Exception e) {
            log.warn("Failed to parse order.json: {}", e.toString());
            return new ArrayList<>();
        }
    }

    private void saveExternalOrderList(Path pluginsDir, List<String> order) {
        Path orderFile = pluginsDir.resolve("order.json");
        try (BufferedWriter writer = Files.newBufferedWriter(orderFile)) {
            gson.toJson(order, writer);
        } catch (Exception e) {
            log.error("Failed to save order.json: {}", e.toString());
        }
    }

    private Map<String, Integer> loadExternalOrder(Path pluginsDir) {
        return null; // Deprecated, replaced by list-based logic
    }

    private ModuleMetadataWrapper readMetadata(File jarFile) throws Exception {
        try (JarFile jar = new JarFile(jarFile)) {
            JarEntry entry = jar.getJarEntry("module.json");
            if (entry == null) {
                log.warn("Skipping JAR {}: No module.json found in the root of the archive.", jarFile.getName());
                return null;
            }

            ModuleMetadata meta;
            try (InputStreamReader reader = new InputStreamReader(jar.getInputStream(entry))) {
                meta = gson.fromJson(reader, ModuleMetadata.class);
            }
            return new ModuleMetadataWrapper(jarFile, meta);
        }
    }

    private void loadModule(ModuleMetadataWrapper wrapper) throws Exception {
        File jarFile = wrapper.file;
        ModuleMetadata meta = wrapper.meta;

        if (meta.main == null || meta.name == null) {
            log.error("Module {} has invalid module.json (missing main or name)", jarFile.getName());
            return;
        }

        if (!isCompatible(meta)) {
            return; // reason already logged
        }

        log.info("Loading module {} (v{}) with priority {} from {}", meta.name, meta.version, meta.priority, jarFile.getName());

            URLClassLoader loader = new URLClassLoader(
                    new URL[]{jarFile.toURI().toURL()},
                    getClass().getClassLoader()
            );

            Class<?> clazz = loader.loadClass(meta.main);
            if (!ProxyModule.class.isAssignableFrom(clazz)) {
                log.error("Main class {} in {} does not implement ProxyModule", meta.main, meta.name);
                return;
            }

            ProxyModule module = (ProxyModule) clazz.getDeclaredConstructor().newInstance();
            ModuleEntry entry = new ModuleEntry(meta.name, meta.version, module);
            
            // Create scoped context
            ModuleContext context = new ModuleContext() {
                private final Logger moduleLog = LoggerFactory.getLogger(meta.name);

                @Override
                public Logger getLogger() { return moduleLog; }

                @Override
                public void registerHandler(PacketHandlerFactory factory) {
                    HandlerRegistry.register(factory);
                    moduleLog.info("Registered packet handler factory.");
                }

                @Override
                public void registerSettings(JPanel panel) {
                    entry.settingsPanel = panel;
                    moduleLog.info("Registered settings panel.");
                }

                @Override
                public String getCoreVersion() { return Version.VERSION; }
            };

            module.onEnable(context);
            loadedModules.add(entry);
            log.info("Module {} enabled successfully.", meta.name);
    }

    private boolean isCompatible(ModuleMetadata meta) {
        SemVer core = SemVer.parse(Version.VERSION);
        if (!SemVer.inRange(core, meta.minCoreVersion, meta.maxCoreVersion)) {
            StringBuilder need = new StringBuilder();
            if (meta.minCoreVersion != null) need.append("≥ ").append(meta.minCoreVersion);
            if (meta.maxCoreVersion != null) {
                if (need.length() > 0) need.append(", ");
                need.append("≤ ").append(meta.maxCoreVersion);
            }
            log.warn("Skipping module {} (v{}): requires core {} but current is {}",
                    meta.name, meta.version, need, Version.VERSION);
            return false;
        }
        return true;
    }

    public List<ModuleEntry> getLoadedModules() {
        return Collections.unmodifiableList(loadedModules);
    }

    public void moveUp(int index) {
        if (index > 0 && index < loadedModules.size()) {
            Collections.swap(loadedModules, index, index - 1);
            saveOrder();
        }
    }

    public void moveDown(int index) {
        if (index >= 0 && index < loadedModules.size() - 1) {
            Collections.swap(loadedModules, index, index + 1);
            saveOrder();
        }
    }

    private void saveOrder() {
        if (currentPluginsDir == null) return;
        List<String> names = loadedModules.stream().map(m -> m.name).collect(Collectors.toList());
        saveExternalOrderList(currentPluginsDir, names);
    }

    public void disableModules() {
        for (ModuleEntry entry : loadedModules) {
            try {
                entry.instance.onDisable();
            } catch (Exception e) {
                log.error("Error disabling module {}: {}", entry.name, e.toString());
            }
        }
        loadedModules.clear();
    }

    public static class ModuleEntry {
        public final String name;
        public final String version;
        public final ProxyModule instance;
        public JPanel settingsPanel;

        public ModuleEntry(String name, String version, ProxyModule instance) {
            this.name = name;
            this.version = version;
            this.instance = instance;
        }

        @Override
        public String toString() {
            return name + " (v" + version + ")";
        }
    }

    private static class ModuleMetadata {
        String name;
        String version;
        String main;
        int priority = 100; // Default priority
        String minCoreVersion; // optional; inclusive lower bound (e.g. "1.0.0")
        String maxCoreVersion; // optional; inclusive upper bound (e.g. "1.5.0")
    }

    private static class ModuleMetadataWrapper {
        final File file;
        final ModuleMetadata meta;
        ModuleMetadataWrapper(File file, ModuleMetadata meta) {
            this.file = file;
            this.meta = meta;
        }
    }
}
