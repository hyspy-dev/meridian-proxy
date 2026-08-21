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
import meridian.protocol.Color;
import meridian.protocol.Direction;
import meridian.protocol.Position;

public class SpawnParticleSystem implements Packet, ToClientPacket {
    public static final int PACKET_ID = 152;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 48;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 48;
    public static final int MAX_SIZE = 16384053;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public String particleSystemId;
    @Nullable public Position position;
    @Nullable public Direction rotation;
    public float scale;
    @Nullable public Color color;
    public float maxDuration;

    public SpawnParticleSystem() {
    }

    public SpawnParticleSystem(@Nullable String particleSystemId, @Nullable Position position, @Nullable Direction rotation, float scale, @Nullable Color color, float maxDuration) {
        this.particleSystemId = particleSystemId;
        this.position = position;
        this.rotation = rotation;
        this.scale = scale;
        this.color = color;
        this.maxDuration = maxDuration;
    }

    public SpawnParticleSystem(@Nonnull SpawnParticleSystem other) {
        this.particleSystemId = other.particleSystemId;
        this.position = other.position;
        this.rotation = other.rotation;
        this.scale = other.scale;
        this.color = other.color;
        this.maxDuration = other.maxDuration;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SpawnParticleSystem", offset, (int) mem.byteSize());
        long needed = (long) offset + 48;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SpawnParticleSystem", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getParticleSystemId(MemorySegment mem) {
        return getParticleSystemId(mem, 0);
    }
    
    @Nullable
    public static String getParticleSystemId(MemorySegment mem, int offset) {
        return hasParticleSystemId(mem, offset) ? PacketIO.readVarString("ParticleSystemId", mem, offset + 48, 4096000): null;
    }
    
    @Nullable
    public static Position getPosition(MemorySegment mem) {
        return getPosition(mem, 0);
    }
    
    @Nullable
    public static Position getPosition(MemorySegment mem, int offset) {
        return hasPosition(mem, offset) ? Position.toObject(mem, offset + 1): null;
    }
    
    @Nullable
    public static Direction getRotation(MemorySegment mem) {
        return getRotation(mem, 0);
    }
    
    @Nullable
    public static Direction getRotation(MemorySegment mem, int offset) {
        return hasRotation(mem, offset) ? Direction.toObject(mem, offset + 25): null;
    }
    
    public static float getScale(MemorySegment mem) {
        return getScale(mem, 0);
    }
    
    public static float getScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 37), "Scale");
    }
    
    @Nullable
    public static Color getColor(MemorySegment mem) {
        return getColor(mem, 0);
    }
    
    @Nullable
    public static Color getColor(MemorySegment mem, int offset) {
        return hasColor(mem, offset) ? Color.toObject(mem, offset + 41): null;
    }
    
    public static float getMaxDuration(MemorySegment mem) {
        return getMaxDuration(mem, 0);
    }
    
    public static float getMaxDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 44), "MaxDuration");
    }
    
    public static boolean hasPosition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasRotation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasColor(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasParticleSystemId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    
    
    public static SpawnParticleSystem toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SpawnParticleSystem toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SpawnParticleSystem and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SpawnParticleSystem toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 48;
        var varPos = 0;
        String v0 = null;
        if (hasParticleSystemId(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("ParticleSystemId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new SpawnParticleSystem(
            v0,
            hasPosition(mem, offset) ? Position.toObject(mem, offset + 1) : null,
            hasRotation(mem, offset) ? Direction.toObject(mem, offset + 25) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 37), "Scale"),
            hasColor(mem, offset) ? Color.toObject(mem, offset + 41) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 44), "MaxDuration")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.position != null) nullBits |= 0x01;
        if (this.rotation != null) nullBits |= 0x02;
        if (this.color != null) nullBits |= 0x04;
        if (this.particleSystemId != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.position != null) {
            this.position.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 24).fill((byte) 0); 
        }
        if (this.rotation != null) {
            this.rotation.serialize(mem, offset + 25);
        } else {
            mem.asSlice(offset + 25, 12).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.scale, "Scale"); mem.set(PacketIO.PROTO_FLOAT, offset + 37, this.scale);
        if (this.color != null) {
            this.color.serialize(mem, offset + 41);
        } else {
            mem.asSlice(offset + 41, 3).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.maxDuration, "MaxDuration"); mem.set(PacketIO.PROTO_FLOAT, offset + 44, this.maxDuration);
        var varOffset = offset + 48;
        if (this.particleSystemId != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.particleSystemId, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 48;
        if (particleSystemId != null) size += PacketIO.stringSize(particleSystemId);

        return size;
    }

    public SpawnParticleSystem clone() {
        SpawnParticleSystem copy = new SpawnParticleSystem();
        copy.particleSystemId = this.particleSystemId;
        copy.position = this.position != null ? this.position.clone() : null;
        copy.rotation = this.rotation != null ? this.rotation.clone() : null;
        copy.scale = this.scale;
        copy.color = this.color != null ? this.color.clone() : null;
        copy.maxDuration = this.maxDuration;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SpawnParticleSystem other)) return false;
        return java.util.Objects.equals(this.particleSystemId, other.particleSystemId) && java.util.Objects.equals(this.position, other.position) && java.util.Objects.equals(this.rotation, other.rotation) && this.scale == other.scale && java.util.Objects.equals(this.color, other.color) && this.maxDuration == other.maxDuration;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(particleSystemId, position, rotation, scale, color, maxDuration);
    }

}