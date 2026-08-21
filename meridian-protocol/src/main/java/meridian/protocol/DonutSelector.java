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

public class DonutSelector extends Selector {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 37;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 37;
    public static final int MAX_SIZE = 37;

    public float minRadius;
    public float maxRadius;
    public float width;
    public float height;
    public float angle;
    @Nullable public Vector3fc offset;
    public float yawOffset;

    public DonutSelector() {
    }

    public DonutSelector(float minRadius, float maxRadius, float width, float height, float angle, @Nullable Vector3fc offset, float yawOffset) {
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
        this.width = width;
        this.height = height;
        this.angle = angle;
        this.offset = offset;
        this.yawOffset = yawOffset;
    }

    public DonutSelector(@Nonnull DonutSelector other) {
        this.minRadius = other.minRadius;
        this.maxRadius = other.maxRadius;
        this.width = other.width;
        this.height = other.height;
        this.angle = other.angle;
        this.offset = other.offset;
        this.yawOffset = other.yawOffset;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("DonutSelector", offset, (int) mem.byteSize());
        long needed = (long) offset + 37;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("DonutSelector", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getMinRadius(MemorySegment mem) {
        return getMinRadius(mem, 0);
    }
    
    public static float getMinRadius(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "MinRadius");
    }
    
    public static float getMaxRadius(MemorySegment mem) {
        return getMaxRadius(mem, 0);
    }
    
    public static float getMaxRadius(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "MaxRadius");
    }
    
    public static float getWidth(MemorySegment mem) {
        return getWidth(mem, 0);
    }
    
    public static float getWidth(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "Width");
    }
    
    public static float getHeight(MemorySegment mem) {
        return getHeight(mem, 0);
    }
    
    public static float getHeight(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 13), "Height");
    }
    
    public static float getAngle(MemorySegment mem) {
        return getAngle(mem, 0);
    }
    
    public static float getAngle(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 17), "Angle");
    }
    
    @Nullable
    public static Vector3fc getOffset(MemorySegment mem) {
        return getOffset(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getOffset(MemorySegment mem, int offset) {
        return hasOffset(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 21), "Offset"): null;
    }
    
    public static float getYawOffset(MemorySegment mem) {
        return getYawOffset(mem, 0);
    }
    
    public static float getYawOffset(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 33), "YawOffset");
    }
    
    public static boolean hasOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static DonutSelector toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static DonutSelector toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one DonutSelector and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static DonutSelector toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new DonutSelector(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "MinRadius"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "MaxRadius"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "Width"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 13), "Height"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 17), "Angle"),
            hasOffset(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 21), "Offset") : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 33), "YawOffset")
        );
        if (cursor != null) cursor.position = offset + 37;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.offset != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.minRadius, "MinRadius"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.minRadius);
        PacketIO.requireFinite(this.maxRadius, "MaxRadius"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.maxRadius);
        PacketIO.requireFinite(this.width, "Width"); mem.set(PacketIO.PROTO_FLOAT, offset + 9, this.width);
        PacketIO.requireFinite(this.height, "Height"); mem.set(PacketIO.PROTO_FLOAT, offset + 13, this.height);
        PacketIO.requireFinite(this.angle, "Angle"); mem.set(PacketIO.PROTO_FLOAT, offset + 17, this.angle);
        if (this.offset != null) {
            PacketIO.requireFinite(this.offset, "Offset"); PacketIO.writeVector3f(mem, offset + 21, this.offset);
        } else {
            mem.asSlice(offset + 21, 12).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.yawOffset, "YawOffset"); mem.set(PacketIO.PROTO_FLOAT, offset + 33, this.yawOffset);
        
        
    
       return 37;
    }
    @Override
    public int computeSize() {
        return 37;
    }

    public DonutSelector clone() {
        DonutSelector copy = new DonutSelector();
        copy.minRadius = this.minRadius;
        copy.maxRadius = this.maxRadius;
        copy.width = this.width;
        copy.height = this.height;
        copy.angle = this.angle;
        copy.offset = this.offset;
        copy.yawOffset = this.yawOffset;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DonutSelector other)) return false;
        return this.minRadius == other.minRadius && this.maxRadius == other.maxRadius && this.width == other.width && this.height == other.height && this.angle == other.angle && java.util.Objects.equals(this.offset, other.offset) && this.yawOffset == other.yawOffset;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(minRadius, maxRadius, width, height, angle, offset, yawOffset);
    }

}