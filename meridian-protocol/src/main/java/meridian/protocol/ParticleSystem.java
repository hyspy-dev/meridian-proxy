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


public class ParticleSystem {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 14;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 22;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String id;
    @Nullable public ParticleSpawnerGroup[] spawners;
    public float lifeSpan;
    public float cullDistance;
    public float boundingRadius;
    public boolean isImportant;

    public ParticleSystem() {
    }

    public ParticleSystem(@Nullable String id, @Nullable ParticleSpawnerGroup[] spawners, float lifeSpan, float cullDistance, float boundingRadius, boolean isImportant) {
        this.id = id;
        this.spawners = spawners;
        this.lifeSpan = lifeSpan;
        this.cullDistance = cullDistance;
        this.boundingRadius = boundingRadius;
        this.isImportant = isImportant;
    }

    public ParticleSystem(@Nonnull ParticleSystem other) {
        this.id = other.id;
        this.spawners = other.spawners;
        this.lifeSpan = other.lifeSpan;
        this.cullDistance = other.cullDistance;
        this.boundingRadius = other.boundingRadius;
        this.isImportant = other.isImportant;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ParticleSystem", offset, (int) mem.byteSize());
        long needed = (long) offset + 22;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ParticleSystem", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 14, 22, "Id"), 4096000): null;
    }
    
    @Nullable
    public static ParticleSpawnerGroup[] getSpawners(MemorySegment mem) {
        return getSpawners(mem, 0);
    }
    
    @Nullable
    public static ParticleSpawnerGroup[] getSpawners(MemorySegment mem, int offset) {
        if (!hasSpawners(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 18, 22, "Spawners");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Spawners");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Spawners", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 121 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Spawners", (int) java.lang.Math.min(off + lenOffset + (long) len * 121, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ParticleSpawnerGroup[len];
        for (var i = 0; i < len; i++) {
            data[i] = ParticleSpawnerGroup.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static float getLifeSpan(MemorySegment mem) {
        return getLifeSpan(mem, 0);
    }
    
    public static float getLifeSpan(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "LifeSpan");
    }
    
    public static float getCullDistance(MemorySegment mem) {
        return getCullDistance(mem, 0);
    }
    
    public static float getCullDistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "CullDistance");
    }
    
    public static float getBoundingRadius(MemorySegment mem) {
        return getBoundingRadius(mem, 0);
    }
    
    public static float getBoundingRadius(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "BoundingRadius");
    }
    
    public static boolean getIsImportant(MemorySegment mem) {
        return getIsImportant(mem, 0);
    }
    
    public static boolean getIsImportant(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 13);
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasSpawners(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
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
    
    public static ParticleSystem toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ParticleSystem toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ParticleSystem and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ParticleSystem toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 22;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 14, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 14, -1, "Id");
        }
        
        ParticleSpawnerGroup[] v1 = null;
        if (hasSpawners(mem, offset)) {
            requireSlot(mem, offset + 18, varPos, "Spawners");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Spawners");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Spawners", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 121 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Spawners", (int) java.lang.Math.min(off + lenOffset + (long) len * 121, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new ParticleSpawnerGroup[len];
            for (var i = 0; i < len; i++) {
                v1[i] = ParticleSpawnerGroup.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 18, -1, "Spawners");
        }
        var result = new ParticleSystem(
            v0,
            v1,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "LifeSpan"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "CullDistance"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "BoundingRadius"),
            mem.get(PacketIO.PROTO_BOOL, offset + 13)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        if (this.spawners != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.lifeSpan, "LifeSpan"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.lifeSpan);
        PacketIO.requireFinite(this.cullDistance, "CullDistance"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.cullDistance);
        PacketIO.requireFinite(this.boundingRadius, "BoundingRadius"); mem.set(PacketIO.PROTO_FLOAT, offset + 9, this.boundingRadius);
        mem.set(PacketIO.PROTO_BOOL, offset + 13, this.isImportant);
        var varOffset = offset + 22;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 14, varOffset - offset - 22);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 14, -1);
        }
        if (this.spawners != null) {
            mem.set(PacketIO.PROTO_INT, offset + 18, varOffset - offset - 22);
            if (spawners.length > 4096000) throw ProtocolException.arrayTooLong("Spawners", spawners.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.spawners.length);
            
            var spawnersValueOffset = 0;
            for (var i = 0; i < this.spawners.length; i++) {
                spawnersValueOffset += this.spawners[i].serialize(mem, varOffset + spawnersValueOffset);
            }
            varOffset += spawnersValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 18, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 22;
        if (id != null) size += PacketIO.stringSize(id);
    if (spawners != null) {
        int spawnersSize = 0;
for (var elem : spawners) spawnersSize += elem.computeSize();
size += VarInt.size(spawners.length) + spawnersSize;
    }

        return size;
    }

    public ParticleSystem clone() {
        ParticleSystem copy = new ParticleSystem();
        copy.id = this.id;
        copy.spawners = this.spawners != null ? java.util.Arrays.stream(this.spawners).map(e -> e.clone()).toArray(ParticleSpawnerGroup[]::new) : null;
        copy.lifeSpan = this.lifeSpan;
        copy.cullDistance = this.cullDistance;
        copy.boundingRadius = this.boundingRadius;
        copy.isImportant = this.isImportant;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ParticleSystem other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Arrays.equals(this.spawners, other.spawners) && this.lifeSpan == other.lifeSpan && this.cullDistance == other.cullDistance && this.boundingRadius == other.boundingRadius && this.isImportant == other.isImportant;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(id);
        result = 31 * result + java.util.Arrays.hashCode(spawners);
        result = 31 * result + Float.hashCode(lifeSpan);
        result = 31 * result + Float.hashCode(cullDistance);
        result = 31 * result + Float.hashCode(boundingRadius);
        result = 31 * result + Boolean.hashCode(isImportant);
        return result;
    }

}