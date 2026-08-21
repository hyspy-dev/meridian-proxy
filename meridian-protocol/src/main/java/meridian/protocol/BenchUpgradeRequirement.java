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


public class BenchUpgradeRequirement {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public MaterialQuantity[] material;
    public double timeSeconds;

    public BenchUpgradeRequirement() {
    }

    public BenchUpgradeRequirement(@Nullable MaterialQuantity[] material, double timeSeconds) {
        this.material = material;
        this.timeSeconds = timeSeconds;
    }

    public BenchUpgradeRequirement(@Nonnull BenchUpgradeRequirement other) {
        this.material = other.material;
        this.timeSeconds = other.timeSeconds;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BenchUpgradeRequirement", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BenchUpgradeRequirement", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static MaterialQuantity[] getMaterial(MemorySegment mem) {
        return getMaterial(mem, 0);
    }
    
    @Nullable
    public static MaterialQuantity[] getMaterial(MemorySegment mem, int offset) {
        if (!hasMaterial(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 9;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Material");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Material", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Material", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new MaterialQuantity[len];
        for (var i = 0; i < len; i++) {
            data[i] = MaterialQuantity.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static double getTimeSeconds(MemorySegment mem) {
        return getTimeSeconds(mem, 0);
    }
    
    public static double getTimeSeconds(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 1), "TimeSeconds");
    }
    
    public static boolean hasMaterial(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static BenchUpgradeRequirement toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BenchUpgradeRequirement toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BenchUpgradeRequirement and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BenchUpgradeRequirement toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        MaterialQuantity[] v0 = null;
        if (hasMaterial(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Material");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Material", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Material", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new MaterialQuantity[len];
            for (var i = 0; i < len; i++) {
                v0[i] = MaterialQuantity.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new BenchUpgradeRequirement(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 1), "TimeSeconds")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.material != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.timeSeconds, "TimeSeconds"); mem.set(PacketIO.PROTO_DOUBLE, offset + 1, this.timeSeconds);
        var varOffset = offset + 9;
        if (this.material != null) {
            
            if (material.length > 4096000) throw ProtocolException.arrayTooLong("Material", material.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.material.length);
            
            var materialValueOffset = 0;
            for (var i = 0; i < this.material.length; i++) {
                materialValueOffset += this.material[i].serialize(mem, varOffset + materialValueOffset);
            }
            varOffset += materialValueOffset;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (material != null) {
        int materialSize = 0;
for (var elem : material) materialSize += elem.computeSize();
size += VarInt.size(material.length) + materialSize;
    }

        return size;
    }

    public BenchUpgradeRequirement clone() {
        BenchUpgradeRequirement copy = new BenchUpgradeRequirement();
        copy.material = this.material != null ? java.util.Arrays.stream(this.material).map(e -> e.clone()).toArray(MaterialQuantity[]::new) : null;
        copy.timeSeconds = this.timeSeconds;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BenchUpgradeRequirement other)) return false;
        return java.util.Arrays.equals(this.material, other.material) && this.timeSeconds == other.timeSeconds;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(material);
        result = 31 * result + Double.hashCode(timeSeconds);
        return result;
    }

}