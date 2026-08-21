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


public class CommandOptionalArgEntry {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 4;
    public static final int VARIABLE_BLOCK_START = 17;
    public static final int MAX_SIZE = 65536037;

    @Nullable public String name;
    @Nullable public String hint;
    @Nullable public String argTypeId;
    @Nullable public String description;

    public CommandOptionalArgEntry() {
    }

    public CommandOptionalArgEntry(@Nullable String name, @Nullable String hint, @Nullable String argTypeId, @Nullable String description) {
        this.name = name;
        this.hint = hint;
        this.argTypeId = argTypeId;
        this.description = description;
    }

    public CommandOptionalArgEntry(@Nonnull CommandOptionalArgEntry other) {
        this.name = other.name;
        this.hint = other.hint;
        this.argTypeId = other.argTypeId;
        this.description = other.description;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CommandOptionalArgEntry", offset, (int) mem.byteSize());
        long needed = (long) offset + 17;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CommandOptionalArgEntry", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getName(MemorySegment mem) {
        return getName(mem, 0);
    }
    
    @Nullable
    public static String getName(MemorySegment mem, int offset) {
        return hasName(mem, offset) ? PacketIO.readVarString("Name", mem, offset + getValidatedOffset(mem, offset, 1, 17, "Name"), 4096000): null;
    }
    
    @Nullable
    public static String getHint(MemorySegment mem) {
        return getHint(mem, 0);
    }
    
    @Nullable
    public static String getHint(MemorySegment mem, int offset) {
        return hasHint(mem, offset) ? PacketIO.readVarString("Hint", mem, offset + getValidatedOffset(mem, offset, 5, 17, "Hint"), 4096000): null;
    }
    
    @Nullable
    public static String getArgTypeId(MemorySegment mem) {
        return getArgTypeId(mem, 0);
    }
    
    @Nullable
    public static String getArgTypeId(MemorySegment mem, int offset) {
        return hasArgTypeId(mem, offset) ? PacketIO.readVarString("ArgTypeId", mem, offset + getValidatedOffset(mem, offset, 9, 17, "ArgTypeId"), 4096000): null;
    }
    
    @Nullable
    public static String getDescription(MemorySegment mem) {
        return getDescription(mem, 0);
    }
    
    @Nullable
    public static String getDescription(MemorySegment mem, int offset) {
        return hasDescription(mem, offset) ? PacketIO.readVarString("Description", mem, offset + getValidatedOffset(mem, offset, 13, 17, "Description"), 4096000): null;
    }
    
    public static boolean hasName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasHint(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasArgTypeId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasDescription(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
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
    
    public static CommandOptionalArgEntry toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CommandOptionalArgEntry toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CommandOptionalArgEntry and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CommandOptionalArgEntry toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 17;
        var varPos = 0;
        String v0 = null;
        if (hasName(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "Name");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Name", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 1, -1, "Name");
        }
        
        String v1 = null;
        if (hasHint(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Hint");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Hint", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 5, -1, "Hint");
        }
        
        String v2 = null;
        if (hasArgTypeId(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "ArgTypeId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("ArgTypeId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 9, -1, "ArgTypeId");
        }
        
        String v3 = null;
        if (hasDescription(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "Description");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readVarString("Description", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 13, -1, "Description");
        }
        var result = new CommandOptionalArgEntry(
            v0,
            v1,
            v2,
            v3
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.name != null) nullBits |= 0x01;
        if (this.hint != null) nullBits |= 0x02;
        if (this.argTypeId != null) nullBits |= 0x04;
        if (this.description != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 17;
        if (this.name != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 17);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.name, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.hint != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 17);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.hint, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.argTypeId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 17);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.argTypeId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
        if (this.description != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 17);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.description, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 17;
        if (name != null) size += PacketIO.stringSize(name);
    if (hint != null) size += PacketIO.stringSize(hint);
    if (argTypeId != null) size += PacketIO.stringSize(argTypeId);
    if (description != null) size += PacketIO.stringSize(description);

        return size;
    }

    public CommandOptionalArgEntry clone() {
        CommandOptionalArgEntry copy = new CommandOptionalArgEntry();
        copy.name = this.name;
        copy.hint = this.hint;
        copy.argTypeId = this.argTypeId;
        copy.description = this.description;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CommandOptionalArgEntry other)) return false;
        return java.util.Objects.equals(this.name, other.name) && java.util.Objects.equals(this.hint, other.hint) && java.util.Objects.equals(this.argTypeId, other.argTypeId) && java.util.Objects.equals(this.description, other.description);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, hint, argTypeId, description);
    }

}