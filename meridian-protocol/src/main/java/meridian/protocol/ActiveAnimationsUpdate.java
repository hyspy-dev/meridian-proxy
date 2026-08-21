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


public class ActiveAnimationsUpdate extends ComponentUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 0;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public String[] activeAnimations = new String[0];

    public ActiveAnimationsUpdate() {
    }

    public ActiveAnimationsUpdate(@Nonnull String[] activeAnimations) {
        this.activeAnimations = activeAnimations;
    }

    public ActiveAnimationsUpdate(@Nonnull ActiveAnimationsUpdate other) {
        this.activeAnimations = other.activeAnimations;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ActiveAnimationsUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 0;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ActiveAnimationsUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String[] getActiveAnimations(MemorySegment mem) {
        return getActiveAnimations(mem, 0);
    }
    
    public static String[] getActiveAnimations(MemorySegment mem, int offset) {
        var off = offset + 0;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ActiveAnimations");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("ActiveAnimations", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (len + 7) / 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ActiveAnimations", (int) java.lang.Math.min(off + lenOffset + (len + 7) / 8, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var bitfieldSize = (len + 7) / 8;
        var bitfieldOff = off;
        off += bitfieldSize;
        if (bitfieldOff + bitfieldSize > mem.byteSize()) throw ProtocolException.bufferTooSmall("ActiveAnimations", bitfieldOff + bitfieldSize, (int) mem.byteSize());
        var present = 0;
        for (var b = 0; b < bitfieldSize; b++) {
            present += Integer.bitCount(mem.get(PacketIO.PROTO_BYTE, bitfieldOff + b) & 0xFF);
        }
        if ((len & 7) != 0) present -= Integer.bitCount((mem.get(PacketIO.PROTO_BYTE, bitfieldOff + bitfieldSize - 1) & 0xFF) >>> (len & 7));
        var needed = off + (long) present * 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ActiveAnimations", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
        var data = new String[len];
        for (var i = 0; i < len;) {
            byte bits = mem.get(PacketIO.PROTO_BYTE, bitfieldOff + i / 8);
            int batchEnd = Math.min(len, (i & ~7) + 8);
            for (; i < batchEnd; i++) {
                if ((bits & (1 << (i & 7))) != 0) {
                var sp = VarInt.getWithLength(mem, off);
                data[i] = PacketIO.readVarString("ActiveAnimations", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
                }
            }
        }
        return data;
    }
    
    
    
    
    
    public static ActiveAnimationsUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ActiveAnimationsUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ActiveAnimationsUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ActiveAnimationsUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 0;
        var varPos = 0;
        String[] v0;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ActiveAnimations");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("ActiveAnimations", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (len + 7) / 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ActiveAnimations", (int) java.lang.Math.min(off + lenOffset + (len + 7) / 8, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            var bitfieldSize = (len + 7) / 8;
            var bitfieldOff = off;
            off += bitfieldSize;
            if (bitfieldOff + bitfieldSize > mem.byteSize()) throw ProtocolException.bufferTooSmall("ActiveAnimations", bitfieldOff + bitfieldSize, (int) mem.byteSize());
            var present = 0;
            for (var b = 0; b < bitfieldSize; b++) {
                present += Integer.bitCount(mem.get(PacketIO.PROTO_BYTE, bitfieldOff + b) & 0xFF);
            }
            if ((len & 7) != 0) present -= Integer.bitCount((mem.get(PacketIO.PROTO_BYTE, bitfieldOff + bitfieldSize - 1) & 0xFF) >>> (len & 7));
            var needed = off + (long) present * 1;
            if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ActiveAnimations", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
            v0 = new String[len];
            for (var i = 0; i < len;) {
                byte bits = mem.get(PacketIO.PROTO_BYTE, bitfieldOff + i / 8);
                int batchEnd = Math.min(len, (i & ~7) + 8);
                for (; i < batchEnd; i++) {
                    if ((bits & (1 << (i & 7))) != 0) {
                    var sp = VarInt.getWithLength(mem, off);
                    v0[i] = PacketIO.readVarString("ActiveAnimations", mem, off, 0, 4096000, sp);
                    off += (int) sp + (int) (sp >>> 32);
                    }
                }
            }
            varPos = off - varBase;
        }
        var result = new ActiveAnimationsUpdate(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 0;
        if (activeAnimations.length > 4096000) throw ProtocolException.arrayTooLong("ActiveAnimations", activeAnimations.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.activeAnimations.length);
        
        var activeAnimationsBitfieldSize = (this.activeAnimations.length + 7) / 8;
        for (var bi = 0; bi < activeAnimationsBitfieldSize; bi++) {
            byte bits = 0;
            for (var j = bi * 8; j < Math.min(this.activeAnimations.length, bi * 8 + 8); j++) {
                if (this.activeAnimations[j] != null) bits |= (byte) (1 << (j & 7));
            }
            mem.set(PacketIO.PROTO_BYTE, varOffset + bi, bits);
        }
        varOffset += activeAnimationsBitfieldSize;
        for (var i = 0; i < this.activeAnimations.length; i++) {
            if (this.activeAnimations[i] != null) {
                varOffset += PacketIO.writeVarString(mem, varOffset, this.activeAnimations[i], 4096000);
            }
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 0;
        int activeAnimationsSize = 0;
for (var elem : activeAnimations) if (elem != null) activeAnimationsSize += PacketIO.stringSize(elem);
size += VarInt.size(activeAnimations.length) + (activeAnimations.length + 7) / 8 + activeAnimationsSize;

        return size;
    }

    public ActiveAnimationsUpdate clone() {
        ActiveAnimationsUpdate copy = new ActiveAnimationsUpdate();
        copy.activeAnimations = java.util.Arrays.copyOf(this.activeAnimations, this.activeAnimations.length);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ActiveAnimationsUpdate other)) return false;
        return java.util.Arrays.equals(this.activeAnimations, other.activeAnimations);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(activeAnimations);
        return result;
    }

}