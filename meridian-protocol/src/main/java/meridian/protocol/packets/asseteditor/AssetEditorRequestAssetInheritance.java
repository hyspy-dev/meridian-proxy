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


public class AssetEditorRequestAssetInheritance implements Packet, ToServerPacket {
    public static final int PACKET_ID = 357;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 5;
    public static final int MAX_SIZE = 32768024;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int token;
    @Nullable public AssetPath assetPath;

    public AssetEditorRequestAssetInheritance() {
    }

    public AssetEditorRequestAssetInheritance(int token, @Nullable AssetPath assetPath) {
        this.token = token;
        this.assetPath = assetPath;
    }

    public AssetEditorRequestAssetInheritance(@Nonnull AssetEditorRequestAssetInheritance other) {
        this.token = other.token;
        this.assetPath = other.assetPath;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorRequestAssetInheritance", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorRequestAssetInheritance", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getToken(MemorySegment mem) {
        return getToken(mem, 0);
    }
    
    public static int getToken(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static AssetPath getAssetPath(MemorySegment mem) {
        return getAssetPath(mem, 0);
    }
    
    @Nullable
    public static AssetPath getAssetPath(MemorySegment mem, int offset) {
        return hasAssetPath(mem, offset) ? AssetPath.toObject(mem, offset + 5): null;
    }
    
    public static boolean hasAssetPath(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static AssetEditorRequestAssetInheritance toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorRequestAssetInheritance toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorRequestAssetInheritance and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorRequestAssetInheritance toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 5;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        AssetPath v1 = null;
        if (hasAssetPath(mem, offset)) {
            v1 = AssetPath.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new AssetEditorRequestAssetInheritance(
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
        if (this.assetPath != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.token);
        var varOffset = offset + 5;
        if (this.assetPath != null) {
            
            varOffset += this.assetPath.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 5;
        if (assetPath != null) size += assetPath.computeSize();

        return size;
    }

    public AssetEditorRequestAssetInheritance clone() {
        AssetEditorRequestAssetInheritance copy = new AssetEditorRequestAssetInheritance();
        copy.token = this.token;
        copy.assetPath = this.assetPath != null ? this.assetPath.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorRequestAssetInheritance other)) return false;
        return this.token == other.token && java.util.Objects.equals(this.assetPath, other.assetPath);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(token, assetPath);
    }

}