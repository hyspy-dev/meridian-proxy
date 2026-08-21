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
import meridian.protocol.ChangeVelocityType;
import meridian.protocol.Position;

public class ApplyKnockback implements Packet, ToClientPacket {
    public static final int PACKET_ID = 164;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 38;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 38;
    public static final int MAX_SIZE = 38;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public Position hitPosition;
    public float x;
    public float y;
    public float z;
    @Nonnull public ChangeVelocityType changeType = ChangeVelocityType.Add;

    public ApplyKnockback() {
    }

    public ApplyKnockback(@Nullable Position hitPosition, float x, float y, float z, @Nonnull ChangeVelocityType changeType) {
        this.hitPosition = hitPosition;
        this.x = x;
        this.y = y;
        this.z = z;
        this.changeType = changeType;
    }

    public ApplyKnockback(@Nonnull ApplyKnockback other) {
        this.hitPosition = other.hitPosition;
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
        this.changeType = other.changeType;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ApplyKnockback", offset, (int) mem.byteSize());
        long needed = (long) offset + 38;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ApplyKnockback", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static Position getHitPosition(MemorySegment mem) {
        return getHitPosition(mem, 0);
    }
    
    @Nullable
    public static Position getHitPosition(MemorySegment mem, int offset) {
        return hasHitPosition(mem, offset) ? Position.toObject(mem, offset + 1): null;
    }
    
    public static float getX(MemorySegment mem) {
        return getX(mem, 0);
    }
    
    public static float getX(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 25), "X");
    }
    
    public static float getY(MemorySegment mem) {
        return getY(mem, 0);
    }
    
    public static float getY(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 29), "Y");
    }
    
    public static float getZ(MemorySegment mem) {
        return getZ(mem, 0);
    }
    
    public static float getZ(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 33), "Z");
    }
    
    public static ChangeVelocityType getChangeType(MemorySegment mem) {
        return getChangeType(mem, 0);
    }
    
    public static ChangeVelocityType getChangeType(MemorySegment mem, int offset) {
        return ChangeVelocityType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 37));
    }
    
    public static boolean hasHitPosition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static ApplyKnockback toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ApplyKnockback toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ApplyKnockback and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ApplyKnockback toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new ApplyKnockback(
            hasHitPosition(mem, offset) ? Position.toObject(mem, offset + 1) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 25), "X"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 29), "Y"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 33), "Z"),
            ChangeVelocityType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 37))
        );
        if (cursor != null) cursor.position = offset + 38;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.hitPosition != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.hitPosition != null) {
            this.hitPosition.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 24).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.x, "X"); mem.set(PacketIO.PROTO_FLOAT, offset + 25, this.x);
        PacketIO.requireFinite(this.y, "Y"); mem.set(PacketIO.PROTO_FLOAT, offset + 29, this.y);
        PacketIO.requireFinite(this.z, "Z"); mem.set(PacketIO.PROTO_FLOAT, offset + 33, this.z);
        mem.set(PacketIO.PROTO_BYTE, offset + 37, (byte) this.changeType.getValue());
        
        
    
       return 38;
    }
    public int computeSize() {
        return 38;
    }

    public ApplyKnockback clone() {
        ApplyKnockback copy = new ApplyKnockback();
        copy.hitPosition = this.hitPosition != null ? this.hitPosition.clone() : null;
        copy.x = this.x;
        copy.y = this.y;
        copy.z = this.z;
        copy.changeType = this.changeType;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ApplyKnockback other)) return false;
        return java.util.Objects.equals(this.hitPosition, other.hitPosition) && this.x == other.x && this.y == other.y && this.z == other.z && java.util.Objects.equals(this.changeType, other.changeType);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(hitPosition, x, y, z, changeType);
    }

}