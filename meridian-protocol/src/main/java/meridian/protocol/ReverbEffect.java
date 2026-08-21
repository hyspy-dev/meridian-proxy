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


public class ReverbEffect {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 54;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 54;
    public static final int MAX_SIZE = 16384059;

    @Nullable public String id;
    public float dryGain;
    public float modalDensity;
    public float diffusion;
    public float gain;
    public float highFrequencyGain;
    public float decayTime;
    public float highFrequencyDecayRatio;
    public float reflectionGain;
    public float reflectionDelay;
    public float lateReverbGain;
    public float lateReverbDelay;
    public float roomRolloffFactor;
    public float airAbsorptionHighFrequencyGain;
    public boolean limitDecayHighFrequency;

    public ReverbEffect() {
    }

    public ReverbEffect(@Nullable String id, float dryGain, float modalDensity, float diffusion, float gain, float highFrequencyGain, float decayTime, float highFrequencyDecayRatio, float reflectionGain, float reflectionDelay, float lateReverbGain, float lateReverbDelay, float roomRolloffFactor, float airAbsorptionHighFrequencyGain, boolean limitDecayHighFrequency) {
        this.id = id;
        this.dryGain = dryGain;
        this.modalDensity = modalDensity;
        this.diffusion = diffusion;
        this.gain = gain;
        this.highFrequencyGain = highFrequencyGain;
        this.decayTime = decayTime;
        this.highFrequencyDecayRatio = highFrequencyDecayRatio;
        this.reflectionGain = reflectionGain;
        this.reflectionDelay = reflectionDelay;
        this.lateReverbGain = lateReverbGain;
        this.lateReverbDelay = lateReverbDelay;
        this.roomRolloffFactor = roomRolloffFactor;
        this.airAbsorptionHighFrequencyGain = airAbsorptionHighFrequencyGain;
        this.limitDecayHighFrequency = limitDecayHighFrequency;
    }

    public ReverbEffect(@Nonnull ReverbEffect other) {
        this.id = other.id;
        this.dryGain = other.dryGain;
        this.modalDensity = other.modalDensity;
        this.diffusion = other.diffusion;
        this.gain = other.gain;
        this.highFrequencyGain = other.highFrequencyGain;
        this.decayTime = other.decayTime;
        this.highFrequencyDecayRatio = other.highFrequencyDecayRatio;
        this.reflectionGain = other.reflectionGain;
        this.reflectionDelay = other.reflectionDelay;
        this.lateReverbGain = other.lateReverbGain;
        this.lateReverbDelay = other.lateReverbDelay;
        this.roomRolloffFactor = other.roomRolloffFactor;
        this.airAbsorptionHighFrequencyGain = other.airAbsorptionHighFrequencyGain;
        this.limitDecayHighFrequency = other.limitDecayHighFrequency;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ReverbEffect", offset, (int) mem.byteSize());
        long needed = (long) offset + 54;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ReverbEffect", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + 54, 4096000): null;
    }
    
    public static float getDryGain(MemorySegment mem) {
        return getDryGain(mem, 0);
    }
    
    public static float getDryGain(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "DryGain");
    }
    
    public static float getModalDensity(MemorySegment mem) {
        return getModalDensity(mem, 0);
    }
    
    public static float getModalDensity(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "ModalDensity");
    }
    
    public static float getDiffusion(MemorySegment mem) {
        return getDiffusion(mem, 0);
    }
    
    public static float getDiffusion(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "Diffusion");
    }
    
    public static float getGain(MemorySegment mem) {
        return getGain(mem, 0);
    }
    
    public static float getGain(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 13), "Gain");
    }
    
    public static float getHighFrequencyGain(MemorySegment mem) {
        return getHighFrequencyGain(mem, 0);
    }
    
    public static float getHighFrequencyGain(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 17), "HighFrequencyGain");
    }
    
    public static float getDecayTime(MemorySegment mem) {
        return getDecayTime(mem, 0);
    }
    
    public static float getDecayTime(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 21), "DecayTime");
    }
    
    public static float getHighFrequencyDecayRatio(MemorySegment mem) {
        return getHighFrequencyDecayRatio(mem, 0);
    }
    
    public static float getHighFrequencyDecayRatio(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 25), "HighFrequencyDecayRatio");
    }
    
    public static float getReflectionGain(MemorySegment mem) {
        return getReflectionGain(mem, 0);
    }
    
    public static float getReflectionGain(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 29), "ReflectionGain");
    }
    
    public static float getReflectionDelay(MemorySegment mem) {
        return getReflectionDelay(mem, 0);
    }
    
    public static float getReflectionDelay(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 33), "ReflectionDelay");
    }
    
    public static float getLateReverbGain(MemorySegment mem) {
        return getLateReverbGain(mem, 0);
    }
    
    public static float getLateReverbGain(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 37), "LateReverbGain");
    }
    
    public static float getLateReverbDelay(MemorySegment mem) {
        return getLateReverbDelay(mem, 0);
    }
    
    public static float getLateReverbDelay(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 41), "LateReverbDelay");
    }
    
    public static float getRoomRolloffFactor(MemorySegment mem) {
        return getRoomRolloffFactor(mem, 0);
    }
    
    public static float getRoomRolloffFactor(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 45), "RoomRolloffFactor");
    }
    
    public static float getAirAbsorptionHighFrequencyGain(MemorySegment mem) {
        return getAirAbsorptionHighFrequencyGain(mem, 0);
    }
    
    public static float getAirAbsorptionHighFrequencyGain(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 49), "AirAbsorptionHighFrequencyGain");
    }
    
    public static boolean getLimitDecayHighFrequency(MemorySegment mem) {
        return getLimitDecayHighFrequency(mem, 0);
    }
    
    public static boolean getLimitDecayHighFrequency(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 53);
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static ReverbEffect toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ReverbEffect toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ReverbEffect and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ReverbEffect toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 54;
        var varPos = 0;
        String v0 = null;
        if (hasId(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new ReverbEffect(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "DryGain"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "ModalDensity"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "Diffusion"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 13), "Gain"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 17), "HighFrequencyGain"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 21), "DecayTime"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 25), "HighFrequencyDecayRatio"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 29), "ReflectionGain"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 33), "ReflectionDelay"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 37), "LateReverbGain"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 41), "LateReverbDelay"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 45), "RoomRolloffFactor"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 49), "AirAbsorptionHighFrequencyGain"),
            mem.get(PacketIO.PROTO_BOOL, offset + 53)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.dryGain, "DryGain"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.dryGain);
        PacketIO.requireFinite(this.modalDensity, "ModalDensity"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.modalDensity);
        PacketIO.requireFinite(this.diffusion, "Diffusion"); mem.set(PacketIO.PROTO_FLOAT, offset + 9, this.diffusion);
        PacketIO.requireFinite(this.gain, "Gain"); mem.set(PacketIO.PROTO_FLOAT, offset + 13, this.gain);
        PacketIO.requireFinite(this.highFrequencyGain, "HighFrequencyGain"); mem.set(PacketIO.PROTO_FLOAT, offset + 17, this.highFrequencyGain);
        PacketIO.requireFinite(this.decayTime, "DecayTime"); mem.set(PacketIO.PROTO_FLOAT, offset + 21, this.decayTime);
        PacketIO.requireFinite(this.highFrequencyDecayRatio, "HighFrequencyDecayRatio"); mem.set(PacketIO.PROTO_FLOAT, offset + 25, this.highFrequencyDecayRatio);
        PacketIO.requireFinite(this.reflectionGain, "ReflectionGain"); mem.set(PacketIO.PROTO_FLOAT, offset + 29, this.reflectionGain);
        PacketIO.requireFinite(this.reflectionDelay, "ReflectionDelay"); mem.set(PacketIO.PROTO_FLOAT, offset + 33, this.reflectionDelay);
        PacketIO.requireFinite(this.lateReverbGain, "LateReverbGain"); mem.set(PacketIO.PROTO_FLOAT, offset + 37, this.lateReverbGain);
        PacketIO.requireFinite(this.lateReverbDelay, "LateReverbDelay"); mem.set(PacketIO.PROTO_FLOAT, offset + 41, this.lateReverbDelay);
        PacketIO.requireFinite(this.roomRolloffFactor, "RoomRolloffFactor"); mem.set(PacketIO.PROTO_FLOAT, offset + 45, this.roomRolloffFactor);
        PacketIO.requireFinite(this.airAbsorptionHighFrequencyGain, "AirAbsorptionHighFrequencyGain"); mem.set(PacketIO.PROTO_FLOAT, offset + 49, this.airAbsorptionHighFrequencyGain);
        mem.set(PacketIO.PROTO_BOOL, offset + 53, this.limitDecayHighFrequency);
        var varOffset = offset + 54;
        if (this.id != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 54;
        if (id != null) size += PacketIO.stringSize(id);

        return size;
    }

    public ReverbEffect clone() {
        ReverbEffect copy = new ReverbEffect();
        copy.id = this.id;
        copy.dryGain = this.dryGain;
        copy.modalDensity = this.modalDensity;
        copy.diffusion = this.diffusion;
        copy.gain = this.gain;
        copy.highFrequencyGain = this.highFrequencyGain;
        copy.decayTime = this.decayTime;
        copy.highFrequencyDecayRatio = this.highFrequencyDecayRatio;
        copy.reflectionGain = this.reflectionGain;
        copy.reflectionDelay = this.reflectionDelay;
        copy.lateReverbGain = this.lateReverbGain;
        copy.lateReverbDelay = this.lateReverbDelay;
        copy.roomRolloffFactor = this.roomRolloffFactor;
        copy.airAbsorptionHighFrequencyGain = this.airAbsorptionHighFrequencyGain;
        copy.limitDecayHighFrequency = this.limitDecayHighFrequency;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ReverbEffect other)) return false;
        return java.util.Objects.equals(this.id, other.id) && this.dryGain == other.dryGain && this.modalDensity == other.modalDensity && this.diffusion == other.diffusion && this.gain == other.gain && this.highFrequencyGain == other.highFrequencyGain && this.decayTime == other.decayTime && this.highFrequencyDecayRatio == other.highFrequencyDecayRatio && this.reflectionGain == other.reflectionGain && this.reflectionDelay == other.reflectionDelay && this.lateReverbGain == other.lateReverbGain && this.lateReverbDelay == other.lateReverbDelay && this.roomRolloffFactor == other.roomRolloffFactor && this.airAbsorptionHighFrequencyGain == other.airAbsorptionHighFrequencyGain && this.limitDecayHighFrequency == other.limitDecayHighFrequency;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, dryGain, modalDensity, diffusion, gain, highFrequencyGain, decayTime, highFrequencyDecayRatio, reflectionGain, reflectionDelay, lateReverbGain, lateReverbDelay, roomRolloffFactor, airAbsorptionHighFrequencyGain, limitDecayHighFrequency);
    }

}