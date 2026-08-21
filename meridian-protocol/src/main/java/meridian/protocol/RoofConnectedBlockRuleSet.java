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


public class RoofConnectedBlockRuleSet extends ConnectedBlockRuleSet {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 21;
    public static final int MAX_SIZE = 49152078;

    @Nullable public StairConnectedBlockRuleSet regular;
    @Nullable public StairConnectedBlockRuleSet hollow;
    public int topperBlockId;
    public int width;
    @Nullable public String materialName;

    public RoofConnectedBlockRuleSet() {
    }

    public RoofConnectedBlockRuleSet(@Nullable StairConnectedBlockRuleSet regular, @Nullable StairConnectedBlockRuleSet hollow, int topperBlockId, int width, @Nullable String materialName) {
        this.regular = regular;
        this.hollow = hollow;
        this.topperBlockId = topperBlockId;
        this.width = width;
        this.materialName = materialName;
    }

    public RoofConnectedBlockRuleSet(@Nonnull RoofConnectedBlockRuleSet other) {
        this.regular = other.regular;
        this.hollow = other.hollow;
        this.topperBlockId = other.topperBlockId;
        this.width = other.width;
        this.materialName = other.materialName;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("RoofConnectedBlockRuleSet", offset, (int) mem.byteSize());
        long needed = (long) offset + 21;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("RoofConnectedBlockRuleSet", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static StairConnectedBlockRuleSet getRegular(MemorySegment mem) {
        return getRegular(mem, 0);
    }
    
    @Nullable
    public static StairConnectedBlockRuleSet getRegular(MemorySegment mem, int offset) {
        return hasRegular(mem, offset) ? StairConnectedBlockRuleSet.toObject(mem, offset + getValidatedOffset(mem, offset, 9, 21, "Regular")): null;
    }
    
    @Nullable
    public static StairConnectedBlockRuleSet getHollow(MemorySegment mem) {
        return getHollow(mem, 0);
    }
    
    @Nullable
    public static StairConnectedBlockRuleSet getHollow(MemorySegment mem, int offset) {
        return hasHollow(mem, offset) ? StairConnectedBlockRuleSet.toObject(mem, offset + getValidatedOffset(mem, offset, 13, 21, "Hollow")): null;
    }
    
    public static int getTopperBlockId(MemorySegment mem) {
        return getTopperBlockId(mem, 0);
    }
    
    public static int getTopperBlockId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getWidth(MemorySegment mem) {
        return getWidth(mem, 0);
    }
    
    public static int getWidth(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    @Nullable
    public static String getMaterialName(MemorySegment mem) {
        return getMaterialName(mem, 0);
    }
    
    @Nullable
    public static String getMaterialName(MemorySegment mem, int offset) {
        return hasMaterialName(mem, offset) ? PacketIO.readVarString("MaterialName", mem, offset + getValidatedOffset(mem, offset, 17, 21, "MaterialName"), 4096000): null;
    }
    
    public static boolean hasRegular(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasHollow(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasMaterialName(MemorySegment mem, int offset) {
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
    
    public static RoofConnectedBlockRuleSet toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static RoofConnectedBlockRuleSet toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one RoofConnectedBlockRuleSet and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static RoofConnectedBlockRuleSet toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 21;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        StairConnectedBlockRuleSet v0 = null;
        if (hasRegular(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "Regular");
            v0 = StairConnectedBlockRuleSet.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 9, -1, "Regular");
        }
        
        StairConnectedBlockRuleSet v1 = null;
        if (hasHollow(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "Hollow");
            v1 = StairConnectedBlockRuleSet.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 13, -1, "Hollow");
        }
        
        String v4 = null;
        if (hasMaterialName(mem, offset)) {
            requireSlot(mem, offset + 17, varPos, "MaterialName");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v4 = PacketIO.readVarString("MaterialName", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 17, -1, "MaterialName");
        }
        var result = new RoofConnectedBlockRuleSet(
            v0,
            v1,
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            v4
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.regular != null) nullBits |= 0x01;
        if (this.hollow != null) nullBits |= 0x02;
        if (this.materialName != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.topperBlockId);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.width);
        var varOffset = offset + 21;
        if (this.regular != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 21);
            varOffset += this.regular.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
        if (this.hollow != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 21);
            varOffset += this.hollow.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
        if (this.materialName != null) {
            mem.set(PacketIO.PROTO_INT, offset + 17, varOffset - offset - 21);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.materialName, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 17, -1);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 21;
        if (regular != null) size += regular.computeSize();
    if (hollow != null) size += hollow.computeSize();
    if (materialName != null) size += PacketIO.stringSize(materialName);

        return size;
    }

    public RoofConnectedBlockRuleSet clone() {
        RoofConnectedBlockRuleSet copy = new RoofConnectedBlockRuleSet();
        copy.regular = this.regular != null ? this.regular.clone() : null;
        copy.hollow = this.hollow != null ? this.hollow.clone() : null;
        copy.topperBlockId = this.topperBlockId;
        copy.width = this.width;
        copy.materialName = this.materialName;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RoofConnectedBlockRuleSet other)) return false;
        return java.util.Objects.equals(this.regular, other.regular) && java.util.Objects.equals(this.hollow, other.hollow) && this.topperBlockId == other.topperBlockId && this.width == other.width && java.util.Objects.equals(this.materialName, other.materialName);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(regular, hollow, topperBlockId, width, materialName);
    }

}