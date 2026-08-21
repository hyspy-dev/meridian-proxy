// Auto-generated - do not edit
package meridian.protocol.packets.serveraccess;

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


public class RequestServerAccess implements Packet, ToClientPacket {
    public static final int PACKET_ID = 250;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 3;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 3;
    public static final int MAX_SIZE = 3;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public Access access = Access.Private;
    public short externalPort;

    public RequestServerAccess() {
    }

    public RequestServerAccess(@Nonnull Access access, short externalPort) {
        this.access = access;
        this.externalPort = externalPort;
    }

    public RequestServerAccess(@Nonnull RequestServerAccess other) {
        this.access = other.access;
        this.externalPort = other.externalPort;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("RequestServerAccess", offset, (int) mem.byteSize());
        long needed = (long) offset + 3;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("RequestServerAccess", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static Access getAccess(MemorySegment mem) {
        return getAccess(mem, 0);
    }
    
    public static Access getAccess(MemorySegment mem, int offset) {
        return Access.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0));
    }
    
    public static short getExternalPort(MemorySegment mem) {
        return getExternalPort(mem, 0);
    }
    
    public static short getExternalPort(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_SHORT, offset + 1);
    }
    
    
    
    
    
    public static RequestServerAccess toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static RequestServerAccess toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one RequestServerAccess and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static RequestServerAccess toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new RequestServerAccess(
            Access.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0)),
            mem.get(PacketIO.PROTO_SHORT, offset + 1)
        );
        if (cursor != null) cursor.position = offset + 3;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, (byte) this.access.getValue());
        mem.set(PacketIO.PROTO_SHORT, offset + 1, this.externalPort);
        
        
    
       return 3;
    }
    public int computeSize() {
        return 3;
    }

    public RequestServerAccess clone() {
        RequestServerAccess copy = new RequestServerAccess();
        copy.access = this.access;
        copy.externalPort = this.externalPort;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RequestServerAccess other)) return false;
        return java.util.Objects.equals(this.access, other.access) && this.externalPort == other.externalPort;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(access, externalPort);
    }

}