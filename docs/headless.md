# Headless: the proxy as the client

A headless connection joins a server with no game behind it, and the proxy plays the client. The
point is to test packet chains (interactions, builder tools, inventory) against a real server and
read its answers directly, with no one at the keyboard.

## How it is built

It is the server leg of an ordinary connection (`HeadlessConnection`):

- its own QUIC connection and certificate;
- the same handler chain;
- the module runtime from `<jar>/headless/modules`, seeded from `<jar>/modules` the first time.

Where the game would be there is a stand-in channel with no socket:

- What the server sends passes every handler, as usual, and ends there.
- What the client says enters the client-to-server chain at that channel
  (`HeadlessClient.sendAsClient`). Modules and core therefore see it as the client's own packets.
  Core's position tracking, for example, follows the bot's movements.

`ProxySession.headless()` tells a module that a session has no game behind it.

The work is split by who owns it:

- **The proxy** does the handshake: `Connect`, then authentication.
  - On an insecure server it answers `RequestInsecurePlayerOptions` with a name and an account made
    from it.
  - On an authenticated one the server leg authenticates with the player's tokens, as always.
    There is no client leg to authenticate.
- **Core** does everything after that (`HeadlessClientHandler`), because it is game behaviour and
  changes with the game's version:

| Server sends | Client answers |
|---|---|
| `WorldSettings` | `RequestAssets` with an **empty** list. `null` would mean "send everything": the server would build and send every file, its own and every mod's, and ask for a rebuild. With an empty list it sends no file (measured on a modded server announcing 49: no `AssetInitialize`, `AssetPart` or `RequestCommonAssetsRebuild`). |
| `WorldLoadFinished` | `ViewRadius` (192 blocks), then `SetupFinalize` |
| `JoinWorld` | `ClientReady(readyForChunks)` within 30 s, or the join fails |
| `SetClientId` | `ClientReady(readyForGameplay)` |
| `ClientTeleport` | `ClientMovement` with the teleport's id and the exact target position |
| `Ping` | three `Pong`s, one per type: `Raw`, `Direct`, `Tick` |
| `SyncInteractionChains` with a negative chain id (a chain the server started: a projectile's miss, a stat effect) | the client's side of it, played like core's own chains from the root the server names. Without it the server waits for the client's data and cancels the chain after a few seconds |

Why three `Pong`s: the server queues every ping once per type and takes each type's pongs in order.
A pong out of turn closes the connection. Without `Tick` pongs, the timeout for cancelling
interactions falls to its 3-second floor.

There is no AFK kick. A client must send at least one packet a minute, and the `Pong`s cover that.
The limit is 2000 packets a second.

## A local test server

The installed game ships the server. Run it in a folder of its own, where it makes its world, with
no tokens:

```sh
"%APPDATA%/Hytale/install/pre-release/package/jre/latest/bin/java.exe" -Xms768M \
    -jar "<install>/package/game/latest/Server/HytaleServer.jar" \
    --bind 127.0.0.1:5599 "--assets=<install>/package/game/latest/Assets.zip" \
    --auth-mode=insecure --disable-cpb-build
```

- `--auth-mode insecure` lets any name in, and no tokens are needed.
- `--disable-cpb-build` stops the server writing compact prefab buffers (`.lpf`) next to the
  prefabs it loads, so a test server leaves the asset and mod folders as it found them. Never point
  a test server at real `--mods` without it.
- `offline` is not an option: it works only with `--singleplayer`, and only for its owner.
- The server boots in about 10 s.
- Its own log is the final word on what it accepted.

## Driving it

Over the [command channel](control-channel.md):

```sh
P="java -jar meridian-proxy-<v>-all.jar"
$P --cmd "headless connect 127.0.0.1:5599 Bot1"      # -> {"conn":1,...}
$P --cmd "sessions"                                  # phase PLAYING once it is in
$P --cmd "watch 1 both Ping,Pong" --for 3
$P --cmd 'expect 1 s2c ServerMessage 5 {"message":{"params":{"message":{"value":"hi"}}}}' \
   --cmd 'send 1 c2s ChatMessage {"message":"hi"}'
$P --cmd "headless close 1"
```

A headless connection stays up after the command connection that opened it closes, until
`headless close` or the proxy exits.

## Acting through core

Core puts its services on the channel as `core <conn> <what> ...`. Each action answers once the
server has said how its chain went, with the block or entity as core then sees it. The `outcome`
holds:

- `status`: `FINISHED`, `FAILED` (the chain's last operation failed), `CANCELLED`, `TIMED_OUT`, or
  `NOT_SENT`;
- `failed`: the operations the server ran that failed, by index and kind;
- `forks`: the chains the server forked, such as a swing's hits or an area dig's blocks;
- `corrections`: how often the server ran an operation otherwise than core guessed.

A chain's own end says little about whether the action worked. A watering can on grass plays its
"nothing to water" branch and ends `FINISHED`; its watering step is in `failed`.

| Command | Does |
|---|---|
| `pos`, `look`, `inv`, `stats` | where the player is and looks; inventory; stats (health, stamina, mana, signature energy) |
| `tp <x y z>` | move the player there |
| `movement` | the body: where its feet are, whether it stands, its capabilities (speeds, step, jump, pull-up, safe drop) |
| `stand <x y z>` | where the feet are when the body stands in that cell, or that it cannot |
| `move <walk\|jump\|mantle\|drop> <x y z> [walk\|run\|sprint]` | one move onto that cell, played tick by tick as the client plays it |
| `block <x y z>` | a block as core sees it: type, rotation, filler, fluid |
| `entities [range]` | entities around, nearest first: id, model, name, position, own interactions |
| `chain <rootId>` | a root's flattened operations, as the forging simulator walks them |
| `slot <n>` | switch the hotbar slot (the held item's own `SwapFrom` root) |
| `face <x y z>` / `face <entity>` | turn the bot to a block's or an entity's middle |
| `hit` / `dig <x y z> [times]` | Primary on a block; `times` swings in a row. Damage wears off between swings far apart. |
| `use`, `plant`, `water <x y z>` | Use; Secondary placing seeds; Secondary on a block (hoe, watering can) |
| `place <x y z> [face] [orient]` | place the held block against a face |
| `attack <entity> [times]` | Primary on an entity: the swing reports it hit |
| `useentity <entity>` | Use (F) on an entity |
| `useitem [times] [hold <s>]` / `swing [hold <s>]` | Secondary / Primary aimed at nothing (eat, drink, guard, draw a bow), the button held `<s>` seconds |

The moves are core's `Movement` service: a body that walks, jumps, pulls itself up and drops
with the client's numbers. Every tick of a move is checked against the blocks' collision shapes
before it starts, and is sent as the client sends it (position, velocity, movement states). The
server takes fall damage from the speed reported at landing. Finding a way is the
`meridian-navigation` module's: `nav <conn> goto <x y z> [radius]`, `nav <conn> plan ...`,
`nav <conn> cancel`. See [the movement design](../../docs/movement-design.md).

`tp` is core's own teleport, not the server's: the client reports the new position, and the server
takes any finite position without a distance check. With a game behind the session, core also moves
the game's view and holds the server at the target while the game catches up. A bot has no view and
no stream of old positions, so it just reports the target as the client.

What the server decides, and what core therefore mirrors:

- **Entity hits come from the client.** The swing's `SelectInteraction` lists the entity
  (`hitEntities`, plus the attacker's position and rotation). The server forks the weapon's hit on
  its side and announces it; core answers every announced fork, nested ones included.
- **Damage checks reach.** The held item's use distance (5 in Adventure, 6 in Creative, at least 10
  in Creative), plus 2, from the eyes to the entity's feet.
- **Combos.** A `ChainingInteraction` step must be the next one, or 0 once the chain's allowance has
  run out. Core counts the steps the server was sent, the player's own included.
- **Charges are held.** While held the client sends `chargeValue = -1`; on release, the time held.
  The server checks that time against its own clock, with 0.25 s of grace, and takes the tier of the
  highest key the hold reached. Without `hold`, core holds each charge just long enough for its
  first tier. That is a tap for a bow, whose first key, `0.0`, puts the arrow back. `swing hold 0.5`
  draws and shoots.
- **Effects and stats.** Effect checks and stat checks see what the walk's own earlier steps applied
  and spent. They start from what the server last said. Stats arrive as changes, not values.

### The server has the last word

Core plays a chain the way the client does, a packet a tick, and follows the server while it goes.
The server echoes every chain operation by operation: the path it took (which operation of which
root at each operation index) and how each ended. Core uses that echo in three ways:

- **It takes the server's outcome when it has one.** An operation the walk has not resolved yet ends
  the way the server says. On grass the server fails `UseWateringCan` at once, while core's walk is
  still in the can's 0.2 s use. The walk takes the failure and goes down the same branch as the
  server.
- **It waits where the client waits.** An operation marked `waitForDataFrom = Server` (portals,
  teleporters, fertilizer, learning a recipe, game flags) stays running until the server's outcome
  comes in. A recipe learned a second time is refused, and core then sends no step that uses it up.
- **It replays where the paths part.** Sometimes the server ran an operation at an index where the
  walk ran a different one, or ran one the walk never did. That means the walk mispredicted an
  operation before it. Core goes back to the first operation the server ended otherwise, replays
  from there the server's way, and sends the replay flagged `desync`. This is the client's
  revert-and-replay, as the server's `InteractionManager` describes it.

  An empty can at a water source fills, but the server then fails `RefillContainer` and takes the
  failed branch. Core replays that branch, and the server ends the chain cleanly. Without the
  replay, the server would wait for the client and then cancel the chain.

An outcome that differs while the path does not is left alone, as the client leaves it. For
example, an NPC's `UseNPC` as the chain's last operation: the server keeps its own outcome, and
nothing after it depends on core's.

### Checking a forge against the server

Everything the bot sends, the server walks again and echoes. Compare the two walks per chain and
fork, over a `watch ... received` of `SyncInteractionChains` both ways. With `received` the watch
shows packets as the server sent them: core takes its own chains' echoes out of a packet that also
carries other chains, so a plain `watch` misses them. The forge cases in `meridian-tests/forge`, next
to the repos, run all of this end to end against a local server of their own. A difference shows the operation and the
state where the two parted. Also watch:

- `CancelInteractionChain`, for core's chains and for the server-started ones (negative ids) the bot
  answers. A server chain cancelled a few seconds after it started went unanswered.
- `WARN` lines in the server's log while the bot acts: `Client failed to send client data`, a charge
  `exceeds max allowed`, an `unexpected chainingIndex`.
- After a replay, the operations sent before it still show as core's last word on their index. An
  operation the server decided as the chain's last one may differ too (`UseNPC` above). Neither is
  a fault.
- what the server sent back: block, fluid, damage and inventory updates, and the target's
  `EntityUpdates` (a hit's `CombatText` and health change).

Set the test world up from the server console, or from the bot's chat once it is op. Do this on the
local test server only:

```
op add Bot1
gamemode adventure Bot1             # creative turns off some breaking branches (a shovel's)
give Bot1 Tool_Hoe_Iron --quantity=1
tp Bot1 710 122 140
/npc spawn Sheep                    # chat; spawns at the bot
/fluid set Water_Source 1 --offset ~ ~1 ~   # chat; above the block the bot faces
log InteractionManager --level=FINEST       # why a chain was cancelled
```

Free a hotbar slot with `DropItemStack {"inventorySectionId":-1,"slotId":N,"quantity":<held>}`.

## An ordinary (authenticated) server

To join a real server, the bot needs a profile's game session: the session token and the identity
token, the same pair the launcher gives the game.

```
headless connect <host:port> <name> auth <sessionToken> <identityToken>
```

- The name on the server is the profile's, read from the identity token.
- The server leg authenticates the usual way: the server's grant is exchanged at
  `/server-join/auth-token`, bound to the fingerprint of the bot's own certificate.
- Send the tokens over the socket rather than as `--cmd` arguments, which other processes can
  read.
- A profile can be on one server only once. Starting the bot as the profile you are playing on that
  same server kicks one of the two.

Not yet supported:

- following a server's referral to another server;
- streams the client would open on its own, such as voice.
