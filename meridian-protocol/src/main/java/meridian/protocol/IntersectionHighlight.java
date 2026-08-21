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


public class IntersectionHighlight {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 8;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 8;
    public static final int MAX_SIZE = 8;

    public float highlightThreshold;
    @Nullable public Color highlightColor;

    public IntersectionHighlight() {
    }

    public IntersectionHighlight(float highlightThreshold, @Nullable Color highlightColor) {
        this.highlightThreshold = highlightThreshold;
        this.highlightColor = highlightColor;
    }

    public IntersectionHighlight(@Nonnull IntersectionHighlight other) {
        this.highlightThreshold = other.highlightThreshold;
        this.highlightColor = other.highlightColor;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("IntersectionHighlight", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("IntersectionHighlight", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getHighlightThreshold(MemorySegment mem) {
        return getHighlightThreshold(mem, 0);
    }
    
    public static float getHighlightThreshold(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "HighlightThreshold");
    }
    
    @Nullable
    public static Color getHighlightColor(MemorySegment mem) {
        return getHighlightColor(mem, 0);
    }
    
    @Nullable
    public static Color getHighlightColor(MemorySegment mem, int offset) {
        return hasHighlightColor(mem, offset) ? Color.toObject(mem, offset + 5): null;
    }
    
    public static boolean hasHighlightColor(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static IntersectionHighlight toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static IntersectionHighlight toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one IntersectionHighlight and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static IntersectionHighlight toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new IntersectionHighlight(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "HighlightThreshold"),
            hasHighlightColor(mem, offset) ? Color.toObject(mem, offset + 5) : null
        );
        if (cursor != null) cursor.position = offset + 8;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.highlightColor != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.highlightThreshold, "HighlightThreshold"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.highlightThreshold);
        if (this.highlightColor != null) {
            this.highlightColor.serialize(mem, offset + 5);
        } else {
            mem.asSlice(offset + 5, 3).fill((byte) 0); 
        }
        
        
    
       return 8;
    }
    public int computeSize() {
        return 8;
    }

    public IntersectionHighlight clone() {
        IntersectionHighlight copy = new IntersectionHighlight();
        copy.highlightThreshold = this.highlightThreshold;
        copy.highlightColor = this.highlightColor != null ? this.highlightColor.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof IntersectionHighlight other)) return false;
        return this.highlightThreshold == other.highlightThreshold && java.util.Objects.equals(this.highlightColor, other.highlightColor);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(highlightThreshold, highlightColor);
    }

}