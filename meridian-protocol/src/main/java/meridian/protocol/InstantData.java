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


public class InstantData {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 12;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 12;
    public static final int MAX_SIZE = 12;

    public long seconds;
    public int nanos;

    public InstantData() {
    }

    public InstantData(long seconds, int nanos) {
        this.seconds = seconds;
        this.nanos = nanos;
    }

    public InstantData(@Nonnull InstantData other) {
        this.seconds = other.seconds;
        this.nanos = other.nanos;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("InstantData", offset, (int) mem.byteSize());
        long needed = (long) offset + 12;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InstantData", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static long getSeconds(MemorySegment mem) {
        return getSeconds(mem, 0);
    }
    
    public static long getSeconds(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_LONG, offset + 0);
    }
    
    public static int getNanos(MemorySegment mem) {
        return getNanos(mem, 0);
    }
    
    public static int getNanos(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 8);
    }
    
    
    
    
    
    public static InstantData toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static InstantData toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one InstantData and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static InstantData toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new InstantData(
            mem.get(PacketIO.PROTO_LONG, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 8)
        );
        if (cursor != null) cursor.position = offset + 12;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_LONG, offset + 0, this.seconds);
        mem.set(PacketIO.PROTO_INT, offset + 8, this.nanos);
        
        
    
       return 12;
    }
    public int computeSize() {
        return 12;
    }

    public InstantData clone() {
        InstantData copy = new InstantData();
        copy.seconds = this.seconds;
        copy.nanos = this.nanos;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InstantData other)) return false;
        return this.seconds == other.seconds && this.nanos == other.nanos;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(seconds, nanos);
    }

}