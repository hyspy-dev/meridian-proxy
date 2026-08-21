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

public class ParticleAttractor {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 85;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 85;
    public static final int MAX_SIZE = 85;

    @Nullable public Vector3fc position;
    @Nullable public Vector3fc radialAxis;
    public float trailPositionMultiplier;
    public float radius;
    public float radialAcceleration;
    public float radialTangentAcceleration;
    @Nullable public Vector3fc linearAcceleration;
    public float radialImpulse;
    public float radialTangentImpulse;
    @Nullable public Vector3fc linearImpulse;
    @Nullable public Vector3fc dampingMultiplier;

    public ParticleAttractor() {
    }

    public ParticleAttractor(@Nullable Vector3fc position, @Nullable Vector3fc radialAxis, float trailPositionMultiplier, float radius, float radialAcceleration, float radialTangentAcceleration, @Nullable Vector3fc linearAcceleration, float radialImpulse, float radialTangentImpulse, @Nullable Vector3fc linearImpulse, @Nullable Vector3fc dampingMultiplier) {
        this.position = position;
        this.radialAxis = radialAxis;
        this.trailPositionMultiplier = trailPositionMultiplier;
        this.radius = radius;
        this.radialAcceleration = radialAcceleration;
        this.radialTangentAcceleration = radialTangentAcceleration;
        this.linearAcceleration = linearAcceleration;
        this.radialImpulse = radialImpulse;
        this.radialTangentImpulse = radialTangentImpulse;
        this.linearImpulse = linearImpulse;
        this.dampingMultiplier = dampingMultiplier;
    }

    public ParticleAttractor(@Nonnull ParticleAttractor other) {
        this.position = other.position;
        this.radialAxis = other.radialAxis;
        this.trailPositionMultiplier = other.trailPositionMultiplier;
        this.radius = other.radius;
        this.radialAcceleration = other.radialAcceleration;
        this.radialTangentAcceleration = other.radialTangentAcceleration;
        this.linearAcceleration = other.linearAcceleration;
        this.radialImpulse = other.radialImpulse;
        this.radialTangentImpulse = other.radialTangentImpulse;
        this.linearImpulse = other.linearImpulse;
        this.dampingMultiplier = other.dampingMultiplier;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ParticleAttractor", offset, (int) mem.byteSize());
        long needed = (long) offset + 85;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ParticleAttractor", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static Vector3fc getPosition(MemorySegment mem) {
        return getPosition(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getPosition(MemorySegment mem, int offset) {
        return hasPosition(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 1), "Position"): null;
    }
    
    @Nullable
    public static Vector3fc getRadialAxis(MemorySegment mem) {
        return getRadialAxis(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getRadialAxis(MemorySegment mem, int offset) {
        return hasRadialAxis(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 13), "RadialAxis"): null;
    }
    
    public static float getTrailPositionMultiplier(MemorySegment mem) {
        return getTrailPositionMultiplier(mem, 0);
    }
    
    public static float getTrailPositionMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 25), "TrailPositionMultiplier");
    }
    
    public static float getRadius(MemorySegment mem) {
        return getRadius(mem, 0);
    }
    
    public static float getRadius(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 29), "Radius");
    }
    
    public static float getRadialAcceleration(MemorySegment mem) {
        return getRadialAcceleration(mem, 0);
    }
    
    public static float getRadialAcceleration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 33), "RadialAcceleration");
    }
    
    public static float getRadialTangentAcceleration(MemorySegment mem) {
        return getRadialTangentAcceleration(mem, 0);
    }
    
    public static float getRadialTangentAcceleration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 37), "RadialTangentAcceleration");
    }
    
    @Nullable
    public static Vector3fc getLinearAcceleration(MemorySegment mem) {
        return getLinearAcceleration(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getLinearAcceleration(MemorySegment mem, int offset) {
        return hasLinearAcceleration(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 41), "LinearAcceleration"): null;
    }
    
    public static float getRadialImpulse(MemorySegment mem) {
        return getRadialImpulse(mem, 0);
    }
    
    public static float getRadialImpulse(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 53), "RadialImpulse");
    }
    
    public static float getRadialTangentImpulse(MemorySegment mem) {
        return getRadialTangentImpulse(mem, 0);
    }
    
    public static float getRadialTangentImpulse(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 57), "RadialTangentImpulse");
    }
    
    @Nullable
    public static Vector3fc getLinearImpulse(MemorySegment mem) {
        return getLinearImpulse(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getLinearImpulse(MemorySegment mem, int offset) {
        return hasLinearImpulse(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 61), "LinearImpulse"): null;
    }
    
    @Nullable
    public static Vector3fc getDampingMultiplier(MemorySegment mem) {
        return getDampingMultiplier(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getDampingMultiplier(MemorySegment mem, int offset) {
        return hasDampingMultiplier(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 73), "DampingMultiplier"): null;
    }
    
    public static boolean hasPosition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasRadialAxis(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasLinearAcceleration(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasLinearImpulse(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasDampingMultiplier(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    
    
    public static ParticleAttractor toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ParticleAttractor toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ParticleAttractor and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ParticleAttractor toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new ParticleAttractor(
            hasPosition(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 1), "Position") : null,
            hasRadialAxis(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 13), "RadialAxis") : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 25), "TrailPositionMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 29), "Radius"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 33), "RadialAcceleration"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 37), "RadialTangentAcceleration"),
            hasLinearAcceleration(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 41), "LinearAcceleration") : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 53), "RadialImpulse"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 57), "RadialTangentImpulse"),
            hasLinearImpulse(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 61), "LinearImpulse") : null,
            hasDampingMultiplier(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 73), "DampingMultiplier") : null
        );
        if (cursor != null) cursor.position = offset + 85;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.position != null) nullBits |= 0x01;
        if (this.radialAxis != null) nullBits |= 0x02;
        if (this.linearAcceleration != null) nullBits |= 0x04;
        if (this.linearImpulse != null) nullBits |= 0x08;
        if (this.dampingMultiplier != null) nullBits |= 0x10;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.position != null) {
            PacketIO.requireFinite(this.position, "Position"); PacketIO.writeVector3f(mem, offset + 1, this.position);
        } else {
            mem.asSlice(offset + 1, 12).fill((byte) 0); 
        }
        if (this.radialAxis != null) {
            PacketIO.requireFinite(this.radialAxis, "RadialAxis"); PacketIO.writeVector3f(mem, offset + 13, this.radialAxis);
        } else {
            mem.asSlice(offset + 13, 12).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.trailPositionMultiplier, "TrailPositionMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 25, this.trailPositionMultiplier);
        PacketIO.requireFinite(this.radius, "Radius"); mem.set(PacketIO.PROTO_FLOAT, offset + 29, this.radius);
        PacketIO.requireFinite(this.radialAcceleration, "RadialAcceleration"); mem.set(PacketIO.PROTO_FLOAT, offset + 33, this.radialAcceleration);
        PacketIO.requireFinite(this.radialTangentAcceleration, "RadialTangentAcceleration"); mem.set(PacketIO.PROTO_FLOAT, offset + 37, this.radialTangentAcceleration);
        if (this.linearAcceleration != null) {
            PacketIO.requireFinite(this.linearAcceleration, "LinearAcceleration"); PacketIO.writeVector3f(mem, offset + 41, this.linearAcceleration);
        } else {
            mem.asSlice(offset + 41, 12).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.radialImpulse, "RadialImpulse"); mem.set(PacketIO.PROTO_FLOAT, offset + 53, this.radialImpulse);
        PacketIO.requireFinite(this.radialTangentImpulse, "RadialTangentImpulse"); mem.set(PacketIO.PROTO_FLOAT, offset + 57, this.radialTangentImpulse);
        if (this.linearImpulse != null) {
            PacketIO.requireFinite(this.linearImpulse, "LinearImpulse"); PacketIO.writeVector3f(mem, offset + 61, this.linearImpulse);
        } else {
            mem.asSlice(offset + 61, 12).fill((byte) 0); 
        }
        if (this.dampingMultiplier != null) {
            PacketIO.requireFinite(this.dampingMultiplier, "DampingMultiplier"); PacketIO.writeVector3f(mem, offset + 73, this.dampingMultiplier);
        } else {
            mem.asSlice(offset + 73, 12).fill((byte) 0); 
        }
        
        
    
       return 85;
    }
    public int computeSize() {
        return 85;
    }

    public ParticleAttractor clone() {
        ParticleAttractor copy = new ParticleAttractor();
        copy.position = this.position;
        copy.radialAxis = this.radialAxis;
        copy.trailPositionMultiplier = this.trailPositionMultiplier;
        copy.radius = this.radius;
        copy.radialAcceleration = this.radialAcceleration;
        copy.radialTangentAcceleration = this.radialTangentAcceleration;
        copy.linearAcceleration = this.linearAcceleration;
        copy.radialImpulse = this.radialImpulse;
        copy.radialTangentImpulse = this.radialTangentImpulse;
        copy.linearImpulse = this.linearImpulse;
        copy.dampingMultiplier = this.dampingMultiplier;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ParticleAttractor other)) return false;
        return java.util.Objects.equals(this.position, other.position) && java.util.Objects.equals(this.radialAxis, other.radialAxis) && this.trailPositionMultiplier == other.trailPositionMultiplier && this.radius == other.radius && this.radialAcceleration == other.radialAcceleration && this.radialTangentAcceleration == other.radialTangentAcceleration && java.util.Objects.equals(this.linearAcceleration, other.linearAcceleration) && this.radialImpulse == other.radialImpulse && this.radialTangentImpulse == other.radialTangentImpulse && java.util.Objects.equals(this.linearImpulse, other.linearImpulse) && java.util.Objects.equals(this.dampingMultiplier, other.dampingMultiplier);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(position, radialAxis, trailPositionMultiplier, radius, radialAcceleration, radialTangentAcceleration, linearAcceleration, radialImpulse, radialTangentImpulse, linearImpulse, dampingMultiplier);
    }

}