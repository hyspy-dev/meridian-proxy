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

public class PointToolMultiMove implements Packet, ToServerPacket {
    public static final int PACKET_ID = 513;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 12;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 12;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public String[] pointIds = new String[0];
    @Nonnull public Vector3fc moveDelta = PacketIO.ZERO_VECTOR3;

    public PointToolMultiMove() {
    }

    public PointToolMultiMove(@Nonnull String[] pointIds, @Nonnull Vector3fc moveDelta) {
        this.pointIds = pointIds;
        this.moveDelta = moveDelta;
    }

    public PointToolMultiMove(@Nonnull PointToolMultiMove other) {
        this.pointIds = other.pointIds;
        this.moveDelta = other.moveDelta;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PointToolMultiMove", offset, (int) mem.byteSize());
        long needed = (long) offset + 12;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PointToolMultiMove", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String[] getPointIds(MemorySegment mem) {
        return getPointIds(mem, 0);
    }
    
    public static String[] getPointIds(MemorySegment mem, int offset) {
        var off = offset + 12;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("PointIds");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("PointIds", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("PointIds", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("PointIds", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    public static Vector3fc getMoveDelta(MemorySegment mem) {
        return getMoveDelta(mem, 0);
    }
    
    public static Vector3fc getMoveDelta(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 0), "MoveDelta");
    }
    
    
    
    
    
    public static PointToolMultiMove toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PointToolMultiMove toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PointToolMultiMove and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PointToolMultiMove toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 12;
        var varPos = 0;
        String[] v0;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("PointIds");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("PointIds", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("PointIds", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v0[i] = PacketIO.readVarString("PointIds", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        }
        var result = new PointToolMultiMove(
            v0,
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 0), "MoveDelta")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.moveDelta, "MoveDelta"); PacketIO.writeVector3f(mem, offset + 0, this.moveDelta);
        var varOffset = offset + 12;
        if (pointIds.length > 4096000) throw ProtocolException.arrayTooLong("PointIds", pointIds.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.pointIds.length);
        
        var pointIdsValueOffset = 0;
        for (var i = 0; i < this.pointIds.length; i++) {
            pointIdsValueOffset += PacketIO.writeVarString(mem, varOffset + pointIdsValueOffset, this.pointIds[i], 4096000);
        }
        varOffset += pointIdsValueOffset;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 12;
        int pointIdsSize = 0;
for (var elem : pointIds) pointIdsSize += PacketIO.stringSize(elem);
size += VarInt.size(pointIds.length) + pointIdsSize;

        return size;
    }

    public PointToolMultiMove clone() {
        PointToolMultiMove copy = new PointToolMultiMove();
        copy.pointIds = java.util.Arrays.copyOf(this.pointIds, this.pointIds.length);
        copy.moveDelta = this.moveDelta;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PointToolMultiMove other)) return false;
        return java.util.Arrays.equals(this.pointIds, other.pointIds) && java.util.Objects.equals(this.moveDelta, other.moveDelta);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(pointIds);
        result = 31 * result + java.util.Objects.hashCode(moveDelta);
        return result;
    }

}