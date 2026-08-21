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


public class BuilderToolBlockArg {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 2;
    public static final int MAX_SIZE = 16384007;

    @Nullable public String defaultValue;
    public boolean allowPattern;

    public BuilderToolBlockArg() {
    }

    public BuilderToolBlockArg(@Nullable String defaultValue, boolean allowPattern) {
        this.defaultValue = defaultValue;
        this.allowPattern = allowPattern;
    }

    public BuilderToolBlockArg(@Nonnull BuilderToolBlockArg other) {
        this.defaultValue = other.defaultValue;
        this.allowPattern = other.allowPattern;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolBlockArg", offset, (int) mem.byteSize());
        long needed = (long) offset + 2;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolBlockArg", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getDefault(MemorySegment mem) {
        return getDefault(mem, 0);
    }
    
    @Nullable
    public static String getDefault(MemorySegment mem, int offset) {
        return hasDefault(mem, offset) ? PacketIO.readVarString("Default", mem, offset + 2, 4096000): null;
    }
    
    public static boolean getAllowPattern(MemorySegment mem) {
        return getAllowPattern(mem, 0);
    }
    
    public static boolean getAllowPattern(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 1);
    }
    
    public static boolean hasDefault(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static BuilderToolBlockArg toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolBlockArg toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolBlockArg and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolBlockArg toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 2;
        var varPos = 0;
        String v0 = null;
        if (hasDefault(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Default", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new BuilderToolBlockArg(
            v0,
            mem.get(PacketIO.PROTO_BOOL, offset + 1)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.defaultValue != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BOOL, offset + 1, this.allowPattern);
        var varOffset = offset + 2;
        if (this.defaultValue != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.defaultValue, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 2;
        if (defaultValue != null) size += PacketIO.stringSize(defaultValue);

        return size;
    }

    public BuilderToolBlockArg clone() {
        BuilderToolBlockArg copy = new BuilderToolBlockArg();
        copy.defaultValue = this.defaultValue;
        copy.allowPattern = this.allowPattern;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolBlockArg other)) return false;
        return java.util.Objects.equals(this.defaultValue, other.defaultValue) && this.allowPattern == other.allowPattern;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(defaultValue, allowPattern);
    }

}