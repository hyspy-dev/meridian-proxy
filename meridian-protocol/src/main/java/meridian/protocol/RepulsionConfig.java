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


public class RepulsionConfig {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 12;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 12;
    public static final int MAX_SIZE = 12;

    public float radius;
    public float minForce;
    public float maxForce;

    public RepulsionConfig() {
    }

    public RepulsionConfig(float radius, float minForce, float maxForce) {
        this.radius = radius;
        this.minForce = minForce;
        this.maxForce = maxForce;
    }

    public RepulsionConfig(@Nonnull RepulsionConfig other) {
        this.radius = other.radius;
        this.minForce = other.minForce;
        this.maxForce = other.maxForce;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("RepulsionConfig", offset, (int) mem.byteSize());
        long needed = (long) offset + 12;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("RepulsionConfig", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getRadius(MemorySegment mem) {
        return getRadius(mem, 0);
    }
    
    public static float getRadius(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "Radius");
    }
    
    public static float getMinForce(MemorySegment mem) {
        return getMinForce(mem, 0);
    }
    
    public static float getMinForce(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "MinForce");
    }
    
    public static float getMaxForce(MemorySegment mem) {
        return getMaxForce(mem, 0);
    }
    
    public static float getMaxForce(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "MaxForce");
    }
    
    
    
    
    
    public static RepulsionConfig toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static RepulsionConfig toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one RepulsionConfig and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static RepulsionConfig toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new RepulsionConfig(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "Radius"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "MinForce"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "MaxForce")
        );
        if (cursor != null) cursor.position = offset + 12;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.radius, "Radius"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.radius);
        PacketIO.requireFinite(this.minForce, "MinForce"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.minForce);
        PacketIO.requireFinite(this.maxForce, "MaxForce"); mem.set(PacketIO.PROTO_FLOAT, offset + 8, this.maxForce);
        
        
    
       return 12;
    }
    public int computeSize() {
        return 12;
    }

    public RepulsionConfig clone() {
        RepulsionConfig copy = new RepulsionConfig();
        copy.radius = this.radius;
        copy.minForce = this.minForce;
        copy.maxForce = this.maxForce;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RepulsionConfig other)) return false;
        return this.radius == other.radius && this.minForce == other.minForce && this.maxForce == other.maxForce;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(radius, minForce, maxForce);
    }

}