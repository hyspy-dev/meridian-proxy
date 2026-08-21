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
import meridian.protocol.Rotation;

public class BuilderToolRotationArg {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1;

    @Nonnull public Rotation defaultValue = Rotation.None;

    public BuilderToolRotationArg() {
    }

    public BuilderToolRotationArg(@Nonnull Rotation defaultValue) {
        this.defaultValue = defaultValue;
    }

    public BuilderToolRotationArg(@Nonnull BuilderToolRotationArg other) {
        this.defaultValue = other.defaultValue;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolRotationArg", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolRotationArg", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static Rotation getDefault(MemorySegment mem) {
        return getDefault(mem, 0);
    }
    
    public static Rotation getDefault(MemorySegment mem, int offset) {
        return Rotation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0));
    }
    
    
    
    
    
    public static BuilderToolRotationArg toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolRotationArg toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolRotationArg and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolRotationArg toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BuilderToolRotationArg(
            Rotation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0))
        );
        if (cursor != null) cursor.position = offset + 1;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, (byte) this.defaultValue.getValue());
        
        
    
       return 1;
    }
    public int computeSize() {
        return 1;
    }

    public BuilderToolRotationArg clone() {
        BuilderToolRotationArg copy = new BuilderToolRotationArg();
        copy.defaultValue = this.defaultValue;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolRotationArg other)) return false;
        return java.util.Objects.equals(this.defaultValue, other.defaultValue);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(defaultValue);
    }

}