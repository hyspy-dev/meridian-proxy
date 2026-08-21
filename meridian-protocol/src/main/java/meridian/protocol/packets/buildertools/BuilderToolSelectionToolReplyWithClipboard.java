// Auto-generated - do not edit
package meridian.protocol.packets.buildertools;

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
import meridian.protocol.packets.interface_.BlockChange;
import meridian.protocol.packets.interface_.EditorSelection;
import meridian.protocol.packets.interface_.FluidChange;

public class BuilderToolSelectionToolReplyWithClipboard implements Packet, ToClientPacket {
    public static final int PACKET_ID = 411;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 26;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 38;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public BlockChange[] blocksChange;
    @Nullable public FluidChange[] fluidsChange;
    @Nullable public ClipboardEntityChange[] entityChanges;
    public boolean blocksOmitted;
    @Nullable public EditorSelection bounds;

    public BuilderToolSelectionToolReplyWithClipboard() {
    }

    public BuilderToolSelectionToolReplyWithClipboard(@Nullable BlockChange[] blocksChange, @Nullable FluidChange[] fluidsChange, @Nullable ClipboardEntityChange[] entityChanges, boolean blocksOmitted, @Nullable EditorSelection bounds) {
        this.blocksChange = blocksChange;
        this.fluidsChange = fluidsChange;
        this.entityChanges = entityChanges;
        this.blocksOmitted = blocksOmitted;
        this.bounds = bounds;
    }

    public BuilderToolSelectionToolReplyWithClipboard(@Nonnull BuilderToolSelectionToolReplyWithClipboard other) {
        this.blocksChange = other.blocksChange;
        this.fluidsChange = other.fluidsChange;
        this.entityChanges = other.entityChanges;
        this.blocksOmitted = other.blocksOmitted;
        this.bounds = other.bounds;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolSelectionToolReplyWithClipboard", offset, (int) mem.byteSize());
        long needed = (long) offset + 38;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolSelectionToolReplyWithClipboard", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static BlockChange[] getBlocksChange(MemorySegment mem) {
        return getBlocksChange(mem, 0);
    }
    
    @Nullable
    public static BlockChange[] getBlocksChange(MemorySegment mem, int offset) {
        if (!hasBlocksChange(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 26, 38, "BlocksChange");
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
        var off = offset + getValidatedOffset(mem, offset, 30, 38, "FluidsChange");
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
        var off = offset + getValidatedOffset(mem, offset, 34, 38, "EntityChanges");
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
    
    public static boolean getBlocksOmitted(MemorySegment mem) {
        return getBlocksOmitted(mem, 0);
    }
    
    public static boolean getBlocksOmitted(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 1);
    }
    
    @Nullable
    public static EditorSelection getBounds(MemorySegment mem) {
        return getBounds(mem, 0);
    }
    
    @Nullable
    public static EditorSelection getBounds(MemorySegment mem, int offset) {
        return hasBounds(mem, offset) ? EditorSelection.toObject(mem, offset + 2): null;
    }
    
    public static boolean hasBounds(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasBlocksChange(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasFluidsChange(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasEntityChanges(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
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
    
    public static BuilderToolSelectionToolReplyWithClipboard toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolSelectionToolReplyWithClipboard toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolSelectionToolReplyWithClipboard and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolSelectionToolReplyWithClipboard toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 38;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        BlockChange[] v0 = null;
        if (hasBlocksChange(mem, offset)) {
            requireSlot(mem, offset + 26, varPos, "BlocksChange");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("BlocksChange");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("BlocksChange", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlocksChange", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new BlockChange[len];
            for (var i = 0; i < len; i++) {
                v0[i] = BlockChange.toObject(mem, off + i * 17);
            }
            varPos = off + len * 17 - varBase;
        } else {
            requireSlot(mem, offset + 26, -1, "BlocksChange");
        }
        
        FluidChange[] v1 = null;
        if (hasFluidsChange(mem, offset)) {
            requireSlot(mem, offset + 30, varPos, "FluidsChange");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("FluidsChange");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("FluidsChange", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FluidsChange", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new FluidChange[len];
            for (var i = 0; i < len; i++) {
                v1[i] = FluidChange.toObject(mem, off + i * 17);
            }
            varPos = off + len * 17 - varBase;
        } else {
            requireSlot(mem, offset + 30, -1, "FluidsChange");
        }
        
        ClipboardEntityChange[] v2 = null;
        if (hasEntityChanges(mem, offset)) {
            requireSlot(mem, offset + 34, varPos, "EntityChanges");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("EntityChanges");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("EntityChanges", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 53 > mem.byteSize()) throw ProtocolException.bufferTooSmall("EntityChanges", (int) java.lang.Math.min(off + lenOffset + (long) len * 53, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new ClipboardEntityChange[len];
            for (var i = 0; i < len; i++) {
                v2[i] = ClipboardEntityChange.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 34, -1, "EntityChanges");
        }
        var result = new BuilderToolSelectionToolReplyWithClipboard(
            v0,
            v1,
            v2,
            mem.get(PacketIO.PROTO_BOOL, offset + 1),
            hasBounds(mem, offset) ? EditorSelection.toObject(mem, offset + 2) : null
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.bounds != null) nullBits |= 0x01;
        if (this.blocksChange != null) nullBits |= 0x02;
        if (this.fluidsChange != null) nullBits |= 0x04;
        if (this.entityChanges != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BOOL, offset + 1, this.blocksOmitted);
        if (this.bounds != null) {
            this.bounds.serialize(mem, offset + 2);
        } else {
            mem.asSlice(offset + 2, 24).fill((byte) 0); 
        }
        var varOffset = offset + 38;
        if (this.blocksChange != null) {
            mem.set(PacketIO.PROTO_INT, offset + 26, varOffset - offset - 38);
            if (blocksChange.length > 4096000) throw ProtocolException.arrayTooLong("BlocksChange", blocksChange.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.blocksChange.length);
            
            var blocksChangeValueOffset = 0;
            for (var i = 0; i < this.blocksChange.length; i++) {
                blocksChangeValueOffset += this.blocksChange[i].serialize(mem, varOffset + blocksChangeValueOffset);
            }
            varOffset += blocksChangeValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 26, -1);
        }
        if (this.fluidsChange != null) {
            mem.set(PacketIO.PROTO_INT, offset + 30, varOffset - offset - 38);
            if (fluidsChange.length > 4096000) throw ProtocolException.arrayTooLong("FluidsChange", fluidsChange.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.fluidsChange.length);
            
            var fluidsChangeValueOffset = 0;
            for (var i = 0; i < this.fluidsChange.length; i++) {
                fluidsChangeValueOffset += this.fluidsChange[i].serialize(mem, varOffset + fluidsChangeValueOffset);
            }
            varOffset += fluidsChangeValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 30, -1);
        }
        if (this.entityChanges != null) {
            mem.set(PacketIO.PROTO_INT, offset + 34, varOffset - offset - 38);
            if (entityChanges.length > 4096000) throw ProtocolException.arrayTooLong("EntityChanges", entityChanges.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.entityChanges.length);
            
            var entityChangesValueOffset = 0;
            for (var i = 0; i < this.entityChanges.length; i++) {
                entityChangesValueOffset += this.entityChanges[i].serialize(mem, varOffset + entityChangesValueOffset);
            }
            varOffset += entityChangesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 34, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 38;
        if (blocksChange != null) size += VarInt.size(blocksChange.length) + blocksChange.length * 17;
    if (fluidsChange != null) size += VarInt.size(fluidsChange.length) + fluidsChange.length * 17;
    if (entityChanges != null) {
        int entityChangesSize = 0;
for (var elem : entityChanges) entityChangesSize += elem.computeSize();
size += VarInt.size(entityChanges.length) + entityChangesSize;
    }

        return size;
    }

    public BuilderToolSelectionToolReplyWithClipboard clone() {
        BuilderToolSelectionToolReplyWithClipboard copy = new BuilderToolSelectionToolReplyWithClipboard();
        copy.blocksChange = this.blocksChange != null ? java.util.Arrays.stream(this.blocksChange).map(e -> e.clone()).toArray(BlockChange[]::new) : null;
        copy.fluidsChange = this.fluidsChange != null ? java.util.Arrays.stream(this.fluidsChange).map(e -> e.clone()).toArray(FluidChange[]::new) : null;
        copy.entityChanges = this.entityChanges != null ? java.util.Arrays.stream(this.entityChanges).map(e -> e.clone()).toArray(ClipboardEntityChange[]::new) : null;
        copy.blocksOmitted = this.blocksOmitted;
        copy.bounds = this.bounds != null ? this.bounds.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolSelectionToolReplyWithClipboard other)) return false;
        return java.util.Arrays.equals(this.blocksChange, other.blocksChange) && java.util.Arrays.equals(this.fluidsChange, other.fluidsChange) && java.util.Arrays.equals(this.entityChanges, other.entityChanges) && this.blocksOmitted == other.blocksOmitted && java.util.Objects.equals(this.bounds, other.bounds);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(blocksChange);
        result = 31 * result + java.util.Arrays.hashCode(fluidsChange);
        result = 31 * result + java.util.Arrays.hashCode(entityChanges);
        result = 31 * result + Boolean.hashCode(blocksOmitted);
        result = 31 * result + java.util.Objects.hashCode(bounds);
        return result;
    }

}