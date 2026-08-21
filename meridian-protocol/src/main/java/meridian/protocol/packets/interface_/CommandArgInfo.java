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


public class CommandArgInfo {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 4;
    public static final int VARIABLE_BLOCK_START = 21;
    public static final int MAX_SIZE = 65536041;

    @Nullable public String name;
    @Nullable public String argTypeId;
    @Nullable public String argTypeName;
    public int valueCount;
    @Nullable public String description;

    public CommandArgInfo() {
    }

    public CommandArgInfo(@Nullable String name, @Nullable String argTypeId, @Nullable String argTypeName, int valueCount, @Nullable String description) {
        this.name = name;
        this.argTypeId = argTypeId;
        this.argTypeName = argTypeName;
        this.valueCount = valueCount;
        this.description = description;
    }

    public CommandArgInfo(@Nonnull CommandArgInfo other) {
        this.name = other.name;
        this.argTypeId = other.argTypeId;
        this.argTypeName = other.argTypeName;
        this.valueCount = other.valueCount;
        this.description = other.description;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CommandArgInfo", offset, (int) mem.byteSize());
        long needed = (long) offset + 21;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CommandArgInfo", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getName(MemorySegment mem) {
        return getName(mem, 0);
    }
    
    @Nullable
    public static String getName(MemorySegment mem, int offset) {
        return hasName(mem, offset) ? PacketIO.readVarString("Name", mem, offset + getValidatedOffset(mem, offset, 5, 21, "Name"), 4096000): null;
    }
    
    @Nullable
    public static String getArgTypeId(MemorySegment mem) {
        return getArgTypeId(mem, 0);
    }
    
    @Nullable
    public static String getArgTypeId(MemorySegment mem, int offset) {
        return hasArgTypeId(mem, offset) ? PacketIO.readVarString("ArgTypeId", mem, offset + getValidatedOffset(mem, offset, 9, 21, "ArgTypeId"), 4096000): null;
    }
    
    @Nullable
    public static String getArgTypeName(MemorySegment mem) {
        return getArgTypeName(mem, 0);
    }
    
    @Nullable
    public static String getArgTypeName(MemorySegment mem, int offset) {
        return hasArgTypeName(mem, offset) ? PacketIO.readVarString("ArgTypeName", mem, offset + getValidatedOffset(mem, offset, 13, 21, "ArgTypeName"), 4096000): null;
    }
    
    public static int getValueCount(MemorySegment mem) {
        return getValueCount(mem, 0);
    }
    
    public static int getValueCount(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static String getDescription(MemorySegment mem) {
        return getDescription(mem, 0);
    }
    
    @Nullable
    public static String getDescription(MemorySegment mem, int offset) {
        return hasDescription(mem, offset) ? PacketIO.readVarString("Description", mem, offset + getValidatedOffset(mem, offset, 17, 21, "Description"), 4096000): null;
    }
    
    public static boolean hasName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasArgTypeId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasArgTypeName(MemorySegment mem, int offset) {
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
    
    public static CommandArgInfo toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CommandArgInfo toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CommandArgInfo and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CommandArgInfo toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 21;
        var varPos = 0;
        String v0 = null;
        if (hasName(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Name");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Name", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 5, -1, "Name");
        }
        
        String v1 = null;
        if (hasArgTypeId(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "ArgTypeId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("ArgTypeId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 9, -1, "ArgTypeId");
        }
        
        String v2 = null;
        if (hasArgTypeName(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "ArgTypeName");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("ArgTypeName", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 13, -1, "ArgTypeName");
        }
        
        String v4 = null;
        if (hasDescription(mem, offset)) {
            requireSlot(mem, offset + 17, varPos, "Description");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v4 = PacketIO.readVarString("Description", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 17, -1, "Description");
        }
        var result = new CommandArgInfo(
            v0,
            v1,
            v2,
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v4
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.name != null) nullBits |= 0x01;
        if (this.argTypeId != null) nullBits |= 0x02;
        if (this.argTypeName != null) nullBits |= 0x04;
        if (this.description != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.valueCount);
        var varOffset = offset + 21;
        if (this.name != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 21);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.name, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.argTypeId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 21);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.argTypeId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
        if (this.argTypeName != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 21);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.argTypeName, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
        if (this.description != null) {
            mem.set(PacketIO.PROTO_INT, offset + 17, varOffset - offset - 21);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.description, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 17, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 21;
        if (name != null) size += PacketIO.stringSize(name);
    if (argTypeId != null) size += PacketIO.stringSize(argTypeId);
    if (argTypeName != null) size += PacketIO.stringSize(argTypeName);
    if (description != null) size += PacketIO.stringSize(description);

        return size;
    }

    public CommandArgInfo clone() {
        CommandArgInfo copy = new CommandArgInfo();
        copy.name = this.name;
        copy.argTypeId = this.argTypeId;
        copy.argTypeName = this.argTypeName;
        copy.valueCount = this.valueCount;
        copy.description = this.description;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CommandArgInfo other)) return false;
        return java.util.Objects.equals(this.name, other.name) && java.util.Objects.equals(this.argTypeId, other.argTypeId) && java.util.Objects.equals(this.argTypeName, other.argTypeName) && this.valueCount == other.valueCount && java.util.Objects.equals(this.description, other.description);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, argTypeId, argTypeName, valueCount, description);
    }

}