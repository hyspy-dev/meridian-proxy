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


public class ShapeConnectedBlockRule extends ConnectedBlockRule {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 13;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 21;
    public static final int MAX_SIZE = 32768031;

    @Nonnull public Vector3i positionOffset = new Vector3i();
    @Nonnull public String shapeId = "";
    @Nullable public int[] allowedRotations;

    public ShapeConnectedBlockRule() {
    }

    public ShapeConnectedBlockRule(@Nonnull Vector3i positionOffset, @Nonnull String shapeId, @Nullable int[] allowedRotations) {
        this.positionOffset = positionOffset;
        this.shapeId = shapeId;
        this.allowedRotations = allowedRotations;
    }

    public ShapeConnectedBlockRule(@Nonnull ShapeConnectedBlockRule other) {
        this.positionOffset = other.positionOffset;
        this.shapeId = other.shapeId;
        this.allowedRotations = other.allowedRotations;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ShapeConnectedBlockRule", offset, (int) mem.byteSize());
        long needed = (long) offset + 21;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ShapeConnectedBlockRule", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static Vector3i getPositionOffset(MemorySegment mem) {
        return getPositionOffset(mem, 0);
    }
    
    public static Vector3i getPositionOffset(MemorySegment mem, int offset) {
        return Vector3i.toObject(mem, offset + 1);
    }
    
    public static String getShapeId(MemorySegment mem) {
        return getShapeId(mem, 0);
    }
    
    public static String getShapeId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("ShapeId", mem, offset + getValidatedOffset(mem, offset, 13, 21, "ShapeId"), 4096000);
    }
    
    @Nullable
    public static int[] getAllowedRotations(MemorySegment mem) {
        return getAllowedRotations(mem, 0);
    }
    
    @Nullable
    public static int[] getAllowedRotations(MemorySegment mem, int offset) {
        if (!hasAllowedRotations(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 17, 21, "AllowedRotations");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("AllowedRotations");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("AllowedRotations", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("AllowedRotations", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    public static boolean hasAllowedRotations(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
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
    
    public static ShapeConnectedBlockRule toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ShapeConnectedBlockRule toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ShapeConnectedBlockRule and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ShapeConnectedBlockRule toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 21;
        var varPos = 0;
        String v1;
        requireSlot(mem, offset + 13, varPos, "ShapeId");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("ShapeId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        int[] v2 = null;
        if (hasAllowedRotations(mem, offset)) {
            requireSlot(mem, offset + 17, varPos, "AllowedRotations");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("AllowedRotations");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("AllowedRotations", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("AllowedRotations", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v2, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 17, -1, "AllowedRotations");
        }
        var result = new ShapeConnectedBlockRule(
            Vector3i.toObject(mem, offset + 1),
            v1,
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.allowedRotations != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        this.positionOffset.serialize(mem, offset + 1);
        var varOffset = offset + 21;
        mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 21);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.shapeId, 4096000);
        if (this.allowedRotations != null) {
            mem.set(PacketIO.PROTO_INT, offset + 17, varOffset - offset - 21);
            if (allowedRotations.length > 4096000) throw ProtocolException.arrayTooLong("AllowedRotations", allowedRotations.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.allowedRotations.length);
            
            MemorySegment.copy(this.allowedRotations, 0, mem, PacketIO.PROTO_INT, varOffset, this.allowedRotations.length);
            varOffset += this.allowedRotations.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 17, -1);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 21;
        size += PacketIO.stringSize(shapeId);
    if (allowedRotations != null) size += VarInt.size(allowedRotations.length) + allowedRotations.length * 4;

        return size;
    }

    public ShapeConnectedBlockRule clone() {
        ShapeConnectedBlockRule copy = new ShapeConnectedBlockRule();
        copy.positionOffset = this.positionOffset.clone();
        copy.shapeId = this.shapeId;
        copy.allowedRotations = this.allowedRotations != null ? java.util.Arrays.copyOf(this.allowedRotations, this.allowedRotations.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ShapeConnectedBlockRule other)) return false;
        return java.util.Objects.equals(this.positionOffset, other.positionOffset) && java.util.Objects.equals(this.shapeId, other.shapeId) && java.util.Arrays.equals(this.allowedRotations, other.allowedRotations);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(positionOffset);
        result = 31 * result + java.util.Objects.hashCode(shapeId);
        result = 31 * result + java.util.Arrays.hashCode(allowedRotations);
        return result;
    }

}