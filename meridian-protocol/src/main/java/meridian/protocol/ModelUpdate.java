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


public class ModelUpdate extends ComponentUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 5;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public Model model;
    public float entityScale;

    public ModelUpdate() {
    }

    public ModelUpdate(@Nullable Model model, float entityScale) {
        this.model = model;
        this.entityScale = entityScale;
    }

    public ModelUpdate(@Nonnull ModelUpdate other) {
        this.model = other.model;
        this.entityScale = other.entityScale;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ModelUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ModelUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static Model getModel(MemorySegment mem) {
        return getModel(mem, 0);
    }
    
    @Nullable
    public static Model getModel(MemorySegment mem, int offset) {
        return hasModel(mem, offset) ? Model.toObject(mem, offset + 5): null;
    }
    
    public static float getEntityScale(MemorySegment mem) {
        return getEntityScale(mem, 0);
    }
    
    public static float getEntityScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "EntityScale");
    }
    
    public static boolean hasModel(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static ModelUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ModelUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ModelUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ModelUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 5;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        Model v0 = null;
        if (hasModel(mem, offset)) {
            v0 = Model.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new ModelUpdate(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "EntityScale")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.model != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.entityScale, "EntityScale"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.entityScale);
        var varOffset = offset + 5;
        if (this.model != null) {
            
            varOffset += this.model.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 5;
        if (model != null) size += model.computeSize();

        return size;
    }

    public ModelUpdate clone() {
        ModelUpdate copy = new ModelUpdate();
        copy.model = this.model != null ? this.model.clone() : null;
        copy.entityScale = this.entityScale;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ModelUpdate other)) return false;
        return java.util.Objects.equals(this.model, other.model) && this.entityScale == other.entityScale;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(model, entityScale);
    }

}