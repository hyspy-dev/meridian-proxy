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


public class ItemHudUI {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 2;
    public static final int MAX_SIZE = 16384007;

    @Nullable public String path;
    @Nonnull public ItemHudUIType type = ItemHudUIType.Hud;

    public ItemHudUI() {
    }

    public ItemHudUI(@Nullable String path, @Nonnull ItemHudUIType type) {
        this.path = path;
        this.type = type;
    }

    public ItemHudUI(@Nonnull ItemHudUI other) {
        this.path = other.path;
        this.type = other.type;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemHudUI", offset, (int) mem.byteSize());
        long needed = (long) offset + 2;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemHudUI", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getPath(MemorySegment mem) {
        return getPath(mem, 0);
    }
    
    @Nullable
    public static String getPath(MemorySegment mem, int offset) {
        return hasPath(mem, offset) ? PacketIO.readVarString("Path", mem, offset + 2, 4096000): null;
    }
    
    public static ItemHudUIType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static ItemHudUIType getType(MemorySegment mem, int offset) {
        return ItemHudUIType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static boolean hasPath(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static ItemHudUI toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemHudUI toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemHudUI and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemHudUI toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 2;
        var varPos = 0;
        String v0 = null;
        if (hasPath(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Path", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new ItemHudUI(
            v0,
            ItemHudUIType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1))
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.path != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        var varOffset = offset + 2;
        if (this.path != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.path, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 2;
        if (path != null) size += PacketIO.stringSize(path);

        return size;
    }

    public ItemHudUI clone() {
        ItemHudUI copy = new ItemHudUI();
        copy.path = this.path;
        copy.type = this.type;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemHudUI other)) return false;
        return java.util.Objects.equals(this.path, other.path) && java.util.Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(path, type);
    }

}