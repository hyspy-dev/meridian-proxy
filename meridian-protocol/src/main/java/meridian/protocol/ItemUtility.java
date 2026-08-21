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

public class ItemUtility {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 10;
    public static final int MAX_SIZE = 1626112020;

    public boolean usable;
    public boolean compatible;
    @Nullable public int[] entityStatsToClear;
    @Nullable public java.util.Map<Integer, Modifier[]> statModifiers;

    public ItemUtility() {
    }

    public ItemUtility(boolean usable, boolean compatible, @Nullable int[] entityStatsToClear, @Nullable java.util.Map<Integer, Modifier[]> statModifiers) {
        this.usable = usable;
        this.compatible = compatible;
        this.entityStatsToClear = entityStatsToClear;
        this.statModifiers = statModifiers;
    }

    public ItemUtility(@Nonnull ItemUtility other) {
        this.usable = other.usable;
        this.compatible = other.compatible;
        this.entityStatsToClear = other.entityStatsToClear;
        this.statModifiers = other.statModifiers;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemUtility", offset, (int) mem.byteSize());
        long needed = (long) offset + 10;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemUtility", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getUsable(MemorySegment mem) {
        return getUsable(mem, 0);
    }
    
    public static boolean getUsable(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x01) != 0;
    }
    
    public static boolean getCompatible(MemorySegment mem) {
        return getCompatible(mem, 0);
    }
    
    public static boolean getCompatible(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x02) != 0;
    }
    
    @Nullable
    public static int[] getEntityStatsToClear(MemorySegment mem) {
        return getEntityStatsToClear(mem, 0);
    }
    
    @Nullable
    public static int[] getEntityStatsToClear(MemorySegment mem, int offset) {
        if (!hasEntityStatsToClear(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 2, 10, "EntityStatsToClear");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("EntityStatsToClear");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("EntityStatsToClear", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("EntityStatsToClear", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    @Nullable
    public static java.util.Map<Integer, Modifier[]> getStatModifiers(MemorySegment mem) {
        return getStatModifiers(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Integer, Modifier[]> getStatModifiers(MemorySegment mem, int offset) {
        if (!hasStatModifiers(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 6, 10, "StatModifiers");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("StatModifiers");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("StatModifiers", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("StatModifiers", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Integer, Modifier[]> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            var valuePacked = VarInt.getWithLength(mem, off);
                if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                var valueLen = (int) valuePacked;
                var valueVarLen = (int) (valuePacked >>> 32);
                if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                if (off + valueVarLen + (long) valueLen * 6 > mem.byteSize())
                    throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 6, (int) mem.byteSize());
                off += valueVarLen;
                var value = new Modifier[valueLen];
                for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                    value[valueIdx] = Modifier.toObject(mem, off);
                    off += 6;
                }
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("StatModifiers", key);
            }
        }
        return data;
    }
    
    public static boolean hasEntityStatsToClear(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasStatModifiers(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
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
    
    public static ItemUtility toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemUtility toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemUtility and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemUtility toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 10;
        var varPos = 0;
        int[] v2 = null;
        if (hasEntityStatsToClear(mem, offset)) {
            requireSlot(mem, offset + 2, varPos, "EntityStatsToClear");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("EntityStatsToClear");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("EntityStatsToClear", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("EntityStatsToClear", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v2, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 2, -1, "EntityStatsToClear");
        }
        
        java.util.Map<Integer, Modifier[]> v3 = null;
        if (hasStatModifiers(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "StatModifiers");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("StatModifiers");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("StatModifiers", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("StatModifiers", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v3 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                var valuePacked = VarInt.getWithLength(mem, off);
                    if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                    var valueLen = (int) valuePacked;
                    var valueVarLen = (int) (valuePacked >>> 32);
                    if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                    if (off + valueVarLen + (long) valueLen * 6 > mem.byteSize())
                        throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 6, (int) mem.byteSize());
                    off += valueVarLen;
                    var value = new Modifier[valueLen];
                    for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                        value[valueIdx] = Modifier.toObject(mem, off);
                        off += 6;
                    }
                if (v3.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("StatModifiers", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 6, -1, "StatModifiers");
        }
        var result = new ItemUtility(
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x02) != 0,
            v2,
            v3
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.entityStatsToClear != null) nullBits |= 0x01;
        if (this.statModifiers != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        byte boolBits0_0 = 0;
        if (this.usable) boolBits0_0 |= 0x01;
        if (this.compatible) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 1 + 0, boolBits0_0);
        var varOffset = offset + 10;
        if (this.entityStatsToClear != null) {
            mem.set(PacketIO.PROTO_INT, offset + 2, varOffset - offset - 10);
            if (entityStatsToClear.length > 4096000) throw ProtocolException.arrayTooLong("EntityStatsToClear", entityStatsToClear.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.entityStatsToClear.length);
            
            MemorySegment.copy(this.entityStatsToClear, 0, mem, PacketIO.PROTO_INT, varOffset, this.entityStatsToClear.length);
            varOffset += this.entityStatsToClear.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 2, -1);
        }
        if (this.statModifiers != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 10);
            if (this.statModifiers.size() > 4096000) throw ProtocolException.dictionaryTooLarge("StatModifiers", statModifiers.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.statModifiers.size());
            for (var e : this.statModifiers.entrySet()) {
                mem.set(PacketIO.PROTO_INT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += VarInt.set(mem, varOffset, e.getValue().length);
                for (var arrItem : e.getValue()) {
                    varOffset += arrItem.serialize(mem, varOffset);
                }
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 10;
        if (entityStatsToClear != null) size += VarInt.size(entityStatsToClear.length) + entityStatsToClear.length * 4;
    if (statModifiers != null) {
        int statModifiersSize = 0;
for (var kvp : statModifiers.entrySet()) statModifiersSize += 4 + VarInt.size(kvp.getValue().length) + kvp.getValue().length * 6;
size += VarInt.size(statModifiers.size()) + statModifiersSize;
    }

        return size;
    }

    public ItemUtility clone() {
        ItemUtility copy = new ItemUtility();
        copy.usable = this.usable;
        copy.compatible = this.compatible;
        copy.entityStatsToClear = this.entityStatsToClear != null ? java.util.Arrays.copyOf(this.entityStatsToClear, this.entityStatsToClear.length) : null;
        if (this.statModifiers != null) {
            java.util.Map<Integer, Modifier[]> m = new java.util.HashMap<>();
            for (var e : this.statModifiers.entrySet()) { m.put(e.getKey(), java.util.Arrays.stream(e.getValue()).map(x -> x.clone()).toArray(Modifier[]::new)); }
            copy.statModifiers = m;
        }
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemUtility other)) return false;
        return this.usable == other.usable && this.compatible == other.compatible && java.util.Arrays.equals(this.entityStatsToClear, other.entityStatsToClear) && java.util.Objects.equals(this.statModifiers, other.statModifiers);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Boolean.hashCode(usable);
        result = 31 * result + Boolean.hashCode(compatible);
        result = 31 * result + java.util.Arrays.hashCode(entityStatsToClear);
        result = 31 * result + java.util.Objects.hashCode(statModifiers);
        return result;
    }

}