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


public class Rangeb {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 2;
    public static final int MAX_SIZE = 2;

    public byte min;
    public byte max;

    public Rangeb() {
    }

    public Rangeb(byte min, byte max) {
        this.min = min;
        this.max = max;
    }

    public Rangeb(@Nonnull Rangeb other) {
        this.min = other.min;
        this.max = other.max;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Rangeb", offset, (int) mem.byteSize());
        long needed = (long) offset + 2;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Rangeb", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static byte getMin(MemorySegment mem) {
        return getMin(mem, 0);
    }
    
    public static byte getMin(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 0);
    }
    
    public static byte getMax(MemorySegment mem) {
        return getMax(mem, 0);
    }
    
    public static byte getMax(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 1);
    }
    
    
    
    
    
    public static Rangeb toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Rangeb toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Rangeb and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Rangeb toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new Rangeb(
            mem.get(PacketIO.PROTO_BYTE, offset + 0),
            mem.get(PacketIO.PROTO_BYTE, offset + 1)
        );
        if (cursor != null) cursor.position = offset + 2;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, this.min);
        mem.set(PacketIO.PROTO_BYTE, offset + 1, this.max);
        
        
    
       return 2;
    }
    public int computeSize() {
        return 2;
    }

    public Rangeb clone() {
        Rangeb copy = new Rangeb();
        copy.min = this.min;
        copy.max = this.max;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Rangeb other)) return false;
        return this.min == other.min && this.max == other.max;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(min, max);
    }

}