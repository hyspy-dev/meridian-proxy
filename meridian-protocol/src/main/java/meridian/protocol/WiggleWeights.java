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


public class WiggleWeights {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 40;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 40;
    public static final int MAX_SIZE = 40;

    public float x;
    public float xDeceleration;
    public float y;
    public float yDeceleration;
    public float z;
    public float zDeceleration;
    public float roll;
    public float rollDeceleration;
    public float pitch;
    public float pitchDeceleration;

    public WiggleWeights() {
    }

    public WiggleWeights(float x, float xDeceleration, float y, float yDeceleration, float z, float zDeceleration, float roll, float rollDeceleration, float pitch, float pitchDeceleration) {
        this.x = x;
        this.xDeceleration = xDeceleration;
        this.y = y;
        this.yDeceleration = yDeceleration;
        this.z = z;
        this.zDeceleration = zDeceleration;
        this.roll = roll;
        this.rollDeceleration = rollDeceleration;
        this.pitch = pitch;
        this.pitchDeceleration = pitchDeceleration;
    }

    public WiggleWeights(@Nonnull WiggleWeights other) {
        this.x = other.x;
        this.xDeceleration = other.xDeceleration;
        this.y = other.y;
        this.yDeceleration = other.yDeceleration;
        this.z = other.z;
        this.zDeceleration = other.zDeceleration;
        this.roll = other.roll;
        this.rollDeceleration = other.rollDeceleration;
        this.pitch = other.pitch;
        this.pitchDeceleration = other.pitchDeceleration;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("WiggleWeights", offset, (int) mem.byteSize());
        long needed = (long) offset + 40;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("WiggleWeights", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getX(MemorySegment mem) {
        return getX(mem, 0);
    }
    
    public static float getX(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "X");
    }
    
    public static float getXDeceleration(MemorySegment mem) {
        return getXDeceleration(mem, 0);
    }
    
    public static float getXDeceleration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "XDeceleration");
    }
    
    public static float getY(MemorySegment mem) {
        return getY(mem, 0);
    }
    
    public static float getY(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "Y");
    }
    
    public static float getYDeceleration(MemorySegment mem) {
        return getYDeceleration(mem, 0);
    }
    
    public static float getYDeceleration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "YDeceleration");
    }
    
    public static float getZ(MemorySegment mem) {
        return getZ(mem, 0);
    }
    
    public static float getZ(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "Z");
    }
    
    public static float getZDeceleration(MemorySegment mem) {
        return getZDeceleration(mem, 0);
    }
    
    public static float getZDeceleration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "ZDeceleration");
    }
    
    public static float getRoll(MemorySegment mem) {
        return getRoll(mem, 0);
    }
    
    public static float getRoll(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 24), "Roll");
    }
    
    public static float getRollDeceleration(MemorySegment mem) {
        return getRollDeceleration(mem, 0);
    }
    
    public static float getRollDeceleration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 28), "RollDeceleration");
    }
    
    public static float getPitch(MemorySegment mem) {
        return getPitch(mem, 0);
    }
    
    public static float getPitch(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 32), "Pitch");
    }
    
    public static float getPitchDeceleration(MemorySegment mem) {
        return getPitchDeceleration(mem, 0);
    }
    
    public static float getPitchDeceleration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 36), "PitchDeceleration");
    }
    
    
    
    
    
    public static WiggleWeights toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static WiggleWeights toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one WiggleWeights and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static WiggleWeights toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new WiggleWeights(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "X"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "XDeceleration"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "Y"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "YDeceleration"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "Z"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "ZDeceleration"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 24), "Roll"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 28), "RollDeceleration"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 32), "Pitch"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 36), "PitchDeceleration")
        );
        if (cursor != null) cursor.position = offset + 40;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.x, "X"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.x);
        PacketIO.requireFinite(this.xDeceleration, "XDeceleration"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.xDeceleration);
        PacketIO.requireFinite(this.y, "Y"); mem.set(PacketIO.PROTO_FLOAT, offset + 8, this.y);
        PacketIO.requireFinite(this.yDeceleration, "YDeceleration"); mem.set(PacketIO.PROTO_FLOAT, offset + 12, this.yDeceleration);
        PacketIO.requireFinite(this.z, "Z"); mem.set(PacketIO.PROTO_FLOAT, offset + 16, this.z);
        PacketIO.requireFinite(this.zDeceleration, "ZDeceleration"); mem.set(PacketIO.PROTO_FLOAT, offset + 20, this.zDeceleration);
        PacketIO.requireFinite(this.roll, "Roll"); mem.set(PacketIO.PROTO_FLOAT, offset + 24, this.roll);
        PacketIO.requireFinite(this.rollDeceleration, "RollDeceleration"); mem.set(PacketIO.PROTO_FLOAT, offset + 28, this.rollDeceleration);
        PacketIO.requireFinite(this.pitch, "Pitch"); mem.set(PacketIO.PROTO_FLOAT, offset + 32, this.pitch);
        PacketIO.requireFinite(this.pitchDeceleration, "PitchDeceleration"); mem.set(PacketIO.PROTO_FLOAT, offset + 36, this.pitchDeceleration);
        
        
    
       return 40;
    }
    public int computeSize() {
        return 40;
    }

    public WiggleWeights clone() {
        WiggleWeights copy = new WiggleWeights();
        copy.x = this.x;
        copy.xDeceleration = this.xDeceleration;
        copy.y = this.y;
        copy.yDeceleration = this.yDeceleration;
        copy.z = this.z;
        copy.zDeceleration = this.zDeceleration;
        copy.roll = this.roll;
        copy.rollDeceleration = this.rollDeceleration;
        copy.pitch = this.pitch;
        copy.pitchDeceleration = this.pitchDeceleration;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof WiggleWeights other)) return false;
        return this.x == other.x && this.xDeceleration == other.xDeceleration && this.y == other.y && this.yDeceleration == other.yDeceleration && this.z == other.z && this.zDeceleration == other.zDeceleration && this.roll == other.roll && this.rollDeceleration == other.rollDeceleration && this.pitch == other.pitch && this.pitchDeceleration == other.pitchDeceleration;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, xDeceleration, y, yDeceleration, z, zDeceleration, roll, rollDeceleration, pitch, pitchDeceleration);
    }

}