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


public class OpenChatWithCommand implements Packet, ToClientPacket {
    public static final int PACKET_ID = 234;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 16384006;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public String command;

    public OpenChatWithCommand() {
    }

    public OpenChatWithCommand(@Nullable String command) {
        this.command = command;
    }

    public OpenChatWithCommand(@Nonnull OpenChatWithCommand other) {
        this.command = other.command;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("OpenChatWithCommand", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("OpenChatWithCommand", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getCommand(MemorySegment mem) {
        return getCommand(mem, 0);
    }
    
    @Nullable
    public static String getCommand(MemorySegment mem, int offset) {
        return hasCommand(mem, offset) ? PacketIO.readVarString("Command", mem, offset + 1, 4096000): null;
    }
    
    public static boolean hasCommand(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static OpenChatWithCommand toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static OpenChatWithCommand toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one OpenChatWithCommand and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static OpenChatWithCommand toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        String v0 = null;
        if (hasCommand(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Command", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new OpenChatWithCommand(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.command != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.command != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.command, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (command != null) size += PacketIO.stringSize(command);

        return size;
    }

    public OpenChatWithCommand clone() {
        OpenChatWithCommand copy = new OpenChatWithCommand();
        copy.command = this.command;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof OpenChatWithCommand other)) return false;
        return java.util.Objects.equals(this.command, other.command);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(command);
    }

}