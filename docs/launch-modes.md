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
4. Type the target server into **Remote** (e.g. `2o2t.org`). The port is optional and
   defaults to `5520`, so only a server that moved off the stock port needs
   `host:port`. **Remote** is also a dropdown of the servers already connected to —
   pick one instead of retyping it. Optionally change the **Local port**
   (default `5520`).
5. Each server gets its own module folder, `<jar-dir>/<host>_<port>/modules`. The bar
   shows whether the typed server has one; while it does not, a **Create folder**
   button appears, which creates it and opens it so module jars can be dropped in
   before the first connection.
6. Click **Connect**. The bar switches to a **Connected to … — Disconnect** status
   and the proxy starts listening.
7. In the Hytale client, **Direct Connect** to `localhost`.

To end the session or switch servers, click **Disconnect**: the proxy unloads the
session (and its modules) and returns to the connection bar, ready to **Connect**
again — to the same Remote or a different one — **without restarting**. It also
returns to the bar on its own if the client or the server drops the connection.

### Platform support

| OS | Game-process snooping | Notes |
|----|----------------------|-------|
| Windows | ✅ | reads the process environment block |
| Linux | ✅ | reads `/proc/<pid>/environ` |
| macOS | ❌ not yet | the status shows yellow — paste the token manually (below) or use Mode 3 |

If snooping is unavailable you can still use the GUI: obtain a player session token
yourself and paste it into the **Session token** field. Connect then works normally.

### Tiling window managers (handled automatically)

On a **non-reparenting window manager** (dwm, i3, xmonad, awesome, …) AWT mis-handles
the frame: it opens at the right size and stays completely empty. The cure is
`_JAVA_AWT_WM_NONREPARENTING=1`, which AWT reads from the environment as the toolkit
starts — too late for the process to set on itself.

So the proxy sets it the only way it can: on X11 it asks the window manager its name
(`_NET_SUPPORTING_WM_CHECK` → `_NET_WM_NAME`, via `xprop`), and if that name is one of
the non-reparenting ones it re-executes itself once with the variable set, logging

```
[X11Relaunch] dwm does not reparent; restarting with _JAVA_AWT_WM_NONREPARENTING=1 so the window renders.
```

Nothing happens under an ordinary reparenting WM — the flag makes AWT ignore frame
decorations, so applying it there would misplace windows. It is also skipped for
`--no-gui` and under the Hytale launcher, whose parent process owns this one. If the WM
cannot be identified (no `xprop`, or a WM that does not announce itself) the log says
so, and starting it yourself still works:

```bash
_JAVA_AWT_WM_NONREPARENTING=1 java -jar meridian-proxy-*-all.jar   # or: wmname LG3D
```

Two other things the startup log tells you when the window looks wrong:

- `Swing look-and-feel: …` — which one is active. Both GTK and Metal are verified to
  render this window correctly on Linux; if a platform look-and-feel ever misbehaves,
  override it with `-Dmeridian.laf=system|metal|nimbus` (or a look-and-feel class name).
- `UI thread has not responded` — the *other* way the window can come up empty. The
  line dumps the UI thread's stack, naming whatever is holding it.

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
| `--remote` | Target server `host` or `host:port` (port defaults to `5520`) | `--remote 1.2.3.4` |
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
