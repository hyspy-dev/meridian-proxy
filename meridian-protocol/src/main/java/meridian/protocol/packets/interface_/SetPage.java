// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

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


public class SetPage implements Packet, ToClientPacket {
    public static final int PACKET_ID = 216;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 2;
    public static final int MAX_SIZE = 2;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public Page page = Page.None;
    public boolean canCloseThroughInteraction;

    public SetPage() {
    }

    public SetPage(@Nonnull Page page, boolean canCloseThroughInteraction) {
        this.page = page;
        this.canCloseThroughInteraction = canCloseThroughInteraction;
    }

    public SetPage(@Nonnull SetPage other) {
        this.page = other.page;
        this.canCloseThroughInteraction = other.canCloseThroughInteraction;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SetPage", offset, (int) mem.byteSize());
        long needed = (long) offset + 2;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SetPage", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static Page getPage(MemorySegment mem) {
        return getPage(mem, 0);
    }
    
    public static Page getPage(MemorySegment mem, int offset) {
        return Page.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0));
    }
    
    public static boolean getCanCloseThroughInteraction(MemorySegment mem) {
        return getCanCloseThroughInteraction(mem, 0);
    }
    
    public static boolean getCanCloseThroughInteraction(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 1);
    }
    
    
    
    
    
    public static SetPage toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SetPage toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SetPage and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SetPage toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new SetPage(
            Page.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0)),
            mem.get(PacketIO.PROTO_BOOL, offset + 1)
        );
        if (cursor != null) cursor.position = offset + 2;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, (byte) this.page.getValue());
        mem.set(PacketIO.PROTO_BOOL, offset + 1, this.canCloseThroughInteraction);
        
        
    
       return 2;
    }
    public int computeSize() {
        return 2;
    }

    public SetPage clone() {
        SetPage copy = new SetPage();
        copy.page = this.page;
        copy.canCloseThroughInteraction = this.canCloseThroughInteraction;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SetPage other)) return false;
        return java.util.Objects.equals(this.page, other.page) && this.canCloseThroughInteraction == other.canCloseThroughInteraction;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(page, canCloseThroughInteraction);
    }

}