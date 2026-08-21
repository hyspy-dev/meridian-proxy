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


public class DropItemStack implements Packet, ToServerPacket {
    public static final int PACKET_ID = 174;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 12;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 12;
    public static final int MAX_SIZE = 12;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int inventorySectionId;
    public int slotId;
    public int quantity;

    public DropItemStack() {
    }

    public DropItemStack(int inventorySectionId, int slotId, int quantity) {
        this.inventorySectionId = inventorySectionId;
        this.slotId = slotId;
        this.quantity = quantity;
    }

    public DropItemStack(@Nonnull DropItemStack other) {
        this.inventorySectionId = other.inventorySectionId;
        this.slotId = other.slotId;
        this.quantity = other.quantity;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("DropItemStack", offset, (int) mem.byteSize());
        long needed = (long) offset + 12;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("DropItemStack", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getInventorySectionId(MemorySegment mem) {
        return getInventorySectionId(mem, 0);
    }
    
    public static int getInventorySectionId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static int getSlotId(MemorySegment mem) {
        return getSlotId(mem, 0);
    }
    
    public static int getSlotId(MemorySegment mem, int offset) {
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
    
    
    
    
    
    public static DropItemStack toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static DropItemStack toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one DropItemStack and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static DropItemStack toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        int v2 = mem.get(PacketIO.PROTO_INT, offset + 8);
        if (v2 < 1) throw ProtocolException.valueBelowMinimum("Quantity", v2, 1);
        var result = new DropItemStack(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4),
            v2
        );
        if (cursor != null) cursor.position = offset + 12;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.inventorySectionId);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.slotId);
        if (this.quantity < 1) throw ProtocolException.valueBelowMinimum("Quantity", this.quantity, 1); mem.set(PacketIO.PROTO_INT, offset + 8, this.quantity);
        
        
    
       return 12;
    }
    public int computeSize() {
        return 12;
    }

    public DropItemStack clone() {
        DropItemStack copy = new DropItemStack();
        copy.inventorySectionId = this.inventorySectionId;
        copy.slotId = this.slotId;
        copy.quantity = this.quantity;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DropItemStack other)) return false;
        return this.inventorySectionId == other.inventorySectionId && this.slotId == other.slotId && this.quantity == other.quantity;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(inventorySectionId, slotId, quantity);
    }

}