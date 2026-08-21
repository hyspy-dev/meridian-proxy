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


public class SetAbsentChunks implements Packet, ToClientPacket {
    public static final int PACKET_ID = 181;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 526;

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
    @Nullable public int[] ys;

    public SetAbsentChunks() {
    }

    public SetAbsentChunks(int x, int z, @Nullable int[] ys) {
        this.x = x;
        this.z = z;
        this.ys = ys;
    }

    public SetAbsentChunks(@Nonnull SetAbsentChunks other) {
        this.x = other.x;
        this.z = other.z;
        this.ys = other.ys;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SetAbsentChunks", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SetAbsentChunks", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getX(MemorySegment mem) {
        return getX(mem, 0);
    }
    
    public static int getX(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getZ(MemorySegment mem) {
        return getZ(mem, 0);
    }
    
    public static int getZ(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    @Nullable
    public static int[] getYs(MemorySegment mem) {
        return getYs(mem, 0);
    }
    
    @Nullable
    public static int[] getYs(MemorySegment mem, int offset) {
        if (!hasYs(mem, offset)) return null;
        var off = offset + 9;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Ys");
        var len = (int) packed;
        if (len > 128) throw ProtocolException.arrayTooLong("Ys", len, 128);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Ys", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    public static boolean hasYs(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static SetAbsentChunks toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SetAbsentChunks toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SetAbsentChunks and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SetAbsentChunks toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        int[] v2 = null;
        if (hasYs(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Ys");
            var len = (int) packed;
            if (len > 128) throw ProtocolException.arrayTooLong("Ys", len, 128);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Ys", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v2, 0, len);
            varPos = off + len * 4 - varBase;
        }
        var result = new SetAbsentChunks(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.ys != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.x);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.z);
        var varOffset = offset + 9;
        if (this.ys != null) {
            
            if (ys.length > 128) throw ProtocolException.arrayTooLong("Ys", ys.length, 128);
            varOffset += VarInt.set(mem, varOffset, this.ys.length);
            
            MemorySegment.copy(this.ys, 0, mem, PacketIO.PROTO_INT, varOffset, this.ys.length);
            varOffset += this.ys.length * 4;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (ys != null) size += VarInt.size(ys.length) + ys.length * 4;

        return size;
    }

    public SetAbsentChunks clone() {
        SetAbsentChunks copy = new SetAbsentChunks();
        copy.x = this.x;
        copy.z = this.z;
        copy.ys = this.ys != null ? java.util.Arrays.copyOf(this.ys, this.ys.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SetAbsentChunks other)) return false;
        return this.x == other.x && this.z == other.z && java.util.Arrays.equals(this.ys, other.ys);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(x);
        result = 31 * result + Integer.hashCode(z);
        result = 31 * result + java.util.Arrays.hashCode(ys);
        return result;
    }

}