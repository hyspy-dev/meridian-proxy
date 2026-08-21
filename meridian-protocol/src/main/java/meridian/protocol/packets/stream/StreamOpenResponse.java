// Auto-generated - do not edit
package meridian.protocol.packets.stream;

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


public class StreamOpenResponse implements Packet, ToClientPacket {
    public static final int PACKET_ID = 461;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 3;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 3;
    public static final int MAX_SIZE = 16384008;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public StreamType type = StreamType.Game;
    public boolean accepted;
    @Nullable public String rejectionReason;

    public StreamOpenResponse() {
    }

    public StreamOpenResponse(@Nonnull StreamType type, boolean accepted, @Nullable String rejectionReason) {
        this.type = type;
        this.accepted = accepted;
        this.rejectionReason = rejectionReason;
    }

    public StreamOpenResponse(@Nonnull StreamOpenResponse other) {
        this.type = other.type;
        this.accepted = other.accepted;
        this.rejectionReason = other.rejectionReason;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("StreamOpenResponse", offset, (int) mem.byteSize());
        long needed = (long) offset + 3;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("StreamOpenResponse", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static StreamType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static StreamType getType(MemorySegment mem, int offset) {
        return StreamType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static boolean getAccepted(MemorySegment mem) {
        return getAccepted(mem, 0);
    }
    
    public static boolean getAccepted(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 2);
    }
    
    @Nullable
    public static String getRejectionReason(MemorySegment mem) {
        return getRejectionReason(mem, 0);
    }
    
    @Nullable
    public static String getRejectionReason(MemorySegment mem, int offset) {
        return hasRejectionReason(mem, offset) ? PacketIO.readVarString("RejectionReason", mem, offset + 3, 4096000): null;
    }
    
    public static boolean hasRejectionReason(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static StreamOpenResponse toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static StreamOpenResponse toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one StreamOpenResponse and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static StreamOpenResponse toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 3;
        var varPos = 0;
        String v2 = null;
        if (hasRejectionReason(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("RejectionReason", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new StreamOpenResponse(
            StreamType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            mem.get(PacketIO.PROTO_BOOL, offset + 2),
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.rejectionReason != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        mem.set(PacketIO.PROTO_BOOL, offset + 2, this.accepted);
        var varOffset = offset + 3;
        if (this.rejectionReason != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.rejectionReason, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 3;
        if (rejectionReason != null) size += PacketIO.stringSize(rejectionReason);

        return size;
    }

    public StreamOpenResponse clone() {
        StreamOpenResponse copy = new StreamOpenResponse();
        copy.type = this.type;
        copy.accepted = this.accepted;
        copy.rejectionReason = this.rejectionReason;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof StreamOpenResponse other)) return false;
        return java.util.Objects.equals(this.type, other.type) && this.accepted == other.accepted && java.util.Objects.equals(this.rejectionReason, other.rejectionReason);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(type, accepted, rejectionReason);
    }

}