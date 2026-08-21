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
import meridian.protocol.CameraKeyframe;

public class CameraSequenceKeyframes implements Packet, ToClientPacket {
    public static final int PACKET_ID = 285;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 5;
    public static final int MAX_SIZE = 12042;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public byte sequenceId;
    public int startIndex;
    @Nonnull public CameraKeyframe[] keyframes = new CameraKeyframe[0];

    public CameraSequenceKeyframes() {
    }

    public CameraSequenceKeyframes(byte sequenceId, int startIndex, @Nonnull CameraKeyframe[] keyframes) {
        this.sequenceId = sequenceId;
        this.startIndex = startIndex;
        this.keyframes = keyframes;
    }

    public CameraSequenceKeyframes(@Nonnull CameraSequenceKeyframes other) {
        this.sequenceId = other.sequenceId;
        this.startIndex = other.startIndex;
        this.keyframes = other.keyframes;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CameraSequenceKeyframes", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CameraSequenceKeyframes", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static byte getSequenceId(MemorySegment mem) {
        return getSequenceId(mem, 0);
    }
    
    public static byte getSequenceId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 0);
    }
    
    public static int getStartIndex(MemorySegment mem) {
        return getStartIndex(mem, 0);
    }
    
    public static int getStartIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static CameraKeyframe[] getKeyframes(MemorySegment mem) {
        return getKeyframes(mem, 0);
    }
    
    public static CameraKeyframe[] getKeyframes(MemorySegment mem, int offset) {
        var off = offset + 5;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Keyframes");
        var len = (int) packed;
        if (len > 128) throw ProtocolException.arrayTooLong("Keyframes", len, 128);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 94 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Keyframes", (int) java.lang.Math.min(off + lenOffset + (long) len * 94, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new CameraKeyframe[len];
        for (var i = 0; i < len; i++) {
            data[i] = CameraKeyframe.toObject(mem, off + i * 94);
        }
        return data;
    }
    
    
    
    
    
    public static CameraSequenceKeyframes toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CameraSequenceKeyframes toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CameraSequenceKeyframes and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CameraSequenceKeyframes toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 5;
        var varPos = 0;
        CameraKeyframe[] v2;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Keyframes");
            var len = (int) packed;
            if (len > 128) throw ProtocolException.arrayTooLong("Keyframes", len, 128);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 94 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Keyframes", (int) java.lang.Math.min(off + lenOffset + (long) len * 94, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new CameraKeyframe[len];
            for (var i = 0; i < len; i++) {
                v2[i] = CameraKeyframe.toObject(mem, off + i * 94);
            }
            varPos = off + len * 94 - varBase;
        }
        var result = new CameraSequenceKeyframes(
            mem.get(PacketIO.PROTO_BYTE, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, this.sequenceId);
        mem.set(PacketIO.PROTO_INT, offset + 1, this.startIndex);
        var varOffset = offset + 5;
        if (keyframes.length > 128) throw ProtocolException.arrayTooLong("Keyframes", keyframes.length, 128);
        varOffset += VarInt.set(mem, varOffset, this.keyframes.length);
        
        var keyframesValueOffset = 0;
        for (var i = 0; i < this.keyframes.length; i++) {
            keyframesValueOffset += this.keyframes[i].serialize(mem, varOffset + keyframesValueOffset);
        }
        varOffset += keyframesValueOffset;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 5;
        size += VarInt.size(keyframes.length) + keyframes.length * 94;

        return size;
    }

    public CameraSequenceKeyframes clone() {
        CameraSequenceKeyframes copy = new CameraSequenceKeyframes();
        copy.sequenceId = this.sequenceId;
        copy.startIndex = this.startIndex;
        copy.keyframes = java.util.Arrays.stream(this.keyframes).map(e -> e.clone()).toArray(CameraKeyframe[]::new);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CameraSequenceKeyframes other)) return false;
        return this.sequenceId == other.sequenceId && this.startIndex == other.startIndex && java.util.Arrays.equals(this.keyframes, other.keyframes);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Byte.hashCode(sequenceId);
        result = 31 * result + Integer.hashCode(startIndex);
        result = 31 * result + java.util.Arrays.hashCode(keyframes);
        return result;
    }

}