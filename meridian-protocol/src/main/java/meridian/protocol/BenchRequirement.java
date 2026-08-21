// Auto-generated - do not edit
package meridian.protocol;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class BenchRequirement {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 18;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public BenchType type = BenchType.Crafting;
    @Nonnull public String id = "";
    @Nullable public String[] categories;
    public int requiredTierLevel;
    @Nullable public String[] requiredAugmentTags;

    public BenchRequirement() {
    }

    public BenchRequirement(@Nonnull BenchType type, @Nonnull String id, @Nullable String[] categories, int requiredTierLevel, @Nullable String[] requiredAugmentTags) {
        this.type = type;
        this.id = id;
        this.categories = categories;
        this.requiredTierLevel = requiredTierLevel;
        this.requiredAugmentTags = requiredAugmentTags;
    }

    public BenchRequirement(@Nonnull BenchRequirement other) {
        this.type = other.type;
        this.id = other.id;
        this.categories = other.categories;
        this.requiredTierLevel = other.requiredTierLevel;
        this.requiredAugmentTags = other.requiredAugmentTags;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BenchRequirement", offset, (int) mem.byteSize());
        long needed = (long) offset + 18;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BenchRequirement", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static BenchType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static BenchType getType(MemorySegment mem, int offset) {
        return BenchType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    public static String getId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 6, 18, "Id"), 4096000);
    }
    
    @Nullable
    public static String[] getCategories(MemorySegment mem) {
        return getCategories(mem, 0);
    }
    
    @Nullable
    public static String[] getCategories(MemorySegment mem, int offset) {
        if (!hasCategories(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 10, 18, "Categories");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Categories");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Categories", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Categories", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("Categories", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    public static int getRequiredTierLevel(MemorySegment mem) {
        return getRequiredTierLevel(mem, 0);
    }
    
    public static int getRequiredTierLevel(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 2);
    }
    
    @Nullable
    public static String[] getRequiredAugmentTags(MemorySegment mem) {
        return getRequiredAugmentTags(mem, 0);
    }
    
    @Nullable
    public static String[] getRequiredAugmentTags(MemorySegment mem, int offset) {
        if (!hasRequiredAugmentTags(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 14, 18, "RequiredAugmentTags");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("RequiredAugmentTags");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("RequiredAugmentTags", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("RequiredAugmentTags", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("RequiredAugmentTags", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    public static boolean hasCategories(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasRequiredAugmentTags(MemorySegment mem, int offset) {
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
    
    public static BenchRequirement toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BenchRequirement toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BenchRequirement and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BenchRequirement toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 18;
        var varPos = 0;
        String v1;
        requireSlot(mem, offset + 6, varPos, "Id");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        String[] v2 = null;
        if (hasCategories(mem, offset)) {
            requireSlot(mem, offset + 10, varPos, "Categories");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Categories");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Categories", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Categories", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v2[i] = PacketIO.readVarString("Categories", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 10, -1, "Categories");
        }
        
        String[] v4 = null;
        if (hasRequiredAugmentTags(mem, offset)) {
            requireSlot(mem, offset + 14, varPos, "RequiredAugmentTags");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("RequiredAugmentTags");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("RequiredAugmentTags", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("RequiredAugmentTags", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v4 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v4[i] = PacketIO.readVarString("RequiredAugmentTags", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 14, -1, "RequiredAugmentTags");
        }
        var result = new BenchRequirement(
            BenchType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v1,
            v2,
            mem.get(PacketIO.PROTO_INT, offset + 2),
            v4
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.categories != null) nullBits |= 0x01;
        if (this.requiredAugmentTags != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 2, this.requiredTierLevel);
        var varOffset = offset + 18;
        mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 18);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        if (this.categories != null) {
            mem.set(PacketIO.PROTO_INT, offset + 10, varOffset - offset - 18);
            if (categories.length > 4096000) throw ProtocolException.arrayTooLong("Categories", categories.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.categories.length);
            
            var categoriesValueOffset = 0;
            for (var i = 0; i < this.categories.length; i++) {
                categoriesValueOffset += PacketIO.writeVarString(mem, varOffset + categoriesValueOffset, this.categories[i], 4096000);
            }
            varOffset += categoriesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 10, -1);
        }
        if (this.requiredAugmentTags != null) {
            mem.set(PacketIO.PROTO_INT, offset + 14, varOffset - offset - 18);
            if (requiredAugmentTags.length > 4096000) throw ProtocolException.arrayTooLong("RequiredAugmentTags", requiredAugmentTags.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.requiredAugmentTags.length);
            
            var requiredAugmentTagsValueOffset = 0;
            for (var i = 0; i < this.requiredAugmentTags.length; i++) {
                requiredAugmentTagsValueOffset += PacketIO.writeVarString(mem, varOffset + requiredAugmentTagsValueOffset, this.requiredAugmentTags[i], 4096000);
            }
            varOffset += requiredAugmentTagsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 14, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 18;
        size += PacketIO.stringSize(id);
    if (categories != null) {
        int categoriesSize = 0;
for (var elem : categories) categoriesSize += PacketIO.stringSize(elem);
size += VarInt.size(categories.length) + categoriesSize;
    }
    if (requiredAugmentTags != null) {
        int requiredAugmentTagsSize = 0;
for (var elem : requiredAugmentTags) requiredAugmentTagsSize += PacketIO.stringSize(elem);
size += VarInt.size(requiredAugmentTags.length) + requiredAugmentTagsSize;
    }

        return size;
    }

    public BenchRequirement clone() {
        BenchRequirement copy = new BenchRequirement();
        copy.type = this.type;
        copy.id = this.id;
        copy.categories = this.categories != null ? java.util.Arrays.copyOf(this.categories, this.categories.length) : null;
        copy.requiredTierLevel = this.requiredTierLevel;
        copy.requiredAugmentTags = this.requiredAugmentTags != null ? java.util.Arrays.copyOf(this.requiredAugmentTags, this.requiredAugmentTags.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BenchRequirement other)) return false;
        return java.util.Objects.equals(this.type, other.type) && java.util.Objects.equals(this.id, other.id) && java.util.Arrays.equals(this.categories, other.categories) && this.requiredTierLevel == other.requiredTierLevel && java.util.Arrays.equals(this.requiredAugmentTags, other.requiredAugmentTags);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(type);
        result = 31 * result + java.util.Objects.hashCode(id);
        result = 31 * result + java.util.Arrays.hashCode(categories);
        result = 31 * result + Integer.hashCode(requiredTierLevel);
        result = 31 * result + java.util.Arrays.hashCode(requiredAugmentTags);
        return result;
    }

}