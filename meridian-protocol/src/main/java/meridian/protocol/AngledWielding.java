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


public class AngledWielding {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 9;

    public float angleRad;
    public float angleDistanceRad;
    public boolean hasModifiers;

    public AngledWielding() {
    }

    public AngledWielding(float angleRad, float angleDistanceRad, boolean hasModifiers) {
        this.angleRad = angleRad;
        this.angleDistanceRad = angleDistanceRad;
        this.hasModifiers = hasModifiers;
    }

    public AngledWielding(@Nonnull AngledWielding other) {
        this.angleRad = other.angleRad;
        this.angleDistanceRad = other.angleDistanceRad;
        this.hasModifiers = other.hasModifiers;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AngledWielding", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AngledWielding", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getAngleRad(MemorySegment mem) {
        return getAngleRad(mem, 0);
    }
    
    public static float getAngleRad(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "AngleRad");
    }
    
    public static float getAngleDistanceRad(MemorySegment mem) {
        return getAngleDistanceRad(mem, 0);
    }
    
    public static float getAngleDistanceRad(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "AngleDistanceRad");
    }
    
    public static boolean getHasModifiers(MemorySegment mem) {
        return getHasModifiers(mem, 0);
    }
    
    public static boolean getHasModifiers(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 8);
    }
    
    
    
    
    
    public static AngledWielding toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AngledWielding toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AngledWielding and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AngledWielding toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new AngledWielding(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "AngleRad"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "AngleDistanceRad"),
            mem.get(PacketIO.PROTO_BOOL, offset + 8)
        );
        if (cursor != null) cursor.position = offset + 9;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.angleRad, "AngleRad"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.angleRad);
        PacketIO.requireFinite(this.angleDistanceRad, "AngleDistanceRad"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.angleDistanceRad);
        mem.set(PacketIO.PROTO_BOOL, offset + 8, this.hasModifiers);
        
        
    
       return 9;
    }
    public int computeSize() {
        return 9;
    }

    public AngledWielding clone() {
        AngledWielding copy = new AngledWielding();
        copy.angleRad = this.angleRad;
        copy.angleDistanceRad = this.angleDistanceRad;
        copy.hasModifiers = this.hasModifiers;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AngledWielding other)) return false;
        return this.angleRad == other.angleRad && this.angleDistanceRad == other.angleDistanceRad && this.hasModifiers == other.hasModifiers;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(angleRad, angleDistanceRad, hasModifiers);
    }

}