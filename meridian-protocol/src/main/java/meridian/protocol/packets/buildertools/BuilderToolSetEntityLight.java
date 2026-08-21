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
import meridian.protocol.ColorLight;

public class BuilderToolSetEntityLight implements Packet, ToServerPacket {
    public static final int PACKET_ID = 422;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 9;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int entityId;
    @Nullable public ColorLight light;

    public BuilderToolSetEntityLight() {
    }

    public BuilderToolSetEntityLight(int entityId, @Nullable ColorLight light) {
        this.entityId = entityId;
        this.light = light;
    }

    public BuilderToolSetEntityLight(@Nonnull BuilderToolSetEntityLight other) {
        this.entityId = other.entityId;
        this.light = other.light;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolSetEntityLight", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolSetEntityLight", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getEntityId(MemorySegment mem) {
        return getEntityId(mem, 0);
    }
    
    public static int getEntityId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static ColorLight getLight(MemorySegment mem) {
        return getLight(mem, 0);
    }
    
    @Nullable
    public static ColorLight getLight(MemorySegment mem, int offset) {
        return hasLight(mem, offset) ? ColorLight.toObject(mem, offset + 5): null;
    }
    
    public static boolean hasLight(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static BuilderToolSetEntityLight toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolSetEntityLight toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolSetEntityLight and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolSetEntityLight toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BuilderToolSetEntityLight(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            hasLight(mem, offset) ? ColorLight.toObject(mem, offset + 5) : null
        );
        if (cursor != null) cursor.position = offset + 9;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.light != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.entityId);
        if (this.light != null) {
            this.light.serialize(mem, offset + 5);
        } else {
            mem.asSlice(offset + 5, 4).fill((byte) 0); 
        }
        
        
    
       return 9;
    }
    public int computeSize() {
        return 9;
    }

    public BuilderToolSetEntityLight clone() {
        BuilderToolSetEntityLight copy = new BuilderToolSetEntityLight();
        copy.entityId = this.entityId;
        copy.light = this.light != null ? this.light.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolSetEntityLight other)) return false;
        return this.entityId == other.entityId && java.util.Objects.equals(this.light, other.light);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(entityId, light);
    }

}