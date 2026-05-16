# Releasing & Hytale updates

Meridian is several independently-versioned artifacts. They are **not** released
together — each moves at its own pace.

## Artifacts & versioning

| Artifact | Versioning | Changes when |
|----------|------------|--------------|
| `meridian-api` | own SemVer, **independent of Hytale** | a module-facing signature is added/changed |
| `meridian-protocol` | `<hytale>-<patch>` (e.g. `0.5.0-pre.8-1`); **BETA**, no guarantees | every Hytale build |
| `meridian-proxy` | own SemVer | the proxy implementation changes |
| `meridian-core-api` | own SemVer | a core service/type is added or extended |
| `meridian-core` (impl) | own SemVer | mapper or service implementation changes |

Rules:

- **`meridian-api`** — minor bump for additive changes (a new method **must** have a
  `default` implementation so modules built against the old version still load);
  major bump for anything breaking.
- **`meridian-protocol`** — patch bump on every Hytale diff. It is intentionally a
  BETA zone; Layer-1 authors who depend on it accept the churn.
- **`meridian-proxy`** and **`meridian-core`** absorb the protocol churn (the mapper
  lives there), so they bump most often.
- No promise of compatibility across a major Hytale epoch.

## Tag conventions

Each artifact prefixes its own tag, so a multi-module repo can carry several:

```
api-v1.2.0
protocol-v0.5.0-pre.8-1
proxy-v1.5.0
core-api-v0.2.0
core-v0.1.0
```

The build reads its artifact-specific tag via `git describe` (the proxy already
does this for the uber-jar's version string).

## Cutting a release (manual)

CI is not wired yet (the repos are not on a shared remote). Until then:

```sh
# from the meridian-proxy repo root
mvn clean install                 # builds api + protocol + proxy + uber-jar
git tag proxy-v1.5.0
# the uber-jar is meridian-proxy/target/meridian-proxy-<describe>-all.jar
```

`meridian-core` is its own repo — release it the same way (`core-v…`, `core-api-v…`).

Publish targets, once wired: `meridian-api` / `meridian-protocol` / `meridian-core-api`
to a Maven repository (GitHub Packages to start) so third-party modules can depend
on them with `<scope>provided</scope>`; the uber-jar to a GitHub Release.

## Reacting to a Hytale update

When a new Hytale server build ships:

1. Run [`tools/regen-protocol.ps1`](../tools/regen-protocol.ps1) with the old and
   new server jars. It decompiles both with the pinned Vineflower build (see
   [`tools/decompile.md`](../tools/decompile.md)), diffs the protocol package, and
   applies changed files to `meridian-protocol` with the package rewritten.
2. Work the manual checklist the script prints (removed files, non-protocol
   imports, `ProtocolSettings`, `PacketRegistry` registrations, interaction
   discriminators).
3. `mvn -pl meridian-protocol install`, then build `meridian-core` — its mapper is
   where a renamed/removed field surfaces as a compile error. Fix the mapper
   (usually one line), bump `meridian-core` patch.
4. If framing/encoding changed, patch `meridian-proxy`.
5. Layer-2 modules (xray-2, ...) are untouched — they never see `meridian-protocol`.
6. Commit as a reviewable change. **Do not push without review.**

## Simulated-update test

A cheap way to rehearse step 3 without waiting for a real Hytale update:

1. In a scratch copy of the decompiled tree, rename one protocol field, e.g.
   `BlockType.drawType` → `BlockType.renderType`.
2. Run `regen-protocol.ps1` against it — it must report the file as changed.
3. Build `meridian-core`: `BlockViewImpl` (the mapper) fails to compile on the
   renamed field. Fix that **one line**.
4. Rebuild `meridian-xray` — it needs **no change and no recompile**: a Layer-2
   module is insulated from protocol churn by `meridian-core-api`.

Step 4 failing would mean a protocol type leaked into a Layer-2 surface — a bug.
