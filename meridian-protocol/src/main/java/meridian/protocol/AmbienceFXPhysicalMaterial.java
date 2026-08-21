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


public class AmbienceFXPhysicalMaterial {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 13;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 13;

    public int physicalMaterialIndex;
    @Nullable public Rangef percent;

    public AmbienceFXPhysicalMaterial() {
    }

    public AmbienceFXPhysicalMaterial(int physicalMaterialIndex, @Nullable Rangef percent) {
        this.physicalMaterialIndex = physicalMaterialIndex;
        this.percent = percent;
    }

    public AmbienceFXPhysicalMaterial(@Nonnull AmbienceFXPhysicalMaterial other) {
        this.physicalMaterialIndex = other.physicalMaterialIndex;
        this.percent = other.percent;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AmbienceFXPhysicalMaterial", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AmbienceFXPhysicalMaterial", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getPhysicalMaterialIndex(MemorySegment mem) {
        return getPhysicalMaterialIndex(mem, 0);
    }
    
    public static int getPhysicalMaterialIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static Rangef getPercent(MemorySegment mem) {
        return getPercent(mem, 0);
    }
    
    @Nullable
    public static Rangef getPercent(MemorySegment mem, int offset) {
        return hasPercent(mem, offset) ? Rangef.toObject(mem, offset + 5): null;
    }
    
    public static boolean hasPercent(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static AmbienceFXPhysicalMaterial toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AmbienceFXPhysicalMaterial toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AmbienceFXPhysicalMaterial and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AmbienceFXPhysicalMaterial toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new AmbienceFXPhysicalMaterial(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            hasPercent(mem, offset) ? Rangef.toObject(mem, offset + 5) : null
        );
        if (cursor != null) cursor.position = offset + 13;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.percent != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.physicalMaterialIndex);
        if (this.percent != null) {
            this.percent.serialize(mem, offset + 5);
        } else {
            mem.asSlice(offset + 5, 8).fill((byte) 0); 
        }
        
        
    
       return 13;
    }
    public int computeSize() {
        return 13;
    }

    public AmbienceFXPhysicalMaterial clone() {
        AmbienceFXPhysicalMaterial copy = new AmbienceFXPhysicalMaterial();
        copy.physicalMaterialIndex = this.physicalMaterialIndex;
        copy.percent = this.percent != null ? this.percent.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AmbienceFXPhysicalMaterial other)) return false;
        return this.physicalMaterialIndex == other.physicalMaterialIndex && java.util.Objects.equals(this.percent, other.percent);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(physicalMaterialIndex, percent);
    }

}