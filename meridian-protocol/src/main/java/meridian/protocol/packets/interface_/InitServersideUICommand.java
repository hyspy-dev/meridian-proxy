// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class InitServersideUICommand extends ServersideUICommand {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public String id = "";
    @Nonnull public String filePath = "";
    @Nullable public UIObjectDataValue dataContext;

    public InitServersideUICommand() {
    }

    public InitServersideUICommand(@Nonnull String id, @Nonnull String filePath, @Nullable UIObjectDataValue dataContext) {
        this.id = id;
        this.filePath = filePath;
        this.dataContext = dataContext;
    }

    public InitServersideUICommand(@Nonnull InitServersideUICommand other) {
        this.id = other.id;
        this.filePath = other.filePath;
        this.dataContext = other.dataContext;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("InitServersideUICommand", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InitServersideUICommand", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    public static String getId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 1, 13, "Id"), 4096000);
    }
    
    public static String getFilePath(MemorySegment mem) {
        return getFilePath(mem, 0);
    }
    
    public static String getFilePath(MemorySegment mem, int offset) {
        return PacketIO.readVarString("FilePath", mem, offset + getValidatedOffset(mem, offset, 5, 13, "FilePath"), 4096000);
    }
    
    @Nullable
    public static UIObjectDataValue getDataContext(MemorySegment mem) {
        return getDataContext(mem, 0);
    }
    
    @Nullable
    public static UIObjectDataValue getDataContext(MemorySegment mem, int offset) {
        return hasDataContext(mem, offset) ? UIObjectDataValue.toObject(mem, offset + getValidatedOffset(mem, offset, 9, 13, "DataContext")): null;
    }
    
    public static boolean hasDataContext(MemorySegment mem, int offset) {
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
    
    public static InitServersideUICommand toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static InitServersideUICommand toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one InitServersideUICommand and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static InitServersideUICommand toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 13;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0;
        requireSlot(mem, offset + 1, varPos, "Id");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        String v1;
        requireSlot(mem, offset + 5, varPos, "FilePath");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("FilePath", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        UIObjectDataValue v2 = null;
        if (hasDataContext(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "DataContext");
            v2 = UIObjectDataValue.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 9, -1, "DataContext");
        }
        var result = new InitServersideUICommand(
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
        if (this.dataContext != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 13;
        mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 13);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 13);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.filePath, 4096000);
        if (this.dataContext != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 13);
            varOffset += this.dataContext.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 13;
        size += PacketIO.stringSize(id);
    size += PacketIO.stringSize(filePath);
    if (dataContext != null) size += dataContext.computeSize();

        return size;
    }

    public InitServersideUICommand clone() {
        InitServersideUICommand copy = new InitServersideUICommand();
        copy.id = this.id;
        copy.filePath = this.filePath;
        copy.dataContext = this.dataContext != null ? this.dataContext.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InitServersideUICommand other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.filePath, other.filePath) && java.util.Objects.equals(this.dataContext, other.dataContext);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, filePath, dataContext);
    }

}