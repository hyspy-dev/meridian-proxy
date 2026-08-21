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


public class ExtraResources {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public ItemQuantity[] resources;

    public ExtraResources() {
    }

    public ExtraResources(@Nullable ItemQuantity[] resources) {
        this.resources = resources;
    }

    public ExtraResources(@Nonnull ExtraResources other) {
        this.resources = other.resources;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ExtraResources", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ExtraResources", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static ItemQuantity[] getResources(MemorySegment mem) {
        return getResources(mem, 0);
    }
    
    @Nullable
    public static ItemQuantity[] getResources(MemorySegment mem, int offset) {
        if (!hasResources(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Resources");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Resources", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Resources", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ItemQuantity[len];
        for (var i = 0; i < len; i++) {
            data[i] = ItemQuantity.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasResources(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static ExtraResources toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ExtraResources toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ExtraResources and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ExtraResources toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ItemQuantity[] v0 = null;
        if (hasResources(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Resources");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Resources", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Resources", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new ItemQuantity[len];
            for (var i = 0; i < len; i++) {
                v0[i] = ItemQuantity.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new ExtraResources(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.resources != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.resources != null) {
            
            if (resources.length > 4096000) throw ProtocolException.arrayTooLong("Resources", resources.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.resources.length);
            
            var resourcesValueOffset = 0;
            for (var i = 0; i < this.resources.length; i++) {
                resourcesValueOffset += this.resources[i].serialize(mem, varOffset + resourcesValueOffset);
            }
            varOffset += resourcesValueOffset;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (resources != null) {
        int resourcesSize = 0;
for (var elem : resources) resourcesSize += elem.computeSize();
size += VarInt.size(resources.length) + resourcesSize;
    }

        return size;
    }

    public ExtraResources clone() {
        ExtraResources copy = new ExtraResources();
        copy.resources = this.resources != null ? java.util.Arrays.stream(this.resources).map(e -> e.clone()).toArray(ItemQuantity[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ExtraResources other)) return false;
        return java.util.Arrays.equals(this.resources, other.resources);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(resources);
        return result;
    }

}