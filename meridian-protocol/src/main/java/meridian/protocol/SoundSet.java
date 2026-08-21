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

public class SoundSet {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 10;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String id;
    @Nullable public java.util.Map<String, Integer> sounds;
    @Nonnull public SoundCategory category = SoundCategory.Music;

    public SoundSet() {
    }

    public SoundSet(@Nullable String id, @Nullable java.util.Map<String, Integer> sounds, @Nonnull SoundCategory category) {
        this.id = id;
        this.sounds = sounds;
        this.category = category;
    }

    public SoundSet(@Nonnull SoundSet other) {
        this.id = other.id;
        this.sounds = other.sounds;
        this.category = other.category;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SoundSet", offset, (int) mem.byteSize());
        long needed = (long) offset + 10;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SoundSet", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 2, 10, "Id"), 4096000): null;
    }
    
    @Nullable
    public static java.util.Map<String, Integer> getSounds(MemorySegment mem) {
        return getSounds(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, Integer> getSounds(MemorySegment mem, int offset) {
        if (!hasSounds(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 6, 10, "Sounds");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Sounds");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Sounds", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Sounds", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, Integer> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Sounds", key);
            }
        }
        return data;
    }
    
    public static SoundCategory getCategory(MemorySegment mem) {
        return getCategory(mem, 0);
    }
    
    public static SoundCategory getCategory(MemorySegment mem, int offset) {
        return SoundCategory.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasSounds(MemorySegment mem, int offset) {
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
    
    public static SoundSet toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SoundSet toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SoundSet and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SoundSet toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 10;
        var varPos = 0;
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 2, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 2, -1, "Id");
        }
        
        java.util.Map<String, Integer> v1 = null;
        if (hasSounds(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "Sounds");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Sounds");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Sounds", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Sounds", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v1 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                if (v1.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Sounds", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 6, -1, "Sounds");
        }
        var result = new SoundSet(
            v0,
            v1,
            SoundCategory.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1))
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        if (this.sounds != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.category.getValue());
        var varOffset = offset + 10;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 2, varOffset - offset - 10);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 2, -1);
        }
        if (this.sounds != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 10);
            if (this.sounds.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Sounds", sounds.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.sounds.size());
            for (var e : this.sounds.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                mem.set(PacketIO.PROTO_INT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 10;
        if (id != null) size += PacketIO.stringSize(id);
    if (sounds != null) {
        int soundsSize = 0;
for (var kvp : sounds.entrySet()) soundsSize += PacketIO.stringSize(kvp.getKey()) + 4;
size += VarInt.size(sounds.size()) + soundsSize;
    }

        return size;
    }

    public SoundSet clone() {
        SoundSet copy = new SoundSet();
        copy.id = this.id;
        copy.sounds = this.sounds != null ? new java.util.HashMap<>(this.sounds) : null;
        copy.category = this.category;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SoundSet other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.sounds, other.sounds) && java.util.Objects.equals(this.category, other.category);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, sounds, category);
    }

}