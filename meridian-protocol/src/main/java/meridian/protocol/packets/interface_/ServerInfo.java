// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

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
import meridian.protocol.HostAddress;

public class ServerInfo implements Packet, ToClientPacket {
    public static final int PACKET_ID = 223;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 17;
    public static final int MAX_SIZE = 32769058;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public String serverName;
    @Nullable public String motd;
    public int maxPlayers;
    @Nullable public HostAddress fallbackServer;

    public ServerInfo() {
    }

    public ServerInfo(@Nullable String serverName, @Nullable String motd, int maxPlayers, @Nullable HostAddress fallbackServer) {
        this.serverName = serverName;
        this.motd = motd;
        this.maxPlayers = maxPlayers;
        this.fallbackServer = fallbackServer;
    }

    public ServerInfo(@Nonnull ServerInfo other) {
        this.serverName = other.serverName;
        this.motd = other.motd;
        this.maxPlayers = other.maxPlayers;
        this.fallbackServer = other.fallbackServer;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ServerInfo", offset, (int) mem.byteSize());
        long needed = (long) offset + 17;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ServerInfo", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getServerName(MemorySegment mem) {
        return getServerName(mem, 0);
    }
    
    @Nullable
    public static String getServerName(MemorySegment mem, int offset) {
        return hasServerName(mem, offset) ? PacketIO.readVarString("ServerName", mem, offset + getValidatedOffset(mem, offset, 5, 17, "ServerName"), 4096000): null;
    }
    
    @Nullable
    public static String getMotd(MemorySegment mem) {
        return getMotd(mem, 0);
    }
    
    @Nullable
    public static String getMotd(MemorySegment mem, int offset) {
        return hasMotd(mem, offset) ? PacketIO.readVarString("Motd", mem, offset + getValidatedOffset(mem, offset, 9, 17, "Motd"), 4096000): null;
    }
    
    public static int getMaxPlayers(MemorySegment mem) {
        return getMaxPlayers(mem, 0);
    }
    
    public static int getMaxPlayers(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static HostAddress getFallbackServer(MemorySegment mem) {
        return getFallbackServer(mem, 0);
    }
    
    @Nullable
    public static HostAddress getFallbackServer(MemorySegment mem, int offset) {
        return hasFallbackServer(mem, offset) ? HostAddress.toObject(mem, offset + getValidatedOffset(mem, offset, 13, 17, "FallbackServer")): null;
    }
    
    public static boolean hasServerName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasMotd(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasFallbackServer(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    private static int getValidatedOffset(MemorySegment buffer, int base, int slotPosition, int varBlockStart, String fieldName) {
        int offset = buffer.get(PacketIO.PROTO_INT, base + slotPosition);
        if (offset < 0 || offset > buffer.byteSize() - base - varBlockStart)
            throw ProtocolException.invalidOffset(fieldName, offset, (int) buffer.byteSize());
        return varBlockStart + offset;
    }
    
    /**
     * Rejects an offset slot that does not name the position the field-order walk reached. A
     * present field must sit where the previous field ended, and an absent field carries -1, so
     * the slot a random-access getter resolves and the walk describe the same bytes.
     */
    private static void requireSlot(MemorySegment mem, int slotPosition, int expected, String fieldName) {
        int slot = mem.get(PacketIO.PROTO_INT, slotPosition);
        if (slot != expected) throw ProtocolException.nonCanonicalLayout(fieldName, slot, expected);
    }
    
    public static ServerInfo toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ServerInfo toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ServerInfo and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ServerInfo toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 17;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasServerName(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "ServerName");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("ServerName", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 5, -1, "ServerName");
        }
        
        String v1 = null;
        if (hasMotd(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "Motd");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Motd", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 9, -1, "Motd");
        }
        
        HostAddress v3 = null;
        if (hasFallbackServer(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "FallbackServer");
            v3 = HostAddress.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 13, -1, "FallbackServer");
        }
        var result = new ServerInfo(
            v0,
            v1,
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v3
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.serverName != null) nullBits |= 0x01;
        if (this.motd != null) nullBits |= 0x02;
        if (this.fallbackServer != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.maxPlayers);
        var varOffset = offset + 17;
        if (this.serverName != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 17);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.serverName, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.motd != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 17);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.motd, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
        if (this.fallbackServer != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 17);
            varOffset += this.fallbackServer.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 17;
        if (serverName != null) size += PacketIO.stringSize(serverName);
    if (motd != null) size += PacketIO.stringSize(motd);
    if (fallbackServer != null) size += fallbackServer.computeSize();

        return size;
    }

    public ServerInfo clone() {
        ServerInfo copy = new ServerInfo();
        copy.serverName = this.serverName;
        copy.motd = this.motd;
        copy.maxPlayers = this.maxPlayers;
        copy.fallbackServer = this.fallbackServer != null ? this.fallbackServer.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ServerInfo other)) return false;
        return java.util.Objects.equals(this.serverName, other.serverName) && java.util.Objects.equals(this.motd, other.motd) && this.maxPlayers == other.maxPlayers && java.util.Objects.equals(this.fallbackServer, other.fallbackServer);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(serverName, motd, maxPlayers, fallbackServer);
    }

}