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


public class RangeVector2f {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 17;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 17;
    public static final int MAX_SIZE = 17;

    @Nullable public Rangef x;
    @Nullable public Rangef y;

    public RangeVector2f() {
    }

    public RangeVector2f(@Nullable Rangef x, @Nullable Rangef y) {
        this.x = x;
        this.y = y;
    }

    public RangeVector2f(@Nonnull RangeVector2f other) {
        this.x = other.x;
        this.y = other.y;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("RangeVector2f", offset, (int) mem.byteSize());
        long needed = (long) offset + 17;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("RangeVector2f", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static Rangef getX(MemorySegment mem) {
        return getX(mem, 0);
    }
    
    @Nullable
    public static Rangef getX(MemorySegment mem, int offset) {
        return hasX(mem, offset) ? Rangef.toObject(mem, offset + 1): null;
    }
    
    @Nullable
    public static Rangef getY(MemorySegment mem) {
        return getY(mem, 0);
    }
    
    @Nullable
    public static Rangef getY(MemorySegment mem, int offset) {
        return hasY(mem, offset) ? Rangef.toObject(mem, offset + 9): null;
    }
    
    public static boolean hasX(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasY(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    
    
    public static RangeVector2f toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static RangeVector2f toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one RangeVector2f and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static RangeVector2f toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new RangeVector2f(
            hasX(mem, offset) ? Rangef.toObject(mem, offset + 1) : null,
            hasY(mem, offset) ? Rangef.toObject(mem, offset + 9) : null
        );
        if (cursor != null) cursor.position = offset + 17;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.x != null) nullBits |= 0x01;
        if (this.y != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.x != null) {
            this.x.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 8).fill((byte) 0); 
        }
        if (this.y != null) {
            this.y.serialize(mem, offset + 9);
        } else {
            mem.asSlice(offset + 9, 8).fill((byte) 0); 
        }
        
        
    
       return 17;
    }
    public int computeSize() {
        return 17;
    }

    public RangeVector2f clone() {
        RangeVector2f copy = new RangeVector2f();
        copy.x = this.x != null ? this.x.clone() : null;
        copy.y = this.y != null ? this.y.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RangeVector2f other)) return false;
        return java.util.Objects.equals(this.x, other.x) && java.util.Objects.equals(this.y, other.y);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, y);
    }

}