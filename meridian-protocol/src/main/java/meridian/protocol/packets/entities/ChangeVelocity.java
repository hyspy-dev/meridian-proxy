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
import meridian.protocol.VelocityConfig;

public class ChangeVelocity implements Packet, ToClientPacket {
    public static final int PACKET_ID = 163;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 35;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 35;
    public static final int MAX_SIZE = 35;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public float x;
    public float y;
    public float z;
    @Nonnull public ChangeVelocityType changeType = ChangeVelocityType.Add;
    @Nullable public VelocityConfig config;

    public ChangeVelocity() {
    }

    public ChangeVelocity(float x, float y, float z, @Nonnull ChangeVelocityType changeType, @Nullable VelocityConfig config) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.changeType = changeType;
        this.config = config;
    }

    public ChangeVelocity(@Nonnull ChangeVelocity other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
        this.changeType = other.changeType;
        this.config = other.config;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ChangeVelocity", offset, (int) mem.byteSize());
        long needed = (long) offset + 35;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ChangeVelocity", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getX(MemorySegment mem) {
        return getX(mem, 0);
    }
    
    public static float getX(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "X");
    }
    
    public static float getY(MemorySegment mem) {
        return getY(mem, 0);
    }
    
    public static float getY(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "Y");
    }
    
    public static float getZ(MemorySegment mem) {
        return getZ(mem, 0);
    }
    
    public static float getZ(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "Z");
    }
    
    public static ChangeVelocityType getChangeType(MemorySegment mem) {
        return getChangeType(mem, 0);
    }
    
    public static ChangeVelocityType getChangeType(MemorySegment mem, int offset) {
        return ChangeVelocityType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 13));
    }
    
    @Nullable
    public static VelocityConfig getConfig(MemorySegment mem) {
        return getConfig(mem, 0);
    }
    
    @Nullable
    public static VelocityConfig getConfig(MemorySegment mem, int offset) {
        return hasConfig(mem, offset) ? VelocityConfig.toObject(mem, offset + 14): null;
    }
    
    public static boolean hasConfig(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static ChangeVelocity toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ChangeVelocity toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ChangeVelocity and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ChangeVelocity toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new ChangeVelocity(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "X"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "Y"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "Z"),
            ChangeVelocityType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 13)),
            hasConfig(mem, offset) ? VelocityConfig.toObject(mem, offset + 14) : null
        );
        if (cursor != null) cursor.position = offset + 35;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.config != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.x, "X"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.x);
        PacketIO.requireFinite(this.y, "Y"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.y);
        PacketIO.requireFinite(this.z, "Z"); mem.set(PacketIO.PROTO_FLOAT, offset + 9, this.z);
        mem.set(PacketIO.PROTO_BYTE, offset + 13, (byte) this.changeType.getValue());
        if (this.config != null) {
            this.config.serialize(mem, offset + 14);
        } else {
            mem.asSlice(offset + 14, 21).fill((byte) 0); 
        }
        
        
    
       return 35;
    }
    public int computeSize() {
        return 35;
    }

    public ChangeVelocity clone() {
        ChangeVelocity copy = new ChangeVelocity();
        copy.x = this.x;
        copy.y = this.y;
        copy.z = this.z;
        copy.changeType = this.changeType;
        copy.config = this.config != null ? this.config.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ChangeVelocity other)) return false;
        return this.x == other.x && this.y == other.y && this.z == other.z && java.util.Objects.equals(this.changeType, other.changeType) && java.util.Objects.equals(this.config, other.config);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, y, z, changeType, config);
    }

}