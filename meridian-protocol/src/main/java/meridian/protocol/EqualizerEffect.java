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


public class EqualizerEffect {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 41;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 41;
    public static final int MAX_SIZE = 16384046;

    @Nullable public String id;
    public float lowGain;
    public float lowCutOff;
    public float lowMidGain;
    public float lowMidCenter;
    public float lowMidWidth;
    public float highMidGain;
    public float highMidCenter;
    public float highMidWidth;
    public float highGain;
    public float highCutOff;

    public EqualizerEffect() {
    }

    public EqualizerEffect(@Nullable String id, float lowGain, float lowCutOff, float lowMidGain, float lowMidCenter, float lowMidWidth, float highMidGain, float highMidCenter, float highMidWidth, float highGain, float highCutOff) {
        this.id = id;
        this.lowGain = lowGain;
        this.lowCutOff = lowCutOff;
        this.lowMidGain = lowMidGain;
        this.lowMidCenter = lowMidCenter;
        this.lowMidWidth = lowMidWidth;
        this.highMidGain = highMidGain;
        this.highMidCenter = highMidCenter;
        this.highMidWidth = highMidWidth;
        this.highGain = highGain;
        this.highCutOff = highCutOff;
    }

    public EqualizerEffect(@Nonnull EqualizerEffect other) {
        this.id = other.id;
        this.lowGain = other.lowGain;
        this.lowCutOff = other.lowCutOff;
        this.lowMidGain = other.lowMidGain;
        this.lowMidCenter = other.lowMidCenter;
        this.lowMidWidth = other.lowMidWidth;
        this.highMidGain = other.highMidGain;
        this.highMidCenter = other.highMidCenter;
        this.highMidWidth = other.highMidWidth;
        this.highGain = other.highGain;
        this.highCutOff = other.highCutOff;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("EqualizerEffect", offset, (int) mem.byteSize());
        long needed = (long) offset + 41;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("EqualizerEffect", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + 41, 4096000): null;
    }
    
    public static float getLowGain(MemorySegment mem) {
        return getLowGain(mem, 0);
    }
    
    public static float getLowGain(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "LowGain");
    }
    
    public static float getLowCutOff(MemorySegment mem) {
        return getLowCutOff(mem, 0);
    }
    
    public static float getLowCutOff(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "LowCutOff");
    }
    
    public static float getLowMidGain(MemorySegment mem) {
        return getLowMidGain(mem, 0);
    }
    
    public static float getLowMidGain(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "LowMidGain");
    }
    
    public static float getLowMidCenter(MemorySegment mem) {
        return getLowMidCenter(mem, 0);
    }
    
    public static float getLowMidCenter(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 13), "LowMidCenter");
    }
    
    public static float getLowMidWidth(MemorySegment mem) {
        return getLowMidWidth(mem, 0);
    }
    
    public static float getLowMidWidth(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 17), "LowMidWidth");
    }
    
    public static float getHighMidGain(MemorySegment mem) {
        return getHighMidGain(mem, 0);
    }
    
    public static float getHighMidGain(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 21), "HighMidGain");
    }
    
    public static float getHighMidCenter(MemorySegment mem) {
        return getHighMidCenter(mem, 0);
    }
    
    public static float getHighMidCenter(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 25), "HighMidCenter");
    }
    
    public static float getHighMidWidth(MemorySegment mem) {
        return getHighMidWidth(mem, 0);
    }
    
    public static float getHighMidWidth(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 29), "HighMidWidth");
    }
    
    public static float getHighGain(MemorySegment mem) {
        return getHighGain(mem, 0);
    }
    
    public static float getHighGain(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 33), "HighGain");
    }
    
    public static float getHighCutOff(MemorySegment mem) {
        return getHighCutOff(mem, 0);
    }
    
    public static float getHighCutOff(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 37), "HighCutOff");
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static EqualizerEffect toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static EqualizerEffect toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one EqualizerEffect and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static EqualizerEffect toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 41;
        var varPos = 0;
        String v0 = null;
        if (hasId(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new EqualizerEffect(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "LowGain"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "LowCutOff"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "LowMidGain"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 13), "LowMidCenter"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 17), "LowMidWidth"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 21), "HighMidGain"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 25), "HighMidCenter"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 29), "HighMidWidth"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 33), "HighGain"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 37), "HighCutOff")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.lowGain, "LowGain"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.lowGain);
        PacketIO.requireFinite(this.lowCutOff, "LowCutOff"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.lowCutOff);
        PacketIO.requireFinite(this.lowMidGain, "LowMidGain"); mem.set(PacketIO.PROTO_FLOAT, offset + 9, this.lowMidGain);
        PacketIO.requireFinite(this.lowMidCenter, "LowMidCenter"); mem.set(PacketIO.PROTO_FLOAT, offset + 13, this.lowMidCenter);
        PacketIO.requireFinite(this.lowMidWidth, "LowMidWidth"); mem.set(PacketIO.PROTO_FLOAT, offset + 17, this.lowMidWidth);
        PacketIO.requireFinite(this.highMidGain, "HighMidGain"); mem.set(PacketIO.PROTO_FLOAT, offset + 21, this.highMidGain);
        PacketIO.requireFinite(this.highMidCenter, "HighMidCenter"); mem.set(PacketIO.PROTO_FLOAT, offset + 25, this.highMidCenter);
        PacketIO.requireFinite(this.highMidWidth, "HighMidWidth"); mem.set(PacketIO.PROTO_FLOAT, offset + 29, this.highMidWidth);
        PacketIO.requireFinite(this.highGain, "HighGain"); mem.set(PacketIO.PROTO_FLOAT, offset + 33, this.highGain);
        PacketIO.requireFinite(this.highCutOff, "HighCutOff"); mem.set(PacketIO.PROTO_FLOAT, offset + 37, this.highCutOff);
        var varOffset = offset + 41;
        if (this.id != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 41;
        if (id != null) size += PacketIO.stringSize(id);

        return size;
    }

    public EqualizerEffect clone() {
        EqualizerEffect copy = new EqualizerEffect();
        copy.id = this.id;
        copy.lowGain = this.lowGain;
        copy.lowCutOff = this.lowCutOff;
        copy.lowMidGain = this.lowMidGain;
        copy.lowMidCenter = this.lowMidCenter;
        copy.lowMidWidth = this.lowMidWidth;
        copy.highMidGain = this.highMidGain;
        copy.highMidCenter = this.highMidCenter;
        copy.highMidWidth = this.highMidWidth;
        copy.highGain = this.highGain;
        copy.highCutOff = this.highCutOff;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EqualizerEffect other)) return false;
        return java.util.Objects.equals(this.id, other.id) && this.lowGain == other.lowGain && this.lowCutOff == other.lowCutOff && this.lowMidGain == other.lowMidGain && this.lowMidCenter == other.lowMidCenter && this.lowMidWidth == other.lowMidWidth && this.highMidGain == other.highMidGain && this.highMidCenter == other.highMidCenter && this.highMidWidth == other.highMidWidth && this.highGain == other.highGain && this.highCutOff == other.highCutOff;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, lowGain, lowCutOff, lowMidGain, lowMidCenter, lowMidWidth, highMidGain, highMidCenter, highMidWidth, highGain, highCutOff);
    }

}