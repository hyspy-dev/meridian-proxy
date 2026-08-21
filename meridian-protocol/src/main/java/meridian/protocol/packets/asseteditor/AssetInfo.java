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


public class AssetInfo {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 10;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 22;
    public static final int MAX_SIZE = 81920065;

    @Nullable public AssetPath path;
    @Nullable public AssetPath oldPath;
    public boolean isDeleted;
    public boolean isNew;
    public long lastModificationDate;
    @Nullable public String lastModificationUsername;

    public AssetInfo() {
    }

    public AssetInfo(@Nullable AssetPath path, @Nullable AssetPath oldPath, boolean isDeleted, boolean isNew, long lastModificationDate, @Nullable String lastModificationUsername) {
        this.path = path;
        this.oldPath = oldPath;
        this.isDeleted = isDeleted;
        this.isNew = isNew;
        this.lastModificationDate = lastModificationDate;
        this.lastModificationUsername = lastModificationUsername;
    }

    public AssetInfo(@Nonnull AssetInfo other) {
        this.path = other.path;
        this.oldPath = other.oldPath;
        this.isDeleted = other.isDeleted;
        this.isNew = other.isNew;
        this.lastModificationDate = other.lastModificationDate;
        this.lastModificationUsername = other.lastModificationUsername;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetInfo", offset, (int) mem.byteSize());
        long needed = (long) offset + 22;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetInfo", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static AssetPath getPath(MemorySegment mem) {
        return getPath(mem, 0);
    }
    
    @Nullable
    public static AssetPath getPath(MemorySegment mem, int offset) {
        return hasPath(mem, offset) ? AssetPath.toObject(mem, offset + getValidatedOffset(mem, offset, 10, 22, "Path")): null;
    }
    
    @Nullable
    public static AssetPath getOldPath(MemorySegment mem) {
        return getOldPath(mem, 0);
    }
    
    @Nullable
    public static AssetPath getOldPath(MemorySegment mem, int offset) {
        return hasOldPath(mem, offset) ? AssetPath.toObject(mem, offset + getValidatedOffset(mem, offset, 14, 22, "OldPath")): null;
    }
    
    public static boolean getIsDeleted(MemorySegment mem) {
        return getIsDeleted(mem, 0);
    }
    
    public static boolean getIsDeleted(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x01) != 0;
    }
    
    public static boolean getIsNew(MemorySegment mem) {
        return getIsNew(mem, 0);
    }
    
    public static boolean getIsNew(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x02) != 0;
    }
    
    public static long getLastModificationDate(MemorySegment mem) {
        return getLastModificationDate(mem, 0);
    }
    
    public static long getLastModificationDate(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_LONG, offset + 2);
    }
    
    @Nullable
    public static String getLastModificationUsername(MemorySegment mem) {
        return getLastModificationUsername(mem, 0);
    }
    
    @Nullable
    public static String getLastModificationUsername(MemorySegment mem, int offset) {
        return hasLastModificationUsername(mem, offset) ? PacketIO.readVarString("LastModificationUsername", mem, offset + getValidatedOffset(mem, offset, 18, 22, "LastModificationUsername"), 4096000): null;
    }
    
    public static boolean hasPath(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasOldPath(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasLastModificationUsername(MemorySegment mem, int offset) {
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
    
    public static AssetInfo toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetInfo toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetInfo and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetInfo toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 22;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        AssetPath v0 = null;
        if (hasPath(mem, offset)) {
            requireSlot(mem, offset + 10, varPos, "Path");
            v0 = AssetPath.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 10, -1, "Path");
        }
        
        AssetPath v1 = null;
        if (hasOldPath(mem, offset)) {
            requireSlot(mem, offset + 14, varPos, "OldPath");
            v1 = AssetPath.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 14, -1, "OldPath");
        }
        
        String v5 = null;
        if (hasLastModificationUsername(mem, offset)) {
            requireSlot(mem, offset + 18, varPos, "LastModificationUsername");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v5 = PacketIO.readVarString("LastModificationUsername", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 18, -1, "LastModificationUsername");
        }
        var result = new AssetInfo(
            v0,
            v1,
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x02) != 0,
            mem.get(PacketIO.PROTO_LONG, offset + 2),
            v5
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.path != null) nullBits |= 0x01;
        if (this.oldPath != null) nullBits |= 0x02;
        if (this.lastModificationUsername != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        byte boolBits0_0 = 0;
        if (this.isDeleted) boolBits0_0 |= 0x01;
        if (this.isNew) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 1 + 0, boolBits0_0);
        mem.set(PacketIO.PROTO_LONG, offset + 2, this.lastModificationDate);
        var varOffset = offset + 22;
        if (this.path != null) {
            mem.set(PacketIO.PROTO_INT, offset + 10, varOffset - offset - 22);
            varOffset += this.path.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 10, -1);
        }
        if (this.oldPath != null) {
            mem.set(PacketIO.PROTO_INT, offset + 14, varOffset - offset - 22);
            varOffset += this.oldPath.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 14, -1);
        }
        if (this.lastModificationUsername != null) {
            mem.set(PacketIO.PROTO_INT, offset + 18, varOffset - offset - 22);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.lastModificationUsername, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 18, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 22;
        if (path != null) size += path.computeSize();
    if (oldPath != null) size += oldPath.computeSize();
    if (lastModificationUsername != null) size += PacketIO.stringSize(lastModificationUsername);

        return size;
    }

    public AssetInfo clone() {
        AssetInfo copy = new AssetInfo();
        copy.path = this.path != null ? this.path.clone() : null;
        copy.oldPath = this.oldPath != null ? this.oldPath.clone() : null;
        copy.isDeleted = this.isDeleted;
        copy.isNew = this.isNew;
        copy.lastModificationDate = this.lastModificationDate;
        copy.lastModificationUsername = this.lastModificationUsername;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetInfo other)) return false;
        return java.util.Objects.equals(this.path, other.path) && java.util.Objects.equals(this.oldPath, other.oldPath) && this.isDeleted == other.isDeleted && this.isNew == other.isNew && this.lastModificationDate == other.lastModificationDate && java.util.Objects.equals(this.lastModificationUsername, other.lastModificationUsername);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(path, oldPath, isDeleted, isNew, lastModificationDate, lastModificationUsername);
    }

}