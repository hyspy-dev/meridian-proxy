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

public class PlaySoundEventLocalPlayer implements Packet, ToClientPacket {
    public static final int PACKET_ID = 362;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 17;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 17;
    public static final int MAX_SIZE = 17;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int localSoundEventIndex;
    public int worldSoundEventIndex;
    @Nonnull public SoundCategory category = SoundCategory.Music;
    public float volumeModifier;
    public float pitchModifier;

    public PlaySoundEventLocalPlayer() {
    }

    public PlaySoundEventLocalPlayer(int localSoundEventIndex, int worldSoundEventIndex, @Nonnull SoundCategory category, float volumeModifier, float pitchModifier) {
        this.localSoundEventIndex = localSoundEventIndex;
        this.worldSoundEventIndex = worldSoundEventIndex;
        this.category = category;
        this.volumeModifier = volumeModifier;
        this.pitchModifier = pitchModifier;
    }

    public PlaySoundEventLocalPlayer(@Nonnull PlaySoundEventLocalPlayer other) {
        this.localSoundEventIndex = other.localSoundEventIndex;
        this.worldSoundEventIndex = other.worldSoundEventIndex;
        this.category = other.category;
        this.volumeModifier = other.volumeModifier;
        this.pitchModifier = other.pitchModifier;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PlaySoundEventLocalPlayer", offset, (int) mem.byteSize());
        long needed = (long) offset + 17;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PlaySoundEventLocalPlayer", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getLocalSoundEventIndex(MemorySegment mem) {
        return getLocalSoundEventIndex(mem, 0);
    }
    
    public static int getLocalSoundEventIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static int getWorldSoundEventIndex(MemorySegment mem) {
        return getWorldSoundEventIndex(mem, 0);
    }
    
    public static int getWorldSoundEventIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 4);
    }
    
    public static SoundCategory getCategory(MemorySegment mem) {
        return getCategory(mem, 0);
    }
    
    public static SoundCategory getCategory(MemorySegment mem, int offset) {
        return SoundCategory.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 8));
    }
    
    public static float getVolumeModifier(MemorySegment mem) {
        return getVolumeModifier(mem, 0);
    }
    
    public static float getVolumeModifier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "VolumeModifier");
    }
    
    public static float getPitchModifier(MemorySegment mem) {
        return getPitchModifier(mem, 0);
    }
    
    public static float getPitchModifier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 13), "PitchModifier");
    }
    
    
    
    
    
    public static PlaySoundEventLocalPlayer toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PlaySoundEventLocalPlayer toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PlaySoundEventLocalPlayer and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PlaySoundEventLocalPlayer toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new PlaySoundEventLocalPlayer(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4),
            SoundCategory.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 8)),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "VolumeModifier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 13), "PitchModifier")
        );
        if (cursor != null) cursor.position = offset + 17;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.localSoundEventIndex);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.worldSoundEventIndex);
        mem.set(PacketIO.PROTO_BYTE, offset + 8, (byte) this.category.getValue());
        PacketIO.requireFinite(this.volumeModifier, "VolumeModifier"); mem.set(PacketIO.PROTO_FLOAT, offset + 9, this.volumeModifier);
        PacketIO.requireFinite(this.pitchModifier, "PitchModifier"); mem.set(PacketIO.PROTO_FLOAT, offset + 13, this.pitchModifier);
        
        
    
       return 17;
    }
    public int computeSize() {
        return 17;
    }

    public PlaySoundEventLocalPlayer clone() {
        PlaySoundEventLocalPlayer copy = new PlaySoundEventLocalPlayer();
        copy.localSoundEventIndex = this.localSoundEventIndex;
        copy.worldSoundEventIndex = this.worldSoundEventIndex;
        copy.category = this.category;
        copy.volumeModifier = this.volumeModifier;
        copy.pitchModifier = this.pitchModifier;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PlaySoundEventLocalPlayer other)) return false;
        return this.localSoundEventIndex == other.localSoundEventIndex && this.worldSoundEventIndex == other.worldSoundEventIndex && java.util.Objects.equals(this.category, other.category) && this.volumeModifier == other.volumeModifier && this.pitchModifier == other.pitchModifier;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(localSoundEventIndex, worldSoundEventIndex, category, volumeModifier, pitchModifier);
    }

}