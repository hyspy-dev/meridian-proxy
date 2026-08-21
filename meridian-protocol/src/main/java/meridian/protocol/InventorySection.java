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
import java.util.HashMap;

public class InventorySection {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 3;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 3;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public java.util.Map<Integer, ItemWithAllMetadata> items;
    public short capacity;

    public InventorySection() {
    }

    public InventorySection(@Nullable java.util.Map<Integer, ItemWithAllMetadata> items, short capacity) {
        this.items = items;
        this.capacity = capacity;
    }

    public InventorySection(@Nonnull InventorySection other) {
        this.items = other.items;
        this.capacity = other.capacity;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("InventorySection", offset, (int) mem.byteSize());
        long needed = (long) offset + 3;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InventorySection", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static java.util.Map<Integer, ItemWithAllMetadata> getItems(MemorySegment mem) {
        return getItems(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Integer, ItemWithAllMetadata> getItems(MemorySegment mem, int offset) {
        if (!hasItems(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 3;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Items");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Items", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 38 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Items", (int) java.lang.Math.min(off + (long) len * 38, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Integer, ItemWithAllMetadata> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            var value = ItemWithAllMetadata.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Items", key);
            }
        }
        return data;
    }
    
    public static short getCapacity(MemorySegment mem) {
        return getCapacity(mem, 0);
    }
    
    public static short getCapacity(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_SHORT, offset + 1);
    }
    
    public static boolean hasItems(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static InventorySection toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static InventorySection toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one InventorySection and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static InventorySection toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 3;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        java.util.Map<Integer, ItemWithAllMetadata> v0 = null;
        if (hasItems(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Items");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Items", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 38 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Items", (int) java.lang.Math.min(off + (long) len * 38, Integer.MAX_VALUE), (int) mem.byteSize());
            v0 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                var value = ItemWithAllMetadata.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v0.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Items", key);
                }
            }
            varPos = off - varBase;
        }
        var result = new InventorySection(
            v0,
            mem.get(PacketIO.PROTO_SHORT, offset + 1)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.items != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_SHORT, offset + 1, this.capacity);
        var varOffset = offset + 3;
        if (this.items != null) {
            
            if (this.items.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Items", items.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.items.size());
            for (var e : this.items.entrySet()) {
                mem.set(PacketIO.PROTO_INT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 3;
        if (items != null) {
        int itemsSize = 0;
for (var kvp : items.entrySet()) itemsSize += 4 + kvp.getValue().computeSize();
size += VarInt.size(items.size()) + itemsSize;
    }

        return size;
    }

    public InventorySection clone() {
        InventorySection copy = new InventorySection();
        if (this.items != null) {
            java.util.Map<Integer, ItemWithAllMetadata> m = new java.util.HashMap<>();
            for (var e : this.items.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.items = m;
        }
        copy.capacity = this.capacity;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InventorySection other)) return false;
        return java.util.Objects.equals(this.items, other.items) && this.capacity == other.capacity;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(items, capacity);
    }

}