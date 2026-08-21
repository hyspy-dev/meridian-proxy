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


public class BuilderToolSetEntityType implements Packet, ToServerPacket {
    public static final int PACKET_ID = 424;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 5;
    public static final int MAX_SIZE = 16384010;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int entityId;
    @Nullable public String typeKey;

    public BuilderToolSetEntityType() {
    }

    public BuilderToolSetEntityType(int entityId, @Nullable String typeKey) {
        this.entityId = entityId;
        this.typeKey = typeKey;
    }

    public BuilderToolSetEntityType(@Nonnull BuilderToolSetEntityType other) {
        this.entityId = other.entityId;
        this.typeKey = other.typeKey;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolSetEntityType", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolSetEntityType", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getEntityId(MemorySegment mem) {
        return getEntityId(mem, 0);
    }
    
    public static int getEntityId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static String getTypeKey(MemorySegment mem) {
        return getTypeKey(mem, 0);
    }
    
    @Nullable
    public static String getTypeKey(MemorySegment mem, int offset) {
        return hasTypeKey(mem, offset) ? PacketIO.readVarString("TypeKey", mem, offset + 5, 4096000): null;
    }
    
    public static boolean hasTypeKey(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static BuilderToolSetEntityType toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolSetEntityType toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolSetEntityType and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolSetEntityType toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 5;
        var varPos = 0;
        String v1 = null;
        if (hasTypeKey(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("TypeKey", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new BuilderToolSetEntityType(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.typeKey != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.entityId);
        var varOffset = offset + 5;
        if (this.typeKey != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.typeKey, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 5;
        if (typeKey != null) size += PacketIO.stringSize(typeKey);

        return size;
    }

    public BuilderToolSetEntityType clone() {
        BuilderToolSetEntityType copy = new BuilderToolSetEntityType();
        copy.entityId = this.entityId;
        copy.typeKey = this.typeKey;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolSetEntityType other)) return false;
        return this.entityId == other.entityId && java.util.Objects.equals(this.typeKey, other.typeKey);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(entityId, typeKey);
    }

}