// Auto-generated - do not edit
package meridian.protocol.packets.asseteditor;

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

public class AssetEditorFetchJsonAssetWithParentsReply implements Packet, ToClientPacket {
    public static final int PACKET_ID = 313;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 5;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int token;
    @Nullable public java.util.Map<AssetPath, String> assets;

    public AssetEditorFetchJsonAssetWithParentsReply() {
    }

    public AssetEditorFetchJsonAssetWithParentsReply(int token, @Nullable java.util.Map<AssetPath, String> assets) {
        this.token = token;
        this.assets = assets;
    }

    public AssetEditorFetchJsonAssetWithParentsReply(@Nonnull AssetEditorFetchJsonAssetWithParentsReply other) {
        this.token = other.token;
        this.assets = other.assets;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorFetchJsonAssetWithParentsReply", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorFetchJsonAssetWithParentsReply", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getToken(MemorySegment mem) {
        return getToken(mem, 0);
    }
    
    public static int getToken(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static java.util.Map<AssetPath, String> getAssets(MemorySegment mem) {
        return getAssets(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<AssetPath, String> getAssets(MemorySegment mem, int offset) {
        if (!hasAssets(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 5;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Assets");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Assets", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 10 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Assets", (int) java.lang.Math.min(off + (long) len * 10, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<AssetPath, String> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = AssetPath.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            var valuePacked = VarInt.getWithLength(mem, off);
                var value = PacketIO.readVarString("value", mem, off, 0, 4096000, valuePacked);
                off += (int) valuePacked + (int) (valuePacked >>> 32);
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Assets", key);
            }
        }
        return data;
    }
    
    public static boolean hasAssets(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static AssetEditorFetchJsonAssetWithParentsReply toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorFetchJsonAssetWithParentsReply toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorFetchJsonAssetWithParentsReply and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorFetchJsonAssetWithParentsReply toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 5;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        java.util.Map<AssetPath, String> v1 = null;
        if (hasAssets(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Assets");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Assets", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 10 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Assets", (int) java.lang.Math.min(off + (long) len * 10, Integer.MAX_VALUE), (int) mem.byteSize());
            v1 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = AssetPath.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                var valuePacked = VarInt.getWithLength(mem, off);
                    var value = PacketIO.readVarString("value", mem, off, 0, 4096000, valuePacked);
                    off += (int) valuePacked + (int) (valuePacked >>> 32);
                if (v1.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Assets", key);
                }
            }
            varPos = off - varBase;
        }
        var result = new AssetEditorFetchJsonAssetWithParentsReply(
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
        if (this.assets != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.token);
        var varOffset = offset + 5;
        if (this.assets != null) {
            
            if (this.assets.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Assets", assets.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.assets.size());
            for (var e : this.assets.entrySet()) {
                varOffset += e.getKey().serialize(mem, varOffset);
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getValue(), 4096000);
            }
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 5;
        if (assets != null) {
        int assetsSize = 0;
for (var kvp : assets.entrySet()) assetsSize += kvp.getKey().computeSize() + PacketIO.stringSize(kvp.getValue());
size += VarInt.size(assets.size()) + assetsSize;
    }

        return size;
    }

    public AssetEditorFetchJsonAssetWithParentsReply clone() {
        AssetEditorFetchJsonAssetWithParentsReply copy = new AssetEditorFetchJsonAssetWithParentsReply();
        copy.token = this.token;
        copy.assets = this.assets != null ? new java.util.HashMap<>(this.assets) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorFetchJsonAssetWithParentsReply other)) return false;
        return this.token == other.token && java.util.Objects.equals(this.assets, other.assets);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(token, assets);
    }

}