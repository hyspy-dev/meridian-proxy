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


public class Direction {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 12;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 12;
    public static final int MAX_SIZE = 12;

    public float yaw;
    public float pitch;
    public float roll;

    public Direction() {
    }

    public Direction(float yaw, float pitch, float roll) {
        this.yaw = yaw;
        this.pitch = pitch;
        this.roll = roll;
    }

    public Direction(@Nonnull Direction other) {
        this.yaw = other.yaw;
        this.pitch = other.pitch;
        this.roll = other.roll;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Direction", offset, (int) mem.byteSize());
        long needed = (long) offset + 12;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Direction", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getYaw(MemorySegment mem) {
        return getYaw(mem, 0);
    }
    
    public static float getYaw(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "Yaw");
    }
    
    public static float getPitch(MemorySegment mem) {
        return getPitch(mem, 0);
    }
    
    public static float getPitch(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "Pitch");
    }
    
    public static float getRoll(MemorySegment mem) {
        return getRoll(mem, 0);
    }
    
    public static float getRoll(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "Roll");
    }
    
    
    
    
    
    public static Direction toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Direction toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Direction and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Direction toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new Direction(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "Yaw"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "Pitch"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "Roll")
        );
        if (cursor != null) cursor.position = offset + 12;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.yaw, "Yaw"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.yaw);
        PacketIO.requireFinite(this.pitch, "Pitch"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.pitch);
        PacketIO.requireFinite(this.roll, "Roll"); mem.set(PacketIO.PROTO_FLOAT, offset + 8, this.roll);
        
        
    
       return 12;
    }
    public int computeSize() {
        return 12;
    }

    public Direction clone() {
        Direction copy = new Direction();
        copy.yaw = this.yaw;
        copy.pitch = this.pitch;
        copy.roll = this.roll;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Direction other)) return false;
        return this.yaw == other.yaw && this.pitch == other.pitch && this.roll == other.roll;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(yaw, pitch, roll);
    }

}