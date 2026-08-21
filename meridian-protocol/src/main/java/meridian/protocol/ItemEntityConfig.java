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


public class ItemEntityConfig {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 5;
    public static final int MAX_SIZE = 16384010;

    @Nullable public String particleSystemId;
    @Nullable public Color particleColor;
    public boolean showItemParticles;

    public ItemEntityConfig() {
    }

    public ItemEntityConfig(@Nullable String particleSystemId, @Nullable Color particleColor, boolean showItemParticles) {
        this.particleSystemId = particleSystemId;
        this.particleColor = particleColor;
        this.showItemParticles = showItemParticles;
    }

    public ItemEntityConfig(@Nonnull ItemEntityConfig other) {
        this.particleSystemId = other.particleSystemId;
        this.particleColor = other.particleColor;
        this.showItemParticles = other.showItemParticles;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemEntityConfig", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemEntityConfig", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getParticleSystemId(MemorySegment mem) {
        return getParticleSystemId(mem, 0);
    }
    
    @Nullable
    public static String getParticleSystemId(MemorySegment mem, int offset) {
        return hasParticleSystemId(mem, offset) ? PacketIO.readVarString("ParticleSystemId", mem, offset + 5, 4096000): null;
    }
    
    @Nullable
    public static Color getParticleColor(MemorySegment mem) {
        return getParticleColor(mem, 0);
    }
    
    @Nullable
    public static Color getParticleColor(MemorySegment mem, int offset) {
        return hasParticleColor(mem, offset) ? Color.toObject(mem, offset + 1): null;
    }
    
    public static boolean getShowItemParticles(MemorySegment mem) {
        return getShowItemParticles(mem, 0);
    }
    
    public static boolean getShowItemParticles(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 4);
    }
    
    public static boolean hasParticleColor(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasParticleSystemId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    
    
    public static ItemEntityConfig toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemEntityConfig toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemEntityConfig and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemEntityConfig toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 5;
        var varPos = 0;
        String v0 = null;
        if (hasParticleSystemId(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("ParticleSystemId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new ItemEntityConfig(
            v0,
            hasParticleColor(mem, offset) ? Color.toObject(mem, offset + 1) : null,
            mem.get(PacketIO.PROTO_BOOL, offset + 4)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.particleColor != null) nullBits |= 0x01;
        if (this.particleSystemId != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.particleColor != null) {
            this.particleColor.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 3).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BOOL, offset + 4, this.showItemParticles);
        var varOffset = offset + 5;
        if (this.particleSystemId != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.particleSystemId, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 5;
        if (particleSystemId != null) size += PacketIO.stringSize(particleSystemId);

        return size;
    }

    public ItemEntityConfig clone() {
        ItemEntityConfig copy = new ItemEntityConfig();
        copy.particleSystemId = this.particleSystemId;
        copy.particleColor = this.particleColor != null ? this.particleColor.clone() : null;
        copy.showItemParticles = this.showItemParticles;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemEntityConfig other)) return false;
        return java.util.Objects.equals(this.particleSystemId, other.particleSystemId) && java.util.Objects.equals(this.particleColor, other.particleColor) && this.showItemParticles == other.showItemParticles;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(particleSystemId, particleColor, showItemParticles);
    }

}