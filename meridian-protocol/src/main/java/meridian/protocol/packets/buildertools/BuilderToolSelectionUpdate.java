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


public class BuilderToolSelectionUpdate implements Packet, ToServerPacket {
    public static final int PACKET_ID = 409;
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

    public int xMin;
    public int yMin;
    public int zMin;
    public int xMax;
    public int yMax;
    public int zMax;

    public BuilderToolSelectionUpdate() {
    }

    public BuilderToolSelectionUpdate(int xMin, int yMin, int zMin, int xMax, int yMax, int zMax) {
        this.xMin = xMin;
        this.yMin = yMin;
        this.zMin = zMin;
        this.xMax = xMax;
        this.yMax = yMax;
        this.zMax = zMax;
    }

    public BuilderToolSelectionUpdate(@Nonnull BuilderToolSelectionUpdate other) {
        this.xMin = other.xMin;
        this.yMin = other.yMin;
        this.zMin = other.zMin;
        this.xMax = other.xMax;
        this.yMax = other.yMax;
        this.zMax = other.zMax;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolSelectionUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 24;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolSelectionUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getXMin(MemorySegment mem) {
        return getXMin(mem, 0);
    }
    
    public static int getXMin(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static int getYMin(MemorySegment mem) {
        return getYMin(mem, 0);
    }
    
    public static int getYMin(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 4);
    }
    
    public static int getZMin(MemorySegment mem) {
        return getZMin(mem, 0);
    }
    
    public static int getZMin(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 8);
    }
    
    public static int getXMax(MemorySegment mem) {
        return getXMax(mem, 0);
    }
    
    public static int getXMax(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 12);
    }
    
    public static int getYMax(MemorySegment mem) {
        return getYMax(mem, 0);
    }
    
    public static int getYMax(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 16);
    }
    
    public static int getZMax(MemorySegment mem) {
        return getZMax(mem, 0);
    }
    
    public static int getZMax(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 20);
    }
    
    
    
    
    
    public static BuilderToolSelectionUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolSelectionUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolSelectionUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolSelectionUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BuilderToolSelectionUpdate(
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
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.xMin);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.yMin);
        mem.set(PacketIO.PROTO_INT, offset + 8, this.zMin);
        mem.set(PacketIO.PROTO_INT, offset + 12, this.xMax);
        mem.set(PacketIO.PROTO_INT, offset + 16, this.yMax);
        mem.set(PacketIO.PROTO_INT, offset + 20, this.zMax);
        
        
    
       return 24;
    }
    public int computeSize() {
        return 24;
    }

    public BuilderToolSelectionUpdate clone() {
        BuilderToolSelectionUpdate copy = new BuilderToolSelectionUpdate();
        copy.xMin = this.xMin;
        copy.yMin = this.yMin;
        copy.zMin = this.zMin;
        copy.xMax = this.xMax;
        copy.yMax = this.yMax;
        copy.zMax = this.zMax;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolSelectionUpdate other)) return false;
        return this.xMin == other.xMin && this.yMin == other.yMin && this.zMin == other.zMin && this.xMax == other.xMax && this.yMax == other.yMax && this.zMax == other.zMax;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(xMin, yMin, zMin, xMax, yMax, zMax);
    }

}