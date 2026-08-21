// Auto-generated - do not edit
package meridian.protocol.packets.player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.NetworkChannel;
import meridian.protocol.Packet;
import meridian.protocol.ToServerPacket;
import meridian.protocol.ToClientPacket;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import meridian.protocol.DebugShape;
import org.joml.*;

public class DisplayDebug implements Packet, ToClientPacket {
    public static final int PACKET_ID = 114;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 23;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 31;
    public static final int MAX_SIZE = 32768041;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public DebugShape shape = DebugShape.Sphere;
    @Nullable public float[] matrix;
    @Nonnull public Vector3fc color = PacketIO.ZERO_VECTOR3;
    public float time;
    @Nonnull public byte flags;
    @Nullable public float[] frustumProjection;
    public float opacity;

    public DisplayDebug() {
    }

    public DisplayDebug(@Nonnull DebugShape shape, @Nullable float[] matrix, @Nonnull Vector3fc color, float time, @Nonnull byte flags, @Nullable float[] frustumProjection, float opacity) {
        this.shape = shape;
        this.matrix = matrix;
        this.color = color;
        this.time = time;
        this.flags = flags;
        this.frustumProjection = frustumProjection;
        this.opacity = opacity;
    }

    public DisplayDebug(@Nonnull DisplayDebug other) {
        this.shape = other.shape;
        this.matrix = other.matrix;
        this.color = other.color;
        this.time = other.time;
        this.flags = other.flags;
        this.frustumProjection = other.frustumProjection;
        this.opacity = other.opacity;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("DisplayDebug", offset, (int) mem.byteSize());
        long needed = (long) offset + 31;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("DisplayDebug", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static DebugShape getShape(MemorySegment mem) {
        return getShape(mem, 0);
    }
    
    public static DebugShape getShape(MemorySegment mem, int offset) {
        return DebugShape.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static float[] getMatrix(MemorySegment mem) {
        return getMatrix(mem, 0);
    }
    
    @Nullable
    public static float[] getMatrix(MemorySegment mem, int offset) {
        if (!hasMatrix(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 23, 31, "Matrix");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Matrix");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Matrix", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Matrix", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new float[len];
        MemorySegment.copy(mem, PacketIO.PROTO_FLOAT, off, data, 0, len);
        return data;
    }
    
    public static Vector3fc getColor(MemorySegment mem) {
        return getColor(mem, 0);
    }
    
    public static Vector3fc getColor(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 2), "Color");
    }
    
    public static float getTime(MemorySegment mem) {
        return getTime(mem, 0);
    }
    
    public static float getTime(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 14), "Time");
    }
    
    public static byte getFlags(MemorySegment mem) {
        return getFlags(mem, 0);
    }
    
    public static byte getFlags(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 18);
    }
    
    @Nullable
    public static float[] getFrustumProjection(MemorySegment mem) {
        return getFrustumProjection(mem, 0);
    }
    
    @Nullable
    public static float[] getFrustumProjection(MemorySegment mem, int offset) {
        if (!hasFrustumProjection(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 27, 31, "FrustumProjection");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("FrustumProjection");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("FrustumProjection", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FrustumProjection", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new float[len];
        MemorySegment.copy(mem, PacketIO.PROTO_FLOAT, off, data, 0, len);
        return data;
    }
    
    public static float getOpacity(MemorySegment mem) {
        return getOpacity(mem, 0);
    }
    
    public static float getOpacity(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 19), "Opacity");
    }
    
    public static boolean hasMatrix(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasFrustumProjection(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
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
    
    public static DisplayDebug toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static DisplayDebug toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one DisplayDebug and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static DisplayDebug toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 31;
        var varPos = 0;
        float[] v1 = null;
        if (hasMatrix(mem, offset)) {
            requireSlot(mem, offset + 23, varPos, "Matrix");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Matrix");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Matrix", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Matrix", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new float[len];
            MemorySegment.copy(mem, PacketIO.PROTO_FLOAT, off, v1, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 23, -1, "Matrix");
        }
        
        float[] v5 = null;
        if (hasFrustumProjection(mem, offset)) {
            requireSlot(mem, offset + 27, varPos, "FrustumProjection");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("FrustumProjection");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("FrustumProjection", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FrustumProjection", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v5 = new float[len];
            MemorySegment.copy(mem, PacketIO.PROTO_FLOAT, off, v5, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 27, -1, "FrustumProjection");
        }
        var result = new DisplayDebug(
            DebugShape.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v1,
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 2), "Color"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 14), "Time"),
            mem.get(PacketIO.PROTO_BYTE, offset + 18),
            v5,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 19), "Opacity")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.matrix != null) nullBits |= 0x01;
        if (this.frustumProjection != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.shape.getValue());
        PacketIO.requireFinite(this.color, "Color"); PacketIO.writeVector3f(mem, offset + 2, this.color);
        PacketIO.requireFinite(this.time, "Time"); mem.set(PacketIO.PROTO_FLOAT, offset + 14, this.time);
        mem.set(PacketIO.PROTO_BYTE, offset + 18, this.flags);
        PacketIO.requireFinite(this.opacity, "Opacity"); mem.set(PacketIO.PROTO_FLOAT, offset + 19, this.opacity);
        var varOffset = offset + 31;
        if (this.matrix != null) {
            mem.set(PacketIO.PROTO_INT, offset + 23, varOffset - offset - 31);
            if (matrix.length > 4096000) throw ProtocolException.arrayTooLong("Matrix", matrix.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.matrix.length);
            
            MemorySegment.copy(this.matrix, 0, mem, PacketIO.PROTO_FLOAT, varOffset, this.matrix.length);
            varOffset += this.matrix.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 23, -1);
        }
        if (this.frustumProjection != null) {
            mem.set(PacketIO.PROTO_INT, offset + 27, varOffset - offset - 31);
            if (frustumProjection.length > 4096000) throw ProtocolException.arrayTooLong("FrustumProjection", frustumProjection.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.frustumProjection.length);
            
            MemorySegment.copy(this.frustumProjection, 0, mem, PacketIO.PROTO_FLOAT, varOffset, this.frustumProjection.length);
            varOffset += this.frustumProjection.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 27, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 31;
        if (matrix != null) size += VarInt.size(matrix.length) + matrix.length * 4;
    if (frustumProjection != null) size += VarInt.size(frustumProjection.length) + frustumProjection.length * 4;

        return size;
    }

    public DisplayDebug clone() {
        DisplayDebug copy = new DisplayDebug();
        copy.shape = this.shape;
        copy.matrix = this.matrix != null ? java.util.Arrays.copyOf(this.matrix, this.matrix.length) : null;
        copy.color = this.color;
        copy.time = this.time;
        copy.flags = this.flags;
        copy.frustumProjection = this.frustumProjection != null ? java.util.Arrays.copyOf(this.frustumProjection, this.frustumProjection.length) : null;
        copy.opacity = this.opacity;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DisplayDebug other)) return false;
        return java.util.Objects.equals(this.shape, other.shape) && java.util.Arrays.equals(this.matrix, other.matrix) && java.util.Objects.equals(this.color, other.color) && this.time == other.time && java.util.Objects.equals(this.flags, other.flags) && java.util.Arrays.equals(this.frustumProjection, other.frustumProjection) && this.opacity == other.opacity;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(shape);
        result = 31 * result + java.util.Arrays.hashCode(matrix);
        result = 31 * result + java.util.Objects.hashCode(color);
        result = 31 * result + Float.hashCode(time);
        result = 31 * result + java.util.Objects.hashCode(flags);
        result = 31 * result + java.util.Arrays.hashCode(frustumProjection);
        result = 31 * result + Float.hashCode(opacity);
        return result;
    }

}