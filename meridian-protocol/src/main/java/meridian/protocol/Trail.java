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


public class Trail {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 61;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 69;
    public static final int MAX_SIZE = 32768079;

    @Nullable public String id;
    @Nullable public String texture;
    public int lifeSpan;
    public float roll;
    @Nullable public Edge start;
    @Nullable public Edge end;
    public float lightInfluence;
    @Nonnull public FXRenderMode renderMode = FXRenderMode.BlendLinear;
    @Nullable public IntersectionHighlight intersectionHighlight;
    public boolean smooth;
    @Nullable public Vector2i frameSize;
    @Nullable public Range frameRange;
    public int frameLifeSpan;

    public Trail() {
    }

    public Trail(@Nullable String id, @Nullable String texture, int lifeSpan, float roll, @Nullable Edge start, @Nullable Edge end, float lightInfluence, @Nonnull FXRenderMode renderMode, @Nullable IntersectionHighlight intersectionHighlight, boolean smooth, @Nullable Vector2i frameSize, @Nullable Range frameRange, int frameLifeSpan) {
        this.id = id;
        this.texture = texture;
        this.lifeSpan = lifeSpan;
        this.roll = roll;
        this.start = start;
        this.end = end;
        this.lightInfluence = lightInfluence;
        this.renderMode = renderMode;
        this.intersectionHighlight = intersectionHighlight;
        this.smooth = smooth;
        this.frameSize = frameSize;
        this.frameRange = frameRange;
        this.frameLifeSpan = frameLifeSpan;
    }

    public Trail(@Nonnull Trail other) {
        this.id = other.id;
        this.texture = other.texture;
        this.lifeSpan = other.lifeSpan;
        this.roll = other.roll;
        this.start = other.start;
        this.end = other.end;
        this.lightInfluence = other.lightInfluence;
        this.renderMode = other.renderMode;
        this.intersectionHighlight = other.intersectionHighlight;
        this.smooth = other.smooth;
        this.frameSize = other.frameSize;
        this.frameRange = other.frameRange;
        this.frameLifeSpan = other.frameLifeSpan;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Trail", offset, (int) mem.byteSize());
        long needed = (long) offset + 69;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Trail", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 61, 69, "Id"), 4096000): null;
    }
    
    @Nullable
    public static String getTexture(MemorySegment mem) {
        return getTexture(mem, 0);
    }
    
    @Nullable
    public static String getTexture(MemorySegment mem, int offset) {
        return hasTexture(mem, offset) ? PacketIO.readVarString("Texture", mem, offset + getValidatedOffset(mem, offset, 65, 69, "Texture"), 4096000): null;
    }
    
    public static int getLifeSpan(MemorySegment mem) {
        return getLifeSpan(mem, 0);
    }
    
    public static int getLifeSpan(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static float getRoll(MemorySegment mem) {
        return getRoll(mem, 0);
    }
    
    public static float getRoll(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "Roll");
    }
    
    @Nullable
    public static Edge getStart(MemorySegment mem) {
        return getStart(mem, 0);
    }
    
    @Nullable
    public static Edge getStart(MemorySegment mem, int offset) {
        return hasStart(mem, offset) ? Edge.toObject(mem, offset + 9): null;
    }
    
    @Nullable
    public static Edge getEnd(MemorySegment mem) {
        return getEnd(mem, 0);
    }
    
    @Nullable
    public static Edge getEnd(MemorySegment mem, int offset) {
        return hasEnd(mem, offset) ? Edge.toObject(mem, offset + 18): null;
    }
    
    public static float getLightInfluence(MemorySegment mem) {
        return getLightInfluence(mem, 0);
    }
    
    public static float getLightInfluence(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 27), "LightInfluence");
    }
    
    public static FXRenderMode getRenderMode(MemorySegment mem) {
        return getRenderMode(mem, 0);
    }
    
    public static FXRenderMode getRenderMode(MemorySegment mem, int offset) {
        return FXRenderMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 31));
    }
    
    @Nullable
    public static IntersectionHighlight getIntersectionHighlight(MemorySegment mem) {
        return getIntersectionHighlight(mem, 0);
    }
    
    @Nullable
    public static IntersectionHighlight getIntersectionHighlight(MemorySegment mem, int offset) {
        return hasIntersectionHighlight(mem, offset) ? IntersectionHighlight.toObject(mem, offset + 32): null;
    }
    
    public static boolean getSmooth(MemorySegment mem) {
        return getSmooth(mem, 0);
    }
    
    public static boolean getSmooth(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 40);
    }
    
    @Nullable
    public static Vector2i getFrameSize(MemorySegment mem) {
        return getFrameSize(mem, 0);
    }
    
    @Nullable
    public static Vector2i getFrameSize(MemorySegment mem, int offset) {
        return hasFrameSize(mem, offset) ? Vector2i.toObject(mem, offset + 41): null;
    }
    
    @Nullable
    public static Range getFrameRange(MemorySegment mem) {
        return getFrameRange(mem, 0);
    }
    
    @Nullable
    public static Range getFrameRange(MemorySegment mem, int offset) {
        return hasFrameRange(mem, offset) ? Range.toObject(mem, offset + 49): null;
    }
    
    public static int getFrameLifeSpan(MemorySegment mem) {
        return getFrameLifeSpan(mem, 0);
    }
    
    public static int getFrameLifeSpan(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 57);
    }
    
    public static boolean hasStart(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasEnd(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasIntersectionHighlight(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasFrameSize(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasFrameRange(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasTexture(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    private static int getValidatedOffset(MemorySegment buffer, int base, int slotPosition, int varBlockStart, String fieldName) {
        int offset = buffer.get(PacketIO.PROTO_INT, base + slotPosition);
        if (offset < 0 || offset > buffer.byteSize() - base - varBlockStart)
            throw ProtocolException.invalidOffset(fieldName, offset, (int) buffer.byteSize());
        return varBlockStart + offset;
    }
    
    /**
     * Rejects an offset slot that does not name the position the field-order walk reached. A
     * present field must sit where the previous field ended, and an absent field carries -1, so
     * the slot a random-access getter resolves and the walk describe the same bytes.
     */
    private static void requireSlot(MemorySegment mem, int slotPosition, int expected, String fieldName) {
        int slot = mem.get(PacketIO.PROTO_INT, slotPosition);
        if (slot != expected) throw ProtocolException.nonCanonicalLayout(fieldName, slot, expected);
    }
    
    public static Trail toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Trail toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Trail and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Trail toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 69;
        var varPos = 0;
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 61, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 61, -1, "Id");
        }
        
        String v1 = null;
        if (hasTexture(mem, offset)) {
            requireSlot(mem, offset + 65, varPos, "Texture");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Texture", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 65, -1, "Texture");
        }
        var result = new Trail(
            v0,
            v1,
            mem.get(PacketIO.PROTO_INT, offset + 1),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "Roll"),
            hasStart(mem, offset) ? Edge.toObject(mem, offset + 9) : null,
            hasEnd(mem, offset) ? Edge.toObject(mem, offset + 18) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 27), "LightInfluence"),
            FXRenderMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 31)),
            hasIntersectionHighlight(mem, offset) ? IntersectionHighlight.toObject(mem, offset + 32) : null,
            mem.get(PacketIO.PROTO_BOOL, offset + 40),
            hasFrameSize(mem, offset) ? Vector2i.toObject(mem, offset + 41) : null,
            hasFrameRange(mem, offset) ? Range.toObject(mem, offset + 49) : null,
            mem.get(PacketIO.PROTO_INT, offset + 57)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.start != null) nullBits |= 0x01;
        if (this.end != null) nullBits |= 0x02;
        if (this.intersectionHighlight != null) nullBits |= 0x04;
        if (this.frameSize != null) nullBits |= 0x08;
        if (this.frameRange != null) nullBits |= 0x10;
        if (this.id != null) nullBits |= 0x20;
        if (this.texture != null) nullBits |= 0x40;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.lifeSpan);
        PacketIO.requireFinite(this.roll, "Roll"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.roll);
        if (this.start != null) {
            this.start.serialize(mem, offset + 9);
        } else {
            mem.asSlice(offset + 9, 9).fill((byte) 0); 
        }
        if (this.end != null) {
            this.end.serialize(mem, offset + 18);
        } else {
            mem.asSlice(offset + 18, 9).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.lightInfluence, "LightInfluence"); mem.set(PacketIO.PROTO_FLOAT, offset + 27, this.lightInfluence);
        mem.set(PacketIO.PROTO_BYTE, offset + 31, (byte) this.renderMode.getValue());
        if (this.intersectionHighlight != null) {
            this.intersectionHighlight.serialize(mem, offset + 32);
        } else {
            mem.asSlice(offset + 32, 8).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BOOL, offset + 40, this.smooth);
        if (this.frameSize != null) {
            this.frameSize.serialize(mem, offset + 41);
        } else {
            mem.asSlice(offset + 41, 8).fill((byte) 0); 
        }
        if (this.frameRange != null) {
            this.frameRange.serialize(mem, offset + 49);
        } else {
            mem.asSlice(offset + 49, 8).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_INT, offset + 57, this.frameLifeSpan);
        var varOffset = offset + 69;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 61, varOffset - offset - 69);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 61, -1);
        }
        if (this.texture != null) {
            mem.set(PacketIO.PROTO_INT, offset + 65, varOffset - offset - 69);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.texture, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 65, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 69;
        if (id != null) size += PacketIO.stringSize(id);
    if (texture != null) size += PacketIO.stringSize(texture);

        return size;
    }

    public Trail clone() {
        Trail copy = new Trail();
        copy.id = this.id;
        copy.texture = this.texture;
        copy.lifeSpan = this.lifeSpan;
        copy.roll = this.roll;
        copy.start = this.start != null ? this.start.clone() : null;
        copy.end = this.end != null ? this.end.clone() : null;
        copy.lightInfluence = this.lightInfluence;
        copy.renderMode = this.renderMode;
        copy.intersectionHighlight = this.intersectionHighlight != null ? this.intersectionHighlight.clone() : null;
        copy.smooth = this.smooth;
        copy.frameSize = this.frameSize != null ? this.frameSize.clone() : null;
        copy.frameRange = this.frameRange != null ? this.frameRange.clone() : null;
        copy.frameLifeSpan = this.frameLifeSpan;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Trail other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.texture, other.texture) && this.lifeSpan == other.lifeSpan && this.roll == other.roll && java.util.Objects.equals(this.start, other.start) && java.util.Objects.equals(this.end, other.end) && this.lightInfluence == other.lightInfluence && java.util.Objects.equals(this.renderMode, other.renderMode) && java.util.Objects.equals(this.intersectionHighlight, other.intersectionHighlight) && this.smooth == other.smooth && java.util.Objects.equals(this.frameSize, other.frameSize) && java.util.Objects.equals(this.frameRange, other.frameRange) && this.frameLifeSpan == other.frameLifeSpan;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, texture, lifeSpan, roll, start, end, lightInfluence, renderMode, intersectionHighlight, smooth, frameSize, frameRange, frameLifeSpan);
    }

}