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


public class BuilderToolSetEntityPickupEnabled implements Packet, ToServerPacket {
    public static final int PACKET_ID = 421;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 5;
    public static final int MAX_SIZE = 5;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int entityId;
    public boolean enabled;

    public BuilderToolSetEntityPickupEnabled() {
    }

    public BuilderToolSetEntityPickupEnabled(int entityId, boolean enabled) {
        this.entityId = entityId;
        this.enabled = enabled;
    }

    public BuilderToolSetEntityPickupEnabled(@Nonnull BuilderToolSetEntityPickupEnabled other) {
        this.entityId = other.entityId;
        this.enabled = other.enabled;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolSetEntityPickupEnabled", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolSetEntityPickupEnabled", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getEntityId(MemorySegment mem) {
        return getEntityId(mem, 0);
    }
    
    public static int getEntityId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static boolean getEnabled(MemorySegment mem) {
        return getEnabled(mem, 0);
    }
    
    public static boolean getEnabled(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 4);
    }
    
    
    
    
    
    public static BuilderToolSetEntityPickupEnabled toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolSetEntityPickupEnabled toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolSetEntityPickupEnabled and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolSetEntityPickupEnabled toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BuilderToolSetEntityPickupEnabled(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_BOOL, offset + 4)
        );
        if (cursor != null) cursor.position = offset + 5;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.entityId);
        mem.set(PacketIO.PROTO_BOOL, offset + 4, this.enabled);
        
        
    
       return 5;
    }
    public int computeSize() {
        return 5;
    }

    public BuilderToolSetEntityPickupEnabled clone() {
        BuilderToolSetEntityPickupEnabled copy = new BuilderToolSetEntityPickupEnabled();
        copy.entityId = this.entityId;
        copy.enabled = this.enabled;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolSetEntityPickupEnabled other)) return false;
        return this.entityId == other.entityId && this.enabled == other.enabled;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(entityId, enabled);
    }

}