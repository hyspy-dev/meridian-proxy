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

public class InteractionCamera {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 29;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 29;
    public static final int MAX_SIZE = 29;

    public float time;
    @Nonnull public Vector3fc position = PacketIO.ZERO_VECTOR3;
    @Nullable public Direction rotation;

    public InteractionCamera() {
    }

    public InteractionCamera(float time, @Nonnull Vector3fc position, @Nullable Direction rotation) {
        this.time = time;
        this.position = position;
        this.rotation = rotation;
    }

    public InteractionCamera(@Nonnull InteractionCamera other) {
        this.time = other.time;
        this.position = other.position;
        this.rotation = other.rotation;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("InteractionCamera", offset, (int) mem.byteSize());
        long needed = (long) offset + 29;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InteractionCamera", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getTime(MemorySegment mem) {
        return getTime(mem, 0);
    }
    
    public static float getTime(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Time");
    }
    
    public static Vector3fc getPosition(MemorySegment mem) {
        return getPosition(mem, 0);
    }
    
    public static Vector3fc getPosition(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 5), "Position");
    }
    
    @Nullable
    public static Direction getRotation(MemorySegment mem) {
        return getRotation(mem, 0);
    }
    
    @Nullable
    public static Direction getRotation(MemorySegment mem, int offset) {
        return hasRotation(mem, offset) ? Direction.toObject(mem, offset + 17): null;
    }
    
    public static boolean hasRotation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static InteractionCamera toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static InteractionCamera toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one InteractionCamera and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static InteractionCamera toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new InteractionCamera(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Time"),
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 5), "Position"),
            hasRotation(mem, offset) ? Direction.toObject(mem, offset + 17) : null
        );
        if (cursor != null) cursor.position = offset + 29;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.rotation != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.time, "Time"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.time);
        PacketIO.requireFinite(this.position, "Position"); PacketIO.writeVector3f(mem, offset + 5, this.position);
        if (this.rotation != null) {
            this.rotation.serialize(mem, offset + 17);
        } else {
            mem.asSlice(offset + 17, 12).fill((byte) 0); 
        }
        
        
    
       return 29;
    }
    public int computeSize() {
        return 29;
    }

    public InteractionCamera clone() {
        InteractionCamera copy = new InteractionCamera();
        copy.time = this.time;
        copy.position = this.position;
        copy.rotation = this.rotation != null ? this.rotation.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InteractionCamera other)) return false;
        return this.time == other.time && java.util.Objects.equals(this.position, other.position) && java.util.Objects.equals(this.rotation, other.rotation);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(time, position, rotation);
    }

}