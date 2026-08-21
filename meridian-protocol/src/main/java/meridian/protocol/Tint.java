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


public class Tint {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 24;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 24;
    public static final int MAX_SIZE = 24;

    public int top;
    public int bottom;
    public int front;
    public int back;
    public int left;
    public int right;

    public Tint() {
    }

    public Tint(int top, int bottom, int front, int back, int left, int right) {
        this.top = top;
        this.bottom = bottom;
        this.front = front;
        this.back = back;
        this.left = left;
        this.right = right;
    }

    public Tint(@Nonnull Tint other) {
        this.top = other.top;
        this.bottom = other.bottom;
        this.front = other.front;
        this.back = other.back;
        this.left = other.left;
        this.right = other.right;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Tint", offset, (int) mem.byteSize());
        long needed = (long) offset + 24;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Tint", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getTop(MemorySegment mem) {
        return getTop(mem, 0);
    }
    
    public static int getTop(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static int getBottom(MemorySegment mem) {
        return getBottom(mem, 0);
    }
    
    public static int getBottom(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 4);
    }
    
    public static int getFront(MemorySegment mem) {
        return getFront(mem, 0);
    }
    
    public static int getFront(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 8);
    }
    
    public static int getBack(MemorySegment mem) {
        return getBack(mem, 0);
    }
    
    public static int getBack(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 12);
    }
    
    public static int getLeft(MemorySegment mem) {
        return getLeft(mem, 0);
    }
    
    public static int getLeft(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 16);
    }
    
    public static int getRight(MemorySegment mem) {
        return getRight(mem, 0);
    }
    
    public static int getRight(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 20);
    }
    
    
    
    
    
    public static Tint toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Tint toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Tint and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Tint toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new Tint(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4),
            mem.get(PacketIO.PROTO_INT, offset + 8),
            mem.get(PacketIO.PROTO_INT, offset + 12),
            mem.get(PacketIO.PROTO_INT, offset + 16),
            mem.get(PacketIO.PROTO_INT, offset + 20)
        );
        if (cursor != null) cursor.position = offset + 24;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.top);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.bottom);
        mem.set(PacketIO.PROTO_INT, offset + 8, this.front);
        mem.set(PacketIO.PROTO_INT, offset + 12, this.back);
        mem.set(PacketIO.PROTO_INT, offset + 16, this.left);
        mem.set(PacketIO.PROTO_INT, offset + 20, this.right);
        
        
    
       return 24;
    }
    public int computeSize() {
        return 24;
    }

    public Tint clone() {
        Tint copy = new Tint();
        copy.top = this.top;
        copy.bottom = this.bottom;
        copy.front = this.front;
        copy.back = this.back;
        copy.left = this.left;
        copy.right = this.right;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Tint other)) return false;
        return this.top == other.top && this.bottom == other.bottom && this.front == other.front && this.back == other.back && this.left == other.left && this.right == other.right;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(top, bottom, front, back, left, right);
    }

}