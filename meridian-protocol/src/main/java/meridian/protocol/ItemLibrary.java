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


public class ItemLibrary {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public ItemBase[] items;
    @Nullable public java.util.Map<Integer, String>[] blockMap;

    public ItemLibrary() {
    }

    public ItemLibrary(@Nullable ItemBase[] items, @Nullable java.util.Map<Integer, String>[] blockMap) {
        this.items = items;
        this.blockMap = blockMap;
    }

    public ItemLibrary(@Nonnull ItemLibrary other) {
        this.items = other.items;
        this.blockMap = other.blockMap;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemLibrary", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemLibrary", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static ItemBase[] getItems(MemorySegment mem) {
        return getItems(mem, 0);
    }
    
    @Nullable
    public static ItemBase[] getItems(MemorySegment mem, int offset) {
        if (!hasItems(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 1, 9, "Items");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Items");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Items", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 266 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Items", (int) java.lang.Math.min(off + lenOffset + (long) len * 266, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ItemBase[len];
        for (var i = 0; i < len; i++) {
            data[i] = ItemBase.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<Integer, String>[] getBlockMap(MemorySegment mem) {
        return getBlockMap(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Integer, String>[] getBlockMap(MemorySegment mem, int offset) {
        if (!hasBlockMap(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 5, 9, "BlockMap");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("BlockMap");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("BlockMap", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockMap", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = (java.util.Map<Integer, String>[]) new java.util.Map[len];
        for (var i = 0; i < len; i++) {
            var mapPacked = VarInt.getWithLength(mem, off);
            if (mapPacked == -1L) throw ProtocolException.invalidVarInt("BlockMap");
            var mapLen = (int) mapPacked;
            if (mapLen > 4096000) throw ProtocolException.dictionaryTooLarge("BlockMap", mapLen, 4096000);
            off += (int) (mapPacked >>> 32);
            if (off + (long) mapLen * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockMap", (int) java.lang.Math.min(off + (long) mapLen * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            var map = new java.util.HashMap<Integer, String>(mapLen);
            for (var j = 0; j < mapLen; j++) {
                var key = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
                var valuePacked = VarInt.getWithLength(mem, off);
                var value = PacketIO.readVarString("value", mem, off, 0, 4096000, valuePacked);
                off += (int) valuePacked + (int) (valuePacked >>> 32);
                if (map.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("BlockMap", key);
                }
            }
            data[i] = map;
        }
        return data;
    }
    
    public static boolean hasItems(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasBlockMap(MemorySegment mem, int offset) {
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
    
    public static ItemLibrary toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemLibrary toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemLibrary and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemLibrary toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ItemBase[] v0 = null;
        if (hasItems(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "Items");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Items");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Items", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 266 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Items", (int) java.lang.Math.min(off + lenOffset + (long) len * 266, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new ItemBase[len];
            for (var i = 0; i < len; i++) {
                v0[i] = ItemBase.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 1, -1, "Items");
        }
        
        java.util.Map<Integer, String>[] v1 = null;
        if (hasBlockMap(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "BlockMap");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("BlockMap");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("BlockMap", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockMap", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = (java.util.Map<Integer, String>[]) new java.util.Map[len];
            for (var i = 0; i < len; i++) {
                var mapPacked = VarInt.getWithLength(mem, off);
                if (mapPacked == -1L) throw ProtocolException.invalidVarInt("BlockMap");
                var mapLen = (int) mapPacked;
                if (mapLen > 4096000) throw ProtocolException.dictionaryTooLarge("BlockMap", mapLen, 4096000);
                off += (int) (mapPacked >>> 32);
                if (off + (long) mapLen * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockMap", (int) java.lang.Math.min(off + (long) mapLen * 5, Integer.MAX_VALUE), (int) mem.byteSize());
                var map = new java.util.HashMap<Integer, String>(mapLen);
                for (var j = 0; j < mapLen; j++) {
                    var key = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                    var valuePacked = VarInt.getWithLength(mem, off);
                    var value = PacketIO.readVarString("value", mem, off, 0, 4096000, valuePacked);
                    off += (int) valuePacked + (int) (valuePacked >>> 32);
                    if (map.put(key, value) != null) {
                        throw ProtocolException.duplicateKey("BlockMap", key);
                    }
                }
                v1[i] = map;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "BlockMap");
        }
        var result = new ItemLibrary(
            v0,
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.items != null) nullBits |= 0x01;
        if (this.blockMap != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 9;
        if (this.items != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 9);
            if (items.length > 4096000) throw ProtocolException.arrayTooLong("Items", items.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.items.length);
            
            var itemsValueOffset = 0;
            for (var i = 0; i < this.items.length; i++) {
                itemsValueOffset += this.items[i].serialize(mem, varOffset + itemsValueOffset);
            }
            varOffset += itemsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.blockMap != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 9);
            if (blockMap.length > 4096000) throw ProtocolException.arrayTooLong("BlockMap", blockMap.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.blockMap.length);
            
            for (var i = 0; i < this.blockMap.length; i++) {
                varOffset += VarInt.set(mem, varOffset, this.blockMap[i].size());
                for (var e : this.blockMap[i].entrySet()) {
                    mem.set(PacketIO.PROTO_INT, varOffset, e.getKey());
                varOffset += 4;
                    varOffset += PacketIO.writeVarString(mem, varOffset, e.getValue(), 4096000);
                }
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (items != null) {
        int itemsSize = 0;
for (var elem : items) itemsSize += elem.computeSize();
size += VarInt.size(items.length) + itemsSize;
    }
    if (blockMap != null) {
        int blockMapSize = 0;
for (var elem : blockMap) blockMapSize += VarInt.size(elem.size()) + elem.entrySet().stream().mapToInt(kvpInner -> 4 + PacketIO.stringSize(kvpInner.getValue())).sum();
size += VarInt.size(blockMap.length) + blockMapSize;
    }

        return size;
    }

    public ItemLibrary clone() {
        ItemLibrary copy = new ItemLibrary();
        copy.items = this.items != null ? java.util.Arrays.stream(this.items).map(e -> e.clone()).toArray(ItemBase[]::new) : null;
        copy.blockMap = this.blockMap != null ? java.util.Arrays.stream(this.blockMap).map(d -> new java.util.HashMap<Integer, String>(d)).toArray(java.util.Map[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemLibrary other)) return false;
        return java.util.Arrays.equals(this.items, other.items) && java.util.Arrays.equals(this.blockMap, other.blockMap);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(items);
        result = 31 * result + java.util.Arrays.hashCode(blockMap);
        return result;
    }

}