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

public class ItemTranslationProperties {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 4;
    public static final int VARIABLE_BLOCK_START = 17;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String name;
    @Nullable public java.util.Map<String, FormattedMessage> nameArguments;
    @Nullable public String description;
    @Nullable public java.util.Map<String, FormattedMessage> descriptionArguments;

    public ItemTranslationProperties() {
    }

    public ItemTranslationProperties(@Nullable String name, @Nullable java.util.Map<String, FormattedMessage> nameArguments, @Nullable String description, @Nullable java.util.Map<String, FormattedMessage> descriptionArguments) {
        this.name = name;
        this.nameArguments = nameArguments;
        this.description = description;
        this.descriptionArguments = descriptionArguments;
    }

    public ItemTranslationProperties(@Nonnull ItemTranslationProperties other) {
        this.name = other.name;
        this.nameArguments = other.nameArguments;
        this.description = other.description;
        this.descriptionArguments = other.descriptionArguments;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemTranslationProperties", offset, (int) mem.byteSize());
        long needed = (long) offset + 17;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemTranslationProperties", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
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
    public static java.util.Map<String, FormattedMessage> getNameArguments(MemorySegment mem) {
        return getNameArguments(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, FormattedMessage> getNameArguments(MemorySegment mem, int offset) {
        if (!hasNameArguments(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 5, 17, "NameArguments");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("NameArguments");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("NameArguments", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 41 > mem.byteSize()) throw ProtocolException.bufferTooSmall("NameArguments", (int) java.lang.Math.min(off + (long) len * 41, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, FormattedMessage> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = FormattedMessage.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("NameArguments", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static String getDescription(MemorySegment mem) {
        return getDescription(mem, 0);
    }
    
    @Nullable
    public static String getDescription(MemorySegment mem, int offset) {
        return hasDescription(mem, offset) ? PacketIO.readVarString("Description", mem, offset + getValidatedOffset(mem, offset, 9, 17, "Description"), 4096000): null;
    }
    
    @Nullable
    public static java.util.Map<String, FormattedMessage> getDescriptionArguments(MemorySegment mem) {
        return getDescriptionArguments(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, FormattedMessage> getDescriptionArguments(MemorySegment mem, int offset) {
        if (!hasDescriptionArguments(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 13, 17, "DescriptionArguments");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("DescriptionArguments");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("DescriptionArguments", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 41 > mem.byteSize()) throw ProtocolException.bufferTooSmall("DescriptionArguments", (int) java.lang.Math.min(off + (long) len * 41, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, FormattedMessage> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = FormattedMessage.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("DescriptionArguments", key);
            }
        }
        return data;
    }
    
    public static boolean hasName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasNameArguments(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasDescription(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasDescriptionArguments(MemorySegment mem, int offset) {
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
    
    public static ItemTranslationProperties toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemTranslationProperties toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemTranslationProperties and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemTranslationProperties toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 17;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
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
        
        java.util.Map<String, FormattedMessage> v1 = null;
        if (hasNameArguments(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "NameArguments");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("NameArguments");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("NameArguments", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 41 > mem.byteSize()) throw ProtocolException.bufferTooSmall("NameArguments", (int) java.lang.Math.min(off + (long) len * 41, Integer.MAX_VALUE), (int) mem.byteSize());
            v1 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = FormattedMessage.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v1.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("NameArguments", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "NameArguments");
        }
        
        String v2 = null;
        if (hasDescription(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "Description");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("Description", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 9, -1, "Description");
        }
        
        java.util.Map<String, FormattedMessage> v3 = null;
        if (hasDescriptionArguments(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "DescriptionArguments");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("DescriptionArguments");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("DescriptionArguments", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 41 > mem.byteSize()) throw ProtocolException.bufferTooSmall("DescriptionArguments", (int) java.lang.Math.min(off + (long) len * 41, Integer.MAX_VALUE), (int) mem.byteSize());
            v3 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = FormattedMessage.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v3.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("DescriptionArguments", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 13, -1, "DescriptionArguments");
        }
        var result = new ItemTranslationProperties(
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
        if (this.nameArguments != null) nullBits |= 0x02;
        if (this.description != null) nullBits |= 0x04;
        if (this.descriptionArguments != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 17;
        if (this.name != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 17);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.name, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.nameArguments != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 17);
            if (this.nameArguments.size() > 4096000) throw ProtocolException.dictionaryTooLarge("NameArguments", nameArguments.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.nameArguments.size());
            for (var e : this.nameArguments.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.description != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 17);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.description, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
        if (this.descriptionArguments != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 17);
            if (this.descriptionArguments.size() > 4096000) throw ProtocolException.dictionaryTooLarge("DescriptionArguments", descriptionArguments.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.descriptionArguments.size());
            for (var e : this.descriptionArguments.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 17;
        if (name != null) size += PacketIO.stringSize(name);
    if (nameArguments != null) {
        int nameArgumentsSize = 0;
for (var kvp : nameArguments.entrySet()) nameArgumentsSize += PacketIO.stringSize(kvp.getKey()) + kvp.getValue().computeSize();
size += VarInt.size(nameArguments.size()) + nameArgumentsSize;
    }
    if (description != null) size += PacketIO.stringSize(description);
    if (descriptionArguments != null) {
        int descriptionArgumentsSize = 0;
for (var kvp : descriptionArguments.entrySet()) descriptionArgumentsSize += PacketIO.stringSize(kvp.getKey()) + kvp.getValue().computeSize();
size += VarInt.size(descriptionArguments.size()) + descriptionArgumentsSize;
    }

        return size;
    }

    public ItemTranslationProperties clone() {
        ItemTranslationProperties copy = new ItemTranslationProperties();
        copy.name = this.name;
        if (this.nameArguments != null) {
            java.util.Map<String, FormattedMessage> m = new java.util.HashMap<>();
            for (var e : this.nameArguments.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.nameArguments = m;
        }
        copy.description = this.description;
        if (this.descriptionArguments != null) {
            java.util.Map<String, FormattedMessage> m = new java.util.HashMap<>();
            for (var e : this.descriptionArguments.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.descriptionArguments = m;
        }
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemTranslationProperties other)) return false;
        return java.util.Objects.equals(this.name, other.name) && java.util.Objects.equals(this.nameArguments, other.nameArguments) && java.util.Objects.equals(this.description, other.description) && java.util.Objects.equals(this.descriptionArguments, other.descriptionArguments);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, nameArguments, description, descriptionArguments);
    }

}