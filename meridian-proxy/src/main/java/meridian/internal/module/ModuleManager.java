package meridian.internal.module;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import meridian.api.event.EventBus;
import meridian.api.module.ProxyModule;
import meridian.api.service.ServiceRegistry;
import meridian.internal.SemVer;
import meridian.internal.Version;
import meridian.internal.event.EventBusImpl;
import meridian.internal.service.ServiceRegistryImpl;
import meridian.protocol.PacketRegistry;
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
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Discovers and loads external modules from JAR files.
 *
 * <p>Module-system v2 load pipeline:
 * <ol>
 *   <li>scan all {@code .jar}s, read {@code module.json}</li>
 *   <li>filter by {@code minProxyVersion}/{@code maxProxyVersion}</li>
 *   <li>capability gating: skip modules whose {@code requires.packets} are
 *       absent from the current protocol</li>
 *   <li>topological sort by {@code dependsOn} (priority breaks ties)</li>
 *   <li>load every surviving jar into a single shared class loader</li>
 *   <li>{@code onEnable} in dependency order</li>
 * </ol>
 * Every skip is logged with a WARN explaining why; nothing crashes the proxy.
 */
public class ModuleManager {
    private static final Logger log = LoggerFactory.getLogger(ModuleManager.class);
    private static final Gson gson = new Gson();

    private final HandlerRegistry handlerRegistry = new HandlerRegistry();
    private final Executor offloadExecutor = Executors.newVirtualThreadPerTaskExecutor();
    private final EventBus eventBus = new EventBusImpl(offloadExecutor);
    private final ServiceRegistry serviceRegistry = new ServiceRegistryImpl();
    private final List<ModuleEntry> loadedModules = new ArrayList<>();
    private final List<SkippedModule> skippedModules = new ArrayList<>();
    private Path currentPluginsDir;

    /** Packet-handler factories registered by modules; consumed by the pipeline. */
    public HandlerRegistry handlerRegistry() {
        return handlerRegistry;
    }

    /** Modules found but not loaded (incompatible) — surfaced in the management UI. */
    public List<SkippedModule> getSkippedModules() {
        return Collections.unmodifiableList(skippedModules);
    }

    /** Process-wide event bus; the pipeline emits built-in events onto it. */
    public EventBus eventBus() {
        return eventBus;
    }

    public void loadModules(Path pluginsDir) {
        this.currentPluginsDir = pluginsDir;
        skippedModules.clear();
        log.info("Scanning for modules in {}...", pluginsDir.toAbsolutePath());

        try {
            if (!Files.exists(pluginsDir)) {
                log.info("Modules directory '{}' does not exist. Creating it...", pluginsDir.toAbsolutePath());
                Files.createDirectories(pluginsDir);
                log.info("Please place your module JARs (like meridian-xray.jar) in this folder and restart.");
                return;
            }

            File[] files = pluginsDir.toFile().listFiles((dir, name) -> name.endsWith(".jar"));
            if (files == null || files.length == 0) {
                log.warn("No .jar files found in the modules folder!");
                return;
            }

            // 1. Scan all JARs for metadata.
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

            // 2. Base ordering (user-reorderable via order.json / the Management UI).
            List<String> orderList = loadExternalOrderList(pluginsDir);
            boolean modified = orderList.removeIf(name -> !discovered.containsKey(name));
            for (ModuleMetadataWrapper wrapper : discovered.values()) {
                if (!orderList.contains(wrapper.meta.name)) {
                    insertInOrder(orderList, discovered, wrapper.meta.name);
                    modified = true;
                }
            }
            if (modified) {
                saveExternalOrderList(pluginsDir, orderList);
            }

            // 3. Compatibility + capability gating.
            Set<String> knownPackets = knownPacketNames();
            Map<String, ModuleMetadataWrapper> eligible = new LinkedHashMap<>();
            for (String name : orderList) {
                ModuleMetadataWrapper wrapper = discovered.get(name);
                if (wrapper == null) continue;
                if (wrapper.meta.main == null || wrapper.meta.name == null) {
                    log.error("Module {} has invalid module.json (missing main or name)", wrapper.file.getName());
                    continue;
                }
                if (!isProxyCompatible(wrapper.meta)) continue;          // reason logged
                if (!hasRequiredPackets(wrapper.meta, knownPackets)) continue;  // reason logged
                eligible.put(name, wrapper);
            }

            // 4. Resolve dependsOn → topological load order.
            List<ModuleMetadataWrapper> ordered = resolveLoadOrder(eligible, orderList);
            if (ordered.isEmpty()) {
                log.info("No modules to load.");
                return;
            }

            // 5. One shared class loader for every surviving module.
            List<URL> urls = new ArrayList<>();
            for (ModuleMetadataWrapper w : ordered) {
                urls.add(w.file.toURI().toURL());
            }
            URLClassLoader sharedLoader = new URLClassLoader(
                    urls.toArray(new URL[0]), getClass().getClassLoader());

            // 6. Load + enable in dependency order.
            for (ModuleMetadataWrapper wrapper : ordered) {
                try {
                    loadModule(wrapper, sharedLoader);
                } catch (Exception e) {
                    log.error("Failed to load module {}: {}", wrapper.file.getName(), e.toString());
                }
            }
        } catch (Exception e) {
            log.error("Error during module scanning: {}", e.toString());
        }
    }

    // ------------------------------------------------------------------
    // Gating
    // ------------------------------------------------------------------

    private static Set<String> knownPacketNames() {
        Set<String> names = new HashSet<>();
        for (PacketRegistry.PacketInfo info : PacketRegistry.all().values()) {
            names.add(info.name());
        }
        return names;
    }

    /** Trailing " Update it: <url>" hint for skip warnings, or "" if the module declares none. */
    private static String updateHint(ModuleMetadata meta) {
        return (meta.updateUrl != null && !meta.updateUrl.isBlank())
                ? "  Update it: " + meta.updateUrl
                : "";
    }

    private boolean isProxyCompatible(ModuleMetadata meta) {
        SemVer proxy = SemVer.parse(Version.VERSION);
        String min = meta.effectiveMinVersion();
        String max = meta.effectiveMaxVersion();
        if (!SemVer.inRange(proxy, min, max)) {
            StringBuilder need = new StringBuilder();
            if (min != null) need.append("≥ ").append(min);
            if (max != null) {
                if (need.length() > 0) need.append(", ");
                need.append("≤ ").append(max);
            }
            log.warn("Skipping module {} (v{}): requires proxy {} but current is {}.{}",
                    meta.name, meta.version, need, Version.VERSION, updateHint(meta));
            skippedModules.add(new SkippedModule(meta.name, meta.version,
                    "requires proxy " + need + " but this build is " + Version.VERSION, meta.updateUrl));
            return false;
        }
        return true;
    }

    private boolean hasRequiredPackets(ModuleMetadata meta, Set<String> knownPackets) {
        if (meta.requires == null || meta.requires.packets == null) return true;
        for (String pkt : meta.requires.packets) {
            if (!knownPackets.contains(pkt)) {
                log.warn("Skipping module {} (v{}): requires packet '{}' which the current protocol does not define.{}",
                        meta.name, meta.version, pkt, updateHint(meta));
                skippedModules.add(new SkippedModule(meta.name, meta.version,
                        "needs packet '" + pkt + "' — the proxy's protocol is out of date", meta.updateUrl));
                return false;
            }
        }
        return true;
    }

    /**
     * Topologically sorts {@code eligible} by {@code dependsOn}. Modules whose
     * declared dependency is missing or out of range are dropped (with their
     * transitive dependents); dependency cycles are dropped too. Within a
     * dependency level, {@code baseOrder} preserves the user-chosen ordering.
     */
    private List<ModuleMetadataWrapper> resolveLoadOrder(
            Map<String, ModuleMetadataWrapper> eligible, List<String> baseOrder) {

        // 5a. Drop modules with unsatisfiable dependsOn — to a fixpoint, so a
        //     dependent of a dropped module is dropped as well.
        Map<String, ModuleMetadataWrapper> live = new LinkedHashMap<>(eligible);
        boolean changed = true;
        while (changed) {
            changed = false;
            for (ModuleMetadataWrapper w : new ArrayList<>(live.values())) {
                Map<String, String> deps = w.meta.dependsOn;
                if (deps == null) continue;
                for (Map.Entry<String, String> dep : deps.entrySet()) {
                    ModuleMetadataWrapper target = live.get(dep.getKey());
                    String reason = null;
                    if (target == null) {
                        reason = "dependency '" + dep.getKey() + "' is not present or was skipped";
                    } else if (!satisfiesRange(SemVer.parse(target.meta.version), dep.getValue())) {
                        reason = "dependency '" + dep.getKey() + "' v" + target.meta.version
                                + " is outside required range '" + dep.getValue() + "'";
                    }
                    if (reason != null) {
                        log.warn("Skipping module {} (v{}): {}.{}",
                                w.meta.name, w.meta.version, reason, updateHint(w.meta));
                        skippedModules.add(new SkippedModule(
                                w.meta.name, w.meta.version, reason, w.meta.updateUrl));
                        live.remove(w.meta.name);
                        changed = true;
                        break;
                    }
                }
            }
        }

        // 5b. Kahn's algorithm; the ready-queue is drained in baseOrder order.
        Map<String, Integer> inDegree = new HashMap<>();
        Map<String, List<String>> dependents = new HashMap<>();
        for (String name : live.keySet()) {
            inDegree.put(name, 0);
            dependents.put(name, new ArrayList<>());
        }
        for (ModuleMetadataWrapper w : live.values()) {
            if (w.meta.dependsOn == null) continue;
            for (String dep : w.meta.dependsOn.keySet()) {
                inDegree.merge(w.meta.name, 1, Integer::sum);
                dependents.get(dep).add(w.meta.name);
            }
        }

        List<String> ready = new ArrayList<>();
        for (String name : baseOrder) {
            if (live.containsKey(name) && inDegree.get(name) == 0) ready.add(name);
        }

        List<ModuleMetadataWrapper> ordered = new ArrayList<>();
        while (!ready.isEmpty()) {
            String name = ready.remove(0);
            ordered.add(live.get(name));
            for (String dependent : dependents.get(name)) {
                if (inDegree.merge(dependent, -1, Integer::sum) == 0) {
                    // Re-insert respecting baseOrder so ties stay deterministic.
                    int idx = baseOrder.indexOf(dependent);
                    int pos = 0;
                    while (pos < ready.size() && baseOrder.indexOf(ready.get(pos)) < idx) pos++;
                    ready.add(pos, dependent);
                }
            }
        }

        if (ordered.size() < live.size()) {
            for (String name : live.keySet()) {
                if (ordered.stream().noneMatch(w -> w.meta.name.equals(name))) {
                    log.error("Skipping module {}: part of a dependsOn cycle", name);
                }
            }
        }
        return ordered;
    }

    /**
     * Tests whether {@code version} satisfies a space-separated range such as
     * {@code ">=1.0.0 <2.0.0"}. Supported operators: {@code >= <= > < =}; a bare
     * version means {@code >=}. Unparseable tokens are treated leniently (pass).
     */
    private static boolean satisfiesRange(SemVer version, String range) {
        if (range == null || range.isBlank() || version == null) return true;
        for (String token : range.trim().split("\\s+")) {
            String op = "=";
            String ver = token;
            if (token.startsWith(">=") || token.startsWith("<=")) {
                op = token.substring(0, 2);
                ver = token.substring(2);
            } else if (token.startsWith(">") || token.startsWith("<") || token.startsWith("=")) {
                op = token.substring(0, 1);
                ver = token.substring(1);
            } else {
                op = ">=";
            }
            SemVer bound = SemVer.parse(ver);
            if (bound == null) continue;
            int cmp = version.compareTo(bound);
            boolean ok = switch (op) {
                case ">=" -> cmp >= 0;
                case "<=" -> cmp <= 0;
                case ">"  -> cmp > 0;
                case "<"  -> cmp < 0;
                default   -> cmp == 0;
            };
            if (!ok) return false;
        }
        return true;
    }

    // ------------------------------------------------------------------
    // order.json (user-facing base ordering)
    // ------------------------------------------------------------------

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

    // ------------------------------------------------------------------
    // Loading
    // ------------------------------------------------------------------

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

    private void loadModule(ModuleMetadataWrapper wrapper, ClassLoader loader) throws Exception {
        ModuleMetadata meta = wrapper.meta;
        log.info("Loading module {} (v{}) with priority {} from {}",
                meta.name, meta.version, meta.priority, wrapper.file.getName());

        Class<?> clazz = loader.loadClass(meta.main);
        if (!ProxyModule.class.isAssignableFrom(clazz)) {
            log.error("Main class {} in {} does not implement ProxyModule", meta.main, meta.name);
            return;
        }

        ProxyModule module = (ProxyModule) clazz.getDeclaredConstructor().newInstance();

        Path dataDir = currentPluginsDir.resolve(meta.name).resolve("data");
        SchedulerImpl scheduler = new SchedulerImpl(meta.name);
        ModuleContextImpl context = new ModuleContextImpl(meta.name, dataDir, handlerRegistry,
                eventBus, serviceRegistry, offloadExecutor, scheduler);
        ModuleEntry entry = new ModuleEntry(meta.name, meta.version, module, context);

        module.onEnable(context);
        entry.settingsPanel = context.settingsPanel;
        loadedModules.add(entry);
        log.info("Module {} enabled successfully.", meta.name);
    }

    // ------------------------------------------------------------------
    // Management UI support
    // ------------------------------------------------------------------

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
            entry.context.runShutdown();
        }
        loadedModules.clear();
    }

    /**
     * A module that was discovered but not loaded because it is incompatible.
     *
     * @param reason    human-readable why it was skipped
     * @param updateUrl the module's {@code updateUrl}, or null
     */
    public record SkippedModule(String name, String version, String reason, String updateUrl) {}

    public static class ModuleEntry {
        public final String name;
        public final String version;
        public final ProxyModule instance;
        final ModuleContextImpl context;
        public JPanel settingsPanel;

        public ModuleEntry(String name, String version, ProxyModule instance, ModuleContextImpl context) {
            this.name = name;
            this.version = version;
            this.instance = instance;
            this.context = context;
        }

        @Override
        public String toString() {
            return name + " (v" + version + ")";
        }
    }

    /** {@code module.json} schema (v2). */
    private static class ModuleMetadata {
        String name;
        String version;
        String main;
        int priority = 100;

        // v2 names; minCoreVersion/maxCoreVersion kept as aliases for modules
        // built against the v1 schema.
        String minProxyVersion;
        String maxProxyVersion;
        String minCoreVersion;
        String maxCoreVersion;

        /** Where the user should get a compatible build — shown when this module is skipped. */
        String updateUrl;

        Map<String, String> dependsOn;
        Requires requires;

        String effectiveMinVersion() {
            return minProxyVersion != null ? minProxyVersion : minCoreVersion;
        }

        String effectiveMaxVersion() {
            return maxProxyVersion != null ? maxProxyVersion : maxCoreVersion;
        }
    }

    private static class Requires {
        List<String> packets;
        List<String> services;
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
