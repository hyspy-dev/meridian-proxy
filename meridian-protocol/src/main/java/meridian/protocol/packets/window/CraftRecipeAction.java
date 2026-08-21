// Auto-generated - do not edit
package meridian.protocol.packets.window;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class CraftRecipeAction extends WindowAction {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 5;
    public static final int MAX_SIZE = 16384010;

    @Nullable public String recipeId;
    public int quantity;

    public CraftRecipeAction() {
    }

    public CraftRecipeAction(@Nullable String recipeId, int quantity) {
        this.recipeId = recipeId;
        this.quantity = quantity;
    }

    public CraftRecipeAction(@Nonnull CraftRecipeAction other) {
        this.recipeId = other.recipeId;
        this.quantity = other.quantity;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CraftRecipeAction", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CraftRecipeAction", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getRecipeId(MemorySegment mem) {
        return getRecipeId(mem, 0);
    }
    
    @Nullable
    public static String getRecipeId(MemorySegment mem, int offset) {
        return hasRecipeId(mem, offset) ? PacketIO.readVarString("RecipeId", mem, offset + 5, 4096000): null;
    }
    
    public static int getQuantity(MemorySegment mem) {
        return getQuantity(mem, 0);
    }
    
    public static int getQuantity(MemorySegment mem, int offset) {
        var value = mem.get(PacketIO.PROTO_INT, offset + 1);
        if (value < 1) throw ProtocolException.valueBelowMinimum("Quantity", value, 1);
        return value;
    }
    
    public static boolean hasRecipeId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static CraftRecipeAction toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CraftRecipeAction toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CraftRecipeAction and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CraftRecipeAction toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 5;
        var varPos = 0;
        String v0 = null;
        if (hasRecipeId(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("RecipeId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        int v1 = mem.get(PacketIO.PROTO_INT, offset + 1);
        if (v1 < 1) throw ProtocolException.valueBelowMinimum("Quantity", v1, 1);
        var result = new CraftRecipeAction(
            v0,
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.recipeId != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.quantity < 1) throw ProtocolException.valueBelowMinimum("Quantity", this.quantity, 1); mem.set(PacketIO.PROTO_INT, offset + 1, this.quantity);
        var varOffset = offset + 5;
        if (this.recipeId != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.recipeId, 4096000);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 5;
        if (recipeId != null) size += PacketIO.stringSize(recipeId);

        return size;
    }

    public CraftRecipeAction clone() {
        CraftRecipeAction copy = new CraftRecipeAction();
        copy.recipeId = this.recipeId;
        copy.quantity = this.quantity;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CraftRecipeAction other)) return false;
        return java.util.Objects.equals(this.recipeId, other.recipeId) && this.quantity == other.quantity;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(recipeId, quantity);
    }

}