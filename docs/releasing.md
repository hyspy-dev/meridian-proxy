# Releasing & Hytale updates

Meridian is several independently-versioned artifacts. They are **not** released
together — each moves at its own pace.

## Artifacts & versioning

| Artifact | Versioning | Changes when |
|----------|------------|--------------|
| `meridian-api` | own SemVer, **independent of Hytale** | a module-facing signature is added/changed |
| `meridian-protocol` | `<hytale-build>-<patch>` (e.g. `0.6.0-pre.13-1`); **BETA**, no guarantees | every Hytale build |
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

Each artifact lives in its own repo now, so a plain `v<semver>` tag is enough:

```
v1.2.0
v1.2.0-beta.1     # a '-' in the version publishes a GitHub prerelease
```

The tag is the only version authority: the release workflow stamps it into the
pom(s) before building, so the artifact's own version string (the uber-jar's
`version.properties`, a module's `module.json`) always matches the release. Nothing
is read from `git describe` any more, and no pom is bumped by hand.

## Cutting a release

```sh
git tag v1.2.0
git push origin v1.2.0
```

That is the whole procedure. The repo's `.github/workflows/release.yml` delegates to
the shared workflow in `hyspy-dev/meridian`, which:

1. decides whether this component is game-bound (does its pom depend on
   `meridian-protocol`?) and, if so, builds one jar per protocol `line/*` branch —
   each against that line's protocol, with its own `line/<game>` branch as the source
   when the code diverges there;
2. stamps `builtFor` (wire CRC) and `requiresProtocol` into every module jar's
   `module.json`, so a jar always states which protocol it needs;
3. publishes one GitHub Release with every jar (`<name>-<version>+<game>[-all].jar`)
   plus a generated `meridian.json` manifest (sha256, size, game line per asset);
4. pokes the umbrella catalog, which redeploys the launcher's `catalog.json` to
   GitHub Pages within seconds.

A line that fails to compile is skipped with a warning and listed in the release
notes — it simply does not appear in the catalog for that game version.

Build-time SDKs (`meridian-api`, `meridian-protocol`, `meridian-core-api`) are not
published to a Maven repository: every build compiles them from source out of their
own repos, so a third-party module only needs the umbrella recipe to build.

## Reacting to a Hytale update

When a new Hytale server build ships:

1. Regenerate `meridian-protocol` from the shared source following
   [`protocol-sync.md`](protocol-sync.md), re-applying the one local patch.
2. Build everything with `build-releases.ps1` — it cleans each module, which
   plain `mvn package` does not, and a stale `target/` reports a false success.
   Renamed and removed fields surface as compile errors here.
3. Diff the field lists of the protocol types the proxy constructs: **added**
   fields never break the build, they just default silently.
4. If framing/encoding changed, patch `meridian-proxy`.
5. Layer-2 modules (camera-tweaks, …) are untouched — they never see
   `meridian-protocol`.
6. Commit as a reviewable change. **Do not push without review.**

## Simulated-update test

A cheap way to rehearse step 3 without waiting for a real Hytale update:

1. In a scratch copy of the decompiled tree, rename one protocol field, e.g.
   `BlockType.drawType` → `BlockType.renderType`.
2. Apply the renamed file to `meridian-protocol` as if it were a real diff.
3. Build `meridian-core`: `BlockViewImpl` (the mapper) fails to compile on the
   renamed field. Fix that **one line**.
4. Rebuild `meridian-camera-tweaks` — it needs **no change and no recompile**:
   a Layer-2 module is insulated from protocol churn by `meridian-core-api`.

Step 4 failing would mean a protocol type leaked into a Layer-2 surface — a bug.
