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


public class AssetEditorRenameAsset implements Packet, ToServerPacket {
    public static final int PACKET_ID = 328;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 65536051;

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
    @Nullable public AssetPath newPath;

    public AssetEditorRenameAsset() {
    }

    public AssetEditorRenameAsset(int token, @Nullable AssetPath path, @Nullable AssetPath newPath) {
        this.token = token;
        this.path = path;
        this.newPath = newPath;
    }

    public AssetEditorRenameAsset(@Nonnull AssetEditorRenameAsset other) {
        this.token = other.token;
        this.path = other.path;
        this.newPath = other.newPath;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorRenameAsset", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorRenameAsset", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
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
        return hasPath(mem, offset) ? AssetPath.toObject(mem, offset + getValidatedOffset(mem, offset, 5, 13, "Path")): null;
    }
    
    @Nullable
    public static AssetPath getNewPath(MemorySegment mem) {
        return getNewPath(mem, 0);
    }
    
    @Nullable
    public static AssetPath getNewPath(MemorySegment mem, int offset) {
        return hasNewPath(mem, offset) ? AssetPath.toObject(mem, offset + getValidatedOffset(mem, offset, 9, 13, "NewPath")): null;
    }
    
    public static boolean hasPath(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasNewPath(MemorySegment mem, int offset) {
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
    
    public static AssetEditorRenameAsset toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorRenameAsset toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorRenameAsset and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorRenameAsset toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 13;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        AssetPath v1 = null;
        if (hasPath(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Path");
            v1 = AssetPath.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "Path");
        }
        
        AssetPath v2 = null;
        if (hasNewPath(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "NewPath");
            v2 = AssetPath.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 9, -1, "NewPath");
        }
        var result = new AssetEditorRenameAsset(
            mem.get(PacketIO.PROTO_INT, offset + 1),
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
        if (this.path != null) nullBits |= 0x01;
        if (this.newPath != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.token);
        var varOffset = offset + 13;
        if (this.path != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 13);
            varOffset += this.path.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.newPath != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 13);
            varOffset += this.newPath.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 13;
        if (path != null) size += path.computeSize();
    if (newPath != null) size += newPath.computeSize();

        return size;
    }

    public AssetEditorRenameAsset clone() {
        AssetEditorRenameAsset copy = new AssetEditorRenameAsset();
        copy.token = this.token;
        copy.path = this.path != null ? this.path.clone() : null;
        copy.newPath = this.newPath != null ? this.newPath.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorRenameAsset other)) return false;
        return this.token == other.token && java.util.Objects.equals(this.path, other.path) && java.util.Objects.equals(this.newPath, other.newPath);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(token, path, newPath);
    }

}