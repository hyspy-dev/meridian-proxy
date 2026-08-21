// Auto-generated - do not edit
package meridian.protocol.packets.buildertools;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class BuilderToolOptionArg {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String defaultValue;
    @Nullable public String[] options;

    public BuilderToolOptionArg() {
    }

    public BuilderToolOptionArg(@Nullable String defaultValue, @Nullable String[] options) {
        this.defaultValue = defaultValue;
        this.options = options;
    }

    public BuilderToolOptionArg(@Nonnull BuilderToolOptionArg other) {
        this.defaultValue = other.defaultValue;
        this.options = other.options;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolOptionArg", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolOptionArg", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getDefault(MemorySegment mem) {
        return getDefault(mem, 0);
    }
    
    @Nullable
    public static String getDefault(MemorySegment mem, int offset) {
        return hasDefault(mem, offset) ? PacketIO.readVarString("Default", mem, offset + getValidatedOffset(mem, offset, 1, 9, "Default"), 4096000): null;
    }
    
    @Nullable
    public static String[] getOptions(MemorySegment mem) {
        return getOptions(mem, 0);
    }
    
    @Nullable
    public static String[] getOptions(MemorySegment mem, int offset) {
        if (!hasOptions(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 5, 9, "Options");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Options");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Options", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Options", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("Options", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    public static boolean hasDefault(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasOptions(MemorySegment mem, int offset) {
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
    
    public static BuilderToolOptionArg toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolOptionArg toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolOptionArg and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolOptionArg toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        String v0 = null;
        if (hasDefault(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "Default");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Default", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 1, -1, "Default");
        }
        
        String[] v1 = null;
        if (hasOptions(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Options");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Options");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Options", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Options", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v1[i] = PacketIO.readVarString("Options", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "Options");
        }
        var result = new BuilderToolOptionArg(
            v0,
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.defaultValue != null) nullBits |= 0x01;
        if (this.options != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 9;
        if (this.defaultValue != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 9);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.defaultValue, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.options != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 9);
            if (options.length > 4096000) throw ProtocolException.arrayTooLong("Options", options.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.options.length);
            
            var optionsValueOffset = 0;
            for (var i = 0; i < this.options.length; i++) {
                optionsValueOffset += PacketIO.writeVarString(mem, varOffset + optionsValueOffset, this.options[i], 4096000);
            }
            varOffset += optionsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (defaultValue != null) size += PacketIO.stringSize(defaultValue);
    if (options != null) {
        int optionsSize = 0;
for (var elem : options) optionsSize += PacketIO.stringSize(elem);
size += VarInt.size(options.length) + optionsSize;
    }

        return size;
    }

    public BuilderToolOptionArg clone() {
        BuilderToolOptionArg copy = new BuilderToolOptionArg();
        copy.defaultValue = this.defaultValue;
        copy.options = this.options != null ? java.util.Arrays.copyOf(this.options, this.options.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolOptionArg other)) return false;
        return java.util.Objects.equals(this.defaultValue, other.defaultValue) && java.util.Arrays.equals(this.options, other.options);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(defaultValue);
        result = 31 * result + java.util.Arrays.hashCode(options);
        return result;
    }

}