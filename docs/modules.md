# Plugin Modules

Meridian is a layered module platform. Custom logic — world tooling, client-side
mods, analytics, CTF / research — ships as external JAR modules loaded at runtime.

See [meridian-camera-tweaks](../../meridian-camera-tweaks) for a working
Layer-2 reference, and the **Extending Meridian** section of the
[README](../README.md) for the artifact layout.

## Two kinds of module

| | Depends on (`provided`) | Sees raw packets? | Hytale-update exposure |
|--|--|--|--|
| **Layer 2** (normal) | `meridian-api` + a Layer-1 `*-api` (e.g. `meridian-core-api`) | no | none — protocol-neutral |
| **Layer 1** (framework) | `meridian-api` + `meridian-protocol` | yes | absorbs protocol churn itself |

Most modules are Layer 2: they talk to a Layer-1 service (`meridian-core`'s
`WorldState`, ...) and never touch `meridian-protocol`, so a Hytale update cannot
break them. Only build Layer 1 when you genuinely need raw packets. See
[updating.md](updating.md) for what that exposure means.

## Loading

Modules are **per-server** — isolated so one server's modules cannot run for
another. The directory depends on the launch mode:

- **Launcher mode:** `…\Saves\<world>\modules\`
- **Standalone:** `<jar-dir>\<host_port>\modules\` (e.g. `…\45.12.34.56_5520\modules\`)

All module JARs load into one shared class loader. Load order is the topological
sort of `dependsOn` (a module always loads after its dependencies); `order.json`
next to the JARs breaks ties and is editable from the Management UI.

### Per-connection runtime

The module runtime is **per connection, not per process.** Each Connect builds a
fresh `ModuleManager` (and a fresh class loader, `HandlerRegistry`, `EventBus`,
`ServiceRegistry`) for the connected server's module directory; each Disconnect
fully unloads it — `onDisable` runs, every `onShutdown` hook fires, the scheduler
stops, and the class loader is closed. Reconnecting to a **different** server
therefore loads that server's module set with no process restart (see
[architecture.md](architecture.md#connection-lifecycle)).

Because Disconnect closes the class loader and stops the module's offload
executor, a module **must release everything it owns** in `onDisable` /
`onShutdown` (threads it spawned itself, native handles, listeners). State left
behind would leak across a reconnect or keep the old class loader alive.

## `module.json`

Every module JAR **must** contain `module.json` in its archive root:

```json
{
  "name": "Meridian Minimap",
  "version": "0.1.0",
  "main": "meridian.minimap.MinimapModule",
  "priority": 100,
  "minProxyVersion": "1.0.0",
  "maxProxyVersion": "2.0.0",
  "updateUrl": "https://github.com/you/your-module/releases",
  "dependsOn": { "meridian-core": ">=0.2.0" },
  "requires": {
    "packets": ["CustomHud", "UpdateWorldMap", "ClientMovement", "JoinWorld"],
    "services": ["meridian.core.api.EntityTracker"]
  }
}
```

| Field | Required | Meaning |
|-------|----------|---------|
| `name` | yes | Unique module id; used as the key in other modules' `dependsOn` |
| `version` | yes | Module SemVer |
| `main` | yes | FQCN of the `ProxyModule` implementation (no-args constructor) |
| `priority` | no (100) | Lower loads earlier, within one `dependsOn` level |
| `minProxyVersion` / `maxProxyVersion` | no | Proxy SemVer range; checked **before** classloading. Legacy aliases: `minCoreVersion` / `maxCoreVersion` |
| `updateUrl` | no | Shown to the user if the proxy skips this module as incompatible — strongly recommended |
| `dependsOn` | no | Map of module-name → SemVer range. Missing/out-of-range → this module is skipped with a WARN |
| `requires.packets` | no | Protocol packet names a **Layer-1** module needs; absent from the protocol → skipped + WARN |
| `requires.services` | no | Service FQCNs a **Layer-2** module expects in the `ServiceRegistry` |

Every incompatibility is a WARN + skip — nothing crashes the proxy.

## `ProxyModule` and `ModuleContext`

```java
public class MyModule implements ProxyModule {
    @Override public void onEnable(ModuleContext ctx) { /* wire everything here */ }
    @Override public void onDisable() {}   // optional
}
```

`ModuleContext` is the whole API surface a module gets:

| Method | Purpose |
|--------|---------|
| `getLogger()` | slf4j logger scoped to the module |
| `registerHandler(Direction, HandlerPosition, PacketHandlerFactory)` | Add a packet handler (Layer-1 / raw-packet) |
| `registerSettings(SettingsSpec)` | Declarative settings UI; the proxy renders it and persists to `<dataDir>/settings.json`. Full reference: [settings.md](settings.md) |
| `events()` | `EventBus` — subscribe to `PhaseChangedEvent`, ... |
| `services()` | `ServiceRegistry` — `provide()` (Layer 1) / `require()` (Layer 2) |
| `scheduler()` | Tickers / deferred tasks; futures auto-cancelled on shutdown |
| `offloadExecutor()` | Virtual-thread executor for blocking work — never block `handle*()` |
| `getDataDir()` | Per-module data directory |
| `onShutdown(Runnable)` | Finalizer run at process shutdown |
| `getCoreVersion()` | Running proxy version — for soft feature detection only |

`registerSettings(JPanel)` still exists but is `@Deprecated` — use `SettingsSpec`.

## Consuming a Layer-1 service (the Layer-2 path)

```java
@Override
public void onEnable(ModuleContext ctx) {
    WorldState world = ctx.services().require(WorldState.class);
    ctx.events().subscribe(PhaseChangedEvent.class, EventPriority.NORMAL, e -> { ... });
    ctx.registerSettings(SettingsSpec.builder()
            .bool("enabled", "Enable", false, v -> { /* ... */ })
            .build());
}
```

`dependsOn` guarantees the service provider (`meridian-core`) is enabled first.

## `PacketHandler` contract (Layer-1)

A handler registered via `registerHandler` returns one of:

| Action | Meaning |
|--------|---------|
| `FORWARD` | Pass-through — the original raw frame is shipped |
| `MODIFIED` | Continue the chain; the router re-serialises the mutated `Packet` |
| `DROP` | Suppress the packet |
| `HANDLED` | Takeover — the handler is responsible for any response |

`HandlerPosition` (`EARLY` / `NORMAL` / `LATE` / `MONITOR`) orders handlers within
the chain; `MONITOR` is observe-only. See [architecture.md](architecture.md#pipeline-architecture).
