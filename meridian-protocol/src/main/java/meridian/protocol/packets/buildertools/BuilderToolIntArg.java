// Auto-generated - do not edit
package meridian.protocol.packets.buildertools;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class BuilderToolIntArg {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 12;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 12;
    public static final int MAX_SIZE = 12;

    public int defaultValue;
    public int min;
    public int max;

    public BuilderToolIntArg() {
    }

    public BuilderToolIntArg(int defaultValue, int min, int max) {
        this.defaultValue = defaultValue;
        this.min = min;
        this.max = max;
    }

    public BuilderToolIntArg(@Nonnull BuilderToolIntArg other) {
        this.defaultValue = other.defaultValue;
        this.min = other.min;
        this.max = other.max;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolIntArg", offset, (int) mem.byteSize());
        long needed = (long) offset + 12;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolIntArg", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getDefault(MemorySegment mem) {
        return getDefault(mem, 0);
    }
    
    public static int getDefault(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static int getMin(MemorySegment mem) {
        return getMin(mem, 0);
    }
    
    public static int getMin(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 4);
    }
    
    public static int getMax(MemorySegment mem) {
        return getMax(mem, 0);
    }
    
    public static int getMax(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 8);
    }
    
    
    
    
    
    public static BuilderToolIntArg toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolIntArg toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolIntArg and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolIntArg toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BuilderToolIntArg(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4),
            mem.get(PacketIO.PROTO_INT, offset + 8)
        );
        if (cursor != null) cursor.position = offset + 12;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.defaultValue);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.min);
        mem.set(PacketIO.PROTO_INT, offset + 8, this.max);
        
        
    
       return 12;
    }
    public int computeSize() {
        return 12;
    }

    public BuilderToolIntArg clone() {
        BuilderToolIntArg copy = new BuilderToolIntArg();
        copy.defaultValue = this.defaultValue;
        copy.min = this.min;
        copy.max = this.max;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolIntArg other)) return false;
        return this.defaultValue == other.defaultValue && this.min == other.min && this.max == other.max;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(defaultValue, min, max);
    }

}