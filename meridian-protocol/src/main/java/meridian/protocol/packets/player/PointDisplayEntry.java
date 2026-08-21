// Auto-generated - do not edit
package meridian.protocol.packets.player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import java.util.HashMap;
import org.joml.*;

public class PointDisplayEntry {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 26;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 38;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public String id = "";
    @Nullable public String name;
    @Nonnull public Vector3fc position = PacketIO.ZERO_VECTOR3;
    @Nonnull public Vector3fc rotation = PacketIO.ZERO_VECTOR3;
    @Nullable public java.util.Map<String, String> tags;
    @Nonnull public PointShapeType shape = PointShapeType.Block;

    public PointDisplayEntry() {
    }

    public PointDisplayEntry(@Nonnull String id, @Nullable String name, @Nonnull Vector3fc position, @Nonnull Vector3fc rotation, @Nullable java.util.Map<String, String> tags, @Nonnull PointShapeType shape) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.rotation = rotation;
        this.tags = tags;
        this.shape = shape;
    }

    public PointDisplayEntry(@Nonnull PointDisplayEntry other) {
        this.id = other.id;
        this.name = other.name;
        this.position = other.position;
        this.rotation = other.rotation;
        this.tags = other.tags;
        this.shape = other.shape;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PointDisplayEntry", offset, (int) mem.byteSize());
        long needed = (long) offset + 38;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PointDisplayEntry", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    public static String getId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 26, 38, "Id"), 4096000);
    }
    
    @Nullable
    public static String getName(MemorySegment mem) {
        return getName(mem, 0);
    }
    
    @Nullable
    public static String getName(MemorySegment mem, int offset) {
        return hasName(mem, offset) ? PacketIO.readVarString("Name", mem, offset + getValidatedOffset(mem, offset, 30, 38, "Name"), 4096000): null;
    }
    
    public static Vector3fc getPosition(MemorySegment mem) {
        return getPosition(mem, 0);
    }
    
    public static Vector3fc getPosition(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 1), "Position");
    }
    
    public static Vector3fc getRotation(MemorySegment mem) {
        return getRotation(mem, 0);
    }
    
    public static Vector3fc getRotation(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 13), "Rotation");
    }
    
    @Nullable
    public static java.util.Map<String, String> getTags(MemorySegment mem) {
        return getTags(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, String> getTags(MemorySegment mem, int offset) {
        if (!hasTags(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 34, 38, "Tags");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Tags");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Tags", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Tags", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, String> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var valuePacked = VarInt.getWithLength(mem, off);
                var value = PacketIO.readVarString("value", mem, off, 0, 4096000, valuePacked);
                off += (int) valuePacked + (int) (valuePacked >>> 32);
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Tags", key);
            }
        }
        return data;
    }
    
    public static PointShapeType getShape(MemorySegment mem) {
        return getShape(mem, 0);
    }
    
    public static PointShapeType getShape(MemorySegment mem, int offset) {
        return PointShapeType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 25));
    }
    
    public static boolean hasName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasTags(MemorySegment mem, int offset) {
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
    
    public static PointDisplayEntry toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PointDisplayEntry toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PointDisplayEntry and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PointDisplayEntry toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 38;
        var varPos = 0;
        String v0;
        requireSlot(mem, offset + 26, varPos, "Id");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        String v1 = null;
        if (hasName(mem, offset)) {
            requireSlot(mem, offset + 30, varPos, "Name");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Name", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 30, -1, "Name");
        }
        
        java.util.Map<String, String> v4 = null;
        if (hasTags(mem, offset)) {
            requireSlot(mem, offset + 34, varPos, "Tags");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Tags");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Tags", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Tags", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            v4 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var valuePacked = VarInt.getWithLength(mem, off);
                    var value = PacketIO.readVarString("value", mem, off, 0, 4096000, valuePacked);
                    off += (int) valuePacked + (int) (valuePacked >>> 32);
                if (v4.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Tags", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 34, -1, "Tags");
        }
        var result = new PointDisplayEntry(
            v0,
            v1,
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 1), "Position"),
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 13), "Rotation"),
            v4,
            PointShapeType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 25))
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.name != null) nullBits |= 0x01;
        if (this.tags != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.position, "Position"); PacketIO.writeVector3f(mem, offset + 1, this.position);
        PacketIO.requireFinite(this.rotation, "Rotation"); PacketIO.writeVector3f(mem, offset + 13, this.rotation);
        mem.set(PacketIO.PROTO_BYTE, offset + 25, (byte) this.shape.getValue());
        var varOffset = offset + 38;
        mem.set(PacketIO.PROTO_INT, offset + 26, varOffset - offset - 38);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        if (this.name != null) {
            mem.set(PacketIO.PROTO_INT, offset + 30, varOffset - offset - 38);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.name, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 30, -1);
        }
        if (this.tags != null) {
            mem.set(PacketIO.PROTO_INT, offset + 34, varOffset - offset - 38);
            if (this.tags.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Tags", tags.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.tags.size());
            for (var e : this.tags.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getValue(), 4096000);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 34, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 38;
        size += PacketIO.stringSize(id);
    if (name != null) size += PacketIO.stringSize(name);
    if (tags != null) {
        int tagsSize = 0;
for (var kvp : tags.entrySet()) tagsSize += PacketIO.stringSize(kvp.getKey()) + PacketIO.stringSize(kvp.getValue());
size += VarInt.size(tags.size()) + tagsSize;
    }

        return size;
    }

    public PointDisplayEntry clone() {
        PointDisplayEntry copy = new PointDisplayEntry();
        copy.id = this.id;
        copy.name = this.name;
        copy.position = this.position;
        copy.rotation = this.rotation;
        copy.tags = this.tags != null ? new java.util.HashMap<>(this.tags) : null;
        copy.shape = this.shape;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PointDisplayEntry other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.name, other.name) && java.util.Objects.equals(this.position, other.position) && java.util.Objects.equals(this.rotation, other.rotation) && java.util.Objects.equals(this.tags, other.tags) && java.util.Objects.equals(this.shape, other.shape);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, name, position, rotation, tags, shape);
    }

}