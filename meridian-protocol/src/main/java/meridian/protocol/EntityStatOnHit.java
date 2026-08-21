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


public class EntityStatOnHit {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 12;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 12;
    public static final int MAX_SIZE = 16384017;

    public int entityStatIndex;
    public float amount;
    @Nonnull public float[] multipliersPerEntitiesHit = new float[0];
    public float multiplierPerExtraEntityHit;

    public EntityStatOnHit() {
    }

    public EntityStatOnHit(int entityStatIndex, float amount, @Nonnull float[] multipliersPerEntitiesHit, float multiplierPerExtraEntityHit) {
        this.entityStatIndex = entityStatIndex;
        this.amount = amount;
        this.multipliersPerEntitiesHit = multipliersPerEntitiesHit;
        this.multiplierPerExtraEntityHit = multiplierPerExtraEntityHit;
    }

    public EntityStatOnHit(@Nonnull EntityStatOnHit other) {
        this.entityStatIndex = other.entityStatIndex;
        this.amount = other.amount;
        this.multipliersPerEntitiesHit = other.multipliersPerEntitiesHit;
        this.multiplierPerExtraEntityHit = other.multiplierPerExtraEntityHit;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("EntityStatOnHit", offset, (int) mem.byteSize());
        long needed = (long) offset + 12;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("EntityStatOnHit", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getEntityStatIndex(MemorySegment mem) {
        return getEntityStatIndex(mem, 0);
    }
    
    public static int getEntityStatIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static float getAmount(MemorySegment mem) {
        return getAmount(mem, 0);
    }
    
    public static float getAmount(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "Amount");
    }
    
    public static float[] getMultipliersPerEntitiesHit(MemorySegment mem) {
        return getMultipliersPerEntitiesHit(mem, 0);
    }
    
    public static float[] getMultipliersPerEntitiesHit(MemorySegment mem, int offset) {
        var off = offset + 12;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("MultipliersPerEntitiesHit");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("MultipliersPerEntitiesHit", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("MultipliersPerEntitiesHit", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new float[len];
        MemorySegment.copy(mem, PacketIO.PROTO_FLOAT, off, data, 0, len);
        return data;
    }
    
    public static float getMultiplierPerExtraEntityHit(MemorySegment mem) {
        return getMultiplierPerExtraEntityHit(mem, 0);
    }
    
    public static float getMultiplierPerExtraEntityHit(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "MultiplierPerExtraEntityHit");
    }
    
    
    
    
    
    public static EntityStatOnHit toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static EntityStatOnHit toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one EntityStatOnHit and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static EntityStatOnHit toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 12;
        var varPos = 0;
        float[] v2;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("MultipliersPerEntitiesHit");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("MultipliersPerEntitiesHit", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("MultipliersPerEntitiesHit", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new float[len];
            MemorySegment.copy(mem, PacketIO.PROTO_FLOAT, off, v2, 0, len);
            varPos = off + len * 4 - varBase;
        }
        var result = new EntityStatOnHit(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "Amount"),
            v2,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "MultiplierPerExtraEntityHit")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.entityStatIndex);
        PacketIO.requireFinite(this.amount, "Amount"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.amount);
        PacketIO.requireFinite(this.multiplierPerExtraEntityHit, "MultiplierPerExtraEntityHit"); mem.set(PacketIO.PROTO_FLOAT, offset + 8, this.multiplierPerExtraEntityHit);
        var varOffset = offset + 12;
        if (multipliersPerEntitiesHit.length > 4096000) throw ProtocolException.arrayTooLong("MultipliersPerEntitiesHit", multipliersPerEntitiesHit.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.multipliersPerEntitiesHit.length);
        
        MemorySegment.copy(this.multipliersPerEntitiesHit, 0, mem, PacketIO.PROTO_FLOAT, varOffset, this.multipliersPerEntitiesHit.length);
        varOffset += this.multipliersPerEntitiesHit.length * 4;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 12;
        size += VarInt.size(multipliersPerEntitiesHit.length) + multipliersPerEntitiesHit.length * 4;

        return size;
    }

    public EntityStatOnHit clone() {
        EntityStatOnHit copy = new EntityStatOnHit();
        copy.entityStatIndex = this.entityStatIndex;
        copy.amount = this.amount;
        copy.multipliersPerEntitiesHit = java.util.Arrays.copyOf(this.multipliersPerEntitiesHit, this.multipliersPerEntitiesHit.length);
        copy.multiplierPerExtraEntityHit = this.multiplierPerExtraEntityHit;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EntityStatOnHit other)) return false;
        return this.entityStatIndex == other.entityStatIndex && this.amount == other.amount && java.util.Arrays.equals(this.multipliersPerEntitiesHit, other.multipliersPerEntitiesHit) && this.multiplierPerExtraEntityHit == other.multiplierPerExtraEntityHit;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(entityStatIndex);
        result = 31 * result + Float.hashCode(amount);
        result = 31 * result + java.util.Arrays.hashCode(multipliersPerEntitiesHit);
        result = 31 * result + Float.hashCode(multiplierPerExtraEntityHit);
        return result;
    }

}