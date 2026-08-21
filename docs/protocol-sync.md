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
        -e 's/\r$//' -e 's/$/\r/' "$FROM/$f" > "$DST/$f"
  done)
done
```

### The one local patch

`Packet.java` must extend the module-facing marker so Layer-2 modules can hold an
opaque packet reference:

```java
public interface Packet extends meridian.api.packet.Packet {
```

That is the whole patch set. Everything else is verbatim — do not hand-edit
generated files; they are overwritten on the next sync.

## After regenerating

1. `mvn -o -DskipTests install` in `meridian-proxy`, then `build-releases.ps1`.
   The script cleans each module, so a stale `target/` cannot hide a break —
   plain `mvn package` without `clean` silently skips recompilation when only
   the dependency jar changed, and reports a false success.
2. The compiler finds renamed and removed fields. It does **not** find fields
   that were *added*: a packet the proxy builds with a no-arg constructor now
   carries new fields at their defaults. Diff the field lists of every protocol
   type the proxy constructs and confirm each new field's default is the
   behaviour you want.
3. Check `ProtocolSettings` moved to the expected CRC/build. `ConnectObserver`
   only logs on mismatch, so a wrong sync point shows up as misparsed packets
   rather than a refused connection.

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

Build **208**, CRC **245610536**, protocol version 3 — 367 packets, 423 structs,
169 enums. Taken from the `pre-release` branch (`0.6.0-pre.13`, 2026-08-20).

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
