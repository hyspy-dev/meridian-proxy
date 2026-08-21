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


public class ApplicationEffects {
    public static final int NULLABLE_BIT_FIELD_SIZE = 2;
    public static final int FIXED_BLOCK_SIZE = 33;
    public static final int VARIABLE_FIELD_COUNT = 6;
    public static final int VARIABLE_BLOCK_START = 57;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public Color entityBottomTint;
    @Nullable public Color entityTopTint;
    @Nullable public String entityAnimationId;
    @Nullable public ModelParticle[] particles;
    @Nullable public ModelParticle[] firstPersonParticles;
    @Nullable public String screenEffect;
    public float horizontalSpeedMultiplier;
    public int soundEventIndexLocal;
    public int soundEventIndexWorld;
    @Nullable public String modelVFXId;
    @Nullable public MovementEffects movementEffects;
    public float mouseSensitivityAdjustmentTarget;
    public float mouseSensitivityAdjustmentDuration;
    @Nullable public AbilityEffects abilityEffects;

    public ApplicationEffects() {
    }

    public ApplicationEffects(@Nullable Color entityBottomTint, @Nullable Color entityTopTint, @Nullable String entityAnimationId, @Nullable ModelParticle[] particles, @Nullable ModelParticle[] firstPersonParticles, @Nullable String screenEffect, float horizontalSpeedMultiplier, int soundEventIndexLocal, int soundEventIndexWorld, @Nullable String modelVFXId, @Nullable MovementEffects movementEffects, float mouseSensitivityAdjustmentTarget, float mouseSensitivityAdjustmentDuration, @Nullable AbilityEffects abilityEffects) {
        this.entityBottomTint = entityBottomTint;
        this.entityTopTint = entityTopTint;
        this.entityAnimationId = entityAnimationId;
        this.particles = particles;
        this.firstPersonParticles = firstPersonParticles;
        this.screenEffect = screenEffect;
        this.horizontalSpeedMultiplier = horizontalSpeedMultiplier;
        this.soundEventIndexLocal = soundEventIndexLocal;
        this.soundEventIndexWorld = soundEventIndexWorld;
        this.modelVFXId = modelVFXId;
        this.movementEffects = movementEffects;
        this.mouseSensitivityAdjustmentTarget = mouseSensitivityAdjustmentTarget;
        this.mouseSensitivityAdjustmentDuration = mouseSensitivityAdjustmentDuration;
        this.abilityEffects = abilityEffects;
    }

    public ApplicationEffects(@Nonnull ApplicationEffects other) {
        this.entityBottomTint = other.entityBottomTint;
        this.entityTopTint = other.entityTopTint;
        this.entityAnimationId = other.entityAnimationId;
        this.particles = other.particles;
        this.firstPersonParticles = other.firstPersonParticles;
        this.screenEffect = other.screenEffect;
        this.horizontalSpeedMultiplier = other.horizontalSpeedMultiplier;
        this.soundEventIndexLocal = other.soundEventIndexLocal;
        this.soundEventIndexWorld = other.soundEventIndexWorld;
        this.modelVFXId = other.modelVFXId;
        this.movementEffects = other.movementEffects;
        this.mouseSensitivityAdjustmentTarget = other.mouseSensitivityAdjustmentTarget;
        this.mouseSensitivityAdjustmentDuration = other.mouseSensitivityAdjustmentDuration;
        this.abilityEffects = other.abilityEffects;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ApplicationEffects", offset, (int) mem.byteSize());
        long needed = (long) offset + 57;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ApplicationEffects", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static Color getEntityBottomTint(MemorySegment mem) {
        return getEntityBottomTint(mem, 0);
    }
    
    @Nullable
    public static Color getEntityBottomTint(MemorySegment mem, int offset) {
        return hasEntityBottomTint(mem, offset) ? Color.toObject(mem, offset + 2): null;
    }
    
    @Nullable
    public static Color getEntityTopTint(MemorySegment mem) {
        return getEntityTopTint(mem, 0);
    }
    
    @Nullable
    public static Color getEntityTopTint(MemorySegment mem, int offset) {
        return hasEntityTopTint(mem, offset) ? Color.toObject(mem, offset + 5): null;
    }
    
    @Nullable
    public static String getEntityAnimationId(MemorySegment mem) {
        return getEntityAnimationId(mem, 0);
    }
    
    @Nullable
    public static String getEntityAnimationId(MemorySegment mem, int offset) {
        return hasEntityAnimationId(mem, offset) ? PacketIO.readVarString("EntityAnimationId", mem, offset + getValidatedOffset(mem, offset, 33, 57, "EntityAnimationId"), 4096000): null;
    }
    
    @Nullable
    public static ModelParticle[] getParticles(MemorySegment mem) {
        return getParticles(mem, 0);
    }
    
    @Nullable
    public static ModelParticle[] getParticles(MemorySegment mem, int offset) {
        if (!hasParticles(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 37, 57, "Particles");
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
        var off = offset + getValidatedOffset(mem, offset, 41, 57, "FirstPersonParticles");
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
    public static String getScreenEffect(MemorySegment mem) {
        return getScreenEffect(mem, 0);
    }
    
    @Nullable
    public static String getScreenEffect(MemorySegment mem, int offset) {
        return hasScreenEffect(mem, offset) ? PacketIO.readVarString("ScreenEffect", mem, offset + getValidatedOffset(mem, offset, 45, 57, "ScreenEffect"), 4096000): null;
    }
    
    public static float getHorizontalSpeedMultiplier(MemorySegment mem) {
        return getHorizontalSpeedMultiplier(mem, 0);
    }
    
    public static float getHorizontalSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "HorizontalSpeedMultiplier");
    }
    
    public static int getSoundEventIndexLocal(MemorySegment mem) {
        return getSoundEventIndexLocal(mem, 0);
    }
    
    public static int getSoundEventIndexLocal(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 12);
    }
    
    public static int getSoundEventIndexWorld(MemorySegment mem) {
        return getSoundEventIndexWorld(mem, 0);
    }
    
    public static int getSoundEventIndexWorld(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 16);
    }
    
    @Nullable
    public static String getModelVFXId(MemorySegment mem) {
        return getModelVFXId(mem, 0);
    }
    
    @Nullable
    public static String getModelVFXId(MemorySegment mem, int offset) {
        return hasModelVFXId(mem, offset) ? PacketIO.readVarString("ModelVFXId", mem, offset + getValidatedOffset(mem, offset, 49, 57, "ModelVFXId"), 4096000): null;
    }
    
    @Nullable
    public static MovementEffects getMovementEffects(MemorySegment mem) {
        return getMovementEffects(mem, 0);
    }
    
    @Nullable
    public static MovementEffects getMovementEffects(MemorySegment mem, int offset) {
        return hasMovementEffects(mem, offset) ? MovementEffects.toObject(mem, offset + 20): null;
    }
    
    public static float getMouseSensitivityAdjustmentTarget(MemorySegment mem) {
        return getMouseSensitivityAdjustmentTarget(mem, 0);
    }
    
    public static float getMouseSensitivityAdjustmentTarget(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 25), "MouseSensitivityAdjustmentTarget");
    }
    
    public static float getMouseSensitivityAdjustmentDuration(MemorySegment mem) {
        return getMouseSensitivityAdjustmentDuration(mem, 0);
    }
    
    public static float getMouseSensitivityAdjustmentDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 29), "MouseSensitivityAdjustmentDuration");
    }
    
    @Nullable
    public static AbilityEffects getAbilityEffects(MemorySegment mem) {
        return getAbilityEffects(mem, 0);
    }
    
    @Nullable
    public static AbilityEffects getAbilityEffects(MemorySegment mem, int offset) {
        return hasAbilityEffects(mem, offset) ? AbilityEffects.toObject(mem, offset + getValidatedOffset(mem, offset, 53, 57, "AbilityEffects")): null;
    }
    
    public static boolean hasEntityBottomTint(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasEntityTopTint(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasMovementEffects(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasEntityAnimationId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasParticles(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasFirstPersonParticles(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasScreenEffect(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasModelVFXId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasAbilityEffects(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
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
    
    public static ApplicationEffects toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ApplicationEffects toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ApplicationEffects and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ApplicationEffects toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 57;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v2 = null;
        if (hasEntityAnimationId(mem, offset)) {
            requireSlot(mem, offset + 33, varPos, "EntityAnimationId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("EntityAnimationId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 33, -1, "EntityAnimationId");
        }
        
        ModelParticle[] v3 = null;
        if (hasParticles(mem, offset)) {
            requireSlot(mem, offset + 37, varPos, "Particles");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Particles");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Particles", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Particles", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v3 = new ModelParticle[len];
            for (var i = 0; i < len; i++) {
                v3[i] = ModelParticle.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 37, -1, "Particles");
        }
        
        ModelParticle[] v4 = null;
        if (hasFirstPersonParticles(mem, offset)) {
            requireSlot(mem, offset + 41, varPos, "FirstPersonParticles");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("FirstPersonParticles");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("FirstPersonParticles", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FirstPersonParticles", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v4 = new ModelParticle[len];
            for (var i = 0; i < len; i++) {
                v4[i] = ModelParticle.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 41, -1, "FirstPersonParticles");
        }
        
        String v5 = null;
        if (hasScreenEffect(mem, offset)) {
            requireSlot(mem, offset + 45, varPos, "ScreenEffect");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v5 = PacketIO.readVarString("ScreenEffect", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 45, -1, "ScreenEffect");
        }
        
        String v9 = null;
        if (hasModelVFXId(mem, offset)) {
            requireSlot(mem, offset + 49, varPos, "ModelVFXId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v9 = PacketIO.readVarString("ModelVFXId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 49, -1, "ModelVFXId");
        }
        
        AbilityEffects v13 = null;
        if (hasAbilityEffects(mem, offset)) {
            requireSlot(mem, offset + 53, varPos, "AbilityEffects");
            v13 = AbilityEffects.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 53, -1, "AbilityEffects");
        }
        var result = new ApplicationEffects(
            hasEntityBottomTint(mem, offset) ? Color.toObject(mem, offset + 2) : null,
            hasEntityTopTint(mem, offset) ? Color.toObject(mem, offset + 5) : null,
            v2,
            v3,
            v4,
            v5,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "HorizontalSpeedMultiplier"),
            mem.get(PacketIO.PROTO_INT, offset + 12),
            mem.get(PacketIO.PROTO_INT, offset + 16),
            v9,
            hasMovementEffects(mem, offset) ? MovementEffects.toObject(mem, offset + 20) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 25), "MouseSensitivityAdjustmentTarget"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 29), "MouseSensitivityAdjustmentDuration"),
            v13
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.entityBottomTint != null) nullBits |= 0x01;
        if (this.entityTopTint != null) nullBits |= 0x02;
        if (this.movementEffects != null) nullBits |= 0x04;
        if (this.entityAnimationId != null) nullBits |= 0x08;
        if (this.particles != null) nullBits |= 0x10;
        if (this.firstPersonParticles != null) nullBits |= 0x20;
        if (this.screenEffect != null) nullBits |= 0x40;
        if (this.modelVFXId != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        nullBits = 0;
        if (this.abilityEffects != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 1, nullBits);
        
        if (this.entityBottomTint != null) {
            this.entityBottomTint.serialize(mem, offset + 2);
        } else {
            mem.asSlice(offset + 2, 3).fill((byte) 0); 
        }
        if (this.entityTopTint != null) {
            this.entityTopTint.serialize(mem, offset + 5);
        } else {
            mem.asSlice(offset + 5, 3).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.horizontalSpeedMultiplier, "HorizontalSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 8, this.horizontalSpeedMultiplier);
        mem.set(PacketIO.PROTO_INT, offset + 12, this.soundEventIndexLocal);
        mem.set(PacketIO.PROTO_INT, offset + 16, this.soundEventIndexWorld);
        if (this.movementEffects != null) {
            this.movementEffects.serialize(mem, offset + 20);
        } else {
            mem.asSlice(offset + 20, 5).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.mouseSensitivityAdjustmentTarget, "MouseSensitivityAdjustmentTarget"); mem.set(PacketIO.PROTO_FLOAT, offset + 25, this.mouseSensitivityAdjustmentTarget);
        PacketIO.requireFinite(this.mouseSensitivityAdjustmentDuration, "MouseSensitivityAdjustmentDuration"); mem.set(PacketIO.PROTO_FLOAT, offset + 29, this.mouseSensitivityAdjustmentDuration);
        var varOffset = offset + 57;
        if (this.entityAnimationId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 33, varOffset - offset - 57);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.entityAnimationId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 33, -1);
        }
        if (this.particles != null) {
            mem.set(PacketIO.PROTO_INT, offset + 37, varOffset - offset - 57);
            if (particles.length > 4096000) throw ProtocolException.arrayTooLong("Particles", particles.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.particles.length);
            
            var particlesValueOffset = 0;
            for (var i = 0; i < this.particles.length; i++) {
                particlesValueOffset += this.particles[i].serialize(mem, varOffset + particlesValueOffset);
            }
            varOffset += particlesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 37, -1);
        }
        if (this.firstPersonParticles != null) {
            mem.set(PacketIO.PROTO_INT, offset + 41, varOffset - offset - 57);
            if (firstPersonParticles.length > 4096000) throw ProtocolException.arrayTooLong("FirstPersonParticles", firstPersonParticles.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.firstPersonParticles.length);
            
            var firstPersonParticlesValueOffset = 0;
            for (var i = 0; i < this.firstPersonParticles.length; i++) {
                firstPersonParticlesValueOffset += this.firstPersonParticles[i].serialize(mem, varOffset + firstPersonParticlesValueOffset);
            }
            varOffset += firstPersonParticlesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 41, -1);
        }
        if (this.screenEffect != null) {
            mem.set(PacketIO.PROTO_INT, offset + 45, varOffset - offset - 57);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.screenEffect, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 45, -1);
        }
        if (this.modelVFXId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 49, varOffset - offset - 57);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.modelVFXId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 49, -1);
        }
        if (this.abilityEffects != null) {
            mem.set(PacketIO.PROTO_INT, offset + 53, varOffset - offset - 57);
            varOffset += this.abilityEffects.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 53, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 57;
        if (entityAnimationId != null) size += PacketIO.stringSize(entityAnimationId);
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
    if (screenEffect != null) size += PacketIO.stringSize(screenEffect);
    if (modelVFXId != null) size += PacketIO.stringSize(modelVFXId);
    if (abilityEffects != null) size += abilityEffects.computeSize();

        return size;
    }

    public ApplicationEffects clone() {
        ApplicationEffects copy = new ApplicationEffects();
        copy.entityBottomTint = this.entityBottomTint != null ? this.entityBottomTint.clone() : null;
        copy.entityTopTint = this.entityTopTint != null ? this.entityTopTint.clone() : null;
        copy.entityAnimationId = this.entityAnimationId;
        copy.particles = this.particles != null ? java.util.Arrays.stream(this.particles).map(e -> e.clone()).toArray(ModelParticle[]::new) : null;
        copy.firstPersonParticles = this.firstPersonParticles != null ? java.util.Arrays.stream(this.firstPersonParticles).map(e -> e.clone()).toArray(ModelParticle[]::new) : null;
        copy.screenEffect = this.screenEffect;
        copy.horizontalSpeedMultiplier = this.horizontalSpeedMultiplier;
        copy.soundEventIndexLocal = this.soundEventIndexLocal;
        copy.soundEventIndexWorld = this.soundEventIndexWorld;
        copy.modelVFXId = this.modelVFXId;
        copy.movementEffects = this.movementEffects != null ? this.movementEffects.clone() : null;
        copy.mouseSensitivityAdjustmentTarget = this.mouseSensitivityAdjustmentTarget;
        copy.mouseSensitivityAdjustmentDuration = this.mouseSensitivityAdjustmentDuration;
        copy.abilityEffects = this.abilityEffects != null ? this.abilityEffects.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ApplicationEffects other)) return false;
        return java.util.Objects.equals(this.entityBottomTint, other.entityBottomTint) && java.util.Objects.equals(this.entityTopTint, other.entityTopTint) && java.util.Objects.equals(this.entityAnimationId, other.entityAnimationId) && java.util.Arrays.equals(this.particles, other.particles) && java.util.Arrays.equals(this.firstPersonParticles, other.firstPersonParticles) && java.util.Objects.equals(this.screenEffect, other.screenEffect) && this.horizontalSpeedMultiplier == other.horizontalSpeedMultiplier && this.soundEventIndexLocal == other.soundEventIndexLocal && this.soundEventIndexWorld == other.soundEventIndexWorld && java.util.Objects.equals(this.modelVFXId, other.modelVFXId) && java.util.Objects.equals(this.movementEffects, other.movementEffects) && this.mouseSensitivityAdjustmentTarget == other.mouseSensitivityAdjustmentTarget && this.mouseSensitivityAdjustmentDuration == other.mouseSensitivityAdjustmentDuration && java.util.Objects.equals(this.abilityEffects, other.abilityEffects);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(entityBottomTint);
        result = 31 * result + java.util.Objects.hashCode(entityTopTint);
        result = 31 * result + java.util.Objects.hashCode(entityAnimationId);
        result = 31 * result + java.util.Arrays.hashCode(particles);
        result = 31 * result + java.util.Arrays.hashCode(firstPersonParticles);
        result = 31 * result + java.util.Objects.hashCode(screenEffect);
        result = 31 * result + Float.hashCode(horizontalSpeedMultiplier);
        result = 31 * result + Integer.hashCode(soundEventIndexLocal);
        result = 31 * result + Integer.hashCode(soundEventIndexWorld);
        result = 31 * result + java.util.Objects.hashCode(modelVFXId);
        result = 31 * result + java.util.Objects.hashCode(movementEffects);
        result = 31 * result + Float.hashCode(mouseSensitivityAdjustmentTarget);
        result = 31 * result + Float.hashCode(mouseSensitivityAdjustmentDuration);
        result = 31 * result + java.util.Objects.hashCode(abilityEffects);
        return result;
    }

}