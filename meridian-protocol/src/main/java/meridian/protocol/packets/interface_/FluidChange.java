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


public class FluidChange {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 17;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 17;
    public static final int MAX_SIZE = 17;

    public int x;
    public int y;
    public int z;
    public int fluidId;
    public byte fluidLevel;

    public FluidChange() {
    }

    public FluidChange(int x, int y, int z, int fluidId, byte fluidLevel) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.fluidId = fluidId;
        this.fluidLevel = fluidLevel;
    }

    public FluidChange(@Nonnull FluidChange other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
        this.fluidId = other.fluidId;
        this.fluidLevel = other.fluidLevel;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("FluidChange", offset, (int) mem.byteSize());
        long needed = (long) offset + 17;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("FluidChange", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getX(MemorySegment mem) {
        return getX(mem, 0);
    }
    
    public static int getX(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static int getY(MemorySegment mem) {
        return getY(mem, 0);
    }
    
    public static int getY(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 4);
    }
    
    public static int getZ(MemorySegment mem) {
        return getZ(mem, 0);
    }
    
    public static int getZ(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 8);
    }
    
    public static int getFluidId(MemorySegment mem) {
        return getFluidId(mem, 0);
    }
    
    public static int getFluidId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 12);
    }
    
    public static byte getFluidLevel(MemorySegment mem) {
        return getFluidLevel(mem, 0);
    }
    
    public static byte getFluidLevel(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 16);
    }
    
    
    
    
    
    public static FluidChange toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static FluidChange toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one FluidChange and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static FluidChange toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new FluidChange(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4),
            mem.get(PacketIO.PROTO_INT, offset + 8),
            mem.get(PacketIO.PROTO_INT, offset + 12),
            mem.get(PacketIO.PROTO_BYTE, offset + 16)
        );
        if (cursor != null) cursor.position = offset + 17;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.x);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.y);
        mem.set(PacketIO.PROTO_INT, offset + 8, this.z);
        mem.set(PacketIO.PROTO_INT, offset + 12, this.fluidId);
        mem.set(PacketIO.PROTO_BYTE, offset + 16, this.fluidLevel);
        
        
    
       return 17;
    }
    public int computeSize() {
        return 17;
    }

    public FluidChange clone() {
        FluidChange copy = new FluidChange();
        copy.x = this.x;
        copy.y = this.y;
        copy.z = this.z;
        copy.fluidId = this.fluidId;
        copy.fluidLevel = this.fluidLevel;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FluidChange other)) return false;
        return this.x == other.x && this.y == other.y && this.z == other.z && this.fluidId == other.fluidId && this.fluidLevel == other.fluidLevel;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, y, z, fluidId, fluidLevel);
    }

}