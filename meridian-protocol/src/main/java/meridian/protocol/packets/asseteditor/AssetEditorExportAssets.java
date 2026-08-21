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


public class AssetEditorExportAssets implements Packet, ToServerPacket {
    public static final int PACKET_ID = 342;
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

    @Nullable public AssetPath[] paths;

    public AssetEditorExportAssets() {
    }

    public AssetEditorExportAssets(@Nullable AssetPath[] paths) {
        this.paths = paths;
    }

    public AssetEditorExportAssets(@Nonnull AssetEditorExportAssets other) {
        this.paths = other.paths;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorExportAssets", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorExportAssets", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static AssetPath[] getPaths(MemorySegment mem) {
        return getPaths(mem, 0);
    }
    
    @Nullable
    public static AssetPath[] getPaths(MemorySegment mem, int offset) {
        if (!hasPaths(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Paths");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Paths", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 9 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Paths", (int) java.lang.Math.min(off + lenOffset + (long) len * 9, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new AssetPath[len];
        for (var i = 0; i < len; i++) {
            data[i] = AssetPath.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasPaths(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static AssetEditorExportAssets toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorExportAssets toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorExportAssets and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorExportAssets toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        AssetPath[] v0 = null;
        if (hasPaths(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Paths");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Paths", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 9 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Paths", (int) java.lang.Math.min(off + lenOffset + (long) len * 9, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new AssetPath[len];
            for (var i = 0; i < len; i++) {
                v0[i] = AssetPath.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new AssetEditorExportAssets(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.paths != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.paths != null) {
            
            if (paths.length > 4096000) throw ProtocolException.arrayTooLong("Paths", paths.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.paths.length);
            
            var pathsValueOffset = 0;
            for (var i = 0; i < this.paths.length; i++) {
                pathsValueOffset += this.paths[i].serialize(mem, varOffset + pathsValueOffset);
            }
            varOffset += pathsValueOffset;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (paths != null) {
        int pathsSize = 0;
for (var elem : paths) pathsSize += elem.computeSize();
size += VarInt.size(paths.length) + pathsSize;
    }

        return size;
    }

    public AssetEditorExportAssets clone() {
        AssetEditorExportAssets copy = new AssetEditorExportAssets();
        copy.paths = this.paths != null ? java.util.Arrays.stream(this.paths).map(e -> e.clone()).toArray(AssetPath[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorExportAssets other)) return false;
        return java.util.Arrays.equals(this.paths, other.paths);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(paths);
        return result;
    }

}