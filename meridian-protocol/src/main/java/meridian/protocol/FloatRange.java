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


public class FloatRange {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 8;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 8;
    public static final int MAX_SIZE = 8;

    public float inclusiveMin;
    public float inclusiveMax;

    public FloatRange() {
    }

    public FloatRange(float inclusiveMin, float inclusiveMax) {
        this.inclusiveMin = inclusiveMin;
        this.inclusiveMax = inclusiveMax;
    }

    public FloatRange(@Nonnull FloatRange other) {
        this.inclusiveMin = other.inclusiveMin;
        this.inclusiveMax = other.inclusiveMax;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("FloatRange", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("FloatRange", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getInclusiveMin(MemorySegment mem) {
        return getInclusiveMin(mem, 0);
    }
    
    public static float getInclusiveMin(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "InclusiveMin");
    }
    
    public static float getInclusiveMax(MemorySegment mem) {
        return getInclusiveMax(mem, 0);
    }
    
    public static float getInclusiveMax(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "InclusiveMax");
    }
    
    
    
    
    
    public static FloatRange toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static FloatRange toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one FloatRange and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static FloatRange toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new FloatRange(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "InclusiveMin"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "InclusiveMax")
        );
        if (cursor != null) cursor.position = offset + 8;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.inclusiveMin, "InclusiveMin"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.inclusiveMin);
        PacketIO.requireFinite(this.inclusiveMax, "InclusiveMax"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.inclusiveMax);
        
        
    
       return 8;
    }
    public int computeSize() {
        return 8;
    }

    public FloatRange clone() {
        FloatRange copy = new FloatRange();
        copy.inclusiveMin = this.inclusiveMin;
        copy.inclusiveMax = this.inclusiveMax;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FloatRange other)) return false;
        return this.inclusiveMin == other.inclusiveMin && this.inclusiveMax == other.inclusiveMax;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(inclusiveMin, inclusiveMax);
    }

}