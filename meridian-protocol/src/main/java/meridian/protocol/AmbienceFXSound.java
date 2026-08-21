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


public class AmbienceFXSound {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 33;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 33;
    public static final int MAX_SIZE = 1677721600;

    public int soundEventIndex;
    @Nonnull public AmbienceFXSoundPlay3D play3D = AmbienceFXSoundPlay3D.Random;
    public int blockSoundSetIndex;
    @Nonnull public AmbienceFXAltitude altitude = AmbienceFXAltitude.Normal;
    @Nonnull public Rangef frequency = new Rangef();
    @Nonnull public Range radius = new Range();
    public int maxBodiesPerEmitter;
    @Nullable public Rangeb sunlightRange;
    @Nullable public StateBinding[] stateBindings;

    public AmbienceFXSound() {
    }

    public AmbienceFXSound(int soundEventIndex, @Nonnull AmbienceFXSoundPlay3D play3D, int blockSoundSetIndex, @Nonnull AmbienceFXAltitude altitude, @Nonnull Rangef frequency, @Nonnull Range radius, int maxBodiesPerEmitter, @Nullable Rangeb sunlightRange, @Nullable StateBinding[] stateBindings) {
        this.soundEventIndex = soundEventIndex;
        this.play3D = play3D;
        this.blockSoundSetIndex = blockSoundSetIndex;
        this.altitude = altitude;
        this.frequency = frequency;
        this.radius = radius;
        this.maxBodiesPerEmitter = maxBodiesPerEmitter;
        this.sunlightRange = sunlightRange;
        this.stateBindings = stateBindings;
    }

    public AmbienceFXSound(@Nonnull AmbienceFXSound other) {
        this.soundEventIndex = other.soundEventIndex;
        this.play3D = other.play3D;
        this.blockSoundSetIndex = other.blockSoundSetIndex;
        this.altitude = other.altitude;
        this.frequency = other.frequency;
        this.radius = other.radius;
        this.maxBodiesPerEmitter = other.maxBodiesPerEmitter;
        this.sunlightRange = other.sunlightRange;
        this.stateBindings = other.stateBindings;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AmbienceFXSound", offset, (int) mem.byteSize());
        long needed = (long) offset + 33;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AmbienceFXSound", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getSoundEventIndex(MemorySegment mem) {
        return getSoundEventIndex(mem, 0);
    }
    
    public static int getSoundEventIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static AmbienceFXSoundPlay3D getPlay3D(MemorySegment mem) {
        return getPlay3D(mem, 0);
    }
    
    public static AmbienceFXSoundPlay3D getPlay3D(MemorySegment mem, int offset) {
        return AmbienceFXSoundPlay3D.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 5));
    }
    
    public static int getBlockSoundSetIndex(MemorySegment mem) {
        return getBlockSoundSetIndex(mem, 0);
    }
    
    public static int getBlockSoundSetIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 6);
    }
    
    public static AmbienceFXAltitude getAltitude(MemorySegment mem) {
        return getAltitude(mem, 0);
    }
    
    public static AmbienceFXAltitude getAltitude(MemorySegment mem, int offset) {
        return AmbienceFXAltitude.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 10));
    }
    
    public static Rangef getFrequency(MemorySegment mem) {
        return getFrequency(mem, 0);
    }
    
    public static Rangef getFrequency(MemorySegment mem, int offset) {
        return Rangef.toObject(mem, offset + 11);
    }
    
    public static Range getRadius(MemorySegment mem) {
        return getRadius(mem, 0);
    }
    
    public static Range getRadius(MemorySegment mem, int offset) {
        return Range.toObject(mem, offset + 19);
    }
    
    public static int getMaxBodiesPerEmitter(MemorySegment mem) {
        return getMaxBodiesPerEmitter(mem, 0);
    }
    
    public static int getMaxBodiesPerEmitter(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 27);
    }
    
    @Nullable
    public static Rangeb getSunlightRange(MemorySegment mem) {
        return getSunlightRange(mem, 0);
    }
    
    @Nullable
    public static Rangeb getSunlightRange(MemorySegment mem, int offset) {
        return hasSunlightRange(mem, offset) ? Rangeb.toObject(mem, offset + 31): null;
    }
    
    @Nullable
    public static StateBinding[] getStateBindings(MemorySegment mem) {
        return getStateBindings(mem, 0);
    }
    
    @Nullable
    public static StateBinding[] getStateBindings(MemorySegment mem, int offset) {
        if (!hasStateBindings(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 33;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("StateBindings");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("StateBindings", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("StateBindings", (int) java.lang.Math.min(off + lenOffset + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new StateBinding[len];
        for (var i = 0; i < len; i++) {
            data[i] = StateBinding.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasSunlightRange(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasStateBindings(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    
    
    public static AmbienceFXSound toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AmbienceFXSound toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AmbienceFXSound and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AmbienceFXSound toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 33;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        StateBinding[] v8 = null;
        if (hasStateBindings(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("StateBindings");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("StateBindings", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("StateBindings", (int) java.lang.Math.min(off + lenOffset + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v8 = new StateBinding[len];
            for (var i = 0; i < len; i++) {
                v8[i] = StateBinding.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new AmbienceFXSound(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            AmbienceFXSoundPlay3D.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 5)),
            mem.get(PacketIO.PROTO_INT, offset + 6),
            AmbienceFXAltitude.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 10)),
            Rangef.toObject(mem, offset + 11),
            Range.toObject(mem, offset + 19),
            mem.get(PacketIO.PROTO_INT, offset + 27),
            hasSunlightRange(mem, offset) ? Rangeb.toObject(mem, offset + 31) : null,
            v8
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.sunlightRange != null) nullBits |= 0x01;
        if (this.stateBindings != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.soundEventIndex);
        mem.set(PacketIO.PROTO_BYTE, offset + 5, (byte) this.play3D.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 6, this.blockSoundSetIndex);
        mem.set(PacketIO.PROTO_BYTE, offset + 10, (byte) this.altitude.getValue());
        this.frequency.serialize(mem, offset + 11);
        this.radius.serialize(mem, offset + 19);
        mem.set(PacketIO.PROTO_INT, offset + 27, this.maxBodiesPerEmitter);
        if (this.sunlightRange != null) {
            this.sunlightRange.serialize(mem, offset + 31);
        } else {
            mem.asSlice(offset + 31, 2).fill((byte) 0); 
        }
        var varOffset = offset + 33;
        if (this.stateBindings != null) {
            
            if (stateBindings.length > 4096000) throw ProtocolException.arrayTooLong("StateBindings", stateBindings.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.stateBindings.length);
            
            var stateBindingsValueOffset = 0;
            for (var i = 0; i < this.stateBindings.length; i++) {
                stateBindingsValueOffset += this.stateBindings[i].serialize(mem, varOffset + stateBindingsValueOffset);
            }
            varOffset += stateBindingsValueOffset;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 33;
        if (stateBindings != null) {
        int stateBindingsSize = 0;
for (var elem : stateBindings) stateBindingsSize += elem.computeSize();
size += VarInt.size(stateBindings.length) + stateBindingsSize;
    }

        return size;
    }

    public AmbienceFXSound clone() {
        AmbienceFXSound copy = new AmbienceFXSound();
        copy.soundEventIndex = this.soundEventIndex;
        copy.play3D = this.play3D;
        copy.blockSoundSetIndex = this.blockSoundSetIndex;
        copy.altitude = this.altitude;
        copy.frequency = this.frequency.clone();
        copy.radius = this.radius.clone();
        copy.maxBodiesPerEmitter = this.maxBodiesPerEmitter;
        copy.sunlightRange = this.sunlightRange != null ? this.sunlightRange.clone() : null;
        copy.stateBindings = this.stateBindings != null ? java.util.Arrays.stream(this.stateBindings).map(e -> e.clone()).toArray(StateBinding[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AmbienceFXSound other)) return false;
        return this.soundEventIndex == other.soundEventIndex && java.util.Objects.equals(this.play3D, other.play3D) && this.blockSoundSetIndex == other.blockSoundSetIndex && java.util.Objects.equals(this.altitude, other.altitude) && java.util.Objects.equals(this.frequency, other.frequency) && java.util.Objects.equals(this.radius, other.radius) && this.maxBodiesPerEmitter == other.maxBodiesPerEmitter && java.util.Objects.equals(this.sunlightRange, other.sunlightRange) && java.util.Arrays.equals(this.stateBindings, other.stateBindings);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(soundEventIndex);
        result = 31 * result + java.util.Objects.hashCode(play3D);
        result = 31 * result + Integer.hashCode(blockSoundSetIndex);
        result = 31 * result + java.util.Objects.hashCode(altitude);
        result = 31 * result + java.util.Objects.hashCode(frequency);
        result = 31 * result + java.util.Objects.hashCode(radius);
        result = 31 * result + Integer.hashCode(maxBodiesPerEmitter);
        result = 31 * result + java.util.Objects.hashCode(sunlightRange);
        result = 31 * result + java.util.Arrays.hashCode(stateBindings);
        return result;
    }

}