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


public class MovementStates {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 4;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 4;
    public static final int MAX_SIZE = 4;

    public boolean idle;
    public boolean horizontalIdle;
    public boolean jumping;
    public boolean flying;
    public boolean walking;
    public boolean running;
    public boolean sprinting;
    public boolean crouching;
    public boolean forcedCrouching;
    public boolean falling;
    public boolean fallingFar;
    public boolean climbing;
    public boolean inFluid;
    public boolean swimming;
    public boolean swimJumping;
    public boolean onGround;
    public boolean mantling;
    public boolean sliding;
    public boolean mounting;
    public boolean rolling;
    public boolean sitting;
    public boolean gliding;
    public boolean sleeping;
    public byte extraJumpsUsed;

    public MovementStates() {
    }

    public MovementStates(boolean idle, boolean horizontalIdle, boolean jumping, boolean flying, boolean walking, boolean running, boolean sprinting, boolean crouching, boolean forcedCrouching, boolean falling, boolean fallingFar, boolean climbing, boolean inFluid, boolean swimming, boolean swimJumping, boolean onGround, boolean mantling, boolean sliding, boolean mounting, boolean rolling, boolean sitting, boolean gliding, boolean sleeping, byte extraJumpsUsed) {
        this.idle = idle;
        this.horizontalIdle = horizontalIdle;
        this.jumping = jumping;
        this.flying = flying;
        this.walking = walking;
        this.running = running;
        this.sprinting = sprinting;
        this.crouching = crouching;
        this.forcedCrouching = forcedCrouching;
        this.falling = falling;
        this.fallingFar = fallingFar;
        this.climbing = climbing;
        this.inFluid = inFluid;
        this.swimming = swimming;
        this.swimJumping = swimJumping;
        this.onGround = onGround;
        this.mantling = mantling;
        this.sliding = sliding;
        this.mounting = mounting;
        this.rolling = rolling;
        this.sitting = sitting;
        this.gliding = gliding;
        this.sleeping = sleeping;
        this.extraJumpsUsed = extraJumpsUsed;
    }

    public MovementStates(@Nonnull MovementStates other) {
        this.idle = other.idle;
        this.horizontalIdle = other.horizontalIdle;
        this.jumping = other.jumping;
        this.flying = other.flying;
        this.walking = other.walking;
        this.running = other.running;
        this.sprinting = other.sprinting;
        this.crouching = other.crouching;
        this.forcedCrouching = other.forcedCrouching;
        this.falling = other.falling;
        this.fallingFar = other.fallingFar;
        this.climbing = other.climbing;
        this.inFluid = other.inFluid;
        this.swimming = other.swimming;
        this.swimJumping = other.swimJumping;
        this.onGround = other.onGround;
        this.mantling = other.mantling;
        this.sliding = other.sliding;
        this.mounting = other.mounting;
        this.rolling = other.rolling;
        this.sitting = other.sitting;
        this.gliding = other.gliding;
        this.sleeping = other.sleeping;
        this.extraJumpsUsed = other.extraJumpsUsed;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("MovementStates", offset, (int) mem.byteSize());
        long needed = (long) offset + 4;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("MovementStates", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getIdle(MemorySegment mem) {
        return getIdle(mem, 0);
    }
    
    public static boolean getIdle(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x01) != 0;
    }
    
    public static boolean getHorizontalIdle(MemorySegment mem) {
        return getHorizontalIdle(mem, 0);
    }
    
    public static boolean getHorizontalIdle(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x02) != 0;
    }
    
    public static boolean getJumping(MemorySegment mem) {
        return getJumping(mem, 0);
    }
    
    public static boolean getJumping(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x04) != 0;
    }
    
    public static boolean getFlying(MemorySegment mem) {
        return getFlying(mem, 0);
    }
    
    public static boolean getFlying(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x08) != 0;
    }
    
    public static boolean getWalking(MemorySegment mem) {
        return getWalking(mem, 0);
    }
    
    public static boolean getWalking(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x10) != 0;
    }
    
    public static boolean getRunning(MemorySegment mem) {
        return getRunning(mem, 0);
    }
    
    public static boolean getRunning(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x20) != 0;
    }
    
    public static boolean getSprinting(MemorySegment mem) {
        return getSprinting(mem, 0);
    }
    
    public static boolean getSprinting(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x40) != 0;
    }
    
    public static boolean getCrouching(MemorySegment mem) {
        return getCrouching(mem, 0);
    }
    
    public static boolean getCrouching(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x80) != 0;
    }
    
    public static boolean getForcedCrouching(MemorySegment mem) {
        return getForcedCrouching(mem, 0);
    }
    
    public static boolean getForcedCrouching(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x01) != 0;
    }
    
    public static boolean getFalling(MemorySegment mem) {
        return getFalling(mem, 0);
    }
    
    public static boolean getFalling(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x02) != 0;
    }
    
    public static boolean getFallingFar(MemorySegment mem) {
        return getFallingFar(mem, 0);
    }
    
    public static boolean getFallingFar(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x04) != 0;
    }
    
    public static boolean getClimbing(MemorySegment mem) {
        return getClimbing(mem, 0);
    }
    
    public static boolean getClimbing(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x08) != 0;
    }
    
    public static boolean getInFluid(MemorySegment mem) {
        return getInFluid(mem, 0);
    }
    
    public static boolean getInFluid(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x10) != 0;
    }
    
    public static boolean getSwimming(MemorySegment mem) {
        return getSwimming(mem, 0);
    }
    
    public static boolean getSwimming(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x20) != 0;
    }
    
    public static boolean getSwimJumping(MemorySegment mem) {
        return getSwimJumping(mem, 0);
    }
    
    public static boolean getSwimJumping(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x40) != 0;
    }
    
    public static boolean getOnGround(MemorySegment mem) {
        return getOnGround(mem, 0);
    }
    
    public static boolean getOnGround(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x80) != 0;
    }
    
    public static boolean getMantling(MemorySegment mem) {
        return getMantling(mem, 0);
    }
    
    public static boolean getMantling(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 2) & 0x01) != 0;
    }
    
    public static boolean getSliding(MemorySegment mem) {
        return getSliding(mem, 0);
    }
    
    public static boolean getSliding(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 2) & 0x02) != 0;
    }
    
    public static boolean getMounting(MemorySegment mem) {
        return getMounting(mem, 0);
    }
    
    public static boolean getMounting(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 2) & 0x04) != 0;
    }
    
    public static boolean getRolling(MemorySegment mem) {
        return getRolling(mem, 0);
    }
    
    public static boolean getRolling(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 2) & 0x08) != 0;
    }
    
    public static boolean getSitting(MemorySegment mem) {
        return getSitting(mem, 0);
    }
    
    public static boolean getSitting(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 2) & 0x10) != 0;
    }
    
    public static boolean getGliding(MemorySegment mem) {
        return getGliding(mem, 0);
    }
    
    public static boolean getGliding(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 2) & 0x20) != 0;
    }
    
    public static boolean getSleeping(MemorySegment mem) {
        return getSleeping(mem, 0);
    }
    
    public static boolean getSleeping(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 2) & 0x40) != 0;
    }
    
    public static byte getExtraJumpsUsed(MemorySegment mem) {
        return getExtraJumpsUsed(mem, 0);
    }
    
    public static byte getExtraJumpsUsed(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 3);
    }
    
    
    
    
    
    public static MovementStates toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static MovementStates toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one MovementStates and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static MovementStates toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new MovementStates(
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x04) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x08) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x10) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x20) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x40) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x80) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x04) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x08) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x10) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x20) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x40) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x80) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 2) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 2) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 2) & 0x04) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 2) & 0x08) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 2) & 0x10) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 2) & 0x20) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 2) & 0x40) != 0,
            mem.get(PacketIO.PROTO_BYTE, offset + 3)
        );
        if (cursor != null) cursor.position = offset + 4;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        byte boolBits0_0 = 0;
        if (this.idle) boolBits0_0 |= 0x01;
        if (this.horizontalIdle) boolBits0_0 |= 0x02;
        if (this.jumping) boolBits0_0 |= 0x04;
        if (this.flying) boolBits0_0 |= 0x08;
        if (this.walking) boolBits0_0 |= 0x10;
        if (this.running) boolBits0_0 |= 0x20;
        if (this.sprinting) boolBits0_0 |= 0x40;
        if (this.crouching) boolBits0_0 |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0 + 0, boolBits0_0);
        byte boolBits0_1 = 0;
        if (this.forcedCrouching) boolBits0_1 |= 0x01;
        if (this.falling) boolBits0_1 |= 0x02;
        if (this.fallingFar) boolBits0_1 |= 0x04;
        if (this.climbing) boolBits0_1 |= 0x08;
        if (this.inFluid) boolBits0_1 |= 0x10;
        if (this.swimming) boolBits0_1 |= 0x20;
        if (this.swimJumping) boolBits0_1 |= 0x40;
        if (this.onGround) boolBits0_1 |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0 + 1, boolBits0_1);
        byte boolBits0_2 = 0;
        if (this.mantling) boolBits0_2 |= 0x01;
        if (this.sliding) boolBits0_2 |= 0x02;
        if (this.mounting) boolBits0_2 |= 0x04;
        if (this.rolling) boolBits0_2 |= 0x08;
        if (this.sitting) boolBits0_2 |= 0x10;
        if (this.gliding) boolBits0_2 |= 0x20;
        if (this.sleeping) boolBits0_2 |= 0x40;
        mem.set(PacketIO.PROTO_BYTE, offset + 0 + 2, boolBits0_2);
        mem.set(PacketIO.PROTO_BYTE, offset + 3, this.extraJumpsUsed);
        
        
    
       return 4;
    }
    public int computeSize() {
        return 4;
    }

    public MovementStates clone() {
        MovementStates copy = new MovementStates();
        copy.idle = this.idle;
        copy.horizontalIdle = this.horizontalIdle;
        copy.jumping = this.jumping;
        copy.flying = this.flying;
        copy.walking = this.walking;
        copy.running = this.running;
        copy.sprinting = this.sprinting;
        copy.crouching = this.crouching;
        copy.forcedCrouching = this.forcedCrouching;
        copy.falling = this.falling;
        copy.fallingFar = this.fallingFar;
        copy.climbing = this.climbing;
        copy.inFluid = this.inFluid;
        copy.swimming = this.swimming;
        copy.swimJumping = this.swimJumping;
        copy.onGround = this.onGround;
        copy.mantling = this.mantling;
        copy.sliding = this.sliding;
        copy.mounting = this.mounting;
        copy.rolling = this.rolling;
        copy.sitting = this.sitting;
        copy.gliding = this.gliding;
        copy.sleeping = this.sleeping;
        copy.extraJumpsUsed = this.extraJumpsUsed;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MovementStates other)) return false;
        return this.idle == other.idle && this.horizontalIdle == other.horizontalIdle && this.jumping == other.jumping && this.flying == other.flying && this.walking == other.walking && this.running == other.running && this.sprinting == other.sprinting && this.crouching == other.crouching && this.forcedCrouching == other.forcedCrouching && this.falling == other.falling && this.fallingFar == other.fallingFar && this.climbing == other.climbing && this.inFluid == other.inFluid && this.swimming == other.swimming && this.swimJumping == other.swimJumping && this.onGround == other.onGround && this.mantling == other.mantling && this.sliding == other.sliding && this.mounting == other.mounting && this.rolling == other.rolling && this.sitting == other.sitting && this.gliding == other.gliding && this.sleeping == other.sleeping && this.extraJumpsUsed == other.extraJumpsUsed;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(idle, horizontalIdle, jumping, flying, walking, running, sprinting, crouching, forcedCrouching, falling, fallingFar, climbing, inFluid, swimming, swimJumping, onGround, mantling, sliding, mounting, rolling, sitting, gliding, sleeping, extraJumpsUsed);
    }

}