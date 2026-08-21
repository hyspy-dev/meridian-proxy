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


public class BlockMatcher {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 3;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 3;
    public static final int MAX_SIZE = 32768026;

    @Nullable public BlockIdMatcher block;
    @Nonnull public BlockFace face = BlockFace.None;
    public boolean staticFace;

    public BlockMatcher() {
    }

    public BlockMatcher(@Nullable BlockIdMatcher block, @Nonnull BlockFace face, boolean staticFace) {
        this.block = block;
        this.face = face;
        this.staticFace = staticFace;
    }

    public BlockMatcher(@Nonnull BlockMatcher other) {
        this.block = other.block;
        this.face = other.face;
        this.staticFace = other.staticFace;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BlockMatcher", offset, (int) mem.byteSize());
        long needed = (long) offset + 3;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockMatcher", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static BlockIdMatcher getBlock(MemorySegment mem) {
        return getBlock(mem, 0);
    }
    
    @Nullable
    public static BlockIdMatcher getBlock(MemorySegment mem, int offset) {
        return hasBlock(mem, offset) ? BlockIdMatcher.toObject(mem, offset + 3): null;
    }
    
    public static BlockFace getFace(MemorySegment mem) {
        return getFace(mem, 0);
    }
    
    public static BlockFace getFace(MemorySegment mem, int offset) {
        return BlockFace.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static boolean getStaticFace(MemorySegment mem) {
        return getStaticFace(mem, 0);
    }
    
    public static boolean getStaticFace(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 2);
    }
    
    public static boolean hasBlock(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static BlockMatcher toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BlockMatcher toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BlockMatcher and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BlockMatcher toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 3;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        BlockIdMatcher v0 = null;
        if (hasBlock(mem, offset)) {
            v0 = BlockIdMatcher.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new BlockMatcher(
            v0,
            BlockFace.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            mem.get(PacketIO.PROTO_BOOL, offset + 2)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.block != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.face.getValue());
        mem.set(PacketIO.PROTO_BOOL, offset + 2, this.staticFace);
        var varOffset = offset + 3;
        if (this.block != null) {
            
            varOffset += this.block.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 3;
        if (block != null) size += block.computeSize();

        return size;
    }

    public BlockMatcher clone() {
        BlockMatcher copy = new BlockMatcher();
        copy.block = this.block != null ? this.block.clone() : null;
        copy.face = this.face;
        copy.staticFace = this.staticFace;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BlockMatcher other)) return false;
        return java.util.Objects.equals(this.block, other.block) && java.util.Objects.equals(this.face, other.face) && this.staticFace == other.staticFace;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(block, face, staticFace);
    }

}