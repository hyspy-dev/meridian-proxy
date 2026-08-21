// Auto-generated - do not edit
package meridian.protocol.packets.asseteditor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class SchemaFile {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 67108866;

    @Nullable public String content;

    public SchemaFile() {
    }

    public SchemaFile(@Nullable String content) {
        this.content = content;
    }

    public SchemaFile(@Nonnull SchemaFile other) {
        this.content = other.content;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SchemaFile", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SchemaFile", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getContent(MemorySegment mem) {
        return getContent(mem, 0);
    }
    
    @Nullable
    public static String getContent(MemorySegment mem, int offset) {
        return hasContent(mem, offset) ? PacketIO.readVarString("Content", mem, offset + 1, 16777215): null;
    }
    
    public static boolean hasContent(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static SchemaFile toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SchemaFile toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SchemaFile and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SchemaFile toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        String v0 = null;
        if (hasContent(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Content", mem, off, 0, 16777215, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new SchemaFile(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.content != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.content != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.content, 16777215);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (content != null) size += PacketIO.stringSize(content);

        return size;
    }

    public SchemaFile clone() {
        SchemaFile copy = new SchemaFile();
        copy.content = this.content;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SchemaFile other)) return false;
        return java.util.Objects.equals(this.content, other.content);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(content);
    }

}