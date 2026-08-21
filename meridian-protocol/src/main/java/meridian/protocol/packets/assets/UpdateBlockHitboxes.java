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
import meridian.protocol.Hitbox;
import meridian.protocol.UpdateType;
import java.util.HashMap;

public class UpdateBlockHitboxes implements Packet, ToClientPacket {
    public static final int PACKET_ID = 41;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 6;
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
    public int maxId;
    @Nullable public java.util.Map<Integer, Hitbox[]> blockBaseHitboxes;

    public UpdateBlockHitboxes() {
    }

    public UpdateBlockHitboxes(@Nonnull UpdateType type, int maxId, @Nullable java.util.Map<Integer, Hitbox[]> blockBaseHitboxes) {
        this.type = type;
        this.maxId = maxId;
        this.blockBaseHitboxes = blockBaseHitboxes;
    }

    public UpdateBlockHitboxes(@Nonnull UpdateBlockHitboxes other) {
        this.type = other.type;
        this.maxId = other.maxId;
        this.blockBaseHitboxes = other.blockBaseHitboxes;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateBlockHitboxes", offset, (int) mem.byteSize());
        long needed = (long) offset + 6;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateBlockHitboxes", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static UpdateType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static UpdateType getType(MemorySegment mem, int offset) {
        return UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static int getMaxId(MemorySegment mem) {
        return getMaxId(mem, 0);
    }
    
    public static int getMaxId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 2);
    }
    
    @Nullable
    public static java.util.Map<Integer, Hitbox[]> getBlockBaseHitboxes(MemorySegment mem) {
        return getBlockBaseHitboxes(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Integer, Hitbox[]> getBlockBaseHitboxes(MemorySegment mem, int offset) {
        if (!hasBlockBaseHitboxes(mem, offset)) return null;
        var off = offset + 6;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("BlockBaseHitboxes");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("BlockBaseHitboxes", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockBaseHitboxes", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Integer, Hitbox[]> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            var valuePacked = VarInt.getWithLength(mem, off);
                if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                var valueLen = (int) valuePacked;
                var valueVarLen = (int) (valuePacked >>> 32);
                if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                if (off + valueVarLen + (long) valueLen * 24 > mem.byteSize())
                    throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 24, (int) mem.byteSize());
                off += valueVarLen;
                var value = new Hitbox[valueLen];
                for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                    value[valueIdx] = Hitbox.toObject(mem, off);
                    off += 24;
                }
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("BlockBaseHitboxes", key);
            }
        }
        return data;
    }
    
    public static boolean hasBlockBaseHitboxes(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static UpdateBlockHitboxes toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateBlockHitboxes toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateBlockHitboxes and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateBlockHitboxes toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 6;
        var varPos = 0;
        java.util.Map<Integer, Hitbox[]> v2 = null;
        if (hasBlockBaseHitboxes(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("BlockBaseHitboxes");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("BlockBaseHitboxes", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockBaseHitboxes", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v2 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                var valuePacked = VarInt.getWithLength(mem, off);
                    if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                    var valueLen = (int) valuePacked;
                    var valueVarLen = (int) (valuePacked >>> 32);
                    if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                    if (off + valueVarLen + (long) valueLen * 24 > mem.byteSize())
                        throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 24, (int) mem.byteSize());
                    off += valueVarLen;
                    var value = new Hitbox[valueLen];
                    for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                        value[valueIdx] = Hitbox.toObject(mem, off);
                        off += 24;
                    }
                if (v2.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("BlockBaseHitboxes", key);
                }
            }
            varPos = off - varBase;
        }
        var result = new UpdateBlockHitboxes(
            UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            mem.get(PacketIO.PROTO_INT, offset + 2),
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.blockBaseHitboxes != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 2, this.maxId);
        var varOffset = offset + 6;
        if (this.blockBaseHitboxes != null) {
            
            if (this.blockBaseHitboxes.size() > 4096000) throw ProtocolException.dictionaryTooLarge("BlockBaseHitboxes", blockBaseHitboxes.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.blockBaseHitboxes.size());
            for (var e : this.blockBaseHitboxes.entrySet()) {
                mem.set(PacketIO.PROTO_INT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += VarInt.set(mem, varOffset, e.getValue().length);
                for (var arrItem : e.getValue()) {
                    varOffset += arrItem.serialize(mem, varOffset);
                }
            }
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 6;
        if (blockBaseHitboxes != null) {
        int blockBaseHitboxesSize = 0;
for (var kvp : blockBaseHitboxes.entrySet()) blockBaseHitboxesSize += 4 + VarInt.size(kvp.getValue().length) + kvp.getValue().length * 24;
size += VarInt.size(blockBaseHitboxes.size()) + blockBaseHitboxesSize;
    }

        return size;
    }

    public UpdateBlockHitboxes clone() {
        UpdateBlockHitboxes copy = new UpdateBlockHitboxes();
        copy.type = this.type;
        copy.maxId = this.maxId;
        if (this.blockBaseHitboxes != null) {
            java.util.Map<Integer, Hitbox[]> m = new java.util.HashMap<>();
            for (var e : this.blockBaseHitboxes.entrySet()) { m.put(e.getKey(), java.util.Arrays.stream(e.getValue()).map(x -> x.clone()).toArray(Hitbox[]::new)); }
            copy.blockBaseHitboxes = m;
        }
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateBlockHitboxes other)) return false;
        return java.util.Objects.equals(this.type, other.type) && this.maxId == other.maxId && java.util.Objects.equals(this.blockBaseHitboxes, other.blockBaseHitboxes);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(type, maxId, blockBaseHitboxes);
    }

}