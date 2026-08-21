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


public class FaceTagConnectedBlockRule extends ConnectedBlockRule {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 14;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 14;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public Vector3i positionOffset = new Vector3i();
    @Nullable public ConnectedBlockFaceTags faceTags;
    @Nonnull public ConnectedBlockMatchType matchType = ConnectedBlockMatchType.Any;

    public FaceTagConnectedBlockRule() {
    }

    public FaceTagConnectedBlockRule(@Nonnull Vector3i positionOffset, @Nullable ConnectedBlockFaceTags faceTags, @Nonnull ConnectedBlockMatchType matchType) {
        this.positionOffset = positionOffset;
        this.faceTags = faceTags;
        this.matchType = matchType;
    }

    public FaceTagConnectedBlockRule(@Nonnull FaceTagConnectedBlockRule other) {
        this.positionOffset = other.positionOffset;
        this.faceTags = other.faceTags;
        this.matchType = other.matchType;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("FaceTagConnectedBlockRule", offset, (int) mem.byteSize());
        long needed = (long) offset + 14;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("FaceTagConnectedBlockRule", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static Vector3i getPositionOffset(MemorySegment mem) {
        return getPositionOffset(mem, 0);
    }
    
    public static Vector3i getPositionOffset(MemorySegment mem, int offset) {
        return Vector3i.toObject(mem, offset + 1);
    }
    
    @Nullable
    public static ConnectedBlockFaceTags getFaceTags(MemorySegment mem) {
        return getFaceTags(mem, 0);
    }
    
    @Nullable
    public static ConnectedBlockFaceTags getFaceTags(MemorySegment mem, int offset) {
        return hasFaceTags(mem, offset) ? ConnectedBlockFaceTags.toObject(mem, offset + 14): null;
    }
    
    public static ConnectedBlockMatchType getMatchType(MemorySegment mem) {
        return getMatchType(mem, 0);
    }
    
    public static ConnectedBlockMatchType getMatchType(MemorySegment mem, int offset) {
        return ConnectedBlockMatchType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 13));
    }
    
    public static boolean hasFaceTags(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static FaceTagConnectedBlockRule toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static FaceTagConnectedBlockRule toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one FaceTagConnectedBlockRule and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static FaceTagConnectedBlockRule toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 14;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ConnectedBlockFaceTags v1 = null;
        if (hasFaceTags(mem, offset)) {
            v1 = ConnectedBlockFaceTags.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new FaceTagConnectedBlockRule(
            Vector3i.toObject(mem, offset + 1),
            v1,
            ConnectedBlockMatchType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 13))
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.faceTags != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        this.positionOffset.serialize(mem, offset + 1);
        mem.set(PacketIO.PROTO_BYTE, offset + 13, (byte) this.matchType.getValue());
        var varOffset = offset + 14;
        if (this.faceTags != null) {
            
            varOffset += this.faceTags.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 14;
        if (faceTags != null) size += faceTags.computeSize();

        return size;
    }

    public FaceTagConnectedBlockRule clone() {
        FaceTagConnectedBlockRule copy = new FaceTagConnectedBlockRule();
        copy.positionOffset = this.positionOffset.clone();
        copy.faceTags = this.faceTags != null ? this.faceTags.clone() : null;
        copy.matchType = this.matchType;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FaceTagConnectedBlockRule other)) return false;
        return java.util.Objects.equals(this.positionOffset, other.positionOffset) && java.util.Objects.equals(this.faceTags, other.faceTags) && java.util.Objects.equals(this.matchType, other.matchType);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(positionOffset, faceTags, matchType);
    }

}