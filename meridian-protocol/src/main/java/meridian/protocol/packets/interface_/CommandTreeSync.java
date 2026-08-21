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


public class CommandTreeSync implements Packet, ToClientPacket {
    public static final int PACKET_ID = 238;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public CommandTreeEntry[] commands;

    public CommandTreeSync() {
    }

    public CommandTreeSync(@Nullable CommandTreeEntry[] commands) {
        this.commands = commands;
    }

    public CommandTreeSync(@Nonnull CommandTreeSync other) {
        this.commands = other.commands;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CommandTreeSync", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CommandTreeSync", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static CommandTreeEntry[] getCommands(MemorySegment mem) {
        return getCommands(mem, 0);
    }
    
    @Nullable
    public static CommandTreeEntry[] getCommands(MemorySegment mem, int offset) {
        if (!hasCommands(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Commands");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Commands", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Commands", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new CommandTreeEntry[len];
        for (var i = 0; i < len; i++) {
            data[i] = CommandTreeEntry.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasCommands(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static CommandTreeSync toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CommandTreeSync toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CommandTreeSync and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CommandTreeSync toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        CommandTreeEntry[] v0 = null;
        if (hasCommands(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Commands");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Commands", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Commands", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new CommandTreeEntry[len];
            for (var i = 0; i < len; i++) {
                v0[i] = CommandTreeEntry.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new CommandTreeSync(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.commands != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.commands != null) {
            
            if (commands.length > 4096000) throw ProtocolException.arrayTooLong("Commands", commands.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.commands.length);
            
            var commandsValueOffset = 0;
            for (var i = 0; i < this.commands.length; i++) {
                commandsValueOffset += this.commands[i].serialize(mem, varOffset + commandsValueOffset);
            }
            varOffset += commandsValueOffset;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (commands != null) {
        int commandsSize = 0;
for (var elem : commands) commandsSize += elem.computeSize();
size += VarInt.size(commands.length) + commandsSize;
    }

        return size;
    }

    public CommandTreeSync clone() {
        CommandTreeSync copy = new CommandTreeSync();
        copy.commands = this.commands != null ? java.util.Arrays.stream(this.commands).map(e -> e.clone()).toArray(CommandTreeEntry[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CommandTreeSync other)) return false;
        return java.util.Arrays.equals(this.commands, other.commands);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(commands);
        return result;
    }

}