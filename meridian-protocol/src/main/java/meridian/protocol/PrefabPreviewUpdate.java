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
import meridian.protocol.packets.interface_.BlockChange;
import meridian.protocol.packets.interface_.FluidChange;

public class PrefabPreviewUpdate extends ComponentUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 13;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 21;
    public static final int MAX_SIZE = 139264031;

    @Nullable public BlockChange[] blocks;
    @Nullable public FluidChange[] fluids;
    public int visibleLayerCount;
    public int biomeTint;
    public int waterTint;

    public PrefabPreviewUpdate() {
    }

    public PrefabPreviewUpdate(@Nullable BlockChange[] blocks, @Nullable FluidChange[] fluids, int visibleLayerCount, int biomeTint, int waterTint) {
        this.blocks = blocks;
        this.fluids = fluids;
        this.visibleLayerCount = visibleLayerCount;
        this.biomeTint = biomeTint;
        this.waterTint = waterTint;
    }

    public PrefabPreviewUpdate(@Nonnull PrefabPreviewUpdate other) {
        this.blocks = other.blocks;
        this.fluids = other.fluids;
        this.visibleLayerCount = other.visibleLayerCount;
        this.biomeTint = other.biomeTint;
        this.waterTint = other.waterTint;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PrefabPreviewUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 21;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PrefabPreviewUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static BlockChange[] getBlocks(MemorySegment mem) {
        return getBlocks(mem, 0);
    }
    
    @Nullable
    public static BlockChange[] getBlocks(MemorySegment mem, int offset) {
        if (!hasBlocks(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 13, 21, "Blocks");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Blocks");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Blocks", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Blocks", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new BlockChange[len];
        for (var i = 0; i < len; i++) {
            data[i] = BlockChange.toObject(mem, off + i * 17);
        }
        return data;
    }
    
    @Nullable
    public static FluidChange[] getFluids(MemorySegment mem) {
        return getFluids(mem, 0);
    }
    
    @Nullable
    public static FluidChange[] getFluids(MemorySegment mem, int offset) {
        if (!hasFluids(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 17, 21, "Fluids");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Fluids");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Fluids", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Fluids", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new FluidChange[len];
        for (var i = 0; i < len; i++) {
            data[i] = FluidChange.toObject(mem, off + i * 17);
        }
        return data;
    }
    
    public static int getVisibleLayerCount(MemorySegment mem) {
        return getVisibleLayerCount(mem, 0);
    }
    
    public static int getVisibleLayerCount(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getBiomeTint(MemorySegment mem) {
        return getBiomeTint(mem, 0);
    }
    
    public static int getBiomeTint(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static int getWaterTint(MemorySegment mem) {
        return getWaterTint(mem, 0);
    }
    
    public static int getWaterTint(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 9);
    }
    
    public static boolean hasBlocks(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasFluids(MemorySegment mem, int offset) {
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
    
    public static PrefabPreviewUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PrefabPreviewUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PrefabPreviewUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PrefabPreviewUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 21;
        var varPos = 0;
        BlockChange[] v0 = null;
        if (hasBlocks(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "Blocks");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Blocks");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Blocks", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Blocks", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new BlockChange[len];
            for (var i = 0; i < len; i++) {
                v0[i] = BlockChange.toObject(mem, off + i * 17);
            }
            varPos = off + len * 17 - varBase;
        } else {
            requireSlot(mem, offset + 13, -1, "Blocks");
        }
        
        FluidChange[] v1 = null;
        if (hasFluids(mem, offset)) {
            requireSlot(mem, offset + 17, varPos, "Fluids");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Fluids");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Fluids", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Fluids", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new FluidChange[len];
            for (var i = 0; i < len; i++) {
                v1[i] = FluidChange.toObject(mem, off + i * 17);
            }
            varPos = off + len * 17 - varBase;
        } else {
            requireSlot(mem, offset + 17, -1, "Fluids");
        }
        var result = new PrefabPreviewUpdate(
            v0,
            v1,
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            mem.get(PacketIO.PROTO_INT, offset + 9)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.blocks != null) nullBits |= 0x01;
        if (this.fluids != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.visibleLayerCount);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.biomeTint);
        mem.set(PacketIO.PROTO_INT, offset + 9, this.waterTint);
        var varOffset = offset + 21;
        if (this.blocks != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 21);
            if (blocks.length > 4096000) throw ProtocolException.arrayTooLong("Blocks", blocks.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.blocks.length);
            
            var blocksValueOffset = 0;
            for (var i = 0; i < this.blocks.length; i++) {
                blocksValueOffset += this.blocks[i].serialize(mem, varOffset + blocksValueOffset);
            }
            varOffset += blocksValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
        if (this.fluids != null) {
            mem.set(PacketIO.PROTO_INT, offset + 17, varOffset - offset - 21);
            if (fluids.length > 4096000) throw ProtocolException.arrayTooLong("Fluids", fluids.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.fluids.length);
            
            var fluidsValueOffset = 0;
            for (var i = 0; i < this.fluids.length; i++) {
                fluidsValueOffset += this.fluids[i].serialize(mem, varOffset + fluidsValueOffset);
            }
            varOffset += fluidsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 17, -1);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 21;
        if (blocks != null) size += VarInt.size(blocks.length) + blocks.length * 17;
    if (fluids != null) size += VarInt.size(fluids.length) + fluids.length * 17;

        return size;
    }

    public PrefabPreviewUpdate clone() {
        PrefabPreviewUpdate copy = new PrefabPreviewUpdate();
        copy.blocks = this.blocks != null ? java.util.Arrays.stream(this.blocks).map(e -> e.clone()).toArray(BlockChange[]::new) : null;
        copy.fluids = this.fluids != null ? java.util.Arrays.stream(this.fluids).map(e -> e.clone()).toArray(FluidChange[]::new) : null;
        copy.visibleLayerCount = this.visibleLayerCount;
        copy.biomeTint = this.biomeTint;
        copy.waterTint = this.waterTint;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PrefabPreviewUpdate other)) return false;
        return java.util.Arrays.equals(this.blocks, other.blocks) && java.util.Arrays.equals(this.fluids, other.fluids) && this.visibleLayerCount == other.visibleLayerCount && this.biomeTint == other.biomeTint && this.waterTint == other.waterTint;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(blocks);
        result = 31 * result + java.util.Arrays.hashCode(fluids);
        result = 31 * result + Integer.hashCode(visibleLayerCount);
        result = 31 * result + Integer.hashCode(biomeTint);
        result = 31 * result + Integer.hashCode(waterTint);
        return result;
    }

}