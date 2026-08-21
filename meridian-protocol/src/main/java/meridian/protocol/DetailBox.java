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
import org.joml.*;

public class DetailBox {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 37;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 37;
    public static final int MAX_SIZE = 37;

    @Nonnull public Vector3fc offset = PacketIO.ZERO_VECTOR3;
    @Nullable public Hitbox box;

    public DetailBox() {
    }

    public DetailBox(@Nonnull Vector3fc offset, @Nullable Hitbox box) {
        this.offset = offset;
        this.box = box;
    }

    public DetailBox(@Nonnull DetailBox other) {
        this.offset = other.offset;
        this.box = other.box;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("DetailBox", offset, (int) mem.byteSize());
        long needed = (long) offset + 37;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("DetailBox", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static Vector3fc getOffset(MemorySegment mem) {
        return getOffset(mem, 0);
    }
    
    public static Vector3fc getOffset(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 1), "Offset");
    }
    
    @Nullable
    public static Hitbox getBox(MemorySegment mem) {
        return getBox(mem, 0);
    }
    
    @Nullable
    public static Hitbox getBox(MemorySegment mem, int offset) {
        return hasBox(mem, offset) ? Hitbox.toObject(mem, offset + 13): null;
    }
    
    public static boolean hasBox(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static DetailBox toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static DetailBox toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one DetailBox and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static DetailBox toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new DetailBox(
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 1), "Offset"),
            hasBox(mem, offset) ? Hitbox.toObject(mem, offset + 13) : null
        );
        if (cursor != null) cursor.position = offset + 37;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.box != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.offset, "Offset"); PacketIO.writeVector3f(mem, offset + 1, this.offset);
        if (this.box != null) {
            this.box.serialize(mem, offset + 13);
        } else {
            mem.asSlice(offset + 13, 24).fill((byte) 0); 
        }
        
        
    
       return 37;
    }
    public int computeSize() {
        return 37;
    }

    public DetailBox clone() {
        DetailBox copy = new DetailBox();
        copy.offset = this.offset;
        copy.box = this.box != null ? this.box.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DetailBox other)) return false;
        return java.util.Objects.equals(this.offset, other.offset) && java.util.Objects.equals(this.box, other.box);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(offset, box);
    }

}