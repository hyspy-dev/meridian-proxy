// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class UIListDataValue extends UIDataValue {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 8;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public String itemTypeName = "";
    @Nonnull public UIDataValue[] items = new UIDataValue[0];

    public UIListDataValue() {
    }

    public UIListDataValue(@Nonnull String itemTypeName, @Nonnull UIDataValue[] items) {
        this.itemTypeName = itemTypeName;
        this.items = items;
    }

    public UIListDataValue(@Nonnull UIListDataValue other) {
        this.itemTypeName = other.itemTypeName;
        this.items = other.items;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UIListDataValue", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UIListDataValue", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getItemTypeName(MemorySegment mem) {
        return getItemTypeName(mem, 0);
    }
    
    public static String getItemTypeName(MemorySegment mem, int offset) {
        return PacketIO.readVarString("ItemTypeName", mem, offset + getValidatedOffset(mem, offset, 0, 8, "ItemTypeName"), 4096000);
    }
    
    public static UIDataValue[] getItems(MemorySegment mem) {
        return getItems(mem, 0);
    }
    
    public static UIDataValue[] getItems(MemorySegment mem, int offset) {
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 4, 8, "Items");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Items");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Items", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Items", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new UIDataValue[len];
        for (var i = 0; i < len; i++) {
            data[i] = UIDataValue.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
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
    
    public static UIListDataValue toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UIListDataValue toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UIListDataValue and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UIListDataValue toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 8;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0;
        requireSlot(mem, offset + 0, varPos, "ItemTypeName");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("ItemTypeName", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        UIDataValue[] v1;
        requireSlot(mem, offset + 4, varPos, "Items");
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Items");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Items", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Items", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new UIDataValue[len];
            for (var i = 0; i < len; i++) {
                v1[i] = UIDataValue.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new UIListDataValue(
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
        varOffset += PacketIO.writeVarString(mem, varOffset, this.itemTypeName, 4096000);
        mem.set(PacketIO.PROTO_INT, offset + 4, varOffset - offset - 8);
        if (items.length > 4096000) throw ProtocolException.arrayTooLong("Items", items.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.items.length);
        
        var itemsValueOffset = 0;
        for (var i = 0; i < this.items.length; i++) {
            itemsValueOffset += this.items[i].serializeWithTypeId(mem, varOffset + itemsValueOffset);
        }
        varOffset += itemsValueOffset;
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 8;
        size += PacketIO.stringSize(itemTypeName);
    int itemsSize = 0;
for (var elem : items) itemsSize += elem.computeSizeWithTypeId();
size += VarInt.size(items.length) + itemsSize;

        return size;
    }

    public UIListDataValue clone() {
        UIListDataValue copy = new UIListDataValue();
        copy.itemTypeName = this.itemTypeName;
        copy.items = java.util.Arrays.copyOf(this.items, this.items.length);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UIListDataValue other)) return false;
        return java.util.Objects.equals(this.itemTypeName, other.itemTypeName) && java.util.Arrays.equals(this.items, other.items);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(itemTypeName);
        result = 31 * result + java.util.Arrays.hashCode(items);
        return result;
    }

}