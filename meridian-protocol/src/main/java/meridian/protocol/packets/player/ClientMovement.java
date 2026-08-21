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
import meridian.protocol.Direction;
import meridian.protocol.HalfFloatPosition;
import meridian.protocol.MovementStates;
import meridian.protocol.Position;
import meridian.protocol.TeleportAck;
import meridian.protocol.Vector3d;

public class ClientMovement implements Packet, ToServerPacket {
    public static final int PACKET_ID = 108;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 2;
    public static final int FIXED_BLOCK_SIZE = 117;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 117;
    public static final int MAX_SIZE = 117;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public MovementStates movementStates;
    @Nullable public HalfFloatPosition relativePosition;
    @Nullable public Position absolutePosition;
    @Nullable public Direction bodyOrientation;
    @Nullable public Direction lookOrientation;
    @Nullable public TeleportAck teleportAck;
    @Nullable public Position wishMovement;
    @Nullable public Vector3d velocity;
    public int mountedTo;
    @Nullable public MovementStates riderMovementStates;

    public ClientMovement() {
    }

    public ClientMovement(@Nullable MovementStates movementStates, @Nullable HalfFloatPosition relativePosition, @Nullable Position absolutePosition, @Nullable Direction bodyOrientation, @Nullable Direction lookOrientation, @Nullable TeleportAck teleportAck, @Nullable Position wishMovement, @Nullable Vector3d velocity, int mountedTo, @Nullable MovementStates riderMovementStates) {
        this.movementStates = movementStates;
        this.relativePosition = relativePosition;
        this.absolutePosition = absolutePosition;
        this.bodyOrientation = bodyOrientation;
        this.lookOrientation = lookOrientation;
        this.teleportAck = teleportAck;
        this.wishMovement = wishMovement;
        this.velocity = velocity;
        this.mountedTo = mountedTo;
        this.riderMovementStates = riderMovementStates;
    }

    public ClientMovement(@Nonnull ClientMovement other) {
        this.movementStates = other.movementStates;
        this.relativePosition = other.relativePosition;
        this.absolutePosition = other.absolutePosition;
        this.bodyOrientation = other.bodyOrientation;
        this.lookOrientation = other.lookOrientation;
        this.teleportAck = other.teleportAck;
        this.wishMovement = other.wishMovement;
        this.velocity = other.velocity;
        this.mountedTo = other.mountedTo;
        this.riderMovementStates = other.riderMovementStates;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ClientMovement", offset, (int) mem.byteSize());
        long needed = (long) offset + 117;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ClientMovement", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static MovementStates getMovementStates(MemorySegment mem) {
        return getMovementStates(mem, 0);
    }
    
    @Nullable
    public static MovementStates getMovementStates(MemorySegment mem, int offset) {
        return hasMovementStates(mem, offset) ? MovementStates.toObject(mem, offset + 2): null;
    }
    
    @Nullable
    public static HalfFloatPosition getRelativePosition(MemorySegment mem) {
        return getRelativePosition(mem, 0);
    }
    
    @Nullable
    public static HalfFloatPosition getRelativePosition(MemorySegment mem, int offset) {
        return hasRelativePosition(mem, offset) ? HalfFloatPosition.toObject(mem, offset + 6): null;
    }
    
    @Nullable
    public static Position getAbsolutePosition(MemorySegment mem) {
        return getAbsolutePosition(mem, 0);
    }
    
    @Nullable
    public static Position getAbsolutePosition(MemorySegment mem, int offset) {
        return hasAbsolutePosition(mem, offset) ? Position.toObject(mem, offset + 12): null;
    }
    
    @Nullable
    public static Direction getBodyOrientation(MemorySegment mem) {
        return getBodyOrientation(mem, 0);
    }
    
    @Nullable
    public static Direction getBodyOrientation(MemorySegment mem, int offset) {
        return hasBodyOrientation(mem, offset) ? Direction.toObject(mem, offset + 36): null;
    }
    
    @Nullable
    public static Direction getLookOrientation(MemorySegment mem) {
        return getLookOrientation(mem, 0);
    }
    
    @Nullable
    public static Direction getLookOrientation(MemorySegment mem, int offset) {
        return hasLookOrientation(mem, offset) ? Direction.toObject(mem, offset + 48): null;
    }
    
    @Nullable
    public static TeleportAck getTeleportAck(MemorySegment mem) {
        return getTeleportAck(mem, 0);
    }
    
    @Nullable
    public static TeleportAck getTeleportAck(MemorySegment mem, int offset) {
        return hasTeleportAck(mem, offset) ? TeleportAck.toObject(mem, offset + 60): null;
    }
    
    @Nullable
    public static Position getWishMovement(MemorySegment mem) {
        return getWishMovement(mem, 0);
    }
    
    @Nullable
    public static Position getWishMovement(MemorySegment mem, int offset) {
        return hasWishMovement(mem, offset) ? Position.toObject(mem, offset + 61): null;
    }
    
    @Nullable
    public static Vector3d getVelocity(MemorySegment mem) {
        return getVelocity(mem, 0);
    }
    
    @Nullable
    public static Vector3d getVelocity(MemorySegment mem, int offset) {
        return hasVelocity(mem, offset) ? Vector3d.toObject(mem, offset + 85): null;
    }
    
    public static int getMountedTo(MemorySegment mem) {
        return getMountedTo(mem, 0);
    }
    
    public static int getMountedTo(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 109);
    }
    
    @Nullable
    public static MovementStates getRiderMovementStates(MemorySegment mem) {
        return getRiderMovementStates(mem, 0);
    }
    
    @Nullable
    public static MovementStates getRiderMovementStates(MemorySegment mem, int offset) {
        return hasRiderMovementStates(mem, offset) ? MovementStates.toObject(mem, offset + 113): null;
    }
    
    public static boolean hasMovementStates(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasRelativePosition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasAbsolutePosition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasBodyOrientation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasLookOrientation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasTeleportAck(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasWishMovement(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasVelocity(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasRiderMovementStates(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x01) != 0;
    }
    
    
    
    public static ClientMovement toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ClientMovement toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ClientMovement and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ClientMovement toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new ClientMovement(
            hasMovementStates(mem, offset) ? MovementStates.toObject(mem, offset + 2) : null,
            hasRelativePosition(mem, offset) ? HalfFloatPosition.toObject(mem, offset + 6) : null,
            hasAbsolutePosition(mem, offset) ? Position.toObject(mem, offset + 12) : null,
            hasBodyOrientation(mem, offset) ? Direction.toObject(mem, offset + 36) : null,
            hasLookOrientation(mem, offset) ? Direction.toObject(mem, offset + 48) : null,
            hasTeleportAck(mem, offset) ? TeleportAck.toObject(mem, offset + 60) : null,
            hasWishMovement(mem, offset) ? Position.toObject(mem, offset + 61) : null,
            hasVelocity(mem, offset) ? Vector3d.toObject(mem, offset + 85) : null,
            mem.get(PacketIO.PROTO_INT, offset + 109),
            hasRiderMovementStates(mem, offset) ? MovementStates.toObject(mem, offset + 113) : null
        );
        if (cursor != null) cursor.position = offset + 117;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.movementStates != null) nullBits |= 0x01;
        if (this.relativePosition != null) nullBits |= 0x02;
        if (this.absolutePosition != null) nullBits |= 0x04;
        if (this.bodyOrientation != null) nullBits |= 0x08;
        if (this.lookOrientation != null) nullBits |= 0x10;
        if (this.teleportAck != null) nullBits |= 0x20;
        if (this.wishMovement != null) nullBits |= 0x40;
        if (this.velocity != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        nullBits = 0;
        if (this.riderMovementStates != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 1, nullBits);
        
        if (this.movementStates != null) {
            this.movementStates.serialize(mem, offset + 2);
        } else {
            mem.asSlice(offset + 2, 4).fill((byte) 0); 
        }
        if (this.relativePosition != null) {
            this.relativePosition.serialize(mem, offset + 6);
        } else {
            mem.asSlice(offset + 6, 6).fill((byte) 0); 
        }
        if (this.absolutePosition != null) {
            this.absolutePosition.serialize(mem, offset + 12);
        } else {
            mem.asSlice(offset + 12, 24).fill((byte) 0); 
        }
        if (this.bodyOrientation != null) {
            this.bodyOrientation.serialize(mem, offset + 36);
        } else {
            mem.asSlice(offset + 36, 12).fill((byte) 0); 
        }
        if (this.lookOrientation != null) {
            this.lookOrientation.serialize(mem, offset + 48);
        } else {
            mem.asSlice(offset + 48, 12).fill((byte) 0); 
        }
        if (this.teleportAck != null) {
            this.teleportAck.serialize(mem, offset + 60);
        } else {
            mem.asSlice(offset + 60, 1).fill((byte) 0); 
        }
        if (this.wishMovement != null) {
            this.wishMovement.serialize(mem, offset + 61);
        } else {
            mem.asSlice(offset + 61, 24).fill((byte) 0); 
        }
        if (this.velocity != null) {
            this.velocity.serialize(mem, offset + 85);
        } else {
            mem.asSlice(offset + 85, 24).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_INT, offset + 109, this.mountedTo);
        if (this.riderMovementStates != null) {
            this.riderMovementStates.serialize(mem, offset + 113);
        } else {
            mem.asSlice(offset + 113, 4).fill((byte) 0); 
        }
        
        
    
       return 117;
    }
    public int computeSize() {
        return 117;
    }

    public ClientMovement clone() {
        ClientMovement copy = new ClientMovement();
        copy.movementStates = this.movementStates != null ? this.movementStates.clone() : null;
        copy.relativePosition = this.relativePosition != null ? this.relativePosition.clone() : null;
        copy.absolutePosition = this.absolutePosition != null ? this.absolutePosition.clone() : null;
        copy.bodyOrientation = this.bodyOrientation != null ? this.bodyOrientation.clone() : null;
        copy.lookOrientation = this.lookOrientation != null ? this.lookOrientation.clone() : null;
        copy.teleportAck = this.teleportAck != null ? this.teleportAck.clone() : null;
        copy.wishMovement = this.wishMovement != null ? this.wishMovement.clone() : null;
        copy.velocity = this.velocity != null ? this.velocity.clone() : null;
        copy.mountedTo = this.mountedTo;
        copy.riderMovementStates = this.riderMovementStates != null ? this.riderMovementStates.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ClientMovement other)) return false;
        return java.util.Objects.equals(this.movementStates, other.movementStates) && java.util.Objects.equals(this.relativePosition, other.relativePosition) && java.util.Objects.equals(this.absolutePosition, other.absolutePosition) && java.util.Objects.equals(this.bodyOrientation, other.bodyOrientation) && java.util.Objects.equals(this.lookOrientation, other.lookOrientation) && java.util.Objects.equals(this.teleportAck, other.teleportAck) && java.util.Objects.equals(this.wishMovement, other.wishMovement) && java.util.Objects.equals(this.velocity, other.velocity) && this.mountedTo == other.mountedTo && java.util.Objects.equals(this.riderMovementStates, other.riderMovementStates);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(movementStates, relativePosition, absolutePosition, bodyOrientation, lookOrientation, teleportAck, wishMovement, velocity, mountedTo, riderMovementStates);
    }

}