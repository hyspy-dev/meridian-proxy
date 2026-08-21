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


public class CommandVariantEntry {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 5;
    public static final int VARIABLE_BLOCK_START = 21;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String pattern;
    @Nullable public CommandArgInfo[] requiredArgs;
    @Nullable public String usageText;
    @Nullable public CommandSuggestionOverride[] suggestionOverrides;
    @Nullable public String description;

    public CommandVariantEntry() {
    }

    public CommandVariantEntry(@Nullable String pattern, @Nullable CommandArgInfo[] requiredArgs, @Nullable String usageText, @Nullable CommandSuggestionOverride[] suggestionOverrides, @Nullable String description) {
        this.pattern = pattern;
        this.requiredArgs = requiredArgs;
        this.usageText = usageText;
        this.suggestionOverrides = suggestionOverrides;
        this.description = description;
    }

    public CommandVariantEntry(@Nonnull CommandVariantEntry other) {
        this.pattern = other.pattern;
        this.requiredArgs = other.requiredArgs;
        this.usageText = other.usageText;
        this.suggestionOverrides = other.suggestionOverrides;
        this.description = other.description;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CommandVariantEntry", offset, (int) mem.byteSize());
        long needed = (long) offset + 21;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CommandVariantEntry", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getPattern(MemorySegment mem) {
        return getPattern(mem, 0);
    }
    
    @Nullable
    public static String getPattern(MemorySegment mem, int offset) {
        return hasPattern(mem, offset) ? PacketIO.readVarString("Pattern", mem, offset + getValidatedOffset(mem, offset, 1, 21, "Pattern"), 4096000): null;
    }
    
    @Nullable
    public static CommandArgInfo[] getRequiredArgs(MemorySegment mem) {
        return getRequiredArgs(mem, 0);
    }
    
    @Nullable
    public static CommandArgInfo[] getRequiredArgs(MemorySegment mem, int offset) {
        if (!hasRequiredArgs(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 5, 21, "RequiredArgs");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("RequiredArgs");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("RequiredArgs", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 21 > mem.byteSize()) throw ProtocolException.bufferTooSmall("RequiredArgs", (int) java.lang.Math.min(off + lenOffset + (long) len * 21, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new CommandArgInfo[len];
        for (var i = 0; i < len; i++) {
            data[i] = CommandArgInfo.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static String getUsageText(MemorySegment mem) {
        return getUsageText(mem, 0);
    }
    
    @Nullable
    public static String getUsageText(MemorySegment mem, int offset) {
        return hasUsageText(mem, offset) ? PacketIO.readVarString("UsageText", mem, offset + getValidatedOffset(mem, offset, 9, 21, "UsageText"), 4096000): null;
    }
    
    @Nullable
    public static CommandSuggestionOverride[] getSuggestionOverrides(MemorySegment mem) {
        return getSuggestionOverrides(mem, 0);
    }
    
    @Nullable
    public static CommandSuggestionOverride[] getSuggestionOverrides(MemorySegment mem, int offset) {
        if (!hasSuggestionOverrides(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 13, 21, "SuggestionOverrides");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("SuggestionOverrides");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("SuggestionOverrides", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 9 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SuggestionOverrides", (int) java.lang.Math.min(off + lenOffset + (long) len * 9, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new CommandSuggestionOverride[len];
        for (var i = 0; i < len; i++) {
            data[i] = CommandSuggestionOverride.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static String getDescription(MemorySegment mem) {
        return getDescription(mem, 0);
    }
    
    @Nullable
    public static String getDescription(MemorySegment mem, int offset) {
        return hasDescription(mem, offset) ? PacketIO.readVarString("Description", mem, offset + getValidatedOffset(mem, offset, 17, 21, "Description"), 4096000): null;
    }
    
    public static boolean hasPattern(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasRequiredArgs(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasUsageText(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasSuggestionOverrides(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasDescription(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
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
    
    public static CommandVariantEntry toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CommandVariantEntry toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CommandVariantEntry and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CommandVariantEntry toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 21;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasPattern(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "Pattern");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Pattern", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 1, -1, "Pattern");
        }
        
        CommandArgInfo[] v1 = null;
        if (hasRequiredArgs(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "RequiredArgs");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("RequiredArgs");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("RequiredArgs", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 21 > mem.byteSize()) throw ProtocolException.bufferTooSmall("RequiredArgs", (int) java.lang.Math.min(off + lenOffset + (long) len * 21, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new CommandArgInfo[len];
            for (var i = 0; i < len; i++) {
                v1[i] = CommandArgInfo.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "RequiredArgs");
        }
        
        String v2 = null;
        if (hasUsageText(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "UsageText");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("UsageText", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 9, -1, "UsageText");
        }
        
        CommandSuggestionOverride[] v3 = null;
        if (hasSuggestionOverrides(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "SuggestionOverrides");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("SuggestionOverrides");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("SuggestionOverrides", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 9 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SuggestionOverrides", (int) java.lang.Math.min(off + lenOffset + (long) len * 9, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v3 = new CommandSuggestionOverride[len];
            for (var i = 0; i < len; i++) {
                v3[i] = CommandSuggestionOverride.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 13, -1, "SuggestionOverrides");
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
        var result = new CommandVariantEntry(
            v0,
            v1,
            v2,
            v3,
            v4
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.pattern != null) nullBits |= 0x01;
        if (this.requiredArgs != null) nullBits |= 0x02;
        if (this.usageText != null) nullBits |= 0x04;
        if (this.suggestionOverrides != null) nullBits |= 0x08;
        if (this.description != null) nullBits |= 0x10;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 21;
        if (this.pattern != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 21);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.pattern, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.requiredArgs != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 21);
            if (requiredArgs.length > 4096000) throw ProtocolException.arrayTooLong("RequiredArgs", requiredArgs.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.requiredArgs.length);
            
            var requiredArgsValueOffset = 0;
            for (var i = 0; i < this.requiredArgs.length; i++) {
                requiredArgsValueOffset += this.requiredArgs[i].serialize(mem, varOffset + requiredArgsValueOffset);
            }
            varOffset += requiredArgsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.usageText != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 21);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.usageText, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
        if (this.suggestionOverrides != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 21);
            if (suggestionOverrides.length > 4096000) throw ProtocolException.arrayTooLong("SuggestionOverrides", suggestionOverrides.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.suggestionOverrides.length);
            
            var suggestionOverridesValueOffset = 0;
            for (var i = 0; i < this.suggestionOverrides.length; i++) {
                suggestionOverridesValueOffset += this.suggestionOverrides[i].serialize(mem, varOffset + suggestionOverridesValueOffset);
            }
            varOffset += suggestionOverridesValueOffset;
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
        if (pattern != null) size += PacketIO.stringSize(pattern);
    if (requiredArgs != null) {
        int requiredArgsSize = 0;
for (var elem : requiredArgs) requiredArgsSize += elem.computeSize();
size += VarInt.size(requiredArgs.length) + requiredArgsSize;
    }
    if (usageText != null) size += PacketIO.stringSize(usageText);
    if (suggestionOverrides != null) {
        int suggestionOverridesSize = 0;
for (var elem : suggestionOverrides) suggestionOverridesSize += elem.computeSize();
size += VarInt.size(suggestionOverrides.length) + suggestionOverridesSize;
    }
    if (description != null) size += PacketIO.stringSize(description);

        return size;
    }

    public CommandVariantEntry clone() {
        CommandVariantEntry copy = new CommandVariantEntry();
        copy.pattern = this.pattern;
        copy.requiredArgs = this.requiredArgs != null ? java.util.Arrays.stream(this.requiredArgs).map(e -> e.clone()).toArray(CommandArgInfo[]::new) : null;
        copy.usageText = this.usageText;
        copy.suggestionOverrides = this.suggestionOverrides != null ? java.util.Arrays.stream(this.suggestionOverrides).map(e -> e.clone()).toArray(CommandSuggestionOverride[]::new) : null;
        copy.description = this.description;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CommandVariantEntry other)) return false;
        return java.util.Objects.equals(this.pattern, other.pattern) && java.util.Arrays.equals(this.requiredArgs, other.requiredArgs) && java.util.Objects.equals(this.usageText, other.usageText) && java.util.Arrays.equals(this.suggestionOverrides, other.suggestionOverrides) && java.util.Objects.equals(this.description, other.description);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(pattern);
        result = 31 * result + java.util.Arrays.hashCode(requiredArgs);
        result = 31 * result + java.util.Objects.hashCode(usageText);
        result = 31 * result + java.util.Arrays.hashCode(suggestionOverrides);
        result = 31 * result + java.util.Objects.hashCode(description);
        return result;
    }

}