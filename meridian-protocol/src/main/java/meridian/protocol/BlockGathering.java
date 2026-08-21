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


public class BlockGathering {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 114688092;

    @Nullable public BlockBreaking breaking;
    @Nullable public Harvesting harvest;
    @Nullable public SoftBlock soft;

    public BlockGathering() {
    }

    public BlockGathering(@Nullable BlockBreaking breaking, @Nullable Harvesting harvest, @Nullable SoftBlock soft) {
        this.breaking = breaking;
        this.harvest = harvest;
        this.soft = soft;
    }

    public BlockGathering(@Nonnull BlockGathering other) {
        this.breaking = other.breaking;
        this.harvest = other.harvest;
        this.soft = other.soft;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BlockGathering", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockGathering", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static BlockBreaking getBreaking(MemorySegment mem) {
        return getBreaking(mem, 0);
    }
    
    @Nullable
    public static BlockBreaking getBreaking(MemorySegment mem, int offset) {
        return hasBreaking(mem, offset) ? BlockBreaking.toObject(mem, offset + getValidatedOffset(mem, offset, 1, 13, "Breaking")): null;
    }
    
    @Nullable
    public static Harvesting getHarvest(MemorySegment mem) {
        return getHarvest(mem, 0);
    }
    
    @Nullable
    public static Harvesting getHarvest(MemorySegment mem, int offset) {
        return hasHarvest(mem, offset) ? Harvesting.toObject(mem, offset + getValidatedOffset(mem, offset, 5, 13, "Harvest")): null;
    }
    
    @Nullable
    public static SoftBlock getSoft(MemorySegment mem) {
        return getSoft(mem, 0);
    }
    
    @Nullable
    public static SoftBlock getSoft(MemorySegment mem, int offset) {
        return hasSoft(mem, offset) ? SoftBlock.toObject(mem, offset + getValidatedOffset(mem, offset, 9, 13, "Soft")): null;
    }
    
    public static boolean hasBreaking(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasHarvest(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasSoft(MemorySegment mem, int offset) {
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
    
    public static BlockGathering toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BlockGathering toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BlockGathering and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BlockGathering toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 13;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        BlockBreaking v0 = null;
        if (hasBreaking(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "Breaking");
            v0 = BlockBreaking.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 1, -1, "Breaking");
        }
        
        Harvesting v1 = null;
        if (hasHarvest(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Harvest");
            v1 = Harvesting.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "Harvest");
        }
        
        SoftBlock v2 = null;
        if (hasSoft(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "Soft");
            v2 = SoftBlock.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 9, -1, "Soft");
        }
        var result = new BlockGathering(
            v0,
            v1,
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.breaking != null) nullBits |= 0x01;
        if (this.harvest != null) nullBits |= 0x02;
        if (this.soft != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 13;
        if (this.breaking != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 13);
            varOffset += this.breaking.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.harvest != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 13);
            varOffset += this.harvest.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.soft != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 13);
            varOffset += this.soft.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 13;
        if (breaking != null) size += breaking.computeSize();
    if (harvest != null) size += harvest.computeSize();
    if (soft != null) size += soft.computeSize();

        return size;
    }

    public BlockGathering clone() {
        BlockGathering copy = new BlockGathering();
        copy.breaking = this.breaking != null ? this.breaking.clone() : null;
        copy.harvest = this.harvest != null ? this.harvest.clone() : null;
        copy.soft = this.soft != null ? this.soft.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BlockGathering other)) return false;
        return java.util.Objects.equals(this.breaking, other.breaking) && java.util.Objects.equals(this.harvest, other.harvest) && java.util.Objects.equals(this.soft, other.soft);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(breaking, harvest, soft);
    }

}