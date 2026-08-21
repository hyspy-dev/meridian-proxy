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


public class SendWindowAction implements Packet, ToServerPacket {
    public static final int PACKET_ID = 203;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 4;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 4;
    public static final int MAX_SIZE = 32768027;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int id;
    @Nonnull public WindowAction action;

    public SendWindowAction() {
    }

    public SendWindowAction(int id, @Nonnull WindowAction action) {
        this.id = id;
        this.action = action;
    }

    public SendWindowAction(@Nonnull SendWindowAction other) {
        this.id = other.id;
        this.action = other.action;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SendWindowAction", offset, (int) mem.byteSize());
        long needed = (long) offset + 4;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SendWindowAction", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    public static int getId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static WindowAction getAction(MemorySegment mem) {
        return getAction(mem, 0);
    }
    
    public static WindowAction getAction(MemorySegment mem, int offset) {
        return WindowAction.toObject(mem, offset + 4);
    }
    
    
    
    
    
    public static SendWindowAction toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SendWindowAction toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SendWindowAction and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SendWindowAction toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 4;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        WindowAction v1;
        {
            v1 = WindowAction.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new SendWindowAction(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.id);
        var varOffset = offset + 4;
        varOffset += this.action.serializeWithTypeId(mem, varOffset);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 4;
        size += action.computeSizeWithTypeId();

        return size;
    }

    public SendWindowAction clone() {
        SendWindowAction copy = new SendWindowAction();
        copy.id = this.id;
        copy.action = this.action;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SendWindowAction other)) return false;
        return this.id == other.id && java.util.Objects.equals(this.action, other.action);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, action);
    }

}