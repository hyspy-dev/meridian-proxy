// Auto-generated - do not edit
package meridian.protocol;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import java.util.HashMap;

public class ProjectileInteraction extends SimpleInteraction {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 23;
    public static final int VARIABLE_FIELD_COUNT = 6;
    public static final int VARIABLE_BLOCK_START = 47;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String configId;
    public boolean ignorePitch;
    public boolean ignoreYaw;
    public boolean ignoreRoll;

    public ProjectileInteraction() {
    }

    public ProjectileInteraction(@Nonnull WaitForDataFrom waitForDataFrom, @Nullable InteractionEffects effects, float horizontalSpeedMultiplier, float runTime, @Nonnull InteractionItemChangeBehavior onItemChangeBehavior, @Nullable java.util.Map<GameMode, InteractionSettings> settings, @Nonnull InteractionRules rules, @Nullable int[] tags, @Nullable InteractionCameraSettings camera, int next, int failed, @Nullable String configId, boolean ignorePitch, boolean ignoreYaw, boolean ignoreRoll) {
        this.waitForDataFrom = waitForDataFrom;
        this.effects = effects;
        this.horizontalSpeedMultiplier = horizontalSpeedMultiplier;
        this.runTime = runTime;
        this.onItemChangeBehavior = onItemChangeBehavior;
        this.settings = settings;
        this.rules = rules;
        this.tags = tags;
        this.camera = camera;
        this.next = next;
        this.failed = failed;
        this.configId = configId;
        this.ignorePitch = ignorePitch;
        this.ignoreYaw = ignoreYaw;
        this.ignoreRoll = ignoreRoll;
    }

    public ProjectileInteraction(@Nonnull ProjectileInteraction other) {
        this.waitForDataFrom = other.waitForDataFrom;
        this.effects = other.effects;
        this.horizontalSpeedMultiplier = other.horizontalSpeedMultiplier;
        this.runTime = other.runTime;
        this.onItemChangeBehavior = other.onItemChangeBehavior;
        this.settings = other.settings;
        this.rules = other.rules;
        this.tags = other.tags;
        this.camera = other.camera;
        this.next = other.next;
        this.failed = other.failed;
        this.configId = other.configId;
        this.ignorePitch = other.ignorePitch;
        this.ignoreYaw = other.ignoreYaw;
        this.ignoreRoll = other.ignoreRoll;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ProjectileInteraction", offset, (int) mem.byteSize());
        long needed = (long) offset + 47;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ProjectileInteraction", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static WaitForDataFrom getWaitForDataFrom(MemorySegment mem) {
        return getWaitForDataFrom(mem, 0);
    }
    
    public static WaitForDataFrom getWaitForDataFrom(MemorySegment mem, int offset) {
        return WaitForDataFrom.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static InteractionEffects getEffects(MemorySegment mem) {
        return getEffects(mem, 0);
    }
    
    @Nullable
    public static InteractionEffects getEffects(MemorySegment mem, int offset) {
        return hasEffects(mem, offset) ? InteractionEffects.toObject(mem, offset + getValidatedOffset(mem, offset, 23, 47, "Effects")): null;
    }
    
    public static float getHorizontalSpeedMultiplier(MemorySegment mem) {
        return getHorizontalSpeedMultiplier(mem, 0);
    }
    
    public static float getHorizontalSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "HorizontalSpeedMultiplier");
    }
    
    public static float getRunTime(MemorySegment mem) {
        return getRunTime(mem, 0);
    }
    
    public static float getRunTime(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 6), "RunTime");
    }
    
    public static InteractionItemChangeBehavior getOnItemChangeBehavior(MemorySegment mem) {
        return getOnItemChangeBehavior(mem, 0);
    }
    
    public static InteractionItemChangeBehavior getOnItemChangeBehavior(MemorySegment mem, int offset) {
        return InteractionItemChangeBehavior.fromValue(mem.get(PacketIO.PROTO_INT, offset + 10));
    }
    
    @Nullable
    public static java.util.Map<GameMode, InteractionSettings> getSettings(MemorySegment mem) {
        return getSettings(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<GameMode, InteractionSettings> getSettings(MemorySegment mem, int offset) {
        if (!hasSettings(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 27, 47, "Settings");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Settings");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Settings", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Settings", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<GameMode, InteractionSettings> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = GameMode.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                off += 1;
            var value = InteractionSettings.toObject(mem, off);
                off += 1;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Settings", key);
            }
        }
        return data;
    }
    
    public static InteractionRules getRules(MemorySegment mem) {
        return getRules(mem, 0);
    }
    
    public static InteractionRules getRules(MemorySegment mem, int offset) {
        return InteractionRules.toObject(mem, offset + getValidatedOffset(mem, offset, 31, 47, "Rules"));
    }
    
    @Nullable
    public static int[] getTags(MemorySegment mem) {
        return getTags(mem, 0);
    }
    
    @Nullable
    public static int[] getTags(MemorySegment mem, int offset) {
        if (!hasTags(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 35, 47, "Tags");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Tags");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Tags", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Tags", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    @Nullable
    public static InteractionCameraSettings getCamera(MemorySegment mem) {
        return getCamera(mem, 0);
    }
    
    @Nullable
    public static InteractionCameraSettings getCamera(MemorySegment mem, int offset) {
        return hasCamera(mem, offset) ? InteractionCameraSettings.toObject(mem, offset + getValidatedOffset(mem, offset, 39, 47, "Camera")): null;
    }
    
    public static int getNext(MemorySegment mem) {
        return getNext(mem, 0);
    }
    
    public static int getNext(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 14);
    }
    
    public static int getFailed(MemorySegment mem) {
        return getFailed(mem, 0);
    }
    
    public static int getFailed(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 18);
    }
    
    @Nullable
    public static String getConfigId(MemorySegment mem) {
        return getConfigId(mem, 0);
    }
    
    @Nullable
    public static String getConfigId(MemorySegment mem, int offset) {
        return hasConfigId(mem, offset) ? PacketIO.readVarString("ConfigId", mem, offset + getValidatedOffset(mem, offset, 43, 47, "ConfigId"), 4096000): null;
    }
    
    public static boolean getIgnorePitch(MemorySegment mem) {
        return getIgnorePitch(mem, 0);
    }
    
    public static boolean getIgnorePitch(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 22) & 0x01) != 0;
    }
    
    public static boolean getIgnoreYaw(MemorySegment mem) {
        return getIgnoreYaw(mem, 0);
    }
    
    public static boolean getIgnoreYaw(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 22) & 0x02) != 0;
    }
    
    public static boolean getIgnoreRoll(MemorySegment mem) {
        return getIgnoreRoll(mem, 0);
    }
    
    public static boolean getIgnoreRoll(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 22) & 0x04) != 0;
    }
    
    public static boolean hasEffects(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasSettings(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasTags(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasCamera(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasConfigId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    private static int getValidatedOffset(MemorySegment buffer, int base, int slotPosition, int varBlockStart, String fieldName) {
        int offset = buffer.get(PacketIO.PROTO_INT, base + slotPosition);
        if (offset < 0 || offset > buffer.byteSize() - base - varBlockStart)
            throw ProtocolException.invalidOffset(fieldName, offset, (int) buffer.byteSize());
        return varBlockStart + offset;
    }
    
    /**
     * Rejects an offset slot that does not name the position the field-order walk reached. A
     * present field must sit where the previous field ended, and an absent field carries -1, so
     * the slot a random-access getter resolves and the walk describe the same bytes.
     */
    private static void requireSlot(MemorySegment mem, int slotPosition, int expected, String fieldName) {
        int slot = mem.get(PacketIO.PROTO_INT, slotPosition);
        if (slot != expected) throw ProtocolException.nonCanonicalLayout(fieldName, slot, expected);
    }
    
    public static ProjectileInteraction toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ProjectileInteraction toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ProjectileInteraction and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ProjectileInteraction toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 47;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        InteractionEffects v1 = null;
        if (hasEffects(mem, offset)) {
            requireSlot(mem, offset + 23, varPos, "Effects");
            v1 = InteractionEffects.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 23, -1, "Effects");
        }
        
        java.util.Map<GameMode, InteractionSettings> v5 = null;
        if (hasSettings(mem, offset)) {
            requireSlot(mem, offset + 27, varPos, "Settings");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Settings");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Settings", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Settings", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            v5 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = GameMode.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                    off += 1;
                var value = InteractionSettings.toObject(mem, off);
                    off += 1;
                if (v5.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Settings", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 27, -1, "Settings");
        }
        
        InteractionRules v6;
        requireSlot(mem, offset + 31, varPos, "Rules");
        {
            v6 = InteractionRules.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        
        int[] v7 = null;
        if (hasTags(mem, offset)) {
            requireSlot(mem, offset + 35, varPos, "Tags");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Tags");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Tags", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Tags", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v7 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v7, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 35, -1, "Tags");
        }
        
        InteractionCameraSettings v8 = null;
        if (hasCamera(mem, offset)) {
            requireSlot(mem, offset + 39, varPos, "Camera");
            v8 = InteractionCameraSettings.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 39, -1, "Camera");
        }
        
        String v11 = null;
        if (hasConfigId(mem, offset)) {
            requireSlot(mem, offset + 43, varPos, "ConfigId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v11 = PacketIO.readVarString("ConfigId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 43, -1, "ConfigId");
        }
        var result = new ProjectileInteraction(
            WaitForDataFrom.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v1,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "HorizontalSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 6), "RunTime"),
            InteractionItemChangeBehavior.fromValue(mem.get(PacketIO.PROTO_INT, offset + 10)),
            v5,
            v6,
            v7,
            v8,
            mem.get(PacketIO.PROTO_INT, offset + 14),
            mem.get(PacketIO.PROTO_INT, offset + 18),
            v11,
            (mem.get(PacketIO.PROTO_BYTE, offset + 22) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 22) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 22) & 0x04) != 0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.effects != null) nullBits |= 0x01;
        if (this.settings != null) nullBits |= 0x02;
        if (this.tags != null) nullBits |= 0x04;
        if (this.camera != null) nullBits |= 0x08;
        if (this.configId != null) nullBits |= 0x10;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.waitForDataFrom.getValue());
        PacketIO.requireFinite(this.horizontalSpeedMultiplier, "HorizontalSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 2, this.horizontalSpeedMultiplier);
        PacketIO.requireFinite(this.runTime, "RunTime"); mem.set(PacketIO.PROTO_FLOAT, offset + 6, this.runTime);
        mem.set(PacketIO.PROTO_INT, offset + 10, this.onItemChangeBehavior.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 14, this.next);
        mem.set(PacketIO.PROTO_INT, offset + 18, this.failed);
        byte boolBits0_0 = 0;
        if (this.ignorePitch) boolBits0_0 |= 0x01;
        if (this.ignoreYaw) boolBits0_0 |= 0x02;
        if (this.ignoreRoll) boolBits0_0 |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 22 + 0, boolBits0_0);
        var varOffset = offset + 47;
        if (this.effects != null) {
            mem.set(PacketIO.PROTO_INT, offset + 23, varOffset - offset - 47);
            varOffset += this.effects.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 23, -1);
        }
        if (this.settings != null) {
            mem.set(PacketIO.PROTO_INT, offset + 27, varOffset - offset - 47);
            if (this.settings.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Settings", settings.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.settings.size());
            for (var e : this.settings.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 27, -1);
        }
        mem.set(PacketIO.PROTO_INT, offset + 31, varOffset - offset - 47);
        varOffset += this.rules.serialize(mem, varOffset);
        if (this.tags != null) {
            mem.set(PacketIO.PROTO_INT, offset + 35, varOffset - offset - 47);
            if (tags.length > 4096000) throw ProtocolException.arrayTooLong("Tags", tags.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.tags.length);
            
            MemorySegment.copy(this.tags, 0, mem, PacketIO.PROTO_INT, varOffset, this.tags.length);
            varOffset += this.tags.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 35, -1);
        }
        if (this.camera != null) {
            mem.set(PacketIO.PROTO_INT, offset + 39, varOffset - offset - 47);
            varOffset += this.camera.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 39, -1);
        }
        if (this.configId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 43, varOffset - offset - 47);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.configId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 43, -1);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 47;
        if (effects != null) size += effects.computeSize();
    if (settings != null) size += VarInt.size(settings.size()) + settings.size() * (1 + 1);
    size += rules.computeSize();
    if (tags != null) size += VarInt.size(tags.length) + tags.length * 4;
    if (camera != null) size += camera.computeSize();
    if (configId != null) size += PacketIO.stringSize(configId);

        return size;
    }

    public ProjectileInteraction clone() {
        ProjectileInteraction copy = new ProjectileInteraction();
        copy.waitForDataFrom = this.waitForDataFrom;
        copy.effects = this.effects != null ? this.effects.clone() : null;
        copy.horizontalSpeedMultiplier = this.horizontalSpeedMultiplier;
        copy.runTime = this.runTime;
        copy.onItemChangeBehavior = this.onItemChangeBehavior;
        if (this.settings != null) {
            java.util.Map<GameMode, InteractionSettings> m = new java.util.HashMap<>();
            for (var e : this.settings.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.settings = m;
        }
        copy.rules = this.rules.clone();
        copy.tags = this.tags != null ? java.util.Arrays.copyOf(this.tags, this.tags.length) : null;
        copy.camera = this.camera != null ? this.camera.clone() : null;
        copy.next = this.next;
        copy.failed = this.failed;
        copy.configId = this.configId;
        copy.ignorePitch = this.ignorePitch;
        copy.ignoreYaw = this.ignoreYaw;
        copy.ignoreRoll = this.ignoreRoll;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ProjectileInteraction other)) return false;
        return java.util.Objects.equals(this.waitForDataFrom, other.waitForDataFrom) && java.util.Objects.equals(this.effects, other.effects) && this.horizontalSpeedMultiplier == other.horizontalSpeedMultiplier && this.runTime == other.runTime && java.util.Objects.equals(this.onItemChangeBehavior, other.onItemChangeBehavior) && java.util.Objects.equals(this.settings, other.settings) && java.util.Objects.equals(this.rules, other.rules) && java.util.Arrays.equals(this.tags, other.tags) && java.util.Objects.equals(this.camera, other.camera) && this.next == other.next && this.failed == other.failed && java.util.Objects.equals(this.configId, other.configId) && this.ignorePitch == other.ignorePitch && this.ignoreYaw == other.ignoreYaw && this.ignoreRoll == other.ignoreRoll;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(waitForDataFrom);
        result = 31 * result + java.util.Objects.hashCode(effects);
        result = 31 * result + Float.hashCode(horizontalSpeedMultiplier);
        result = 31 * result + Float.hashCode(runTime);
        result = 31 * result + java.util.Objects.hashCode(onItemChangeBehavior);
        result = 31 * result + java.util.Objects.hashCode(settings);
        result = 31 * result + java.util.Objects.hashCode(rules);
        result = 31 * result + java.util.Arrays.hashCode(tags);
        result = 31 * result + java.util.Objects.hashCode(camera);
        result = 31 * result + Integer.hashCode(next);
        result = 31 * result + Integer.hashCode(failed);
        result = 31 * result + java.util.Objects.hashCode(configId);
        result = 31 * result + Boolean.hashCode(ignorePitch);
        result = 31 * result + Boolean.hashCode(ignoreYaw);
        result = 31 * result + Boolean.hashCode(ignoreRoll);
        return result;
    }

}