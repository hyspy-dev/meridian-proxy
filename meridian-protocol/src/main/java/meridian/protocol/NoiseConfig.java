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


public class NoiseConfig {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 22;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 22;
    public static final int MAX_SIZE = 22;

    public int seed;
    @Nonnull public NoiseType type = NoiseType.Sin;
    public float frequency;
    public float amplitude;
    @Nonnull public ClampConfig clamp = new ClampConfig();

    public NoiseConfig() {
    }

    public NoiseConfig(int seed, @Nonnull NoiseType type, float frequency, float amplitude, @Nonnull ClampConfig clamp) {
        this.seed = seed;
        this.type = type;
        this.frequency = frequency;
        this.amplitude = amplitude;
        this.clamp = clamp;
    }

    public NoiseConfig(@Nonnull NoiseConfig other) {
        this.seed = other.seed;
        this.type = other.type;
        this.frequency = other.frequency;
        this.amplitude = other.amplitude;
        this.clamp = other.clamp;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("NoiseConfig", offset, (int) mem.byteSize());
        long needed = (long) offset + 22;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("NoiseConfig", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getSeed(MemorySegment mem) {
        return getSeed(mem, 0);
    }
    
    public static int getSeed(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static NoiseType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static NoiseType getType(MemorySegment mem, int offset) {
        return NoiseType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 4));
    }
    
    public static float getFrequency(MemorySegment mem) {
        return getFrequency(mem, 0);
    }
    
    public static float getFrequency(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "Frequency");
    }
    
    public static float getAmplitude(MemorySegment mem) {
        return getAmplitude(mem, 0);
    }
    
    public static float getAmplitude(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "Amplitude");
    }
    
    public static ClampConfig getClamp(MemorySegment mem) {
        return getClamp(mem, 0);
    }
    
    public static ClampConfig getClamp(MemorySegment mem, int offset) {
        return ClampConfig.toObject(mem, offset + 13);
    }
    
    
    
    
    
    public static NoiseConfig toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static NoiseConfig toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one NoiseConfig and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static NoiseConfig toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new NoiseConfig(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            NoiseType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 4)),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "Frequency"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "Amplitude"),
            ClampConfig.toObject(mem, offset + 13)
        );
        if (cursor != null) cursor.position = offset + 22;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.seed);
        mem.set(PacketIO.PROTO_BYTE, offset + 4, (byte) this.type.getValue());
        PacketIO.requireFinite(this.frequency, "Frequency"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.frequency);
        PacketIO.requireFinite(this.amplitude, "Amplitude"); mem.set(PacketIO.PROTO_FLOAT, offset + 9, this.amplitude);
        this.clamp.serialize(mem, offset + 13);
        
        
    
       return 22;
    }
    public int computeSize() {
        return 22;
    }

    public NoiseConfig clone() {
        NoiseConfig copy = new NoiseConfig();
        copy.seed = this.seed;
        copy.type = this.type;
        copy.frequency = this.frequency;
        copy.amplitude = this.amplitude;
        copy.clamp = this.clamp.clone();
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof NoiseConfig other)) return false;
        return this.seed == other.seed && java.util.Objects.equals(this.type, other.type) && this.frequency == other.frequency && this.amplitude == other.amplitude && java.util.Objects.equals(this.clamp, other.clamp);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(seed, type, frequency, amplitude, clamp);
    }

}