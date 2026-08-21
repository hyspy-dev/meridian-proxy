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


public class StateBinding {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 5;
    public static final int MAX_SIZE = 53248010;

    public int audioStateIndex;
    @Nullable public StateDelta[] deltas;

    public StateBinding() {
    }

    public StateBinding(int audioStateIndex, @Nullable StateDelta[] deltas) {
        this.audioStateIndex = audioStateIndex;
        this.deltas = deltas;
    }

    public StateBinding(@Nonnull StateBinding other) {
        this.audioStateIndex = other.audioStateIndex;
        this.deltas = other.deltas;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("StateBinding", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("StateBinding", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getAudioStateIndex(MemorySegment mem) {
        return getAudioStateIndex(mem, 0);
    }
    
    public static int getAudioStateIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static StateDelta[] getDeltas(MemorySegment mem) {
        return getDeltas(mem, 0);
    }
    
    @Nullable
    public static StateDelta[] getDeltas(MemorySegment mem, int offset) {
        if (!hasDeltas(mem, offset)) return null;
        var off = offset + 5;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Deltas");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Deltas", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 13 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Deltas", (int) java.lang.Math.min(off + lenOffset + (long) len * 13, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new StateDelta[len];
        for (var i = 0; i < len; i++) {
            data[i] = StateDelta.toObject(mem, off + i * 13);
        }
        return data;
    }
    
    public static boolean hasDeltas(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static StateBinding toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static StateBinding toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one StateBinding and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static StateBinding toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 5;
        var varPos = 0;
        StateDelta[] v1 = null;
        if (hasDeltas(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Deltas");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Deltas", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 13 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Deltas", (int) java.lang.Math.min(off + lenOffset + (long) len * 13, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new StateDelta[len];
            for (var i = 0; i < len; i++) {
                v1[i] = StateDelta.toObject(mem, off + i * 13);
            }
            varPos = off + len * 13 - varBase;
        }
        var result = new StateBinding(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.deltas != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.audioStateIndex);
        var varOffset = offset + 5;
        if (this.deltas != null) {
            
            if (deltas.length > 4096000) throw ProtocolException.arrayTooLong("Deltas", deltas.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.deltas.length);
            
            var deltasValueOffset = 0;
            for (var i = 0; i < this.deltas.length; i++) {
                deltasValueOffset += this.deltas[i].serialize(mem, varOffset + deltasValueOffset);
            }
            varOffset += deltasValueOffset;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 5;
        if (deltas != null) size += VarInt.size(deltas.length) + deltas.length * 13;

        return size;
    }

    public StateBinding clone() {
        StateBinding copy = new StateBinding();
        copy.audioStateIndex = this.audioStateIndex;
        copy.deltas = this.deltas != null ? java.util.Arrays.stream(this.deltas).map(e -> e.clone()).toArray(StateDelta[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof StateBinding other)) return false;
        return this.audioStateIndex == other.audioStateIndex && java.util.Arrays.equals(this.deltas, other.deltas);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(audioStateIndex);
        result = 31 * result + java.util.Arrays.hashCode(deltas);
        return result;
    }

}