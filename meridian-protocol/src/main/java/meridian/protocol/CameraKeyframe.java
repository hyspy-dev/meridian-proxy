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


public class CameraKeyframe {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 94;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 94;
    public static final int MAX_SIZE = 94;

    @Nullable public Position position;
    @Nullable public Direction look;
    @Nullable public Position lookAtPoint;
    public float duration;
    @Nonnull public EasingType easing = EasingType.Linear;
    @Nullable public Float fov;
    @Nullable public DepthOfFieldSettings depthOfField;

    public CameraKeyframe() {
    }

    public CameraKeyframe(@Nullable Position position, @Nullable Direction look, @Nullable Position lookAtPoint, float duration, @Nonnull EasingType easing, @Nullable Float fov, @Nullable DepthOfFieldSettings depthOfField) {
        this.position = position;
        this.look = look;
        this.lookAtPoint = lookAtPoint;
        this.duration = duration;
        this.easing = easing;
        this.fov = fov;
        this.depthOfField = depthOfField;
    }

    public CameraKeyframe(@Nonnull CameraKeyframe other) {
        this.position = other.position;
        this.look = other.look;
        this.lookAtPoint = other.lookAtPoint;
        this.duration = other.duration;
        this.easing = other.easing;
        this.fov = other.fov;
        this.depthOfField = other.depthOfField;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CameraKeyframe", offset, (int) mem.byteSize());
        long needed = (long) offset + 94;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CameraKeyframe", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static Position getPosition(MemorySegment mem) {
        return getPosition(mem, 0);
    }
    
    @Nullable
    public static Position getPosition(MemorySegment mem, int offset) {
        return hasPosition(mem, offset) ? Position.toObject(mem, offset + 1): null;
    }
    
    @Nullable
    public static Direction getLook(MemorySegment mem) {
        return getLook(mem, 0);
    }
    
    @Nullable
    public static Direction getLook(MemorySegment mem, int offset) {
        return hasLook(mem, offset) ? Direction.toObject(mem, offset + 25): null;
    }
    
    @Nullable
    public static Position getLookAtPoint(MemorySegment mem) {
        return getLookAtPoint(mem, 0);
    }
    
    @Nullable
    public static Position getLookAtPoint(MemorySegment mem, int offset) {
        return hasLookAtPoint(mem, offset) ? Position.toObject(mem, offset + 37): null;
    }
    
    public static float getDuration(MemorySegment mem) {
        return getDuration(mem, 0);
    }
    
    public static float getDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 61), "Duration");
    }
    
    public static EasingType getEasing(MemorySegment mem) {
        return getEasing(mem, 0);
    }
    
    public static EasingType getEasing(MemorySegment mem, int offset) {
        return EasingType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 65));
    }
    
    @Nullable
    public static Float getFov(MemorySegment mem) {
        return getFov(mem, 0);
    }
    
    @Nullable
    public static Float getFov(MemorySegment mem, int offset) {
        return hasFov(mem, offset) ? PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 66), "Fov"): null;
    }
    
    @Nullable
    public static DepthOfFieldSettings getDepthOfField(MemorySegment mem) {
        return getDepthOfField(mem, 0);
    }
    
    @Nullable
    public static DepthOfFieldSettings getDepthOfField(MemorySegment mem, int offset) {
        return hasDepthOfField(mem, offset) ? DepthOfFieldSettings.toObject(mem, offset + 70): null;
    }
    
    public static boolean hasPosition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasLook(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasLookAtPoint(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasFov(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasDepthOfField(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    
    
    public static CameraKeyframe toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CameraKeyframe toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CameraKeyframe and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CameraKeyframe toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new CameraKeyframe(
            hasPosition(mem, offset) ? Position.toObject(mem, offset + 1) : null,
            hasLook(mem, offset) ? Direction.toObject(mem, offset + 25) : null,
            hasLookAtPoint(mem, offset) ? Position.toObject(mem, offset + 37) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 61), "Duration"),
            EasingType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 65)),
            hasFov(mem, offset) ? PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 66), "Fov") : null,
            hasDepthOfField(mem, offset) ? DepthOfFieldSettings.toObject(mem, offset + 70) : null
        );
        if (cursor != null) cursor.position = offset + 94;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.position != null) nullBits |= 0x01;
        if (this.look != null) nullBits |= 0x02;
        if (this.lookAtPoint != null) nullBits |= 0x04;
        if (this.fov != null) nullBits |= 0x08;
        if (this.depthOfField != null) nullBits |= 0x10;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.position != null) {
            this.position.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 24).fill((byte) 0); 
        }
        if (this.look != null) {
            this.look.serialize(mem, offset + 25);
        } else {
            mem.asSlice(offset + 25, 12).fill((byte) 0); 
        }
        if (this.lookAtPoint != null) {
            this.lookAtPoint.serialize(mem, offset + 37);
        } else {
            mem.asSlice(offset + 37, 24).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.duration, "Duration"); mem.set(PacketIO.PROTO_FLOAT, offset + 61, this.duration);
        mem.set(PacketIO.PROTO_BYTE, offset + 65, (byte) this.easing.getValue());
        if (this.fov != null) {
            PacketIO.requireFinite(this.fov, "Fov"); mem.set(PacketIO.PROTO_FLOAT, offset + 66, this.fov);
        } else {
            mem.asSlice(offset + 66, 4).fill((byte) 0); 
        }
        if (this.depthOfField != null) {
            this.depthOfField.serialize(mem, offset + 70);
        } else {
            mem.asSlice(offset + 70, 24).fill((byte) 0); 
        }
        
        
    
       return 94;
    }
    public int computeSize() {
        return 94;
    }

    public CameraKeyframe clone() {
        CameraKeyframe copy = new CameraKeyframe();
        copy.position = this.position != null ? this.position.clone() : null;
        copy.look = this.look != null ? this.look.clone() : null;
        copy.lookAtPoint = this.lookAtPoint != null ? this.lookAtPoint.clone() : null;
        copy.duration = this.duration;
        copy.easing = this.easing;
        copy.fov = this.fov;
        copy.depthOfField = this.depthOfField != null ? this.depthOfField.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CameraKeyframe other)) return false;
        return java.util.Objects.equals(this.position, other.position) && java.util.Objects.equals(this.look, other.look) && java.util.Objects.equals(this.lookAtPoint, other.lookAtPoint) && this.duration == other.duration && java.util.Objects.equals(this.easing, other.easing) && java.util.Objects.equals(this.fov, other.fov) && java.util.Objects.equals(this.depthOfField, other.depthOfField);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(position, look, lookAtPoint, duration, easing, fov, depthOfField);
    }

}