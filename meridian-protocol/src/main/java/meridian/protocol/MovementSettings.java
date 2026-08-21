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


public class MovementSettings {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 259;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 259;
    public static final int MAX_SIZE = 259;

    public float mass;
    public float dragCoefficient;
    public boolean invertedGravity;
    public float velocityResistance;
    public float jumpForce;
    public float swimJumpForce;
    public float jumpBufferDuration;
    public float jumpBufferMaxYVelocity;
    public float acceleration;
    public float airDragMin;
    public float airDragMax;
    public float airDragMinSpeed;
    public float airDragMaxSpeed;
    public float airFrictionMin;
    public float airFrictionMax;
    public float airFrictionMinSpeed;
    public float airFrictionMaxSpeed;
    public float airSpeedMultiplier;
    public float airControlMinSpeed;
    public float airControlMaxSpeed;
    public float airControlMinMultiplier;
    public float airControlMaxMultiplier;
    public float comboAirSpeedMultiplier;
    public float baseSpeed;
    public float climbSpeed;
    public float climbSpeedLateral;
    public float climbUpSprintSpeed;
    public float climbDownSprintSpeed;
    public float horizontalFlySpeed;
    public float verticalFlySpeed;
    public float maxSpeedMultiplier;
    public float minSpeedMultiplier;
    public float wishDirectionGravityX;
    public float wishDirectionGravityY;
    public float wishDirectionWeightX;
    public float wishDirectionWeightY;
    @Nonnull public FlyMode fly = FlyMode.Disabled;
    public float collisionExpulsionForce;
    public float forwardWalkSpeedMultiplier;
    public float backwardWalkSpeedMultiplier;
    public float strafeWalkSpeedMultiplier;
    public float forwardRunSpeedMultiplier;
    public float backwardRunSpeedMultiplier;
    public float strafeRunSpeedMultiplier;
    public float forwardCrouchSpeedMultiplier;
    public float backwardCrouchSpeedMultiplier;
    public float strafeCrouchSpeedMultiplier;
    public float forwardSprintSpeedMultiplier;
    public float variableJumpFallForce;
    public float fallEffectDuration;
    public float fallJumpForce;
    public float fallMomentumLoss;
    public float autoJumpObstacleSpeedLoss;
    public float autoJumpObstacleSprintSpeedLoss;
    public float autoJumpObstacleEffectDuration;
    public float autoJumpObstacleSprintEffectDuration;
    public float autoJumpObstacleMaxAngle;
    public boolean autoJumpDisableJumping;
    public float minSlideEntrySpeed;
    public float slideExitSpeed;
    public float minFallSpeedToEngageRoll;
    public float maxFallSpeedToEngageRoll;
    public float rollStartSpeedModifier;
    public float rollExitSpeedModifier;
    public float rollTimeToComplete;
    public float maxSlopeAngleDegrees;
    public float maxWallAngleDegrees;

    public MovementSettings() {
    }

    public MovementSettings(float mass, float dragCoefficient, boolean invertedGravity, float velocityResistance, float jumpForce, float swimJumpForce, float jumpBufferDuration, float jumpBufferMaxYVelocity, float acceleration, float airDragMin, float airDragMax, float airDragMinSpeed, float airDragMaxSpeed, float airFrictionMin, float airFrictionMax, float airFrictionMinSpeed, float airFrictionMaxSpeed, float airSpeedMultiplier, float airControlMinSpeed, float airControlMaxSpeed, float airControlMinMultiplier, float airControlMaxMultiplier, float comboAirSpeedMultiplier, float baseSpeed, float climbSpeed, float climbSpeedLateral, float climbUpSprintSpeed, float climbDownSprintSpeed, float horizontalFlySpeed, float verticalFlySpeed, float maxSpeedMultiplier, float minSpeedMultiplier, float wishDirectionGravityX, float wishDirectionGravityY, float wishDirectionWeightX, float wishDirectionWeightY, @Nonnull FlyMode fly, float collisionExpulsionForce, float forwardWalkSpeedMultiplier, float backwardWalkSpeedMultiplier, float strafeWalkSpeedMultiplier, float forwardRunSpeedMultiplier, float backwardRunSpeedMultiplier, float strafeRunSpeedMultiplier, float forwardCrouchSpeedMultiplier, float backwardCrouchSpeedMultiplier, float strafeCrouchSpeedMultiplier, float forwardSprintSpeedMultiplier, float variableJumpFallForce, float fallEffectDuration, float fallJumpForce, float fallMomentumLoss, float autoJumpObstacleSpeedLoss, float autoJumpObstacleSprintSpeedLoss, float autoJumpObstacleEffectDuration, float autoJumpObstacleSprintEffectDuration, float autoJumpObstacleMaxAngle, boolean autoJumpDisableJumping, float minSlideEntrySpeed, float slideExitSpeed, float minFallSpeedToEngageRoll, float maxFallSpeedToEngageRoll, float rollStartSpeedModifier, float rollExitSpeedModifier, float rollTimeToComplete, float maxSlopeAngleDegrees, float maxWallAngleDegrees) {
        this.mass = mass;
        this.dragCoefficient = dragCoefficient;
        this.invertedGravity = invertedGravity;
        this.velocityResistance = velocityResistance;
        this.jumpForce = jumpForce;
        this.swimJumpForce = swimJumpForce;
        this.jumpBufferDuration = jumpBufferDuration;
        this.jumpBufferMaxYVelocity = jumpBufferMaxYVelocity;
        this.acceleration = acceleration;
        this.airDragMin = airDragMin;
        this.airDragMax = airDragMax;
        this.airDragMinSpeed = airDragMinSpeed;
        this.airDragMaxSpeed = airDragMaxSpeed;
        this.airFrictionMin = airFrictionMin;
        this.airFrictionMax = airFrictionMax;
        this.airFrictionMinSpeed = airFrictionMinSpeed;
        this.airFrictionMaxSpeed = airFrictionMaxSpeed;
        this.airSpeedMultiplier = airSpeedMultiplier;
        this.airControlMinSpeed = airControlMinSpeed;
        this.airControlMaxSpeed = airControlMaxSpeed;
        this.airControlMinMultiplier = airControlMinMultiplier;
        this.airControlMaxMultiplier = airControlMaxMultiplier;
        this.comboAirSpeedMultiplier = comboAirSpeedMultiplier;
        this.baseSpeed = baseSpeed;
        this.climbSpeed = climbSpeed;
        this.climbSpeedLateral = climbSpeedLateral;
        this.climbUpSprintSpeed = climbUpSprintSpeed;
        this.climbDownSprintSpeed = climbDownSprintSpeed;
        this.horizontalFlySpeed = horizontalFlySpeed;
        this.verticalFlySpeed = verticalFlySpeed;
        this.maxSpeedMultiplier = maxSpeedMultiplier;
        this.minSpeedMultiplier = minSpeedMultiplier;
        this.wishDirectionGravityX = wishDirectionGravityX;
        this.wishDirectionGravityY = wishDirectionGravityY;
        this.wishDirectionWeightX = wishDirectionWeightX;
        this.wishDirectionWeightY = wishDirectionWeightY;
        this.fly = fly;
        this.collisionExpulsionForce = collisionExpulsionForce;
        this.forwardWalkSpeedMultiplier = forwardWalkSpeedMultiplier;
        this.backwardWalkSpeedMultiplier = backwardWalkSpeedMultiplier;
        this.strafeWalkSpeedMultiplier = strafeWalkSpeedMultiplier;
        this.forwardRunSpeedMultiplier = forwardRunSpeedMultiplier;
        this.backwardRunSpeedMultiplier = backwardRunSpeedMultiplier;
        this.strafeRunSpeedMultiplier = strafeRunSpeedMultiplier;
        this.forwardCrouchSpeedMultiplier = forwardCrouchSpeedMultiplier;
        this.backwardCrouchSpeedMultiplier = backwardCrouchSpeedMultiplier;
        this.strafeCrouchSpeedMultiplier = strafeCrouchSpeedMultiplier;
        this.forwardSprintSpeedMultiplier = forwardSprintSpeedMultiplier;
        this.variableJumpFallForce = variableJumpFallForce;
        this.fallEffectDuration = fallEffectDuration;
        this.fallJumpForce = fallJumpForce;
        this.fallMomentumLoss = fallMomentumLoss;
        this.autoJumpObstacleSpeedLoss = autoJumpObstacleSpeedLoss;
        this.autoJumpObstacleSprintSpeedLoss = autoJumpObstacleSprintSpeedLoss;
        this.autoJumpObstacleEffectDuration = autoJumpObstacleEffectDuration;
        this.autoJumpObstacleSprintEffectDuration = autoJumpObstacleSprintEffectDuration;
        this.autoJumpObstacleMaxAngle = autoJumpObstacleMaxAngle;
        this.autoJumpDisableJumping = autoJumpDisableJumping;
        this.minSlideEntrySpeed = minSlideEntrySpeed;
        this.slideExitSpeed = slideExitSpeed;
        this.minFallSpeedToEngageRoll = minFallSpeedToEngageRoll;
        this.maxFallSpeedToEngageRoll = maxFallSpeedToEngageRoll;
        this.rollStartSpeedModifier = rollStartSpeedModifier;
        this.rollExitSpeedModifier = rollExitSpeedModifier;
        this.rollTimeToComplete = rollTimeToComplete;
        this.maxSlopeAngleDegrees = maxSlopeAngleDegrees;
        this.maxWallAngleDegrees = maxWallAngleDegrees;
    }

    public MovementSettings(@Nonnull MovementSettings other) {
        this.mass = other.mass;
        this.dragCoefficient = other.dragCoefficient;
        this.invertedGravity = other.invertedGravity;
        this.velocityResistance = other.velocityResistance;
        this.jumpForce = other.jumpForce;
        this.swimJumpForce = other.swimJumpForce;
        this.jumpBufferDuration = other.jumpBufferDuration;
        this.jumpBufferMaxYVelocity = other.jumpBufferMaxYVelocity;
        this.acceleration = other.acceleration;
        this.airDragMin = other.airDragMin;
        this.airDragMax = other.airDragMax;
        this.airDragMinSpeed = other.airDragMinSpeed;
        this.airDragMaxSpeed = other.airDragMaxSpeed;
        this.airFrictionMin = other.airFrictionMin;
        this.airFrictionMax = other.airFrictionMax;
        this.airFrictionMinSpeed = other.airFrictionMinSpeed;
        this.airFrictionMaxSpeed = other.airFrictionMaxSpeed;
        this.airSpeedMultiplier = other.airSpeedMultiplier;
        this.airControlMinSpeed = other.airControlMinSpeed;
        this.airControlMaxSpeed = other.airControlMaxSpeed;
        this.airControlMinMultiplier = other.airControlMinMultiplier;
        this.airControlMaxMultiplier = other.airControlMaxMultiplier;
        this.comboAirSpeedMultiplier = other.comboAirSpeedMultiplier;
        this.baseSpeed = other.baseSpeed;
        this.climbSpeed = other.climbSpeed;
        this.climbSpeedLateral = other.climbSpeedLateral;
        this.climbUpSprintSpeed = other.climbUpSprintSpeed;
        this.climbDownSprintSpeed = other.climbDownSprintSpeed;
        this.horizontalFlySpeed = other.horizontalFlySpeed;
        this.verticalFlySpeed = other.verticalFlySpeed;
        this.maxSpeedMultiplier = other.maxSpeedMultiplier;
        this.minSpeedMultiplier = other.minSpeedMultiplier;
        this.wishDirectionGravityX = other.wishDirectionGravityX;
        this.wishDirectionGravityY = other.wishDirectionGravityY;
        this.wishDirectionWeightX = other.wishDirectionWeightX;
        this.wishDirectionWeightY = other.wishDirectionWeightY;
        this.fly = other.fly;
        this.collisionExpulsionForce = other.collisionExpulsionForce;
        this.forwardWalkSpeedMultiplier = other.forwardWalkSpeedMultiplier;
        this.backwardWalkSpeedMultiplier = other.backwardWalkSpeedMultiplier;
        this.strafeWalkSpeedMultiplier = other.strafeWalkSpeedMultiplier;
        this.forwardRunSpeedMultiplier = other.forwardRunSpeedMultiplier;
        this.backwardRunSpeedMultiplier = other.backwardRunSpeedMultiplier;
        this.strafeRunSpeedMultiplier = other.strafeRunSpeedMultiplier;
        this.forwardCrouchSpeedMultiplier = other.forwardCrouchSpeedMultiplier;
        this.backwardCrouchSpeedMultiplier = other.backwardCrouchSpeedMultiplier;
        this.strafeCrouchSpeedMultiplier = other.strafeCrouchSpeedMultiplier;
        this.forwardSprintSpeedMultiplier = other.forwardSprintSpeedMultiplier;
        this.variableJumpFallForce = other.variableJumpFallForce;
        this.fallEffectDuration = other.fallEffectDuration;
        this.fallJumpForce = other.fallJumpForce;
        this.fallMomentumLoss = other.fallMomentumLoss;
        this.autoJumpObstacleSpeedLoss = other.autoJumpObstacleSpeedLoss;
        this.autoJumpObstacleSprintSpeedLoss = other.autoJumpObstacleSprintSpeedLoss;
        this.autoJumpObstacleEffectDuration = other.autoJumpObstacleEffectDuration;
        this.autoJumpObstacleSprintEffectDuration = other.autoJumpObstacleSprintEffectDuration;
        this.autoJumpObstacleMaxAngle = other.autoJumpObstacleMaxAngle;
        this.autoJumpDisableJumping = other.autoJumpDisableJumping;
        this.minSlideEntrySpeed = other.minSlideEntrySpeed;
        this.slideExitSpeed = other.slideExitSpeed;
        this.minFallSpeedToEngageRoll = other.minFallSpeedToEngageRoll;
        this.maxFallSpeedToEngageRoll = other.maxFallSpeedToEngageRoll;
        this.rollStartSpeedModifier = other.rollStartSpeedModifier;
        this.rollExitSpeedModifier = other.rollExitSpeedModifier;
        this.rollTimeToComplete = other.rollTimeToComplete;
        this.maxSlopeAngleDegrees = other.maxSlopeAngleDegrees;
        this.maxWallAngleDegrees = other.maxWallAngleDegrees;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("MovementSettings", offset, (int) mem.byteSize());
        long needed = (long) offset + 259;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("MovementSettings", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getMass(MemorySegment mem) {
        return getMass(mem, 0);
    }
    
    public static float getMass(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "Mass");
    }
    
    public static float getDragCoefficient(MemorySegment mem) {
        return getDragCoefficient(mem, 0);
    }
    
    public static float getDragCoefficient(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "DragCoefficient");
    }
    
    public static boolean getInvertedGravity(MemorySegment mem) {
        return getInvertedGravity(mem, 0);
    }
    
    public static boolean getInvertedGravity(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 8);
    }
    
    public static float getVelocityResistance(MemorySegment mem) {
        return getVelocityResistance(mem, 0);
    }
    
    public static float getVelocityResistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "VelocityResistance");
    }
    
    public static float getJumpForce(MemorySegment mem) {
        return getJumpForce(mem, 0);
    }
    
    public static float getJumpForce(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 13), "JumpForce");
    }
    
    public static float getSwimJumpForce(MemorySegment mem) {
        return getSwimJumpForce(mem, 0);
    }
    
    public static float getSwimJumpForce(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 17), "SwimJumpForce");
    }
    
    public static float getJumpBufferDuration(MemorySegment mem) {
        return getJumpBufferDuration(mem, 0);
    }
    
    public static float getJumpBufferDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 21), "JumpBufferDuration");
    }
    
    public static float getJumpBufferMaxYVelocity(MemorySegment mem) {
        return getJumpBufferMaxYVelocity(mem, 0);
    }
    
    public static float getJumpBufferMaxYVelocity(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 25), "JumpBufferMaxYVelocity");
    }
    
    public static float getAcceleration(MemorySegment mem) {
        return getAcceleration(mem, 0);
    }
    
    public static float getAcceleration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 29), "Acceleration");
    }
    
    public static float getAirDragMin(MemorySegment mem) {
        return getAirDragMin(mem, 0);
    }
    
    public static float getAirDragMin(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 33), "AirDragMin");
    }
    
    public static float getAirDragMax(MemorySegment mem) {
        return getAirDragMax(mem, 0);
    }
    
    public static float getAirDragMax(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 37), "AirDragMax");
    }
    
    public static float getAirDragMinSpeed(MemorySegment mem) {
        return getAirDragMinSpeed(mem, 0);
    }
    
    public static float getAirDragMinSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 41), "AirDragMinSpeed");
    }
    
    public static float getAirDragMaxSpeed(MemorySegment mem) {
        return getAirDragMaxSpeed(mem, 0);
    }
    
    public static float getAirDragMaxSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 45), "AirDragMaxSpeed");
    }
    
    public static float getAirFrictionMin(MemorySegment mem) {
        return getAirFrictionMin(mem, 0);
    }
    
    public static float getAirFrictionMin(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 49), "AirFrictionMin");
    }
    
    public static float getAirFrictionMax(MemorySegment mem) {
        return getAirFrictionMax(mem, 0);
    }
    
    public static float getAirFrictionMax(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 53), "AirFrictionMax");
    }
    
    public static float getAirFrictionMinSpeed(MemorySegment mem) {
        return getAirFrictionMinSpeed(mem, 0);
    }
    
    public static float getAirFrictionMinSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 57), "AirFrictionMinSpeed");
    }
    
    public static float getAirFrictionMaxSpeed(MemorySegment mem) {
        return getAirFrictionMaxSpeed(mem, 0);
    }
    
    public static float getAirFrictionMaxSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 61), "AirFrictionMaxSpeed");
    }
    
    public static float getAirSpeedMultiplier(MemorySegment mem) {
        return getAirSpeedMultiplier(mem, 0);
    }
    
    public static float getAirSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 65), "AirSpeedMultiplier");
    }
    
    public static float getAirControlMinSpeed(MemorySegment mem) {
        return getAirControlMinSpeed(mem, 0);
    }
    
    public static float getAirControlMinSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 69), "AirControlMinSpeed");
    }
    
    public static float getAirControlMaxSpeed(MemorySegment mem) {
        return getAirControlMaxSpeed(mem, 0);
    }
    
    public static float getAirControlMaxSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 73), "AirControlMaxSpeed");
    }
    
    public static float getAirControlMinMultiplier(MemorySegment mem) {
        return getAirControlMinMultiplier(mem, 0);
    }
    
    public static float getAirControlMinMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 77), "AirControlMinMultiplier");
    }
    
    public static float getAirControlMaxMultiplier(MemorySegment mem) {
        return getAirControlMaxMultiplier(mem, 0);
    }
    
    public static float getAirControlMaxMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 81), "AirControlMaxMultiplier");
    }
    
    public static float getComboAirSpeedMultiplier(MemorySegment mem) {
        return getComboAirSpeedMultiplier(mem, 0);
    }
    
    public static float getComboAirSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 85), "ComboAirSpeedMultiplier");
    }
    
    public static float getBaseSpeed(MemorySegment mem) {
        return getBaseSpeed(mem, 0);
    }
    
    public static float getBaseSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 89), "BaseSpeed");
    }
    
    public static float getClimbSpeed(MemorySegment mem) {
        return getClimbSpeed(mem, 0);
    }
    
    public static float getClimbSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 93), "ClimbSpeed");
    }
    
    public static float getClimbSpeedLateral(MemorySegment mem) {
        return getClimbSpeedLateral(mem, 0);
    }
    
    public static float getClimbSpeedLateral(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 97), "ClimbSpeedLateral");
    }
    
    public static float getClimbUpSprintSpeed(MemorySegment mem) {
        return getClimbUpSprintSpeed(mem, 0);
    }
    
    public static float getClimbUpSprintSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 101), "ClimbUpSprintSpeed");
    }
    
    public static float getClimbDownSprintSpeed(MemorySegment mem) {
        return getClimbDownSprintSpeed(mem, 0);
    }
    
    public static float getClimbDownSprintSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 105), "ClimbDownSprintSpeed");
    }
    
    public static float getHorizontalFlySpeed(MemorySegment mem) {
        return getHorizontalFlySpeed(mem, 0);
    }
    
    public static float getHorizontalFlySpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 109), "HorizontalFlySpeed");
    }
    
    public static float getVerticalFlySpeed(MemorySegment mem) {
        return getVerticalFlySpeed(mem, 0);
    }
    
    public static float getVerticalFlySpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 113), "VerticalFlySpeed");
    }
    
    public static float getMaxSpeedMultiplier(MemorySegment mem) {
        return getMaxSpeedMultiplier(mem, 0);
    }
    
    public static float getMaxSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 117), "MaxSpeedMultiplier");
    }
    
    public static float getMinSpeedMultiplier(MemorySegment mem) {
        return getMinSpeedMultiplier(mem, 0);
    }
    
    public static float getMinSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 121), "MinSpeedMultiplier");
    }
    
    public static float getWishDirectionGravityX(MemorySegment mem) {
        return getWishDirectionGravityX(mem, 0);
    }
    
    public static float getWishDirectionGravityX(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 125), "WishDirectionGravityX");
    }
    
    public static float getWishDirectionGravityY(MemorySegment mem) {
        return getWishDirectionGravityY(mem, 0);
    }
    
    public static float getWishDirectionGravityY(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 129), "WishDirectionGravityY");
    }
    
    public static float getWishDirectionWeightX(MemorySegment mem) {
        return getWishDirectionWeightX(mem, 0);
    }
    
    public static float getWishDirectionWeightX(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 133), "WishDirectionWeightX");
    }
    
    public static float getWishDirectionWeightY(MemorySegment mem) {
        return getWishDirectionWeightY(mem, 0);
    }
    
    public static float getWishDirectionWeightY(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 137), "WishDirectionWeightY");
    }
    
    public static FlyMode getFly(MemorySegment mem) {
        return getFly(mem, 0);
    }
    
    public static FlyMode getFly(MemorySegment mem, int offset) {
        return FlyMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 141));
    }
    
    public static float getCollisionExpulsionForce(MemorySegment mem) {
        return getCollisionExpulsionForce(mem, 0);
    }
    
    public static float getCollisionExpulsionForce(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 142), "CollisionExpulsionForce");
    }
    
    public static float getForwardWalkSpeedMultiplier(MemorySegment mem) {
        return getForwardWalkSpeedMultiplier(mem, 0);
    }
    
    public static float getForwardWalkSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 146), "ForwardWalkSpeedMultiplier");
    }
    
    public static float getBackwardWalkSpeedMultiplier(MemorySegment mem) {
        return getBackwardWalkSpeedMultiplier(mem, 0);
    }
    
    public static float getBackwardWalkSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 150), "BackwardWalkSpeedMultiplier");
    }
    
    public static float getStrafeWalkSpeedMultiplier(MemorySegment mem) {
        return getStrafeWalkSpeedMultiplier(mem, 0);
    }
    
    public static float getStrafeWalkSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 154), "StrafeWalkSpeedMultiplier");
    }
    
    public static float getForwardRunSpeedMultiplier(MemorySegment mem) {
        return getForwardRunSpeedMultiplier(mem, 0);
    }
    
    public static float getForwardRunSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 158), "ForwardRunSpeedMultiplier");
    }
    
    public static float getBackwardRunSpeedMultiplier(MemorySegment mem) {
        return getBackwardRunSpeedMultiplier(mem, 0);
    }
    
    public static float getBackwardRunSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 162), "BackwardRunSpeedMultiplier");
    }
    
    public static float getStrafeRunSpeedMultiplier(MemorySegment mem) {
        return getStrafeRunSpeedMultiplier(mem, 0);
    }
    
    public static float getStrafeRunSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 166), "StrafeRunSpeedMultiplier");
    }
    
    public static float getForwardCrouchSpeedMultiplier(MemorySegment mem) {
        return getForwardCrouchSpeedMultiplier(mem, 0);
    }
    
    public static float getForwardCrouchSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 170), "ForwardCrouchSpeedMultiplier");
    }
    
    public static float getBackwardCrouchSpeedMultiplier(MemorySegment mem) {
        return getBackwardCrouchSpeedMultiplier(mem, 0);
    }
    
    public static float getBackwardCrouchSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 174), "BackwardCrouchSpeedMultiplier");
    }
    
    public static float getStrafeCrouchSpeedMultiplier(MemorySegment mem) {
        return getStrafeCrouchSpeedMultiplier(mem, 0);
    }
    
    public static float getStrafeCrouchSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 178), "StrafeCrouchSpeedMultiplier");
    }
    
    public static float getForwardSprintSpeedMultiplier(MemorySegment mem) {
        return getForwardSprintSpeedMultiplier(mem, 0);
    }
    
    public static float getForwardSprintSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 182), "ForwardSprintSpeedMultiplier");
    }
    
    public static float getVariableJumpFallForce(MemorySegment mem) {
        return getVariableJumpFallForce(mem, 0);
    }
    
    public static float getVariableJumpFallForce(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 186), "VariableJumpFallForce");
    }
    
    public static float getFallEffectDuration(MemorySegment mem) {
        return getFallEffectDuration(mem, 0);
    }
    
    public static float getFallEffectDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 190), "FallEffectDuration");
    }
    
    public static float getFallJumpForce(MemorySegment mem) {
        return getFallJumpForce(mem, 0);
    }
    
    public static float getFallJumpForce(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 194), "FallJumpForce");
    }
    
    public static float getFallMomentumLoss(MemorySegment mem) {
        return getFallMomentumLoss(mem, 0);
    }
    
    public static float getFallMomentumLoss(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 198), "FallMomentumLoss");
    }
    
    public static float getAutoJumpObstacleSpeedLoss(MemorySegment mem) {
        return getAutoJumpObstacleSpeedLoss(mem, 0);
    }
    
    public static float getAutoJumpObstacleSpeedLoss(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 202), "AutoJumpObstacleSpeedLoss");
    }
    
    public static float getAutoJumpObstacleSprintSpeedLoss(MemorySegment mem) {
        return getAutoJumpObstacleSprintSpeedLoss(mem, 0);
    }
    
    public static float getAutoJumpObstacleSprintSpeedLoss(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 206), "AutoJumpObstacleSprintSpeedLoss");
    }
    
    public static float getAutoJumpObstacleEffectDuration(MemorySegment mem) {
        return getAutoJumpObstacleEffectDuration(mem, 0);
    }
    
    public static float getAutoJumpObstacleEffectDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 210), "AutoJumpObstacleEffectDuration");
    }
    
    public static float getAutoJumpObstacleSprintEffectDuration(MemorySegment mem) {
        return getAutoJumpObstacleSprintEffectDuration(mem, 0);
    }
    
    public static float getAutoJumpObstacleSprintEffectDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 214), "AutoJumpObstacleSprintEffectDuration");
    }
    
    public static float getAutoJumpObstacleMaxAngle(MemorySegment mem) {
        return getAutoJumpObstacleMaxAngle(mem, 0);
    }
    
    public static float getAutoJumpObstacleMaxAngle(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 218), "AutoJumpObstacleMaxAngle");
    }
    
    public static boolean getAutoJumpDisableJumping(MemorySegment mem) {
        return getAutoJumpDisableJumping(mem, 0);
    }
    
    public static boolean getAutoJumpDisableJumping(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 222);
    }
    
    public static float getMinSlideEntrySpeed(MemorySegment mem) {
        return getMinSlideEntrySpeed(mem, 0);
    }
    
    public static float getMinSlideEntrySpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 223), "MinSlideEntrySpeed");
    }
    
    public static float getSlideExitSpeed(MemorySegment mem) {
        return getSlideExitSpeed(mem, 0);
    }
    
    public static float getSlideExitSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 227), "SlideExitSpeed");
    }
    
    public static float getMinFallSpeedToEngageRoll(MemorySegment mem) {
        return getMinFallSpeedToEngageRoll(mem, 0);
    }
    
    public static float getMinFallSpeedToEngageRoll(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 231), "MinFallSpeedToEngageRoll");
    }
    
    public static float getMaxFallSpeedToEngageRoll(MemorySegment mem) {
        return getMaxFallSpeedToEngageRoll(mem, 0);
    }
    
    public static float getMaxFallSpeedToEngageRoll(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 235), "MaxFallSpeedToEngageRoll");
    }
    
    public static float getRollStartSpeedModifier(MemorySegment mem) {
        return getRollStartSpeedModifier(mem, 0);
    }
    
    public static float getRollStartSpeedModifier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 239), "RollStartSpeedModifier");
    }
    
    public static float getRollExitSpeedModifier(MemorySegment mem) {
        return getRollExitSpeedModifier(mem, 0);
    }
    
    public static float getRollExitSpeedModifier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 243), "RollExitSpeedModifier");
    }
    
    public static float getRollTimeToComplete(MemorySegment mem) {
        return getRollTimeToComplete(mem, 0);
    }
    
    public static float getRollTimeToComplete(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 247), "RollTimeToComplete");
    }
    
    public static float getMaxSlopeAngleDegrees(MemorySegment mem) {
        return getMaxSlopeAngleDegrees(mem, 0);
    }
    
    public static float getMaxSlopeAngleDegrees(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 251), "MaxSlopeAngleDegrees");
    }
    
    public static float getMaxWallAngleDegrees(MemorySegment mem) {
        return getMaxWallAngleDegrees(mem, 0);
    }
    
    public static float getMaxWallAngleDegrees(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 255), "MaxWallAngleDegrees");
    }
    
    
    
    
    
    public static MovementSettings toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static MovementSettings toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one MovementSettings and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static MovementSettings toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new MovementSettings(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "Mass"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "DragCoefficient"),
            mem.get(PacketIO.PROTO_BOOL, offset + 8),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "VelocityResistance"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 13), "JumpForce"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 17), "SwimJumpForce"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 21), "JumpBufferDuration"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 25), "JumpBufferMaxYVelocity"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 29), "Acceleration"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 33), "AirDragMin"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 37), "AirDragMax"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 41), "AirDragMinSpeed"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 45), "AirDragMaxSpeed"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 49), "AirFrictionMin"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 53), "AirFrictionMax"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 57), "AirFrictionMinSpeed"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 61), "AirFrictionMaxSpeed"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 65), "AirSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 69), "AirControlMinSpeed"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 73), "AirControlMaxSpeed"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 77), "AirControlMinMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 81), "AirControlMaxMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 85), "ComboAirSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 89), "BaseSpeed"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 93), "ClimbSpeed"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 97), "ClimbSpeedLateral"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 101), "ClimbUpSprintSpeed"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 105), "ClimbDownSprintSpeed"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 109), "HorizontalFlySpeed"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 113), "VerticalFlySpeed"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 117), "MaxSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 121), "MinSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 125), "WishDirectionGravityX"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 129), "WishDirectionGravityY"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 133), "WishDirectionWeightX"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 137), "WishDirectionWeightY"),
            FlyMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 141)),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 142), "CollisionExpulsionForce"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 146), "ForwardWalkSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 150), "BackwardWalkSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 154), "StrafeWalkSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 158), "ForwardRunSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 162), "BackwardRunSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 166), "StrafeRunSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 170), "ForwardCrouchSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 174), "BackwardCrouchSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 178), "StrafeCrouchSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 182), "ForwardSprintSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 186), "VariableJumpFallForce"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 190), "FallEffectDuration"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 194), "FallJumpForce"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 198), "FallMomentumLoss"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 202), "AutoJumpObstacleSpeedLoss"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 206), "AutoJumpObstacleSprintSpeedLoss"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 210), "AutoJumpObstacleEffectDuration"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 214), "AutoJumpObstacleSprintEffectDuration"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 218), "AutoJumpObstacleMaxAngle"),
            mem.get(PacketIO.PROTO_BOOL, offset + 222),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 223), "MinSlideEntrySpeed"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 227), "SlideExitSpeed"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 231), "MinFallSpeedToEngageRoll"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 235), "MaxFallSpeedToEngageRoll"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 239), "RollStartSpeedModifier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 243), "RollExitSpeedModifier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 247), "RollTimeToComplete"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 251), "MaxSlopeAngleDegrees"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 255), "MaxWallAngleDegrees")
        );
        if (cursor != null) cursor.position = offset + 259;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.mass, "Mass"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.mass);
        PacketIO.requireFinite(this.dragCoefficient, "DragCoefficient"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.dragCoefficient);
        mem.set(PacketIO.PROTO_BOOL, offset + 8, this.invertedGravity);
        PacketIO.requireFinite(this.velocityResistance, "VelocityResistance"); mem.set(PacketIO.PROTO_FLOAT, offset + 9, this.velocityResistance);
        PacketIO.requireFinite(this.jumpForce, "JumpForce"); mem.set(PacketIO.PROTO_FLOAT, offset + 13, this.jumpForce);
        PacketIO.requireFinite(this.swimJumpForce, "SwimJumpForce"); mem.set(PacketIO.PROTO_FLOAT, offset + 17, this.swimJumpForce);
        PacketIO.requireFinite(this.jumpBufferDuration, "JumpBufferDuration"); mem.set(PacketIO.PROTO_FLOAT, offset + 21, this.jumpBufferDuration);
        PacketIO.requireFinite(this.jumpBufferMaxYVelocity, "JumpBufferMaxYVelocity"); mem.set(PacketIO.PROTO_FLOAT, offset + 25, this.jumpBufferMaxYVelocity);
        PacketIO.requireFinite(this.acceleration, "Acceleration"); mem.set(PacketIO.PROTO_FLOAT, offset + 29, this.acceleration);
        PacketIO.requireFinite(this.airDragMin, "AirDragMin"); mem.set(PacketIO.PROTO_FLOAT, offset + 33, this.airDragMin);
        PacketIO.requireFinite(this.airDragMax, "AirDragMax"); mem.set(PacketIO.PROTO_FLOAT, offset + 37, this.airDragMax);
        PacketIO.requireFinite(this.airDragMinSpeed, "AirDragMinSpeed"); mem.set(PacketIO.PROTO_FLOAT, offset + 41, this.airDragMinSpeed);
        PacketIO.requireFinite(this.airDragMaxSpeed, "AirDragMaxSpeed"); mem.set(PacketIO.PROTO_FLOAT, offset + 45, this.airDragMaxSpeed);
        PacketIO.requireFinite(this.airFrictionMin, "AirFrictionMin"); mem.set(PacketIO.PROTO_FLOAT, offset + 49, this.airFrictionMin);
        PacketIO.requireFinite(this.airFrictionMax, "AirFrictionMax"); mem.set(PacketIO.PROTO_FLOAT, offset + 53, this.airFrictionMax);
        PacketIO.requireFinite(this.airFrictionMinSpeed, "AirFrictionMinSpeed"); mem.set(PacketIO.PROTO_FLOAT, offset + 57, this.airFrictionMinSpeed);
        PacketIO.requireFinite(this.airFrictionMaxSpeed, "AirFrictionMaxSpeed"); mem.set(PacketIO.PROTO_FLOAT, offset + 61, this.airFrictionMaxSpeed);
        PacketIO.requireFinite(this.airSpeedMultiplier, "AirSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 65, this.airSpeedMultiplier);
        PacketIO.requireFinite(this.airControlMinSpeed, "AirControlMinSpeed"); mem.set(PacketIO.PROTO_FLOAT, offset + 69, this.airControlMinSpeed);
        PacketIO.requireFinite(this.airControlMaxSpeed, "AirControlMaxSpeed"); mem.set(PacketIO.PROTO_FLOAT, offset + 73, this.airControlMaxSpeed);
        PacketIO.requireFinite(this.airControlMinMultiplier, "AirControlMinMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 77, this.airControlMinMultiplier);
        PacketIO.requireFinite(this.airControlMaxMultiplier, "AirControlMaxMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 81, this.airControlMaxMultiplier);
        PacketIO.requireFinite(this.comboAirSpeedMultiplier, "ComboAirSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 85, this.comboAirSpeedMultiplier);
        PacketIO.requireFinite(this.baseSpeed, "BaseSpeed"); mem.set(PacketIO.PROTO_FLOAT, offset + 89, this.baseSpeed);
        PacketIO.requireFinite(this.climbSpeed, "ClimbSpeed"); mem.set(PacketIO.PROTO_FLOAT, offset + 93, this.climbSpeed);
        PacketIO.requireFinite(this.climbSpeedLateral, "ClimbSpeedLateral"); mem.set(PacketIO.PROTO_FLOAT, offset + 97, this.climbSpeedLateral);
        PacketIO.requireFinite(this.climbUpSprintSpeed, "ClimbUpSprintSpeed"); mem.set(PacketIO.PROTO_FLOAT, offset + 101, this.climbUpSprintSpeed);
        PacketIO.requireFinite(this.climbDownSprintSpeed, "ClimbDownSprintSpeed"); mem.set(PacketIO.PROTO_FLOAT, offset + 105, this.climbDownSprintSpeed);
        PacketIO.requireFinite(this.horizontalFlySpeed, "HorizontalFlySpeed"); mem.set(PacketIO.PROTO_FLOAT, offset + 109, this.horizontalFlySpeed);
        PacketIO.requireFinite(this.verticalFlySpeed, "VerticalFlySpeed"); mem.set(PacketIO.PROTO_FLOAT, offset + 113, this.verticalFlySpeed);
        PacketIO.requireFinite(this.maxSpeedMultiplier, "MaxSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 117, this.maxSpeedMultiplier);
        PacketIO.requireFinite(this.minSpeedMultiplier, "MinSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 121, this.minSpeedMultiplier);
        PacketIO.requireFinite(this.wishDirectionGravityX, "WishDirectionGravityX"); mem.set(PacketIO.PROTO_FLOAT, offset + 125, this.wishDirectionGravityX);
        PacketIO.requireFinite(this.wishDirectionGravityY, "WishDirectionGravityY"); mem.set(PacketIO.PROTO_FLOAT, offset + 129, this.wishDirectionGravityY);
        PacketIO.requireFinite(this.wishDirectionWeightX, "WishDirectionWeightX"); mem.set(PacketIO.PROTO_FLOAT, offset + 133, this.wishDirectionWeightX);
        PacketIO.requireFinite(this.wishDirectionWeightY, "WishDirectionWeightY"); mem.set(PacketIO.PROTO_FLOAT, offset + 137, this.wishDirectionWeightY);
        mem.set(PacketIO.PROTO_BYTE, offset + 141, (byte) this.fly.getValue());
        PacketIO.requireFinite(this.collisionExpulsionForce, "CollisionExpulsionForce"); mem.set(PacketIO.PROTO_FLOAT, offset + 142, this.collisionExpulsionForce);
        PacketIO.requireFinite(this.forwardWalkSpeedMultiplier, "ForwardWalkSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 146, this.forwardWalkSpeedMultiplier);
        PacketIO.requireFinite(this.backwardWalkSpeedMultiplier, "BackwardWalkSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 150, this.backwardWalkSpeedMultiplier);
        PacketIO.requireFinite(this.strafeWalkSpeedMultiplier, "StrafeWalkSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 154, this.strafeWalkSpeedMultiplier);
        PacketIO.requireFinite(this.forwardRunSpeedMultiplier, "ForwardRunSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 158, this.forwardRunSpeedMultiplier);
        PacketIO.requireFinite(this.backwardRunSpeedMultiplier, "BackwardRunSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 162, this.backwardRunSpeedMultiplier);
        PacketIO.requireFinite(this.strafeRunSpeedMultiplier, "StrafeRunSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 166, this.strafeRunSpeedMultiplier);
        PacketIO.requireFinite(this.forwardCrouchSpeedMultiplier, "ForwardCrouchSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 170, this.forwardCrouchSpeedMultiplier);
        PacketIO.requireFinite(this.backwardCrouchSpeedMultiplier, "BackwardCrouchSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 174, this.backwardCrouchSpeedMultiplier);
        PacketIO.requireFinite(this.strafeCrouchSpeedMultiplier, "StrafeCrouchSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 178, this.strafeCrouchSpeedMultiplier);
        PacketIO.requireFinite(this.forwardSprintSpeedMultiplier, "ForwardSprintSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 182, this.forwardSprintSpeedMultiplier);
        PacketIO.requireFinite(this.variableJumpFallForce, "VariableJumpFallForce"); mem.set(PacketIO.PROTO_FLOAT, offset + 186, this.variableJumpFallForce);
        PacketIO.requireFinite(this.fallEffectDuration, "FallEffectDuration"); mem.set(PacketIO.PROTO_FLOAT, offset + 190, this.fallEffectDuration);
        PacketIO.requireFinite(this.fallJumpForce, "FallJumpForce"); mem.set(PacketIO.PROTO_FLOAT, offset + 194, this.fallJumpForce);
        PacketIO.requireFinite(this.fallMomentumLoss, "FallMomentumLoss"); mem.set(PacketIO.PROTO_FLOAT, offset + 198, this.fallMomentumLoss);
        PacketIO.requireFinite(this.autoJumpObstacleSpeedLoss, "AutoJumpObstacleSpeedLoss"); mem.set(PacketIO.PROTO_FLOAT, offset + 202, this.autoJumpObstacleSpeedLoss);
        PacketIO.requireFinite(this.autoJumpObstacleSprintSpeedLoss, "AutoJumpObstacleSprintSpeedLoss"); mem.set(PacketIO.PROTO_FLOAT, offset + 206, this.autoJumpObstacleSprintSpeedLoss);
        PacketIO.requireFinite(this.autoJumpObstacleEffectDuration, "AutoJumpObstacleEffectDuration"); mem.set(PacketIO.PROTO_FLOAT, offset + 210, this.autoJumpObstacleEffectDuration);
        PacketIO.requireFinite(this.autoJumpObstacleSprintEffectDuration, "AutoJumpObstacleSprintEffectDuration"); mem.set(PacketIO.PROTO_FLOAT, offset + 214, this.autoJumpObstacleSprintEffectDuration);
        PacketIO.requireFinite(this.autoJumpObstacleMaxAngle, "AutoJumpObstacleMaxAngle"); mem.set(PacketIO.PROTO_FLOAT, offset + 218, this.autoJumpObstacleMaxAngle);
        mem.set(PacketIO.PROTO_BOOL, offset + 222, this.autoJumpDisableJumping);
        PacketIO.requireFinite(this.minSlideEntrySpeed, "MinSlideEntrySpeed"); mem.set(PacketIO.PROTO_FLOAT, offset + 223, this.minSlideEntrySpeed);
        PacketIO.requireFinite(this.slideExitSpeed, "SlideExitSpeed"); mem.set(PacketIO.PROTO_FLOAT, offset + 227, this.slideExitSpeed);
        PacketIO.requireFinite(this.minFallSpeedToEngageRoll, "MinFallSpeedToEngageRoll"); mem.set(PacketIO.PROTO_FLOAT, offset + 231, this.minFallSpeedToEngageRoll);
        PacketIO.requireFinite(this.maxFallSpeedToEngageRoll, "MaxFallSpeedToEngageRoll"); mem.set(PacketIO.PROTO_FLOAT, offset + 235, this.maxFallSpeedToEngageRoll);
        PacketIO.requireFinite(this.rollStartSpeedModifier, "RollStartSpeedModifier"); mem.set(PacketIO.PROTO_FLOAT, offset + 239, this.rollStartSpeedModifier);
        PacketIO.requireFinite(this.rollExitSpeedModifier, "RollExitSpeedModifier"); mem.set(PacketIO.PROTO_FLOAT, offset + 243, this.rollExitSpeedModifier);
        PacketIO.requireFinite(this.rollTimeToComplete, "RollTimeToComplete"); mem.set(PacketIO.PROTO_FLOAT, offset + 247, this.rollTimeToComplete);
        PacketIO.requireFinite(this.maxSlopeAngleDegrees, "MaxSlopeAngleDegrees"); mem.set(PacketIO.PROTO_FLOAT, offset + 251, this.maxSlopeAngleDegrees);
        PacketIO.requireFinite(this.maxWallAngleDegrees, "MaxWallAngleDegrees"); mem.set(PacketIO.PROTO_FLOAT, offset + 255, this.maxWallAngleDegrees);
        
        
    
       return 259;
    }
    public int computeSize() {
        return 259;
    }

    public MovementSettings clone() {
        MovementSettings copy = new MovementSettings();
        copy.mass = this.mass;
        copy.dragCoefficient = this.dragCoefficient;
        copy.invertedGravity = this.invertedGravity;
        copy.velocityResistance = this.velocityResistance;
        copy.jumpForce = this.jumpForce;
        copy.swimJumpForce = this.swimJumpForce;
        copy.jumpBufferDuration = this.jumpBufferDuration;
        copy.jumpBufferMaxYVelocity = this.jumpBufferMaxYVelocity;
        copy.acceleration = this.acceleration;
        copy.airDragMin = this.airDragMin;
        copy.airDragMax = this.airDragMax;
        copy.airDragMinSpeed = this.airDragMinSpeed;
        copy.airDragMaxSpeed = this.airDragMaxSpeed;
        copy.airFrictionMin = this.airFrictionMin;
        copy.airFrictionMax = this.airFrictionMax;
        copy.airFrictionMinSpeed = this.airFrictionMinSpeed;
        copy.airFrictionMaxSpeed = this.airFrictionMaxSpeed;
        copy.airSpeedMultiplier = this.airSpeedMultiplier;
        copy.airControlMinSpeed = this.airControlMinSpeed;
        copy.airControlMaxSpeed = this.airControlMaxSpeed;
        copy.airControlMinMultiplier = this.airControlMinMultiplier;
        copy.airControlMaxMultiplier = this.airControlMaxMultiplier;
        copy.comboAirSpeedMultiplier = this.comboAirSpeedMultiplier;
        copy.baseSpeed = this.baseSpeed;
        copy.climbSpeed = this.climbSpeed;
        copy.climbSpeedLateral = this.climbSpeedLateral;
        copy.climbUpSprintSpeed = this.climbUpSprintSpeed;
        copy.climbDownSprintSpeed = this.climbDownSprintSpeed;
        copy.horizontalFlySpeed = this.horizontalFlySpeed;
        copy.verticalFlySpeed = this.verticalFlySpeed;
        copy.maxSpeedMultiplier = this.maxSpeedMultiplier;
        copy.minSpeedMultiplier = this.minSpeedMultiplier;
        copy.wishDirectionGravityX = this.wishDirectionGravityX;
        copy.wishDirectionGravityY = this.wishDirectionGravityY;
        copy.wishDirectionWeightX = this.wishDirectionWeightX;
        copy.wishDirectionWeightY = this.wishDirectionWeightY;
        copy.fly = this.fly;
        copy.collisionExpulsionForce = this.collisionExpulsionForce;
        copy.forwardWalkSpeedMultiplier = this.forwardWalkSpeedMultiplier;
        copy.backwardWalkSpeedMultiplier = this.backwardWalkSpeedMultiplier;
        copy.strafeWalkSpeedMultiplier = this.strafeWalkSpeedMultiplier;
        copy.forwardRunSpeedMultiplier = this.forwardRunSpeedMultiplier;
        copy.backwardRunSpeedMultiplier = this.backwardRunSpeedMultiplier;
        copy.strafeRunSpeedMultiplier = this.strafeRunSpeedMultiplier;
        copy.forwardCrouchSpeedMultiplier = this.forwardCrouchSpeedMultiplier;
        copy.backwardCrouchSpeedMultiplier = this.backwardCrouchSpeedMultiplier;
        copy.strafeCrouchSpeedMultiplier = this.strafeCrouchSpeedMultiplier;
        copy.forwardSprintSpeedMultiplier = this.forwardSprintSpeedMultiplier;
        copy.variableJumpFallForce = this.variableJumpFallForce;
        copy.fallEffectDuration = this.fallEffectDuration;
        copy.fallJumpForce = this.fallJumpForce;
        copy.fallMomentumLoss = this.fallMomentumLoss;
        copy.autoJumpObstacleSpeedLoss = this.autoJumpObstacleSpeedLoss;
        copy.autoJumpObstacleSprintSpeedLoss = this.autoJumpObstacleSprintSpeedLoss;
        copy.autoJumpObstacleEffectDuration = this.autoJumpObstacleEffectDuration;
        copy.autoJumpObstacleSprintEffectDuration = this.autoJumpObstacleSprintEffectDuration;
        copy.autoJumpObstacleMaxAngle = this.autoJumpObstacleMaxAngle;
        copy.autoJumpDisableJumping = this.autoJumpDisableJumping;
        copy.minSlideEntrySpeed = this.minSlideEntrySpeed;
        copy.slideExitSpeed = this.slideExitSpeed;
        copy.minFallSpeedToEngageRoll = this.minFallSpeedToEngageRoll;
        copy.maxFallSpeedToEngageRoll = this.maxFallSpeedToEngageRoll;
        copy.rollStartSpeedModifier = this.rollStartSpeedModifier;
        copy.rollExitSpeedModifier = this.rollExitSpeedModifier;
        copy.rollTimeToComplete = this.rollTimeToComplete;
        copy.maxSlopeAngleDegrees = this.maxSlopeAngleDegrees;
        copy.maxWallAngleDegrees = this.maxWallAngleDegrees;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MovementSettings other)) return false;
        return this.mass == other.mass && this.dragCoefficient == other.dragCoefficient && this.invertedGravity == other.invertedGravity && this.velocityResistance == other.velocityResistance && this.jumpForce == other.jumpForce && this.swimJumpForce == other.swimJumpForce && this.jumpBufferDuration == other.jumpBufferDuration && this.jumpBufferMaxYVelocity == other.jumpBufferMaxYVelocity && this.acceleration == other.acceleration && this.airDragMin == other.airDragMin && this.airDragMax == other.airDragMax && this.airDragMinSpeed == other.airDragMinSpeed && this.airDragMaxSpeed == other.airDragMaxSpeed && this.airFrictionMin == other.airFrictionMin && this.airFrictionMax == other.airFrictionMax && this.airFrictionMinSpeed == other.airFrictionMinSpeed && this.airFrictionMaxSpeed == other.airFrictionMaxSpeed && this.airSpeedMultiplier == other.airSpeedMultiplier && this.airControlMinSpeed == other.airControlMinSpeed && this.airControlMaxSpeed == other.airControlMaxSpeed && this.airControlMinMultiplier == other.airControlMinMultiplier && this.airControlMaxMultiplier == other.airControlMaxMultiplier && this.comboAirSpeedMultiplier == other.comboAirSpeedMultiplier && this.baseSpeed == other.baseSpeed && this.climbSpeed == other.climbSpeed && this.climbSpeedLateral == other.climbSpeedLateral && this.climbUpSprintSpeed == other.climbUpSprintSpeed && this.climbDownSprintSpeed == other.climbDownSprintSpeed && this.horizontalFlySpeed == other.horizontalFlySpeed && this.verticalFlySpeed == other.verticalFlySpeed && this.maxSpeedMultiplier == other.maxSpeedMultiplier && this.minSpeedMultiplier == other.minSpeedMultiplier && this.wishDirectionGravityX == other.wishDirectionGravityX && this.wishDirectionGravityY == other.wishDirectionGravityY && this.wishDirectionWeightX == other.wishDirectionWeightX && this.wishDirectionWeightY == other.wishDirectionWeightY && java.util.Objects.equals(this.fly, other.fly) && this.collisionExpulsionForce == other.collisionExpulsionForce && this.forwardWalkSpeedMultiplier == other.forwardWalkSpeedMultiplier && this.backwardWalkSpeedMultiplier == other.backwardWalkSpeedMultiplier && this.strafeWalkSpeedMultiplier == other.strafeWalkSpeedMultiplier && this.forwardRunSpeedMultiplier == other.forwardRunSpeedMultiplier && this.backwardRunSpeedMultiplier == other.backwardRunSpeedMultiplier && this.strafeRunSpeedMultiplier == other.strafeRunSpeedMultiplier && this.forwardCrouchSpeedMultiplier == other.forwardCrouchSpeedMultiplier && this.backwardCrouchSpeedMultiplier == other.backwardCrouchSpeedMultiplier && this.strafeCrouchSpeedMultiplier == other.strafeCrouchSpeedMultiplier && this.forwardSprintSpeedMultiplier == other.forwardSprintSpeedMultiplier && this.variableJumpFallForce == other.variableJumpFallForce && this.fallEffectDuration == other.fallEffectDuration && this.fallJumpForce == other.fallJumpForce && this.fallMomentumLoss == other.fallMomentumLoss && this.autoJumpObstacleSpeedLoss == other.autoJumpObstacleSpeedLoss && this.autoJumpObstacleSprintSpeedLoss == other.autoJumpObstacleSprintSpeedLoss && this.autoJumpObstacleEffectDuration == other.autoJumpObstacleEffectDuration && this.autoJumpObstacleSprintEffectDuration == other.autoJumpObstacleSprintEffectDuration && this.autoJumpObstacleMaxAngle == other.autoJumpObstacleMaxAngle && this.autoJumpDisableJumping == other.autoJumpDisableJumping && this.minSlideEntrySpeed == other.minSlideEntrySpeed && this.slideExitSpeed == other.slideExitSpeed && this.minFallSpeedToEngageRoll == other.minFallSpeedToEngageRoll && this.maxFallSpeedToEngageRoll == other.maxFallSpeedToEngageRoll && this.rollStartSpeedModifier == other.rollStartSpeedModifier && this.rollExitSpeedModifier == other.rollExitSpeedModifier && this.rollTimeToComplete == other.rollTimeToComplete && this.maxSlopeAngleDegrees == other.maxSlopeAngleDegrees && this.maxWallAngleDegrees == other.maxWallAngleDegrees;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(mass, dragCoefficient, invertedGravity, velocityResistance, jumpForce, swimJumpForce, jumpBufferDuration, jumpBufferMaxYVelocity, acceleration, airDragMin, airDragMax, airDragMinSpeed, airDragMaxSpeed, airFrictionMin, airFrictionMax, airFrictionMinSpeed, airFrictionMaxSpeed, airSpeedMultiplier, airControlMinSpeed, airControlMaxSpeed, airControlMinMultiplier, airControlMaxMultiplier, comboAirSpeedMultiplier, baseSpeed, climbSpeed, climbSpeedLateral, climbUpSprintSpeed, climbDownSprintSpeed, horizontalFlySpeed, verticalFlySpeed, maxSpeedMultiplier, minSpeedMultiplier, wishDirectionGravityX, wishDirectionGravityY, wishDirectionWeightX, wishDirectionWeightY, fly, collisionExpulsionForce, forwardWalkSpeedMultiplier, backwardWalkSpeedMultiplier, strafeWalkSpeedMultiplier, forwardRunSpeedMultiplier, backwardRunSpeedMultiplier, strafeRunSpeedMultiplier, forwardCrouchSpeedMultiplier, backwardCrouchSpeedMultiplier, strafeCrouchSpeedMultiplier, forwardSprintSpeedMultiplier, variableJumpFallForce, fallEffectDuration, fallJumpForce, fallMomentumLoss, autoJumpObstacleSpeedLoss, autoJumpObstacleSprintSpeedLoss, autoJumpObstacleEffectDuration, autoJumpObstacleSprintEffectDuration, autoJumpObstacleMaxAngle, autoJumpDisableJumping, minSlideEntrySpeed, slideExitSpeed, minFallSpeedToEngageRoll, maxFallSpeedToEngageRoll, rollStartSpeedModifier, rollExitSpeedModifier, rollTimeToComplete, maxSlopeAngleDegrees, maxWallAngleDegrees);
    }

}