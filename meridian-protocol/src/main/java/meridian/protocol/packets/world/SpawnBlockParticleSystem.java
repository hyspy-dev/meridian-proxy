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
import meridian.protocol.BlockParticleEvent;
import meridian.protocol.Position;

public class SpawnBlockParticleSystem implements Packet, ToClientPacket {
    public static final int PACKET_ID = 153;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 30;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 30;
    public static final int MAX_SIZE = 30;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int blockId;
    @Nonnull public BlockParticleEvent particleType = BlockParticleEvent.Walk;
    @Nullable public Position position;

    public SpawnBlockParticleSystem() {
    }

    public SpawnBlockParticleSystem(int blockId, @Nonnull BlockParticleEvent particleType, @Nullable Position position) {
        this.blockId = blockId;
        this.particleType = particleType;
        this.position = position;
    }

    public SpawnBlockParticleSystem(@Nonnull SpawnBlockParticleSystem other) {
        this.blockId = other.blockId;
        this.particleType = other.particleType;
        this.position = other.position;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SpawnBlockParticleSystem", offset, (int) mem.byteSize());
        long needed = (long) offset + 30;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SpawnBlockParticleSystem", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getBlockId(MemorySegment mem) {
        return getBlockId(mem, 0);
    }
    
    public static int getBlockId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static BlockParticleEvent getParticleType(MemorySegment mem) {
        return getParticleType(mem, 0);
    }
    
    public static BlockParticleEvent getParticleType(MemorySegment mem, int offset) {
        return BlockParticleEvent.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 5));
    }
    
    @Nullable
    public static Position getPosition(MemorySegment mem) {
        return getPosition(mem, 0);
    }
    
    @Nullable
    public static Position getPosition(MemorySegment mem, int offset) {
        return hasPosition(mem, offset) ? Position.toObject(mem, offset + 6): null;
    }
    
    public static boolean hasPosition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static SpawnBlockParticleSystem toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SpawnBlockParticleSystem toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SpawnBlockParticleSystem and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SpawnBlockParticleSystem toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new SpawnBlockParticleSystem(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            BlockParticleEvent.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 5)),
            hasPosition(mem, offset) ? Position.toObject(mem, offset + 6) : null
        );
        if (cursor != null) cursor.position = offset + 30;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.position != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.blockId);
        mem.set(PacketIO.PROTO_BYTE, offset + 5, (byte) this.particleType.getValue());
        if (this.position != null) {
            this.position.serialize(mem, offset + 6);
        } else {
            mem.asSlice(offset + 6, 24).fill((byte) 0); 
        }
        
        
    
       return 30;
    }
    public int computeSize() {
        return 30;
    }

    public SpawnBlockParticleSystem clone() {
        SpawnBlockParticleSystem copy = new SpawnBlockParticleSystem();
        copy.blockId = this.blockId;
        copy.particleType = this.particleType;
        copy.position = this.position != null ? this.position.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SpawnBlockParticleSystem other)) return false;
        return this.blockId == other.blockId && java.util.Objects.equals(this.particleType, other.particleType) && java.util.Objects.equals(this.position, other.position);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(blockId, particleType, position);
    }

}