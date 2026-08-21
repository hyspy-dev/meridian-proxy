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


public class AssetEditorSetupAssetTypes implements Packet, ToClientPacket {
    public static final int PACKET_ID = 306;
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

    @Nullable public AssetEditorAssetType[] assetTypes;

    public AssetEditorSetupAssetTypes() {
    }

    public AssetEditorSetupAssetTypes(@Nullable AssetEditorAssetType[] assetTypes) {
        this.assetTypes = assetTypes;
    }

    public AssetEditorSetupAssetTypes(@Nonnull AssetEditorSetupAssetTypes other) {
        this.assetTypes = other.assetTypes;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorSetupAssetTypes", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorSetupAssetTypes", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static AssetEditorAssetType[] getAssetTypes(MemorySegment mem) {
        return getAssetTypes(mem, 0);
    }
    
    @Nullable
    public static AssetEditorAssetType[] getAssetTypes(MemorySegment mem, int offset) {
        if (!hasAssetTypes(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("AssetTypes");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("AssetTypes", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 19 > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetTypes", (int) java.lang.Math.min(off + lenOffset + (long) len * 19, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new AssetEditorAssetType[len];
        for (var i = 0; i < len; i++) {
            data[i] = AssetEditorAssetType.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasAssetTypes(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static AssetEditorSetupAssetTypes toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorSetupAssetTypes toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorSetupAssetTypes and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorSetupAssetTypes toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        AssetEditorAssetType[] v0 = null;
        if (hasAssetTypes(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("AssetTypes");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("AssetTypes", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 19 > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetTypes", (int) java.lang.Math.min(off + lenOffset + (long) len * 19, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new AssetEditorAssetType[len];
            for (var i = 0; i < len; i++) {
                v0[i] = AssetEditorAssetType.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new AssetEditorSetupAssetTypes(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.assetTypes != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.assetTypes != null) {
            
            if (assetTypes.length > 4096000) throw ProtocolException.arrayTooLong("AssetTypes", assetTypes.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.assetTypes.length);
            
            var assetTypesValueOffset = 0;
            for (var i = 0; i < this.assetTypes.length; i++) {
                assetTypesValueOffset += this.assetTypes[i].serialize(mem, varOffset + assetTypesValueOffset);
            }
            varOffset += assetTypesValueOffset;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (assetTypes != null) {
        int assetTypesSize = 0;
for (var elem : assetTypes) assetTypesSize += elem.computeSize();
size += VarInt.size(assetTypes.length) + assetTypesSize;
    }

        return size;
    }

    public AssetEditorSetupAssetTypes clone() {
        AssetEditorSetupAssetTypes copy = new AssetEditorSetupAssetTypes();
        copy.assetTypes = this.assetTypes != null ? java.util.Arrays.stream(this.assetTypes).map(e -> e.clone()).toArray(AssetEditorAssetType[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorSetupAssetTypes other)) return false;
        return java.util.Arrays.equals(this.assetTypes, other.assetTypes);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(assetTypes);
        return result;
    }

}