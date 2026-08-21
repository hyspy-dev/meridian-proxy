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


public class PortalState {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 5;
    public static final int MAX_SIZE = 5;

    public int remainingSeconds;
    public boolean breaching;

    public PortalState() {
    }

    public PortalState(int remainingSeconds, boolean breaching) {
        this.remainingSeconds = remainingSeconds;
        this.breaching = breaching;
    }

    public PortalState(@Nonnull PortalState other) {
        this.remainingSeconds = other.remainingSeconds;
        this.breaching = other.breaching;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PortalState", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PortalState", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getRemainingSeconds(MemorySegment mem) {
        return getRemainingSeconds(mem, 0);
    }
    
    public static int getRemainingSeconds(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static boolean getBreaching(MemorySegment mem) {
        return getBreaching(mem, 0);
    }
    
    public static boolean getBreaching(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 4);
    }
    
    
    
    
    
    public static PortalState toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PortalState toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PortalState and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PortalState toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new PortalState(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_BOOL, offset + 4)
        );
        if (cursor != null) cursor.position = offset + 5;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.remainingSeconds);
        mem.set(PacketIO.PROTO_BOOL, offset + 4, this.breaching);
        
        
    
       return 5;
    }
    public int computeSize() {
        return 5;
    }

    public PortalState clone() {
        PortalState copy = new PortalState();
        copy.remainingSeconds = this.remainingSeconds;
        copy.breaching = this.breaching;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PortalState other)) return false;
        return this.remainingSeconds == other.remainingSeconds && this.breaching == other.breaching;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(remainingSeconds, breaching);
    }

}