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


public class UVMotion {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 19;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 19;
    public static final int MAX_SIZE = 16384024;

    @Nullable public String texture;
    public boolean addRandomUVOffset;
    public float speedX;
    public float speedY;
    public float scale;
    public float strength;
    @Nonnull public UVMotionCurveType strengthCurveType = UVMotionCurveType.Constant;

    public UVMotion() {
    }

    public UVMotion(@Nullable String texture, boolean addRandomUVOffset, float speedX, float speedY, float scale, float strength, @Nonnull UVMotionCurveType strengthCurveType) {
        this.texture = texture;
        this.addRandomUVOffset = addRandomUVOffset;
        this.speedX = speedX;
        this.speedY = speedY;
        this.scale = scale;
        this.strength = strength;
        this.strengthCurveType = strengthCurveType;
    }

    public UVMotion(@Nonnull UVMotion other) {
        this.texture = other.texture;
        this.addRandomUVOffset = other.addRandomUVOffset;
        this.speedX = other.speedX;
        this.speedY = other.speedY;
        this.scale = other.scale;
        this.strength = other.strength;
        this.strengthCurveType = other.strengthCurveType;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UVMotion", offset, (int) mem.byteSize());
        long needed = (long) offset + 19;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UVMotion", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getTexture(MemorySegment mem) {
        return getTexture(mem, 0);
    }
    
    @Nullable
    public static String getTexture(MemorySegment mem, int offset) {
        return hasTexture(mem, offset) ? PacketIO.readVarString("Texture", mem, offset + 19, 4096000): null;
    }
    
    public static boolean getAddRandomUVOffset(MemorySegment mem) {
        return getAddRandomUVOffset(mem, 0);
    }
    
    public static boolean getAddRandomUVOffset(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 1);
    }
    
    public static float getSpeedX(MemorySegment mem) {
        return getSpeedX(mem, 0);
    }
    
    public static float getSpeedX(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "SpeedX");
    }
    
    public static float getSpeedY(MemorySegment mem) {
        return getSpeedY(mem, 0);
    }
    
    public static float getSpeedY(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 6), "SpeedY");
    }
    
    public static float getScale(MemorySegment mem) {
        return getScale(mem, 0);
    }
    
    public static float getScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 10), "Scale");
    }
    
    public static float getStrength(MemorySegment mem) {
        return getStrength(mem, 0);
    }
    
    public static float getStrength(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 14), "Strength");
    }
    
    public static UVMotionCurveType getStrengthCurveType(MemorySegment mem) {
        return getStrengthCurveType(mem, 0);
    }
    
    public static UVMotionCurveType getStrengthCurveType(MemorySegment mem, int offset) {
        return UVMotionCurveType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 18));
    }
    
    public static boolean hasTexture(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static UVMotion toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UVMotion toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UVMotion and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UVMotion toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 19;
        var varPos = 0;
        String v0 = null;
        if (hasTexture(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Texture", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new UVMotion(
            v0,
            mem.get(PacketIO.PROTO_BOOL, offset + 1),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "SpeedX"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 6), "SpeedY"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 10), "Scale"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 14), "Strength"),
            UVMotionCurveType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 18))
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.texture != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BOOL, offset + 1, this.addRandomUVOffset);
        PacketIO.requireFinite(this.speedX, "SpeedX"); mem.set(PacketIO.PROTO_FLOAT, offset + 2, this.speedX);
        PacketIO.requireFinite(this.speedY, "SpeedY"); mem.set(PacketIO.PROTO_FLOAT, offset + 6, this.speedY);
        PacketIO.requireFinite(this.scale, "Scale"); mem.set(PacketIO.PROTO_FLOAT, offset + 10, this.scale);
        PacketIO.requireFinite(this.strength, "Strength"); mem.set(PacketIO.PROTO_FLOAT, offset + 14, this.strength);
        mem.set(PacketIO.PROTO_BYTE, offset + 18, (byte) this.strengthCurveType.getValue());
        var varOffset = offset + 19;
        if (this.texture != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.texture, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 19;
        if (texture != null) size += PacketIO.stringSize(texture);

        return size;
    }

    public UVMotion clone() {
        UVMotion copy = new UVMotion();
        copy.texture = this.texture;
        copy.addRandomUVOffset = this.addRandomUVOffset;
        copy.speedX = this.speedX;
        copy.speedY = this.speedY;
        copy.scale = this.scale;
        copy.strength = this.strength;
        copy.strengthCurveType = this.strengthCurveType;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UVMotion other)) return false;
        return java.util.Objects.equals(this.texture, other.texture) && this.addRandomUVOffset == other.addRandomUVOffset && this.speedX == other.speedX && this.speedY == other.speedY && this.scale == other.scale && this.strength == other.strength && java.util.Objects.equals(this.strengthCurveType, other.strengthCurveType);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(texture, addRandomUVOffset, speedX, speedY, scale, strength, strengthCurveType);
    }

}