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
import meridian.protocol.BlockType;
import meridian.protocol.UpdateType;
import java.util.HashMap;

public class UpdateBlockTypes implements Packet, ToClientPacket {
    public static final int PACKET_ID = 40;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 7;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 7;
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
    @Nullable public java.util.Map<Integer, BlockType> blockTypes;
    public boolean updateBlockTextures;
    public boolean updateModelTextures;
    public boolean updateModels;
    public boolean updateMapGeometry;

    public UpdateBlockTypes() {
    }

    public UpdateBlockTypes(@Nonnull UpdateType type, int maxId, @Nullable java.util.Map<Integer, BlockType> blockTypes, boolean updateBlockTextures, boolean updateModelTextures, boolean updateModels, boolean updateMapGeometry) {
        this.type = type;
        this.maxId = maxId;
        this.blockTypes = blockTypes;
        this.updateBlockTextures = updateBlockTextures;
        this.updateModelTextures = updateModelTextures;
        this.updateModels = updateModels;
        this.updateMapGeometry = updateMapGeometry;
    }

    public UpdateBlockTypes(@Nonnull UpdateBlockTypes other) {
        this.type = other.type;
        this.maxId = other.maxId;
        this.blockTypes = other.blockTypes;
        this.updateBlockTextures = other.updateBlockTextures;
        this.updateModelTextures = other.updateModelTextures;
        this.updateModels = other.updateModels;
        this.updateMapGeometry = other.updateMapGeometry;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateBlockTypes", offset, (int) mem.byteSize());
        long needed = (long) offset + 7;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateBlockTypes", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
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
    public static java.util.Map<Integer, BlockType> getBlockTypes(MemorySegment mem) {
        return getBlockTypes(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Integer, BlockType> getBlockTypes(MemorySegment mem, int offset) {
        if (!hasBlockTypes(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 7;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("BlockTypes");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("BlockTypes", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 281 > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockTypes", (int) java.lang.Math.min(off + (long) len * 281, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Integer, BlockType> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            var value = BlockType.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("BlockTypes", key);
            }
        }
        return data;
    }
    
    public static boolean getUpdateBlockTextures(MemorySegment mem) {
        return getUpdateBlockTextures(mem, 0);
    }
    
    public static boolean getUpdateBlockTextures(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x01) != 0;
    }
    
    public static boolean getUpdateModelTextures(MemorySegment mem) {
        return getUpdateModelTextures(mem, 0);
    }
    
    public static boolean getUpdateModelTextures(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x02) != 0;
    }
    
    public static boolean getUpdateModels(MemorySegment mem) {
        return getUpdateModels(mem, 0);
    }
    
    public static boolean getUpdateModels(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x04) != 0;
    }
    
    public static boolean getUpdateMapGeometry(MemorySegment mem) {
        return getUpdateMapGeometry(mem, 0);
    }
    
    public static boolean getUpdateMapGeometry(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x08) != 0;
    }
    
    public static boolean hasBlockTypes(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static UpdateBlockTypes toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateBlockTypes toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateBlockTypes and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateBlockTypes toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 7;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        java.util.Map<Integer, BlockType> v2 = null;
        if (hasBlockTypes(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("BlockTypes");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("BlockTypes", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 281 > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockTypes", (int) java.lang.Math.min(off + (long) len * 281, Integer.MAX_VALUE), (int) mem.byteSize());
            v2 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                var value = BlockType.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v2.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("BlockTypes", key);
                }
            }
            varPos = off - varBase;
        }
        var result = new UpdateBlockTypes(
            UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            mem.get(PacketIO.PROTO_INT, offset + 2),
            v2,
            (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x04) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x08) != 0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.blockTypes != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 2, this.maxId);
        byte boolBits0_0 = 0;
        if (this.updateBlockTextures) boolBits0_0 |= 0x01;
        if (this.updateModelTextures) boolBits0_0 |= 0x02;
        if (this.updateModels) boolBits0_0 |= 0x04;
        if (this.updateMapGeometry) boolBits0_0 |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 6 + 0, boolBits0_0);
        var varOffset = offset + 7;
        if (this.blockTypes != null) {
            
            if (this.blockTypes.size() > 4096000) throw ProtocolException.dictionaryTooLarge("BlockTypes", blockTypes.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.blockTypes.size());
            for (var e : this.blockTypes.entrySet()) {
                mem.set(PacketIO.PROTO_INT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 7;
        if (blockTypes != null) {
        int blockTypesSize = 0;
for (var kvp : blockTypes.entrySet()) blockTypesSize += 4 + kvp.getValue().computeSize();
size += VarInt.size(blockTypes.size()) + blockTypesSize;
    }

        return size;
    }

    public UpdateBlockTypes clone() {
        UpdateBlockTypes copy = new UpdateBlockTypes();
        copy.type = this.type;
        copy.maxId = this.maxId;
        if (this.blockTypes != null) {
            java.util.Map<Integer, BlockType> m = new java.util.HashMap<>();
            for (var e : this.blockTypes.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.blockTypes = m;
        }
        copy.updateBlockTextures = this.updateBlockTextures;
        copy.updateModelTextures = this.updateModelTextures;
        copy.updateModels = this.updateModels;
        copy.updateMapGeometry = this.updateMapGeometry;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateBlockTypes other)) return false;
        return java.util.Objects.equals(this.type, other.type) && this.maxId == other.maxId && java.util.Objects.equals(this.blockTypes, other.blockTypes) && this.updateBlockTextures == other.updateBlockTextures && this.updateModelTextures == other.updateModelTextures && this.updateModels == other.updateModels && this.updateMapGeometry == other.updateMapGeometry;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(type, maxId, blockTypes, updateBlockTextures, updateModelTextures, updateModels, updateMapGeometry);
    }

}