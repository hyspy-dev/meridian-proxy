// Auto-generated - do not edit
package meridian.protocol.packets.player;

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
import java.util.UUID;

public class JoinWorld implements Packet, ToClientPacket {
    public static final int PACKET_ID = 104;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 26;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 26;
    public static final int MAX_SIZE = 26;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public boolean clearWorld;
    public boolean fadeInOut;
    @Nonnull public java.util.UUID worldUuid = new java.util.UUID(0L, 0L);
    @Nullable public Integer minSectionY;
    @Nullable public Integer maxSectionY;

    public JoinWorld() {
    }

    public JoinWorld(boolean clearWorld, boolean fadeInOut, @Nonnull java.util.UUID worldUuid, @Nullable Integer minSectionY, @Nullable Integer maxSectionY) {
        this.clearWorld = clearWorld;
        this.fadeInOut = fadeInOut;
        this.worldUuid = worldUuid;
        this.minSectionY = minSectionY;
        this.maxSectionY = maxSectionY;
    }

    public JoinWorld(@Nonnull JoinWorld other) {
        this.clearWorld = other.clearWorld;
        this.fadeInOut = other.fadeInOut;
        this.worldUuid = other.worldUuid;
        this.minSectionY = other.minSectionY;
        this.maxSectionY = other.maxSectionY;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("JoinWorld", offset, (int) mem.byteSize());
        long needed = (long) offset + 26;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("JoinWorld", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getClearWorld(MemorySegment mem) {
        return getClearWorld(mem, 0);
    }
    
    public static boolean getClearWorld(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x01) != 0;
    }
    
    public static boolean getFadeInOut(MemorySegment mem) {
        return getFadeInOut(mem, 0);
    }
    
    public static boolean getFadeInOut(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x02) != 0;
    }
    
    public static java.util.UUID getWorldUuid(MemorySegment mem) {
        return getWorldUuid(mem, 0);
    }
    
    public static java.util.UUID getWorldUuid(MemorySegment mem, int offset) {
        return PacketIO.readUUID(mem, offset + 2);
    }
    
    @Nullable
    public static Integer getMinSectionY(MemorySegment mem) {
        return getMinSectionY(mem, 0);
    }
    
    @Nullable
    public static Integer getMinSectionY(MemorySegment mem, int offset) {
        return hasMinSectionY(mem, offset) ? mem.get(PacketIO.PROTO_INT, offset + 18): null;
    }
    
    @Nullable
    public static Integer getMaxSectionY(MemorySegment mem) {
        return getMaxSectionY(mem, 0);
    }
    
    @Nullable
    public static Integer getMaxSectionY(MemorySegment mem, int offset) {
        return hasMaxSectionY(mem, offset) ? mem.get(PacketIO.PROTO_INT, offset + 22): null;
    }
    
    public static boolean hasMinSectionY(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasMaxSectionY(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    
    
    public static JoinWorld toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static JoinWorld toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one JoinWorld and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static JoinWorld toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new JoinWorld(
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x02) != 0,
            PacketIO.readUUID(mem, offset + 2),
            hasMinSectionY(mem, offset) ? mem.get(PacketIO.PROTO_INT, offset + 18) : null,
            hasMaxSectionY(mem, offset) ? mem.get(PacketIO.PROTO_INT, offset + 22) : null
        );
        if (cursor != null) cursor.position = offset + 26;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.minSectionY != null) nullBits |= 0x01;
        if (this.maxSectionY != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        byte boolBits0_0 = 0;
        if (this.clearWorld) boolBits0_0 |= 0x01;
        if (this.fadeInOut) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 1 + 0, boolBits0_0);
        PacketIO.writeUUID(mem, offset + 2, this.worldUuid);
        if (this.minSectionY != null) {
            mem.set(PacketIO.PROTO_INT, offset + 18, this.minSectionY);
        } else {
            mem.asSlice(offset + 18, 4).fill((byte) 0); 
        }
        if (this.maxSectionY != null) {
            mem.set(PacketIO.PROTO_INT, offset + 22, this.maxSectionY);
        } else {
            mem.asSlice(offset + 22, 4).fill((byte) 0); 
        }
        
        
    
       return 26;
    }
    public int computeSize() {
        return 26;
    }

    public JoinWorld clone() {
        JoinWorld copy = new JoinWorld();
        copy.clearWorld = this.clearWorld;
        copy.fadeInOut = this.fadeInOut;
        copy.worldUuid = this.worldUuid;
        copy.minSectionY = this.minSectionY;
        copy.maxSectionY = this.maxSectionY;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof JoinWorld other)) return false;
        return this.clearWorld == other.clearWorld && this.fadeInOut == other.fadeInOut && java.util.Objects.equals(this.worldUuid, other.worldUuid) && java.util.Objects.equals(this.minSectionY, other.minSectionY) && java.util.Objects.equals(this.maxSectionY, other.maxSectionY);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(clearWorld, fadeInOut, worldUuid, minSectionY, maxSectionY);
    }

}