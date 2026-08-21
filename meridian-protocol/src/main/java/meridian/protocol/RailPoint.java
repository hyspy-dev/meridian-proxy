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

public class RailPoint {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 24;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 24;
    public static final int MAX_SIZE = 24;

    @Nonnull public Vector3fc point = PacketIO.ZERO_VECTOR3;
    @Nonnull public Vector3fc normal = PacketIO.ZERO_VECTOR3;

    public RailPoint() {
    }

    public RailPoint(@Nonnull Vector3fc point, @Nonnull Vector3fc normal) {
        this.point = point;
        this.normal = normal;
    }

    public RailPoint(@Nonnull RailPoint other) {
        this.point = other.point;
        this.normal = other.normal;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("RailPoint", offset, (int) mem.byteSize());
        long needed = (long) offset + 24;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("RailPoint", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static Vector3fc getPoint(MemorySegment mem) {
        return getPoint(mem, 0);
    }
    
    public static Vector3fc getPoint(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 0), "Point");
    }
    
    public static Vector3fc getNormal(MemorySegment mem) {
        return getNormal(mem, 0);
    }
    
    public static Vector3fc getNormal(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 12), "Normal");
    }
    
    
    
    
    
    public static RailPoint toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static RailPoint toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one RailPoint and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static RailPoint toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new RailPoint(
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 0), "Point"),
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 12), "Normal")
        );
        if (cursor != null) cursor.position = offset + 24;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.point, "Point"); PacketIO.writeVector3f(mem, offset + 0, this.point);
        PacketIO.requireFinite(this.normal, "Normal"); PacketIO.writeVector3f(mem, offset + 12, this.normal);
        
        
    
       return 24;
    }
    public int computeSize() {
        return 24;
    }

    public RailPoint clone() {
        RailPoint copy = new RailPoint();
        copy.point = this.point;
        copy.normal = this.normal;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RailPoint other)) return false;
        return java.util.Objects.equals(this.point, other.point) && java.util.Objects.equals(this.normal, other.normal);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(point, normal);
    }

}