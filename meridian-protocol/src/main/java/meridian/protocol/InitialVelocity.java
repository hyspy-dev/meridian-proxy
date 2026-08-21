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


public class InitialVelocity {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 25;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 25;
    public static final int MAX_SIZE = 25;

    @Nullable public Rangef yaw;
    @Nullable public Rangef pitch;
    @Nullable public Rangef speed;

    public InitialVelocity() {
    }

    public InitialVelocity(@Nullable Rangef yaw, @Nullable Rangef pitch, @Nullable Rangef speed) {
        this.yaw = yaw;
        this.pitch = pitch;
        this.speed = speed;
    }

    public InitialVelocity(@Nonnull InitialVelocity other) {
        this.yaw = other.yaw;
        this.pitch = other.pitch;
        this.speed = other.speed;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("InitialVelocity", offset, (int) mem.byteSize());
        long needed = (long) offset + 25;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InitialVelocity", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static Rangef getYaw(MemorySegment mem) {
        return getYaw(mem, 0);
    }
    
    @Nullable
    public static Rangef getYaw(MemorySegment mem, int offset) {
        return hasYaw(mem, offset) ? Rangef.toObject(mem, offset + 1): null;
    }
    
    @Nullable
    public static Rangef getPitch(MemorySegment mem) {
        return getPitch(mem, 0);
    }
    
    @Nullable
    public static Rangef getPitch(MemorySegment mem, int offset) {
        return hasPitch(mem, offset) ? Rangef.toObject(mem, offset + 9): null;
    }
    
    @Nullable
    public static Rangef getSpeed(MemorySegment mem) {
        return getSpeed(mem, 0);
    }
    
    @Nullable
    public static Rangef getSpeed(MemorySegment mem, int offset) {
        return hasSpeed(mem, offset) ? Rangef.toObject(mem, offset + 17): null;
    }
    
    public static boolean hasYaw(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasPitch(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasSpeed(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    
    
    public static InitialVelocity toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static InitialVelocity toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one InitialVelocity and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static InitialVelocity toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new InitialVelocity(
            hasYaw(mem, offset) ? Rangef.toObject(mem, offset + 1) : null,
            hasPitch(mem, offset) ? Rangef.toObject(mem, offset + 9) : null,
            hasSpeed(mem, offset) ? Rangef.toObject(mem, offset + 17) : null
        );
        if (cursor != null) cursor.position = offset + 25;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.yaw != null) nullBits |= 0x01;
        if (this.pitch != null) nullBits |= 0x02;
        if (this.speed != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.yaw != null) {
            this.yaw.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 8).fill((byte) 0); 
        }
        if (this.pitch != null) {
            this.pitch.serialize(mem, offset + 9);
        } else {
            mem.asSlice(offset + 9, 8).fill((byte) 0); 
        }
        if (this.speed != null) {
            this.speed.serialize(mem, offset + 17);
        } else {
            mem.asSlice(offset + 17, 8).fill((byte) 0); 
        }
        
        
    
       return 25;
    }
    public int computeSize() {
        return 25;
    }

    public InitialVelocity clone() {
        InitialVelocity copy = new InitialVelocity();
        copy.yaw = this.yaw != null ? this.yaw.clone() : null;
        copy.pitch = this.pitch != null ? this.pitch.clone() : null;
        copy.speed = this.speed != null ? this.speed.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InitialVelocity other)) return false;
        return java.util.Objects.equals(this.yaw, other.yaw) && java.util.Objects.equals(this.pitch, other.pitch) && java.util.Objects.equals(this.speed, other.speed);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(yaw, pitch, speed);
    }

}