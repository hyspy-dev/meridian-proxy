# Meridian Proxy

A transparent man-in-the-middle proxy for Hytale game traffic. It intercepts the
QUIC connection between the Hytale client and a dedicated server, enabling
real-time packet inspection, modification, and injection while keeping a fully
authenticated session on both sides.

> For educational and research purposes only. Not affiliated with Hypixel Studios
> or Hytale.

**Community & support:** [Discord](https://discord.gg/kApV2z2Qmw)

---

## Quick Start

1. **Download** the latest `meridian-proxy-*-all.jar` from the [Releases](../../releases) page.
2. Start the **Hytale launcher**, sign in, and click **Play**.
3. **Double-click the jar.** A window opens — wait for the *Hytale game* indicator
   to turn green, type the target server into **Remote**, and click **Connect**.
4. In the Hytale client, **Direct Connect** to `localhost`.

That's the standalone flow. There are three launch modes in total — see
**[docs/launch-modes.md](docs/launch-modes.md)**.

## Launch Modes

| Mode | You run | Best for |
|------|---------|----------|
| **1 — Server-jar replacement** | the Hytale launcher (it starts the proxy for you) | playing through the launcher's single-player UI |
| **2 — Standalone GUI** | the proxy jar directly (double-click) | most users — Windows / Linux |
| **3 — Standalone CLI** | the jar from a terminal (`--session-token`) | macOS, headless, automation |

Mode 1 replaces the game's bundled server file (`HytaleServer.jar` in the Hytale
install directory) — the launcher then runs the proxy in its place. Modes 2 and 3
run the proxy jar on its own, alongside an unmodified game install.

The proxy never mints its own Hytale session — Hytale allows one active session per
account, so it reuses the running game's session. Full setup for each mode:
**[docs/launch-modes.md](docs/launch-modes.md)**.

## Documentation

- **[Launch Modes](docs/launch-modes.md)** — setup guide for all three modes
- **[Architecture](docs/architecture.md)** — connection flow, auth, packet protocol, pipeline
- **[Plugin Modules](docs/modules.md)** — writing and loading extension JARs
- **[Updating](docs/updating.md)** — what to rebuild when something changes, and how the proxy flags staleness
- **[Releasing](docs/releasing.md)** — versioning, tags, and the Hytale-update workflow
- **[Troubleshooting](docs/troubleshooting.md)** — common errors and fixes

## Extending Meridian

Meridian is layered Maven artifacts:

- **`meridian-api`** — the stable module SPI. Protocol-neutral; survives Hytale updates.
- **`meridian-protocol`** — Hytale packet classes. BETA — changes with every Hytale build.
- **`meridian-proxy`** — the proxy implementation (this uber-jar).
- **`meridian-core`** — a Layer-1 module: headless game state, published as `meridian-core-api`.

Two ways to build a module:

- **Layer-2 module** — the normal case (xray, esp, ...). Depend on `meridian-api`
  plus the Layer-1 `*-api` you need (e.g. `meridian-core-api`), both `provided`.
  **Do not** depend on `meridian-protocol` — a Hytale update cannot break you.
- **Layer-1 framework** — raw-packet access (packet loggers, new core services).
  Depend on `meridian-api` + `meridian-protocol`; you absorb protocol churn yourself.

See [docs/modules.md](docs/modules.md) to write one, [docs/architecture.md](docs/architecture.md)
for the layering model.

**Hytale compatibility:** a proxy build embeds one `meridian-protocol` version,
targeting one Hytale build range — see [docs/releasing.md](docs/releasing.md).

## Platform Support

A single uber-jar runs cross-platform — it bundles the native QUIC codec for every
supported OS. Java 22+ is required to run it.

| Platform | Runs the proxy | Game-session auto-detect (Mode 2) |
|----------|:--------------:|:---------------------------------:|
| Windows x86_64 | ✅ | ✅ |
| Linux x86_64 | ✅ | ✅ |
| macOS Intel (x86_64) | ✅ | ❌ — paste the token, or use [Mode 3](docs/launch-modes.md#mode-3--standalone-cli) |
| macOS Apple Silicon (arm64) | ⚠️ via x86_64 JVM under Rosetta 2 | ❌ |

**Not supported:** Linux arm64, Windows arm64 — the bundled QUIC codec
(`netty-incubator-codec-native-quic 0.0.60.Final`) ships x86_64 natives only. There
is no aarch64 build at this version, so ARM platforms have no working QUIC transport.

> Game-session auto-detection (reading the running game's session in standalone GUI
> mode) is implemented for Windows and Linux. On macOS the **Session token** field
> must be filled manually — see [docs/launch-modes.md](docs/launch-modes.md).

## Build

Requires **Java 22+** and **Maven 3.8+**. The build is platform-agnostic — the
produced jar carries natives for all supported platforms regardless of where it
was built.

```bash
cd meridian-proxy
mvn clean package -DskipTests
```

This is a multi-module reactor — it builds `meridian-api`, `meridian-protocol` and
`meridian-proxy`. The runnable uber-jar (built by `maven-shade-plugin`) is:

```
meridian-proxy/target/meridian-proxy-<version>-all.jar
```

Run that one — the thin jars alongside it are not runnable standalone.

`<version>` comes from `git describe --tags` at build time: `proxy-v1.5.0` on a tag,
`…-3-gabc1234` between tags, `-dirty` with uncommitted changes. The same string
appears in the window title and the `Implementation-Version` manifest entry.

### Releasing

Meridian's artifacts are versioned and tagged independently
(`api-v…`, `protocol-v…`, `proxy-v…`). The full scheme, tag conventions and the
Hytale-update workflow are in **[docs/releasing.md](docs/releasing.md)**.

## License

Mozilla Public License 2.0 — see [LICENSE](LICENSE).
