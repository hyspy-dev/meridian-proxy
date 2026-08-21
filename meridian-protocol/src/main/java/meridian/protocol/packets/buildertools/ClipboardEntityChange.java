// Auto-generated - do not edit
package meridian.protocol.packets.buildertools;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import meridian.protocol.Direction;
import meridian.protocol.Model;

public class ClipboardEntityChange {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 45;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 53;
    public static final int MAX_SIZE = 1677721600;

    public float x;
    public float y;
    public float z;
    public int blockId;
    @Nullable public Model model;
    @Nullable public String itemId;
    @Nullable public Direction bodyOrientation;
    @Nullable public Direction lookOrientation;
    public float scale;

    public ClipboardEntityChange() {
    }

    public ClipboardEntityChange(float x, float y, float z, int blockId, @Nullable Model model, @Nullable String itemId, @Nullable Direction bodyOrientation, @Nullable Direction lookOrientation, float scale) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.blockId = blockId;
        this.model = model;
        this.itemId = itemId;
        this.bodyOrientation = bodyOrientation;
        this.lookOrientation = lookOrientation;
        this.scale = scale;
    }

    public ClipboardEntityChange(@Nonnull ClipboardEntityChange other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
        this.blockId = other.blockId;
        this.model = other.model;
        this.itemId = other.itemId;
        this.bodyOrientation = other.bodyOrientation;
        this.lookOrientation = other.lookOrientation;
        this.scale = other.scale;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ClipboardEntityChange", offset, (int) mem.byteSize());
        long needed = (long) offset + 53;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ClipboardEntityChange", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getX(MemorySegment mem) {
        return getX(mem, 0);
    }
    
    public static float getX(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "X");
    }
    
    public static float getY(MemorySegment mem) {
        return getY(mem, 0);
    }
    
    public static float getY(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "Y");
    }
    
    public static float getZ(MemorySegment mem) {
        return getZ(mem, 0);
    }
    
    public static float getZ(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "Z");
    }
    
    public static int getBlockId(MemorySegment mem) {
        return getBlockId(mem, 0);
    }
    
    public static int getBlockId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 13);
    }
    
    @Nullable
    public static Model getModel(MemorySegment mem) {
        return getModel(mem, 0);
    }
    
    @Nullable
    public static Model getModel(MemorySegment mem, int offset) {
        return hasModel(mem, offset) ? Model.toObject(mem, offset + getValidatedOffset(mem, offset, 45, 53, "Model")): null;
    }
    
    @Nullable
    public static String getItemId(MemorySegment mem) {
        return getItemId(mem, 0);
    }
    
    @Nullable
    public static String getItemId(MemorySegment mem, int offset) {
        return hasItemId(mem, offset) ? PacketIO.readVarString("ItemId", mem, offset + getValidatedOffset(mem, offset, 49, 53, "ItemId"), 4096000): null;
    }
    
    @Nullable
    public static Direction getBodyOrientation(MemorySegment mem) {
        return getBodyOrientation(mem, 0);
    }
    
    @Nullable
    public static Direction getBodyOrientation(MemorySegment mem, int offset) {
        return hasBodyOrientation(mem, offset) ? Direction.toObject(mem, offset + 17): null;
    }
    
    @Nullable
    public static Direction getLookOrientation(MemorySegment mem) {
        return getLookOrientation(mem, 0);
    }
    
    @Nullable
    public static Direction getLookOrientation(MemorySegment mem, int offset) {
        return hasLookOrientation(mem, offset) ? Direction.toObject(mem, offset + 29): null;
    }
    
    public static float getScale(MemorySegment mem) {
        return getScale(mem, 0);
    }
    
    public static float getScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 41), "Scale");
    }
    
    public static boolean hasBodyOrientation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasLookOrientation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasModel(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasItemId(MemorySegment mem, int offset) {
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
    
    public static ClipboardEntityChange toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ClipboardEntityChange toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ClipboardEntityChange and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ClipboardEntityChange toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 53;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        Model v4 = null;
        if (hasModel(mem, offset)) {
            requireSlot(mem, offset + 45, varPos, "Model");
            v4 = Model.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 45, -1, "Model");
        }
        
        String v5 = null;
        if (hasItemId(mem, offset)) {
            requireSlot(mem, offset + 49, varPos, "ItemId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v5 = PacketIO.readVarString("ItemId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 49, -1, "ItemId");
        }
        var result = new ClipboardEntityChange(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "X"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "Y"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "Z"),
            mem.get(PacketIO.PROTO_INT, offset + 13),
            v4,
            v5,
            hasBodyOrientation(mem, offset) ? Direction.toObject(mem, offset + 17) : null,
            hasLookOrientation(mem, offset) ? Direction.toObject(mem, offset + 29) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 41), "Scale")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.bodyOrientation != null) nullBits |= 0x01;
        if (this.lookOrientation != null) nullBits |= 0x02;
        if (this.model != null) nullBits |= 0x04;
        if (this.itemId != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.x, "X"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.x);
        PacketIO.requireFinite(this.y, "Y"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.y);
        PacketIO.requireFinite(this.z, "Z"); mem.set(PacketIO.PROTO_FLOAT, offset + 9, this.z);
        mem.set(PacketIO.PROTO_INT, offset + 13, this.blockId);
        if (this.bodyOrientation != null) {
            this.bodyOrientation.serialize(mem, offset + 17);
        } else {
            mem.asSlice(offset + 17, 12).fill((byte) 0); 
        }
        if (this.lookOrientation != null) {
            this.lookOrientation.serialize(mem, offset + 29);
        } else {
            mem.asSlice(offset + 29, 12).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.scale, "Scale"); mem.set(PacketIO.PROTO_FLOAT, offset + 41, this.scale);
        var varOffset = offset + 53;
        if (this.model != null) {
            mem.set(PacketIO.PROTO_INT, offset + 45, varOffset - offset - 53);
            varOffset += this.model.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 45, -1);
        }
        if (this.itemId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 49, varOffset - offset - 53);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.itemId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 49, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 53;
        if (model != null) size += model.computeSize();
    if (itemId != null) size += PacketIO.stringSize(itemId);

        return size;
    }

    public ClipboardEntityChange clone() {
        ClipboardEntityChange copy = new ClipboardEntityChange();
        copy.x = this.x;
        copy.y = this.y;
        copy.z = this.z;
        copy.blockId = this.blockId;
        copy.model = this.model != null ? this.model.clone() : null;
        copy.itemId = this.itemId;
        copy.bodyOrientation = this.bodyOrientation != null ? this.bodyOrientation.clone() : null;
        copy.lookOrientation = this.lookOrientation != null ? this.lookOrientation.clone() : null;
        copy.scale = this.scale;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ClipboardEntityChange other)) return false;
        return this.x == other.x && this.y == other.y && this.z == other.z && this.blockId == other.blockId && java.util.Objects.equals(this.model, other.model) && java.util.Objects.equals(this.itemId, other.itemId) && java.util.Objects.equals(this.bodyOrientation, other.bodyOrientation) && java.util.Objects.equals(this.lookOrientation, other.lookOrientation) && this.scale == other.scale;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, y, z, blockId, model, itemId, bodyOrientation, lookOrientation, scale);
    }

}