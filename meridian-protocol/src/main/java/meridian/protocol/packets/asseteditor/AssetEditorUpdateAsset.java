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


public class AssetEditorUpdateAsset implements Packet, ToServerPacket {
    public static final int PACKET_ID = 324;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 21;
    public static final int MAX_SIZE = 53248050;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int token;
    @Nullable public String assetType;
    @Nullable public AssetPath path;
    public int assetIndex = Integer.MIN_VALUE;
    @Nullable public byte[] data;

    public AssetEditorUpdateAsset() {
    }

    public AssetEditorUpdateAsset(int token, @Nullable String assetType, @Nullable AssetPath path, int assetIndex, @Nullable byte[] data) {
        this.token = token;
        this.assetType = assetType;
        this.path = path;
        this.assetIndex = assetIndex;
        this.data = data;
    }

    public AssetEditorUpdateAsset(@Nonnull AssetEditorUpdateAsset other) {
        this.token = other.token;
        this.assetType = other.assetType;
        this.path = other.path;
        this.assetIndex = other.assetIndex;
        this.data = other.data;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorUpdateAsset", offset, (int) mem.byteSize());
        long needed = (long) offset + 21;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorUpdateAsset", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getToken(MemorySegment mem) {
        return getToken(mem, 0);
    }
    
    public static int getToken(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static String getAssetType(MemorySegment mem) {
        return getAssetType(mem, 0);
    }
    
    @Nullable
    public static String getAssetType(MemorySegment mem, int offset) {
        return hasAssetType(mem, offset) ? PacketIO.readVarString("AssetType", mem, offset + getValidatedOffset(mem, offset, 9, 21, "AssetType"), 4096000): null;
    }
    
    @Nullable
    public static AssetPath getPath(MemorySegment mem) {
        return getPath(mem, 0);
    }
    
    @Nullable
    public static AssetPath getPath(MemorySegment mem, int offset) {
        return hasPath(mem, offset) ? AssetPath.toObject(mem, offset + getValidatedOffset(mem, offset, 13, 21, "Path")): null;
    }
    
    public static int getAssetIndex(MemorySegment mem) {
        return getAssetIndex(mem, 0);
    }
    
    public static int getAssetIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    @Nullable
    public static byte[] getData(MemorySegment mem) {
        return getData(mem, 0);
    }
    
    @Nullable
    public static byte[] getData(MemorySegment mem, int offset) {
        if (!hasData(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 17, 21, "Data");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Data");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Data", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Data", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new byte[len];
        MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, data, 0, len);
        return data;
    }
    
    public static boolean hasAssetType(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasPath(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasData(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
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
    
    public static AssetEditorUpdateAsset toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorUpdateAsset toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorUpdateAsset and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorUpdateAsset toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 21;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v1 = null;
        if (hasAssetType(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "AssetType");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("AssetType", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 9, -1, "AssetType");
        }
        
        AssetPath v2 = null;
        if (hasPath(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "Path");
            v2 = AssetPath.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 13, -1, "Path");
        }
        
        byte[] v4 = null;
        if (hasData(mem, offset)) {
            requireSlot(mem, offset + 17, varPos, "Data");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Data");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Data", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Data", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v4 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v4, 0, len);
            varPos = off + len - varBase;
        } else {
            requireSlot(mem, offset + 17, -1, "Data");
        }
        var result = new AssetEditorUpdateAsset(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v1,
            v2,
            mem.get(PacketIO.PROTO_INT, offset + 5),
            v4
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.assetType != null) nullBits |= 0x01;
        if (this.path != null) nullBits |= 0x02;
        if (this.data != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.token);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.assetIndex);
        var varOffset = offset + 21;
        if (this.assetType != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 21);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.assetType, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
        if (this.path != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 21);
            varOffset += this.path.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
        if (this.data != null) {
            mem.set(PacketIO.PROTO_INT, offset + 17, varOffset - offset - 21);
            if (data.length > 4096000) throw ProtocolException.arrayTooLong("Data", data.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.data.length);
            
            MemorySegment.copy(this.data, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.data.length);
            varOffset += this.data.length * 1;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 17, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 21;
        if (assetType != null) size += PacketIO.stringSize(assetType);
    if (path != null) size += path.computeSize();
    if (data != null) size += VarInt.size(data.length) + data.length * 1;

        return size;
    }

    public AssetEditorUpdateAsset clone() {
        AssetEditorUpdateAsset copy = new AssetEditorUpdateAsset();
        copy.token = this.token;
        copy.assetType = this.assetType;
        copy.path = this.path != null ? this.path.clone() : null;
        copy.assetIndex = this.assetIndex;
        copy.data = this.data != null ? java.util.Arrays.copyOf(this.data, this.data.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorUpdateAsset other)) return false;
        return this.token == other.token && java.util.Objects.equals(this.assetType, other.assetType) && java.util.Objects.equals(this.path, other.path) && this.assetIndex == other.assetIndex && java.util.Arrays.equals(this.data, other.data);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(token);
        result = 31 * result + java.util.Objects.hashCode(assetType);
        result = 31 * result + java.util.Objects.hashCode(path);
        result = 31 * result + Integer.hashCode(assetIndex);
        result = 31 * result + java.util.Arrays.hashCode(data);
        return result;
    }

}