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


public class NotConnectedBlockRule extends ConnectedBlockRule {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 0;
    public static final int MAX_SIZE = 1024;

    @Nonnull public ConnectedBlockRule rule;

    public NotConnectedBlockRule() {
    }

    public NotConnectedBlockRule(@Nonnull ConnectedBlockRule rule) {
        this.rule = rule;
    }

    public NotConnectedBlockRule(@Nonnull NotConnectedBlockRule other) {
        this.rule = other.rule;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("NotConnectedBlockRule", offset, (int) mem.byteSize());
        long needed = (long) offset + 0;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("NotConnectedBlockRule", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static ConnectedBlockRule getRule(MemorySegment mem) {
        return getRule(mem, 0);
    }
    
    public static ConnectedBlockRule getRule(MemorySegment mem, int offset) {
        return ConnectedBlockRule.toObject(mem, offset + 0);
    }
    
    
    
    
    
    public static NotConnectedBlockRule toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static NotConnectedBlockRule toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one NotConnectedBlockRule and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static NotConnectedBlockRule toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 0;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ConnectedBlockRule v0;
        {
            v0 = ConnectedBlockRule.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new NotConnectedBlockRule(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 0;
        varOffset += this.rule.serializeWithTypeId(mem, varOffset);
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 0;
        size += rule.computeSizeWithTypeId();

        return size;
    }

    public NotConnectedBlockRule clone() {
        NotConnectedBlockRule copy = new NotConnectedBlockRule();
        copy.rule = this.rule;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof NotConnectedBlockRule other)) return false;
        return java.util.Objects.equals(this.rule, other.rule);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(rule);
    }

}