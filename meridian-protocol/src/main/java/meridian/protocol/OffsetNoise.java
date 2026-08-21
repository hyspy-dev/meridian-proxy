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


public class OffsetNoise {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 12;
    public static final int MAX_SIZE = 270336027;

    @Nonnull public NoiseConfig[] x = new NoiseConfig[0];
    @Nonnull public NoiseConfig[] y = new NoiseConfig[0];
    @Nonnull public NoiseConfig[] z = new NoiseConfig[0];

    public OffsetNoise() {
    }

    public OffsetNoise(@Nonnull NoiseConfig[] x, @Nonnull NoiseConfig[] y, @Nonnull NoiseConfig[] z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public OffsetNoise(@Nonnull OffsetNoise other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("OffsetNoise", offset, (int) mem.byteSize());
        long needed = (long) offset + 12;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("OffsetNoise", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static NoiseConfig[] getX(MemorySegment mem) {
        return getX(mem, 0);
    }
    
    public static NoiseConfig[] getX(MemorySegment mem, int offset) {
        var off = offset + getValidatedOffset(mem, offset, 0, 12, "X");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("X");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("X", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 22 > mem.byteSize()) throw ProtocolException.bufferTooSmall("X", (int) java.lang.Math.min(off + lenOffset + (long) len * 22, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new NoiseConfig[len];
        for (var i = 0; i < len; i++) {
            data[i] = NoiseConfig.toObject(mem, off + i * 22);
        }
        return data;
    }
    
    public static NoiseConfig[] getY(MemorySegment mem) {
        return getY(mem, 0);
    }
    
    public static NoiseConfig[] getY(MemorySegment mem, int offset) {
        var off = offset + getValidatedOffset(mem, offset, 4, 12, "Y");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Y");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Y", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 22 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Y", (int) java.lang.Math.min(off + lenOffset + (long) len * 22, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new NoiseConfig[len];
        for (var i = 0; i < len; i++) {
            data[i] = NoiseConfig.toObject(mem, off + i * 22);
        }
        return data;
    }
    
    public static NoiseConfig[] getZ(MemorySegment mem) {
        return getZ(mem, 0);
    }
    
    public static NoiseConfig[] getZ(MemorySegment mem, int offset) {
        var off = offset + getValidatedOffset(mem, offset, 8, 12, "Z");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Z");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Z", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 22 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Z", (int) java.lang.Math.min(off + lenOffset + (long) len * 22, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new NoiseConfig[len];
        for (var i = 0; i < len; i++) {
            data[i] = NoiseConfig.toObject(mem, off + i * 22);
        }
        return data;
    }
    
    
    
    private static int getValidatedOffset(MemorySegment buffer, int base, int slotPosition, int varBlockStart, String fieldName) {
        int offset = buffer.get(PacketIO.PROTO_INT, base + slotPosition);
        if (offset < 0 || offset > buffer.byteSize() - base - varBlockStart)
            throw ProtocolException.invalidOffset(fieldName, offset, (int) buffer.byteSize());
        return varBlockStart + offset;
    }
    
    /**
     * Rejects an offset slot that does not name the position the field-order walk reached. A
     * present field must sit where the previous field ended, and an absent field carries -1, so
     * the slot a random-access getter resolves and the walk describe the same bytes.
     */
    private static void requireSlot(MemorySegment mem, int slotPosition, int expected, String fieldName) {
        int slot = mem.get(PacketIO.PROTO_INT, slotPosition);
        if (slot != expected) throw ProtocolException.nonCanonicalLayout(fieldName, slot, expected);
    }
    
    public static OffsetNoise toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static OffsetNoise toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one OffsetNoise and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static OffsetNoise toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 12;
        var varPos = 0;
        NoiseConfig[] v0;
        requireSlot(mem, offset + 0, varPos, "X");
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("X");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("X", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 22 > mem.byteSize()) throw ProtocolException.bufferTooSmall("X", (int) java.lang.Math.min(off + lenOffset + (long) len * 22, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new NoiseConfig[len];
            for (var i = 0; i < len; i++) {
                v0[i] = NoiseConfig.toObject(mem, off + i * 22);
            }
            varPos = off + len * 22 - varBase;
        }
        
        NoiseConfig[] v1;
        requireSlot(mem, offset + 4, varPos, "Y");
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Y");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Y", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 22 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Y", (int) java.lang.Math.min(off + lenOffset + (long) len * 22, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new NoiseConfig[len];
            for (var i = 0; i < len; i++) {
                v1[i] = NoiseConfig.toObject(mem, off + i * 22);
            }
            varPos = off + len * 22 - varBase;
        }
        
        NoiseConfig[] v2;
        requireSlot(mem, offset + 8, varPos, "Z");
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Z");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Z", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 22 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Z", (int) java.lang.Math.min(off + lenOffset + (long) len * 22, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new NoiseConfig[len];
            for (var i = 0; i < len; i++) {
                v2[i] = NoiseConfig.toObject(mem, off + i * 22);
            }
            varPos = off + len * 22 - varBase;
        }
        var result = new OffsetNoise(
            v0,
            v1,
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 12;
        mem.set(PacketIO.PROTO_INT, offset + 0, varOffset - offset - 12);
        if (x.length > 4096000) throw ProtocolException.arrayTooLong("X", x.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.x.length);
        
        var xValueOffset = 0;
        for (var i = 0; i < this.x.length; i++) {
            xValueOffset += this.x[i].serialize(mem, varOffset + xValueOffset);
        }
        varOffset += xValueOffset;
        mem.set(PacketIO.PROTO_INT, offset + 4, varOffset - offset - 12);
        if (y.length > 4096000) throw ProtocolException.arrayTooLong("Y", y.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.y.length);
        
        var yValueOffset = 0;
        for (var i = 0; i < this.y.length; i++) {
            yValueOffset += this.y[i].serialize(mem, varOffset + yValueOffset);
        }
        varOffset += yValueOffset;
        mem.set(PacketIO.PROTO_INT, offset + 8, varOffset - offset - 12);
        if (z.length > 4096000) throw ProtocolException.arrayTooLong("Z", z.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.z.length);
        
        var zValueOffset = 0;
        for (var i = 0; i < this.z.length; i++) {
            zValueOffset += this.z[i].serialize(mem, varOffset + zValueOffset);
        }
        varOffset += zValueOffset;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 12;
        size += VarInt.size(x.length) + x.length * 22;
    size += VarInt.size(y.length) + y.length * 22;
    size += VarInt.size(z.length) + z.length * 22;

        return size;
    }

    public OffsetNoise clone() {
        OffsetNoise copy = new OffsetNoise();
        copy.x = java.util.Arrays.stream(this.x).map(e -> e.clone()).toArray(NoiseConfig[]::new);
        copy.y = java.util.Arrays.stream(this.y).map(e -> e.clone()).toArray(NoiseConfig[]::new);
        copy.z = java.util.Arrays.stream(this.z).map(e -> e.clone()).toArray(NoiseConfig[]::new);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof OffsetNoise other)) return false;
        return java.util.Arrays.equals(this.x, other.x) && java.util.Arrays.equals(this.y, other.y) && java.util.Arrays.equals(this.z, other.z);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(x);
        result = 31 * result + java.util.Arrays.hashCode(y);
        result = 31 * result + java.util.Arrays.hashCode(z);
        return result;
    }

}