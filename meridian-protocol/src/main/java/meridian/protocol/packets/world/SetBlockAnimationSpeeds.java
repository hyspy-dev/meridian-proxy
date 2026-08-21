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


public class SetBlockAnimationSpeeds implements Packet, ToClientPacket {
    public static final int PACKET_ID = 253;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 20;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 20;
    public static final int MAX_SIZE = 557081;

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
    public long revision;
    @Nonnull public BlockAnimationEntry[] entries = new BlockAnimationEntry[0];

    public SetBlockAnimationSpeeds() {
    }

    public SetBlockAnimationSpeeds(int x, int y, int z, long revision, @Nonnull BlockAnimationEntry[] entries) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.revision = revision;
        this.entries = entries;
    }

    public SetBlockAnimationSpeeds(@Nonnull SetBlockAnimationSpeeds other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
        this.revision = other.revision;
        this.entries = other.entries;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SetBlockAnimationSpeeds", offset, (int) mem.byteSize());
        long needed = (long) offset + 20;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SetBlockAnimationSpeeds", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
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
    
    public static long getRevision(MemorySegment mem) {
        return getRevision(mem, 0);
    }
    
    public static long getRevision(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_LONG, offset + 12);
    }
    
    public static BlockAnimationEntry[] getEntries(MemorySegment mem) {
        return getEntries(mem, 0);
    }
    
    public static BlockAnimationEntry[] getEntries(MemorySegment mem, int offset) {
        var off = offset + 20;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Entries");
        var len = (int) packed;
        if (len > 32768) throw ProtocolException.arrayTooLong("Entries", len, 32768);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Entries", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new BlockAnimationEntry[len];
        for (var i = 0; i < len; i++) {
            data[i] = BlockAnimationEntry.toObject(mem, off + i * 17);
        }
        return data;
    }
    
    
    
    
    
    public static SetBlockAnimationSpeeds toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SetBlockAnimationSpeeds toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SetBlockAnimationSpeeds and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SetBlockAnimationSpeeds toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 20;
        var varPos = 0;
        BlockAnimationEntry[] v4;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Entries");
            var len = (int) packed;
            if (len > 32768) throw ProtocolException.arrayTooLong("Entries", len, 32768);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Entries", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v4 = new BlockAnimationEntry[len];
            for (var i = 0; i < len; i++) {
                v4[i] = BlockAnimationEntry.toObject(mem, off + i * 17);
            }
            varPos = off + len * 17 - varBase;
        }
        var result = new SetBlockAnimationSpeeds(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4),
            mem.get(PacketIO.PROTO_INT, offset + 8),
            mem.get(PacketIO.PROTO_LONG, offset + 12),
            v4
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.x);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.y);
        mem.set(PacketIO.PROTO_INT, offset + 8, this.z);
        mem.set(PacketIO.PROTO_LONG, offset + 12, this.revision);
        var varOffset = offset + 20;
        if (entries.length > 32768) throw ProtocolException.arrayTooLong("Entries", entries.length, 32768);
        varOffset += VarInt.set(mem, varOffset, this.entries.length);
        
        var entriesValueOffset = 0;
        for (var i = 0; i < this.entries.length; i++) {
            entriesValueOffset += this.entries[i].serialize(mem, varOffset + entriesValueOffset);
        }
        varOffset += entriesValueOffset;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 20;
        size += VarInt.size(entries.length) + entries.length * 17;

        return size;
    }

    public SetBlockAnimationSpeeds clone() {
        SetBlockAnimationSpeeds copy = new SetBlockAnimationSpeeds();
        copy.x = this.x;
        copy.y = this.y;
        copy.z = this.z;
        copy.revision = this.revision;
        copy.entries = java.util.Arrays.stream(this.entries).map(e -> e.clone()).toArray(BlockAnimationEntry[]::new);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SetBlockAnimationSpeeds other)) return false;
        return this.x == other.x && this.y == other.y && this.z == other.z && this.revision == other.revision && java.util.Arrays.equals(this.entries, other.entries);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(x);
        result = 31 * result + Integer.hashCode(y);
        result = 31 * result + Integer.hashCode(z);
        result = 31 * result + Long.hashCode(revision);
        result = 31 * result + java.util.Arrays.hashCode(entries);
        return result;
    }

}