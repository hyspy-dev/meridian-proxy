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


public class BlockRotation {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 3;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 3;
    public static final int MAX_SIZE = 3;

    @Nonnull public Rotation rotationYaw = Rotation.None;
    @Nonnull public Rotation rotationPitch = Rotation.None;
    @Nonnull public Rotation rotationRoll = Rotation.None;

    public BlockRotation() {
    }

    public BlockRotation(@Nonnull Rotation rotationYaw, @Nonnull Rotation rotationPitch, @Nonnull Rotation rotationRoll) {
        this.rotationYaw = rotationYaw;
        this.rotationPitch = rotationPitch;
        this.rotationRoll = rotationRoll;
    }

    public BlockRotation(@Nonnull BlockRotation other) {
        this.rotationYaw = other.rotationYaw;
        this.rotationPitch = other.rotationPitch;
        this.rotationRoll = other.rotationRoll;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BlockRotation", offset, (int) mem.byteSize());
        long needed = (long) offset + 3;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockRotation", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static Rotation getRotationYaw(MemorySegment mem) {
        return getRotationYaw(mem, 0);
    }
    
    public static Rotation getRotationYaw(MemorySegment mem, int offset) {
        return Rotation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0));
    }
    
    public static Rotation getRotationPitch(MemorySegment mem) {
        return getRotationPitch(mem, 0);
    }
    
    public static Rotation getRotationPitch(MemorySegment mem, int offset) {
        return Rotation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static Rotation getRotationRoll(MemorySegment mem) {
        return getRotationRoll(mem, 0);
    }
    
    public static Rotation getRotationRoll(MemorySegment mem, int offset) {
        return Rotation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2));
    }
    
    
    
    
    
    public static BlockRotation toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BlockRotation toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BlockRotation and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BlockRotation toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BlockRotation(
            Rotation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0)),
            Rotation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            Rotation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2))
        );
        if (cursor != null) cursor.position = offset + 3;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, (byte) this.rotationYaw.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.rotationPitch.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 2, (byte) this.rotationRoll.getValue());
        
        
    
       return 3;
    }
    public int computeSize() {
        return 3;
    }

    public BlockRotation clone() {
        BlockRotation copy = new BlockRotation();
        copy.rotationYaw = this.rotationYaw;
        copy.rotationPitch = this.rotationPitch;
        copy.rotationRoll = this.rotationRoll;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BlockRotation other)) return false;
        return java.util.Objects.equals(this.rotationYaw, other.rotationYaw) && java.util.Objects.equals(this.rotationPitch, other.rotationPitch) && java.util.Objects.equals(this.rotationRoll, other.rotationRoll);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(rotationYaw, rotationPitch, rotationRoll);
    }

}