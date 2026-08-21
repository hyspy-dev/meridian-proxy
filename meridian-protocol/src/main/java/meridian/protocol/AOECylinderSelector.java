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

public class AOECylinderSelector extends Selector {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 21;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 21;
    public static final int MAX_SIZE = 21;

    public float range;
    public float height;
    @Nullable public Vector3fc offset;

    public AOECylinderSelector() {
    }

    public AOECylinderSelector(float range, float height, @Nullable Vector3fc offset) {
        this.range = range;
        this.height = height;
        this.offset = offset;
    }

    public AOECylinderSelector(@Nonnull AOECylinderSelector other) {
        this.range = other.range;
        this.height = other.height;
        this.offset = other.offset;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AOECylinderSelector", offset, (int) mem.byteSize());
        long needed = (long) offset + 21;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AOECylinderSelector", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getRange(MemorySegment mem) {
        return getRange(mem, 0);
    }
    
    public static float getRange(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Range");
    }
    
    public static float getHeight(MemorySegment mem) {
        return getHeight(mem, 0);
    }
    
    public static float getHeight(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "Height");
    }
    
    @Nullable
    public static Vector3fc getOffset(MemorySegment mem) {
        return getOffset(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getOffset(MemorySegment mem, int offset) {
        return hasOffset(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 9), "Offset"): null;
    }
    
    public static boolean hasOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static AOECylinderSelector toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AOECylinderSelector toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AOECylinderSelector and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AOECylinderSelector toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new AOECylinderSelector(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Range"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "Height"),
            hasOffset(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 9), "Offset") : null
        );
        if (cursor != null) cursor.position = offset + 21;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.offset != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.range, "Range"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.range);
        PacketIO.requireFinite(this.height, "Height"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.height);
        if (this.offset != null) {
            PacketIO.requireFinite(this.offset, "Offset"); PacketIO.writeVector3f(mem, offset + 9, this.offset);
        } else {
            mem.asSlice(offset + 9, 12).fill((byte) 0); 
        }
        
        
    
       return 21;
    }
    @Override
    public int computeSize() {
        return 21;
    }

    public AOECylinderSelector clone() {
        AOECylinderSelector copy = new AOECylinderSelector();
        copy.range = this.range;
        copy.height = this.height;
        copy.offset = this.offset;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AOECylinderSelector other)) return false;
        return this.range == other.range && this.height == other.height && java.util.Objects.equals(this.offset, other.offset);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(range, height, offset);
    }

}