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


public class SoundEventLayerRandomSettings {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 20;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 20;
    public static final int MAX_SIZE = 20;

    public float minVolume;
    public float maxVolume;
    public float minPitch;
    public float maxPitch;
    public float maxStartOffset;

    public SoundEventLayerRandomSettings() {
    }

    public SoundEventLayerRandomSettings(float minVolume, float maxVolume, float minPitch, float maxPitch, float maxStartOffset) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
        this.minPitch = minPitch;
        this.maxPitch = maxPitch;
        this.maxStartOffset = maxStartOffset;
    }

    public SoundEventLayerRandomSettings(@Nonnull SoundEventLayerRandomSettings other) {
        this.minVolume = other.minVolume;
        this.maxVolume = other.maxVolume;
        this.minPitch = other.minPitch;
        this.maxPitch = other.maxPitch;
        this.maxStartOffset = other.maxStartOffset;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SoundEventLayerRandomSettings", offset, (int) mem.byteSize());
        long needed = (long) offset + 20;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SoundEventLayerRandomSettings", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getMinVolume(MemorySegment mem) {
        return getMinVolume(mem, 0);
    }
    
    public static float getMinVolume(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "MinVolume");
    }
    
    public static float getMaxVolume(MemorySegment mem) {
        return getMaxVolume(mem, 0);
    }
    
    public static float getMaxVolume(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "MaxVolume");
    }
    
    public static float getMinPitch(MemorySegment mem) {
        return getMinPitch(mem, 0);
    }
    
    public static float getMinPitch(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "MinPitch");
    }
    
    public static float getMaxPitch(MemorySegment mem) {
        return getMaxPitch(mem, 0);
    }
    
    public static float getMaxPitch(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "MaxPitch");
    }
    
    public static float getMaxStartOffset(MemorySegment mem) {
        return getMaxStartOffset(mem, 0);
    }
    
    public static float getMaxStartOffset(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "MaxStartOffset");
    }
    
    
    
    
    
    public static SoundEventLayerRandomSettings toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SoundEventLayerRandomSettings toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SoundEventLayerRandomSettings and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SoundEventLayerRandomSettings toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new SoundEventLayerRandomSettings(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "MinVolume"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "MaxVolume"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "MinPitch"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "MaxPitch"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "MaxStartOffset")
        );
        if (cursor != null) cursor.position = offset + 20;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.minVolume, "MinVolume"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.minVolume);
        PacketIO.requireFinite(this.maxVolume, "MaxVolume"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.maxVolume);
        PacketIO.requireFinite(this.minPitch, "MinPitch"); mem.set(PacketIO.PROTO_FLOAT, offset + 8, this.minPitch);
        PacketIO.requireFinite(this.maxPitch, "MaxPitch"); mem.set(PacketIO.PROTO_FLOAT, offset + 12, this.maxPitch);
        PacketIO.requireFinite(this.maxStartOffset, "MaxStartOffset"); mem.set(PacketIO.PROTO_FLOAT, offset + 16, this.maxStartOffset);
        
        
    
       return 20;
    }
    public int computeSize() {
        return 20;
    }

    public SoundEventLayerRandomSettings clone() {
        SoundEventLayerRandomSettings copy = new SoundEventLayerRandomSettings();
        copy.minVolume = this.minVolume;
        copy.maxVolume = this.maxVolume;
        copy.minPitch = this.minPitch;
        copy.maxPitch = this.maxPitch;
        copy.maxStartOffset = this.maxStartOffset;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SoundEventLayerRandomSettings other)) return false;
        return this.minVolume == other.minVolume && this.maxVolume == other.maxVolume && this.minPitch == other.minPitch && this.maxPitch == other.maxPitch && this.maxStartOffset == other.maxStartOffset;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(minVolume, maxVolume, minPitch, maxPitch, maxStartOffset);
    }

}