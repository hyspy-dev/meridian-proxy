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


public class CustomUIEventBinding {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 3;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 11;
    public static final int MAX_SIZE = 32768021;

    @Nonnull public CustomUIEventBindingType type = CustomUIEventBindingType.Activating;
    @Nullable public String selector;
    @Nullable public String data;
    public boolean locksInterface;

    public CustomUIEventBinding() {
    }

    public CustomUIEventBinding(@Nonnull CustomUIEventBindingType type, @Nullable String selector, @Nullable String data, boolean locksInterface) {
        this.type = type;
        this.selector = selector;
        this.data = data;
        this.locksInterface = locksInterface;
    }

    public CustomUIEventBinding(@Nonnull CustomUIEventBinding other) {
        this.type = other.type;
        this.selector = other.selector;
        this.data = other.data;
        this.locksInterface = other.locksInterface;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CustomUIEventBinding", offset, (int) mem.byteSize());
        long needed = (long) offset + 11;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CustomUIEventBinding", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static CustomUIEventBindingType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static CustomUIEventBindingType getType(MemorySegment mem, int offset) {
        return CustomUIEventBindingType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static String getSelector(MemorySegment mem) {
        return getSelector(mem, 0);
    }
    
    @Nullable
    public static String getSelector(MemorySegment mem, int offset) {
        return hasSelector(mem, offset) ? PacketIO.readVarString("Selector", mem, offset + getValidatedOffset(mem, offset, 3, 11, "Selector"), 4096000): null;
    }
    
    @Nullable
    public static String getData(MemorySegment mem) {
        return getData(mem, 0);
    }
    
    @Nullable
    public static String getData(MemorySegment mem, int offset) {
        return hasData(mem, offset) ? PacketIO.readVarString("Data", mem, offset + getValidatedOffset(mem, offset, 7, 11, "Data"), 4096000): null;
    }
    
    public static boolean getLocksInterface(MemorySegment mem) {
        return getLocksInterface(mem, 0);
    }
    
    public static boolean getLocksInterface(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 2);
    }
    
    public static boolean hasSelector(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasData(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
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
    
    public static CustomUIEventBinding toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CustomUIEventBinding toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CustomUIEventBinding and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CustomUIEventBinding toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 11;
        var varPos = 0;
        String v1 = null;
        if (hasSelector(mem, offset)) {
            requireSlot(mem, offset + 3, varPos, "Selector");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Selector", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 3, -1, "Selector");
        }
        
        String v2 = null;
        if (hasData(mem, offset)) {
            requireSlot(mem, offset + 7, varPos, "Data");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("Data", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 7, -1, "Data");
        }
        var result = new CustomUIEventBinding(
            CustomUIEventBindingType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v1,
            v2,
            mem.get(PacketIO.PROTO_BOOL, offset + 2)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.selector != null) nullBits |= 0x01;
        if (this.data != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        mem.set(PacketIO.PROTO_BOOL, offset + 2, this.locksInterface);
        var varOffset = offset + 11;
        if (this.selector != null) {
            mem.set(PacketIO.PROTO_INT, offset + 3, varOffset - offset - 11);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.selector, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 3, -1);
        }
        if (this.data != null) {
            mem.set(PacketIO.PROTO_INT, offset + 7, varOffset - offset - 11);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.data, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 7, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 11;
        if (selector != null) size += PacketIO.stringSize(selector);
    if (data != null) size += PacketIO.stringSize(data);

        return size;
    }

    public CustomUIEventBinding clone() {
        CustomUIEventBinding copy = new CustomUIEventBinding();
        copy.type = this.type;
        copy.selector = this.selector;
        copy.data = this.data;
        copy.locksInterface = this.locksInterface;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CustomUIEventBinding other)) return false;
        return java.util.Objects.equals(this.type, other.type) && java.util.Objects.equals(this.selector, other.selector) && java.util.Objects.equals(this.data, other.data) && this.locksInterface == other.locksInterface;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(type, selector, data, locksInterface);
    }

}