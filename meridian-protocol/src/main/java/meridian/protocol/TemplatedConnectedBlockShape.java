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


public class TemplatedConnectedBlockShape extends ConnectedBlockShape {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String templateId;

    public TemplatedConnectedBlockShape() {
    }

    public TemplatedConnectedBlockShape(@Nullable ConnectedBlockFaceTags faceTags, int relativeRotationIndex, @Nullable String templateId) {
        this.faceTags = faceTags;
        this.relativeRotationIndex = relativeRotationIndex;
        this.templateId = templateId;
    }

    public TemplatedConnectedBlockShape(@Nonnull TemplatedConnectedBlockShape other) {
        this.faceTags = other.faceTags;
        this.relativeRotationIndex = other.relativeRotationIndex;
        this.templateId = other.templateId;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("TemplatedConnectedBlockShape", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("TemplatedConnectedBlockShape", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static ConnectedBlockFaceTags getFaceTags(MemorySegment mem) {
        return getFaceTags(mem, 0);
    }
    
    @Nullable
    public static ConnectedBlockFaceTags getFaceTags(MemorySegment mem, int offset) {
        return hasFaceTags(mem, offset) ? ConnectedBlockFaceTags.toObject(mem, offset + getValidatedOffset(mem, offset, 5, 13, "FaceTags")): null;
    }
    
    public static int getRelativeRotationIndex(MemorySegment mem) {
        return getRelativeRotationIndex(mem, 0);
    }
    
    public static int getRelativeRotationIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static String getTemplateId(MemorySegment mem) {
        return getTemplateId(mem, 0);
    }
    
    @Nullable
    public static String getTemplateId(MemorySegment mem, int offset) {
        return hasTemplateId(mem, offset) ? PacketIO.readVarString("TemplateId", mem, offset + getValidatedOffset(mem, offset, 9, 13, "TemplateId"), 4096000): null;
    }
    
    public static boolean hasFaceTags(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasTemplateId(MemorySegment mem, int offset) {
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
    
    public static TemplatedConnectedBlockShape toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static TemplatedConnectedBlockShape toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one TemplatedConnectedBlockShape and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static TemplatedConnectedBlockShape toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 13;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ConnectedBlockFaceTags v0 = null;
        if (hasFaceTags(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "FaceTags");
            v0 = ConnectedBlockFaceTags.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "FaceTags");
        }
        
        String v2 = null;
        if (hasTemplateId(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "TemplateId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("TemplateId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 9, -1, "TemplateId");
        }
        var result = new TemplatedConnectedBlockShape(
            v0,
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.faceTags != null) nullBits |= 0x01;
        if (this.templateId != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.relativeRotationIndex);
        var varOffset = offset + 13;
        if (this.faceTags != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 13);
            varOffset += this.faceTags.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.templateId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 13);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.templateId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 13;
        if (faceTags != null) size += faceTags.computeSize();
    if (templateId != null) size += PacketIO.stringSize(templateId);

        return size;
    }

    public TemplatedConnectedBlockShape clone() {
        TemplatedConnectedBlockShape copy = new TemplatedConnectedBlockShape();
        copy.faceTags = this.faceTags != null ? this.faceTags.clone() : null;
        copy.relativeRotationIndex = this.relativeRotationIndex;
        copy.templateId = this.templateId;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TemplatedConnectedBlockShape other)) return false;
        return java.util.Objects.equals(this.faceTags, other.faceTags) && this.relativeRotationIndex == other.relativeRotationIndex && java.util.Objects.equals(this.templateId, other.templateId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(faceTags, relativeRotationIndex, templateId);
    }

}