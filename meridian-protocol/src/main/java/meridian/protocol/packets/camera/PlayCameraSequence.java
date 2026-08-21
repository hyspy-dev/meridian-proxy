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


public class PlayCameraSequence implements Packet, ToClientPacket {
    public static final int PACKET_ID = 284;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 11;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 11;
    public static final int MAX_SIZE = 11;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public byte sequenceId;
    @Nonnull public byte flags;
    @Nullable public Float baseFov;
    public int totalKeyframes;

    public PlayCameraSequence() {
    }

    public PlayCameraSequence(byte sequenceId, @Nonnull byte flags, @Nullable Float baseFov, int totalKeyframes) {
        this.sequenceId = sequenceId;
        this.flags = flags;
        this.baseFov = baseFov;
        this.totalKeyframes = totalKeyframes;
    }

    public PlayCameraSequence(@Nonnull PlayCameraSequence other) {
        this.sequenceId = other.sequenceId;
        this.flags = other.flags;
        this.baseFov = other.baseFov;
        this.totalKeyframes = other.totalKeyframes;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PlayCameraSequence", offset, (int) mem.byteSize());
        long needed = (long) offset + 11;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PlayCameraSequence", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static byte getSequenceId(MemorySegment mem) {
        return getSequenceId(mem, 0);
    }
    
    public static byte getSequenceId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 1);
    }
    
    public static byte getFlags(MemorySegment mem) {
        return getFlags(mem, 0);
    }
    
    public static byte getFlags(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 2);
    }
    
    @Nullable
    public static Float getBaseFov(MemorySegment mem) {
        return getBaseFov(mem, 0);
    }
    
    @Nullable
    public static Float getBaseFov(MemorySegment mem, int offset) {
        return hasBaseFov(mem, offset) ? PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 3), "BaseFov"): null;
    }
    
    public static int getTotalKeyframes(MemorySegment mem) {
        return getTotalKeyframes(mem, 0);
    }
    
    public static int getTotalKeyframes(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 7);
    }
    
    public static boolean hasBaseFov(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static PlayCameraSequence toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PlayCameraSequence toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PlayCameraSequence and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PlayCameraSequence toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new PlayCameraSequence(
            mem.get(PacketIO.PROTO_BYTE, offset + 1),
            mem.get(PacketIO.PROTO_BYTE, offset + 2),
            hasBaseFov(mem, offset) ? PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 3), "BaseFov") : null,
            mem.get(PacketIO.PROTO_INT, offset + 7)
        );
        if (cursor != null) cursor.position = offset + 11;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.baseFov != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, this.sequenceId);
        mem.set(PacketIO.PROTO_BYTE, offset + 2, this.flags);
        if (this.baseFov != null) {
            PacketIO.requireFinite(this.baseFov, "BaseFov"); mem.set(PacketIO.PROTO_FLOAT, offset + 3, this.baseFov);
        } else {
            mem.asSlice(offset + 3, 4).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_INT, offset + 7, this.totalKeyframes);
        
        
    
       return 11;
    }
    public int computeSize() {
        return 11;
    }

    public PlayCameraSequence clone() {
        PlayCameraSequence copy = new PlayCameraSequence();
        copy.sequenceId = this.sequenceId;
        copy.flags = this.flags;
        copy.baseFov = this.baseFov;
        copy.totalKeyframes = this.totalKeyframes;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PlayCameraSequence other)) return false;
        return this.sequenceId == other.sequenceId && java.util.Objects.equals(this.flags, other.flags) && java.util.Objects.equals(this.baseFov, other.baseFov) && this.totalKeyframes == other.totalKeyframes;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(sequenceId, flags, baseFov, totalKeyframes);
    }

}