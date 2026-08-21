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


public class SetElementPropertyServersideUICommand extends ServersideUICommand {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 12;
    public static final int MAX_SIZE = 32769046;

    @Nonnull public String selector = "";
    @Nonnull public String propertyName = "";
    @Nonnull public UIDataValue value;

    public SetElementPropertyServersideUICommand() {
    }

    public SetElementPropertyServersideUICommand(@Nonnull String selector, @Nonnull String propertyName, @Nonnull UIDataValue value) {
        this.selector = selector;
        this.propertyName = propertyName;
        this.value = value;
    }

    public SetElementPropertyServersideUICommand(@Nonnull SetElementPropertyServersideUICommand other) {
        this.selector = other.selector;
        this.propertyName = other.propertyName;
        this.value = other.value;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SetElementPropertyServersideUICommand", offset, (int) mem.byteSize());
        long needed = (long) offset + 12;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SetElementPropertyServersideUICommand", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getSelector(MemorySegment mem) {
        return getSelector(mem, 0);
    }
    
    public static String getSelector(MemorySegment mem, int offset) {
        return PacketIO.readVarString("Selector", mem, offset + getValidatedOffset(mem, offset, 0, 12, "Selector"), 4096000);
    }
    
    public static String getPropertyName(MemorySegment mem) {
        return getPropertyName(mem, 0);
    }
    
    public static String getPropertyName(MemorySegment mem, int offset) {
        return PacketIO.readVarString("PropertyName", mem, offset + getValidatedOffset(mem, offset, 4, 12, "PropertyName"), 4096000);
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
    
    public static SetElementPropertyServersideUICommand toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SetElementPropertyServersideUICommand toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SetElementPropertyServersideUICommand and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SetElementPropertyServersideUICommand toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 12;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0;
        requireSlot(mem, offset + 0, varPos, "Selector");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Selector", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        String v1;
        requireSlot(mem, offset + 4, varPos, "PropertyName");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("PropertyName", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        UIDataValue v2;
        requireSlot(mem, offset + 8, varPos, "Value");
        {
            v2 = UIDataValue.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new SetElementPropertyServersideUICommand(
            v0,
            v1,
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 12;
        mem.set(PacketIO.PROTO_INT, offset + 0, varOffset - offset - 12);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.selector, 4096000);
        mem.set(PacketIO.PROTO_INT, offset + 4, varOffset - offset - 12);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.propertyName, 4096000);
        mem.set(PacketIO.PROTO_INT, offset + 8, varOffset - offset - 12);
        varOffset += this.value.serializeWithTypeId(mem, varOffset);
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 12;
        size += PacketIO.stringSize(selector);
    size += PacketIO.stringSize(propertyName);
    size += value.computeSizeWithTypeId();

        return size;
    }

    public SetElementPropertyServersideUICommand clone() {
        SetElementPropertyServersideUICommand copy = new SetElementPropertyServersideUICommand();
        copy.selector = this.selector;
        copy.propertyName = this.propertyName;
        copy.value = this.value;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SetElementPropertyServersideUICommand other)) return false;
        return java.util.Objects.equals(this.selector, other.selector) && java.util.Objects.equals(this.propertyName, other.propertyName) && java.util.Objects.equals(this.value, other.value);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(selector, propertyName, value);
    }

}