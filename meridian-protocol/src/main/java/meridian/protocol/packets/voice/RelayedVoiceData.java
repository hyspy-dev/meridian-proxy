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
import meridian.protocol.Position;
import java.util.UUID;

public class RelayedVoiceData implements Packet, ToClientPacket {
    public static final int PACKET_ID = 451;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 52;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 52;
    public static final int MAX_SIZE = 569;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Voice;
    }

    @Nonnull public java.util.UUID speakerId = new java.util.UUID(0L, 0L);
    public int entityId;
    public short sequenceNumber;
    public int timestamp;
    @Nullable public Position speakerPosition;
    public boolean speakerIsUnderwater;
    @Nonnull public byte[] opusData = new byte[0];

    public RelayedVoiceData() {
    }

    public RelayedVoiceData(@Nonnull java.util.UUID speakerId, int entityId, short sequenceNumber, int timestamp, @Nullable Position speakerPosition, boolean speakerIsUnderwater, @Nonnull byte[] opusData) {
        this.speakerId = speakerId;
        this.entityId = entityId;
        this.sequenceNumber = sequenceNumber;
        this.timestamp = timestamp;
        this.speakerPosition = speakerPosition;
        this.speakerIsUnderwater = speakerIsUnderwater;
        this.opusData = opusData;
    }

    public RelayedVoiceData(@Nonnull RelayedVoiceData other) {
        this.speakerId = other.speakerId;
        this.entityId = other.entityId;
        this.sequenceNumber = other.sequenceNumber;
        this.timestamp = other.timestamp;
        this.speakerPosition = other.speakerPosition;
        this.speakerIsUnderwater = other.speakerIsUnderwater;
        this.opusData = other.opusData;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("RelayedVoiceData", offset, (int) mem.byteSize());
        long needed = (long) offset + 52;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("RelayedVoiceData", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static java.util.UUID getSpeakerId(MemorySegment mem) {
        return getSpeakerId(mem, 0);
    }
    
    public static java.util.UUID getSpeakerId(MemorySegment mem, int offset) {
        return PacketIO.readUUID(mem, offset + 1);
    }
    
    public static int getEntityId(MemorySegment mem) {
        return getEntityId(mem, 0);
    }
    
    public static int getEntityId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 17);
    }
    
    public static short getSequenceNumber(MemorySegment mem) {
        return getSequenceNumber(mem, 0);
    }
    
    public static short getSequenceNumber(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_SHORT, offset + 21);
    }
    
    public static int getTimestamp(MemorySegment mem) {
        return getTimestamp(mem, 0);
    }
    
    public static int getTimestamp(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 23);
    }
    
    @Nullable
    public static Position getSpeakerPosition(MemorySegment mem) {
        return getSpeakerPosition(mem, 0);
    }
    
    @Nullable
    public static Position getSpeakerPosition(MemorySegment mem, int offset) {
        return hasSpeakerPosition(mem, offset) ? Position.toObject(mem, offset + 27): null;
    }
    
    public static boolean getSpeakerIsUnderwater(MemorySegment mem) {
        return getSpeakerIsUnderwater(mem, 0);
    }
    
    public static boolean getSpeakerIsUnderwater(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 51);
    }
    
    public static byte[] getOpusData(MemorySegment mem) {
        return getOpusData(mem, 0);
    }
    
    public static byte[] getOpusData(MemorySegment mem, int offset) {
        var off = offset + 52;
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
    
    public static boolean hasSpeakerPosition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static RelayedVoiceData toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static RelayedVoiceData toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one RelayedVoiceData and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static RelayedVoiceData toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 52;
        var varPos = 0;
        byte[] v6;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("OpusData");
            var len = (int) packed;
            if (len > 512) throw ProtocolException.arrayTooLong("OpusData", len, 512);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("OpusData", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v6 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v6, 0, len);
            varPos = off + len - varBase;
        }
        var result = new RelayedVoiceData(
            PacketIO.readUUID(mem, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 17),
            mem.get(PacketIO.PROTO_SHORT, offset + 21),
            mem.get(PacketIO.PROTO_INT, offset + 23),
            hasSpeakerPosition(mem, offset) ? Position.toObject(mem, offset + 27) : null,
            mem.get(PacketIO.PROTO_BOOL, offset + 51),
            v6
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.speakerPosition != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.writeUUID(mem, offset + 1, this.speakerId);
        mem.set(PacketIO.PROTO_INT, offset + 17, this.entityId);
        mem.set(PacketIO.PROTO_SHORT, offset + 21, this.sequenceNumber);
        mem.set(PacketIO.PROTO_INT, offset + 23, this.timestamp);
        if (this.speakerPosition != null) {
            this.speakerPosition.serialize(mem, offset + 27);
        } else {
            mem.asSlice(offset + 27, 24).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BOOL, offset + 51, this.speakerIsUnderwater);
        var varOffset = offset + 52;
        if (opusData.length > 512) throw ProtocolException.arrayTooLong("OpusData", opusData.length, 512);
        varOffset += VarInt.set(mem, varOffset, this.opusData.length);
        
        MemorySegment.copy(this.opusData, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.opusData.length);
        varOffset += this.opusData.length * 1;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 52;
        size += VarInt.size(opusData.length) + opusData.length * 1;

        return size;
    }

    public RelayedVoiceData clone() {
        RelayedVoiceData copy = new RelayedVoiceData();
        copy.speakerId = this.speakerId;
        copy.entityId = this.entityId;
        copy.sequenceNumber = this.sequenceNumber;
        copy.timestamp = this.timestamp;
        copy.speakerPosition = this.speakerPosition != null ? this.speakerPosition.clone() : null;
        copy.speakerIsUnderwater = this.speakerIsUnderwater;
        copy.opusData = java.util.Arrays.copyOf(this.opusData, this.opusData.length);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RelayedVoiceData other)) return false;
        return java.util.Objects.equals(this.speakerId, other.speakerId) && this.entityId == other.entityId && this.sequenceNumber == other.sequenceNumber && this.timestamp == other.timestamp && java.util.Objects.equals(this.speakerPosition, other.speakerPosition) && this.speakerIsUnderwater == other.speakerIsUnderwater && java.util.Arrays.equals(this.opusData, other.opusData);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(speakerId);
        result = 31 * result + Integer.hashCode(entityId);
        result = 31 * result + Short.hashCode(sequenceNumber);
        result = 31 * result + Integer.hashCode(timestamp);
        result = 31 * result + java.util.Objects.hashCode(speakerPosition);
        result = 31 * result + Boolean.hashCode(speakerIsUnderwater);
        result = 31 * result + java.util.Arrays.hashCode(opusData);
        return result;
    }

}