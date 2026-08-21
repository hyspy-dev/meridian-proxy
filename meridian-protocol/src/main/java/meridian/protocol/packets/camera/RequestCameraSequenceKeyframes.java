// Auto-generated - do not edit
package meridian.protocol.packets.camera;

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


public class RequestCameraSequenceKeyframes implements Packet, ToServerPacket {
    public static final int PACKET_ID = 287;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 9;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public byte sequenceId;
    public int fromIndex;
    public int count;

    public RequestCameraSequenceKeyframes() {
    }

    public RequestCameraSequenceKeyframes(byte sequenceId, int fromIndex, int count) {
        this.sequenceId = sequenceId;
        this.fromIndex = fromIndex;
        this.count = count;
    }

    public RequestCameraSequenceKeyframes(@Nonnull RequestCameraSequenceKeyframes other) {
        this.sequenceId = other.sequenceId;
        this.fromIndex = other.fromIndex;
        this.count = other.count;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("RequestCameraSequenceKeyframes", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("RequestCameraSequenceKeyframes", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static byte getSequenceId(MemorySegment mem) {
        return getSequenceId(mem, 0);
    }
    
    public static byte getSequenceId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 0);
    }
    
    public static int getFromIndex(MemorySegment mem) {
        return getFromIndex(mem, 0);
    }
    
    public static int getFromIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getCount(MemorySegment mem) {
        return getCount(mem, 0);
    }
    
    public static int getCount(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    
    
    
    
    public static RequestCameraSequenceKeyframes toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static RequestCameraSequenceKeyframes toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one RequestCameraSequenceKeyframes and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static RequestCameraSequenceKeyframes toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new RequestCameraSequenceKeyframes(
            mem.get(PacketIO.PROTO_BYTE, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5)
        );
        if (cursor != null) cursor.position = offset + 9;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, this.sequenceId);
        mem.set(PacketIO.PROTO_INT, offset + 1, this.fromIndex);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.count);
        
        
    
       return 9;
    }
    public int computeSize() {
        return 9;
    }

    public RequestCameraSequenceKeyframes clone() {
        RequestCameraSequenceKeyframes copy = new RequestCameraSequenceKeyframes();
        copy.sequenceId = this.sequenceId;
        copy.fromIndex = this.fromIndex;
        copy.count = this.count;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RequestCameraSequenceKeyframes other)) return false;
        return this.sequenceId == other.sequenceId && this.fromIndex == other.fromIndex && this.count == other.count;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(sequenceId, fromIndex, count);
    }

}