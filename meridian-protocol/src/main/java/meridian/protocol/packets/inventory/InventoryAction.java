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
import meridian.protocol.InventoryActionType;

public class InventoryAction implements Packet, ToServerPacket {
    public static final int PACKET_ID = 179;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 6;
    public static final int MAX_SIZE = 6;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int inventorySectionId;
    @Nonnull public InventoryActionType inventoryActionType = InventoryActionType.TakeAll;
    public byte actionData;

    public InventoryAction() {
    }

    public InventoryAction(int inventorySectionId, @Nonnull InventoryActionType inventoryActionType, byte actionData) {
        this.inventorySectionId = inventorySectionId;
        this.inventoryActionType = inventoryActionType;
        this.actionData = actionData;
    }

    public InventoryAction(@Nonnull InventoryAction other) {
        this.inventorySectionId = other.inventorySectionId;
        this.inventoryActionType = other.inventoryActionType;
        this.actionData = other.actionData;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("InventoryAction", offset, (int) mem.byteSize());
        long needed = (long) offset + 6;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InventoryAction", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getInventorySectionId(MemorySegment mem) {
        return getInventorySectionId(mem, 0);
    }
    
    public static int getInventorySectionId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static InventoryActionType getInventoryActionType(MemorySegment mem) {
        return getInventoryActionType(mem, 0);
    }
    
    public static InventoryActionType getInventoryActionType(MemorySegment mem, int offset) {
        return InventoryActionType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 4));
    }
    
    public static byte getActionData(MemorySegment mem) {
        return getActionData(mem, 0);
    }
    
    public static byte getActionData(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 5);
    }
    
    
    
    
    
    public static InventoryAction toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static InventoryAction toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one InventoryAction and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static InventoryAction toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new InventoryAction(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            InventoryActionType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 4)),
            mem.get(PacketIO.PROTO_BYTE, offset + 5)
        );
        if (cursor != null) cursor.position = offset + 6;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.inventorySectionId);
        mem.set(PacketIO.PROTO_BYTE, offset + 4, (byte) this.inventoryActionType.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 5, this.actionData);
        
        
    
       return 6;
    }
    public int computeSize() {
        return 6;
    }

    public InventoryAction clone() {
        InventoryAction copy = new InventoryAction();
        copy.inventorySectionId = this.inventorySectionId;
        copy.inventoryActionType = this.inventoryActionType;
        copy.actionData = this.actionData;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InventoryAction other)) return false;
        return this.inventorySectionId == other.inventorySectionId && java.util.Objects.equals(this.inventoryActionType, other.inventoryActionType) && this.actionData == other.actionData;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(inventorySectionId, inventoryActionType, actionData);
    }

}