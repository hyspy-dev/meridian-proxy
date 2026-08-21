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


public class FormattedMessageImage {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 8;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 8;
    public static final int MAX_SIZE = 16384013;

    @Nonnull public String filePath = "";
    public int width;
    public int height;

    public FormattedMessageImage() {
    }

    public FormattedMessageImage(@Nonnull String filePath, int width, int height) {
        this.filePath = filePath;
        this.width = width;
        this.height = height;
    }

    public FormattedMessageImage(@Nonnull FormattedMessageImage other) {
        this.filePath = other.filePath;
        this.width = other.width;
        this.height = other.height;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("FormattedMessageImage", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("FormattedMessageImage", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getFilePath(MemorySegment mem) {
        return getFilePath(mem, 0);
    }
    
    public static String getFilePath(MemorySegment mem, int offset) {
        return PacketIO.readVarString("FilePath", mem, offset + 8, 4096000);
    }
    
    public static int getWidth(MemorySegment mem) {
        return getWidth(mem, 0);
    }
    
    public static int getWidth(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static int getHeight(MemorySegment mem) {
        return getHeight(mem, 0);
    }
    
    public static int getHeight(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 4);
    }
    
    
    
    
    
    public static FormattedMessageImage toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static FormattedMessageImage toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one FormattedMessageImage and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static FormattedMessageImage toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 8;
        var varPos = 0;
        String v0;
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("FilePath", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new FormattedMessageImage(
            v0,
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.width);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.height);
        var varOffset = offset + 8;
        varOffset += PacketIO.writeVarString(mem, varOffset, this.filePath, 4096000);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 8;
        size += PacketIO.stringSize(filePath);

        return size;
    }

    public FormattedMessageImage clone() {
        FormattedMessageImage copy = new FormattedMessageImage();
        copy.filePath = this.filePath;
        copy.width = this.width;
        copy.height = this.height;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FormattedMessageImage other)) return false;
        return java.util.Objects.equals(this.filePath, other.filePath) && this.width == other.width && this.height == other.height;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(filePath, width, height);
    }

}