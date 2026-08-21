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

public class ItemPullbackConfiguration {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 49;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 49;
    public static final int MAX_SIZE = 49;

    @Nullable public Vector3fc leftOffsetOverride;
    @Nullable public Vector3fc leftRotationOverride;
    @Nullable public Vector3fc rightOffsetOverride;
    @Nullable public Vector3fc rightRotationOverride;

    public ItemPullbackConfiguration() {
    }

    public ItemPullbackConfiguration(@Nullable Vector3fc leftOffsetOverride, @Nullable Vector3fc leftRotationOverride, @Nullable Vector3fc rightOffsetOverride, @Nullable Vector3fc rightRotationOverride) {
        this.leftOffsetOverride = leftOffsetOverride;
        this.leftRotationOverride = leftRotationOverride;
        this.rightOffsetOverride = rightOffsetOverride;
        this.rightRotationOverride = rightRotationOverride;
    }

    public ItemPullbackConfiguration(@Nonnull ItemPullbackConfiguration other) {
        this.leftOffsetOverride = other.leftOffsetOverride;
        this.leftRotationOverride = other.leftRotationOverride;
        this.rightOffsetOverride = other.rightOffsetOverride;
        this.rightRotationOverride = other.rightRotationOverride;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemPullbackConfiguration", offset, (int) mem.byteSize());
        long needed = (long) offset + 49;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemPullbackConfiguration", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static Vector3fc getLeftOffsetOverride(MemorySegment mem) {
        return getLeftOffsetOverride(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getLeftOffsetOverride(MemorySegment mem, int offset) {
        return hasLeftOffsetOverride(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 1), "LeftOffsetOverride"): null;
    }
    
    @Nullable
    public static Vector3fc getLeftRotationOverride(MemorySegment mem) {
        return getLeftRotationOverride(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getLeftRotationOverride(MemorySegment mem, int offset) {
        return hasLeftRotationOverride(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 13), "LeftRotationOverride"): null;
    }
    
    @Nullable
    public static Vector3fc getRightOffsetOverride(MemorySegment mem) {
        return getRightOffsetOverride(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getRightOffsetOverride(MemorySegment mem, int offset) {
        return hasRightOffsetOverride(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 25), "RightOffsetOverride"): null;
    }
    
    @Nullable
    public static Vector3fc getRightRotationOverride(MemorySegment mem) {
        return getRightRotationOverride(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getRightRotationOverride(MemorySegment mem, int offset) {
        return hasRightRotationOverride(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 37), "RightRotationOverride"): null;
    }
    
    public static boolean hasLeftOffsetOverride(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasLeftRotationOverride(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasRightOffsetOverride(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasRightRotationOverride(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    
    
    public static ItemPullbackConfiguration toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemPullbackConfiguration toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemPullbackConfiguration and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemPullbackConfiguration toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new ItemPullbackConfiguration(
            hasLeftOffsetOverride(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 1), "LeftOffsetOverride") : null,
            hasLeftRotationOverride(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 13), "LeftRotationOverride") : null,
            hasRightOffsetOverride(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 25), "RightOffsetOverride") : null,
            hasRightRotationOverride(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 37), "RightRotationOverride") : null
        );
        if (cursor != null) cursor.position = offset + 49;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.leftOffsetOverride != null) nullBits |= 0x01;
        if (this.leftRotationOverride != null) nullBits |= 0x02;
        if (this.rightOffsetOverride != null) nullBits |= 0x04;
        if (this.rightRotationOverride != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.leftOffsetOverride != null) {
            PacketIO.requireFinite(this.leftOffsetOverride, "LeftOffsetOverride"); PacketIO.writeVector3f(mem, offset + 1, this.leftOffsetOverride);
        } else {
            mem.asSlice(offset + 1, 12).fill((byte) 0); 
        }
        if (this.leftRotationOverride != null) {
            PacketIO.requireFinite(this.leftRotationOverride, "LeftRotationOverride"); PacketIO.writeVector3f(mem, offset + 13, this.leftRotationOverride);
        } else {
            mem.asSlice(offset + 13, 12).fill((byte) 0); 
        }
        if (this.rightOffsetOverride != null) {
            PacketIO.requireFinite(this.rightOffsetOverride, "RightOffsetOverride"); PacketIO.writeVector3f(mem, offset + 25, this.rightOffsetOverride);
        } else {
            mem.asSlice(offset + 25, 12).fill((byte) 0); 
        }
        if (this.rightRotationOverride != null) {
            PacketIO.requireFinite(this.rightRotationOverride, "RightRotationOverride"); PacketIO.writeVector3f(mem, offset + 37, this.rightRotationOverride);
        } else {
            mem.asSlice(offset + 37, 12).fill((byte) 0); 
        }
        
        
    
       return 49;
    }
    public int computeSize() {
        return 49;
    }

    public ItemPullbackConfiguration clone() {
        ItemPullbackConfiguration copy = new ItemPullbackConfiguration();
        copy.leftOffsetOverride = this.leftOffsetOverride;
        copy.leftRotationOverride = this.leftRotationOverride;
        copy.rightOffsetOverride = this.rightOffsetOverride;
        copy.rightRotationOverride = this.rightRotationOverride;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemPullbackConfiguration other)) return false;
        return java.util.Objects.equals(this.leftOffsetOverride, other.leftOffsetOverride) && java.util.Objects.equals(this.leftRotationOverride, other.leftRotationOverride) && java.util.Objects.equals(this.rightOffsetOverride, other.rightOffsetOverride) && java.util.Objects.equals(this.rightRotationOverride, other.rightRotationOverride);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(leftOffsetOverride, leftRotationOverride, rightOffsetOverride, rightRotationOverride);
    }

}