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


public class RequiredBlockFaceSupport {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 16;
    public static final int VARIABLE_FIELD_COUNT = 4;
    public static final int VARIABLE_BLOCK_START = 32;
    public static final int MAX_SIZE = 98304052;

    @Nullable public String faceType;
    @Nullable public String selfFaceType;
    @Nullable public String blockSetId;
    public int blockTypeId;
    public int tagIndex;
    public int fluidId;
    @Nonnull public SupportMatch support = SupportMatch.Ignored;
    @Nonnull public SupportMatch matchSelf = SupportMatch.Ignored;
    public boolean allowSupportPropagation;
    public boolean rotate;
    @Nullable public Vector3i[] filler;

    public RequiredBlockFaceSupport() {
    }

    public RequiredBlockFaceSupport(@Nullable String faceType, @Nullable String selfFaceType, @Nullable String blockSetId, int blockTypeId, int tagIndex, int fluidId, @Nonnull SupportMatch support, @Nonnull SupportMatch matchSelf, boolean allowSupportPropagation, boolean rotate, @Nullable Vector3i[] filler) {
        this.faceType = faceType;
        this.selfFaceType = selfFaceType;
        this.blockSetId = blockSetId;
        this.blockTypeId = blockTypeId;
        this.tagIndex = tagIndex;
        this.fluidId = fluidId;
        this.support = support;
        this.matchSelf = matchSelf;
        this.allowSupportPropagation = allowSupportPropagation;
        this.rotate = rotate;
        this.filler = filler;
    }

    public RequiredBlockFaceSupport(@Nonnull RequiredBlockFaceSupport other) {
        this.faceType = other.faceType;
        this.selfFaceType = other.selfFaceType;
        this.blockSetId = other.blockSetId;
        this.blockTypeId = other.blockTypeId;
        this.tagIndex = other.tagIndex;
        this.fluidId = other.fluidId;
        this.support = other.support;
        this.matchSelf = other.matchSelf;
        this.allowSupportPropagation = other.allowSupportPropagation;
        this.rotate = other.rotate;
        this.filler = other.filler;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("RequiredBlockFaceSupport", offset, (int) mem.byteSize());
        long needed = (long) offset + 32;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("RequiredBlockFaceSupport", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getFaceType(MemorySegment mem) {
        return getFaceType(mem, 0);
    }
    
    @Nullable
    public static String getFaceType(MemorySegment mem, int offset) {
        return hasFaceType(mem, offset) ? PacketIO.readVarString("FaceType", mem, offset + getValidatedOffset(mem, offset, 16, 32, "FaceType"), 4096000): null;
    }
    
    @Nullable
    public static String getSelfFaceType(MemorySegment mem) {
        return getSelfFaceType(mem, 0);
    }
    
    @Nullable
    public static String getSelfFaceType(MemorySegment mem, int offset) {
        return hasSelfFaceType(mem, offset) ? PacketIO.readVarString("SelfFaceType", mem, offset + getValidatedOffset(mem, offset, 20, 32, "SelfFaceType"), 4096000): null;
    }
    
    @Nullable
    public static String getBlockSetId(MemorySegment mem) {
        return getBlockSetId(mem, 0);
    }
    
    @Nullable
    public static String getBlockSetId(MemorySegment mem, int offset) {
        return hasBlockSetId(mem, offset) ? PacketIO.readVarString("BlockSetId", mem, offset + getValidatedOffset(mem, offset, 24, 32, "BlockSetId"), 4096000): null;
    }
    
    public static int getBlockTypeId(MemorySegment mem) {
        return getBlockTypeId(mem, 0);
    }
    
    public static int getBlockTypeId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getTagIndex(MemorySegment mem) {
        return getTagIndex(mem, 0);
    }
    
    public static int getTagIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static int getFluidId(MemorySegment mem) {
        return getFluidId(mem, 0);
    }
    
    public static int getFluidId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 9);
    }
    
    public static SupportMatch getSupport(MemorySegment mem) {
        return getSupport(mem, 0);
    }
    
    public static SupportMatch getSupport(MemorySegment mem, int offset) {
        return SupportMatch.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 13));
    }
    
    public static SupportMatch getMatchSelf(MemorySegment mem) {
        return getMatchSelf(mem, 0);
    }
    
    public static SupportMatch getMatchSelf(MemorySegment mem, int offset) {
        return SupportMatch.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 14));
    }
    
    public static boolean getAllowSupportPropagation(MemorySegment mem) {
        return getAllowSupportPropagation(mem, 0);
    }
    
    public static boolean getAllowSupportPropagation(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 15) & 0x01) != 0;
    }
    
    public static boolean getRotate(MemorySegment mem) {
        return getRotate(mem, 0);
    }
    
    public static boolean getRotate(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 15) & 0x02) != 0;
    }
    
    @Nullable
    public static Vector3i[] getFiller(MemorySegment mem) {
        return getFiller(mem, 0);
    }
    
    @Nullable
    public static Vector3i[] getFiller(MemorySegment mem, int offset) {
        if (!hasFiller(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 28, 32, "Filler");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Filler");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Filler", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 12 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Filler", (int) java.lang.Math.min(off + lenOffset + (long) len * 12, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new Vector3i[len];
        for (var i = 0; i < len; i++) {
            data[i] = Vector3i.toObject(mem, off + i * 12);
        }
        return data;
    }
    
    public static boolean hasFaceType(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasSelfFaceType(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasBlockSetId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasFiller(MemorySegment mem, int offset) {
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
    
    public static RequiredBlockFaceSupport toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static RequiredBlockFaceSupport toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one RequiredBlockFaceSupport and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static RequiredBlockFaceSupport toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 32;
        var varPos = 0;
        String v0 = null;
        if (hasFaceType(mem, offset)) {
            requireSlot(mem, offset + 16, varPos, "FaceType");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("FaceType", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 16, -1, "FaceType");
        }
        
        String v1 = null;
        if (hasSelfFaceType(mem, offset)) {
            requireSlot(mem, offset + 20, varPos, "SelfFaceType");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("SelfFaceType", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 20, -1, "SelfFaceType");
        }
        
        String v2 = null;
        if (hasBlockSetId(mem, offset)) {
            requireSlot(mem, offset + 24, varPos, "BlockSetId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("BlockSetId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 24, -1, "BlockSetId");
        }
        
        Vector3i[] v10 = null;
        if (hasFiller(mem, offset)) {
            requireSlot(mem, offset + 28, varPos, "Filler");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Filler");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Filler", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 12 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Filler", (int) java.lang.Math.min(off + lenOffset + (long) len * 12, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v10 = new Vector3i[len];
            for (var i = 0; i < len; i++) {
                v10[i] = Vector3i.toObject(mem, off + i * 12);
            }
            varPos = off + len * 12 - varBase;
        } else {
            requireSlot(mem, offset + 28, -1, "Filler");
        }
        var result = new RequiredBlockFaceSupport(
            v0,
            v1,
            v2,
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            mem.get(PacketIO.PROTO_INT, offset + 9),
            SupportMatch.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 13)),
            SupportMatch.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 14)),
            (mem.get(PacketIO.PROTO_BYTE, offset + 15) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 15) & 0x02) != 0,
            v10
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.faceType != null) nullBits |= 0x01;
        if (this.selfFaceType != null) nullBits |= 0x02;
        if (this.blockSetId != null) nullBits |= 0x04;
        if (this.filler != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.blockTypeId);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.tagIndex);
        mem.set(PacketIO.PROTO_INT, offset + 9, this.fluidId);
        mem.set(PacketIO.PROTO_BYTE, offset + 13, (byte) this.support.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 14, (byte) this.matchSelf.getValue());
        byte boolBits0_0 = 0;
        if (this.allowSupportPropagation) boolBits0_0 |= 0x01;
        if (this.rotate) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 15 + 0, boolBits0_0);
        var varOffset = offset + 32;
        if (this.faceType != null) {
            mem.set(PacketIO.PROTO_INT, offset + 16, varOffset - offset - 32);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.faceType, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 16, -1);
        }
        if (this.selfFaceType != null) {
            mem.set(PacketIO.PROTO_INT, offset + 20, varOffset - offset - 32);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.selfFaceType, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 20, -1);
        }
        if (this.blockSetId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 24, varOffset - offset - 32);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.blockSetId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 24, -1);
        }
        if (this.filler != null) {
            mem.set(PacketIO.PROTO_INT, offset + 28, varOffset - offset - 32);
            if (filler.length > 4096000) throw ProtocolException.arrayTooLong("Filler", filler.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.filler.length);
            
            var fillerValueOffset = 0;
            for (var i = 0; i < this.filler.length; i++) {
                fillerValueOffset += this.filler[i].serialize(mem, varOffset + fillerValueOffset);
            }
            varOffset += fillerValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 28, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 32;
        if (faceType != null) size += PacketIO.stringSize(faceType);
    if (selfFaceType != null) size += PacketIO.stringSize(selfFaceType);
    if (blockSetId != null) size += PacketIO.stringSize(blockSetId);
    if (filler != null) size += VarInt.size(filler.length) + filler.length * 12;

        return size;
    }

    public RequiredBlockFaceSupport clone() {
        RequiredBlockFaceSupport copy = new RequiredBlockFaceSupport();
        copy.faceType = this.faceType;
        copy.selfFaceType = this.selfFaceType;
        copy.blockSetId = this.blockSetId;
        copy.blockTypeId = this.blockTypeId;
        copy.tagIndex = this.tagIndex;
        copy.fluidId = this.fluidId;
        copy.support = this.support;
        copy.matchSelf = this.matchSelf;
        copy.allowSupportPropagation = this.allowSupportPropagation;
        copy.rotate = this.rotate;
        copy.filler = this.filler != null ? java.util.Arrays.stream(this.filler).map(e -> e.clone()).toArray(Vector3i[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RequiredBlockFaceSupport other)) return false;
        return java.util.Objects.equals(this.faceType, other.faceType) && java.util.Objects.equals(this.selfFaceType, other.selfFaceType) && java.util.Objects.equals(this.blockSetId, other.blockSetId) && this.blockTypeId == other.blockTypeId && this.tagIndex == other.tagIndex && this.fluidId == other.fluidId && java.util.Objects.equals(this.support, other.support) && java.util.Objects.equals(this.matchSelf, other.matchSelf) && this.allowSupportPropagation == other.allowSupportPropagation && this.rotate == other.rotate && java.util.Arrays.equals(this.filler, other.filler);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(faceType);
        result = 31 * result + java.util.Objects.hashCode(selfFaceType);
        result = 31 * result + java.util.Objects.hashCode(blockSetId);
        result = 31 * result + Integer.hashCode(blockTypeId);
        result = 31 * result + Integer.hashCode(tagIndex);
        result = 31 * result + Integer.hashCode(fluidId);
        result = 31 * result + java.util.Objects.hashCode(support);
        result = 31 * result + java.util.Objects.hashCode(matchSelf);
        result = 31 * result + Boolean.hashCode(allowSupportPropagation);
        result = 31 * result + Boolean.hashCode(rotate);
        result = 31 * result + java.util.Arrays.hashCode(filler);
        return result;
    }

}