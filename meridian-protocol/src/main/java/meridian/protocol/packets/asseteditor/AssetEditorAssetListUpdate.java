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


public class AssetEditorAssetListUpdate implements Packet, ToClientPacket {
    public static final int PACKET_ID = 320;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public String pack;
    @Nullable public AssetEditorFileEntry[] additions;
    @Nullable public AssetEditorFileEntry[] deletions;

    public AssetEditorAssetListUpdate() {
    }

    public AssetEditorAssetListUpdate(@Nullable String pack, @Nullable AssetEditorFileEntry[] additions, @Nullable AssetEditorFileEntry[] deletions) {
        this.pack = pack;
        this.additions = additions;
        this.deletions = deletions;
    }

    public AssetEditorAssetListUpdate(@Nonnull AssetEditorAssetListUpdate other) {
        this.pack = other.pack;
        this.additions = other.additions;
        this.deletions = other.deletions;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorAssetListUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorAssetListUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getPack(MemorySegment mem) {
        return getPack(mem, 0);
    }
    
    @Nullable
    public static String getPack(MemorySegment mem, int offset) {
        return hasPack(mem, offset) ? PacketIO.readVarString("Pack", mem, offset + getValidatedOffset(mem, offset, 1, 13, "Pack"), 4096000): null;
    }
    
    @Nullable
    public static AssetEditorFileEntry[] getAdditions(MemorySegment mem) {
        return getAdditions(mem, 0);
    }
    
    @Nullable
    public static AssetEditorFileEntry[] getAdditions(MemorySegment mem, int offset) {
        if (!hasAdditions(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 5, 13, "Additions");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Additions");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Additions", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Additions", (int) java.lang.Math.min(off + lenOffset + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new AssetEditorFileEntry[len];
        for (var i = 0; i < len; i++) {
            data[i] = AssetEditorFileEntry.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static AssetEditorFileEntry[] getDeletions(MemorySegment mem) {
        return getDeletions(mem, 0);
    }
    
    @Nullable
    public static AssetEditorFileEntry[] getDeletions(MemorySegment mem, int offset) {
        if (!hasDeletions(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 9, 13, "Deletions");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Deletions");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Deletions", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Deletions", (int) java.lang.Math.min(off + lenOffset + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new AssetEditorFileEntry[len];
        for (var i = 0; i < len; i++) {
            data[i] = AssetEditorFileEntry.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasPack(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasAdditions(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasDeletions(MemorySegment mem, int offset) {
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
    
    public static AssetEditorAssetListUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorAssetListUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorAssetListUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorAssetListUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 13;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasPack(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "Pack");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Pack", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 1, -1, "Pack");
        }
        
        AssetEditorFileEntry[] v1 = null;
        if (hasAdditions(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Additions");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Additions");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Additions", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Additions", (int) java.lang.Math.min(off + lenOffset + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new AssetEditorFileEntry[len];
            for (var i = 0; i < len; i++) {
                v1[i] = AssetEditorFileEntry.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "Additions");
        }
        
        AssetEditorFileEntry[] v2 = null;
        if (hasDeletions(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "Deletions");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Deletions");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Deletions", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Deletions", (int) java.lang.Math.min(off + lenOffset + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new AssetEditorFileEntry[len];
            for (var i = 0; i < len; i++) {
                v2[i] = AssetEditorFileEntry.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 9, -1, "Deletions");
        }
        var result = new AssetEditorAssetListUpdate(
            v0,
            v1,
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.pack != null) nullBits |= 0x01;
        if (this.additions != null) nullBits |= 0x02;
        if (this.deletions != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 13;
        if (this.pack != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 13);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.pack, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.additions != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 13);
            if (additions.length > 4096000) throw ProtocolException.arrayTooLong("Additions", additions.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.additions.length);
            
            var additionsValueOffset = 0;
            for (var i = 0; i < this.additions.length; i++) {
                additionsValueOffset += this.additions[i].serialize(mem, varOffset + additionsValueOffset);
            }
            varOffset += additionsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.deletions != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 13);
            if (deletions.length > 4096000) throw ProtocolException.arrayTooLong("Deletions", deletions.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.deletions.length);
            
            var deletionsValueOffset = 0;
            for (var i = 0; i < this.deletions.length; i++) {
                deletionsValueOffset += this.deletions[i].serialize(mem, varOffset + deletionsValueOffset);
            }
            varOffset += deletionsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 13;
        if (pack != null) size += PacketIO.stringSize(pack);
    if (additions != null) {
        int additionsSize = 0;
for (var elem : additions) additionsSize += elem.computeSize();
size += VarInt.size(additions.length) + additionsSize;
    }
    if (deletions != null) {
        int deletionsSize = 0;
for (var elem : deletions) deletionsSize += elem.computeSize();
size += VarInt.size(deletions.length) + deletionsSize;
    }

        return size;
    }

    public AssetEditorAssetListUpdate clone() {
        AssetEditorAssetListUpdate copy = new AssetEditorAssetListUpdate();
        copy.pack = this.pack;
        copy.additions = this.additions != null ? java.util.Arrays.stream(this.additions).map(e -> e.clone()).toArray(AssetEditorFileEntry[]::new) : null;
        copy.deletions = this.deletions != null ? java.util.Arrays.stream(this.deletions).map(e -> e.clone()).toArray(AssetEditorFileEntry[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorAssetListUpdate other)) return false;
        return java.util.Objects.equals(this.pack, other.pack) && java.util.Arrays.equals(this.additions, other.additions) && java.util.Arrays.equals(this.deletions, other.deletions);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(pack);
        result = 31 * result + java.util.Arrays.hashCode(additions);
        result = 31 * result + java.util.Arrays.hashCode(deletions);
        return result;
    }

}