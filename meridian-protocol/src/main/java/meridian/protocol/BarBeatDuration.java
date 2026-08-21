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


public class BarBeatDuration {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 12;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 12;
    public static final int MAX_SIZE = 12;

    public int bars;
    public int beats;
    public float ms;

    public BarBeatDuration() {
    }

    public BarBeatDuration(int bars, int beats, float ms) {
        this.bars = bars;
        this.beats = beats;
        this.ms = ms;
    }

    public BarBeatDuration(@Nonnull BarBeatDuration other) {
        this.bars = other.bars;
        this.beats = other.beats;
        this.ms = other.ms;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BarBeatDuration", offset, (int) mem.byteSize());
        long needed = (long) offset + 12;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BarBeatDuration", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getBars(MemorySegment mem) {
        return getBars(mem, 0);
    }
    
    public static int getBars(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static int getBeats(MemorySegment mem) {
        return getBeats(mem, 0);
    }
    
    public static int getBeats(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 4);
    }
    
    public static float getMs(MemorySegment mem) {
        return getMs(mem, 0);
    }
    
    public static float getMs(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "Ms");
    }
    
    
    
    
    
    public static BarBeatDuration toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BarBeatDuration toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BarBeatDuration and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BarBeatDuration toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BarBeatDuration(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "Ms")
        );
        if (cursor != null) cursor.position = offset + 12;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.bars);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.beats);
        PacketIO.requireFinite(this.ms, "Ms"); mem.set(PacketIO.PROTO_FLOAT, offset + 8, this.ms);
        
        
    
       return 12;
    }
    public int computeSize() {
        return 12;
    }

    public BarBeatDuration clone() {
        BarBeatDuration copy = new BarBeatDuration();
        copy.bars = this.bars;
        copy.beats = this.beats;
        copy.ms = this.ms;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BarBeatDuration other)) return false;
        return this.bars == other.bars && this.beats == other.beats && this.ms == other.ms;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(bars, beats, ms);
    }

}