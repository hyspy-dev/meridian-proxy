// Auto-generated - do not edit
package meridian.protocol.packets.world;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class SetFluidCmd {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 7;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 7;
    public static final int MAX_SIZE = 7;

    public short index;
    public int fluidId;
    public byte fluidLevel;

    public SetFluidCmd() {
    }

    public SetFluidCmd(short index, int fluidId, byte fluidLevel) {
        this.index = index;
        this.fluidId = fluidId;
        this.fluidLevel = fluidLevel;
    }

    public SetFluidCmd(@Nonnull SetFluidCmd other) {
        this.index = other.index;
        this.fluidId = other.fluidId;
        this.fluidLevel = other.fluidLevel;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SetFluidCmd", offset, (int) mem.byteSize());
        long needed = (long) offset + 7;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SetFluidCmd", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static short getIndex(MemorySegment mem) {
        return getIndex(mem, 0);
    }
    
    public static short getIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_SHORT, offset + 0);
    }
    
    public static int getFluidId(MemorySegment mem) {
        return getFluidId(mem, 0);
    }
    
    public static int getFluidId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 2);
    }
    
    public static byte getFluidLevel(MemorySegment mem) {
        return getFluidLevel(mem, 0);
    }
    
    public static byte getFluidLevel(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 6);
    }
    
    
    
    
    
    public static SetFluidCmd toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SetFluidCmd toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SetFluidCmd and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SetFluidCmd toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new SetFluidCmd(
            mem.get(PacketIO.PROTO_SHORT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 2),
            mem.get(PacketIO.PROTO_BYTE, offset + 6)
        );
        if (cursor != null) cursor.position = offset + 7;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_SHORT, offset + 0, this.index);
        mem.set(PacketIO.PROTO_INT, offset + 2, this.fluidId);
        mem.set(PacketIO.PROTO_BYTE, offset + 6, this.fluidLevel);
        
        
    
       return 7;
    }
    public int computeSize() {
        return 7;
    }

    public SetFluidCmd clone() {
        SetFluidCmd copy = new SetFluidCmd();
        copy.index = this.index;
        copy.fluidId = this.fluidId;
        copy.fluidLevel = this.fluidLevel;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SetFluidCmd other)) return false;
        return this.index == other.index && this.fluidId == other.fluidId && this.fluidLevel == other.fluidLevel;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(index, fluidId, fluidLevel);
    }

}