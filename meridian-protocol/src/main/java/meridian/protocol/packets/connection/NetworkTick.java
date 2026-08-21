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


public class NetworkTick implements Packet, ToClientPacket {
    public static final int PACKET_ID = 5;
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
        return NetworkChannel.Default;
    }

    public int tickDurationMicros;
    public int serverTick;

    public NetworkTick() {
    }

    public NetworkTick(int tickDurationMicros, int serverTick) {
        this.tickDurationMicros = tickDurationMicros;
        this.serverTick = serverTick;
    }

    public NetworkTick(@Nonnull NetworkTick other) {
        this.tickDurationMicros = other.tickDurationMicros;
        this.serverTick = other.serverTick;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("NetworkTick", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("NetworkTick", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getTickDurationMicros(MemorySegment mem) {
        return getTickDurationMicros(mem, 0);
    }
    
    public static int getTickDurationMicros(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static int getServerTick(MemorySegment mem) {
        return getServerTick(mem, 0);
    }
    
    public static int getServerTick(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 4);
    }
    
    
    
    
    
    public static NetworkTick toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static NetworkTick toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one NetworkTick and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static NetworkTick toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new NetworkTick(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4)
        );
        if (cursor != null) cursor.position = offset + 8;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.tickDurationMicros);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.serverTick);
        
        
    
       return 8;
    }
    public int computeSize() {
        return 8;
    }

    public NetworkTick clone() {
        NetworkTick copy = new NetworkTick();
        copy.tickDurationMicros = this.tickDurationMicros;
        copy.serverTick = this.serverTick;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof NetworkTick other)) return false;
        return this.tickDurationMicros == other.tickDurationMicros && this.serverTick == other.serverTick;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(tickDurationMicros, serverTick);
    }

}