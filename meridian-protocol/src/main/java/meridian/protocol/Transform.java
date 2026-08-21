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


public class Transform {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 37;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 37;
    public static final int MAX_SIZE = 37;

    @Nullable public Position position;
    @Nullable public Direction orientation;

    public Transform() {
    }

    public Transform(@Nullable Position position, @Nullable Direction orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public Transform(@Nonnull Transform other) {
        this.position = other.position;
        this.orientation = other.orientation;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Transform", offset, (int) mem.byteSize());
        long needed = (long) offset + 37;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Transform", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static Position getPosition(MemorySegment mem) {
        return getPosition(mem, 0);
    }
    
    @Nullable
    public static Position getPosition(MemorySegment mem, int offset) {
        return hasPosition(mem, offset) ? Position.toObject(mem, offset + 1): null;
    }
    
    @Nullable
    public static Direction getOrientation(MemorySegment mem) {
        return getOrientation(mem, 0);
    }
    
    @Nullable
    public static Direction getOrientation(MemorySegment mem, int offset) {
        return hasOrientation(mem, offset) ? Direction.toObject(mem, offset + 25): null;
    }
    
    public static boolean hasPosition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasOrientation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    
    
    public static Transform toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Transform toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Transform and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Transform toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new Transform(
            hasPosition(mem, offset) ? Position.toObject(mem, offset + 1) : null,
            hasOrientation(mem, offset) ? Direction.toObject(mem, offset + 25) : null
        );
        if (cursor != null) cursor.position = offset + 37;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.position != null) nullBits |= 0x01;
        if (this.orientation != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.position != null) {
            this.position.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 24).fill((byte) 0); 
        }
        if (this.orientation != null) {
            this.orientation.serialize(mem, offset + 25);
        } else {
            mem.asSlice(offset + 25, 12).fill((byte) 0); 
        }
        
        
    
       return 37;
    }
    public int computeSize() {
        return 37;
    }

    public Transform clone() {
        Transform copy = new Transform();
        copy.position = this.position != null ? this.position.clone() : null;
        copy.orientation = this.orientation != null ? this.orientation.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Transform other)) return false;
        return java.util.Objects.equals(this.position, other.position) && java.util.Objects.equals(this.orientation, other.orientation);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(position, orientation);
    }

}