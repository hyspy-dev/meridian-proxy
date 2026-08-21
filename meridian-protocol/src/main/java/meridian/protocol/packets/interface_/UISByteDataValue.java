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


public class UISByteDataValue extends UIDataValue {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1;

    public byte value;

    public UISByteDataValue() {
    }

    public UISByteDataValue(byte value) {
        this.value = value;
    }

    public UISByteDataValue(@Nonnull UISByteDataValue other) {
        this.value = other.value;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UISByteDataValue", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UISByteDataValue", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static byte getValue(MemorySegment mem) {
        return getValue(mem, 0);
    }
    
    public static byte getValue(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 0);
    }
    
    
    
    
    
    public static UISByteDataValue toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UISByteDataValue toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UISByteDataValue and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UISByteDataValue toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new UISByteDataValue(
            mem.get(PacketIO.PROTO_BYTE, offset + 0)
        );
        if (cursor != null) cursor.position = offset + 1;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, this.value);
        
        
    
       return 1;
    }
    @Override
    public int computeSize() {
        return 1;
    }

    public UISByteDataValue clone() {
        UISByteDataValue copy = new UISByteDataValue();
        copy.value = this.value;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UISByteDataValue other)) return false;
        return this.value == other.value;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(value);
    }

}