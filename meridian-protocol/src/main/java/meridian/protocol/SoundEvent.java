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


public class SoundEvent {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 31;
    public static final int VARIABLE_FIELD_COUNT = 4;
    public static final int VARIABLE_BLOCK_START = 47;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String id;
    public float volume;
    public float pitch;
    public int maxInstance;
    public boolean preventSoundInterruption;
    public float startAttenuationDistance;
    public float maxDistance;
    public float spatialBlend;
    @Nullable public SoundEventLayer[] layers;
    public int audioCategory;
    @Nullable public StateBinding[] stateBindings;
    @Nullable public AudioCategoryDuckingRule[] duckingRules;
    public boolean bypassDucking;

    public SoundEvent() {
    }

    public SoundEvent(@Nullable String id, float volume, float pitch, int maxInstance, boolean preventSoundInterruption, float startAttenuationDistance, float maxDistance, float spatialBlend, @Nullable SoundEventLayer[] layers, int audioCategory, @Nullable StateBinding[] stateBindings, @Nullable AudioCategoryDuckingRule[] duckingRules, boolean bypassDucking) {
        this.id = id;
        this.volume = volume;
        this.pitch = pitch;
        this.maxInstance = maxInstance;
        this.preventSoundInterruption = preventSoundInterruption;
        this.startAttenuationDistance = startAttenuationDistance;
        this.maxDistance = maxDistance;
        this.spatialBlend = spatialBlend;
        this.layers = layers;
        this.audioCategory = audioCategory;
        this.stateBindings = stateBindings;
        this.duckingRules = duckingRules;
        this.bypassDucking = bypassDucking;
    }

    public SoundEvent(@Nonnull SoundEvent other) {
        this.id = other.id;
        this.volume = other.volume;
        this.pitch = other.pitch;
        this.maxInstance = other.maxInstance;
        this.preventSoundInterruption = other.preventSoundInterruption;
        this.startAttenuationDistance = other.startAttenuationDistance;
        this.maxDistance = other.maxDistance;
        this.spatialBlend = other.spatialBlend;
        this.layers = other.layers;
        this.audioCategory = other.audioCategory;
        this.stateBindings = other.stateBindings;
        this.duckingRules = other.duckingRules;
        this.bypassDucking = other.bypassDucking;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SoundEvent", offset, (int) mem.byteSize());
        long needed = (long) offset + 47;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SoundEvent", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 31, 47, "Id"), 4096000): null;
    }
    
    public static float getVolume(MemorySegment mem) {
        return getVolume(mem, 0);
    }
    
    public static float getVolume(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Volume");
    }
    
    public static float getPitch(MemorySegment mem) {
        return getPitch(mem, 0);
    }
    
    public static float getPitch(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "Pitch");
    }
    
    public static int getMaxInstance(MemorySegment mem) {
        return getMaxInstance(mem, 0);
    }
    
    public static int getMaxInstance(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 9);
    }
    
    public static boolean getPreventSoundInterruption(MemorySegment mem) {
        return getPreventSoundInterruption(mem, 0);
    }
    
    public static boolean getPreventSoundInterruption(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 13);
    }
    
    public static float getStartAttenuationDistance(MemorySegment mem) {
        return getStartAttenuationDistance(mem, 0);
    }
    
    public static float getStartAttenuationDistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 14), "StartAttenuationDistance");
    }
    
    public static float getMaxDistance(MemorySegment mem) {
        return getMaxDistance(mem, 0);
    }
    
    public static float getMaxDistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 18), "MaxDistance");
    }
    
    public static float getSpatialBlend(MemorySegment mem) {
        return getSpatialBlend(mem, 0);
    }
    
    public static float getSpatialBlend(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 22), "SpatialBlend");
    }
    
    @Nullable
    public static SoundEventLayer[] getLayers(MemorySegment mem) {
        return getLayers(mem, 0);
    }
    
    @Nullable
    public static SoundEventLayer[] getLayers(MemorySegment mem, int offset) {
        if (!hasLayers(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 35, 47, "Layers");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Layers");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Layers", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 45 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Layers", (int) java.lang.Math.min(off + lenOffset + (long) len * 45, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new SoundEventLayer[len];
        for (var i = 0; i < len; i++) {
            data[i] = SoundEventLayer.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static int getAudioCategory(MemorySegment mem) {
        return getAudioCategory(mem, 0);
    }
    
    public static int getAudioCategory(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 26);
    }
    
    @Nullable
    public static StateBinding[] getStateBindings(MemorySegment mem) {
        return getStateBindings(mem, 0);
    }
    
    @Nullable
    public static StateBinding[] getStateBindings(MemorySegment mem, int offset) {
        if (!hasStateBindings(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 39, 47, "StateBindings");
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
        var off = offset + getValidatedOffset(mem, offset, 43, 47, "DuckingRules");
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
    
    public static boolean getBypassDucking(MemorySegment mem) {
        return getBypassDucking(mem, 0);
    }
    
    public static boolean getBypassDucking(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 30);
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasLayers(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasStateBindings(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasDuckingRules(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
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
    
    public static SoundEvent toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SoundEvent toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SoundEvent and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SoundEvent toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 47;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 31, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 31, -1, "Id");
        }
        
        SoundEventLayer[] v8 = null;
        if (hasLayers(mem, offset)) {
            requireSlot(mem, offset + 35, varPos, "Layers");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Layers");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Layers", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 45 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Layers", (int) java.lang.Math.min(off + lenOffset + (long) len * 45, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v8 = new SoundEventLayer[len];
            for (var i = 0; i < len; i++) {
                v8[i] = SoundEventLayer.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 35, -1, "Layers");
        }
        
        StateBinding[] v10 = null;
        if (hasStateBindings(mem, offset)) {
            requireSlot(mem, offset + 39, varPos, "StateBindings");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("StateBindings");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("StateBindings", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("StateBindings", (int) java.lang.Math.min(off + lenOffset + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v10 = new StateBinding[len];
            for (var i = 0; i < len; i++) {
                v10[i] = StateBinding.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 39, -1, "StateBindings");
        }
        
        AudioCategoryDuckingRule[] v11 = null;
        if (hasDuckingRules(mem, offset)) {
            requireSlot(mem, offset + 43, varPos, "DuckingRules");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("DuckingRules");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("DuckingRules", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 24 > mem.byteSize()) throw ProtocolException.bufferTooSmall("DuckingRules", (int) java.lang.Math.min(off + lenOffset + (long) len * 24, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v11 = new AudioCategoryDuckingRule[len];
            for (var i = 0; i < len; i++) {
                v11[i] = AudioCategoryDuckingRule.toObject(mem, off + i * 24);
            }
            varPos = off + len * 24 - varBase;
        } else {
            requireSlot(mem, offset + 43, -1, "DuckingRules");
        }
        var result = new SoundEvent(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Volume"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "Pitch"),
            mem.get(PacketIO.PROTO_INT, offset + 9),
            mem.get(PacketIO.PROTO_BOOL, offset + 13),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 14), "StartAttenuationDistance"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 18), "MaxDistance"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 22), "SpatialBlend"),
            v8,
            mem.get(PacketIO.PROTO_INT, offset + 26),
            v10,
            v11,
            mem.get(PacketIO.PROTO_BOOL, offset + 30)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        if (this.layers != null) nullBits |= 0x02;
        if (this.stateBindings != null) nullBits |= 0x04;
        if (this.duckingRules != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.volume, "Volume"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.volume);
        PacketIO.requireFinite(this.pitch, "Pitch"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.pitch);
        mem.set(PacketIO.PROTO_INT, offset + 9, this.maxInstance);
        mem.set(PacketIO.PROTO_BOOL, offset + 13, this.preventSoundInterruption);
        PacketIO.requireFinite(this.startAttenuationDistance, "StartAttenuationDistance"); mem.set(PacketIO.PROTO_FLOAT, offset + 14, this.startAttenuationDistance);
        PacketIO.requireFinite(this.maxDistance, "MaxDistance"); mem.set(PacketIO.PROTO_FLOAT, offset + 18, this.maxDistance);
        PacketIO.requireFinite(this.spatialBlend, "SpatialBlend"); mem.set(PacketIO.PROTO_FLOAT, offset + 22, this.spatialBlend);
        mem.set(PacketIO.PROTO_INT, offset + 26, this.audioCategory);
        mem.set(PacketIO.PROTO_BOOL, offset + 30, this.bypassDucking);
        var varOffset = offset + 47;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 31, varOffset - offset - 47);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 31, -1);
        }
        if (this.layers != null) {
            mem.set(PacketIO.PROTO_INT, offset + 35, varOffset - offset - 47);
            if (layers.length > 4096000) throw ProtocolException.arrayTooLong("Layers", layers.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.layers.length);
            
            var layersValueOffset = 0;
            for (var i = 0; i < this.layers.length; i++) {
                layersValueOffset += this.layers[i].serialize(mem, varOffset + layersValueOffset);
            }
            varOffset += layersValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 35, -1);
        }
        if (this.stateBindings != null) {
            mem.set(PacketIO.PROTO_INT, offset + 39, varOffset - offset - 47);
            if (stateBindings.length > 4096000) throw ProtocolException.arrayTooLong("StateBindings", stateBindings.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.stateBindings.length);
            
            var stateBindingsValueOffset = 0;
            for (var i = 0; i < this.stateBindings.length; i++) {
                stateBindingsValueOffset += this.stateBindings[i].serialize(mem, varOffset + stateBindingsValueOffset);
            }
            varOffset += stateBindingsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 39, -1);
        }
        if (this.duckingRules != null) {
            mem.set(PacketIO.PROTO_INT, offset + 43, varOffset - offset - 47);
            if (duckingRules.length > 4096000) throw ProtocolException.arrayTooLong("DuckingRules", duckingRules.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.duckingRules.length);
            
            var duckingRulesValueOffset = 0;
            for (var i = 0; i < this.duckingRules.length; i++) {
                duckingRulesValueOffset += this.duckingRules[i].serialize(mem, varOffset + duckingRulesValueOffset);
            }
            varOffset += duckingRulesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 43, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 47;
        if (id != null) size += PacketIO.stringSize(id);
    if (layers != null) {
        int layersSize = 0;
for (var elem : layers) layersSize += elem.computeSize();
size += VarInt.size(layers.length) + layersSize;
    }
    if (stateBindings != null) {
        int stateBindingsSize = 0;
for (var elem : stateBindings) stateBindingsSize += elem.computeSize();
size += VarInt.size(stateBindings.length) + stateBindingsSize;
    }
    if (duckingRules != null) size += VarInt.size(duckingRules.length) + duckingRules.length * 24;

        return size;
    }

    public SoundEvent clone() {
        SoundEvent copy = new SoundEvent();
        copy.id = this.id;
        copy.volume = this.volume;
        copy.pitch = this.pitch;
        copy.maxInstance = this.maxInstance;
        copy.preventSoundInterruption = this.preventSoundInterruption;
        copy.startAttenuationDistance = this.startAttenuationDistance;
        copy.maxDistance = this.maxDistance;
        copy.spatialBlend = this.spatialBlend;
        copy.layers = this.layers != null ? java.util.Arrays.stream(this.layers).map(e -> e.clone()).toArray(SoundEventLayer[]::new) : null;
        copy.audioCategory = this.audioCategory;
        copy.stateBindings = this.stateBindings != null ? java.util.Arrays.stream(this.stateBindings).map(e -> e.clone()).toArray(StateBinding[]::new) : null;
        copy.duckingRules = this.duckingRules != null ? java.util.Arrays.stream(this.duckingRules).map(e -> e.clone()).toArray(AudioCategoryDuckingRule[]::new) : null;
        copy.bypassDucking = this.bypassDucking;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SoundEvent other)) return false;
        return java.util.Objects.equals(this.id, other.id) && this.volume == other.volume && this.pitch == other.pitch && this.maxInstance == other.maxInstance && this.preventSoundInterruption == other.preventSoundInterruption && this.startAttenuationDistance == other.startAttenuationDistance && this.maxDistance == other.maxDistance && this.spatialBlend == other.spatialBlend && java.util.Arrays.equals(this.layers, other.layers) && this.audioCategory == other.audioCategory && java.util.Arrays.equals(this.stateBindings, other.stateBindings) && java.util.Arrays.equals(this.duckingRules, other.duckingRules) && this.bypassDucking == other.bypassDucking;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(id);
        result = 31 * result + Float.hashCode(volume);
        result = 31 * result + Float.hashCode(pitch);
        result = 31 * result + Integer.hashCode(maxInstance);
        result = 31 * result + Boolean.hashCode(preventSoundInterruption);
        result = 31 * result + Float.hashCode(startAttenuationDistance);
        result = 31 * result + Float.hashCode(maxDistance);
        result = 31 * result + Float.hashCode(spatialBlend);
        result = 31 * result + java.util.Arrays.hashCode(layers);
        result = 31 * result + Integer.hashCode(audioCategory);
        result = 31 * result + java.util.Arrays.hashCode(stateBindings);
        result = 31 * result + java.util.Arrays.hashCode(duckingRules);
        result = 31 * result + Boolean.hashCode(bypassDucking);
        return result;
    }

}