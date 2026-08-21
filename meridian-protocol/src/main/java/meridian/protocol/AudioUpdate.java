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


public class AudioUpdate extends ComponentUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 0;
    public static final int MAX_SIZE = 16384005;

    @Nonnull public int[] soundEventIds = new int[0];

    public AudioUpdate() {
    }

    public AudioUpdate(@Nonnull int[] soundEventIds) {
        this.soundEventIds = soundEventIds;
    }

    public AudioUpdate(@Nonnull AudioUpdate other) {
        this.soundEventIds = other.soundEventIds;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AudioUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 0;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AudioUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int[] getSoundEventIds(MemorySegment mem) {
        return getSoundEventIds(mem, 0);
    }
    
    public static int[] getSoundEventIds(MemorySegment mem, int offset) {
        var off = offset + 0;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("SoundEventIds");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("SoundEventIds", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SoundEventIds", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    
    
    
    
    public static AudioUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AudioUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AudioUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AudioUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 0;
        var varPos = 0;
        int[] v0;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("SoundEventIds");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("SoundEventIds", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SoundEventIds", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v0, 0, len);
            varPos = off + len * 4 - varBase;
        }
        var result = new AudioUpdate(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 0;
        if (soundEventIds.length > 4096000) throw ProtocolException.arrayTooLong("SoundEventIds", soundEventIds.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.soundEventIds.length);
        
        MemorySegment.copy(this.soundEventIds, 0, mem, PacketIO.PROTO_INT, varOffset, this.soundEventIds.length);
        varOffset += this.soundEventIds.length * 4;
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 0;
        size += VarInt.size(soundEventIds.length) + soundEventIds.length * 4;

        return size;
    }

    public AudioUpdate clone() {
        AudioUpdate copy = new AudioUpdate();
        copy.soundEventIds = java.util.Arrays.copyOf(this.soundEventIds, this.soundEventIds.length);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AudioUpdate other)) return false;
        return java.util.Arrays.equals(this.soundEventIds, other.soundEventIds);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(soundEventIds);
        return result;
    }

}