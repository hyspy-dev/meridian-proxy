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


public class PlayerSkinUpdate extends ComponentUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 2104;

    @Nullable public PlayerSkin skin;

    public PlayerSkinUpdate() {
    }

    public PlayerSkinUpdate(@Nullable PlayerSkin skin) {
        this.skin = skin;
    }

    public PlayerSkinUpdate(@Nonnull PlayerSkinUpdate other) {
        this.skin = other.skin;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PlayerSkinUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PlayerSkinUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static PlayerSkin getSkin(MemorySegment mem) {
        return getSkin(mem, 0);
    }
    
    @Nullable
    public static PlayerSkin getSkin(MemorySegment mem, int offset) {
        return hasSkin(mem, offset) ? PlayerSkin.toObject(mem, offset + 1): null;
    }
    
    public static boolean hasSkin(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static PlayerSkinUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PlayerSkinUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PlayerSkinUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PlayerSkinUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        PlayerSkin v0 = null;
        if (hasSkin(mem, offset)) {
            v0 = PlayerSkin.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new PlayerSkinUpdate(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.skin != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.skin != null) {
            
            varOffset += this.skin.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 1;
        if (skin != null) size += skin.computeSize();

        return size;
    }

    public PlayerSkinUpdate clone() {
        PlayerSkinUpdate copy = new PlayerSkinUpdate();
        copy.skin = this.skin != null ? this.skin.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PlayerSkinUpdate other)) return false;
        return java.util.Objects.equals(this.skin, other.skin);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(skin);
    }

}