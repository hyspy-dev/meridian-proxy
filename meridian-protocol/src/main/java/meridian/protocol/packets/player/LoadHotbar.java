// Auto-generated - do not edit
package meridian.protocol.packets.player;

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


public class LoadHotbar implements Packet, ToServerPacket {
    public static final int PACKET_ID = 106;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public byte inventoryRow;

    public LoadHotbar() {
    }

    public LoadHotbar(byte inventoryRow) {
        this.inventoryRow = inventoryRow;
    }

    public LoadHotbar(@Nonnull LoadHotbar other) {
        this.inventoryRow = other.inventoryRow;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("LoadHotbar", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("LoadHotbar", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static byte getInventoryRow(MemorySegment mem) {
        return getInventoryRow(mem, 0);
    }
    
    public static byte getInventoryRow(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 0);
    }
    
    
    
    
    
    public static LoadHotbar toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static LoadHotbar toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one LoadHotbar and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static LoadHotbar toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new LoadHotbar(
            mem.get(PacketIO.PROTO_BYTE, offset + 0)
        );
        if (cursor != null) cursor.position = offset + 1;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, this.inventoryRow);
        
        
    
       return 1;
    }
    public int computeSize() {
        return 1;
    }

    public LoadHotbar clone() {
        LoadHotbar copy = new LoadHotbar();
        copy.inventoryRow = this.inventoryRow;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof LoadHotbar other)) return false;
        return this.inventoryRow == other.inventoryRow;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(inventoryRow);
    }

}