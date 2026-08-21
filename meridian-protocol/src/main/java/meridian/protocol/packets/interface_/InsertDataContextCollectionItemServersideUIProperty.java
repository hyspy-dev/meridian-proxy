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


public class InsertDataContextCollectionItemServersideUIProperty extends ServersideUICommand {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 4;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 12;
    public static final int MAX_SIZE = 16385041;

    @Nonnull public String property = "";
    public int index;
    @Nonnull public UIDataValue value;

    public InsertDataContextCollectionItemServersideUIProperty() {
    }

    public InsertDataContextCollectionItemServersideUIProperty(@Nonnull String property, int index, @Nonnull UIDataValue value) {
        this.property = property;
        this.index = index;
        this.value = value;
    }

    public InsertDataContextCollectionItemServersideUIProperty(@Nonnull InsertDataContextCollectionItemServersideUIProperty other) {
        this.property = other.property;
        this.index = other.index;
        this.value = other.value;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("InsertDataContextCollectionItemServersideUIProperty", offset, (int) mem.byteSize());
        long needed = (long) offset + 12;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InsertDataContextCollectionItemServersideUIProperty", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getProperty(MemorySegment mem) {
        return getProperty(mem, 0);
    }
    
    public static String getProperty(MemorySegment mem, int offset) {
        return PacketIO.readVarString("Property", mem, offset + getValidatedOffset(mem, offset, 4, 12, "Property"), 4096000);
    }
    
    public static int getIndex(MemorySegment mem) {
        return getIndex(mem, 0);
    }
    
    public static int getIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static UIDataValue getValue(MemorySegment mem) {
        return getValue(mem, 0);
    }
    
    public static UIDataValue getValue(MemorySegment mem, int offset) {
        return UIDataValue.toObject(mem, offset + getValidatedOffset(mem, offset, 8, 12, "Value"));
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
    
    public static InsertDataContextCollectionItemServersideUIProperty toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static InsertDataContextCollectionItemServersideUIProperty toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one InsertDataContextCollectionItemServersideUIProperty and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static InsertDataContextCollectionItemServersideUIProperty toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 12;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0;
        requireSlot(mem, offset + 4, varPos, "Property");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Property", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        UIDataValue v2;
        requireSlot(mem, offset + 8, varPos, "Value");
        {
            v2 = UIDataValue.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new InsertDataContextCollectionItemServersideUIProperty(
            v0,
            mem.get(PacketIO.PROTO_INT, offset + 0),
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.index);
        var varOffset = offset + 12;
        mem.set(PacketIO.PROTO_INT, offset + 4, varOffset - offset - 12);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.property, 4096000);
        mem.set(PacketIO.PROTO_INT, offset + 8, varOffset - offset - 12);
        varOffset += this.value.serializeWithTypeId(mem, varOffset);
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 12;
        size += PacketIO.stringSize(property);
    size += value.computeSizeWithTypeId();

        return size;
    }

    public InsertDataContextCollectionItemServersideUIProperty clone() {
        InsertDataContextCollectionItemServersideUIProperty copy = new InsertDataContextCollectionItemServersideUIProperty();
        copy.property = this.property;
        copy.index = this.index;
        copy.value = this.value;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InsertDataContextCollectionItemServersideUIProperty other)) return false;
        return java.util.Objects.equals(this.property, other.property) && this.index == other.index && java.util.Objects.equals(this.value, other.value);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(property, index, value);
    }

}