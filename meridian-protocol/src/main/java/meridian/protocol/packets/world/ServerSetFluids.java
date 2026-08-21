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


public class ServerSetFluids implements Packet, ToClientPacket {
    public static final int PACKET_ID = 143;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 12;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 12;
    public static final int MAX_SIZE = 28672017;

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
    @Nonnull public SetFluidCmd[] cmds = new SetFluidCmd[0];

    public ServerSetFluids() {
    }

    public ServerSetFluids(int x, int y, int z, @Nonnull SetFluidCmd[] cmds) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.cmds = cmds;
    }

    public ServerSetFluids(@Nonnull ServerSetFluids other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
        this.cmds = other.cmds;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ServerSetFluids", offset, (int) mem.byteSize());
        long needed = (long) offset + 12;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ServerSetFluids", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getX(MemorySegment mem) {
        return getX(mem, 0);
    }
    
    public static int getX(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static int getY(MemorySegment mem) {
        return getY(mem, 0);
    }
    
    public static int getY(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 4);
    }
    
    public static int getZ(MemorySegment mem) {
        return getZ(mem, 0);
    }
    
    public static int getZ(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 8);
    }
    
    public static SetFluidCmd[] getCmds(MemorySegment mem) {
        return getCmds(mem, 0);
    }
    
    public static SetFluidCmd[] getCmds(MemorySegment mem, int offset) {
        var off = offset + 12;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Cmds");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Cmds", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 7 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Cmds", (int) java.lang.Math.min(off + lenOffset + (long) len * 7, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new SetFluidCmd[len];
        for (var i = 0; i < len; i++) {
            data[i] = SetFluidCmd.toObject(mem, off + i * 7);
        }
        return data;
    }
    
    
    
    
    
    public static ServerSetFluids toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ServerSetFluids toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ServerSetFluids and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ServerSetFluids toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 12;
        var varPos = 0;
        SetFluidCmd[] v3;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Cmds");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Cmds", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 7 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Cmds", (int) java.lang.Math.min(off + lenOffset + (long) len * 7, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v3 = new SetFluidCmd[len];
            for (var i = 0; i < len; i++) {
                v3[i] = SetFluidCmd.toObject(mem, off + i * 7);
            }
            varPos = off + len * 7 - varBase;
        }
        var result = new ServerSetFluids(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4),
            mem.get(PacketIO.PROTO_INT, offset + 8),
            v3
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.x);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.y);
        mem.set(PacketIO.PROTO_INT, offset + 8, this.z);
        var varOffset = offset + 12;
        if (cmds.length > 4096000) throw ProtocolException.arrayTooLong("Cmds", cmds.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.cmds.length);
        
        var cmdsValueOffset = 0;
        for (var i = 0; i < this.cmds.length; i++) {
            cmdsValueOffset += this.cmds[i].serialize(mem, varOffset + cmdsValueOffset);
        }
        varOffset += cmdsValueOffset;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 12;
        size += VarInt.size(cmds.length) + cmds.length * 7;

        return size;
    }

    public ServerSetFluids clone() {
        ServerSetFluids copy = new ServerSetFluids();
        copy.x = this.x;
        copy.y = this.y;
        copy.z = this.z;
        copy.cmds = java.util.Arrays.stream(this.cmds).map(e -> e.clone()).toArray(SetFluidCmd[]::new);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ServerSetFluids other)) return false;
        return this.x == other.x && this.y == other.y && this.z == other.z && java.util.Arrays.equals(this.cmds, other.cmds);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(x);
        result = 31 * result + Integer.hashCode(y);
        result = 31 * result + Integer.hashCode(z);
        result = 31 * result + java.util.Arrays.hashCode(cmds);
        return result;
    }

}