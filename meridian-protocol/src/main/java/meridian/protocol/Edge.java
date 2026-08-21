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


public class Edge {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 9;

    @Nullable public ColorAlpha color;
    public float width;

    public Edge() {
    }

    public Edge(@Nullable ColorAlpha color, float width) {
        this.color = color;
        this.width = width;
    }

    public Edge(@Nonnull Edge other) {
        this.color = other.color;
        this.width = other.width;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Edge", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Edge", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static ColorAlpha getColor(MemorySegment mem) {
        return getColor(mem, 0);
    }
    
    @Nullable
    public static ColorAlpha getColor(MemorySegment mem, int offset) {
        return hasColor(mem, offset) ? ColorAlpha.toObject(mem, offset + 1): null;
    }
    
    public static float getWidth(MemorySegment mem) {
        return getWidth(mem, 0);
    }
    
    public static float getWidth(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "Width");
    }
    
    public static boolean hasColor(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static Edge toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Edge toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Edge and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Edge toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new Edge(
            hasColor(mem, offset) ? ColorAlpha.toObject(mem, offset + 1) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "Width")
        );
        if (cursor != null) cursor.position = offset + 9;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.color != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.color != null) {
            this.color.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 4).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.width, "Width"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.width);
        
        
    
       return 9;
    }
    public int computeSize() {
        return 9;
    }

    public Edge clone() {
        Edge copy = new Edge();
        copy.color = this.color != null ? this.color.clone() : null;
        copy.width = this.width;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Edge other)) return false;
        return java.util.Objects.equals(this.color, other.color) && this.width == other.width;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(color, width);
    }

}