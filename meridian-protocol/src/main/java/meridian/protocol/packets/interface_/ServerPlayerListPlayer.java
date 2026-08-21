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

public class ServerPlayerListPlayer {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 42;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 42;
    public static final int MAX_SIZE = 16384047;

    @Nonnull public java.util.UUID uuid = new java.util.UUID(0L, 0L);
    @Nullable public String username;
    @Nullable public java.util.UUID worldUuid;
    public int ping;
    public boolean spectating;
    @Nullable public Integer livesRemaining;

    public ServerPlayerListPlayer() {
    }

    public ServerPlayerListPlayer(@Nonnull java.util.UUID uuid, @Nullable String username, @Nullable java.util.UUID worldUuid, int ping, boolean spectating, @Nullable Integer livesRemaining) {
        this.uuid = uuid;
        this.username = username;
        this.worldUuid = worldUuid;
        this.ping = ping;
        this.spectating = spectating;
        this.livesRemaining = livesRemaining;
    }

    public ServerPlayerListPlayer(@Nonnull ServerPlayerListPlayer other) {
        this.uuid = other.uuid;
        this.username = other.username;
        this.worldUuid = other.worldUuid;
        this.ping = other.ping;
        this.spectating = other.spectating;
        this.livesRemaining = other.livesRemaining;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ServerPlayerListPlayer", offset, (int) mem.byteSize());
        long needed = (long) offset + 42;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ServerPlayerListPlayer", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static java.util.UUID getUuid(MemorySegment mem) {
        return getUuid(mem, 0);
    }
    
    public static java.util.UUID getUuid(MemorySegment mem, int offset) {
        return PacketIO.readUUID(mem, offset + 1);
    }
    
    @Nullable
    public static String getUsername(MemorySegment mem) {
        return getUsername(mem, 0);
    }
    
    @Nullable
    public static String getUsername(MemorySegment mem, int offset) {
        return hasUsername(mem, offset) ? PacketIO.readVarString("Username", mem, offset + 42, 4096000): null;
    }
    
    @Nullable
    public static java.util.UUID getWorldUuid(MemorySegment mem) {
        return getWorldUuid(mem, 0);
    }
    
    @Nullable
    public static java.util.UUID getWorldUuid(MemorySegment mem, int offset) {
        return hasWorldUuid(mem, offset) ? PacketIO.readUUID(mem, offset + 17): null;
    }
    
    public static int getPing(MemorySegment mem) {
        return getPing(mem, 0);
    }
    
    public static int getPing(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 33);
    }
    
    public static boolean getSpectating(MemorySegment mem) {
        return getSpectating(mem, 0);
    }
    
    public static boolean getSpectating(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 37);
    }
    
    @Nullable
    public static Integer getLivesRemaining(MemorySegment mem) {
        return getLivesRemaining(mem, 0);
    }
    
    @Nullable
    public static Integer getLivesRemaining(MemorySegment mem, int offset) {
        return hasLivesRemaining(mem, offset) ? mem.get(PacketIO.PROTO_INT, offset + 38): null;
    }
    
    public static boolean hasWorldUuid(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasLivesRemaining(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasUsername(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    
    
    public static ServerPlayerListPlayer toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ServerPlayerListPlayer toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ServerPlayerListPlayer and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ServerPlayerListPlayer toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 42;
        var varPos = 0;
        String v1 = null;
        if (hasUsername(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Username", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new ServerPlayerListPlayer(
            PacketIO.readUUID(mem, offset + 1),
            v1,
            hasWorldUuid(mem, offset) ? PacketIO.readUUID(mem, offset + 17) : null,
            mem.get(PacketIO.PROTO_INT, offset + 33),
            mem.get(PacketIO.PROTO_BOOL, offset + 37),
            hasLivesRemaining(mem, offset) ? mem.get(PacketIO.PROTO_INT, offset + 38) : null
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.worldUuid != null) nullBits |= 0x01;
        if (this.livesRemaining != null) nullBits |= 0x02;
        if (this.username != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.writeUUID(mem, offset + 1, this.uuid);
        if (this.worldUuid != null) {
            PacketIO.writeUUID(mem, offset + 17, this.worldUuid);
        } else {
            mem.asSlice(offset + 17, 16).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_INT, offset + 33, this.ping);
        mem.set(PacketIO.PROTO_BOOL, offset + 37, this.spectating);
        if (this.livesRemaining != null) {
            mem.set(PacketIO.PROTO_INT, offset + 38, this.livesRemaining);
        } else {
            mem.asSlice(offset + 38, 4).fill((byte) 0); 
        }
        var varOffset = offset + 42;
        if (this.username != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.username, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 42;
        if (username != null) size += PacketIO.stringSize(username);

        return size;
    }

    public ServerPlayerListPlayer clone() {
        ServerPlayerListPlayer copy = new ServerPlayerListPlayer();
        copy.uuid = this.uuid;
        copy.username = this.username;
        copy.worldUuid = this.worldUuid;
        copy.ping = this.ping;
        copy.spectating = this.spectating;
        copy.livesRemaining = this.livesRemaining;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ServerPlayerListPlayer other)) return false;
        return java.util.Objects.equals(this.uuid, other.uuid) && java.util.Objects.equals(this.username, other.username) && java.util.Objects.equals(this.worldUuid, other.worldUuid) && this.ping == other.ping && this.spectating == other.spectating && java.util.Objects.equals(this.livesRemaining, other.livesRemaining);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(uuid, username, worldUuid, ping, spectating, livesRemaining);
    }

}