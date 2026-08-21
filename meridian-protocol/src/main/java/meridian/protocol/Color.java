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


public class Color {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 3;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 3;
    public static final int MAX_SIZE = 3;

    public byte red;
    public byte green;
    public byte blue;

    public Color() {
    }

    public Color(byte red, byte green, byte blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public Color(@Nonnull Color other) {
        this.red = other.red;
        this.green = other.green;
        this.blue = other.blue;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Color", offset, (int) mem.byteSize());
        long needed = (long) offset + 3;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Color", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static byte getRed(MemorySegment mem) {
        return getRed(mem, 0);
    }
    
    public static byte getRed(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 0);
    }
    
    public static byte getGreen(MemorySegment mem) {
        return getGreen(mem, 0);
    }
    
    public static byte getGreen(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 1);
    }
    
    public static byte getBlue(MemorySegment mem) {
        return getBlue(mem, 0);
    }
    
    public static byte getBlue(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 2);
    }
    
    
    
    
    
    public static Color toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Color toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Color and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Color toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new Color(
            mem.get(PacketIO.PROTO_BYTE, offset + 0),
            mem.get(PacketIO.PROTO_BYTE, offset + 1),
            mem.get(PacketIO.PROTO_BYTE, offset + 2)
        );
        if (cursor != null) cursor.position = offset + 3;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, this.red);
        mem.set(PacketIO.PROTO_BYTE, offset + 1, this.green);
        mem.set(PacketIO.PROTO_BYTE, offset + 2, this.blue);
        
        
    
       return 3;
    }
    public int computeSize() {
        return 3;
    }

    public Color clone() {
        Color copy = new Color();
        copy.red = this.red;
        copy.green = this.green;
        copy.blue = this.blue;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Color other)) return false;
        return this.red == other.red && this.green == other.green && this.blue == other.blue;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(red, green, blue);
    }

}