# Decompiling the Hytale server

`meridian-protocol` is a 1:1 mirror of the server's `com.hypixel.hytale.protocol`
package. To re-sync it after a Hytale update the server jar must be decompiled
**reproducibly** — same tool, same version, same flags every time — otherwise the
diff between two builds drowns in decompiler-output noise.

## Tool

**Vineflower 1.12.0** — `vineflower-1.12.0.jar`.

It ships in the unpacked-server repo next to the server jars:

```
hytale-server-unpacked/
├── vineflower-1.12.0.jar
├── versions.json             # symbolic tag ↔ dated build mapping
├── history/                  # one <version>.jar per Hytale build
│   ├── 0.5.0-pre.8.jar       # legacy SemVer-ish naming
│   ├── 2026.01.13-dcad8778f.jar
│   ├── 2026.05.07-5efa15f6d.jar
│   └── ...
└── src/                      # decompiled tree (output)
```

## Command

```sh
java -jar vineflower-1.12.0.jar <HytaleServer.jar> <output-dir>
```

**No extra flags.** Vineflower 1.12.0 defaults only. Adding or changing flags
changes the output and invalidates every future diff — don't.

## Rules

1. **Wipe before decompile.** Always decompile into an empty directory. Vineflower
   copies non-class resources too; decompiling over an existing tree leaves stale
   files behind. (Verified in Phase 0: re-decompiling `0.5.0-pre.8.jar` reproduced
   the committed `.java` tree byte-for-byte — the only differences were stale
   leftovers in a destination that was not wiped first.)

2. **Diff decompiler output, not source trees.** To find what really changed
   between two Hytale builds, decompile **both** the old and the new jar with this
   exact command and diff the two outputs. Never diff "existing committed tree" vs
   "fresh decompile" — that mixes real wire-format changes with decompiler variance.

3. **Only `com.hypixel.hytale.protocol` is mirrored.** The proxy does not mirror
   `server.core` or other server packages, and does not validate the handshake CRC
   (it forwards transparently). When syncing, touch only the protocol package.

## Current sync point

`meridian-protocol` currently mirrors Hytale server **`pre-release-48`**
(`0.6.0-pre.1`, commit `7ce9c4a4d`; `versions.json` in
`Hytale-Server-Unpacked-latest/hytale-server-unpacked/` maps the symbolic
tag to the actual dated build). Protocol version `3`, build `101`,
CRC `-2125278700`, ALPN `hytale/3`. The packet/struct/enum counts are
unchanged from `release-15` (326/386/155); the `release-15 → pre-release-48`
protocol-tree diff was confined to `ProtocolSettings` (CRC/version/build),
`QuicApplicationErrorCode` (new `Crash(7)`) and `ChannelConnection`
(new `clearPacketTimeout()`, `closeApplicationConnection(..., FormattedMessage)`).
See [`PROTOCOL-CHANGES-release15-to-pre48.md`](../../../Hytale-Server-Unpacked-latest/hytale-server-unpacked/PROTOCOL-CHANGES-release15-to-pre48.md)
for the full write-up.

> **Versioning note.** Hytale builds prior to 2026-01 used `0.5.0-pre.N`.
> Newer builds drop the SemVer-ish prefix and ship as `YYYY.MM.DD-<hash>`
> with `pre-release-N` / `release-N` tags in `versions.json`. When
> bumping the sync point, prefer the `pre-release-N` tag — it's stable
> across re-runs of the unpack pipeline; the dated hash is per-build.
