// Auto-generated - do not edit
package meridian.protocol.packets.assets;

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
import java.util.UUID;

public class UntrackObjective implements Packet, ToClientPacket {
    public static final int PACKET_ID = 70;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 16;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 16;
    public static final int MAX_SIZE = 16;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public java.util.UUID objectiveUuid = new java.util.UUID(0L, 0L);

    public UntrackObjective() {
    }

    public UntrackObjective(@Nonnull java.util.UUID objectiveUuid) {
        this.objectiveUuid = objectiveUuid;
    }

    public UntrackObjective(@Nonnull UntrackObjective other) {
        this.objectiveUuid = other.objectiveUuid;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UntrackObjective", offset, (int) mem.byteSize());
        long needed = (long) offset + 16;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UntrackObjective", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static java.util.UUID getObjectiveUuid(MemorySegment mem) {
        return getObjectiveUuid(mem, 0);
    }
    
    public static java.util.UUID getObjectiveUuid(MemorySegment mem, int offset) {
        return PacketIO.readUUID(mem, offset + 0);
    }
    
    
    
    
    
    public static UntrackObjective toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UntrackObjective toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UntrackObjective and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UntrackObjective toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new UntrackObjective(
            PacketIO.readUUID(mem, offset + 0)
        );
        if (cursor != null) cursor.position = offset + 16;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.writeUUID(mem, offset + 0, this.objectiveUuid);
        
        
    
       return 16;
    }
    public int computeSize() {
        return 16;
    }

    public UntrackObjective clone() {
        UntrackObjective copy = new UntrackObjective();
        copy.objectiveUuid = this.objectiveUuid;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UntrackObjective other)) return false;
        return java.util.Objects.equals(this.objectiveUuid, other.objectiveUuid);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(objectiveUuid);
    }

}