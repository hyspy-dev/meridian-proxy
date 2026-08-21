// Auto-generated - do not edit
package meridian.protocol.packets.world;

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
import meridian.protocol.Position;

public class CancelParticleSystems implements Packet, ToClientPacket {
    public static final int PACKET_ID = 525;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 50;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 50;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public Position regionMin;
    @Nullable public Position regionMax;
    @Nullable public String[] particleSystemIds;
    public boolean instant;

    public CancelParticleSystems() {
    }

    public CancelParticleSystems(@Nullable Position regionMin, @Nullable Position regionMax, @Nullable String[] particleSystemIds, boolean instant) {
        this.regionMin = regionMin;
        this.regionMax = regionMax;
        this.particleSystemIds = particleSystemIds;
        this.instant = instant;
    }

    public CancelParticleSystems(@Nonnull CancelParticleSystems other) {
        this.regionMin = other.regionMin;
        this.regionMax = other.regionMax;
        this.particleSystemIds = other.particleSystemIds;
        this.instant = other.instant;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CancelParticleSystems", offset, (int) mem.byteSize());
        long needed = (long) offset + 50;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CancelParticleSystems", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static Position getRegionMin(MemorySegment mem) {
        return getRegionMin(mem, 0);
    }
    
    @Nullable
    public static Position getRegionMin(MemorySegment mem, int offset) {
        return hasRegionMin(mem, offset) ? Position.toObject(mem, offset + 1): null;
    }
    
    @Nullable
    public static Position getRegionMax(MemorySegment mem) {
        return getRegionMax(mem, 0);
    }
    
    @Nullable
    public static Position getRegionMax(MemorySegment mem, int offset) {
        return hasRegionMax(mem, offset) ? Position.toObject(mem, offset + 25): null;
    }
    
    @Nullable
    public static String[] getParticleSystemIds(MemorySegment mem) {
        return getParticleSystemIds(mem, 0);
    }
    
    @Nullable
    public static String[] getParticleSystemIds(MemorySegment mem, int offset) {
        if (!hasParticleSystemIds(mem, offset)) return null;
        var off = offset + 50;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ParticleSystemIds");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("ParticleSystemIds", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("ParticleSystemIds", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("ParticleSystemIds", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    public static boolean getInstant(MemorySegment mem) {
        return getInstant(mem, 0);
    }
    
    public static boolean getInstant(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 49);
    }
    
    public static boolean hasRegionMin(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasRegionMax(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasParticleSystemIds(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    
    
    public static CancelParticleSystems toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CancelParticleSystems toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CancelParticleSystems and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CancelParticleSystems toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 50;
        var varPos = 0;
        String[] v2 = null;
        if (hasParticleSystemIds(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ParticleSystemIds");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("ParticleSystemIds", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("ParticleSystemIds", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v2[i] = PacketIO.readVarString("ParticleSystemIds", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        }
        var result = new CancelParticleSystems(
            hasRegionMin(mem, offset) ? Position.toObject(mem, offset + 1) : null,
            hasRegionMax(mem, offset) ? Position.toObject(mem, offset + 25) : null,
            v2,
            mem.get(PacketIO.PROTO_BOOL, offset + 49)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.regionMin != null) nullBits |= 0x01;
        if (this.regionMax != null) nullBits |= 0x02;
        if (this.particleSystemIds != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.regionMin != null) {
            this.regionMin.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 24).fill((byte) 0); 
        }
        if (this.regionMax != null) {
            this.regionMax.serialize(mem, offset + 25);
        } else {
            mem.asSlice(offset + 25, 24).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BOOL, offset + 49, this.instant);
        var varOffset = offset + 50;
        if (this.particleSystemIds != null) {
            
            if (particleSystemIds.length > 4096000) throw ProtocolException.arrayTooLong("ParticleSystemIds", particleSystemIds.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.particleSystemIds.length);
            
            var particleSystemIdsValueOffset = 0;
            for (var i = 0; i < this.particleSystemIds.length; i++) {
                particleSystemIdsValueOffset += PacketIO.writeVarString(mem, varOffset + particleSystemIdsValueOffset, this.particleSystemIds[i], 4096000);
            }
            varOffset += particleSystemIdsValueOffset;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 50;
        if (particleSystemIds != null) {
        int particleSystemIdsSize = 0;
for (var elem : particleSystemIds) particleSystemIdsSize += PacketIO.stringSize(elem);
size += VarInt.size(particleSystemIds.length) + particleSystemIdsSize;
    }

        return size;
    }

    public CancelParticleSystems clone() {
        CancelParticleSystems copy = new CancelParticleSystems();
        copy.regionMin = this.regionMin != null ? this.regionMin.clone() : null;
        copy.regionMax = this.regionMax != null ? this.regionMax.clone() : null;
        copy.particleSystemIds = this.particleSystemIds != null ? java.util.Arrays.copyOf(this.particleSystemIds, this.particleSystemIds.length) : null;
        copy.instant = this.instant;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CancelParticleSystems other)) return false;
        return java.util.Objects.equals(this.regionMin, other.regionMin) && java.util.Objects.equals(this.regionMax, other.regionMax) && java.util.Arrays.equals(this.particleSystemIds, other.particleSystemIds) && this.instant == other.instant;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(regionMin);
        result = 31 * result + java.util.Objects.hashCode(regionMax);
        result = 31 * result + java.util.Arrays.hashCode(particleSystemIds);
        result = 31 * result + Boolean.hashCode(instant);
        return result;
    }

}