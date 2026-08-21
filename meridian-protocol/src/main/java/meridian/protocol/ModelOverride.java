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

public class ModelOverride {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String model;
    @Nullable public String texture;
    @Nullable public java.util.Map<String, AnimationSet> animationSets;

    public ModelOverride() {
    }

    public ModelOverride(@Nullable String model, @Nullable String texture, @Nullable java.util.Map<String, AnimationSet> animationSets) {
        this.model = model;
        this.texture = texture;
        this.animationSets = animationSets;
    }

    public ModelOverride(@Nonnull ModelOverride other) {
        this.model = other.model;
        this.texture = other.texture;
        this.animationSets = other.animationSets;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ModelOverride", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ModelOverride", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getModel(MemorySegment mem) {
        return getModel(mem, 0);
    }
    
    @Nullable
    public static String getModel(MemorySegment mem, int offset) {
        return hasModel(mem, offset) ? PacketIO.readVarString("Model", mem, offset + getValidatedOffset(mem, offset, 1, 13, "Model"), 4096000): null;
    }
    
    @Nullable
    public static String getTexture(MemorySegment mem) {
        return getTexture(mem, 0);
    }
    
    @Nullable
    public static String getTexture(MemorySegment mem, int offset) {
        return hasTexture(mem, offset) ? PacketIO.readVarString("Texture", mem, offset + getValidatedOffset(mem, offset, 5, 13, "Texture"), 4096000): null;
    }
    
    @Nullable
    public static java.util.Map<String, AnimationSet> getAnimationSets(MemorySegment mem) {
        return getAnimationSets(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, AnimationSet> getAnimationSets(MemorySegment mem, int offset) {
        if (!hasAnimationSets(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 9, 13, "AnimationSets");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("AnimationSets");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("AnimationSets", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 18 > mem.byteSize()) throw ProtocolException.bufferTooSmall("AnimationSets", (int) java.lang.Math.min(off + (long) len * 18, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, AnimationSet> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = AnimationSet.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("AnimationSets", key);
            }
        }
        return data;
    }
    
    public static boolean hasModel(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasTexture(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasAnimationSets(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
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
    
    public static ModelOverride toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ModelOverride toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ModelOverride and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ModelOverride toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 13;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasModel(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "Model");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Model", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 1, -1, "Model");
        }
        
        String v1 = null;
        if (hasTexture(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Texture");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Texture", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 5, -1, "Texture");
        }
        
        java.util.Map<String, AnimationSet> v2 = null;
        if (hasAnimationSets(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "AnimationSets");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("AnimationSets");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("AnimationSets", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 18 > mem.byteSize()) throw ProtocolException.bufferTooSmall("AnimationSets", (int) java.lang.Math.min(off + (long) len * 18, Integer.MAX_VALUE), (int) mem.byteSize());
            v2 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = AnimationSet.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v2.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("AnimationSets", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 9, -1, "AnimationSets");
        }
        var result = new ModelOverride(
            v0,
            v1,
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.model != null) nullBits |= 0x01;
        if (this.texture != null) nullBits |= 0x02;
        if (this.animationSets != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 13;
        if (this.model != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 13);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.model, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.texture != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 13);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.texture, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.animationSets != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 13);
            if (this.animationSets.size() > 4096000) throw ProtocolException.dictionaryTooLarge("AnimationSets", animationSets.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.animationSets.size());
            for (var e : this.animationSets.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 13;
        if (model != null) size += PacketIO.stringSize(model);
    if (texture != null) size += PacketIO.stringSize(texture);
    if (animationSets != null) {
        int animationSetsSize = 0;
for (var kvp : animationSets.entrySet()) animationSetsSize += PacketIO.stringSize(kvp.getKey()) + kvp.getValue().computeSize();
size += VarInt.size(animationSets.size()) + animationSetsSize;
    }

        return size;
    }

    public ModelOverride clone() {
        ModelOverride copy = new ModelOverride();
        copy.model = this.model;
        copy.texture = this.texture;
        if (this.animationSets != null) {
            java.util.Map<String, AnimationSet> m = new java.util.HashMap<>();
            for (var e : this.animationSets.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.animationSets = m;
        }
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ModelOverride other)) return false;
        return java.util.Objects.equals(this.model, other.model) && java.util.Objects.equals(this.texture, other.texture) && java.util.Objects.equals(this.animationSets, other.animationSets);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(model, texture, animationSets);
    }

}