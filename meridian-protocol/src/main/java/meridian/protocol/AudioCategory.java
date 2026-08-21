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


public class AudioCategory {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 13;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 25;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String id;
    public float volume;
    public int parentAudioCategoryIndex;
    @Nullable public StateBinding[] stateBindings;
    @Nullable public AudioCategoryDuckingRule[] duckingRules;
    public float maxDuckingDb;

    public AudioCategory() {
    }

    public AudioCategory(@Nullable String id, float volume, int parentAudioCategoryIndex, @Nullable StateBinding[] stateBindings, @Nullable AudioCategoryDuckingRule[] duckingRules, float maxDuckingDb) {
        this.id = id;
        this.volume = volume;
        this.parentAudioCategoryIndex = parentAudioCategoryIndex;
        this.stateBindings = stateBindings;
        this.duckingRules = duckingRules;
        this.maxDuckingDb = maxDuckingDb;
    }

    public AudioCategory(@Nonnull AudioCategory other) {
        this.id = other.id;
        this.volume = other.volume;
        this.parentAudioCategoryIndex = other.parentAudioCategoryIndex;
        this.stateBindings = other.stateBindings;
        this.duckingRules = other.duckingRules;
        this.maxDuckingDb = other.maxDuckingDb;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AudioCategory", offset, (int) mem.byteSize());
        long needed = (long) offset + 25;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AudioCategory", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 13, 25, "Id"), 4096000): null;
    }
    
    public static float getVolume(MemorySegment mem) {
        return getVolume(mem, 0);
    }
    
    public static float getVolume(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Volume");
    }
    
    public static int getParentAudioCategoryIndex(MemorySegment mem) {
        return getParentAudioCategoryIndex(mem, 0);
    }
    
    public static int getParentAudioCategoryIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    @Nullable
    public static StateBinding[] getStateBindings(MemorySegment mem) {
        return getStateBindings(mem, 0);
    }
    
    @Nullable
    public static StateBinding[] getStateBindings(MemorySegment mem, int offset) {
        if (!hasStateBindings(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 17, 25, "StateBindings");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("StateBindings");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("StateBindings", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("StateBindings", (int) java.lang.Math.min(off + lenOffset + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new StateBinding[len];
        for (var i = 0; i < len; i++) {
            data[i] = StateBinding.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static AudioCategoryDuckingRule[] getDuckingRules(MemorySegment mem) {
        return getDuckingRules(mem, 0);
    }
    
    @Nullable
    public static AudioCategoryDuckingRule[] getDuckingRules(MemorySegment mem, int offset) {
        if (!hasDuckingRules(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 21, 25, "DuckingRules");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("DuckingRules");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("DuckingRules", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 24 > mem.byteSize()) throw ProtocolException.bufferTooSmall("DuckingRules", (int) java.lang.Math.min(off + lenOffset + (long) len * 24, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new AudioCategoryDuckingRule[len];
        for (var i = 0; i < len; i++) {
            data[i] = AudioCategoryDuckingRule.toObject(mem, off + i * 24);
        }
        return data;
    }
    
    public static float getMaxDuckingDb(MemorySegment mem) {
        return getMaxDuckingDb(mem, 0);
    }
    
    public static float getMaxDuckingDb(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "MaxDuckingDb");
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasStateBindings(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasDuckingRules(MemorySegment mem, int offset) {
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
    
    public static AudioCategory toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AudioCategory toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AudioCategory and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AudioCategory toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 25;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 13, -1, "Id");
        }
        
        StateBinding[] v3 = null;
        if (hasStateBindings(mem, offset)) {
            requireSlot(mem, offset + 17, varPos, "StateBindings");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("StateBindings");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("StateBindings", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("StateBindings", (int) java.lang.Math.min(off + lenOffset + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v3 = new StateBinding[len];
            for (var i = 0; i < len; i++) {
                v3[i] = StateBinding.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 17, -1, "StateBindings");
        }
        
        AudioCategoryDuckingRule[] v4 = null;
        if (hasDuckingRules(mem, offset)) {
            requireSlot(mem, offset + 21, varPos, "DuckingRules");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("DuckingRules");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("DuckingRules", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 24 > mem.byteSize()) throw ProtocolException.bufferTooSmall("DuckingRules", (int) java.lang.Math.min(off + lenOffset + (long) len * 24, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v4 = new AudioCategoryDuckingRule[len];
            for (var i = 0; i < len; i++) {
                v4[i] = AudioCategoryDuckingRule.toObject(mem, off + i * 24);
            }
            varPos = off + len * 24 - varBase;
        } else {
            requireSlot(mem, offset + 21, -1, "DuckingRules");
        }
        var result = new AudioCategory(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Volume"),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            v3,
            v4,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "MaxDuckingDb")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        if (this.stateBindings != null) nullBits |= 0x02;
        if (this.duckingRules != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.volume, "Volume"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.volume);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.parentAudioCategoryIndex);
        PacketIO.requireFinite(this.maxDuckingDb, "MaxDuckingDb"); mem.set(PacketIO.PROTO_FLOAT, offset + 9, this.maxDuckingDb);
        var varOffset = offset + 25;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 25);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
        if (this.stateBindings != null) {
            mem.set(PacketIO.PROTO_INT, offset + 17, varOffset - offset - 25);
            if (stateBindings.length > 4096000) throw ProtocolException.arrayTooLong("StateBindings", stateBindings.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.stateBindings.length);
            
            var stateBindingsValueOffset = 0;
            for (var i = 0; i < this.stateBindings.length; i++) {
                stateBindingsValueOffset += this.stateBindings[i].serialize(mem, varOffset + stateBindingsValueOffset);
            }
            varOffset += stateBindingsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 17, -1);
        }
        if (this.duckingRules != null) {
            mem.set(PacketIO.PROTO_INT, offset + 21, varOffset - offset - 25);
            if (duckingRules.length > 4096000) throw ProtocolException.arrayTooLong("DuckingRules", duckingRules.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.duckingRules.length);
            
            var duckingRulesValueOffset = 0;
            for (var i = 0; i < this.duckingRules.length; i++) {
                duckingRulesValueOffset += this.duckingRules[i].serialize(mem, varOffset + duckingRulesValueOffset);
            }
            varOffset += duckingRulesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 21, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 25;
        if (id != null) size += PacketIO.stringSize(id);
    if (stateBindings != null) {
        int stateBindingsSize = 0;
for (var elem : stateBindings) stateBindingsSize += elem.computeSize();
size += VarInt.size(stateBindings.length) + stateBindingsSize;
    }
    if (duckingRules != null) size += VarInt.size(duckingRules.length) + duckingRules.length * 24;

        return size;
    }

    public AudioCategory clone() {
        AudioCategory copy = new AudioCategory();
        copy.id = this.id;
        copy.volume = this.volume;
        copy.parentAudioCategoryIndex = this.parentAudioCategoryIndex;
        copy.stateBindings = this.stateBindings != null ? java.util.Arrays.stream(this.stateBindings).map(e -> e.clone()).toArray(StateBinding[]::new) : null;
        copy.duckingRules = this.duckingRules != null ? java.util.Arrays.stream(this.duckingRules).map(e -> e.clone()).toArray(AudioCategoryDuckingRule[]::new) : null;
        copy.maxDuckingDb = this.maxDuckingDb;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AudioCategory other)) return false;
        return java.util.Objects.equals(this.id, other.id) && this.volume == other.volume && this.parentAudioCategoryIndex == other.parentAudioCategoryIndex && java.util.Arrays.equals(this.stateBindings, other.stateBindings) && java.util.Arrays.equals(this.duckingRules, other.duckingRules) && this.maxDuckingDb == other.maxDuckingDb;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(id);
        result = 31 * result + Float.hashCode(volume);
        result = 31 * result + Integer.hashCode(parentAudioCategoryIndex);
        result = 31 * result + java.util.Arrays.hashCode(stateBindings);
        result = 31 * result + java.util.Arrays.hashCode(duckingRules);
        result = 31 * result + Float.hashCode(maxDuckingDb);
        return result;
    }

}