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

public class WorldParticle {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 32;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 32;
    public static final int MAX_SIZE = 16384037;

    @Nullable public String systemId;
    public float scale;
    @Nullable public Color color;
    @Nullable public Vector3fc positionOffset;
    @Nullable public Direction rotationOffset;

    public WorldParticle() {
    }

    public WorldParticle(@Nullable String systemId, float scale, @Nullable Color color, @Nullable Vector3fc positionOffset, @Nullable Direction rotationOffset) {
        this.systemId = systemId;
        this.scale = scale;
        this.color = color;
        this.positionOffset = positionOffset;
        this.rotationOffset = rotationOffset;
    }

    public WorldParticle(@Nonnull WorldParticle other) {
        this.systemId = other.systemId;
        this.scale = other.scale;
        this.color = other.color;
        this.positionOffset = other.positionOffset;
        this.rotationOffset = other.rotationOffset;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("WorldParticle", offset, (int) mem.byteSize());
        long needed = (long) offset + 32;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("WorldParticle", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getSystemId(MemorySegment mem) {
        return getSystemId(mem, 0);
    }
    
    @Nullable
    public static String getSystemId(MemorySegment mem, int offset) {
        return hasSystemId(mem, offset) ? PacketIO.readVarString("SystemId", mem, offset + 32, 4096000): null;
    }
    
    public static float getScale(MemorySegment mem) {
        return getScale(mem, 0);
    }
    
    public static float getScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Scale");
    }
    
    @Nullable
    public static Color getColor(MemorySegment mem) {
        return getColor(mem, 0);
    }
    
    @Nullable
    public static Color getColor(MemorySegment mem, int offset) {
        return hasColor(mem, offset) ? Color.toObject(mem, offset + 5): null;
    }
    
    @Nullable
    public static Vector3fc getPositionOffset(MemorySegment mem) {
        return getPositionOffset(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getPositionOffset(MemorySegment mem, int offset) {
        return hasPositionOffset(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 8), "PositionOffset"): null;
    }
    
    @Nullable
    public static Direction getRotationOffset(MemorySegment mem) {
        return getRotationOffset(mem, 0);
    }
    
    @Nullable
    public static Direction getRotationOffset(MemorySegment mem, int offset) {
        return hasRotationOffset(mem, offset) ? Direction.toObject(mem, offset + 20): null;
    }
    
    public static boolean hasColor(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasPositionOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasRotationOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasSystemId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    
    
    public static WorldParticle toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static WorldParticle toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one WorldParticle and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static WorldParticle toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 32;
        var varPos = 0;
        String v0 = null;
        if (hasSystemId(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("SystemId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new WorldParticle(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Scale"),
            hasColor(mem, offset) ? Color.toObject(mem, offset + 5) : null,
            hasPositionOffset(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 8), "PositionOffset") : null,
            hasRotationOffset(mem, offset) ? Direction.toObject(mem, offset + 20) : null
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.color != null) nullBits |= 0x01;
        if (this.positionOffset != null) nullBits |= 0x02;
        if (this.rotationOffset != null) nullBits |= 0x04;
        if (this.systemId != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.scale, "Scale"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.scale);
        if (this.color != null) {
            this.color.serialize(mem, offset + 5);
        } else {
            mem.asSlice(offset + 5, 3).fill((byte) 0); 
        }
        if (this.positionOffset != null) {
            PacketIO.requireFinite(this.positionOffset, "PositionOffset"); PacketIO.writeVector3f(mem, offset + 8, this.positionOffset);
        } else {
            mem.asSlice(offset + 8, 12).fill((byte) 0); 
        }
        if (this.rotationOffset != null) {
            this.rotationOffset.serialize(mem, offset + 20);
        } else {
            mem.asSlice(offset + 20, 12).fill((byte) 0); 
        }
        var varOffset = offset + 32;
        if (this.systemId != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.systemId, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 32;
        if (systemId != null) size += PacketIO.stringSize(systemId);

        return size;
    }

    public WorldParticle clone() {
        WorldParticle copy = new WorldParticle();
        copy.systemId = this.systemId;
        copy.scale = this.scale;
        copy.color = this.color != null ? this.color.clone() : null;
        copy.positionOffset = this.positionOffset;
        copy.rotationOffset = this.rotationOffset != null ? this.rotationOffset.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof WorldParticle other)) return false;
        return java.util.Objects.equals(this.systemId, other.systemId) && this.scale == other.scale && java.util.Objects.equals(this.color, other.color) && java.util.Objects.equals(this.positionOffset, other.positionOffset) && java.util.Objects.equals(this.rotationOffset, other.rotationOffset);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(systemId, scale, color, positionOffset, rotationOffset);
    }

}