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

public class PointToolMove implements Packet, ToServerPacket {
    public static final int PACKET_ID = 511;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 12;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 12;
    public static final int MAX_SIZE = 16384017;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public String pointId = "";
    @Nonnull public Vector3fc newPosition = PacketIO.ZERO_VECTOR3;

    public PointToolMove() {
    }

    public PointToolMove(@Nonnull String pointId, @Nonnull Vector3fc newPosition) {
        this.pointId = pointId;
        this.newPosition = newPosition;
    }

    public PointToolMove(@Nonnull PointToolMove other) {
        this.pointId = other.pointId;
        this.newPosition = other.newPosition;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PointToolMove", offset, (int) mem.byteSize());
        long needed = (long) offset + 12;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PointToolMove", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getPointId(MemorySegment mem) {
        return getPointId(mem, 0);
    }
    
    public static String getPointId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("PointId", mem, offset + 12, 4096000);
    }
    
    public static Vector3fc getNewPosition(MemorySegment mem) {
        return getNewPosition(mem, 0);
    }
    
    public static Vector3fc getNewPosition(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 0), "NewPosition");
    }
    
    
    
    
    
    public static PointToolMove toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PointToolMove toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PointToolMove and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PointToolMove toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 12;
        var varPos = 0;
        String v0;
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("PointId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new PointToolMove(
            v0,
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 0), "NewPosition")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.newPosition, "NewPosition"); PacketIO.writeVector3f(mem, offset + 0, this.newPosition);
        var varOffset = offset + 12;
        varOffset += PacketIO.writeVarString(mem, varOffset, this.pointId, 4096000);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 12;
        size += PacketIO.stringSize(pointId);

        return size;
    }

    public PointToolMove clone() {
        PointToolMove copy = new PointToolMove();
        copy.pointId = this.pointId;
        copy.newPosition = this.newPosition;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PointToolMove other)) return false;
        return java.util.Objects.equals(this.pointId, other.pointId) && java.util.Objects.equals(this.newPosition, other.newPosition);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(pointId, newPosition);
    }

}