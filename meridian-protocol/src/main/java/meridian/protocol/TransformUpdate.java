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


public class TransformUpdate extends ComponentUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 49;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 49;
    public static final int MAX_SIZE = 49;

    @Nonnull public ModelTransform transform = new ModelTransform();

    public TransformUpdate() {
    }

    public TransformUpdate(@Nonnull ModelTransform transform) {
        this.transform = transform;
    }

    public TransformUpdate(@Nonnull TransformUpdate other) {
        this.transform = other.transform;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("TransformUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 49;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("TransformUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static ModelTransform getTransform(MemorySegment mem) {
        return getTransform(mem, 0);
    }
    
    public static ModelTransform getTransform(MemorySegment mem, int offset) {
        return ModelTransform.toObject(mem, offset + 0);
    }
    
    
    
    
    
    public static TransformUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static TransformUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one TransformUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static TransformUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new TransformUpdate(
            ModelTransform.toObject(mem, offset + 0)
        );
        if (cursor != null) cursor.position = offset + 49;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        this.transform.serialize(mem, offset + 0);
        
        
    
       return 49;
    }
    @Override
    public int computeSize() {
        return 49;
    }

    public TransformUpdate clone() {
        TransformUpdate copy = new TransformUpdate();
        copy.transform = this.transform.clone();
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TransformUpdate other)) return false;
        return java.util.Objects.equals(this.transform, other.transform);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(transform);
    }

}