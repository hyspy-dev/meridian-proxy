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


public class SetActiveSlot implements Packet, ToServerPacket, ToClientPacket {
    public static final int PACKET_ID = 177;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 8;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 8;
    public static final int MAX_SIZE = 8;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int inventorySectionId;
    public int activeSlot;

    public SetActiveSlot() {
    }

    public SetActiveSlot(int inventorySectionId, int activeSlot) {
        this.inventorySectionId = inventorySectionId;
        this.activeSlot = activeSlot;
    }

    public SetActiveSlot(@Nonnull SetActiveSlot other) {
        this.inventorySectionId = other.inventorySectionId;
        this.activeSlot = other.activeSlot;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SetActiveSlot", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SetActiveSlot", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getInventorySectionId(MemorySegment mem) {
        return getInventorySectionId(mem, 0);
    }
    
    public static int getInventorySectionId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static int getActiveSlot(MemorySegment mem) {
        return getActiveSlot(mem, 0);
    }
    
    public static int getActiveSlot(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 4);
    }
    
    
    
    
    
    public static SetActiveSlot toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SetActiveSlot toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SetActiveSlot and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SetActiveSlot toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new SetActiveSlot(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4)
        );
        if (cursor != null) cursor.position = offset + 8;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.inventorySectionId);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.activeSlot);
        
        
    
       return 8;
    }
    public int computeSize() {
        return 8;
    }

    public SetActiveSlot clone() {
        SetActiveSlot copy = new SetActiveSlot();
        copy.inventorySectionId = this.inventorySectionId;
        copy.activeSlot = this.activeSlot;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SetActiveSlot other)) return false;
        return this.inventorySectionId == other.inventorySectionId && this.activeSlot == other.activeSlot;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(inventorySectionId, activeSlot);
    }

}