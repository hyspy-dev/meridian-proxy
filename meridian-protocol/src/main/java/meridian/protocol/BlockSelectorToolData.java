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


public class BlockSelectorToolData {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 4;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 4;
    public static final int MAX_SIZE = 4;

    public float durabilityLossOnUse;

    public BlockSelectorToolData() {
    }

    public BlockSelectorToolData(float durabilityLossOnUse) {
        this.durabilityLossOnUse = durabilityLossOnUse;
    }

    public BlockSelectorToolData(@Nonnull BlockSelectorToolData other) {
        this.durabilityLossOnUse = other.durabilityLossOnUse;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BlockSelectorToolData", offset, (int) mem.byteSize());
        long needed = (long) offset + 4;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockSelectorToolData", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getDurabilityLossOnUse(MemorySegment mem) {
        return getDurabilityLossOnUse(mem, 0);
    }
    
    public static float getDurabilityLossOnUse(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "DurabilityLossOnUse");
    }
    
    
    
    
    
    public static BlockSelectorToolData toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BlockSelectorToolData toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BlockSelectorToolData and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BlockSelectorToolData toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BlockSelectorToolData(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "DurabilityLossOnUse")
        );
        if (cursor != null) cursor.position = offset + 4;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.durabilityLossOnUse, "DurabilityLossOnUse"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.durabilityLossOnUse);
        
        
    
       return 4;
    }
    public int computeSize() {
        return 4;
    }

    public BlockSelectorToolData clone() {
        BlockSelectorToolData copy = new BlockSelectorToolData();
        copy.durabilityLossOnUse = this.durabilityLossOnUse;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BlockSelectorToolData other)) return false;
        return this.durabilityLossOnUse == other.durabilityLossOnUse;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(durabilityLossOnUse);
    }

}