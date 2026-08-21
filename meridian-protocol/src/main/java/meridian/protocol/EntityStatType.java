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


public class EntityStatType {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 15;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 27;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String id;
    public float value;
    public float min;
    public float max;
    @Nullable public EntityStatEffects minValueEffects;
    @Nullable public EntityStatEffects maxValueEffects;
    @Nonnull public EntityStatResetBehavior resetBehavior = EntityStatResetBehavior.InitialValue;
    public boolean hideFromTooltip;

    public EntityStatType() {
    }

    public EntityStatType(@Nullable String id, float value, float min, float max, @Nullable EntityStatEffects minValueEffects, @Nullable EntityStatEffects maxValueEffects, @Nonnull EntityStatResetBehavior resetBehavior, boolean hideFromTooltip) {
        this.id = id;
        this.value = value;
        this.min = min;
        this.max = max;
        this.minValueEffects = minValueEffects;
        this.maxValueEffects = maxValueEffects;
        this.resetBehavior = resetBehavior;
        this.hideFromTooltip = hideFromTooltip;
    }

    public EntityStatType(@Nonnull EntityStatType other) {
        this.id = other.id;
        this.value = other.value;
        this.min = other.min;
        this.max = other.max;
        this.minValueEffects = other.minValueEffects;
        this.maxValueEffects = other.maxValueEffects;
        this.resetBehavior = other.resetBehavior;
        this.hideFromTooltip = other.hideFromTooltip;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("EntityStatType", offset, (int) mem.byteSize());
        long needed = (long) offset + 27;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("EntityStatType", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 15, 27, "Id"), 4096000): null;
    }
    
    public static float getValue(MemorySegment mem) {
        return getValue(mem, 0);
    }
    
    public static float getValue(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Value");
    }
    
    public static float getMin(MemorySegment mem) {
        return getMin(mem, 0);
    }
    
    public static float getMin(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "Min");
    }
    
    public static float getMax(MemorySegment mem) {
        return getMax(mem, 0);
    }
    
    public static float getMax(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "Max");
    }
    
    @Nullable
    public static EntityStatEffects getMinValueEffects(MemorySegment mem) {
        return getMinValueEffects(mem, 0);
    }
    
    @Nullable
    public static EntityStatEffects getMinValueEffects(MemorySegment mem, int offset) {
        return hasMinValueEffects(mem, offset) ? EntityStatEffects.toObject(mem, offset + getValidatedOffset(mem, offset, 19, 27, "MinValueEffects")): null;
    }
    
    @Nullable
    public static EntityStatEffects getMaxValueEffects(MemorySegment mem) {
        return getMaxValueEffects(mem, 0);
    }
    
    @Nullable
    public static EntityStatEffects getMaxValueEffects(MemorySegment mem, int offset) {
        return hasMaxValueEffects(mem, offset) ? EntityStatEffects.toObject(mem, offset + getValidatedOffset(mem, offset, 23, 27, "MaxValueEffects")): null;
    }
    
    public static EntityStatResetBehavior getResetBehavior(MemorySegment mem) {
        return getResetBehavior(mem, 0);
    }
    
    public static EntityStatResetBehavior getResetBehavior(MemorySegment mem, int offset) {
        return EntityStatResetBehavior.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 13));
    }
    
    public static boolean getHideFromTooltip(MemorySegment mem) {
        return getHideFromTooltip(mem, 0);
    }
    
    public static boolean getHideFromTooltip(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 14);
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasMinValueEffects(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasMaxValueEffects(MemorySegment mem, int offset) {
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
    
    public static EntityStatType toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static EntityStatType toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one EntityStatType and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static EntityStatType toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 27;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 15, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 15, -1, "Id");
        }
        
        EntityStatEffects v4 = null;
        if (hasMinValueEffects(mem, offset)) {
            requireSlot(mem, offset + 19, varPos, "MinValueEffects");
            v4 = EntityStatEffects.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 19, -1, "MinValueEffects");
        }
        
        EntityStatEffects v5 = null;
        if (hasMaxValueEffects(mem, offset)) {
            requireSlot(mem, offset + 23, varPos, "MaxValueEffects");
            v5 = EntityStatEffects.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 23, -1, "MaxValueEffects");
        }
        var result = new EntityStatType(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Value"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "Min"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "Max"),
            v4,
            v5,
            EntityStatResetBehavior.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 13)),
            mem.get(PacketIO.PROTO_BOOL, offset + 14)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        if (this.minValueEffects != null) nullBits |= 0x02;
        if (this.maxValueEffects != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.value, "Value"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.value);
        PacketIO.requireFinite(this.min, "Min"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.min);
        PacketIO.requireFinite(this.max, "Max"); mem.set(PacketIO.PROTO_FLOAT, offset + 9, this.max);
        mem.set(PacketIO.PROTO_BYTE, offset + 13, (byte) this.resetBehavior.getValue());
        mem.set(PacketIO.PROTO_BOOL, offset + 14, this.hideFromTooltip);
        var varOffset = offset + 27;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 15, varOffset - offset - 27);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 15, -1);
        }
        if (this.minValueEffects != null) {
            mem.set(PacketIO.PROTO_INT, offset + 19, varOffset - offset - 27);
            varOffset += this.minValueEffects.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 19, -1);
        }
        if (this.maxValueEffects != null) {
            mem.set(PacketIO.PROTO_INT, offset + 23, varOffset - offset - 27);
            varOffset += this.maxValueEffects.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 23, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 27;
        if (id != null) size += PacketIO.stringSize(id);
    if (minValueEffects != null) size += minValueEffects.computeSize();
    if (maxValueEffects != null) size += maxValueEffects.computeSize();

        return size;
    }

    public EntityStatType clone() {
        EntityStatType copy = new EntityStatType();
        copy.id = this.id;
        copy.value = this.value;
        copy.min = this.min;
        copy.max = this.max;
        copy.minValueEffects = this.minValueEffects != null ? this.minValueEffects.clone() : null;
        copy.maxValueEffects = this.maxValueEffects != null ? this.maxValueEffects.clone() : null;
        copy.resetBehavior = this.resetBehavior;
        copy.hideFromTooltip = this.hideFromTooltip;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EntityStatType other)) return false;
        return java.util.Objects.equals(this.id, other.id) && this.value == other.value && this.min == other.min && this.max == other.max && java.util.Objects.equals(this.minValueEffects, other.minValueEffects) && java.util.Objects.equals(this.maxValueEffects, other.maxValueEffects) && java.util.Objects.equals(this.resetBehavior, other.resetBehavior) && this.hideFromTooltip == other.hideFromTooltip;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, value, min, max, minValueEffects, maxValueEffects, resetBehavior, hideFromTooltip);
    }

}