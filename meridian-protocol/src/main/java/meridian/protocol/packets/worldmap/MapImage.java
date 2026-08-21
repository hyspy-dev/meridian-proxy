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


public class MapImage {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 10;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 18;
    public static final int MAX_SIZE = 20480028;

    public int width;
    public int height;
    @Nullable public int[] palette;
    public byte bitsPerIndex;
    @Nullable public byte[] packedIndices;

    public MapImage() {
    }

    public MapImage(int width, int height, @Nullable int[] palette, byte bitsPerIndex, @Nullable byte[] packedIndices) {
        this.width = width;
        this.height = height;
        this.palette = palette;
        this.bitsPerIndex = bitsPerIndex;
        this.packedIndices = packedIndices;
    }

    public MapImage(@Nonnull MapImage other) {
        this.width = other.width;
        this.height = other.height;
        this.palette = other.palette;
        this.bitsPerIndex = other.bitsPerIndex;
        this.packedIndices = other.packedIndices;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("MapImage", offset, (int) mem.byteSize());
        long needed = (long) offset + 18;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("MapImage", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
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
    
    @Nullable
    public static int[] getPalette(MemorySegment mem) {
        return getPalette(mem, 0);
    }
    
    @Nullable
    public static int[] getPalette(MemorySegment mem, int offset) {
        if (!hasPalette(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 10, 18, "Palette");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Palette");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Palette", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Palette", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    public static byte getBitsPerIndex(MemorySegment mem) {
        return getBitsPerIndex(mem, 0);
    }
    
    public static byte getBitsPerIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 9);
    }
    
    @Nullable
    public static byte[] getPackedIndices(MemorySegment mem) {
        return getPackedIndices(mem, 0);
    }
    
    @Nullable
    public static byte[] getPackedIndices(MemorySegment mem, int offset) {
        if (!hasPackedIndices(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 14, 18, "PackedIndices");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("PackedIndices");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("PackedIndices", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("PackedIndices", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new byte[len];
        MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, data, 0, len);
        return data;
    }
    
    public static boolean hasPalette(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasPackedIndices(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    private static int getValidatedOffset(MemorySegment buffer, int base, int slotPosition, int varBlockStart, String fieldName) {
        int offset = buffer.get(PacketIO.PROTO_INT, base + slotPosition);
        if (offset < 0 || offset > buffer.byteSize() - base - varBlockStart)
            throw ProtocolException.invalidOffset(fieldName, offset, (int) buffer.byteSize());
        return varBlockStart + offset;
    }
    
    /**
     * Rejects an offset slot that does not name the position the field-order walk reached. A
     * present field must sit where the previous field ended, and an absent field carries -1, so
     * the slot a random-access getter resolves and the walk describe the same bytes.
     */
    private static void requireSlot(MemorySegment mem, int slotPosition, int expected, String fieldName) {
        int slot = mem.get(PacketIO.PROTO_INT, slotPosition);
        if (slot != expected) throw ProtocolException.nonCanonicalLayout(fieldName, slot, expected);
    }
    
    public static MapImage toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static MapImage toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one MapImage and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static MapImage toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 18;
        var varPos = 0;
        int[] v2 = null;
        if (hasPalette(mem, offset)) {
            requireSlot(mem, offset + 10, varPos, "Palette");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Palette");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Palette", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Palette", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v2, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 10, -1, "Palette");
        }
        
        byte[] v4 = null;
        if (hasPackedIndices(mem, offset)) {
            requireSlot(mem, offset + 14, varPos, "PackedIndices");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("PackedIndices");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("PackedIndices", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("PackedIndices", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v4 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v4, 0, len);
            varPos = off + len - varBase;
        } else {
            requireSlot(mem, offset + 14, -1, "PackedIndices");
        }
        var result = new MapImage(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            v2,
            mem.get(PacketIO.PROTO_BYTE, offset + 9),
            v4
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.palette != null) nullBits |= 0x01;
        if (this.packedIndices != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.width);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.height);
        mem.set(PacketIO.PROTO_BYTE, offset + 9, this.bitsPerIndex);
        var varOffset = offset + 18;
        if (this.palette != null) {
            mem.set(PacketIO.PROTO_INT, offset + 10, varOffset - offset - 18);
            if (palette.length > 4096000) throw ProtocolException.arrayTooLong("Palette", palette.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.palette.length);
            
            MemorySegment.copy(this.palette, 0, mem, PacketIO.PROTO_INT, varOffset, this.palette.length);
            varOffset += this.palette.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 10, -1);
        }
        if (this.packedIndices != null) {
            mem.set(PacketIO.PROTO_INT, offset + 14, varOffset - offset - 18);
            if (packedIndices.length > 4096000) throw ProtocolException.arrayTooLong("PackedIndices", packedIndices.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.packedIndices.length);
            
            MemorySegment.copy(this.packedIndices, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.packedIndices.length);
            varOffset += this.packedIndices.length * 1;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 14, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 18;
        if (palette != null) size += VarInt.size(palette.length) + palette.length * 4;
    if (packedIndices != null) size += VarInt.size(packedIndices.length) + packedIndices.length * 1;

        return size;
    }

    public MapImage clone() {
        MapImage copy = new MapImage();
        copy.width = this.width;
        copy.height = this.height;
        copy.palette = this.palette != null ? java.util.Arrays.copyOf(this.palette, this.palette.length) : null;
        copy.bitsPerIndex = this.bitsPerIndex;
        copy.packedIndices = this.packedIndices != null ? java.util.Arrays.copyOf(this.packedIndices, this.packedIndices.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MapImage other)) return false;
        return this.width == other.width && this.height == other.height && java.util.Arrays.equals(this.palette, other.palette) && this.bitsPerIndex == other.bitsPerIndex && java.util.Arrays.equals(this.packedIndices, other.packedIndices);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(width);
        result = 31 * result + Integer.hashCode(height);
        result = 31 * result + java.util.Arrays.hashCode(palette);
        result = 31 * result + Byte.hashCode(bitsPerIndex);
        result = 31 * result + java.util.Arrays.hashCode(packedIndices);
        return result;
    }

}