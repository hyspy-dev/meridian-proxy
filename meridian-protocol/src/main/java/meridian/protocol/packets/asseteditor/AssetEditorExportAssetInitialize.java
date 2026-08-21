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


public class AssetEditorExportAssetInitialize implements Packet, ToClientPacket {
    public static final int PACKET_ID = 343;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 14;
    public static final int MAX_SIZE = 81920066;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public AssetEditorAsset asset;
    @Nullable public AssetPath oldPath;
    public int size;
    public boolean failed;

    public AssetEditorExportAssetInitialize() {
    }

    public AssetEditorExportAssetInitialize(@Nullable AssetEditorAsset asset, @Nullable AssetPath oldPath, int size, boolean failed) {
        this.asset = asset;
        this.oldPath = oldPath;
        this.size = size;
        this.failed = failed;
    }

    public AssetEditorExportAssetInitialize(@Nonnull AssetEditorExportAssetInitialize other) {
        this.asset = other.asset;
        this.oldPath = other.oldPath;
        this.size = other.size;
        this.failed = other.failed;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorExportAssetInitialize", offset, (int) mem.byteSize());
        long needed = (long) offset + 14;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorExportAssetInitialize", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static AssetEditorAsset getAsset(MemorySegment mem) {
        return getAsset(mem, 0);
    }
    
    @Nullable
    public static AssetEditorAsset getAsset(MemorySegment mem, int offset) {
        return hasAsset(mem, offset) ? AssetEditorAsset.toObject(mem, offset + getValidatedOffset(mem, offset, 6, 14, "Asset")): null;
    }
    
    @Nullable
    public static AssetPath getOldPath(MemorySegment mem) {
        return getOldPath(mem, 0);
    }
    
    @Nullable
    public static AssetPath getOldPath(MemorySegment mem, int offset) {
        return hasOldPath(mem, offset) ? AssetPath.toObject(mem, offset + getValidatedOffset(mem, offset, 10, 14, "OldPath")): null;
    }
    
    public static int getSize(MemorySegment mem) {
        return getSize(mem, 0);
    }
    
    public static int getSize(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static boolean getFailed(MemorySegment mem) {
        return getFailed(mem, 0);
    }
    
    public static boolean getFailed(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 5);
    }
    
    public static boolean hasAsset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasOldPath(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
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
    
    public static AssetEditorExportAssetInitialize toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorExportAssetInitialize toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorExportAssetInitialize and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorExportAssetInitialize toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 14;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        AssetEditorAsset v0 = null;
        if (hasAsset(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "Asset");
            v0 = AssetEditorAsset.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 6, -1, "Asset");
        }
        
        AssetPath v1 = null;
        if (hasOldPath(mem, offset)) {
            requireSlot(mem, offset + 10, varPos, "OldPath");
            v1 = AssetPath.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 10, -1, "OldPath");
        }
        var result = new AssetEditorExportAssetInitialize(
            v0,
            v1,
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_BOOL, offset + 5)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.asset != null) nullBits |= 0x01;
        if (this.oldPath != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.size);
        mem.set(PacketIO.PROTO_BOOL, offset + 5, this.failed);
        var varOffset = offset + 14;
        if (this.asset != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 14);
            varOffset += this.asset.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
        if (this.oldPath != null) {
            mem.set(PacketIO.PROTO_INT, offset + 10, varOffset - offset - 14);
            varOffset += this.oldPath.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 10, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 14;
        if (asset != null) size += asset.computeSize();
    if (oldPath != null) size += oldPath.computeSize();

        return size;
    }

    public AssetEditorExportAssetInitialize clone() {
        AssetEditorExportAssetInitialize copy = new AssetEditorExportAssetInitialize();
        copy.asset = this.asset != null ? this.asset.clone() : null;
        copy.oldPath = this.oldPath != null ? this.oldPath.clone() : null;
        copy.size = this.size;
        copy.failed = this.failed;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorExportAssetInitialize other)) return false;
        return java.util.Objects.equals(this.asset, other.asset) && java.util.Objects.equals(this.oldPath, other.oldPath) && this.size == other.size && this.failed == other.failed;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(asset, oldPath, size, failed);
    }

}