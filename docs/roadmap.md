# meridian-core — roadmap

## The goal

**The goal is not any single module.** The goal is a complete, honest, in-proxy
mirror of Hytale's game state and mechanics — a model faithful enough that
**anyone can build a module against the neutral API without ever touching raw
packets or the protocol.**

Modules are *demonstrations and consumers* of that model. They prove the model
is good enough; they are not the point. A module is allowed to be thin: all
the real work lives in core.

**Honest implementation** means reproducing the real server/client behaviour,
not shortcuts. The proxy sits on the pipe — it sees exactly what the client
sees — so any state the client can reconstruct, core should reconstruct too, in
full. Where the genuine mechanic is a simulation (interaction chains, chunk
palettes), core reproduces the simulation rather than guessing.

## Layering

- **Layer 1 — meridian-core** (this repo): observes raw traffic, reproduces game
  state and mechanics, publishes neutral services. Absorbs all protocol churn.
- **Layer 2 — modules**: depend only on `meridian-core-api` + `meridian-api`.
  Protocol-neutral; a Hytale update cannot break them.
- **Layer 1 siblings** — orthogonal observers that write to disk and need no
  state model (recorder / world archive). They sit on raw packets directly.

See the proxy's [`architecture.md`](../../meridian-proxy/docs/architecture.md)
for the connection model and pipeline.

## Status

| Subsystem | State | Service |
|-----------|-------|---------|
| WorldState — block-type catalog | ✅ done | `WorldState` |
| EntityTracker — entity positions + local player pose | ✅ done | `EntityTracker` |
| CameraControl — camera packet forging | ✅ done | `CameraControl` |
| InventoryTracker — hotbar/utility/tools + held items | ✅ done | internal |
| ItemRegistry — item assets | ✅ done | internal |
| ChunkTracker — block ids at any position | ✅ done, verified | internal |
| World / Block / Player — building-block API | ✅ done | `World` |
| DebugRender — through-wall + depth-tested shapes | ✅ done | `DebugRender` |

## What core exposes today

`World` is the position-addressed facade — building blocks, not features:

- `world.blockAt(x,y,z)` → `Block` (`type()`, `isAir()`, …).
- `world.player()` → `Player` (`position()`, `heldItem()`, `hotbarSlotOf()`,
  `selectHotbarSlot()`).

`DebugRender` lets a module draw shapes into the client's world (through-wall
trigger-volumes via `worldBox(id, …)`, depth-tested debug cubes via
`box(…)`), with full RGBA / opacity control.

A Layer-2 module writes its own scan / decision logic and acts through these
objects — core only removes the packet plumbing.

## Roadmap

### ⬜ meridian-recorder (Layer-1 sibling) — session archive

A raw-packet recorder: tee every framed packet (both directions) with a
monotonic timestamp to a `.mrec` file, plus a header (session info, protocol
version, handshake). An orthogonal observer — needs no state model, sits on raw
packets via `meridian-api` + `meridian-protocol`, like a world archiver.

This is the **shared substrate** for the replay launch mode below — both are
"write the session to disk" of different flavours.

### ⬜ replay-mode — re-watch a recorded session

A proxy **launch mode** (`--replay <file>`): the backend is a recorded stream
instead of a live QUIC server. The proxy re-emits the recorded S→C to a real
Hytale client at the original cadence; a core/module layer suppresses all C→S
and drives a free camera via `CameraControl`. The client renders; the viewer
flies through a frozen, replaying world.

**Why it leads.** This is the feature that makes Meridian spread — content
creators promote replay tooling for free. It is mostly *composition* of pieces
that already exist: the recorder writes the archive, `CameraControl` already
drives a free camera, the proxy already has pluggable launch modes
(launcher / standalone).

**Honest challenges.**
- **Auth on playback** — the client must complete a handshake against the
  proxy-as-fake-server; the recording header carries the recorded handshake, or
  playback forges a minimal valid one.
- **C→S during playback** — fully suppressed; the recorded world does not react.
  The camera is driven independently.
- **Timeline scrubbing** — forward playback is trivial (re-feed). Seeking
  backward needs keyframes or replay-from-start. v1: forward + restart-to-seek;
  keyframes later.

### ✅ meridian-world-downloader (Layer-1 sibling)

Geometry capture is **done**: streams `SetChunk` / `ServerSetBlock` /
`ServerSetBlocks` / `UpdateFluids` / `SetChunkEnvironments` / `UpdateWorldMap`
into an own region format (`MwdWriter` + `RegionWriter`), with a
`RegionConverter` and a `MapViewer` for offline inspection. Writes to disk
as packets arrive so `UnloadChunk` doesn't lose the data.

A faithful Hytale-compatible save (matching the server's own region format,
not our own) is a separate, larger track — it needs the **disk** format
(≠ the network palette) plus capture of block entities / biomes / metadata.
See [region-file-format.md](region-file-format.md) for the analysis of the
target on-disk layout when we get there.

### ⬜ Future trackers — consumer-driven

Added when a real consumer needs them, never up front: player stats / effects,
cooldowns, full inventory metadata (durability), entity components beyond
transforms, chat, … Each is the same pattern: observe traffic → neutral service.

## Modules

| Module | Layer | State | Consumes |
|--------|-------|-------|----------|
| meridian-camera-tweaks | 2 | ✅ | CameraControl, EntityTracker |
| meridian-packetdump | — | ✅ | diagnostic (raw) |
| meridian-minimap | 1 | ✅ | EntityTracker + raw `UpdateWorldMap` / `CustomHud` |
| meridian-blueprint | 1 | ✅ | World, WorldState, DebugRender + raw paste-preview packets |
| meridian-world-downloader | 1 sibling | ✅ | WorldState + raw chunk/world-map packets |
| meridian-recorder | 1 sibling | ⬜ | raw packets — session archive |
| replay-mode | launch mode + core | ⬜ | recorder archive, CameraControl |

Each module stays thin. If a module needs logic that other modules could reuse,
that logic belongs in core.

## Build order

1. ✅ WorldState · EntityTracker · CameraControl · DebugRender
2. ✅ InventoryTracker · ItemRegistry · ChunkTracker · World / Block / Player
3. ✅ world-downloader · minimap · blueprint · camera-tweaks
4. ⬜ **meridian-recorder** → **replay-mode** — the session-archive substrate and
   the flagship viewer feature; the priority.
5. ⬜ Future trackers as needed
