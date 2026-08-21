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


public class AssetEditorRebuildCaches {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1;

    public boolean blockTextures;
    public boolean models;
    public boolean modelTextures;
    public boolean mapGeometry;
    public boolean itemIcons;

    public AssetEditorRebuildCaches() {
    }

    public AssetEditorRebuildCaches(boolean blockTextures, boolean models, boolean modelTextures, boolean mapGeometry, boolean itemIcons) {
        this.blockTextures = blockTextures;
        this.models = models;
        this.modelTextures = modelTextures;
        this.mapGeometry = mapGeometry;
        this.itemIcons = itemIcons;
    }

    public AssetEditorRebuildCaches(@Nonnull AssetEditorRebuildCaches other) {
        this.blockTextures = other.blockTextures;
        this.models = other.models;
        this.modelTextures = other.modelTextures;
        this.mapGeometry = other.mapGeometry;
        this.itemIcons = other.itemIcons;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorRebuildCaches", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorRebuildCaches", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getBlockTextures(MemorySegment mem) {
        return getBlockTextures(mem, 0);
    }
    
    public static boolean getBlockTextures(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x01) != 0;
    }
    
    public static boolean getModels(MemorySegment mem) {
        return getModels(mem, 0);
    }
    
    public static boolean getModels(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x02) != 0;
    }
    
    public static boolean getModelTextures(MemorySegment mem) {
        return getModelTextures(mem, 0);
    }
    
    public static boolean getModelTextures(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x04) != 0;
    }
    
    public static boolean getMapGeometry(MemorySegment mem) {
        return getMapGeometry(mem, 0);
    }
    
    public static boolean getMapGeometry(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x08) != 0;
    }
    
    public static boolean getItemIcons(MemorySegment mem) {
        return getItemIcons(mem, 0);
    }
    
    public static boolean getItemIcons(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x10) != 0;
    }
    
    
    
    
    
    public static AssetEditorRebuildCaches toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorRebuildCaches toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorRebuildCaches and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorRebuildCaches toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new AssetEditorRebuildCaches(
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x04) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x08) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x10) != 0
        );
        if (cursor != null) cursor.position = offset + 1;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        byte boolBits0_0 = 0;
        if (this.blockTextures) boolBits0_0 |= 0x01;
        if (this.models) boolBits0_0 |= 0x02;
        if (this.modelTextures) boolBits0_0 |= 0x04;
        if (this.mapGeometry) boolBits0_0 |= 0x08;
        if (this.itemIcons) boolBits0_0 |= 0x10;
        mem.set(PacketIO.PROTO_BYTE, offset + 0 + 0, boolBits0_0);
        
        
    
       return 1;
    }
    public int computeSize() {
        return 1;
    }

    public AssetEditorRebuildCaches clone() {
        AssetEditorRebuildCaches copy = new AssetEditorRebuildCaches();
        copy.blockTextures = this.blockTextures;
        copy.models = this.models;
        copy.modelTextures = this.modelTextures;
        copy.mapGeometry = this.mapGeometry;
        copy.itemIcons = this.itemIcons;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorRebuildCaches other)) return false;
        return this.blockTextures == other.blockTextures && this.models == other.models && this.modelTextures == other.modelTextures && this.mapGeometry == other.mapGeometry && this.itemIcons == other.itemIcons;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(blockTextures, models, modelTextures, mapGeometry, itemIcons);
    }

}