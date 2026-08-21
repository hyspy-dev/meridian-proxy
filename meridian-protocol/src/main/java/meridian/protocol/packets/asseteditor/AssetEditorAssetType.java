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


public class AssetEditorAssetType {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 3;
    public static final int VARIABLE_FIELD_COUNT = 4;
    public static final int VARIABLE_BLOCK_START = 19;
    public static final int MAX_SIZE = 65536039;

    @Nullable public String id;
    @Nullable public String icon;
    public boolean isColoredIcon;
    @Nullable public String path;
    @Nullable public String fileExtension;
    @Nonnull public AssetEditorEditorType editorType = AssetEditorEditorType.None;

    public AssetEditorAssetType() {
    }

    public AssetEditorAssetType(@Nullable String id, @Nullable String icon, boolean isColoredIcon, @Nullable String path, @Nullable String fileExtension, @Nonnull AssetEditorEditorType editorType) {
        this.id = id;
        this.icon = icon;
        this.isColoredIcon = isColoredIcon;
        this.path = path;
        this.fileExtension = fileExtension;
        this.editorType = editorType;
    }

    public AssetEditorAssetType(@Nonnull AssetEditorAssetType other) {
        this.id = other.id;
        this.icon = other.icon;
        this.isColoredIcon = other.isColoredIcon;
        this.path = other.path;
        this.fileExtension = other.fileExtension;
        this.editorType = other.editorType;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorAssetType", offset, (int) mem.byteSize());
        long needed = (long) offset + 19;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorAssetType", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 3, 19, "Id"), 4096000): null;
    }
    
    @Nullable
    public static String getIcon(MemorySegment mem) {
        return getIcon(mem, 0);
    }
    
    @Nullable
    public static String getIcon(MemorySegment mem, int offset) {
        return hasIcon(mem, offset) ? PacketIO.readVarString("Icon", mem, offset + getValidatedOffset(mem, offset, 7, 19, "Icon"), 4096000): null;
    }
    
    public static boolean getIsColoredIcon(MemorySegment mem) {
        return getIsColoredIcon(mem, 0);
    }
    
    public static boolean getIsColoredIcon(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 1);
    }
    
    @Nullable
    public static String getPath(MemorySegment mem) {
        return getPath(mem, 0);
    }
    
    @Nullable
    public static String getPath(MemorySegment mem, int offset) {
        return hasPath(mem, offset) ? PacketIO.readVarString("Path", mem, offset + getValidatedOffset(mem, offset, 11, 19, "Path"), 4096000): null;
    }
    
    @Nullable
    public static String getFileExtension(MemorySegment mem) {
        return getFileExtension(mem, 0);
    }
    
    @Nullable
    public static String getFileExtension(MemorySegment mem, int offset) {
        return hasFileExtension(mem, offset) ? PacketIO.readVarString("FileExtension", mem, offset + getValidatedOffset(mem, offset, 15, 19, "FileExtension"), 4096000): null;
    }
    
    public static AssetEditorEditorType getEditorType(MemorySegment mem) {
        return getEditorType(mem, 0);
    }
    
    public static AssetEditorEditorType getEditorType(MemorySegment mem, int offset) {
        return AssetEditorEditorType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2));
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasIcon(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasPath(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasFileExtension(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    private static int getValidatedOffset(MemorySegment buffer, int base, int slotPosition, int varBlockStart, String fieldName) {
        int offset = buffer.get(PacketIO.PROTO_INT, base + slotPosition);
        if (offset < 0 || offset > buffer.byteSize() - base - varBlockStart)
            throw ProtocolException.invalidOffset(fieldName, offset, (int) buffer.byteSize());
        return varBlockStart + offset;
    }
    
    /**
     * Rejects an offset slot that does not name the position the field-order walk reached. A
     * present field must sit where the previous field ended, and an absent field carries -1, so
     * the slot a random-access getter resolves and the walk describe the same bytes.
     */
    private static void requireSlot(MemorySegment mem, int slotPosition, int expected, String fieldName) {
        int slot = mem.get(PacketIO.PROTO_INT, slotPosition);
        if (slot != expected) throw ProtocolException.nonCanonicalLayout(fieldName, slot, expected);
    }
    
    public static AssetEditorAssetType toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorAssetType toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorAssetType and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorAssetType toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 19;
        var varPos = 0;
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 3, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 3, -1, "Id");
        }
        
        String v1 = null;
        if (hasIcon(mem, offset)) {
            requireSlot(mem, offset + 7, varPos, "Icon");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Icon", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 7, -1, "Icon");
        }
        
        String v3 = null;
        if (hasPath(mem, offset)) {
            requireSlot(mem, offset + 11, varPos, "Path");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readVarString("Path", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 11, -1, "Path");
        }
        
        String v4 = null;
        if (hasFileExtension(mem, offset)) {
            requireSlot(mem, offset + 15, varPos, "FileExtension");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v4 = PacketIO.readVarString("FileExtension", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 15, -1, "FileExtension");
        }
        var result = new AssetEditorAssetType(
            v0,
            v1,
            mem.get(PacketIO.PROTO_BOOL, offset + 1),
            v3,
            v4,
            AssetEditorEditorType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2))
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        if (this.icon != null) nullBits |= 0x02;
        if (this.path != null) nullBits |= 0x04;
        if (this.fileExtension != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BOOL, offset + 1, this.isColoredIcon);
        mem.set(PacketIO.PROTO_BYTE, offset + 2, (byte) this.editorType.getValue());
        var varOffset = offset + 19;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 3, varOffset - offset - 19);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 3, -1);
        }
        if (this.icon != null) {
            mem.set(PacketIO.PROTO_INT, offset + 7, varOffset - offset - 19);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.icon, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 7, -1);
        }
        if (this.path != null) {
            mem.set(PacketIO.PROTO_INT, offset + 11, varOffset - offset - 19);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.path, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 11, -1);
        }
        if (this.fileExtension != null) {
            mem.set(PacketIO.PROTO_INT, offset + 15, varOffset - offset - 19);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.fileExtension, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 15, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 19;
        if (id != null) size += PacketIO.stringSize(id);
    if (icon != null) size += PacketIO.stringSize(icon);
    if (path != null) size += PacketIO.stringSize(path);
    if (fileExtension != null) size += PacketIO.stringSize(fileExtension);

        return size;
    }

    public AssetEditorAssetType clone() {
        AssetEditorAssetType copy = new AssetEditorAssetType();
        copy.id = this.id;
        copy.icon = this.icon;
        copy.isColoredIcon = this.isColoredIcon;
        copy.path = this.path;
        copy.fileExtension = this.fileExtension;
        copy.editorType = this.editorType;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorAssetType other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.icon, other.icon) && this.isColoredIcon == other.isColoredIcon && java.util.Objects.equals(this.path, other.path) && java.util.Objects.equals(this.fileExtension, other.fileExtension) && java.util.Objects.equals(this.editorType, other.editorType);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, icon, isColoredIcon, path, fileExtension, editorType);
    }

}