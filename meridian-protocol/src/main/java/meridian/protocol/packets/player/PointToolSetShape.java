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
import org.joml.*;

public class PointToolSetShape implements Packet, ToServerPacket {
    public static final int PACKET_ID = 523;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 13;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 16384018;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public String pointId = "";
    @Nonnull public PointShapeType shape = PointShapeType.Block;
    @Nonnull public Vector3fc newPosition = PacketIO.ZERO_VECTOR3;

    public PointToolSetShape() {
    }

    public PointToolSetShape(@Nonnull String pointId, @Nonnull PointShapeType shape, @Nonnull Vector3fc newPosition) {
        this.pointId = pointId;
        this.shape = shape;
        this.newPosition = newPosition;
    }

    public PointToolSetShape(@Nonnull PointToolSetShape other) {
        this.pointId = other.pointId;
        this.shape = other.shape;
        this.newPosition = other.newPosition;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PointToolSetShape", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PointToolSetShape", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getPointId(MemorySegment mem) {
        return getPointId(mem, 0);
    }
    
    public static String getPointId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("PointId", mem, offset + 13, 4096000);
    }
    
    public static PointShapeType getShape(MemorySegment mem) {
        return getShape(mem, 0);
    }
    
    public static PointShapeType getShape(MemorySegment mem, int offset) {
        return PointShapeType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0));
    }
    
    public static Vector3fc getNewPosition(MemorySegment mem) {
        return getNewPosition(mem, 0);
    }
    
    public static Vector3fc getNewPosition(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 1), "NewPosition");
    }
    
    
    
    
    
    public static PointToolSetShape toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PointToolSetShape toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PointToolSetShape and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PointToolSetShape toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 13;
        var varPos = 0;
        String v0;
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("PointId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new PointToolSetShape(
            v0,
            PointShapeType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0)),
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 1), "NewPosition")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, (byte) this.shape.getValue());
        PacketIO.requireFinite(this.newPosition, "NewPosition"); PacketIO.writeVector3f(mem, offset + 1, this.newPosition);
        var varOffset = offset + 13;
        varOffset += PacketIO.writeVarString(mem, varOffset, this.pointId, 4096000);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 13;
        size += PacketIO.stringSize(pointId);

        return size;
    }

    public PointToolSetShape clone() {
        PointToolSetShape copy = new PointToolSetShape();
        copy.pointId = this.pointId;
        copy.shape = this.shape;
        copy.newPosition = this.newPosition;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PointToolSetShape other)) return false;
        return java.util.Objects.equals(this.pointId, other.pointId) && java.util.Objects.equals(this.shape, other.shape) && java.util.Objects.equals(this.newPosition, other.newPosition);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(pointId, shape, newPosition);
    }

}