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


public class Vector3d {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 24;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 24;
    public static final int MAX_SIZE = 24;

    public double x;
    public double y;
    public double z;

    public Vector3d() {
    }

    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3d(@Nonnull Vector3d other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Vector3d", offset, (int) mem.byteSize());
        long needed = (long) offset + 24;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Vector3d", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static double getX(MemorySegment mem) {
        return getX(mem, 0);
    }
    
    public static double getX(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 0), "X");
    }
    
    public static double getY(MemorySegment mem) {
        return getY(mem, 0);
    }
    
    public static double getY(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 8), "Y");
    }
    
    public static double getZ(MemorySegment mem) {
        return getZ(mem, 0);
    }
    
    public static double getZ(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 16), "Z");
    }
    
    
    
    
    
    public static Vector3d toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Vector3d toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Vector3d and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Vector3d toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new Vector3d(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 0), "X"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 8), "Y"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 16), "Z")
        );
        if (cursor != null) cursor.position = offset + 24;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.x, "X"); mem.set(PacketIO.PROTO_DOUBLE, offset + 0, this.x);
        PacketIO.requireFinite(this.y, "Y"); mem.set(PacketIO.PROTO_DOUBLE, offset + 8, this.y);
        PacketIO.requireFinite(this.z, "Z"); mem.set(PacketIO.PROTO_DOUBLE, offset + 16, this.z);
        
        
    
       return 24;
    }
    public int computeSize() {
        return 24;
    }

    public Vector3d clone() {
        Vector3d copy = new Vector3d();
        copy.x = this.x;
        copy.y = this.y;
        copy.z = this.z;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vector3d other)) return false;
        return this.x == other.x && this.y == other.y && this.z == other.z;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, y, z);
    }

}