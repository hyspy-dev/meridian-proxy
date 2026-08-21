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
import org.joml.*;

public class ModelTrail {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 27;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 35;
    public static final int MAX_SIZE = 32768045;

    @Nullable public String trailId;
    @Nonnull public EntityPart targetEntityPart = EntityPart.Self;
    @Nullable public String targetNodeName;
    @Nullable public Vector3fc positionOffset;
    @Nullable public Direction rotationOffset;
    public boolean fixedRotation;

    public ModelTrail() {
    }

    public ModelTrail(@Nullable String trailId, @Nonnull EntityPart targetEntityPart, @Nullable String targetNodeName, @Nullable Vector3fc positionOffset, @Nullable Direction rotationOffset, boolean fixedRotation) {
        this.trailId = trailId;
        this.targetEntityPart = targetEntityPart;
        this.targetNodeName = targetNodeName;
        this.positionOffset = positionOffset;
        this.rotationOffset = rotationOffset;
        this.fixedRotation = fixedRotation;
    }

    public ModelTrail(@Nonnull ModelTrail other) {
        this.trailId = other.trailId;
        this.targetEntityPart = other.targetEntityPart;
        this.targetNodeName = other.targetNodeName;
        this.positionOffset = other.positionOffset;
        this.rotationOffset = other.rotationOffset;
        this.fixedRotation = other.fixedRotation;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ModelTrail", offset, (int) mem.byteSize());
        long needed = (long) offset + 35;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ModelTrail", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getTrailId(MemorySegment mem) {
        return getTrailId(mem, 0);
    }
    
    @Nullable
    public static String getTrailId(MemorySegment mem, int offset) {
        return hasTrailId(mem, offset) ? PacketIO.readVarString("TrailId", mem, offset + getValidatedOffset(mem, offset, 27, 35, "TrailId"), 4096000): null;
    }
    
    public static EntityPart getTargetEntityPart(MemorySegment mem) {
        return getTargetEntityPart(mem, 0);
    }
    
    public static EntityPart getTargetEntityPart(MemorySegment mem, int offset) {
        return EntityPart.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static String getTargetNodeName(MemorySegment mem) {
        return getTargetNodeName(mem, 0);
    }
    
    @Nullable
    public static String getTargetNodeName(MemorySegment mem, int offset) {
        return hasTargetNodeName(mem, offset) ? PacketIO.readVarString("TargetNodeName", mem, offset + getValidatedOffset(mem, offset, 31, 35, "TargetNodeName"), 4096000): null;
    }
    
    @Nullable
    public static Vector3fc getPositionOffset(MemorySegment mem) {
        return getPositionOffset(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getPositionOffset(MemorySegment mem, int offset) {
        return hasPositionOffset(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 2), "PositionOffset"): null;
    }
    
    @Nullable
    public static Direction getRotationOffset(MemorySegment mem) {
        return getRotationOffset(mem, 0);
    }
    
    @Nullable
    public static Direction getRotationOffset(MemorySegment mem, int offset) {
        return hasRotationOffset(mem, offset) ? Direction.toObject(mem, offset + 14): null;
    }
    
    public static boolean getFixedRotation(MemorySegment mem) {
        return getFixedRotation(mem, 0);
    }
    
    public static boolean getFixedRotation(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 26);
    }
    
    public static boolean hasPositionOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasRotationOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasTrailId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasTargetNodeName(MemorySegment mem, int offset) {
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
    
    public static ModelTrail toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ModelTrail toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ModelTrail and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ModelTrail toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 35;
        var varPos = 0;
        String v0 = null;
        if (hasTrailId(mem, offset)) {
            requireSlot(mem, offset + 27, varPos, "TrailId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("TrailId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 27, -1, "TrailId");
        }
        
        String v2 = null;
        if (hasTargetNodeName(mem, offset)) {
            requireSlot(mem, offset + 31, varPos, "TargetNodeName");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("TargetNodeName", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 31, -1, "TargetNodeName");
        }
        var result = new ModelTrail(
            v0,
            EntityPart.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v2,
            hasPositionOffset(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 2), "PositionOffset") : null,
            hasRotationOffset(mem, offset) ? Direction.toObject(mem, offset + 14) : null,
            mem.get(PacketIO.PROTO_BOOL, offset + 26)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.positionOffset != null) nullBits |= 0x01;
        if (this.rotationOffset != null) nullBits |= 0x02;
        if (this.trailId != null) nullBits |= 0x04;
        if (this.targetNodeName != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.targetEntityPart.getValue());
        if (this.positionOffset != null) {
            PacketIO.requireFinite(this.positionOffset, "PositionOffset"); PacketIO.writeVector3f(mem, offset + 2, this.positionOffset);
        } else {
            mem.asSlice(offset + 2, 12).fill((byte) 0); 
        }
        if (this.rotationOffset != null) {
            this.rotationOffset.serialize(mem, offset + 14);
        } else {
            mem.asSlice(offset + 14, 12).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BOOL, offset + 26, this.fixedRotation);
        var varOffset = offset + 35;
        if (this.trailId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 27, varOffset - offset - 35);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.trailId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 27, -1);
        }
        if (this.targetNodeName != null) {
            mem.set(PacketIO.PROTO_INT, offset + 31, varOffset - offset - 35);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.targetNodeName, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 31, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 35;
        if (trailId != null) size += PacketIO.stringSize(trailId);
    if (targetNodeName != null) size += PacketIO.stringSize(targetNodeName);

        return size;
    }

    public ModelTrail clone() {
        ModelTrail copy = new ModelTrail();
        copy.trailId = this.trailId;
        copy.targetEntityPart = this.targetEntityPart;
        copy.targetNodeName = this.targetNodeName;
        copy.positionOffset = this.positionOffset;
        copy.rotationOffset = this.rotationOffset != null ? this.rotationOffset.clone() : null;
        copy.fixedRotation = this.fixedRotation;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ModelTrail other)) return false;
        return java.util.Objects.equals(this.trailId, other.trailId) && java.util.Objects.equals(this.targetEntityPart, other.targetEntityPart) && java.util.Objects.equals(this.targetNodeName, other.targetNodeName) && java.util.Objects.equals(this.positionOffset, other.positionOffset) && java.util.Objects.equals(this.rotationOffset, other.rotationOffset) && this.fixedRotation == other.fixedRotation;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(trailId, targetEntityPart, targetNodeName, positionOffset, rotationOffset, fixedRotation);
    }

}