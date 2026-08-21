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


public class SetFluids implements Packet, ToClientPacket {
    public static final int PACKET_ID = 136;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 13;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 4096018;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Chunks;
    }

    public int x;
    public int y;
    public int z;
    @Nullable public byte[] data;

    public SetFluids() {
    }

    public SetFluids(int x, int y, int z, @Nullable byte[] data) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.data = data;
    }

    public SetFluids(@Nonnull SetFluids other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
        this.data = other.data;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SetFluids", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SetFluids", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getX(MemorySegment mem) {
        return getX(mem, 0);
    }
    
    public static int getX(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getY(MemorySegment mem) {
        return getY(mem, 0);
    }
    
    public static int getY(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static int getZ(MemorySegment mem) {
        return getZ(mem, 0);
    }
    
    public static int getZ(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 9);
    }
    
    @Nullable
    public static byte[] getData(MemorySegment mem) {
        return getData(mem, 0);
    }
    
    @Nullable
    public static byte[] getData(MemorySegment mem, int offset) {
        if (!hasData(mem, offset)) return null;
        var off = offset + 13;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Data");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Data", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Data", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new byte[len];
        MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, data, 0, len);
        return data;
    }
    
    public static boolean hasData(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static SetFluids toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SetFluids toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SetFluids and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SetFluids toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 13;
        var varPos = 0;
        byte[] v3 = null;
        if (hasData(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Data");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Data", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Data", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v3 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v3, 0, len);
            varPos = off + len - varBase;
        }
        var result = new SetFluids(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            mem.get(PacketIO.PROTO_INT, offset + 9),
            v3
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.data != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.x);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.y);
        mem.set(PacketIO.PROTO_INT, offset + 9, this.z);
        var varOffset = offset + 13;
        if (this.data != null) {
            
            if (data.length > 4096000) throw ProtocolException.arrayTooLong("Data", data.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.data.length);
            
            MemorySegment.copy(this.data, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.data.length);
            varOffset += this.data.length * 1;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 13;
        if (data != null) size += VarInt.size(data.length) + data.length * 1;

        return size;
    }

    public SetFluids clone() {
        SetFluids copy = new SetFluids();
        copy.x = this.x;
        copy.y = this.y;
        copy.z = this.z;
        copy.data = this.data != null ? java.util.Arrays.copyOf(this.data, this.data.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SetFluids other)) return false;
        return this.x == other.x && this.y == other.y && this.z == other.z && java.util.Arrays.equals(this.data, other.data);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(x);
        result = 31 * result + Integer.hashCode(y);
        result = 31 * result + Integer.hashCode(z);
        result = 31 * result + java.util.Arrays.hashCode(data);
        return result;
    }

}