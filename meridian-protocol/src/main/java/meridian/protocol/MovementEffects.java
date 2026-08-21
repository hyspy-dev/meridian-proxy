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


public class MovementEffects {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 5;
    public static final int MAX_SIZE = 5;

    public boolean disableForward;
    public boolean disableBackward;
    public boolean disableLeft;
    public boolean disableRight;
    public boolean disableSprint;
    public boolean disableJump;
    public boolean disableCrouch;
    public float speedMultiplier = 1f;

    public MovementEffects() {
    }

    public MovementEffects(boolean disableForward, boolean disableBackward, boolean disableLeft, boolean disableRight, boolean disableSprint, boolean disableJump, boolean disableCrouch, float speedMultiplier) {
        this.disableForward = disableForward;
        this.disableBackward = disableBackward;
        this.disableLeft = disableLeft;
        this.disableRight = disableRight;
        this.disableSprint = disableSprint;
        this.disableJump = disableJump;
        this.disableCrouch = disableCrouch;
        this.speedMultiplier = speedMultiplier;
    }

    public MovementEffects(@Nonnull MovementEffects other) {
        this.disableForward = other.disableForward;
        this.disableBackward = other.disableBackward;
        this.disableLeft = other.disableLeft;
        this.disableRight = other.disableRight;
        this.disableSprint = other.disableSprint;
        this.disableJump = other.disableJump;
        this.disableCrouch = other.disableCrouch;
        this.speedMultiplier = other.speedMultiplier;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("MovementEffects", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("MovementEffects", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getDisableForward(MemorySegment mem) {
        return getDisableForward(mem, 0);
    }
    
    public static boolean getDisableForward(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x01) != 0;
    }
    
    public static boolean getDisableBackward(MemorySegment mem) {
        return getDisableBackward(mem, 0);
    }
    
    public static boolean getDisableBackward(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x02) != 0;
    }
    
    public static boolean getDisableLeft(MemorySegment mem) {
        return getDisableLeft(mem, 0);
    }
    
    public static boolean getDisableLeft(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x04) != 0;
    }
    
    public static boolean getDisableRight(MemorySegment mem) {
        return getDisableRight(mem, 0);
    }
    
    public static boolean getDisableRight(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x08) != 0;
    }
    
    public static boolean getDisableSprint(MemorySegment mem) {
        return getDisableSprint(mem, 0);
    }
    
    public static boolean getDisableSprint(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x10) != 0;
    }
    
    public static boolean getDisableJump(MemorySegment mem) {
        return getDisableJump(mem, 0);
    }
    
    public static boolean getDisableJump(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x20) != 0;
    }
    
    public static boolean getDisableCrouch(MemorySegment mem) {
        return getDisableCrouch(mem, 0);
    }
    
    public static boolean getDisableCrouch(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x40) != 0;
    }
    
    public static float getSpeedMultiplier(MemorySegment mem) {
        return getSpeedMultiplier(mem, 0);
    }
    
    public static float getSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "SpeedMultiplier");
    }
    
    
    
    
    
    public static MovementEffects toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static MovementEffects toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one MovementEffects and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static MovementEffects toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new MovementEffects(
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x04) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x08) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x10) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x20) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x40) != 0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "SpeedMultiplier")
        );
        if (cursor != null) cursor.position = offset + 5;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        byte boolBits0_0 = 0;
        if (this.disableForward) boolBits0_0 |= 0x01;
        if (this.disableBackward) boolBits0_0 |= 0x02;
        if (this.disableLeft) boolBits0_0 |= 0x04;
        if (this.disableRight) boolBits0_0 |= 0x08;
        if (this.disableSprint) boolBits0_0 |= 0x10;
        if (this.disableJump) boolBits0_0 |= 0x20;
        if (this.disableCrouch) boolBits0_0 |= 0x40;
        mem.set(PacketIO.PROTO_BYTE, offset + 0 + 0, boolBits0_0);
        PacketIO.requireFinite(this.speedMultiplier, "SpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.speedMultiplier);
        
        
    
       return 5;
    }
    public int computeSize() {
        return 5;
    }

    public MovementEffects clone() {
        MovementEffects copy = new MovementEffects();
        copy.disableForward = this.disableForward;
        copy.disableBackward = this.disableBackward;
        copy.disableLeft = this.disableLeft;
        copy.disableRight = this.disableRight;
        copy.disableSprint = this.disableSprint;
        copy.disableJump = this.disableJump;
        copy.disableCrouch = this.disableCrouch;
        copy.speedMultiplier = this.speedMultiplier;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MovementEffects other)) return false;
        return this.disableForward == other.disableForward && this.disableBackward == other.disableBackward && this.disableLeft == other.disableLeft && this.disableRight == other.disableRight && this.disableSprint == other.disableSprint && this.disableJump == other.disableJump && this.disableCrouch == other.disableCrouch && this.speedMultiplier == other.speedMultiplier;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(disableForward, disableBackward, disableLeft, disableRight, disableSprint, disableJump, disableCrouch, speedMultiplier);
    }

}