// Auto-generated - do not edit
package meridian.protocol.packets.setup;

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
import meridian.protocol.Asset;

public class AssetInitialize implements Packet, ToClientPacket {
    public static final int PACKET_ID = 24;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 4;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 4;
    public static final int MAX_SIZE = 2121;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public Asset asset = new Asset();
    public int size;

    public AssetInitialize() {
    }

    public AssetInitialize(@Nonnull Asset asset, int size) {
        this.asset = asset;
        this.size = size;
    }

    public AssetInitialize(@Nonnull AssetInitialize other) {
        this.asset = other.asset;
        this.size = other.size;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetInitialize", offset, (int) mem.byteSize());
        long needed = (long) offset + 4;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetInitialize", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static Asset getAsset(MemorySegment mem) {
        return getAsset(mem, 0);
    }
    
    public static Asset getAsset(MemorySegment mem, int offset) {
        return Asset.toObject(mem, offset + 4);
    }
    
    public static int getSize(MemorySegment mem) {
        return getSize(mem, 0);
    }
    
    public static int getSize(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    
    
    
    
    public static AssetInitialize toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetInitialize toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetInitialize and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetInitialize toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 4;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        Asset v0;
        {
            v0 = Asset.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new AssetInitialize(
            v0,
            mem.get(PacketIO.PROTO_INT, offset + 0)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.size);
        var varOffset = offset + 4;
        varOffset += this.asset.serialize(mem, varOffset);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 4;
        size += asset.computeSize();

        return size;
    }

    public AssetInitialize clone() {
        AssetInitialize copy = new AssetInitialize();
        copy.asset = this.asset.clone();
        copy.size = this.size;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetInitialize other)) return false;
        return java.util.Objects.equals(this.asset, other.asset) && this.size == other.size;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(asset, size);
    }

}