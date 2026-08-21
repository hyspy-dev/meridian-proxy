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

public class PatternedConnectedBlockRuleSet extends ConnectedBlockRuleSet {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public String ruleSetId = "";
    @Nullable public java.util.Map<String, Integer> shapeNameToBlockId;

    public PatternedConnectedBlockRuleSet() {
    }

    public PatternedConnectedBlockRuleSet(@Nonnull String ruleSetId, @Nullable java.util.Map<String, Integer> shapeNameToBlockId) {
        this.ruleSetId = ruleSetId;
        this.shapeNameToBlockId = shapeNameToBlockId;
    }

    public PatternedConnectedBlockRuleSet(@Nonnull PatternedConnectedBlockRuleSet other) {
        this.ruleSetId = other.ruleSetId;
        this.shapeNameToBlockId = other.shapeNameToBlockId;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PatternedConnectedBlockRuleSet", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PatternedConnectedBlockRuleSet", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getRuleSetId(MemorySegment mem) {
        return getRuleSetId(mem, 0);
    }
    
    public static String getRuleSetId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("RuleSetId", mem, offset + getValidatedOffset(mem, offset, 1, 9, "RuleSetId"), 4096000);
    }
    
    @Nullable
    public static java.util.Map<String, Integer> getShapeNameToBlockId(MemorySegment mem) {
        return getShapeNameToBlockId(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, Integer> getShapeNameToBlockId(MemorySegment mem, int offset) {
        if (!hasShapeNameToBlockId(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 5, 9, "ShapeNameToBlockId");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ShapeNameToBlockId");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ShapeNameToBlockId", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ShapeNameToBlockId", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, Integer> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("ShapeNameToBlockId", key);
            }
        }
        return data;
    }
    
    public static boolean hasShapeNameToBlockId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
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
    
    public static PatternedConnectedBlockRuleSet toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PatternedConnectedBlockRuleSet toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PatternedConnectedBlockRuleSet and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PatternedConnectedBlockRuleSet toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        String v0;
        requireSlot(mem, offset + 1, varPos, "RuleSetId");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("RuleSetId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        java.util.Map<String, Integer> v1 = null;
        if (hasShapeNameToBlockId(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "ShapeNameToBlockId");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ShapeNameToBlockId");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ShapeNameToBlockId", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ShapeNameToBlockId", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v1 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                if (v1.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("ShapeNameToBlockId", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "ShapeNameToBlockId");
        }
        var result = new PatternedConnectedBlockRuleSet(
            v0,
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.shapeNameToBlockId != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 9;
        mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 9);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.ruleSetId, 4096000);
        if (this.shapeNameToBlockId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 9);
            if (this.shapeNameToBlockId.size() > 4096000) throw ProtocolException.dictionaryTooLarge("ShapeNameToBlockId", shapeNameToBlockId.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.shapeNameToBlockId.size());
            for (var e : this.shapeNameToBlockId.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                mem.set(PacketIO.PROTO_INT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 9;
        size += PacketIO.stringSize(ruleSetId);
    if (shapeNameToBlockId != null) {
        int shapeNameToBlockIdSize = 0;
for (var kvp : shapeNameToBlockId.entrySet()) shapeNameToBlockIdSize += PacketIO.stringSize(kvp.getKey()) + 4;
size += VarInt.size(shapeNameToBlockId.size()) + shapeNameToBlockIdSize;
    }

        return size;
    }

    public PatternedConnectedBlockRuleSet clone() {
        PatternedConnectedBlockRuleSet copy = new PatternedConnectedBlockRuleSet();
        copy.ruleSetId = this.ruleSetId;
        copy.shapeNameToBlockId = this.shapeNameToBlockId != null ? new java.util.HashMap<>(this.shapeNameToBlockId) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PatternedConnectedBlockRuleSet other)) return false;
        return java.util.Objects.equals(this.ruleSetId, other.ruleSetId) && java.util.Objects.equals(this.shapeNameToBlockId, other.shapeNameToBlockId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(ruleSetId, shapeNameToBlockId);
    }

}