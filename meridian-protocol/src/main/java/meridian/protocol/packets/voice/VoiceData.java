// Auto-generated - do not edit
package meridian.protocol.packets.voice;

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


public class VoiceData implements Packet, ToServerPacket {
    public static final int PACKET_ID = 450;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 6;
    public static final int MAX_SIZE = 523;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Voice;
    }

    public short sequenceNumber;
    public int timestamp;
    @Nonnull public byte[] opusData = new byte[0];

    public VoiceData() {
    }

    public VoiceData(short sequenceNumber, int timestamp, @Nonnull byte[] opusData) {
        this.sequenceNumber = sequenceNumber;
        this.timestamp = timestamp;
        this.opusData = opusData;
    }

    public VoiceData(@Nonnull VoiceData other) {
        this.sequenceNumber = other.sequenceNumber;
        this.timestamp = other.timestamp;
        this.opusData = other.opusData;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("VoiceData", offset, (int) mem.byteSize());
        long needed = (long) offset + 6;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("VoiceData", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static short getSequenceNumber(MemorySegment mem) {
        return getSequenceNumber(mem, 0);
    }
    
    public static short getSequenceNumber(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_SHORT, offset + 0);
    }
    
    public static int getTimestamp(MemorySegment mem) {
        return getTimestamp(mem, 0);
    }
    
    public static int getTimestamp(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 2);
    }
    
    public static byte[] getOpusData(MemorySegment mem) {
        return getOpusData(mem, 0);
    }
    
    public static byte[] getOpusData(MemorySegment mem, int offset) {
        var off = offset + 6;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("OpusData");
        var len = (int) packed;
        if (len > 512) throw ProtocolException.arrayTooLong("OpusData", len, 512);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("OpusData", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new byte[len];
        MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, data, 0, len);
        return data;
    }
    
    
    
    
    
    public static VoiceData toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static VoiceData toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one VoiceData and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static VoiceData toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 6;
        var varPos = 0;
        byte[] v2;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("OpusData");
            var len = (int) packed;
            if (len > 512) throw ProtocolException.arrayTooLong("OpusData", len, 512);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("OpusData", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v2, 0, len);
            varPos = off + len - varBase;
        }
        var result = new VoiceData(
            mem.get(PacketIO.PROTO_SHORT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 2),
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_SHORT, offset + 0, this.sequenceNumber);
        mem.set(PacketIO.PROTO_INT, offset + 2, this.timestamp);
        var varOffset = offset + 6;
        if (opusData.length > 512) throw ProtocolException.arrayTooLong("OpusData", opusData.length, 512);
        varOffset += VarInt.set(mem, varOffset, this.opusData.length);
        
        MemorySegment.copy(this.opusData, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.opusData.length);
        varOffset += this.opusData.length * 1;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 6;
        size += VarInt.size(opusData.length) + opusData.length * 1;

        return size;
    }

    public VoiceData clone() {
        VoiceData copy = new VoiceData();
        copy.sequenceNumber = this.sequenceNumber;
        copy.timestamp = this.timestamp;
        copy.opusData = java.util.Arrays.copyOf(this.opusData, this.opusData.length);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof VoiceData other)) return false;
        return this.sequenceNumber == other.sequenceNumber && this.timestamp == other.timestamp && java.util.Arrays.equals(this.opusData, other.opusData);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Short.hashCode(sequenceNumber);
        result = 31 * result + Integer.hashCode(timestamp);
        result = 31 * result + java.util.Arrays.hashCode(opusData);
        return result;
    }

}