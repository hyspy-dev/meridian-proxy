// Auto-generated - do not edit
package meridian.protocol.packets.player;

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


public class ClientReady implements Packet, ToServerPacket {
    public static final int PACKET_ID = 105;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public boolean readyForChunks;
    public boolean readyForGameplay;

    public ClientReady() {
    }

    public ClientReady(boolean readyForChunks, boolean readyForGameplay) {
        this.readyForChunks = readyForChunks;
        this.readyForGameplay = readyForGameplay;
    }

    public ClientReady(@Nonnull ClientReady other) {
        this.readyForChunks = other.readyForChunks;
        this.readyForGameplay = other.readyForGameplay;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ClientReady", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ClientReady", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getReadyForChunks(MemorySegment mem) {
        return getReadyForChunks(mem, 0);
    }
    
    public static boolean getReadyForChunks(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x01) != 0;
    }
    
    public static boolean getReadyForGameplay(MemorySegment mem) {
        return getReadyForGameplay(mem, 0);
    }
    
    public static boolean getReadyForGameplay(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x02) != 0;
    }
    
    
    
    
    
    public static ClientReady toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ClientReady toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ClientReady and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ClientReady toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new ClientReady(
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x02) != 0
        );
        if (cursor != null) cursor.position = offset + 1;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        byte boolBits0_0 = 0;
        if (this.readyForChunks) boolBits0_0 |= 0x01;
        if (this.readyForGameplay) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0 + 0, boolBits0_0);
        
        
    
       return 1;
    }
    public int computeSize() {
        return 1;
    }

    public ClientReady clone() {
        ClientReady copy = new ClientReady();
        copy.readyForChunks = this.readyForChunks;
        copy.readyForGameplay = this.readyForGameplay;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ClientReady other)) return false;
        return this.readyForChunks == other.readyForChunks && this.readyForGameplay == other.readyForGameplay;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(readyForChunks, readyForGameplay);
    }

}