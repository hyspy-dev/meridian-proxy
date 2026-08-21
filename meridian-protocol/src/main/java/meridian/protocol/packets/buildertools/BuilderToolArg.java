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


public class BuilderToolArg {
    public static final int NULLABLE_BIT_FIELD_SIZE = 2;
    public static final int FIXED_BLOCK_SIZE = 33;
    public static final int VARIABLE_FIELD_COUNT = 5;
    public static final int VARIABLE_BLOCK_START = 53;
    public static final int MAX_SIZE = 1677721600;

    public boolean required;
    @Nullable public String id;
    @Nonnull public BuilderToolArgType argType = BuilderToolArgType.Bool;
    @Nullable public BuilderToolBoolArg boolArg;
    @Nullable public BuilderToolFloatArg floatArg;
    @Nullable public BuilderToolIntArg intArg;
    @Nullable public BuilderToolStringArg stringArg;
    @Nullable public BuilderToolBlockArg blockArg;
    @Nullable public BuilderToolMaskArg maskArg;
    @Nullable public BuilderToolBrushShapeArg brushShapeArg;
    @Nullable public BuilderToolBrushOriginArg brushOriginArg;
    @Nullable public BuilderToolBrushAxisArg brushAxisArg;
    @Nullable public BuilderToolRotationArg rotationArg;
    @Nullable public BuilderToolOptionArg optionArg;

    public BuilderToolArg() {
    }

    public BuilderToolArg(boolean required, @Nullable String id, @Nonnull BuilderToolArgType argType, @Nullable BuilderToolBoolArg boolArg, @Nullable BuilderToolFloatArg floatArg, @Nullable BuilderToolIntArg intArg, @Nullable BuilderToolStringArg stringArg, @Nullable BuilderToolBlockArg blockArg, @Nullable BuilderToolMaskArg maskArg, @Nullable BuilderToolBrushShapeArg brushShapeArg, @Nullable BuilderToolBrushOriginArg brushOriginArg, @Nullable BuilderToolBrushAxisArg brushAxisArg, @Nullable BuilderToolRotationArg rotationArg, @Nullable BuilderToolOptionArg optionArg) {
        this.required = required;
        this.id = id;
        this.argType = argType;
        this.boolArg = boolArg;
        this.floatArg = floatArg;
        this.intArg = intArg;
        this.stringArg = stringArg;
        this.blockArg = blockArg;
        this.maskArg = maskArg;
        this.brushShapeArg = brushShapeArg;
        this.brushOriginArg = brushOriginArg;
        this.brushAxisArg = brushAxisArg;
        this.rotationArg = rotationArg;
        this.optionArg = optionArg;
    }

    public BuilderToolArg(@Nonnull BuilderToolArg other) {
        this.required = other.required;
        this.id = other.id;
        this.argType = other.argType;
        this.boolArg = other.boolArg;
        this.floatArg = other.floatArg;
        this.intArg = other.intArg;
        this.stringArg = other.stringArg;
        this.blockArg = other.blockArg;
        this.maskArg = other.maskArg;
        this.brushShapeArg = other.brushShapeArg;
        this.brushOriginArg = other.brushOriginArg;
        this.brushAxisArg = other.brushAxisArg;
        this.rotationArg = other.rotationArg;
        this.optionArg = other.optionArg;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolArg", offset, (int) mem.byteSize());
        long needed = (long) offset + 53;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolArg", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getRequired(MemorySegment mem) {
        return getRequired(mem, 0);
    }
    
    public static boolean getRequired(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 2);
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 33, 53, "Id"), 4096000): null;
    }
    
    public static BuilderToolArgType getArgType(MemorySegment mem) {
        return getArgType(mem, 0);
    }
    
    public static BuilderToolArgType getArgType(MemorySegment mem, int offset) {
        return BuilderToolArgType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 3));
    }
    
    @Nullable
    public static BuilderToolBoolArg getBoolArg(MemorySegment mem) {
        return getBoolArg(mem, 0);
    }
    
    @Nullable
    public static BuilderToolBoolArg getBoolArg(MemorySegment mem, int offset) {
        return hasBoolArg(mem, offset) ? BuilderToolBoolArg.toObject(mem, offset + 4): null;
    }
    
    @Nullable
    public static BuilderToolFloatArg getFloatArg(MemorySegment mem) {
        return getFloatArg(mem, 0);
    }
    
    @Nullable
    public static BuilderToolFloatArg getFloatArg(MemorySegment mem, int offset) {
        return hasFloatArg(mem, offset) ? BuilderToolFloatArg.toObject(mem, offset + 5): null;
    }
    
    @Nullable
    public static BuilderToolIntArg getIntArg(MemorySegment mem) {
        return getIntArg(mem, 0);
    }
    
    @Nullable
    public static BuilderToolIntArg getIntArg(MemorySegment mem, int offset) {
        return hasIntArg(mem, offset) ? BuilderToolIntArg.toObject(mem, offset + 17): null;
    }
    
    @Nullable
    public static BuilderToolStringArg getStringArg(MemorySegment mem) {
        return getStringArg(mem, 0);
    }
    
    @Nullable
    public static BuilderToolStringArg getStringArg(MemorySegment mem, int offset) {
        return hasStringArg(mem, offset) ? BuilderToolStringArg.toObject(mem, offset + getValidatedOffset(mem, offset, 37, 53, "StringArg")): null;
    }
    
    @Nullable
    public static BuilderToolBlockArg getBlockArg(MemorySegment mem) {
        return getBlockArg(mem, 0);
    }
    
    @Nullable
    public static BuilderToolBlockArg getBlockArg(MemorySegment mem, int offset) {
        return hasBlockArg(mem, offset) ? BuilderToolBlockArg.toObject(mem, offset + getValidatedOffset(mem, offset, 41, 53, "BlockArg")): null;
    }
    
    @Nullable
    public static BuilderToolMaskArg getMaskArg(MemorySegment mem) {
        return getMaskArg(mem, 0);
    }
    
    @Nullable
    public static BuilderToolMaskArg getMaskArg(MemorySegment mem, int offset) {
        return hasMaskArg(mem, offset) ? BuilderToolMaskArg.toObject(mem, offset + getValidatedOffset(mem, offset, 45, 53, "MaskArg")): null;
    }
    
    @Nullable
    public static BuilderToolBrushShapeArg getBrushShapeArg(MemorySegment mem) {
        return getBrushShapeArg(mem, 0);
    }
    
    @Nullable
    public static BuilderToolBrushShapeArg getBrushShapeArg(MemorySegment mem, int offset) {
        return hasBrushShapeArg(mem, offset) ? BuilderToolBrushShapeArg.toObject(mem, offset + 29): null;
    }
    
    @Nullable
    public static BuilderToolBrushOriginArg getBrushOriginArg(MemorySegment mem) {
        return getBrushOriginArg(mem, 0);
    }
    
    @Nullable
    public static BuilderToolBrushOriginArg getBrushOriginArg(MemorySegment mem, int offset) {
        return hasBrushOriginArg(mem, offset) ? BuilderToolBrushOriginArg.toObject(mem, offset + 30): null;
    }
    
    @Nullable
    public static BuilderToolBrushAxisArg getBrushAxisArg(MemorySegment mem) {
        return getBrushAxisArg(mem, 0);
    }
    
    @Nullable
    public static BuilderToolBrushAxisArg getBrushAxisArg(MemorySegment mem, int offset) {
        return hasBrushAxisArg(mem, offset) ? BuilderToolBrushAxisArg.toObject(mem, offset + 31): null;
    }
    
    @Nullable
    public static BuilderToolRotationArg getRotationArg(MemorySegment mem) {
        return getRotationArg(mem, 0);
    }
    
    @Nullable
    public static BuilderToolRotationArg getRotationArg(MemorySegment mem, int offset) {
        return hasRotationArg(mem, offset) ? BuilderToolRotationArg.toObject(mem, offset + 32): null;
    }
    
    @Nullable
    public static BuilderToolOptionArg getOptionArg(MemorySegment mem) {
        return getOptionArg(mem, 0);
    }
    
    @Nullable
    public static BuilderToolOptionArg getOptionArg(MemorySegment mem, int offset) {
        return hasOptionArg(mem, offset) ? BuilderToolOptionArg.toObject(mem, offset + getValidatedOffset(mem, offset, 49, 53, "OptionArg")): null;
    }
    
    public static boolean hasBoolArg(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasFloatArg(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasIntArg(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasBrushShapeArg(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasBrushOriginArg(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasBrushAxisArg(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasRotationArg(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasStringArg(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasBlockArg(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasMaskArg(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasOptionArg(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
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
    
    public static BuilderToolArg toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolArg toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolArg and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolArg toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 53;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v1 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 33, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 33, -1, "Id");
        }
        
        BuilderToolStringArg v6 = null;
        if (hasStringArg(mem, offset)) {
            requireSlot(mem, offset + 37, varPos, "StringArg");
            v6 = BuilderToolStringArg.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 37, -1, "StringArg");
        }
        
        BuilderToolBlockArg v7 = null;
        if (hasBlockArg(mem, offset)) {
            requireSlot(mem, offset + 41, varPos, "BlockArg");
            v7 = BuilderToolBlockArg.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 41, -1, "BlockArg");
        }
        
        BuilderToolMaskArg v8 = null;
        if (hasMaskArg(mem, offset)) {
            requireSlot(mem, offset + 45, varPos, "MaskArg");
            v8 = BuilderToolMaskArg.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 45, -1, "MaskArg");
        }
        
        BuilderToolOptionArg v13 = null;
        if (hasOptionArg(mem, offset)) {
            requireSlot(mem, offset + 49, varPos, "OptionArg");
            v13 = BuilderToolOptionArg.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 49, -1, "OptionArg");
        }
        var result = new BuilderToolArg(
            mem.get(PacketIO.PROTO_BOOL, offset + 2),
            v1,
            BuilderToolArgType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 3)),
            hasBoolArg(mem, offset) ? BuilderToolBoolArg.toObject(mem, offset + 4) : null,
            hasFloatArg(mem, offset) ? BuilderToolFloatArg.toObject(mem, offset + 5) : null,
            hasIntArg(mem, offset) ? BuilderToolIntArg.toObject(mem, offset + 17) : null,
            v6,
            v7,
            v8,
            hasBrushShapeArg(mem, offset) ? BuilderToolBrushShapeArg.toObject(mem, offset + 29) : null,
            hasBrushOriginArg(mem, offset) ? BuilderToolBrushOriginArg.toObject(mem, offset + 30) : null,
            hasBrushAxisArg(mem, offset) ? BuilderToolBrushAxisArg.toObject(mem, offset + 31) : null,
            hasRotationArg(mem, offset) ? BuilderToolRotationArg.toObject(mem, offset + 32) : null,
            v13
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.boolArg != null) nullBits |= 0x01;
        if (this.floatArg != null) nullBits |= 0x02;
        if (this.intArg != null) nullBits |= 0x04;
        if (this.brushShapeArg != null) nullBits |= 0x08;
        if (this.brushOriginArg != null) nullBits |= 0x10;
        if (this.brushAxisArg != null) nullBits |= 0x20;
        if (this.rotationArg != null) nullBits |= 0x40;
        if (this.id != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        nullBits = 0;
        if (this.stringArg != null) nullBits |= 0x01;
        if (this.blockArg != null) nullBits |= 0x02;
        if (this.maskArg != null) nullBits |= 0x04;
        if (this.optionArg != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 1, nullBits);
        
        mem.set(PacketIO.PROTO_BOOL, offset + 2, this.required);
        mem.set(PacketIO.PROTO_BYTE, offset + 3, (byte) this.argType.getValue());
        if (this.boolArg != null) {
            this.boolArg.serialize(mem, offset + 4);
        } else {
            mem.asSlice(offset + 4, 1).fill((byte) 0); 
        }
        if (this.floatArg != null) {
            this.floatArg.serialize(mem, offset + 5);
        } else {
            mem.asSlice(offset + 5, 12).fill((byte) 0); 
        }
        if (this.intArg != null) {
            this.intArg.serialize(mem, offset + 17);
        } else {
            mem.asSlice(offset + 17, 12).fill((byte) 0); 
        }
        if (this.brushShapeArg != null) {
            this.brushShapeArg.serialize(mem, offset + 29);
        } else {
            mem.asSlice(offset + 29, 1).fill((byte) 0); 
        }
        if (this.brushOriginArg != null) {
            this.brushOriginArg.serialize(mem, offset + 30);
        } else {
            mem.asSlice(offset + 30, 1).fill((byte) 0); 
        }
        if (this.brushAxisArg != null) {
            this.brushAxisArg.serialize(mem, offset + 31);
        } else {
            mem.asSlice(offset + 31, 1).fill((byte) 0); 
        }
        if (this.rotationArg != null) {
            this.rotationArg.serialize(mem, offset + 32);
        } else {
            mem.asSlice(offset + 32, 1).fill((byte) 0); 
        }
        var varOffset = offset + 53;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 33, varOffset - offset - 53);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 33, -1);
        }
        if (this.stringArg != null) {
            mem.set(PacketIO.PROTO_INT, offset + 37, varOffset - offset - 53);
            varOffset += this.stringArg.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 37, -1);
        }
        if (this.blockArg != null) {
            mem.set(PacketIO.PROTO_INT, offset + 41, varOffset - offset - 53);
            varOffset += this.blockArg.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 41, -1);
        }
        if (this.maskArg != null) {
            mem.set(PacketIO.PROTO_INT, offset + 45, varOffset - offset - 53);
            varOffset += this.maskArg.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 45, -1);
        }
        if (this.optionArg != null) {
            mem.set(PacketIO.PROTO_INT, offset + 49, varOffset - offset - 53);
            varOffset += this.optionArg.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 49, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 53;
        if (id != null) size += PacketIO.stringSize(id);
    if (stringArg != null) size += stringArg.computeSize();
    if (blockArg != null) size += blockArg.computeSize();
    if (maskArg != null) size += maskArg.computeSize();
    if (optionArg != null) size += optionArg.computeSize();

        return size;
    }

    public BuilderToolArg clone() {
        BuilderToolArg copy = new BuilderToolArg();
        copy.required = this.required;
        copy.id = this.id;
        copy.argType = this.argType;
        copy.boolArg = this.boolArg != null ? this.boolArg.clone() : null;
        copy.floatArg = this.floatArg != null ? this.floatArg.clone() : null;
        copy.intArg = this.intArg != null ? this.intArg.clone() : null;
        copy.stringArg = this.stringArg != null ? this.stringArg.clone() : null;
        copy.blockArg = this.blockArg != null ? this.blockArg.clone() : null;
        copy.maskArg = this.maskArg != null ? this.maskArg.clone() : null;
        copy.brushShapeArg = this.brushShapeArg != null ? this.brushShapeArg.clone() : null;
        copy.brushOriginArg = this.brushOriginArg != null ? this.brushOriginArg.clone() : null;
        copy.brushAxisArg = this.brushAxisArg != null ? this.brushAxisArg.clone() : null;
        copy.rotationArg = this.rotationArg != null ? this.rotationArg.clone() : null;
        copy.optionArg = this.optionArg != null ? this.optionArg.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolArg other)) return false;
        return this.required == other.required && java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.argType, other.argType) && java.util.Objects.equals(this.boolArg, other.boolArg) && java.util.Objects.equals(this.floatArg, other.floatArg) && java.util.Objects.equals(this.intArg, other.intArg) && java.util.Objects.equals(this.stringArg, other.stringArg) && java.util.Objects.equals(this.blockArg, other.blockArg) && java.util.Objects.equals(this.maskArg, other.maskArg) && java.util.Objects.equals(this.brushShapeArg, other.brushShapeArg) && java.util.Objects.equals(this.brushOriginArg, other.brushOriginArg) && java.util.Objects.equals(this.brushAxisArg, other.brushAxisArg) && java.util.Objects.equals(this.rotationArg, other.rotationArg) && java.util.Objects.equals(this.optionArg, other.optionArg);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(required, id, argType, boolArg, floatArg, intArg, stringArg, blockArg, maskArg, brushShapeArg, brushOriginArg, brushAxisArg, rotationArg, optionArg);
    }

}