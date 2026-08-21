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
import meridian.protocol.ItemBase;
import meridian.protocol.UpdateType;
import java.util.HashMap;

public class UpdateItems implements Packet, ToClientPacket {
    public static final int PACKET_ID = 54;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 3;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 11;
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
    @Nullable public java.util.Map<String, ItemBase> items;
    @Nullable public String[] removedItems;
    public boolean updateModels;
    public boolean updateIcons;

    public UpdateItems() {
    }

    public UpdateItems(@Nonnull UpdateType type, @Nullable java.util.Map<String, ItemBase> items, @Nullable String[] removedItems, boolean updateModels, boolean updateIcons) {
        this.type = type;
        this.items = items;
        this.removedItems = removedItems;
        this.updateModels = updateModels;
        this.updateIcons = updateIcons;
    }

    public UpdateItems(@Nonnull UpdateItems other) {
        this.type = other.type;
        this.items = other.items;
        this.removedItems = other.removedItems;
        this.updateModels = other.updateModels;
        this.updateIcons = other.updateIcons;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateItems", offset, (int) mem.byteSize());
        long needed = (long) offset + 11;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateItems", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static UpdateType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static UpdateType getType(MemorySegment mem, int offset) {
        return UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static java.util.Map<String, ItemBase> getItems(MemorySegment mem) {
        return getItems(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, ItemBase> getItems(MemorySegment mem, int offset) {
        if (!hasItems(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 3, 11, "Items");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Items");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Items", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 267 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Items", (int) java.lang.Math.min(off + (long) len * 267, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, ItemBase> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = ItemBase.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Items", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static String[] getRemovedItems(MemorySegment mem) {
        return getRemovedItems(mem, 0);
    }
    
    @Nullable
    public static String[] getRemovedItems(MemorySegment mem, int offset) {
        if (!hasRemovedItems(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 7, 11, "RemovedItems");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("RemovedItems");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("RemovedItems", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("RemovedItems", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("RemovedItems", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    public static boolean getUpdateModels(MemorySegment mem) {
        return getUpdateModels(mem, 0);
    }
    
    public static boolean getUpdateModels(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 2) & 0x01) != 0;
    }
    
    public static boolean getUpdateIcons(MemorySegment mem) {
        return getUpdateIcons(mem, 0);
    }
    
    public static boolean getUpdateIcons(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 2) & 0x02) != 0;
    }
    
    public static boolean hasItems(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasRemovedItems(MemorySegment mem, int offset) {
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
    
    public static UpdateItems toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateItems toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateItems and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateItems toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 11;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        java.util.Map<String, ItemBase> v1 = null;
        if (hasItems(mem, offset)) {
            requireSlot(mem, offset + 3, varPos, "Items");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Items");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Items", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 267 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Items", (int) java.lang.Math.min(off + (long) len * 267, Integer.MAX_VALUE), (int) mem.byteSize());
            v1 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = ItemBase.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v1.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Items", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 3, -1, "Items");
        }
        
        String[] v2 = null;
        if (hasRemovedItems(mem, offset)) {
            requireSlot(mem, offset + 7, varPos, "RemovedItems");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("RemovedItems");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("RemovedItems", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("RemovedItems", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v2[i] = PacketIO.readVarString("RemovedItems", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 7, -1, "RemovedItems");
        }
        var result = new UpdateItems(
            UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v1,
            v2,
            (mem.get(PacketIO.PROTO_BYTE, offset + 2) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 2) & 0x02) != 0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.items != null) nullBits |= 0x01;
        if (this.removedItems != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        byte boolBits0_0 = 0;
        if (this.updateModels) boolBits0_0 |= 0x01;
        if (this.updateIcons) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 2 + 0, boolBits0_0);
        var varOffset = offset + 11;
        if (this.items != null) {
            mem.set(PacketIO.PROTO_INT, offset + 3, varOffset - offset - 11);
            if (this.items.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Items", items.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.items.size());
            for (var e : this.items.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 3, -1);
        }
        if (this.removedItems != null) {
            mem.set(PacketIO.PROTO_INT, offset + 7, varOffset - offset - 11);
            if (removedItems.length > 4096000) throw ProtocolException.arrayTooLong("RemovedItems", removedItems.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.removedItems.length);
            
            var removedItemsValueOffset = 0;
            for (var i = 0; i < this.removedItems.length; i++) {
                removedItemsValueOffset += PacketIO.writeVarString(mem, varOffset + removedItemsValueOffset, this.removedItems[i], 4096000);
            }
            varOffset += removedItemsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 7, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 11;
        if (items != null) {
        int itemsSize = 0;
for (var kvp : items.entrySet()) itemsSize += PacketIO.stringSize(kvp.getKey()) + kvp.getValue().computeSize();
size += VarInt.size(items.size()) + itemsSize;
    }
    if (removedItems != null) {
        int removedItemsSize = 0;
for (var elem : removedItems) removedItemsSize += PacketIO.stringSize(elem);
size += VarInt.size(removedItems.length) + removedItemsSize;
    }

        return size;
    }

    public UpdateItems clone() {
        UpdateItems copy = new UpdateItems();
        copy.type = this.type;
        if (this.items != null) {
            java.util.Map<String, ItemBase> m = new java.util.HashMap<>();
            for (var e : this.items.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.items = m;
        }
        copy.removedItems = this.removedItems != null ? java.util.Arrays.copyOf(this.removedItems, this.removedItems.length) : null;
        copy.updateModels = this.updateModels;
        copy.updateIcons = this.updateIcons;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateItems other)) return false;
        return java.util.Objects.equals(this.type, other.type) && java.util.Objects.equals(this.items, other.items) && java.util.Arrays.equals(this.removedItems, other.removedItems) && this.updateModels == other.updateModels && this.updateIcons == other.updateIcons;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(type);
        result = 31 * result + java.util.Objects.hashCode(items);
        result = 31 * result + java.util.Arrays.hashCode(removedItems);
        result = 31 * result + Boolean.hashCode(updateModels);
        result = 31 * result + Boolean.hashCode(updateIcons);
        return result;
    }

}