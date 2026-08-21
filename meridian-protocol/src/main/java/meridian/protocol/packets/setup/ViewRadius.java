// Auto-generated - do not edit
package meridian.protocol.packets.setup;

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


public class ViewRadius implements Packet, ToServerPacket, ToClientPacket {
    public static final int PACKET_ID = 32;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 4;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 4;
    public static final int MAX_SIZE = 4;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Chunks;
    }

    public int value;

    public ViewRadius() {
    }

    public ViewRadius(int value) {
        this.value = value;
    }

    public ViewRadius(@Nonnull ViewRadius other) {
        this.value = other.value;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ViewRadius", offset, (int) mem.byteSize());
        long needed = (long) offset + 4;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ViewRadius", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getValue(MemorySegment mem) {
        return getValue(mem, 0);
    }
    
    public static int getValue(MemorySegment mem, int offset) {
        var value = mem.get(PacketIO.PROTO_INT, offset + 0);
        if (value < 0) throw ProtocolException.valueBelowMinimum("Value", value, 0);
        return value;
    }
    
    
    
    
    
    public static ViewRadius toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ViewRadius toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ViewRadius and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ViewRadius toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        int v0 = mem.get(PacketIO.PROTO_INT, offset + 0);
        if (v0 < 0) throw ProtocolException.valueBelowMinimum("Value", v0, 0);
        var result = new ViewRadius(
            v0
        );
        if (cursor != null) cursor.position = offset + 4;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        if (this.value < 0) throw ProtocolException.valueBelowMinimum("Value", this.value, 0); mem.set(PacketIO.PROTO_INT, offset + 0, this.value);
        
        
    
       return 4;
    }
    public int computeSize() {
        return 4;
    }

    public ViewRadius clone() {
        ViewRadius copy = new ViewRadius();
        copy.value = this.value;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ViewRadius other)) return false;
        return this.value == other.value;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(value);
    }

}