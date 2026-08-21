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

public class EntityEffect {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 24;
    public static final int VARIABLE_FIELD_COUNT = 6;
    public static final int VARIABLE_BLOCK_START = 48;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String id;
    @Nullable public String name;
    @Nullable public ApplicationEffects applicationEffects;
    public int worldRemovalSoundEventIndex;
    public int localRemovalSoundEventIndex;
    @Nullable public ModelOverride modelOverride;
    public float duration;
    public boolean infinite;
    public boolean debuff;
    @Nullable public String statusEffectIcon;
    @Nonnull public OverlapBehavior overlapBehavior = OverlapBehavior.Extend;
    public double damageCalculatorCooldown;
    @Nullable public java.util.Map<Integer, Float> statModifiers;
    @Nonnull public ValueType valueType = ValueType.Percent;

    public EntityEffect() {
    }

    public EntityEffect(@Nullable String id, @Nullable String name, @Nullable ApplicationEffects applicationEffects, int worldRemovalSoundEventIndex, int localRemovalSoundEventIndex, @Nullable ModelOverride modelOverride, float duration, boolean infinite, boolean debuff, @Nullable String statusEffectIcon, @Nonnull OverlapBehavior overlapBehavior, double damageCalculatorCooldown, @Nullable java.util.Map<Integer, Float> statModifiers, @Nonnull ValueType valueType) {
        this.id = id;
        this.name = name;
        this.applicationEffects = applicationEffects;
        this.worldRemovalSoundEventIndex = worldRemovalSoundEventIndex;
        this.localRemovalSoundEventIndex = localRemovalSoundEventIndex;
        this.modelOverride = modelOverride;
        this.duration = duration;
        this.infinite = infinite;
        this.debuff = debuff;
        this.statusEffectIcon = statusEffectIcon;
        this.overlapBehavior = overlapBehavior;
        this.damageCalculatorCooldown = damageCalculatorCooldown;
        this.statModifiers = statModifiers;
        this.valueType = valueType;
    }

    public EntityEffect(@Nonnull EntityEffect other) {
        this.id = other.id;
        this.name = other.name;
        this.applicationEffects = other.applicationEffects;
        this.worldRemovalSoundEventIndex = other.worldRemovalSoundEventIndex;
        this.localRemovalSoundEventIndex = other.localRemovalSoundEventIndex;
        this.modelOverride = other.modelOverride;
        this.duration = other.duration;
        this.infinite = other.infinite;
        this.debuff = other.debuff;
        this.statusEffectIcon = other.statusEffectIcon;
        this.overlapBehavior = other.overlapBehavior;
        this.damageCalculatorCooldown = other.damageCalculatorCooldown;
        this.statModifiers = other.statModifiers;
        this.valueType = other.valueType;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("EntityEffect", offset, (int) mem.byteSize());
        long needed = (long) offset + 48;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("EntityEffect", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 24, 48, "Id"), 4096000): null;
    }
    
    @Nullable
    public static String getName(MemorySegment mem) {
        return getName(mem, 0);
    }
    
    @Nullable
    public static String getName(MemorySegment mem, int offset) {
        return hasName(mem, offset) ? PacketIO.readVarString("Name", mem, offset + getValidatedOffset(mem, offset, 28, 48, "Name"), 4096000): null;
    }
    
    @Nullable
    public static ApplicationEffects getApplicationEffects(MemorySegment mem) {
        return getApplicationEffects(mem, 0);
    }
    
    @Nullable
    public static ApplicationEffects getApplicationEffects(MemorySegment mem, int offset) {
        return hasApplicationEffects(mem, offset) ? ApplicationEffects.toObject(mem, offset + getValidatedOffset(mem, offset, 32, 48, "ApplicationEffects")): null;
    }
    
    public static int getWorldRemovalSoundEventIndex(MemorySegment mem) {
        return getWorldRemovalSoundEventIndex(mem, 0);
    }
    
    public static int getWorldRemovalSoundEventIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getLocalRemovalSoundEventIndex(MemorySegment mem) {
        return getLocalRemovalSoundEventIndex(mem, 0);
    }
    
    public static int getLocalRemovalSoundEventIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    @Nullable
    public static ModelOverride getModelOverride(MemorySegment mem) {
        return getModelOverride(mem, 0);
    }
    
    @Nullable
    public static ModelOverride getModelOverride(MemorySegment mem, int offset) {
        return hasModelOverride(mem, offset) ? ModelOverride.toObject(mem, offset + getValidatedOffset(mem, offset, 36, 48, "ModelOverride")): null;
    }
    
    public static float getDuration(MemorySegment mem) {
        return getDuration(mem, 0);
    }
    
    public static float getDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "Duration");
    }
    
    public static boolean getInfinite(MemorySegment mem) {
        return getInfinite(mem, 0);
    }
    
    public static boolean getInfinite(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 13) & 0x01) != 0;
    }
    
    public static boolean getDebuff(MemorySegment mem) {
        return getDebuff(mem, 0);
    }
    
    public static boolean getDebuff(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 13) & 0x02) != 0;
    }
    
    @Nullable
    public static String getStatusEffectIcon(MemorySegment mem) {
        return getStatusEffectIcon(mem, 0);
    }
    
    @Nullable
    public static String getStatusEffectIcon(MemorySegment mem, int offset) {
        return hasStatusEffectIcon(mem, offset) ? PacketIO.readVarString("StatusEffectIcon", mem, offset + getValidatedOffset(mem, offset, 40, 48, "StatusEffectIcon"), 4096000): null;
    }
    
    public static OverlapBehavior getOverlapBehavior(MemorySegment mem) {
        return getOverlapBehavior(mem, 0);
    }
    
    public static OverlapBehavior getOverlapBehavior(MemorySegment mem, int offset) {
        return OverlapBehavior.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 14));
    }
    
    public static double getDamageCalculatorCooldown(MemorySegment mem) {
        return getDamageCalculatorCooldown(mem, 0);
    }
    
    public static double getDamageCalculatorCooldown(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 15), "DamageCalculatorCooldown");
    }
    
    @Nullable
    public static java.util.Map<Integer, Float> getStatModifiers(MemorySegment mem) {
        return getStatModifiers(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Integer, Float> getStatModifiers(MemorySegment mem, int offset) {
        if (!hasStatModifiers(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 44, 48, "StatModifiers");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("StatModifiers");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("StatModifiers", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("StatModifiers", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Integer, Float> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            var value = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("StatModifiers", key);
            }
        }
        return data;
    }
    
    public static ValueType getValueType(MemorySegment mem) {
        return getValueType(mem, 0);
    }
    
    public static ValueType getValueType(MemorySegment mem, int offset) {
        return ValueType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 23));
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasApplicationEffects(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasModelOverride(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasStatusEffectIcon(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasStatModifiers(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
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
    
    public static EntityEffect toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static EntityEffect toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one EntityEffect and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static EntityEffect toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 48;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 24, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 24, -1, "Id");
        }
        
        String v1 = null;
        if (hasName(mem, offset)) {
            requireSlot(mem, offset + 28, varPos, "Name");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Name", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 28, -1, "Name");
        }
        
        ApplicationEffects v2 = null;
        if (hasApplicationEffects(mem, offset)) {
            requireSlot(mem, offset + 32, varPos, "ApplicationEffects");
            v2 = ApplicationEffects.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 32, -1, "ApplicationEffects");
        }
        
        ModelOverride v5 = null;
        if (hasModelOverride(mem, offset)) {
            requireSlot(mem, offset + 36, varPos, "ModelOverride");
            v5 = ModelOverride.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 36, -1, "ModelOverride");
        }
        
        String v9 = null;
        if (hasStatusEffectIcon(mem, offset)) {
            requireSlot(mem, offset + 40, varPos, "StatusEffectIcon");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v9 = PacketIO.readVarString("StatusEffectIcon", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 40, -1, "StatusEffectIcon");
        }
        
        java.util.Map<Integer, Float> v12 = null;
        if (hasStatModifiers(mem, offset)) {
            requireSlot(mem, offset + 44, varPos, "StatModifiers");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("StatModifiers");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("StatModifiers", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("StatModifiers", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
            v12 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                var value = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                if (v12.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("StatModifiers", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 44, -1, "StatModifiers");
        }
        var result = new EntityEffect(
            v0,
            v1,
            v2,
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            v5,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "Duration"),
            (mem.get(PacketIO.PROTO_BYTE, offset + 13) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 13) & 0x02) != 0,
            v9,
            OverlapBehavior.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 14)),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 15), "DamageCalculatorCooldown"),
            v12,
            ValueType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 23))
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        if (this.name != null) nullBits |= 0x02;
        if (this.applicationEffects != null) nullBits |= 0x04;
        if (this.modelOverride != null) nullBits |= 0x08;
        if (this.statusEffectIcon != null) nullBits |= 0x10;
        if (this.statModifiers != null) nullBits |= 0x20;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.worldRemovalSoundEventIndex);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.localRemovalSoundEventIndex);
        PacketIO.requireFinite(this.duration, "Duration"); mem.set(PacketIO.PROTO_FLOAT, offset + 9, this.duration);
        byte boolBits0_0 = 0;
        if (this.infinite) boolBits0_0 |= 0x01;
        if (this.debuff) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 13 + 0, boolBits0_0);
        mem.set(PacketIO.PROTO_BYTE, offset + 14, (byte) this.overlapBehavior.getValue());
        PacketIO.requireFinite(this.damageCalculatorCooldown, "DamageCalculatorCooldown"); mem.set(PacketIO.PROTO_DOUBLE, offset + 15, this.damageCalculatorCooldown);
        mem.set(PacketIO.PROTO_BYTE, offset + 23, (byte) this.valueType.getValue());
        var varOffset = offset + 48;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 24, varOffset - offset - 48);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 24, -1);
        }
        if (this.name != null) {
            mem.set(PacketIO.PROTO_INT, offset + 28, varOffset - offset - 48);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.name, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 28, -1);
        }
        if (this.applicationEffects != null) {
            mem.set(PacketIO.PROTO_INT, offset + 32, varOffset - offset - 48);
            varOffset += this.applicationEffects.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 32, -1);
        }
        if (this.modelOverride != null) {
            mem.set(PacketIO.PROTO_INT, offset + 36, varOffset - offset - 48);
            varOffset += this.modelOverride.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 36, -1);
        }
        if (this.statusEffectIcon != null) {
            mem.set(PacketIO.PROTO_INT, offset + 40, varOffset - offset - 48);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.statusEffectIcon, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 40, -1);
        }
        if (this.statModifiers != null) {
            mem.set(PacketIO.PROTO_INT, offset + 44, varOffset - offset - 48);
            if (this.statModifiers.size() > 4096000) throw ProtocolException.dictionaryTooLarge("StatModifiers", statModifiers.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.statModifiers.size());
            for (var e : this.statModifiers.entrySet()) {
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
    public int computeSize() {
        int size = 48;
        if (id != null) size += PacketIO.stringSize(id);
    if (name != null) size += PacketIO.stringSize(name);
    if (applicationEffects != null) size += applicationEffects.computeSize();
    if (modelOverride != null) size += modelOverride.computeSize();
    if (statusEffectIcon != null) size += PacketIO.stringSize(statusEffectIcon);
    if (statModifiers != null) size += VarInt.size(statModifiers.size()) + statModifiers.size() * (4 + 4);

        return size;
    }

    public EntityEffect clone() {
        EntityEffect copy = new EntityEffect();
        copy.id = this.id;
        copy.name = this.name;
        copy.applicationEffects = this.applicationEffects != null ? this.applicationEffects.clone() : null;
        copy.worldRemovalSoundEventIndex = this.worldRemovalSoundEventIndex;
        copy.localRemovalSoundEventIndex = this.localRemovalSoundEventIndex;
        copy.modelOverride = this.modelOverride != null ? this.modelOverride.clone() : null;
        copy.duration = this.duration;
        copy.infinite = this.infinite;
        copy.debuff = this.debuff;
        copy.statusEffectIcon = this.statusEffectIcon;
        copy.overlapBehavior = this.overlapBehavior;
        copy.damageCalculatorCooldown = this.damageCalculatorCooldown;
        copy.statModifiers = this.statModifiers != null ? new java.util.HashMap<>(this.statModifiers) : null;
        copy.valueType = this.valueType;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EntityEffect other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.name, other.name) && java.util.Objects.equals(this.applicationEffects, other.applicationEffects) && this.worldRemovalSoundEventIndex == other.worldRemovalSoundEventIndex && this.localRemovalSoundEventIndex == other.localRemovalSoundEventIndex && java.util.Objects.equals(this.modelOverride, other.modelOverride) && this.duration == other.duration && this.infinite == other.infinite && this.debuff == other.debuff && java.util.Objects.equals(this.statusEffectIcon, other.statusEffectIcon) && java.util.Objects.equals(this.overlapBehavior, other.overlapBehavior) && this.damageCalculatorCooldown == other.damageCalculatorCooldown && java.util.Objects.equals(this.statModifiers, other.statModifiers) && java.util.Objects.equals(this.valueType, other.valueType);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, name, applicationEffects, worldRemovalSoundEventIndex, localRemovalSoundEventIndex, modelOverride, duration, infinite, debuff, statusEffectIcon, overlapBehavior, damageCalculatorCooldown, statModifiers, valueType);
    }

}