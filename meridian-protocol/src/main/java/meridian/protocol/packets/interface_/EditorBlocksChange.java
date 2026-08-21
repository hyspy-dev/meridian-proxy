// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.NetworkChannel;
import meridian.protocol.Packet;
import meridian.protocol.ToServerPacket;
import meridian.protocol.ToClientPacket;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import meridian.protocol.packets.buildertools.ClipboardEntityChange;

public class EditorBlocksChange implements Packet, ToClientPacket {
    public static final int PACKET_ID = 222;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 2;
    public static final int FIXED_BLOCK_SIZE = 68;
    public static final int VARIABLE_FIELD_COUNT = 4;
    public static final int VARIABLE_BLOCK_START = 84;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public EditorSelection selection;
    @Nullable public BlockChange[] blocksChange;
    @Nullable public FluidChange[] fluidsChange;
    @Nullable public ClipboardEntityChange[] entityChanges;
    public int blocksCount;
    public boolean advancedPreview;
    public boolean skipPreviewRebuild;
    @Nullable public Integer cumulativeRotX;
    @Nullable public Integer cumulativeRotY;
    @Nullable public Integer cumulativeRotZ;
    public boolean blocksOmitted;
    @Nullable public EditorSelection anchorBounds;
    @Nullable public byte[] shapeOccupancy;

    public EditorBlocksChange() {
    }

    public EditorBlocksChange(@Nullable EditorSelection selection, @Nullable BlockChange[] blocksChange, @Nullable FluidChange[] fluidsChange, @Nullable ClipboardEntityChange[] entityChanges, int blocksCount, boolean advancedPreview, boolean skipPreviewRebuild, @Nullable Integer cumulativeRotX, @Nullable Integer cumulativeRotY, @Nullable Integer cumulativeRotZ, boolean blocksOmitted, @Nullable EditorSelection anchorBounds, @Nullable byte[] shapeOccupancy) {
        this.selection = selection;
        this.blocksChange = blocksChange;
        this.fluidsChange = fluidsChange;
        this.entityChanges = entityChanges;
        this.blocksCount = blocksCount;
        this.advancedPreview = advancedPreview;
        this.skipPreviewRebuild = skipPreviewRebuild;
        this.cumulativeRotX = cumulativeRotX;
        this.cumulativeRotY = cumulativeRotY;
        this.cumulativeRotZ = cumulativeRotZ;
        this.blocksOmitted = blocksOmitted;
        this.anchorBounds = anchorBounds;
        this.shapeOccupancy = shapeOccupancy;
    }

    public EditorBlocksChange(@Nonnull EditorBlocksChange other) {
        this.selection = other.selection;
        this.blocksChange = other.blocksChange;
        this.fluidsChange = other.fluidsChange;
        this.entityChanges = other.entityChanges;
        this.blocksCount = other.blocksCount;
        this.advancedPreview = other.advancedPreview;
        this.skipPreviewRebuild = other.skipPreviewRebuild;
        this.cumulativeRotX = other.cumulativeRotX;
        this.cumulativeRotY = other.cumulativeRotY;
        this.cumulativeRotZ = other.cumulativeRotZ;
        this.blocksOmitted = other.blocksOmitted;
        this.anchorBounds = other.anchorBounds;
        this.shapeOccupancy = other.shapeOccupancy;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("EditorBlocksChange", offset, (int) mem.byteSize());
        long needed = (long) offset + 84;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("EditorBlocksChange", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static EditorSelection getSelection(MemorySegment mem) {
        return getSelection(mem, 0);
    }
    
    @Nullable
    public static EditorSelection getSelection(MemorySegment mem, int offset) {
        return hasSelection(mem, offset) ? EditorSelection.toObject(mem, offset + 2): null;
    }
    
    @Nullable
    public static BlockChange[] getBlocksChange(MemorySegment mem) {
        return getBlocksChange(mem, 0);
    }
    
    @Nullable
    public static BlockChange[] getBlocksChange(MemorySegment mem, int offset) {
        if (!hasBlocksChange(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 68, 84, "BlocksChange");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("BlocksChange");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("BlocksChange", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlocksChange", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new BlockChange[len];
        for (var i = 0; i < len; i++) {
            data[i] = BlockChange.toObject(mem, off + i * 17);
        }
        return data;
    }
    
    @Nullable
    public static FluidChange[] getFluidsChange(MemorySegment mem) {
        return getFluidsChange(mem, 0);
    }
    
    @Nullable
    public static FluidChange[] getFluidsChange(MemorySegment mem, int offset) {
        if (!hasFluidsChange(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 72, 84, "FluidsChange");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("FluidsChange");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("FluidsChange", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FluidsChange", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new FluidChange[len];
        for (var i = 0; i < len; i++) {
            data[i] = FluidChange.toObject(mem, off + i * 17);
        }
        return data;
    }
    
    @Nullable
    public static ClipboardEntityChange[] getEntityChanges(MemorySegment mem) {
        return getEntityChanges(mem, 0);
    }
    
    @Nullable
    public static ClipboardEntityChange[] getEntityChanges(MemorySegment mem, int offset) {
        if (!hasEntityChanges(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 76, 84, "EntityChanges");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("EntityChanges");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("EntityChanges", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 53 > mem.byteSize()) throw ProtocolException.bufferTooSmall("EntityChanges", (int) java.lang.Math.min(off + lenOffset + (long) len * 53, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ClipboardEntityChange[len];
        for (var i = 0; i < len; i++) {
            data[i] = ClipboardEntityChange.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static int getBlocksCount(MemorySegment mem) {
        return getBlocksCount(mem, 0);
    }
    
    public static int getBlocksCount(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 26);
    }
    
    public static boolean getAdvancedPreview(MemorySegment mem) {
        return getAdvancedPreview(mem, 0);
    }
    
    public static boolean getAdvancedPreview(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 30) & 0x01) != 0;
    }
    
    public static boolean getSkipPreviewRebuild(MemorySegment mem) {
        return getSkipPreviewRebuild(mem, 0);
    }
    
    public static boolean getSkipPreviewRebuild(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 30) & 0x02) != 0;
    }
    
    @Nullable
    public static Integer getCumulativeRotX(MemorySegment mem) {
        return getCumulativeRotX(mem, 0);
    }
    
    @Nullable
    public static Integer getCumulativeRotX(MemorySegment mem, int offset) {
        return hasCumulativeRotX(mem, offset) ? mem.get(PacketIO.PROTO_INT, offset + 31): null;
    }
    
    @Nullable
    public static Integer getCumulativeRotY(MemorySegment mem) {
        return getCumulativeRotY(mem, 0);
    }
    
    @Nullable
    public static Integer getCumulativeRotY(MemorySegment mem, int offset) {
        return hasCumulativeRotY(mem, offset) ? mem.get(PacketIO.PROTO_INT, offset + 35): null;
    }
    
    @Nullable
    public static Integer getCumulativeRotZ(MemorySegment mem) {
        return getCumulativeRotZ(mem, 0);
    }
    
    @Nullable
    public static Integer getCumulativeRotZ(MemorySegment mem, int offset) {
        return hasCumulativeRotZ(mem, offset) ? mem.get(PacketIO.PROTO_INT, offset + 39): null;
    }
    
    public static boolean getBlocksOmitted(MemorySegment mem) {
        return getBlocksOmitted(mem, 0);
    }
    
    public static boolean getBlocksOmitted(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 43);
    }
    
    @Nullable
    public static EditorSelection getAnchorBounds(MemorySegment mem) {
        return getAnchorBounds(mem, 0);
    }
    
    @Nullable
    public static EditorSelection getAnchorBounds(MemorySegment mem, int offset) {
        return hasAnchorBounds(mem, offset) ? EditorSelection.toObject(mem, offset + 44): null;
    }
    
    @Nullable
    public static byte[] getShapeOccupancy(MemorySegment mem) {
        return getShapeOccupancy(mem, 0);
    }
    
    @Nullable
    public static byte[] getShapeOccupancy(MemorySegment mem, int offset) {
        if (!hasShapeOccupancy(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 80, 84, "ShapeOccupancy");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ShapeOccupancy");
        var len = (int) packed;
        if (len > 16777216) throw ProtocolException.arrayTooLong("ShapeOccupancy", len, 16777216);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("ShapeOccupancy", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new byte[len];
        MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, data, 0, len);
        return data;
    }
    
    public static boolean hasSelection(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasCumulativeRotX(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasCumulativeRotY(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasCumulativeRotZ(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasAnchorBounds(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasBlocksChange(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasFluidsChange(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasEntityChanges(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasShapeOccupancy(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
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
    
    public static EditorBlocksChange toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static EditorBlocksChange toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one EditorBlocksChange and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static EditorBlocksChange toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 84;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        BlockChange[] v1 = null;
        if (hasBlocksChange(mem, offset)) {
            requireSlot(mem, offset + 68, varPos, "BlocksChange");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("BlocksChange");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("BlocksChange", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlocksChange", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new BlockChange[len];
            for (var i = 0; i < len; i++) {
                v1[i] = BlockChange.toObject(mem, off + i * 17);
            }
            varPos = off + len * 17 - varBase;
        } else {
            requireSlot(mem, offset + 68, -1, "BlocksChange");
        }
        
        FluidChange[] v2 = null;
        if (hasFluidsChange(mem, offset)) {
            requireSlot(mem, offset + 72, varPos, "FluidsChange");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("FluidsChange");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("FluidsChange", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FluidsChange", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new FluidChange[len];
            for (var i = 0; i < len; i++) {
                v2[i] = FluidChange.toObject(mem, off + i * 17);
            }
            varPos = off + len * 17 - varBase;
        } else {
            requireSlot(mem, offset + 72, -1, "FluidsChange");
        }
        
        ClipboardEntityChange[] v3 = null;
        if (hasEntityChanges(mem, offset)) {
            requireSlot(mem, offset + 76, varPos, "EntityChanges");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("EntityChanges");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("EntityChanges", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 53 > mem.byteSize()) throw ProtocolException.bufferTooSmall("EntityChanges", (int) java.lang.Math.min(off + lenOffset + (long) len * 53, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v3 = new ClipboardEntityChange[len];
            for (var i = 0; i < len; i++) {
                v3[i] = ClipboardEntityChange.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 76, -1, "EntityChanges");
        }
        
        byte[] v12 = null;
        if (hasShapeOccupancy(mem, offset)) {
            requireSlot(mem, offset + 80, varPos, "ShapeOccupancy");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ShapeOccupancy");
            var len = (int) packed;
            if (len > 16777216) throw ProtocolException.arrayTooLong("ShapeOccupancy", len, 16777216);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("ShapeOccupancy", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v12 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v12, 0, len);
            varPos = off + len - varBase;
        } else {
            requireSlot(mem, offset + 80, -1, "ShapeOccupancy");
        }
        var result = new EditorBlocksChange(
            hasSelection(mem, offset) ? EditorSelection.toObject(mem, offset + 2) : null,
            v1,
            v2,
            v3,
            mem.get(PacketIO.PROTO_INT, offset + 26),
            (mem.get(PacketIO.PROTO_BYTE, offset + 30) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 30) & 0x02) != 0,
            hasCumulativeRotX(mem, offset) ? mem.get(PacketIO.PROTO_INT, offset + 31) : null,
            hasCumulativeRotY(mem, offset) ? mem.get(PacketIO.PROTO_INT, offset + 35) : null,
            hasCumulativeRotZ(mem, offset) ? mem.get(PacketIO.PROTO_INT, offset + 39) : null,
            mem.get(PacketIO.PROTO_BOOL, offset + 43),
            hasAnchorBounds(mem, offset) ? EditorSelection.toObject(mem, offset + 44) : null,
            v12
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.selection != null) nullBits |= 0x01;
        if (this.cumulativeRotX != null) nullBits |= 0x02;
        if (this.cumulativeRotY != null) nullBits |= 0x04;
        if (this.cumulativeRotZ != null) nullBits |= 0x08;
        if (this.anchorBounds != null) nullBits |= 0x10;
        if (this.blocksChange != null) nullBits |= 0x20;
        if (this.fluidsChange != null) nullBits |= 0x40;
        if (this.entityChanges != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        nullBits = 0;
        if (this.shapeOccupancy != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 1, nullBits);
        
        if (this.selection != null) {
            this.selection.serialize(mem, offset + 2);
        } else {
            mem.asSlice(offset + 2, 24).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_INT, offset + 26, this.blocksCount);
        byte boolBits0_0 = 0;
        if (this.advancedPreview) boolBits0_0 |= 0x01;
        if (this.skipPreviewRebuild) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 30 + 0, boolBits0_0);
        if (this.cumulativeRotX != null) {
            mem.set(PacketIO.PROTO_INT, offset + 31, this.cumulativeRotX);
        } else {
            mem.asSlice(offset + 31, 4).fill((byte) 0); 
        }
        if (this.cumulativeRotY != null) {
            mem.set(PacketIO.PROTO_INT, offset + 35, this.cumulativeRotY);
        } else {
            mem.asSlice(offset + 35, 4).fill((byte) 0); 
        }
        if (this.cumulativeRotZ != null) {
            mem.set(PacketIO.PROTO_INT, offset + 39, this.cumulativeRotZ);
        } else {
            mem.asSlice(offset + 39, 4).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BOOL, offset + 43, this.blocksOmitted);
        if (this.anchorBounds != null) {
            this.anchorBounds.serialize(mem, offset + 44);
        } else {
            mem.asSlice(offset + 44, 24).fill((byte) 0); 
        }
        var varOffset = offset + 84;
        if (this.blocksChange != null) {
            mem.set(PacketIO.PROTO_INT, offset + 68, varOffset - offset - 84);
            if (blocksChange.length > 4096000) throw ProtocolException.arrayTooLong("BlocksChange", blocksChange.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.blocksChange.length);
            
            var blocksChangeValueOffset = 0;
            for (var i = 0; i < this.blocksChange.length; i++) {
                blocksChangeValueOffset += this.blocksChange[i].serialize(mem, varOffset + blocksChangeValueOffset);
            }
            varOffset += blocksChangeValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 68, -1);
        }
        if (this.fluidsChange != null) {
            mem.set(PacketIO.PROTO_INT, offset + 72, varOffset - offset - 84);
            if (fluidsChange.length > 4096000) throw ProtocolException.arrayTooLong("FluidsChange", fluidsChange.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.fluidsChange.length);
            
            var fluidsChangeValueOffset = 0;
            for (var i = 0; i < this.fluidsChange.length; i++) {
                fluidsChangeValueOffset += this.fluidsChange[i].serialize(mem, varOffset + fluidsChangeValueOffset);
            }
            varOffset += fluidsChangeValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 72, -1);
        }
        if (this.entityChanges != null) {
            mem.set(PacketIO.PROTO_INT, offset + 76, varOffset - offset - 84);
            if (entityChanges.length > 4096000) throw ProtocolException.arrayTooLong("EntityChanges", entityChanges.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.entityChanges.length);
            
            var entityChangesValueOffset = 0;
            for (var i = 0; i < this.entityChanges.length; i++) {
                entityChangesValueOffset += this.entityChanges[i].serialize(mem, varOffset + entityChangesValueOffset);
            }
            varOffset += entityChangesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 76, -1);
        }
        if (this.shapeOccupancy != null) {
            mem.set(PacketIO.PROTO_INT, offset + 80, varOffset - offset - 84);
            if (shapeOccupancy.length > 16777216) throw ProtocolException.arrayTooLong("ShapeOccupancy", shapeOccupancy.length, 16777216);
            varOffset += VarInt.set(mem, varOffset, this.shapeOccupancy.length);
            
            MemorySegment.copy(this.shapeOccupancy, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.shapeOccupancy.length);
            varOffset += this.shapeOccupancy.length * 1;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 80, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 84;
        if (blocksChange != null) size += VarInt.size(blocksChange.length) + blocksChange.length * 17;
    if (fluidsChange != null) size += VarInt.size(fluidsChange.length) + fluidsChange.length * 17;
    if (entityChanges != null) {
        int entityChangesSize = 0;
for (var elem : entityChanges) entityChangesSize += elem.computeSize();
size += VarInt.size(entityChanges.length) + entityChangesSize;
    }
    if (shapeOccupancy != null) size += VarInt.size(shapeOccupancy.length) + shapeOccupancy.length * 1;

        return size;
    }

    public EditorBlocksChange clone() {
        EditorBlocksChange copy = new EditorBlocksChange();
        copy.selection = this.selection != null ? this.selection.clone() : null;
        copy.blocksChange = this.blocksChange != null ? java.util.Arrays.stream(this.blocksChange).map(e -> e.clone()).toArray(BlockChange[]::new) : null;
        copy.fluidsChange = this.fluidsChange != null ? java.util.Arrays.stream(this.fluidsChange).map(e -> e.clone()).toArray(FluidChange[]::new) : null;
        copy.entityChanges = this.entityChanges != null ? java.util.Arrays.stream(this.entityChanges).map(e -> e.clone()).toArray(ClipboardEntityChange[]::new) : null;
        copy.blocksCount = this.blocksCount;
        copy.advancedPreview = this.advancedPreview;
        copy.skipPreviewRebuild = this.skipPreviewRebuild;
        copy.cumulativeRotX = this.cumulativeRotX;
        copy.cumulativeRotY = this.cumulativeRotY;
        copy.cumulativeRotZ = this.cumulativeRotZ;
        copy.blocksOmitted = this.blocksOmitted;
        copy.anchorBounds = this.anchorBounds != null ? this.anchorBounds.clone() : null;
        copy.shapeOccupancy = this.shapeOccupancy != null ? java.util.Arrays.copyOf(this.shapeOccupancy, this.shapeOccupancy.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EditorBlocksChange other)) return false;
        return java.util.Objects.equals(this.selection, other.selection) && java.util.Arrays.equals(this.blocksChange, other.blocksChange) && java.util.Arrays.equals(this.fluidsChange, other.fluidsChange) && java.util.Arrays.equals(this.entityChanges, other.entityChanges) && this.blocksCount == other.blocksCount && this.advancedPreview == other.advancedPreview && this.skipPreviewRebuild == other.skipPreviewRebuild && java.util.Objects.equals(this.cumulativeRotX, other.cumulativeRotX) && java.util.Objects.equals(this.cumulativeRotY, other.cumulativeRotY) && java.util.Objects.equals(this.cumulativeRotZ, other.cumulativeRotZ) && this.blocksOmitted == other.blocksOmitted && java.util.Objects.equals(this.anchorBounds, other.anchorBounds) && java.util.Arrays.equals(this.shapeOccupancy, other.shapeOccupancy);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(selection);
        result = 31 * result + java.util.Arrays.hashCode(blocksChange);
        result = 31 * result + java.util.Arrays.hashCode(fluidsChange);
        result = 31 * result + java.util.Arrays.hashCode(entityChanges);
        result = 31 * result + Integer.hashCode(blocksCount);
        result = 31 * result + Boolean.hashCode(advancedPreview);
        result = 31 * result + Boolean.hashCode(skipPreviewRebuild);
        result = 31 * result + java.util.Objects.hashCode(cumulativeRotX);
        result = 31 * result + java.util.Objects.hashCode(cumulativeRotY);
        result = 31 * result + java.util.Objects.hashCode(cumulativeRotZ);
        result = 31 * result + Boolean.hashCode(blocksOmitted);
        result = 31 * result + java.util.Objects.hashCode(anchorBounds);
        result = 31 * result + java.util.Arrays.hashCode(shapeOccupancy);
        return result;
    }

}