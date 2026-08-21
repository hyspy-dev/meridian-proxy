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

public class WorldSettings implements Packet, ToClientPacket {
    public static final int PACKET_ID = 20;
    public static final boolean IS_COMPRESSED = true;
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

    @Nullable public Asset[] requiredAssets;

    public WorldSettings() {
    }

    public WorldSettings(@Nullable Asset[] requiredAssets) {
        this.requiredAssets = requiredAssets;
    }

    public WorldSettings(@Nonnull WorldSettings other) {
        this.requiredAssets = other.requiredAssets;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("WorldSettings", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("WorldSettings", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static Asset[] getRequiredAssets(MemorySegment mem) {
        return getRequiredAssets(mem, 0);
    }
    
    @Nullable
    public static Asset[] getRequiredAssets(MemorySegment mem, int offset) {
        if (!hasRequiredAssets(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("RequiredAssets");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("RequiredAssets", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 64 > mem.byteSize()) throw ProtocolException.bufferTooSmall("RequiredAssets", (int) java.lang.Math.min(off + lenOffset + (long) len * 64, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new Asset[len];
        for (var i = 0; i < len; i++) {
            data[i] = Asset.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasRequiredAssets(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static WorldSettings toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static WorldSettings toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one WorldSettings and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static WorldSettings toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        Asset[] v0 = null;
        if (hasRequiredAssets(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("RequiredAssets");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("RequiredAssets", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 64 > mem.byteSize()) throw ProtocolException.bufferTooSmall("RequiredAssets", (int) java.lang.Math.min(off + lenOffset + (long) len * 64, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new Asset[len];
            for (var i = 0; i < len; i++) {
                v0[i] = Asset.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new WorldSettings(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.requiredAssets != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.requiredAssets != null) {
            
            if (requiredAssets.length > 4096000) throw ProtocolException.arrayTooLong("RequiredAssets", requiredAssets.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.requiredAssets.length);
            
            var requiredAssetsValueOffset = 0;
            for (var i = 0; i < this.requiredAssets.length; i++) {
                requiredAssetsValueOffset += this.requiredAssets[i].serialize(mem, varOffset + requiredAssetsValueOffset);
            }
            varOffset += requiredAssetsValueOffset;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (requiredAssets != null) {
        int requiredAssetsSize = 0;
for (var elem : requiredAssets) requiredAssetsSize += elem.computeSize();
size += VarInt.size(requiredAssets.length) + requiredAssetsSize;
    }

        return size;
    }

    public WorldSettings clone() {
        WorldSettings copy = new WorldSettings();
        copy.requiredAssets = this.requiredAssets != null ? java.util.Arrays.stream(this.requiredAssets).map(e -> e.clone()).toArray(Asset[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof WorldSettings other)) return false;
        return java.util.Arrays.equals(this.requiredAssets, other.requiredAssets);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(requiredAssets);
        return result;
    }

}