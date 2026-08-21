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
import org.joml.*;

public class AppliedForce {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 17;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 17;
    public static final int MAX_SIZE = 17;

    @Nonnull public Vector3fc direction = PacketIO.ZERO_VECTOR3;
    public boolean adjustVertical;
    public float force;

    public AppliedForce() {
    }

    public AppliedForce(@Nonnull Vector3fc direction, boolean adjustVertical, float force) {
        this.direction = direction;
        this.adjustVertical = adjustVertical;
        this.force = force;
    }

    public AppliedForce(@Nonnull AppliedForce other) {
        this.direction = other.direction;
        this.adjustVertical = other.adjustVertical;
        this.force = other.force;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AppliedForce", offset, (int) mem.byteSize());
        long needed = (long) offset + 17;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AppliedForce", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static Vector3fc getDirection(MemorySegment mem) {
        return getDirection(mem, 0);
    }
    
    public static Vector3fc getDirection(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 0), "Direction");
    }
    
    public static boolean getAdjustVertical(MemorySegment mem) {
        return getAdjustVertical(mem, 0);
    }
    
    public static boolean getAdjustVertical(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 12);
    }
    
    public static float getForce(MemorySegment mem) {
        return getForce(mem, 0);
    }
    
    public static float getForce(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 13), "Force");
    }
    
    
    
    
    
    public static AppliedForce toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AppliedForce toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AppliedForce and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AppliedForce toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new AppliedForce(
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 0), "Direction"),
            mem.get(PacketIO.PROTO_BOOL, offset + 12),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 13), "Force")
        );
        if (cursor != null) cursor.position = offset + 17;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.direction, "Direction"); PacketIO.writeVector3f(mem, offset + 0, this.direction);
        mem.set(PacketIO.PROTO_BOOL, offset + 12, this.adjustVertical);
        PacketIO.requireFinite(this.force, "Force"); mem.set(PacketIO.PROTO_FLOAT, offset + 13, this.force);
        
        
    
       return 17;
    }
    public int computeSize() {
        return 17;
    }

    public AppliedForce clone() {
        AppliedForce copy = new AppliedForce();
        copy.direction = this.direction;
        copy.adjustVertical = this.adjustVertical;
        copy.force = this.force;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AppliedForce other)) return false;
        return java.util.Objects.equals(this.direction, other.direction) && this.adjustVertical == other.adjustVertical && this.force == other.force;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(direction, adjustVertical, force);
    }

}