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


public class BlockBreaking {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 13;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 25;
    public static final int MAX_SIZE = 49152040;

    @Nullable public String gatherType;
    public float health;
    public int quantity = 1;
    public int quality;
    @Nullable public String itemId;
    @Nullable public String dropListId;

    public BlockBreaking() {
    }

    public BlockBreaking(@Nullable String gatherType, float health, int quantity, int quality, @Nullable String itemId, @Nullable String dropListId) {
        this.gatherType = gatherType;
        this.health = health;
        this.quantity = quantity;
        this.quality = quality;
        this.itemId = itemId;
        this.dropListId = dropListId;
    }

    public BlockBreaking(@Nonnull BlockBreaking other) {
        this.gatherType = other.gatherType;
        this.health = other.health;
        this.quantity = other.quantity;
        this.quality = other.quality;
        this.itemId = other.itemId;
        this.dropListId = other.dropListId;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BlockBreaking", offset, (int) mem.byteSize());
        long needed = (long) offset + 25;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockBreaking", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getGatherType(MemorySegment mem) {
        return getGatherType(mem, 0);
    }
    
    @Nullable
    public static String getGatherType(MemorySegment mem, int offset) {
        return hasGatherType(mem, offset) ? PacketIO.readVarString("GatherType", mem, offset + getValidatedOffset(mem, offset, 13, 25, "GatherType"), 4096000): null;
    }
    
    public static float getHealth(MemorySegment mem) {
        return getHealth(mem, 0);
    }
    
    public static float getHealth(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Health");
    }
    
    public static int getQuantity(MemorySegment mem) {
        return getQuantity(mem, 0);
    }
    
    public static int getQuantity(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static int getQuality(MemorySegment mem) {
        return getQuality(mem, 0);
    }
    
    public static int getQuality(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 9);
    }
    
    @Nullable
    public static String getItemId(MemorySegment mem) {
        return getItemId(mem, 0);
    }
    
    @Nullable
    public static String getItemId(MemorySegment mem, int offset) {
        return hasItemId(mem, offset) ? PacketIO.readVarString("ItemId", mem, offset + getValidatedOffset(mem, offset, 17, 25, "ItemId"), 4096000): null;
    }
    
    @Nullable
    public static String getDropListId(MemorySegment mem) {
        return getDropListId(mem, 0);
    }
    
    @Nullable
    public static String getDropListId(MemorySegment mem, int offset) {
        return hasDropListId(mem, offset) ? PacketIO.readVarString("DropListId", mem, offset + getValidatedOffset(mem, offset, 21, 25, "DropListId"), 4096000): null;
    }
    
    public static boolean hasGatherType(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasItemId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasDropListId(MemorySegment mem, int offset) {
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
    
    public static BlockBreaking toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BlockBreaking toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BlockBreaking and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BlockBreaking toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 25;
        var varPos = 0;
        String v0 = null;
        if (hasGatherType(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "GatherType");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("GatherType", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 13, -1, "GatherType");
        }
        
        String v4 = null;
        if (hasItemId(mem, offset)) {
            requireSlot(mem, offset + 17, varPos, "ItemId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v4 = PacketIO.readVarString("ItemId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 17, -1, "ItemId");
        }
        
        String v5 = null;
        if (hasDropListId(mem, offset)) {
            requireSlot(mem, offset + 21, varPos, "DropListId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v5 = PacketIO.readVarString("DropListId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 21, -1, "DropListId");
        }
        var result = new BlockBreaking(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Health"),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            mem.get(PacketIO.PROTO_INT, offset + 9),
            v4,
            v5
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.gatherType != null) nullBits |= 0x01;
        if (this.itemId != null) nullBits |= 0x02;
        if (this.dropListId != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.health, "Health"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.health);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.quantity);
        mem.set(PacketIO.PROTO_INT, offset + 9, this.quality);
        var varOffset = offset + 25;
        if (this.gatherType != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 25);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.gatherType, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
        if (this.itemId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 17, varOffset - offset - 25);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.itemId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 17, -1);
        }
        if (this.dropListId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 21, varOffset - offset - 25);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.dropListId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 21, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 25;
        if (gatherType != null) size += PacketIO.stringSize(gatherType);
    if (itemId != null) size += PacketIO.stringSize(itemId);
    if (dropListId != null) size += PacketIO.stringSize(dropListId);

        return size;
    }

    public BlockBreaking clone() {
        BlockBreaking copy = new BlockBreaking();
        copy.gatherType = this.gatherType;
        copy.health = this.health;
        copy.quantity = this.quantity;
        copy.quality = this.quality;
        copy.itemId = this.itemId;
        copy.dropListId = this.dropListId;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BlockBreaking other)) return false;
        return java.util.Objects.equals(this.gatherType, other.gatherType) && this.health == other.health && this.quantity == other.quantity && this.quality == other.quality && java.util.Objects.equals(this.itemId, other.itemId) && java.util.Objects.equals(this.dropListId, other.dropListId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(gatherType, health, quantity, quality, itemId, dropListId);
    }

}