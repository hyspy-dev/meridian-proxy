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


public class AssetEditorAssetListSetup implements Packet, ToClientPacket {
    public static final int PACKET_ID = 319;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 3;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 11;
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
    public boolean isReadOnly;
    public boolean canBeDeleted;
    @Nonnull public AssetEditorFileTree tree = AssetEditorFileTree.Server;
    @Nullable public AssetEditorFileEntry[] paths;

    public AssetEditorAssetListSetup() {
    }

    public AssetEditorAssetListSetup(@Nullable String pack, boolean isReadOnly, boolean canBeDeleted, @Nonnull AssetEditorFileTree tree, @Nullable AssetEditorFileEntry[] paths) {
        this.pack = pack;
        this.isReadOnly = isReadOnly;
        this.canBeDeleted = canBeDeleted;
        this.tree = tree;
        this.paths = paths;
    }

    public AssetEditorAssetListSetup(@Nonnull AssetEditorAssetListSetup other) {
        this.pack = other.pack;
        this.isReadOnly = other.isReadOnly;
        this.canBeDeleted = other.canBeDeleted;
        this.tree = other.tree;
        this.paths = other.paths;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorAssetListSetup", offset, (int) mem.byteSize());
        long needed = (long) offset + 11;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorAssetListSetup", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getPack(MemorySegment mem) {
        return getPack(mem, 0);
    }
    
    @Nullable
    public static String getPack(MemorySegment mem, int offset) {
        return hasPack(mem, offset) ? PacketIO.readVarString("Pack", mem, offset + getValidatedOffset(mem, offset, 3, 11, "Pack"), 4096000): null;
    }
    
    public static boolean getIsReadOnly(MemorySegment mem) {
        return getIsReadOnly(mem, 0);
    }
    
    public static boolean getIsReadOnly(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x01) != 0;
    }
    
    public static boolean getCanBeDeleted(MemorySegment mem) {
        return getCanBeDeleted(mem, 0);
    }
    
    public static boolean getCanBeDeleted(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x02) != 0;
    }
    
    public static AssetEditorFileTree getTree(MemorySegment mem) {
        return getTree(mem, 0);
    }
    
    public static AssetEditorFileTree getTree(MemorySegment mem, int offset) {
        return AssetEditorFileTree.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2));
    }
    
    @Nullable
    public static AssetEditorFileEntry[] getPaths(MemorySegment mem) {
        return getPaths(mem, 0);
    }
    
    @Nullable
    public static AssetEditorFileEntry[] getPaths(MemorySegment mem, int offset) {
        if (!hasPaths(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 7, 11, "Paths");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Paths");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Paths", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Paths", (int) java.lang.Math.min(off + lenOffset + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
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
    
    public static boolean hasPaths(MemorySegment mem, int offset) {
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
    
    public static AssetEditorAssetListSetup toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorAssetListSetup toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorAssetListSetup and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorAssetListSetup toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 11;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasPack(mem, offset)) {
            requireSlot(mem, offset + 3, varPos, "Pack");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Pack", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 3, -1, "Pack");
        }
        
        AssetEditorFileEntry[] v4 = null;
        if (hasPaths(mem, offset)) {
            requireSlot(mem, offset + 7, varPos, "Paths");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Paths");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Paths", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Paths", (int) java.lang.Math.min(off + lenOffset + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v4 = new AssetEditorFileEntry[len];
            for (var i = 0; i < len; i++) {
                v4[i] = AssetEditorFileEntry.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 7, -1, "Paths");
        }
        var result = new AssetEditorAssetListSetup(
            v0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x02) != 0,
            AssetEditorFileTree.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2)),
            v4
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.pack != null) nullBits |= 0x01;
        if (this.paths != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        byte boolBits0_0 = 0;
        if (this.isReadOnly) boolBits0_0 |= 0x01;
        if (this.canBeDeleted) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 1 + 0, boolBits0_0);
        mem.set(PacketIO.PROTO_BYTE, offset + 2, (byte) this.tree.getValue());
        var varOffset = offset + 11;
        if (this.pack != null) {
            mem.set(PacketIO.PROTO_INT, offset + 3, varOffset - offset - 11);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.pack, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 3, -1);
        }
        if (this.paths != null) {
            mem.set(PacketIO.PROTO_INT, offset + 7, varOffset - offset - 11);
            if (paths.length > 4096000) throw ProtocolException.arrayTooLong("Paths", paths.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.paths.length);
            
            var pathsValueOffset = 0;
            for (var i = 0; i < this.paths.length; i++) {
                pathsValueOffset += this.paths[i].serialize(mem, varOffset + pathsValueOffset);
            }
            varOffset += pathsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 7, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 11;
        if (pack != null) size += PacketIO.stringSize(pack);
    if (paths != null) {
        int pathsSize = 0;
for (var elem : paths) pathsSize += elem.computeSize();
size += VarInt.size(paths.length) + pathsSize;
    }

        return size;
    }

    public AssetEditorAssetListSetup clone() {
        AssetEditorAssetListSetup copy = new AssetEditorAssetListSetup();
        copy.pack = this.pack;
        copy.isReadOnly = this.isReadOnly;
        copy.canBeDeleted = this.canBeDeleted;
        copy.tree = this.tree;
        copy.paths = this.paths != null ? java.util.Arrays.stream(this.paths).map(e -> e.clone()).toArray(AssetEditorFileEntry[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorAssetListSetup other)) return false;
        return java.util.Objects.equals(this.pack, other.pack) && this.isReadOnly == other.isReadOnly && this.canBeDeleted == other.canBeDeleted && java.util.Objects.equals(this.tree, other.tree) && java.util.Arrays.equals(this.paths, other.paths);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(pack);
        result = 31 * result + Boolean.hashCode(isReadOnly);
        result = 31 * result + Boolean.hashCode(canBeDeleted);
        result = 31 * result + java.util.Objects.hashCode(tree);
        result = 31 * result + java.util.Arrays.hashCode(paths);
        return result;
    }

}