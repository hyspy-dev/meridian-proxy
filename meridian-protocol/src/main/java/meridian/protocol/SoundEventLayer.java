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


public class SoundEventLayer {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 45;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 45;
    public static final int MAX_SIZE = 1677721600;

    public float volume;
    public float startDelay;
    public float fadeIn;
    public boolean looping;
    public int probability;
    public float probabilityRerollDelay;
    public int roundRobinHistorySize;
    @Nonnull public SoundEventLayerRandomSettings randomSettings = new SoundEventLayerRandomSettings();
    @Nonnull public String[] files = new String[0];

    public SoundEventLayer() {
    }

    public SoundEventLayer(float volume, float startDelay, float fadeIn, boolean looping, int probability, float probabilityRerollDelay, int roundRobinHistorySize, @Nonnull SoundEventLayerRandomSettings randomSettings, @Nonnull String[] files) {
        this.volume = volume;
        this.startDelay = startDelay;
        this.fadeIn = fadeIn;
        this.looping = looping;
        this.probability = probability;
        this.probabilityRerollDelay = probabilityRerollDelay;
        this.roundRobinHistorySize = roundRobinHistorySize;
        this.randomSettings = randomSettings;
        this.files = files;
    }

    public SoundEventLayer(@Nonnull SoundEventLayer other) {
        this.volume = other.volume;
        this.startDelay = other.startDelay;
        this.fadeIn = other.fadeIn;
        this.looping = other.looping;
        this.probability = other.probability;
        this.probabilityRerollDelay = other.probabilityRerollDelay;
        this.roundRobinHistorySize = other.roundRobinHistorySize;
        this.randomSettings = other.randomSettings;
        this.files = other.files;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SoundEventLayer", offset, (int) mem.byteSize());
        long needed = (long) offset + 45;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SoundEventLayer", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getVolume(MemorySegment mem) {
        return getVolume(mem, 0);
    }
    
    public static float getVolume(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "Volume");
    }
    
    public static float getStartDelay(MemorySegment mem) {
        return getStartDelay(mem, 0);
    }
    
    public static float getStartDelay(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "StartDelay");
    }
    
    public static float getFadeIn(MemorySegment mem) {
        return getFadeIn(mem, 0);
    }
    
    public static float getFadeIn(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "FadeIn");
    }
    
    public static boolean getLooping(MemorySegment mem) {
        return getLooping(mem, 0);
    }
    
    public static boolean getLooping(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 12);
    }
    
    public static int getProbability(MemorySegment mem) {
        return getProbability(mem, 0);
    }
    
    public static int getProbability(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 13);
    }
    
    public static float getProbabilityRerollDelay(MemorySegment mem) {
        return getProbabilityRerollDelay(mem, 0);
    }
    
    public static float getProbabilityRerollDelay(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 17), "ProbabilityRerollDelay");
    }
    
    public static int getRoundRobinHistorySize(MemorySegment mem) {
        return getRoundRobinHistorySize(mem, 0);
    }
    
    public static int getRoundRobinHistorySize(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 21);
    }
    
    public static SoundEventLayerRandomSettings getRandomSettings(MemorySegment mem) {
        return getRandomSettings(mem, 0);
    }
    
    public static SoundEventLayerRandomSettings getRandomSettings(MemorySegment mem, int offset) {
        return SoundEventLayerRandomSettings.toObject(mem, offset + 25);
    }
    
    public static String[] getFiles(MemorySegment mem) {
        return getFiles(mem, 0);
    }
    
    public static String[] getFiles(MemorySegment mem, int offset) {
        var off = offset + 45;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Files");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Files", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Files", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("Files", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    
    
    
    
    public static SoundEventLayer toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SoundEventLayer toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SoundEventLayer and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SoundEventLayer toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 45;
        var varPos = 0;
        String[] v8;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Files");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Files", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Files", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v8 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v8[i] = PacketIO.readVarString("Files", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        }
        var result = new SoundEventLayer(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "Volume"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "StartDelay"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "FadeIn"),
            mem.get(PacketIO.PROTO_BOOL, offset + 12),
            mem.get(PacketIO.PROTO_INT, offset + 13),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 17), "ProbabilityRerollDelay"),
            mem.get(PacketIO.PROTO_INT, offset + 21),
            SoundEventLayerRandomSettings.toObject(mem, offset + 25),
            v8
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.volume, "Volume"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.volume);
        PacketIO.requireFinite(this.startDelay, "StartDelay"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.startDelay);
        PacketIO.requireFinite(this.fadeIn, "FadeIn"); mem.set(PacketIO.PROTO_FLOAT, offset + 8, this.fadeIn);
        mem.set(PacketIO.PROTO_BOOL, offset + 12, this.looping);
        mem.set(PacketIO.PROTO_INT, offset + 13, this.probability);
        PacketIO.requireFinite(this.probabilityRerollDelay, "ProbabilityRerollDelay"); mem.set(PacketIO.PROTO_FLOAT, offset + 17, this.probabilityRerollDelay);
        mem.set(PacketIO.PROTO_INT, offset + 21, this.roundRobinHistorySize);
        this.randomSettings.serialize(mem, offset + 25);
        var varOffset = offset + 45;
        if (files.length > 4096000) throw ProtocolException.arrayTooLong("Files", files.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.files.length);
        
        var filesValueOffset = 0;
        for (var i = 0; i < this.files.length; i++) {
            filesValueOffset += PacketIO.writeVarString(mem, varOffset + filesValueOffset, this.files[i], 4096000);
        }
        varOffset += filesValueOffset;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 45;
        int filesSize = 0;
for (var elem : files) filesSize += PacketIO.stringSize(elem);
size += VarInt.size(files.length) + filesSize;

        return size;
    }

    public SoundEventLayer clone() {
        SoundEventLayer copy = new SoundEventLayer();
        copy.volume = this.volume;
        copy.startDelay = this.startDelay;
        copy.fadeIn = this.fadeIn;
        copy.looping = this.looping;
        copy.probability = this.probability;
        copy.probabilityRerollDelay = this.probabilityRerollDelay;
        copy.roundRobinHistorySize = this.roundRobinHistorySize;
        copy.randomSettings = this.randomSettings.clone();
        copy.files = java.util.Arrays.copyOf(this.files, this.files.length);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SoundEventLayer other)) return false;
        return this.volume == other.volume && this.startDelay == other.startDelay && this.fadeIn == other.fadeIn && this.looping == other.looping && this.probability == other.probability && this.probabilityRerollDelay == other.probabilityRerollDelay && this.roundRobinHistorySize == other.roundRobinHistorySize && java.util.Objects.equals(this.randomSettings, other.randomSettings) && java.util.Arrays.equals(this.files, other.files);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Float.hashCode(volume);
        result = 31 * result + Float.hashCode(startDelay);
        result = 31 * result + Float.hashCode(fadeIn);
        result = 31 * result + Boolean.hashCode(looping);
        result = 31 * result + Integer.hashCode(probability);
        result = 31 * result + Float.hashCode(probabilityRerollDelay);
        result = 31 * result + Integer.hashCode(roundRobinHistorySize);
        result = 31 * result + java.util.Objects.hashCode(randomSettings);
        result = 31 * result + java.util.Arrays.hashCode(files);
        return result;
    }

}