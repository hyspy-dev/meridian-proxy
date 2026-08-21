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


public class FogOptions {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 18;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 18;
    public static final int MAX_SIZE = 18;

    public boolean ignoreFogLimits;
    public float effectiveViewDistanceMultiplier;
    public float fogFarViewDistance;
    public float fogHeightCameraOffset;
    public boolean fogHeightCameraOverriden;
    public float fogHeightCameraFixed;

    public FogOptions() {
    }

    public FogOptions(boolean ignoreFogLimits, float effectiveViewDistanceMultiplier, float fogFarViewDistance, float fogHeightCameraOffset, boolean fogHeightCameraOverriden, float fogHeightCameraFixed) {
        this.ignoreFogLimits = ignoreFogLimits;
        this.effectiveViewDistanceMultiplier = effectiveViewDistanceMultiplier;
        this.fogFarViewDistance = fogFarViewDistance;
        this.fogHeightCameraOffset = fogHeightCameraOffset;
        this.fogHeightCameraOverriden = fogHeightCameraOverriden;
        this.fogHeightCameraFixed = fogHeightCameraFixed;
    }

    public FogOptions(@Nonnull FogOptions other) {
        this.ignoreFogLimits = other.ignoreFogLimits;
        this.effectiveViewDistanceMultiplier = other.effectiveViewDistanceMultiplier;
        this.fogFarViewDistance = other.fogFarViewDistance;
        this.fogHeightCameraOffset = other.fogHeightCameraOffset;
        this.fogHeightCameraOverriden = other.fogHeightCameraOverriden;
        this.fogHeightCameraFixed = other.fogHeightCameraFixed;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("FogOptions", offset, (int) mem.byteSize());
        long needed = (long) offset + 18;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("FogOptions", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getIgnoreFogLimits(MemorySegment mem) {
        return getIgnoreFogLimits(mem, 0);
    }
    
    public static boolean getIgnoreFogLimits(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 0);
    }
    
    public static float getEffectiveViewDistanceMultiplier(MemorySegment mem) {
        return getEffectiveViewDistanceMultiplier(mem, 0);
    }
    
    public static float getEffectiveViewDistanceMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "EffectiveViewDistanceMultiplier");
    }
    
    public static float getFogFarViewDistance(MemorySegment mem) {
        return getFogFarViewDistance(mem, 0);
    }
    
    public static float getFogFarViewDistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "FogFarViewDistance");
    }
    
    public static float getFogHeightCameraOffset(MemorySegment mem) {
        return getFogHeightCameraOffset(mem, 0);
    }
    
    public static float getFogHeightCameraOffset(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "FogHeightCameraOffset");
    }
    
    public static boolean getFogHeightCameraOverriden(MemorySegment mem) {
        return getFogHeightCameraOverriden(mem, 0);
    }
    
    public static boolean getFogHeightCameraOverriden(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 13);
    }
    
    public static float getFogHeightCameraFixed(MemorySegment mem) {
        return getFogHeightCameraFixed(mem, 0);
    }
    
    public static float getFogHeightCameraFixed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 14), "FogHeightCameraFixed");
    }
    
    
    
    
    
    public static FogOptions toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static FogOptions toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one FogOptions and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static FogOptions toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new FogOptions(
            mem.get(PacketIO.PROTO_BOOL, offset + 0),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "EffectiveViewDistanceMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "FogFarViewDistance"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "FogHeightCameraOffset"),
            mem.get(PacketIO.PROTO_BOOL, offset + 13),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 14), "FogHeightCameraFixed")
        );
        if (cursor != null) cursor.position = offset + 18;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BOOL, offset + 0, this.ignoreFogLimits);
        PacketIO.requireFinite(this.effectiveViewDistanceMultiplier, "EffectiveViewDistanceMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.effectiveViewDistanceMultiplier);
        PacketIO.requireFinite(this.fogFarViewDistance, "FogFarViewDistance"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.fogFarViewDistance);
        PacketIO.requireFinite(this.fogHeightCameraOffset, "FogHeightCameraOffset"); mem.set(PacketIO.PROTO_FLOAT, offset + 9, this.fogHeightCameraOffset);
        mem.set(PacketIO.PROTO_BOOL, offset + 13, this.fogHeightCameraOverriden);
        PacketIO.requireFinite(this.fogHeightCameraFixed, "FogHeightCameraFixed"); mem.set(PacketIO.PROTO_FLOAT, offset + 14, this.fogHeightCameraFixed);
        
        
    
       return 18;
    }
    public int computeSize() {
        return 18;
    }

    public FogOptions clone() {
        FogOptions copy = new FogOptions();
        copy.ignoreFogLimits = this.ignoreFogLimits;
        copy.effectiveViewDistanceMultiplier = this.effectiveViewDistanceMultiplier;
        copy.fogFarViewDistance = this.fogFarViewDistance;
        copy.fogHeightCameraOffset = this.fogHeightCameraOffset;
        copy.fogHeightCameraOverriden = this.fogHeightCameraOverriden;
        copy.fogHeightCameraFixed = this.fogHeightCameraFixed;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FogOptions other)) return false;
        return this.ignoreFogLimits == other.ignoreFogLimits && this.effectiveViewDistanceMultiplier == other.effectiveViewDistanceMultiplier && this.fogFarViewDistance == other.fogFarViewDistance && this.fogHeightCameraOffset == other.fogHeightCameraOffset && this.fogHeightCameraOverriden == other.fogHeightCameraOverriden && this.fogHeightCameraFixed == other.fogHeightCameraFixed;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(ignoreFogLimits, effectiveViewDistanceMultiplier, fogFarViewDistance, fogHeightCameraOffset, fogHeightCameraOverriden, fogHeightCameraFixed);
    }

}