// Auto-generated - do not edit
package meridian.protocol.packets.buildertools;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.NetworkChannel;
import meridian.protocol.Packet;
import meridian.protocol.ToServerPacket;
import meridian.protocol.ToClientPacket;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import meridian.protocol.ModelTransform;

public class BuilderToolSetEntityTransform implements Packet, ToServerPacket {
    public static final int PACKET_ID = 402;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 55;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 55;
    public static final int MAX_SIZE = 55;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int entityId;
    @Nullable public ModelTransform modelTransform;
    public boolean isSessionEnd;

    public BuilderToolSetEntityTransform() {
    }

    public BuilderToolSetEntityTransform(int entityId, @Nullable ModelTransform modelTransform, boolean isSessionEnd) {
        this.entityId = entityId;
        this.modelTransform = modelTransform;
        this.isSessionEnd = isSessionEnd;
    }

    public BuilderToolSetEntityTransform(@Nonnull BuilderToolSetEntityTransform other) {
        this.entityId = other.entityId;
        this.modelTransform = other.modelTransform;
        this.isSessionEnd = other.isSessionEnd;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolSetEntityTransform", offset, (int) mem.byteSize());
        long needed = (long) offset + 55;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolSetEntityTransform", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getEntityId(MemorySegment mem) {
        return getEntityId(mem, 0);
    }
    
    public static int getEntityId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static ModelTransform getModelTransform(MemorySegment mem) {
        return getModelTransform(mem, 0);
    }
    
    @Nullable
    public static ModelTransform getModelTransform(MemorySegment mem, int offset) {
        return hasModelTransform(mem, offset) ? ModelTransform.toObject(mem, offset + 5): null;
    }
    
    public static boolean getIsSessionEnd(MemorySegment mem) {
        return getIsSessionEnd(mem, 0);
    }
    
    public static boolean getIsSessionEnd(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 54);
    }
    
    public static boolean hasModelTransform(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static BuilderToolSetEntityTransform toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolSetEntityTransform toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolSetEntityTransform and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolSetEntityTransform toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BuilderToolSetEntityTransform(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            hasModelTransform(mem, offset) ? ModelTransform.toObject(mem, offset + 5) : null,
            mem.get(PacketIO.PROTO_BOOL, offset + 54)
        );
        if (cursor != null) cursor.position = offset + 55;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.modelTransform != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.entityId);
        if (this.modelTransform != null) {
            this.modelTransform.serialize(mem, offset + 5);
        } else {
            mem.asSlice(offset + 5, 49).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BOOL, offset + 54, this.isSessionEnd);
        
        
    
       return 55;
    }
    public int computeSize() {
        return 55;
    }

    public BuilderToolSetEntityTransform clone() {
        BuilderToolSetEntityTransform copy = new BuilderToolSetEntityTransform();
        copy.entityId = this.entityId;
        copy.modelTransform = this.modelTransform != null ? this.modelTransform.clone() : null;
        copy.isSessionEnd = this.isSessionEnd;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolSetEntityTransform other)) return false;
        return this.entityId == other.entityId && java.util.Objects.equals(this.modelTransform, other.modelTransform) && this.isSessionEnd == other.isSessionEnd;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(entityId, modelTransform, isSessionEnd);
    }

}