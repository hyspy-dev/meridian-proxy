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

public class EntityStatUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 13;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 21;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public EntityStatOp op = EntityStatOp.Init;
    public boolean predictable;
    public float value;
    @Nullable public java.util.Map<String, Modifier> modifiers;
    @Nullable public String modifierKey;
    @Nullable public Modifier modifier;

    public EntityStatUpdate() {
    }

    public EntityStatUpdate(@Nonnull EntityStatOp op, boolean predictable, float value, @Nullable java.util.Map<String, Modifier> modifiers, @Nullable String modifierKey, @Nullable Modifier modifier) {
        this.op = op;
        this.predictable = predictable;
        this.value = value;
        this.modifiers = modifiers;
        this.modifierKey = modifierKey;
        this.modifier = modifier;
    }

    public EntityStatUpdate(@Nonnull EntityStatUpdate other) {
        this.op = other.op;
        this.predictable = other.predictable;
        this.value = other.value;
        this.modifiers = other.modifiers;
        this.modifierKey = other.modifierKey;
        this.modifier = other.modifier;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("EntityStatUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 21;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("EntityStatUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static EntityStatOp getOp(MemorySegment mem) {
        return getOp(mem, 0);
    }
    
    public static EntityStatOp getOp(MemorySegment mem, int offset) {
        return EntityStatOp.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static boolean getPredictable(MemorySegment mem) {
        return getPredictable(mem, 0);
    }
    
    public static boolean getPredictable(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 2);
    }
    
    public static float getValue(MemorySegment mem) {
        return getValue(mem, 0);
    }
    
    public static float getValue(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 3), "Value");
    }
    
    @Nullable
    public static java.util.Map<String, Modifier> getModifiers(MemorySegment mem) {
        return getModifiers(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, Modifier> getModifiers(MemorySegment mem, int offset) {
        if (!hasModifiers(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 13, 21, "Modifiers");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Modifiers");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Modifiers", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 7 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Modifiers", (int) java.lang.Math.min(off + (long) len * 7, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, Modifier> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = Modifier.toObject(mem, off);
                off += 6;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Modifiers", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static String getModifierKey(MemorySegment mem) {
        return getModifierKey(mem, 0);
    }
    
    @Nullable
    public static String getModifierKey(MemorySegment mem, int offset) {
        return hasModifierKey(mem, offset) ? PacketIO.readVarString("ModifierKey", mem, offset + getValidatedOffset(mem, offset, 17, 21, "ModifierKey"), 4096000): null;
    }
    
    @Nullable
    public static Modifier getModifier(MemorySegment mem) {
        return getModifier(mem, 0);
    }
    
    @Nullable
    public static Modifier getModifier(MemorySegment mem, int offset) {
        return hasModifier(mem, offset) ? Modifier.toObject(mem, offset + 7): null;
    }
    
    public static boolean hasModifier(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasModifiers(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasModifierKey(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
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
    
    public static EntityStatUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static EntityStatUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one EntityStatUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static EntityStatUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 21;
        var varPos = 0;
        java.util.Map<String, Modifier> v3 = null;
        if (hasModifiers(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "Modifiers");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Modifiers");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Modifiers", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 7 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Modifiers", (int) java.lang.Math.min(off + (long) len * 7, Integer.MAX_VALUE), (int) mem.byteSize());
            v3 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = Modifier.toObject(mem, off);
                    off += 6;
                if (v3.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Modifiers", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 13, -1, "Modifiers");
        }
        
        String v4 = null;
        if (hasModifierKey(mem, offset)) {
            requireSlot(mem, offset + 17, varPos, "ModifierKey");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v4 = PacketIO.readVarString("ModifierKey", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 17, -1, "ModifierKey");
        }
        var result = new EntityStatUpdate(
            EntityStatOp.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            mem.get(PacketIO.PROTO_BOOL, offset + 2),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 3), "Value"),
            v3,
            v4,
            hasModifier(mem, offset) ? Modifier.toObject(mem, offset + 7) : null
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.modifier != null) nullBits |= 0x01;
        if (this.modifiers != null) nullBits |= 0x02;
        if (this.modifierKey != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.op.getValue());
        mem.set(PacketIO.PROTO_BOOL, offset + 2, this.predictable);
        PacketIO.requireFinite(this.value, "Value"); mem.set(PacketIO.PROTO_FLOAT, offset + 3, this.value);
        if (this.modifier != null) {
            this.modifier.serialize(mem, offset + 7);
        } else {
            mem.asSlice(offset + 7, 6).fill((byte) 0); 
        }
        var varOffset = offset + 21;
        if (this.modifiers != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 21);
            if (this.modifiers.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Modifiers", modifiers.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.modifiers.size());
            for (var e : this.modifiers.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
        if (this.modifierKey != null) {
            mem.set(PacketIO.PROTO_INT, offset + 17, varOffset - offset - 21);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.modifierKey, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 17, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 21;
        if (modifiers != null) {
        int modifiersSize = 0;
for (var kvp : modifiers.entrySet()) modifiersSize += PacketIO.stringSize(kvp.getKey()) + 6;
size += VarInt.size(modifiers.size()) + modifiersSize;
    }
    if (modifierKey != null) size += PacketIO.stringSize(modifierKey);

        return size;
    }

    public EntityStatUpdate clone() {
        EntityStatUpdate copy = new EntityStatUpdate();
        copy.op = this.op;
        copy.predictable = this.predictable;
        copy.value = this.value;
        if (this.modifiers != null) {
            java.util.Map<String, Modifier> m = new java.util.HashMap<>();
            for (var e : this.modifiers.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.modifiers = m;
        }
        copy.modifierKey = this.modifierKey;
        copy.modifier = this.modifier != null ? this.modifier.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EntityStatUpdate other)) return false;
        return java.util.Objects.equals(this.op, other.op) && this.predictable == other.predictable && this.value == other.value && java.util.Objects.equals(this.modifiers, other.modifiers) && java.util.Objects.equals(this.modifierKey, other.modifierKey) && java.util.Objects.equals(this.modifier, other.modifier);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(op, predictable, value, modifiers, modifierKey, modifier);
    }

}