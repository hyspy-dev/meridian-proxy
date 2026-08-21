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


public class InteractionSettings {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1;

    public boolean allowSkipOnClick;

    public InteractionSettings() {
    }

    public InteractionSettings(boolean allowSkipOnClick) {
        this.allowSkipOnClick = allowSkipOnClick;
    }

    public InteractionSettings(@Nonnull InteractionSettings other) {
        this.allowSkipOnClick = other.allowSkipOnClick;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("InteractionSettings", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InteractionSettings", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getAllowSkipOnClick(MemorySegment mem) {
        return getAllowSkipOnClick(mem, 0);
    }
    
    public static boolean getAllowSkipOnClick(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 0);
    }
    
    
    
    
    
    public static InteractionSettings toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static InteractionSettings toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one InteractionSettings and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static InteractionSettings toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new InteractionSettings(
            mem.get(PacketIO.PROTO_BOOL, offset + 0)
        );
        if (cursor != null) cursor.position = offset + 1;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BOOL, offset + 0, this.allowSkipOnClick);
        
        
    
       return 1;
    }
    public int computeSize() {
        return 1;
    }

    public InteractionSettings clone() {
        InteractionSettings copy = new InteractionSettings();
        copy.allowSkipOnClick = this.allowSkipOnClick;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InteractionSettings other)) return false;
        return this.allowSkipOnClick == other.allowSkipOnClick;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(allowSkipOnClick);
    }

}