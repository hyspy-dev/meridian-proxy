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


public class AssetEditorFetchAssetReply implements Packet, ToClientPacket {
    public static final int PACKET_ID = 312;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 5;
    public static final int MAX_SIZE = 4096010;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int token;
    @Nullable public byte[] contents;

    public AssetEditorFetchAssetReply() {
    }

    public AssetEditorFetchAssetReply(int token, @Nullable byte[] contents) {
        this.token = token;
        this.contents = contents;
    }

    public AssetEditorFetchAssetReply(@Nonnull AssetEditorFetchAssetReply other) {
        this.token = other.token;
        this.contents = other.contents;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorFetchAssetReply", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorFetchAssetReply", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getToken(MemorySegment mem) {
        return getToken(mem, 0);
    }
    
    public static int getToken(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static byte[] getContents(MemorySegment mem) {
        return getContents(mem, 0);
    }
    
    @Nullable
    public static byte[] getContents(MemorySegment mem, int offset) {
        if (!hasContents(mem, offset)) return null;
        var off = offset + 5;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Contents");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Contents", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Contents", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new byte[len];
        MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, data, 0, len);
        return data;
    }
    
    public static boolean hasContents(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static AssetEditorFetchAssetReply toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorFetchAssetReply toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorFetchAssetReply and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorFetchAssetReply toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 5;
        var varPos = 0;
        byte[] v1 = null;
        if (hasContents(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Contents");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Contents", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Contents", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v1, 0, len);
            varPos = off + len - varBase;
        }
        var result = new AssetEditorFetchAssetReply(
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
        if (this.contents != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.token);
        var varOffset = offset + 5;
        if (this.contents != null) {
            
            if (contents.length > 4096000) throw ProtocolException.arrayTooLong("Contents", contents.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.contents.length);
            
            MemorySegment.copy(this.contents, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.contents.length);
            varOffset += this.contents.length * 1;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 5;
        if (contents != null) size += VarInt.size(contents.length) + contents.length * 1;

        return size;
    }

    public AssetEditorFetchAssetReply clone() {
        AssetEditorFetchAssetReply copy = new AssetEditorFetchAssetReply();
        copy.token = this.token;
        copy.contents = this.contents != null ? java.util.Arrays.copyOf(this.contents, this.contents.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorFetchAssetReply other)) return false;
        return this.token == other.token && java.util.Arrays.equals(this.contents, other.contents);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(token);
        result = 31 * result + java.util.Arrays.hashCode(contents);
        return result;
    }

}