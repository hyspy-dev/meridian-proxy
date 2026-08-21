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


public class ItemToolSpec {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 16384014;

    @Nullable public String gatherType;
    public float power;
    public int quality;

    public ItemToolSpec() {
    }

    public ItemToolSpec(@Nullable String gatherType, float power, int quality) {
        this.gatherType = gatherType;
        this.power = power;
        this.quality = quality;
    }

    public ItemToolSpec(@Nonnull ItemToolSpec other) {
        this.gatherType = other.gatherType;
        this.power = other.power;
        this.quality = other.quality;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemToolSpec", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemToolSpec", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getGatherType(MemorySegment mem) {
        return getGatherType(mem, 0);
    }
    
    @Nullable
    public static String getGatherType(MemorySegment mem, int offset) {
        return hasGatherType(mem, offset) ? PacketIO.readVarString("GatherType", mem, offset + 9, 4096000): null;
    }
    
    public static float getPower(MemorySegment mem) {
        return getPower(mem, 0);
    }
    
    public static float getPower(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Power");
    }
    
    public static int getQuality(MemorySegment mem) {
        return getQuality(mem, 0);
    }
    
    public static int getQuality(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static boolean hasGatherType(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static ItemToolSpec toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemToolSpec toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemToolSpec and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemToolSpec toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        String v0 = null;
        if (hasGatherType(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("GatherType", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new ItemToolSpec(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Power"),
            mem.get(PacketIO.PROTO_INT, offset + 5)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.gatherType != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.power, "Power"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.power);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.quality);
        var varOffset = offset + 9;
        if (this.gatherType != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.gatherType, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (gatherType != null) size += PacketIO.stringSize(gatherType);

        return size;
    }

    public ItemToolSpec clone() {
        ItemToolSpec copy = new ItemToolSpec();
        copy.gatherType = this.gatherType;
        copy.power = this.power;
        copy.quality = this.quality;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemToolSpec other)) return false;
        return java.util.Objects.equals(this.gatherType, other.gatherType) && this.power == other.power && this.quality == other.quality;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(gatherType, power, quality);
    }

}