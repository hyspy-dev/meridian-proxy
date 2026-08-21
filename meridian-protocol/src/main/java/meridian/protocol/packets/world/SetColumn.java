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


public class SetColumn implements Packet, ToClientPacket {
    public static final int PACKET_ID = 138;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 8;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 20;
    public static final int MAX_SIZE = 12288035;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Chunks;
    }

    public int x;
    public int z;
    @Nonnull public byte[] heightmap = new byte[0];
    @Nonnull public byte[] tintmap = new byte[0];
    @Nonnull public byte[] environments = new byte[0];

    public SetColumn() {
    }

    public SetColumn(int x, int z, @Nonnull byte[] heightmap, @Nonnull byte[] tintmap, @Nonnull byte[] environments) {
        this.x = x;
        this.z = z;
        this.heightmap = heightmap;
        this.tintmap = tintmap;
        this.environments = environments;
    }

    public SetColumn(@Nonnull SetColumn other) {
        this.x = other.x;
        this.z = other.z;
        this.heightmap = other.heightmap;
        this.tintmap = other.tintmap;
        this.environments = other.environments;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SetColumn", offset, (int) mem.byteSize());
        long needed = (long) offset + 20;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SetColumn", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getX(MemorySegment mem) {
        return getX(mem, 0);
    }
    
    public static int getX(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static int getZ(MemorySegment mem) {
        return getZ(mem, 0);
    }
    
    public static int getZ(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 4);
    }
    
    public static byte[] getHeightmap(MemorySegment mem) {
        return getHeightmap(mem, 0);
    }
    
    public static byte[] getHeightmap(MemorySegment mem, int offset) {
        var off = offset + getValidatedOffset(mem, offset, 8, 20, "Heightmap");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Heightmap");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Heightmap", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Heightmap", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new byte[len];
        MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, data, 0, len);
        return data;
    }
    
    public static byte[] getTintmap(MemorySegment mem) {
        return getTintmap(mem, 0);
    }
    
    public static byte[] getTintmap(MemorySegment mem, int offset) {
        var off = offset + getValidatedOffset(mem, offset, 12, 20, "Tintmap");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Tintmap");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Tintmap", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Tintmap", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new byte[len];
        MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, data, 0, len);
        return data;
    }
    
    public static byte[] getEnvironments(MemorySegment mem) {
        return getEnvironments(mem, 0);
    }
    
    public static byte[] getEnvironments(MemorySegment mem, int offset) {
        var off = offset + getValidatedOffset(mem, offset, 16, 20, "Environments");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Environments");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Environments", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Environments", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new byte[len];
        MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, data, 0, len);
        return data;
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
    
    public static SetColumn toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SetColumn toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SetColumn and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SetColumn toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 20;
        var varPos = 0;
        byte[] v2;
        requireSlot(mem, offset + 8, varPos, "Heightmap");
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Heightmap");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Heightmap", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Heightmap", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v2, 0, len);
            varPos = off + len - varBase;
        }
        
        byte[] v3;
        requireSlot(mem, offset + 12, varPos, "Tintmap");
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Tintmap");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Tintmap", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Tintmap", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v3 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v3, 0, len);
            varPos = off + len - varBase;
        }
        
        byte[] v4;
        requireSlot(mem, offset + 16, varPos, "Environments");
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Environments");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Environments", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Environments", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v4 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v4, 0, len);
            varPos = off + len - varBase;
        }
        var result = new SetColumn(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4),
            v2,
            v3,
            v4
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.x);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.z);
        var varOffset = offset + 20;
        mem.set(PacketIO.PROTO_INT, offset + 8, varOffset - offset - 20);
        if (heightmap.length > 4096000) throw ProtocolException.arrayTooLong("Heightmap", heightmap.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.heightmap.length);
        
        MemorySegment.copy(this.heightmap, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.heightmap.length);
        varOffset += this.heightmap.length * 1;
        mem.set(PacketIO.PROTO_INT, offset + 12, varOffset - offset - 20);
        if (tintmap.length > 4096000) throw ProtocolException.arrayTooLong("Tintmap", tintmap.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.tintmap.length);
        
        MemorySegment.copy(this.tintmap, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.tintmap.length);
        varOffset += this.tintmap.length * 1;
        mem.set(PacketIO.PROTO_INT, offset + 16, varOffset - offset - 20);
        if (environments.length > 4096000) throw ProtocolException.arrayTooLong("Environments", environments.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.environments.length);
        
        MemorySegment.copy(this.environments, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.environments.length);
        varOffset += this.environments.length * 1;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 20;
        size += VarInt.size(heightmap.length) + heightmap.length * 1;
    size += VarInt.size(tintmap.length) + tintmap.length * 1;
    size += VarInt.size(environments.length) + environments.length * 1;

        return size;
    }

    public SetColumn clone() {
        SetColumn copy = new SetColumn();
        copy.x = this.x;
        copy.z = this.z;
        copy.heightmap = java.util.Arrays.copyOf(this.heightmap, this.heightmap.length);
        copy.tintmap = java.util.Arrays.copyOf(this.tintmap, this.tintmap.length);
        copy.environments = java.util.Arrays.copyOf(this.environments, this.environments.length);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SetColumn other)) return false;
        return this.x == other.x && this.z == other.z && java.util.Arrays.equals(this.heightmap, other.heightmap) && java.util.Arrays.equals(this.tintmap, other.tintmap) && java.util.Arrays.equals(this.environments, other.environments);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(x);
        result = 31 * result + Integer.hashCode(z);
        result = 31 * result + java.util.Arrays.hashCode(heightmap);
        result = 31 * result + java.util.Arrays.hashCode(tintmap);
        result = 31 * result + java.util.Arrays.hashCode(environments);
        return result;
    }

}