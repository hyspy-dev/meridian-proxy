// Auto-generated - do not edit
package meridian.protocol.packets.world;

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
import meridian.protocol.BlockPosition;

public class UpdateBlockDamage implements Packet, ToClientPacket {
    public static final int PACKET_ID = 144;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 21;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 21;
    public static final int MAX_SIZE = 21;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Chunks;
    }

    @Nullable public BlockPosition blockPosition;
    public float damage;
    public float delta;

    public UpdateBlockDamage() {
    }

    public UpdateBlockDamage(@Nullable BlockPosition blockPosition, float damage, float delta) {
        this.blockPosition = blockPosition;
        this.damage = damage;
        this.delta = delta;
    }

    public UpdateBlockDamage(@Nonnull UpdateBlockDamage other) {
        this.blockPosition = other.blockPosition;
        this.damage = other.damage;
        this.delta = other.delta;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateBlockDamage", offset, (int) mem.byteSize());
        long needed = (long) offset + 21;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateBlockDamage", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static BlockPosition getBlockPosition(MemorySegment mem) {
        return getBlockPosition(mem, 0);
    }
    
    @Nullable
    public static BlockPosition getBlockPosition(MemorySegment mem, int offset) {
        return hasBlockPosition(mem, offset) ? BlockPosition.toObject(mem, offset + 1): null;
    }
    
    public static float getDamage(MemorySegment mem) {
        return getDamage(mem, 0);
    }
    
    public static float getDamage(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 13), "Damage");
    }
    
    public static float getDelta(MemorySegment mem) {
        return getDelta(mem, 0);
    }
    
    public static float getDelta(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 17), "Delta");
    }
    
    public static boolean hasBlockPosition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static UpdateBlockDamage toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateBlockDamage toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateBlockDamage and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateBlockDamage toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new UpdateBlockDamage(
            hasBlockPosition(mem, offset) ? BlockPosition.toObject(mem, offset + 1) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 13), "Damage"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 17), "Delta")
        );
        if (cursor != null) cursor.position = offset + 21;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.blockPosition != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.blockPosition != null) {
            this.blockPosition.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 12).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.damage, "Damage"); mem.set(PacketIO.PROTO_FLOAT, offset + 13, this.damage);
        PacketIO.requireFinite(this.delta, "Delta"); mem.set(PacketIO.PROTO_FLOAT, offset + 17, this.delta);
        
        
    
       return 21;
    }
    public int computeSize() {
        return 21;
    }

    public UpdateBlockDamage clone() {
        UpdateBlockDamage copy = new UpdateBlockDamage();
        copy.blockPosition = this.blockPosition != null ? this.blockPosition.clone() : null;
        copy.damage = this.damage;
        copy.delta = this.delta;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateBlockDamage other)) return false;
        return java.util.Objects.equals(this.blockPosition, other.blockPosition) && this.damage == other.damage && this.delta == other.delta;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(blockPosition, damage, delta);
    }

}