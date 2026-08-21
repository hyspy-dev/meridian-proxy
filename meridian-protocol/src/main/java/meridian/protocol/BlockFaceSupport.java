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


public class BlockFaceSupport {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 65536019;

    @Nullable public String faceType;
    @Nullable public Vector3i[] filler;

    public BlockFaceSupport() {
    }

    public BlockFaceSupport(@Nullable String faceType, @Nullable Vector3i[] filler) {
        this.faceType = faceType;
        this.filler = filler;
    }

    public BlockFaceSupport(@Nonnull BlockFaceSupport other) {
        this.faceType = other.faceType;
        this.filler = other.filler;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BlockFaceSupport", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockFaceSupport", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getFaceType(MemorySegment mem) {
        return getFaceType(mem, 0);
    }
    
    @Nullable
    public static String getFaceType(MemorySegment mem, int offset) {
        return hasFaceType(mem, offset) ? PacketIO.readVarString("FaceType", mem, offset + getValidatedOffset(mem, offset, 1, 9, "FaceType"), 4096000): null;
    }
    
    @Nullable
    public static Vector3i[] getFiller(MemorySegment mem) {
        return getFiller(mem, 0);
    }
    
    @Nullable
    public static Vector3i[] getFiller(MemorySegment mem, int offset) {
        if (!hasFiller(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 5, 9, "Filler");
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
    
    public static boolean hasFiller(MemorySegment mem, int offset) {
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
    
    public static BlockFaceSupport toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BlockFaceSupport toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BlockFaceSupport and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BlockFaceSupport toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        String v0 = null;
        if (hasFaceType(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "FaceType");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("FaceType", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 1, -1, "FaceType");
        }
        
        Vector3i[] v1 = null;
        if (hasFiller(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Filler");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Filler");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Filler", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 12 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Filler", (int) java.lang.Math.min(off + lenOffset + (long) len * 12, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new Vector3i[len];
            for (var i = 0; i < len; i++) {
                v1[i] = Vector3i.toObject(mem, off + i * 12);
            }
            varPos = off + len * 12 - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "Filler");
        }
        var result = new BlockFaceSupport(
            v0,
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.faceType != null) nullBits |= 0x01;
        if (this.filler != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 9;
        if (this.faceType != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 9);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.faceType, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.filler != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 9);
            if (filler.length > 4096000) throw ProtocolException.arrayTooLong("Filler", filler.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.filler.length);
            
            var fillerValueOffset = 0;
            for (var i = 0; i < this.filler.length; i++) {
                fillerValueOffset += this.filler[i].serialize(mem, varOffset + fillerValueOffset);
            }
            varOffset += fillerValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (faceType != null) size += PacketIO.stringSize(faceType);
    if (filler != null) size += VarInt.size(filler.length) + filler.length * 12;

        return size;
    }

    public BlockFaceSupport clone() {
        BlockFaceSupport copy = new BlockFaceSupport();
        copy.faceType = this.faceType;
        copy.filler = this.filler != null ? java.util.Arrays.stream(this.filler).map(e -> e.clone()).toArray(Vector3i[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BlockFaceSupport other)) return false;
        return java.util.Objects.equals(this.faceType, other.faceType) && java.util.Arrays.equals(this.filler, other.filler);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(faceType);
        result = 31 * result + java.util.Arrays.hashCode(filler);
        return result;
    }

}