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

public class MountedUpdate extends ComponentUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 47;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 47;
    public static final int MAX_SIZE = 47;

    public int mountedToEntity;
    @Nonnull public Vector3fc attachmentOffset = PacketIO.ZERO_VECTOR3;
    @Nonnull public MountController controller = MountController.Minecart;
    @Nullable public BlockMount block;

    public MountedUpdate() {
    }

    public MountedUpdate(int mountedToEntity, @Nonnull Vector3fc attachmentOffset, @Nonnull MountController controller, @Nullable BlockMount block) {
        this.mountedToEntity = mountedToEntity;
        this.attachmentOffset = attachmentOffset;
        this.controller = controller;
        this.block = block;
    }

    public MountedUpdate(@Nonnull MountedUpdate other) {
        this.mountedToEntity = other.mountedToEntity;
        this.attachmentOffset = other.attachmentOffset;
        this.controller = other.controller;
        this.block = other.block;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("MountedUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 47;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("MountedUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getMountedToEntity(MemorySegment mem) {
        return getMountedToEntity(mem, 0);
    }
    
    public static int getMountedToEntity(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static Vector3fc getAttachmentOffset(MemorySegment mem) {
        return getAttachmentOffset(mem, 0);
    }
    
    public static Vector3fc getAttachmentOffset(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 5), "AttachmentOffset");
    }
    
    public static MountController getController(MemorySegment mem) {
        return getController(mem, 0);
    }
    
    public static MountController getController(MemorySegment mem, int offset) {
        return MountController.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 17));
    }
    
    @Nullable
    public static BlockMount getBlock(MemorySegment mem) {
        return getBlock(mem, 0);
    }
    
    @Nullable
    public static BlockMount getBlock(MemorySegment mem, int offset) {
        return hasBlock(mem, offset) ? BlockMount.toObject(mem, offset + 18): null;
    }
    
    public static boolean hasBlock(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static MountedUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static MountedUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one MountedUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static MountedUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new MountedUpdate(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 5), "AttachmentOffset"),
            MountController.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 17)),
            hasBlock(mem, offset) ? BlockMount.toObject(mem, offset + 18) : null
        );
        if (cursor != null) cursor.position = offset + 47;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.block != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.mountedToEntity);
        PacketIO.requireFinite(this.attachmentOffset, "AttachmentOffset"); PacketIO.writeVector3f(mem, offset + 5, this.attachmentOffset);
        mem.set(PacketIO.PROTO_BYTE, offset + 17, (byte) this.controller.getValue());
        if (this.block != null) {
            this.block.serialize(mem, offset + 18);
        } else {
            mem.asSlice(offset + 18, 29).fill((byte) 0); 
        }
        
        
    
       return 47;
    }
    @Override
    public int computeSize() {
        return 47;
    }

    public MountedUpdate clone() {
        MountedUpdate copy = new MountedUpdate();
        copy.mountedToEntity = this.mountedToEntity;
        copy.attachmentOffset = this.attachmentOffset;
        copy.controller = this.controller;
        copy.block = this.block != null ? this.block.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MountedUpdate other)) return false;
        return this.mountedToEntity == other.mountedToEntity && java.util.Objects.equals(this.attachmentOffset, other.attachmentOffset) && java.util.Objects.equals(this.controller, other.controller) && java.util.Objects.equals(this.block, other.block);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(mountedToEntity, attachmentOffset, controller, block);
    }

}