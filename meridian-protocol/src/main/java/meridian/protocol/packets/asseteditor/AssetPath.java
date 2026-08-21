// Auto-generated - do not edit
package meridian.protocol.packets.asseteditor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class AssetPath {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 32768019;

    @Nullable public String pack;
    @Nullable public String path;

    public AssetPath() {
    }

    public AssetPath(@Nullable String pack, @Nullable String path) {
        this.pack = pack;
        this.path = path;
    }

    public AssetPath(@Nonnull AssetPath other) {
        this.pack = other.pack;
        this.path = other.path;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetPath", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetPath", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getPack(MemorySegment mem) {
        return getPack(mem, 0);
    }
    
    @Nullable
    public static String getPack(MemorySegment mem, int offset) {
        return hasPack(mem, offset) ? PacketIO.readVarString("Pack", mem, offset + getValidatedOffset(mem, offset, 1, 9, "Pack"), 4096000): null;
    }
    
    @Nullable
    public static String getPath(MemorySegment mem) {
        return getPath(mem, 0);
    }
    
    @Nullable
    public static String getPath(MemorySegment mem, int offset) {
        return hasPath(mem, offset) ? PacketIO.readVarString("Path", mem, offset + getValidatedOffset(mem, offset, 5, 9, "Path"), 4096000): null;
    }
    
    public static boolean hasPack(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasPath(MemorySegment mem, int offset) {
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
    
    public static AssetPath toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetPath toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetPath and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetPath toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
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
        
        String v1 = null;
        if (hasPath(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Path");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Path", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 5, -1, "Path");
        }
        var result = new AssetPath(
            v0,
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.pack != null) nullBits |= 0x01;
        if (this.path != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 9;
        if (this.pack != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 9);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.pack, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.path != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 9);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.path, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (pack != null) size += PacketIO.stringSize(pack);
    if (path != null) size += PacketIO.stringSize(path);

        return size;
    }

    public AssetPath clone() {
        AssetPath copy = new AssetPath();
        copy.pack = this.pack;
        copy.path = this.path;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetPath other)) return false;
        return java.util.Objects.equals(this.pack, other.pack) && java.util.Objects.equals(this.path, other.path);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(pack, path);
    }

}