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


public class TagPattern {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 14;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public TagPatternType type = TagPatternType.Equals;
    public int tagIndex;
    @Nullable public TagPattern[] operands;
    @Nullable public TagPattern not;

    public TagPattern() {
    }

    public TagPattern(@Nonnull TagPatternType type, int tagIndex, @Nullable TagPattern[] operands, @Nullable TagPattern not) {
        this.type = type;
        this.tagIndex = tagIndex;
        this.operands = operands;
        this.not = not;
    }

    public TagPattern(@Nonnull TagPattern other) {
        this.type = other.type;
        this.tagIndex = other.tagIndex;
        this.operands = other.operands;
        this.not = other.not;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("TagPattern", offset, (int) mem.byteSize());
        long needed = (long) offset + 14;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("TagPattern", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static TagPatternType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static TagPatternType getType(MemorySegment mem, int offset) {
        return TagPatternType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static int getTagIndex(MemorySegment mem) {
        return getTagIndex(mem, 0);
    }
    
    public static int getTagIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 2);
    }
    
    @Nullable
    public static TagPattern[] getOperands(MemorySegment mem) {
        return getOperands(mem, 0);
    }
    
    @Nullable
    public static TagPattern[] getOperands(MemorySegment mem, int offset) {
        if (!hasOperands(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 6, 14, "Operands");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Operands");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Operands", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 14 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Operands", (int) java.lang.Math.min(off + lenOffset + (long) len * 14, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new TagPattern[len];
        for (var i = 0; i < len; i++) {
            data[i] = TagPattern.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static TagPattern getNot(MemorySegment mem) {
        return getNot(mem, 0);
    }
    
    @Nullable
    public static TagPattern getNot(MemorySegment mem, int offset) {
        return hasNot(mem, offset) ? TagPattern.toObject(mem, offset + getValidatedOffset(mem, offset, 10, 14, "Not")): null;
    }
    
    public static boolean hasOperands(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasNot(MemorySegment mem, int offset) {
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
    
    public static TagPattern toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static TagPattern toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one TagPattern and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static TagPattern toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 14;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        TagPattern[] v2 = null;
        if (hasOperands(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "Operands");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Operands");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Operands", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 14 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Operands", (int) java.lang.Math.min(off + lenOffset + (long) len * 14, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new TagPattern[len];
            for (var i = 0; i < len; i++) {
                v2[i] = TagPattern.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 6, -1, "Operands");
        }
        
        TagPattern v3 = null;
        if (hasNot(mem, offset)) {
            requireSlot(mem, offset + 10, varPos, "Not");
            v3 = TagPattern.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 10, -1, "Not");
        }
        var result = new TagPattern(
            TagPatternType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            mem.get(PacketIO.PROTO_INT, offset + 2),
            v2,
            v3
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.operands != null) nullBits |= 0x01;
        if (this.not != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 2, this.tagIndex);
        var varOffset = offset + 14;
        if (this.operands != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 14);
            if (operands.length > 4096000) throw ProtocolException.arrayTooLong("Operands", operands.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.operands.length);
            
            var operandsValueOffset = 0;
            for (var i = 0; i < this.operands.length; i++) {
                operandsValueOffset += this.operands[i].serialize(mem, varOffset + operandsValueOffset);
            }
            varOffset += operandsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
        if (this.not != null) {
            mem.set(PacketIO.PROTO_INT, offset + 10, varOffset - offset - 14);
            varOffset += this.not.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 10, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 14;
        if (operands != null) {
        int operandsSize = 0;
for (var elem : operands) operandsSize += elem.computeSize();
size += VarInt.size(operands.length) + operandsSize;
    }
    if (not != null) size += not.computeSize();

        return size;
    }

    public TagPattern clone() {
        TagPattern copy = new TagPattern();
        copy.type = this.type;
        copy.tagIndex = this.tagIndex;
        copy.operands = this.operands != null ? java.util.Arrays.stream(this.operands).map(e -> e.clone()).toArray(TagPattern[]::new) : null;
        copy.not = this.not != null ? this.not.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TagPattern other)) return false;
        return java.util.Objects.equals(this.type, other.type) && this.tagIndex == other.tagIndex && java.util.Arrays.equals(this.operands, other.operands) && java.util.Objects.equals(this.not, other.not);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(type);
        result = 31 * result + Integer.hashCode(tagIndex);
        result = 31 * result + java.util.Arrays.hashCode(operands);
        result = 31 * result + java.util.Objects.hashCode(not);
        return result;
    }

}