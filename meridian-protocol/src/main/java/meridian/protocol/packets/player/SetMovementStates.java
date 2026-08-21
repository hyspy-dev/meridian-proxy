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
import meridian.protocol.SavedMovementStates;

public class SetMovementStates implements Packet, ToClientPacket {
    public static final int PACKET_ID = 102;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 2;
    public static final int MAX_SIZE = 2;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public SavedMovementStates movementStates;

    public SetMovementStates() {
    }

    public SetMovementStates(@Nullable SavedMovementStates movementStates) {
        this.movementStates = movementStates;
    }

    public SetMovementStates(@Nonnull SetMovementStates other) {
        this.movementStates = other.movementStates;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SetMovementStates", offset, (int) mem.byteSize());
        long needed = (long) offset + 2;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SetMovementStates", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static SavedMovementStates getMovementStates(MemorySegment mem) {
        return getMovementStates(mem, 0);
    }
    
    @Nullable
    public static SavedMovementStates getMovementStates(MemorySegment mem, int offset) {
        return hasMovementStates(mem, offset) ? SavedMovementStates.toObject(mem, offset + 1): null;
    }
    
    public static boolean hasMovementStates(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static SetMovementStates toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SetMovementStates toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SetMovementStates and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SetMovementStates toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new SetMovementStates(
            hasMovementStates(mem, offset) ? SavedMovementStates.toObject(mem, offset + 1) : null
        );
        if (cursor != null) cursor.position = offset + 2;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.movementStates != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.movementStates != null) {
            this.movementStates.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 1).fill((byte) 0); 
        }
        
        
    
       return 2;
    }
    public int computeSize() {
        return 2;
    }

    public SetMovementStates clone() {
        SetMovementStates copy = new SetMovementStates();
        copy.movementStates = this.movementStates != null ? this.movementStates.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SetMovementStates other)) return false;
        return java.util.Objects.equals(this.movementStates, other.movementStates);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(movementStates);
    }

}