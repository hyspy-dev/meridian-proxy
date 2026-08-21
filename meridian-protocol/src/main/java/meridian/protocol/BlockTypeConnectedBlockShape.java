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


public class BlockTypeConnectedBlockShape extends ConnectedBlockShape {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 1677721600;

    public int blockId;

    public BlockTypeConnectedBlockShape() {
    }

    public BlockTypeConnectedBlockShape(@Nullable ConnectedBlockFaceTags faceTags, int relativeRotationIndex, int blockId) {
        this.faceTags = faceTags;
        this.relativeRotationIndex = relativeRotationIndex;
        this.blockId = blockId;
    }

    public BlockTypeConnectedBlockShape(@Nonnull BlockTypeConnectedBlockShape other) {
        this.faceTags = other.faceTags;
        this.relativeRotationIndex = other.relativeRotationIndex;
        this.blockId = other.blockId;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BlockTypeConnectedBlockShape", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockTypeConnectedBlockShape", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static ConnectedBlockFaceTags getFaceTags(MemorySegment mem) {
        return getFaceTags(mem, 0);
    }
    
    @Nullable
    public static ConnectedBlockFaceTags getFaceTags(MemorySegment mem, int offset) {
        return hasFaceTags(mem, offset) ? ConnectedBlockFaceTags.toObject(mem, offset + 9): null;
    }
    
    public static int getRelativeRotationIndex(MemorySegment mem) {
        return getRelativeRotationIndex(mem, 0);
    }
    
    public static int getRelativeRotationIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getBlockId(MemorySegment mem) {
        return getBlockId(mem, 0);
    }
    
    public static int getBlockId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static boolean hasFaceTags(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static BlockTypeConnectedBlockShape toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BlockTypeConnectedBlockShape toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BlockTypeConnectedBlockShape and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BlockTypeConnectedBlockShape toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ConnectedBlockFaceTags v0 = null;
        if (hasFaceTags(mem, offset)) {
            v0 = ConnectedBlockFaceTags.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new BlockTypeConnectedBlockShape(
            v0,
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.faceTags != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.relativeRotationIndex);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.blockId);
        var varOffset = offset + 9;
        if (this.faceTags != null) {
            
            varOffset += this.faceTags.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 9;
        if (faceTags != null) size += faceTags.computeSize();

        return size;
    }

    public BlockTypeConnectedBlockShape clone() {
        BlockTypeConnectedBlockShape copy = new BlockTypeConnectedBlockShape();
        copy.faceTags = this.faceTags != null ? this.faceTags.clone() : null;
        copy.relativeRotationIndex = this.relativeRotationIndex;
        copy.blockId = this.blockId;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BlockTypeConnectedBlockShape other)) return false;
        return java.util.Objects.equals(this.faceTags, other.faceTags) && this.relativeRotationIndex == other.relativeRotationIndex && this.blockId == other.blockId;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(faceTags, relativeRotationIndex, blockId);
    }

}