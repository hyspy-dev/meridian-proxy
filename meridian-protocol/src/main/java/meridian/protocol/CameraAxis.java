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


public class CameraAxis {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 4096014;

    @Nullable public Rangef angleRange;
    @Nullable public CameraNode[] targetNodes;

    public CameraAxis() {
    }

    public CameraAxis(@Nullable Rangef angleRange, @Nullable CameraNode[] targetNodes) {
        this.angleRange = angleRange;
        this.targetNodes = targetNodes;
    }

    public CameraAxis(@Nonnull CameraAxis other) {
        this.angleRange = other.angleRange;
        this.targetNodes = other.targetNodes;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CameraAxis", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CameraAxis", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static Rangef getAngleRange(MemorySegment mem) {
        return getAngleRange(mem, 0);
    }
    
    @Nullable
    public static Rangef getAngleRange(MemorySegment mem, int offset) {
        return hasAngleRange(mem, offset) ? Rangef.toObject(mem, offset + 1): null;
    }
    
    @Nullable
    public static CameraNode[] getTargetNodes(MemorySegment mem) {
        return getTargetNodes(mem, 0);
    }
    
    @Nullable
    public static CameraNode[] getTargetNodes(MemorySegment mem, int offset) {
        if (!hasTargetNodes(mem, offset)) return null;
        var off = offset + 9;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("TargetNodes");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("TargetNodes", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("TargetNodes", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new CameraNode[len];
        for (var i = 0; i < len; i++) {
            data[i] = CameraNode.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
        }
        return data;
    }
    
    public static boolean hasAngleRange(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasTargetNodes(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    
    
    public static CameraAxis toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CameraAxis toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CameraAxis and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CameraAxis toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        CameraNode[] v1 = null;
        if (hasTargetNodes(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("TargetNodes");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("TargetNodes", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("TargetNodes", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new CameraNode[len];
            for (var i = 0; i < len; i++) {
                v1[i] = CameraNode.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
            }
            varPos = off + len - varBase;
        }
        var result = new CameraAxis(
            hasAngleRange(mem, offset) ? Rangef.toObject(mem, offset + 1) : null,
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.angleRange != null) nullBits |= 0x01;
        if (this.targetNodes != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.angleRange != null) {
            this.angleRange.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 8).fill((byte) 0); 
        }
        var varOffset = offset + 9;
        if (this.targetNodes != null) {
            
            if (targetNodes.length > 4096000) throw ProtocolException.arrayTooLong("TargetNodes", targetNodes.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.targetNodes.length);
            
            for (var i = 0; i < this.targetNodes.length; i++) {
                mem.set(PacketIO.PROTO_BYTE, varOffset + i * 1, (byte) this.targetNodes[i].getValue());
            }
            varOffset += this.targetNodes.length * 1;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (targetNodes != null) size += VarInt.size(targetNodes.length) + targetNodes.length * 1;

        return size;
    }

    public CameraAxis clone() {
        CameraAxis copy = new CameraAxis();
        copy.angleRange = this.angleRange != null ? this.angleRange.clone() : null;
        copy.targetNodes = this.targetNodes != null ? java.util.Arrays.copyOf(this.targetNodes, this.targetNodes.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CameraAxis other)) return false;
        return java.util.Objects.equals(this.angleRange, other.angleRange) && java.util.Arrays.equals(this.targetNodes, other.targetNodes);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(angleRange);
        result = 31 * result + java.util.Arrays.hashCode(targetNodes);
        return result;
    }

}