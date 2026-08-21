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


public class ParticleCollision {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 3;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 3;
    public static final int MAX_SIZE = 3;

    @Nonnull public ParticleCollisionBlockType blockType = ParticleCollisionBlockType.None;
    @Nonnull public ParticleCollisionAction action = ParticleCollisionAction.Expire;
    @Nonnull public ParticleRotationInfluence particleRotationInfluence = ParticleRotationInfluence.None;

    public ParticleCollision() {
    }

    public ParticleCollision(@Nonnull ParticleCollisionBlockType blockType, @Nonnull ParticleCollisionAction action, @Nonnull ParticleRotationInfluence particleRotationInfluence) {
        this.blockType = blockType;
        this.action = action;
        this.particleRotationInfluence = particleRotationInfluence;
    }

    public ParticleCollision(@Nonnull ParticleCollision other) {
        this.blockType = other.blockType;
        this.action = other.action;
        this.particleRotationInfluence = other.particleRotationInfluence;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ParticleCollision", offset, (int) mem.byteSize());
        long needed = (long) offset + 3;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ParticleCollision", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static ParticleCollisionBlockType getBlockType(MemorySegment mem) {
        return getBlockType(mem, 0);
    }
    
    public static ParticleCollisionBlockType getBlockType(MemorySegment mem, int offset) {
        return ParticleCollisionBlockType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0));
    }
    
    public static ParticleCollisionAction getAction(MemorySegment mem) {
        return getAction(mem, 0);
    }
    
    public static ParticleCollisionAction getAction(MemorySegment mem, int offset) {
        return ParticleCollisionAction.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static ParticleRotationInfluence getParticleRotationInfluence(MemorySegment mem) {
        return getParticleRotationInfluence(mem, 0);
    }
    
    public static ParticleRotationInfluence getParticleRotationInfluence(MemorySegment mem, int offset) {
        return ParticleRotationInfluence.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2));
    }
    
    
    
    
    
    public static ParticleCollision toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ParticleCollision toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ParticleCollision and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ParticleCollision toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new ParticleCollision(
            ParticleCollisionBlockType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0)),
            ParticleCollisionAction.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            ParticleRotationInfluence.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2))
        );
        if (cursor != null) cursor.position = offset + 3;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, (byte) this.blockType.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.action.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 2, (byte) this.particleRotationInfluence.getValue());
        
        
    
       return 3;
    }
    public int computeSize() {
        return 3;
    }

    public ParticleCollision clone() {
        ParticleCollision copy = new ParticleCollision();
        copy.blockType = this.blockType;
        copy.action = this.action;
        copy.particleRotationInfluence = this.particleRotationInfluence;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ParticleCollision other)) return false;
        return java.util.Objects.equals(this.blockType, other.blockType) && java.util.Objects.equals(this.action, other.action) && java.util.Objects.equals(this.particleRotationInfluence, other.particleRotationInfluence);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(blockType, action, particleRotationInfluence);
    }

}