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

public class RequestAssets implements Packet, ToServerPacket {
    public static final int PACKET_ID = 23;
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

    @Nullable public Asset[] assets;

    public RequestAssets() {
    }

    public RequestAssets(@Nullable Asset[] assets) {
        this.assets = assets;
    }

    public RequestAssets(@Nonnull RequestAssets other) {
        this.assets = other.assets;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("RequestAssets", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("RequestAssets", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static Asset[] getAssets(MemorySegment mem) {
        return getAssets(mem, 0);
    }
    
    @Nullable
    public static Asset[] getAssets(MemorySegment mem, int offset) {
        if (!hasAssets(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Assets");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Assets", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 64 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Assets", (int) java.lang.Math.min(off + lenOffset + (long) len * 64, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new Asset[len];
        for (var i = 0; i < len; i++) {
            data[i] = Asset.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasAssets(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static RequestAssets toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static RequestAssets toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one RequestAssets and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static RequestAssets toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        Asset[] v0 = null;
        if (hasAssets(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Assets");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Assets", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 64 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Assets", (int) java.lang.Math.min(off + lenOffset + (long) len * 64, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new Asset[len];
            for (var i = 0; i < len; i++) {
                v0[i] = Asset.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new RequestAssets(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.assets != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.assets != null) {
            
            if (assets.length > 4096000) throw ProtocolException.arrayTooLong("Assets", assets.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.assets.length);
            
            var assetsValueOffset = 0;
            for (var i = 0; i < this.assets.length; i++) {
                assetsValueOffset += this.assets[i].serialize(mem, varOffset + assetsValueOffset);
            }
            varOffset += assetsValueOffset;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (assets != null) {
        int assetsSize = 0;
for (var elem : assets) assetsSize += elem.computeSize();
size += VarInt.size(assets.length) + assetsSize;
    }

        return size;
    }

    public RequestAssets clone() {
        RequestAssets copy = new RequestAssets();
        copy.assets = this.assets != null ? java.util.Arrays.stream(this.assets).map(e -> e.clone()).toArray(Asset[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RequestAssets other)) return false;
        return java.util.Arrays.equals(this.assets, other.assets);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(assets);
        return result;
    }

}