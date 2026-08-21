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


public class FluidParticle {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 8;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 8;
    public static final int MAX_SIZE = 16384013;

    @Nullable public String systemId;
    @Nullable public Color color;
    public float scale;

    public FluidParticle() {
    }

    public FluidParticle(@Nullable String systemId, @Nullable Color color, float scale) {
        this.systemId = systemId;
        this.color = color;
        this.scale = scale;
    }

    public FluidParticle(@Nonnull FluidParticle other) {
        this.systemId = other.systemId;
        this.color = other.color;
        this.scale = other.scale;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("FluidParticle", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("FluidParticle", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getSystemId(MemorySegment mem) {
        return getSystemId(mem, 0);
    }
    
    @Nullable
    public static String getSystemId(MemorySegment mem, int offset) {
        return hasSystemId(mem, offset) ? PacketIO.readVarString("SystemId", mem, offset + 8, 4096000): null;
    }
    
    @Nullable
    public static Color getColor(MemorySegment mem) {
        return getColor(mem, 0);
    }
    
    @Nullable
    public static Color getColor(MemorySegment mem, int offset) {
        return hasColor(mem, offset) ? Color.toObject(mem, offset + 1): null;
    }
    
    public static float getScale(MemorySegment mem) {
        return getScale(mem, 0);
    }
    
    public static float getScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "Scale");
    }
    
    public static boolean hasColor(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasSystemId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    
    
    public static FluidParticle toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static FluidParticle toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one FluidParticle and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static FluidParticle toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 8;
        var varPos = 0;
        String v0 = null;
        if (hasSystemId(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("SystemId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new FluidParticle(
            v0,
            hasColor(mem, offset) ? Color.toObject(mem, offset + 1) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "Scale")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.color != null) nullBits |= 0x01;
        if (this.systemId != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.color != null) {
            this.color.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 3).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.scale, "Scale"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.scale);
        var varOffset = offset + 8;
        if (this.systemId != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.systemId, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 8;
        if (systemId != null) size += PacketIO.stringSize(systemId);

        return size;
    }

    public FluidParticle clone() {
        FluidParticle copy = new FluidParticle();
        copy.systemId = this.systemId;
        copy.color = this.color != null ? this.color.clone() : null;
        copy.scale = this.scale;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FluidParticle other)) return false;
        return java.util.Objects.equals(this.systemId, other.systemId) && java.util.Objects.equals(this.color, other.color) && this.scale == other.scale;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(systemId, color, scale);
    }

}