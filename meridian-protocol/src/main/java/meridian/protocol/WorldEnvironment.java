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

public class WorldEnvironment {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 4;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 16;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String id;
    @Nullable public Color waterTint;
    @Nullable public java.util.Map<Integer, FluidParticle> fluidParticles;
    @Nullable public int[] tagIndexes;

    public WorldEnvironment() {
    }

    public WorldEnvironment(@Nullable String id, @Nullable Color waterTint, @Nullable java.util.Map<Integer, FluidParticle> fluidParticles, @Nullable int[] tagIndexes) {
        this.id = id;
        this.waterTint = waterTint;
        this.fluidParticles = fluidParticles;
        this.tagIndexes = tagIndexes;
    }

    public WorldEnvironment(@Nonnull WorldEnvironment other) {
        this.id = other.id;
        this.waterTint = other.waterTint;
        this.fluidParticles = other.fluidParticles;
        this.tagIndexes = other.tagIndexes;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("WorldEnvironment", offset, (int) mem.byteSize());
        long needed = (long) offset + 16;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("WorldEnvironment", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 4, 16, "Id"), 4096000): null;
    }
    
    @Nullable
    public static Color getWaterTint(MemorySegment mem) {
        return getWaterTint(mem, 0);
    }
    
    @Nullable
    public static Color getWaterTint(MemorySegment mem, int offset) {
        return hasWaterTint(mem, offset) ? Color.toObject(mem, offset + 1): null;
    }
    
    @Nullable
    public static java.util.Map<Integer, FluidParticle> getFluidParticles(MemorySegment mem) {
        return getFluidParticles(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Integer, FluidParticle> getFluidParticles(MemorySegment mem, int offset) {
        if (!hasFluidParticles(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 8, 16, "FluidParticles");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("FluidParticles");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("FluidParticles", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 12 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FluidParticles", (int) java.lang.Math.min(off + (long) len * 12, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Integer, FluidParticle> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            var value = FluidParticle.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("FluidParticles", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static int[] getTagIndexes(MemorySegment mem) {
        return getTagIndexes(mem, 0);
    }
    
    @Nullable
    public static int[] getTagIndexes(MemorySegment mem, int offset) {
        if (!hasTagIndexes(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 12, 16, "TagIndexes");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("TagIndexes");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("TagIndexes", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("TagIndexes", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    public static boolean hasWaterTint(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasFluidParticles(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasTagIndexes(MemorySegment mem, int offset) {
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
    
    public static WorldEnvironment toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static WorldEnvironment toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one WorldEnvironment and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static WorldEnvironment toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 16;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 4, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 4, -1, "Id");
        }
        
        java.util.Map<Integer, FluidParticle> v2 = null;
        if (hasFluidParticles(mem, offset)) {
            requireSlot(mem, offset + 8, varPos, "FluidParticles");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("FluidParticles");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("FluidParticles", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 12 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FluidParticles", (int) java.lang.Math.min(off + (long) len * 12, Integer.MAX_VALUE), (int) mem.byteSize());
            v2 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                var value = FluidParticle.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v2.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("FluidParticles", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 8, -1, "FluidParticles");
        }
        
        int[] v3 = null;
        if (hasTagIndexes(mem, offset)) {
            requireSlot(mem, offset + 12, varPos, "TagIndexes");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("TagIndexes");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("TagIndexes", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("TagIndexes", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v3 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v3, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 12, -1, "TagIndexes");
        }
        var result = new WorldEnvironment(
            v0,
            hasWaterTint(mem, offset) ? Color.toObject(mem, offset + 1) : null,
            v2,
            v3
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.waterTint != null) nullBits |= 0x01;
        if (this.id != null) nullBits |= 0x02;
        if (this.fluidParticles != null) nullBits |= 0x04;
        if (this.tagIndexes != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.waterTint != null) {
            this.waterTint.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 3).fill((byte) 0); 
        }
        var varOffset = offset + 16;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 4, varOffset - offset - 16);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 4, -1);
        }
        if (this.fluidParticles != null) {
            mem.set(PacketIO.PROTO_INT, offset + 8, varOffset - offset - 16);
            if (this.fluidParticles.size() > 4096000) throw ProtocolException.dictionaryTooLarge("FluidParticles", fluidParticles.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.fluidParticles.size());
            for (var e : this.fluidParticles.entrySet()) {
                mem.set(PacketIO.PROTO_INT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 8, -1);
        }
        if (this.tagIndexes != null) {
            mem.set(PacketIO.PROTO_INT, offset + 12, varOffset - offset - 16);
            if (tagIndexes.length > 4096000) throw ProtocolException.arrayTooLong("TagIndexes", tagIndexes.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.tagIndexes.length);
            
            MemorySegment.copy(this.tagIndexes, 0, mem, PacketIO.PROTO_INT, varOffset, this.tagIndexes.length);
            varOffset += this.tagIndexes.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 12, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 16;
        if (id != null) size += PacketIO.stringSize(id);
    if (fluidParticles != null) {
        int fluidParticlesSize = 0;
for (var kvp : fluidParticles.entrySet()) fluidParticlesSize += 4 + kvp.getValue().computeSize();
size += VarInt.size(fluidParticles.size()) + fluidParticlesSize;
    }
    if (tagIndexes != null) size += VarInt.size(tagIndexes.length) + tagIndexes.length * 4;

        return size;
    }

    public WorldEnvironment clone() {
        WorldEnvironment copy = new WorldEnvironment();
        copy.id = this.id;
        copy.waterTint = this.waterTint != null ? this.waterTint.clone() : null;
        if (this.fluidParticles != null) {
            java.util.Map<Integer, FluidParticle> m = new java.util.HashMap<>();
            for (var e : this.fluidParticles.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.fluidParticles = m;
        }
        copy.tagIndexes = this.tagIndexes != null ? java.util.Arrays.copyOf(this.tagIndexes, this.tagIndexes.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof WorldEnvironment other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.waterTint, other.waterTint) && java.util.Objects.equals(this.fluidParticles, other.fluidParticles) && java.util.Arrays.equals(this.tagIndexes, other.tagIndexes);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(id);
        result = 31 * result + java.util.Objects.hashCode(waterTint);
        result = 31 * result + java.util.Objects.hashCode(fluidParticles);
        result = 31 * result + java.util.Arrays.hashCode(tagIndexes);
        return result;
    }

}