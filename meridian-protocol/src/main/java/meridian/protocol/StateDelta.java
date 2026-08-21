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


public class StateDelta {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 13;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 13;

    public int valueIndex;
    public float volumeDb;
    public boolean mute;
    public float pitchSemitones;

    public StateDelta() {
    }

    public StateDelta(int valueIndex, float volumeDb, boolean mute, float pitchSemitones) {
        this.valueIndex = valueIndex;
        this.volumeDb = volumeDb;
        this.mute = mute;
        this.pitchSemitones = pitchSemitones;
    }

    public StateDelta(@Nonnull StateDelta other) {
        this.valueIndex = other.valueIndex;
        this.volumeDb = other.volumeDb;
        this.mute = other.mute;
        this.pitchSemitones = other.pitchSemitones;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("StateDelta", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("StateDelta", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getValueIndex(MemorySegment mem) {
        return getValueIndex(mem, 0);
    }
    
    public static int getValueIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static float getVolumeDb(MemorySegment mem) {
        return getVolumeDb(mem, 0);
    }
    
    public static float getVolumeDb(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "VolumeDb");
    }
    
    public static boolean getMute(MemorySegment mem) {
        return getMute(mem, 0);
    }
    
    public static boolean getMute(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 8);
    }
    
    public static float getPitchSemitones(MemorySegment mem) {
        return getPitchSemitones(mem, 0);
    }
    
    public static float getPitchSemitones(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "PitchSemitones");
    }
    
    
    
    
    
    public static StateDelta toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static StateDelta toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one StateDelta and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static StateDelta toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new StateDelta(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "VolumeDb"),
            mem.get(PacketIO.PROTO_BOOL, offset + 8),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "PitchSemitones")
        );
        if (cursor != null) cursor.position = offset + 13;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.valueIndex);
        PacketIO.requireFinite(this.volumeDb, "VolumeDb"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.volumeDb);
        mem.set(PacketIO.PROTO_BOOL, offset + 8, this.mute);
        PacketIO.requireFinite(this.pitchSemitones, "PitchSemitones"); mem.set(PacketIO.PROTO_FLOAT, offset + 9, this.pitchSemitones);
        
        
    
       return 13;
    }
    public int computeSize() {
        return 13;
    }

    public StateDelta clone() {
        StateDelta copy = new StateDelta();
        copy.valueIndex = this.valueIndex;
        copy.volumeDb = this.volumeDb;
        copy.mute = this.mute;
        copy.pitchSemitones = this.pitchSemitones;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof StateDelta other)) return false;
        return this.valueIndex == other.valueIndex && this.volumeDb == other.volumeDb && this.mute == other.mute && this.pitchSemitones == other.pitchSemitones;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(valueIndex, volumeDb, mute, pitchSemitones);
    }

}