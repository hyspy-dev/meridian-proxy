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
import meridian.protocol.ParticleSpawner;
import meridian.protocol.UpdateType;
import java.util.HashMap;

public class UpdateParticleSpawners implements Packet, ToClientPacket {
    public static final int PACKET_ID = 50;
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
    @Nullable public java.util.Map<String, ParticleSpawner> particleSpawners;
    @Nullable public String[] removedParticleSpawners;

    public UpdateParticleSpawners() {
    }

    public UpdateParticleSpawners(@Nonnull UpdateType type, @Nullable java.util.Map<String, ParticleSpawner> particleSpawners, @Nullable String[] removedParticleSpawners) {
        this.type = type;
        this.particleSpawners = particleSpawners;
        this.removedParticleSpawners = removedParticleSpawners;
    }

    public UpdateParticleSpawners(@Nonnull UpdateParticleSpawners other) {
        this.type = other.type;
        this.particleSpawners = other.particleSpawners;
        this.removedParticleSpawners = other.removedParticleSpawners;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateParticleSpawners", offset, (int) mem.byteSize());
        long needed = (long) offset + 10;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateParticleSpawners", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static UpdateType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static UpdateType getType(MemorySegment mem, int offset) {
        return UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static java.util.Map<String, ParticleSpawner> getParticleSpawners(MemorySegment mem) {
        return getParticleSpawners(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, ParticleSpawner> getParticleSpawners(MemorySegment mem, int offset) {
        if (!hasParticleSpawners(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 2, 10, "ParticleSpawners");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ParticleSpawners");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ParticleSpawners", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 147 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ParticleSpawners", (int) java.lang.Math.min(off + (long) len * 147, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, ParticleSpawner> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = ParticleSpawner.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("ParticleSpawners", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static String[] getRemovedParticleSpawners(MemorySegment mem) {
        return getRemovedParticleSpawners(mem, 0);
    }
    
    @Nullable
    public static String[] getRemovedParticleSpawners(MemorySegment mem, int offset) {
        if (!hasRemovedParticleSpawners(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 6, 10, "RemovedParticleSpawners");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("RemovedParticleSpawners");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("RemovedParticleSpawners", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("RemovedParticleSpawners", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("RemovedParticleSpawners", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    public static boolean hasParticleSpawners(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasRemovedParticleSpawners(MemorySegment mem, int offset) {
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
    
    public static UpdateParticleSpawners toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateParticleSpawners toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateParticleSpawners and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateParticleSpawners toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 10;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        java.util.Map<String, ParticleSpawner> v1 = null;
        if (hasParticleSpawners(mem, offset)) {
            requireSlot(mem, offset + 2, varPos, "ParticleSpawners");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ParticleSpawners");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ParticleSpawners", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 147 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ParticleSpawners", (int) java.lang.Math.min(off + (long) len * 147, Integer.MAX_VALUE), (int) mem.byteSize());
            v1 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = ParticleSpawner.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v1.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("ParticleSpawners", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 2, -1, "ParticleSpawners");
        }
        
        String[] v2 = null;
        if (hasRemovedParticleSpawners(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "RemovedParticleSpawners");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("RemovedParticleSpawners");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("RemovedParticleSpawners", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("RemovedParticleSpawners", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v2[i] = PacketIO.readVarString("RemovedParticleSpawners", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 6, -1, "RemovedParticleSpawners");
        }
        var result = new UpdateParticleSpawners(
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
        if (this.particleSpawners != null) nullBits |= 0x01;
        if (this.removedParticleSpawners != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        var varOffset = offset + 10;
        if (this.particleSpawners != null) {
            mem.set(PacketIO.PROTO_INT, offset + 2, varOffset - offset - 10);
            if (this.particleSpawners.size() > 4096000) throw ProtocolException.dictionaryTooLarge("ParticleSpawners", particleSpawners.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.particleSpawners.size());
            for (var e : this.particleSpawners.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 2, -1);
        }
        if (this.removedParticleSpawners != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 10);
            if (removedParticleSpawners.length > 4096000) throw ProtocolException.arrayTooLong("RemovedParticleSpawners", removedParticleSpawners.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.removedParticleSpawners.length);
            
            var removedParticleSpawnersValueOffset = 0;
            for (var i = 0; i < this.removedParticleSpawners.length; i++) {
                removedParticleSpawnersValueOffset += PacketIO.writeVarString(mem, varOffset + removedParticleSpawnersValueOffset, this.removedParticleSpawners[i], 4096000);
            }
            varOffset += removedParticleSpawnersValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 10;
        if (particleSpawners != null) {
        int particleSpawnersSize = 0;
for (var kvp : particleSpawners.entrySet()) particleSpawnersSize += PacketIO.stringSize(kvp.getKey()) + kvp.getValue().computeSize();
size += VarInt.size(particleSpawners.size()) + particleSpawnersSize;
    }
    if (removedParticleSpawners != null) {
        int removedParticleSpawnersSize = 0;
for (var elem : removedParticleSpawners) removedParticleSpawnersSize += PacketIO.stringSize(elem);
size += VarInt.size(removedParticleSpawners.length) + removedParticleSpawnersSize;
    }

        return size;
    }

    public UpdateParticleSpawners clone() {
        UpdateParticleSpawners copy = new UpdateParticleSpawners();
        copy.type = this.type;
        if (this.particleSpawners != null) {
            java.util.Map<String, ParticleSpawner> m = new java.util.HashMap<>();
            for (var e : this.particleSpawners.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.particleSpawners = m;
        }
        copy.removedParticleSpawners = this.removedParticleSpawners != null ? java.util.Arrays.copyOf(this.removedParticleSpawners, this.removedParticleSpawners.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateParticleSpawners other)) return false;
        return java.util.Objects.equals(this.type, other.type) && java.util.Objects.equals(this.particleSpawners, other.particleSpawners) && java.util.Arrays.equals(this.removedParticleSpawners, other.removedParticleSpawners);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(type);
        result = 31 * result + java.util.Objects.hashCode(particleSpawners);
        result = 31 * result + java.util.Arrays.hashCode(removedParticleSpawners);
        return result;
    }

}