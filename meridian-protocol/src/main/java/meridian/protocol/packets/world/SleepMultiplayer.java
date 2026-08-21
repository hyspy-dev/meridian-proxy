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
import java.util.UUID;

public class SleepMultiplayer {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 65536014;

    public int sleepersCount;
    public int awakeCount;
    @Nullable public java.util.UUID[] awakeSample;

    public SleepMultiplayer() {
    }

    public SleepMultiplayer(int sleepersCount, int awakeCount, @Nullable java.util.UUID[] awakeSample) {
        this.sleepersCount = sleepersCount;
        this.awakeCount = awakeCount;
        this.awakeSample = awakeSample;
    }

    public SleepMultiplayer(@Nonnull SleepMultiplayer other) {
        this.sleepersCount = other.sleepersCount;
        this.awakeCount = other.awakeCount;
        this.awakeSample = other.awakeSample;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SleepMultiplayer", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SleepMultiplayer", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getSleepersCount(MemorySegment mem) {
        return getSleepersCount(mem, 0);
    }
    
    public static int getSleepersCount(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getAwakeCount(MemorySegment mem) {
        return getAwakeCount(mem, 0);
    }
    
    public static int getAwakeCount(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    @Nullable
    public static java.util.UUID[] getAwakeSample(MemorySegment mem) {
        return getAwakeSample(mem, 0);
    }
    
    @Nullable
    public static java.util.UUID[] getAwakeSample(MemorySegment mem, int offset) {
        if (!hasAwakeSample(mem, offset)) return null;
        var off = offset + 9;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("AwakeSample");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("AwakeSample", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 16 > mem.byteSize()) throw ProtocolException.bufferTooSmall("AwakeSample", (int) java.lang.Math.min(off + lenOffset + (long) len * 16, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new java.util.UUID[len];
        for (var i = 0; i < len; i++) {
            data[i] = PacketIO.readUUID(mem, off + i * 16);
        }
        return data;
    }
    
    public static boolean hasAwakeSample(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static SleepMultiplayer toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SleepMultiplayer toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SleepMultiplayer and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SleepMultiplayer toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        java.util.UUID[] v2 = null;
        if (hasAwakeSample(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("AwakeSample");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("AwakeSample", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 16 > mem.byteSize()) throw ProtocolException.bufferTooSmall("AwakeSample", (int) java.lang.Math.min(off + lenOffset + (long) len * 16, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new java.util.UUID[len];
            for (var i = 0; i < len; i++) {
                v2[i] = PacketIO.readUUID(mem, off + i * 16);
            }
            varPos = off + len * 16 - varBase;
        }
        var result = new SleepMultiplayer(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.awakeSample != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.sleepersCount);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.awakeCount);
        var varOffset = offset + 9;
        if (this.awakeSample != null) {
            
            if (awakeSample.length > 4096000) throw ProtocolException.arrayTooLong("AwakeSample", awakeSample.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.awakeSample.length);
            
            for (var i = 0; i < this.awakeSample.length; i++) {
                PacketIO.writeUUID(mem, varOffset + i * 16, this.awakeSample[i]);
            }
            varOffset += this.awakeSample.length * 16;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (awakeSample != null) size += VarInt.size(awakeSample.length) + awakeSample.length * 16;

        return size;
    }

    public SleepMultiplayer clone() {
        SleepMultiplayer copy = new SleepMultiplayer();
        copy.sleepersCount = this.sleepersCount;
        copy.awakeCount = this.awakeCount;
        copy.awakeSample = this.awakeSample != null ? java.util.Arrays.copyOf(this.awakeSample, this.awakeSample.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SleepMultiplayer other)) return false;
        return this.sleepersCount == other.sleepersCount && this.awakeCount == other.awakeCount && java.util.Arrays.equals(this.awakeSample, other.awakeSample);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(sleepersCount);
        result = 31 * result + Integer.hashCode(awakeCount);
        result = 31 * result + java.util.Arrays.hashCode(awakeSample);
        return result;
    }

}