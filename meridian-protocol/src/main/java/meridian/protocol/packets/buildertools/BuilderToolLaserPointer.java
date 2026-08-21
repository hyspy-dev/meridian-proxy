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


public class BuilderToolLaserPointer implements Packet, ToClientPacket {
    public static final int PACKET_ID = 419;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 36;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 36;
    public static final int MAX_SIZE = 36;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int playerNetworkId;
    public float startX;
    public float startY;
    public float startZ;
    public float endX;
    public float endY;
    public float endZ;
    public int color;
    public int durationMs;

    public BuilderToolLaserPointer() {
    }

    public BuilderToolLaserPointer(int playerNetworkId, float startX, float startY, float startZ, float endX, float endY, float endZ, int color, int durationMs) {
        this.playerNetworkId = playerNetworkId;
        this.startX = startX;
        this.startY = startY;
        this.startZ = startZ;
        this.endX = endX;
        this.endY = endY;
        this.endZ = endZ;
        this.color = color;
        this.durationMs = durationMs;
    }

    public BuilderToolLaserPointer(@Nonnull BuilderToolLaserPointer other) {
        this.playerNetworkId = other.playerNetworkId;
        this.startX = other.startX;
        this.startY = other.startY;
        this.startZ = other.startZ;
        this.endX = other.endX;
        this.endY = other.endY;
        this.endZ = other.endZ;
        this.color = other.color;
        this.durationMs = other.durationMs;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolLaserPointer", offset, (int) mem.byteSize());
        long needed = (long) offset + 36;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolLaserPointer", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getPlayerNetworkId(MemorySegment mem) {
        return getPlayerNetworkId(mem, 0);
    }
    
    public static int getPlayerNetworkId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static float getStartX(MemorySegment mem) {
        return getStartX(mem, 0);
    }
    
    public static float getStartX(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "StartX");
    }
    
    public static float getStartY(MemorySegment mem) {
        return getStartY(mem, 0);
    }
    
    public static float getStartY(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "StartY");
    }
    
    public static float getStartZ(MemorySegment mem) {
        return getStartZ(mem, 0);
    }
    
    public static float getStartZ(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "StartZ");
    }
    
    public static float getEndX(MemorySegment mem) {
        return getEndX(mem, 0);
    }
    
    public static float getEndX(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "EndX");
    }
    
    public static float getEndY(MemorySegment mem) {
        return getEndY(mem, 0);
    }
    
    public static float getEndY(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "EndY");
    }
    
    public static float getEndZ(MemorySegment mem) {
        return getEndZ(mem, 0);
    }
    
    public static float getEndZ(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 24), "EndZ");
    }
    
    public static int getColor(MemorySegment mem) {
        return getColor(mem, 0);
    }
    
    public static int getColor(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 28);
    }
    
    public static int getDurationMs(MemorySegment mem) {
        return getDurationMs(mem, 0);
    }
    
    public static int getDurationMs(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 32);
    }
    
    
    
    
    
    public static BuilderToolLaserPointer toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolLaserPointer toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolLaserPointer and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolLaserPointer toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BuilderToolLaserPointer(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "StartX"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "StartY"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "StartZ"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "EndX"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "EndY"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 24), "EndZ"),
            mem.get(PacketIO.PROTO_INT, offset + 28),
            mem.get(PacketIO.PROTO_INT, offset + 32)
        );
        if (cursor != null) cursor.position = offset + 36;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.playerNetworkId);
        PacketIO.requireFinite(this.startX, "StartX"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.startX);
        PacketIO.requireFinite(this.startY, "StartY"); mem.set(PacketIO.PROTO_FLOAT, offset + 8, this.startY);
        PacketIO.requireFinite(this.startZ, "StartZ"); mem.set(PacketIO.PROTO_FLOAT, offset + 12, this.startZ);
        PacketIO.requireFinite(this.endX, "EndX"); mem.set(PacketIO.PROTO_FLOAT, offset + 16, this.endX);
        PacketIO.requireFinite(this.endY, "EndY"); mem.set(PacketIO.PROTO_FLOAT, offset + 20, this.endY);
        PacketIO.requireFinite(this.endZ, "EndZ"); mem.set(PacketIO.PROTO_FLOAT, offset + 24, this.endZ);
        mem.set(PacketIO.PROTO_INT, offset + 28, this.color);
        mem.set(PacketIO.PROTO_INT, offset + 32, this.durationMs);
        
        
    
       return 36;
    }
    public int computeSize() {
        return 36;
    }

    public BuilderToolLaserPointer clone() {
        BuilderToolLaserPointer copy = new BuilderToolLaserPointer();
        copy.playerNetworkId = this.playerNetworkId;
        copy.startX = this.startX;
        copy.startY = this.startY;
        copy.startZ = this.startZ;
        copy.endX = this.endX;
        copy.endY = this.endY;
        copy.endZ = this.endZ;
        copy.color = this.color;
        copy.durationMs = this.durationMs;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolLaserPointer other)) return false;
        return this.playerNetworkId == other.playerNetworkId && this.startX == other.startX && this.startY == other.startY && this.startZ == other.startZ && this.endX == other.endX && this.endY == other.endY && this.endZ == other.endZ && this.color == other.color && this.durationMs == other.durationMs;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(playerNetworkId, startX, startY, startZ, endX, endY, endZ, color, durationMs);
    }

}