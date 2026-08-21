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


public class ItemCategory {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 5;
    public static final int VARIABLE_BLOCK_START = 26;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String id;
    @Nullable public String name;
    @Nullable public String icon;
    public int order;
    @Nonnull public ItemGridInfoDisplayMode infoDisplayMode = ItemGridInfoDisplayMode.Tooltip;
    @Nullable public ItemCategory[] children;
    @Nullable public SubCategoryDefinition[] subCategories;

    public ItemCategory() {
    }

    public ItemCategory(@Nullable String id, @Nullable String name, @Nullable String icon, int order, @Nonnull ItemGridInfoDisplayMode infoDisplayMode, @Nullable ItemCategory[] children, @Nullable SubCategoryDefinition[] subCategories) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.order = order;
        this.infoDisplayMode = infoDisplayMode;
        this.children = children;
        this.subCategories = subCategories;
    }

    public ItemCategory(@Nonnull ItemCategory other) {
        this.id = other.id;
        this.name = other.name;
        this.icon = other.icon;
        this.order = other.order;
        this.infoDisplayMode = other.infoDisplayMode;
        this.children = other.children;
        this.subCategories = other.subCategories;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemCategory", offset, (int) mem.byteSize());
        long needed = (long) offset + 26;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemCategory", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 6, 26, "Id"), 4096000): null;
    }
    
    @Nullable
    public static String getName(MemorySegment mem) {
        return getName(mem, 0);
    }
    
    @Nullable
    public static String getName(MemorySegment mem, int offset) {
        return hasName(mem, offset) ? PacketIO.readVarString("Name", mem, offset + getValidatedOffset(mem, offset, 10, 26, "Name"), 4096000): null;
    }
    
    @Nullable
    public static String getIcon(MemorySegment mem) {
        return getIcon(mem, 0);
    }
    
    @Nullable
    public static String getIcon(MemorySegment mem, int offset) {
        return hasIcon(mem, offset) ? PacketIO.readVarString("Icon", mem, offset + getValidatedOffset(mem, offset, 14, 26, "Icon"), 4096000): null;
    }
    
    public static int getOrder(MemorySegment mem) {
        return getOrder(mem, 0);
    }
    
    public static int getOrder(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static ItemGridInfoDisplayMode getInfoDisplayMode(MemorySegment mem) {
        return getInfoDisplayMode(mem, 0);
    }
    
    public static ItemGridInfoDisplayMode getInfoDisplayMode(MemorySegment mem, int offset) {
        return ItemGridInfoDisplayMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 5));
    }
    
    @Nullable
    public static ItemCategory[] getChildren(MemorySegment mem) {
        return getChildren(mem, 0);
    }
    
    @Nullable
    public static ItemCategory[] getChildren(MemorySegment mem, int offset) {
        if (!hasChildren(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 18, 26, "Children");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Children");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Children", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 26 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Children", (int) java.lang.Math.min(off + lenOffset + (long) len * 26, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ItemCategory[len];
        for (var i = 0; i < len; i++) {
            data[i] = ItemCategory.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static SubCategoryDefinition[] getSubCategories(MemorySegment mem) {
        return getSubCategories(mem, 0);
    }
    
    @Nullable
    public static SubCategoryDefinition[] getSubCategories(MemorySegment mem, int offset) {
        if (!hasSubCategories(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 22, 26, "SubCategories");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("SubCategories");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("SubCategories", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SubCategories", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new SubCategoryDefinition[len];
        for (var i = 0; i < len; i++) {
            data[i] = SubCategoryDefinition.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasIcon(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasChildren(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasSubCategories(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
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
    
    public static ItemCategory toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemCategory toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemCategory and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemCategory toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 26;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 6, -1, "Id");
        }
        
        String v1 = null;
        if (hasName(mem, offset)) {
            requireSlot(mem, offset + 10, varPos, "Name");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Name", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 10, -1, "Name");
        }
        
        String v2 = null;
        if (hasIcon(mem, offset)) {
            requireSlot(mem, offset + 14, varPos, "Icon");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("Icon", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 14, -1, "Icon");
        }
        
        ItemCategory[] v5 = null;
        if (hasChildren(mem, offset)) {
            requireSlot(mem, offset + 18, varPos, "Children");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Children");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Children", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 26 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Children", (int) java.lang.Math.min(off + lenOffset + (long) len * 26, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v5 = new ItemCategory[len];
            for (var i = 0; i < len; i++) {
                v5[i] = ItemCategory.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 18, -1, "Children");
        }
        
        SubCategoryDefinition[] v6 = null;
        if (hasSubCategories(mem, offset)) {
            requireSlot(mem, offset + 22, varPos, "SubCategories");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("SubCategories");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("SubCategories", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SubCategories", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v6 = new SubCategoryDefinition[len];
            for (var i = 0; i < len; i++) {
                v6[i] = SubCategoryDefinition.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 22, -1, "SubCategories");
        }
        var result = new ItemCategory(
            v0,
            v1,
            v2,
            mem.get(PacketIO.PROTO_INT, offset + 1),
            ItemGridInfoDisplayMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 5)),
            v5,
            v6
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        if (this.name != null) nullBits |= 0x02;
        if (this.icon != null) nullBits |= 0x04;
        if (this.children != null) nullBits |= 0x08;
        if (this.subCategories != null) nullBits |= 0x10;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.order);
        mem.set(PacketIO.PROTO_BYTE, offset + 5, (byte) this.infoDisplayMode.getValue());
        var varOffset = offset + 26;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 26);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
        if (this.name != null) {
            mem.set(PacketIO.PROTO_INT, offset + 10, varOffset - offset - 26);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.name, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 10, -1);
        }
        if (this.icon != null) {
            mem.set(PacketIO.PROTO_INT, offset + 14, varOffset - offset - 26);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.icon, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 14, -1);
        }
        if (this.children != null) {
            mem.set(PacketIO.PROTO_INT, offset + 18, varOffset - offset - 26);
            if (children.length > 4096000) throw ProtocolException.arrayTooLong("Children", children.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.children.length);
            
            var childrenValueOffset = 0;
            for (var i = 0; i < this.children.length; i++) {
                childrenValueOffset += this.children[i].serialize(mem, varOffset + childrenValueOffset);
            }
            varOffset += childrenValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 18, -1);
        }
        if (this.subCategories != null) {
            mem.set(PacketIO.PROTO_INT, offset + 22, varOffset - offset - 26);
            if (subCategories.length > 4096000) throw ProtocolException.arrayTooLong("SubCategories", subCategories.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.subCategories.length);
            
            var subCategoriesValueOffset = 0;
            for (var i = 0; i < this.subCategories.length; i++) {
                subCategoriesValueOffset += this.subCategories[i].serialize(mem, varOffset + subCategoriesValueOffset);
            }
            varOffset += subCategoriesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 22, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 26;
        if (id != null) size += PacketIO.stringSize(id);
    if (name != null) size += PacketIO.stringSize(name);
    if (icon != null) size += PacketIO.stringSize(icon);
    if (children != null) {
        int childrenSize = 0;
for (var elem : children) childrenSize += elem.computeSize();
size += VarInt.size(children.length) + childrenSize;
    }
    if (subCategories != null) {
        int subCategoriesSize = 0;
for (var elem : subCategories) subCategoriesSize += elem.computeSize();
size += VarInt.size(subCategories.length) + subCategoriesSize;
    }

        return size;
    }

    public ItemCategory clone() {
        ItemCategory copy = new ItemCategory();
        copy.id = this.id;
        copy.name = this.name;
        copy.icon = this.icon;
        copy.order = this.order;
        copy.infoDisplayMode = this.infoDisplayMode;
        copy.children = this.children != null ? java.util.Arrays.stream(this.children).map(e -> e.clone()).toArray(ItemCategory[]::new) : null;
        copy.subCategories = this.subCategories != null ? java.util.Arrays.stream(this.subCategories).map(e -> e.clone()).toArray(SubCategoryDefinition[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemCategory other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.name, other.name) && java.util.Objects.equals(this.icon, other.icon) && this.order == other.order && java.util.Objects.equals(this.infoDisplayMode, other.infoDisplayMode) && java.util.Arrays.equals(this.children, other.children) && java.util.Arrays.equals(this.subCategories, other.subCategories);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(id);
        result = 31 * result + java.util.Objects.hashCode(name);
        result = 31 * result + java.util.Objects.hashCode(icon);
        result = 31 * result + Integer.hashCode(order);
        result = 31 * result + java.util.Objects.hashCode(infoDisplayMode);
        result = 31 * result + java.util.Arrays.hashCode(children);
        result = 31 * result + java.util.Arrays.hashCode(subCategories);
        return result;
    }

}