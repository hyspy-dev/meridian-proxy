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


public class BlockPlacementSettings {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 16;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 16;
    public static final int MAX_SIZE = 16;

    public boolean allowRotationKey;
    public boolean placeInEmptyBlocks;
    @Nonnull public BlockPreviewVisibility previewVisibility = BlockPreviewVisibility.AlwaysVisible;
    @Nonnull public BlockPlacementRotationMode rotationMode = BlockPlacementRotationMode.FacingPlayer;
    public int wallPlacementOverrideBlockId;
    public int floorPlacementOverrideBlockId;
    public int ceilingPlacementOverrideBlockId;
    public boolean allowBreakReplace;

    public BlockPlacementSettings() {
    }

    public BlockPlacementSettings(boolean allowRotationKey, boolean placeInEmptyBlocks, @Nonnull BlockPreviewVisibility previewVisibility, @Nonnull BlockPlacementRotationMode rotationMode, int wallPlacementOverrideBlockId, int floorPlacementOverrideBlockId, int ceilingPlacementOverrideBlockId, boolean allowBreakReplace) {
        this.allowRotationKey = allowRotationKey;
        this.placeInEmptyBlocks = placeInEmptyBlocks;
        this.previewVisibility = previewVisibility;
        this.rotationMode = rotationMode;
        this.wallPlacementOverrideBlockId = wallPlacementOverrideBlockId;
        this.floorPlacementOverrideBlockId = floorPlacementOverrideBlockId;
        this.ceilingPlacementOverrideBlockId = ceilingPlacementOverrideBlockId;
        this.allowBreakReplace = allowBreakReplace;
    }

    public BlockPlacementSettings(@Nonnull BlockPlacementSettings other) {
        this.allowRotationKey = other.allowRotationKey;
        this.placeInEmptyBlocks = other.placeInEmptyBlocks;
        this.previewVisibility = other.previewVisibility;
        this.rotationMode = other.rotationMode;
        this.wallPlacementOverrideBlockId = other.wallPlacementOverrideBlockId;
        this.floorPlacementOverrideBlockId = other.floorPlacementOverrideBlockId;
        this.ceilingPlacementOverrideBlockId = other.ceilingPlacementOverrideBlockId;
        this.allowBreakReplace = other.allowBreakReplace;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BlockPlacementSettings", offset, (int) mem.byteSize());
        long needed = (long) offset + 16;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockPlacementSettings", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getAllowRotationKey(MemorySegment mem) {
        return getAllowRotationKey(mem, 0);
    }
    
    public static boolean getAllowRotationKey(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x01) != 0;
    }
    
    public static boolean getPlaceInEmptyBlocks(MemorySegment mem) {
        return getPlaceInEmptyBlocks(mem, 0);
    }
    
    public static boolean getPlaceInEmptyBlocks(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x02) != 0;
    }
    
    public static BlockPreviewVisibility getPreviewVisibility(MemorySegment mem) {
        return getPreviewVisibility(mem, 0);
    }
    
    public static BlockPreviewVisibility getPreviewVisibility(MemorySegment mem, int offset) {
        return BlockPreviewVisibility.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static BlockPlacementRotationMode getRotationMode(MemorySegment mem) {
        return getRotationMode(mem, 0);
    }
    
    public static BlockPlacementRotationMode getRotationMode(MemorySegment mem, int offset) {
        return BlockPlacementRotationMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2));
    }
    
    public static int getWallPlacementOverrideBlockId(MemorySegment mem) {
        return getWallPlacementOverrideBlockId(mem, 0);
    }
    
    public static int getWallPlacementOverrideBlockId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 3);
    }
    
    public static int getFloorPlacementOverrideBlockId(MemorySegment mem) {
        return getFloorPlacementOverrideBlockId(mem, 0);
    }
    
    public static int getFloorPlacementOverrideBlockId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 7);
    }
    
    public static int getCeilingPlacementOverrideBlockId(MemorySegment mem) {
        return getCeilingPlacementOverrideBlockId(mem, 0);
    }
    
    public static int getCeilingPlacementOverrideBlockId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 11);
    }
    
    public static boolean getAllowBreakReplace(MemorySegment mem) {
        return getAllowBreakReplace(mem, 0);
    }
    
    public static boolean getAllowBreakReplace(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 15);
    }
    
    
    
    
    
    public static BlockPlacementSettings toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BlockPlacementSettings toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BlockPlacementSettings and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BlockPlacementSettings toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BlockPlacementSettings(
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x02) != 0,
            BlockPreviewVisibility.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            BlockPlacementRotationMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2)),
            mem.get(PacketIO.PROTO_INT, offset + 3),
            mem.get(PacketIO.PROTO_INT, offset + 7),
            mem.get(PacketIO.PROTO_INT, offset + 11),
            mem.get(PacketIO.PROTO_BOOL, offset + 15)
        );
        if (cursor != null) cursor.position = offset + 16;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        byte boolBits0_0 = 0;
        if (this.allowRotationKey) boolBits0_0 |= 0x01;
        if (this.placeInEmptyBlocks) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0 + 0, boolBits0_0);
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.previewVisibility.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 2, (byte) this.rotationMode.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 3, this.wallPlacementOverrideBlockId);
        mem.set(PacketIO.PROTO_INT, offset + 7, this.floorPlacementOverrideBlockId);
        mem.set(PacketIO.PROTO_INT, offset + 11, this.ceilingPlacementOverrideBlockId);
        mem.set(PacketIO.PROTO_BOOL, offset + 15, this.allowBreakReplace);
        
        
    
       return 16;
    }
    public int computeSize() {
        return 16;
    }

    public BlockPlacementSettings clone() {
        BlockPlacementSettings copy = new BlockPlacementSettings();
        copy.allowRotationKey = this.allowRotationKey;
        copy.placeInEmptyBlocks = this.placeInEmptyBlocks;
        copy.previewVisibility = this.previewVisibility;
        copy.rotationMode = this.rotationMode;
        copy.wallPlacementOverrideBlockId = this.wallPlacementOverrideBlockId;
        copy.floorPlacementOverrideBlockId = this.floorPlacementOverrideBlockId;
        copy.ceilingPlacementOverrideBlockId = this.ceilingPlacementOverrideBlockId;
        copy.allowBreakReplace = this.allowBreakReplace;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BlockPlacementSettings other)) return false;
        return this.allowRotationKey == other.allowRotationKey && this.placeInEmptyBlocks == other.placeInEmptyBlocks && java.util.Objects.equals(this.previewVisibility, other.previewVisibility) && java.util.Objects.equals(this.rotationMode, other.rotationMode) && this.wallPlacementOverrideBlockId == other.wallPlacementOverrideBlockId && this.floorPlacementOverrideBlockId == other.floorPlacementOverrideBlockId && this.ceilingPlacementOverrideBlockId == other.ceilingPlacementOverrideBlockId && this.allowBreakReplace == other.allowBreakReplace;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(allowRotationKey, placeInEmptyBlocks, previewVisibility, rotationMode, wallPlacementOverrideBlockId, floorPlacementOverrideBlockId, ceilingPlacementOverrideBlockId, allowBreakReplace);
    }

}