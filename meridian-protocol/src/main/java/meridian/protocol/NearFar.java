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


public class NearFar {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 8;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 8;
    public static final int MAX_SIZE = 8;

    public float near;
    public float far;

    public NearFar() {
    }

    public NearFar(float near, float far) {
        this.near = near;
        this.far = far;
    }

    public NearFar(@Nonnull NearFar other) {
        this.near = other.near;
        this.far = other.far;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("NearFar", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("NearFar", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getNear(MemorySegment mem) {
        return getNear(mem, 0);
    }
    
    public static float getNear(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "Near");
    }
    
    public static float getFar(MemorySegment mem) {
        return getFar(mem, 0);
    }
    
    public static float getFar(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "Far");
    }
    
    
    
    
    
    public static NearFar toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static NearFar toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one NearFar and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static NearFar toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new NearFar(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "Near"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "Far")
        );
        if (cursor != null) cursor.position = offset + 8;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.near, "Near"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.near);
        PacketIO.requireFinite(this.far, "Far"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.far);
        
        
    
       return 8;
    }
    public int computeSize() {
        return 8;
    }

    public NearFar clone() {
        NearFar copy = new NearFar();
        copy.near = this.near;
        copy.far = this.far;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof NearFar other)) return false;
        return this.near == other.near && this.far == other.far;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(near, far);
    }

}