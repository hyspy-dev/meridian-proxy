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


public class AssetEditorModifiedAssetsCount implements Packet, ToClientPacket {
    public static final int PACKET_ID = 340;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 4;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 4;
    public static final int MAX_SIZE = 4;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int count;

    public AssetEditorModifiedAssetsCount() {
    }

    public AssetEditorModifiedAssetsCount(int count) {
        this.count = count;
    }

    public AssetEditorModifiedAssetsCount(@Nonnull AssetEditorModifiedAssetsCount other) {
        this.count = other.count;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorModifiedAssetsCount", offset, (int) mem.byteSize());
        long needed = (long) offset + 4;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorModifiedAssetsCount", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getCount(MemorySegment mem) {
        return getCount(mem, 0);
    }
    
    public static int getCount(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    
    
    
    
    public static AssetEditorModifiedAssetsCount toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorModifiedAssetsCount toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorModifiedAssetsCount and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorModifiedAssetsCount toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new AssetEditorModifiedAssetsCount(
            mem.get(PacketIO.PROTO_INT, offset + 0)
        );
        if (cursor != null) cursor.position = offset + 4;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.count);
        
        
    
       return 4;
    }
    public int computeSize() {
        return 4;
    }

    public AssetEditorModifiedAssetsCount clone() {
        AssetEditorModifiedAssetsCount copy = new AssetEditorModifiedAssetsCount();
        copy.count = this.count;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorModifiedAssetsCount other)) return false;
        return this.count == other.count;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(count);
    }

}