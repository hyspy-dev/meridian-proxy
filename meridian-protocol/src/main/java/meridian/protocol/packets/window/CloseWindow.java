// Auto-generated - do not edit
package meridian.protocol.packets.window;

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


public class CloseWindow implements Packet, ToServerPacket, ToClientPacket {
    public static final int PACKET_ID = 202;
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
        return NetworkChannel.Default;
    }

    public int id;

    public CloseWindow() {
    }

    public CloseWindow(int id) {
        this.id = id;
    }

    public CloseWindow(@Nonnull CloseWindow other) {
        this.id = other.id;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CloseWindow", offset, (int) mem.byteSize());
        long needed = (long) offset + 4;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CloseWindow", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    public static int getId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    
    
    
    
    public static CloseWindow toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CloseWindow toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CloseWindow and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CloseWindow toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new CloseWindow(
            mem.get(PacketIO.PROTO_INT, offset + 0)
        );
        if (cursor != null) cursor.position = offset + 4;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.id);
        
        
    
       return 4;
    }
    public int computeSize() {
        return 4;
    }

    public CloseWindow clone() {
        CloseWindow copy = new CloseWindow();
        copy.id = this.id;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CloseWindow other)) return false;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }

}