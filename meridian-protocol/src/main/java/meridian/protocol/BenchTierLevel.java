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


public class BenchTierLevel {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 17;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 17;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public BenchUpgradeRequirement benchUpgradeRequirement;
    public double craftingTimeReductionModifier;
    public int extraInputSlot;
    public int extraOutputSlot;

    public BenchTierLevel() {
    }

    public BenchTierLevel(@Nullable BenchUpgradeRequirement benchUpgradeRequirement, double craftingTimeReductionModifier, int extraInputSlot, int extraOutputSlot) {
        this.benchUpgradeRequirement = benchUpgradeRequirement;
        this.craftingTimeReductionModifier = craftingTimeReductionModifier;
        this.extraInputSlot = extraInputSlot;
        this.extraOutputSlot = extraOutputSlot;
    }

    public BenchTierLevel(@Nonnull BenchTierLevel other) {
        this.benchUpgradeRequirement = other.benchUpgradeRequirement;
        this.craftingTimeReductionModifier = other.craftingTimeReductionModifier;
        this.extraInputSlot = other.extraInputSlot;
        this.extraOutputSlot = other.extraOutputSlot;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BenchTierLevel", offset, (int) mem.byteSize());
        long needed = (long) offset + 17;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BenchTierLevel", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static BenchUpgradeRequirement getBenchUpgradeRequirement(MemorySegment mem) {
        return getBenchUpgradeRequirement(mem, 0);
    }
    
    @Nullable
    public static BenchUpgradeRequirement getBenchUpgradeRequirement(MemorySegment mem, int offset) {
        return hasBenchUpgradeRequirement(mem, offset) ? BenchUpgradeRequirement.toObject(mem, offset + 17): null;
    }
    
    public static double getCraftingTimeReductionModifier(MemorySegment mem) {
        return getCraftingTimeReductionModifier(mem, 0);
    }
    
    public static double getCraftingTimeReductionModifier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 1), "CraftingTimeReductionModifier");
    }
    
    public static int getExtraInputSlot(MemorySegment mem) {
        return getExtraInputSlot(mem, 0);
    }
    
    public static int getExtraInputSlot(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 9);
    }
    
    public static int getExtraOutputSlot(MemorySegment mem) {
        return getExtraOutputSlot(mem, 0);
    }
    
    public static int getExtraOutputSlot(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 13);
    }
    
    public static boolean hasBenchUpgradeRequirement(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static BenchTierLevel toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BenchTierLevel toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BenchTierLevel and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BenchTierLevel toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 17;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        BenchUpgradeRequirement v0 = null;
        if (hasBenchUpgradeRequirement(mem, offset)) {
            v0 = BenchUpgradeRequirement.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new BenchTierLevel(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 1), "CraftingTimeReductionModifier"),
            mem.get(PacketIO.PROTO_INT, offset + 9),
            mem.get(PacketIO.PROTO_INT, offset + 13)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.benchUpgradeRequirement != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.craftingTimeReductionModifier, "CraftingTimeReductionModifier"); mem.set(PacketIO.PROTO_DOUBLE, offset + 1, this.craftingTimeReductionModifier);
        mem.set(PacketIO.PROTO_INT, offset + 9, this.extraInputSlot);
        mem.set(PacketIO.PROTO_INT, offset + 13, this.extraOutputSlot);
        var varOffset = offset + 17;
        if (this.benchUpgradeRequirement != null) {
            
            varOffset += this.benchUpgradeRequirement.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 17;
        if (benchUpgradeRequirement != null) size += benchUpgradeRequirement.computeSize();

        return size;
    }

    public BenchTierLevel clone() {
        BenchTierLevel copy = new BenchTierLevel();
        copy.benchUpgradeRequirement = this.benchUpgradeRequirement != null ? this.benchUpgradeRequirement.clone() : null;
        copy.craftingTimeReductionModifier = this.craftingTimeReductionModifier;
        copy.extraInputSlot = this.extraInputSlot;
        copy.extraOutputSlot = this.extraOutputSlot;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BenchTierLevel other)) return false;
        return java.util.Objects.equals(this.benchUpgradeRequirement, other.benchUpgradeRequirement) && this.craftingTimeReductionModifier == other.craftingTimeReductionModifier && this.extraInputSlot == other.extraInputSlot && this.extraOutputSlot == other.extraOutputSlot;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(benchUpgradeRequirement, craftingTimeReductionModifier, extraInputSlot, extraOutputSlot);
    }

}