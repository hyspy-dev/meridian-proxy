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


public class Hitbox {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 24;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 24;
    public static final int MAX_SIZE = 24;

    public float minX;
    public float minY;
    public float minZ;
    public float maxX;
    public float maxY;
    public float maxZ;

    public Hitbox() {
    }

    public Hitbox(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        this.minX = minX;
        this.minY = minY;
        this.minZ = minZ;
        this.maxX = maxX;
        this.maxY = maxY;
        this.maxZ = maxZ;
    }

    public Hitbox(@Nonnull Hitbox other) {
        this.minX = other.minX;
        this.minY = other.minY;
        this.minZ = other.minZ;
        this.maxX = other.maxX;
        this.maxY = other.maxY;
        this.maxZ = other.maxZ;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Hitbox", offset, (int) mem.byteSize());
        long needed = (long) offset + 24;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Hitbox", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getMinX(MemorySegment mem) {
        return getMinX(mem, 0);
    }
    
    public static float getMinX(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "MinX");
    }
    
    public static float getMinY(MemorySegment mem) {
        return getMinY(mem, 0);
    }
    
    public static float getMinY(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "MinY");
    }
    
    public static float getMinZ(MemorySegment mem) {
        return getMinZ(mem, 0);
    }
    
    public static float getMinZ(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "MinZ");
    }
    
    public static float getMaxX(MemorySegment mem) {
        return getMaxX(mem, 0);
    }
    
    public static float getMaxX(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "MaxX");
    }
    
    public static float getMaxY(MemorySegment mem) {
        return getMaxY(mem, 0);
    }
    
    public static float getMaxY(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "MaxY");
    }
    
    public static float getMaxZ(MemorySegment mem) {
        return getMaxZ(mem, 0);
    }
    
    public static float getMaxZ(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "MaxZ");
    }
    
    
    
    
    
    public static Hitbox toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Hitbox toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Hitbox and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Hitbox toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new Hitbox(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "MinX"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "MinY"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "MinZ"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "MaxX"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "MaxY"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "MaxZ")
        );
        if (cursor != null) cursor.position = offset + 24;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.minX, "MinX"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.minX);
        PacketIO.requireFinite(this.minY, "MinY"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.minY);
        PacketIO.requireFinite(this.minZ, "MinZ"); mem.set(PacketIO.PROTO_FLOAT, offset + 8, this.minZ);
        PacketIO.requireFinite(this.maxX, "MaxX"); mem.set(PacketIO.PROTO_FLOAT, offset + 12, this.maxX);
        PacketIO.requireFinite(this.maxY, "MaxY"); mem.set(PacketIO.PROTO_FLOAT, offset + 16, this.maxY);
        PacketIO.requireFinite(this.maxZ, "MaxZ"); mem.set(PacketIO.PROTO_FLOAT, offset + 20, this.maxZ);
        
        
    
       return 24;
    }
    public int computeSize() {
        return 24;
    }

    public Hitbox clone() {
        Hitbox copy = new Hitbox();
        copy.minX = this.minX;
        copy.minY = this.minY;
        copy.minZ = this.minZ;
        copy.maxX = this.maxX;
        copy.maxY = this.maxY;
        copy.maxZ = this.maxZ;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Hitbox other)) return false;
        return this.minX == other.minX && this.minY == other.minY && this.minZ == other.minZ && this.maxX == other.maxX && this.maxY == other.maxY && this.maxZ == other.maxZ;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(minX, minY, minZ, maxX, maxY, maxZ);
    }

}