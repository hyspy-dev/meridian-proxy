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


public class AddToServerPlayerList implements Packet, ToClientPacket {
    public static final int PACKET_ID = 224;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 0;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public ServerPlayerListPlayer[] players = new ServerPlayerListPlayer[0];

    public AddToServerPlayerList() {
    }

    public AddToServerPlayerList(@Nonnull ServerPlayerListPlayer[] players) {
        this.players = players;
    }

    public AddToServerPlayerList(@Nonnull AddToServerPlayerList other) {
        this.players = other.players;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AddToServerPlayerList", offset, (int) mem.byteSize());
        long needed = (long) offset + 0;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AddToServerPlayerList", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static ServerPlayerListPlayer[] getPlayers(MemorySegment mem) {
        return getPlayers(mem, 0);
    }
    
    public static ServerPlayerListPlayer[] getPlayers(MemorySegment mem, int offset) {
        var walkCursor = new ReadCursor();
        var off = offset + 0;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Players");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Players", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Players", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ServerPlayerListPlayer[len];
        for (var i = 0; i < len; i++) {
            data[i] = ServerPlayerListPlayer.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    
    
    
    
    public static AddToServerPlayerList toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AddToServerPlayerList toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AddToServerPlayerList and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AddToServerPlayerList toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 0;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ServerPlayerListPlayer[] v0;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Players");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Players", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Players", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new ServerPlayerListPlayer[len];
            for (var i = 0; i < len; i++) {
                v0[i] = ServerPlayerListPlayer.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new AddToServerPlayerList(
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
        
        var playersValueOffset = 0;
        for (var i = 0; i < this.players.length; i++) {
            playersValueOffset += this.players[i].serialize(mem, varOffset + playersValueOffset);
        }
        varOffset += playersValueOffset;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 0;
        int playersSize = 0;
for (var elem : players) playersSize += elem.computeSize();
size += VarInt.size(players.length) + playersSize;

        return size;
    }

    public AddToServerPlayerList clone() {
        AddToServerPlayerList copy = new AddToServerPlayerList();
        copy.players = java.util.Arrays.stream(this.players).map(e -> e.clone()).toArray(ServerPlayerListPlayer[]::new);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AddToServerPlayerList other)) return false;
        return java.util.Arrays.equals(this.players, other.players);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(players);
        return result;
    }

}