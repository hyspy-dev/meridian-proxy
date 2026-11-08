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

Core puts its services on the channel as `core <conn> <what> ...`. Each action answers once its
chain has played out, with the block or entity as core then sees it.

| Command | Does |
|---|---|
| `pos`, `look`, `inv`, `stats` | where the player is and looks; inventory; stats (health, stamina, mana, signature energy) |
| `tp <x y z>` | move the player there |
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
| `useitem [times]` / `swing` | Secondary / Primary aimed at nothing (eat, drink, shoot, guard) |

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
  The server checks that time against its own clock, with 0.25 s of grace.
- **Effects and stats.** Effect checks and stat checks see what the walk's own earlier steps applied
  and spent. They start from what the server last said. Stats arrive as changes, not values.

Server-only operations arrive as plain `SimpleInteraction`s. Their outcome is the server's alone, and
the forge does not wait for it: the client guesses, and so does core. Examples:

- an NPC's `UseNPC`;
- `RefillContainer`, which fills the can and then reports Failed for a source;
- `UseWateringCan` on something that is not tilled soil.

### Checking a forge against the server

Everything the bot sends, the server walks again and echoes. Compare the two walks per chain and
fork, over a `watch` of `SyncInteractionChains` both ways. A difference shows the operation and the
state where the two parted. Also watch:

- `CancelInteractionChain` with a non-negative chain id. Negative ids are the server's own chains,
  such as stat effects.
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
