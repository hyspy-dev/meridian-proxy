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
import java.util.HashMap;
import java.util.UUID;

public class UpdateServerPlayerListPing implements Packet, ToClientPacket {
    public static final int PACKET_ID = 227;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 0;
    public static final int MAX_SIZE = 81920005;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public java.util.Map<java.util.UUID, Integer> players = new java.util.HashMap<>();

    public UpdateServerPlayerListPing() {
    }

    public UpdateServerPlayerListPing(@Nonnull java.util.Map<java.util.UUID, Integer> players) {
        this.players = players;
    }

    public UpdateServerPlayerListPing(@Nonnull UpdateServerPlayerListPing other) {
        this.players = other.players;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateServerPlayerListPing", offset, (int) mem.byteSize());
        long needed = (long) offset + 0;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateServerPlayerListPing", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static java.util.Map<java.util.UUID, Integer> getPlayers(MemorySegment mem) {
        return getPlayers(mem, 0);
    }
    
    public static java.util.Map<java.util.UUID, Integer> getPlayers(MemorySegment mem, int offset) {
        var off = offset + 0;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Players");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Players", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 20 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Players", (int) java.lang.Math.min(off + (long) len * 20, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<java.util.UUID, Integer> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = PacketIO.readUUID(mem, off);
                off += 16;
            var value = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Players", key);
            }
        }
        return data;
    }
    
    
    
    
    
    public static UpdateServerPlayerListPing toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateServerPlayerListPing toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateServerPlayerListPing and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateServerPlayerListPing toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 0;
        var varPos = 0;
        java.util.Map<java.util.UUID, Integer> v0;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Players");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Players", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 20 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Players", (int) java.lang.Math.min(off + (long) len * 20, Integer.MAX_VALUE), (int) mem.byteSize());
            v0 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = PacketIO.readUUID(mem, off);
                    off += 16;
                var value = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                if (v0.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Players", key);
                }
            }
            varPos = off - varBase;
        }
        var result = new UpdateServerPlayerListPing(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 0;
        if (this.players.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Players", players.size(), 4096000);
        varOffset += VarInt.set(mem, varOffset, this.players.size());
        for (var e : this.players.entrySet()) {
            PacketIO.writeUUID(mem, varOffset, e.getKey());
            varOffset += 16;
            mem.set(PacketIO.PROTO_INT, varOffset, e.getValue());
            varOffset += 4;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 0;
        size += VarInt.size(players.size()) + players.size() * (16 + 4);

        return size;
    }

    public UpdateServerPlayerListPing clone() {
        UpdateServerPlayerListPing copy = new UpdateServerPlayerListPing();
        copy.players = new java.util.HashMap<>(this.players);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateServerPlayerListPing other)) return false;
        return java.util.Objects.equals(this.players, other.players);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(players);
    }

}