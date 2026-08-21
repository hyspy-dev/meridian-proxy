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


public class RailConfig {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 98304006;

    @Nullable public RailPoint[] points;

    public RailConfig() {
    }

    public RailConfig(@Nullable RailPoint[] points) {
        this.points = points;
    }

    public RailConfig(@Nonnull RailConfig other) {
        this.points = other.points;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("RailConfig", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("RailConfig", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static RailPoint[] getPoints(MemorySegment mem) {
        return getPoints(mem, 0);
    }
    
    @Nullable
    public static RailPoint[] getPoints(MemorySegment mem, int offset) {
        if (!hasPoints(mem, offset)) return null;
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Points");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Points", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 24 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Points", (int) java.lang.Math.min(off + lenOffset + (long) len * 24, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new RailPoint[len];
        for (var i = 0; i < len; i++) {
            data[i] = RailPoint.toObject(mem, off + i * 24);
        }
        return data;
    }
    
    public static boolean hasPoints(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static RailConfig toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static RailConfig toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one RailConfig and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static RailConfig toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        RailPoint[] v0 = null;
        if (hasPoints(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Points");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Points", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 24 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Points", (int) java.lang.Math.min(off + lenOffset + (long) len * 24, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new RailPoint[len];
            for (var i = 0; i < len; i++) {
                v0[i] = RailPoint.toObject(mem, off + i * 24);
            }
            varPos = off + len * 24 - varBase;
        }
        var result = new RailConfig(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.points != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.points != null) {
            
            if (points.length > 4096000) throw ProtocolException.arrayTooLong("Points", points.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.points.length);
            
            var pointsValueOffset = 0;
            for (var i = 0; i < this.points.length; i++) {
                pointsValueOffset += this.points[i].serialize(mem, varOffset + pointsValueOffset);
            }
            varOffset += pointsValueOffset;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (points != null) size += VarInt.size(points.length) + points.length * 24;

        return size;
    }

    public RailConfig clone() {
        RailConfig copy = new RailConfig();
        copy.points = this.points != null ? java.util.Arrays.stream(this.points).map(e -> e.clone()).toArray(RailPoint[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RailConfig other)) return false;
        return java.util.Arrays.equals(this.points, other.points);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(points);
        return result;
    }

}