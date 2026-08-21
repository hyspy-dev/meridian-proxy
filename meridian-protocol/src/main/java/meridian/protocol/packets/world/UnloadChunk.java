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


public class UnloadChunk implements Packet, ToClientPacket {
    public static final int PACKET_ID = 135;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 8;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 8;
    public static final int MAX_SIZE = 8;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Chunks;
    }

    public int chunkX;
    public int chunkZ;

    public UnloadChunk() {
    }

    public UnloadChunk(int chunkX, int chunkZ) {
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
    }

    public UnloadChunk(@Nonnull UnloadChunk other) {
        this.chunkX = other.chunkX;
        this.chunkZ = other.chunkZ;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UnloadChunk", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UnloadChunk", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getChunkX(MemorySegment mem) {
        return getChunkX(mem, 0);
    }
    
    public static int getChunkX(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static int getChunkZ(MemorySegment mem) {
        return getChunkZ(mem, 0);
    }
    
    public static int getChunkZ(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 4);
    }
    
    
    
    
    
    public static UnloadChunk toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UnloadChunk toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UnloadChunk and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UnloadChunk toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new UnloadChunk(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4)
        );
        if (cursor != null) cursor.position = offset + 8;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.chunkX);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.chunkZ);
        
        
    
       return 8;
    }
    public int computeSize() {
        return 8;
    }

    public UnloadChunk clone() {
        UnloadChunk copy = new UnloadChunk();
        copy.chunkX = this.chunkX;
        copy.chunkZ = this.chunkZ;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UnloadChunk other)) return false;
        return this.chunkX == other.chunkX && this.chunkZ == other.chunkZ;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(chunkX, chunkZ);
    }

}