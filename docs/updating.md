# Updating Meridian

This is the practical companion to [releasing.md](releasing.md): **when something
changes, what has to be rebuilt — and how the proxy tells the user it is stale.**

## The dependency chain

```
Hytale  ──►  meridian-protocol  ──►  meridian-proxy
                               └──►  meridian-core (impl)  ──►  meridian-core-api
                                                                      │
                          Layer-2 modules (xray, ...)  ◄──────────────┘
                          depend on meridian-api + *-core-api only
```

Hytale's protocol churn enters at `meridian-protocol` and is **absorbed** by the
mappers in `meridian-proxy` and `meridian-core`. It does **not** cross the
`*-api` line — Layer-2 modules sit behind that wall.

## What to rebuild when X changes

| You changed… | Rebuild | Untouched |
|--------------|---------|-----------|
| A Hytale packet → `meridian-protocol` | `meridian-proxy`, `meridian-core` | Layer-2 modules (xray) |
| `meridian-core` mapper (`*-impl`) only | `meridian-core` | proxy, Layer-2 modules |
| `meridian-core-api` — **additive** (new method/type) | `meridian-core` | Layer-2 modules keep working; recompile only to *use* the new API |
| `meridian-core-api` — **breaking** | `meridian-core` + every consumer | — (deliberate major bump) |
| `meridian-api` — **additive** (`default` methods) | `meridian-proxy` | modules keep working |
| `meridian-api` — **breaking** | `meridian-proxy` + every module | — (deliberate major bump) |
| `meridian-proxy` impl only | `meridian-proxy` | everything else |
| One Layer-2 module | just that module | everything else |

**Rule of thumb:** a Hytale update propagates `protocol → proxy + core` and
**stops there**. Rebuilding a Layer-2 module in response to a Hytale update means
a protocol type leaked across the `*-api` line — that is a bug.

Build order is always upstream-first — see [README](../README.md#build).

## Who / how often

| Layer | Cadence | Driven by |
|-------|---------|-----------|
| `meridian-protocol` | every Hytale build (~weekly) | Hytale releases |
| `meridian-proxy`, `meridian-core` | every Hytale build + own fixes | protocol churn |
| `meridian-api`, `meridian-core-api` | rarely | deliberate API evolution |
| Layer-2 modules | only on a deliberate `*-api` major bump | their own authors |

Reacting to a Hytale update is automated by
[`tools/regen-protocol.ps1`](../tools/regen-protocol.ps1); the full procedure is in
[releasing.md](releasing.md#reacting-to-a-hytale-update).

## How the proxy tells the user it is stale

The proxy does not fail silently — it surfaces three staleness signals, each with
a link to where the fix lives.

### 1. Protocol mismatch (the proxy itself is stale)

The client's first `Connect` packet carries its protocol CRC and build number.
The proxy compares them to the `meridian-protocol` it was built with. On a
mismatch it logs a prominent warning **with the proxy's releases link** — Hytale
updated and this proxy build needs to catch up.

### 2. Module skipped (a module is incompatible)

When `ModuleManager` skips a module — incompatible `minProxyVersion`, a missing
`requires.packets` entry, or an unsatisfied `dependsOn` — the warning names the
reason **and the module's own update link**, so the user knows where to get a
compatible build.

### 3. Unparseable packets (runtime)

Unknown packet ids and packets that fail structural validation are logged and
forwarded as raw bytes (the session survives). A burst of these means the
protocol is stale.

## `updateUrl` — for module authors

Declare where users should get updates in your `module.json`:

```json
{
  "name": "Meridian Xray",
  "version": "2.0.0",
  "main": "meridian.xray.XrayModule",
  "dependsOn": { "meridian-core": ">=0.1.0" },
  "updateUrl": "https://github.com/hyspy-dev/meridian-xray/releases"
}
```

If the proxy ever skips your module as incompatible, it shows this link to the
user verbatim. It is optional but strongly recommended — without it, an
incompatible module is just a warning with nowhere to go.
