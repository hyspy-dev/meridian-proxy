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
import meridian.protocol.ItemQuantity;

public class SetCreativeItem implements Packet, ToServerPacket {
    public static final int PACKET_ID = 171;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 16384018;

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
    @Nonnull public ItemQuantity item = new ItemQuantity();
    public boolean override;

    public SetCreativeItem() {
    }

    public SetCreativeItem(int inventorySectionId, int slotId, @Nonnull ItemQuantity item, boolean override) {
        this.inventorySectionId = inventorySectionId;
        this.slotId = slotId;
        this.item = item;
        this.override = override;
    }

    public SetCreativeItem(@Nonnull SetCreativeItem other) {
        this.inventorySectionId = other.inventorySectionId;
        this.slotId = other.slotId;
        this.item = other.item;
        this.override = other.override;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SetCreativeItem", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SetCreativeItem", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
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
    
    public static ItemQuantity getItem(MemorySegment mem) {
        return getItem(mem, 0);
    }
    
    public static ItemQuantity getItem(MemorySegment mem, int offset) {
        return ItemQuantity.toObject(mem, offset + 9);
    }
    
    public static boolean getOverride(MemorySegment mem) {
        return getOverride(mem, 0);
    }
    
    public static boolean getOverride(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 8);
    }
    
    
    
    
    
    public static SetCreativeItem toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SetCreativeItem toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SetCreativeItem and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SetCreativeItem toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ItemQuantity v2;
        {
            v2 = ItemQuantity.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new SetCreativeItem(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4),
            v2,
            mem.get(PacketIO.PROTO_BOOL, offset + 8)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.inventorySectionId);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.slotId);
        mem.set(PacketIO.PROTO_BOOL, offset + 8, this.override);
        var varOffset = offset + 9;
        varOffset += this.item.serialize(mem, varOffset);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        size += item.computeSize();

        return size;
    }

    public SetCreativeItem clone() {
        SetCreativeItem copy = new SetCreativeItem();
        copy.inventorySectionId = this.inventorySectionId;
        copy.slotId = this.slotId;
        copy.item = this.item.clone();
        copy.override = this.override;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SetCreativeItem other)) return false;
        return this.inventorySectionId == other.inventorySectionId && this.slotId == other.slotId && java.util.Objects.equals(this.item, other.item) && this.override == other.override;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(inventorySectionId, slotId, item, override);
    }

}