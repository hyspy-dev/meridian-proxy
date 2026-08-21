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


public class AssetEditorRequestAssetInheritanceReply implements Packet, ToClientPacket {
    public static final int PACKET_ID = 358;
    public static final boolean IS_COMPRESSED = false;
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
    @Nullable public AssetInheritanceTreeNode asset;

    public AssetEditorRequestAssetInheritanceReply() {
    }

    public AssetEditorRequestAssetInheritanceReply(int token, @Nullable AssetInheritanceTreeNode asset) {
        this.token = token;
        this.asset = asset;
    }

    public AssetEditorRequestAssetInheritanceReply(@Nonnull AssetEditorRequestAssetInheritanceReply other) {
        this.token = other.token;
        this.asset = other.asset;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorRequestAssetInheritanceReply", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorRequestAssetInheritanceReply", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getToken(MemorySegment mem) {
        return getToken(mem, 0);
    }
    
    public static int getToken(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static AssetInheritanceTreeNode getAsset(MemorySegment mem) {
        return getAsset(mem, 0);
    }
    
    @Nullable
    public static AssetInheritanceTreeNode getAsset(MemorySegment mem, int offset) {
        return hasAsset(mem, offset) ? AssetInheritanceTreeNode.toObject(mem, offset + 5): null;
    }
    
    public static boolean hasAsset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static AssetEditorRequestAssetInheritanceReply toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorRequestAssetInheritanceReply toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorRequestAssetInheritanceReply and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorRequestAssetInheritanceReply toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 5;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        AssetInheritanceTreeNode v1 = null;
        if (hasAsset(mem, offset)) {
            v1 = AssetInheritanceTreeNode.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new AssetEditorRequestAssetInheritanceReply(
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
        if (this.asset != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.token);
        var varOffset = offset + 5;
        if (this.asset != null) {
            
            varOffset += this.asset.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 5;
        if (asset != null) size += asset.computeSize();

        return size;
    }

    public AssetEditorRequestAssetInheritanceReply clone() {
        AssetEditorRequestAssetInheritanceReply copy = new AssetEditorRequestAssetInheritanceReply();
        copy.token = this.token;
        copy.asset = this.asset != null ? this.asset.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorRequestAssetInheritanceReply other)) return false;
        return this.token == other.token && java.util.Objects.equals(this.asset, other.asset);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(token, asset);
    }

}