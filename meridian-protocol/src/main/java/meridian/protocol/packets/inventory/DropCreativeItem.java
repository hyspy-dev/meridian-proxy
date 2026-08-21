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

public class DropCreativeItem implements Packet, ToServerPacket {
    public static final int PACKET_ID = 172;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 0;
    public static final int MAX_SIZE = 16384009;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public ItemQuantity item = new ItemQuantity();

    public DropCreativeItem() {
    }

    public DropCreativeItem(@Nonnull ItemQuantity item) {
        this.item = item;
    }

    public DropCreativeItem(@Nonnull DropCreativeItem other) {
        this.item = other.item;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("DropCreativeItem", offset, (int) mem.byteSize());
        long needed = (long) offset + 0;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("DropCreativeItem", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static ItemQuantity getItem(MemorySegment mem) {
        return getItem(mem, 0);
    }
    
    public static ItemQuantity getItem(MemorySegment mem, int offset) {
        return ItemQuantity.toObject(mem, offset + 0);
    }
    
    
    
    
    
    public static DropCreativeItem toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static DropCreativeItem toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one DropCreativeItem and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static DropCreativeItem toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 0;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ItemQuantity v0;
        {
            v0 = ItemQuantity.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new DropCreativeItem(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 0;
        varOffset += this.item.serialize(mem, varOffset);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 0;
        size += item.computeSize();

        return size;
    }

    public DropCreativeItem clone() {
        DropCreativeItem copy = new DropCreativeItem();
        copy.item = this.item.clone();
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DropCreativeItem other)) return false;
        return java.util.Objects.equals(this.item, other.item);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(item);
    }

}