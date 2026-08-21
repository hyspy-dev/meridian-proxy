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


public class AssetEditorUpdateAssetPack implements Packet, ToServerPacket, ToClientPacket {
    public static final int PACKET_ID = 315;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public String id;
    @Nullable public AssetPackManifest manifest;

    public AssetEditorUpdateAssetPack() {
    }

    public AssetEditorUpdateAssetPack(@Nullable String id, @Nullable AssetPackManifest manifest) {
        this.id = id;
        this.manifest = manifest;
    }

    public AssetEditorUpdateAssetPack(@Nonnull AssetEditorUpdateAssetPack other) {
        this.id = other.id;
        this.manifest = other.manifest;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorUpdateAssetPack", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorUpdateAssetPack", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 1, 9, "Id"), 4096000): null;
    }
    
    @Nullable
    public static AssetPackManifest getManifest(MemorySegment mem) {
        return getManifest(mem, 0);
    }
    
    @Nullable
    public static AssetPackManifest getManifest(MemorySegment mem, int offset) {
        return hasManifest(mem, offset) ? AssetPackManifest.toObject(mem, offset + getValidatedOffset(mem, offset, 5, 9, "Manifest")): null;
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasManifest(MemorySegment mem, int offset) {
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
    
    public static AssetEditorUpdateAssetPack toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorUpdateAssetPack toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorUpdateAssetPack and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorUpdateAssetPack toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 1, -1, "Id");
        }
        
        AssetPackManifest v1 = null;
        if (hasManifest(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Manifest");
            v1 = AssetPackManifest.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "Manifest");
        }
        var result = new AssetEditorUpdateAssetPack(
            v0,
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        if (this.manifest != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 9;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 9);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.manifest != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 9);
            varOffset += this.manifest.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (id != null) size += PacketIO.stringSize(id);
    if (manifest != null) size += manifest.computeSize();

        return size;
    }

    public AssetEditorUpdateAssetPack clone() {
        AssetEditorUpdateAssetPack copy = new AssetEditorUpdateAssetPack();
        copy.id = this.id;
        copy.manifest = this.manifest != null ? this.manifest.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorUpdateAssetPack other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.manifest, other.manifest);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, manifest);
    }

}