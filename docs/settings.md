# Settings API

A module declares its settings UI with `SettingsSpec` — a tree of typed nodes —
and the proxy renders it into its native GUI. The spec is Swing-free: modules
describe **what** they want, not how it looks.

```java
ctx.registerSettings(SettingsSpec.builder()
        .bool("enabled", "Enable X-Ray", false, v -> enabled = v)
        .build());
```

That single call gives you:

- A session-only toggle — flips back to its declared initial on every restart.
  Add `.persistent()` after the declaration to make it survive (see
  [Persistence](#persistence)).
- An `onChange` callback that fires **at registration time** with the persisted
  value (if any, for persistent settings) or the declared initial, and again on
  every edit.
- Whatever look-and-feel the proxy currently uses — no Swing code in your module.

## Lifecycle

`onChange` is invoked exactly the same way as the user pressing the widget,
so a single callback per setting is enough:

| When | What happens |
|------|--------------|
| `registerSettings(spec)` | Each leaf's `onChange` fires with the persisted-or-initial value. Run any wiring (start a scheduler, flip a flag) inside it. |
| User edits a widget | `onChange` fires with the new value; if the setting was marked `.persistent()` the value is also written to disk. |
| `onDisable()` | Runs on Disconnect — the whole module (its settings panel included) is dropped with the connection's runtime. Tear down your own state here. |

`onChange` always runs on the Swing EDT. If your work is heavy (or blocking),
post it to `ctx.offloadExecutor()` or just store the value in a `volatile`
field and react asynchronously from `ctx.scheduler()`.

## Persistence

**Opt-in.** By default no setting survives a proxy restart — every `onChange`
callback fires with the declared initial at startup and edits are session-only.
Mark settings worth remembering with `.persistent()` (chain) or
`.persistent("key1", "key2", ...)` (varargs):

```java
SettingsSpec.builder()
        // Session-only — toggle always starts off on a restart.
        .bool("active", "Active", false, v -> active = v)

        // Persisted — the dialled-in radius is the user's tuning.
        .int_("radius", "Radius", 1, 512, 16, v -> radius = v).persistent()

        // Mass form — useful with many settings declared in a row or with
        // settings declared inside an already-built sub-spec.
        .string("draftName", "Draft", "", v -> draft = v)
        .int_("attempts", "Attempts", 0, 99, 0, v -> attempts = v)
        .persistent("attempts")

        .build();
```

Two equivalent forms:

- **Chain**: `.persistent()` right after a setting marks that setting (or
  every setting inside it, if it was a `.section(...)`).
- **By key**: `.persistent("k1", "k2", ...)` is independent of position, and
  fails loud (`IllegalArgumentException`) if any key wasn't declared — typos
  caught at startup, not silently ignored.

What persistent means concretely:

- The value is written to `<dataDir>/settings.json` on every edit.
- It is reloaded into the widget on the next startup.
- Keys not in the persistent set are **dropped** from `settings.json` on the
  next save — orphans from an older build don't accumulate.

The data directory is per-module; values do not collide across modules.

### Choosing what to persist

Rule of thumb: persist **tuning** (radius, filter name, distance, list of
captured packets — anything the user dialled in). Don't persist **action
state** (toggles for active modes, target coordinates for a single test, a
combo box of "what to do right now"). The default of "don't" is correct for
most settings; persistence is the exception.

Live examples in the tree:

- [MinimapModule.java](../../meridian-minimap/src/main/java/meridian/minimap/MinimapModule.java) — `position` and `zoom` persistent, every per-element show/hide too.
- [CameraTweaksModule.java](../../meridian-camera-tweaks/src/main/java/meridian/cameratweaks/CameraTweaksModule.java) — the active mode is session-only, every distance/shift is persistent.
- [BlueprintModule.java](../../meridian-blueprint/src/main/java/meridian/blueprint/BlueprintModule.java) — `layerWindow` persistent, the live-list and action buttons are session-only.

## Setting types

Every leaf takes a `key`, a human-readable `label`, an `initial` value, and an
`onChange` callback.

| Builder | Widget | Initial type |
|---------|--------|--------------|
| `.bool(key, label, initial, Consumer<Boolean>)` | Checkbox | `boolean` |
| `.int_(key, label, min, max, initial, Consumer<Integer>)` | Bounded spinner | `int` |
| `.string(key, label, initial, Consumer<String>)` | Text field (saves on focus loss) | `String` |
| `.enum_(key, label, EnumClass, initial, Consumer<E>)` | Combo box | enum constant |
| `.stringList(key, label, initial, Consumer<List<String>>)` | Multi-line text area | `List<String>` |
| `.regexList(key, label, initial, Consumer<List<Pattern>>)` | Multi-line, validates each line | `List<String>` (compiled to `List<Pattern>`) |
| `.color(key, label, initialRgba, IntConsumer)` | Native colour picker | `int` (ARGB packed) |
| `.playerList(key, label, Consumer<List<UUID>>)` | UUID list (autocomplete if a registry exists) | none |
| `.button(label, Runnable)` | Push-button — no key, no persistence | none |
| `.liveList(label, Supplier<List<String>>[, IntConsumer onRowClick])` | Read-only list polled on a timer, optional row click | none |
| `.liveText(label, Supplier<String>)` | Read-only single-line label polled on a timer | none |

### Example

```java
ctx.registerSettings(SettingsSpec.builder()
        .bool("enabled", "Enabled", false, v -> enabled = v)
        .int_("radius", "Radius", 1, 512, 16, v -> radius = v)
        .string("filter", "Filter (contains)", "", v -> filter = v == null ? "" : v)
        .enum_("mode", "Mode", Mode.class, Mode.SAFE, v -> mode = v)
        .color("highlight", "Highlight colour", 0xFF99FF4C, v -> highlight = v)
        .stringList("ignore", "Ignore list", List.of(), v -> ignore = Set.copyOf(v))
        .build());
```

## Two-way bindings

By default a setting's value flows one way: the user edits the widget, the
module's `onChange` fires. When the module needs to push values back into a
field — a "Fill" button, a cross-module listener — pass a `SettingBinding<T>`
to the binding-aware overload:

```java
private final SettingBinding<String> xBinding = new SettingBinding<>();
private final SettingBinding<String> yBinding = new SettingBinding<>();
private final SettingBinding<String> zBinding = new SettingBinding<>();

ctx.registerSettings(SettingsSpec.builder()
        .string("x", "X", "", v -> xText = v, xBinding)
        .string("y", "Y", "", v -> yText = v, yBinding)
        .string("z", "Z", "", v -> zText = v, zBinding)
        .button("Fill from observed", () -> {
            interactions.targetedBlock().ifPresent(p -> {
                xBinding.set(Integer.toString(p.x()));
                yBinding.set(Integer.toString(p.y()));
                zBinding.set(Integer.toString(p.z()));
            });
        })
        .build());

selectionBus.onBlockSelected(p ->
        SwingUtilities.invokeLater(() -> {
            xBinding.set(Integer.toString(p.x()));
            // ...
        }));
```

`binding.set(value)` is safe to call from any thread — the renderer hops to
the EDT itself. It updates the widget, persists through the store, **and**
fires the module's `onChange` (so your `xText` field stays in sync just as if
the user had typed it).

Currently supported on `.string(...)`. Add overloads for other widgets when a
real use case shows up — the pattern in
[SettingsRenderer.renderText](../meridian-proxy/src/main/java/meridian/internal/gui/SettingsRenderer.java)
is straightforward to follow.

## Programmatic enable / disable

Any widget — checkbox, spinner, text field, button, live list, live text, a
whole section — can be greyed out from code via an `EnabledControl`:

```java
private final EnabledControl convertEnabled = new EnabledControl(true);

SettingsSpec.builder()
        .button("Convert", this::startConvert).enabled(convertEnabled)
        .liveText("Status", () -> status)
        .build();

// later, on the worker thread:
convertEnabled.set(false);   // greys out the button while the job runs
// ...
convertEnabled.set(true);    // re-enable when done
```

`enabled(control)` chains right after a setting and binds the control to the
last-declared node. `control.set(boolean)` is safe from any thread — the
renderer hops to the EDT and recursively toggles every Swing child under the
node so labels grey out alongside their fields and section children grey out
alongside their section. The initial state of the control is applied on the
first paint, so you can disable a setting before the panel is even shown.

## Single live label

A `liveText` is a one-line read-only label that the proxy polls on a UI timer
(twice per second). Pair it with a button for a "task + status" pattern:

```java
private volatile String status = "Idle.";

SettingsSpec.builder()
        .button("Run", () -> { status = "Running…"; doWork(); status = "Done."; })
        .liveText("Status", () -> status)
        .build();
```

Same contract as `liveList`: the supplier runs on the EDT, so it must be
cheap (read a volatile field, don't compute). Use for single dynamic values
— a status line, a counter, current ping. Multiple lines → use `liveList`.

## Buttons

A push-button has no key and no persisted value — it's a pure action. The
runnable fires on the EDT; offload anything blocking through
`ctx.offloadExecutor()` or `ctx.scheduler()`:

```java
SettingsSpec.builder()
        .button("Refresh", this::refresh)
        .button("Export to file…", () -> ctx.offloadExecutor().execute(this::export))
        .build();
```

Buttons are the right primitive for interaction-test-style modules — a panel
of named one-shot actions that read from other settings the user already
entered. They can sit anywhere in the spec, including inside sections.

## Sections

`.section(name, inner)` nests a sub-spec under a titled group:

```java
SettingsSpec.builder()
        .section("Entity overlay", SettingsSpec.builder()
                .bool("entityEnabled", "Enabled", false, v -> entityEnabled = v)
                .int_("entityRadius", "Radius", 1, 512, 64, v -> entityRadius = v)
                .build())
        .section("Block overlay", SettingsSpec.builder()
                .bool("blockEnabled", "Enabled", false, v -> blockEnabled = v)
                .string("blockName", "Block name", "", v -> blockName = v)
                .build())
        .build();
```

Sections never have a key — only their children do. Keys are still globally
unique within the module's spec: don't reuse "enabled" in two sections.

## Live lists

`.liveList(label, source)` adds a **read-only** list whose rows come from a
supplier the proxy polls on a UI timer. No persistence, no edit; this is the
channel for surfacing dynamic data — nearest entities, queue depth, current
ping, anything you compute on a scheduler tick.

```java
private volatile List<String> rowsSnapshot = List.of();

ctx.registerSettings(SettingsSpec.builder()
        .liveList("Top 100 nearest", () -> rowsSnapshot)
        .build());

// Somewhere in a scheduler tick:
rowsSnapshot = List.copyOf(computedRows);
```

Contract:

- `source.get()` is called on the EDT roughly twice per second.
- It must be cheap and thread-safe — read a volatile snapshot field, do not
  scan or sort on every call.
- Returning the same `List` reference twice in a row is fine and skips the
  re-paint.

### Clickable rows

The clickable overload takes an `IntConsumer` that receives the index of the
clicked row:

```java
.liveList("Nearest blocks (click to share)",
        () -> snapshot.rows(),
        idx -> onRowClicked(idx))
```

The module is responsible for the row→payload mapping. The robust pattern is
to publish text **and** payload through one volatile reference so both reads
see the same snapshot:

```java
private record Snapshot(List<String> rows, List<BlockPos> positions) {
    static final Snapshot EMPTY = new Snapshot(List.of(), List.of());
}
private volatile Snapshot snapshot = Snapshot.EMPTY;

private void onRowClicked(int idx) {
    Snapshot s = snapshot;                          // one volatile read
    if (idx < 0 || idx >= s.positions().size()) return;
    selectionBus.publishBlock(s.positions().get(idx));
}
```

Without that pairing the snapshot can advance between the user's click and
your lookup, and you'd act on a row that no longer matches the displayed
text.

## Cross-module wiring

Settings are owned by one module, but a row click in module A can mutate a
field in module B if both go through a shared **service** in the registry —
no direct dependency between the modules.

Pattern used for a "click a row, X/Y/Z snap to that target" behaviour:

1. Layer-1 module exposes a pub/sub service (e.g. `SelectionBus`) via
   `services().provide(...)`.
2. The publisher module looks it up as a soft dependency:
   ```java
   SelectionBus bus = ctx.services().get(SelectionBus.class).orElse(null);
   ```
   and publishes on its UI events.
3. The subscriber module looks it up the same way and registers a listener.
   If the listener touches Swing, hop to the EDT explicitly:
   ```java
   bus.onBlockSelected(p ->
           SwingUtilities.invokeLater(() -> applyBlockPos(x, y, z, p)));
   ```
4. Neither side declares `requires.services` for the bus — that would harden
   the dependency. The `.orElse(null)` keeps the module working under an older
   proxy that lacks the service.

## Update link footer

The proxy automatically renders a clickable link to the module's
[`module.json#updateUrl`](modules.md#modulejson) at the bottom of the settings
panel. No code on the module side. Clicking opens the URL in the user's system
browser.

This applies to both `registerSettings(SettingsSpec)` and the deprecated
`registerSettings(JPanel)` path — the link is wrapped onto the panel by the
proxy regardless. Omit `updateUrl` from `module.json` to hide the footer.

## Common patterns

**Soft service dependency.** Use `services().get(Foo.class)` (returns
`Optional`) when you want to degrade gracefully if a service is absent. Use
`services().require(Foo.class)` when you genuinely cannot run without it —
and declare it in `module.json#requires.services` so the proxy skips the
module with a friendly WARN instead of NPE'ing at startup.

**Radio button via enum.** Define a small enum, expose it via `.enum_`. The
proxy renders a combo box; the persisted value is the enum constant's name.

**Validating text input.** `.string(...)` saves on focus loss. To enforce a
schema (e.g. parseable as int), validate inside `onChange` and store a sentinel
or last-good value when the parse fails — the widget itself doesn't reject
input.

**Multiple boxes / many widgets.** A pure-Swing `JPanel` overload exists
(`registerSettings(JPanel)`) but is **deprecated** — it bypasses persistence
and ties the module to Swing. Use `SettingsSpec` and break complex panels into
nested sections.
