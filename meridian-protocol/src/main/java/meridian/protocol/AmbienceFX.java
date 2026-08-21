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


public class AmbienceFX {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 22;
    public static final int VARIABLE_FIELD_COUNT = 6;
    public static final int VARIABLE_BLOCK_START = 46;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String id;
    @Nullable public AmbienceFXConditions conditions;
    @Nullable public AmbienceFXSound[] sounds;
    public int musicContainerIndex;
    @Nullable public AmbienceFXAmbientBed ambientBed;
    @Nullable public AmbienceFXSoundEffect soundEffect;
    public int priority;
    @Nullable public int[] blockedAmbienceFxIndices;
    public int audioCategoryIndex;
    @Nullable public AmbienceStateWrite[] setStates;

    public AmbienceFX() {
    }

    public AmbienceFX(@Nullable String id, @Nullable AmbienceFXConditions conditions, @Nullable AmbienceFXSound[] sounds, int musicContainerIndex, @Nullable AmbienceFXAmbientBed ambientBed, @Nullable AmbienceFXSoundEffect soundEffect, int priority, @Nullable int[] blockedAmbienceFxIndices, int audioCategoryIndex, @Nullable AmbienceStateWrite[] setStates) {
        this.id = id;
        this.conditions = conditions;
        this.sounds = sounds;
        this.musicContainerIndex = musicContainerIndex;
        this.ambientBed = ambientBed;
        this.soundEffect = soundEffect;
        this.priority = priority;
        this.blockedAmbienceFxIndices = blockedAmbienceFxIndices;
        this.audioCategoryIndex = audioCategoryIndex;
        this.setStates = setStates;
    }

    public AmbienceFX(@Nonnull AmbienceFX other) {
        this.id = other.id;
        this.conditions = other.conditions;
        this.sounds = other.sounds;
        this.musicContainerIndex = other.musicContainerIndex;
        this.ambientBed = other.ambientBed;
        this.soundEffect = other.soundEffect;
        this.priority = other.priority;
        this.blockedAmbienceFxIndices = other.blockedAmbienceFxIndices;
        this.audioCategoryIndex = other.audioCategoryIndex;
        this.setStates = other.setStates;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AmbienceFX", offset, (int) mem.byteSize());
        long needed = (long) offset + 46;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AmbienceFX", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 22, 46, "Id"), 4096000): null;
    }
    
    @Nullable
    public static AmbienceFXConditions getConditions(MemorySegment mem) {
        return getConditions(mem, 0);
    }
    
    @Nullable
    public static AmbienceFXConditions getConditions(MemorySegment mem, int offset) {
        return hasConditions(mem, offset) ? AmbienceFXConditions.toObject(mem, offset + getValidatedOffset(mem, offset, 26, 46, "Conditions")): null;
    }
    
    @Nullable
    public static AmbienceFXSound[] getSounds(MemorySegment mem) {
        return getSounds(mem, 0);
    }
    
    @Nullable
    public static AmbienceFXSound[] getSounds(MemorySegment mem, int offset) {
        if (!hasSounds(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 30, 46, "Sounds");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Sounds");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Sounds", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 33 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Sounds", (int) java.lang.Math.min(off + lenOffset + (long) len * 33, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new AmbienceFXSound[len];
        for (var i = 0; i < len; i++) {
            data[i] = AmbienceFXSound.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static int getMusicContainerIndex(MemorySegment mem) {
        return getMusicContainerIndex(mem, 0);
    }
    
    public static int getMusicContainerIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static AmbienceFXAmbientBed getAmbientBed(MemorySegment mem) {
        return getAmbientBed(mem, 0);
    }
    
    @Nullable
    public static AmbienceFXAmbientBed getAmbientBed(MemorySegment mem, int offset) {
        return hasAmbientBed(mem, offset) ? AmbienceFXAmbientBed.toObject(mem, offset + getValidatedOffset(mem, offset, 34, 46, "AmbientBed")): null;
    }
    
    @Nullable
    public static AmbienceFXSoundEffect getSoundEffect(MemorySegment mem) {
        return getSoundEffect(mem, 0);
    }
    
    @Nullable
    public static AmbienceFXSoundEffect getSoundEffect(MemorySegment mem, int offset) {
        return hasSoundEffect(mem, offset) ? AmbienceFXSoundEffect.toObject(mem, offset + 5): null;
    }
    
    public static int getPriority(MemorySegment mem) {
        return getPriority(mem, 0);
    }
    
    public static int getPriority(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 14);
    }
    
    @Nullable
    public static int[] getBlockedAmbienceFxIndices(MemorySegment mem) {
        return getBlockedAmbienceFxIndices(mem, 0);
    }
    
    @Nullable
    public static int[] getBlockedAmbienceFxIndices(MemorySegment mem, int offset) {
        if (!hasBlockedAmbienceFxIndices(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 38, 46, "BlockedAmbienceFxIndices");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("BlockedAmbienceFxIndices");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("BlockedAmbienceFxIndices", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockedAmbienceFxIndices", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    public static int getAudioCategoryIndex(MemorySegment mem) {
        return getAudioCategoryIndex(mem, 0);
    }
    
    public static int getAudioCategoryIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 18);
    }
    
    @Nullable
    public static AmbienceStateWrite[] getSetStates(MemorySegment mem) {
        return getSetStates(mem, 0);
    }
    
    @Nullable
    public static AmbienceStateWrite[] getSetStates(MemorySegment mem, int offset) {
        if (!hasSetStates(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 42, 46, "SetStates");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("SetStates");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("SetStates", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 9 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SetStates", (int) java.lang.Math.min(off + lenOffset + (long) len * 9, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new AmbienceStateWrite[len];
        for (var i = 0; i < len; i++) {
            data[i] = AmbienceStateWrite.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasSoundEffect(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasConditions(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasSounds(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasAmbientBed(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasBlockedAmbienceFxIndices(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasSetStates(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
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
    
    public static AmbienceFX toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AmbienceFX toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AmbienceFX and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AmbienceFX toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 46;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 22, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 22, -1, "Id");
        }
        
        AmbienceFXConditions v1 = null;
        if (hasConditions(mem, offset)) {
            requireSlot(mem, offset + 26, varPos, "Conditions");
            v1 = AmbienceFXConditions.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 26, -1, "Conditions");
        }
        
        AmbienceFXSound[] v2 = null;
        if (hasSounds(mem, offset)) {
            requireSlot(mem, offset + 30, varPos, "Sounds");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Sounds");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Sounds", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 33 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Sounds", (int) java.lang.Math.min(off + lenOffset + (long) len * 33, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new AmbienceFXSound[len];
            for (var i = 0; i < len; i++) {
                v2[i] = AmbienceFXSound.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 30, -1, "Sounds");
        }
        
        AmbienceFXAmbientBed v4 = null;
        if (hasAmbientBed(mem, offset)) {
            requireSlot(mem, offset + 34, varPos, "AmbientBed");
            v4 = AmbienceFXAmbientBed.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 34, -1, "AmbientBed");
        }
        
        int[] v7 = null;
        if (hasBlockedAmbienceFxIndices(mem, offset)) {
            requireSlot(mem, offset + 38, varPos, "BlockedAmbienceFxIndices");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("BlockedAmbienceFxIndices");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("BlockedAmbienceFxIndices", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockedAmbienceFxIndices", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v7 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v7, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 38, -1, "BlockedAmbienceFxIndices");
        }
        
        AmbienceStateWrite[] v9 = null;
        if (hasSetStates(mem, offset)) {
            requireSlot(mem, offset + 42, varPos, "SetStates");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("SetStates");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("SetStates", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 9 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SetStates", (int) java.lang.Math.min(off + lenOffset + (long) len * 9, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v9 = new AmbienceStateWrite[len];
            for (var i = 0; i < len; i++) {
                v9[i] = AmbienceStateWrite.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 42, -1, "SetStates");
        }
        var result = new AmbienceFX(
            v0,
            v1,
            v2,
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v4,
            hasSoundEffect(mem, offset) ? AmbienceFXSoundEffect.toObject(mem, offset + 5) : null,
            mem.get(PacketIO.PROTO_INT, offset + 14),
            v7,
            mem.get(PacketIO.PROTO_INT, offset + 18),
            v9
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.soundEffect != null) nullBits |= 0x01;
        if (this.id != null) nullBits |= 0x02;
        if (this.conditions != null) nullBits |= 0x04;
        if (this.sounds != null) nullBits |= 0x08;
        if (this.ambientBed != null) nullBits |= 0x10;
        if (this.blockedAmbienceFxIndices != null) nullBits |= 0x20;
        if (this.setStates != null) nullBits |= 0x40;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.musicContainerIndex);
        if (this.soundEffect != null) {
            this.soundEffect.serialize(mem, offset + 5);
        } else {
            mem.asSlice(offset + 5, 9).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_INT, offset + 14, this.priority);
        mem.set(PacketIO.PROTO_INT, offset + 18, this.audioCategoryIndex);
        var varOffset = offset + 46;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 22, varOffset - offset - 46);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 22, -1);
        }
        if (this.conditions != null) {
            mem.set(PacketIO.PROTO_INT, offset + 26, varOffset - offset - 46);
            varOffset += this.conditions.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 26, -1);
        }
        if (this.sounds != null) {
            mem.set(PacketIO.PROTO_INT, offset + 30, varOffset - offset - 46);
            if (sounds.length > 4096000) throw ProtocolException.arrayTooLong("Sounds", sounds.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.sounds.length);
            
            var soundsValueOffset = 0;
            for (var i = 0; i < this.sounds.length; i++) {
                soundsValueOffset += this.sounds[i].serialize(mem, varOffset + soundsValueOffset);
            }
            varOffset += soundsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 30, -1);
        }
        if (this.ambientBed != null) {
            mem.set(PacketIO.PROTO_INT, offset + 34, varOffset - offset - 46);
            varOffset += this.ambientBed.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 34, -1);
        }
        if (this.blockedAmbienceFxIndices != null) {
            mem.set(PacketIO.PROTO_INT, offset + 38, varOffset - offset - 46);
            if (blockedAmbienceFxIndices.length > 4096000) throw ProtocolException.arrayTooLong("BlockedAmbienceFxIndices", blockedAmbienceFxIndices.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.blockedAmbienceFxIndices.length);
            
            MemorySegment.copy(this.blockedAmbienceFxIndices, 0, mem, PacketIO.PROTO_INT, varOffset, this.blockedAmbienceFxIndices.length);
            varOffset += this.blockedAmbienceFxIndices.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 38, -1);
        }
        if (this.setStates != null) {
            mem.set(PacketIO.PROTO_INT, offset + 42, varOffset - offset - 46);
            if (setStates.length > 4096000) throw ProtocolException.arrayTooLong("SetStates", setStates.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.setStates.length);
            
            var setStatesValueOffset = 0;
            for (var i = 0; i < this.setStates.length; i++) {
                setStatesValueOffset += this.setStates[i].serialize(mem, varOffset + setStatesValueOffset);
            }
            varOffset += setStatesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 42, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 46;
        if (id != null) size += PacketIO.stringSize(id);
    if (conditions != null) size += conditions.computeSize();
    if (sounds != null) {
        int soundsSize = 0;
for (var elem : sounds) soundsSize += elem.computeSize();
size += VarInt.size(sounds.length) + soundsSize;
    }
    if (ambientBed != null) size += ambientBed.computeSize();
    if (blockedAmbienceFxIndices != null) size += VarInt.size(blockedAmbienceFxIndices.length) + blockedAmbienceFxIndices.length * 4;
    if (setStates != null) {
        int setStatesSize = 0;
for (var elem : setStates) setStatesSize += elem.computeSize();
size += VarInt.size(setStates.length) + setStatesSize;
    }

        return size;
    }

    public AmbienceFX clone() {
        AmbienceFX copy = new AmbienceFX();
        copy.id = this.id;
        copy.conditions = this.conditions != null ? this.conditions.clone() : null;
        copy.sounds = this.sounds != null ? java.util.Arrays.stream(this.sounds).map(e -> e.clone()).toArray(AmbienceFXSound[]::new) : null;
        copy.musicContainerIndex = this.musicContainerIndex;
        copy.ambientBed = this.ambientBed != null ? this.ambientBed.clone() : null;
        copy.soundEffect = this.soundEffect != null ? this.soundEffect.clone() : null;
        copy.priority = this.priority;
        copy.blockedAmbienceFxIndices = this.blockedAmbienceFxIndices != null ? java.util.Arrays.copyOf(this.blockedAmbienceFxIndices, this.blockedAmbienceFxIndices.length) : null;
        copy.audioCategoryIndex = this.audioCategoryIndex;
        copy.setStates = this.setStates != null ? java.util.Arrays.stream(this.setStates).map(e -> e.clone()).toArray(AmbienceStateWrite[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AmbienceFX other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.conditions, other.conditions) && java.util.Arrays.equals(this.sounds, other.sounds) && this.musicContainerIndex == other.musicContainerIndex && java.util.Objects.equals(this.ambientBed, other.ambientBed) && java.util.Objects.equals(this.soundEffect, other.soundEffect) && this.priority == other.priority && java.util.Arrays.equals(this.blockedAmbienceFxIndices, other.blockedAmbienceFxIndices) && this.audioCategoryIndex == other.audioCategoryIndex && java.util.Arrays.equals(this.setStates, other.setStates);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(id);
        result = 31 * result + java.util.Objects.hashCode(conditions);
        result = 31 * result + java.util.Arrays.hashCode(sounds);
        result = 31 * result + Integer.hashCode(musicContainerIndex);
        result = 31 * result + java.util.Objects.hashCode(ambientBed);
        result = 31 * result + java.util.Objects.hashCode(soundEffect);
        result = 31 * result + Integer.hashCode(priority);
        result = 31 * result + java.util.Arrays.hashCode(blockedAmbienceFxIndices);
        result = 31 * result + Integer.hashCode(audioCategoryIndex);
        result = 31 * result + java.util.Arrays.hashCode(setStates);
        return result;
    }

}