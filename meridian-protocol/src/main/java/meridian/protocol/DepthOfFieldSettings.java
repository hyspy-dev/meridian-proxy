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


public class DepthOfFieldSettings {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 24;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 24;
    public static final int MAX_SIZE = 24;

    public float nearBlurry;
    public float nearSharp;
    public float farSharp;
    public float farBlurry;
    public float nearBlurMax;
    public float farBlurMax;

    public DepthOfFieldSettings() {
    }

    public DepthOfFieldSettings(float nearBlurry, float nearSharp, float farSharp, float farBlurry, float nearBlurMax, float farBlurMax) {
        this.nearBlurry = nearBlurry;
        this.nearSharp = nearSharp;
        this.farSharp = farSharp;
        this.farBlurry = farBlurry;
        this.nearBlurMax = nearBlurMax;
        this.farBlurMax = farBlurMax;
    }

    public DepthOfFieldSettings(@Nonnull DepthOfFieldSettings other) {
        this.nearBlurry = other.nearBlurry;
        this.nearSharp = other.nearSharp;
        this.farSharp = other.farSharp;
        this.farBlurry = other.farBlurry;
        this.nearBlurMax = other.nearBlurMax;
        this.farBlurMax = other.farBlurMax;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("DepthOfFieldSettings", offset, (int) mem.byteSize());
        long needed = (long) offset + 24;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("DepthOfFieldSettings", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getNearBlurry(MemorySegment mem) {
        return getNearBlurry(mem, 0);
    }
    
    public static float getNearBlurry(MemorySegment mem, int offset) {
        var value = PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "NearBlurry");
        if (value < 0) throw ProtocolException.valueBelowMinimum("NearBlurry", value, 0);
        return value;
    }
    
    public static float getNearSharp(MemorySegment mem) {
        return getNearSharp(mem, 0);
    }
    
    public static float getNearSharp(MemorySegment mem, int offset) {
        var value = PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "NearSharp");
        if (value < 0) throw ProtocolException.valueBelowMinimum("NearSharp", value, 0);
        return value;
    }
    
    public static float getFarSharp(MemorySegment mem) {
        return getFarSharp(mem, 0);
    }
    
    public static float getFarSharp(MemorySegment mem, int offset) {
        var value = PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "FarSharp");
        if (value < 0) throw ProtocolException.valueBelowMinimum("FarSharp", value, 0);
        return value;
    }
    
    public static float getFarBlurry(MemorySegment mem) {
        return getFarBlurry(mem, 0);
    }
    
    public static float getFarBlurry(MemorySegment mem, int offset) {
        var value = PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "FarBlurry");
        if (value < 0) throw ProtocolException.valueBelowMinimum("FarBlurry", value, 0);
        return value;
    }
    
    public static float getNearBlurMax(MemorySegment mem) {
        return getNearBlurMax(mem, 0);
    }
    
    public static float getNearBlurMax(MemorySegment mem, int offset) {
        var value = PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "NearBlurMax");
        if (value < 0 || value > 1) throw ProtocolException.valueOutOfRange("NearBlurMax", value, 0, 1);
        return value;
    }
    
    public static float getFarBlurMax(MemorySegment mem) {
        return getFarBlurMax(mem, 0);
    }
    
    public static float getFarBlurMax(MemorySegment mem, int offset) {
        var value = PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "FarBlurMax");
        if (value < 0 || value > 1) throw ProtocolException.valueOutOfRange("FarBlurMax", value, 0, 1);
        return value;
    }
    
    
    
    
    
    public static DepthOfFieldSettings toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static DepthOfFieldSettings toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one DepthOfFieldSettings and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static DepthOfFieldSettings toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        float v0 = PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "NearBlurry");
        if (v0 < 0) throw ProtocolException.valueBelowMinimum("NearBlurry", v0, 0);
        
        float v1 = PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "NearSharp");
        if (v1 < 0) throw ProtocolException.valueBelowMinimum("NearSharp", v1, 0);
        
        float v2 = PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "FarSharp");
        if (v2 < 0) throw ProtocolException.valueBelowMinimum("FarSharp", v2, 0);
        
        float v3 = PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "FarBlurry");
        if (v3 < 0) throw ProtocolException.valueBelowMinimum("FarBlurry", v3, 0);
        
        float v4 = PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "NearBlurMax");
        if (v4 < 0 || v4 > 1) throw ProtocolException.valueOutOfRange("NearBlurMax", v4, 0, 1);
        
        float v5 = PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "FarBlurMax");
        if (v5 < 0 || v5 > 1) throw ProtocolException.valueOutOfRange("FarBlurMax", v5, 0, 1);
        var result = new DepthOfFieldSettings(
            v0,
            v1,
            v2,
            v3,
            v4,
            v5
        );
        if (cursor != null) cursor.position = offset + 24;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        if (this.nearBlurry < 0) throw ProtocolException.valueBelowMinimum("NearBlurry", this.nearBlurry, 0); PacketIO.requireFinite(this.nearBlurry, "NearBlurry"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.nearBlurry);
        if (this.nearSharp < 0) throw ProtocolException.valueBelowMinimum("NearSharp", this.nearSharp, 0); PacketIO.requireFinite(this.nearSharp, "NearSharp"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.nearSharp);
        if (this.farSharp < 0) throw ProtocolException.valueBelowMinimum("FarSharp", this.farSharp, 0); PacketIO.requireFinite(this.farSharp, "FarSharp"); mem.set(PacketIO.PROTO_FLOAT, offset + 8, this.farSharp);
        if (this.farBlurry < 0) throw ProtocolException.valueBelowMinimum("FarBlurry", this.farBlurry, 0); PacketIO.requireFinite(this.farBlurry, "FarBlurry"); mem.set(PacketIO.PROTO_FLOAT, offset + 12, this.farBlurry);
        if (this.nearBlurMax < 0 || this.nearBlurMax > 1) throw ProtocolException.valueOutOfRange("NearBlurMax", this.nearBlurMax, 0, 1); PacketIO.requireFinite(this.nearBlurMax, "NearBlurMax"); mem.set(PacketIO.PROTO_FLOAT, offset + 16, this.nearBlurMax);
        if (this.farBlurMax < 0 || this.farBlurMax > 1) throw ProtocolException.valueOutOfRange("FarBlurMax", this.farBlurMax, 0, 1); PacketIO.requireFinite(this.farBlurMax, "FarBlurMax"); mem.set(PacketIO.PROTO_FLOAT, offset + 20, this.farBlurMax);
        
        
    
       return 24;
    }
    public int computeSize() {
        return 24;
    }

    public DepthOfFieldSettings clone() {
        DepthOfFieldSettings copy = new DepthOfFieldSettings();
        copy.nearBlurry = this.nearBlurry;
        copy.nearSharp = this.nearSharp;
        copy.farSharp = this.farSharp;
        copy.farBlurry = this.farBlurry;
        copy.nearBlurMax = this.nearBlurMax;
        copy.farBlurMax = this.farBlurMax;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DepthOfFieldSettings other)) return false;
        return this.nearBlurry == other.nearBlurry && this.nearSharp == other.nearSharp && this.farSharp == other.farSharp && this.farBlurry == other.farBlurry && this.nearBlurMax == other.nearBlurMax && this.farBlurMax == other.farBlurMax;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(nearBlurry, nearSharp, farSharp, farBlurry, nearBlurMax, farBlurMax);
    }

}