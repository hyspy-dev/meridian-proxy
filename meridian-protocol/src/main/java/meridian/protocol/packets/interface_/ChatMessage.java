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


public class ChatMessage implements Packet, ToServerPacket {
    public static final int PACKET_ID = 211;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1026;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public String message;

    public ChatMessage() {
    }

    public ChatMessage(@Nullable String message) {
        this.message = message;
    }

    public ChatMessage(@Nonnull ChatMessage other) {
        this.message = other.message;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ChatMessage", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ChatMessage", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getMessage(MemorySegment mem) {
        return getMessage(mem, 0);
    }
    
    @Nullable
    public static String getMessage(MemorySegment mem, int offset) {
        return hasMessage(mem, offset) ? PacketIO.readVarString("Message", mem, offset + 1, 255): null;
    }
    
    public static boolean hasMessage(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static ChatMessage toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ChatMessage toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ChatMessage and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ChatMessage toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        String v0 = null;
        if (hasMessage(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Message", mem, off, 0, 255, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new ChatMessage(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.message != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.message != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.message, 255);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (message != null) size += PacketIO.stringSize(message);

        return size;
    }

    public ChatMessage clone() {
        ChatMessage copy = new ChatMessage();
        copy.message = this.message;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ChatMessage other)) return false;
        return java.util.Objects.equals(this.message, other.message);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(message);
    }

}