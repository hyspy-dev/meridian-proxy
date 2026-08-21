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


public class ItemQuality {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 7;
    public static final int VARIABLE_BLOCK_START = 33;
    public static final int MAX_SIZE = 114688068;

    @Nullable public String id;
    @Nullable public String itemTooltipTexture;
    @Nullable public String itemTooltipArrowTexture;
    @Nullable public String slotTexture;
    @Nullable public String blockSlotTexture;
    @Nullable public String specialSlotTexture;
    @Nullable public Color textColor;
    @Nullable public String localizationKey;
    public boolean visibleQualityLabel;
    public boolean renderSpecialSlot;
    public boolean hideFromSearch;

    public ItemQuality() {
    }

    public ItemQuality(@Nullable String id, @Nullable String itemTooltipTexture, @Nullable String itemTooltipArrowTexture, @Nullable String slotTexture, @Nullable String blockSlotTexture, @Nullable String specialSlotTexture, @Nullable Color textColor, @Nullable String localizationKey, boolean visibleQualityLabel, boolean renderSpecialSlot, boolean hideFromSearch) {
        this.id = id;
        this.itemTooltipTexture = itemTooltipTexture;
        this.itemTooltipArrowTexture = itemTooltipArrowTexture;
        this.slotTexture = slotTexture;
        this.blockSlotTexture = blockSlotTexture;
        this.specialSlotTexture = specialSlotTexture;
        this.textColor = textColor;
        this.localizationKey = localizationKey;
        this.visibleQualityLabel = visibleQualityLabel;
        this.renderSpecialSlot = renderSpecialSlot;
        this.hideFromSearch = hideFromSearch;
    }

    public ItemQuality(@Nonnull ItemQuality other) {
        this.id = other.id;
        this.itemTooltipTexture = other.itemTooltipTexture;
        this.itemTooltipArrowTexture = other.itemTooltipArrowTexture;
        this.slotTexture = other.slotTexture;
        this.blockSlotTexture = other.blockSlotTexture;
        this.specialSlotTexture = other.specialSlotTexture;
        this.textColor = other.textColor;
        this.localizationKey = other.localizationKey;
        this.visibleQualityLabel = other.visibleQualityLabel;
        this.renderSpecialSlot = other.renderSpecialSlot;
        this.hideFromSearch = other.hideFromSearch;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemQuality", offset, (int) mem.byteSize());
        long needed = (long) offset + 33;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemQuality", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 5, 33, "Id"), 4096000): null;
    }
    
    @Nullable
    public static String getItemTooltipTexture(MemorySegment mem) {
        return getItemTooltipTexture(mem, 0);
    }
    
    @Nullable
    public static String getItemTooltipTexture(MemorySegment mem, int offset) {
        return hasItemTooltipTexture(mem, offset) ? PacketIO.readVarString("ItemTooltipTexture", mem, offset + getValidatedOffset(mem, offset, 9, 33, "ItemTooltipTexture"), 4096000): null;
    }
    
    @Nullable
    public static String getItemTooltipArrowTexture(MemorySegment mem) {
        return getItemTooltipArrowTexture(mem, 0);
    }
    
    @Nullable
    public static String getItemTooltipArrowTexture(MemorySegment mem, int offset) {
        return hasItemTooltipArrowTexture(mem, offset) ? PacketIO.readVarString("ItemTooltipArrowTexture", mem, offset + getValidatedOffset(mem, offset, 13, 33, "ItemTooltipArrowTexture"), 4096000): null;
    }
    
    @Nullable
    public static String getSlotTexture(MemorySegment mem) {
        return getSlotTexture(mem, 0);
    }
    
    @Nullable
    public static String getSlotTexture(MemorySegment mem, int offset) {
        return hasSlotTexture(mem, offset) ? PacketIO.readVarString("SlotTexture", mem, offset + getValidatedOffset(mem, offset, 17, 33, "SlotTexture"), 4096000): null;
    }
    
    @Nullable
    public static String getBlockSlotTexture(MemorySegment mem) {
        return getBlockSlotTexture(mem, 0);
    }
    
    @Nullable
    public static String getBlockSlotTexture(MemorySegment mem, int offset) {
        return hasBlockSlotTexture(mem, offset) ? PacketIO.readVarString("BlockSlotTexture", mem, offset + getValidatedOffset(mem, offset, 21, 33, "BlockSlotTexture"), 4096000): null;
    }
    
    @Nullable
    public static String getSpecialSlotTexture(MemorySegment mem) {
        return getSpecialSlotTexture(mem, 0);
    }
    
    @Nullable
    public static String getSpecialSlotTexture(MemorySegment mem, int offset) {
        return hasSpecialSlotTexture(mem, offset) ? PacketIO.readVarString("SpecialSlotTexture", mem, offset + getValidatedOffset(mem, offset, 25, 33, "SpecialSlotTexture"), 4096000): null;
    }
    
    @Nullable
    public static Color getTextColor(MemorySegment mem) {
        return getTextColor(mem, 0);
    }
    
    @Nullable
    public static Color getTextColor(MemorySegment mem, int offset) {
        return hasTextColor(mem, offset) ? Color.toObject(mem, offset + 1): null;
    }
    
    @Nullable
    public static String getLocalizationKey(MemorySegment mem) {
        return getLocalizationKey(mem, 0);
    }
    
    @Nullable
    public static String getLocalizationKey(MemorySegment mem, int offset) {
        return hasLocalizationKey(mem, offset) ? PacketIO.readVarString("LocalizationKey", mem, offset + getValidatedOffset(mem, offset, 29, 33, "LocalizationKey"), 4096000): null;
    }
    
    public static boolean getVisibleQualityLabel(MemorySegment mem) {
        return getVisibleQualityLabel(mem, 0);
    }
    
    public static boolean getVisibleQualityLabel(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 4) & 0x01) != 0;
    }
    
    public static boolean getRenderSpecialSlot(MemorySegment mem) {
        return getRenderSpecialSlot(mem, 0);
    }
    
    public static boolean getRenderSpecialSlot(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 4) & 0x02) != 0;
    }
    
    public static boolean getHideFromSearch(MemorySegment mem) {
        return getHideFromSearch(mem, 0);
    }
    
    public static boolean getHideFromSearch(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 4) & 0x04) != 0;
    }
    
    public static boolean hasTextColor(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasItemTooltipTexture(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasItemTooltipArrowTexture(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasSlotTexture(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasBlockSlotTexture(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasSpecialSlotTexture(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasLocalizationKey(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
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
    
    public static ItemQuality toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemQuality toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemQuality and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemQuality toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 33;
        var varPos = 0;
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 5, -1, "Id");
        }
        
        String v1 = null;
        if (hasItemTooltipTexture(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "ItemTooltipTexture");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("ItemTooltipTexture", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 9, -1, "ItemTooltipTexture");
        }
        
        String v2 = null;
        if (hasItemTooltipArrowTexture(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "ItemTooltipArrowTexture");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("ItemTooltipArrowTexture", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 13, -1, "ItemTooltipArrowTexture");
        }
        
        String v3 = null;
        if (hasSlotTexture(mem, offset)) {
            requireSlot(mem, offset + 17, varPos, "SlotTexture");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readVarString("SlotTexture", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 17, -1, "SlotTexture");
        }
        
        String v4 = null;
        if (hasBlockSlotTexture(mem, offset)) {
            requireSlot(mem, offset + 21, varPos, "BlockSlotTexture");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v4 = PacketIO.readVarString("BlockSlotTexture", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 21, -1, "BlockSlotTexture");
        }
        
        String v5 = null;
        if (hasSpecialSlotTexture(mem, offset)) {
            requireSlot(mem, offset + 25, varPos, "SpecialSlotTexture");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v5 = PacketIO.readVarString("SpecialSlotTexture", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 25, -1, "SpecialSlotTexture");
        }
        
        String v7 = null;
        if (hasLocalizationKey(mem, offset)) {
            requireSlot(mem, offset + 29, varPos, "LocalizationKey");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v7 = PacketIO.readVarString("LocalizationKey", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 29, -1, "LocalizationKey");
        }
        var result = new ItemQuality(
            v0,
            v1,
            v2,
            v3,
            v4,
            v5,
            hasTextColor(mem, offset) ? Color.toObject(mem, offset + 1) : null,
            v7,
            (mem.get(PacketIO.PROTO_BYTE, offset + 4) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 4) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 4) & 0x04) != 0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.textColor != null) nullBits |= 0x01;
        if (this.id != null) nullBits |= 0x02;
        if (this.itemTooltipTexture != null) nullBits |= 0x04;
        if (this.itemTooltipArrowTexture != null) nullBits |= 0x08;
        if (this.slotTexture != null) nullBits |= 0x10;
        if (this.blockSlotTexture != null) nullBits |= 0x20;
        if (this.specialSlotTexture != null) nullBits |= 0x40;
        if (this.localizationKey != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.textColor != null) {
            this.textColor.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 3).fill((byte) 0); 
        }
        byte boolBits0_0 = 0;
        if (this.visibleQualityLabel) boolBits0_0 |= 0x01;
        if (this.renderSpecialSlot) boolBits0_0 |= 0x02;
        if (this.hideFromSearch) boolBits0_0 |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 4 + 0, boolBits0_0);
        var varOffset = offset + 33;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 33);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.itemTooltipTexture != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 33);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.itemTooltipTexture, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
        if (this.itemTooltipArrowTexture != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 33);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.itemTooltipArrowTexture, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
        if (this.slotTexture != null) {
            mem.set(PacketIO.PROTO_INT, offset + 17, varOffset - offset - 33);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.slotTexture, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 17, -1);
        }
        if (this.blockSlotTexture != null) {
            mem.set(PacketIO.PROTO_INT, offset + 21, varOffset - offset - 33);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.blockSlotTexture, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 21, -1);
        }
        if (this.specialSlotTexture != null) {
            mem.set(PacketIO.PROTO_INT, offset + 25, varOffset - offset - 33);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.specialSlotTexture, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 25, -1);
        }
        if (this.localizationKey != null) {
            mem.set(PacketIO.PROTO_INT, offset + 29, varOffset - offset - 33);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.localizationKey, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 29, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 33;
        if (id != null) size += PacketIO.stringSize(id);
    if (itemTooltipTexture != null) size += PacketIO.stringSize(itemTooltipTexture);
    if (itemTooltipArrowTexture != null) size += PacketIO.stringSize(itemTooltipArrowTexture);
    if (slotTexture != null) size += PacketIO.stringSize(slotTexture);
    if (blockSlotTexture != null) size += PacketIO.stringSize(blockSlotTexture);
    if (specialSlotTexture != null) size += PacketIO.stringSize(specialSlotTexture);
    if (localizationKey != null) size += PacketIO.stringSize(localizationKey);

        return size;
    }

    public ItemQuality clone() {
        ItemQuality copy = new ItemQuality();
        copy.id = this.id;
        copy.itemTooltipTexture = this.itemTooltipTexture;
        copy.itemTooltipArrowTexture = this.itemTooltipArrowTexture;
        copy.slotTexture = this.slotTexture;
        copy.blockSlotTexture = this.blockSlotTexture;
        copy.specialSlotTexture = this.specialSlotTexture;
        copy.textColor = this.textColor != null ? this.textColor.clone() : null;
        copy.localizationKey = this.localizationKey;
        copy.visibleQualityLabel = this.visibleQualityLabel;
        copy.renderSpecialSlot = this.renderSpecialSlot;
        copy.hideFromSearch = this.hideFromSearch;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemQuality other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.itemTooltipTexture, other.itemTooltipTexture) && java.util.Objects.equals(this.itemTooltipArrowTexture, other.itemTooltipArrowTexture) && java.util.Objects.equals(this.slotTexture, other.slotTexture) && java.util.Objects.equals(this.blockSlotTexture, other.blockSlotTexture) && java.util.Objects.equals(this.specialSlotTexture, other.specialSlotTexture) && java.util.Objects.equals(this.textColor, other.textColor) && java.util.Objects.equals(this.localizationKey, other.localizationKey) && this.visibleQualityLabel == other.visibleQualityLabel && this.renderSpecialSlot == other.renderSpecialSlot && this.hideFromSearch == other.hideFromSearch;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, itemTooltipTexture, itemTooltipArrowTexture, slotTexture, blockSlotTexture, specialSlotTexture, textColor, localizationKey, visibleQualityLabel, renderSpecialSlot, hideFromSearch);
    }

}