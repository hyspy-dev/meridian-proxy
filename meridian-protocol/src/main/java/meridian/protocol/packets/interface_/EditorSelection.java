// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class EditorSelection {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 24;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 24;
    public static final int MAX_SIZE = 24;

    public int minX;
    public int minY;
    public int minZ;
    public int maxX;
    public int maxY;
    public int maxZ;

    public EditorSelection() {
    }

    public EditorSelection(int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
        this.minX = minX;
        this.minY = minY;
        this.minZ = minZ;
        this.maxX = maxX;
        this.maxY = maxY;
        this.maxZ = maxZ;
    }

    public EditorSelection(@Nonnull EditorSelection other) {
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
        if (offset < 0) throw ProtocolException.invalidOffset("EditorSelection", offset, (int) mem.byteSize());
        long needed = (long) offset + 24;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("EditorSelection", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getMinX(MemorySegment mem) {
        return getMinX(mem, 0);
    }
    
    public static int getMinX(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static int getMinY(MemorySegment mem) {
        return getMinY(mem, 0);
    }
    
    public static int getMinY(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 4);
    }
    
    public static int getMinZ(MemorySegment mem) {
        return getMinZ(mem, 0);
    }
    
    public static int getMinZ(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 8);
    }
    
    public static int getMaxX(MemorySegment mem) {
        return getMaxX(mem, 0);
    }
    
    public static int getMaxX(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 12);
    }
    
    public static int getMaxY(MemorySegment mem) {
        return getMaxY(mem, 0);
    }
    
    public static int getMaxY(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 16);
    }
    
    public static int getMaxZ(MemorySegment mem) {
        return getMaxZ(mem, 0);
    }
    
    public static int getMaxZ(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 20);
    }
    
    
    
    
    
    public static EditorSelection toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static EditorSelection toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one EditorSelection and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static EditorSelection toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new EditorSelection(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4),
            mem.get(PacketIO.PROTO_INT, offset + 8),
            mem.get(PacketIO.PROTO_INT, offset + 12),
            mem.get(PacketIO.PROTO_INT, offset + 16),
            mem.get(PacketIO.PROTO_INT, offset + 20)
        );
        if (cursor != null) cursor.position = offset + 24;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.minX);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.minY);
        mem.set(PacketIO.PROTO_INT, offset + 8, this.minZ);
        mem.set(PacketIO.PROTO_INT, offset + 12, this.maxX);
        mem.set(PacketIO.PROTO_INT, offset + 16, this.maxY);
        mem.set(PacketIO.PROTO_INT, offset + 20, this.maxZ);
        
        
    
       return 24;
    }
    public int computeSize() {
        return 24;
    }

    public EditorSelection clone() {
        EditorSelection copy = new EditorSelection();
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
        if (!(obj instanceof EditorSelection other)) return false;
        return this.minX == other.minX && this.minY == other.minY && this.minZ == other.minZ && this.maxX == other.maxX && this.maxY == other.maxY && this.maxZ == other.maxZ;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(minX, minY, minZ, maxX, maxY, maxZ);
    }

}