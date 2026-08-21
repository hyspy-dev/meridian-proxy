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

public class ServerCameraSettings {
    public static final int NULLABLE_BIT_FIELD_SIZE = 2;
    public static final int FIXED_BLOCK_SIZE = 179;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 179;
    public static final int MAX_SIZE = 179;

    public float positionLerpSpeed = 1;
    public float rotationLerpSpeed = 1;
    public float distance;
    public float speedModifier = 1;
    public boolean allowPitchControls;
    public boolean displayCursor;
    public boolean displayReticle;
    @Nonnull public MouseInputTargetType mouseInputTargetType = MouseInputTargetType.Any;
    public boolean sendMouseMotion;
    public boolean skipCharacterPhysics;
    public boolean isFirstPerson = true;
    public boolean hideHeldItem;
    @Nonnull public MovementForceRotationType movementForceRotationType = MovementForceRotationType.AttachedToHead;
    @Nullable public Direction movementForceRotation;
    @Nonnull public AttachedToType attachedToType = AttachedToType.LocalPlayer;
    public int attachedToEntityId;
    public boolean eyeOffset;
    public boolean followAttachedEntity;
    @Nonnull public PositionDistanceOffsetType positionDistanceOffsetType = PositionDistanceOffsetType.DistanceOffset;
    @Nullable public Position positionOffset;
    @Nullable public Direction rotationOffset;
    @Nonnull public PositionType positionType = PositionType.AttachedToPlusOffset;
    @Nullable public Position position;
    @Nonnull public RotationType rotationType = RotationType.AttachedToPlusOffset;
    @Nullable public Direction rotation;
    @Nonnull public CanMoveType canMoveType = CanMoveType.AttachedToLocalPlayer;
    @Nonnull public ApplyMovementType applyMovementType = ApplyMovementType.CharacterController;
    @Nullable public Vector3fc movementMultiplier;
    @Nonnull public ApplyLookType applyLookType = ApplyLookType.LocalPlayerLookOrientation;
    @Nullable public Vector2fc lookMultiplier;
    @Nonnull public MouseInputType mouseInputType = MouseInputType.LookAtTarget;
    @Nullable public Vector3fc planeNormal;
    @Nullable public Float baseFov;
    @Nullable public DepthOfFieldSettings depthOfField;

    public ServerCameraSettings() {
    }

    public ServerCameraSettings(float positionLerpSpeed, float rotationLerpSpeed, float distance, float speedModifier, boolean allowPitchControls, boolean displayCursor, boolean displayReticle, @Nonnull MouseInputTargetType mouseInputTargetType, boolean sendMouseMotion, boolean skipCharacterPhysics, boolean isFirstPerson, boolean hideHeldItem, @Nonnull MovementForceRotationType movementForceRotationType, @Nullable Direction movementForceRotation, @Nonnull AttachedToType attachedToType, int attachedToEntityId, boolean eyeOffset, boolean followAttachedEntity, @Nonnull PositionDistanceOffsetType positionDistanceOffsetType, @Nullable Position positionOffset, @Nullable Direction rotationOffset, @Nonnull PositionType positionType, @Nullable Position position, @Nonnull RotationType rotationType, @Nullable Direction rotation, @Nonnull CanMoveType canMoveType, @Nonnull ApplyMovementType applyMovementType, @Nullable Vector3fc movementMultiplier, @Nonnull ApplyLookType applyLookType, @Nullable Vector2fc lookMultiplier, @Nonnull MouseInputType mouseInputType, @Nullable Vector3fc planeNormal, @Nullable Float baseFov, @Nullable DepthOfFieldSettings depthOfField) {
        this.positionLerpSpeed = positionLerpSpeed;
        this.rotationLerpSpeed = rotationLerpSpeed;
        this.distance = distance;
        this.speedModifier = speedModifier;
        this.allowPitchControls = allowPitchControls;
        this.displayCursor = displayCursor;
        this.displayReticle = displayReticle;
        this.mouseInputTargetType = mouseInputTargetType;
        this.sendMouseMotion = sendMouseMotion;
        this.skipCharacterPhysics = skipCharacterPhysics;
        this.isFirstPerson = isFirstPerson;
        this.hideHeldItem = hideHeldItem;
        this.movementForceRotationType = movementForceRotationType;
        this.movementForceRotation = movementForceRotation;
        this.attachedToType = attachedToType;
        this.attachedToEntityId = attachedToEntityId;
        this.eyeOffset = eyeOffset;
        this.followAttachedEntity = followAttachedEntity;
        this.positionDistanceOffsetType = positionDistanceOffsetType;
        this.positionOffset = positionOffset;
        this.rotationOffset = rotationOffset;
        this.positionType = positionType;
        this.position = position;
        this.rotationType = rotationType;
        this.rotation = rotation;
        this.canMoveType = canMoveType;
        this.applyMovementType = applyMovementType;
        this.movementMultiplier = movementMultiplier;
        this.applyLookType = applyLookType;
        this.lookMultiplier = lookMultiplier;
        this.mouseInputType = mouseInputType;
        this.planeNormal = planeNormal;
        this.baseFov = baseFov;
        this.depthOfField = depthOfField;
    }

    public ServerCameraSettings(@Nonnull ServerCameraSettings other) {
        this.positionLerpSpeed = other.positionLerpSpeed;
        this.rotationLerpSpeed = other.rotationLerpSpeed;
        this.distance = other.distance;
        this.speedModifier = other.speedModifier;
        this.allowPitchControls = other.allowPitchControls;
        this.displayCursor = other.displayCursor;
        this.displayReticle = other.displayReticle;
        this.mouseInputTargetType = other.mouseInputTargetType;
        this.sendMouseMotion = other.sendMouseMotion;
        this.skipCharacterPhysics = other.skipCharacterPhysics;
        this.isFirstPerson = other.isFirstPerson;
        this.hideHeldItem = other.hideHeldItem;
        this.movementForceRotationType = other.movementForceRotationType;
        this.movementForceRotation = other.movementForceRotation;
        this.attachedToType = other.attachedToType;
        this.attachedToEntityId = other.attachedToEntityId;
        this.eyeOffset = other.eyeOffset;
        this.followAttachedEntity = other.followAttachedEntity;
        this.positionDistanceOffsetType = other.positionDistanceOffsetType;
        this.positionOffset = other.positionOffset;
        this.rotationOffset = other.rotationOffset;
        this.positionType = other.positionType;
        this.position = other.position;
        this.rotationType = other.rotationType;
        this.rotation = other.rotation;
        this.canMoveType = other.canMoveType;
        this.applyMovementType = other.applyMovementType;
        this.movementMultiplier = other.movementMultiplier;
        this.applyLookType = other.applyLookType;
        this.lookMultiplier = other.lookMultiplier;
        this.mouseInputType = other.mouseInputType;
        this.planeNormal = other.planeNormal;
        this.baseFov = other.baseFov;
        this.depthOfField = other.depthOfField;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ServerCameraSettings", offset, (int) mem.byteSize());
        long needed = (long) offset + 179;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ServerCameraSettings", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getPositionLerpSpeed(MemorySegment mem) {
        return getPositionLerpSpeed(mem, 0);
    }
    
    public static float getPositionLerpSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "PositionLerpSpeed");
    }
    
    public static float getRotationLerpSpeed(MemorySegment mem) {
        return getRotationLerpSpeed(mem, 0);
    }
    
    public static float getRotationLerpSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 6), "RotationLerpSpeed");
    }
    
    public static float getDistance(MemorySegment mem) {
        return getDistance(mem, 0);
    }
    
    public static float getDistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 10), "Distance");
    }
    
    public static float getSpeedModifier(MemorySegment mem) {
        return getSpeedModifier(mem, 0);
    }
    
    public static float getSpeedModifier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 14), "SpeedModifier");
    }
    
    public static boolean getAllowPitchControls(MemorySegment mem) {
        return getAllowPitchControls(mem, 0);
    }
    
    public static boolean getAllowPitchControls(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 18) & 0x01) != 0;
    }
    
    public static boolean getDisplayCursor(MemorySegment mem) {
        return getDisplayCursor(mem, 0);
    }
    
    public static boolean getDisplayCursor(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 18) & 0x02) != 0;
    }
    
    public static boolean getDisplayReticle(MemorySegment mem) {
        return getDisplayReticle(mem, 0);
    }
    
    public static boolean getDisplayReticle(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 18) & 0x04) != 0;
    }
    
    public static MouseInputTargetType getMouseInputTargetType(MemorySegment mem) {
        return getMouseInputTargetType(mem, 0);
    }
    
    public static MouseInputTargetType getMouseInputTargetType(MemorySegment mem, int offset) {
        return MouseInputTargetType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 19));
    }
    
    public static boolean getSendMouseMotion(MemorySegment mem) {
        return getSendMouseMotion(mem, 0);
    }
    
    public static boolean getSendMouseMotion(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 20) & 0x01) != 0;
    }
    
    public static boolean getSkipCharacterPhysics(MemorySegment mem) {
        return getSkipCharacterPhysics(mem, 0);
    }
    
    public static boolean getSkipCharacterPhysics(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 20) & 0x02) != 0;
    }
    
    public static boolean getIsFirstPerson(MemorySegment mem) {
        return getIsFirstPerson(mem, 0);
    }
    
    public static boolean getIsFirstPerson(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 20) & 0x04) != 0;
    }
    
    public static boolean getHideHeldItem(MemorySegment mem) {
        return getHideHeldItem(mem, 0);
    }
    
    public static boolean getHideHeldItem(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 20) & 0x08) != 0;
    }
    
    public static MovementForceRotationType getMovementForceRotationType(MemorySegment mem) {
        return getMovementForceRotationType(mem, 0);
    }
    
    public static MovementForceRotationType getMovementForceRotationType(MemorySegment mem, int offset) {
        return MovementForceRotationType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 21));
    }
    
    @Nullable
    public static Direction getMovementForceRotation(MemorySegment mem) {
        return getMovementForceRotation(mem, 0);
    }
    
    @Nullable
    public static Direction getMovementForceRotation(MemorySegment mem, int offset) {
        return hasMovementForceRotation(mem, offset) ? Direction.toObject(mem, offset + 22): null;
    }
    
    public static AttachedToType getAttachedToType(MemorySegment mem) {
        return getAttachedToType(mem, 0);
    }
    
    public static AttachedToType getAttachedToType(MemorySegment mem, int offset) {
        return AttachedToType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 34));
    }
    
    public static int getAttachedToEntityId(MemorySegment mem) {
        return getAttachedToEntityId(mem, 0);
    }
    
    public static int getAttachedToEntityId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 35);
    }
    
    public static boolean getEyeOffset(MemorySegment mem) {
        return getEyeOffset(mem, 0);
    }
    
    public static boolean getEyeOffset(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 39) & 0x01) != 0;
    }
    
    public static boolean getFollowAttachedEntity(MemorySegment mem) {
        return getFollowAttachedEntity(mem, 0);
    }
    
    public static boolean getFollowAttachedEntity(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 39) & 0x02) != 0;
    }
    
    public static PositionDistanceOffsetType getPositionDistanceOffsetType(MemorySegment mem) {
        return getPositionDistanceOffsetType(mem, 0);
    }
    
    public static PositionDistanceOffsetType getPositionDistanceOffsetType(MemorySegment mem, int offset) {
        return PositionDistanceOffsetType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 40));
    }
    
    @Nullable
    public static Position getPositionOffset(MemorySegment mem) {
        return getPositionOffset(mem, 0);
    }
    
    @Nullable
    public static Position getPositionOffset(MemorySegment mem, int offset) {
        return hasPositionOffset(mem, offset) ? Position.toObject(mem, offset + 41): null;
    }
    
    @Nullable
    public static Direction getRotationOffset(MemorySegment mem) {
        return getRotationOffset(mem, 0);
    }
    
    @Nullable
    public static Direction getRotationOffset(MemorySegment mem, int offset) {
        return hasRotationOffset(mem, offset) ? Direction.toObject(mem, offset + 65): null;
    }
    
    public static PositionType getPositionType(MemorySegment mem) {
        return getPositionType(mem, 0);
    }
    
    public static PositionType getPositionType(MemorySegment mem, int offset) {
        return PositionType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 77));
    }
    
    @Nullable
    public static Position getPosition(MemorySegment mem) {
        return getPosition(mem, 0);
    }
    
    @Nullable
    public static Position getPosition(MemorySegment mem, int offset) {
        return hasPosition(mem, offset) ? Position.toObject(mem, offset + 78): null;
    }
    
    public static RotationType getRotationType(MemorySegment mem) {
        return getRotationType(mem, 0);
    }
    
    public static RotationType getRotationType(MemorySegment mem, int offset) {
        return RotationType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 102));
    }
    
    @Nullable
    public static Direction getRotation(MemorySegment mem) {
        return getRotation(mem, 0);
    }
    
    @Nullable
    public static Direction getRotation(MemorySegment mem, int offset) {
        return hasRotation(mem, offset) ? Direction.toObject(mem, offset + 103): null;
    }
    
    public static CanMoveType getCanMoveType(MemorySegment mem) {
        return getCanMoveType(mem, 0);
    }
    
    public static CanMoveType getCanMoveType(MemorySegment mem, int offset) {
        return CanMoveType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 115));
    }
    
    public static ApplyMovementType getApplyMovementType(MemorySegment mem) {
        return getApplyMovementType(mem, 0);
    }
    
    public static ApplyMovementType getApplyMovementType(MemorySegment mem, int offset) {
        return ApplyMovementType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 116));
    }
    
    @Nullable
    public static Vector3fc getMovementMultiplier(MemorySegment mem) {
        return getMovementMultiplier(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getMovementMultiplier(MemorySegment mem, int offset) {
        return hasMovementMultiplier(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 117), "MovementMultiplier"): null;
    }
    
    public static ApplyLookType getApplyLookType(MemorySegment mem) {
        return getApplyLookType(mem, 0);
    }
    
    public static ApplyLookType getApplyLookType(MemorySegment mem, int offset) {
        return ApplyLookType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 129));
    }
    
    @Nullable
    public static Vector2fc getLookMultiplier(MemorySegment mem) {
        return getLookMultiplier(mem, 0);
    }
    
    @Nullable
    public static Vector2fc getLookMultiplier(MemorySegment mem, int offset) {
        return hasLookMultiplier(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector2f(mem, offset + 130), "LookMultiplier"): null;
    }
    
    public static MouseInputType getMouseInputType(MemorySegment mem) {
        return getMouseInputType(mem, 0);
    }
    
    public static MouseInputType getMouseInputType(MemorySegment mem, int offset) {
        return MouseInputType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 138));
    }
    
    @Nullable
    public static Vector3fc getPlaneNormal(MemorySegment mem) {
        return getPlaneNormal(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getPlaneNormal(MemorySegment mem, int offset) {
        return hasPlaneNormal(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 139), "PlaneNormal"): null;
    }
    
    @Nullable
    public static Float getBaseFov(MemorySegment mem) {
        return getBaseFov(mem, 0);
    }
    
    @Nullable
    public static Float getBaseFov(MemorySegment mem, int offset) {
        return hasBaseFov(mem, offset) ? PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 151), "BaseFov"): null;
    }
    
    @Nullable
    public static DepthOfFieldSettings getDepthOfField(MemorySegment mem) {
        return getDepthOfField(mem, 0);
    }
    
    @Nullable
    public static DepthOfFieldSettings getDepthOfField(MemorySegment mem, int offset) {
        return hasDepthOfField(mem, offset) ? DepthOfFieldSettings.toObject(mem, offset + 155): null;
    }
    
    public static boolean hasMovementForceRotation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasPositionOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasRotationOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasPosition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasRotation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasMovementMultiplier(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasLookMultiplier(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasPlaneNormal(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasBaseFov(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasDepthOfField(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x02) != 0;
    }
    
    
    
    public static ServerCameraSettings toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ServerCameraSettings toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ServerCameraSettings and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ServerCameraSettings toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new ServerCameraSettings(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "PositionLerpSpeed"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 6), "RotationLerpSpeed"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 10), "Distance"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 14), "SpeedModifier"),
            (mem.get(PacketIO.PROTO_BYTE, offset + 18) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 18) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 18) & 0x04) != 0,
            MouseInputTargetType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 19)),
            (mem.get(PacketIO.PROTO_BYTE, offset + 20) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 20) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 20) & 0x04) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 20) & 0x08) != 0,
            MovementForceRotationType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 21)),
            hasMovementForceRotation(mem, offset) ? Direction.toObject(mem, offset + 22) : null,
            AttachedToType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 34)),
            mem.get(PacketIO.PROTO_INT, offset + 35),
            (mem.get(PacketIO.PROTO_BYTE, offset + 39) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 39) & 0x02) != 0,
            PositionDistanceOffsetType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 40)),
            hasPositionOffset(mem, offset) ? Position.toObject(mem, offset + 41) : null,
            hasRotationOffset(mem, offset) ? Direction.toObject(mem, offset + 65) : null,
            PositionType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 77)),
            hasPosition(mem, offset) ? Position.toObject(mem, offset + 78) : null,
            RotationType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 102)),
            hasRotation(mem, offset) ? Direction.toObject(mem, offset + 103) : null,
            CanMoveType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 115)),
            ApplyMovementType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 116)),
            hasMovementMultiplier(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 117), "MovementMultiplier") : null,
            ApplyLookType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 129)),
            hasLookMultiplier(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector2f(mem, offset + 130), "LookMultiplier") : null,
            MouseInputType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 138)),
            hasPlaneNormal(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 139), "PlaneNormal") : null,
            hasBaseFov(mem, offset) ? PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 151), "BaseFov") : null,
            hasDepthOfField(mem, offset) ? DepthOfFieldSettings.toObject(mem, offset + 155) : null
        );
        if (cursor != null) cursor.position = offset + 179;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.movementForceRotation != null) nullBits |= 0x01;
        if (this.positionOffset != null) nullBits |= 0x02;
        if (this.rotationOffset != null) nullBits |= 0x04;
        if (this.position != null) nullBits |= 0x08;
        if (this.rotation != null) nullBits |= 0x10;
        if (this.movementMultiplier != null) nullBits |= 0x20;
        if (this.lookMultiplier != null) nullBits |= 0x40;
        if (this.planeNormal != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        nullBits = 0;
        if (this.baseFov != null) nullBits |= 0x01;
        if (this.depthOfField != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 1, nullBits);
        
        PacketIO.requireFinite(this.positionLerpSpeed, "PositionLerpSpeed"); mem.set(PacketIO.PROTO_FLOAT, offset + 2, this.positionLerpSpeed);
        PacketIO.requireFinite(this.rotationLerpSpeed, "RotationLerpSpeed"); mem.set(PacketIO.PROTO_FLOAT, offset + 6, this.rotationLerpSpeed);
        PacketIO.requireFinite(this.distance, "Distance"); mem.set(PacketIO.PROTO_FLOAT, offset + 10, this.distance);
        PacketIO.requireFinite(this.speedModifier, "SpeedModifier"); mem.set(PacketIO.PROTO_FLOAT, offset + 14, this.speedModifier);
        byte boolBits0_0 = 0;
        if (this.allowPitchControls) boolBits0_0 |= 0x01;
        if (this.displayCursor) boolBits0_0 |= 0x02;
        if (this.displayReticle) boolBits0_0 |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 18 + 0, boolBits0_0);
        mem.set(PacketIO.PROTO_BYTE, offset + 19, (byte) this.mouseInputTargetType.getValue());
        byte boolBits1_0 = 0;
        if (this.sendMouseMotion) boolBits1_0 |= 0x01;
        if (this.skipCharacterPhysics) boolBits1_0 |= 0x02;
        if (this.isFirstPerson) boolBits1_0 |= 0x04;
        if (this.hideHeldItem) boolBits1_0 |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 20 + 0, boolBits1_0);
        mem.set(PacketIO.PROTO_BYTE, offset + 21, (byte) this.movementForceRotationType.getValue());
        if (this.movementForceRotation != null) {
            this.movementForceRotation.serialize(mem, offset + 22);
        } else {
            mem.asSlice(offset + 22, 12).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BYTE, offset + 34, (byte) this.attachedToType.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 35, this.attachedToEntityId);
        byte boolBits2_0 = 0;
        if (this.eyeOffset) boolBits2_0 |= 0x01;
        if (this.followAttachedEntity) boolBits2_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 39 + 0, boolBits2_0);
        mem.set(PacketIO.PROTO_BYTE, offset + 40, (byte) this.positionDistanceOffsetType.getValue());
        if (this.positionOffset != null) {
            this.positionOffset.serialize(mem, offset + 41);
        } else {
            mem.asSlice(offset + 41, 24).fill((byte) 0); 
        }
        if (this.rotationOffset != null) {
            this.rotationOffset.serialize(mem, offset + 65);
        } else {
            mem.asSlice(offset + 65, 12).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BYTE, offset + 77, (byte) this.positionType.getValue());
        if (this.position != null) {
            this.position.serialize(mem, offset + 78);
        } else {
            mem.asSlice(offset + 78, 24).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BYTE, offset + 102, (byte) this.rotationType.getValue());
        if (this.rotation != null) {
            this.rotation.serialize(mem, offset + 103);
        } else {
            mem.asSlice(offset + 103, 12).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BYTE, offset + 115, (byte) this.canMoveType.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 116, (byte) this.applyMovementType.getValue());
        if (this.movementMultiplier != null) {
            PacketIO.requireFinite(this.movementMultiplier, "MovementMultiplier"); PacketIO.writeVector3f(mem, offset + 117, this.movementMultiplier);
        } else {
            mem.asSlice(offset + 117, 12).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BYTE, offset + 129, (byte) this.applyLookType.getValue());
        if (this.lookMultiplier != null) {
            PacketIO.requireFinite(this.lookMultiplier, "LookMultiplier"); PacketIO.writeVector2f(mem, offset + 130, this.lookMultiplier);
        } else {
            mem.asSlice(offset + 130, 8).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BYTE, offset + 138, (byte) this.mouseInputType.getValue());
        if (this.planeNormal != null) {
            PacketIO.requireFinite(this.planeNormal, "PlaneNormal"); PacketIO.writeVector3f(mem, offset + 139, this.planeNormal);
        } else {
            mem.asSlice(offset + 139, 12).fill((byte) 0); 
        }
        if (this.baseFov != null) {
            PacketIO.requireFinite(this.baseFov, "BaseFov"); mem.set(PacketIO.PROTO_FLOAT, offset + 151, this.baseFov);
        } else {
            mem.asSlice(offset + 151, 4).fill((byte) 0); 
        }
        if (this.depthOfField != null) {
            this.depthOfField.serialize(mem, offset + 155);
        } else {
            mem.asSlice(offset + 155, 24).fill((byte) 0); 
        }
        
        
    
       return 179;
    }
    public int computeSize() {
        return 179;
    }

    public ServerCameraSettings clone() {
        ServerCameraSettings copy = new ServerCameraSettings();
        copy.positionLerpSpeed = this.positionLerpSpeed;
        copy.rotationLerpSpeed = this.rotationLerpSpeed;
        copy.distance = this.distance;
        copy.speedModifier = this.speedModifier;
        copy.allowPitchControls = this.allowPitchControls;
        copy.displayCursor = this.displayCursor;
        copy.displayReticle = this.displayReticle;
        copy.mouseInputTargetType = this.mouseInputTargetType;
        copy.sendMouseMotion = this.sendMouseMotion;
        copy.skipCharacterPhysics = this.skipCharacterPhysics;
        copy.isFirstPerson = this.isFirstPerson;
        copy.hideHeldItem = this.hideHeldItem;
        copy.movementForceRotationType = this.movementForceRotationType;
        copy.movementForceRotation = this.movementForceRotation != null ? this.movementForceRotation.clone() : null;
        copy.attachedToType = this.attachedToType;
        copy.attachedToEntityId = this.attachedToEntityId;
        copy.eyeOffset = this.eyeOffset;
        copy.followAttachedEntity = this.followAttachedEntity;
        copy.positionDistanceOffsetType = this.positionDistanceOffsetType;
        copy.positionOffset = this.positionOffset != null ? this.positionOffset.clone() : null;
        copy.rotationOffset = this.rotationOffset != null ? this.rotationOffset.clone() : null;
        copy.positionType = this.positionType;
        copy.position = this.position != null ? this.position.clone() : null;
        copy.rotationType = this.rotationType;
        copy.rotation = this.rotation != null ? this.rotation.clone() : null;
        copy.canMoveType = this.canMoveType;
        copy.applyMovementType = this.applyMovementType;
        copy.movementMultiplier = this.movementMultiplier;
        copy.applyLookType = this.applyLookType;
        copy.lookMultiplier = this.lookMultiplier;
        copy.mouseInputType = this.mouseInputType;
        copy.planeNormal = this.planeNormal;
        copy.baseFov = this.baseFov;
        copy.depthOfField = this.depthOfField != null ? this.depthOfField.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ServerCameraSettings other)) return false;
        return this.positionLerpSpeed == other.positionLerpSpeed && this.rotationLerpSpeed == other.rotationLerpSpeed && this.distance == other.distance && this.speedModifier == other.speedModifier && this.allowPitchControls == other.allowPitchControls && this.displayCursor == other.displayCursor && this.displayReticle == other.displayReticle && java.util.Objects.equals(this.mouseInputTargetType, other.mouseInputTargetType) && this.sendMouseMotion == other.sendMouseMotion && this.skipCharacterPhysics == other.skipCharacterPhysics && this.isFirstPerson == other.isFirstPerson && this.hideHeldItem == other.hideHeldItem && java.util.Objects.equals(this.movementForceRotationType, other.movementForceRotationType) && java.util.Objects.equals(this.movementForceRotation, other.movementForceRotation) && java.util.Objects.equals(this.attachedToType, other.attachedToType) && this.attachedToEntityId == other.attachedToEntityId && this.eyeOffset == other.eyeOffset && this.followAttachedEntity == other.followAttachedEntity && java.util.Objects.equals(this.positionDistanceOffsetType, other.positionDistanceOffsetType) && java.util.Objects.equals(this.positionOffset, other.positionOffset) && java.util.Objects.equals(this.rotationOffset, other.rotationOffset) && java.util.Objects.equals(this.positionType, other.positionType) && java.util.Objects.equals(this.position, other.position) && java.util.Objects.equals(this.rotationType, other.rotationType) && java.util.Objects.equals(this.rotation, other.rotation) && java.util.Objects.equals(this.canMoveType, other.canMoveType) && java.util.Objects.equals(this.applyMovementType, other.applyMovementType) && java.util.Objects.equals(this.movementMultiplier, other.movementMultiplier) && java.util.Objects.equals(this.applyLookType, other.applyLookType) && java.util.Objects.equals(this.lookMultiplier, other.lookMultiplier) && java.util.Objects.equals(this.mouseInputType, other.mouseInputType) && java.util.Objects.equals(this.planeNormal, other.planeNormal) && java.util.Objects.equals(this.baseFov, other.baseFov) && java.util.Objects.equals(this.depthOfField, other.depthOfField);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(positionLerpSpeed, rotationLerpSpeed, distance, speedModifier, allowPitchControls, displayCursor, displayReticle, mouseInputTargetType, sendMouseMotion, skipCharacterPhysics, isFirstPerson, hideHeldItem, movementForceRotationType, movementForceRotation, attachedToType, attachedToEntityId, eyeOffset, followAttachedEntity, positionDistanceOffsetType, positionOffset, rotationOffset, positionType, position, rotationType, rotation, canMoveType, applyMovementType, movementMultiplier, applyLookType, lookMultiplier, mouseInputType, planeNormal, baseFov, depthOfField);
    }

}