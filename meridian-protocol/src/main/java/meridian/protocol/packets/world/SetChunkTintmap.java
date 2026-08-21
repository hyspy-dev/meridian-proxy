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


public class SetChunkTintmap implements Packet, ToClientPacket {
    public static final int PACKET_ID = 133;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 8;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 8;
    public static final int MAX_SIZE = 4096013;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Chunks;
    }

    public int x;
    public int z;
    @Nonnull public byte[] tintmap = new byte[0];

    public SetChunkTintmap() {
    }

    public SetChunkTintmap(int x, int z, @Nonnull byte[] tintmap) {
        this.x = x;
        this.z = z;
        this.tintmap = tintmap;
    }

    public SetChunkTintmap(@Nonnull SetChunkTintmap other) {
        this.x = other.x;
        this.z = other.z;
        this.tintmap = other.tintmap;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SetChunkTintmap", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SetChunkTintmap", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getX(MemorySegment mem) {
        return getX(mem, 0);
    }
    
    public static int getX(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static int getZ(MemorySegment mem) {
        return getZ(mem, 0);
    }
    
    public static int getZ(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 4);
    }
    
    public static byte[] getTintmap(MemorySegment mem) {
        return getTintmap(mem, 0);
    }
    
    public static byte[] getTintmap(MemorySegment mem, int offset) {
        var off = offset + 8;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Tintmap");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Tintmap", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Tintmap", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new byte[len];
        MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, data, 0, len);
        return data;
    }
    
    
    
    
    
    public static SetChunkTintmap toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SetChunkTintmap toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SetChunkTintmap and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SetChunkTintmap toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 8;
        var varPos = 0;
        byte[] v2;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Tintmap");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Tintmap", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Tintmap", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v2, 0, len);
            varPos = off + len - varBase;
        }
        var result = new SetChunkTintmap(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4),
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.x);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.z);
        var varOffset = offset + 8;
        if (tintmap.length > 4096000) throw ProtocolException.arrayTooLong("Tintmap", tintmap.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.tintmap.length);
        
        MemorySegment.copy(this.tintmap, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.tintmap.length);
        varOffset += this.tintmap.length * 1;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 8;
        size += VarInt.size(tintmap.length) + tintmap.length * 1;

        return size;
    }

    public SetChunkTintmap clone() {
        SetChunkTintmap copy = new SetChunkTintmap();
        copy.x = this.x;
        copy.z = this.z;
        copy.tintmap = java.util.Arrays.copyOf(this.tintmap, this.tintmap.length);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SetChunkTintmap other)) return false;
        return this.x == other.x && this.z == other.z && java.util.Arrays.equals(this.tintmap, other.tintmap);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(x);
        result = 31 * result + Integer.hashCode(z);
        result = 31 * result + java.util.Arrays.hashCode(tintmap);
        return result;
    }

}