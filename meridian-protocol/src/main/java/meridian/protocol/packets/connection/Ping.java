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

public class Ping implements Packet, ToClientPacket {
    public static final int PACKET_ID = 3;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 28;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 28;
    public static final int MAX_SIZE = 28;

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
    public int lastPingValueRaw;
    public int lastPingValueDirect;
    public int lastPingValueTick;

    public Ping() {
    }

    public Ping(int id, @Nonnull InstantData time, int lastPingValueRaw, int lastPingValueDirect, int lastPingValueTick) {
        this.id = id;
        this.time = time;
        this.lastPingValueRaw = lastPingValueRaw;
        this.lastPingValueDirect = lastPingValueDirect;
        this.lastPingValueTick = lastPingValueTick;
    }

    public Ping(@Nonnull Ping other) {
        this.id = other.id;
        this.time = other.time;
        this.lastPingValueRaw = other.lastPingValueRaw;
        this.lastPingValueDirect = other.lastPingValueDirect;
        this.lastPingValueTick = other.lastPingValueTick;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Ping", offset, (int) mem.byteSize());
        long needed = (long) offset + 28;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Ping", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
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
    
    public static int getLastPingValueRaw(MemorySegment mem) {
        return getLastPingValueRaw(mem, 0);
    }
    
    public static int getLastPingValueRaw(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 16);
    }
    
    public static int getLastPingValueDirect(MemorySegment mem) {
        return getLastPingValueDirect(mem, 0);
    }
    
    public static int getLastPingValueDirect(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 20);
    }
    
    public static int getLastPingValueTick(MemorySegment mem) {
        return getLastPingValueTick(mem, 0);
    }
    
    public static int getLastPingValueTick(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 24);
    }
    
    
    
    
    
    public static Ping toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Ping toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Ping and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Ping toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new Ping(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            InstantData.toObject(mem, offset + 4),
            mem.get(PacketIO.PROTO_INT, offset + 16),
            mem.get(PacketIO.PROTO_INT, offset + 20),
            mem.get(PacketIO.PROTO_INT, offset + 24)
        );
        if (cursor != null) cursor.position = offset + 28;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.id);
        this.time.serialize(mem, offset + 4);
        mem.set(PacketIO.PROTO_INT, offset + 16, this.lastPingValueRaw);
        mem.set(PacketIO.PROTO_INT, offset + 20, this.lastPingValueDirect);
        mem.set(PacketIO.PROTO_INT, offset + 24, this.lastPingValueTick);
        
        
    
       return 28;
    }
    public int computeSize() {
        return 28;
    }

    public Ping clone() {
        Ping copy = new Ping();
        copy.id = this.id;
        copy.time = this.time.clone();
        copy.lastPingValueRaw = this.lastPingValueRaw;
        copy.lastPingValueDirect = this.lastPingValueDirect;
        copy.lastPingValueTick = this.lastPingValueTick;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Ping other)) return false;
        return this.id == other.id && java.util.Objects.equals(this.time, other.time) && this.lastPingValueRaw == other.lastPingValueRaw && this.lastPingValueDirect == other.lastPingValueDirect && this.lastPingValueTick == other.lastPingValueTick;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, time, lastPingValueRaw, lastPingValueDirect, lastPingValueTick);
    }

}