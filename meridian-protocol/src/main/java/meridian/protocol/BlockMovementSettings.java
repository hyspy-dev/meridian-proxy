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


public class BlockMovementSettings {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 43;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 43;
    public static final int MAX_SIZE = 43;

    public boolean isClimbable;
    public float climbUpSpeedMultiplier;
    public float climbDownSpeedMultiplier;
    public float climbLateralSpeedMultiplier;
    public boolean isBouncy;
    public float bounceVelocity;
    public float drag;
    public float friction;
    public float terminalVelocityModifier;
    public float horizontalSpeedMultiplier;
    public float acceleration;
    public float jumpForceMultiplier;
    public boolean disableAutoStep;

    public BlockMovementSettings() {
    }

    public BlockMovementSettings(boolean isClimbable, float climbUpSpeedMultiplier, float climbDownSpeedMultiplier, float climbLateralSpeedMultiplier, boolean isBouncy, float bounceVelocity, float drag, float friction, float terminalVelocityModifier, float horizontalSpeedMultiplier, float acceleration, float jumpForceMultiplier, boolean disableAutoStep) {
        this.isClimbable = isClimbable;
        this.climbUpSpeedMultiplier = climbUpSpeedMultiplier;
        this.climbDownSpeedMultiplier = climbDownSpeedMultiplier;
        this.climbLateralSpeedMultiplier = climbLateralSpeedMultiplier;
        this.isBouncy = isBouncy;
        this.bounceVelocity = bounceVelocity;
        this.drag = drag;
        this.friction = friction;
        this.terminalVelocityModifier = terminalVelocityModifier;
        this.horizontalSpeedMultiplier = horizontalSpeedMultiplier;
        this.acceleration = acceleration;
        this.jumpForceMultiplier = jumpForceMultiplier;
        this.disableAutoStep = disableAutoStep;
    }

    public BlockMovementSettings(@Nonnull BlockMovementSettings other) {
        this.isClimbable = other.isClimbable;
        this.climbUpSpeedMultiplier = other.climbUpSpeedMultiplier;
        this.climbDownSpeedMultiplier = other.climbDownSpeedMultiplier;
        this.climbLateralSpeedMultiplier = other.climbLateralSpeedMultiplier;
        this.isBouncy = other.isBouncy;
        this.bounceVelocity = other.bounceVelocity;
        this.drag = other.drag;
        this.friction = other.friction;
        this.terminalVelocityModifier = other.terminalVelocityModifier;
        this.horizontalSpeedMultiplier = other.horizontalSpeedMultiplier;
        this.acceleration = other.acceleration;
        this.jumpForceMultiplier = other.jumpForceMultiplier;
        this.disableAutoStep = other.disableAutoStep;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BlockMovementSettings", offset, (int) mem.byteSize());
        long needed = (long) offset + 43;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockMovementSettings", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getIsClimbable(MemorySegment mem) {
        return getIsClimbable(mem, 0);
    }
    
    public static boolean getIsClimbable(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 0);
    }
    
    public static float getClimbUpSpeedMultiplier(MemorySegment mem) {
        return getClimbUpSpeedMultiplier(mem, 0);
    }
    
    public static float getClimbUpSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "ClimbUpSpeedMultiplier");
    }
    
    public static float getClimbDownSpeedMultiplier(MemorySegment mem) {
        return getClimbDownSpeedMultiplier(mem, 0);
    }
    
    public static float getClimbDownSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "ClimbDownSpeedMultiplier");
    }
    
    public static float getClimbLateralSpeedMultiplier(MemorySegment mem) {
        return getClimbLateralSpeedMultiplier(mem, 0);
    }
    
    public static float getClimbLateralSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "ClimbLateralSpeedMultiplier");
    }
    
    public static boolean getIsBouncy(MemorySegment mem) {
        return getIsBouncy(mem, 0);
    }
    
    public static boolean getIsBouncy(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 13);
    }
    
    public static float getBounceVelocity(MemorySegment mem) {
        return getBounceVelocity(mem, 0);
    }
    
    public static float getBounceVelocity(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 14), "BounceVelocity");
    }
    
    public static float getDrag(MemorySegment mem) {
        return getDrag(mem, 0);
    }
    
    public static float getDrag(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 18), "Drag");
    }
    
    public static float getFriction(MemorySegment mem) {
        return getFriction(mem, 0);
    }
    
    public static float getFriction(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 22), "Friction");
    }
    
    public static float getTerminalVelocityModifier(MemorySegment mem) {
        return getTerminalVelocityModifier(mem, 0);
    }
    
    public static float getTerminalVelocityModifier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 26), "TerminalVelocityModifier");
    }
    
    public static float getHorizontalSpeedMultiplier(MemorySegment mem) {
        return getHorizontalSpeedMultiplier(mem, 0);
    }
    
    public static float getHorizontalSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 30), "HorizontalSpeedMultiplier");
    }
    
    public static float getAcceleration(MemorySegment mem) {
        return getAcceleration(mem, 0);
    }
    
    public static float getAcceleration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 34), "Acceleration");
    }
    
    public static float getJumpForceMultiplier(MemorySegment mem) {
        return getJumpForceMultiplier(mem, 0);
    }
    
    public static float getJumpForceMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 38), "JumpForceMultiplier");
    }
    
    public static boolean getDisableAutoStep(MemorySegment mem) {
        return getDisableAutoStep(mem, 0);
    }
    
    public static boolean getDisableAutoStep(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 42);
    }
    
    
    
    
    
    public static BlockMovementSettings toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BlockMovementSettings toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BlockMovementSettings and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BlockMovementSettings toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BlockMovementSettings(
            mem.get(PacketIO.PROTO_BOOL, offset + 0),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "ClimbUpSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "ClimbDownSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "ClimbLateralSpeedMultiplier"),
            mem.get(PacketIO.PROTO_BOOL, offset + 13),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 14), "BounceVelocity"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 18), "Drag"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 22), "Friction"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 26), "TerminalVelocityModifier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 30), "HorizontalSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 34), "Acceleration"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 38), "JumpForceMultiplier"),
            mem.get(PacketIO.PROTO_BOOL, offset + 42)
        );
        if (cursor != null) cursor.position = offset + 43;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BOOL, offset + 0, this.isClimbable);
        PacketIO.requireFinite(this.climbUpSpeedMultiplier, "ClimbUpSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.climbUpSpeedMultiplier);
        PacketIO.requireFinite(this.climbDownSpeedMultiplier, "ClimbDownSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.climbDownSpeedMultiplier);
        PacketIO.requireFinite(this.climbLateralSpeedMultiplier, "ClimbLateralSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 9, this.climbLateralSpeedMultiplier);
        mem.set(PacketIO.PROTO_BOOL, offset + 13, this.isBouncy);
        PacketIO.requireFinite(this.bounceVelocity, "BounceVelocity"); mem.set(PacketIO.PROTO_FLOAT, offset + 14, this.bounceVelocity);
        PacketIO.requireFinite(this.drag, "Drag"); mem.set(PacketIO.PROTO_FLOAT, offset + 18, this.drag);
        PacketIO.requireFinite(this.friction, "Friction"); mem.set(PacketIO.PROTO_FLOAT, offset + 22, this.friction);
        PacketIO.requireFinite(this.terminalVelocityModifier, "TerminalVelocityModifier"); mem.set(PacketIO.PROTO_FLOAT, offset + 26, this.terminalVelocityModifier);
        PacketIO.requireFinite(this.horizontalSpeedMultiplier, "HorizontalSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 30, this.horizontalSpeedMultiplier);
        PacketIO.requireFinite(this.acceleration, "Acceleration"); mem.set(PacketIO.PROTO_FLOAT, offset + 34, this.acceleration);
        PacketIO.requireFinite(this.jumpForceMultiplier, "JumpForceMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 38, this.jumpForceMultiplier);
        mem.set(PacketIO.PROTO_BOOL, offset + 42, this.disableAutoStep);
        
        
    
       return 43;
    }
    public int computeSize() {
        return 43;
    }

    public BlockMovementSettings clone() {
        BlockMovementSettings copy = new BlockMovementSettings();
        copy.isClimbable = this.isClimbable;
        copy.climbUpSpeedMultiplier = this.climbUpSpeedMultiplier;
        copy.climbDownSpeedMultiplier = this.climbDownSpeedMultiplier;
        copy.climbLateralSpeedMultiplier = this.climbLateralSpeedMultiplier;
        copy.isBouncy = this.isBouncy;
        copy.bounceVelocity = this.bounceVelocity;
        copy.drag = this.drag;
        copy.friction = this.friction;
        copy.terminalVelocityModifier = this.terminalVelocityModifier;
        copy.horizontalSpeedMultiplier = this.horizontalSpeedMultiplier;
        copy.acceleration = this.acceleration;
        copy.jumpForceMultiplier = this.jumpForceMultiplier;
        copy.disableAutoStep = this.disableAutoStep;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BlockMovementSettings other)) return false;
        return this.isClimbable == other.isClimbable && this.climbUpSpeedMultiplier == other.climbUpSpeedMultiplier && this.climbDownSpeedMultiplier == other.climbDownSpeedMultiplier && this.climbLateralSpeedMultiplier == other.climbLateralSpeedMultiplier && this.isBouncy == other.isBouncy && this.bounceVelocity == other.bounceVelocity && this.drag == other.drag && this.friction == other.friction && this.terminalVelocityModifier == other.terminalVelocityModifier && this.horizontalSpeedMultiplier == other.horizontalSpeedMultiplier && this.acceleration == other.acceleration && this.jumpForceMultiplier == other.jumpForceMultiplier && this.disableAutoStep == other.disableAutoStep;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(isClimbable, climbUpSpeedMultiplier, climbDownSpeedMultiplier, climbLateralSpeedMultiplier, isBouncy, bounceVelocity, drag, friction, terminalVelocityModifier, horizontalSpeedMultiplier, acceleration, jumpForceMultiplier, disableAutoStep);
    }

}