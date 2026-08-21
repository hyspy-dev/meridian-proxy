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


public class ParticleSpawner {
    public static final int NULLABLE_BIT_FIELD_SIZE = 2;
    public static final int FIXED_BLOCK_SIZE = 130;
    public static final int VARIABLE_FIELD_COUNT = 4;
    public static final int VARIABLE_BLOCK_START = 146;
    public static final int MAX_SIZE = 651264347;

    @Nullable public String id;
    @Nullable public Particle particle;
    @Nonnull public EmitShape shape = EmitShape.Sphere;
    @Nullable public RangeVector3f emitOffset;
    public float cameraOffset;
    public boolean useEmitDirection;
    public float lifeSpan;
    @Nullable public Rangef spawnRate;
    public boolean spawnBurst;
    @Nullable public Rangef waveDelay;
    @Nullable public Range totalParticles;
    public int maxConcurrentParticles;
    @Nullable public InitialVelocity initialVelocity;
    public float velocityStretchMultiplier;
    @Nonnull public ParticleRotationInfluence particleRotationInfluence = ParticleRotationInfluence.None;
    public boolean particleRotateWithSpawner;
    public boolean isLowRes;
    public float trailSpawnerPositionMultiplier;
    public float trailSpawnerRotationMultiplier;
    @Nullable public ParticleCollision particleCollision;
    @Nonnull public FXRenderMode renderMode = FXRenderMode.BlendLinear;
    public float lightInfluence;
    public boolean linearFiltering;
    @Nullable public Rangef particleLifeSpan;
    @Nullable public UVMotion uvMotion;
    @Nullable public ParticleAttractor[] attractors;
    @Nullable public IntersectionHighlight intersectionHighlight;

    public ParticleSpawner() {
    }

    public ParticleSpawner(@Nullable String id, @Nullable Particle particle, @Nonnull EmitShape shape, @Nullable RangeVector3f emitOffset, float cameraOffset, boolean useEmitDirection, float lifeSpan, @Nullable Rangef spawnRate, boolean spawnBurst, @Nullable Rangef waveDelay, @Nullable Range totalParticles, int maxConcurrentParticles, @Nullable InitialVelocity initialVelocity, float velocityStretchMultiplier, @Nonnull ParticleRotationInfluence particleRotationInfluence, boolean particleRotateWithSpawner, boolean isLowRes, float trailSpawnerPositionMultiplier, float trailSpawnerRotationMultiplier, @Nullable ParticleCollision particleCollision, @Nonnull FXRenderMode renderMode, float lightInfluence, boolean linearFiltering, @Nullable Rangef particleLifeSpan, @Nullable UVMotion uvMotion, @Nullable ParticleAttractor[] attractors, @Nullable IntersectionHighlight intersectionHighlight) {
        this.id = id;
        this.particle = particle;
        this.shape = shape;
        this.emitOffset = emitOffset;
        this.cameraOffset = cameraOffset;
        this.useEmitDirection = useEmitDirection;
        this.lifeSpan = lifeSpan;
        this.spawnRate = spawnRate;
        this.spawnBurst = spawnBurst;
        this.waveDelay = waveDelay;
        this.totalParticles = totalParticles;
        this.maxConcurrentParticles = maxConcurrentParticles;
        this.initialVelocity = initialVelocity;
        this.velocityStretchMultiplier = velocityStretchMultiplier;
        this.particleRotationInfluence = particleRotationInfluence;
        this.particleRotateWithSpawner = particleRotateWithSpawner;
        this.isLowRes = isLowRes;
        this.trailSpawnerPositionMultiplier = trailSpawnerPositionMultiplier;
        this.trailSpawnerRotationMultiplier = trailSpawnerRotationMultiplier;
        this.particleCollision = particleCollision;
        this.renderMode = renderMode;
        this.lightInfluence = lightInfluence;
        this.linearFiltering = linearFiltering;
        this.particleLifeSpan = particleLifeSpan;
        this.uvMotion = uvMotion;
        this.attractors = attractors;
        this.intersectionHighlight = intersectionHighlight;
    }

    public ParticleSpawner(@Nonnull ParticleSpawner other) {
        this.id = other.id;
        this.particle = other.particle;
        this.shape = other.shape;
        this.emitOffset = other.emitOffset;
        this.cameraOffset = other.cameraOffset;
        this.useEmitDirection = other.useEmitDirection;
        this.lifeSpan = other.lifeSpan;
        this.spawnRate = other.spawnRate;
        this.spawnBurst = other.spawnBurst;
        this.waveDelay = other.waveDelay;
        this.totalParticles = other.totalParticles;
        this.maxConcurrentParticles = other.maxConcurrentParticles;
        this.initialVelocity = other.initialVelocity;
        this.velocityStretchMultiplier = other.velocityStretchMultiplier;
        this.particleRotationInfluence = other.particleRotationInfluence;
        this.particleRotateWithSpawner = other.particleRotateWithSpawner;
        this.isLowRes = other.isLowRes;
        this.trailSpawnerPositionMultiplier = other.trailSpawnerPositionMultiplier;
        this.trailSpawnerRotationMultiplier = other.trailSpawnerRotationMultiplier;
        this.particleCollision = other.particleCollision;
        this.renderMode = other.renderMode;
        this.lightInfluence = other.lightInfluence;
        this.linearFiltering = other.linearFiltering;
        this.particleLifeSpan = other.particleLifeSpan;
        this.uvMotion = other.uvMotion;
        this.attractors = other.attractors;
        this.intersectionHighlight = other.intersectionHighlight;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ParticleSpawner", offset, (int) mem.byteSize());
        long needed = (long) offset + 146;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ParticleSpawner", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 130, 146, "Id"), 4096000): null;
    }
    
    @Nullable
    public static Particle getParticle(MemorySegment mem) {
        return getParticle(mem, 0);
    }
    
    @Nullable
    public static Particle getParticle(MemorySegment mem, int offset) {
        return hasParticle(mem, offset) ? Particle.toObject(mem, offset + getValidatedOffset(mem, offset, 134, 146, "Particle")): null;
    }
    
    public static EmitShape getShape(MemorySegment mem) {
        return getShape(mem, 0);
    }
    
    public static EmitShape getShape(MemorySegment mem, int offset) {
        return EmitShape.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2));
    }
    
    @Nullable
    public static RangeVector3f getEmitOffset(MemorySegment mem) {
        return getEmitOffset(mem, 0);
    }
    
    @Nullable
    public static RangeVector3f getEmitOffset(MemorySegment mem, int offset) {
        return hasEmitOffset(mem, offset) ? RangeVector3f.toObject(mem, offset + 3): null;
    }
    
    public static float getCameraOffset(MemorySegment mem) {
        return getCameraOffset(mem, 0);
    }
    
    public static float getCameraOffset(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 28), "CameraOffset");
    }
    
    public static boolean getUseEmitDirection(MemorySegment mem) {
        return getUseEmitDirection(mem, 0);
    }
    
    public static boolean getUseEmitDirection(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 32);
    }
    
    public static float getLifeSpan(MemorySegment mem) {
        return getLifeSpan(mem, 0);
    }
    
    public static float getLifeSpan(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 33), "LifeSpan");
    }
    
    @Nullable
    public static Rangef getSpawnRate(MemorySegment mem) {
        return getSpawnRate(mem, 0);
    }
    
    @Nullable
    public static Rangef getSpawnRate(MemorySegment mem, int offset) {
        return hasSpawnRate(mem, offset) ? Rangef.toObject(mem, offset + 37): null;
    }
    
    public static boolean getSpawnBurst(MemorySegment mem) {
        return getSpawnBurst(mem, 0);
    }
    
    public static boolean getSpawnBurst(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 45);
    }
    
    @Nullable
    public static Rangef getWaveDelay(MemorySegment mem) {
        return getWaveDelay(mem, 0);
    }
    
    @Nullable
    public static Rangef getWaveDelay(MemorySegment mem, int offset) {
        return hasWaveDelay(mem, offset) ? Rangef.toObject(mem, offset + 46): null;
    }
    
    @Nullable
    public static Range getTotalParticles(MemorySegment mem) {
        return getTotalParticles(mem, 0);
    }
    
    @Nullable
    public static Range getTotalParticles(MemorySegment mem, int offset) {
        return hasTotalParticles(mem, offset) ? Range.toObject(mem, offset + 54): null;
    }
    
    public static int getMaxConcurrentParticles(MemorySegment mem) {
        return getMaxConcurrentParticles(mem, 0);
    }
    
    public static int getMaxConcurrentParticles(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 62);
    }
    
    @Nullable
    public static InitialVelocity getInitialVelocity(MemorySegment mem) {
        return getInitialVelocity(mem, 0);
    }
    
    @Nullable
    public static InitialVelocity getInitialVelocity(MemorySegment mem, int offset) {
        return hasInitialVelocity(mem, offset) ? InitialVelocity.toObject(mem, offset + 66): null;
    }
    
    public static float getVelocityStretchMultiplier(MemorySegment mem) {
        return getVelocityStretchMultiplier(mem, 0);
    }
    
    public static float getVelocityStretchMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 91), "VelocityStretchMultiplier");
    }
    
    public static ParticleRotationInfluence getParticleRotationInfluence(MemorySegment mem) {
        return getParticleRotationInfluence(mem, 0);
    }
    
    public static ParticleRotationInfluence getParticleRotationInfluence(MemorySegment mem, int offset) {
        return ParticleRotationInfluence.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 95));
    }
    
    public static boolean getParticleRotateWithSpawner(MemorySegment mem) {
        return getParticleRotateWithSpawner(mem, 0);
    }
    
    public static boolean getParticleRotateWithSpawner(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 96) & 0x01) != 0;
    }
    
    public static boolean getIsLowRes(MemorySegment mem) {
        return getIsLowRes(mem, 0);
    }
    
    public static boolean getIsLowRes(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 96) & 0x02) != 0;
    }
    
    public static float getTrailSpawnerPositionMultiplier(MemorySegment mem) {
        return getTrailSpawnerPositionMultiplier(mem, 0);
    }
    
    public static float getTrailSpawnerPositionMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 97), "TrailSpawnerPositionMultiplier");
    }
    
    public static float getTrailSpawnerRotationMultiplier(MemorySegment mem) {
        return getTrailSpawnerRotationMultiplier(mem, 0);
    }
    
    public static float getTrailSpawnerRotationMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 101), "TrailSpawnerRotationMultiplier");
    }
    
    @Nullable
    public static ParticleCollision getParticleCollision(MemorySegment mem) {
        return getParticleCollision(mem, 0);
    }
    
    @Nullable
    public static ParticleCollision getParticleCollision(MemorySegment mem, int offset) {
        return hasParticleCollision(mem, offset) ? ParticleCollision.toObject(mem, offset + 105): null;
    }
    
    public static FXRenderMode getRenderMode(MemorySegment mem) {
        return getRenderMode(mem, 0);
    }
    
    public static FXRenderMode getRenderMode(MemorySegment mem, int offset) {
        return FXRenderMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 108));
    }
    
    public static float getLightInfluence(MemorySegment mem) {
        return getLightInfluence(mem, 0);
    }
    
    public static float getLightInfluence(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 109), "LightInfluence");
    }
    
    public static boolean getLinearFiltering(MemorySegment mem) {
        return getLinearFiltering(mem, 0);
    }
    
    public static boolean getLinearFiltering(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 113);
    }
    
    @Nullable
    public static Rangef getParticleLifeSpan(MemorySegment mem) {
        return getParticleLifeSpan(mem, 0);
    }
    
    @Nullable
    public static Rangef getParticleLifeSpan(MemorySegment mem, int offset) {
        return hasParticleLifeSpan(mem, offset) ? Rangef.toObject(mem, offset + 114): null;
    }
    
    @Nullable
    public static UVMotion getUvMotion(MemorySegment mem) {
        return getUvMotion(mem, 0);
    }
    
    @Nullable
    public static UVMotion getUvMotion(MemorySegment mem, int offset) {
        return hasUvMotion(mem, offset) ? UVMotion.toObject(mem, offset + getValidatedOffset(mem, offset, 138, 146, "UvMotion")): null;
    }
    
    @Nullable
    public static ParticleAttractor[] getAttractors(MemorySegment mem) {
        return getAttractors(mem, 0);
    }
    
    @Nullable
    public static ParticleAttractor[] getAttractors(MemorySegment mem, int offset) {
        if (!hasAttractors(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 142, 146, "Attractors");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Attractors");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Attractors", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 85 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Attractors", (int) java.lang.Math.min(off + lenOffset + (long) len * 85, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ParticleAttractor[len];
        for (var i = 0; i < len; i++) {
            data[i] = ParticleAttractor.toObject(mem, off + i * 85);
        }
        return data;
    }
    
    @Nullable
    public static IntersectionHighlight getIntersectionHighlight(MemorySegment mem) {
        return getIntersectionHighlight(mem, 0);
    }
    
    @Nullable
    public static IntersectionHighlight getIntersectionHighlight(MemorySegment mem, int offset) {
        return hasIntersectionHighlight(mem, offset) ? IntersectionHighlight.toObject(mem, offset + 122): null;
    }
    
    public static boolean hasEmitOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasSpawnRate(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasWaveDelay(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasTotalParticles(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasInitialVelocity(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasParticleCollision(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasParticleLifeSpan(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasIntersectionHighlight(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasParticle(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasUvMotion(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasAttractors(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
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
    
    public static ParticleSpawner toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ParticleSpawner toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ParticleSpawner and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ParticleSpawner toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 146;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 130, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 130, -1, "Id");
        }
        
        Particle v1 = null;
        if (hasParticle(mem, offset)) {
            requireSlot(mem, offset + 134, varPos, "Particle");
            v1 = Particle.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 134, -1, "Particle");
        }
        
        UVMotion v24 = null;
        if (hasUvMotion(mem, offset)) {
            requireSlot(mem, offset + 138, varPos, "UvMotion");
            v24 = UVMotion.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 138, -1, "UvMotion");
        }
        
        ParticleAttractor[] v25 = null;
        if (hasAttractors(mem, offset)) {
            requireSlot(mem, offset + 142, varPos, "Attractors");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Attractors");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Attractors", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 85 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Attractors", (int) java.lang.Math.min(off + lenOffset + (long) len * 85, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v25 = new ParticleAttractor[len];
            for (var i = 0; i < len; i++) {
                v25[i] = ParticleAttractor.toObject(mem, off + i * 85);
            }
            varPos = off + len * 85 - varBase;
        } else {
            requireSlot(mem, offset + 142, -1, "Attractors");
        }
        var result = new ParticleSpawner(
            v0,
            v1,
            EmitShape.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2)),
            hasEmitOffset(mem, offset) ? RangeVector3f.toObject(mem, offset + 3) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 28), "CameraOffset"),
            mem.get(PacketIO.PROTO_BOOL, offset + 32),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 33), "LifeSpan"),
            hasSpawnRate(mem, offset) ? Rangef.toObject(mem, offset + 37) : null,
            mem.get(PacketIO.PROTO_BOOL, offset + 45),
            hasWaveDelay(mem, offset) ? Rangef.toObject(mem, offset + 46) : null,
            hasTotalParticles(mem, offset) ? Range.toObject(mem, offset + 54) : null,
            mem.get(PacketIO.PROTO_INT, offset + 62),
            hasInitialVelocity(mem, offset) ? InitialVelocity.toObject(mem, offset + 66) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 91), "VelocityStretchMultiplier"),
            ParticleRotationInfluence.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 95)),
            (mem.get(PacketIO.PROTO_BYTE, offset + 96) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 96) & 0x02) != 0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 97), "TrailSpawnerPositionMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 101), "TrailSpawnerRotationMultiplier"),
            hasParticleCollision(mem, offset) ? ParticleCollision.toObject(mem, offset + 105) : null,
            FXRenderMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 108)),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 109), "LightInfluence"),
            mem.get(PacketIO.PROTO_BOOL, offset + 113),
            hasParticleLifeSpan(mem, offset) ? Rangef.toObject(mem, offset + 114) : null,
            v24,
            v25,
            hasIntersectionHighlight(mem, offset) ? IntersectionHighlight.toObject(mem, offset + 122) : null
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.emitOffset != null) nullBits |= 0x01;
        if (this.spawnRate != null) nullBits |= 0x02;
        if (this.waveDelay != null) nullBits |= 0x04;
        if (this.totalParticles != null) nullBits |= 0x08;
        if (this.initialVelocity != null) nullBits |= 0x10;
        if (this.particleCollision != null) nullBits |= 0x20;
        if (this.particleLifeSpan != null) nullBits |= 0x40;
        if (this.intersectionHighlight != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        if (this.particle != null) nullBits |= 0x02;
        if (this.uvMotion != null) nullBits |= 0x04;
        if (this.attractors != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 1, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 2, (byte) this.shape.getValue());
        if (this.emitOffset != null) {
            this.emitOffset.serialize(mem, offset + 3);
        } else {
            mem.asSlice(offset + 3, 25).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.cameraOffset, "CameraOffset"); mem.set(PacketIO.PROTO_FLOAT, offset + 28, this.cameraOffset);
        mem.set(PacketIO.PROTO_BOOL, offset + 32, this.useEmitDirection);
        PacketIO.requireFinite(this.lifeSpan, "LifeSpan"); mem.set(PacketIO.PROTO_FLOAT, offset + 33, this.lifeSpan);
        if (this.spawnRate != null) {
            this.spawnRate.serialize(mem, offset + 37);
        } else {
            mem.asSlice(offset + 37, 8).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BOOL, offset + 45, this.spawnBurst);
        if (this.waveDelay != null) {
            this.waveDelay.serialize(mem, offset + 46);
        } else {
            mem.asSlice(offset + 46, 8).fill((byte) 0); 
        }
        if (this.totalParticles != null) {
            this.totalParticles.serialize(mem, offset + 54);
        } else {
            mem.asSlice(offset + 54, 8).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_INT, offset + 62, this.maxConcurrentParticles);
        if (this.initialVelocity != null) {
            this.initialVelocity.serialize(mem, offset + 66);
        } else {
            mem.asSlice(offset + 66, 25).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.velocityStretchMultiplier, "VelocityStretchMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 91, this.velocityStretchMultiplier);
        mem.set(PacketIO.PROTO_BYTE, offset + 95, (byte) this.particleRotationInfluence.getValue());
        byte boolBits0_0 = 0;
        if (this.particleRotateWithSpawner) boolBits0_0 |= 0x01;
        if (this.isLowRes) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 96 + 0, boolBits0_0);
        PacketIO.requireFinite(this.trailSpawnerPositionMultiplier, "TrailSpawnerPositionMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 97, this.trailSpawnerPositionMultiplier);
        PacketIO.requireFinite(this.trailSpawnerRotationMultiplier, "TrailSpawnerRotationMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 101, this.trailSpawnerRotationMultiplier);
        if (this.particleCollision != null) {
            this.particleCollision.serialize(mem, offset + 105);
        } else {
            mem.asSlice(offset + 105, 3).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BYTE, offset + 108, (byte) this.renderMode.getValue());
        PacketIO.requireFinite(this.lightInfluence, "LightInfluence"); mem.set(PacketIO.PROTO_FLOAT, offset + 109, this.lightInfluence);
        mem.set(PacketIO.PROTO_BOOL, offset + 113, this.linearFiltering);
        if (this.particleLifeSpan != null) {
            this.particleLifeSpan.serialize(mem, offset + 114);
        } else {
            mem.asSlice(offset + 114, 8).fill((byte) 0); 
        }
        if (this.intersectionHighlight != null) {
            this.intersectionHighlight.serialize(mem, offset + 122);
        } else {
            mem.asSlice(offset + 122, 8).fill((byte) 0); 
        }
        var varOffset = offset + 146;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 130, varOffset - offset - 146);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 130, -1);
        }
        if (this.particle != null) {
            mem.set(PacketIO.PROTO_INT, offset + 134, varOffset - offset - 146);
            varOffset += this.particle.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 134, -1);
        }
        if (this.uvMotion != null) {
            mem.set(PacketIO.PROTO_INT, offset + 138, varOffset - offset - 146);
            varOffset += this.uvMotion.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 138, -1);
        }
        if (this.attractors != null) {
            mem.set(PacketIO.PROTO_INT, offset + 142, varOffset - offset - 146);
            if (attractors.length > 4096000) throw ProtocolException.arrayTooLong("Attractors", attractors.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.attractors.length);
            
            var attractorsValueOffset = 0;
            for (var i = 0; i < this.attractors.length; i++) {
                attractorsValueOffset += this.attractors[i].serialize(mem, varOffset + attractorsValueOffset);
            }
            varOffset += attractorsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 142, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 146;
        if (id != null) size += PacketIO.stringSize(id);
    if (particle != null) size += particle.computeSize();
    if (uvMotion != null) size += uvMotion.computeSize();
    if (attractors != null) size += VarInt.size(attractors.length) + attractors.length * 85;

        return size;
    }

    public ParticleSpawner clone() {
        ParticleSpawner copy = new ParticleSpawner();
        copy.id = this.id;
        copy.particle = this.particle != null ? this.particle.clone() : null;
        copy.shape = this.shape;
        copy.emitOffset = this.emitOffset != null ? this.emitOffset.clone() : null;
        copy.cameraOffset = this.cameraOffset;
        copy.useEmitDirection = this.useEmitDirection;
        copy.lifeSpan = this.lifeSpan;
        copy.spawnRate = this.spawnRate != null ? this.spawnRate.clone() : null;
        copy.spawnBurst = this.spawnBurst;
        copy.waveDelay = this.waveDelay != null ? this.waveDelay.clone() : null;
        copy.totalParticles = this.totalParticles != null ? this.totalParticles.clone() : null;
        copy.maxConcurrentParticles = this.maxConcurrentParticles;
        copy.initialVelocity = this.initialVelocity != null ? this.initialVelocity.clone() : null;
        copy.velocityStretchMultiplier = this.velocityStretchMultiplier;
        copy.particleRotationInfluence = this.particleRotationInfluence;
        copy.particleRotateWithSpawner = this.particleRotateWithSpawner;
        copy.isLowRes = this.isLowRes;
        copy.trailSpawnerPositionMultiplier = this.trailSpawnerPositionMultiplier;
        copy.trailSpawnerRotationMultiplier = this.trailSpawnerRotationMultiplier;
        copy.particleCollision = this.particleCollision != null ? this.particleCollision.clone() : null;
        copy.renderMode = this.renderMode;
        copy.lightInfluence = this.lightInfluence;
        copy.linearFiltering = this.linearFiltering;
        copy.particleLifeSpan = this.particleLifeSpan != null ? this.particleLifeSpan.clone() : null;
        copy.uvMotion = this.uvMotion != null ? this.uvMotion.clone() : null;
        copy.attractors = this.attractors != null ? java.util.Arrays.stream(this.attractors).map(e -> e.clone()).toArray(ParticleAttractor[]::new) : null;
        copy.intersectionHighlight = this.intersectionHighlight != null ? this.intersectionHighlight.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ParticleSpawner other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.particle, other.particle) && java.util.Objects.equals(this.shape, other.shape) && java.util.Objects.equals(this.emitOffset, other.emitOffset) && this.cameraOffset == other.cameraOffset && this.useEmitDirection == other.useEmitDirection && this.lifeSpan == other.lifeSpan && java.util.Objects.equals(this.spawnRate, other.spawnRate) && this.spawnBurst == other.spawnBurst && java.util.Objects.equals(this.waveDelay, other.waveDelay) && java.util.Objects.equals(this.totalParticles, other.totalParticles) && this.maxConcurrentParticles == other.maxConcurrentParticles && java.util.Objects.equals(this.initialVelocity, other.initialVelocity) && this.velocityStretchMultiplier == other.velocityStretchMultiplier && java.util.Objects.equals(this.particleRotationInfluence, other.particleRotationInfluence) && this.particleRotateWithSpawner == other.particleRotateWithSpawner && this.isLowRes == other.isLowRes && this.trailSpawnerPositionMultiplier == other.trailSpawnerPositionMultiplier && this.trailSpawnerRotationMultiplier == other.trailSpawnerRotationMultiplier && java.util.Objects.equals(this.particleCollision, other.particleCollision) && java.util.Objects.equals(this.renderMode, other.renderMode) && this.lightInfluence == other.lightInfluence && this.linearFiltering == other.linearFiltering && java.util.Objects.equals(this.particleLifeSpan, other.particleLifeSpan) && java.util.Objects.equals(this.uvMotion, other.uvMotion) && java.util.Arrays.equals(this.attractors, other.attractors) && java.util.Objects.equals(this.intersectionHighlight, other.intersectionHighlight);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(id);
        result = 31 * result + java.util.Objects.hashCode(particle);
        result = 31 * result + java.util.Objects.hashCode(shape);
        result = 31 * result + java.util.Objects.hashCode(emitOffset);
        result = 31 * result + Float.hashCode(cameraOffset);
        result = 31 * result + Boolean.hashCode(useEmitDirection);
        result = 31 * result + Float.hashCode(lifeSpan);
        result = 31 * result + java.util.Objects.hashCode(spawnRate);
        result = 31 * result + Boolean.hashCode(spawnBurst);
        result = 31 * result + java.util.Objects.hashCode(waveDelay);
        result = 31 * result + java.util.Objects.hashCode(totalParticles);
        result = 31 * result + Integer.hashCode(maxConcurrentParticles);
        result = 31 * result + java.util.Objects.hashCode(initialVelocity);
        result = 31 * result + Float.hashCode(velocityStretchMultiplier);
        result = 31 * result + java.util.Objects.hashCode(particleRotationInfluence);
        result = 31 * result + Boolean.hashCode(particleRotateWithSpawner);
        result = 31 * result + Boolean.hashCode(isLowRes);
        result = 31 * result + Float.hashCode(trailSpawnerPositionMultiplier);
        result = 31 * result + Float.hashCode(trailSpawnerRotationMultiplier);
        result = 31 * result + java.util.Objects.hashCode(particleCollision);
        result = 31 * result + java.util.Objects.hashCode(renderMode);
        result = 31 * result + Float.hashCode(lightInfluence);
        result = 31 * result + Boolean.hashCode(linearFiltering);
        result = 31 * result + java.util.Objects.hashCode(particleLifeSpan);
        result = 31 * result + java.util.Objects.hashCode(uvMotion);
        result = 31 * result + java.util.Arrays.hashCode(attractors);
        result = 31 * result + java.util.Objects.hashCode(intersectionHighlight);
        return result;
    }

}