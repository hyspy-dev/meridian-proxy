// Auto-generated - do not edit
package meridian.protocol.packets.world;

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


public class PlaySoundEventEntity implements Packet, ToClientPacket {
    public static final int PACKET_ID = 156;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 16;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 16;
    public static final int MAX_SIZE = 16;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int soundEventIndex;
    public int networkId;
    public float volumeModifier;
    public float pitchModifier;

    public PlaySoundEventEntity() {
    }

    public PlaySoundEventEntity(int soundEventIndex, int networkId, float volumeModifier, float pitchModifier) {
        this.soundEventIndex = soundEventIndex;
        this.networkId = networkId;
        this.volumeModifier = volumeModifier;
        this.pitchModifier = pitchModifier;
    }

    public PlaySoundEventEntity(@Nonnull PlaySoundEventEntity other) {
        this.soundEventIndex = other.soundEventIndex;
        this.networkId = other.networkId;
        this.volumeModifier = other.volumeModifier;
        this.pitchModifier = other.pitchModifier;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PlaySoundEventEntity", offset, (int) mem.byteSize());
        long needed = (long) offset + 16;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PlaySoundEventEntity", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getSoundEventIndex(MemorySegment mem) {
        return getSoundEventIndex(mem, 0);
    }
    
    public static int getSoundEventIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static int getNetworkId(MemorySegment mem) {
        return getNetworkId(mem, 0);
    }
    
    public static int getNetworkId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 4);
    }
    
    public static float getVolumeModifier(MemorySegment mem) {
        return getVolumeModifier(mem, 0);
    }
    
    public static float getVolumeModifier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "VolumeModifier");
    }
    
    public static float getPitchModifier(MemorySegment mem) {
        return getPitchModifier(mem, 0);
    }
    
    public static float getPitchModifier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "PitchModifier");
    }
    
    
    
    
    
    public static PlaySoundEventEntity toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PlaySoundEventEntity toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PlaySoundEventEntity and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PlaySoundEventEntity toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new PlaySoundEventEntity(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "VolumeModifier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "PitchModifier")
        );
        if (cursor != null) cursor.position = offset + 16;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.soundEventIndex);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.networkId);
        PacketIO.requireFinite(this.volumeModifier, "VolumeModifier"); mem.set(PacketIO.PROTO_FLOAT, offset + 8, this.volumeModifier);
        PacketIO.requireFinite(this.pitchModifier, "PitchModifier"); mem.set(PacketIO.PROTO_FLOAT, offset + 12, this.pitchModifier);
        
        
    
       return 16;
    }
    public int computeSize() {
        return 16;
    }

    public PlaySoundEventEntity clone() {
        PlaySoundEventEntity copy = new PlaySoundEventEntity();
        copy.soundEventIndex = this.soundEventIndex;
        copy.networkId = this.networkId;
        copy.volumeModifier = this.volumeModifier;
        copy.pitchModifier = this.pitchModifier;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PlaySoundEventEntity other)) return false;
        return this.soundEventIndex == other.soundEventIndex && this.networkId == other.networkId && this.volumeModifier == other.volumeModifier && this.pitchModifier == other.pitchModifier;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(soundEventIndex, networkId, volumeModifier, pitchModifier);
    }

}