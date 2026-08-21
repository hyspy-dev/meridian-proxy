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

public class ModelParticle {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 34;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 42;
    public static final int MAX_SIZE = 32768052;

    @Nullable public String systemId;
    public float scale;
    @Nullable public Color color;
    @Nonnull public EntityPart targetEntityPart = EntityPart.Self;
    @Nullable public String targetNodeName;
    @Nullable public Vector3fc positionOffset;
    @Nullable public Direction rotationOffset;
    public boolean detachedFromModel;
    public boolean clearParticlesOnRemove;

    public ModelParticle() {
    }

    public ModelParticle(@Nullable String systemId, float scale, @Nullable Color color, @Nonnull EntityPart targetEntityPart, @Nullable String targetNodeName, @Nullable Vector3fc positionOffset, @Nullable Direction rotationOffset, boolean detachedFromModel, boolean clearParticlesOnRemove) {
        this.systemId = systemId;
        this.scale = scale;
        this.color = color;
        this.targetEntityPart = targetEntityPart;
        this.targetNodeName = targetNodeName;
        this.positionOffset = positionOffset;
        this.rotationOffset = rotationOffset;
        this.detachedFromModel = detachedFromModel;
        this.clearParticlesOnRemove = clearParticlesOnRemove;
    }

    public ModelParticle(@Nonnull ModelParticle other) {
        this.systemId = other.systemId;
        this.scale = other.scale;
        this.color = other.color;
        this.targetEntityPart = other.targetEntityPart;
        this.targetNodeName = other.targetNodeName;
        this.positionOffset = other.positionOffset;
        this.rotationOffset = other.rotationOffset;
        this.detachedFromModel = other.detachedFromModel;
        this.clearParticlesOnRemove = other.clearParticlesOnRemove;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ModelParticle", offset, (int) mem.byteSize());
        long needed = (long) offset + 42;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ModelParticle", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getSystemId(MemorySegment mem) {
        return getSystemId(mem, 0);
    }
    
    @Nullable
    public static String getSystemId(MemorySegment mem, int offset) {
        return hasSystemId(mem, offset) ? PacketIO.readVarString("SystemId", mem, offset + getValidatedOffset(mem, offset, 34, 42, "SystemId"), 4096000): null;
    }
    
    public static float getScale(MemorySegment mem) {
        return getScale(mem, 0);
    }
    
    public static float getScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Scale");
    }
    
    @Nullable
    public static Color getColor(MemorySegment mem) {
        return getColor(mem, 0);
    }
    
    @Nullable
    public static Color getColor(MemorySegment mem, int offset) {
        return hasColor(mem, offset) ? Color.toObject(mem, offset + 5): null;
    }
    
    public static EntityPart getTargetEntityPart(MemorySegment mem) {
        return getTargetEntityPart(mem, 0);
    }
    
    public static EntityPart getTargetEntityPart(MemorySegment mem, int offset) {
        return EntityPart.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 8));
    }
    
    @Nullable
    public static String getTargetNodeName(MemorySegment mem) {
        return getTargetNodeName(mem, 0);
    }
    
    @Nullable
    public static String getTargetNodeName(MemorySegment mem, int offset) {
        return hasTargetNodeName(mem, offset) ? PacketIO.readVarString("TargetNodeName", mem, offset + getValidatedOffset(mem, offset, 38, 42, "TargetNodeName"), 4096000): null;
    }
    
    @Nullable
    public static Vector3fc getPositionOffset(MemorySegment mem) {
        return getPositionOffset(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getPositionOffset(MemorySegment mem, int offset) {
        return hasPositionOffset(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 9), "PositionOffset"): null;
    }
    
    @Nullable
    public static Direction getRotationOffset(MemorySegment mem) {
        return getRotationOffset(mem, 0);
    }
    
    @Nullable
    public static Direction getRotationOffset(MemorySegment mem, int offset) {
        return hasRotationOffset(mem, offset) ? Direction.toObject(mem, offset + 21): null;
    }
    
    public static boolean getDetachedFromModel(MemorySegment mem) {
        return getDetachedFromModel(mem, 0);
    }
    
    public static boolean getDetachedFromModel(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 33) & 0x01) != 0;
    }
    
    public static boolean getClearParticlesOnRemove(MemorySegment mem) {
        return getClearParticlesOnRemove(mem, 0);
    }
    
    public static boolean getClearParticlesOnRemove(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 33) & 0x02) != 0;
    }
    
    public static boolean hasColor(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasPositionOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasRotationOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasSystemId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasTargetNodeName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
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
    
    public static ModelParticle toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ModelParticle toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ModelParticle and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ModelParticle toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 42;
        var varPos = 0;
        String v0 = null;
        if (hasSystemId(mem, offset)) {
            requireSlot(mem, offset + 34, varPos, "SystemId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("SystemId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 34, -1, "SystemId");
        }
        
        String v4 = null;
        if (hasTargetNodeName(mem, offset)) {
            requireSlot(mem, offset + 38, varPos, "TargetNodeName");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v4 = PacketIO.readVarString("TargetNodeName", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 38, -1, "TargetNodeName");
        }
        var result = new ModelParticle(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Scale"),
            hasColor(mem, offset) ? Color.toObject(mem, offset + 5) : null,
            EntityPart.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 8)),
            v4,
            hasPositionOffset(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 9), "PositionOffset") : null,
            hasRotationOffset(mem, offset) ? Direction.toObject(mem, offset + 21) : null,
            (mem.get(PacketIO.PROTO_BYTE, offset + 33) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 33) & 0x02) != 0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.color != null) nullBits |= 0x01;
        if (this.positionOffset != null) nullBits |= 0x02;
        if (this.rotationOffset != null) nullBits |= 0x04;
        if (this.systemId != null) nullBits |= 0x08;
        if (this.targetNodeName != null) nullBits |= 0x10;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.scale, "Scale"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.scale);
        if (this.color != null) {
            this.color.serialize(mem, offset + 5);
        } else {
            mem.asSlice(offset + 5, 3).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BYTE, offset + 8, (byte) this.targetEntityPart.getValue());
        if (this.positionOffset != null) {
            PacketIO.requireFinite(this.positionOffset, "PositionOffset"); PacketIO.writeVector3f(mem, offset + 9, this.positionOffset);
        } else {
            mem.asSlice(offset + 9, 12).fill((byte) 0); 
        }
        if (this.rotationOffset != null) {
            this.rotationOffset.serialize(mem, offset + 21);
        } else {
            mem.asSlice(offset + 21, 12).fill((byte) 0); 
        }
        byte boolBits0_0 = 0;
        if (this.detachedFromModel) boolBits0_0 |= 0x01;
        if (this.clearParticlesOnRemove) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 33 + 0, boolBits0_0);
        var varOffset = offset + 42;
        if (this.systemId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 34, varOffset - offset - 42);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.systemId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 34, -1);
        }
        if (this.targetNodeName != null) {
            mem.set(PacketIO.PROTO_INT, offset + 38, varOffset - offset - 42);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.targetNodeName, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 38, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 42;
        if (systemId != null) size += PacketIO.stringSize(systemId);
    if (targetNodeName != null) size += PacketIO.stringSize(targetNodeName);

        return size;
    }

    public ModelParticle clone() {
        ModelParticle copy = new ModelParticle();
        copy.systemId = this.systemId;
        copy.scale = this.scale;
        copy.color = this.color != null ? this.color.clone() : null;
        copy.targetEntityPart = this.targetEntityPart;
        copy.targetNodeName = this.targetNodeName;
        copy.positionOffset = this.positionOffset;
        copy.rotationOffset = this.rotationOffset != null ? this.rotationOffset.clone() : null;
        copy.detachedFromModel = this.detachedFromModel;
        copy.clearParticlesOnRemove = this.clearParticlesOnRemove;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ModelParticle other)) return false;
        return java.util.Objects.equals(this.systemId, other.systemId) && this.scale == other.scale && java.util.Objects.equals(this.color, other.color) && java.util.Objects.equals(this.targetEntityPart, other.targetEntityPart) && java.util.Objects.equals(this.targetNodeName, other.targetNodeName) && java.util.Objects.equals(this.positionOffset, other.positionOffset) && java.util.Objects.equals(this.rotationOffset, other.rotationOffset) && this.detachedFromModel == other.detachedFromModel && this.clearParticlesOnRemove == other.clearParticlesOnRemove;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(systemId, scale, color, targetEntityPart, targetNodeName, positionOffset, rotationOffset, detachedFromModel, clearParticlesOnRemove);
    }

}