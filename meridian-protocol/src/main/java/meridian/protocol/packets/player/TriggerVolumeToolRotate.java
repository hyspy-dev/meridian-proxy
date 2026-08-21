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

public class TriggerVolumeToolRotate implements Packet, ToServerPacket {
    public static final int PACKET_ID = 524;
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

    @Nonnull public String volumeId = "";
    @Nonnull public Vector3fc rotation = PacketIO.ZERO_VECTOR3;

    public TriggerVolumeToolRotate() {
    }

    public TriggerVolumeToolRotate(@Nonnull String volumeId, @Nonnull Vector3fc rotation) {
        this.volumeId = volumeId;
        this.rotation = rotation;
    }

    public TriggerVolumeToolRotate(@Nonnull TriggerVolumeToolRotate other) {
        this.volumeId = other.volumeId;
        this.rotation = other.rotation;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("TriggerVolumeToolRotate", offset, (int) mem.byteSize());
        long needed = (long) offset + 12;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("TriggerVolumeToolRotate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getVolumeId(MemorySegment mem) {
        return getVolumeId(mem, 0);
    }
    
    public static String getVolumeId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("VolumeId", mem, offset + 12, 4096000);
    }
    
    public static Vector3fc getRotation(MemorySegment mem) {
        return getRotation(mem, 0);
    }
    
    public static Vector3fc getRotation(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 0), "Rotation");
    }
    
    
    
    
    
    public static TriggerVolumeToolRotate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static TriggerVolumeToolRotate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one TriggerVolumeToolRotate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static TriggerVolumeToolRotate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 12;
        var varPos = 0;
        String v0;
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("VolumeId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new TriggerVolumeToolRotate(
            v0,
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 0), "Rotation")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.rotation, "Rotation"); PacketIO.writeVector3f(mem, offset + 0, this.rotation);
        var varOffset = offset + 12;
        varOffset += PacketIO.writeVarString(mem, varOffset, this.volumeId, 4096000);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 12;
        size += PacketIO.stringSize(volumeId);

        return size;
    }

    public TriggerVolumeToolRotate clone() {
        TriggerVolumeToolRotate copy = new TriggerVolumeToolRotate();
        copy.volumeId = this.volumeId;
        copy.rotation = this.rotation;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TriggerVolumeToolRotate other)) return false;
        return java.util.Objects.equals(this.volumeId, other.volumeId) && java.util.Objects.equals(this.rotation, other.rotation);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(volumeId, rotation);
    }

}