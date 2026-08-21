// Auto-generated - do not edit
package meridian.protocol.packets.entities;

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
import meridian.protocol.Direction;
import meridian.protocol.MovementStates;
import meridian.protocol.Position;

public class MountMovement implements Packet, ToServerPacket {
    public static final int PACKET_ID = 166;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 40;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 40;
    public static final int MAX_SIZE = 40;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public Position absolutePosition = new Position();
    @Nonnull public Direction bodyOrientation = new Direction();
    @Nonnull public MovementStates movementStates = new MovementStates();

    public MountMovement() {
    }

    public MountMovement(@Nonnull Position absolutePosition, @Nonnull Direction bodyOrientation, @Nonnull MovementStates movementStates) {
        this.absolutePosition = absolutePosition;
        this.bodyOrientation = bodyOrientation;
        this.movementStates = movementStates;
    }

    public MountMovement(@Nonnull MountMovement other) {
        this.absolutePosition = other.absolutePosition;
        this.bodyOrientation = other.bodyOrientation;
        this.movementStates = other.movementStates;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("MountMovement", offset, (int) mem.byteSize());
        long needed = (long) offset + 40;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("MountMovement", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static Position getAbsolutePosition(MemorySegment mem) {
        return getAbsolutePosition(mem, 0);
    }
    
    public static Position getAbsolutePosition(MemorySegment mem, int offset) {
        return Position.toObject(mem, offset + 0);
    }
    
    public static Direction getBodyOrientation(MemorySegment mem) {
        return getBodyOrientation(mem, 0);
    }
    
    public static Direction getBodyOrientation(MemorySegment mem, int offset) {
        return Direction.toObject(mem, offset + 24);
    }
    
    public static MovementStates getMovementStates(MemorySegment mem) {
        return getMovementStates(mem, 0);
    }
    
    public static MovementStates getMovementStates(MemorySegment mem, int offset) {
        return MovementStates.toObject(mem, offset + 36);
    }
    
    
    
    
    
    public static MountMovement toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static MountMovement toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one MountMovement and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static MountMovement toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new MountMovement(
            Position.toObject(mem, offset + 0),
            Direction.toObject(mem, offset + 24),
            MovementStates.toObject(mem, offset + 36)
        );
        if (cursor != null) cursor.position = offset + 40;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        this.absolutePosition.serialize(mem, offset + 0);
        this.bodyOrientation.serialize(mem, offset + 24);
        this.movementStates.serialize(mem, offset + 36);
        
        
    
       return 40;
    }
    public int computeSize() {
        return 40;
    }

    public MountMovement clone() {
        MountMovement copy = new MountMovement();
        copy.absolutePosition = this.absolutePosition.clone();
        copy.bodyOrientation = this.bodyOrientation.clone();
        copy.movementStates = this.movementStates.clone();
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MountMovement other)) return false;
        return java.util.Objects.equals(this.absolutePosition, other.absolutePosition) && java.util.Objects.equals(this.bodyOrientation, other.bodyOrientation) && java.util.Objects.equals(this.movementStates, other.movementStates);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(absolutePosition, bodyOrientation, movementStates);
    }

}