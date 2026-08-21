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


public class AbilityEffects {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 4096006;

    @Nullable public InteractionType[] disabled;

    public AbilityEffects() {
    }

    public AbilityEffects(@Nullable InteractionType[] disabled) {
        this.disabled = disabled;
    }

    public AbilityEffects(@Nonnull AbilityEffects other) {
        this.disabled = other.disabled;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AbilityEffects", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AbilityEffects", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static InteractionType[] getDisabled(MemorySegment mem) {
        return getDisabled(mem, 0);
    }
    
    @Nullable
    public static InteractionType[] getDisabled(MemorySegment mem, int offset) {
        if (!hasDisabled(mem, offset)) return null;
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Disabled");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Disabled", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Disabled", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new InteractionType[len];
        for (var i = 0; i < len; i++) {
            data[i] = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
        }
        return data;
    }
    
    public static boolean hasDisabled(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static AbilityEffects toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AbilityEffects toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AbilityEffects and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AbilityEffects toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        InteractionType[] v0 = null;
        if (hasDisabled(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Disabled");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Disabled", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Disabled", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new InteractionType[len];
            for (var i = 0; i < len; i++) {
                v0[i] = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
            }
            varPos = off + len - varBase;
        }
        var result = new AbilityEffects(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.disabled != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.disabled != null) {
            
            if (disabled.length > 4096000) throw ProtocolException.arrayTooLong("Disabled", disabled.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.disabled.length);
            
            for (var i = 0; i < this.disabled.length; i++) {
                mem.set(PacketIO.PROTO_BYTE, varOffset + i * 1, (byte) this.disabled[i].getValue());
            }
            varOffset += this.disabled.length * 1;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (disabled != null) size += VarInt.size(disabled.length) + disabled.length * 1;

        return size;
    }

    public AbilityEffects clone() {
        AbilityEffects copy = new AbilityEffects();
        copy.disabled = this.disabled != null ? java.util.Arrays.copyOf(this.disabled, this.disabled.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AbilityEffects other)) return false;
        return java.util.Arrays.equals(this.disabled, other.disabled);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(disabled);
        return result;
    }

}