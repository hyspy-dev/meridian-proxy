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


public class UIComponentsUpdate extends ComponentUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 0;
    public static final int MAX_SIZE = 16384005;

    @Nonnull public int[] components = new int[0];

    public UIComponentsUpdate() {
    }

    public UIComponentsUpdate(@Nonnull int[] components) {
        this.components = components;
    }

    public UIComponentsUpdate(@Nonnull UIComponentsUpdate other) {
        this.components = other.components;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UIComponentsUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 0;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UIComponentsUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int[] getComponents(MemorySegment mem) {
        return getComponents(mem, 0);
    }
    
    public static int[] getComponents(MemorySegment mem, int offset) {
        var off = offset + 0;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Components");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Components", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Components", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    
    
    
    
    public static UIComponentsUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UIComponentsUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UIComponentsUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UIComponentsUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 0;
        var varPos = 0;
        int[] v0;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Components");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Components", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Components", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v0, 0, len);
            varPos = off + len * 4 - varBase;
        }
        var result = new UIComponentsUpdate(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 0;
        if (components.length > 4096000) throw ProtocolException.arrayTooLong("Components", components.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.components.length);
        
        MemorySegment.copy(this.components, 0, mem, PacketIO.PROTO_INT, varOffset, this.components.length);
        varOffset += this.components.length * 4;
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 0;
        size += VarInt.size(components.length) + components.length * 4;

        return size;
    }

    public UIComponentsUpdate clone() {
        UIComponentsUpdate copy = new UIComponentsUpdate();
        copy.components = java.util.Arrays.copyOf(this.components, this.components.length);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UIComponentsUpdate other)) return false;
        return java.util.Arrays.equals(this.components, other.components);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(components);
        return result;
    }

}