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


public class CameraShakeConfig {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 19;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 27;
    public static final int MAX_SIZE = 540672081;

    public float duration;
    public float startTime;
    public boolean continuous;
    @Nonnull public EasingConfig easeIn = new EasingConfig();
    @Nonnull public EasingConfig easeOut = new EasingConfig();
    @Nonnull public OffsetNoise offset = new OffsetNoise();
    @Nonnull public RotationNoise rotation = new RotationNoise();

    public CameraShakeConfig() {
    }

    public CameraShakeConfig(float duration, float startTime, boolean continuous, @Nonnull EasingConfig easeIn, @Nonnull EasingConfig easeOut, @Nonnull OffsetNoise offset, @Nonnull RotationNoise rotation) {
        this.duration = duration;
        this.startTime = startTime;
        this.continuous = continuous;
        this.easeIn = easeIn;
        this.easeOut = easeOut;
        this.offset = offset;
        this.rotation = rotation;
    }

    public CameraShakeConfig(@Nonnull CameraShakeConfig other) {
        this.duration = other.duration;
        this.startTime = other.startTime;
        this.continuous = other.continuous;
        this.easeIn = other.easeIn;
        this.easeOut = other.easeOut;
        this.offset = other.offset;
        this.rotation = other.rotation;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CameraShakeConfig", offset, (int) mem.byteSize());
        long needed = (long) offset + 27;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CameraShakeConfig", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getDuration(MemorySegment mem) {
        return getDuration(mem, 0);
    }
    
    public static float getDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "Duration");
    }
    
    public static float getStartTime(MemorySegment mem) {
        return getStartTime(mem, 0);
    }
    
    public static float getStartTime(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "StartTime");
    }
    
    public static boolean getContinuous(MemorySegment mem) {
        return getContinuous(mem, 0);
    }
    
    public static boolean getContinuous(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 8);
    }
    
    public static EasingConfig getEaseIn(MemorySegment mem) {
        return getEaseIn(mem, 0);
    }
    
    public static EasingConfig getEaseIn(MemorySegment mem, int offset) {
        return EasingConfig.toObject(mem, offset + 9);
    }
    
    public static EasingConfig getEaseOut(MemorySegment mem) {
        return getEaseOut(mem, 0);
    }
    
    public static EasingConfig getEaseOut(MemorySegment mem, int offset) {
        return EasingConfig.toObject(mem, offset + 14);
    }
    
    public static OffsetNoise getOffset(MemorySegment mem) {
        return getOffset(mem, 0);
    }
    
    public static OffsetNoise getOffset(MemorySegment mem, int offset) {
        return OffsetNoise.toObject(mem, offset + getValidatedOffset(mem, offset, 19, 27, "Offset"));
    }
    
    public static RotationNoise getRotation(MemorySegment mem) {
        return getRotation(mem, 0);
    }
    
    public static RotationNoise getRotation(MemorySegment mem, int offset) {
        return RotationNoise.toObject(mem, offset + getValidatedOffset(mem, offset, 23, 27, "Rotation"));
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
    
    public static CameraShakeConfig toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CameraShakeConfig toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CameraShakeConfig and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CameraShakeConfig toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 27;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        OffsetNoise v5;
        requireSlot(mem, offset + 19, varPos, "Offset");
        {
            v5 = OffsetNoise.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        
        RotationNoise v6;
        requireSlot(mem, offset + 23, varPos, "Rotation");
        {
            v6 = RotationNoise.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new CameraShakeConfig(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "Duration"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "StartTime"),
            mem.get(PacketIO.PROTO_BOOL, offset + 8),
            EasingConfig.toObject(mem, offset + 9),
            EasingConfig.toObject(mem, offset + 14),
            v5,
            v6
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.duration, "Duration"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.duration);
        PacketIO.requireFinite(this.startTime, "StartTime"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.startTime);
        mem.set(PacketIO.PROTO_BOOL, offset + 8, this.continuous);
        this.easeIn.serialize(mem, offset + 9);
        this.easeOut.serialize(mem, offset + 14);
        var varOffset = offset + 27;
        mem.set(PacketIO.PROTO_INT, offset + 19, varOffset - offset - 27);
        varOffset += this.offset.serialize(mem, varOffset);
        mem.set(PacketIO.PROTO_INT, offset + 23, varOffset - offset - 27);
        varOffset += this.rotation.serialize(mem, varOffset);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 27;
        size += offset.computeSize();
    size += rotation.computeSize();

        return size;
    }

    public CameraShakeConfig clone() {
        CameraShakeConfig copy = new CameraShakeConfig();
        copy.duration = this.duration;
        copy.startTime = this.startTime;
        copy.continuous = this.continuous;
        copy.easeIn = this.easeIn.clone();
        copy.easeOut = this.easeOut.clone();
        copy.offset = this.offset.clone();
        copy.rotation = this.rotation.clone();
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CameraShakeConfig other)) return false;
        return this.duration == other.duration && this.startTime == other.startTime && this.continuous == other.continuous && java.util.Objects.equals(this.easeIn, other.easeIn) && java.util.Objects.equals(this.easeOut, other.easeOut) && java.util.Objects.equals(this.offset, other.offset) && java.util.Objects.equals(this.rotation, other.rotation);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(duration, startTime, continuous, easeIn, easeOut, offset, rotation);
    }

}