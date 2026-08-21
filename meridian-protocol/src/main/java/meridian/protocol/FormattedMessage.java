// Auto-generated - do not edit
package meridian.protocol;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import java.util.HashMap;

public class FormattedMessage {
    public static final int NULLABLE_BIT_FIELD_SIZE = 2;
    public static final int FIXED_BLOCK_SIZE = 8;
    public static final int VARIABLE_FIELD_COUNT = 8;
    public static final int VARIABLE_BLOCK_START = 40;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String rawText;
    @Nullable public String messageId;
    @Nullable public FormattedMessage[] children;
    @Nullable public java.util.Map<String, ParamValue> params;
    @Nullable public java.util.Map<String, FormattedMessage> messageParams;
    @Nullable public String color;
    @Nullable public Boolean bold;
    @Nullable public Boolean italic;
    @Nullable public Boolean monospace;
    @Nullable public Boolean underlined;
    @Nullable public Boolean strikethrough;
    @Nullable public String link;
    public boolean markupEnabled;
    @Nullable public FormattedMessageImage image;

    public FormattedMessage() {
    }

    public FormattedMessage(@Nullable String rawText, @Nullable String messageId, @Nullable FormattedMessage[] children, @Nullable java.util.Map<String, ParamValue> params, @Nullable java.util.Map<String, FormattedMessage> messageParams, @Nullable String color, @Nullable Boolean bold, @Nullable Boolean italic, @Nullable Boolean monospace, @Nullable Boolean underlined, @Nullable Boolean strikethrough, @Nullable String link, boolean markupEnabled, @Nullable FormattedMessageImage image) {
        this.rawText = rawText;
        this.messageId = messageId;
        this.children = children;
        this.params = params;
        this.messageParams = messageParams;
        this.color = color;
        this.bold = bold;
        this.italic = italic;
        this.monospace = monospace;
        this.underlined = underlined;
        this.strikethrough = strikethrough;
        this.link = link;
        this.markupEnabled = markupEnabled;
        this.image = image;
    }

    public FormattedMessage(@Nonnull FormattedMessage other) {
        this.rawText = other.rawText;
        this.messageId = other.messageId;
        this.children = other.children;
        this.params = other.params;
        this.messageParams = other.messageParams;
        this.color = other.color;
        this.bold = other.bold;
        this.italic = other.italic;
        this.monospace = other.monospace;
        this.underlined = other.underlined;
        this.strikethrough = other.strikethrough;
        this.link = other.link;
        this.markupEnabled = other.markupEnabled;
        this.image = other.image;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("FormattedMessage", offset, (int) mem.byteSize());
        long needed = (long) offset + 40;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("FormattedMessage", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getRawText(MemorySegment mem) {
        return getRawText(mem, 0);
    }
    
    @Nullable
    public static String getRawText(MemorySegment mem, int offset) {
        return hasRawText(mem, offset) ? PacketIO.readVarString("RawText", mem, offset + getValidatedOffset(mem, offset, 8, 40, "RawText"), 4096000): null;
    }
    
    @Nullable
    public static String getMessageId(MemorySegment mem) {
        return getMessageId(mem, 0);
    }
    
    @Nullable
    public static String getMessageId(MemorySegment mem, int offset) {
        return hasMessageId(mem, offset) ? PacketIO.readVarString("MessageId", mem, offset + getValidatedOffset(mem, offset, 12, 40, "MessageId"), 4096000): null;
    }
    
    @Nullable
    public static FormattedMessage[] getChildren(MemorySegment mem) {
        return getChildren(mem, 0);
    }
    
    @Nullable
    public static FormattedMessage[] getChildren(MemorySegment mem, int offset) {
        if (!hasChildren(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 16, 40, "Children");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Children");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Children", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 40 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Children", (int) java.lang.Math.min(off + lenOffset + (long) len * 40, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new FormattedMessage[len];
        for (var i = 0; i < len; i++) {
            data[i] = FormattedMessage.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<String, ParamValue> getParams(MemorySegment mem) {
        return getParams(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, ParamValue> getParams(MemorySegment mem, int offset) {
        if (!hasParams(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 20, 40, "Params");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Params");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Params", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Params", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, ParamValue> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = ParamValue.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Params", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<String, FormattedMessage> getMessageParams(MemorySegment mem) {
        return getMessageParams(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, FormattedMessage> getMessageParams(MemorySegment mem, int offset) {
        if (!hasMessageParams(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 24, 40, "MessageParams");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("MessageParams");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("MessageParams", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 41 > mem.byteSize()) throw ProtocolException.bufferTooSmall("MessageParams", (int) java.lang.Math.min(off + (long) len * 41, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, FormattedMessage> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = FormattedMessage.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("MessageParams", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static String getColor(MemorySegment mem) {
        return getColor(mem, 0);
    }
    
    @Nullable
    public static String getColor(MemorySegment mem, int offset) {
        return hasColor(mem, offset) ? PacketIO.readVarString("Color", mem, offset + getValidatedOffset(mem, offset, 28, 40, "Color"), 4096000): null;
    }
    
    @Nullable
    public static Boolean getBold(MemorySegment mem) {
        return getBold(mem, 0);
    }
    
    @Nullable
    public static Boolean getBold(MemorySegment mem, int offset) {
        return hasBold(mem, offset) ? mem.get(PacketIO.PROTO_BOOL, offset + 2): null;
    }
    
    @Nullable
    public static Boolean getItalic(MemorySegment mem) {
        return getItalic(mem, 0);
    }
    
    @Nullable
    public static Boolean getItalic(MemorySegment mem, int offset) {
        return hasItalic(mem, offset) ? mem.get(PacketIO.PROTO_BOOL, offset + 3): null;
    }
    
    @Nullable
    public static Boolean getMonospace(MemorySegment mem) {
        return getMonospace(mem, 0);
    }
    
    @Nullable
    public static Boolean getMonospace(MemorySegment mem, int offset) {
        return hasMonospace(mem, offset) ? mem.get(PacketIO.PROTO_BOOL, offset + 4): null;
    }
    
    @Nullable
    public static Boolean getUnderlined(MemorySegment mem) {
        return getUnderlined(mem, 0);
    }
    
    @Nullable
    public static Boolean getUnderlined(MemorySegment mem, int offset) {
        return hasUnderlined(mem, offset) ? mem.get(PacketIO.PROTO_BOOL, offset + 5): null;
    }
    
    @Nullable
    public static Boolean getStrikethrough(MemorySegment mem) {
        return getStrikethrough(mem, 0);
    }
    
    @Nullable
    public static Boolean getStrikethrough(MemorySegment mem, int offset) {
        return hasStrikethrough(mem, offset) ? mem.get(PacketIO.PROTO_BOOL, offset + 6): null;
    }
    
    @Nullable
    public static String getLink(MemorySegment mem) {
        return getLink(mem, 0);
    }
    
    @Nullable
    public static String getLink(MemorySegment mem, int offset) {
        return hasLink(mem, offset) ? PacketIO.readVarString("Link", mem, offset + getValidatedOffset(mem, offset, 32, 40, "Link"), 4096000): null;
    }
    
    public static boolean getMarkupEnabled(MemorySegment mem) {
        return getMarkupEnabled(mem, 0);
    }
    
    public static boolean getMarkupEnabled(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 7);
    }
    
    @Nullable
    public static FormattedMessageImage getImage(MemorySegment mem) {
        return getImage(mem, 0);
    }
    
    @Nullable
    public static FormattedMessageImage getImage(MemorySegment mem, int offset) {
        return hasImage(mem, offset) ? FormattedMessageImage.toObject(mem, offset + getValidatedOffset(mem, offset, 36, 40, "Image")): null;
    }
    
    public static boolean hasBold(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasItalic(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasMonospace(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasUnderlined(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasStrikethrough(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasRawText(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasMessageId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasChildren(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasParams(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasMessageParams(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasColor(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasLink(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasImage(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
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
    
    public static FormattedMessage toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static FormattedMessage toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one FormattedMessage and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static FormattedMessage toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 40;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasRawText(mem, offset)) {
            requireSlot(mem, offset + 8, varPos, "RawText");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("RawText", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 8, -1, "RawText");
        }
        
        String v1 = null;
        if (hasMessageId(mem, offset)) {
            requireSlot(mem, offset + 12, varPos, "MessageId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("MessageId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 12, -1, "MessageId");
        }
        
        FormattedMessage[] v2 = null;
        if (hasChildren(mem, offset)) {
            requireSlot(mem, offset + 16, varPos, "Children");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Children");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Children", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 40 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Children", (int) java.lang.Math.min(off + lenOffset + (long) len * 40, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new FormattedMessage[len];
            for (var i = 0; i < len; i++) {
                v2[i] = FormattedMessage.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 16, -1, "Children");
        }
        
        java.util.Map<String, ParamValue> v3 = null;
        if (hasParams(mem, offset)) {
            requireSlot(mem, offset + 20, varPos, "Params");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Params");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Params", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Params", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            v3 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = ParamValue.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v3.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Params", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 20, -1, "Params");
        }
        
        java.util.Map<String, FormattedMessage> v4 = null;
        if (hasMessageParams(mem, offset)) {
            requireSlot(mem, offset + 24, varPos, "MessageParams");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("MessageParams");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("MessageParams", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 41 > mem.byteSize()) throw ProtocolException.bufferTooSmall("MessageParams", (int) java.lang.Math.min(off + (long) len * 41, Integer.MAX_VALUE), (int) mem.byteSize());
            v4 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = FormattedMessage.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v4.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("MessageParams", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 24, -1, "MessageParams");
        }
        
        String v5 = null;
        if (hasColor(mem, offset)) {
            requireSlot(mem, offset + 28, varPos, "Color");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v5 = PacketIO.readVarString("Color", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 28, -1, "Color");
        }
        
        String v11 = null;
        if (hasLink(mem, offset)) {
            requireSlot(mem, offset + 32, varPos, "Link");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v11 = PacketIO.readVarString("Link", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 32, -1, "Link");
        }
        
        FormattedMessageImage v13 = null;
        if (hasImage(mem, offset)) {
            requireSlot(mem, offset + 36, varPos, "Image");
            v13 = FormattedMessageImage.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 36, -1, "Image");
        }
        var result = new FormattedMessage(
            v0,
            v1,
            v2,
            v3,
            v4,
            v5,
            hasBold(mem, offset) ? mem.get(PacketIO.PROTO_BOOL, offset + 2) : null,
            hasItalic(mem, offset) ? mem.get(PacketIO.PROTO_BOOL, offset + 3) : null,
            hasMonospace(mem, offset) ? mem.get(PacketIO.PROTO_BOOL, offset + 4) : null,
            hasUnderlined(mem, offset) ? mem.get(PacketIO.PROTO_BOOL, offset + 5) : null,
            hasStrikethrough(mem, offset) ? mem.get(PacketIO.PROTO_BOOL, offset + 6) : null,
            v11,
            mem.get(PacketIO.PROTO_BOOL, offset + 7),
            v13
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.bold != null) nullBits |= 0x01;
        if (this.italic != null) nullBits |= 0x02;
        if (this.monospace != null) nullBits |= 0x04;
        if (this.underlined != null) nullBits |= 0x08;
        if (this.strikethrough != null) nullBits |= 0x10;
        if (this.rawText != null) nullBits |= 0x20;
        if (this.messageId != null) nullBits |= 0x40;
        if (this.children != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        nullBits = 0;
        if (this.params != null) nullBits |= 0x01;
        if (this.messageParams != null) nullBits |= 0x02;
        if (this.color != null) nullBits |= 0x04;
        if (this.link != null) nullBits |= 0x08;
        if (this.image != null) nullBits |= 0x10;
        mem.set(PacketIO.PROTO_BYTE, offset + 1, nullBits);
        
        if (this.bold != null) {
            mem.set(PacketIO.PROTO_BOOL, offset + 2, this.bold);
        } else {
            mem.asSlice(offset + 2, 1).fill((byte) 0); 
        }
        if (this.italic != null) {
            mem.set(PacketIO.PROTO_BOOL, offset + 3, this.italic);
        } else {
            mem.asSlice(offset + 3, 1).fill((byte) 0); 
        }
        if (this.monospace != null) {
            mem.set(PacketIO.PROTO_BOOL, offset + 4, this.monospace);
        } else {
            mem.asSlice(offset + 4, 1).fill((byte) 0); 
        }
        if (this.underlined != null) {
            mem.set(PacketIO.PROTO_BOOL, offset + 5, this.underlined);
        } else {
            mem.asSlice(offset + 5, 1).fill((byte) 0); 
        }
        if (this.strikethrough != null) {
            mem.set(PacketIO.PROTO_BOOL, offset + 6, this.strikethrough);
        } else {
            mem.asSlice(offset + 6, 1).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BOOL, offset + 7, this.markupEnabled);
        var varOffset = offset + 40;
        if (this.rawText != null) {
            mem.set(PacketIO.PROTO_INT, offset + 8, varOffset - offset - 40);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.rawText, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 8, -1);
        }
        if (this.messageId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 12, varOffset - offset - 40);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.messageId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 12, -1);
        }
        if (this.children != null) {
            mem.set(PacketIO.PROTO_INT, offset + 16, varOffset - offset - 40);
            if (children.length > 4096000) throw ProtocolException.arrayTooLong("Children", children.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.children.length);
            
            var childrenValueOffset = 0;
            for (var i = 0; i < this.children.length; i++) {
                childrenValueOffset += this.children[i].serialize(mem, varOffset + childrenValueOffset);
            }
            varOffset += childrenValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 16, -1);
        }
        if (this.params != null) {
            mem.set(PacketIO.PROTO_INT, offset + 20, varOffset - offset - 40);
            if (this.params.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Params", params.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.params.size());
            for (var e : this.params.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                varOffset += e.getValue().serializeWithTypeId(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 20, -1);
        }
        if (this.messageParams != null) {
            mem.set(PacketIO.PROTO_INT, offset + 24, varOffset - offset - 40);
            if (this.messageParams.size() > 4096000) throw ProtocolException.dictionaryTooLarge("MessageParams", messageParams.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.messageParams.size());
            for (var e : this.messageParams.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 24, -1);
        }
        if (this.color != null) {
            mem.set(PacketIO.PROTO_INT, offset + 28, varOffset - offset - 40);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.color, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 28, -1);
        }
        if (this.link != null) {
            mem.set(PacketIO.PROTO_INT, offset + 32, varOffset - offset - 40);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.link, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 32, -1);
        }
        if (this.image != null) {
            mem.set(PacketIO.PROTO_INT, offset + 36, varOffset - offset - 40);
            varOffset += this.image.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 36, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 40;
        if (rawText != null) size += PacketIO.stringSize(rawText);
    if (messageId != null) size += PacketIO.stringSize(messageId);
    if (children != null) {
        int childrenSize = 0;
for (var elem : children) childrenSize += elem.computeSize();
size += VarInt.size(children.length) + childrenSize;
    }
    if (params != null) {
        int paramsSize = 0;
for (var kvp : params.entrySet()) paramsSize += PacketIO.stringSize(kvp.getKey()) + kvp.getValue().computeSizeWithTypeId();
size += VarInt.size(params.size()) + paramsSize;
    }
    if (messageParams != null) {
        int messageParamsSize = 0;
for (var kvp : messageParams.entrySet()) messageParamsSize += PacketIO.stringSize(kvp.getKey()) + kvp.getValue().computeSize();
size += VarInt.size(messageParams.size()) + messageParamsSize;
    }
    if (color != null) size += PacketIO.stringSize(color);
    if (link != null) size += PacketIO.stringSize(link);
    if (image != null) size += image.computeSize();

        return size;
    }

    public FormattedMessage clone() {
        FormattedMessage copy = new FormattedMessage();
        copy.rawText = this.rawText;
        copy.messageId = this.messageId;
        copy.children = this.children != null ? java.util.Arrays.stream(this.children).map(e -> e.clone()).toArray(FormattedMessage[]::new) : null;
        copy.params = this.params != null ? new java.util.HashMap<>(this.params) : null;
        if (this.messageParams != null) {
            java.util.Map<String, FormattedMessage> m = new java.util.HashMap<>();
            for (var e : this.messageParams.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.messageParams = m;
        }
        copy.color = this.color;
        copy.bold = this.bold;
        copy.italic = this.italic;
        copy.monospace = this.monospace;
        copy.underlined = this.underlined;
        copy.strikethrough = this.strikethrough;
        copy.link = this.link;
        copy.markupEnabled = this.markupEnabled;
        copy.image = this.image != null ? this.image.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FormattedMessage other)) return false;
        return java.util.Objects.equals(this.rawText, other.rawText) && java.util.Objects.equals(this.messageId, other.messageId) && java.util.Arrays.equals(this.children, other.children) && java.util.Objects.equals(this.params, other.params) && java.util.Objects.equals(this.messageParams, other.messageParams) && java.util.Objects.equals(this.color, other.color) && java.util.Objects.equals(this.bold, other.bold) && java.util.Objects.equals(this.italic, other.italic) && java.util.Objects.equals(this.monospace, other.monospace) && java.util.Objects.equals(this.underlined, other.underlined) && java.util.Objects.equals(this.strikethrough, other.strikethrough) && java.util.Objects.equals(this.link, other.link) && this.markupEnabled == other.markupEnabled && java.util.Objects.equals(this.image, other.image);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(rawText);
        result = 31 * result + java.util.Objects.hashCode(messageId);
        result = 31 * result + java.util.Arrays.hashCode(children);
        result = 31 * result + java.util.Objects.hashCode(params);
        result = 31 * result + java.util.Objects.hashCode(messageParams);
        result = 31 * result + java.util.Objects.hashCode(color);
        result = 31 * result + java.util.Objects.hashCode(bold);
        result = 31 * result + java.util.Objects.hashCode(italic);
        result = 31 * result + java.util.Objects.hashCode(monospace);
        result = 31 * result + java.util.Objects.hashCode(underlined);
        result = 31 * result + java.util.Objects.hashCode(strikethrough);
        result = 31 * result + java.util.Objects.hashCode(link);
        result = 31 * result + Boolean.hashCode(markupEnabled);
        result = 31 * result + java.util.Objects.hashCode(image);
        return result;
    }

}