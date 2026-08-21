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
import org.joml.*;

public class ProjectileConfig {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 174;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 182;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public PhysicsConfig physicsConfig;
    @Nullable public Model model;
    public double launchForce;
    @Nullable public Vector3fc spawnOffset;
    @Nullable public Direction rotationOffset;
    public boolean rotateSpawnOffsetByPitch;
    public boolean rotateSpawnOffsetByYaw;
    @Nullable public java.util.Map<InteractionType, Integer> interactions;
    public int launchLocalSoundEventIndex;
    public int launchWorldSoundEventIndex;
    public int projectileSoundEventIndex;
    public float minScale;
    public float maxScale;

    public ProjectileConfig() {
    }

    public ProjectileConfig(@Nullable PhysicsConfig physicsConfig, @Nullable Model model, double launchForce, @Nullable Vector3fc spawnOffset, @Nullable Direction rotationOffset, boolean rotateSpawnOffsetByPitch, boolean rotateSpawnOffsetByYaw, @Nullable java.util.Map<InteractionType, Integer> interactions, int launchLocalSoundEventIndex, int launchWorldSoundEventIndex, int projectileSoundEventIndex, float minScale, float maxScale) {
        this.physicsConfig = physicsConfig;
        this.model = model;
        this.launchForce = launchForce;
        this.spawnOffset = spawnOffset;
        this.rotationOffset = rotationOffset;
        this.rotateSpawnOffsetByPitch = rotateSpawnOffsetByPitch;
        this.rotateSpawnOffsetByYaw = rotateSpawnOffsetByYaw;
        this.interactions = interactions;
        this.launchLocalSoundEventIndex = launchLocalSoundEventIndex;
        this.launchWorldSoundEventIndex = launchWorldSoundEventIndex;
        this.projectileSoundEventIndex = projectileSoundEventIndex;
        this.minScale = minScale;
        this.maxScale = maxScale;
    }

    public ProjectileConfig(@Nonnull ProjectileConfig other) {
        this.physicsConfig = other.physicsConfig;
        this.model = other.model;
        this.launchForce = other.launchForce;
        this.spawnOffset = other.spawnOffset;
        this.rotationOffset = other.rotationOffset;
        this.rotateSpawnOffsetByPitch = other.rotateSpawnOffsetByPitch;
        this.rotateSpawnOffsetByYaw = other.rotateSpawnOffsetByYaw;
        this.interactions = other.interactions;
        this.launchLocalSoundEventIndex = other.launchLocalSoundEventIndex;
        this.launchWorldSoundEventIndex = other.launchWorldSoundEventIndex;
        this.projectileSoundEventIndex = other.projectileSoundEventIndex;
        this.minScale = other.minScale;
        this.maxScale = other.maxScale;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ProjectileConfig", offset, (int) mem.byteSize());
        long needed = (long) offset + 182;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ProjectileConfig", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static PhysicsConfig getPhysicsConfig(MemorySegment mem) {
        return getPhysicsConfig(mem, 0);
    }
    
    @Nullable
    public static PhysicsConfig getPhysicsConfig(MemorySegment mem, int offset) {
        return hasPhysicsConfig(mem, offset) ? PhysicsConfig.toObject(mem, offset + 1): null;
    }
    
    @Nullable
    public static Model getModel(MemorySegment mem) {
        return getModel(mem, 0);
    }
    
    @Nullable
    public static Model getModel(MemorySegment mem, int offset) {
        return hasModel(mem, offset) ? Model.toObject(mem, offset + getValidatedOffset(mem, offset, 174, 182, "Model")): null;
    }
    
    public static double getLaunchForce(MemorySegment mem) {
        return getLaunchForce(mem, 0);
    }
    
    public static double getLaunchForce(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 121), "LaunchForce");
    }
    
    @Nullable
    public static Vector3fc getSpawnOffset(MemorySegment mem) {
        return getSpawnOffset(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getSpawnOffset(MemorySegment mem, int offset) {
        return hasSpawnOffset(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 129), "SpawnOffset"): null;
    }
    
    @Nullable
    public static Direction getRotationOffset(MemorySegment mem) {
        return getRotationOffset(mem, 0);
    }
    
    @Nullable
    public static Direction getRotationOffset(MemorySegment mem, int offset) {
        return hasRotationOffset(mem, offset) ? Direction.toObject(mem, offset + 141): null;
    }
    
    public static boolean getRotateSpawnOffsetByPitch(MemorySegment mem) {
        return getRotateSpawnOffsetByPitch(mem, 0);
    }
    
    public static boolean getRotateSpawnOffsetByPitch(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 153) & 0x01) != 0;
    }
    
    public static boolean getRotateSpawnOffsetByYaw(MemorySegment mem) {
        return getRotateSpawnOffsetByYaw(mem, 0);
    }
    
    public static boolean getRotateSpawnOffsetByYaw(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 153) & 0x02) != 0;
    }
    
    @Nullable
    public static java.util.Map<InteractionType, Integer> getInteractions(MemorySegment mem) {
        return getInteractions(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<InteractionType, Integer> getInteractions(MemorySegment mem, int offset) {
        if (!hasInteractions(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 178, 182, "Interactions");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Interactions");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Interactions", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Interactions", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<InteractionType, Integer> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                off += 1;
            var value = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Interactions", key);
            }
        }
        return data;
    }
    
    public static int getLaunchLocalSoundEventIndex(MemorySegment mem) {
        return getLaunchLocalSoundEventIndex(mem, 0);
    }
    
    public static int getLaunchLocalSoundEventIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 154);
    }
    
    public static int getLaunchWorldSoundEventIndex(MemorySegment mem) {
        return getLaunchWorldSoundEventIndex(mem, 0);
    }
    
    public static int getLaunchWorldSoundEventIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 158);
    }
    
    public static int getProjectileSoundEventIndex(MemorySegment mem) {
        return getProjectileSoundEventIndex(mem, 0);
    }
    
    public static int getProjectileSoundEventIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 162);
    }
    
    public static float getMinScale(MemorySegment mem) {
        return getMinScale(mem, 0);
    }
    
    public static float getMinScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 166), "MinScale");
    }
    
    public static float getMaxScale(MemorySegment mem) {
        return getMaxScale(mem, 0);
    }
    
    public static float getMaxScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 170), "MaxScale");
    }
    
    public static boolean hasPhysicsConfig(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasSpawnOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasRotationOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasModel(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasInteractions(MemorySegment mem, int offset) {
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
    
    public static ProjectileConfig toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ProjectileConfig toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ProjectileConfig and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ProjectileConfig toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 182;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        Model v1 = null;
        if (hasModel(mem, offset)) {
            requireSlot(mem, offset + 174, varPos, "Model");
            v1 = Model.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 174, -1, "Model");
        }
        
        java.util.Map<InteractionType, Integer> v7 = null;
        if (hasInteractions(mem, offset)) {
            requireSlot(mem, offset + 178, varPos, "Interactions");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Interactions");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Interactions", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Interactions", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v7 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                    off += 1;
                var value = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                if (v7.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Interactions", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 178, -1, "Interactions");
        }
        var result = new ProjectileConfig(
            hasPhysicsConfig(mem, offset) ? PhysicsConfig.toObject(mem, offset + 1) : null,
            v1,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 121), "LaunchForce"),
            hasSpawnOffset(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 129), "SpawnOffset") : null,
            hasRotationOffset(mem, offset) ? Direction.toObject(mem, offset + 141) : null,
            (mem.get(PacketIO.PROTO_BYTE, offset + 153) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 153) & 0x02) != 0,
            v7,
            mem.get(PacketIO.PROTO_INT, offset + 154),
            mem.get(PacketIO.PROTO_INT, offset + 158),
            mem.get(PacketIO.PROTO_INT, offset + 162),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 166), "MinScale"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 170), "MaxScale")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.physicsConfig != null) nullBits |= 0x01;
        if (this.spawnOffset != null) nullBits |= 0x02;
        if (this.rotationOffset != null) nullBits |= 0x04;
        if (this.model != null) nullBits |= 0x08;
        if (this.interactions != null) nullBits |= 0x10;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.physicsConfig != null) {
            this.physicsConfig.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 120).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.launchForce, "LaunchForce"); mem.set(PacketIO.PROTO_DOUBLE, offset + 121, this.launchForce);
        if (this.spawnOffset != null) {
            PacketIO.requireFinite(this.spawnOffset, "SpawnOffset"); PacketIO.writeVector3f(mem, offset + 129, this.spawnOffset);
        } else {
            mem.asSlice(offset + 129, 12).fill((byte) 0); 
        }
        if (this.rotationOffset != null) {
            this.rotationOffset.serialize(mem, offset + 141);
        } else {
            mem.asSlice(offset + 141, 12).fill((byte) 0); 
        }
        byte boolBits0_0 = 0;
        if (this.rotateSpawnOffsetByPitch) boolBits0_0 |= 0x01;
        if (this.rotateSpawnOffsetByYaw) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 153 + 0, boolBits0_0);
        mem.set(PacketIO.PROTO_INT, offset + 154, this.launchLocalSoundEventIndex);
        mem.set(PacketIO.PROTO_INT, offset + 158, this.launchWorldSoundEventIndex);
        mem.set(PacketIO.PROTO_INT, offset + 162, this.projectileSoundEventIndex);
        PacketIO.requireFinite(this.minScale, "MinScale"); mem.set(PacketIO.PROTO_FLOAT, offset + 166, this.minScale);
        PacketIO.requireFinite(this.maxScale, "MaxScale"); mem.set(PacketIO.PROTO_FLOAT, offset + 170, this.maxScale);
        var varOffset = offset + 182;
        if (this.model != null) {
            mem.set(PacketIO.PROTO_INT, offset + 174, varOffset - offset - 182);
            varOffset += this.model.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 174, -1);
        }
        if (this.interactions != null) {
            mem.set(PacketIO.PROTO_INT, offset + 178, varOffset - offset - 182);
            if (this.interactions.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Interactions", interactions.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.interactions.size());
            for (var e : this.interactions.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                mem.set(PacketIO.PROTO_INT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 178, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 182;
        if (model != null) size += model.computeSize();
    if (interactions != null) size += VarInt.size(interactions.size()) + interactions.size() * (1 + 4);

        return size;
    }

    public ProjectileConfig clone() {
        ProjectileConfig copy = new ProjectileConfig();
        copy.physicsConfig = this.physicsConfig != null ? this.physicsConfig.clone() : null;
        copy.model = this.model != null ? this.model.clone() : null;
        copy.launchForce = this.launchForce;
        copy.spawnOffset = this.spawnOffset;
        copy.rotationOffset = this.rotationOffset != null ? this.rotationOffset.clone() : null;
        copy.rotateSpawnOffsetByPitch = this.rotateSpawnOffsetByPitch;
        copy.rotateSpawnOffsetByYaw = this.rotateSpawnOffsetByYaw;
        copy.interactions = this.interactions != null ? new java.util.HashMap<>(this.interactions) : null;
        copy.launchLocalSoundEventIndex = this.launchLocalSoundEventIndex;
        copy.launchWorldSoundEventIndex = this.launchWorldSoundEventIndex;
        copy.projectileSoundEventIndex = this.projectileSoundEventIndex;
        copy.minScale = this.minScale;
        copy.maxScale = this.maxScale;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ProjectileConfig other)) return false;
        return java.util.Objects.equals(this.physicsConfig, other.physicsConfig) && java.util.Objects.equals(this.model, other.model) && this.launchForce == other.launchForce && java.util.Objects.equals(this.spawnOffset, other.spawnOffset) && java.util.Objects.equals(this.rotationOffset, other.rotationOffset) && this.rotateSpawnOffsetByPitch == other.rotateSpawnOffsetByPitch && this.rotateSpawnOffsetByYaw == other.rotateSpawnOffsetByYaw && java.util.Objects.equals(this.interactions, other.interactions) && this.launchLocalSoundEventIndex == other.launchLocalSoundEventIndex && this.launchWorldSoundEventIndex == other.launchWorldSoundEventIndex && this.projectileSoundEventIndex == other.projectileSoundEventIndex && this.minScale == other.minScale && this.maxScale == other.maxScale;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(physicsConfig, model, launchForce, spawnOffset, rotationOffset, rotateSpawnOffsetByPitch, rotateSpawnOffsetByYaw, interactions, launchLocalSoundEventIndex, launchWorldSoundEventIndex, projectileSoundEventIndex, minScale, maxScale);
    }

}