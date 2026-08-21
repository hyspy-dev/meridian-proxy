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


public class Stinger {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 19;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 31;
    public static final int MAX_SIZE = 131072046;

    @Nullable public String id;
    public int musicContainerIndex;
    public int maxInstance;
    public short priority;
    @Nullable public String exclusionGroup;
    public int audioCategoryIndex;
    public float volume;
    @Nullable public AudioCategoryDuckingRule[] duckingRules;

    public Stinger() {
    }

    public Stinger(@Nullable String id, int musicContainerIndex, int maxInstance, short priority, @Nullable String exclusionGroup, int audioCategoryIndex, float volume, @Nullable AudioCategoryDuckingRule[] duckingRules) {
        this.id = id;
        this.musicContainerIndex = musicContainerIndex;
        this.maxInstance = maxInstance;
        this.priority = priority;
        this.exclusionGroup = exclusionGroup;
        this.audioCategoryIndex = audioCategoryIndex;
        this.volume = volume;
        this.duckingRules = duckingRules;
    }

    public Stinger(@Nonnull Stinger other) {
        this.id = other.id;
        this.musicContainerIndex = other.musicContainerIndex;
        this.maxInstance = other.maxInstance;
        this.priority = other.priority;
        this.exclusionGroup = other.exclusionGroup;
        this.audioCategoryIndex = other.audioCategoryIndex;
        this.volume = other.volume;
        this.duckingRules = other.duckingRules;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Stinger", offset, (int) mem.byteSize());
        long needed = (long) offset + 31;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Stinger", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 19, 31, "Id"), 4096000): null;
    }
    
    public static int getMusicContainerIndex(MemorySegment mem) {
        return getMusicContainerIndex(mem, 0);
    }
    
    public static int getMusicContainerIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getMaxInstance(MemorySegment mem) {
        return getMaxInstance(mem, 0);
    }
    
    public static int getMaxInstance(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static short getPriority(MemorySegment mem) {
        return getPriority(mem, 0);
    }
    
    public static short getPriority(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_SHORT, offset + 9);
    }
    
    @Nullable
    public static String getExclusionGroup(MemorySegment mem) {
        return getExclusionGroup(mem, 0);
    }
    
    @Nullable
    public static String getExclusionGroup(MemorySegment mem, int offset) {
        return hasExclusionGroup(mem, offset) ? PacketIO.readVarString("ExclusionGroup", mem, offset + getValidatedOffset(mem, offset, 23, 31, "ExclusionGroup"), 4096000): null;
    }
    
    public static int getAudioCategoryIndex(MemorySegment mem) {
        return getAudioCategoryIndex(mem, 0);
    }
    
    public static int getAudioCategoryIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 11);
    }
    
    public static float getVolume(MemorySegment mem) {
        return getVolume(mem, 0);
    }
    
    public static float getVolume(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 15), "Volume");
    }
    
    @Nullable
    public static AudioCategoryDuckingRule[] getDuckingRules(MemorySegment mem) {
        return getDuckingRules(mem, 0);
    }
    
    @Nullable
    public static AudioCategoryDuckingRule[] getDuckingRules(MemorySegment mem, int offset) {
        if (!hasDuckingRules(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 27, 31, "DuckingRules");
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
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasExclusionGroup(MemorySegment mem, int offset) {
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
    
    public static Stinger toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Stinger toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Stinger and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Stinger toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 31;
        var varPos = 0;
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 19, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 19, -1, "Id");
        }
        
        String v4 = null;
        if (hasExclusionGroup(mem, offset)) {
            requireSlot(mem, offset + 23, varPos, "ExclusionGroup");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v4 = PacketIO.readVarString("ExclusionGroup", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 23, -1, "ExclusionGroup");
        }
        
        AudioCategoryDuckingRule[] v7 = null;
        if (hasDuckingRules(mem, offset)) {
            requireSlot(mem, offset + 27, varPos, "DuckingRules");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("DuckingRules");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("DuckingRules", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 24 > mem.byteSize()) throw ProtocolException.bufferTooSmall("DuckingRules", (int) java.lang.Math.min(off + lenOffset + (long) len * 24, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v7 = new AudioCategoryDuckingRule[len];
            for (var i = 0; i < len; i++) {
                v7[i] = AudioCategoryDuckingRule.toObject(mem, off + i * 24);
            }
            varPos = off + len * 24 - varBase;
        } else {
            requireSlot(mem, offset + 27, -1, "DuckingRules");
        }
        var result = new Stinger(
            v0,
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            mem.get(PacketIO.PROTO_SHORT, offset + 9),
            v4,
            mem.get(PacketIO.PROTO_INT, offset + 11),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 15), "Volume"),
            v7
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        if (this.exclusionGroup != null) nullBits |= 0x02;
        if (this.duckingRules != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.musicContainerIndex);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.maxInstance);
        mem.set(PacketIO.PROTO_SHORT, offset + 9, this.priority);
        mem.set(PacketIO.PROTO_INT, offset + 11, this.audioCategoryIndex);
        PacketIO.requireFinite(this.volume, "Volume"); mem.set(PacketIO.PROTO_FLOAT, offset + 15, this.volume);
        var varOffset = offset + 31;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 19, varOffset - offset - 31);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 19, -1);
        }
        if (this.exclusionGroup != null) {
            mem.set(PacketIO.PROTO_INT, offset + 23, varOffset - offset - 31);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.exclusionGroup, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 23, -1);
        }
        if (this.duckingRules != null) {
            mem.set(PacketIO.PROTO_INT, offset + 27, varOffset - offset - 31);
            if (duckingRules.length > 4096000) throw ProtocolException.arrayTooLong("DuckingRules", duckingRules.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.duckingRules.length);
            
            var duckingRulesValueOffset = 0;
            for (var i = 0; i < this.duckingRules.length; i++) {
                duckingRulesValueOffset += this.duckingRules[i].serialize(mem, varOffset + duckingRulesValueOffset);
            }
            varOffset += duckingRulesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 27, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 31;
        if (id != null) size += PacketIO.stringSize(id);
    if (exclusionGroup != null) size += PacketIO.stringSize(exclusionGroup);
    if (duckingRules != null) size += VarInt.size(duckingRules.length) + duckingRules.length * 24;

        return size;
    }

    public Stinger clone() {
        Stinger copy = new Stinger();
        copy.id = this.id;
        copy.musicContainerIndex = this.musicContainerIndex;
        copy.maxInstance = this.maxInstance;
        copy.priority = this.priority;
        copy.exclusionGroup = this.exclusionGroup;
        copy.audioCategoryIndex = this.audioCategoryIndex;
        copy.volume = this.volume;
        copy.duckingRules = this.duckingRules != null ? java.util.Arrays.stream(this.duckingRules).map(e -> e.clone()).toArray(AudioCategoryDuckingRule[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Stinger other)) return false;
        return java.util.Objects.equals(this.id, other.id) && this.musicContainerIndex == other.musicContainerIndex && this.maxInstance == other.maxInstance && this.priority == other.priority && java.util.Objects.equals(this.exclusionGroup, other.exclusionGroup) && this.audioCategoryIndex == other.audioCategoryIndex && this.volume == other.volume && java.util.Arrays.equals(this.duckingRules, other.duckingRules);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(id);
        result = 31 * result + Integer.hashCode(musicContainerIndex);
        result = 31 * result + Integer.hashCode(maxInstance);
        result = 31 * result + Short.hashCode(priority);
        result = 31 * result + java.util.Objects.hashCode(exclusionGroup);
        result = 31 * result + Integer.hashCode(audioCategoryIndex);
        result = 31 * result + Float.hashCode(volume);
        result = 31 * result + java.util.Arrays.hashCode(duckingRules);
        return result;
    }

}