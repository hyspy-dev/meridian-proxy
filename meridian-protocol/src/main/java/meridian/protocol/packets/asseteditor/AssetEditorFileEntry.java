// Auto-generated - do not edit
package meridian.protocol.packets.asseteditor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class AssetEditorFileEntry {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 2;
    public static final int MAX_SIZE = 16384007;

    @Nullable public String path;
    public boolean isDirectory;

    public AssetEditorFileEntry() {
    }

    public AssetEditorFileEntry(@Nullable String path, boolean isDirectory) {
        this.path = path;
        this.isDirectory = isDirectory;
    }

    public AssetEditorFileEntry(@Nonnull AssetEditorFileEntry other) {
        this.path = other.path;
        this.isDirectory = other.isDirectory;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorFileEntry", offset, (int) mem.byteSize());
        long needed = (long) offset + 2;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorFileEntry", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getPath(MemorySegment mem) {
        return getPath(mem, 0);
    }
    
    @Nullable
    public static String getPath(MemorySegment mem, int offset) {
        return hasPath(mem, offset) ? PacketIO.readVarString("Path", mem, offset + 2, 4096000): null;
    }
    
    public static boolean getIsDirectory(MemorySegment mem) {
        return getIsDirectory(mem, 0);
    }
    
    public static boolean getIsDirectory(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 1);
    }
    
    public static boolean hasPath(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static AssetEditorFileEntry toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorFileEntry toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorFileEntry and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorFileEntry toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 2;
        var varPos = 0;
        String v0 = null;
        if (hasPath(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Path", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new AssetEditorFileEntry(
            v0,
            mem.get(PacketIO.PROTO_BOOL, offset + 1)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.path != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BOOL, offset + 1, this.isDirectory);
        var varOffset = offset + 2;
        if (this.path != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.path, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 2;
        if (path != null) size += PacketIO.stringSize(path);

        return size;
    }

    public AssetEditorFileEntry clone() {
        AssetEditorFileEntry copy = new AssetEditorFileEntry();
        copy.path = this.path;
        copy.isDirectory = this.isDirectory;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorFileEntry other)) return false;
        return java.util.Objects.equals(this.path, other.path) && this.isDirectory == other.isDirectory;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(path, isDirectory);
    }

}