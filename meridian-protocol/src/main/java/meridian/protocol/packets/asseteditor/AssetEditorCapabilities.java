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


public class AssetEditorCapabilities implements Packet, ToClientPacket {
    public static final int PACKET_ID = 304;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public boolean canDiscardAssets;
    public boolean canEditAssets;
    public boolean canCreateAssetPacks;
    public boolean canEditAssetPacks;
    public boolean canDeleteAssetPacks;

    public AssetEditorCapabilities() {
    }

    public AssetEditorCapabilities(boolean canDiscardAssets, boolean canEditAssets, boolean canCreateAssetPacks, boolean canEditAssetPacks, boolean canDeleteAssetPacks) {
        this.canDiscardAssets = canDiscardAssets;
        this.canEditAssets = canEditAssets;
        this.canCreateAssetPacks = canCreateAssetPacks;
        this.canEditAssetPacks = canEditAssetPacks;
        this.canDeleteAssetPacks = canDeleteAssetPacks;
    }

    public AssetEditorCapabilities(@Nonnull AssetEditorCapabilities other) {
        this.canDiscardAssets = other.canDiscardAssets;
        this.canEditAssets = other.canEditAssets;
        this.canCreateAssetPacks = other.canCreateAssetPacks;
        this.canEditAssetPacks = other.canEditAssetPacks;
        this.canDeleteAssetPacks = other.canDeleteAssetPacks;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorCapabilities", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorCapabilities", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getCanDiscardAssets(MemorySegment mem) {
        return getCanDiscardAssets(mem, 0);
    }
    
    public static boolean getCanDiscardAssets(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x01) != 0;
    }
    
    public static boolean getCanEditAssets(MemorySegment mem) {
        return getCanEditAssets(mem, 0);
    }
    
    public static boolean getCanEditAssets(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x02) != 0;
    }
    
    public static boolean getCanCreateAssetPacks(MemorySegment mem) {
        return getCanCreateAssetPacks(mem, 0);
    }
    
    public static boolean getCanCreateAssetPacks(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x04) != 0;
    }
    
    public static boolean getCanEditAssetPacks(MemorySegment mem) {
        return getCanEditAssetPacks(mem, 0);
    }
    
    public static boolean getCanEditAssetPacks(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x08) != 0;
    }
    
    public static boolean getCanDeleteAssetPacks(MemorySegment mem) {
        return getCanDeleteAssetPacks(mem, 0);
    }
    
    public static boolean getCanDeleteAssetPacks(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x10) != 0;
    }
    
    
    
    
    
    public static AssetEditorCapabilities toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorCapabilities toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorCapabilities and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorCapabilities toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new AssetEditorCapabilities(
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x04) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x08) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x10) != 0
        );
        if (cursor != null) cursor.position = offset + 1;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        byte boolBits0_0 = 0;
        if (this.canDiscardAssets) boolBits0_0 |= 0x01;
        if (this.canEditAssets) boolBits0_0 |= 0x02;
        if (this.canCreateAssetPacks) boolBits0_0 |= 0x04;
        if (this.canEditAssetPacks) boolBits0_0 |= 0x08;
        if (this.canDeleteAssetPacks) boolBits0_0 |= 0x10;
        mem.set(PacketIO.PROTO_BYTE, offset + 0 + 0, boolBits0_0);
        
        
    
       return 1;
    }
    public int computeSize() {
        return 1;
    }

    public AssetEditorCapabilities clone() {
        AssetEditorCapabilities copy = new AssetEditorCapabilities();
        copy.canDiscardAssets = this.canDiscardAssets;
        copy.canEditAssets = this.canEditAssets;
        copy.canCreateAssetPacks = this.canCreateAssetPacks;
        copy.canEditAssetPacks = this.canEditAssetPacks;
        copy.canDeleteAssetPacks = this.canDeleteAssetPacks;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorCapabilities other)) return false;
        return this.canDiscardAssets == other.canDiscardAssets && this.canEditAssets == other.canEditAssets && this.canCreateAssetPacks == other.canCreateAssetPacks && this.canEditAssetPacks == other.canEditAssetPacks && this.canDeleteAssetPacks == other.canDeleteAssetPacks;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(canDiscardAssets, canEditAssets, canCreateAssetPacks, canEditAssetPacks, canDeleteAssetPacks);
    }

}