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


public class MaterialQuantity {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 17;
    public static final int MAX_SIZE = 32768027;

    @Nullable public String itemId;
    public int itemTag;
    @Nullable public String resourceTypeId;
    public int quantity;

    public MaterialQuantity() {
    }

    public MaterialQuantity(@Nullable String itemId, int itemTag, @Nullable String resourceTypeId, int quantity) {
        this.itemId = itemId;
        this.itemTag = itemTag;
        this.resourceTypeId = resourceTypeId;
        this.quantity = quantity;
    }

    public MaterialQuantity(@Nonnull MaterialQuantity other) {
        this.itemId = other.itemId;
        this.itemTag = other.itemTag;
        this.resourceTypeId = other.resourceTypeId;
        this.quantity = other.quantity;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("MaterialQuantity", offset, (int) mem.byteSize());
        long needed = (long) offset + 17;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("MaterialQuantity", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getItemId(MemorySegment mem) {
        return getItemId(mem, 0);
    }
    
    @Nullable
    public static String getItemId(MemorySegment mem, int offset) {
        return hasItemId(mem, offset) ? PacketIO.readVarString("ItemId", mem, offset + getValidatedOffset(mem, offset, 9, 17, "ItemId"), 4096000): null;
    }
    
    public static int getItemTag(MemorySegment mem) {
        return getItemTag(mem, 0);
    }
    
    public static int getItemTag(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static String getResourceTypeId(MemorySegment mem) {
        return getResourceTypeId(mem, 0);
    }
    
    @Nullable
    public static String getResourceTypeId(MemorySegment mem, int offset) {
        return hasResourceTypeId(mem, offset) ? PacketIO.readVarString("ResourceTypeId", mem, offset + getValidatedOffset(mem, offset, 13, 17, "ResourceTypeId"), 4096000): null;
    }
    
    public static int getQuantity(MemorySegment mem) {
        return getQuantity(mem, 0);
    }
    
    public static int getQuantity(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static boolean hasItemId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasResourceTypeId(MemorySegment mem, int offset) {
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
    
    public static MaterialQuantity toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static MaterialQuantity toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one MaterialQuantity and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static MaterialQuantity toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 17;
        var varPos = 0;
        String v0 = null;
        if (hasItemId(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "ItemId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("ItemId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 9, -1, "ItemId");
        }
        
        String v2 = null;
        if (hasResourceTypeId(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "ResourceTypeId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("ResourceTypeId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 13, -1, "ResourceTypeId");
        }
        var result = new MaterialQuantity(
            v0,
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v2,
            mem.get(PacketIO.PROTO_INT, offset + 5)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.itemId != null) nullBits |= 0x01;
        if (this.resourceTypeId != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.itemTag);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.quantity);
        var varOffset = offset + 17;
        if (this.itemId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 17);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.itemId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
        if (this.resourceTypeId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 17);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.resourceTypeId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 17;
        if (itemId != null) size += PacketIO.stringSize(itemId);
    if (resourceTypeId != null) size += PacketIO.stringSize(resourceTypeId);

        return size;
    }

    public MaterialQuantity clone() {
        MaterialQuantity copy = new MaterialQuantity();
        copy.itemId = this.itemId;
        copy.itemTag = this.itemTag;
        copy.resourceTypeId = this.resourceTypeId;
        copy.quantity = this.quantity;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MaterialQuantity other)) return false;
        return java.util.Objects.equals(this.itemId, other.itemId) && this.itemTag == other.itemTag && java.util.Objects.equals(this.resourceTypeId, other.resourceTypeId) && this.quantity == other.quantity;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(itemId, itemTag, resourceTypeId, quantity);
    }

}