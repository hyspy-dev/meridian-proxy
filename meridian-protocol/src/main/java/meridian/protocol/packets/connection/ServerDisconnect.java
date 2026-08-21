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
import meridian.protocol.FormattedMessage;

public class ServerDisconnect implements Packet, ToClientPacket {
    public static final int PACKET_ID = 2;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 2;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public FormattedMessage reason;
    @Nonnull public DisconnectType type = DisconnectType.Disconnect;

    public ServerDisconnect() {
    }

    public ServerDisconnect(@Nullable FormattedMessage reason, @Nonnull DisconnectType type) {
        this.reason = reason;
        this.type = type;
    }

    public ServerDisconnect(@Nonnull ServerDisconnect other) {
        this.reason = other.reason;
        this.type = other.type;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ServerDisconnect", offset, (int) mem.byteSize());
        long needed = (long) offset + 2;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ServerDisconnect", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static FormattedMessage getReason(MemorySegment mem) {
        return getReason(mem, 0);
    }
    
    @Nullable
    public static FormattedMessage getReason(MemorySegment mem, int offset) {
        return hasReason(mem, offset) ? FormattedMessage.toObject(mem, offset + 2): null;
    }
    
    public static DisconnectType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static DisconnectType getType(MemorySegment mem, int offset) {
        return DisconnectType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static boolean hasReason(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static ServerDisconnect toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ServerDisconnect toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ServerDisconnect and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ServerDisconnect toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 2;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        FormattedMessage v0 = null;
        if (hasReason(mem, offset)) {
            v0 = FormattedMessage.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new ServerDisconnect(
            v0,
            DisconnectType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1))
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.reason != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        var varOffset = offset + 2;
        if (this.reason != null) {
            
            varOffset += this.reason.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 2;
        if (reason != null) size += reason.computeSize();

        return size;
    }

    public ServerDisconnect clone() {
        ServerDisconnect copy = new ServerDisconnect();
        copy.reason = this.reason != null ? this.reason.clone() : null;
        copy.type = this.type;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ServerDisconnect other)) return false;
        return java.util.Objects.equals(this.reason, other.reason) && java.util.Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(reason, type);
    }

}