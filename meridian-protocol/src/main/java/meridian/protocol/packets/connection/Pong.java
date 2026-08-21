// Auto-generated - do not edit
package meridian.protocol.packets.connection;

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
import meridian.protocol.InstantData;

public class Pong implements Packet, ToServerPacket {
    public static final int PACKET_ID = 4;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 19;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 19;
    public static final int MAX_SIZE = 19;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int id;
    @Nonnull public InstantData time = new InstantData();
    @Nonnull public PongType type = PongType.Raw;
    public short packetQueueSize;

    public Pong() {
    }

    public Pong(int id, @Nonnull InstantData time, @Nonnull PongType type, short packetQueueSize) {
        this.id = id;
        this.time = time;
        this.type = type;
        this.packetQueueSize = packetQueueSize;
    }

    public Pong(@Nonnull Pong other) {
        this.id = other.id;
        this.time = other.time;
        this.type = other.type;
        this.packetQueueSize = other.packetQueueSize;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Pong", offset, (int) mem.byteSize());
        long needed = (long) offset + 19;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Pong", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    public static int getId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static InstantData getTime(MemorySegment mem) {
        return getTime(mem, 0);
    }
    
    public static InstantData getTime(MemorySegment mem, int offset) {
        return InstantData.toObject(mem, offset + 4);
    }
    
    public static PongType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static PongType getType(MemorySegment mem, int offset) {
        return PongType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 16));
    }
    
    public static short getPacketQueueSize(MemorySegment mem) {
        return getPacketQueueSize(mem, 0);
    }
    
    public static short getPacketQueueSize(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_SHORT, offset + 17);
    }
    
    
    
    
    
    public static Pong toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Pong toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Pong and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Pong toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new Pong(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            InstantData.toObject(mem, offset + 4),
            PongType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 16)),
            mem.get(PacketIO.PROTO_SHORT, offset + 17)
        );
        if (cursor != null) cursor.position = offset + 19;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.id);
        this.time.serialize(mem, offset + 4);
        mem.set(PacketIO.PROTO_BYTE, offset + 16, (byte) this.type.getValue());
        mem.set(PacketIO.PROTO_SHORT, offset + 17, this.packetQueueSize);
        
        
    
       return 19;
    }
    public int computeSize() {
        return 19;
    }

    public Pong clone() {
        Pong copy = new Pong();
        copy.id = this.id;
        copy.time = this.time.clone();
        copy.type = this.type;
        copy.packetQueueSize = this.packetQueueSize;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pong other)) return false;
        return this.id == other.id && java.util.Objects.equals(this.time, other.time) && java.util.Objects.equals(this.type, other.type) && this.packetQueueSize == other.packetQueueSize;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, time, type, packetQueueSize);
    }

}