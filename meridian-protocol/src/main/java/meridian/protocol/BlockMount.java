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

public class BlockMount {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 29;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 29;
    public static final int MAX_SIZE = 29;

    @Nonnull public BlockMountType type = BlockMountType.Seat;
    @Nonnull public Vector3fc position = PacketIO.ZERO_VECTOR3;
    @Nonnull public Vector3fc orientation = PacketIO.ZERO_VECTOR3;
    public int blockTypeId;

    public BlockMount() {
    }

    public BlockMount(@Nonnull BlockMountType type, @Nonnull Vector3fc position, @Nonnull Vector3fc orientation, int blockTypeId) {
        this.type = type;
        this.position = position;
        this.orientation = orientation;
        this.blockTypeId = blockTypeId;
    }

    public BlockMount(@Nonnull BlockMount other) {
        this.type = other.type;
        this.position = other.position;
        this.orientation = other.orientation;
        this.blockTypeId = other.blockTypeId;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BlockMount", offset, (int) mem.byteSize());
        long needed = (long) offset + 29;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockMount", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static BlockMountType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static BlockMountType getType(MemorySegment mem, int offset) {
        return BlockMountType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0));
    }
    
    public static Vector3fc getPosition(MemorySegment mem) {
        return getPosition(mem, 0);
    }
    
    public static Vector3fc getPosition(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 1), "Position");
    }
    
    public static Vector3fc getOrientation(MemorySegment mem) {
        return getOrientation(mem, 0);
    }
    
    public static Vector3fc getOrientation(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 13), "Orientation");
    }
    
    public static int getBlockTypeId(MemorySegment mem) {
        return getBlockTypeId(mem, 0);
    }
    
    public static int getBlockTypeId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 25);
    }
    
    
    
    
    
    public static BlockMount toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BlockMount toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BlockMount and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BlockMount toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BlockMount(
            BlockMountType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0)),
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 1), "Position"),
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 13), "Orientation"),
            mem.get(PacketIO.PROTO_INT, offset + 25)
        );
        if (cursor != null) cursor.position = offset + 29;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, (byte) this.type.getValue());
        PacketIO.requireFinite(this.position, "Position"); PacketIO.writeVector3f(mem, offset + 1, this.position);
        PacketIO.requireFinite(this.orientation, "Orientation"); PacketIO.writeVector3f(mem, offset + 13, this.orientation);
        mem.set(PacketIO.PROTO_INT, offset + 25, this.blockTypeId);
        
        
    
       return 29;
    }
    public int computeSize() {
        return 29;
    }

    public BlockMount clone() {
        BlockMount copy = new BlockMount();
        copy.type = this.type;
        copy.position = this.position;
        copy.orientation = this.orientation;
        copy.blockTypeId = this.blockTypeId;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BlockMount other)) return false;
        return java.util.Objects.equals(this.type, other.type) && java.util.Objects.equals(this.position, other.position) && java.util.Objects.equals(this.orientation, other.orientation) && this.blockTypeId == other.blockTypeId;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(type, position, orientation, blockTypeId);
    }

}