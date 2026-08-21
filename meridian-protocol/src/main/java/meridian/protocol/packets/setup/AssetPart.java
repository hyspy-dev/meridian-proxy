// Auto-generated - do not edit
package meridian.protocol.packets.setup;

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


public class AssetPart implements Packet, ToClientPacket {
    public static final int PACKET_ID = 25;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 4096006;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public byte[] part;

    public AssetPart() {
    }

    public AssetPart(@Nullable byte[] part) {
        this.part = part;
    }

    public AssetPart(@Nonnull AssetPart other) {
        this.part = other.part;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetPart", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetPart", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static byte[] getPart(MemorySegment mem) {
        return getPart(mem, 0);
    }
    
    @Nullable
    public static byte[] getPart(MemorySegment mem, int offset) {
        if (!hasPart(mem, offset)) return null;
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Part");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Part", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Part", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new byte[len];
        MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, data, 0, len);
        return data;
    }
    
    public static boolean hasPart(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static AssetPart toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetPart toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetPart and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetPart toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        byte[] v0 = null;
        if (hasPart(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Part");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Part", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Part", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v0, 0, len);
            varPos = off + len - varBase;
        }
        var result = new AssetPart(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.part != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.part != null) {
            
            if (part.length > 4096000) throw ProtocolException.arrayTooLong("Part", part.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.part.length);
            
            MemorySegment.copy(this.part, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.part.length);
            varOffset += this.part.length * 1;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (part != null) size += VarInt.size(part.length) + part.length * 1;

        return size;
    }

    public AssetPart clone() {
        AssetPart copy = new AssetPart();
        copy.part = this.part != null ? java.util.Arrays.copyOf(this.part, this.part.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetPart other)) return false;
        return java.util.Arrays.equals(this.part, other.part);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(part);
        return result;
    }

}