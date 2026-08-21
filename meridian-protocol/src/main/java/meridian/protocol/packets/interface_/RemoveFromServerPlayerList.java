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
import java.util.UUID;

public class RemoveFromServerPlayerList implements Packet, ToClientPacket {
    public static final int PACKET_ID = 225;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 0;
    public static final int MAX_SIZE = 65536005;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public java.util.UUID[] players = new java.util.UUID[0];

    public RemoveFromServerPlayerList() {
    }

    public RemoveFromServerPlayerList(@Nonnull java.util.UUID[] players) {
        this.players = players;
    }

    public RemoveFromServerPlayerList(@Nonnull RemoveFromServerPlayerList other) {
        this.players = other.players;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("RemoveFromServerPlayerList", offset, (int) mem.byteSize());
        long needed = (long) offset + 0;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("RemoveFromServerPlayerList", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static java.util.UUID[] getPlayers(MemorySegment mem) {
        return getPlayers(mem, 0);
    }
    
    public static java.util.UUID[] getPlayers(MemorySegment mem, int offset) {
        var off = offset + 0;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Players");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Players", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 16 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Players", (int) java.lang.Math.min(off + lenOffset + (long) len * 16, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new java.util.UUID[len];
        for (var i = 0; i < len; i++) {
            data[i] = PacketIO.readUUID(mem, off + i * 16);
        }
        return data;
    }
    
    
    
    
    
    public static RemoveFromServerPlayerList toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static RemoveFromServerPlayerList toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one RemoveFromServerPlayerList and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static RemoveFromServerPlayerList toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 0;
        var varPos = 0;
        java.util.UUID[] v0;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Players");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Players", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 16 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Players", (int) java.lang.Math.min(off + lenOffset + (long) len * 16, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new java.util.UUID[len];
            for (var i = 0; i < len; i++) {
                v0[i] = PacketIO.readUUID(mem, off + i * 16);
            }
            varPos = off + len * 16 - varBase;
        }
        var result = new RemoveFromServerPlayerList(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 0;
        if (players.length > 4096000) throw ProtocolException.arrayTooLong("Players", players.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.players.length);
        
        for (var i = 0; i < this.players.length; i++) {
            PacketIO.writeUUID(mem, varOffset + i * 16, this.players[i]);
        }
        varOffset += this.players.length * 16;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 0;
        size += VarInt.size(players.length) + players.length * 16;

        return size;
    }

    public RemoveFromServerPlayerList clone() {
        RemoveFromServerPlayerList copy = new RemoveFromServerPlayerList();
        copy.players = java.util.Arrays.copyOf(this.players, this.players.length);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RemoveFromServerPlayerList other)) return false;
        return java.util.Arrays.equals(this.players, other.players);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(players);
        return result;
    }

}