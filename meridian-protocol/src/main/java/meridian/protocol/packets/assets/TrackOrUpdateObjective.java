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
import meridian.protocol.Objective;

public class TrackOrUpdateObjective implements Packet, ToClientPacket {
    public static final int PACKET_ID = 69;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public Objective objective;

    public TrackOrUpdateObjective() {
    }

    public TrackOrUpdateObjective(@Nullable Objective objective) {
        this.objective = objective;
    }

    public TrackOrUpdateObjective(@Nonnull TrackOrUpdateObjective other) {
        this.objective = other.objective;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("TrackOrUpdateObjective", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("TrackOrUpdateObjective", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static Objective getObjective(MemorySegment mem) {
        return getObjective(mem, 0);
    }
    
    @Nullable
    public static Objective getObjective(MemorySegment mem, int offset) {
        return hasObjective(mem, offset) ? Objective.toObject(mem, offset + 1): null;
    }
    
    public static boolean hasObjective(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static TrackOrUpdateObjective toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static TrackOrUpdateObjective toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one TrackOrUpdateObjective and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static TrackOrUpdateObjective toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        Objective v0 = null;
        if (hasObjective(mem, offset)) {
            v0 = Objective.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new TrackOrUpdateObjective(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.objective != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.objective != null) {
            
            varOffset += this.objective.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (objective != null) size += objective.computeSize();

        return size;
    }

    public TrackOrUpdateObjective clone() {
        TrackOrUpdateObjective copy = new TrackOrUpdateObjective();
        copy.objective = this.objective != null ? this.objective.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TrackOrUpdateObjective other)) return false;
        return java.util.Objects.equals(this.objective, other.objective);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(objective);
    }

}