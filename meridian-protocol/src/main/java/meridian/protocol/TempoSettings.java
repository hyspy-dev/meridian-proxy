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


public class TempoSettings {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 12;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 12;
    public static final int MAX_SIZE = 12;

    public float bpm;
    public int beatsPerBar;
    public int beatValue;

    public TempoSettings() {
    }

    public TempoSettings(float bpm, int beatsPerBar, int beatValue) {
        this.bpm = bpm;
        this.beatsPerBar = beatsPerBar;
        this.beatValue = beatValue;
    }

    public TempoSettings(@Nonnull TempoSettings other) {
        this.bpm = other.bpm;
        this.beatsPerBar = other.beatsPerBar;
        this.beatValue = other.beatValue;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("TempoSettings", offset, (int) mem.byteSize());
        long needed = (long) offset + 12;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("TempoSettings", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getBpm(MemorySegment mem) {
        return getBpm(mem, 0);
    }
    
    public static float getBpm(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "Bpm");
    }
    
    public static int getBeatsPerBar(MemorySegment mem) {
        return getBeatsPerBar(mem, 0);
    }
    
    public static int getBeatsPerBar(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 4);
    }
    
    public static int getBeatValue(MemorySegment mem) {
        return getBeatValue(mem, 0);
    }
    
    public static int getBeatValue(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 8);
    }
    
    
    
    
    
    public static TempoSettings toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static TempoSettings toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one TempoSettings and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static TempoSettings toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new TempoSettings(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "Bpm"),
            mem.get(PacketIO.PROTO_INT, offset + 4),
            mem.get(PacketIO.PROTO_INT, offset + 8)
        );
        if (cursor != null) cursor.position = offset + 12;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.bpm, "Bpm"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.bpm);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.beatsPerBar);
        mem.set(PacketIO.PROTO_INT, offset + 8, this.beatValue);
        
        
    
       return 12;
    }
    public int computeSize() {
        return 12;
    }

    public TempoSettings clone() {
        TempoSettings copy = new TempoSettings();
        copy.bpm = this.bpm;
        copy.beatsPerBar = this.beatsPerBar;
        copy.beatValue = this.beatValue;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TempoSettings other)) return false;
        return this.bpm == other.bpm && this.beatsPerBar == other.beatsPerBar && this.beatValue == other.beatValue;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(bpm, beatsPerBar, beatValue);
    }

}