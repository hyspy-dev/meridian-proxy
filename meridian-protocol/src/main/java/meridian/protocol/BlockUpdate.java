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


public class BlockUpdate extends ComponentUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 8;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 8;
    public static final int MAX_SIZE = 8;

    public int blockId;
    public float entityScale;

    public BlockUpdate() {
    }

    public BlockUpdate(int blockId, float entityScale) {
        this.blockId = blockId;
        this.entityScale = entityScale;
    }

    public BlockUpdate(@Nonnull BlockUpdate other) {
        this.blockId = other.blockId;
        this.entityScale = other.entityScale;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BlockUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getBlockId(MemorySegment mem) {
        return getBlockId(mem, 0);
    }
    
    public static int getBlockId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static float getEntityScale(MemorySegment mem) {
        return getEntityScale(mem, 0);
    }
    
    public static float getEntityScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "EntityScale");
    }
    
    
    
    
    
    public static BlockUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BlockUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BlockUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BlockUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BlockUpdate(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "EntityScale")
        );
        if (cursor != null) cursor.position = offset + 8;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.blockId);
        PacketIO.requireFinite(this.entityScale, "EntityScale"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.entityScale);
        
        
    
       return 8;
    }
    @Override
    public int computeSize() {
        return 8;
    }

    public BlockUpdate clone() {
        BlockUpdate copy = new BlockUpdate();
        copy.blockId = this.blockId;
        copy.entityScale = this.entityScale;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BlockUpdate other)) return false;
        return this.blockId == other.blockId && this.entityScale == other.entityScale;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(blockId, entityScale);
    }

}