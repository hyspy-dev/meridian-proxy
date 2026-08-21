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


public class VelocityConfig {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 21;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 21;
    public static final int MAX_SIZE = 21;

    public float groundResistance;
    public float groundResistanceMax;
    public float airResistance;
    public float airResistanceMax;
    public float threshold;
    @Nonnull public VelocityThresholdStyle style = VelocityThresholdStyle.Linear;

    public VelocityConfig() {
    }

    public VelocityConfig(float groundResistance, float groundResistanceMax, float airResistance, float airResistanceMax, float threshold, @Nonnull VelocityThresholdStyle style) {
        this.groundResistance = groundResistance;
        this.groundResistanceMax = groundResistanceMax;
        this.airResistance = airResistance;
        this.airResistanceMax = airResistanceMax;
        this.threshold = threshold;
        this.style = style;
    }

    public VelocityConfig(@Nonnull VelocityConfig other) {
        this.groundResistance = other.groundResistance;
        this.groundResistanceMax = other.groundResistanceMax;
        this.airResistance = other.airResistance;
        this.airResistanceMax = other.airResistanceMax;
        this.threshold = other.threshold;
        this.style = other.style;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("VelocityConfig", offset, (int) mem.byteSize());
        long needed = (long) offset + 21;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("VelocityConfig", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getGroundResistance(MemorySegment mem) {
        return getGroundResistance(mem, 0);
    }
    
    public static float getGroundResistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "GroundResistance");
    }
    
    public static float getGroundResistanceMax(MemorySegment mem) {
        return getGroundResistanceMax(mem, 0);
    }
    
    public static float getGroundResistanceMax(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "GroundResistanceMax");
    }
    
    public static float getAirResistance(MemorySegment mem) {
        return getAirResistance(mem, 0);
    }
    
    public static float getAirResistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "AirResistance");
    }
    
    public static float getAirResistanceMax(MemorySegment mem) {
        return getAirResistanceMax(mem, 0);
    }
    
    public static float getAirResistanceMax(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "AirResistanceMax");
    }
    
    public static float getThreshold(MemorySegment mem) {
        return getThreshold(mem, 0);
    }
    
    public static float getThreshold(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "Threshold");
    }
    
    public static VelocityThresholdStyle getStyle(MemorySegment mem) {
        return getStyle(mem, 0);
    }
    
    public static VelocityThresholdStyle getStyle(MemorySegment mem, int offset) {
        return VelocityThresholdStyle.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 20));
    }
    
    
    
    
    
    public static VelocityConfig toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static VelocityConfig toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one VelocityConfig and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static VelocityConfig toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new VelocityConfig(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "GroundResistance"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "GroundResistanceMax"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "AirResistance"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "AirResistanceMax"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "Threshold"),
            VelocityThresholdStyle.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 20))
        );
        if (cursor != null) cursor.position = offset + 21;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.groundResistance, "GroundResistance"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.groundResistance);
        PacketIO.requireFinite(this.groundResistanceMax, "GroundResistanceMax"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.groundResistanceMax);
        PacketIO.requireFinite(this.airResistance, "AirResistance"); mem.set(PacketIO.PROTO_FLOAT, offset + 8, this.airResistance);
        PacketIO.requireFinite(this.airResistanceMax, "AirResistanceMax"); mem.set(PacketIO.PROTO_FLOAT, offset + 12, this.airResistanceMax);
        PacketIO.requireFinite(this.threshold, "Threshold"); mem.set(PacketIO.PROTO_FLOAT, offset + 16, this.threshold);
        mem.set(PacketIO.PROTO_BYTE, offset + 20, (byte) this.style.getValue());
        
        
    
       return 21;
    }
    public int computeSize() {
        return 21;
    }

    public VelocityConfig clone() {
        VelocityConfig copy = new VelocityConfig();
        copy.groundResistance = this.groundResistance;
        copy.groundResistanceMax = this.groundResistanceMax;
        copy.airResistance = this.airResistance;
        copy.airResistanceMax = this.airResistanceMax;
        copy.threshold = this.threshold;
        copy.style = this.style;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof VelocityConfig other)) return false;
        return this.groundResistance == other.groundResistance && this.groundResistanceMax == other.groundResistanceMax && this.airResistance == other.airResistance && this.airResistanceMax == other.airResistanceMax && this.threshold == other.threshold && java.util.Objects.equals(this.style, other.style);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(groundResistance, groundResistanceMax, airResistance, airResistanceMax, threshold, style);
    }

}