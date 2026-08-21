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


public class AssetEditorCreateAssetPack implements Packet, ToServerPacket {
    public static final int PACKET_ID = 316;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 9;
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
    @Nullable public AssetPackManifest manifest;
    public int targetDirectoryIndex;

    public AssetEditorCreateAssetPack() {
    }

    public AssetEditorCreateAssetPack(int token, @Nullable AssetPackManifest manifest, int targetDirectoryIndex) {
        this.token = token;
        this.manifest = manifest;
        this.targetDirectoryIndex = targetDirectoryIndex;
    }

    public AssetEditorCreateAssetPack(@Nonnull AssetEditorCreateAssetPack other) {
        this.token = other.token;
        this.manifest = other.manifest;
        this.targetDirectoryIndex = other.targetDirectoryIndex;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorCreateAssetPack", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorCreateAssetPack", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getToken(MemorySegment mem) {
        return getToken(mem, 0);
    }
    
    public static int getToken(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static AssetPackManifest getManifest(MemorySegment mem) {
        return getManifest(mem, 0);
    }
    
    @Nullable
    public static AssetPackManifest getManifest(MemorySegment mem, int offset) {
        return hasManifest(mem, offset) ? AssetPackManifest.toObject(mem, offset + 9): null;
    }
    
    public static int getTargetDirectoryIndex(MemorySegment mem) {
        return getTargetDirectoryIndex(mem, 0);
    }
    
    public static int getTargetDirectoryIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static boolean hasManifest(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static AssetEditorCreateAssetPack toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorCreateAssetPack toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorCreateAssetPack and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorCreateAssetPack toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        AssetPackManifest v1 = null;
        if (hasManifest(mem, offset)) {
            v1 = AssetPackManifest.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new AssetEditorCreateAssetPack(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v1,
            mem.get(PacketIO.PROTO_INT, offset + 5)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.manifest != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.token);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.targetDirectoryIndex);
        var varOffset = offset + 9;
        if (this.manifest != null) {
            
            varOffset += this.manifest.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (manifest != null) size += manifest.computeSize();

        return size;
    }

    public AssetEditorCreateAssetPack clone() {
        AssetEditorCreateAssetPack copy = new AssetEditorCreateAssetPack();
        copy.token = this.token;
        copy.manifest = this.manifest != null ? this.manifest.clone() : null;
        copy.targetDirectoryIndex = this.targetDirectoryIndex;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorCreateAssetPack other)) return false;
        return this.token == other.token && java.util.Objects.equals(this.manifest, other.manifest) && this.targetDirectoryIndex == other.targetDirectoryIndex;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(token, manifest, targetDirectoryIndex);
    }

}