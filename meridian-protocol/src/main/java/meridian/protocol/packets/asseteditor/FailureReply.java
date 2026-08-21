// Auto-generated - do not edit
package meridian.protocol.packets.asseteditor;

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
import meridian.protocol.FormattedMessage;

public class FailureReply implements Packet, ToServerPacket, ToClientPacket {
    public static final int PACKET_ID = 300;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 5;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int token;
    @Nullable public FormattedMessage message;

    public FailureReply() {
    }

    public FailureReply(int token, @Nullable FormattedMessage message) {
        this.token = token;
        this.message = message;
    }

    public FailureReply(@Nonnull FailureReply other) {
        this.token = other.token;
        this.message = other.message;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("FailureReply", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("FailureReply", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getToken(MemorySegment mem) {
        return getToken(mem, 0);
    }
    
    public static int getToken(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static FormattedMessage getMessage(MemorySegment mem) {
        return getMessage(mem, 0);
    }
    
    @Nullable
    public static FormattedMessage getMessage(MemorySegment mem, int offset) {
        return hasMessage(mem, offset) ? FormattedMessage.toObject(mem, offset + 5): null;
    }
    
    public static boolean hasMessage(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static FailureReply toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static FailureReply toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one FailureReply and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static FailureReply toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 5;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        FormattedMessage v1 = null;
        if (hasMessage(mem, offset)) {
            v1 = FormattedMessage.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new FailureReply(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v1
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
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.token);
        var varOffset = offset + 5;
        if (this.message != null) {
            
            varOffset += this.message.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 5;
        if (message != null) size += message.computeSize();

        return size;
    }

    public FailureReply clone() {
        FailureReply copy = new FailureReply();
        copy.token = this.token;
        copy.message = this.message != null ? this.message.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FailureReply other)) return false;
        return this.token == other.token && java.util.Objects.equals(this.message, other.message);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(token, message);
    }

}