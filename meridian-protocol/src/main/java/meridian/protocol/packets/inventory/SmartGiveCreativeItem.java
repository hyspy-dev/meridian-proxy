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
import meridian.protocol.SmartMoveType;

public class SmartGiveCreativeItem implements Packet, ToServerPacket {
    public static final int PACKET_ID = 173;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 16384010;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public ItemQuantity item = new ItemQuantity();
    @Nonnull public SmartMoveType moveType = SmartMoveType.EquipOrMergeStack;

    public SmartGiveCreativeItem() {
    }

    public SmartGiveCreativeItem(@Nonnull ItemQuantity item, @Nonnull SmartMoveType moveType) {
        this.item = item;
        this.moveType = moveType;
    }

    public SmartGiveCreativeItem(@Nonnull SmartGiveCreativeItem other) {
        this.item = other.item;
        this.moveType = other.moveType;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SmartGiveCreativeItem", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SmartGiveCreativeItem", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static ItemQuantity getItem(MemorySegment mem) {
        return getItem(mem, 0);
    }
    
    public static ItemQuantity getItem(MemorySegment mem, int offset) {
        return ItemQuantity.toObject(mem, offset + 1);
    }
    
    public static SmartMoveType getMoveType(MemorySegment mem) {
        return getMoveType(mem, 0);
    }
    
    public static SmartMoveType getMoveType(MemorySegment mem, int offset) {
        return SmartMoveType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0));
    }
    
    
    
    
    
    public static SmartGiveCreativeItem toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SmartGiveCreativeItem toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SmartGiveCreativeItem and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SmartGiveCreativeItem toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ItemQuantity v0;
        {
            v0 = ItemQuantity.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new SmartGiveCreativeItem(
            v0,
            SmartMoveType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0))
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, (byte) this.moveType.getValue());
        var varOffset = offset + 1;
        varOffset += this.item.serialize(mem, varOffset);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        size += item.computeSize();

        return size;
    }

    public SmartGiveCreativeItem clone() {
        SmartGiveCreativeItem copy = new SmartGiveCreativeItem();
        copy.item = this.item.clone();
        copy.moveType = this.moveType;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SmartGiveCreativeItem other)) return false;
        return java.util.Objects.equals(this.item, other.item) && java.util.Objects.equals(this.moveType, other.moveType);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(item, moveType);
    }

}