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


public class ClientOpenWindow implements Packet, ToServerPacket {
    public static final int PACKET_ID = 204;
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

    @Nonnull public WindowType type = WindowType.Container;

    public ClientOpenWindow() {
    }

    public ClientOpenWindow(@Nonnull WindowType type) {
        this.type = type;
    }

    public ClientOpenWindow(@Nonnull ClientOpenWindow other) {
        this.type = other.type;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ClientOpenWindow", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ClientOpenWindow", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static WindowType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static WindowType getType(MemorySegment mem, int offset) {
        return WindowType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0));
    }
    
    
    
    
    
    public static ClientOpenWindow toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ClientOpenWindow toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ClientOpenWindow and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ClientOpenWindow toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new ClientOpenWindow(
            WindowType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0))
        );
        if (cursor != null) cursor.position = offset + 1;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, (byte) this.type.getValue());
        
        
    
       return 1;
    }
    public int computeSize() {
        return 1;
    }

    public ClientOpenWindow clone() {
        ClientOpenWindow copy = new ClientOpenWindow();
        copy.type = this.type;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ClientOpenWindow other)) return false;
        return java.util.Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(type);
    }

}