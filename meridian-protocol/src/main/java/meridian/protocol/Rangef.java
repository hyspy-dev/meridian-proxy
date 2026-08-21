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


public class Rangef {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 8;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 8;
    public static final int MAX_SIZE = 8;

    public float min;
    public float max;

    public Rangef() {
    }

    public Rangef(float min, float max) {
        this.min = min;
        this.max = max;
    }

    public Rangef(@Nonnull Rangef other) {
        this.min = other.min;
        this.max = other.max;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Rangef", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Rangef", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
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
    
    
    
    
    
    public static Rangef toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Rangef toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Rangef and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Rangef toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new Rangef(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "Min"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "Max")
        );
        if (cursor != null) cursor.position = offset + 8;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.min, "Min"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.min);
        PacketIO.requireFinite(this.max, "Max"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.max);
        
        
    
       return 8;
    }
    public int computeSize() {
        return 8;
    }

    public Rangef clone() {
        Rangef copy = new Rangef();
        copy.min = this.min;
        copy.max = this.max;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Rangef other)) return false;
        return this.min == other.min && this.max == other.max;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(min, max);
    }

}