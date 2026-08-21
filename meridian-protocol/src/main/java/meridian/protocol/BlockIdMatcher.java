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


public class BlockIdMatcher {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 32768023;

    @Nullable public String id;
    @Nullable public String state;
    public int tagIndex;

    public BlockIdMatcher() {
    }

    public BlockIdMatcher(@Nullable String id, @Nullable String state, int tagIndex) {
        this.id = id;
        this.state = state;
        this.tagIndex = tagIndex;
    }

    public BlockIdMatcher(@Nonnull BlockIdMatcher other) {
        this.id = other.id;
        this.state = other.state;
        this.tagIndex = other.tagIndex;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BlockIdMatcher", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockIdMatcher", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 5, 13, "Id"), 4096000): null;
    }
    
    @Nullable
    public static String getState(MemorySegment mem) {
        return getState(mem, 0);
    }
    
    @Nullable
    public static String getState(MemorySegment mem, int offset) {
        return hasState(mem, offset) ? PacketIO.readVarString("State", mem, offset + getValidatedOffset(mem, offset, 9, 13, "State"), 4096000): null;
    }
    
    public static int getTagIndex(MemorySegment mem) {
        return getTagIndex(mem, 0);
    }
    
    public static int getTagIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasState(MemorySegment mem, int offset) {
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
    
    public static BlockIdMatcher toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BlockIdMatcher toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BlockIdMatcher and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BlockIdMatcher toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 13;
        var varPos = 0;
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 5, -1, "Id");
        }
        
        String v1 = null;
        if (hasState(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "State");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("State", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 9, -1, "State");
        }
        var result = new BlockIdMatcher(
            v0,
            v1,
            mem.get(PacketIO.PROTO_INT, offset + 1)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        if (this.state != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.tagIndex);
        var varOffset = offset + 13;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 13);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.state != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 13);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.state, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 13;
        if (id != null) size += PacketIO.stringSize(id);
    if (state != null) size += PacketIO.stringSize(state);

        return size;
    }

    public BlockIdMatcher clone() {
        BlockIdMatcher copy = new BlockIdMatcher();
        copy.id = this.id;
        copy.state = this.state;
        copy.tagIndex = this.tagIndex;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BlockIdMatcher other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.state, other.state) && this.tagIndex == other.tagIndex;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, state, tagIndex);
    }

}