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


public class ParticleAnimationFrame {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 58;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 58;
    public static final int MAX_SIZE = 58;

    @Nullable public Range frameIndex;
    @Nullable public RangeVector2f scale;
    @Nullable public RangeVector3f rotation;
    @Nullable public Color color;
    public float opacity;

    public ParticleAnimationFrame() {
    }

    public ParticleAnimationFrame(@Nullable Range frameIndex, @Nullable RangeVector2f scale, @Nullable RangeVector3f rotation, @Nullable Color color, float opacity) {
        this.frameIndex = frameIndex;
        this.scale = scale;
        this.rotation = rotation;
        this.color = color;
        this.opacity = opacity;
    }

    public ParticleAnimationFrame(@Nonnull ParticleAnimationFrame other) {
        this.frameIndex = other.frameIndex;
        this.scale = other.scale;
        this.rotation = other.rotation;
        this.color = other.color;
        this.opacity = other.opacity;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ParticleAnimationFrame", offset, (int) mem.byteSize());
        long needed = (long) offset + 58;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ParticleAnimationFrame", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static Range getFrameIndex(MemorySegment mem) {
        return getFrameIndex(mem, 0);
    }
    
    @Nullable
    public static Range getFrameIndex(MemorySegment mem, int offset) {
        return hasFrameIndex(mem, offset) ? Range.toObject(mem, offset + 1): null;
    }
    
    @Nullable
    public static RangeVector2f getScale(MemorySegment mem) {
        return getScale(mem, 0);
    }
    
    @Nullable
    public static RangeVector2f getScale(MemorySegment mem, int offset) {
        return hasScale(mem, offset) ? RangeVector2f.toObject(mem, offset + 9): null;
    }
    
    @Nullable
    public static RangeVector3f getRotation(MemorySegment mem) {
        return getRotation(mem, 0);
    }
    
    @Nullable
    public static RangeVector3f getRotation(MemorySegment mem, int offset) {
        return hasRotation(mem, offset) ? RangeVector3f.toObject(mem, offset + 26): null;
    }
    
    @Nullable
    public static Color getColor(MemorySegment mem) {
        return getColor(mem, 0);
    }
    
    @Nullable
    public static Color getColor(MemorySegment mem, int offset) {
        return hasColor(mem, offset) ? Color.toObject(mem, offset + 51): null;
    }
    
    public static float getOpacity(MemorySegment mem) {
        return getOpacity(mem, 0);
    }
    
    public static float getOpacity(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 54), "Opacity");
    }
    
    public static boolean hasFrameIndex(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasScale(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasRotation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasColor(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    
    
    public static ParticleAnimationFrame toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ParticleAnimationFrame toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ParticleAnimationFrame and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ParticleAnimationFrame toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new ParticleAnimationFrame(
            hasFrameIndex(mem, offset) ? Range.toObject(mem, offset + 1) : null,
            hasScale(mem, offset) ? RangeVector2f.toObject(mem, offset + 9) : null,
            hasRotation(mem, offset) ? RangeVector3f.toObject(mem, offset + 26) : null,
            hasColor(mem, offset) ? Color.toObject(mem, offset + 51) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 54), "Opacity")
        );
        if (cursor != null) cursor.position = offset + 58;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.frameIndex != null) nullBits |= 0x01;
        if (this.scale != null) nullBits |= 0x02;
        if (this.rotation != null) nullBits |= 0x04;
        if (this.color != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.frameIndex != null) {
            this.frameIndex.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 8).fill((byte) 0); 
        }
        if (this.scale != null) {
            this.scale.serialize(mem, offset + 9);
        } else {
            mem.asSlice(offset + 9, 17).fill((byte) 0); 
        }
        if (this.rotation != null) {
            this.rotation.serialize(mem, offset + 26);
        } else {
            mem.asSlice(offset + 26, 25).fill((byte) 0); 
        }
        if (this.color != null) {
            this.color.serialize(mem, offset + 51);
        } else {
            mem.asSlice(offset + 51, 3).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.opacity, "Opacity"); mem.set(PacketIO.PROTO_FLOAT, offset + 54, this.opacity);
        
        
    
       return 58;
    }
    public int computeSize() {
        return 58;
    }

    public ParticleAnimationFrame clone() {
        ParticleAnimationFrame copy = new ParticleAnimationFrame();
        copy.frameIndex = this.frameIndex != null ? this.frameIndex.clone() : null;
        copy.scale = this.scale != null ? this.scale.clone() : null;
        copy.rotation = this.rotation != null ? this.rotation.clone() : null;
        copy.color = this.color != null ? this.color.clone() : null;
        copy.opacity = this.opacity;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ParticleAnimationFrame other)) return false;
        return java.util.Objects.equals(this.frameIndex, other.frameIndex) && java.util.Objects.equals(this.scale, other.scale) && java.util.Objects.equals(this.rotation, other.rotation) && java.util.Objects.equals(this.color, other.color) && this.opacity == other.opacity;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(frameIndex, scale, rotation, color, opacity);
    }

}