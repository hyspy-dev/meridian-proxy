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


public class EasingConfig {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 5;
    public static final int MAX_SIZE = 5;

    public float time;
    @Nonnull public EasingType type = EasingType.Linear;

    public EasingConfig() {
    }

    public EasingConfig(float time, @Nonnull EasingType type) {
        this.time = time;
        this.type = type;
    }

    public EasingConfig(@Nonnull EasingConfig other) {
        this.time = other.time;
        this.type = other.type;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("EasingConfig", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("EasingConfig", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getTime(MemorySegment mem) {
        return getTime(mem, 0);
    }
    
    public static float getTime(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "Time");
    }
    
    public static EasingType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static EasingType getType(MemorySegment mem, int offset) {
        return EasingType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 4));
    }
    
    
    
    
    
    public static EasingConfig toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static EasingConfig toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one EasingConfig and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static EasingConfig toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new EasingConfig(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "Time"),
            EasingType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 4))
        );
        if (cursor != null) cursor.position = offset + 5;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.time, "Time"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.time);
        mem.set(PacketIO.PROTO_BYTE, offset + 4, (byte) this.type.getValue());
        
        
    
       return 5;
    }
    public int computeSize() {
        return 5;
    }

    public EasingConfig clone() {
        EasingConfig copy = new EasingConfig();
        copy.time = this.time;
        copy.type = this.type;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EasingConfig other)) return false;
        return this.time == other.time && java.util.Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(time, type);
    }

}