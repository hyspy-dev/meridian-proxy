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


public class HitEntity {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 4;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 4;
    public static final int MAX_SIZE = 8192009;

    public int next;
    @Nonnull public EntityMatcher[] matchers = new EntityMatcher[0];

    public HitEntity() {
    }

    public HitEntity(int next, @Nonnull EntityMatcher[] matchers) {
        this.next = next;
        this.matchers = matchers;
    }

    public HitEntity(@Nonnull HitEntity other) {
        this.next = other.next;
        this.matchers = other.matchers;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("HitEntity", offset, (int) mem.byteSize());
        long needed = (long) offset + 4;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("HitEntity", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getNext(MemorySegment mem) {
        return getNext(mem, 0);
    }
    
    public static int getNext(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static EntityMatcher[] getMatchers(MemorySegment mem) {
        return getMatchers(mem, 0);
    }
    
    public static EntityMatcher[] getMatchers(MemorySegment mem, int offset) {
        var off = offset + 4;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Matchers");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Matchers", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Matchers", (int) java.lang.Math.min(off + lenOffset + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new EntityMatcher[len];
        for (var i = 0; i < len; i++) {
            data[i] = EntityMatcher.toObject(mem, off + i * 2);
        }
        return data;
    }
    
    
    
    
    
    public static HitEntity toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static HitEntity toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one HitEntity and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static HitEntity toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 4;
        var varPos = 0;
        EntityMatcher[] v1;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Matchers");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Matchers", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Matchers", (int) java.lang.Math.min(off + lenOffset + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new EntityMatcher[len];
            for (var i = 0; i < len; i++) {
                v1[i] = EntityMatcher.toObject(mem, off + i * 2);
            }
            varPos = off + len * 2 - varBase;
        }
        var result = new HitEntity(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.next);
        var varOffset = offset + 4;
        if (matchers.length > 4096000) throw ProtocolException.arrayTooLong("Matchers", matchers.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.matchers.length);
        
        var matchersValueOffset = 0;
        for (var i = 0; i < this.matchers.length; i++) {
            matchersValueOffset += this.matchers[i].serialize(mem, varOffset + matchersValueOffset);
        }
        varOffset += matchersValueOffset;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 4;
        size += VarInt.size(matchers.length) + matchers.length * 2;

        return size;
    }

    public HitEntity clone() {
        HitEntity copy = new HitEntity();
        copy.next = this.next;
        copy.matchers = java.util.Arrays.stream(this.matchers).map(e -> e.clone()).toArray(EntityMatcher[]::new);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof HitEntity other)) return false;
        return this.next == other.next && java.util.Arrays.equals(this.matchers, other.matchers);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(next);
        result = 31 * result + java.util.Arrays.hashCode(matchers);
        return result;
    }

}