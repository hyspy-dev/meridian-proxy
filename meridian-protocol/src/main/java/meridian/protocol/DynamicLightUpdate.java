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


public class DynamicLightUpdate extends ComponentUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 4;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 4;
    public static final int MAX_SIZE = 4;

    @Nonnull public ColorLight dynamicLight = new ColorLight();

    public DynamicLightUpdate() {
    }

    public DynamicLightUpdate(@Nonnull ColorLight dynamicLight) {
        this.dynamicLight = dynamicLight;
    }

    public DynamicLightUpdate(@Nonnull DynamicLightUpdate other) {
        this.dynamicLight = other.dynamicLight;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("DynamicLightUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 4;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("DynamicLightUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static ColorLight getDynamicLight(MemorySegment mem) {
        return getDynamicLight(mem, 0);
    }
    
    public static ColorLight getDynamicLight(MemorySegment mem, int offset) {
        return ColorLight.toObject(mem, offset + 0);
    }
    
    
    
    
    
    public static DynamicLightUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static DynamicLightUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one DynamicLightUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static DynamicLightUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new DynamicLightUpdate(
            ColorLight.toObject(mem, offset + 0)
        );
        if (cursor != null) cursor.position = offset + 4;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        this.dynamicLight.serialize(mem, offset + 0);
        
        
    
       return 4;
    }
    @Override
    public int computeSize() {
        return 4;
    }

    public DynamicLightUpdate clone() {
        DynamicLightUpdate copy = new DynamicLightUpdate();
        copy.dynamicLight = this.dynamicLight.clone();
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DynamicLightUpdate other)) return false;
        return java.util.Objects.equals(this.dynamicLight, other.dynamicLight);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(dynamicLight);
    }

}