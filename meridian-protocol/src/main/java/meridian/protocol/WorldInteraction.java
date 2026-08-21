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


public class WorldInteraction {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 20;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 20;
    public static final int MAX_SIZE = 20;

    public int entityId;
    @Nullable public BlockPosition blockPosition;
    @Nullable public BlockRotation blockRotation;

    public WorldInteraction() {
    }

    public WorldInteraction(int entityId, @Nullable BlockPosition blockPosition, @Nullable BlockRotation blockRotation) {
        this.entityId = entityId;
        this.blockPosition = blockPosition;
        this.blockRotation = blockRotation;
    }

    public WorldInteraction(@Nonnull WorldInteraction other) {
        this.entityId = other.entityId;
        this.blockPosition = other.blockPosition;
        this.blockRotation = other.blockRotation;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("WorldInteraction", offset, (int) mem.byteSize());
        long needed = (long) offset + 20;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("WorldInteraction", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getEntityId(MemorySegment mem) {
        return getEntityId(mem, 0);
    }
    
    public static int getEntityId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static BlockPosition getBlockPosition(MemorySegment mem) {
        return getBlockPosition(mem, 0);
    }
    
    @Nullable
    public static BlockPosition getBlockPosition(MemorySegment mem, int offset) {
        return hasBlockPosition(mem, offset) ? BlockPosition.toObject(mem, offset + 5): null;
    }
    
    @Nullable
    public static BlockRotation getBlockRotation(MemorySegment mem) {
        return getBlockRotation(mem, 0);
    }
    
    @Nullable
    public static BlockRotation getBlockRotation(MemorySegment mem, int offset) {
        return hasBlockRotation(mem, offset) ? BlockRotation.toObject(mem, offset + 17): null;
    }
    
    public static boolean hasBlockPosition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasBlockRotation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    
    
    public static WorldInteraction toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static WorldInteraction toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one WorldInteraction and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static WorldInteraction toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new WorldInteraction(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            hasBlockPosition(mem, offset) ? BlockPosition.toObject(mem, offset + 5) : null,
            hasBlockRotation(mem, offset) ? BlockRotation.toObject(mem, offset + 17) : null
        );
        if (cursor != null) cursor.position = offset + 20;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.blockPosition != null) nullBits |= 0x01;
        if (this.blockRotation != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.entityId);
        if (this.blockPosition != null) {
            this.blockPosition.serialize(mem, offset + 5);
        } else {
            mem.asSlice(offset + 5, 12).fill((byte) 0); 
        }
        if (this.blockRotation != null) {
            this.blockRotation.serialize(mem, offset + 17);
        } else {
            mem.asSlice(offset + 17, 3).fill((byte) 0); 
        }
        
        
    
       return 20;
    }
    public int computeSize() {
        return 20;
    }

    public WorldInteraction clone() {
        WorldInteraction copy = new WorldInteraction();
        copy.entityId = this.entityId;
        copy.blockPosition = this.blockPosition != null ? this.blockPosition.clone() : null;
        copy.blockRotation = this.blockRotation != null ? this.blockRotation.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof WorldInteraction other)) return false;
        return this.entityId == other.entityId && java.util.Objects.equals(this.blockPosition, other.blockPosition) && java.util.Objects.equals(this.blockRotation, other.blockRotation);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(entityId, blockPosition, blockRotation);
    }

}