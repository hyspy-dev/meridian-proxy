// Auto-generated - do not edit
package meridian.protocol.packets.assets;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.NetworkChannel;
import meridian.protocol.Packet;
import meridian.protocol.ToServerPacket;
import meridian.protocol.ToClientPacket;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import meridian.protocol.ItemCategory;
import meridian.protocol.UpdateType;

public class UpdateItemCategories implements Packet, ToClientPacket {
    public static final int PACKET_ID = 56;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 2;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public UpdateType type = UpdateType.Init;
    @Nullable public ItemCategory[] itemCategories;

    public UpdateItemCategories() {
    }

    public UpdateItemCategories(@Nonnull UpdateType type, @Nullable ItemCategory[] itemCategories) {
        this.type = type;
        this.itemCategories = itemCategories;
    }

    public UpdateItemCategories(@Nonnull UpdateItemCategories other) {
        this.type = other.type;
        this.itemCategories = other.itemCategories;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateItemCategories", offset, (int) mem.byteSize());
        long needed = (long) offset + 2;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateItemCategories", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static UpdateType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static UpdateType getType(MemorySegment mem, int offset) {
        return UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static ItemCategory[] getItemCategories(MemorySegment mem) {
        return getItemCategories(mem, 0);
    }
    
    @Nullable
    public static ItemCategory[] getItemCategories(MemorySegment mem, int offset) {
        if (!hasItemCategories(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 2;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ItemCategories");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("ItemCategories", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 26 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemCategories", (int) java.lang.Math.min(off + lenOffset + (long) len * 26, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ItemCategory[len];
        for (var i = 0; i < len; i++) {
            data[i] = ItemCategory.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasItemCategories(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static UpdateItemCategories toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateItemCategories toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateItemCategories and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateItemCategories toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 2;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ItemCategory[] v1 = null;
        if (hasItemCategories(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ItemCategories");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("ItemCategories", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 26 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemCategories", (int) java.lang.Math.min(off + lenOffset + (long) len * 26, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new ItemCategory[len];
            for (var i = 0; i < len; i++) {
                v1[i] = ItemCategory.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new UpdateItemCategories(
            UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.itemCategories != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        var varOffset = offset + 2;
        if (this.itemCategories != null) {
            
            if (itemCategories.length > 4096000) throw ProtocolException.arrayTooLong("ItemCategories", itemCategories.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.itemCategories.length);
            
            var itemCategoriesValueOffset = 0;
            for (var i = 0; i < this.itemCategories.length; i++) {
                itemCategoriesValueOffset += this.itemCategories[i].serialize(mem, varOffset + itemCategoriesValueOffset);
            }
            varOffset += itemCategoriesValueOffset;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 2;
        if (itemCategories != null) {
        int itemCategoriesSize = 0;
for (var elem : itemCategories) itemCategoriesSize += elem.computeSize();
size += VarInt.size(itemCategories.length) + itemCategoriesSize;
    }

        return size;
    }

    public UpdateItemCategories clone() {
        UpdateItemCategories copy = new UpdateItemCategories();
        copy.type = this.type;
        copy.itemCategories = this.itemCategories != null ? java.util.Arrays.stream(this.itemCategories).map(e -> e.clone()).toArray(ItemCategory[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateItemCategories other)) return false;
        return java.util.Objects.equals(this.type, other.type) && java.util.Arrays.equals(this.itemCategories, other.itemCategories);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(type);
        result = 31 * result + java.util.Arrays.hashCode(itemCategories);
        return result;
    }

}