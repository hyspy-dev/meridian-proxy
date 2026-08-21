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


public class AssetEditorFetchAsset implements Packet, ToServerPacket {
    public static final int PACKET_ID = 310;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 6;
    public static final int MAX_SIZE = 32768025;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int token;
    @Nullable public AssetPath path;
    public boolean isFromOpenedTab;

    public AssetEditorFetchAsset() {
    }

    public AssetEditorFetchAsset(int token, @Nullable AssetPath path, boolean isFromOpenedTab) {
        this.token = token;
        this.path = path;
        this.isFromOpenedTab = isFromOpenedTab;
    }

    public AssetEditorFetchAsset(@Nonnull AssetEditorFetchAsset other) {
        this.token = other.token;
        this.path = other.path;
        this.isFromOpenedTab = other.isFromOpenedTab;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorFetchAsset", offset, (int) mem.byteSize());
        long needed = (long) offset + 6;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorFetchAsset", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getToken(MemorySegment mem) {
        return getToken(mem, 0);
    }
    
    public static int getToken(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static AssetPath getPath(MemorySegment mem) {
        return getPath(mem, 0);
    }
    
    @Nullable
    public static AssetPath getPath(MemorySegment mem, int offset) {
        return hasPath(mem, offset) ? AssetPath.toObject(mem, offset + 6): null;
    }
    
    public static boolean getIsFromOpenedTab(MemorySegment mem) {
        return getIsFromOpenedTab(mem, 0);
    }
    
    public static boolean getIsFromOpenedTab(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 5);
    }
    
    public static boolean hasPath(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static AssetEditorFetchAsset toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorFetchAsset toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorFetchAsset and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorFetchAsset toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 6;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        AssetPath v1 = null;
        if (hasPath(mem, offset)) {
            v1 = AssetPath.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new AssetEditorFetchAsset(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v1,
            mem.get(PacketIO.PROTO_BOOL, offset + 5)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.path != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.token);
        mem.set(PacketIO.PROTO_BOOL, offset + 5, this.isFromOpenedTab);
        var varOffset = offset + 6;
        if (this.path != null) {
            
            varOffset += this.path.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 6;
        if (path != null) size += path.computeSize();

        return size;
    }

    public AssetEditorFetchAsset clone() {
        AssetEditorFetchAsset copy = new AssetEditorFetchAsset();
        copy.token = this.token;
        copy.path = this.path != null ? this.path.clone() : null;
        copy.isFromOpenedTab = this.isFromOpenedTab;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorFetchAsset other)) return false;
        return this.token == other.token && java.util.Objects.equals(this.path, other.path) && this.isFromOpenedTab == other.isFromOpenedTab;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(token, path, isFromOpenedTab);
    }

}