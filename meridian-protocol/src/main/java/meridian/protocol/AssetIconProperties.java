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

public class AssetIconProperties {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 25;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 25;
    public static final int MAX_SIZE = 25;

    public float scale;
    @Nullable public Vector2fc translation;
    @Nullable public Vector3fc rotation;

    public AssetIconProperties() {
    }

    public AssetIconProperties(float scale, @Nullable Vector2fc translation, @Nullable Vector3fc rotation) {
        this.scale = scale;
        this.translation = translation;
        this.rotation = rotation;
    }

    public AssetIconProperties(@Nonnull AssetIconProperties other) {
        this.scale = other.scale;
        this.translation = other.translation;
        this.rotation = other.rotation;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetIconProperties", offset, (int) mem.byteSize());
        long needed = (long) offset + 25;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetIconProperties", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getScale(MemorySegment mem) {
        return getScale(mem, 0);
    }
    
    public static float getScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Scale");
    }
    
    @Nullable
    public static Vector2fc getTranslation(MemorySegment mem) {
        return getTranslation(mem, 0);
    }
    
    @Nullable
    public static Vector2fc getTranslation(MemorySegment mem, int offset) {
        return hasTranslation(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector2f(mem, offset + 5), "Translation"): null;
    }
    
    @Nullable
    public static Vector3fc getRotation(MemorySegment mem) {
        return getRotation(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getRotation(MemorySegment mem, int offset) {
        return hasRotation(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 13), "Rotation"): null;
    }
    
    public static boolean hasTranslation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasRotation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    
    
    public static AssetIconProperties toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetIconProperties toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetIconProperties and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetIconProperties toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new AssetIconProperties(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Scale"),
            hasTranslation(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector2f(mem, offset + 5), "Translation") : null,
            hasRotation(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 13), "Rotation") : null
        );
        if (cursor != null) cursor.position = offset + 25;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.translation != null) nullBits |= 0x01;
        if (this.rotation != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.scale, "Scale"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.scale);
        if (this.translation != null) {
            PacketIO.requireFinite(this.translation, "Translation"); PacketIO.writeVector2f(mem, offset + 5, this.translation);
        } else {
            mem.asSlice(offset + 5, 8).fill((byte) 0); 
        }
        if (this.rotation != null) {
            PacketIO.requireFinite(this.rotation, "Rotation"); PacketIO.writeVector3f(mem, offset + 13, this.rotation);
        } else {
            mem.asSlice(offset + 13, 12).fill((byte) 0); 
        }
        
        
    
       return 25;
    }
    public int computeSize() {
        return 25;
    }

    public AssetIconProperties clone() {
        AssetIconProperties copy = new AssetIconProperties();
        copy.scale = this.scale;
        copy.translation = this.translation;
        copy.rotation = this.rotation;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetIconProperties other)) return false;
        return this.scale == other.scale && java.util.Objects.equals(this.translation, other.translation) && java.util.Objects.equals(this.rotation, other.rotation);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(scale, translation, rotation);
    }

}