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


public class ClampConfig {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 9;

    public float min;
    public float max;
    public boolean normalize;

    public ClampConfig() {
    }

    public ClampConfig(float min, float max, boolean normalize) {
        this.min = min;
        this.max = max;
        this.normalize = normalize;
    }

    public ClampConfig(@Nonnull ClampConfig other) {
        this.min = other.min;
        this.max = other.max;
        this.normalize = other.normalize;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ClampConfig", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ClampConfig", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getMin(MemorySegment mem) {
        return getMin(mem, 0);
    }
    
    public static float getMin(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "Min");
    }
    
    public static float getMax(MemorySegment mem) {
        return getMax(mem, 0);
    }
    
    public static float getMax(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "Max");
    }
    
    public static boolean getNormalize(MemorySegment mem) {
        return getNormalize(mem, 0);
    }
    
    public static boolean getNormalize(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 8);
    }
    
    
    
    
    
    public static ClampConfig toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ClampConfig toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ClampConfig and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ClampConfig toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new ClampConfig(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "Min"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "Max"),
            mem.get(PacketIO.PROTO_BOOL, offset + 8)
        );
        if (cursor != null) cursor.position = offset + 9;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.min, "Min"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.min);
        PacketIO.requireFinite(this.max, "Max"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.max);
        mem.set(PacketIO.PROTO_BOOL, offset + 8, this.normalize);
        
        
    
       return 9;
    }
    public int computeSize() {
        return 9;
    }

    public ClampConfig clone() {
        ClampConfig copy = new ClampConfig();
        copy.min = this.min;
        copy.max = this.max;
        copy.normalize = this.normalize;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ClampConfig other)) return false;
        return this.min == other.min && this.max == other.max && this.normalize == other.normalize;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(min, max, normalize);
    }

}