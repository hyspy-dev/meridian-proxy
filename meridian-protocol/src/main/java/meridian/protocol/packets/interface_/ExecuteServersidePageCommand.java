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


public class ExecuteServersidePageCommand implements Packet, ToServerPacket {
    public static final int PACKET_ID = 1202;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public String pageId = "";
    @Nonnull public String commandId = "";
    @Nullable public UIDataValue param;

    public ExecuteServersidePageCommand() {
    }

    public ExecuteServersidePageCommand(@Nonnull String pageId, @Nonnull String commandId, @Nullable UIDataValue param) {
        this.pageId = pageId;
        this.commandId = commandId;
        this.param = param;
    }

    public ExecuteServersidePageCommand(@Nonnull ExecuteServersidePageCommand other) {
        this.pageId = other.pageId;
        this.commandId = other.commandId;
        this.param = other.param;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ExecuteServersidePageCommand", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ExecuteServersidePageCommand", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getPageId(MemorySegment mem) {
        return getPageId(mem, 0);
    }
    
    public static String getPageId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("PageId", mem, offset + getValidatedOffset(mem, offset, 1, 13, "PageId"), 4096000);
    }
    
    public static String getCommandId(MemorySegment mem) {
        return getCommandId(mem, 0);
    }
    
    public static String getCommandId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("CommandId", mem, offset + getValidatedOffset(mem, offset, 5, 13, "CommandId"), 4096000);
    }
    
    @Nullable
    public static UIDataValue getParam(MemorySegment mem) {
        return getParam(mem, 0);
    }
    
    @Nullable
    public static UIDataValue getParam(MemorySegment mem, int offset) {
        return hasParam(mem, offset) ? UIDataValue.toObject(mem, offset + getValidatedOffset(mem, offset, 9, 13, "Param")): null;
    }
    
    public static boolean hasParam(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    private static int getValidatedOffset(MemorySegment buffer, int base, int slotPosition, int varBlockStart, String fieldName) {
        int offset = buffer.get(PacketIO.PROTO_INT, base + slotPosition);
        if (offset < 0 || offset > buffer.byteSize() - base - varBlockStart)
            throw ProtocolException.invalidOffset(fieldName, offset, (int) buffer.byteSize());
        return varBlockStart + offset;
    }
    
    /**
     * Rejects an offset slot that does not name the position the field-order walk reached. A
     * present field must sit where the previous field ended, and an absent field carries -1, so
     * the slot a random-access getter resolves and the walk describe the same bytes.
     */
    private static void requireSlot(MemorySegment mem, int slotPosition, int expected, String fieldName) {
        int slot = mem.get(PacketIO.PROTO_INT, slotPosition);
        if (slot != expected) throw ProtocolException.nonCanonicalLayout(fieldName, slot, expected);
    }
    
    public static ExecuteServersidePageCommand toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ExecuteServersidePageCommand toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ExecuteServersidePageCommand and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ExecuteServersidePageCommand toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 13;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0;
        requireSlot(mem, offset + 1, varPos, "PageId");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("PageId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        String v1;
        requireSlot(mem, offset + 5, varPos, "CommandId");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("CommandId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        UIDataValue v2 = null;
        if (hasParam(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "Param");
            v2 = UIDataValue.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 9, -1, "Param");
        }
        var result = new ExecuteServersidePageCommand(
            v0,
            v1,
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.param != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 13;
        mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 13);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.pageId, 4096000);
        mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 13);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.commandId, 4096000);
        if (this.param != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 13);
            varOffset += this.param.serializeWithTypeId(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 13;
        size += PacketIO.stringSize(pageId);
    size += PacketIO.stringSize(commandId);
    if (param != null) size += param.computeSizeWithTypeId();

        return size;
    }

    public ExecuteServersidePageCommand clone() {
        ExecuteServersidePageCommand copy = new ExecuteServersidePageCommand();
        copy.pageId = this.pageId;
        copy.commandId = this.commandId;
        copy.param = this.param;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ExecuteServersidePageCommand other)) return false;
        return java.util.Objects.equals(this.pageId, other.pageId) && java.util.Objects.equals(this.commandId, other.commandId) && java.util.Objects.equals(this.param, other.param);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(pageId, commandId, param);
    }

}