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


public class AmbienceStateWrite {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 16384029;

    public int audioStateIndex;
    public int valueIndex;
    @Nullable public StateTransition transitionOverride;

    public AmbienceStateWrite() {
    }

    public AmbienceStateWrite(int audioStateIndex, int valueIndex, @Nullable StateTransition transitionOverride) {
        this.audioStateIndex = audioStateIndex;
        this.valueIndex = valueIndex;
        this.transitionOverride = transitionOverride;
    }

    public AmbienceStateWrite(@Nonnull AmbienceStateWrite other) {
        this.audioStateIndex = other.audioStateIndex;
        this.valueIndex = other.valueIndex;
        this.transitionOverride = other.transitionOverride;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AmbienceStateWrite", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AmbienceStateWrite", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getAudioStateIndex(MemorySegment mem) {
        return getAudioStateIndex(mem, 0);
    }
    
    public static int getAudioStateIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getValueIndex(MemorySegment mem) {
        return getValueIndex(mem, 0);
    }
    
    public static int getValueIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    @Nullable
    public static StateTransition getTransitionOverride(MemorySegment mem) {
        return getTransitionOverride(mem, 0);
    }
    
    @Nullable
    public static StateTransition getTransitionOverride(MemorySegment mem, int offset) {
        return hasTransitionOverride(mem, offset) ? StateTransition.toObject(mem, offset + 9): null;
    }
    
    public static boolean hasTransitionOverride(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static AmbienceStateWrite toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AmbienceStateWrite toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AmbienceStateWrite and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AmbienceStateWrite toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        StateTransition v2 = null;
        if (hasTransitionOverride(mem, offset)) {
            v2 = StateTransition.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new AmbienceStateWrite(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.transitionOverride != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.audioStateIndex);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.valueIndex);
        var varOffset = offset + 9;
        if (this.transitionOverride != null) {
            
            varOffset += this.transitionOverride.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (transitionOverride != null) size += transitionOverride.computeSize();

        return size;
    }

    public AmbienceStateWrite clone() {
        AmbienceStateWrite copy = new AmbienceStateWrite();
        copy.audioStateIndex = this.audioStateIndex;
        copy.valueIndex = this.valueIndex;
        copy.transitionOverride = this.transitionOverride != null ? this.transitionOverride.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AmbienceStateWrite other)) return false;
        return this.audioStateIndex == other.audioStateIndex && this.valueIndex == other.valueIndex && java.util.Objects.equals(this.transitionOverride, other.transitionOverride);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(audioStateIndex, valueIndex, transitionOverride);
    }

}