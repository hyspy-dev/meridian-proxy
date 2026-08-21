// Auto-generated - do not edit
package meridian.protocol.packets.world;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.NetworkChannel;
import meridian.protocol.Packet;
import meridian.protocol.ToServerPacket;
import meridian.protocol.ToClientPacket;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class UnloadChunks implements Packet, ToClientPacket {
    public static final int PACKET_ID = 182;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 81939;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Chunks;
    }

    @Nullable public int[] sections;
    @Nullable public int[] columns;

    public UnloadChunks() {
    }

    public UnloadChunks(@Nullable int[] sections, @Nullable int[] columns) {
        this.sections = sections;
        this.columns = columns;
    }

    public UnloadChunks(@Nonnull UnloadChunks other) {
        this.sections = other.sections;
        this.columns = other.columns;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UnloadChunks", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UnloadChunks", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static int[] getSections(MemorySegment mem) {
        return getSections(mem, 0);
    }
    
    @Nullable
    public static int[] getSections(MemorySegment mem, int offset) {
        if (!hasSections(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 1, 9, "Sections");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Sections");
        var len = (int) packed;
        if (len > 12288) throw ProtocolException.arrayTooLong("Sections", len, 12288);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Sections", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    @Nullable
    public static int[] getColumns(MemorySegment mem) {
        return getColumns(mem, 0);
    }
    
    @Nullable
    public static int[] getColumns(MemorySegment mem, int offset) {
        if (!hasColumns(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 5, 9, "Columns");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Columns");
        var len = (int) packed;
        if (len > 8192) throw ProtocolException.arrayTooLong("Columns", len, 8192);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Columns", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    public static boolean hasSections(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasColumns(MemorySegment mem, int offset) {
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
    
    public static UnloadChunks toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UnloadChunks toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UnloadChunks and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UnloadChunks toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        int[] v0 = null;
        if (hasSections(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "Sections");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Sections");
            var len = (int) packed;
            if (len > 12288) throw ProtocolException.arrayTooLong("Sections", len, 12288);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Sections", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v0, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 1, -1, "Sections");
        }
        
        int[] v1 = null;
        if (hasColumns(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Columns");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Columns");
            var len = (int) packed;
            if (len > 8192) throw ProtocolException.arrayTooLong("Columns", len, 8192);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Columns", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v1, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "Columns");
        }
        var result = new UnloadChunks(
            v0,
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.sections != null) nullBits |= 0x01;
        if (this.columns != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 9;
        if (this.sections != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 9);
            if (sections.length > 12288) throw ProtocolException.arrayTooLong("Sections", sections.length, 12288);
            varOffset += VarInt.set(mem, varOffset, this.sections.length);
            
            MemorySegment.copy(this.sections, 0, mem, PacketIO.PROTO_INT, varOffset, this.sections.length);
            varOffset += this.sections.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.columns != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 9);
            if (columns.length > 8192) throw ProtocolException.arrayTooLong("Columns", columns.length, 8192);
            varOffset += VarInt.set(mem, varOffset, this.columns.length);
            
            MemorySegment.copy(this.columns, 0, mem, PacketIO.PROTO_INT, varOffset, this.columns.length);
            varOffset += this.columns.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (sections != null) size += VarInt.size(sections.length) + sections.length * 4;
    if (columns != null) size += VarInt.size(columns.length) + columns.length * 4;

        return size;
    }

    public UnloadChunks clone() {
        UnloadChunks copy = new UnloadChunks();
        copy.sections = this.sections != null ? java.util.Arrays.copyOf(this.sections, this.sections.length) : null;
        copy.columns = this.columns != null ? java.util.Arrays.copyOf(this.columns, this.columns.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UnloadChunks other)) return false;
        return java.util.Arrays.equals(this.sections, other.sections) && java.util.Arrays.equals(this.columns, other.columns);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(sections);
        result = 31 * result + java.util.Arrays.hashCode(columns);
        return result;
    }

}