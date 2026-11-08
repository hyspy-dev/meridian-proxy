# The command channel

A running proxy takes commands over a TCP port on the loopback address. Uses:

- A single-player world's wrapper asks it for a route.
- A person or a script looks at the packets of a live connection and sends their own, then checks
  what the server answered, without a hand in the game.

## Where it is

| Mode | Port |
|---|---|
| Multiplex, started by the launcher | `--control-port`: the first port of the launch's route slot, the number of the first UDP route |
| Standalone, launcher-wrapped, CLI | the proxy's own UDP listen port |
| Older launchers (before 1.0.9) | `--sp-control <port>`, still accepted |

TCP and UDP of one number do not collide. If the port is taken, a free one is used instead.

The proxy writes where it ended up to `<jar dir>/control/<port>.json` and removes the file on exit:

```json
{"port":16480,"token":"...","pid":47092,"mode":"multiplex","version":"1.0.11","started":"..."}
```

The token comes from `MERIDIAN_CONTROL_TOKEN` when whoever started the proxy set it (the launcher
does, and gives the same value to the game for its single-player wrapper). Otherwise the proxy makes
one up. `MERIDIAN_SP_SECRET` is still read for older launchers.

## Talking to it

The first line must be `HELLO <token>`. A wrong token gets `{"error":"who are you"}` and the
connection is closed. A right one gets `{"hello":"ok","version":"..."}`.

After that, one command a line. Commands are numbered from 1 in the order they arrive. Every answer
is a JSON line:

- it carries `"cmd": <n>`, the number of the command it answers;
- the last answer for a command carries `"end": true`;
- an answer with `"error"` is a failure.

`watch` never ends by itself: it streams until `stop <n>` or the connection closes. Closing the
connection also ends every `watch` and `expect` it started, and closes the single-player routes it
opened.

The game's threads never wait on a slow reader. When too many answers pile up, the oldest are
dropped and a `{"lost":<count>}` line says how many.

| Command | What it does |
|---|---|
| `help` | the list below |
| `sessions` | live game connections: `id`, `target`, `localPort`, `phase`, `player`, `uuid`, `streams` |
| `packets [part]` | packet names with `id`, `channel` and direction (`c2s`, `s2c`, `both`) |
| `send <conn\|-> <c2s\|s2c> <Packet> [json]` | builds the packet from JSON (fields as in `meridian-protocol`; missing fields keep their defaults) and sends it on the stream of its channel |
| `watch [conn\|*] [c2s\|s2c\|both] [A,B\|*] [full] [received]` | streams packets as they pass |
| `expect <conn\|-> <c2s\|s2c> <Packet> [secs] [json]` | waits for the next such packet whose fields include the JSON given; ends with it or with a timeout error |
| `stop <n>` | ends watch or expect number `n` |
| `open <clientPort> <serverPort> <player> <serverSession> <serverIdentity>` | a single-player world's route, `-` for a missing token; closed with the connection |
| `headless connect <host:port> [name] [insecure]` | joins a server with no game, the proxy playing the client (see [headless.md](headless.md)); answers with the connection number |
| `headless close <conn>` / `headless list` | leaves / lists them |

Notes on the arguments:

- `-` as the connection means "the only one there is".
- `send` goes straight out: it does not pass the handler chain, so modules do not see it as
  traffic.
- In `watch` and `expect`, packets the proxy made itself (a module, core or a `send`) show up with
  `"outcome":"forged"`. Each `watch` answer also says what the handler chain did with the packet:
  `forwarded`, `modified`, `dropped`, `handled` or `undecoded`.
- Packets are shown with long strings and arrays cut; `full` shows them uncut. A `byte[]` is
  base64; a number array is accepted when sending.
- A `watch` shows each packet as it went on, after the handlers. With `received` it shows each one
  as it came in, before any handler changed or dropped it (`"outcome":"received"`), plus the ones the
  proxy made itself. Use it to see what the server really sent: core takes its own chains' echoes
  out of a packet before the game gets it, so a plain `watch` misses them in a packet that also
  carries other chains.
- Arm an `expect` before the `send` it answers. Commands on one connection run in order, so sending
  both in one go does that.

## From the command line

```sh
java -jar meridian-proxy-<v>-all.jar --cmd "sessions"
java -jar meridian-proxy-<v>-all.jar --cmd "watch - s2c ClientTeleport,SetGameMode" --for 30
java -jar meridian-proxy-<v>-all.jar \
     --cmd "expect - s2c ClientTeleport 5" \
     --cmd "send - c2s ClientMovement {\"absolutePosition\":{\"x\":0,\"y\":120,\"z\":0}}"
```

The jar finds the proxy by the files in its own directory's `control/`. It picks the newest one whose
process is alive, or the one named with `--port`. It prints every answer and exits once each
command has had its last answer, or after `--for` seconds. The exit code is `1` if any answer was
an error and `2` if no proxy was found.

A `--cmd` run opens no window and writes no log file, so the running proxy's `meridian.log` is left
alone.
