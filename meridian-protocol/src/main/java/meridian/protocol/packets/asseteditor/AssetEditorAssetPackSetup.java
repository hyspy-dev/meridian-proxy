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

public class AssetEditorAssetPackSetup implements Packet, ToClientPacket {
    public static final int PACKET_ID = 314;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
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

    @Nullable public java.util.Map<String, AssetPackManifest> packs;

    public AssetEditorAssetPackSetup() {
    }

    public AssetEditorAssetPackSetup(@Nullable java.util.Map<String, AssetPackManifest> packs) {
        this.packs = packs;
    }

    public AssetEditorAssetPackSetup(@Nonnull AssetEditorAssetPackSetup other) {
        this.packs = other.packs;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorAssetPackSetup", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorAssetPackSetup", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static java.util.Map<String, AssetPackManifest> getPacks(MemorySegment mem) {
        return getPacks(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, AssetPackManifest> getPacks(MemorySegment mem, int offset) {
        if (!hasPacks(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Packs");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Packs", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 30 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Packs", (int) java.lang.Math.min(off + (long) len * 30, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, AssetPackManifest> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = AssetPackManifest.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Packs", key);
            }
        }
        return data;
    }
    
    public static boolean hasPacks(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static AssetEditorAssetPackSetup toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorAssetPackSetup toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorAssetPackSetup and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorAssetPackSetup toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        java.util.Map<String, AssetPackManifest> v0 = null;
        if (hasPacks(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Packs");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Packs", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 30 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Packs", (int) java.lang.Math.min(off + (long) len * 30, Integer.MAX_VALUE), (int) mem.byteSize());
            v0 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = AssetPackManifest.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v0.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Packs", key);
                }
            }
            varPos = off - varBase;
        }
        var result = new AssetEditorAssetPackSetup(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.packs != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.packs != null) {
            
            if (this.packs.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Packs", packs.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.packs.size());
            for (var e : this.packs.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (packs != null) {
        int packsSize = 0;
for (var kvp : packs.entrySet()) packsSize += PacketIO.stringSize(kvp.getKey()) + kvp.getValue().computeSize();
size += VarInt.size(packs.size()) + packsSize;
    }

        return size;
    }

    public AssetEditorAssetPackSetup clone() {
        AssetEditorAssetPackSetup copy = new AssetEditorAssetPackSetup();
        if (this.packs != null) {
            java.util.Map<String, AssetPackManifest> m = new java.util.HashMap<>();
            for (var e : this.packs.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.packs = m;
        }
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorAssetPackSetup other)) return false;
        return java.util.Objects.equals(this.packs, other.packs);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(packs);
    }

}