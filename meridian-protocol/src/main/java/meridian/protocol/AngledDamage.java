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


public class AngledDamage {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 21;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 21;
    public static final int MAX_SIZE = 1677721600;

    public double angle;
    public double angleDistance;
    @Nullable public DamageEffects damageEffects;
    public int next;

    public AngledDamage() {
    }

    public AngledDamage(double angle, double angleDistance, @Nullable DamageEffects damageEffects, int next) {
        this.angle = angle;
        this.angleDistance = angleDistance;
        this.damageEffects = damageEffects;
        this.next = next;
    }

    public AngledDamage(@Nonnull AngledDamage other) {
        this.angle = other.angle;
        this.angleDistance = other.angleDistance;
        this.damageEffects = other.damageEffects;
        this.next = other.next;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AngledDamage", offset, (int) mem.byteSize());
        long needed = (long) offset + 21;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AngledDamage", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static double getAngle(MemorySegment mem) {
        return getAngle(mem, 0);
    }
    
    public static double getAngle(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 1), "Angle");
    }
    
    public static double getAngleDistance(MemorySegment mem) {
        return getAngleDistance(mem, 0);
    }
    
    public static double getAngleDistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 9), "AngleDistance");
    }
    
    @Nullable
    public static DamageEffects getDamageEffects(MemorySegment mem) {
        return getDamageEffects(mem, 0);
    }
    
    @Nullable
    public static DamageEffects getDamageEffects(MemorySegment mem, int offset) {
        return hasDamageEffects(mem, offset) ? DamageEffects.toObject(mem, offset + 21): null;
    }
    
    public static int getNext(MemorySegment mem) {
        return getNext(mem, 0);
    }
    
    public static int getNext(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 17);
    }
    
    public static boolean hasDamageEffects(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static AngledDamage toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AngledDamage toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AngledDamage and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AngledDamage toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 21;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        DamageEffects v2 = null;
        if (hasDamageEffects(mem, offset)) {
            v2 = DamageEffects.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new AngledDamage(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 1), "Angle"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 9), "AngleDistance"),
            v2,
            mem.get(PacketIO.PROTO_INT, offset + 17)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.damageEffects != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.angle, "Angle"); mem.set(PacketIO.PROTO_DOUBLE, offset + 1, this.angle);
        PacketIO.requireFinite(this.angleDistance, "AngleDistance"); mem.set(PacketIO.PROTO_DOUBLE, offset + 9, this.angleDistance);
        mem.set(PacketIO.PROTO_INT, offset + 17, this.next);
        var varOffset = offset + 21;
        if (this.damageEffects != null) {
            
            varOffset += this.damageEffects.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 21;
        if (damageEffects != null) size += damageEffects.computeSize();

        return size;
    }

    public AngledDamage clone() {
        AngledDamage copy = new AngledDamage();
        copy.angle = this.angle;
        copy.angleDistance = this.angleDistance;
        copy.damageEffects = this.damageEffects != null ? this.damageEffects.clone() : null;
        copy.next = this.next;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AngledDamage other)) return false;
        return this.angle == other.angle && this.angleDistance == other.angleDistance && java.util.Objects.equals(this.damageEffects, other.damageEffects) && this.next == other.next;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(angle, angleDistance, damageEffects, next);
    }

}