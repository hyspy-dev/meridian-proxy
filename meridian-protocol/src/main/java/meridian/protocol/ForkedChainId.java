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


public class ForkedChainId {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 1033;

    public int entryIndex;
    public int subIndex;
    @Nullable public ForkedChainId forkedId;

    public ForkedChainId() {
    }

    public ForkedChainId(int entryIndex, int subIndex, @Nullable ForkedChainId forkedId) {
        this.entryIndex = entryIndex;
        this.subIndex = subIndex;
        this.forkedId = forkedId;
    }

    public ForkedChainId(@Nonnull ForkedChainId other) {
        this.entryIndex = other.entryIndex;
        this.subIndex = other.subIndex;
        this.forkedId = other.forkedId;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ForkedChainId", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ForkedChainId", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getEntryIndex(MemorySegment mem) {
        return getEntryIndex(mem, 0);
    }
    
    public static int getEntryIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getSubIndex(MemorySegment mem) {
        return getSubIndex(mem, 0);
    }
    
    public static int getSubIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    @Nullable
    public static ForkedChainId getForkedId(MemorySegment mem) {
        return getForkedId(mem, 0);
    }
    
    @Nullable
    public static ForkedChainId getForkedId(MemorySegment mem, int offset) {
        return hasForkedId(mem, offset) ? ForkedChainId.toObject(mem, offset + 9): null;
    }
    
    public static boolean hasForkedId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static ForkedChainId toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ForkedChainId toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ForkedChainId and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ForkedChainId toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ForkedChainId v2 = null;
        if (hasForkedId(mem, offset)) {
            v2 = ForkedChainId.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new ForkedChainId(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.forkedId != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.entryIndex);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.subIndex);
        var varOffset = offset + 9;
        if (this.forkedId != null) {
            
            varOffset += this.forkedId.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (forkedId != null) size += forkedId.computeSize();

        return size;
    }

    public ForkedChainId clone() {
        ForkedChainId copy = new ForkedChainId();
        copy.entryIndex = this.entryIndex;
        copy.subIndex = this.subIndex;
        copy.forkedId = this.forkedId != null ? this.forkedId.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ForkedChainId other)) return false;
        return this.entryIndex == other.entryIndex && this.subIndex == other.subIndex && java.util.Objects.equals(this.forkedId, other.forkedId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(entryIndex, subIndex, forkedId);
    }

}