// Auto-generated - do not edit
package meridian.protocol.packets.inventory;

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


public class MoveItemStack implements Packet, ToServerPacket {
    public static final int PACKET_ID = 175;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 20;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 20;
    public static final int MAX_SIZE = 20;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int fromSectionId;
    public int fromSlotId;
    public int quantity;
    public int toSectionId;
    public int toSlotId;

    public MoveItemStack() {
    }

    public MoveItemStack(int fromSectionId, int fromSlotId, int quantity, int toSectionId, int toSlotId) {
        this.fromSectionId = fromSectionId;
        this.fromSlotId = fromSlotId;
        this.quantity = quantity;
        this.toSectionId = toSectionId;
        this.toSlotId = toSlotId;
    }

    public MoveItemStack(@Nonnull MoveItemStack other) {
        this.fromSectionId = other.fromSectionId;
        this.fromSlotId = other.fromSlotId;
        this.quantity = other.quantity;
        this.toSectionId = other.toSectionId;
        this.toSlotId = other.toSlotId;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("MoveItemStack", offset, (int) mem.byteSize());
        long needed = (long) offset + 20;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("MoveItemStack", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getFromSectionId(MemorySegment mem) {
        return getFromSectionId(mem, 0);
    }
    
    public static int getFromSectionId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static int getFromSlotId(MemorySegment mem) {
        return getFromSlotId(mem, 0);
    }
    
    public static int getFromSlotId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 4);
    }
    
    public static int getQuantity(MemorySegment mem) {
        return getQuantity(mem, 0);
    }
    
    public static int getQuantity(MemorySegment mem, int offset) {
        var value = mem.get(PacketIO.PROTO_INT, offset + 8);
        if (value < 1) throw ProtocolException.valueBelowMinimum("Quantity", value, 1);
        return value;
    }
    
    public static int getToSectionId(MemorySegment mem) {
        return getToSectionId(mem, 0);
    }
    
    public static int getToSectionId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 12);
    }
    
    public static int getToSlotId(MemorySegment mem) {
        return getToSlotId(mem, 0);
    }
    
    public static int getToSlotId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 16);
    }
    
    
    
    
    
    public static MoveItemStack toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static MoveItemStack toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one MoveItemStack and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static MoveItemStack toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        int v2 = mem.get(PacketIO.PROTO_INT, offset + 8);
        if (v2 < 1) throw ProtocolException.valueBelowMinimum("Quantity", v2, 1);
        var result = new MoveItemStack(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4),
            v2,
            mem.get(PacketIO.PROTO_INT, offset + 12),
            mem.get(PacketIO.PROTO_INT, offset + 16)
        );
        if (cursor != null) cursor.position = offset + 20;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.fromSectionId);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.fromSlotId);
        if (this.quantity < 1) throw ProtocolException.valueBelowMinimum("Quantity", this.quantity, 1); mem.set(PacketIO.PROTO_INT, offset + 8, this.quantity);
        mem.set(PacketIO.PROTO_INT, offset + 12, this.toSectionId);
        mem.set(PacketIO.PROTO_INT, offset + 16, this.toSlotId);
        
        
    
       return 20;
    }
    public int computeSize() {
        return 20;
    }

    public MoveItemStack clone() {
        MoveItemStack copy = new MoveItemStack();
        copy.fromSectionId = this.fromSectionId;
        copy.fromSlotId = this.fromSlotId;
        copy.quantity = this.quantity;
        copy.toSectionId = this.toSectionId;
        copy.toSlotId = this.toSlotId;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MoveItemStack other)) return false;
        return this.fromSectionId == other.fromSectionId && this.fromSlotId == other.fromSlotId && this.quantity == other.quantity && this.toSectionId == other.toSectionId && this.toSlotId == other.toSlotId;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(fromSectionId, fromSlotId, quantity, toSectionId, toSlotId);
    }

}