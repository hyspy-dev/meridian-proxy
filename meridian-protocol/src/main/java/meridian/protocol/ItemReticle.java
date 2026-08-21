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


public class ItemReticle {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 6;
    public static final int MAX_SIZE = 1677721600;

    public boolean hideBase;
    @Nullable public String[] parts;
    public float duration;

    public ItemReticle() {
    }

    public ItemReticle(boolean hideBase, @Nullable String[] parts, float duration) {
        this.hideBase = hideBase;
        this.parts = parts;
        this.duration = duration;
    }

    public ItemReticle(@Nonnull ItemReticle other) {
        this.hideBase = other.hideBase;
        this.parts = other.parts;
        this.duration = other.duration;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemReticle", offset, (int) mem.byteSize());
        long needed = (long) offset + 6;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemReticle", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getHideBase(MemorySegment mem) {
        return getHideBase(mem, 0);
    }
    
    public static boolean getHideBase(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 1);
    }
    
    @Nullable
    public static String[] getParts(MemorySegment mem) {
        return getParts(mem, 0);
    }
    
    @Nullable
    public static String[] getParts(MemorySegment mem, int offset) {
        if (!hasParts(mem, offset)) return null;
        var off = offset + 6;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Parts");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Parts", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Parts", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("Parts", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    public static float getDuration(MemorySegment mem) {
        return getDuration(mem, 0);
    }
    
    public static float getDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "Duration");
    }
    
    public static boolean hasParts(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static ItemReticle toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemReticle toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemReticle and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemReticle toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 6;
        var varPos = 0;
        String[] v1 = null;
        if (hasParts(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Parts");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Parts", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Parts", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v1[i] = PacketIO.readVarString("Parts", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        }
        var result = new ItemReticle(
            mem.get(PacketIO.PROTO_BOOL, offset + 1),
            v1,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "Duration")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.parts != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BOOL, offset + 1, this.hideBase);
        PacketIO.requireFinite(this.duration, "Duration"); mem.set(PacketIO.PROTO_FLOAT, offset + 2, this.duration);
        var varOffset = offset + 6;
        if (this.parts != null) {
            
            if (parts.length > 4096000) throw ProtocolException.arrayTooLong("Parts", parts.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.parts.length);
            
            var partsValueOffset = 0;
            for (var i = 0; i < this.parts.length; i++) {
                partsValueOffset += PacketIO.writeVarString(mem, varOffset + partsValueOffset, this.parts[i], 4096000);
            }
            varOffset += partsValueOffset;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 6;
        if (parts != null) {
        int partsSize = 0;
for (var elem : parts) partsSize += PacketIO.stringSize(elem);
size += VarInt.size(parts.length) + partsSize;
    }

        return size;
    }

    public ItemReticle clone() {
        ItemReticle copy = new ItemReticle();
        copy.hideBase = this.hideBase;
        copy.parts = this.parts != null ? java.util.Arrays.copyOf(this.parts, this.parts.length) : null;
        copy.duration = this.duration;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemReticle other)) return false;
        return this.hideBase == other.hideBase && java.util.Arrays.equals(this.parts, other.parts) && this.duration == other.duration;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Boolean.hashCode(hideBase);
        result = 31 * result + java.util.Arrays.hashCode(parts);
        result = 31 * result + Float.hashCode(duration);
        return result;
    }

}