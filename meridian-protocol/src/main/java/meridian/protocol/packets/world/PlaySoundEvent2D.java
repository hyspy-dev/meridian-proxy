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
import meridian.protocol.SoundCategory;

public class PlaySoundEvent2D implements Packet, ToClientPacket {
    public static final int PACKET_ID = 154;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 13;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 13;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int soundEventIndex;
    @Nonnull public SoundCategory category = SoundCategory.Music;
    public float volumeModifier;
    public float pitchModifier;

    public PlaySoundEvent2D() {
    }

    public PlaySoundEvent2D(int soundEventIndex, @Nonnull SoundCategory category, float volumeModifier, float pitchModifier) {
        this.soundEventIndex = soundEventIndex;
        this.category = category;
        this.volumeModifier = volumeModifier;
        this.pitchModifier = pitchModifier;
    }

    public PlaySoundEvent2D(@Nonnull PlaySoundEvent2D other) {
        this.soundEventIndex = other.soundEventIndex;
        this.category = other.category;
        this.volumeModifier = other.volumeModifier;
        this.pitchModifier = other.pitchModifier;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PlaySoundEvent2D", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PlaySoundEvent2D", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getSoundEventIndex(MemorySegment mem) {
        return getSoundEventIndex(mem, 0);
    }
    
    public static int getSoundEventIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static SoundCategory getCategory(MemorySegment mem) {
        return getCategory(mem, 0);
    }
    
    public static SoundCategory getCategory(MemorySegment mem, int offset) {
        return SoundCategory.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 4));
    }
    
    public static float getVolumeModifier(MemorySegment mem) {
        return getVolumeModifier(mem, 0);
    }
    
    public static float getVolumeModifier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "VolumeModifier");
    }
    
    public static float getPitchModifier(MemorySegment mem) {
        return getPitchModifier(mem, 0);
    }
    
    public static float getPitchModifier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "PitchModifier");
    }
    
    
    
    
    
    public static PlaySoundEvent2D toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PlaySoundEvent2D toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PlaySoundEvent2D and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PlaySoundEvent2D toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new PlaySoundEvent2D(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            SoundCategory.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 4)),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "VolumeModifier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "PitchModifier")
        );
        if (cursor != null) cursor.position = offset + 13;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.soundEventIndex);
        mem.set(PacketIO.PROTO_BYTE, offset + 4, (byte) this.category.getValue());
        PacketIO.requireFinite(this.volumeModifier, "VolumeModifier"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.volumeModifier);
        PacketIO.requireFinite(this.pitchModifier, "PitchModifier"); mem.set(PacketIO.PROTO_FLOAT, offset + 9, this.pitchModifier);
        
        
    
       return 13;
    }
    public int computeSize() {
        return 13;
    }

    public PlaySoundEvent2D clone() {
        PlaySoundEvent2D copy = new PlaySoundEvent2D();
        copy.soundEventIndex = this.soundEventIndex;
        copy.category = this.category;
        copy.volumeModifier = this.volumeModifier;
        copy.pitchModifier = this.pitchModifier;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PlaySoundEvent2D other)) return false;
        return this.soundEventIndex == other.soundEventIndex && java.util.Objects.equals(this.category, other.category) && this.volumeModifier == other.volumeModifier && this.pitchModifier == other.pitchModifier;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(soundEventIndex, category, volumeModifier, pitchModifier);
    }

}