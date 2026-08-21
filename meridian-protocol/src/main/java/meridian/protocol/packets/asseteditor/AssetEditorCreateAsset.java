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


public class AssetEditorCreateAsset implements Packet, ToServerPacket {
    public static final int PACKET_ID = 327;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 18;
    public static final int MAX_SIZE = 53248047;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int token;
    @Nullable public AssetPath path;
    @Nullable public byte[] data;
    @Nullable public AssetEditorRebuildCaches rebuildCaches;
    @Nullable public String buttonId;

    public AssetEditorCreateAsset() {
    }

    public AssetEditorCreateAsset(int token, @Nullable AssetPath path, @Nullable byte[] data, @Nullable AssetEditorRebuildCaches rebuildCaches, @Nullable String buttonId) {
        this.token = token;
        this.path = path;
        this.data = data;
        this.rebuildCaches = rebuildCaches;
        this.buttonId = buttonId;
    }

    public AssetEditorCreateAsset(@Nonnull AssetEditorCreateAsset other) {
        this.token = other.token;
        this.path = other.path;
        this.data = other.data;
        this.rebuildCaches = other.rebuildCaches;
        this.buttonId = other.buttonId;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorCreateAsset", offset, (int) mem.byteSize());
        long needed = (long) offset + 18;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorCreateAsset", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getToken(MemorySegment mem) {
        return getToken(mem, 0);
    }
    
    public static int getToken(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static AssetPath getPath(MemorySegment mem) {
        return getPath(mem, 0);
    }
    
    @Nullable
    public static AssetPath getPath(MemorySegment mem, int offset) {
        return hasPath(mem, offset) ? AssetPath.toObject(mem, offset + getValidatedOffset(mem, offset, 6, 18, "Path")): null;
    }
    
    @Nullable
    public static byte[] getData(MemorySegment mem) {
        return getData(mem, 0);
    }
    
    @Nullable
    public static byte[] getData(MemorySegment mem, int offset) {
        if (!hasData(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 10, 18, "Data");
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
    
    @Nullable
    public static AssetEditorRebuildCaches getRebuildCaches(MemorySegment mem) {
        return getRebuildCaches(mem, 0);
    }
    
    @Nullable
    public static AssetEditorRebuildCaches getRebuildCaches(MemorySegment mem, int offset) {
        return hasRebuildCaches(mem, offset) ? AssetEditorRebuildCaches.toObject(mem, offset + 5): null;
    }
    
    @Nullable
    public static String getButtonId(MemorySegment mem) {
        return getButtonId(mem, 0);
    }
    
    @Nullable
    public static String getButtonId(MemorySegment mem, int offset) {
        return hasButtonId(mem, offset) ? PacketIO.readVarString("ButtonId", mem, offset + getValidatedOffset(mem, offset, 14, 18, "ButtonId"), 4096000): null;
    }
    
    public static boolean hasRebuildCaches(MemorySegment mem, int offset) {
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
    
    public static boolean hasButtonId(MemorySegment mem, int offset) {
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
    
    public static AssetEditorCreateAsset toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorCreateAsset toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorCreateAsset and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorCreateAsset toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 18;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        AssetPath v1 = null;
        if (hasPath(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "Path");
            v1 = AssetPath.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 6, -1, "Path");
        }
        
        byte[] v2 = null;
        if (hasData(mem, offset)) {
            requireSlot(mem, offset + 10, varPos, "Data");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Data");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Data", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Data", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v2, 0, len);
            varPos = off + len - varBase;
        } else {
            requireSlot(mem, offset + 10, -1, "Data");
        }
        
        String v4 = null;
        if (hasButtonId(mem, offset)) {
            requireSlot(mem, offset + 14, varPos, "ButtonId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v4 = PacketIO.readVarString("ButtonId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 14, -1, "ButtonId");
        }
        var result = new AssetEditorCreateAsset(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v1,
            v2,
            hasRebuildCaches(mem, offset) ? AssetEditorRebuildCaches.toObject(mem, offset + 5) : null,
            v4
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.rebuildCaches != null) nullBits |= 0x01;
        if (this.path != null) nullBits |= 0x02;
        if (this.data != null) nullBits |= 0x04;
        if (this.buttonId != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.token);
        if (this.rebuildCaches != null) {
            this.rebuildCaches.serialize(mem, offset + 5);
        } else {
            mem.asSlice(offset + 5, 1).fill((byte) 0); 
        }
        var varOffset = offset + 18;
        if (this.path != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 18);
            varOffset += this.path.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
        if (this.data != null) {
            mem.set(PacketIO.PROTO_INT, offset + 10, varOffset - offset - 18);
            if (data.length > 4096000) throw ProtocolException.arrayTooLong("Data", data.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.data.length);
            
            MemorySegment.copy(this.data, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.data.length);
            varOffset += this.data.length * 1;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 10, -1);
        }
        if (this.buttonId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 14, varOffset - offset - 18);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.buttonId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 14, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 18;
        if (path != null) size += path.computeSize();
    if (data != null) size += VarInt.size(data.length) + data.length * 1;
    if (buttonId != null) size += PacketIO.stringSize(buttonId);

        return size;
    }

    public AssetEditorCreateAsset clone() {
        AssetEditorCreateAsset copy = new AssetEditorCreateAsset();
        copy.token = this.token;
        copy.path = this.path != null ? this.path.clone() : null;
        copy.data = this.data != null ? java.util.Arrays.copyOf(this.data, this.data.length) : null;
        copy.rebuildCaches = this.rebuildCaches != null ? this.rebuildCaches.clone() : null;
        copy.buttonId = this.buttonId;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorCreateAsset other)) return false;
        return this.token == other.token && java.util.Objects.equals(this.path, other.path) && java.util.Arrays.equals(this.data, other.data) && java.util.Objects.equals(this.rebuildCaches, other.rebuildCaches) && java.util.Objects.equals(this.buttonId, other.buttonId);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(token);
        result = 31 * result + java.util.Objects.hashCode(path);
        result = 31 * result + java.util.Arrays.hashCode(data);
        result = 31 * result + java.util.Objects.hashCode(rebuildCaches);
        result = 31 * result + java.util.Objects.hashCode(buttonId);
        return result;
    }

}