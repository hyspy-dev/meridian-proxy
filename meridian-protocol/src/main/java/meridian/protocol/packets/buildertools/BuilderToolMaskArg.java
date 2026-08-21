// Auto-generated - do not edit
package meridian.protocol.packets.buildertools;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class BuilderToolMaskArg {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 16384006;

    @Nullable public String defaultValue;

    public BuilderToolMaskArg() {
    }

    public BuilderToolMaskArg(@Nullable String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public BuilderToolMaskArg(@Nonnull BuilderToolMaskArg other) {
        this.defaultValue = other.defaultValue;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolMaskArg", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolMaskArg", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getDefault(MemorySegment mem) {
        return getDefault(mem, 0);
    }
    
    @Nullable
    public static String getDefault(MemorySegment mem, int offset) {
        return hasDefault(mem, offset) ? PacketIO.readVarString("Default", mem, offset + 1, 4096000): null;
    }
    
    public static boolean hasDefault(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static BuilderToolMaskArg toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolMaskArg toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolMaskArg and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolMaskArg toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        String v0 = null;
        if (hasDefault(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Default", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new BuilderToolMaskArg(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.defaultValue != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.defaultValue != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.defaultValue, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (defaultValue != null) size += PacketIO.stringSize(defaultValue);

        return size;
    }

    public BuilderToolMaskArg clone() {
        BuilderToolMaskArg copy = new BuilderToolMaskArg();
        copy.defaultValue = this.defaultValue;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolMaskArg other)) return false;
        return java.util.Objects.equals(this.defaultValue, other.defaultValue);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(defaultValue);
    }

}