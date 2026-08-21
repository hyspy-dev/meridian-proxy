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


public class ItemWithAllMetadata {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 26;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 34;
    public static final int MAX_SIZE = 32768044;

    @Nonnull public String itemId = "";
    public int quantity;
    public double durability;
    public double maxDurability;
    public int quality;
    public boolean overrideDroppedItemAnimation;
    @Nullable public String metadata;

    public ItemWithAllMetadata() {
    }

    public ItemWithAllMetadata(@Nonnull String itemId, int quantity, double durability, double maxDurability, int quality, boolean overrideDroppedItemAnimation, @Nullable String metadata) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.durability = durability;
        this.maxDurability = maxDurability;
        this.quality = quality;
        this.overrideDroppedItemAnimation = overrideDroppedItemAnimation;
        this.metadata = metadata;
    }

    public ItemWithAllMetadata(@Nonnull ItemWithAllMetadata other) {
        this.itemId = other.itemId;
        this.quantity = other.quantity;
        this.durability = other.durability;
        this.maxDurability = other.maxDurability;
        this.quality = other.quality;
        this.overrideDroppedItemAnimation = other.overrideDroppedItemAnimation;
        this.metadata = other.metadata;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemWithAllMetadata", offset, (int) mem.byteSize());
        long needed = (long) offset + 34;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemWithAllMetadata", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getItemId(MemorySegment mem) {
        return getItemId(mem, 0);
    }
    
    public static String getItemId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("ItemId", mem, offset + getValidatedOffset(mem, offset, 26, 34, "ItemId"), 4096000);
    }
    
    public static int getQuantity(MemorySegment mem) {
        return getQuantity(mem, 0);
    }
    
    public static int getQuantity(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static double getDurability(MemorySegment mem) {
        return getDurability(mem, 0);
    }
    
    public static double getDurability(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 5), "Durability");
    }
    
    public static double getMaxDurability(MemorySegment mem) {
        return getMaxDurability(mem, 0);
    }
    
    public static double getMaxDurability(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 13), "MaxDurability");
    }
    
    public static int getQuality(MemorySegment mem) {
        return getQuality(mem, 0);
    }
    
    public static int getQuality(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 21);
    }
    
    public static boolean getOverrideDroppedItemAnimation(MemorySegment mem) {
        return getOverrideDroppedItemAnimation(mem, 0);
    }
    
    public static boolean getOverrideDroppedItemAnimation(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 25);
    }
    
    @Nullable
    public static String getMetadata(MemorySegment mem) {
        return getMetadata(mem, 0);
    }
    
    @Nullable
    public static String getMetadata(MemorySegment mem, int offset) {
        return hasMetadata(mem, offset) ? PacketIO.readVarString("Metadata", mem, offset + getValidatedOffset(mem, offset, 30, 34, "Metadata"), 4096000): null;
    }
    
    public static boolean hasMetadata(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
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
    
    public static ItemWithAllMetadata toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemWithAllMetadata toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemWithAllMetadata and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemWithAllMetadata toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 34;
        var varPos = 0;
        String v0;
        requireSlot(mem, offset + 26, varPos, "ItemId");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("ItemId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        String v6 = null;
        if (hasMetadata(mem, offset)) {
            requireSlot(mem, offset + 30, varPos, "Metadata");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v6 = PacketIO.readVarString("Metadata", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 30, -1, "Metadata");
        }
        var result = new ItemWithAllMetadata(
            v0,
            mem.get(PacketIO.PROTO_INT, offset + 1),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 5), "Durability"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 13), "MaxDurability"),
            mem.get(PacketIO.PROTO_INT, offset + 21),
            mem.get(PacketIO.PROTO_BOOL, offset + 25),
            v6
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.metadata != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.quantity);
        PacketIO.requireFinite(this.durability, "Durability"); mem.set(PacketIO.PROTO_DOUBLE, offset + 5, this.durability);
        PacketIO.requireFinite(this.maxDurability, "MaxDurability"); mem.set(PacketIO.PROTO_DOUBLE, offset + 13, this.maxDurability);
        mem.set(PacketIO.PROTO_INT, offset + 21, this.quality);
        mem.set(PacketIO.PROTO_BOOL, offset + 25, this.overrideDroppedItemAnimation);
        var varOffset = offset + 34;
        mem.set(PacketIO.PROTO_INT, offset + 26, varOffset - offset - 34);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.itemId, 4096000);
        if (this.metadata != null) {
            mem.set(PacketIO.PROTO_INT, offset + 30, varOffset - offset - 34);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.metadata, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 30, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 34;
        size += PacketIO.stringSize(itemId);
    if (metadata != null) size += PacketIO.stringSize(metadata);

        return size;
    }

    public ItemWithAllMetadata clone() {
        ItemWithAllMetadata copy = new ItemWithAllMetadata();
        copy.itemId = this.itemId;
        copy.quantity = this.quantity;
        copy.durability = this.durability;
        copy.maxDurability = this.maxDurability;
        copy.quality = this.quality;
        copy.overrideDroppedItemAnimation = this.overrideDroppedItemAnimation;
        copy.metadata = this.metadata;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemWithAllMetadata other)) return false;
        return java.util.Objects.equals(this.itemId, other.itemId) && this.quantity == other.quantity && this.durability == other.durability && this.maxDurability == other.maxDurability && this.quality == other.quality && this.overrideDroppedItemAnimation == other.overrideDroppedItemAnimation && java.util.Objects.equals(this.metadata, other.metadata);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(itemId, quantity, durability, maxDurability, quality, overrideDroppedItemAnimation, metadata);
    }

}