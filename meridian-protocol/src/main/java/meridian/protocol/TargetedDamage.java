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


public class TargetedDamage {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 1677721600;

    public int index;
    @Nullable public DamageEffects damageEffects;
    public int next;

    public TargetedDamage() {
    }

    public TargetedDamage(int index, @Nullable DamageEffects damageEffects, int next) {
        this.index = index;
        this.damageEffects = damageEffects;
        this.next = next;
    }

    public TargetedDamage(@Nonnull TargetedDamage other) {
        this.index = other.index;
        this.damageEffects = other.damageEffects;
        this.next = other.next;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("TargetedDamage", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("TargetedDamage", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getIndex(MemorySegment mem) {
        return getIndex(mem, 0);
    }
    
    public static int getIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static DamageEffects getDamageEffects(MemorySegment mem) {
        return getDamageEffects(mem, 0);
    }
    
    @Nullable
    public static DamageEffects getDamageEffects(MemorySegment mem, int offset) {
        return hasDamageEffects(mem, offset) ? DamageEffects.toObject(mem, offset + 9): null;
    }
    
    public static int getNext(MemorySegment mem) {
        return getNext(mem, 0);
    }
    
    public static int getNext(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static boolean hasDamageEffects(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static TargetedDamage toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static TargetedDamage toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one TargetedDamage and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static TargetedDamage toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        DamageEffects v1 = null;
        if (hasDamageEffects(mem, offset)) {
            v1 = DamageEffects.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new TargetedDamage(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v1,
            mem.get(PacketIO.PROTO_INT, offset + 5)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.damageEffects != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.index);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.next);
        var varOffset = offset + 9;
        if (this.damageEffects != null) {
            
            varOffset += this.damageEffects.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (damageEffects != null) size += damageEffects.computeSize();

        return size;
    }

    public TargetedDamage clone() {
        TargetedDamage copy = new TargetedDamage();
        copy.index = this.index;
        copy.damageEffects = this.damageEffects != null ? this.damageEffects.clone() : null;
        copy.next = this.next;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TargetedDamage other)) return false;
        return this.index == other.index && java.util.Objects.equals(this.damageEffects, other.damageEffects) && this.next == other.next;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(index, damageEffects, next);
    }

}