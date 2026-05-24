# Launch Modes

Meridian Proxy can be started in three ways. They differ only in **how the proxy
obtains a Hytale session** — the proxying itself is identical. Pick the one that
matches your setup.

| Mode | You run | Token source | Best for |
|------|---------|--------------|----------|
| [1 — Server-jar replacement](#mode-1--server-jar-replacement) | the Hytale launcher | env vars set by the launcher | playing through the launcher's single-player UI |
| [2 — Standalone GUI](#mode-2--standalone-gui) | the proxy jar (double-click) | auto-read from the running game | most users, Windows / Linux |
| [3 — Standalone CLI](#mode-3--standalone-cli) | the proxy jar from a terminal | `--session-token` argument | macOS, headless, automation |

> **One session per account.** Hytale allows a single active session per account.
> The proxy therefore never mints its own — it reuses the session the Hytale game
> already holds and derives a server-scope child session from it. This is why
> modes 2 and 3 need the game (or at least its session token) to be available.

> **Platforms.** The proxy runs on Windows x86_64, Linux x86_64, and macOS (Intel
> natively; Apple Silicon through Rosetta 2). ARM64 is **not supported** — the
> bundled QUIC codec has no aarch64 native. Full matrix in the
> [README](../README.md#platform-support).

---

## Mode 1 — Server-jar replacement

Mode 1 plugs into the Hytale launcher's documented single-player flow — the
launcher invokes whichever `HytaleServer.jar` sits in the install's server
directory and hands it the session tokens via environment variables. By
swapping that jar for the proxy you let the launcher start the proxy
automatically; the proxy re-invokes the real server jar for genuine local
play.

### Setup (one-time)

1. Open the Hytale install's server directory:
   `%AppData%\Roaming\Hytale\install\release\package\game\latest\Server`
2. Rename the original `HytaleServer.jar` → `_HytaleServer.jar`.
3. Drop the proxy jar in as `HytaleServer.jar`.

The proxy can still launch the real server (`_HytaleServer.jar`) for genuine local
play — it auto-wraps it when the world name has no `~` prefix.

### Connecting to a remote server

In the Hytale client, create a **single-player** world and name it after the target
server's address, prefixed with `~`:

- `~45.12.34.56:5520` &nbsp;or&nbsp; `~45.12.34.56_5520`

The proxy detects the `~` prefix, skips local-server wrapping, and forwards your
session to that address. Without the prefix it behaves as a normal local server.

📺 [Video walkthrough](https://youtu.be/O_rd1cLwxMI)

---

## Mode 2 — Standalone GUI

Run the proxy jar directly. It opens a window, finds the running Hytale game, and
reads the live session straight out of the game process — nothing to copy.

### Steps

1. Start the **Hytale launcher**, sign in, and click **Play** so the game is running.
2. Double-click `meridian-proxy-*-all.jar`. A window opens with a connection bar.
3. The **Hytale game** indicator turns green and the **Session token** field
   auto-fills. (If it stays red, click **Refresh** once the game is up.)
4. Type the target server into **Remote** (e.g. `2o2t.org:5520`). Optionally change
   the **Local port** (default `5520`).
5. Click **Connect**. The bar disappears and the proxy starts listening.
6. In the Hytale client, **Direct Connect** to `localhost`.

### Platform support

| OS | Game-process snooping | Notes |
|----|----------------------|-------|
| Windows | ✅ | reads the process environment block |
| Linux | ✅ | reads `/proc/<pid>/environ` |
| macOS | ❌ not yet | the status shows yellow — paste the token manually (below) or use Mode 3 |

If snooping is unavailable you can still use the GUI: obtain a player session token
yourself and paste it into the **Session token** field. Connect then works normally.

---

## Mode 3 — Standalone CLI

Headless launch with the player session token passed as an argument. This is the
cross-platform fallback for Mode 2 — useful on macOS, on servers, or for scripting.

```bash
java -jar meridian-proxy-*-all.jar \
    --session-token "<player session token>" \
    --remote 2o2t.org:5520 \
    --bind localhost:5520 \
    --no-gui
```

The proxy uses the supplied token as the player session and derives the two
server-scope tokens itself via `POST /game-session/child`. You only ever provide
the **one** player session token.

### Getting the player session token

The token lives in the running Hytale game's environment as `HYTALE_SESSION_TOKEN`.
Read it however your OS allows, e.g. on macOS/Linux:

```bash
ps eww -p "$(pgrep -if hytale | head -1)" | tr ' ' '\n' | grep HYTALE_SESSION_TOKEN
```

Any valid `hytale:client` session token for your account works.

---

## Connection arguments

| Arg | Description | Example |
|-----|-------------|---------|
| `--session-token` | Player session token (selects Mode 3) | `--session-token "eyJ…"` |
| `--remote` | Target server `host:port` | `--remote 1.2.3.4:5520` |
| `--bind` | Local listen address / port | `--bind localhost:5520` |
| `--backup-dir` | Launcher-supplied path (Mode 1 only) | — |
| `--no-gui` | Disable the Swing window | `--no-gui` |

`--remote` and `--bind` are optional. In standalone mode, if they are present they
pre-fill the GUI fields; if absent the GUI shows its defaults. Launching with **no**
tokens and **no** `--backup-dir` always opens the standalone GUI (Mode 2).

## How a mode is selected

```
env tokens present, or --backup-dir   → Mode 1 (launcher)
--session-token present               → Mode 3 (CLI)
neither                               → Mode 2 (standalone GUI)
```
