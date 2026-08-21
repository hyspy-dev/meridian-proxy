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


public class EntityMatcher {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 2;
    public static final int MAX_SIZE = 2;

    @Nonnull public EntityMatcherType type = EntityMatcherType.Server;
    public boolean invert;

    public EntityMatcher() {
    }

    public EntityMatcher(@Nonnull EntityMatcherType type, boolean invert) {
        this.type = type;
        this.invert = invert;
    }

    public EntityMatcher(@Nonnull EntityMatcher other) {
        this.type = other.type;
        this.invert = other.invert;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("EntityMatcher", offset, (int) mem.byteSize());
        long needed = (long) offset + 2;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("EntityMatcher", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static EntityMatcherType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static EntityMatcherType getType(MemorySegment mem, int offset) {
        return EntityMatcherType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0));
    }
    
    public static boolean getInvert(MemorySegment mem) {
        return getInvert(mem, 0);
    }
    
    public static boolean getInvert(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 1);
    }
    
    
    
    
    
    public static EntityMatcher toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static EntityMatcher toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one EntityMatcher and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static EntityMatcher toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new EntityMatcher(
            EntityMatcherType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0)),
            mem.get(PacketIO.PROTO_BOOL, offset + 1)
        );
        if (cursor != null) cursor.position = offset + 2;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, (byte) this.type.getValue());
        mem.set(PacketIO.PROTO_BOOL, offset + 1, this.invert);
        
        
    
       return 2;
    }
    public int computeSize() {
        return 2;
    }

    public EntityMatcher clone() {
        EntityMatcher copy = new EntityMatcher();
        copy.type = this.type;
        copy.invert = this.invert;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EntityMatcher other)) return false;
        return java.util.Objects.equals(this.type, other.type) && this.invert == other.invert;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(type, invert);
    }

}