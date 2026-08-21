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


public class DamageEntry {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 16384014;

    @Nullable public String labelKey;
    public float min;
    public float max;

    public DamageEntry() {
    }

    public DamageEntry(@Nullable String labelKey, float min, float max) {
        this.labelKey = labelKey;
        this.min = min;
        this.max = max;
    }

    public DamageEntry(@Nonnull DamageEntry other) {
        this.labelKey = other.labelKey;
        this.min = other.min;
        this.max = other.max;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("DamageEntry", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("DamageEntry", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getLabelKey(MemorySegment mem) {
        return getLabelKey(mem, 0);
    }
    
    @Nullable
    public static String getLabelKey(MemorySegment mem, int offset) {
        return hasLabelKey(mem, offset) ? PacketIO.readVarString("LabelKey", mem, offset + 9, 4096000): null;
    }
    
    public static float getMin(MemorySegment mem) {
        return getMin(mem, 0);
    }
    
    public static float getMin(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Min");
    }
    
    public static float getMax(MemorySegment mem) {
        return getMax(mem, 0);
    }
    
    public static float getMax(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "Max");
    }
    
    public static boolean hasLabelKey(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static DamageEntry toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static DamageEntry toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one DamageEntry and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static DamageEntry toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        String v0 = null;
        if (hasLabelKey(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("LabelKey", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new DamageEntry(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Min"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "Max")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.labelKey != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.min, "Min"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.min);
        PacketIO.requireFinite(this.max, "Max"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.max);
        var varOffset = offset + 9;
        if (this.labelKey != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.labelKey, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (labelKey != null) size += PacketIO.stringSize(labelKey);

        return size;
    }

    public DamageEntry clone() {
        DamageEntry copy = new DamageEntry();
        copy.labelKey = this.labelKey;
        copy.min = this.min;
        copy.max = this.max;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DamageEntry other)) return false;
        return java.util.Objects.equals(this.labelKey, other.labelKey) && this.min == other.min && this.max == other.max;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(labelKey, min, max);
    }

}