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


public class BlockBreakingDecal {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 0;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public String[] stageTextures = new String[0];

    public BlockBreakingDecal() {
    }

    public BlockBreakingDecal(@Nonnull String[] stageTextures) {
        this.stageTextures = stageTextures;
    }

    public BlockBreakingDecal(@Nonnull BlockBreakingDecal other) {
        this.stageTextures = other.stageTextures;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BlockBreakingDecal", offset, (int) mem.byteSize());
        long needed = (long) offset + 0;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockBreakingDecal", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String[] getStageTextures(MemorySegment mem) {
        return getStageTextures(mem, 0);
    }
    
    public static String[] getStageTextures(MemorySegment mem, int offset) {
        var off = offset + 0;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("StageTextures");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("StageTextures", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("StageTextures", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("StageTextures", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    
    
    
    
    public static BlockBreakingDecal toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BlockBreakingDecal toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BlockBreakingDecal and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BlockBreakingDecal toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 0;
        var varPos = 0;
        String[] v0;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("StageTextures");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("StageTextures", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("StageTextures", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v0[i] = PacketIO.readVarString("StageTextures", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        }
        var result = new BlockBreakingDecal(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 0;
        if (stageTextures.length > 4096000) throw ProtocolException.arrayTooLong("StageTextures", stageTextures.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.stageTextures.length);
        
        var stageTexturesValueOffset = 0;
        for (var i = 0; i < this.stageTextures.length; i++) {
            stageTexturesValueOffset += PacketIO.writeVarString(mem, varOffset + stageTexturesValueOffset, this.stageTextures[i], 4096000);
        }
        varOffset += stageTexturesValueOffset;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 0;
        int stageTexturesSize = 0;
for (var elem : stageTextures) stageTexturesSize += PacketIO.stringSize(elem);
size += VarInt.size(stageTextures.length) + stageTexturesSize;

        return size;
    }

    public BlockBreakingDecal clone() {
        BlockBreakingDecal copy = new BlockBreakingDecal();
        copy.stageTextures = java.util.Arrays.copyOf(this.stageTextures, this.stageTextures.length);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BlockBreakingDecal other)) return false;
        return java.util.Arrays.equals(this.stageTextures, other.stageTextures);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(stageTextures);
        return result;
    }

}