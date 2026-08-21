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

public class BlockParticleSet {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 32;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 40;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String id;
    @Nullable public Color color;
    public float scale;
    @Nullable public Vector3fc positionOffset;
    @Nullable public Direction rotationOffset;
    @Nullable public java.util.Map<BlockParticleEvent, String> particleSystemIds;

    public BlockParticleSet() {
    }

    public BlockParticleSet(@Nullable String id, @Nullable Color color, float scale, @Nullable Vector3fc positionOffset, @Nullable Direction rotationOffset, @Nullable java.util.Map<BlockParticleEvent, String> particleSystemIds) {
        this.id = id;
        this.color = color;
        this.scale = scale;
        this.positionOffset = positionOffset;
        this.rotationOffset = rotationOffset;
        this.particleSystemIds = particleSystemIds;
    }

    public BlockParticleSet(@Nonnull BlockParticleSet other) {
        this.id = other.id;
        this.color = other.color;
        this.scale = other.scale;
        this.positionOffset = other.positionOffset;
        this.rotationOffset = other.rotationOffset;
        this.particleSystemIds = other.particleSystemIds;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BlockParticleSet", offset, (int) mem.byteSize());
        long needed = (long) offset + 40;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockParticleSet", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 32, 40, "Id"), 4096000): null;
    }
    
    @Nullable
    public static Color getColor(MemorySegment mem) {
        return getColor(mem, 0);
    }
    
    @Nullable
    public static Color getColor(MemorySegment mem, int offset) {
        return hasColor(mem, offset) ? Color.toObject(mem, offset + 1): null;
    }
    
    public static float getScale(MemorySegment mem) {
        return getScale(mem, 0);
    }
    
    public static float getScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "Scale");
    }
    
    @Nullable
    public static Vector3fc getPositionOffset(MemorySegment mem) {
        return getPositionOffset(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getPositionOffset(MemorySegment mem, int offset) {
        return hasPositionOffset(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 8), "PositionOffset"): null;
    }
    
    @Nullable
    public static Direction getRotationOffset(MemorySegment mem) {
        return getRotationOffset(mem, 0);
    }
    
    @Nullable
    public static Direction getRotationOffset(MemorySegment mem, int offset) {
        return hasRotationOffset(mem, offset) ? Direction.toObject(mem, offset + 20): null;
    }
    
    @Nullable
    public static java.util.Map<BlockParticleEvent, String> getParticleSystemIds(MemorySegment mem) {
        return getParticleSystemIds(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<BlockParticleEvent, String> getParticleSystemIds(MemorySegment mem, int offset) {
        if (!hasParticleSystemIds(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 36, 40, "ParticleSystemIds");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ParticleSystemIds");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ParticleSystemIds", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ParticleSystemIds", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<BlockParticleEvent, String> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = BlockParticleEvent.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                off += 1;
            var valuePacked = VarInt.getWithLength(mem, off);
                var value = PacketIO.readVarString("value", mem, off, 0, 4096000, valuePacked);
                off += (int) valuePacked + (int) (valuePacked >>> 32);
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("ParticleSystemIds", key);
            }
        }
        return data;
    }
    
    public static boolean hasColor(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasPositionOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasRotationOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasParticleSystemIds(MemorySegment mem, int offset) {
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
    
    public static BlockParticleSet toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BlockParticleSet toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BlockParticleSet and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BlockParticleSet toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 40;
        var varPos = 0;
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 32, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 32, -1, "Id");
        }
        
        java.util.Map<BlockParticleEvent, String> v5 = null;
        if (hasParticleSystemIds(mem, offset)) {
            requireSlot(mem, offset + 36, varPos, "ParticleSystemIds");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ParticleSystemIds");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ParticleSystemIds", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ParticleSystemIds", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            v5 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = BlockParticleEvent.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                    off += 1;
                var valuePacked = VarInt.getWithLength(mem, off);
                    var value = PacketIO.readVarString("value", mem, off, 0, 4096000, valuePacked);
                    off += (int) valuePacked + (int) (valuePacked >>> 32);
                if (v5.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("ParticleSystemIds", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 36, -1, "ParticleSystemIds");
        }
        var result = new BlockParticleSet(
            v0,
            hasColor(mem, offset) ? Color.toObject(mem, offset + 1) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "Scale"),
            hasPositionOffset(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 8), "PositionOffset") : null,
            hasRotationOffset(mem, offset) ? Direction.toObject(mem, offset + 20) : null,
            v5
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.color != null) nullBits |= 0x01;
        if (this.positionOffset != null) nullBits |= 0x02;
        if (this.rotationOffset != null) nullBits |= 0x04;
        if (this.id != null) nullBits |= 0x08;
        if (this.particleSystemIds != null) nullBits |= 0x10;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.color != null) {
            this.color.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 3).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.scale, "Scale"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.scale);
        if (this.positionOffset != null) {
            PacketIO.requireFinite(this.positionOffset, "PositionOffset"); PacketIO.writeVector3f(mem, offset + 8, this.positionOffset);
        } else {
            mem.asSlice(offset + 8, 12).fill((byte) 0); 
        }
        if (this.rotationOffset != null) {
            this.rotationOffset.serialize(mem, offset + 20);
        } else {
            mem.asSlice(offset + 20, 12).fill((byte) 0); 
        }
        var varOffset = offset + 40;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 32, varOffset - offset - 40);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 32, -1);
        }
        if (this.particleSystemIds != null) {
            mem.set(PacketIO.PROTO_INT, offset + 36, varOffset - offset - 40);
            if (this.particleSystemIds.size() > 4096000) throw ProtocolException.dictionaryTooLarge("ParticleSystemIds", particleSystemIds.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.particleSystemIds.size());
            for (var e : this.particleSystemIds.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getValue(), 4096000);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 36, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 40;
        if (id != null) size += PacketIO.stringSize(id);
    if (particleSystemIds != null) {
        int particleSystemIdsSize = 0;
for (var kvp : particleSystemIds.entrySet()) particleSystemIdsSize += 1 + PacketIO.stringSize(kvp.getValue());
size += VarInt.size(particleSystemIds.size()) + particleSystemIdsSize;
    }

        return size;
    }

    public BlockParticleSet clone() {
        BlockParticleSet copy = new BlockParticleSet();
        copy.id = this.id;
        copy.color = this.color != null ? this.color.clone() : null;
        copy.scale = this.scale;
        copy.positionOffset = this.positionOffset;
        copy.rotationOffset = this.rotationOffset != null ? this.rotationOffset.clone() : null;
        copy.particleSystemIds = this.particleSystemIds != null ? new java.util.HashMap<>(this.particleSystemIds) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BlockParticleSet other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.color, other.color) && this.scale == other.scale && java.util.Objects.equals(this.positionOffset, other.positionOffset) && java.util.Objects.equals(this.rotationOffset, other.rotationOffset) && java.util.Objects.equals(this.particleSystemIds, other.particleSystemIds);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, color, scale, positionOffset, rotationOffset, particleSystemIds);
    }

}