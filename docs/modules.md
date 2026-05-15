# Plugin Modules

The proxy is a **base for layered modules** — the built-in auth handling is just
the first `PacketHandler`. Custom logic (world-save, analytics, client-side mods,
CTF / research tooling) plugs in via external JAR modules.

See [meridian-xray](../../meridian-xray) for a working reference implementation.

## Loading

Modules are **per-server** — isolated so behavior from one world cannot spill into
another. They are loaded dynamically from:

```
%AppData%\Roaming\Hytale\UserData\Saves\<servername>\modules
```

Load order is persisted in `order.json` next to the JARs.

## Creating a module

1. It must be a standard `.jar` file.
2. It **must contain a `module.json` manifest** in the archive root:

   ```json
   {
     "name": "Xray",
     "version": "1.0",
     "main": "com.mypackage.MyModule",
     "priority": 100,
     "minCoreVersion": "1.0.0",
     "maxCoreVersion": "1.5.0"
   }
   ```

   - `priority` — lower loads earlier; default `100`.
   - `minCoreVersion` / `maxCoreVersion` — **optional** inclusive bounds, compared
     against the core's `git describe` version (only `MAJOR.MINOR.PATCH` is used —
     git suffixes ignored). Outside the range, the module is skipped *before*
     classloading with a clear `WARN`. Use these for hard compatibility — anything
     that would otherwise crash with `NoSuchMethodError`.

3. The `main` class must implement `ProxyModule`.

## Soft feature detection

For optional behavior the module can enable when the core is new enough (but
doesn't strictly require), use `ModuleContext.getCoreVersion()` from `onEnable()`:

```java
@Override
public void onEnable(ModuleContext ctx) {
    ctx.getLogger().info("Running on core {}", ctx.getCoreVersion());
    // Enable an extra hook only on 1.1.0+
    if (SemVer.inRange(SemVer.parse(ctx.getCoreVersion()), "1.1.0", null)) {
        ctx.registerHandler(new OptionalNewApiHandler());
    }
    ctx.registerHandler(new BaselineHandler());
}
```

Rule of thumb: the **declarative gate in `module.json` is the primary mechanism** —
it runs before classloading and protects against missing APIs. `getCoreVersion()`
is purely for adapting behavior when the module *can* work either way.

## PacketHandler contract

A handler returns one of:

| Action | Meaning |
|--------|---------|
| `FORWARD` | Pass-through — the original raw frame is shipped |
| `MODIFIED` | Continue the chain; the router re-serialises the mutated `Packet` |
| `DROP` | Suppress the packet entirely |
| `HANDLED` | Async takeover — the handler is responsible for any response |

Every call receives a `ProxySession`, which exposes `sendToClient()` /
`sendToServer()` for packet injection from any handler. See
[architecture.md](architecture.md#pipeline-architecture) for where handlers sit
in the pipeline.
