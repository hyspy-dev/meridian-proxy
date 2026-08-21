// Auto-generated - do not edit
package meridian.protocol.packets.assets;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.NetworkChannel;
import meridian.protocol.Packet;
import meridian.protocol.ToServerPacket;
import meridian.protocol.ToClientPacket;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import meridian.protocol.ParticleSystem;
import meridian.protocol.UpdateType;
import java.util.HashMap;

public class UpdateParticleSystems implements Packet, ToClientPacket {
    public static final int PACKET_ID = 49;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 10;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public UpdateType type = UpdateType.Init;
    @Nullable public java.util.Map<String, ParticleSystem> particleSystems;
    @Nullable public String[] removedParticleSystems;

    public UpdateParticleSystems() {
    }

    public UpdateParticleSystems(@Nonnull UpdateType type, @Nullable java.util.Map<String, ParticleSystem> particleSystems, @Nullable String[] removedParticleSystems) {
        this.type = type;
        this.particleSystems = particleSystems;
        this.removedParticleSystems = removedParticleSystems;
    }

    public UpdateParticleSystems(@Nonnull UpdateParticleSystems other) {
        this.type = other.type;
        this.particleSystems = other.particleSystems;
        this.removedParticleSystems = other.removedParticleSystems;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateParticleSystems", offset, (int) mem.byteSize());
        long needed = (long) offset + 10;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateParticleSystems", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static UpdateType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static UpdateType getType(MemorySegment mem, int offset) {
        return UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static java.util.Map<String, ParticleSystem> getParticleSystems(MemorySegment mem) {
        return getParticleSystems(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, ParticleSystem> getParticleSystems(MemorySegment mem, int offset) {
        if (!hasParticleSystems(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 2, 10, "ParticleSystems");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ParticleSystems");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ParticleSystems", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 23 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ParticleSystems", (int) java.lang.Math.min(off + (long) len * 23, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, ParticleSystem> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = ParticleSystem.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("ParticleSystems", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static String[] getRemovedParticleSystems(MemorySegment mem) {
        return getRemovedParticleSystems(mem, 0);
    }
    
    @Nullable
    public static String[] getRemovedParticleSystems(MemorySegment mem, int offset) {
        if (!hasRemovedParticleSystems(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 6, 10, "RemovedParticleSystems");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("RemovedParticleSystems");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("RemovedParticleSystems", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("RemovedParticleSystems", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("RemovedParticleSystems", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    public static boolean hasParticleSystems(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasRemovedParticleSystems(MemorySegment mem, int offset) {
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
    
    public static UpdateParticleSystems toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateParticleSystems toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateParticleSystems and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateParticleSystems toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 10;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        java.util.Map<String, ParticleSystem> v1 = null;
        if (hasParticleSystems(mem, offset)) {
            requireSlot(mem, offset + 2, varPos, "ParticleSystems");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ParticleSystems");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ParticleSystems", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 23 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ParticleSystems", (int) java.lang.Math.min(off + (long) len * 23, Integer.MAX_VALUE), (int) mem.byteSize());
            v1 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = ParticleSystem.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v1.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("ParticleSystems", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 2, -1, "ParticleSystems");
        }
        
        String[] v2 = null;
        if (hasRemovedParticleSystems(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "RemovedParticleSystems");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("RemovedParticleSystems");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("RemovedParticleSystems", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("RemovedParticleSystems", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v2[i] = PacketIO.readVarString("RemovedParticleSystems", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 6, -1, "RemovedParticleSystems");
        }
        var result = new UpdateParticleSystems(
            UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v1,
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.particleSystems != null) nullBits |= 0x01;
        if (this.removedParticleSystems != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        var varOffset = offset + 10;
        if (this.particleSystems != null) {
            mem.set(PacketIO.PROTO_INT, offset + 2, varOffset - offset - 10);
            if (this.particleSystems.size() > 4096000) throw ProtocolException.dictionaryTooLarge("ParticleSystems", particleSystems.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.particleSystems.size());
            for (var e : this.particleSystems.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 2, -1);
        }
        if (this.removedParticleSystems != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 10);
            if (removedParticleSystems.length > 4096000) throw ProtocolException.arrayTooLong("RemovedParticleSystems", removedParticleSystems.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.removedParticleSystems.length);
            
            var removedParticleSystemsValueOffset = 0;
            for (var i = 0; i < this.removedParticleSystems.length; i++) {
                removedParticleSystemsValueOffset += PacketIO.writeVarString(mem, varOffset + removedParticleSystemsValueOffset, this.removedParticleSystems[i], 4096000);
            }
            varOffset += removedParticleSystemsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 10;
        if (particleSystems != null) {
        int particleSystemsSize = 0;
for (var kvp : particleSystems.entrySet()) particleSystemsSize += PacketIO.stringSize(kvp.getKey()) + kvp.getValue().computeSize();
size += VarInt.size(particleSystems.size()) + particleSystemsSize;
    }
    if (removedParticleSystems != null) {
        int removedParticleSystemsSize = 0;
for (var elem : removedParticleSystems) removedParticleSystemsSize += PacketIO.stringSize(elem);
size += VarInt.size(removedParticleSystems.length) + removedParticleSystemsSize;
    }

        return size;
    }

    public UpdateParticleSystems clone() {
        UpdateParticleSystems copy = new UpdateParticleSystems();
        copy.type = this.type;
        if (this.particleSystems != null) {
            java.util.Map<String, ParticleSystem> m = new java.util.HashMap<>();
            for (var e : this.particleSystems.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.particleSystems = m;
        }
        copy.removedParticleSystems = this.removedParticleSystems != null ? java.util.Arrays.copyOf(this.removedParticleSystems, this.removedParticleSystems.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateParticleSystems other)) return false;
        return java.util.Objects.equals(this.type, other.type) && java.util.Objects.equals(this.particleSystems, other.particleSystems) && java.util.Arrays.equals(this.removedParticleSystems, other.removedParticleSystems);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(type);
        result = 31 * result + java.util.Objects.hashCode(particleSystems);
        result = 31 * result + java.util.Arrays.hashCode(removedParticleSystems);
        return result;
    }

}