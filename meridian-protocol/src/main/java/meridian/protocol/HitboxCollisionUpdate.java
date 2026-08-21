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


public class HitboxCollisionUpdate extends ComponentUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 4;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 4;
    public static final int MAX_SIZE = 4;

    public int hitboxCollisionConfigIndex;

    public HitboxCollisionUpdate() {
    }

    public HitboxCollisionUpdate(int hitboxCollisionConfigIndex) {
        this.hitboxCollisionConfigIndex = hitboxCollisionConfigIndex;
    }

    public HitboxCollisionUpdate(@Nonnull HitboxCollisionUpdate other) {
        this.hitboxCollisionConfigIndex = other.hitboxCollisionConfigIndex;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("HitboxCollisionUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 4;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("HitboxCollisionUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getHitboxCollisionConfigIndex(MemorySegment mem) {
        return getHitboxCollisionConfigIndex(mem, 0);
    }
    
    public static int getHitboxCollisionConfigIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    
    
    
    
    public static HitboxCollisionUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static HitboxCollisionUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one HitboxCollisionUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static HitboxCollisionUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new HitboxCollisionUpdate(
            mem.get(PacketIO.PROTO_INT, offset + 0)
        );
        if (cursor != null) cursor.position = offset + 4;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.hitboxCollisionConfigIndex);
        
        
    
       return 4;
    }
    @Override
    public int computeSize() {
        return 4;
    }

    public HitboxCollisionUpdate clone() {
        HitboxCollisionUpdate copy = new HitboxCollisionUpdate();
        copy.hitboxCollisionConfigIndex = this.hitboxCollisionConfigIndex;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof HitboxCollisionUpdate other)) return false;
        return this.hitboxCollisionConfigIndex == other.hitboxCollisionConfigIndex;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(hitboxCollisionConfigIndex);
    }

}