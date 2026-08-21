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


public class NameplateUpdate extends ComponentUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 0;
    public static final int MAX_SIZE = 16384005;

    @Nonnull public String text = "";

    public NameplateUpdate() {
    }

    public NameplateUpdate(@Nonnull String text) {
        this.text = text;
    }

    public NameplateUpdate(@Nonnull NameplateUpdate other) {
        this.text = other.text;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("NameplateUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 0;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("NameplateUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getText(MemorySegment mem) {
        return getText(mem, 0);
    }
    
    public static String getText(MemorySegment mem, int offset) {
        return PacketIO.readVarString("Text", mem, offset + 0, 4096000);
    }
    
    
    
    
    
    public static NameplateUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static NameplateUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one NameplateUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static NameplateUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 0;
        var varPos = 0;
        String v0;
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Text", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new NameplateUpdate(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 0;
        varOffset += PacketIO.writeVarString(mem, varOffset, this.text, 4096000);
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 0;
        size += PacketIO.stringSize(text);

        return size;
    }

    public NameplateUpdate clone() {
        NameplateUpdate copy = new NameplateUpdate();
        copy.text = this.text;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof NameplateUpdate other)) return false;
        return java.util.Objects.equals(this.text, other.text);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(text);
    }

}