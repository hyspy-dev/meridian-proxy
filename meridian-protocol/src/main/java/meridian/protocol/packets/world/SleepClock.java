// Auto-generated - do not edit
package meridian.protocol.packets.world;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import meridian.protocol.InstantData;

public class SleepClock {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 33;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 33;
    public static final int MAX_SIZE = 33;

    @Nullable public InstantData startGametime;
    @Nullable public InstantData targetGametime;
    public float progress;
    public float durationSeconds;

    public SleepClock() {
    }

    public SleepClock(@Nullable InstantData startGametime, @Nullable InstantData targetGametime, float progress, float durationSeconds) {
        this.startGametime = startGametime;
        this.targetGametime = targetGametime;
        this.progress = progress;
        this.durationSeconds = durationSeconds;
    }

    public SleepClock(@Nonnull SleepClock other) {
        this.startGametime = other.startGametime;
        this.targetGametime = other.targetGametime;
        this.progress = other.progress;
        this.durationSeconds = other.durationSeconds;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SleepClock", offset, (int) mem.byteSize());
        long needed = (long) offset + 33;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SleepClock", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static InstantData getStartGametime(MemorySegment mem) {
        return getStartGametime(mem, 0);
    }
    
    @Nullable
    public static InstantData getStartGametime(MemorySegment mem, int offset) {
        return hasStartGametime(mem, offset) ? InstantData.toObject(mem, offset + 1): null;
    }
    
    @Nullable
    public static InstantData getTargetGametime(MemorySegment mem) {
        return getTargetGametime(mem, 0);
    }
    
    @Nullable
    public static InstantData getTargetGametime(MemorySegment mem, int offset) {
        return hasTargetGametime(mem, offset) ? InstantData.toObject(mem, offset + 13): null;
    }
    
    public static float getProgress(MemorySegment mem) {
        return getProgress(mem, 0);
    }
    
    public static float getProgress(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 25), "Progress");
    }
    
    public static float getDurationSeconds(MemorySegment mem) {
        return getDurationSeconds(mem, 0);
    }
    
    public static float getDurationSeconds(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 29), "DurationSeconds");
    }
    
    public static boolean hasStartGametime(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasTargetGametime(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    
    
    public static SleepClock toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SleepClock toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SleepClock and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SleepClock toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new SleepClock(
            hasStartGametime(mem, offset) ? InstantData.toObject(mem, offset + 1) : null,
            hasTargetGametime(mem, offset) ? InstantData.toObject(mem, offset + 13) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 25), "Progress"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 29), "DurationSeconds")
        );
        if (cursor != null) cursor.position = offset + 33;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.startGametime != null) nullBits |= 0x01;
        if (this.targetGametime != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.startGametime != null) {
            this.startGametime.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 12).fill((byte) 0); 
        }
        if (this.targetGametime != null) {
            this.targetGametime.serialize(mem, offset + 13);
        } else {
            mem.asSlice(offset + 13, 12).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.progress, "Progress"); mem.set(PacketIO.PROTO_FLOAT, offset + 25, this.progress);
        PacketIO.requireFinite(this.durationSeconds, "DurationSeconds"); mem.set(PacketIO.PROTO_FLOAT, offset + 29, this.durationSeconds);
        
        
    
       return 33;
    }
    public int computeSize() {
        return 33;
    }

    public SleepClock clone() {
        SleepClock copy = new SleepClock();
        copy.startGametime = this.startGametime != null ? this.startGametime.clone() : null;
        copy.targetGametime = this.targetGametime != null ? this.targetGametime.clone() : null;
        copy.progress = this.progress;
        copy.durationSeconds = this.durationSeconds;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SleepClock other)) return false;
        return java.util.Objects.equals(this.startGametime, other.startGametime) && java.util.Objects.equals(this.targetGametime, other.targetGametime) && this.progress == other.progress && this.durationSeconds == other.durationSeconds;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(startGametime, targetGametime, progress, durationSeconds);
    }

}