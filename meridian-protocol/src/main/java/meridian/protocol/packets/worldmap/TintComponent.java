// Auto-generated - do not edit
package meridian.protocol.packets.worldmap;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import meridian.protocol.Color;

public class TintComponent extends MapMarkerComponent {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 3;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 3;
    public static final int MAX_SIZE = 3;

    @Nonnull public Color color = new Color();

    public TintComponent() {
    }

    public TintComponent(@Nonnull Color color) {
        this.color = color;
    }

    public TintComponent(@Nonnull TintComponent other) {
        this.color = other.color;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("TintComponent", offset, (int) mem.byteSize());
        long needed = (long) offset + 3;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("TintComponent", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static Color getColor(MemorySegment mem) {
        return getColor(mem, 0);
    }
    
    public static Color getColor(MemorySegment mem, int offset) {
        return Color.toObject(mem, offset + 0);
    }
    
    
    
    
    
    public static TintComponent toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static TintComponent toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one TintComponent and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static TintComponent toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new TintComponent(
            Color.toObject(mem, offset + 0)
        );
        if (cursor != null) cursor.position = offset + 3;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        this.color.serialize(mem, offset + 0);
        
        
    
       return 3;
    }
    @Override
    public int computeSize() {
        return 3;
    }

    public TintComponent clone() {
        TintComponent copy = new TintComponent();
        copy.color = this.color.clone();
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TintComponent other)) return false;
        return java.util.Objects.equals(this.color, other.color);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(color);
    }

}