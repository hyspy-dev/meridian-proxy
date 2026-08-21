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


public class PhysicsConfig {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 120;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 120;
    public static final int MAX_SIZE = 120;

    @Nonnull public PhysicsType type = PhysicsType.Standard;
    public double density;
    public double gravity;
    public double bounciness;
    public int bounceCount;
    public double bounceLimit;
    public boolean sticksVertically;
    public boolean computeYaw;
    public boolean computePitch;
    @Nonnull public RotationMode rotationMode = RotationMode.None;
    public double moveOutOfSolidSpeed;
    public double terminalVelocityAir;
    public double densityAir;
    public double terminalVelocityWater;
    public double densityWater;
    public double hitWaterImpulseLoss;
    public double rotationForce;
    public float speedRotationFactor;
    public double swimmingDampingFactor;
    public boolean allowRolling;
    public double rollingFrictionFactor;
    public float rollingSpeed;

    public PhysicsConfig() {
    }

    public PhysicsConfig(@Nonnull PhysicsType type, double density, double gravity, double bounciness, int bounceCount, double bounceLimit, boolean sticksVertically, boolean computeYaw, boolean computePitch, @Nonnull RotationMode rotationMode, double moveOutOfSolidSpeed, double terminalVelocityAir, double densityAir, double terminalVelocityWater, double densityWater, double hitWaterImpulseLoss, double rotationForce, float speedRotationFactor, double swimmingDampingFactor, boolean allowRolling, double rollingFrictionFactor, float rollingSpeed) {
        this.type = type;
        this.density = density;
        this.gravity = gravity;
        this.bounciness = bounciness;
        this.bounceCount = bounceCount;
        this.bounceLimit = bounceLimit;
        this.sticksVertically = sticksVertically;
        this.computeYaw = computeYaw;
        this.computePitch = computePitch;
        this.rotationMode = rotationMode;
        this.moveOutOfSolidSpeed = moveOutOfSolidSpeed;
        this.terminalVelocityAir = terminalVelocityAir;
        this.densityAir = densityAir;
        this.terminalVelocityWater = terminalVelocityWater;
        this.densityWater = densityWater;
        this.hitWaterImpulseLoss = hitWaterImpulseLoss;
        this.rotationForce = rotationForce;
        this.speedRotationFactor = speedRotationFactor;
        this.swimmingDampingFactor = swimmingDampingFactor;
        this.allowRolling = allowRolling;
        this.rollingFrictionFactor = rollingFrictionFactor;
        this.rollingSpeed = rollingSpeed;
    }

    public PhysicsConfig(@Nonnull PhysicsConfig other) {
        this.type = other.type;
        this.density = other.density;
        this.gravity = other.gravity;
        this.bounciness = other.bounciness;
        this.bounceCount = other.bounceCount;
        this.bounceLimit = other.bounceLimit;
        this.sticksVertically = other.sticksVertically;
        this.computeYaw = other.computeYaw;
        this.computePitch = other.computePitch;
        this.rotationMode = other.rotationMode;
        this.moveOutOfSolidSpeed = other.moveOutOfSolidSpeed;
        this.terminalVelocityAir = other.terminalVelocityAir;
        this.densityAir = other.densityAir;
        this.terminalVelocityWater = other.terminalVelocityWater;
        this.densityWater = other.densityWater;
        this.hitWaterImpulseLoss = other.hitWaterImpulseLoss;
        this.rotationForce = other.rotationForce;
        this.speedRotationFactor = other.speedRotationFactor;
        this.swimmingDampingFactor = other.swimmingDampingFactor;
        this.allowRolling = other.allowRolling;
        this.rollingFrictionFactor = other.rollingFrictionFactor;
        this.rollingSpeed = other.rollingSpeed;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PhysicsConfig", offset, (int) mem.byteSize());
        long needed = (long) offset + 120;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PhysicsConfig", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static PhysicsType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static PhysicsType getType(MemorySegment mem, int offset) {
        return PhysicsType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0));
    }
    
    public static double getDensity(MemorySegment mem) {
        return getDensity(mem, 0);
    }
    
    public static double getDensity(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 1), "Density");
    }
    
    public static double getGravity(MemorySegment mem) {
        return getGravity(mem, 0);
    }
    
    public static double getGravity(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 9), "Gravity");
    }
    
    public static double getBounciness(MemorySegment mem) {
        return getBounciness(mem, 0);
    }
    
    public static double getBounciness(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 17), "Bounciness");
    }
    
    public static int getBounceCount(MemorySegment mem) {
        return getBounceCount(mem, 0);
    }
    
    public static int getBounceCount(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 25);
    }
    
    public static double getBounceLimit(MemorySegment mem) {
        return getBounceLimit(mem, 0);
    }
    
    public static double getBounceLimit(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 29), "BounceLimit");
    }
    
    public static boolean getSticksVertically(MemorySegment mem) {
        return getSticksVertically(mem, 0);
    }
    
    public static boolean getSticksVertically(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 37) & 0x01) != 0;
    }
    
    public static boolean getComputeYaw(MemorySegment mem) {
        return getComputeYaw(mem, 0);
    }
    
    public static boolean getComputeYaw(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 37) & 0x02) != 0;
    }
    
    public static boolean getComputePitch(MemorySegment mem) {
        return getComputePitch(mem, 0);
    }
    
    public static boolean getComputePitch(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 37) & 0x04) != 0;
    }
    
    public static RotationMode getRotationMode(MemorySegment mem) {
        return getRotationMode(mem, 0);
    }
    
    public static RotationMode getRotationMode(MemorySegment mem, int offset) {
        return RotationMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 38));
    }
    
    public static double getMoveOutOfSolidSpeed(MemorySegment mem) {
        return getMoveOutOfSolidSpeed(mem, 0);
    }
    
    public static double getMoveOutOfSolidSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 39), "MoveOutOfSolidSpeed");
    }
    
    public static double getTerminalVelocityAir(MemorySegment mem) {
        return getTerminalVelocityAir(mem, 0);
    }
    
    public static double getTerminalVelocityAir(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 47), "TerminalVelocityAir");
    }
    
    public static double getDensityAir(MemorySegment mem) {
        return getDensityAir(mem, 0);
    }
    
    public static double getDensityAir(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 55), "DensityAir");
    }
    
    public static double getTerminalVelocityWater(MemorySegment mem) {
        return getTerminalVelocityWater(mem, 0);
    }
    
    public static double getTerminalVelocityWater(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 63), "TerminalVelocityWater");
    }
    
    public static double getDensityWater(MemorySegment mem) {
        return getDensityWater(mem, 0);
    }
    
    public static double getDensityWater(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 71), "DensityWater");
    }
    
    public static double getHitWaterImpulseLoss(MemorySegment mem) {
        return getHitWaterImpulseLoss(mem, 0);
    }
    
    public static double getHitWaterImpulseLoss(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 79), "HitWaterImpulseLoss");
    }
    
    public static double getRotationForce(MemorySegment mem) {
        return getRotationForce(mem, 0);
    }
    
    public static double getRotationForce(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 87), "RotationForce");
    }
    
    public static float getSpeedRotationFactor(MemorySegment mem) {
        return getSpeedRotationFactor(mem, 0);
    }
    
    public static float getSpeedRotationFactor(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 95), "SpeedRotationFactor");
    }
    
    public static double getSwimmingDampingFactor(MemorySegment mem) {
        return getSwimmingDampingFactor(mem, 0);
    }
    
    public static double getSwimmingDampingFactor(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 99), "SwimmingDampingFactor");
    }
    
    public static boolean getAllowRolling(MemorySegment mem) {
        return getAllowRolling(mem, 0);
    }
    
    public static boolean getAllowRolling(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 107);
    }
    
    public static double getRollingFrictionFactor(MemorySegment mem) {
        return getRollingFrictionFactor(mem, 0);
    }
    
    public static double getRollingFrictionFactor(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 108), "RollingFrictionFactor");
    }
    
    public static float getRollingSpeed(MemorySegment mem) {
        return getRollingSpeed(mem, 0);
    }
    
    public static float getRollingSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 116), "RollingSpeed");
    }
    
    
    
    
    
    public static PhysicsConfig toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PhysicsConfig toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PhysicsConfig and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PhysicsConfig toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new PhysicsConfig(
            PhysicsType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0)),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 1), "Density"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 9), "Gravity"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 17), "Bounciness"),
            mem.get(PacketIO.PROTO_INT, offset + 25),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 29), "BounceLimit"),
            (mem.get(PacketIO.PROTO_BYTE, offset + 37) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 37) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 37) & 0x04) != 0,
            RotationMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 38)),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 39), "MoveOutOfSolidSpeed"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 47), "TerminalVelocityAir"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 55), "DensityAir"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 63), "TerminalVelocityWater"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 71), "DensityWater"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 79), "HitWaterImpulseLoss"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 87), "RotationForce"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 95), "SpeedRotationFactor"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 99), "SwimmingDampingFactor"),
            mem.get(PacketIO.PROTO_BOOL, offset + 107),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 108), "RollingFrictionFactor"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 116), "RollingSpeed")
        );
        if (cursor != null) cursor.position = offset + 120;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, (byte) this.type.getValue());
        PacketIO.requireFinite(this.density, "Density"); mem.set(PacketIO.PROTO_DOUBLE, offset + 1, this.density);
        PacketIO.requireFinite(this.gravity, "Gravity"); mem.set(PacketIO.PROTO_DOUBLE, offset + 9, this.gravity);
        PacketIO.requireFinite(this.bounciness, "Bounciness"); mem.set(PacketIO.PROTO_DOUBLE, offset + 17, this.bounciness);
        mem.set(PacketIO.PROTO_INT, offset + 25, this.bounceCount);
        PacketIO.requireFinite(this.bounceLimit, "BounceLimit"); mem.set(PacketIO.PROTO_DOUBLE, offset + 29, this.bounceLimit);
        byte boolBits0_0 = 0;
        if (this.sticksVertically) boolBits0_0 |= 0x01;
        if (this.computeYaw) boolBits0_0 |= 0x02;
        if (this.computePitch) boolBits0_0 |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 37 + 0, boolBits0_0);
        mem.set(PacketIO.PROTO_BYTE, offset + 38, (byte) this.rotationMode.getValue());
        PacketIO.requireFinite(this.moveOutOfSolidSpeed, "MoveOutOfSolidSpeed"); mem.set(PacketIO.PROTO_DOUBLE, offset + 39, this.moveOutOfSolidSpeed);
        PacketIO.requireFinite(this.terminalVelocityAir, "TerminalVelocityAir"); mem.set(PacketIO.PROTO_DOUBLE, offset + 47, this.terminalVelocityAir);
        PacketIO.requireFinite(this.densityAir, "DensityAir"); mem.set(PacketIO.PROTO_DOUBLE, offset + 55, this.densityAir);
        PacketIO.requireFinite(this.terminalVelocityWater, "TerminalVelocityWater"); mem.set(PacketIO.PROTO_DOUBLE, offset + 63, this.terminalVelocityWater);
        PacketIO.requireFinite(this.densityWater, "DensityWater"); mem.set(PacketIO.PROTO_DOUBLE, offset + 71, this.densityWater);
        PacketIO.requireFinite(this.hitWaterImpulseLoss, "HitWaterImpulseLoss"); mem.set(PacketIO.PROTO_DOUBLE, offset + 79, this.hitWaterImpulseLoss);
        PacketIO.requireFinite(this.rotationForce, "RotationForce"); mem.set(PacketIO.PROTO_DOUBLE, offset + 87, this.rotationForce);
        PacketIO.requireFinite(this.speedRotationFactor, "SpeedRotationFactor"); mem.set(PacketIO.PROTO_FLOAT, offset + 95, this.speedRotationFactor);
        PacketIO.requireFinite(this.swimmingDampingFactor, "SwimmingDampingFactor"); mem.set(PacketIO.PROTO_DOUBLE, offset + 99, this.swimmingDampingFactor);
        mem.set(PacketIO.PROTO_BOOL, offset + 107, this.allowRolling);
        PacketIO.requireFinite(this.rollingFrictionFactor, "RollingFrictionFactor"); mem.set(PacketIO.PROTO_DOUBLE, offset + 108, this.rollingFrictionFactor);
        PacketIO.requireFinite(this.rollingSpeed, "RollingSpeed"); mem.set(PacketIO.PROTO_FLOAT, offset + 116, this.rollingSpeed);
        
        
    
       return 120;
    }
    public int computeSize() {
        return 120;
    }

    public PhysicsConfig clone() {
        PhysicsConfig copy = new PhysicsConfig();
        copy.type = this.type;
        copy.density = this.density;
        copy.gravity = this.gravity;
        copy.bounciness = this.bounciness;
        copy.bounceCount = this.bounceCount;
        copy.bounceLimit = this.bounceLimit;
        copy.sticksVertically = this.sticksVertically;
        copy.computeYaw = this.computeYaw;
        copy.computePitch = this.computePitch;
        copy.rotationMode = this.rotationMode;
        copy.moveOutOfSolidSpeed = this.moveOutOfSolidSpeed;
        copy.terminalVelocityAir = this.terminalVelocityAir;
        copy.densityAir = this.densityAir;
        copy.terminalVelocityWater = this.terminalVelocityWater;
        copy.densityWater = this.densityWater;
        copy.hitWaterImpulseLoss = this.hitWaterImpulseLoss;
        copy.rotationForce = this.rotationForce;
        copy.speedRotationFactor = this.speedRotationFactor;
        copy.swimmingDampingFactor = this.swimmingDampingFactor;
        copy.allowRolling = this.allowRolling;
        copy.rollingFrictionFactor = this.rollingFrictionFactor;
        copy.rollingSpeed = this.rollingSpeed;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PhysicsConfig other)) return false;
        return java.util.Objects.equals(this.type, other.type) && this.density == other.density && this.gravity == other.gravity && this.bounciness == other.bounciness && this.bounceCount == other.bounceCount && this.bounceLimit == other.bounceLimit && this.sticksVertically == other.sticksVertically && this.computeYaw == other.computeYaw && this.computePitch == other.computePitch && java.util.Objects.equals(this.rotationMode, other.rotationMode) && this.moveOutOfSolidSpeed == other.moveOutOfSolidSpeed && this.terminalVelocityAir == other.terminalVelocityAir && this.densityAir == other.densityAir && this.terminalVelocityWater == other.terminalVelocityWater && this.densityWater == other.densityWater && this.hitWaterImpulseLoss == other.hitWaterImpulseLoss && this.rotationForce == other.rotationForce && this.speedRotationFactor == other.speedRotationFactor && this.swimmingDampingFactor == other.swimmingDampingFactor && this.allowRolling == other.allowRolling && this.rollingFrictionFactor == other.rollingFrictionFactor && this.rollingSpeed == other.rollingSpeed;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(type, density, gravity, bounciness, bounceCount, bounceLimit, sticksVertically, computeYaw, computePitch, rotationMode, moveOutOfSolidSpeed, terminalVelocityAir, densityAir, terminalVelocityWater, densityWater, hitWaterImpulseLoss, rotationForce, speedRotationFactor, swimmingDampingFactor, allowRolling, rollingFrictionFactor, rollingSpeed);
    }

}