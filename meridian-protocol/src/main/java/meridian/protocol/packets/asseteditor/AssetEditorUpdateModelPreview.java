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
import meridian.protocol.BlockType;
import meridian.protocol.Model;

public class AssetEditorUpdateModelPreview implements Packet, ToClientPacket {
    public static final int PACKET_ID = 355;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 29;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 41;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public AssetPath assetPath;
    @Nullable public Model model;
    @Nullable public BlockType block;
    @Nullable public AssetEditorPreviewCameraSettings camera;

    public AssetEditorUpdateModelPreview() {
    }

    public AssetEditorUpdateModelPreview(@Nullable AssetPath assetPath, @Nullable Model model, @Nullable BlockType block, @Nullable AssetEditorPreviewCameraSettings camera) {
        this.assetPath = assetPath;
        this.model = model;
        this.block = block;
        this.camera = camera;
    }

    public AssetEditorUpdateModelPreview(@Nonnull AssetEditorUpdateModelPreview other) {
        this.assetPath = other.assetPath;
        this.model = other.model;
        this.block = other.block;
        this.camera = other.camera;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorUpdateModelPreview", offset, (int) mem.byteSize());
        long needed = (long) offset + 41;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorUpdateModelPreview", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static AssetPath getAssetPath(MemorySegment mem) {
        return getAssetPath(mem, 0);
    }
    
    @Nullable
    public static AssetPath getAssetPath(MemorySegment mem, int offset) {
        return hasAssetPath(mem, offset) ? AssetPath.toObject(mem, offset + getValidatedOffset(mem, offset, 29, 41, "AssetPath")): null;
    }
    
    @Nullable
    public static Model getModel(MemorySegment mem) {
        return getModel(mem, 0);
    }
    
    @Nullable
    public static Model getModel(MemorySegment mem, int offset) {
        return hasModel(mem, offset) ? Model.toObject(mem, offset + getValidatedOffset(mem, offset, 33, 41, "Model")): null;
    }
    
    @Nullable
    public static BlockType getBlock(MemorySegment mem) {
        return getBlock(mem, 0);
    }
    
    @Nullable
    public static BlockType getBlock(MemorySegment mem, int offset) {
        return hasBlock(mem, offset) ? BlockType.toObject(mem, offset + getValidatedOffset(mem, offset, 37, 41, "Block")): null;
    }
    
    @Nullable
    public static AssetEditorPreviewCameraSettings getCamera(MemorySegment mem) {
        return getCamera(mem, 0);
    }
    
    @Nullable
    public static AssetEditorPreviewCameraSettings getCamera(MemorySegment mem, int offset) {
        return hasCamera(mem, offset) ? AssetEditorPreviewCameraSettings.toObject(mem, offset + 1): null;
    }
    
    public static boolean hasCamera(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasAssetPath(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasModel(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasBlock(MemorySegment mem, int offset) {
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
    
    public static AssetEditorUpdateModelPreview toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorUpdateModelPreview toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorUpdateModelPreview and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorUpdateModelPreview toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 41;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        AssetPath v0 = null;
        if (hasAssetPath(mem, offset)) {
            requireSlot(mem, offset + 29, varPos, "AssetPath");
            v0 = AssetPath.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 29, -1, "AssetPath");
        }
        
        Model v1 = null;
        if (hasModel(mem, offset)) {
            requireSlot(mem, offset + 33, varPos, "Model");
            v1 = Model.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 33, -1, "Model");
        }
        
        BlockType v2 = null;
        if (hasBlock(mem, offset)) {
            requireSlot(mem, offset + 37, varPos, "Block");
            v2 = BlockType.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 37, -1, "Block");
        }
        var result = new AssetEditorUpdateModelPreview(
            v0,
            v1,
            v2,
            hasCamera(mem, offset) ? AssetEditorPreviewCameraSettings.toObject(mem, offset + 1) : null
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.camera != null) nullBits |= 0x01;
        if (this.assetPath != null) nullBits |= 0x02;
        if (this.model != null) nullBits |= 0x04;
        if (this.block != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.camera != null) {
            this.camera.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 28).fill((byte) 0); 
        }
        var varOffset = offset + 41;
        if (this.assetPath != null) {
            mem.set(PacketIO.PROTO_INT, offset + 29, varOffset - offset - 41);
            varOffset += this.assetPath.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 29, -1);
        }
        if (this.model != null) {
            mem.set(PacketIO.PROTO_INT, offset + 33, varOffset - offset - 41);
            varOffset += this.model.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 33, -1);
        }
        if (this.block != null) {
            mem.set(PacketIO.PROTO_INT, offset + 37, varOffset - offset - 41);
            varOffset += this.block.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 37, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 41;
        if (assetPath != null) size += assetPath.computeSize();
    if (model != null) size += model.computeSize();
    if (block != null) size += block.computeSize();

        return size;
    }

    public AssetEditorUpdateModelPreview clone() {
        AssetEditorUpdateModelPreview copy = new AssetEditorUpdateModelPreview();
        copy.assetPath = this.assetPath != null ? this.assetPath.clone() : null;
        copy.model = this.model != null ? this.model.clone() : null;
        copy.block = this.block != null ? this.block.clone() : null;
        copy.camera = this.camera != null ? this.camera.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorUpdateModelPreview other)) return false;
        return java.util.Objects.equals(this.assetPath, other.assetPath) && java.util.Objects.equals(this.model, other.model) && java.util.Objects.equals(this.block, other.block) && java.util.Objects.equals(this.camera, other.camera);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(assetPath, model, block, camera);
    }

}