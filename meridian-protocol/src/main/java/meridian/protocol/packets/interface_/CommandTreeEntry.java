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


public class CommandTreeEntry {
    public static final int NULLABLE_BIT_FIELD_SIZE = 2;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 10;
    public static final int VARIABLE_BLOCK_START = 42;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String name;
    @Nullable public String[] aliases;
    @Nullable public String usageText;
    @Nullable public String description;
    @Nullable public CommandVariantEntry[] variants;
    @Nullable public CommandTreeEntry[] subcommands;
    @Nullable public String[] subcommandHints;
    @Nullable public CommandArgInfo[] requiredArgs;
    @Nullable public CommandOptionalArgEntry[] optionalArgs;
    @Nullable public CommandSuggestionOverride[] suggestionOverrides;

    public CommandTreeEntry() {
    }

    public CommandTreeEntry(@Nullable String name, @Nullable String[] aliases, @Nullable String usageText, @Nullable String description, @Nullable CommandVariantEntry[] variants, @Nullable CommandTreeEntry[] subcommands, @Nullable String[] subcommandHints, @Nullable CommandArgInfo[] requiredArgs, @Nullable CommandOptionalArgEntry[] optionalArgs, @Nullable CommandSuggestionOverride[] suggestionOverrides) {
        this.name = name;
        this.aliases = aliases;
        this.usageText = usageText;
        this.description = description;
        this.variants = variants;
        this.subcommands = subcommands;
        this.subcommandHints = subcommandHints;
        this.requiredArgs = requiredArgs;
        this.optionalArgs = optionalArgs;
        this.suggestionOverrides = suggestionOverrides;
    }

    public CommandTreeEntry(@Nonnull CommandTreeEntry other) {
        this.name = other.name;
        this.aliases = other.aliases;
        this.usageText = other.usageText;
        this.description = other.description;
        this.variants = other.variants;
        this.subcommands = other.subcommands;
        this.subcommandHints = other.subcommandHints;
        this.requiredArgs = other.requiredArgs;
        this.optionalArgs = other.optionalArgs;
        this.suggestionOverrides = other.suggestionOverrides;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CommandTreeEntry", offset, (int) mem.byteSize());
        long needed = (long) offset + 42;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CommandTreeEntry", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getName(MemorySegment mem) {
        return getName(mem, 0);
    }
    
    @Nullable
    public static String getName(MemorySegment mem, int offset) {
        return hasName(mem, offset) ? PacketIO.readVarString("Name", mem, offset + getValidatedOffset(mem, offset, 2, 42, "Name"), 4096000): null;
    }
    
    @Nullable
    public static String[] getAliases(MemorySegment mem) {
        return getAliases(mem, 0);
    }
    
    @Nullable
    public static String[] getAliases(MemorySegment mem, int offset) {
        if (!hasAliases(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 6, 42, "Aliases");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Aliases");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Aliases", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Aliases", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("Aliases", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    @Nullable
    public static String getUsageText(MemorySegment mem) {
        return getUsageText(mem, 0);
    }
    
    @Nullable
    public static String getUsageText(MemorySegment mem, int offset) {
        return hasUsageText(mem, offset) ? PacketIO.readVarString("UsageText", mem, offset + getValidatedOffset(mem, offset, 10, 42, "UsageText"), 4096000): null;
    }
    
    @Nullable
    public static String getDescription(MemorySegment mem) {
        return getDescription(mem, 0);
    }
    
    @Nullable
    public static String getDescription(MemorySegment mem, int offset) {
        return hasDescription(mem, offset) ? PacketIO.readVarString("Description", mem, offset + getValidatedOffset(mem, offset, 14, 42, "Description"), 4096000): null;
    }
    
    @Nullable
    public static CommandVariantEntry[] getVariants(MemorySegment mem) {
        return getVariants(mem, 0);
    }
    
    @Nullable
    public static CommandVariantEntry[] getVariants(MemorySegment mem, int offset) {
        if (!hasVariants(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 18, 42, "Variants");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Variants");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Variants", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 21 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Variants", (int) java.lang.Math.min(off + lenOffset + (long) len * 21, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new CommandVariantEntry[len];
        for (var i = 0; i < len; i++) {
            data[i] = CommandVariantEntry.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static CommandTreeEntry[] getSubcommands(MemorySegment mem) {
        return getSubcommands(mem, 0);
    }
    
    @Nullable
    public static CommandTreeEntry[] getSubcommands(MemorySegment mem, int offset) {
        if (!hasSubcommands(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 22, 42, "Subcommands");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Subcommands");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Subcommands", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Subcommands", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new CommandTreeEntry[len];
        for (var i = 0; i < len; i++) {
            data[i] = CommandTreeEntry.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static String[] getSubcommandHints(MemorySegment mem) {
        return getSubcommandHints(mem, 0);
    }
    
    @Nullable
    public static String[] getSubcommandHints(MemorySegment mem, int offset) {
        if (!hasSubcommandHints(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 26, 42, "SubcommandHints");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("SubcommandHints");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("SubcommandHints", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("SubcommandHints", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("SubcommandHints", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    @Nullable
    public static CommandArgInfo[] getRequiredArgs(MemorySegment mem) {
        return getRequiredArgs(mem, 0);
    }
    
    @Nullable
    public static CommandArgInfo[] getRequiredArgs(MemorySegment mem, int offset) {
        if (!hasRequiredArgs(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 30, 42, "RequiredArgs");
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
    public static CommandOptionalArgEntry[] getOptionalArgs(MemorySegment mem) {
        return getOptionalArgs(mem, 0);
    }
    
    @Nullable
    public static CommandOptionalArgEntry[] getOptionalArgs(MemorySegment mem, int offset) {
        if (!hasOptionalArgs(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 34, 42, "OptionalArgs");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("OptionalArgs");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("OptionalArgs", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("OptionalArgs", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new CommandOptionalArgEntry[len];
        for (var i = 0; i < len; i++) {
            data[i] = CommandOptionalArgEntry.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static CommandSuggestionOverride[] getSuggestionOverrides(MemorySegment mem) {
        return getSuggestionOverrides(mem, 0);
    }
    
    @Nullable
    public static CommandSuggestionOverride[] getSuggestionOverrides(MemorySegment mem, int offset) {
        if (!hasSuggestionOverrides(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 38, 42, "SuggestionOverrides");
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
    
    public static boolean hasName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasAliases(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasUsageText(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasDescription(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasVariants(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasSubcommands(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasSubcommandHints(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasRequiredArgs(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasOptionalArgs(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasSuggestionOverrides(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
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
    
    public static CommandTreeEntry toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CommandTreeEntry toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CommandTreeEntry and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CommandTreeEntry toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 42;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasName(mem, offset)) {
            requireSlot(mem, offset + 2, varPos, "Name");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Name", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 2, -1, "Name");
        }
        
        String[] v1 = null;
        if (hasAliases(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "Aliases");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Aliases");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Aliases", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Aliases", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v1[i] = PacketIO.readVarString("Aliases", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 6, -1, "Aliases");
        }
        
        String v2 = null;
        if (hasUsageText(mem, offset)) {
            requireSlot(mem, offset + 10, varPos, "UsageText");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("UsageText", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 10, -1, "UsageText");
        }
        
        String v3 = null;
        if (hasDescription(mem, offset)) {
            requireSlot(mem, offset + 14, varPos, "Description");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readVarString("Description", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 14, -1, "Description");
        }
        
        CommandVariantEntry[] v4 = null;
        if (hasVariants(mem, offset)) {
            requireSlot(mem, offset + 18, varPos, "Variants");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Variants");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Variants", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 21 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Variants", (int) java.lang.Math.min(off + lenOffset + (long) len * 21, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v4 = new CommandVariantEntry[len];
            for (var i = 0; i < len; i++) {
                v4[i] = CommandVariantEntry.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 18, -1, "Variants");
        }
        
        CommandTreeEntry[] v5 = null;
        if (hasSubcommands(mem, offset)) {
            requireSlot(mem, offset + 22, varPos, "Subcommands");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Subcommands");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Subcommands", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Subcommands", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v5 = new CommandTreeEntry[len];
            for (var i = 0; i < len; i++) {
                v5[i] = CommandTreeEntry.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 22, -1, "Subcommands");
        }
        
        String[] v6 = null;
        if (hasSubcommandHints(mem, offset)) {
            requireSlot(mem, offset + 26, varPos, "SubcommandHints");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("SubcommandHints");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("SubcommandHints", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("SubcommandHints", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v6 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v6[i] = PacketIO.readVarString("SubcommandHints", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 26, -1, "SubcommandHints");
        }
        
        CommandArgInfo[] v7 = null;
        if (hasRequiredArgs(mem, offset)) {
            requireSlot(mem, offset + 30, varPos, "RequiredArgs");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("RequiredArgs");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("RequiredArgs", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 21 > mem.byteSize()) throw ProtocolException.bufferTooSmall("RequiredArgs", (int) java.lang.Math.min(off + lenOffset + (long) len * 21, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v7 = new CommandArgInfo[len];
            for (var i = 0; i < len; i++) {
                v7[i] = CommandArgInfo.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 30, -1, "RequiredArgs");
        }
        
        CommandOptionalArgEntry[] v8 = null;
        if (hasOptionalArgs(mem, offset)) {
            requireSlot(mem, offset + 34, varPos, "OptionalArgs");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("OptionalArgs");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("OptionalArgs", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("OptionalArgs", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v8 = new CommandOptionalArgEntry[len];
            for (var i = 0; i < len; i++) {
                v8[i] = CommandOptionalArgEntry.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 34, -1, "OptionalArgs");
        }
        
        CommandSuggestionOverride[] v9 = null;
        if (hasSuggestionOverrides(mem, offset)) {
            requireSlot(mem, offset + 38, varPos, "SuggestionOverrides");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("SuggestionOverrides");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("SuggestionOverrides", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 9 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SuggestionOverrides", (int) java.lang.Math.min(off + lenOffset + (long) len * 9, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v9 = new CommandSuggestionOverride[len];
            for (var i = 0; i < len; i++) {
                v9[i] = CommandSuggestionOverride.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 38, -1, "SuggestionOverrides");
        }
        var result = new CommandTreeEntry(
            v0,
            v1,
            v2,
            v3,
            v4,
            v5,
            v6,
            v7,
            v8,
            v9
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.name != null) nullBits |= 0x01;
        if (this.aliases != null) nullBits |= 0x02;
        if (this.usageText != null) nullBits |= 0x04;
        if (this.description != null) nullBits |= 0x08;
        if (this.variants != null) nullBits |= 0x10;
        if (this.subcommands != null) nullBits |= 0x20;
        if (this.subcommandHints != null) nullBits |= 0x40;
        if (this.requiredArgs != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        nullBits = 0;
        if (this.optionalArgs != null) nullBits |= 0x01;
        if (this.suggestionOverrides != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 1, nullBits);
        
        
        var varOffset = offset + 42;
        if (this.name != null) {
            mem.set(PacketIO.PROTO_INT, offset + 2, varOffset - offset - 42);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.name, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 2, -1);
        }
        if (this.aliases != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 42);
            if (aliases.length > 4096000) throw ProtocolException.arrayTooLong("Aliases", aliases.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.aliases.length);
            
            var aliasesValueOffset = 0;
            for (var i = 0; i < this.aliases.length; i++) {
                aliasesValueOffset += PacketIO.writeVarString(mem, varOffset + aliasesValueOffset, this.aliases[i], 4096000);
            }
            varOffset += aliasesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
        if (this.usageText != null) {
            mem.set(PacketIO.PROTO_INT, offset + 10, varOffset - offset - 42);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.usageText, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 10, -1);
        }
        if (this.description != null) {
            mem.set(PacketIO.PROTO_INT, offset + 14, varOffset - offset - 42);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.description, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 14, -1);
        }
        if (this.variants != null) {
            mem.set(PacketIO.PROTO_INT, offset + 18, varOffset - offset - 42);
            if (variants.length > 4096000) throw ProtocolException.arrayTooLong("Variants", variants.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.variants.length);
            
            var variantsValueOffset = 0;
            for (var i = 0; i < this.variants.length; i++) {
                variantsValueOffset += this.variants[i].serialize(mem, varOffset + variantsValueOffset);
            }
            varOffset += variantsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 18, -1);
        }
        if (this.subcommands != null) {
            mem.set(PacketIO.PROTO_INT, offset + 22, varOffset - offset - 42);
            if (subcommands.length > 4096000) throw ProtocolException.arrayTooLong("Subcommands", subcommands.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.subcommands.length);
            
            var subcommandsValueOffset = 0;
            for (var i = 0; i < this.subcommands.length; i++) {
                subcommandsValueOffset += this.subcommands[i].serialize(mem, varOffset + subcommandsValueOffset);
            }
            varOffset += subcommandsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 22, -1);
        }
        if (this.subcommandHints != null) {
            mem.set(PacketIO.PROTO_INT, offset + 26, varOffset - offset - 42);
            if (subcommandHints.length > 4096000) throw ProtocolException.arrayTooLong("SubcommandHints", subcommandHints.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.subcommandHints.length);
            
            var subcommandHintsValueOffset = 0;
            for (var i = 0; i < this.subcommandHints.length; i++) {
                subcommandHintsValueOffset += PacketIO.writeVarString(mem, varOffset + subcommandHintsValueOffset, this.subcommandHints[i], 4096000);
            }
            varOffset += subcommandHintsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 26, -1);
        }
        if (this.requiredArgs != null) {
            mem.set(PacketIO.PROTO_INT, offset + 30, varOffset - offset - 42);
            if (requiredArgs.length > 4096000) throw ProtocolException.arrayTooLong("RequiredArgs", requiredArgs.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.requiredArgs.length);
            
            var requiredArgsValueOffset = 0;
            for (var i = 0; i < this.requiredArgs.length; i++) {
                requiredArgsValueOffset += this.requiredArgs[i].serialize(mem, varOffset + requiredArgsValueOffset);
            }
            varOffset += requiredArgsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 30, -1);
        }
        if (this.optionalArgs != null) {
            mem.set(PacketIO.PROTO_INT, offset + 34, varOffset - offset - 42);
            if (optionalArgs.length > 4096000) throw ProtocolException.arrayTooLong("OptionalArgs", optionalArgs.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.optionalArgs.length);
            
            var optionalArgsValueOffset = 0;
            for (var i = 0; i < this.optionalArgs.length; i++) {
                optionalArgsValueOffset += this.optionalArgs[i].serialize(mem, varOffset + optionalArgsValueOffset);
            }
            varOffset += optionalArgsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 34, -1);
        }
        if (this.suggestionOverrides != null) {
            mem.set(PacketIO.PROTO_INT, offset + 38, varOffset - offset - 42);
            if (suggestionOverrides.length > 4096000) throw ProtocolException.arrayTooLong("SuggestionOverrides", suggestionOverrides.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.suggestionOverrides.length);
            
            var suggestionOverridesValueOffset = 0;
            for (var i = 0; i < this.suggestionOverrides.length; i++) {
                suggestionOverridesValueOffset += this.suggestionOverrides[i].serialize(mem, varOffset + suggestionOverridesValueOffset);
            }
            varOffset += suggestionOverridesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 38, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 42;
        if (name != null) size += PacketIO.stringSize(name);
    if (aliases != null) {
        int aliasesSize = 0;
for (var elem : aliases) aliasesSize += PacketIO.stringSize(elem);
size += VarInt.size(aliases.length) + aliasesSize;
    }
    if (usageText != null) size += PacketIO.stringSize(usageText);
    if (description != null) size += PacketIO.stringSize(description);
    if (variants != null) {
        int variantsSize = 0;
for (var elem : variants) variantsSize += elem.computeSize();
size += VarInt.size(variants.length) + variantsSize;
    }
    if (subcommands != null) {
        int subcommandsSize = 0;
for (var elem : subcommands) subcommandsSize += elem.computeSize();
size += VarInt.size(subcommands.length) + subcommandsSize;
    }
    if (subcommandHints != null) {
        int subcommandHintsSize = 0;
for (var elem : subcommandHints) subcommandHintsSize += PacketIO.stringSize(elem);
size += VarInt.size(subcommandHints.length) + subcommandHintsSize;
    }
    if (requiredArgs != null) {
        int requiredArgsSize = 0;
for (var elem : requiredArgs) requiredArgsSize += elem.computeSize();
size += VarInt.size(requiredArgs.length) + requiredArgsSize;
    }
    if (optionalArgs != null) {
        int optionalArgsSize = 0;
for (var elem : optionalArgs) optionalArgsSize += elem.computeSize();
size += VarInt.size(optionalArgs.length) + optionalArgsSize;
    }
    if (suggestionOverrides != null) {
        int suggestionOverridesSize = 0;
for (var elem : suggestionOverrides) suggestionOverridesSize += elem.computeSize();
size += VarInt.size(suggestionOverrides.length) + suggestionOverridesSize;
    }

        return size;
    }

    public CommandTreeEntry clone() {
        CommandTreeEntry copy = new CommandTreeEntry();
        copy.name = this.name;
        copy.aliases = this.aliases != null ? java.util.Arrays.copyOf(this.aliases, this.aliases.length) : null;
        copy.usageText = this.usageText;
        copy.description = this.description;
        copy.variants = this.variants != null ? java.util.Arrays.stream(this.variants).map(e -> e.clone()).toArray(CommandVariantEntry[]::new) : null;
        copy.subcommands = this.subcommands != null ? java.util.Arrays.stream(this.subcommands).map(e -> e.clone()).toArray(CommandTreeEntry[]::new) : null;
        copy.subcommandHints = this.subcommandHints != null ? java.util.Arrays.copyOf(this.subcommandHints, this.subcommandHints.length) : null;
        copy.requiredArgs = this.requiredArgs != null ? java.util.Arrays.stream(this.requiredArgs).map(e -> e.clone()).toArray(CommandArgInfo[]::new) : null;
        copy.optionalArgs = this.optionalArgs != null ? java.util.Arrays.stream(this.optionalArgs).map(e -> e.clone()).toArray(CommandOptionalArgEntry[]::new) : null;
        copy.suggestionOverrides = this.suggestionOverrides != null ? java.util.Arrays.stream(this.suggestionOverrides).map(e -> e.clone()).toArray(CommandSuggestionOverride[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CommandTreeEntry other)) return false;
        return java.util.Objects.equals(this.name, other.name) && java.util.Arrays.equals(this.aliases, other.aliases) && java.util.Objects.equals(this.usageText, other.usageText) && java.util.Objects.equals(this.description, other.description) && java.util.Arrays.equals(this.variants, other.variants) && java.util.Arrays.equals(this.subcommands, other.subcommands) && java.util.Arrays.equals(this.subcommandHints, other.subcommandHints) && java.util.Arrays.equals(this.requiredArgs, other.requiredArgs) && java.util.Arrays.equals(this.optionalArgs, other.optionalArgs) && java.util.Arrays.equals(this.suggestionOverrides, other.suggestionOverrides);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(name);
        result = 31 * result + java.util.Arrays.hashCode(aliases);
        result = 31 * result + java.util.Objects.hashCode(usageText);
        result = 31 * result + java.util.Objects.hashCode(description);
        result = 31 * result + java.util.Arrays.hashCode(variants);
        result = 31 * result + java.util.Arrays.hashCode(subcommands);
        result = 31 * result + java.util.Arrays.hashCode(subcommandHints);
        result = 31 * result + java.util.Arrays.hashCode(requiredArgs);
        result = 31 * result + java.util.Arrays.hashCode(optionalArgs);
        result = 31 * result + java.util.Arrays.hashCode(suggestionOverrides);
        return result;
    }

}