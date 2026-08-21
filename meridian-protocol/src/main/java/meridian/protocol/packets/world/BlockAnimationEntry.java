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


public class BlockAnimationEntry {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 17;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 17;
    public static final int MAX_SIZE = 17;

    public int index;
    public int expectedBlockId;
    public float speed;
    @Nullable public Float phase;

    public BlockAnimationEntry() {
    }

    public BlockAnimationEntry(int index, int expectedBlockId, float speed, @Nullable Float phase) {
        this.index = index;
        this.expectedBlockId = expectedBlockId;
        this.speed = speed;
        this.phase = phase;
    }

    public BlockAnimationEntry(@Nonnull BlockAnimationEntry other) {
        this.index = other.index;
        this.expectedBlockId = other.expectedBlockId;
        this.speed = other.speed;
        this.phase = other.phase;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BlockAnimationEntry", offset, (int) mem.byteSize());
        long needed = (long) offset + 17;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockAnimationEntry", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getIndex(MemorySegment mem) {
        return getIndex(mem, 0);
    }
    
    public static int getIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getExpectedBlockId(MemorySegment mem) {
        return getExpectedBlockId(mem, 0);
    }
    
    public static int getExpectedBlockId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static float getSpeed(MemorySegment mem) {
        return getSpeed(mem, 0);
    }
    
    public static float getSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "Speed");
    }
    
    @Nullable
    public static Float getPhase(MemorySegment mem) {
        return getPhase(mem, 0);
    }
    
    @Nullable
    public static Float getPhase(MemorySegment mem, int offset) {
        return hasPhase(mem, offset) ? PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 13), "Phase"): null;
    }
    
    public static boolean hasPhase(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static BlockAnimationEntry toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BlockAnimationEntry toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BlockAnimationEntry and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BlockAnimationEntry toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BlockAnimationEntry(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "Speed"),
            hasPhase(mem, offset) ? PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 13), "Phase") : null
        );
        if (cursor != null) cursor.position = offset + 17;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.phase != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.index);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.expectedBlockId);
        PacketIO.requireFinite(this.speed, "Speed"); mem.set(PacketIO.PROTO_FLOAT, offset + 9, this.speed);
        if (this.phase != null) {
            PacketIO.requireFinite(this.phase, "Phase"); mem.set(PacketIO.PROTO_FLOAT, offset + 13, this.phase);
        } else {
            mem.asSlice(offset + 13, 4).fill((byte) 0); 
        }
        
        
    
       return 17;
    }
    public int computeSize() {
        return 17;
    }

    public BlockAnimationEntry clone() {
        BlockAnimationEntry copy = new BlockAnimationEntry();
        copy.index = this.index;
        copy.expectedBlockId = this.expectedBlockId;
        copy.speed = this.speed;
        copy.phase = this.phase;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BlockAnimationEntry other)) return false;
        return this.index == other.index && this.expectedBlockId == other.expectedBlockId && this.speed == other.speed && java.util.Objects.equals(this.phase, other.phase);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(index, expectedBlockId, speed, phase);
    }

}