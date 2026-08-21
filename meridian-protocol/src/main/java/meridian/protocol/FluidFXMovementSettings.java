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


public class FluidFXMovementSettings {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 24;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 24;
    public static final int MAX_SIZE = 24;

    public float swimUpSpeed;
    public float swimDownSpeed;
    public float sinkSpeed;
    public float horizontalSpeedMultiplier;
    public float fieldOfViewMultiplier;
    public float entryVelocityMultiplier;

    public FluidFXMovementSettings() {
    }

    public FluidFXMovementSettings(float swimUpSpeed, float swimDownSpeed, float sinkSpeed, float horizontalSpeedMultiplier, float fieldOfViewMultiplier, float entryVelocityMultiplier) {
        this.swimUpSpeed = swimUpSpeed;
        this.swimDownSpeed = swimDownSpeed;
        this.sinkSpeed = sinkSpeed;
        this.horizontalSpeedMultiplier = horizontalSpeedMultiplier;
        this.fieldOfViewMultiplier = fieldOfViewMultiplier;
        this.entryVelocityMultiplier = entryVelocityMultiplier;
    }

    public FluidFXMovementSettings(@Nonnull FluidFXMovementSettings other) {
        this.swimUpSpeed = other.swimUpSpeed;
        this.swimDownSpeed = other.swimDownSpeed;
        this.sinkSpeed = other.sinkSpeed;
        this.horizontalSpeedMultiplier = other.horizontalSpeedMultiplier;
        this.fieldOfViewMultiplier = other.fieldOfViewMultiplier;
        this.entryVelocityMultiplier = other.entryVelocityMultiplier;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("FluidFXMovementSettings", offset, (int) mem.byteSize());
        long needed = (long) offset + 24;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("FluidFXMovementSettings", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getSwimUpSpeed(MemorySegment mem) {
        return getSwimUpSpeed(mem, 0);
    }
    
    public static float getSwimUpSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "SwimUpSpeed");
    }
    
    public static float getSwimDownSpeed(MemorySegment mem) {
        return getSwimDownSpeed(mem, 0);
    }
    
    public static float getSwimDownSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "SwimDownSpeed");
    }
    
    public static float getSinkSpeed(MemorySegment mem) {
        return getSinkSpeed(mem, 0);
    }
    
    public static float getSinkSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "SinkSpeed");
    }
    
    public static float getHorizontalSpeedMultiplier(MemorySegment mem) {
        return getHorizontalSpeedMultiplier(mem, 0);
    }
    
    public static float getHorizontalSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "HorizontalSpeedMultiplier");
    }
    
    public static float getFieldOfViewMultiplier(MemorySegment mem) {
        return getFieldOfViewMultiplier(mem, 0);
    }
    
    public static float getFieldOfViewMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "FieldOfViewMultiplier");
    }
    
    public static float getEntryVelocityMultiplier(MemorySegment mem) {
        return getEntryVelocityMultiplier(mem, 0);
    }
    
    public static float getEntryVelocityMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "EntryVelocityMultiplier");
    }
    
    
    
    
    
    public static FluidFXMovementSettings toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static FluidFXMovementSettings toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one FluidFXMovementSettings and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static FluidFXMovementSettings toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new FluidFXMovementSettings(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "SwimUpSpeed"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "SwimDownSpeed"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "SinkSpeed"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "HorizontalSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "FieldOfViewMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "EntryVelocityMultiplier")
        );
        if (cursor != null) cursor.position = offset + 24;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.swimUpSpeed, "SwimUpSpeed"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.swimUpSpeed);
        PacketIO.requireFinite(this.swimDownSpeed, "SwimDownSpeed"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.swimDownSpeed);
        PacketIO.requireFinite(this.sinkSpeed, "SinkSpeed"); mem.set(PacketIO.PROTO_FLOAT, offset + 8, this.sinkSpeed);
        PacketIO.requireFinite(this.horizontalSpeedMultiplier, "HorizontalSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 12, this.horizontalSpeedMultiplier);
        PacketIO.requireFinite(this.fieldOfViewMultiplier, "FieldOfViewMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 16, this.fieldOfViewMultiplier);
        PacketIO.requireFinite(this.entryVelocityMultiplier, "EntryVelocityMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 20, this.entryVelocityMultiplier);
        
        
    
       return 24;
    }
    public int computeSize() {
        return 24;
    }

    public FluidFXMovementSettings clone() {
        FluidFXMovementSettings copy = new FluidFXMovementSettings();
        copy.swimUpSpeed = this.swimUpSpeed;
        copy.swimDownSpeed = this.swimDownSpeed;
        copy.sinkSpeed = this.sinkSpeed;
        copy.horizontalSpeedMultiplier = this.horizontalSpeedMultiplier;
        copy.fieldOfViewMultiplier = this.fieldOfViewMultiplier;
        copy.entryVelocityMultiplier = this.entryVelocityMultiplier;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FluidFXMovementSettings other)) return false;
        return this.swimUpSpeed == other.swimUpSpeed && this.swimDownSpeed == other.swimDownSpeed && this.sinkSpeed == other.sinkSpeed && this.horizontalSpeedMultiplier == other.horizontalSpeedMultiplier && this.fieldOfViewMultiplier == other.fieldOfViewMultiplier && this.entryVelocityMultiplier == other.entryVelocityMultiplier;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(swimUpSpeed, swimDownSpeed, sinkSpeed, horizontalSpeedMultiplier, fieldOfViewMultiplier, entryVelocityMultiplier);
    }

}