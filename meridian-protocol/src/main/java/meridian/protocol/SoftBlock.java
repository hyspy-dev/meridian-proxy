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


public class SoftBlock {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 10;
    public static final int MAX_SIZE = 32768020;

    @Nullable public String itemId;
    @Nullable public String dropListId;
    public boolean isWeaponBreakable;

    public SoftBlock() {
    }

    public SoftBlock(@Nullable String itemId, @Nullable String dropListId, boolean isWeaponBreakable) {
        this.itemId = itemId;
        this.dropListId = dropListId;
        this.isWeaponBreakable = isWeaponBreakable;
    }

    public SoftBlock(@Nonnull SoftBlock other) {
        this.itemId = other.itemId;
        this.dropListId = other.dropListId;
        this.isWeaponBreakable = other.isWeaponBreakable;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SoftBlock", offset, (int) mem.byteSize());
        long needed = (long) offset + 10;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SoftBlock", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getItemId(MemorySegment mem) {
        return getItemId(mem, 0);
    }
    
    @Nullable
    public static String getItemId(MemorySegment mem, int offset) {
        return hasItemId(mem, offset) ? PacketIO.readVarString("ItemId", mem, offset + getValidatedOffset(mem, offset, 2, 10, "ItemId"), 4096000): null;
    }
    
    @Nullable
    public static String getDropListId(MemorySegment mem) {
        return getDropListId(mem, 0);
    }
    
    @Nullable
    public static String getDropListId(MemorySegment mem, int offset) {
        return hasDropListId(mem, offset) ? PacketIO.readVarString("DropListId", mem, offset + getValidatedOffset(mem, offset, 6, 10, "DropListId"), 4096000): null;
    }
    
    public static boolean getIsWeaponBreakable(MemorySegment mem) {
        return getIsWeaponBreakable(mem, 0);
    }
    
    public static boolean getIsWeaponBreakable(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 1);
    }
    
    public static boolean hasItemId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasDropListId(MemorySegment mem, int offset) {
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
    
    public static SoftBlock toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SoftBlock toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SoftBlock and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SoftBlock toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 10;
        var varPos = 0;
        String v0 = null;
        if (hasItemId(mem, offset)) {
            requireSlot(mem, offset + 2, varPos, "ItemId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("ItemId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 2, -1, "ItemId");
        }
        
        String v1 = null;
        if (hasDropListId(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "DropListId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("DropListId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 6, -1, "DropListId");
        }
        var result = new SoftBlock(
            v0,
            v1,
            mem.get(PacketIO.PROTO_BOOL, offset + 1)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.itemId != null) nullBits |= 0x01;
        if (this.dropListId != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BOOL, offset + 1, this.isWeaponBreakable);
        var varOffset = offset + 10;
        if (this.itemId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 2, varOffset - offset - 10);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.itemId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 2, -1);
        }
        if (this.dropListId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 10);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.dropListId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 10;
        if (itemId != null) size += PacketIO.stringSize(itemId);
    if (dropListId != null) size += PacketIO.stringSize(dropListId);

        return size;
    }

    public SoftBlock clone() {
        SoftBlock copy = new SoftBlock();
        copy.itemId = this.itemId;
        copy.dropListId = this.dropListId;
        copy.isWeaponBreakable = this.isWeaponBreakable;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SoftBlock other)) return false;
        return java.util.Objects.equals(this.itemId, other.itemId) && java.util.Objects.equals(this.dropListId, other.dropListId) && this.isWeaponBreakable == other.isWeaponBreakable;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(itemId, dropListId, isWeaponBreakable);
    }

}