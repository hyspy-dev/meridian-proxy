// Auto-generated - do not edit
package meridian.protocol.packets.player;

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

public class ClientTeleport implements Packet, ToClientPacket {
    public static final int PACKET_ID = 109;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
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

    public byte teleportId;
    @Nonnull public short ignoredTransformFields;
    @Nonnull public short relativeTransformFields;
    @Nonnull public ModelTransform modelTransform = new ModelTransform();
    public boolean resetVelocity;

    public ClientTeleport() {
    }

    public ClientTeleport(byte teleportId, @Nonnull short ignoredTransformFields, @Nonnull short relativeTransformFields, @Nonnull ModelTransform modelTransform, boolean resetVelocity) {
        this.teleportId = teleportId;
        this.ignoredTransformFields = ignoredTransformFields;
        this.relativeTransformFields = relativeTransformFields;
        this.modelTransform = modelTransform;
        this.resetVelocity = resetVelocity;
    }

    public ClientTeleport(@Nonnull ClientTeleport other) {
        this.teleportId = other.teleportId;
        this.ignoredTransformFields = other.ignoredTransformFields;
        this.relativeTransformFields = other.relativeTransformFields;
        this.modelTransform = other.modelTransform;
        this.resetVelocity = other.resetVelocity;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ClientTeleport", offset, (int) mem.byteSize());
        long needed = (long) offset + 55;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ClientTeleport", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static byte getTeleportId(MemorySegment mem) {
        return getTeleportId(mem, 0);
    }
    
    public static byte getTeleportId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 0);
    }
    
    public static short getIgnoredTransformFields(MemorySegment mem) {
        return getIgnoredTransformFields(mem, 0);
    }
    
    public static short getIgnoredTransformFields(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_SHORT, offset + 1);
    }
    
    public static short getRelativeTransformFields(MemorySegment mem) {
        return getRelativeTransformFields(mem, 0);
    }
    
    public static short getRelativeTransformFields(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_SHORT, offset + 3);
    }
    
    public static ModelTransform getModelTransform(MemorySegment mem) {
        return getModelTransform(mem, 0);
    }
    
    public static ModelTransform getModelTransform(MemorySegment mem, int offset) {
        return ModelTransform.toObject(mem, offset + 5);
    }
    
    public static boolean getResetVelocity(MemorySegment mem) {
        return getResetVelocity(mem, 0);
    }
    
    public static boolean getResetVelocity(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 54);
    }
    
    
    
    
    
    public static ClientTeleport toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ClientTeleport toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ClientTeleport and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ClientTeleport toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new ClientTeleport(
            mem.get(PacketIO.PROTO_BYTE, offset + 0),
            mem.get(PacketIO.PROTO_SHORT, offset + 1),
            mem.get(PacketIO.PROTO_SHORT, offset + 3),
            ModelTransform.toObject(mem, offset + 5),
            mem.get(PacketIO.PROTO_BOOL, offset + 54)
        );
        if (cursor != null) cursor.position = offset + 55;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, this.teleportId);
        mem.set(PacketIO.PROTO_SHORT, offset + 1, this.ignoredTransformFields);
        mem.set(PacketIO.PROTO_SHORT, offset + 3, this.relativeTransformFields);
        this.modelTransform.serialize(mem, offset + 5);
        mem.set(PacketIO.PROTO_BOOL, offset + 54, this.resetVelocity);
        
        
    
       return 55;
    }
    public int computeSize() {
        return 55;
    }

    public ClientTeleport clone() {
        ClientTeleport copy = new ClientTeleport();
        copy.teleportId = this.teleportId;
        copy.ignoredTransformFields = this.ignoredTransformFields;
        copy.relativeTransformFields = this.relativeTransformFields;
        copy.modelTransform = this.modelTransform.clone();
        copy.resetVelocity = this.resetVelocity;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ClientTeleport other)) return false;
        return this.teleportId == other.teleportId && java.util.Objects.equals(this.ignoredTransformFields, other.ignoredTransformFields) && java.util.Objects.equals(this.relativeTransformFields, other.relativeTransformFields) && java.util.Objects.equals(this.modelTransform, other.modelTransform) && this.resetVelocity == other.resetVelocity;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(teleportId, ignoredTransformFields, relativeTransformFields, modelTransform, resetVelocity);
    }

}