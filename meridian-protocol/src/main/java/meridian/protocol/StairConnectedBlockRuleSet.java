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


public class StairConnectedBlockRuleSet extends ConnectedBlockRuleSet {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 21;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 21;
    public static final int MAX_SIZE = 16384026;

    public int straightBlockId;
    public int cornerLeftBlockId;
    public int cornerRightBlockId;
    public int invertedCornerLeftBlockId;
    public int invertedCornerRightBlockId;
    @Nullable public String materialName;

    public StairConnectedBlockRuleSet() {
    }

    public StairConnectedBlockRuleSet(int straightBlockId, int cornerLeftBlockId, int cornerRightBlockId, int invertedCornerLeftBlockId, int invertedCornerRightBlockId, @Nullable String materialName) {
        this.straightBlockId = straightBlockId;
        this.cornerLeftBlockId = cornerLeftBlockId;
        this.cornerRightBlockId = cornerRightBlockId;
        this.invertedCornerLeftBlockId = invertedCornerLeftBlockId;
        this.invertedCornerRightBlockId = invertedCornerRightBlockId;
        this.materialName = materialName;
    }

    public StairConnectedBlockRuleSet(@Nonnull StairConnectedBlockRuleSet other) {
        this.straightBlockId = other.straightBlockId;
        this.cornerLeftBlockId = other.cornerLeftBlockId;
        this.cornerRightBlockId = other.cornerRightBlockId;
        this.invertedCornerLeftBlockId = other.invertedCornerLeftBlockId;
        this.invertedCornerRightBlockId = other.invertedCornerRightBlockId;
        this.materialName = other.materialName;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("StairConnectedBlockRuleSet", offset, (int) mem.byteSize());
        long needed = (long) offset + 21;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("StairConnectedBlockRuleSet", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getStraightBlockId(MemorySegment mem) {
        return getStraightBlockId(mem, 0);
    }
    
    public static int getStraightBlockId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getCornerLeftBlockId(MemorySegment mem) {
        return getCornerLeftBlockId(mem, 0);
    }
    
    public static int getCornerLeftBlockId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static int getCornerRightBlockId(MemorySegment mem) {
        return getCornerRightBlockId(mem, 0);
    }
    
    public static int getCornerRightBlockId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 9);
    }
    
    public static int getInvertedCornerLeftBlockId(MemorySegment mem) {
        return getInvertedCornerLeftBlockId(mem, 0);
    }
    
    public static int getInvertedCornerLeftBlockId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 13);
    }
    
    public static int getInvertedCornerRightBlockId(MemorySegment mem) {
        return getInvertedCornerRightBlockId(mem, 0);
    }
    
    public static int getInvertedCornerRightBlockId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 17);
    }
    
    @Nullable
    public static String getMaterialName(MemorySegment mem) {
        return getMaterialName(mem, 0);
    }
    
    @Nullable
    public static String getMaterialName(MemorySegment mem, int offset) {
        return hasMaterialName(mem, offset) ? PacketIO.readVarString("MaterialName", mem, offset + 21, 4096000): null;
    }
    
    public static boolean hasMaterialName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static StairConnectedBlockRuleSet toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static StairConnectedBlockRuleSet toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one StairConnectedBlockRuleSet and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static StairConnectedBlockRuleSet toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 21;
        var varPos = 0;
        String v5 = null;
        if (hasMaterialName(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v5 = PacketIO.readVarString("MaterialName", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new StairConnectedBlockRuleSet(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            mem.get(PacketIO.PROTO_INT, offset + 9),
            mem.get(PacketIO.PROTO_INT, offset + 13),
            mem.get(PacketIO.PROTO_INT, offset + 17),
            v5
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.materialName != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.straightBlockId);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.cornerLeftBlockId);
        mem.set(PacketIO.PROTO_INT, offset + 9, this.cornerRightBlockId);
        mem.set(PacketIO.PROTO_INT, offset + 13, this.invertedCornerLeftBlockId);
        mem.set(PacketIO.PROTO_INT, offset + 17, this.invertedCornerRightBlockId);
        var varOffset = offset + 21;
        if (this.materialName != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.materialName, 4096000);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 21;
        if (materialName != null) size += PacketIO.stringSize(materialName);

        return size;
    }

    public StairConnectedBlockRuleSet clone() {
        StairConnectedBlockRuleSet copy = new StairConnectedBlockRuleSet();
        copy.straightBlockId = this.straightBlockId;
        copy.cornerLeftBlockId = this.cornerLeftBlockId;
        copy.cornerRightBlockId = this.cornerRightBlockId;
        copy.invertedCornerLeftBlockId = this.invertedCornerLeftBlockId;
        copy.invertedCornerRightBlockId = this.invertedCornerRightBlockId;
        copy.materialName = this.materialName;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof StairConnectedBlockRuleSet other)) return false;
        return this.straightBlockId == other.straightBlockId && this.cornerLeftBlockId == other.cornerLeftBlockId && this.cornerRightBlockId == other.cornerRightBlockId && this.invertedCornerLeftBlockId == other.invertedCornerLeftBlockId && this.invertedCornerRightBlockId == other.invertedCornerRightBlockId && java.util.Objects.equals(this.materialName, other.materialName);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(straightBlockId, cornerLeftBlockId, cornerRightBlockId, invertedCornerLeftBlockId, invertedCornerRightBlockId, materialName);
    }

}