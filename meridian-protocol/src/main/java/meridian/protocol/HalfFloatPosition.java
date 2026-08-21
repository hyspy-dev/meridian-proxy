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


public class HalfFloatPosition {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 6;
    public static final int MAX_SIZE = 6;

    public short x;
    public short y;
    public short z;

    public HalfFloatPosition() {
    }

    public HalfFloatPosition(short x, short y, short z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public HalfFloatPosition(@Nonnull HalfFloatPosition other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("HalfFloatPosition", offset, (int) mem.byteSize());
        long needed = (long) offset + 6;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("HalfFloatPosition", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static short getX(MemorySegment mem) {
        return getX(mem, 0);
    }
    
    public static short getX(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_SHORT, offset + 0);
    }
    
    public static short getY(MemorySegment mem) {
        return getY(mem, 0);
    }
    
    public static short getY(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_SHORT, offset + 2);
    }
    
    public static short getZ(MemorySegment mem) {
        return getZ(mem, 0);
    }
    
    public static short getZ(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_SHORT, offset + 4);
    }
    
    
    
    
    
    public static HalfFloatPosition toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static HalfFloatPosition toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one HalfFloatPosition and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static HalfFloatPosition toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new HalfFloatPosition(
            mem.get(PacketIO.PROTO_SHORT, offset + 0),
            mem.get(PacketIO.PROTO_SHORT, offset + 2),
            mem.get(PacketIO.PROTO_SHORT, offset + 4)
        );
        if (cursor != null) cursor.position = offset + 6;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_SHORT, offset + 0, this.x);
        mem.set(PacketIO.PROTO_SHORT, offset + 2, this.y);
        mem.set(PacketIO.PROTO_SHORT, offset + 4, this.z);
        
        
    
       return 6;
    }
    public int computeSize() {
        return 6;
    }

    public HalfFloatPosition clone() {
        HalfFloatPosition copy = new HalfFloatPosition();
        copy.x = this.x;
        copy.y = this.y;
        copy.z = this.z;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof HalfFloatPosition other)) return false;
        return this.x == other.x && this.y == other.y && this.z == other.z;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, y, z);
    }

}