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


public class ClientDisconnect implements Packet, ToServerPacket {
    public static final int PACKET_ID = 1;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 2;
    public static final int MAX_SIZE = 2;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public ClientDisconnectReason reason = ClientDisconnectReason.PlayerLeave;
    @Nonnull public DisconnectType type = DisconnectType.Disconnect;

    public ClientDisconnect() {
    }

    public ClientDisconnect(@Nonnull ClientDisconnectReason reason, @Nonnull DisconnectType type) {
        this.reason = reason;
        this.type = type;
    }

    public ClientDisconnect(@Nonnull ClientDisconnect other) {
        this.reason = other.reason;
        this.type = other.type;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ClientDisconnect", offset, (int) mem.byteSize());
        long needed = (long) offset + 2;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ClientDisconnect", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static ClientDisconnectReason getReason(MemorySegment mem) {
        return getReason(mem, 0);
    }
    
    public static ClientDisconnectReason getReason(MemorySegment mem, int offset) {
        return ClientDisconnectReason.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0));
    }
    
    public static DisconnectType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static DisconnectType getType(MemorySegment mem, int offset) {
        return DisconnectType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    
    
    
    
    public static ClientDisconnect toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ClientDisconnect toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ClientDisconnect and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ClientDisconnect toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new ClientDisconnect(
            ClientDisconnectReason.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0)),
            DisconnectType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1))
        );
        if (cursor != null) cursor.position = offset + 2;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, (byte) this.reason.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        
        
    
       return 2;
    }
    public int computeSize() {
        return 2;
    }

    public ClientDisconnect clone() {
        ClientDisconnect copy = new ClientDisconnect();
        copy.reason = this.reason;
        copy.type = this.type;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ClientDisconnect other)) return false;
        return java.util.Objects.equals(this.reason, other.reason) && java.util.Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(reason, type);
    }

}