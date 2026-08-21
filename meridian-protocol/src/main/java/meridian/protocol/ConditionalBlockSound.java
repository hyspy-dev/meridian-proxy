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


public class ConditionalBlockSound {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 8;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 8;
    public static final int MAX_SIZE = 8;

    public int soundEventIndex;
    public int ambienceFXIndex;

    public ConditionalBlockSound() {
    }

    public ConditionalBlockSound(int soundEventIndex, int ambienceFXIndex) {
        this.soundEventIndex = soundEventIndex;
        this.ambienceFXIndex = ambienceFXIndex;
    }

    public ConditionalBlockSound(@Nonnull ConditionalBlockSound other) {
        this.soundEventIndex = other.soundEventIndex;
        this.ambienceFXIndex = other.ambienceFXIndex;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ConditionalBlockSound", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ConditionalBlockSound", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getSoundEventIndex(MemorySegment mem) {
        return getSoundEventIndex(mem, 0);
    }
    
    public static int getSoundEventIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static int getAmbienceFXIndex(MemorySegment mem) {
        return getAmbienceFXIndex(mem, 0);
    }
    
    public static int getAmbienceFXIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 4);
    }
    
    
    
    
    
    public static ConditionalBlockSound toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ConditionalBlockSound toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ConditionalBlockSound and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ConditionalBlockSound toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new ConditionalBlockSound(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4)
        );
        if (cursor != null) cursor.position = offset + 8;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.soundEventIndex);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.ambienceFXIndex);
        
        
    
       return 8;
    }
    public int computeSize() {
        return 8;
    }

    public ConditionalBlockSound clone() {
        ConditionalBlockSound copy = new ConditionalBlockSound();
        copy.soundEventIndex = this.soundEventIndex;
        copy.ambienceFXIndex = this.ambienceFXIndex;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ConditionalBlockSound other)) return false;
        return this.soundEventIndex == other.soundEventIndex && this.ambienceFXIndex == other.ambienceFXIndex;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(soundEventIndex, ambienceFXIndex);
    }

}