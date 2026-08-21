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


public class ModelAttachment {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 4;
    public static final int VARIABLE_BLOCK_START = 17;
    public static final int MAX_SIZE = 65536037;

    @Nullable public String model;
    @Nullable public String texture;
    @Nullable public String gradientSet;
    @Nullable public String gradientId;

    public ModelAttachment() {
    }

    public ModelAttachment(@Nullable String model, @Nullable String texture, @Nullable String gradientSet, @Nullable String gradientId) {
        this.model = model;
        this.texture = texture;
        this.gradientSet = gradientSet;
        this.gradientId = gradientId;
    }

    public ModelAttachment(@Nonnull ModelAttachment other) {
        this.model = other.model;
        this.texture = other.texture;
        this.gradientSet = other.gradientSet;
        this.gradientId = other.gradientId;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ModelAttachment", offset, (int) mem.byteSize());
        long needed = (long) offset + 17;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ModelAttachment", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getModel(MemorySegment mem) {
        return getModel(mem, 0);
    }
    
    @Nullable
    public static String getModel(MemorySegment mem, int offset) {
        return hasModel(mem, offset) ? PacketIO.readVarString("Model", mem, offset + getValidatedOffset(mem, offset, 1, 17, "Model"), 4096000): null;
    }
    
    @Nullable
    public static String getTexture(MemorySegment mem) {
        return getTexture(mem, 0);
    }
    
    @Nullable
    public static String getTexture(MemorySegment mem, int offset) {
        return hasTexture(mem, offset) ? PacketIO.readVarString("Texture", mem, offset + getValidatedOffset(mem, offset, 5, 17, "Texture"), 4096000): null;
    }
    
    @Nullable
    public static String getGradientSet(MemorySegment mem) {
        return getGradientSet(mem, 0);
    }
    
    @Nullable
    public static String getGradientSet(MemorySegment mem, int offset) {
        return hasGradientSet(mem, offset) ? PacketIO.readVarString("GradientSet", mem, offset + getValidatedOffset(mem, offset, 9, 17, "GradientSet"), 4096000): null;
    }
    
    @Nullable
    public static String getGradientId(MemorySegment mem) {
        return getGradientId(mem, 0);
    }
    
    @Nullable
    public static String getGradientId(MemorySegment mem, int offset) {
        return hasGradientId(mem, offset) ? PacketIO.readVarString("GradientId", mem, offset + getValidatedOffset(mem, offset, 13, 17, "GradientId"), 4096000): null;
    }
    
    public static boolean hasModel(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasTexture(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasGradientSet(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasGradientId(MemorySegment mem, int offset) {
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
    
    public static ModelAttachment toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ModelAttachment toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ModelAttachment and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ModelAttachment toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 17;
        var varPos = 0;
        String v0 = null;
        if (hasModel(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "Model");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Model", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 1, -1, "Model");
        }
        
        String v1 = null;
        if (hasTexture(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Texture");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Texture", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 5, -1, "Texture");
        }
        
        String v2 = null;
        if (hasGradientSet(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "GradientSet");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("GradientSet", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 9, -1, "GradientSet");
        }
        
        String v3 = null;
        if (hasGradientId(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "GradientId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readVarString("GradientId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 13, -1, "GradientId");
        }
        var result = new ModelAttachment(
            v0,
            v1,
            v2,
            v3
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.model != null) nullBits |= 0x01;
        if (this.texture != null) nullBits |= 0x02;
        if (this.gradientSet != null) nullBits |= 0x04;
        if (this.gradientId != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 17;
        if (this.model != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 17);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.model, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.texture != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 17);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.texture, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.gradientSet != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 17);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.gradientSet, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
        if (this.gradientId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 17);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.gradientId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 17;
        if (model != null) size += PacketIO.stringSize(model);
    if (texture != null) size += PacketIO.stringSize(texture);
    if (gradientSet != null) size += PacketIO.stringSize(gradientSet);
    if (gradientId != null) size += PacketIO.stringSize(gradientId);

        return size;
    }

    public ModelAttachment clone() {
        ModelAttachment copy = new ModelAttachment();
        copy.model = this.model;
        copy.texture = this.texture;
        copy.gradientSet = this.gradientSet;
        copy.gradientId = this.gradientId;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ModelAttachment other)) return false;
        return java.util.Objects.equals(this.model, other.model) && java.util.Objects.equals(this.texture, other.texture) && java.util.Objects.equals(this.gradientSet, other.gradientSet) && java.util.Objects.equals(this.gradientId, other.gradientId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(model, texture, gradientSet, gradientId);
    }

}