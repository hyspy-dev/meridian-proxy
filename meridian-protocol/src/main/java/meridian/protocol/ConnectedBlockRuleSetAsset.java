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

public class ConnectedBlockRuleSetAsset {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 14;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public String id = "";
    @Nonnull public ConnectedBlockUpdateMode updateMode = ConnectedBlockUpdateMode.PlaceUpdate;
    @Nullable public java.util.Map<String, ConnectedBlockShape> shapes;
    @Nullable public ConnectedBlockPattern[] patterns;

    public ConnectedBlockRuleSetAsset() {
    }

    public ConnectedBlockRuleSetAsset(@Nonnull String id, @Nonnull ConnectedBlockUpdateMode updateMode, @Nullable java.util.Map<String, ConnectedBlockShape> shapes, @Nullable ConnectedBlockPattern[] patterns) {
        this.id = id;
        this.updateMode = updateMode;
        this.shapes = shapes;
        this.patterns = patterns;
    }

    public ConnectedBlockRuleSetAsset(@Nonnull ConnectedBlockRuleSetAsset other) {
        this.id = other.id;
        this.updateMode = other.updateMode;
        this.shapes = other.shapes;
        this.patterns = other.patterns;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ConnectedBlockRuleSetAsset", offset, (int) mem.byteSize());
        long needed = (long) offset + 14;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ConnectedBlockRuleSetAsset", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    public static String getId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 2, 14, "Id"), 4096000);
    }
    
    public static ConnectedBlockUpdateMode getUpdateMode(MemorySegment mem) {
        return getUpdateMode(mem, 0);
    }
    
    public static ConnectedBlockUpdateMode getUpdateMode(MemorySegment mem, int offset) {
        return ConnectedBlockUpdateMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static java.util.Map<String, ConnectedBlockShape> getShapes(MemorySegment mem) {
        return getShapes(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, ConnectedBlockShape> getShapes(MemorySegment mem, int offset) {
        if (!hasShapes(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 6, 14, "Shapes");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Shapes");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Shapes", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Shapes", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, ConnectedBlockShape> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = ConnectedBlockShape.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Shapes", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static ConnectedBlockPattern[] getPatterns(MemorySegment mem) {
        return getPatterns(mem, 0);
    }
    
    @Nullable
    public static ConnectedBlockPattern[] getPatterns(MemorySegment mem, int offset) {
        if (!hasPatterns(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 10, 14, "Patterns");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Patterns");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Patterns", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 14 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Patterns", (int) java.lang.Math.min(off + lenOffset + (long) len * 14, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ConnectedBlockPattern[len];
        for (var i = 0; i < len; i++) {
            data[i] = ConnectedBlockPattern.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasShapes(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasPatterns(MemorySegment mem, int offset) {
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
    
    public static ConnectedBlockRuleSetAsset toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ConnectedBlockRuleSetAsset toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ConnectedBlockRuleSetAsset and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ConnectedBlockRuleSetAsset toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 14;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0;
        requireSlot(mem, offset + 2, varPos, "Id");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        java.util.Map<String, ConnectedBlockShape> v2 = null;
        if (hasShapes(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "Shapes");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Shapes");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Shapes", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Shapes", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            v2 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = ConnectedBlockShape.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v2.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Shapes", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 6, -1, "Shapes");
        }
        
        ConnectedBlockPattern[] v3 = null;
        if (hasPatterns(mem, offset)) {
            requireSlot(mem, offset + 10, varPos, "Patterns");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Patterns");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Patterns", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 14 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Patterns", (int) java.lang.Math.min(off + lenOffset + (long) len * 14, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v3 = new ConnectedBlockPattern[len];
            for (var i = 0; i < len; i++) {
                v3[i] = ConnectedBlockPattern.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 10, -1, "Patterns");
        }
        var result = new ConnectedBlockRuleSetAsset(
            v0,
            ConnectedBlockUpdateMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v2,
            v3
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.shapes != null) nullBits |= 0x01;
        if (this.patterns != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.updateMode.getValue());
        var varOffset = offset + 14;
        mem.set(PacketIO.PROTO_INT, offset + 2, varOffset - offset - 14);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        if (this.shapes != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 14);
            if (this.shapes.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Shapes", shapes.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.shapes.size());
            for (var e : this.shapes.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                varOffset += e.getValue().serializeWithTypeId(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
        if (this.patterns != null) {
            mem.set(PacketIO.PROTO_INT, offset + 10, varOffset - offset - 14);
            if (patterns.length > 4096000) throw ProtocolException.arrayTooLong("Patterns", patterns.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.patterns.length);
            
            var patternsValueOffset = 0;
            for (var i = 0; i < this.patterns.length; i++) {
                patternsValueOffset += this.patterns[i].serialize(mem, varOffset + patternsValueOffset);
            }
            varOffset += patternsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 10, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 14;
        size += PacketIO.stringSize(id);
    if (shapes != null) {
        int shapesSize = 0;
for (var kvp : shapes.entrySet()) shapesSize += PacketIO.stringSize(kvp.getKey()) + kvp.getValue().computeSizeWithTypeId();
size += VarInt.size(shapes.size()) + shapesSize;
    }
    if (patterns != null) {
        int patternsSize = 0;
for (var elem : patterns) patternsSize += elem.computeSize();
size += VarInt.size(patterns.length) + patternsSize;
    }

        return size;
    }

    public ConnectedBlockRuleSetAsset clone() {
        ConnectedBlockRuleSetAsset copy = new ConnectedBlockRuleSetAsset();
        copy.id = this.id;
        copy.updateMode = this.updateMode;
        copy.shapes = this.shapes != null ? new java.util.HashMap<>(this.shapes) : null;
        copy.patterns = this.patterns != null ? java.util.Arrays.stream(this.patterns).map(e -> e.clone()).toArray(ConnectedBlockPattern[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ConnectedBlockRuleSetAsset other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.updateMode, other.updateMode) && java.util.Objects.equals(this.shapes, other.shapes) && java.util.Arrays.equals(this.patterns, other.patterns);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(id);
        result = 31 * result + java.util.Objects.hashCode(updateMode);
        result = 31 * result + java.util.Objects.hashCode(shapes);
        result = 31 * result + java.util.Arrays.hashCode(patterns);
        return result;
    }

}