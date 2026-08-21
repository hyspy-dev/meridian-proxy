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


public class SetChunkHeightmap implements Packet, ToClientPacket {
    public static final int PACKET_ID = 132;
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
    @Nonnull public byte[] heightmap = new byte[0];

    public SetChunkHeightmap() {
    }

    public SetChunkHeightmap(int x, int z, @Nonnull byte[] heightmap) {
        this.x = x;
        this.z = z;
        this.heightmap = heightmap;
    }

    public SetChunkHeightmap(@Nonnull SetChunkHeightmap other) {
        this.x = other.x;
        this.z = other.z;
        this.heightmap = other.heightmap;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SetChunkHeightmap", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SetChunkHeightmap", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
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
    
    public static byte[] getHeightmap(MemorySegment mem) {
        return getHeightmap(mem, 0);
    }
    
    public static byte[] getHeightmap(MemorySegment mem, int offset) {
        var off = offset + 8;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Heightmap");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Heightmap", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Heightmap", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new byte[len];
        MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, data, 0, len);
        return data;
    }
    
    
    
    
    
    public static SetChunkHeightmap toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SetChunkHeightmap toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SetChunkHeightmap and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SetChunkHeightmap toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 8;
        var varPos = 0;
        byte[] v2;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Heightmap");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Heightmap", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Heightmap", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v2, 0, len);
            varPos = off + len - varBase;
        }
        var result = new SetChunkHeightmap(
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
        if (heightmap.length > 4096000) throw ProtocolException.arrayTooLong("Heightmap", heightmap.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.heightmap.length);
        
        MemorySegment.copy(this.heightmap, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.heightmap.length);
        varOffset += this.heightmap.length * 1;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 8;
        size += VarInt.size(heightmap.length) + heightmap.length * 1;

        return size;
    }

    public SetChunkHeightmap clone() {
        SetChunkHeightmap copy = new SetChunkHeightmap();
        copy.x = this.x;
        copy.z = this.z;
        copy.heightmap = java.util.Arrays.copyOf(this.heightmap, this.heightmap.length);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SetChunkHeightmap other)) return false;
        return this.x == other.x && this.z == other.z && java.util.Arrays.equals(this.heightmap, other.heightmap);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(x);
        result = 31 * result + Integer.hashCode(z);
        result = 31 * result + java.util.Arrays.hashCode(heightmap);
        return result;
    }

}