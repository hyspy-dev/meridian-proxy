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

public class TriggerVolumeToolGroupMove implements Packet, ToServerPacket {
    public static final int PACKET_ID = 489;
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

    @Nonnull public String groupId = "";
    @Nonnull public Vector3fc moveDelta = PacketIO.ZERO_VECTOR3;

    public TriggerVolumeToolGroupMove() {
    }

    public TriggerVolumeToolGroupMove(@Nonnull String groupId, @Nonnull Vector3fc moveDelta) {
        this.groupId = groupId;
        this.moveDelta = moveDelta;
    }

    public TriggerVolumeToolGroupMove(@Nonnull TriggerVolumeToolGroupMove other) {
        this.groupId = other.groupId;
        this.moveDelta = other.moveDelta;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("TriggerVolumeToolGroupMove", offset, (int) mem.byteSize());
        long needed = (long) offset + 12;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("TriggerVolumeToolGroupMove", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getGroupId(MemorySegment mem) {
        return getGroupId(mem, 0);
    }
    
    public static String getGroupId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("GroupId", mem, offset + 12, 4096000);
    }
    
    public static Vector3fc getMoveDelta(MemorySegment mem) {
        return getMoveDelta(mem, 0);
    }
    
    public static Vector3fc getMoveDelta(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 0), "MoveDelta");
    }
    
    
    
    
    
    public static TriggerVolumeToolGroupMove toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static TriggerVolumeToolGroupMove toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one TriggerVolumeToolGroupMove and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static TriggerVolumeToolGroupMove toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 12;
        var varPos = 0;
        String v0;
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("GroupId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new TriggerVolumeToolGroupMove(
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
        varOffset += PacketIO.writeVarString(mem, varOffset, this.groupId, 4096000);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 12;
        size += PacketIO.stringSize(groupId);

        return size;
    }

    public TriggerVolumeToolGroupMove clone() {
        TriggerVolumeToolGroupMove copy = new TriggerVolumeToolGroupMove();
        copy.groupId = this.groupId;
        copy.moveDelta = this.moveDelta;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TriggerVolumeToolGroupMove other)) return false;
        return java.util.Objects.equals(this.groupId, other.groupId) && java.util.Objects.equals(this.moveDelta, other.moveDelta);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(groupId, moveDelta);
    }

}