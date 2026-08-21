// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class UIDoubleDataValue extends UIDataValue {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 8;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 8;
    public static final int MAX_SIZE = 8;

    public double value;

    public UIDoubleDataValue() {
    }

    public UIDoubleDataValue(double value) {
        this.value = value;
    }

    public UIDoubleDataValue(@Nonnull UIDoubleDataValue other) {
        this.value = other.value;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UIDoubleDataValue", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UIDoubleDataValue", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static double getValue(MemorySegment mem) {
        return getValue(mem, 0);
    }
    
    public static double getValue(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 0), "Value");
    }
    
    
    
    
    
    public static UIDoubleDataValue toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UIDoubleDataValue toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UIDoubleDataValue and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UIDoubleDataValue toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new UIDoubleDataValue(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 0), "Value")
        );
        if (cursor != null) cursor.position = offset + 8;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.value, "Value"); mem.set(PacketIO.PROTO_DOUBLE, offset + 0, this.value);
        
        
    
       return 8;
    }
    @Override
    public int computeSize() {
        return 8;
    }

    public UIDoubleDataValue clone() {
        UIDoubleDataValue copy = new UIDoubleDataValue();
        copy.value = this.value;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UIDoubleDataValue other)) return false;
        return this.value == other.value;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(value);
    }

}