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
import meridian.protocol.Position;
import meridian.protocol.SoundCategory;

public class PlaySoundEvent3D implements Packet, ToClientPacket {
    public static final int PACKET_ID = 155;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 38;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 38;
    public static final int MAX_SIZE = 38;

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
    @Nullable public Position position;
    public float volumeModifier;
    public float pitchModifier;

    public PlaySoundEvent3D() {
    }

    public PlaySoundEvent3D(int soundEventIndex, @Nonnull SoundCategory category, @Nullable Position position, float volumeModifier, float pitchModifier) {
        this.soundEventIndex = soundEventIndex;
        this.category = category;
        this.position = position;
        this.volumeModifier = volumeModifier;
        this.pitchModifier = pitchModifier;
    }

    public PlaySoundEvent3D(@Nonnull PlaySoundEvent3D other) {
        this.soundEventIndex = other.soundEventIndex;
        this.category = other.category;
        this.position = other.position;
        this.volumeModifier = other.volumeModifier;
        this.pitchModifier = other.pitchModifier;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PlaySoundEvent3D", offset, (int) mem.byteSize());
        long needed = (long) offset + 38;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PlaySoundEvent3D", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getSoundEventIndex(MemorySegment mem) {
        return getSoundEventIndex(mem, 0);
    }
    
    public static int getSoundEventIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static SoundCategory getCategory(MemorySegment mem) {
        return getCategory(mem, 0);
    }
    
    public static SoundCategory getCategory(MemorySegment mem, int offset) {
        return SoundCategory.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 5));
    }
    
    @Nullable
    public static Position getPosition(MemorySegment mem) {
        return getPosition(mem, 0);
    }
    
    @Nullable
    public static Position getPosition(MemorySegment mem, int offset) {
        return hasPosition(mem, offset) ? Position.toObject(mem, offset + 6): null;
    }
    
    public static float getVolumeModifier(MemorySegment mem) {
        return getVolumeModifier(mem, 0);
    }
    
    public static float getVolumeModifier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 30), "VolumeModifier");
    }
    
    public static float getPitchModifier(MemorySegment mem) {
        return getPitchModifier(mem, 0);
    }
    
    public static float getPitchModifier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 34), "PitchModifier");
    }
    
    public static boolean hasPosition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static PlaySoundEvent3D toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PlaySoundEvent3D toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PlaySoundEvent3D and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PlaySoundEvent3D toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new PlaySoundEvent3D(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            SoundCategory.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 5)),
            hasPosition(mem, offset) ? Position.toObject(mem, offset + 6) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 30), "VolumeModifier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 34), "PitchModifier")
        );
        if (cursor != null) cursor.position = offset + 38;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.position != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.soundEventIndex);
        mem.set(PacketIO.PROTO_BYTE, offset + 5, (byte) this.category.getValue());
        if (this.position != null) {
            this.position.serialize(mem, offset + 6);
        } else {
            mem.asSlice(offset + 6, 24).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.volumeModifier, "VolumeModifier"); mem.set(PacketIO.PROTO_FLOAT, offset + 30, this.volumeModifier);
        PacketIO.requireFinite(this.pitchModifier, "PitchModifier"); mem.set(PacketIO.PROTO_FLOAT, offset + 34, this.pitchModifier);
        
        
    
       return 38;
    }
    public int computeSize() {
        return 38;
    }

    public PlaySoundEvent3D clone() {
        PlaySoundEvent3D copy = new PlaySoundEvent3D();
        copy.soundEventIndex = this.soundEventIndex;
        copy.category = this.category;
        copy.position = this.position != null ? this.position.clone() : null;
        copy.volumeModifier = this.volumeModifier;
        copy.pitchModifier = this.pitchModifier;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PlaySoundEvent3D other)) return false;
        return this.soundEventIndex == other.soundEventIndex && java.util.Objects.equals(this.category, other.category) && java.util.Objects.equals(this.position, other.position) && this.volumeModifier == other.volumeModifier && this.pitchModifier == other.pitchModifier;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(soundEventIndex, category, position, volumeModifier, pitchModifier);
    }

}