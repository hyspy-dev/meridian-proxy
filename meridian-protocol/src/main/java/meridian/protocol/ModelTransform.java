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


public class ModelTransform {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 49;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 49;
    public static final int MAX_SIZE = 49;

    @Nullable public Position position;
    @Nullable public Direction bodyOrientation;
    @Nullable public Direction lookOrientation;

    public ModelTransform() {
    }

    public ModelTransform(@Nullable Position position, @Nullable Direction bodyOrientation, @Nullable Direction lookOrientation) {
        this.position = position;
        this.bodyOrientation = bodyOrientation;
        this.lookOrientation = lookOrientation;
    }

    public ModelTransform(@Nonnull ModelTransform other) {
        this.position = other.position;
        this.bodyOrientation = other.bodyOrientation;
        this.lookOrientation = other.lookOrientation;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ModelTransform", offset, (int) mem.byteSize());
        long needed = (long) offset + 49;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ModelTransform", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
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
    public static Direction getBodyOrientation(MemorySegment mem) {
        return getBodyOrientation(mem, 0);
    }
    
    @Nullable
    public static Direction getBodyOrientation(MemorySegment mem, int offset) {
        return hasBodyOrientation(mem, offset) ? Direction.toObject(mem, offset + 25): null;
    }
    
    @Nullable
    public static Direction getLookOrientation(MemorySegment mem) {
        return getLookOrientation(mem, 0);
    }
    
    @Nullable
    public static Direction getLookOrientation(MemorySegment mem, int offset) {
        return hasLookOrientation(mem, offset) ? Direction.toObject(mem, offset + 37): null;
    }
    
    public static boolean hasPosition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasBodyOrientation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasLookOrientation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    
    
    public static ModelTransform toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ModelTransform toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ModelTransform and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ModelTransform toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new ModelTransform(
            hasPosition(mem, offset) ? Position.toObject(mem, offset + 1) : null,
            hasBodyOrientation(mem, offset) ? Direction.toObject(mem, offset + 25) : null,
            hasLookOrientation(mem, offset) ? Direction.toObject(mem, offset + 37) : null
        );
        if (cursor != null) cursor.position = offset + 49;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.position != null) nullBits |= 0x01;
        if (this.bodyOrientation != null) nullBits |= 0x02;
        if (this.lookOrientation != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.position != null) {
            this.position.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 24).fill((byte) 0); 
        }
        if (this.bodyOrientation != null) {
            this.bodyOrientation.serialize(mem, offset + 25);
        } else {
            mem.asSlice(offset + 25, 12).fill((byte) 0); 
        }
        if (this.lookOrientation != null) {
            this.lookOrientation.serialize(mem, offset + 37);
        } else {
            mem.asSlice(offset + 37, 12).fill((byte) 0); 
        }
        
        
    
       return 49;
    }
    public int computeSize() {
        return 49;
    }

    public ModelTransform clone() {
        ModelTransform copy = new ModelTransform();
        copy.position = this.position != null ? this.position.clone() : null;
        copy.bodyOrientation = this.bodyOrientation != null ? this.bodyOrientation.clone() : null;
        copy.lookOrientation = this.lookOrientation != null ? this.lookOrientation.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ModelTransform other)) return false;
        return java.util.Objects.equals(this.position, other.position) && java.util.Objects.equals(this.bodyOrientation, other.bodyOrientation) && java.util.Objects.equals(this.lookOrientation, other.lookOrientation);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(position, bodyOrientation, lookOrientation);
    }

}