// Auto-generated - do not edit
package meridian.protocol.packets.asseteditor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class JsonUpdateCommand {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 3;
    public static final int VARIABLE_FIELD_COUNT = 4;
    public static final int VARIABLE_BLOCK_START = 19;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public JsonUpdateType type = JsonUpdateType.SetProperty;
    @Nullable public String[] path;
    @Nullable public String value;
    @Nullable public String previousValue;
    @Nullable public String[] firstCreatedProperty;
    @Nullable public AssetEditorRebuildCaches rebuildCaches;

    public JsonUpdateCommand() {
    }

    public JsonUpdateCommand(@Nonnull JsonUpdateType type, @Nullable String[] path, @Nullable String value, @Nullable String previousValue, @Nullable String[] firstCreatedProperty, @Nullable AssetEditorRebuildCaches rebuildCaches) {
        this.type = type;
        this.path = path;
        this.value = value;
        this.previousValue = previousValue;
        this.firstCreatedProperty = firstCreatedProperty;
        this.rebuildCaches = rebuildCaches;
    }

    public JsonUpdateCommand(@Nonnull JsonUpdateCommand other) {
        this.type = other.type;
        this.path = other.path;
        this.value = other.value;
        this.previousValue = other.previousValue;
        this.firstCreatedProperty = other.firstCreatedProperty;
        this.rebuildCaches = other.rebuildCaches;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("JsonUpdateCommand", offset, (int) mem.byteSize());
        long needed = (long) offset + 19;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("JsonUpdateCommand", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static JsonUpdateType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static JsonUpdateType getType(MemorySegment mem, int offset) {
        return JsonUpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static String[] getPath(MemorySegment mem) {
        return getPath(mem, 0);
    }
    
    @Nullable
    public static String[] getPath(MemorySegment mem, int offset) {
        if (!hasPath(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 3, 19, "Path");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Path");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Path", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Path", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("Path", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    @Nullable
    public static String getValue(MemorySegment mem) {
        return getValue(mem, 0);
    }
    
    @Nullable
    public static String getValue(MemorySegment mem, int offset) {
        return hasValue(mem, offset) ? PacketIO.readVarString("Value", mem, offset + getValidatedOffset(mem, offset, 7, 19, "Value"), 4096000): null;
    }
    
    @Nullable
    public static String getPreviousValue(MemorySegment mem) {
        return getPreviousValue(mem, 0);
    }
    
    @Nullable
    public static String getPreviousValue(MemorySegment mem, int offset) {
        return hasPreviousValue(mem, offset) ? PacketIO.readVarString("PreviousValue", mem, offset + getValidatedOffset(mem, offset, 11, 19, "PreviousValue"), 4096000): null;
    }
    
    @Nullable
    public static String[] getFirstCreatedProperty(MemorySegment mem) {
        return getFirstCreatedProperty(mem, 0);
    }
    
    @Nullable
    public static String[] getFirstCreatedProperty(MemorySegment mem, int offset) {
        if (!hasFirstCreatedProperty(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 15, 19, "FirstCreatedProperty");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("FirstCreatedProperty");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("FirstCreatedProperty", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("FirstCreatedProperty", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("FirstCreatedProperty", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    @Nullable
    public static AssetEditorRebuildCaches getRebuildCaches(MemorySegment mem) {
        return getRebuildCaches(mem, 0);
    }
    
    @Nullable
    public static AssetEditorRebuildCaches getRebuildCaches(MemorySegment mem, int offset) {
        return hasRebuildCaches(mem, offset) ? AssetEditorRebuildCaches.toObject(mem, offset + 2): null;
    }
    
    public static boolean hasRebuildCaches(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasPath(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasValue(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasPreviousValue(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasFirstCreatedProperty(MemorySegment mem, int offset) {
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
    
    public static JsonUpdateCommand toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static JsonUpdateCommand toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one JsonUpdateCommand and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static JsonUpdateCommand toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 19;
        var varPos = 0;
        String[] v1 = null;
        if (hasPath(mem, offset)) {
            requireSlot(mem, offset + 3, varPos, "Path");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Path");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Path", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Path", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v1[i] = PacketIO.readVarString("Path", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 3, -1, "Path");
        }
        
        String v2 = null;
        if (hasValue(mem, offset)) {
            requireSlot(mem, offset + 7, varPos, "Value");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("Value", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 7, -1, "Value");
        }
        
        String v3 = null;
        if (hasPreviousValue(mem, offset)) {
            requireSlot(mem, offset + 11, varPos, "PreviousValue");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readVarString("PreviousValue", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 11, -1, "PreviousValue");
        }
        
        String[] v4 = null;
        if (hasFirstCreatedProperty(mem, offset)) {
            requireSlot(mem, offset + 15, varPos, "FirstCreatedProperty");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("FirstCreatedProperty");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("FirstCreatedProperty", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("FirstCreatedProperty", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v4 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v4[i] = PacketIO.readVarString("FirstCreatedProperty", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 15, -1, "FirstCreatedProperty");
        }
        var result = new JsonUpdateCommand(
            JsonUpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v1,
            v2,
            v3,
            v4,
            hasRebuildCaches(mem, offset) ? AssetEditorRebuildCaches.toObject(mem, offset + 2) : null
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.rebuildCaches != null) nullBits |= 0x01;
        if (this.path != null) nullBits |= 0x02;
        if (this.value != null) nullBits |= 0x04;
        if (this.previousValue != null) nullBits |= 0x08;
        if (this.firstCreatedProperty != null) nullBits |= 0x10;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        if (this.rebuildCaches != null) {
            this.rebuildCaches.serialize(mem, offset + 2);
        } else {
            mem.asSlice(offset + 2, 1).fill((byte) 0); 
        }
        var varOffset = offset + 19;
        if (this.path != null) {
            mem.set(PacketIO.PROTO_INT, offset + 3, varOffset - offset - 19);
            if (path.length > 4096000) throw ProtocolException.arrayTooLong("Path", path.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.path.length);
            
            var pathValueOffset = 0;
            for (var i = 0; i < this.path.length; i++) {
                pathValueOffset += PacketIO.writeVarString(mem, varOffset + pathValueOffset, this.path[i], 4096000);
            }
            varOffset += pathValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 3, -1);
        }
        if (this.value != null) {
            mem.set(PacketIO.PROTO_INT, offset + 7, varOffset - offset - 19);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.value, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 7, -1);
        }
        if (this.previousValue != null) {
            mem.set(PacketIO.PROTO_INT, offset + 11, varOffset - offset - 19);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.previousValue, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 11, -1);
        }
        if (this.firstCreatedProperty != null) {
            mem.set(PacketIO.PROTO_INT, offset + 15, varOffset - offset - 19);
            if (firstCreatedProperty.length > 4096000) throw ProtocolException.arrayTooLong("FirstCreatedProperty", firstCreatedProperty.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.firstCreatedProperty.length);
            
            var firstCreatedPropertyValueOffset = 0;
            for (var i = 0; i < this.firstCreatedProperty.length; i++) {
                firstCreatedPropertyValueOffset += PacketIO.writeVarString(mem, varOffset + firstCreatedPropertyValueOffset, this.firstCreatedProperty[i], 4096000);
            }
            varOffset += firstCreatedPropertyValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 15, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 19;
        if (path != null) {
        int pathSize = 0;
for (var elem : path) pathSize += PacketIO.stringSize(elem);
size += VarInt.size(path.length) + pathSize;
    }
    if (value != null) size += PacketIO.stringSize(value);
    if (previousValue != null) size += PacketIO.stringSize(previousValue);
    if (firstCreatedProperty != null) {
        int firstCreatedPropertySize = 0;
for (var elem : firstCreatedProperty) firstCreatedPropertySize += PacketIO.stringSize(elem);
size += VarInt.size(firstCreatedProperty.length) + firstCreatedPropertySize;
    }

        return size;
    }

    public JsonUpdateCommand clone() {
        JsonUpdateCommand copy = new JsonUpdateCommand();
        copy.type = this.type;
        copy.path = this.path != null ? java.util.Arrays.copyOf(this.path, this.path.length) : null;
        copy.value = this.value;
        copy.previousValue = this.previousValue;
        copy.firstCreatedProperty = this.firstCreatedProperty != null ? java.util.Arrays.copyOf(this.firstCreatedProperty, this.firstCreatedProperty.length) : null;
        copy.rebuildCaches = this.rebuildCaches != null ? this.rebuildCaches.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof JsonUpdateCommand other)) return false;
        return java.util.Objects.equals(this.type, other.type) && java.util.Arrays.equals(this.path, other.path) && java.util.Objects.equals(this.value, other.value) && java.util.Objects.equals(this.previousValue, other.previousValue) && java.util.Arrays.equals(this.firstCreatedProperty, other.firstCreatedProperty) && java.util.Objects.equals(this.rebuildCaches, other.rebuildCaches);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(type);
        result = 31 * result + java.util.Arrays.hashCode(path);
        result = 31 * result + java.util.Objects.hashCode(value);
        result = 31 * result + java.util.Objects.hashCode(previousValue);
        result = 31 * result + java.util.Arrays.hashCode(firstCreatedProperty);
        result = 31 * result + java.util.Objects.hashCode(rebuildCaches);
        return result;
    }

}