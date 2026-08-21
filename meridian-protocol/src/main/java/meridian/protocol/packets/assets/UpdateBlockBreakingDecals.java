// Auto-generated - do not edit
package meridian.protocol.packets.assets;

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
import meridian.protocol.BlockBreakingDecal;
import meridian.protocol.UpdateType;
import java.util.HashMap;

public class UpdateBlockBreakingDecals implements Packet, ToClientPacket {
    public static final int PACKET_ID = 45;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public UpdateType type = UpdateType.Init;
    @Nonnull public java.util.Map<String, BlockBreakingDecal> blockBreakingDecals = new java.util.HashMap<>();

    public UpdateBlockBreakingDecals() {
    }

    public UpdateBlockBreakingDecals(@Nonnull UpdateType type, @Nonnull java.util.Map<String, BlockBreakingDecal> blockBreakingDecals) {
        this.type = type;
        this.blockBreakingDecals = blockBreakingDecals;
    }

    public UpdateBlockBreakingDecals(@Nonnull UpdateBlockBreakingDecals other) {
        this.type = other.type;
        this.blockBreakingDecals = other.blockBreakingDecals;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateBlockBreakingDecals", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateBlockBreakingDecals", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static UpdateType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static UpdateType getType(MemorySegment mem, int offset) {
        return UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0));
    }
    
    public static java.util.Map<String, BlockBreakingDecal> getBlockBreakingDecals(MemorySegment mem) {
        return getBlockBreakingDecals(mem, 0);
    }
    
    public static java.util.Map<String, BlockBreakingDecal> getBlockBreakingDecals(MemorySegment mem, int offset) {
        var walkCursor = new ReadCursor();
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("BlockBreakingDecals");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("BlockBreakingDecals", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockBreakingDecals", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, BlockBreakingDecal> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = BlockBreakingDecal.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("BlockBreakingDecals", key);
            }
        }
        return data;
    }
    
    
    
    
    
    public static UpdateBlockBreakingDecals toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateBlockBreakingDecals toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateBlockBreakingDecals and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateBlockBreakingDecals toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        java.util.Map<String, BlockBreakingDecal> v1;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("BlockBreakingDecals");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("BlockBreakingDecals", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockBreakingDecals", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            v1 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = BlockBreakingDecal.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v1.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("BlockBreakingDecals", key);
                }
            }
            varPos = off - varBase;
        }
        var result = new UpdateBlockBreakingDecals(
            UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0)),
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, (byte) this.type.getValue());
        var varOffset = offset + 1;
        if (this.blockBreakingDecals.size() > 4096000) throw ProtocolException.dictionaryTooLarge("BlockBreakingDecals", blockBreakingDecals.size(), 4096000);
        varOffset += VarInt.set(mem, varOffset, this.blockBreakingDecals.size());
        for (var e : this.blockBreakingDecals.entrySet()) {
            varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
            varOffset += e.getValue().serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        int blockBreakingDecalsSize = 0;
for (var kvp : blockBreakingDecals.entrySet()) blockBreakingDecalsSize += PacketIO.stringSize(kvp.getKey()) + kvp.getValue().computeSize();
size += VarInt.size(blockBreakingDecals.size()) + blockBreakingDecalsSize;

        return size;
    }

    public UpdateBlockBreakingDecals clone() {
        UpdateBlockBreakingDecals copy = new UpdateBlockBreakingDecals();
        copy.type = this.type;
        {
            java.util.Map<String, BlockBreakingDecal> m = new java.util.HashMap<>();
            for (var e : this.blockBreakingDecals.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.blockBreakingDecals = m;
        }
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateBlockBreakingDecals other)) return false;
        return java.util.Objects.equals(this.type, other.type) && java.util.Objects.equals(this.blockBreakingDecals, other.blockBreakingDecals);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(type, blockBreakingDecals);
    }

}