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


public class BuilderToolExtrudeAction implements Packet, ToServerPacket {
    public static final int PACKET_ID = 403;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 30;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 30;
    public static final int MAX_SIZE = 30;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int x;
    public int y;
    public int z;
    public int xNormal;
    public int yNormal;
    public int zNormal;
    @Nonnull public ExtrudeMode mode = ExtrudeMode.Extrude;
    public boolean isHoldDownInteraction;
    public int undoGroupSize;

    public BuilderToolExtrudeAction() {
    }

    public BuilderToolExtrudeAction(int x, int y, int z, int xNormal, int yNormal, int zNormal, @Nonnull ExtrudeMode mode, boolean isHoldDownInteraction, int undoGroupSize) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.xNormal = xNormal;
        this.yNormal = yNormal;
        this.zNormal = zNormal;
        this.mode = mode;
        this.isHoldDownInteraction = isHoldDownInteraction;
        this.undoGroupSize = undoGroupSize;
    }

    public BuilderToolExtrudeAction(@Nonnull BuilderToolExtrudeAction other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
        this.xNormal = other.xNormal;
        this.yNormal = other.yNormal;
        this.zNormal = other.zNormal;
        this.mode = other.mode;
        this.isHoldDownInteraction = other.isHoldDownInteraction;
        this.undoGroupSize = other.undoGroupSize;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolExtrudeAction", offset, (int) mem.byteSize());
        long needed = (long) offset + 30;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolExtrudeAction", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
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
    
    public static int getXNormal(MemorySegment mem) {
        return getXNormal(mem, 0);
    }
    
    public static int getXNormal(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 12);
    }
    
    public static int getYNormal(MemorySegment mem) {
        return getYNormal(mem, 0);
    }
    
    public static int getYNormal(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 16);
    }
    
    public static int getZNormal(MemorySegment mem) {
        return getZNormal(mem, 0);
    }
    
    public static int getZNormal(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 20);
    }
    
    public static ExtrudeMode getMode(MemorySegment mem) {
        return getMode(mem, 0);
    }
    
    public static ExtrudeMode getMode(MemorySegment mem, int offset) {
        return ExtrudeMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 24));
    }
    
    public static boolean getIsHoldDownInteraction(MemorySegment mem) {
        return getIsHoldDownInteraction(mem, 0);
    }
    
    public static boolean getIsHoldDownInteraction(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 25);
    }
    
    public static int getUndoGroupSize(MemorySegment mem) {
        return getUndoGroupSize(mem, 0);
    }
    
    public static int getUndoGroupSize(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 26);
    }
    
    
    
    
    
    public static BuilderToolExtrudeAction toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolExtrudeAction toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolExtrudeAction and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolExtrudeAction toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BuilderToolExtrudeAction(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4),
            mem.get(PacketIO.PROTO_INT, offset + 8),
            mem.get(PacketIO.PROTO_INT, offset + 12),
            mem.get(PacketIO.PROTO_INT, offset + 16),
            mem.get(PacketIO.PROTO_INT, offset + 20),
            ExtrudeMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 24)),
            mem.get(PacketIO.PROTO_BOOL, offset + 25),
            mem.get(PacketIO.PROTO_INT, offset + 26)
        );
        if (cursor != null) cursor.position = offset + 30;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.x);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.y);
        mem.set(PacketIO.PROTO_INT, offset + 8, this.z);
        mem.set(PacketIO.PROTO_INT, offset + 12, this.xNormal);
        mem.set(PacketIO.PROTO_INT, offset + 16, this.yNormal);
        mem.set(PacketIO.PROTO_INT, offset + 20, this.zNormal);
        mem.set(PacketIO.PROTO_BYTE, offset + 24, (byte) this.mode.getValue());
        mem.set(PacketIO.PROTO_BOOL, offset + 25, this.isHoldDownInteraction);
        mem.set(PacketIO.PROTO_INT, offset + 26, this.undoGroupSize);
        
        
    
       return 30;
    }
    public int computeSize() {
        return 30;
    }

    public BuilderToolExtrudeAction clone() {
        BuilderToolExtrudeAction copy = new BuilderToolExtrudeAction();
        copy.x = this.x;
        copy.y = this.y;
        copy.z = this.z;
        copy.xNormal = this.xNormal;
        copy.yNormal = this.yNormal;
        copy.zNormal = this.zNormal;
        copy.mode = this.mode;
        copy.isHoldDownInteraction = this.isHoldDownInteraction;
        copy.undoGroupSize = this.undoGroupSize;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolExtrudeAction other)) return false;
        return this.x == other.x && this.y == other.y && this.z == other.z && this.xNormal == other.xNormal && this.yNormal == other.yNormal && this.zNormal == other.zNormal && java.util.Objects.equals(this.mode, other.mode) && this.isHoldDownInteraction == other.isHoldDownInteraction && this.undoGroupSize == other.undoGroupSize;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, y, z, xNormal, yNormal, zNormal, mode, isHoldDownInteraction, undoGroupSize);
    }

}