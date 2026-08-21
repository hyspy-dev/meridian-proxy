// Auto-generated - do not edit
package meridian.protocol.packets.buildertools;

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


public class BuilderToolLineAction implements Packet, ToServerPacket {
    public static final int PACKET_ID = 414;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 24;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 24;
    public static final int MAX_SIZE = 24;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int xStart;
    public int yStart;
    public int zStart;
    public int xEnd;
    public int yEnd;
    public int zEnd;

    public BuilderToolLineAction() {
    }

    public BuilderToolLineAction(int xStart, int yStart, int zStart, int xEnd, int yEnd, int zEnd) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.zStart = zStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        this.zEnd = zEnd;
    }

    public BuilderToolLineAction(@Nonnull BuilderToolLineAction other) {
        this.xStart = other.xStart;
        this.yStart = other.yStart;
        this.zStart = other.zStart;
        this.xEnd = other.xEnd;
        this.yEnd = other.yEnd;
        this.zEnd = other.zEnd;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolLineAction", offset, (int) mem.byteSize());
        long needed = (long) offset + 24;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolLineAction", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getXStart(MemorySegment mem) {
        return getXStart(mem, 0);
    }
    
    public static int getXStart(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static int getYStart(MemorySegment mem) {
        return getYStart(mem, 0);
    }
    
    public static int getYStart(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 4);
    }
    
    public static int getZStart(MemorySegment mem) {
        return getZStart(mem, 0);
    }
    
    public static int getZStart(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 8);
    }
    
    public static int getXEnd(MemorySegment mem) {
        return getXEnd(mem, 0);
    }
    
    public static int getXEnd(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 12);
    }
    
    public static int getYEnd(MemorySegment mem) {
        return getYEnd(mem, 0);
    }
    
    public static int getYEnd(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 16);
    }
    
    public static int getZEnd(MemorySegment mem) {
        return getZEnd(mem, 0);
    }
    
    public static int getZEnd(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 20);
    }
    
    
    
    
    
    public static BuilderToolLineAction toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolLineAction toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolLineAction and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolLineAction toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BuilderToolLineAction(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4),
            mem.get(PacketIO.PROTO_INT, offset + 8),
            mem.get(PacketIO.PROTO_INT, offset + 12),
            mem.get(PacketIO.PROTO_INT, offset + 16),
            mem.get(PacketIO.PROTO_INT, offset + 20)
        );
        if (cursor != null) cursor.position = offset + 24;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.xStart);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.yStart);
        mem.set(PacketIO.PROTO_INT, offset + 8, this.zStart);
        mem.set(PacketIO.PROTO_INT, offset + 12, this.xEnd);
        mem.set(PacketIO.PROTO_INT, offset + 16, this.yEnd);
        mem.set(PacketIO.PROTO_INT, offset + 20, this.zEnd);
        
        
    
       return 24;
    }
    public int computeSize() {
        return 24;
    }

    public BuilderToolLineAction clone() {
        BuilderToolLineAction copy = new BuilderToolLineAction();
        copy.xStart = this.xStart;
        copy.yStart = this.yStart;
        copy.zStart = this.zStart;
        copy.xEnd = this.xEnd;
        copy.yEnd = this.yEnd;
        copy.zEnd = this.zEnd;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolLineAction other)) return false;
        return this.xStart == other.xStart && this.yStart == other.yStart && this.zStart == other.zStart && this.xEnd == other.xEnd && this.yEnd == other.yEnd && this.zEnd == other.zEnd;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(xStart, yStart, zStart, xEnd, yEnd, zEnd);
    }

}