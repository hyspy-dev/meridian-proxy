// Auto-generated - do not edit
package meridian.protocol;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class MusicEmitterConfig {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 29;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 29;
    public static final int MAX_SIZE = 29;

    public int musicContainerIndex;
    public int audioCategoryOverrideIndex;
    public float referenceDistance;
    public float maxDistance;
    public float spatialBlend;
    public float reverbSend;
    public float volume;
    public boolean loop;

    public MusicEmitterConfig() {
    }

    public MusicEmitterConfig(int musicContainerIndex, int audioCategoryOverrideIndex, float referenceDistance, float maxDistance, float spatialBlend, float reverbSend, float volume, boolean loop) {
        this.musicContainerIndex = musicContainerIndex;
        this.audioCategoryOverrideIndex = audioCategoryOverrideIndex;
        this.referenceDistance = referenceDistance;
        this.maxDistance = maxDistance;
        this.spatialBlend = spatialBlend;
        this.reverbSend = reverbSend;
        this.volume = volume;
        this.loop = loop;
    }

    public MusicEmitterConfig(@Nonnull MusicEmitterConfig other) {
        this.musicContainerIndex = other.musicContainerIndex;
        this.audioCategoryOverrideIndex = other.audioCategoryOverrideIndex;
        this.referenceDistance = other.referenceDistance;
        this.maxDistance = other.maxDistance;
        this.spatialBlend = other.spatialBlend;
        this.reverbSend = other.reverbSend;
        this.volume = other.volume;
        this.loop = other.loop;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("MusicEmitterConfig", offset, (int) mem.byteSize());
        long needed = (long) offset + 29;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("MusicEmitterConfig", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getMusicContainerIndex(MemorySegment mem) {
        return getMusicContainerIndex(mem, 0);
    }
    
    public static int getMusicContainerIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static int getAudioCategoryOverrideIndex(MemorySegment mem) {
        return getAudioCategoryOverrideIndex(mem, 0);
    }
    
    public static int getAudioCategoryOverrideIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 4);
    }
    
    public static float getReferenceDistance(MemorySegment mem) {
        return getReferenceDistance(mem, 0);
    }
    
    public static float getReferenceDistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "ReferenceDistance");
    }
    
    public static float getMaxDistance(MemorySegment mem) {
        return getMaxDistance(mem, 0);
    }
    
    public static float getMaxDistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "MaxDistance");
    }
    
    public static float getSpatialBlend(MemorySegment mem) {
        return getSpatialBlend(mem, 0);
    }
    
    public static float getSpatialBlend(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "SpatialBlend");
    }
    
    public static float getReverbSend(MemorySegment mem) {
        return getReverbSend(mem, 0);
    }
    
    public static float getReverbSend(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "ReverbSend");
    }
    
    public static float getVolume(MemorySegment mem) {
        return getVolume(mem, 0);
    }
    
    public static float getVolume(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 24), "Volume");
    }
    
    public static boolean getLoop(MemorySegment mem) {
        return getLoop(mem, 0);
    }
    
    public static boolean getLoop(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 28);
    }
    
    
    
    
    
    public static MusicEmitterConfig toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static MusicEmitterConfig toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one MusicEmitterConfig and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static MusicEmitterConfig toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new MusicEmitterConfig(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "ReferenceDistance"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "MaxDistance"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "SpatialBlend"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "ReverbSend"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 24), "Volume"),
            mem.get(PacketIO.PROTO_BOOL, offset + 28)
        );
        if (cursor != null) cursor.position = offset + 29;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.musicContainerIndex);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.audioCategoryOverrideIndex);
        PacketIO.requireFinite(this.referenceDistance, "ReferenceDistance"); mem.set(PacketIO.PROTO_FLOAT, offset + 8, this.referenceDistance);
        PacketIO.requireFinite(this.maxDistance, "MaxDistance"); mem.set(PacketIO.PROTO_FLOAT, offset + 12, this.maxDistance);
        PacketIO.requireFinite(this.spatialBlend, "SpatialBlend"); mem.set(PacketIO.PROTO_FLOAT, offset + 16, this.spatialBlend);
        PacketIO.requireFinite(this.reverbSend, "ReverbSend"); mem.set(PacketIO.PROTO_FLOAT, offset + 20, this.reverbSend);
        PacketIO.requireFinite(this.volume, "Volume"); mem.set(PacketIO.PROTO_FLOAT, offset + 24, this.volume);
        mem.set(PacketIO.PROTO_BOOL, offset + 28, this.loop);
        
        
    
       return 29;
    }
    public int computeSize() {
        return 29;
    }

    public MusicEmitterConfig clone() {
        MusicEmitterConfig copy = new MusicEmitterConfig();
        copy.musicContainerIndex = this.musicContainerIndex;
        copy.audioCategoryOverrideIndex = this.audioCategoryOverrideIndex;
        copy.referenceDistance = this.referenceDistance;
        copy.maxDistance = this.maxDistance;
        copy.spatialBlend = this.spatialBlend;
        copy.reverbSend = this.reverbSend;
        copy.volume = this.volume;
        copy.loop = this.loop;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MusicEmitterConfig other)) return false;
        return this.musicContainerIndex == other.musicContainerIndex && this.audioCategoryOverrideIndex == other.audioCategoryOverrideIndex && this.referenceDistance == other.referenceDistance && this.maxDistance == other.maxDistance && this.spatialBlend == other.spatialBlend && this.reverbSend == other.reverbSend && this.volume == other.volume && this.loop == other.loop;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(musicContainerIndex, audioCategoryOverrideIndex, referenceDistance, maxDistance, spatialBlend, reverbSend, volume, loop);
    }

}