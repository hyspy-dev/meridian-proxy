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
import org.joml.*;

public class ParticleSpawnerGroup {
    public static final int NULLABLE_BIT_FIELD_SIZE = 2;
    public static final int FIXED_BLOCK_SIZE = 113;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 121;
    public static final int MAX_SIZE = 364544131;

    @Nullable public String spawnerId;
    @Nullable public Vector3fc positionOffset;
    @Nullable public Direction rotationOffset;
    public boolean fixedRotation;
    public float startDelay;
    @Nullable public Rangef spawnRate;
    @Nullable public Rangef waveDelay;
    public int totalSpawners;
    public int maxConcurrent;
    @Nullable public InitialVelocity initialVelocity;
    @Nullable public RangeVector3f emitOffset;
    @Nullable public Rangef lifeSpan;
    @Nullable public ParticleAttractor[] attractors;

    public ParticleSpawnerGroup() {
    }

    public ParticleSpawnerGroup(@Nullable String spawnerId, @Nullable Vector3fc positionOffset, @Nullable Direction rotationOffset, boolean fixedRotation, float startDelay, @Nullable Rangef spawnRate, @Nullable Rangef waveDelay, int totalSpawners, int maxConcurrent, @Nullable InitialVelocity initialVelocity, @Nullable RangeVector3f emitOffset, @Nullable Rangef lifeSpan, @Nullable ParticleAttractor[] attractors) {
        this.spawnerId = spawnerId;
        this.positionOffset = positionOffset;
        this.rotationOffset = rotationOffset;
        this.fixedRotation = fixedRotation;
        this.startDelay = startDelay;
        this.spawnRate = spawnRate;
        this.waveDelay = waveDelay;
        this.totalSpawners = totalSpawners;
        this.maxConcurrent = maxConcurrent;
        this.initialVelocity = initialVelocity;
        this.emitOffset = emitOffset;
        this.lifeSpan = lifeSpan;
        this.attractors = attractors;
    }

    public ParticleSpawnerGroup(@Nonnull ParticleSpawnerGroup other) {
        this.spawnerId = other.spawnerId;
        this.positionOffset = other.positionOffset;
        this.rotationOffset = other.rotationOffset;
        this.fixedRotation = other.fixedRotation;
        this.startDelay = other.startDelay;
        this.spawnRate = other.spawnRate;
        this.waveDelay = other.waveDelay;
        this.totalSpawners = other.totalSpawners;
        this.maxConcurrent = other.maxConcurrent;
        this.initialVelocity = other.initialVelocity;
        this.emitOffset = other.emitOffset;
        this.lifeSpan = other.lifeSpan;
        this.attractors = other.attractors;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ParticleSpawnerGroup", offset, (int) mem.byteSize());
        long needed = (long) offset + 121;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ParticleSpawnerGroup", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getSpawnerId(MemorySegment mem) {
        return getSpawnerId(mem, 0);
    }
    
    @Nullable
    public static String getSpawnerId(MemorySegment mem, int offset) {
        return hasSpawnerId(mem, offset) ? PacketIO.readVarString("SpawnerId", mem, offset + getValidatedOffset(mem, offset, 113, 121, "SpawnerId"), 4096000): null;
    }
    
    @Nullable
    public static Vector3fc getPositionOffset(MemorySegment mem) {
        return getPositionOffset(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getPositionOffset(MemorySegment mem, int offset) {
        return hasPositionOffset(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 2), "PositionOffset"): null;
    }
    
    @Nullable
    public static Direction getRotationOffset(MemorySegment mem) {
        return getRotationOffset(mem, 0);
    }
    
    @Nullable
    public static Direction getRotationOffset(MemorySegment mem, int offset) {
        return hasRotationOffset(mem, offset) ? Direction.toObject(mem, offset + 14): null;
    }
    
    public static boolean getFixedRotation(MemorySegment mem) {
        return getFixedRotation(mem, 0);
    }
    
    public static boolean getFixedRotation(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 26);
    }
    
    public static float getStartDelay(MemorySegment mem) {
        return getStartDelay(mem, 0);
    }
    
    public static float getStartDelay(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 27), "StartDelay");
    }
    
    @Nullable
    public static Rangef getSpawnRate(MemorySegment mem) {
        return getSpawnRate(mem, 0);
    }
    
    @Nullable
    public static Rangef getSpawnRate(MemorySegment mem, int offset) {
        return hasSpawnRate(mem, offset) ? Rangef.toObject(mem, offset + 31): null;
    }
    
    @Nullable
    public static Rangef getWaveDelay(MemorySegment mem) {
        return getWaveDelay(mem, 0);
    }
    
    @Nullable
    public static Rangef getWaveDelay(MemorySegment mem, int offset) {
        return hasWaveDelay(mem, offset) ? Rangef.toObject(mem, offset + 39): null;
    }
    
    public static int getTotalSpawners(MemorySegment mem) {
        return getTotalSpawners(mem, 0);
    }
    
    public static int getTotalSpawners(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 47);
    }
    
    public static int getMaxConcurrent(MemorySegment mem) {
        return getMaxConcurrent(mem, 0);
    }
    
    public static int getMaxConcurrent(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 51);
    }
    
    @Nullable
    public static InitialVelocity getInitialVelocity(MemorySegment mem) {
        return getInitialVelocity(mem, 0);
    }
    
    @Nullable
    public static InitialVelocity getInitialVelocity(MemorySegment mem, int offset) {
        return hasInitialVelocity(mem, offset) ? InitialVelocity.toObject(mem, offset + 55): null;
    }
    
    @Nullable
    public static RangeVector3f getEmitOffset(MemorySegment mem) {
        return getEmitOffset(mem, 0);
    }
    
    @Nullable
    public static RangeVector3f getEmitOffset(MemorySegment mem, int offset) {
        return hasEmitOffset(mem, offset) ? RangeVector3f.toObject(mem, offset + 80): null;
    }
    
    @Nullable
    public static Rangef getLifeSpan(MemorySegment mem) {
        return getLifeSpan(mem, 0);
    }
    
    @Nullable
    public static Rangef getLifeSpan(MemorySegment mem, int offset) {
        return hasLifeSpan(mem, offset) ? Rangef.toObject(mem, offset + 105): null;
    }
    
    @Nullable
    public static ParticleAttractor[] getAttractors(MemorySegment mem) {
        return getAttractors(mem, 0);
    }
    
    @Nullable
    public static ParticleAttractor[] getAttractors(MemorySegment mem, int offset) {
        if (!hasAttractors(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 117, 121, "Attractors");
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
    
    public static boolean hasPositionOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasRotationOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasSpawnRate(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasWaveDelay(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasInitialVelocity(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasEmitOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasLifeSpan(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasSpawnerId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasAttractors(MemorySegment mem, int offset) {
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
    
    public static ParticleSpawnerGroup toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ParticleSpawnerGroup toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ParticleSpawnerGroup and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ParticleSpawnerGroup toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 121;
        var varPos = 0;
        String v0 = null;
        if (hasSpawnerId(mem, offset)) {
            requireSlot(mem, offset + 113, varPos, "SpawnerId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("SpawnerId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 113, -1, "SpawnerId");
        }
        
        ParticleAttractor[] v12 = null;
        if (hasAttractors(mem, offset)) {
            requireSlot(mem, offset + 117, varPos, "Attractors");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Attractors");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Attractors", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 85 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Attractors", (int) java.lang.Math.min(off + lenOffset + (long) len * 85, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v12 = new ParticleAttractor[len];
            for (var i = 0; i < len; i++) {
                v12[i] = ParticleAttractor.toObject(mem, off + i * 85);
            }
            varPos = off + len * 85 - varBase;
        } else {
            requireSlot(mem, offset + 117, -1, "Attractors");
        }
        var result = new ParticleSpawnerGroup(
            v0,
            hasPositionOffset(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 2), "PositionOffset") : null,
            hasRotationOffset(mem, offset) ? Direction.toObject(mem, offset + 14) : null,
            mem.get(PacketIO.PROTO_BOOL, offset + 26),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 27), "StartDelay"),
            hasSpawnRate(mem, offset) ? Rangef.toObject(mem, offset + 31) : null,
            hasWaveDelay(mem, offset) ? Rangef.toObject(mem, offset + 39) : null,
            mem.get(PacketIO.PROTO_INT, offset + 47),
            mem.get(PacketIO.PROTO_INT, offset + 51),
            hasInitialVelocity(mem, offset) ? InitialVelocity.toObject(mem, offset + 55) : null,
            hasEmitOffset(mem, offset) ? RangeVector3f.toObject(mem, offset + 80) : null,
            hasLifeSpan(mem, offset) ? Rangef.toObject(mem, offset + 105) : null,
            v12
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.positionOffset != null) nullBits |= 0x01;
        if (this.rotationOffset != null) nullBits |= 0x02;
        if (this.spawnRate != null) nullBits |= 0x04;
        if (this.waveDelay != null) nullBits |= 0x08;
        if (this.initialVelocity != null) nullBits |= 0x10;
        if (this.emitOffset != null) nullBits |= 0x20;
        if (this.lifeSpan != null) nullBits |= 0x40;
        if (this.spawnerId != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        nullBits = 0;
        if (this.attractors != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 1, nullBits);
        
        if (this.positionOffset != null) {
            PacketIO.requireFinite(this.positionOffset, "PositionOffset"); PacketIO.writeVector3f(mem, offset + 2, this.positionOffset);
        } else {
            mem.asSlice(offset + 2, 12).fill((byte) 0); 
        }
        if (this.rotationOffset != null) {
            this.rotationOffset.serialize(mem, offset + 14);
        } else {
            mem.asSlice(offset + 14, 12).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BOOL, offset + 26, this.fixedRotation);
        PacketIO.requireFinite(this.startDelay, "StartDelay"); mem.set(PacketIO.PROTO_FLOAT, offset + 27, this.startDelay);
        if (this.spawnRate != null) {
            this.spawnRate.serialize(mem, offset + 31);
        } else {
            mem.asSlice(offset + 31, 8).fill((byte) 0); 
        }
        if (this.waveDelay != null) {
            this.waveDelay.serialize(mem, offset + 39);
        } else {
            mem.asSlice(offset + 39, 8).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_INT, offset + 47, this.totalSpawners);
        mem.set(PacketIO.PROTO_INT, offset + 51, this.maxConcurrent);
        if (this.initialVelocity != null) {
            this.initialVelocity.serialize(mem, offset + 55);
        } else {
            mem.asSlice(offset + 55, 25).fill((byte) 0); 
        }
        if (this.emitOffset != null) {
            this.emitOffset.serialize(mem, offset + 80);
        } else {
            mem.asSlice(offset + 80, 25).fill((byte) 0); 
        }
        if (this.lifeSpan != null) {
            this.lifeSpan.serialize(mem, offset + 105);
        } else {
            mem.asSlice(offset + 105, 8).fill((byte) 0); 
        }
        var varOffset = offset + 121;
        if (this.spawnerId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 113, varOffset - offset - 121);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.spawnerId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 113, -1);
        }
        if (this.attractors != null) {
            mem.set(PacketIO.PROTO_INT, offset + 117, varOffset - offset - 121);
            if (attractors.length > 4096000) throw ProtocolException.arrayTooLong("Attractors", attractors.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.attractors.length);
            
            var attractorsValueOffset = 0;
            for (var i = 0; i < this.attractors.length; i++) {
                attractorsValueOffset += this.attractors[i].serialize(mem, varOffset + attractorsValueOffset);
            }
            varOffset += attractorsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 117, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 121;
        if (spawnerId != null) size += PacketIO.stringSize(spawnerId);
    if (attractors != null) size += VarInt.size(attractors.length) + attractors.length * 85;

        return size;
    }

    public ParticleSpawnerGroup clone() {
        ParticleSpawnerGroup copy = new ParticleSpawnerGroup();
        copy.spawnerId = this.spawnerId;
        copy.positionOffset = this.positionOffset;
        copy.rotationOffset = this.rotationOffset != null ? this.rotationOffset.clone() : null;
        copy.fixedRotation = this.fixedRotation;
        copy.startDelay = this.startDelay;
        copy.spawnRate = this.spawnRate != null ? this.spawnRate.clone() : null;
        copy.waveDelay = this.waveDelay != null ? this.waveDelay.clone() : null;
        copy.totalSpawners = this.totalSpawners;
        copy.maxConcurrent = this.maxConcurrent;
        copy.initialVelocity = this.initialVelocity != null ? this.initialVelocity.clone() : null;
        copy.emitOffset = this.emitOffset != null ? this.emitOffset.clone() : null;
        copy.lifeSpan = this.lifeSpan != null ? this.lifeSpan.clone() : null;
        copy.attractors = this.attractors != null ? java.util.Arrays.stream(this.attractors).map(e -> e.clone()).toArray(ParticleAttractor[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ParticleSpawnerGroup other)) return false;
        return java.util.Objects.equals(this.spawnerId, other.spawnerId) && java.util.Objects.equals(this.positionOffset, other.positionOffset) && java.util.Objects.equals(this.rotationOffset, other.rotationOffset) && this.fixedRotation == other.fixedRotation && this.startDelay == other.startDelay && java.util.Objects.equals(this.spawnRate, other.spawnRate) && java.util.Objects.equals(this.waveDelay, other.waveDelay) && this.totalSpawners == other.totalSpawners && this.maxConcurrent == other.maxConcurrent && java.util.Objects.equals(this.initialVelocity, other.initialVelocity) && java.util.Objects.equals(this.emitOffset, other.emitOffset) && java.util.Objects.equals(this.lifeSpan, other.lifeSpan) && java.util.Arrays.equals(this.attractors, other.attractors);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(spawnerId);
        result = 31 * result + java.util.Objects.hashCode(positionOffset);
        result = 31 * result + java.util.Objects.hashCode(rotationOffset);
        result = 31 * result + Boolean.hashCode(fixedRotation);
        result = 31 * result + Float.hashCode(startDelay);
        result = 31 * result + java.util.Objects.hashCode(spawnRate);
        result = 31 * result + java.util.Objects.hashCode(waveDelay);
        result = 31 * result + Integer.hashCode(totalSpawners);
        result = 31 * result + Integer.hashCode(maxConcurrent);
        result = 31 * result + java.util.Objects.hashCode(initialVelocity);
        result = 31 * result + java.util.Objects.hashCode(emitOffset);
        result = 31 * result + java.util.Objects.hashCode(lifeSpan);
        result = 31 * result + java.util.Arrays.hashCode(attractors);
        return result;
    }

}