// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import java.util.UUID;

public class ServerPlayerListUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 32;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 32;
    public static final int MAX_SIZE = 32;

    @Nonnull public java.util.UUID uuid = new java.util.UUID(0L, 0L);
    @Nonnull public java.util.UUID worldUuid = new java.util.UUID(0L, 0L);

    public ServerPlayerListUpdate() {
    }

    public ServerPlayerListUpdate(@Nonnull java.util.UUID uuid, @Nonnull java.util.UUID worldUuid) {
        this.uuid = uuid;
        this.worldUuid = worldUuid;
    }

    public ServerPlayerListUpdate(@Nonnull ServerPlayerListUpdate other) {
        this.uuid = other.uuid;
        this.worldUuid = other.worldUuid;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ServerPlayerListUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 32;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ServerPlayerListUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static java.util.UUID getUuid(MemorySegment mem) {
        return getUuid(mem, 0);
    }
    
    public static java.util.UUID getUuid(MemorySegment mem, int offset) {
        return PacketIO.readUUID(mem, offset + 0);
    }
    
    public static java.util.UUID getWorldUuid(MemorySegment mem) {
        return getWorldUuid(mem, 0);
    }
    
    public static java.util.UUID getWorldUuid(MemorySegment mem, int offset) {
        return PacketIO.readUUID(mem, offset + 16);
    }
    
    
    
    
    
    public static ServerPlayerListUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ServerPlayerListUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ServerPlayerListUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ServerPlayerListUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new ServerPlayerListUpdate(
            PacketIO.readUUID(mem, offset + 0),
            PacketIO.readUUID(mem, offset + 16)
        );
        if (cursor != null) cursor.position = offset + 32;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.writeUUID(mem, offset + 0, this.uuid);
        PacketIO.writeUUID(mem, offset + 16, this.worldUuid);
        
        
    
       return 32;
    }
    public int computeSize() {
        return 32;
    }

    public ServerPlayerListUpdate clone() {
        ServerPlayerListUpdate copy = new ServerPlayerListUpdate();
        copy.uuid = this.uuid;
        copy.worldUuid = this.worldUuid;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ServerPlayerListUpdate other)) return false;
        return java.util.Objects.equals(this.uuid, other.uuid) && java.util.Objects.equals(this.worldUuid, other.worldUuid);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(uuid, worldUuid);
    }

}