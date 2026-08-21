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


public class ItemAppearanceCondition {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 18;
    public static final int VARIABLE_FIELD_COUNT = 5;
    public static final int VARIABLE_BLOCK_START = 38;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public ModelParticle[] particles;
    @Nullable public ModelParticle[] firstPersonParticles;
    @Nullable public String model;
    @Nullable public String texture;
    @Nullable public String modelVFXId;
    @Nullable public FloatRange condition;
    @Nonnull public ValueType conditionValueType = ValueType.Percent;
    public int localSoundEventId;
    public int worldSoundEventId;

    public ItemAppearanceCondition() {
    }

    public ItemAppearanceCondition(@Nullable ModelParticle[] particles, @Nullable ModelParticle[] firstPersonParticles, @Nullable String model, @Nullable String texture, @Nullable String modelVFXId, @Nullable FloatRange condition, @Nonnull ValueType conditionValueType, int localSoundEventId, int worldSoundEventId) {
        this.particles = particles;
        this.firstPersonParticles = firstPersonParticles;
        this.model = model;
        this.texture = texture;
        this.modelVFXId = modelVFXId;
        this.condition = condition;
        this.conditionValueType = conditionValueType;
        this.localSoundEventId = localSoundEventId;
        this.worldSoundEventId = worldSoundEventId;
    }

    public ItemAppearanceCondition(@Nonnull ItemAppearanceCondition other) {
        this.particles = other.particles;
        this.firstPersonParticles = other.firstPersonParticles;
        this.model = other.model;
        this.texture = other.texture;
        this.modelVFXId = other.modelVFXId;
        this.condition = other.condition;
        this.conditionValueType = other.conditionValueType;
        this.localSoundEventId = other.localSoundEventId;
        this.worldSoundEventId = other.worldSoundEventId;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemAppearanceCondition", offset, (int) mem.byteSize());
        long needed = (long) offset + 38;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemAppearanceCondition", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static ModelParticle[] getParticles(MemorySegment mem) {
        return getParticles(mem, 0);
    }
    
    @Nullable
    public static ModelParticle[] getParticles(MemorySegment mem, int offset) {
        if (!hasParticles(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 18, 38, "Particles");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Particles");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Particles", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Particles", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ModelParticle[len];
        for (var i = 0; i < len; i++) {
            data[i] = ModelParticle.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static ModelParticle[] getFirstPersonParticles(MemorySegment mem) {
        return getFirstPersonParticles(mem, 0);
    }
    
    @Nullable
    public static ModelParticle[] getFirstPersonParticles(MemorySegment mem, int offset) {
        if (!hasFirstPersonParticles(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 22, 38, "FirstPersonParticles");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("FirstPersonParticles");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("FirstPersonParticles", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FirstPersonParticles", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ModelParticle[len];
        for (var i = 0; i < len; i++) {
            data[i] = ModelParticle.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static String getModel(MemorySegment mem) {
        return getModel(mem, 0);
    }
    
    @Nullable
    public static String getModel(MemorySegment mem, int offset) {
        return hasModel(mem, offset) ? PacketIO.readVarString("Model", mem, offset + getValidatedOffset(mem, offset, 26, 38, "Model"), 4096000): null;
    }
    
    @Nullable
    public static String getTexture(MemorySegment mem) {
        return getTexture(mem, 0);
    }
    
    @Nullable
    public static String getTexture(MemorySegment mem, int offset) {
        return hasTexture(mem, offset) ? PacketIO.readVarString("Texture", mem, offset + getValidatedOffset(mem, offset, 30, 38, "Texture"), 4096000): null;
    }
    
    @Nullable
    public static String getModelVFXId(MemorySegment mem) {
        return getModelVFXId(mem, 0);
    }
    
    @Nullable
    public static String getModelVFXId(MemorySegment mem, int offset) {
        return hasModelVFXId(mem, offset) ? PacketIO.readVarString("ModelVFXId", mem, offset + getValidatedOffset(mem, offset, 34, 38, "ModelVFXId"), 4096000): null;
    }
    
    @Nullable
    public static FloatRange getCondition(MemorySegment mem) {
        return getCondition(mem, 0);
    }
    
    @Nullable
    public static FloatRange getCondition(MemorySegment mem, int offset) {
        return hasCondition(mem, offset) ? FloatRange.toObject(mem, offset + 1): null;
    }
    
    public static ValueType getConditionValueType(MemorySegment mem) {
        return getConditionValueType(mem, 0);
    }
    
    public static ValueType getConditionValueType(MemorySegment mem, int offset) {
        return ValueType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 9));
    }
    
    public static int getLocalSoundEventId(MemorySegment mem) {
        return getLocalSoundEventId(mem, 0);
    }
    
    public static int getLocalSoundEventId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 10);
    }
    
    public static int getWorldSoundEventId(MemorySegment mem) {
        return getWorldSoundEventId(mem, 0);
    }
    
    public static int getWorldSoundEventId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 14);
    }
    
    public static boolean hasCondition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasParticles(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasFirstPersonParticles(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasModel(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasTexture(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasModelVFXId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
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
    
    public static ItemAppearanceCondition toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemAppearanceCondition toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemAppearanceCondition and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemAppearanceCondition toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 38;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ModelParticle[] v0 = null;
        if (hasParticles(mem, offset)) {
            requireSlot(mem, offset + 18, varPos, "Particles");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Particles");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Particles", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Particles", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new ModelParticle[len];
            for (var i = 0; i < len; i++) {
                v0[i] = ModelParticle.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 18, -1, "Particles");
        }
        
        ModelParticle[] v1 = null;
        if (hasFirstPersonParticles(mem, offset)) {
            requireSlot(mem, offset + 22, varPos, "FirstPersonParticles");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("FirstPersonParticles");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("FirstPersonParticles", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FirstPersonParticles", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new ModelParticle[len];
            for (var i = 0; i < len; i++) {
                v1[i] = ModelParticle.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 22, -1, "FirstPersonParticles");
        }
        
        String v2 = null;
        if (hasModel(mem, offset)) {
            requireSlot(mem, offset + 26, varPos, "Model");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("Model", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 26, -1, "Model");
        }
        
        String v3 = null;
        if (hasTexture(mem, offset)) {
            requireSlot(mem, offset + 30, varPos, "Texture");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readVarString("Texture", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 30, -1, "Texture");
        }
        
        String v4 = null;
        if (hasModelVFXId(mem, offset)) {
            requireSlot(mem, offset + 34, varPos, "ModelVFXId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v4 = PacketIO.readVarString("ModelVFXId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 34, -1, "ModelVFXId");
        }
        var result = new ItemAppearanceCondition(
            v0,
            v1,
            v2,
            v3,
            v4,
            hasCondition(mem, offset) ? FloatRange.toObject(mem, offset + 1) : null,
            ValueType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 9)),
            mem.get(PacketIO.PROTO_INT, offset + 10),
            mem.get(PacketIO.PROTO_INT, offset + 14)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.condition != null) nullBits |= 0x01;
        if (this.particles != null) nullBits |= 0x02;
        if (this.firstPersonParticles != null) nullBits |= 0x04;
        if (this.model != null) nullBits |= 0x08;
        if (this.texture != null) nullBits |= 0x10;
        if (this.modelVFXId != null) nullBits |= 0x20;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.condition != null) {
            this.condition.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 8).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BYTE, offset + 9, (byte) this.conditionValueType.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 10, this.localSoundEventId);
        mem.set(PacketIO.PROTO_INT, offset + 14, this.worldSoundEventId);
        var varOffset = offset + 38;
        if (this.particles != null) {
            mem.set(PacketIO.PROTO_INT, offset + 18, varOffset - offset - 38);
            if (particles.length > 4096000) throw ProtocolException.arrayTooLong("Particles", particles.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.particles.length);
            
            var particlesValueOffset = 0;
            for (var i = 0; i < this.particles.length; i++) {
                particlesValueOffset += this.particles[i].serialize(mem, varOffset + particlesValueOffset);
            }
            varOffset += particlesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 18, -1);
        }
        if (this.firstPersonParticles != null) {
            mem.set(PacketIO.PROTO_INT, offset + 22, varOffset - offset - 38);
            if (firstPersonParticles.length > 4096000) throw ProtocolException.arrayTooLong("FirstPersonParticles", firstPersonParticles.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.firstPersonParticles.length);
            
            var firstPersonParticlesValueOffset = 0;
            for (var i = 0; i < this.firstPersonParticles.length; i++) {
                firstPersonParticlesValueOffset += this.firstPersonParticles[i].serialize(mem, varOffset + firstPersonParticlesValueOffset);
            }
            varOffset += firstPersonParticlesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 22, -1);
        }
        if (this.model != null) {
            mem.set(PacketIO.PROTO_INT, offset + 26, varOffset - offset - 38);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.model, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 26, -1);
        }
        if (this.texture != null) {
            mem.set(PacketIO.PROTO_INT, offset + 30, varOffset - offset - 38);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.texture, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 30, -1);
        }
        if (this.modelVFXId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 34, varOffset - offset - 38);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.modelVFXId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 34, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 38;
        if (particles != null) {
        int particlesSize = 0;
for (var elem : particles) particlesSize += elem.computeSize();
size += VarInt.size(particles.length) + particlesSize;
    }
    if (firstPersonParticles != null) {
        int firstPersonParticlesSize = 0;
for (var elem : firstPersonParticles) firstPersonParticlesSize += elem.computeSize();
size += VarInt.size(firstPersonParticles.length) + firstPersonParticlesSize;
    }
    if (model != null) size += PacketIO.stringSize(model);
    if (texture != null) size += PacketIO.stringSize(texture);
    if (modelVFXId != null) size += PacketIO.stringSize(modelVFXId);

        return size;
    }

    public ItemAppearanceCondition clone() {
        ItemAppearanceCondition copy = new ItemAppearanceCondition();
        copy.particles = this.particles != null ? java.util.Arrays.stream(this.particles).map(e -> e.clone()).toArray(ModelParticle[]::new) : null;
        copy.firstPersonParticles = this.firstPersonParticles != null ? java.util.Arrays.stream(this.firstPersonParticles).map(e -> e.clone()).toArray(ModelParticle[]::new) : null;
        copy.model = this.model;
        copy.texture = this.texture;
        copy.modelVFXId = this.modelVFXId;
        copy.condition = this.condition != null ? this.condition.clone() : null;
        copy.conditionValueType = this.conditionValueType;
        copy.localSoundEventId = this.localSoundEventId;
        copy.worldSoundEventId = this.worldSoundEventId;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemAppearanceCondition other)) return false;
        return java.util.Arrays.equals(this.particles, other.particles) && java.util.Arrays.equals(this.firstPersonParticles, other.firstPersonParticles) && java.util.Objects.equals(this.model, other.model) && java.util.Objects.equals(this.texture, other.texture) && java.util.Objects.equals(this.modelVFXId, other.modelVFXId) && java.util.Objects.equals(this.condition, other.condition) && java.util.Objects.equals(this.conditionValueType, other.conditionValueType) && this.localSoundEventId == other.localSoundEventId && this.worldSoundEventId == other.worldSoundEventId;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(particles);
        result = 31 * result + java.util.Arrays.hashCode(firstPersonParticles);
        result = 31 * result + java.util.Objects.hashCode(model);
        result = 31 * result + java.util.Objects.hashCode(texture);
        result = 31 * result + java.util.Objects.hashCode(modelVFXId);
        result = 31 * result + java.util.Objects.hashCode(condition);
        result = 31 * result + java.util.Objects.hashCode(conditionValueType);
        result = 31 * result + Integer.hashCode(localSoundEventId);
        result = 31 * result + Integer.hashCode(worldSoundEventId);
        return result;
    }

}