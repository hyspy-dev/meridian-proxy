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


public class ItemTool {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public ItemToolSpec[] specs;
    public float speed;
    @Nullable public BreakShape breakShape;

    public ItemTool() {
    }

    public ItemTool(@Nullable ItemToolSpec[] specs, float speed, @Nullable BreakShape breakShape) {
        this.specs = specs;
        this.speed = speed;
        this.breakShape = breakShape;
    }

    public ItemTool(@Nonnull ItemTool other) {
        this.specs = other.specs;
        this.speed = other.speed;
        this.breakShape = other.breakShape;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemTool", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemTool", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static ItemToolSpec[] getSpecs(MemorySegment mem) {
        return getSpecs(mem, 0);
    }
    
    @Nullable
    public static ItemToolSpec[] getSpecs(MemorySegment mem, int offset) {
        if (!hasSpecs(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 5, 13, "Specs");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Specs");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Specs", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 9 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Specs", (int) java.lang.Math.min(off + lenOffset + (long) len * 9, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ItemToolSpec[len];
        for (var i = 0; i < len; i++) {
            data[i] = ItemToolSpec.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static float getSpeed(MemorySegment mem) {
        return getSpeed(mem, 0);
    }
    
    public static float getSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Speed");
    }
    
    @Nullable
    public static BreakShape getBreakShape(MemorySegment mem) {
        return getBreakShape(mem, 0);
    }
    
    @Nullable
    public static BreakShape getBreakShape(MemorySegment mem, int offset) {
        return hasBreakShape(mem, offset) ? BreakShape.toObject(mem, offset + getValidatedOffset(mem, offset, 9, 13, "BreakShape")): null;
    }
    
    public static boolean hasSpecs(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasBreakShape(MemorySegment mem, int offset) {
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
    
    public static ItemTool toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemTool toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemTool and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemTool toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 13;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ItemToolSpec[] v0 = null;
        if (hasSpecs(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Specs");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Specs");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Specs", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 9 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Specs", (int) java.lang.Math.min(off + lenOffset + (long) len * 9, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new ItemToolSpec[len];
            for (var i = 0; i < len; i++) {
                v0[i] = ItemToolSpec.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "Specs");
        }
        
        BreakShape v2 = null;
        if (hasBreakShape(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "BreakShape");
            v2 = BreakShape.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 9, -1, "BreakShape");
        }
        var result = new ItemTool(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Speed"),
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.specs != null) nullBits |= 0x01;
        if (this.breakShape != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.speed, "Speed"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.speed);
        var varOffset = offset + 13;
        if (this.specs != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 13);
            if (specs.length > 4096000) throw ProtocolException.arrayTooLong("Specs", specs.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.specs.length);
            
            var specsValueOffset = 0;
            for (var i = 0; i < this.specs.length; i++) {
                specsValueOffset += this.specs[i].serialize(mem, varOffset + specsValueOffset);
            }
            varOffset += specsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.breakShape != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 13);
            varOffset += this.breakShape.serializeWithTypeId(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 13;
        if (specs != null) {
        int specsSize = 0;
for (var elem : specs) specsSize += elem.computeSize();
size += VarInt.size(specs.length) + specsSize;
    }
    if (breakShape != null) size += breakShape.computeSizeWithTypeId();

        return size;
    }

    public ItemTool clone() {
        ItemTool copy = new ItemTool();
        copy.specs = this.specs != null ? java.util.Arrays.stream(this.specs).map(e -> e.clone()).toArray(ItemToolSpec[]::new) : null;
        copy.speed = this.speed;
        copy.breakShape = this.breakShape;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemTool other)) return false;
        return java.util.Arrays.equals(this.specs, other.specs) && this.speed == other.speed && java.util.Objects.equals(this.breakShape, other.breakShape);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(specs);
        result = 31 * result + Float.hashCode(speed);
        result = 31 * result + java.util.Objects.hashCode(breakShape);
        return result;
    }

}