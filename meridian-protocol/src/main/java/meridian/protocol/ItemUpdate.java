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


public class ItemUpdate extends ComponentUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 4;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 4;
    public static final int MAX_SIZE = 32768048;

    @Nonnull public ItemWithAllMetadata item = new ItemWithAllMetadata();
    public float entityScale;

    public ItemUpdate() {
    }

    public ItemUpdate(@Nonnull ItemWithAllMetadata item, float entityScale) {
        this.item = item;
        this.entityScale = entityScale;
    }

    public ItemUpdate(@Nonnull ItemUpdate other) {
        this.item = other.item;
        this.entityScale = other.entityScale;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 4;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static ItemWithAllMetadata getItem(MemorySegment mem) {
        return getItem(mem, 0);
    }
    
    public static ItemWithAllMetadata getItem(MemorySegment mem, int offset) {
        return ItemWithAllMetadata.toObject(mem, offset + 4);
    }
    
    public static float getEntityScale(MemorySegment mem) {
        return getEntityScale(mem, 0);
    }
    
    public static float getEntityScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "EntityScale");
    }
    
    
    
    
    
    public static ItemUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 4;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ItemWithAllMetadata v0;
        {
            v0 = ItemWithAllMetadata.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new ItemUpdate(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "EntityScale")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.entityScale, "EntityScale"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.entityScale);
        var varOffset = offset + 4;
        varOffset += this.item.serialize(mem, varOffset);
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 4;
        size += item.computeSize();

        return size;
    }

    public ItemUpdate clone() {
        ItemUpdate copy = new ItemUpdate();
        copy.item = this.item.clone();
        copy.entityScale = this.entityScale;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemUpdate other)) return false;
        return java.util.Objects.equals(this.item, other.item) && this.entityScale == other.entityScale;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(item, entityScale);
    }

}