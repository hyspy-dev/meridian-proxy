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


public class MouseMotionEvent {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 4096014;

    @Nullable public MouseButtonType[] mouseButtonType;
    @Nullable public Vector2i relativeMotion;

    public MouseMotionEvent() {
    }

    public MouseMotionEvent(@Nullable MouseButtonType[] mouseButtonType, @Nullable Vector2i relativeMotion) {
        this.mouseButtonType = mouseButtonType;
        this.relativeMotion = relativeMotion;
    }

    public MouseMotionEvent(@Nonnull MouseMotionEvent other) {
        this.mouseButtonType = other.mouseButtonType;
        this.relativeMotion = other.relativeMotion;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("MouseMotionEvent", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("MouseMotionEvent", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static MouseButtonType[] getMouseButtonType(MemorySegment mem) {
        return getMouseButtonType(mem, 0);
    }
    
    @Nullable
    public static MouseButtonType[] getMouseButtonType(MemorySegment mem, int offset) {
        if (!hasMouseButtonType(mem, offset)) return null;
        var off = offset + 9;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("MouseButtonType");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("MouseButtonType", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("MouseButtonType", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new MouseButtonType[len];
        for (var i = 0; i < len; i++) {
            data[i] = MouseButtonType.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
        }
        return data;
    }
    
    @Nullable
    public static Vector2i getRelativeMotion(MemorySegment mem) {
        return getRelativeMotion(mem, 0);
    }
    
    @Nullable
    public static Vector2i getRelativeMotion(MemorySegment mem, int offset) {
        return hasRelativeMotion(mem, offset) ? Vector2i.toObject(mem, offset + 1): null;
    }
    
    public static boolean hasRelativeMotion(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasMouseButtonType(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    
    
    public static MouseMotionEvent toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static MouseMotionEvent toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one MouseMotionEvent and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static MouseMotionEvent toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        MouseButtonType[] v0 = null;
        if (hasMouseButtonType(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("MouseButtonType");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("MouseButtonType", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("MouseButtonType", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new MouseButtonType[len];
            for (var i = 0; i < len; i++) {
                v0[i] = MouseButtonType.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
            }
            varPos = off + len - varBase;
        }
        var result = new MouseMotionEvent(
            v0,
            hasRelativeMotion(mem, offset) ? Vector2i.toObject(mem, offset + 1) : null
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.relativeMotion != null) nullBits |= 0x01;
        if (this.mouseButtonType != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.relativeMotion != null) {
            this.relativeMotion.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 8).fill((byte) 0); 
        }
        var varOffset = offset + 9;
        if (this.mouseButtonType != null) {
            
            if (mouseButtonType.length > 4096000) throw ProtocolException.arrayTooLong("MouseButtonType", mouseButtonType.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.mouseButtonType.length);
            
            for (var i = 0; i < this.mouseButtonType.length; i++) {
                mem.set(PacketIO.PROTO_BYTE, varOffset + i * 1, (byte) this.mouseButtonType[i].getValue());
            }
            varOffset += this.mouseButtonType.length * 1;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (mouseButtonType != null) size += VarInt.size(mouseButtonType.length) + mouseButtonType.length * 1;

        return size;
    }

    public MouseMotionEvent clone() {
        MouseMotionEvent copy = new MouseMotionEvent();
        copy.mouseButtonType = this.mouseButtonType != null ? java.util.Arrays.copyOf(this.mouseButtonType, this.mouseButtonType.length) : null;
        copy.relativeMotion = this.relativeMotion != null ? this.relativeMotion.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MouseMotionEvent other)) return false;
        return java.util.Arrays.equals(this.mouseButtonType, other.mouseButtonType) && java.util.Objects.equals(this.relativeMotion, other.relativeMotion);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(mouseButtonType);
        result = 31 * result + java.util.Objects.hashCode(relativeMotion);
        return result;
    }

}