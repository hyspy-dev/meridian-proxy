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


public class ConnectedBlockPattern {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 14;
    public static final int MAX_SIZE = 32769048;

    @Nullable public ConnectedBlockRule rule;
    @Nullable public int[] rotations;
    public boolean transformRulesWithOrientation;
    @Nonnull public String outputShapeId = "";

    public ConnectedBlockPattern() {
    }

    public ConnectedBlockPattern(@Nullable ConnectedBlockRule rule, @Nullable int[] rotations, boolean transformRulesWithOrientation, @Nonnull String outputShapeId) {
        this.rule = rule;
        this.rotations = rotations;
        this.transformRulesWithOrientation = transformRulesWithOrientation;
        this.outputShapeId = outputShapeId;
    }

    public ConnectedBlockPattern(@Nonnull ConnectedBlockPattern other) {
        this.rule = other.rule;
        this.rotations = other.rotations;
        this.transformRulesWithOrientation = other.transformRulesWithOrientation;
        this.outputShapeId = other.outputShapeId;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ConnectedBlockPattern", offset, (int) mem.byteSize());
        long needed = (long) offset + 14;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ConnectedBlockPattern", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static ConnectedBlockRule getRule(MemorySegment mem) {
        return getRule(mem, 0);
    }
    
    @Nullable
    public static ConnectedBlockRule getRule(MemorySegment mem, int offset) {
        return hasRule(mem, offset) ? ConnectedBlockRule.toObject(mem, offset + getValidatedOffset(mem, offset, 2, 14, "Rule")): null;
    }
    
    @Nullable
    public static int[] getRotations(MemorySegment mem) {
        return getRotations(mem, 0);
    }
    
    @Nullable
    public static int[] getRotations(MemorySegment mem, int offset) {
        if (!hasRotations(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 6, 14, "Rotations");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Rotations");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Rotations", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Rotations", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    public static boolean getTransformRulesWithOrientation(MemorySegment mem) {
        return getTransformRulesWithOrientation(mem, 0);
    }
    
    public static boolean getTransformRulesWithOrientation(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 1);
    }
    
    public static String getOutputShapeId(MemorySegment mem) {
        return getOutputShapeId(mem, 0);
    }
    
    public static String getOutputShapeId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("OutputShapeId", mem, offset + getValidatedOffset(mem, offset, 10, 14, "OutputShapeId"), 4096000);
    }
    
    public static boolean hasRule(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasRotations(MemorySegment mem, int offset) {
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
    
    public static ConnectedBlockPattern toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ConnectedBlockPattern toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ConnectedBlockPattern and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ConnectedBlockPattern toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 14;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ConnectedBlockRule v0 = null;
        if (hasRule(mem, offset)) {
            requireSlot(mem, offset + 2, varPos, "Rule");
            v0 = ConnectedBlockRule.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 2, -1, "Rule");
        }
        
        int[] v1 = null;
        if (hasRotations(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "Rotations");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Rotations");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Rotations", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Rotations", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v1, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 6, -1, "Rotations");
        }
        
        String v3;
        requireSlot(mem, offset + 10, varPos, "OutputShapeId");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readVarString("OutputShapeId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new ConnectedBlockPattern(
            v0,
            v1,
            mem.get(PacketIO.PROTO_BOOL, offset + 1),
            v3
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.rule != null) nullBits |= 0x01;
        if (this.rotations != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BOOL, offset + 1, this.transformRulesWithOrientation);
        var varOffset = offset + 14;
        if (this.rule != null) {
            mem.set(PacketIO.PROTO_INT, offset + 2, varOffset - offset - 14);
            varOffset += this.rule.serializeWithTypeId(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 2, -1);
        }
        if (this.rotations != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 14);
            if (rotations.length > 4096000) throw ProtocolException.arrayTooLong("Rotations", rotations.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.rotations.length);
            
            MemorySegment.copy(this.rotations, 0, mem, PacketIO.PROTO_INT, varOffset, this.rotations.length);
            varOffset += this.rotations.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
        mem.set(PacketIO.PROTO_INT, offset + 10, varOffset - offset - 14);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.outputShapeId, 4096000);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 14;
        if (rule != null) size += rule.computeSizeWithTypeId();
    if (rotations != null) size += VarInt.size(rotations.length) + rotations.length * 4;
    size += PacketIO.stringSize(outputShapeId);

        return size;
    }

    public ConnectedBlockPattern clone() {
        ConnectedBlockPattern copy = new ConnectedBlockPattern();
        copy.rule = this.rule;
        copy.rotations = this.rotations != null ? java.util.Arrays.copyOf(this.rotations, this.rotations.length) : null;
        copy.transformRulesWithOrientation = this.transformRulesWithOrientation;
        copy.outputShapeId = this.outputShapeId;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ConnectedBlockPattern other)) return false;
        return java.util.Objects.equals(this.rule, other.rule) && java.util.Arrays.equals(this.rotations, other.rotations) && this.transformRulesWithOrientation == other.transformRulesWithOrientation && java.util.Objects.equals(this.outputShapeId, other.outputShapeId);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(rule);
        result = 31 * result + java.util.Arrays.hashCode(rotations);
        result = 31 * result + Boolean.hashCode(transformRulesWithOrientation);
        result = 31 * result + java.util.Objects.hashCode(outputShapeId);
        return result;
    }

}