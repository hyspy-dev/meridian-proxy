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


public class AudioCategoryDuckingRule {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 24;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 24;
    public static final int MAX_SIZE = 24;

    public int targetAudioCategoryIndex;
    public float duckingVolumeDb;
    public float attackMs;
    public float holdMs;
    public float releaseMs;
    @Nonnull public FadeCurve curve = FadeCurve.Linear;
    @Nonnull public FadeCurve releaseCurve = FadeCurve.Linear;
    public short priority;

    public AudioCategoryDuckingRule() {
    }

    public AudioCategoryDuckingRule(int targetAudioCategoryIndex, float duckingVolumeDb, float attackMs, float holdMs, float releaseMs, @Nonnull FadeCurve curve, @Nonnull FadeCurve releaseCurve, short priority) {
        this.targetAudioCategoryIndex = targetAudioCategoryIndex;
        this.duckingVolumeDb = duckingVolumeDb;
        this.attackMs = attackMs;
        this.holdMs = holdMs;
        this.releaseMs = releaseMs;
        this.curve = curve;
        this.releaseCurve = releaseCurve;
        this.priority = priority;
    }

    public AudioCategoryDuckingRule(@Nonnull AudioCategoryDuckingRule other) {
        this.targetAudioCategoryIndex = other.targetAudioCategoryIndex;
        this.duckingVolumeDb = other.duckingVolumeDb;
        this.attackMs = other.attackMs;
        this.holdMs = other.holdMs;
        this.releaseMs = other.releaseMs;
        this.curve = other.curve;
        this.releaseCurve = other.releaseCurve;
        this.priority = other.priority;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AudioCategoryDuckingRule", offset, (int) mem.byteSize());
        long needed = (long) offset + 24;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AudioCategoryDuckingRule", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getTargetAudioCategoryIndex(MemorySegment mem) {
        return getTargetAudioCategoryIndex(mem, 0);
    }
    
    public static int getTargetAudioCategoryIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static float getDuckingVolumeDb(MemorySegment mem) {
        return getDuckingVolumeDb(mem, 0);
    }
    
    public static float getDuckingVolumeDb(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "DuckingVolumeDb");
    }
    
    public static float getAttackMs(MemorySegment mem) {
        return getAttackMs(mem, 0);
    }
    
    public static float getAttackMs(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "AttackMs");
    }
    
    public static float getHoldMs(MemorySegment mem) {
        return getHoldMs(mem, 0);
    }
    
    public static float getHoldMs(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "HoldMs");
    }
    
    public static float getReleaseMs(MemorySegment mem) {
        return getReleaseMs(mem, 0);
    }
    
    public static float getReleaseMs(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "ReleaseMs");
    }
    
    public static FadeCurve getCurve(MemorySegment mem) {
        return getCurve(mem, 0);
    }
    
    public static FadeCurve getCurve(MemorySegment mem, int offset) {
        return FadeCurve.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 20));
    }
    
    public static FadeCurve getReleaseCurve(MemorySegment mem) {
        return getReleaseCurve(mem, 0);
    }
    
    public static FadeCurve getReleaseCurve(MemorySegment mem, int offset) {
        return FadeCurve.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 21));
    }
    
    public static short getPriority(MemorySegment mem) {
        return getPriority(mem, 0);
    }
    
    public static short getPriority(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_SHORT, offset + 22);
    }
    
    
    
    
    
    public static AudioCategoryDuckingRule toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AudioCategoryDuckingRule toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AudioCategoryDuckingRule and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AudioCategoryDuckingRule toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new AudioCategoryDuckingRule(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "DuckingVolumeDb"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "AttackMs"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "HoldMs"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "ReleaseMs"),
            FadeCurve.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 20)),
            FadeCurve.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 21)),
            mem.get(PacketIO.PROTO_SHORT, offset + 22)
        );
        if (cursor != null) cursor.position = offset + 24;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.targetAudioCategoryIndex);
        PacketIO.requireFinite(this.duckingVolumeDb, "DuckingVolumeDb"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.duckingVolumeDb);
        PacketIO.requireFinite(this.attackMs, "AttackMs"); mem.set(PacketIO.PROTO_FLOAT, offset + 8, this.attackMs);
        PacketIO.requireFinite(this.holdMs, "HoldMs"); mem.set(PacketIO.PROTO_FLOAT, offset + 12, this.holdMs);
        PacketIO.requireFinite(this.releaseMs, "ReleaseMs"); mem.set(PacketIO.PROTO_FLOAT, offset + 16, this.releaseMs);
        mem.set(PacketIO.PROTO_BYTE, offset + 20, (byte) this.curve.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 21, (byte) this.releaseCurve.getValue());
        mem.set(PacketIO.PROTO_SHORT, offset + 22, this.priority);
        
        
    
       return 24;
    }
    public int computeSize() {
        return 24;
    }

    public AudioCategoryDuckingRule clone() {
        AudioCategoryDuckingRule copy = new AudioCategoryDuckingRule();
        copy.targetAudioCategoryIndex = this.targetAudioCategoryIndex;
        copy.duckingVolumeDb = this.duckingVolumeDb;
        copy.attackMs = this.attackMs;
        copy.holdMs = this.holdMs;
        copy.releaseMs = this.releaseMs;
        copy.curve = this.curve;
        copy.releaseCurve = this.releaseCurve;
        copy.priority = this.priority;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AudioCategoryDuckingRule other)) return false;
        return this.targetAudioCategoryIndex == other.targetAudioCategoryIndex && this.duckingVolumeDb == other.duckingVolumeDb && this.attackMs == other.attackMs && this.holdMs == other.holdMs && this.releaseMs == other.releaseMs && java.util.Objects.equals(this.curve, other.curve) && java.util.Objects.equals(this.releaseCurve, other.releaseCurve) && this.priority == other.priority;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(targetAudioCategoryIndex, duckingVolumeDb, attackMs, holdMs, releaseMs, curve, releaseCurve, priority);
    }

}