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


public class UpdateCategoryAction extends WindowAction {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 8;
    public static final int MAX_SIZE = 32768018;

    @Nonnull public String category = "";
    @Nonnull public String itemCategory = "";

    public UpdateCategoryAction() {
    }

    public UpdateCategoryAction(@Nonnull String category, @Nonnull String itemCategory) {
        this.category = category;
        this.itemCategory = itemCategory;
    }

    public UpdateCategoryAction(@Nonnull UpdateCategoryAction other) {
        this.category = other.category;
        this.itemCategory = other.itemCategory;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateCategoryAction", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateCategoryAction", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getCategory(MemorySegment mem) {
        return getCategory(mem, 0);
    }
    
    public static String getCategory(MemorySegment mem, int offset) {
        return PacketIO.readVarString("Category", mem, offset + getValidatedOffset(mem, offset, 0, 8, "Category"), 4096000);
    }
    
    public static String getItemCategory(MemorySegment mem) {
        return getItemCategory(mem, 0);
    }
    
    public static String getItemCategory(MemorySegment mem, int offset) {
        return PacketIO.readVarString("ItemCategory", mem, offset + getValidatedOffset(mem, offset, 4, 8, "ItemCategory"), 4096000);
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
    
    public static UpdateCategoryAction toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateCategoryAction toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateCategoryAction and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateCategoryAction toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 8;
        var varPos = 0;
        String v0;
        requireSlot(mem, offset + 0, varPos, "Category");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Category", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        String v1;
        requireSlot(mem, offset + 4, varPos, "ItemCategory");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("ItemCategory", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new UpdateCategoryAction(
            v0,
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 8;
        mem.set(PacketIO.PROTO_INT, offset + 0, varOffset - offset - 8);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.category, 4096000);
        mem.set(PacketIO.PROTO_INT, offset + 4, varOffset - offset - 8);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.itemCategory, 4096000);
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 8;
        size += PacketIO.stringSize(category);
    size += PacketIO.stringSize(itemCategory);

        return size;
    }

    public UpdateCategoryAction clone() {
        UpdateCategoryAction copy = new UpdateCategoryAction();
        copy.category = this.category;
        copy.itemCategory = this.itemCategory;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateCategoryAction other)) return false;
        return java.util.Objects.equals(this.category, other.category) && java.util.Objects.equals(this.itemCategory, other.itemCategory);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(category, itemCategory);
    }

}