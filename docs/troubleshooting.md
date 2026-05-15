# Troubleshooting

## `Hytale game process not detected` (standalone GUI)

The proxy could not find a running game to read the session from. Start the Hytale
launcher, sign in, click **Play**, then hit **Refresh** in the proxy window. On
macOS process snooping isn't implemented — paste a player session token into the
**Session token** field, or use [Mode 3](launch-modes.md#mode-3--standalone-cli).

## `HTTP 403 Forbidden` / `invalid token`

The session has expired (tokens live ~1 hour). Click **Connect** again — the proxy
re-reads the game's current session. If it persists, restart the Hytale game so the
launcher mints a fresh one.

## `Authentication timeout: ServerAuthToken`

The client disconnects after ~30 seconds — the proxy's Pkt 13 was delivered *after*
the client already transitioned out of the auth stage. Check the logs:

1. S2C buffering is active — look for `[S2C] Buffering enabled`
2. `FlushBufferingEvent` fires
3. Pkt 13 reaches the client before Pkt 20

See [S2C Buffering](architecture.md#s2c-buffering-mechanism).

## `Received unhandled packet type: ServerAuthToken`

Client-side log indicating Pkt 13 arrived at the wrong protocol stage — same root
cause as the timeout above (buffering race).

## `Failed to deserialize packet …` then a disconnect

Protocol drift: the proxy's packet definitions target a specific Hytale build and
the server is on a newer one. `PacketRouter` forwards the raw frame regardless, so
the warning itself is harmless — but if the layout change is breaking, the protocol
tree needs re-syncing to the server's version.

## `Backend connection failed`

The real server address is wrong or unreachable. Double-check the `Remote` value.

## `Local port … is already in use`

Another process holds the bind port — most likely a running Hytale single-player
session on `5520`. Close it, or set a different **Local port** in the GUI and use
that port in the client's Direct Connect.

## Stream reordering warnings

`Bridge: Stream X arrives ahead of Y. Buffering.` is **normal** — QUIC delivers
streams out of order and the proxy holds them until the expected sequence is intact.
