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


public class ItemQuantity {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 4;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 4;
    public static final int MAX_SIZE = 16384009;

    @Nonnull public String itemId = "";
    public int quantity;

    public ItemQuantity() {
    }

    public ItemQuantity(@Nonnull String itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public ItemQuantity(@Nonnull ItemQuantity other) {
        this.itemId = other.itemId;
        this.quantity = other.quantity;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemQuantity", offset, (int) mem.byteSize());
        long needed = (long) offset + 4;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemQuantity", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getItemId(MemorySegment mem) {
        return getItemId(mem, 0);
    }
    
    public static String getItemId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("ItemId", mem, offset + 4, 4096000);
    }
    
    public static int getQuantity(MemorySegment mem) {
        return getQuantity(mem, 0);
    }
    
    public static int getQuantity(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    
    
    
    
    public static ItemQuantity toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemQuantity toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemQuantity and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemQuantity toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 4;
        var varPos = 0;
        String v0;
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("ItemId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new ItemQuantity(
            v0,
            mem.get(PacketIO.PROTO_INT, offset + 0)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.quantity);
        var varOffset = offset + 4;
        varOffset += PacketIO.writeVarString(mem, varOffset, this.itemId, 4096000);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 4;
        size += PacketIO.stringSize(itemId);

        return size;
    }

    public ItemQuantity clone() {
        ItemQuantity copy = new ItemQuantity();
        copy.itemId = this.itemId;
        copy.quantity = this.quantity;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemQuantity other)) return false;
        return java.util.Objects.equals(this.itemId, other.itemId) && this.quantity == other.quantity;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(itemId, quantity);
    }

}