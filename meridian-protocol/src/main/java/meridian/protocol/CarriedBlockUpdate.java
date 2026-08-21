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


public class CarriedBlockUpdate extends ComponentUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 16384006;

    @Nullable public String itemId;

    public CarriedBlockUpdate() {
    }

    public CarriedBlockUpdate(@Nullable String itemId) {
        this.itemId = itemId;
    }

    public CarriedBlockUpdate(@Nonnull CarriedBlockUpdate other) {
        this.itemId = other.itemId;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CarriedBlockUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CarriedBlockUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getItemId(MemorySegment mem) {
        return getItemId(mem, 0);
    }
    
    @Nullable
    public static String getItemId(MemorySegment mem, int offset) {
        return hasItemId(mem, offset) ? PacketIO.readVarString("ItemId", mem, offset + 1, 4096000): null;
    }
    
    public static boolean hasItemId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static CarriedBlockUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CarriedBlockUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CarriedBlockUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CarriedBlockUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        String v0 = null;
        if (hasItemId(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("ItemId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new CarriedBlockUpdate(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.itemId != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.itemId != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.itemId, 4096000);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 1;
        if (itemId != null) size += PacketIO.stringSize(itemId);

        return size;
    }

    public CarriedBlockUpdate clone() {
        CarriedBlockUpdate copy = new CarriedBlockUpdate();
        copy.itemId = this.itemId;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CarriedBlockUpdate other)) return false;
        return java.util.Objects.equals(this.itemId, other.itemId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(itemId);
    }

}