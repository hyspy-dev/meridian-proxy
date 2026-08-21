// Auto-generated - do not edit
package meridian.protocol.packets.interaction;

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


public class MountNPC implements Packet, ToClientPacket {
    public static final int PACKET_ID = 293;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 16;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 16;
    public static final int MAX_SIZE = 16;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public float anchorX;
    public float anchorY;
    public float anchorZ;
    public int entityId;

    public MountNPC() {
    }

    public MountNPC(float anchorX, float anchorY, float anchorZ, int entityId) {
        this.anchorX = anchorX;
        this.anchorY = anchorY;
        this.anchorZ = anchorZ;
        this.entityId = entityId;
    }

    public MountNPC(@Nonnull MountNPC other) {
        this.anchorX = other.anchorX;
        this.anchorY = other.anchorY;
        this.anchorZ = other.anchorZ;
        this.entityId = other.entityId;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("MountNPC", offset, (int) mem.byteSize());
        long needed = (long) offset + 16;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("MountNPC", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getAnchorX(MemorySegment mem) {
        return getAnchorX(mem, 0);
    }
    
    public static float getAnchorX(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "AnchorX");
    }
    
    public static float getAnchorY(MemorySegment mem) {
        return getAnchorY(mem, 0);
    }
    
    public static float getAnchorY(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "AnchorY");
    }
    
    public static float getAnchorZ(MemorySegment mem) {
        return getAnchorZ(mem, 0);
    }
    
    public static float getAnchorZ(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "AnchorZ");
    }
    
    public static int getEntityId(MemorySegment mem) {
        return getEntityId(mem, 0);
    }
    
    public static int getEntityId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 12);
    }
    
    
    
    
    
    public static MountNPC toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static MountNPC toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one MountNPC and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static MountNPC toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new MountNPC(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "AnchorX"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "AnchorY"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "AnchorZ"),
            mem.get(PacketIO.PROTO_INT, offset + 12)
        );
        if (cursor != null) cursor.position = offset + 16;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.anchorX, "AnchorX"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.anchorX);
        PacketIO.requireFinite(this.anchorY, "AnchorY"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.anchorY);
        PacketIO.requireFinite(this.anchorZ, "AnchorZ"); mem.set(PacketIO.PROTO_FLOAT, offset + 8, this.anchorZ);
        mem.set(PacketIO.PROTO_INT, offset + 12, this.entityId);
        
        
    
       return 16;
    }
    public int computeSize() {
        return 16;
    }

    public MountNPC clone() {
        MountNPC copy = new MountNPC();
        copy.anchorX = this.anchorX;
        copy.anchorY = this.anchorY;
        copy.anchorZ = this.anchorZ;
        copy.entityId = this.entityId;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MountNPC other)) return false;
        return this.anchorX == other.anchorX && this.anchorY == other.anchorY && this.anchorZ == other.anchorZ && this.entityId == other.entityId;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(anchorX, anchorY, anchorZ, entityId);
    }

}