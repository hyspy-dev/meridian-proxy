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

public class Particle {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 149;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 157;
    public static final int MAX_SIZE = 270336167;

    @Nullable public String texturePath;
    @Nullable public Size frameSize;
    @Nonnull public ParticleUVOption uvOption = ParticleUVOption.None;
    @Nonnull public ParticleScaleRatioConstraint scaleRatioConstraint = ParticleScaleRatioConstraint.OneToOne;
    @Nonnull public SoftParticle softParticles = SoftParticle.Enable;
    public float softParticlesFadeFactor;
    public float cameraNearFadeStartDistance;
    public float cameraNearFadeEndDistance;
    public float cameraFarFadeStartDistance;
    public float cameraFarFadeEndDistance;
    public boolean useSpriteBlending;
    @Nullable public ParticleAnimationFrame initialAnimationFrame;
    @Nullable public ParticleAnimationFrame collisionAnimationFrame;
    @Nullable public java.util.Map<Integer, ParticleAnimationFrame> animationFrames;

    public Particle() {
    }

    public Particle(@Nullable String texturePath, @Nullable Size frameSize, @Nonnull ParticleUVOption uvOption, @Nonnull ParticleScaleRatioConstraint scaleRatioConstraint, @Nonnull SoftParticle softParticles, float softParticlesFadeFactor, float cameraNearFadeStartDistance, float cameraNearFadeEndDistance, float cameraFarFadeStartDistance, float cameraFarFadeEndDistance, boolean useSpriteBlending, @Nullable ParticleAnimationFrame initialAnimationFrame, @Nullable ParticleAnimationFrame collisionAnimationFrame, @Nullable java.util.Map<Integer, ParticleAnimationFrame> animationFrames) {
        this.texturePath = texturePath;
        this.frameSize = frameSize;
        this.uvOption = uvOption;
        this.scaleRatioConstraint = scaleRatioConstraint;
        this.softParticles = softParticles;
        this.softParticlesFadeFactor = softParticlesFadeFactor;
        this.cameraNearFadeStartDistance = cameraNearFadeStartDistance;
        this.cameraNearFadeEndDistance = cameraNearFadeEndDistance;
        this.cameraFarFadeStartDistance = cameraFarFadeStartDistance;
        this.cameraFarFadeEndDistance = cameraFarFadeEndDistance;
        this.useSpriteBlending = useSpriteBlending;
        this.initialAnimationFrame = initialAnimationFrame;
        this.collisionAnimationFrame = collisionAnimationFrame;
        this.animationFrames = animationFrames;
    }

    public Particle(@Nonnull Particle other) {
        this.texturePath = other.texturePath;
        this.frameSize = other.frameSize;
        this.uvOption = other.uvOption;
        this.scaleRatioConstraint = other.scaleRatioConstraint;
        this.softParticles = other.softParticles;
        this.softParticlesFadeFactor = other.softParticlesFadeFactor;
        this.cameraNearFadeStartDistance = other.cameraNearFadeStartDistance;
        this.cameraNearFadeEndDistance = other.cameraNearFadeEndDistance;
        this.cameraFarFadeStartDistance = other.cameraFarFadeStartDistance;
        this.cameraFarFadeEndDistance = other.cameraFarFadeEndDistance;
        this.useSpriteBlending = other.useSpriteBlending;
        this.initialAnimationFrame = other.initialAnimationFrame;
        this.collisionAnimationFrame = other.collisionAnimationFrame;
        this.animationFrames = other.animationFrames;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Particle", offset, (int) mem.byteSize());
        long needed = (long) offset + 157;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Particle", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getTexturePath(MemorySegment mem) {
        return getTexturePath(mem, 0);
    }
    
    @Nullable
    public static String getTexturePath(MemorySegment mem, int offset) {
        return hasTexturePath(mem, offset) ? PacketIO.readVarString("TexturePath", mem, offset + getValidatedOffset(mem, offset, 149, 157, "TexturePath"), 4096000): null;
    }
    
    @Nullable
    public static Size getFrameSize(MemorySegment mem) {
        return getFrameSize(mem, 0);
    }
    
    @Nullable
    public static Size getFrameSize(MemorySegment mem, int offset) {
        return hasFrameSize(mem, offset) ? Size.toObject(mem, offset + 1): null;
    }
    
    public static ParticleUVOption getUvOption(MemorySegment mem) {
        return getUvOption(mem, 0);
    }
    
    public static ParticleUVOption getUvOption(MemorySegment mem, int offset) {
        return ParticleUVOption.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 9));
    }
    
    public static ParticleScaleRatioConstraint getScaleRatioConstraint(MemorySegment mem) {
        return getScaleRatioConstraint(mem, 0);
    }
    
    public static ParticleScaleRatioConstraint getScaleRatioConstraint(MemorySegment mem, int offset) {
        return ParticleScaleRatioConstraint.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 10));
    }
    
    public static SoftParticle getSoftParticles(MemorySegment mem) {
        return getSoftParticles(mem, 0);
    }
    
    public static SoftParticle getSoftParticles(MemorySegment mem, int offset) {
        return SoftParticle.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 11));
    }
    
    public static float getSoftParticlesFadeFactor(MemorySegment mem) {
        return getSoftParticlesFadeFactor(mem, 0);
    }
    
    public static float getSoftParticlesFadeFactor(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "SoftParticlesFadeFactor");
    }
    
    public static float getCameraNearFadeStartDistance(MemorySegment mem) {
        return getCameraNearFadeStartDistance(mem, 0);
    }
    
    public static float getCameraNearFadeStartDistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "CameraNearFadeStartDistance");
    }
    
    public static float getCameraNearFadeEndDistance(MemorySegment mem) {
        return getCameraNearFadeEndDistance(mem, 0);
    }
    
    public static float getCameraNearFadeEndDistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "CameraNearFadeEndDistance");
    }
    
    public static float getCameraFarFadeStartDistance(MemorySegment mem) {
        return getCameraFarFadeStartDistance(mem, 0);
    }
    
    public static float getCameraFarFadeStartDistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 24), "CameraFarFadeStartDistance");
    }
    
    public static float getCameraFarFadeEndDistance(MemorySegment mem) {
        return getCameraFarFadeEndDistance(mem, 0);
    }
    
    public static float getCameraFarFadeEndDistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 28), "CameraFarFadeEndDistance");
    }
    
    public static boolean getUseSpriteBlending(MemorySegment mem) {
        return getUseSpriteBlending(mem, 0);
    }
    
    public static boolean getUseSpriteBlending(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 32);
    }
    
    @Nullable
    public static ParticleAnimationFrame getInitialAnimationFrame(MemorySegment mem) {
        return getInitialAnimationFrame(mem, 0);
    }
    
    @Nullable
    public static ParticleAnimationFrame getInitialAnimationFrame(MemorySegment mem, int offset) {
        return hasInitialAnimationFrame(mem, offset) ? ParticleAnimationFrame.toObject(mem, offset + 33): null;
    }
    
    @Nullable
    public static ParticleAnimationFrame getCollisionAnimationFrame(MemorySegment mem) {
        return getCollisionAnimationFrame(mem, 0);
    }
    
    @Nullable
    public static ParticleAnimationFrame getCollisionAnimationFrame(MemorySegment mem, int offset) {
        return hasCollisionAnimationFrame(mem, offset) ? ParticleAnimationFrame.toObject(mem, offset + 91): null;
    }
    
    @Nullable
    public static java.util.Map<Integer, ParticleAnimationFrame> getAnimationFrames(MemorySegment mem) {
        return getAnimationFrames(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Integer, ParticleAnimationFrame> getAnimationFrames(MemorySegment mem, int offset) {
        if (!hasAnimationFrames(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 153, 157, "AnimationFrames");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("AnimationFrames");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("AnimationFrames", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 62 > mem.byteSize()) throw ProtocolException.bufferTooSmall("AnimationFrames", (int) java.lang.Math.min(off + (long) len * 62, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Integer, ParticleAnimationFrame> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            var value = ParticleAnimationFrame.toObject(mem, off);
                off += 58;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("AnimationFrames", key);
            }
        }
        return data;
    }
    
    public static boolean hasFrameSize(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasInitialAnimationFrame(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasCollisionAnimationFrame(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasTexturePath(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasAnimationFrames(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
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
    
    public static Particle toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Particle toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Particle and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Particle toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 157;
        var varPos = 0;
        String v0 = null;
        if (hasTexturePath(mem, offset)) {
            requireSlot(mem, offset + 149, varPos, "TexturePath");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("TexturePath", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 149, -1, "TexturePath");
        }
        
        java.util.Map<Integer, ParticleAnimationFrame> v13 = null;
        if (hasAnimationFrames(mem, offset)) {
            requireSlot(mem, offset + 153, varPos, "AnimationFrames");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("AnimationFrames");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("AnimationFrames", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 62 > mem.byteSize()) throw ProtocolException.bufferTooSmall("AnimationFrames", (int) java.lang.Math.min(off + (long) len * 62, Integer.MAX_VALUE), (int) mem.byteSize());
            v13 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                var value = ParticleAnimationFrame.toObject(mem, off);
                    off += 58;
                if (v13.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("AnimationFrames", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 153, -1, "AnimationFrames");
        }
        var result = new Particle(
            v0,
            hasFrameSize(mem, offset) ? Size.toObject(mem, offset + 1) : null,
            ParticleUVOption.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 9)),
            ParticleScaleRatioConstraint.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 10)),
            SoftParticle.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 11)),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "SoftParticlesFadeFactor"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "CameraNearFadeStartDistance"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "CameraNearFadeEndDistance"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 24), "CameraFarFadeStartDistance"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 28), "CameraFarFadeEndDistance"),
            mem.get(PacketIO.PROTO_BOOL, offset + 32),
            hasInitialAnimationFrame(mem, offset) ? ParticleAnimationFrame.toObject(mem, offset + 33) : null,
            hasCollisionAnimationFrame(mem, offset) ? ParticleAnimationFrame.toObject(mem, offset + 91) : null,
            v13
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.frameSize != null) nullBits |= 0x01;
        if (this.initialAnimationFrame != null) nullBits |= 0x02;
        if (this.collisionAnimationFrame != null) nullBits |= 0x04;
        if (this.texturePath != null) nullBits |= 0x08;
        if (this.animationFrames != null) nullBits |= 0x10;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.frameSize != null) {
            this.frameSize.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 8).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BYTE, offset + 9, (byte) this.uvOption.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 10, (byte) this.scaleRatioConstraint.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 11, (byte) this.softParticles.getValue());
        PacketIO.requireFinite(this.softParticlesFadeFactor, "SoftParticlesFadeFactor"); mem.set(PacketIO.PROTO_FLOAT, offset + 12, this.softParticlesFadeFactor);
        PacketIO.requireFinite(this.cameraNearFadeStartDistance, "CameraNearFadeStartDistance"); mem.set(PacketIO.PROTO_FLOAT, offset + 16, this.cameraNearFadeStartDistance);
        PacketIO.requireFinite(this.cameraNearFadeEndDistance, "CameraNearFadeEndDistance"); mem.set(PacketIO.PROTO_FLOAT, offset + 20, this.cameraNearFadeEndDistance);
        PacketIO.requireFinite(this.cameraFarFadeStartDistance, "CameraFarFadeStartDistance"); mem.set(PacketIO.PROTO_FLOAT, offset + 24, this.cameraFarFadeStartDistance);
        PacketIO.requireFinite(this.cameraFarFadeEndDistance, "CameraFarFadeEndDistance"); mem.set(PacketIO.PROTO_FLOAT, offset + 28, this.cameraFarFadeEndDistance);
        mem.set(PacketIO.PROTO_BOOL, offset + 32, this.useSpriteBlending);
        if (this.initialAnimationFrame != null) {
            this.initialAnimationFrame.serialize(mem, offset + 33);
        } else {
            mem.asSlice(offset + 33, 58).fill((byte) 0); 
        }
        if (this.collisionAnimationFrame != null) {
            this.collisionAnimationFrame.serialize(mem, offset + 91);
        } else {
            mem.asSlice(offset + 91, 58).fill((byte) 0); 
        }
        var varOffset = offset + 157;
        if (this.texturePath != null) {
            mem.set(PacketIO.PROTO_INT, offset + 149, varOffset - offset - 157);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.texturePath, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 149, -1);
        }
        if (this.animationFrames != null) {
            mem.set(PacketIO.PROTO_INT, offset + 153, varOffset - offset - 157);
            if (this.animationFrames.size() > 4096000) throw ProtocolException.dictionaryTooLarge("AnimationFrames", animationFrames.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.animationFrames.size());
            for (var e : this.animationFrames.entrySet()) {
                mem.set(PacketIO.PROTO_INT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 153, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 157;
        if (texturePath != null) size += PacketIO.stringSize(texturePath);
    if (animationFrames != null) size += VarInt.size(animationFrames.size()) + animationFrames.size() * (4 + 58);

        return size;
    }

    public Particle clone() {
        Particle copy = new Particle();
        copy.texturePath = this.texturePath;
        copy.frameSize = this.frameSize != null ? this.frameSize.clone() : null;
        copy.uvOption = this.uvOption;
        copy.scaleRatioConstraint = this.scaleRatioConstraint;
        copy.softParticles = this.softParticles;
        copy.softParticlesFadeFactor = this.softParticlesFadeFactor;
        copy.cameraNearFadeStartDistance = this.cameraNearFadeStartDistance;
        copy.cameraNearFadeEndDistance = this.cameraNearFadeEndDistance;
        copy.cameraFarFadeStartDistance = this.cameraFarFadeStartDistance;
        copy.cameraFarFadeEndDistance = this.cameraFarFadeEndDistance;
        copy.useSpriteBlending = this.useSpriteBlending;
        copy.initialAnimationFrame = this.initialAnimationFrame != null ? this.initialAnimationFrame.clone() : null;
        copy.collisionAnimationFrame = this.collisionAnimationFrame != null ? this.collisionAnimationFrame.clone() : null;
        if (this.animationFrames != null) {
            java.util.Map<Integer, ParticleAnimationFrame> m = new java.util.HashMap<>();
            for (var e : this.animationFrames.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.animationFrames = m;
        }
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Particle other)) return false;
        return java.util.Objects.equals(this.texturePath, other.texturePath) && java.util.Objects.equals(this.frameSize, other.frameSize) && java.util.Objects.equals(this.uvOption, other.uvOption) && java.util.Objects.equals(this.scaleRatioConstraint, other.scaleRatioConstraint) && java.util.Objects.equals(this.softParticles, other.softParticles) && this.softParticlesFadeFactor == other.softParticlesFadeFactor && this.cameraNearFadeStartDistance == other.cameraNearFadeStartDistance && this.cameraNearFadeEndDistance == other.cameraNearFadeEndDistance && this.cameraFarFadeStartDistance == other.cameraFarFadeStartDistance && this.cameraFarFadeEndDistance == other.cameraFarFadeEndDistance && this.useSpriteBlending == other.useSpriteBlending && java.util.Objects.equals(this.initialAnimationFrame, other.initialAnimationFrame) && java.util.Objects.equals(this.collisionAnimationFrame, other.collisionAnimationFrame) && java.util.Objects.equals(this.animationFrames, other.animationFrames);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(texturePath, frameSize, uvOption, scaleRatioConstraint, softParticles, softParticlesFadeFactor, cameraNearFadeStartDistance, cameraNearFadeEndDistance, cameraFarFadeStartDistance, cameraFarFadeEndDistance, useSpriteBlending, initialAnimationFrame, collisionAnimationFrame, animationFrames);
    }

}