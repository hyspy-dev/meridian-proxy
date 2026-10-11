# Syncing `meridian-protocol` to a Hytale build

`meridian-protocol` is a 1:1 mirror of the server's `com.hypixel.hytale.protocol`
package, with a single mechanical change: the package is rewritten to
`meridian.protocol`. The proxy decodes packets with this copy, so a version
mismatch does not fail loudly — it misparses structs (a `BlockType` size drift
alone is enough to empty the block catalog and write `Unknown` for every block).

## Source of truth: the shared source

Hytale's server source is published, so **nothing is decompiled any more**:

```
B:\Job\dev\_java\hypixel\hytale-shared-source        # git repo, real source
├── HytaleServer/Protocol/
│   ├── src/main/java/com/hypixel/hytale/protocol/   # handwritten: Packet, io/*
│   └── target/generated-sources/java/.../protocol/  # generated: packets, structs, enums
└── ...
```

Two branches track the two patchlines: `pre-release` (weekly) and `release`.
Check out the one being synced; `Protocol/protocol-version.json` and the
generated `ProtocolSettings.java` carry the CRC and build number.

Server jars to run against still live at
`B:\Job\dev\_java\Hytale-Server-Unpacked-latest\hytale-server-unpacked\history`
(`0.6.0-pre.N.jar` / `0.5.N.jar`).

## Regenerating the tree

Both source roots are copied, the package is rewritten, and CRLF endings are
preserved. `io/netty/*` is skipped — the proxy runs its own Netty pipeline and
those classes pull in server-only QUIC types.

```sh
SRC=/b/Job/dev/_java/hypixel/hytale-shared-source/HytaleServer/Protocol
DST=<repo>/meridian-protocol/src/main/java/meridian/protocol
rm -rf "$DST" && mkdir -p "$DST"
for FROM in "$SRC/target/generated-sources/java/com/hypixel/hytale/protocol" \
            "$SRC/src/main/java/com/hypixel/hytale/protocol"; do
  (cd "$FROM" && find . -name '*.java' | while read -r f; do
    case "$f" in ./io/netty/*) continue ;; esac
    mkdir -p "$DST/$(dirname "$f")"
    sed -e 's/com\.hypixel\.hytale\.protocol/meridian.protocol/g' \
        -e 's/\r$//' -e '$!s/$/\r/' "$FROM/$f" > "$DST/$f"
  done)
done
# Hytale's own version stamp (crc as uint32 + buildNumber); the pom guard checks against it
cp "$SRC/../../Protocol/protocol-version.json" "$DST/../../../resources/protocol-version.json"
```

The `$!` matters: the generated files end without a final newline, and a plain
`s/$/\r/` leaves a lone `\r` after the closing brace. Git's CRLF normalisation
only touches `\r\n` pairs, so every file in the tree then shows up as modified.

### The one local patch

`Packet.java` must extend the module-facing marker so Layer-2 modules can hold an
opaque packet reference:

```java
public interface Packet extends meridian.api.packet.Packet {
```

That is the whole patch set. Everything else is verbatim — do not hand-edit
generated files; they are overwritten on the next sync.

## After regenerating

1. Check the file list against the upstream diff. `git status` in
   `meridian-protocol` should name exactly the files that
   `git diff --name-status <old-sync> <new-sync>` names under the two roots in
   the shared source, plus the pom and `protocol-version.json`. An extra file
   means the tree had drifted: `io/PacketIO.java` changed upstream in build 232,
   but the 242 sync missed it, and it was only caught at 251.
2. Build the whole chain with `clean` (`protocol → core → proxy → launcher →
   modules`). To build working trees before anything is pushed, point an umbrella
   recipe at local paths with no branch column. Plain `mvn package` without
   `clean` silently skips recompilation when only the dependency jar changed,
   and reports a false success.
3. The compiler finds renamed and removed fields. It does **not** find fields
   that were *added*: a packet the proxy builds with a no-arg constructor now
   carries new fields at their defaults. Diff the field lists of every protocol
   type the proxy constructs and confirm each new field's default is the
   behaviour you want.
4. Check `ProtocolSettings` moved to the expected CRC/build. `ConnectObserver`
   only logs on mismatch, so a wrong sync point shows up as misparsed packets
   rather than a refused connection.

## The CRC in text is unsigned

`ProtocolSettings.PROTOCOL_CRC` is a signed Java int, but everywhere the CRC is written
down it is the unsigned uint32 of the same bits: Hytale's own `Protocol/protocol-version.json`
and its discovery heartbeat, the `meridian-protocol` pom version, `meridian.protocol.version`
in consumer poms, `crc` in the umbrella `versions/*.conf`, `builtFor` in module.json, and the
catalog (whose builder only accepts `\d+` versions). The first negative CRC was build 209
(0.6.3): -423274174 signed = 3871693122 unsigned. `ModuleManager.speaksOurProtocol` and the
launcher's `ProxyBuild.crcOf` mask to uint32 before comparing; the pom guard checks the
version against the json copy (and the json's buildNumber against `ProtocolSettings`), so it
never has to convert.

Bump checklist: the `meridian-protocol` pom version; the `meridian.protocol.version` property
in the poms that depend on the protocol — meridian-proxy, meridian-core and
meridian-client-control (the umbrella and CI override it with `-D`, but a plain local `mvn` build
reads the pin and can pull a stale protocol out of `~/.m2`); the `crc` in the umbrella's
`versions/<game>.conf` (an exact file wins over the `X.Y.X` wildcard, which matters once two
builds of one minor differ, as 0.6.0-pre.13 and 0.6.3 do).

## `PROTOCOL_VERSION` is the QUIC ALPN

Separate from the CRC and the build number, `ProtocolSettings.PROTOCOL_VERSION`
is what goes on the wire as the ALPN token. The server (`QUICTransport`,
`QuicheListener`) advertises `"hytale/" + PROTOCOL_VERSION` plus the previous
version, and `QuicheConnection.initChannel` **rejects any connection whose
negotiated ALPN version is lower than its own** — `ClientOutdated`, with a
`client.general.disconnect.clientOutdated` message.

Both proxy legs therefore have to move with it. They read `HytaleAlpn.CURRENT` /
`HytaleAlpn.PREVIOUS`, which derive from `ProtocolSettings`, so a sync carries
them automatically — but only if `meridian-proxy` is **recompiled**: those are
compile-time constants and get inlined into the class file. Another reason the
`clean` build is not optional.

Symptom of a stale ALPN: the QUIC/TLS handshake reports SUCCESS, then the peer
immediately sends a clean application close (error 0) and not a single game
packet is ever decoded. Version 2 → 3 happened between build 100 and build 208.

## Current sync point

Build **251**, CRC **2982205573** (signed -1312761723), protocol version 3 - 384 packets,
444 structs, 177 enums. Taken from the `pre-release` branch (`0.7.0-pre.5.1`, Sync 2026-10-02;
Sync 2026-10-01 is the same build). The umbrella recipe is the `versions/0.7.X.conf` wildcard.
Builds in between: 232 (`0.7.0-pre.2`, CRC 322808978), 242 (`0.7.0-pre.3`, CRC 3666756532),
245 (`0.7.0-pre.4`, CRC 1902590056).

The 0.6 line stays on build **209** / CRC **3871693122** (signed -423274174): every live 0.6
build shares it - `0.6.0-pre.13.1` (the hotfix that moved it off 245610536) and `0.6.0`..`0.6.3`
on `release`. Its recipe is the `versions/0.6.X.conf` wildcard; build 208 (`0.6.0-pre.13`,
CRC 245610536) matches no installed game any more. 208 -> 209 only added `ConfigureIcePeer`
(254, ToServer) and two default methods on `ServerListener`.

Changes from build 242 to 251 (nothing the proxy, core or a module touches; no code changes):

- Handshake untouched: `Connect` / auth / `ClientReferral` / `ServerInfo` unchanged, ALPN still 3,
  the handwritten root (`Packet`, `io/*`) has no upstream diff.
- Seven new packets: `UpdateAbilityKeywords` (94, ToClient, compressed; arrives before
  `UpdateItems` during setup), `ExecuteServersideHudCommand` (207, ToServer), `InitViewModelTypes`
  (208, ToClient), `UpdateServersideHud` (209, ToClient), `OpenChapterRewardsPage` (220, ToClient),
  `ChapterRewardsPageResult` (221, ToServer), `DismissServersidePage` (527, ToServer).
- Renumbered: `UpdateServersideUIPage` 1200 -> 205, `ExecuteServersidePageCommand` 1202 -> 206
  (`InitViewModelTypes` was 1203 in build 245). No other id moved.
- `WorldGameplayConfig` (185) is variable-size now: `WorldConfig` gained a nullable-bits byte and
  `blockedRootInteractionTagIndexes`, so its fixed fields shifted by one byte.
- `UpdateBossBar.hardMode`, bit-packed with `hide` into the byte at offset 5.
- `ItemAbility` (inside `ItemBase`): the tag / applies-to arrays became four ability-keyword
  index arrays; `AbilitySlot.Primary` renamed `Core` (same value 0); new `AbilityKeyword`.
- `StateDelta` gained a nullable `StateFade fade` (13 -> 40 bytes), which changes the wire form
  of every sound event, audio category, ambience FX and music container that embeds it.
- Serverside UI reworked: `UpdateServersideUIPage.id`, `ExecuteServersidePageCommand.pageId` ->
  `id`, `InitServersideUICommand` lost `id` and gained `HudWidgetSlot` / `order` /
  `ServersidePageLifetime`; the three `...ServersideUIProperty` commands renamed
  `...ServersideUICommand`, plus `RemoveServersideUICommand` (5) and
  `SetVisibilityServersideUICommand` (6); `UIDataValue` gained `UIFormattedMessageDataValue` (16)
  and `UIColorDataValue` (17); `Page.ChapterRewards` (10) appended.
- No server-side change to the blobs core and world-downloader parse by hand (`SetChunk`
  palettes, light octree, `SetFluids`, environments, heightmap, tintmap, `MapImage`), nor to the
  region-file formats the downloader writes.

Changes from build 227 to 242 (synced as one step at 242; `meridian-core` `WorldChunks` and
`meridian-world-downloader` were adapted to the new chunk packets in the same step):

- Six new packets, no renumbering: `UpdateBlockDamages` (117, ToClient, Chunks), `ServerSetHeight`
  (183, ToClient, Chunks), `ServerSetHeights` (184, ToClient, Chunks), `UpdateRecurringWorldEvents`
  (255, ToClient), `RemoveRecurringWorldEvents` (256, ToClient), `AssetEditorUpdateAssetPackManifest`
  (359, ToServer). Id 315 changed meaning: `AssetEditorUpdateAssetPack` (Both) became
  `AssetEditorAssetPackUpdated` (ToClient); the client->server half moved to 359.
- No enum renumbering. Appended: `ComponentUpdateType.PreventDebugScreens` (31, empty
  `PreventDebugScreensUpdate`), `Page.Chapters` (9). New: `SectionEnvironmentsMode`
  (`Uniform` / `Columns`), `MapMarkerIconSize` (`Default` / `Major`).
- `SetColumn` (138): `heightmap` is a fixed `int[1024]` inline at offset 8 (was a palette-encoded
  `byte[]`), `environments` removed, `tintmap` follows at 4104. `SetChunkHeightmap` (132) is a
  fixed 4104 bytes (`x`, `z`, `int[1024]`).
- `SetChunkEnvironments` (134) is per section now (`y` added). Payload: a `SectionEnvironmentsMode`
  byte, then one varint id (`Uniform`) or 1024 per-column run lists (`Columns`).
- Heightmap deltas: `ServerSetHeight` (world-block `x`, `z`, `height`) for one changed column,
  `ServerSetHeights` (column `x`, `z` + `SetHeightCmd{short index, int height}[]`, `index = z<<5 | x`)
  for 2..511, a full `SetChunkHeightmap` above that.
- `MapMarker`: `iconSize` (byte at 38) and nullable `compassImage`; fixed block 38 -> 39, every
  offset slot shifted by one, so the `UpdateWorldMap` marker stride is 63.
- `PortalDef.explorationSeconds` + `breachSeconds` -> `durationSeconds`; `PortalState.breaching`
  -> `bonusSeconds` (int). Music timing: `BarBeatDuration.beats` is a float, fades and
  `StateTransition.duration` / `delay` are `BarBeatDuration`, `syncTo` is `MusicSync`.
- Asset editor: `AssetEditorAssetPackSetup.packs` is `Map<String, AssetPack>`; `isReadOnly` on the
  fetch replies and `AssetInheritanceTreeNode`. Smaller: `ItemMovementSettings.extraJumpLocalSoundEventIndex`.
- Handwritten root: `io/PacketIO` (changed at 232) records the wire size of uncompressed packets in
  its stats; no wire-format effect. This file was missed by the 242 sync and only came in at 251.
- Unchanged: `SetChunk`, `SetChunkTintmap`, `SetFluids`, `UnloadChunks`, `ClearChunks`, `JoinWorld`,
  `EntityUpdates`, `MapMarkerComponent`.

Changes from build 209 to 227:

- Four new packets, no renumbering of existing ids: `UpdateBeamConfigs` (93, ToClient),
  `SelfGrantEntitlement` (123, ToClient), `WorldGameplayConfig` (185, ToClient),
  `ConfigureIcePeer` (254, ToServer, already in 209).
- `InteractionType` renumbered: `Ability4 = 5` inserted, everything from `Use` on shifted by
  one. The proxy only ever names the constants, so a regen is enough.
- `UpdatePlayerInventory` gained `abilitySlots` and `runeBag` sections (server section ids
  -11 and -12). `PlayerStateHandler` exposes them as the `AbilitySlots` / `RuneBag` panels and
  dupe-test counts them; `InventoryTracker` still mirrors only hotbar / utility / tools (all a
  forge needs). Same sync fixed `PlayerStateHandler.panel()`, which mapped `SetActiveSlot` ids
  as 0..4 while the server sends `InventoryComponent.*_SECTION_ID` (-1 hotbar, -5 utility,
  -8 tools, ...), so every active-slot update had landed on `Backpack`.
- `ShowEventTitle.isMajor` (boolean) became `style` (`EventTitleStyle`: Default / Major /
  GoblinBreach). `UpdateLanguage.language` is non-null now, max 105 bytes (Connect too).
- `ItemBase.ability` (`ItemAbility`: slot, cooldown, cost, `AbilityCostType`, tags,
  attributes); `ChangeStatInteraction` / `StatsConditionInteraction.useAbilityCost`,
  `TriggerCooldownInteraction.useAbilityCooldown`, `ChangeStateInteraction.requireBlockPlacement`,
  new `GroundedConditionInteraction`; `DurabilityOperator` renamed `ComparisonOperator`.
- `ClientFeature` lost `DisplayHealthBars` / `DisplayCombatText` / `CanHide*`; they moved
  into `CombatConfig` / `PlayerConfig` / `WorldConfig` inside `WorldGameplayConfig`.
- Smaller: `ItemGlider` dive fields, `ModelVFX.opacity`, `CombatTextUpdate.color`,
  `AOECircleSelector` / `StabSelector.sizeAttribute`, `ComponentUpdateType.PreventEmotes`,
  `WindowType.Memories`, `SwitchTo.Transparency`, `SyncPlayerPreferences.activateTriggerVolumes`.
- Codegen: every polymorphic `toObject` counts nesting through `ReadCursor.enterNested`
  (`MAX_NESTING_DEPTH = 32`, in the handwritten io tree); `ProtocolException.nestingTooDeep`.

Notable changes from the previous sync point (build 100, CRC 1316766548, the
`release-14` decompile):

- **Codegen dropped the `ByteBuf` path.** Packets no longer have
  `serialize(ByteBuf)`, `deserialize(ByteBuf, int)`, `computeBytesConsumed`,
  `isBufferTooSmall` or `validateStructure`, and `ValidationResult` is gone.
  Decoding is `toObject(MemorySegment, offset[, ReadCursor])`; `PacketRegistry
  .PacketInfo` carries only `toObject`. `PacketIO`'s framed `ByteBuf` helpers
  survive and bridge to `MemorySegment` internally, which is what the proxy uses.
- **Framing is unchanged**: `[4-byte payload length LE][4-byte packet ID LE][payload]`.
- `ClientTeleport` gained `ignoredTransformFields` / `relativeTransformFields`
  (`ModelTransformFields` bitmasks); a transform field is applied unless its bit
  is set, replacing the old "leave the sub-object null" convention.
- `MovementSettings.canFly` (boolean) became `fly` (`FlyMode`:
  `Disabled` / `Allowed` / `Forced`).
- `MovementStates` is bit-packed now — 4 bytes instead of 23, same fields plus
  `extraJumpsUsed`. The generated accessors hide this.
- `BlockType` lost `flags` (`BlockFlags` is gone) and gained `modelAnimationSpeed`;
  `JoinWorld` gained nullable `minSectionY` / `maxSectionY`; `ItemWithAllMetadata`
  gained `quality`; `ServerCameraSettings` gained `depthOfField`, `baseFov`,
  `followAttachedEntity`, `hideHeldItem`.
