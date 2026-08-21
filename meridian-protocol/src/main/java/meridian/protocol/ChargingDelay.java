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


public class ChargingDelay {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 20;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 20;
    public static final int MAX_SIZE = 20;

    public float minDelay;
    public float maxDelay;
    public float maxTotalDelay;
    public float minHealth;
    public float maxHealth;

    public ChargingDelay() {
    }

    public ChargingDelay(float minDelay, float maxDelay, float maxTotalDelay, float minHealth, float maxHealth) {
        this.minDelay = minDelay;
        this.maxDelay = maxDelay;
        this.maxTotalDelay = maxTotalDelay;
        this.minHealth = minHealth;
        this.maxHealth = maxHealth;
    }

    public ChargingDelay(@Nonnull ChargingDelay other) {
        this.minDelay = other.minDelay;
        this.maxDelay = other.maxDelay;
        this.maxTotalDelay = other.maxTotalDelay;
        this.minHealth = other.minHealth;
        this.maxHealth = other.maxHealth;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ChargingDelay", offset, (int) mem.byteSize());
        long needed = (long) offset + 20;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ChargingDelay", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getMinDelay(MemorySegment mem) {
        return getMinDelay(mem, 0);
    }
    
    public static float getMinDelay(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "MinDelay");
    }
    
    public static float getMaxDelay(MemorySegment mem) {
        return getMaxDelay(mem, 0);
    }
    
    public static float getMaxDelay(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "MaxDelay");
    }
    
    public static float getMaxTotalDelay(MemorySegment mem) {
        return getMaxTotalDelay(mem, 0);
    }
    
    public static float getMaxTotalDelay(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "MaxTotalDelay");
    }
    
    public static float getMinHealth(MemorySegment mem) {
        return getMinHealth(mem, 0);
    }
    
    public static float getMinHealth(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "MinHealth");
    }
    
    public static float getMaxHealth(MemorySegment mem) {
        return getMaxHealth(mem, 0);
    }
    
    public static float getMaxHealth(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "MaxHealth");
    }
    
    
    
    
    
    public static ChargingDelay toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ChargingDelay toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ChargingDelay and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ChargingDelay toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new ChargingDelay(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "MinDelay"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "MaxDelay"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "MaxTotalDelay"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "MinHealth"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "MaxHealth")
        );
        if (cursor != null) cursor.position = offset + 20;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.minDelay, "MinDelay"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.minDelay);
        PacketIO.requireFinite(this.maxDelay, "MaxDelay"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.maxDelay);
        PacketIO.requireFinite(this.maxTotalDelay, "MaxTotalDelay"); mem.set(PacketIO.PROTO_FLOAT, offset + 8, this.maxTotalDelay);
        PacketIO.requireFinite(this.minHealth, "MinHealth"); mem.set(PacketIO.PROTO_FLOAT, offset + 12, this.minHealth);
        PacketIO.requireFinite(this.maxHealth, "MaxHealth"); mem.set(PacketIO.PROTO_FLOAT, offset + 16, this.maxHealth);
        
        
    
       return 20;
    }
    public int computeSize() {
        return 20;
    }

    public ChargingDelay clone() {
        ChargingDelay copy = new ChargingDelay();
        copy.minDelay = this.minDelay;
        copy.maxDelay = this.maxDelay;
        copy.maxTotalDelay = this.maxTotalDelay;
        copy.minHealth = this.minHealth;
        copy.maxHealth = this.maxHealth;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ChargingDelay other)) return false;
        return this.minDelay == other.minDelay && this.maxDelay == other.maxDelay && this.maxTotalDelay == other.maxTotalDelay && this.minHealth == other.minHealth && this.maxHealth == other.maxHealth;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(minDelay, maxDelay, maxTotalDelay, minHealth, maxHealth);
    }

}