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

public class StatsConditionInteraction extends SimpleInteraction {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 24;
    public static final int VARIABLE_FIELD_COUNT = 6;
    public static final int VARIABLE_BLOCK_START = 48;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public java.util.Map<Integer, Float> costs;
    public boolean lessThan;
    public boolean lenient;
    @Nonnull public ValueType valueType = ValueType.Percent;

    public StatsConditionInteraction() {
    }

    public StatsConditionInteraction(@Nonnull WaitForDataFrom waitForDataFrom, @Nullable InteractionEffects effects, float horizontalSpeedMultiplier, float runTime, @Nonnull InteractionItemChangeBehavior onItemChangeBehavior, @Nullable java.util.Map<GameMode, InteractionSettings> settings, @Nonnull InteractionRules rules, @Nullable int[] tags, @Nullable InteractionCameraSettings camera, int next, int failed, @Nullable java.util.Map<Integer, Float> costs, boolean lessThan, boolean lenient, @Nonnull ValueType valueType) {
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
        this.costs = costs;
        this.lessThan = lessThan;
        this.lenient = lenient;
        this.valueType = valueType;
    }

    public StatsConditionInteraction(@Nonnull StatsConditionInteraction other) {
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
        this.costs = other.costs;
        this.lessThan = other.lessThan;
        this.lenient = other.lenient;
        this.valueType = other.valueType;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("StatsConditionInteraction", offset, (int) mem.byteSize());
        long needed = (long) offset + 48;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("StatsConditionInteraction", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
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
        return hasEffects(mem, offset) ? InteractionEffects.toObject(mem, offset + getValidatedOffset(mem, offset, 24, 48, "Effects")): null;
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
        var off = offset + getValidatedOffset(mem, offset, 28, 48, "Settings");
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
        return InteractionRules.toObject(mem, offset + getValidatedOffset(mem, offset, 32, 48, "Rules"));
    }
    
    @Nullable
    public static int[] getTags(MemorySegment mem) {
        return getTags(mem, 0);
    }
    
    @Nullable
    public static int[] getTags(MemorySegment mem, int offset) {
        if (!hasTags(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 36, 48, "Tags");
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
        return hasCamera(mem, offset) ? InteractionCameraSettings.toObject(mem, offset + getValidatedOffset(mem, offset, 40, 48, "Camera")): null;
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
    public static java.util.Map<Integer, Float> getCosts(MemorySegment mem) {
        return getCosts(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Integer, Float> getCosts(MemorySegment mem, int offset) {
        if (!hasCosts(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 44, 48, "Costs");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Costs");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Costs", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Costs", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Integer, Float> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            var value = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Costs", key);
            }
        }
        return data;
    }
    
    public static boolean getLessThan(MemorySegment mem) {
        return getLessThan(mem, 0);
    }
    
    public static boolean getLessThan(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 22) & 0x01) != 0;
    }
    
    public static boolean getLenient(MemorySegment mem) {
        return getLenient(mem, 0);
    }
    
    public static boolean getLenient(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 22) & 0x02) != 0;
    }
    
    public static ValueType getValueType(MemorySegment mem) {
        return getValueType(mem, 0);
    }
    
    public static ValueType getValueType(MemorySegment mem, int offset) {
        return ValueType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 23));
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
    
    public static boolean hasCosts(MemorySegment mem, int offset) {
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
    
    public static StatsConditionInteraction toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static StatsConditionInteraction toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one StatsConditionInteraction and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static StatsConditionInteraction toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 48;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        InteractionEffects v1 = null;
        if (hasEffects(mem, offset)) {
            requireSlot(mem, offset + 24, varPos, "Effects");
            v1 = InteractionEffects.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 24, -1, "Effects");
        }
        
        java.util.Map<GameMode, InteractionSettings> v5 = null;
        if (hasSettings(mem, offset)) {
            requireSlot(mem, offset + 28, varPos, "Settings");
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
            requireSlot(mem, offset + 28, -1, "Settings");
        }
        
        InteractionRules v6;
        requireSlot(mem, offset + 32, varPos, "Rules");
        {
            v6 = InteractionRules.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        
        int[] v7 = null;
        if (hasTags(mem, offset)) {
            requireSlot(mem, offset + 36, varPos, "Tags");
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
            requireSlot(mem, offset + 36, -1, "Tags");
        }
        
        InteractionCameraSettings v8 = null;
        if (hasCamera(mem, offset)) {
            requireSlot(mem, offset + 40, varPos, "Camera");
            v8 = InteractionCameraSettings.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 40, -1, "Camera");
        }
        
        java.util.Map<Integer, Float> v11 = null;
        if (hasCosts(mem, offset)) {
            requireSlot(mem, offset + 44, varPos, "Costs");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Costs");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Costs", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Costs", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
            v11 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                var value = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                if (v11.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Costs", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 44, -1, "Costs");
        }
        var result = new StatsConditionInteraction(
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
            ValueType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 23))
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
        if (this.costs != null) nullBits |= 0x10;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.waitForDataFrom.getValue());
        PacketIO.requireFinite(this.horizontalSpeedMultiplier, "HorizontalSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 2, this.horizontalSpeedMultiplier);
        PacketIO.requireFinite(this.runTime, "RunTime"); mem.set(PacketIO.PROTO_FLOAT, offset + 6, this.runTime);
        mem.set(PacketIO.PROTO_INT, offset + 10, this.onItemChangeBehavior.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 14, this.next);
        mem.set(PacketIO.PROTO_INT, offset + 18, this.failed);
        byte boolBits0_0 = 0;
        if (this.lessThan) boolBits0_0 |= 0x01;
        if (this.lenient) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 22 + 0, boolBits0_0);
        mem.set(PacketIO.PROTO_BYTE, offset + 23, (byte) this.valueType.getValue());
        var varOffset = offset + 48;
        if (this.effects != null) {
            mem.set(PacketIO.PROTO_INT, offset + 24, varOffset - offset - 48);
            varOffset += this.effects.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 24, -1);
        }
        if (this.settings != null) {
            mem.set(PacketIO.PROTO_INT, offset + 28, varOffset - offset - 48);
            if (this.settings.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Settings", settings.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.settings.size());
            for (var e : this.settings.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 28, -1);
        }
        mem.set(PacketIO.PROTO_INT, offset + 32, varOffset - offset - 48);
        varOffset += this.rules.serialize(mem, varOffset);
        if (this.tags != null) {
            mem.set(PacketIO.PROTO_INT, offset + 36, varOffset - offset - 48);
            if (tags.length > 4096000) throw ProtocolException.arrayTooLong("Tags", tags.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.tags.length);
            
            MemorySegment.copy(this.tags, 0, mem, PacketIO.PROTO_INT, varOffset, this.tags.length);
            varOffset += this.tags.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 36, -1);
        }
        if (this.camera != null) {
            mem.set(PacketIO.PROTO_INT, offset + 40, varOffset - offset - 48);
            varOffset += this.camera.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 40, -1);
        }
        if (this.costs != null) {
            mem.set(PacketIO.PROTO_INT, offset + 44, varOffset - offset - 48);
            if (this.costs.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Costs", costs.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.costs.size());
            for (var e : this.costs.entrySet()) {
                mem.set(PacketIO.PROTO_INT, varOffset, e.getKey());
                varOffset += 4;
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 44, -1);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 48;
        if (effects != null) size += effects.computeSize();
    if (settings != null) size += VarInt.size(settings.size()) + settings.size() * (1 + 1);
    size += rules.computeSize();
    if (tags != null) size += VarInt.size(tags.length) + tags.length * 4;
    if (camera != null) size += camera.computeSize();
    if (costs != null) size += VarInt.size(costs.size()) + costs.size() * (4 + 4);

        return size;
    }

    public StatsConditionInteraction clone() {
        StatsConditionInteraction copy = new StatsConditionInteraction();
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
        copy.costs = this.costs != null ? new java.util.HashMap<>(this.costs) : null;
        copy.lessThan = this.lessThan;
        copy.lenient = this.lenient;
        copy.valueType = this.valueType;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof StatsConditionInteraction other)) return false;
        return java.util.Objects.equals(this.waitForDataFrom, other.waitForDataFrom) && java.util.Objects.equals(this.effects, other.effects) && this.horizontalSpeedMultiplier == other.horizontalSpeedMultiplier && this.runTime == other.runTime && java.util.Objects.equals(this.onItemChangeBehavior, other.onItemChangeBehavior) && java.util.Objects.equals(this.settings, other.settings) && java.util.Objects.equals(this.rules, other.rules) && java.util.Arrays.equals(this.tags, other.tags) && java.util.Objects.equals(this.camera, other.camera) && this.next == other.next && this.failed == other.failed && java.util.Objects.equals(this.costs, other.costs) && this.lessThan == other.lessThan && this.lenient == other.lenient && java.util.Objects.equals(this.valueType, other.valueType);
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
        result = 31 * result + java.util.Objects.hashCode(costs);
        result = 31 * result + Boolean.hashCode(lessThan);
        result = 31 * result + Boolean.hashCode(lenient);
        result = 31 * result + java.util.Objects.hashCode(valueType);
        return result;
    }

}