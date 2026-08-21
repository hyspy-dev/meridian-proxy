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
import org.joml.*;

public class BoxBreakShape extends BreakShape {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 27;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 27;
    public static final int MAX_SIZE = 27;

    public int width;
    public int height;
    public int depth;
    public boolean centered;
    @Nullable public Vector3fc offset;
    @Nonnull public BreakShapeOrientation orientation = BreakShapeOrientation.View;

    public BoxBreakShape() {
    }

    public BoxBreakShape(int width, int height, int depth, boolean centered, @Nullable Vector3fc offset, @Nonnull BreakShapeOrientation orientation) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.centered = centered;
        this.offset = offset;
        this.orientation = orientation;
    }

    public BoxBreakShape(@Nonnull BoxBreakShape other) {
        this.width = other.width;
        this.height = other.height;
        this.depth = other.depth;
        this.centered = other.centered;
        this.offset = other.offset;
        this.orientation = other.orientation;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BoxBreakShape", offset, (int) mem.byteSize());
        long needed = (long) offset + 27;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BoxBreakShape", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getWidth(MemorySegment mem) {
        return getWidth(mem, 0);
    }
    
    public static int getWidth(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getHeight(MemorySegment mem) {
        return getHeight(mem, 0);
    }
    
    public static int getHeight(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static int getDepth(MemorySegment mem) {
        return getDepth(mem, 0);
    }
    
    public static int getDepth(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 9);
    }
    
    public static boolean getCentered(MemorySegment mem) {
        return getCentered(mem, 0);
    }
    
    public static boolean getCentered(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 13);
    }
    
    @Nullable
    public static Vector3fc getOffset(MemorySegment mem) {
        return getOffset(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getOffset(MemorySegment mem, int offset) {
        return hasOffset(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 14), "Offset"): null;
    }
    
    public static BreakShapeOrientation getOrientation(MemorySegment mem) {
        return getOrientation(mem, 0);
    }
    
    public static BreakShapeOrientation getOrientation(MemorySegment mem, int offset) {
        return BreakShapeOrientation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 26));
    }
    
    public static boolean hasOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static BoxBreakShape toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BoxBreakShape toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BoxBreakShape and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BoxBreakShape toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BoxBreakShape(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            mem.get(PacketIO.PROTO_INT, offset + 9),
            mem.get(PacketIO.PROTO_BOOL, offset + 13),
            hasOffset(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 14), "Offset") : null,
            BreakShapeOrientation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 26))
        );
        if (cursor != null) cursor.position = offset + 27;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.offset != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.width);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.height);
        mem.set(PacketIO.PROTO_INT, offset + 9, this.depth);
        mem.set(PacketIO.PROTO_BOOL, offset + 13, this.centered);
        if (this.offset != null) {
            PacketIO.requireFinite(this.offset, "Offset"); PacketIO.writeVector3f(mem, offset + 14, this.offset);
        } else {
            mem.asSlice(offset + 14, 12).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BYTE, offset + 26, (byte) this.orientation.getValue());
        
        
    
       return 27;
    }
    @Override
    public int computeSize() {
        return 27;
    }

    public BoxBreakShape clone() {
        BoxBreakShape copy = new BoxBreakShape();
        copy.width = this.width;
        copy.height = this.height;
        copy.depth = this.depth;
        copy.centered = this.centered;
        copy.offset = this.offset;
        copy.orientation = this.orientation;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BoxBreakShape other)) return false;
        return this.width == other.width && this.height == other.height && this.depth == other.depth && this.centered == other.centered && java.util.Objects.equals(this.offset, other.offset) && java.util.Objects.equals(this.orientation, other.orientation);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(width, height, depth, centered, offset, orientation);
    }

}