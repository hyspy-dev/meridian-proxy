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
import java.util.HashMap;

public class ApplyForceInteraction extends SimpleInteraction {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 83;
    public static final int VARIABLE_FIELD_COUNT = 6;
    public static final int VARIABLE_BLOCK_START = 107;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public VelocityConfig velocityConfig;
    @Nonnull public ChangeVelocityType changeVelocityType = ChangeVelocityType.Add;
    @Nonnull public AppliedForce[] forces = new AppliedForce[0];
    public float duration;
    @Nullable public FloatRange verticalClamp;
    public boolean waitForGround;
    public boolean waitForCollision;
    public float groundCheckDelay;
    public float collisionCheckDelay;
    public int groundNext;
    public int collisionNext;
    public float raycastDistance;
    public float raycastHeightOffset;
    @Nonnull public RaycastMode raycastMode = RaycastMode.FollowMotion;
    public boolean useTargetBlockForDirection;

    public ApplyForceInteraction() {
    }

    public ApplyForceInteraction(@Nonnull WaitForDataFrom waitForDataFrom, @Nullable InteractionEffects effects, float horizontalSpeedMultiplier, float runTime, @Nonnull InteractionItemChangeBehavior onItemChangeBehavior, @Nullable java.util.Map<GameMode, InteractionSettings> settings, @Nonnull InteractionRules rules, @Nullable int[] tags, @Nullable InteractionCameraSettings camera, int next, int failed, @Nullable VelocityConfig velocityConfig, @Nonnull ChangeVelocityType changeVelocityType, @Nonnull AppliedForce[] forces, float duration, @Nullable FloatRange verticalClamp, boolean waitForGround, boolean waitForCollision, float groundCheckDelay, float collisionCheckDelay, int groundNext, int collisionNext, float raycastDistance, float raycastHeightOffset, @Nonnull RaycastMode raycastMode, boolean useTargetBlockForDirection) {
        this.waitForDataFrom = waitForDataFrom;
        this.effects = effects;
        this.horizontalSpeedMultiplier = horizontalSpeedMultiplier;
        this.runTime = runTime;
        this.onItemChangeBehavior = onItemChangeBehavior;
        this.settings = settings;
        this.rules = rules;
        this.tags = tags;
        this.camera = camera;
        this.next = next;
        this.failed = failed;
        this.velocityConfig = velocityConfig;
        this.changeVelocityType = changeVelocityType;
        this.forces = forces;
        this.duration = duration;
        this.verticalClamp = verticalClamp;
        this.waitForGround = waitForGround;
        this.waitForCollision = waitForCollision;
        this.groundCheckDelay = groundCheckDelay;
        this.collisionCheckDelay = collisionCheckDelay;
        this.groundNext = groundNext;
        this.collisionNext = collisionNext;
        this.raycastDistance = raycastDistance;
        this.raycastHeightOffset = raycastHeightOffset;
        this.raycastMode = raycastMode;
        this.useTargetBlockForDirection = useTargetBlockForDirection;
    }

    public ApplyForceInteraction(@Nonnull ApplyForceInteraction other) {
        this.waitForDataFrom = other.waitForDataFrom;
        this.effects = other.effects;
        this.horizontalSpeedMultiplier = other.horizontalSpeedMultiplier;
        this.runTime = other.runTime;
        this.onItemChangeBehavior = other.onItemChangeBehavior;
        this.settings = other.settings;
        this.rules = other.rules;
        this.tags = other.tags;
        this.camera = other.camera;
        this.next = other.next;
        this.failed = other.failed;
        this.velocityConfig = other.velocityConfig;
        this.changeVelocityType = other.changeVelocityType;
        this.forces = other.forces;
        this.duration = other.duration;
        this.verticalClamp = other.verticalClamp;
        this.waitForGround = other.waitForGround;
        this.waitForCollision = other.waitForCollision;
        this.groundCheckDelay = other.groundCheckDelay;
        this.collisionCheckDelay = other.collisionCheckDelay;
        this.groundNext = other.groundNext;
        this.collisionNext = other.collisionNext;
        this.raycastDistance = other.raycastDistance;
        this.raycastHeightOffset = other.raycastHeightOffset;
        this.raycastMode = other.raycastMode;
        this.useTargetBlockForDirection = other.useTargetBlockForDirection;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ApplyForceInteraction", offset, (int) mem.byteSize());
        long needed = (long) offset + 107;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ApplyForceInteraction", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static WaitForDataFrom getWaitForDataFrom(MemorySegment mem) {
        return getWaitForDataFrom(mem, 0);
    }
    
    public static WaitForDataFrom getWaitForDataFrom(MemorySegment mem, int offset) {
        return WaitForDataFrom.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static InteractionEffects getEffects(MemorySegment mem) {
        return getEffects(mem, 0);
    }
    
    @Nullable
    public static InteractionEffects getEffects(MemorySegment mem, int offset) {
        return hasEffects(mem, offset) ? InteractionEffects.toObject(mem, offset + getValidatedOffset(mem, offset, 83, 107, "Effects")): null;
    }
    
    public static float getHorizontalSpeedMultiplier(MemorySegment mem) {
        return getHorizontalSpeedMultiplier(mem, 0);
    }
    
    public static float getHorizontalSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "HorizontalSpeedMultiplier");
    }
    
    public static float getRunTime(MemorySegment mem) {
        return getRunTime(mem, 0);
    }
    
    public static float getRunTime(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 6), "RunTime");
    }
    
    public static InteractionItemChangeBehavior getOnItemChangeBehavior(MemorySegment mem) {
        return getOnItemChangeBehavior(mem, 0);
    }
    
    public static InteractionItemChangeBehavior getOnItemChangeBehavior(MemorySegment mem, int offset) {
        return InteractionItemChangeBehavior.fromValue(mem.get(PacketIO.PROTO_INT, offset + 10));
    }
    
    @Nullable
    public static java.util.Map<GameMode, InteractionSettings> getSettings(MemorySegment mem) {
        return getSettings(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<GameMode, InteractionSettings> getSettings(MemorySegment mem, int offset) {
        if (!hasSettings(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 87, 107, "Settings");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Settings");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Settings", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Settings", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<GameMode, InteractionSettings> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = GameMode.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                off += 1;
            var value = InteractionSettings.toObject(mem, off);
                off += 1;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Settings", key);
            }
        }
        return data;
    }
    
    public static InteractionRules getRules(MemorySegment mem) {
        return getRules(mem, 0);
    }
    
    public static InteractionRules getRules(MemorySegment mem, int offset) {
        return InteractionRules.toObject(mem, offset + getValidatedOffset(mem, offset, 91, 107, "Rules"));
    }
    
    @Nullable
    public static int[] getTags(MemorySegment mem) {
        return getTags(mem, 0);
    }
    
    @Nullable
    public static int[] getTags(MemorySegment mem, int offset) {
        if (!hasTags(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 95, 107, "Tags");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Tags");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Tags", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Tags", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    @Nullable
    public static InteractionCameraSettings getCamera(MemorySegment mem) {
        return getCamera(mem, 0);
    }
    
    @Nullable
    public static InteractionCameraSettings getCamera(MemorySegment mem, int offset) {
        return hasCamera(mem, offset) ? InteractionCameraSettings.toObject(mem, offset + getValidatedOffset(mem, offset, 99, 107, "Camera")): null;
    }
    
    public static int getNext(MemorySegment mem) {
        return getNext(mem, 0);
    }
    
    public static int getNext(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 14);
    }
    
    public static int getFailed(MemorySegment mem) {
        return getFailed(mem, 0);
    }
    
    public static int getFailed(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 18);
    }
    
    @Nullable
    public static VelocityConfig getVelocityConfig(MemorySegment mem) {
        return getVelocityConfig(mem, 0);
    }
    
    @Nullable
    public static VelocityConfig getVelocityConfig(MemorySegment mem, int offset) {
        return hasVelocityConfig(mem, offset) ? VelocityConfig.toObject(mem, offset + 22): null;
    }
    
    public static ChangeVelocityType getChangeVelocityType(MemorySegment mem) {
        return getChangeVelocityType(mem, 0);
    }
    
    public static ChangeVelocityType getChangeVelocityType(MemorySegment mem, int offset) {
        return ChangeVelocityType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 43));
    }
    
    public static AppliedForce[] getForces(MemorySegment mem) {
        return getForces(mem, 0);
    }
    
    public static AppliedForce[] getForces(MemorySegment mem, int offset) {
        var off = offset + getValidatedOffset(mem, offset, 103, 107, "Forces");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Forces");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Forces", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Forces", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new AppliedForce[len];
        for (var i = 0; i < len; i++) {
            data[i] = AppliedForce.toObject(mem, off + i * 17);
        }
        return data;
    }
    
    public static float getDuration(MemorySegment mem) {
        return getDuration(mem, 0);
    }
    
    public static float getDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 44), "Duration");
    }
    
    @Nullable
    public static FloatRange getVerticalClamp(MemorySegment mem) {
        return getVerticalClamp(mem, 0);
    }
    
    @Nullable
    public static FloatRange getVerticalClamp(MemorySegment mem, int offset) {
        return hasVerticalClamp(mem, offset) ? FloatRange.toObject(mem, offset + 48): null;
    }
    
    public static boolean getWaitForGround(MemorySegment mem) {
        return getWaitForGround(mem, 0);
    }
    
    public static boolean getWaitForGround(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 56) & 0x01) != 0;
    }
    
    public static boolean getWaitForCollision(MemorySegment mem) {
        return getWaitForCollision(mem, 0);
    }
    
    public static boolean getWaitForCollision(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 56) & 0x02) != 0;
    }
    
    public static float getGroundCheckDelay(MemorySegment mem) {
        return getGroundCheckDelay(mem, 0);
    }
    
    public static float getGroundCheckDelay(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 57), "GroundCheckDelay");
    }
    
    public static float getCollisionCheckDelay(MemorySegment mem) {
        return getCollisionCheckDelay(mem, 0);
    }
    
    public static float getCollisionCheckDelay(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 61), "CollisionCheckDelay");
    }
    
    public static int getGroundNext(MemorySegment mem) {
        return getGroundNext(mem, 0);
    }
    
    public static int getGroundNext(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 65);
    }
    
    public static int getCollisionNext(MemorySegment mem) {
        return getCollisionNext(mem, 0);
    }
    
    public static int getCollisionNext(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 69);
    }
    
    public static float getRaycastDistance(MemorySegment mem) {
        return getRaycastDistance(mem, 0);
    }
    
    public static float getRaycastDistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 73), "RaycastDistance");
    }
    
    public static float getRaycastHeightOffset(MemorySegment mem) {
        return getRaycastHeightOffset(mem, 0);
    }
    
    public static float getRaycastHeightOffset(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 77), "RaycastHeightOffset");
    }
    
    public static RaycastMode getRaycastMode(MemorySegment mem) {
        return getRaycastMode(mem, 0);
    }
    
    public static RaycastMode getRaycastMode(MemorySegment mem, int offset) {
        return RaycastMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 81));
    }
    
    public static boolean getUseTargetBlockForDirection(MemorySegment mem) {
        return getUseTargetBlockForDirection(mem, 0);
    }
    
    public static boolean getUseTargetBlockForDirection(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 82);
    }
    
    public static boolean hasVelocityConfig(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasVerticalClamp(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasEffects(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasSettings(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasTags(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasCamera(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    private static int getValidatedOffset(MemorySegment buffer, int base, int slotPosition, int varBlockStart, String fieldName) {
        int offset = buffer.get(PacketIO.PROTO_INT, base + slotPosition);
        if (offset < 0 || offset > buffer.byteSize() - base - varBlockStart)
            throw ProtocolException.invalidOffset(fieldName, offset, (int) buffer.byteSize());
        return varBlockStart + offset;
    }
    
    /**
     * Rejects an offset slot that does not name the position the field-order walk reached. A
     * present field must sit where the previous field ended, and an absent field carries -1, so
     * the slot a random-access getter resolves and the walk describe the same bytes.
     */
    private static void requireSlot(MemorySegment mem, int slotPosition, int expected, String fieldName) {
        int slot = mem.get(PacketIO.PROTO_INT, slotPosition);
        if (slot != expected) throw ProtocolException.nonCanonicalLayout(fieldName, slot, expected);
    }
    
    public static ApplyForceInteraction toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ApplyForceInteraction toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ApplyForceInteraction and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ApplyForceInteraction toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 107;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        InteractionEffects v1 = null;
        if (hasEffects(mem, offset)) {
            requireSlot(mem, offset + 83, varPos, "Effects");
            v1 = InteractionEffects.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 83, -1, "Effects");
        }
        
        java.util.Map<GameMode, InteractionSettings> v5 = null;
        if (hasSettings(mem, offset)) {
            requireSlot(mem, offset + 87, varPos, "Settings");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Settings");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Settings", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Settings", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            v5 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = GameMode.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                    off += 1;
                var value = InteractionSettings.toObject(mem, off);
                    off += 1;
                if (v5.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Settings", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 87, -1, "Settings");
        }
        
        InteractionRules v6;
        requireSlot(mem, offset + 91, varPos, "Rules");
        {
            v6 = InteractionRules.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        
        int[] v7 = null;
        if (hasTags(mem, offset)) {
            requireSlot(mem, offset + 95, varPos, "Tags");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Tags");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Tags", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Tags", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v7 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v7, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 95, -1, "Tags");
        }
        
        InteractionCameraSettings v8 = null;
        if (hasCamera(mem, offset)) {
            requireSlot(mem, offset + 99, varPos, "Camera");
            v8 = InteractionCameraSettings.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 99, -1, "Camera");
        }
        
        AppliedForce[] v13;
        requireSlot(mem, offset + 103, varPos, "Forces");
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Forces");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Forces", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Forces", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v13 = new AppliedForce[len];
            for (var i = 0; i < len; i++) {
                v13[i] = AppliedForce.toObject(mem, off + i * 17);
            }
            varPos = off + len * 17 - varBase;
        }
        var result = new ApplyForceInteraction(
            WaitForDataFrom.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v1,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "HorizontalSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 6), "RunTime"),
            InteractionItemChangeBehavior.fromValue(mem.get(PacketIO.PROTO_INT, offset + 10)),
            v5,
            v6,
            v7,
            v8,
            mem.get(PacketIO.PROTO_INT, offset + 14),
            mem.get(PacketIO.PROTO_INT, offset + 18),
            hasVelocityConfig(mem, offset) ? VelocityConfig.toObject(mem, offset + 22) : null,
            ChangeVelocityType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 43)),
            v13,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 44), "Duration"),
            hasVerticalClamp(mem, offset) ? FloatRange.toObject(mem, offset + 48) : null,
            (mem.get(PacketIO.PROTO_BYTE, offset + 56) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 56) & 0x02) != 0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 57), "GroundCheckDelay"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 61), "CollisionCheckDelay"),
            mem.get(PacketIO.PROTO_INT, offset + 65),
            mem.get(PacketIO.PROTO_INT, offset + 69),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 73), "RaycastDistance"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 77), "RaycastHeightOffset"),
            RaycastMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 81)),
            mem.get(PacketIO.PROTO_BOOL, offset + 82)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.velocityConfig != null) nullBits |= 0x01;
        if (this.verticalClamp != null) nullBits |= 0x02;
        if (this.effects != null) nullBits |= 0x04;
        if (this.settings != null) nullBits |= 0x08;
        if (this.tags != null) nullBits |= 0x10;
        if (this.camera != null) nullBits |= 0x20;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.waitForDataFrom.getValue());
        PacketIO.requireFinite(this.horizontalSpeedMultiplier, "HorizontalSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 2, this.horizontalSpeedMultiplier);
        PacketIO.requireFinite(this.runTime, "RunTime"); mem.set(PacketIO.PROTO_FLOAT, offset + 6, this.runTime);
        mem.set(PacketIO.PROTO_INT, offset + 10, this.onItemChangeBehavior.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 14, this.next);
        mem.set(PacketIO.PROTO_INT, offset + 18, this.failed);
        if (this.velocityConfig != null) {
            this.velocityConfig.serialize(mem, offset + 22);
        } else {
            mem.asSlice(offset + 22, 21).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BYTE, offset + 43, (byte) this.changeVelocityType.getValue());
        PacketIO.requireFinite(this.duration, "Duration"); mem.set(PacketIO.PROTO_FLOAT, offset + 44, this.duration);
        if (this.verticalClamp != null) {
            this.verticalClamp.serialize(mem, offset + 48);
        } else {
            mem.asSlice(offset + 48, 8).fill((byte) 0); 
        }
        byte boolBits0_0 = 0;
        if (this.waitForGround) boolBits0_0 |= 0x01;
        if (this.waitForCollision) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 56 + 0, boolBits0_0);
        PacketIO.requireFinite(this.groundCheckDelay, "GroundCheckDelay"); mem.set(PacketIO.PROTO_FLOAT, offset + 57, this.groundCheckDelay);
        PacketIO.requireFinite(this.collisionCheckDelay, "CollisionCheckDelay"); mem.set(PacketIO.PROTO_FLOAT, offset + 61, this.collisionCheckDelay);
        mem.set(PacketIO.PROTO_INT, offset + 65, this.groundNext);
        mem.set(PacketIO.PROTO_INT, offset + 69, this.collisionNext);
        PacketIO.requireFinite(this.raycastDistance, "RaycastDistance"); mem.set(PacketIO.PROTO_FLOAT, offset + 73, this.raycastDistance);
        PacketIO.requireFinite(this.raycastHeightOffset, "RaycastHeightOffset"); mem.set(PacketIO.PROTO_FLOAT, offset + 77, this.raycastHeightOffset);
        mem.set(PacketIO.PROTO_BYTE, offset + 81, (byte) this.raycastMode.getValue());
        mem.set(PacketIO.PROTO_BOOL, offset + 82, this.useTargetBlockForDirection);
        var varOffset = offset + 107;
        if (this.effects != null) {
            mem.set(PacketIO.PROTO_INT, offset + 83, varOffset - offset - 107);
            varOffset += this.effects.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 83, -1);
        }
        if (this.settings != null) {
            mem.set(PacketIO.PROTO_INT, offset + 87, varOffset - offset - 107);
            if (this.settings.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Settings", settings.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.settings.size());
            for (var e : this.settings.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 87, -1);
        }
        mem.set(PacketIO.PROTO_INT, offset + 91, varOffset - offset - 107);
        varOffset += this.rules.serialize(mem, varOffset);
        if (this.tags != null) {
            mem.set(PacketIO.PROTO_INT, offset + 95, varOffset - offset - 107);
            if (tags.length > 4096000) throw ProtocolException.arrayTooLong("Tags", tags.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.tags.length);
            
            MemorySegment.copy(this.tags, 0, mem, PacketIO.PROTO_INT, varOffset, this.tags.length);
            varOffset += this.tags.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 95, -1);
        }
        if (this.camera != null) {
            mem.set(PacketIO.PROTO_INT, offset + 99, varOffset - offset - 107);
            varOffset += this.camera.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 99, -1);
        }
        mem.set(PacketIO.PROTO_INT, offset + 103, varOffset - offset - 107);
        if (forces.length > 4096000) throw ProtocolException.arrayTooLong("Forces", forces.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.forces.length);
        
        var forcesValueOffset = 0;
        for (var i = 0; i < this.forces.length; i++) {
            forcesValueOffset += this.forces[i].serialize(mem, varOffset + forcesValueOffset);
        }
        varOffset += forcesValueOffset;
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 107;
        if (effects != null) size += effects.computeSize();
    if (settings != null) size += VarInt.size(settings.size()) + settings.size() * (1 + 1);
    size += rules.computeSize();
    if (tags != null) size += VarInt.size(tags.length) + tags.length * 4;
    if (camera != null) size += camera.computeSize();
    size += VarInt.size(forces.length) + forces.length * 17;

        return size;
    }

    public ApplyForceInteraction clone() {
        ApplyForceInteraction copy = new ApplyForceInteraction();
        copy.waitForDataFrom = this.waitForDataFrom;
        copy.effects = this.effects != null ? this.effects.clone() : null;
        copy.horizontalSpeedMultiplier = this.horizontalSpeedMultiplier;
        copy.runTime = this.runTime;
        copy.onItemChangeBehavior = this.onItemChangeBehavior;
        if (this.settings != null) {
            java.util.Map<GameMode, InteractionSettings> m = new java.util.HashMap<>();
            for (var e : this.settings.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.settings = m;
        }
        copy.rules = this.rules.clone();
        copy.tags = this.tags != null ? java.util.Arrays.copyOf(this.tags, this.tags.length) : null;
        copy.camera = this.camera != null ? this.camera.clone() : null;
        copy.next = this.next;
        copy.failed = this.failed;
        copy.velocityConfig = this.velocityConfig != null ? this.velocityConfig.clone() : null;
        copy.changeVelocityType = this.changeVelocityType;
        copy.forces = java.util.Arrays.stream(this.forces).map(e -> e.clone()).toArray(AppliedForce[]::new);
        copy.duration = this.duration;
        copy.verticalClamp = this.verticalClamp != null ? this.verticalClamp.clone() : null;
        copy.waitForGround = this.waitForGround;
        copy.waitForCollision = this.waitForCollision;
        copy.groundCheckDelay = this.groundCheckDelay;
        copy.collisionCheckDelay = this.collisionCheckDelay;
        copy.groundNext = this.groundNext;
        copy.collisionNext = this.collisionNext;
        copy.raycastDistance = this.raycastDistance;
        copy.raycastHeightOffset = this.raycastHeightOffset;
        copy.raycastMode = this.raycastMode;
        copy.useTargetBlockForDirection = this.useTargetBlockForDirection;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ApplyForceInteraction other)) return false;
        return java.util.Objects.equals(this.waitForDataFrom, other.waitForDataFrom) && java.util.Objects.equals(this.effects, other.effects) && this.horizontalSpeedMultiplier == other.horizontalSpeedMultiplier && this.runTime == other.runTime && java.util.Objects.equals(this.onItemChangeBehavior, other.onItemChangeBehavior) && java.util.Objects.equals(this.settings, other.settings) && java.util.Objects.equals(this.rules, other.rules) && java.util.Arrays.equals(this.tags, other.tags) && java.util.Objects.equals(this.camera, other.camera) && this.next == other.next && this.failed == other.failed && java.util.Objects.equals(this.velocityConfig, other.velocityConfig) && java.util.Objects.equals(this.changeVelocityType, other.changeVelocityType) && java.util.Arrays.equals(this.forces, other.forces) && this.duration == other.duration && java.util.Objects.equals(this.verticalClamp, other.verticalClamp) && this.waitForGround == other.waitForGround && this.waitForCollision == other.waitForCollision && this.groundCheckDelay == other.groundCheckDelay && this.collisionCheckDelay == other.collisionCheckDelay && this.groundNext == other.groundNext && this.collisionNext == other.collisionNext && this.raycastDistance == other.raycastDistance && this.raycastHeightOffset == other.raycastHeightOffset && java.util.Objects.equals(this.raycastMode, other.raycastMode) && this.useTargetBlockForDirection == other.useTargetBlockForDirection;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(waitForDataFrom);
        result = 31 * result + java.util.Objects.hashCode(effects);
        result = 31 * result + Float.hashCode(horizontalSpeedMultiplier);
        result = 31 * result + Float.hashCode(runTime);
        result = 31 * result + java.util.Objects.hashCode(onItemChangeBehavior);
        result = 31 * result + java.util.Objects.hashCode(settings);
        result = 31 * result + java.util.Objects.hashCode(rules);
        result = 31 * result + java.util.Arrays.hashCode(tags);
        result = 31 * result + java.util.Objects.hashCode(camera);
        result = 31 * result + Integer.hashCode(next);
        result = 31 * result + Integer.hashCode(failed);
        result = 31 * result + java.util.Objects.hashCode(velocityConfig);
        result = 31 * result + java.util.Objects.hashCode(changeVelocityType);
        result = 31 * result + java.util.Arrays.hashCode(forces);
        result = 31 * result + Float.hashCode(duration);
        result = 31 * result + java.util.Objects.hashCode(verticalClamp);
        result = 31 * result + Boolean.hashCode(waitForGround);
        result = 31 * result + Boolean.hashCode(waitForCollision);
        result = 31 * result + Float.hashCode(groundCheckDelay);
        result = 31 * result + Float.hashCode(collisionCheckDelay);
        result = 31 * result + Integer.hashCode(groundNext);
        result = 31 * result + Integer.hashCode(collisionNext);
        result = 31 * result + Float.hashCode(raycastDistance);
        result = 31 * result + Float.hashCode(raycastHeightOffset);
        result = 31 * result + java.util.Objects.hashCode(raycastMode);
        result = 31 * result + Boolean.hashCode(useTargetBlockForDirection);
        return result;
    }

}