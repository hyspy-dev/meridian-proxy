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

public class ItemSoundSet {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 36864019;

    @Nullable public String id;
    @Nullable public java.util.Map<ItemSoundEvent, Integer> soundEventIndices;

    public ItemSoundSet() {
    }

    public ItemSoundSet(@Nullable String id, @Nullable java.util.Map<ItemSoundEvent, Integer> soundEventIndices) {
        this.id = id;
        this.soundEventIndices = soundEventIndices;
    }

    public ItemSoundSet(@Nonnull ItemSoundSet other) {
        this.id = other.id;
        this.soundEventIndices = other.soundEventIndices;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemSoundSet", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemSoundSet", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 1, 9, "Id"), 4096000): null;
    }
    
    @Nullable
    public static java.util.Map<ItemSoundEvent, Integer> getSoundEventIndices(MemorySegment mem) {
        return getSoundEventIndices(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<ItemSoundEvent, Integer> getSoundEventIndices(MemorySegment mem, int offset) {
        if (!hasSoundEventIndices(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 5, 9, "SoundEventIndices");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("SoundEventIndices");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("SoundEventIndices", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SoundEventIndices", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<ItemSoundEvent, Integer> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = ItemSoundEvent.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                off += 1;
            var value = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("SoundEventIndices", key);
            }
        }
        return data;
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasSoundEventIndices(MemorySegment mem, int offset) {
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
    
    public static ItemSoundSet toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemSoundSet toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemSoundSet and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemSoundSet toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 1, -1, "Id");
        }
        
        java.util.Map<ItemSoundEvent, Integer> v1 = null;
        if (hasSoundEventIndices(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "SoundEventIndices");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("SoundEventIndices");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("SoundEventIndices", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SoundEventIndices", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v1 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = ItemSoundEvent.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                    off += 1;
                var value = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                if (v1.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("SoundEventIndices", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "SoundEventIndices");
        }
        var result = new ItemSoundSet(
            v0,
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        if (this.soundEventIndices != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 9;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 9);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.soundEventIndices != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 9);
            if (this.soundEventIndices.size() > 4096000) throw ProtocolException.dictionaryTooLarge("SoundEventIndices", soundEventIndices.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.soundEventIndices.size());
            for (var e : this.soundEventIndices.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                mem.set(PacketIO.PROTO_INT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (id != null) size += PacketIO.stringSize(id);
    if (soundEventIndices != null) size += VarInt.size(soundEventIndices.size()) + soundEventIndices.size() * (1 + 4);

        return size;
    }

    public ItemSoundSet clone() {
        ItemSoundSet copy = new ItemSoundSet();
        copy.id = this.id;
        copy.soundEventIndices = this.soundEventIndices != null ? new java.util.HashMap<>(this.soundEventIndices) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemSoundSet other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.soundEventIndices, other.soundEventIndices);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, soundEventIndices);
    }

}