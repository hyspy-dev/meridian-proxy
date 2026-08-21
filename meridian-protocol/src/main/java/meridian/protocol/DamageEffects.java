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


public class DamageEffects {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public ModelParticle[] modelParticles;
    @Nullable public WorldParticle[] worldParticles;
    public int soundEventIndex;

    public DamageEffects() {
    }

    public DamageEffects(@Nullable ModelParticle[] modelParticles, @Nullable WorldParticle[] worldParticles, int soundEventIndex) {
        this.modelParticles = modelParticles;
        this.worldParticles = worldParticles;
        this.soundEventIndex = soundEventIndex;
    }

    public DamageEffects(@Nonnull DamageEffects other) {
        this.modelParticles = other.modelParticles;
        this.worldParticles = other.worldParticles;
        this.soundEventIndex = other.soundEventIndex;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("DamageEffects", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("DamageEffects", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static ModelParticle[] getModelParticles(MemorySegment mem) {
        return getModelParticles(mem, 0);
    }
    
    @Nullable
    public static ModelParticle[] getModelParticles(MemorySegment mem, int offset) {
        if (!hasModelParticles(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 5, 13, "ModelParticles");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ModelParticles");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("ModelParticles", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ModelParticles", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ModelParticle[len];
        for (var i = 0; i < len; i++) {
            data[i] = ModelParticle.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static WorldParticle[] getWorldParticles(MemorySegment mem) {
        return getWorldParticles(mem, 0);
    }
    
    @Nullable
    public static WorldParticle[] getWorldParticles(MemorySegment mem, int offset) {
        if (!hasWorldParticles(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 9, 13, "WorldParticles");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("WorldParticles");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("WorldParticles", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 32 > mem.byteSize()) throw ProtocolException.bufferTooSmall("WorldParticles", (int) java.lang.Math.min(off + lenOffset + (long) len * 32, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new WorldParticle[len];
        for (var i = 0; i < len; i++) {
            data[i] = WorldParticle.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static int getSoundEventIndex(MemorySegment mem) {
        return getSoundEventIndex(mem, 0);
    }
    
    public static int getSoundEventIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static boolean hasModelParticles(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasWorldParticles(MemorySegment mem, int offset) {
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
    
    public static DamageEffects toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static DamageEffects toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one DamageEffects and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static DamageEffects toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 13;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ModelParticle[] v0 = null;
        if (hasModelParticles(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "ModelParticles");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ModelParticles");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("ModelParticles", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ModelParticles", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new ModelParticle[len];
            for (var i = 0; i < len; i++) {
                v0[i] = ModelParticle.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "ModelParticles");
        }
        
        WorldParticle[] v1 = null;
        if (hasWorldParticles(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "WorldParticles");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("WorldParticles");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("WorldParticles", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 32 > mem.byteSize()) throw ProtocolException.bufferTooSmall("WorldParticles", (int) java.lang.Math.min(off + lenOffset + (long) len * 32, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new WorldParticle[len];
            for (var i = 0; i < len; i++) {
                v1[i] = WorldParticle.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 9, -1, "WorldParticles");
        }
        var result = new DamageEffects(
            v0,
            v1,
            mem.get(PacketIO.PROTO_INT, offset + 1)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.modelParticles != null) nullBits |= 0x01;
        if (this.worldParticles != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.soundEventIndex);
        var varOffset = offset + 13;
        if (this.modelParticles != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 13);
            if (modelParticles.length > 4096000) throw ProtocolException.arrayTooLong("ModelParticles", modelParticles.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.modelParticles.length);
            
            var modelParticlesValueOffset = 0;
            for (var i = 0; i < this.modelParticles.length; i++) {
                modelParticlesValueOffset += this.modelParticles[i].serialize(mem, varOffset + modelParticlesValueOffset);
            }
            varOffset += modelParticlesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.worldParticles != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 13);
            if (worldParticles.length > 4096000) throw ProtocolException.arrayTooLong("WorldParticles", worldParticles.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.worldParticles.length);
            
            var worldParticlesValueOffset = 0;
            for (var i = 0; i < this.worldParticles.length; i++) {
                worldParticlesValueOffset += this.worldParticles[i].serialize(mem, varOffset + worldParticlesValueOffset);
            }
            varOffset += worldParticlesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 13;
        if (modelParticles != null) {
        int modelParticlesSize = 0;
for (var elem : modelParticles) modelParticlesSize += elem.computeSize();
size += VarInt.size(modelParticles.length) + modelParticlesSize;
    }
    if (worldParticles != null) {
        int worldParticlesSize = 0;
for (var elem : worldParticles) worldParticlesSize += elem.computeSize();
size += VarInt.size(worldParticles.length) + worldParticlesSize;
    }

        return size;
    }

    public DamageEffects clone() {
        DamageEffects copy = new DamageEffects();
        copy.modelParticles = this.modelParticles != null ? java.util.Arrays.stream(this.modelParticles).map(e -> e.clone()).toArray(ModelParticle[]::new) : null;
        copy.worldParticles = this.worldParticles != null ? java.util.Arrays.stream(this.worldParticles).map(e -> e.clone()).toArray(WorldParticle[]::new) : null;
        copy.soundEventIndex = this.soundEventIndex;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DamageEffects other)) return false;
        return java.util.Arrays.equals(this.modelParticles, other.modelParticles) && java.util.Arrays.equals(this.worldParticles, other.worldParticles) && this.soundEventIndex == other.soundEventIndex;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(modelParticles);
        result = 31 * result + java.util.Arrays.hashCode(worldParticles);
        result = 31 * result + Integer.hashCode(soundEventIndex);
        return result;
    }

}