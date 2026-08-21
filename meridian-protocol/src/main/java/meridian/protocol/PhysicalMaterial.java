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


public class PhysicalMaterial {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 17;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 17;
    public static final int MAX_SIZE = 16384022;

    @Nullable public String id;
    public float reflectionCoeff;
    public float attenuationPerBlock;
    public float hFAttenuationPerBlock;
    public float shelterOpacity;

    public PhysicalMaterial() {
    }

    public PhysicalMaterial(@Nullable String id, float reflectionCoeff, float attenuationPerBlock, float hFAttenuationPerBlock, float shelterOpacity) {
        this.id = id;
        this.reflectionCoeff = reflectionCoeff;
        this.attenuationPerBlock = attenuationPerBlock;
        this.hFAttenuationPerBlock = hFAttenuationPerBlock;
        this.shelterOpacity = shelterOpacity;
    }

    public PhysicalMaterial(@Nonnull PhysicalMaterial other) {
        this.id = other.id;
        this.reflectionCoeff = other.reflectionCoeff;
        this.attenuationPerBlock = other.attenuationPerBlock;
        this.hFAttenuationPerBlock = other.hFAttenuationPerBlock;
        this.shelterOpacity = other.shelterOpacity;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PhysicalMaterial", offset, (int) mem.byteSize());
        long needed = (long) offset + 17;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PhysicalMaterial", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + 17, 4096000): null;
    }
    
    public static float getReflectionCoeff(MemorySegment mem) {
        return getReflectionCoeff(mem, 0);
    }
    
    public static float getReflectionCoeff(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "ReflectionCoeff");
    }
    
    public static float getAttenuationPerBlock(MemorySegment mem) {
        return getAttenuationPerBlock(mem, 0);
    }
    
    public static float getAttenuationPerBlock(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "AttenuationPerBlock");
    }
    
    public static float getHFAttenuationPerBlock(MemorySegment mem) {
        return getHFAttenuationPerBlock(mem, 0);
    }
    
    public static float getHFAttenuationPerBlock(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "HFAttenuationPerBlock");
    }
    
    public static float getShelterOpacity(MemorySegment mem) {
        return getShelterOpacity(mem, 0);
    }
    
    public static float getShelterOpacity(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 13), "ShelterOpacity");
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static PhysicalMaterial toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PhysicalMaterial toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PhysicalMaterial and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PhysicalMaterial toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 17;
        var varPos = 0;
        String v0 = null;
        if (hasId(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new PhysicalMaterial(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "ReflectionCoeff"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "AttenuationPerBlock"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "HFAttenuationPerBlock"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 13), "ShelterOpacity")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.reflectionCoeff, "ReflectionCoeff"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.reflectionCoeff);
        PacketIO.requireFinite(this.attenuationPerBlock, "AttenuationPerBlock"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.attenuationPerBlock);
        PacketIO.requireFinite(this.hFAttenuationPerBlock, "HFAttenuationPerBlock"); mem.set(PacketIO.PROTO_FLOAT, offset + 9, this.hFAttenuationPerBlock);
        PacketIO.requireFinite(this.shelterOpacity, "ShelterOpacity"); mem.set(PacketIO.PROTO_FLOAT, offset + 13, this.shelterOpacity);
        var varOffset = offset + 17;
        if (this.id != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 17;
        if (id != null) size += PacketIO.stringSize(id);

        return size;
    }

    public PhysicalMaterial clone() {
        PhysicalMaterial copy = new PhysicalMaterial();
        copy.id = this.id;
        copy.reflectionCoeff = this.reflectionCoeff;
        copy.attenuationPerBlock = this.attenuationPerBlock;
        copy.hFAttenuationPerBlock = this.hFAttenuationPerBlock;
        copy.shelterOpacity = this.shelterOpacity;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PhysicalMaterial other)) return false;
        return java.util.Objects.equals(this.id, other.id) && this.reflectionCoeff == other.reflectionCoeff && this.attenuationPerBlock == other.attenuationPerBlock && this.hFAttenuationPerBlock == other.hFAttenuationPerBlock && this.shelterOpacity == other.shelterOpacity;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, reflectionCoeff, attenuationPerBlock, hFAttenuationPerBlock, shelterOpacity);
    }

}