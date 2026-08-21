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


public class SetBlockCmd {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 9;

    public short index;
    public int blockId;
    public short filler;
    public byte rotation;

    public SetBlockCmd() {
    }

    public SetBlockCmd(short index, int blockId, short filler, byte rotation) {
        this.index = index;
        this.blockId = blockId;
        this.filler = filler;
        this.rotation = rotation;
    }

    public SetBlockCmd(@Nonnull SetBlockCmd other) {
        this.index = other.index;
        this.blockId = other.blockId;
        this.filler = other.filler;
        this.rotation = other.rotation;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SetBlockCmd", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SetBlockCmd", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static short getIndex(MemorySegment mem) {
        return getIndex(mem, 0);
    }
    
    public static short getIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_SHORT, offset + 0);
    }
    
    public static int getBlockId(MemorySegment mem) {
        return getBlockId(mem, 0);
    }
    
    public static int getBlockId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 2);
    }
    
    public static short getFiller(MemorySegment mem) {
        return getFiller(mem, 0);
    }
    
    public static short getFiller(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_SHORT, offset + 6);
    }
    
    public static byte getRotation(MemorySegment mem) {
        return getRotation(mem, 0);
    }
    
    public static byte getRotation(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 8);
    }
    
    
    
    
    
    public static SetBlockCmd toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SetBlockCmd toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SetBlockCmd and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SetBlockCmd toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new SetBlockCmd(
            mem.get(PacketIO.PROTO_SHORT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 2),
            mem.get(PacketIO.PROTO_SHORT, offset + 6),
            mem.get(PacketIO.PROTO_BYTE, offset + 8)
        );
        if (cursor != null) cursor.position = offset + 9;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_SHORT, offset + 0, this.index);
        mem.set(PacketIO.PROTO_INT, offset + 2, this.blockId);
        mem.set(PacketIO.PROTO_SHORT, offset + 6, this.filler);
        mem.set(PacketIO.PROTO_BYTE, offset + 8, this.rotation);
        
        
    
       return 9;
    }
    public int computeSize() {
        return 9;
    }

    public SetBlockCmd clone() {
        SetBlockCmd copy = new SetBlockCmd();
        copy.index = this.index;
        copy.blockId = this.blockId;
        copy.filler = this.filler;
        copy.rotation = this.rotation;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SetBlockCmd other)) return false;
        return this.index == other.index && this.blockId == other.blockId && this.filler == other.filler && this.rotation == other.rotation;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(index, blockId, filler, rotation);
    }

}