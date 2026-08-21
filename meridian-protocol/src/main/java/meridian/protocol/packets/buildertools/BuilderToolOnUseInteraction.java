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
import meridian.protocol.InteractionType;

public class BuilderToolOnUseInteraction implements Packet, ToServerPacket {
    public static final int PACKET_ID = 413;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 58;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 58;
    public static final int MAX_SIZE = 58;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public InteractionType type = InteractionType.Primary;
    public int x;
    public int y;
    public int z;
    public int offsetForPaintModeX;
    public int offsetForPaintModeY;
    public int offsetForPaintModeZ;
    public boolean isAltPlaySculptBrushModDown;
    public boolean isHoldDownInteraction;
    public boolean isDoServerRaytraceForPosition;
    public int maxLengthToolIgnoreHistory;
    public float raycastOriginX;
    public float raycastOriginY;
    public float raycastOriginZ;
    public float raycastDirectionX;
    public float raycastDirectionY;
    public float raycastDirectionZ;
    public int undoGroupSize;

    public BuilderToolOnUseInteraction() {
    }

    public BuilderToolOnUseInteraction(@Nonnull InteractionType type, int x, int y, int z, int offsetForPaintModeX, int offsetForPaintModeY, int offsetForPaintModeZ, boolean isAltPlaySculptBrushModDown, boolean isHoldDownInteraction, boolean isDoServerRaytraceForPosition, int maxLengthToolIgnoreHistory, float raycastOriginX, float raycastOriginY, float raycastOriginZ, float raycastDirectionX, float raycastDirectionY, float raycastDirectionZ, int undoGroupSize) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.z = z;
        this.offsetForPaintModeX = offsetForPaintModeX;
        this.offsetForPaintModeY = offsetForPaintModeY;
        this.offsetForPaintModeZ = offsetForPaintModeZ;
        this.isAltPlaySculptBrushModDown = isAltPlaySculptBrushModDown;
        this.isHoldDownInteraction = isHoldDownInteraction;
        this.isDoServerRaytraceForPosition = isDoServerRaytraceForPosition;
        this.maxLengthToolIgnoreHistory = maxLengthToolIgnoreHistory;
        this.raycastOriginX = raycastOriginX;
        this.raycastOriginY = raycastOriginY;
        this.raycastOriginZ = raycastOriginZ;
        this.raycastDirectionX = raycastDirectionX;
        this.raycastDirectionY = raycastDirectionY;
        this.raycastDirectionZ = raycastDirectionZ;
        this.undoGroupSize = undoGroupSize;
    }

    public BuilderToolOnUseInteraction(@Nonnull BuilderToolOnUseInteraction other) {
        this.type = other.type;
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
        this.offsetForPaintModeX = other.offsetForPaintModeX;
        this.offsetForPaintModeY = other.offsetForPaintModeY;
        this.offsetForPaintModeZ = other.offsetForPaintModeZ;
        this.isAltPlaySculptBrushModDown = other.isAltPlaySculptBrushModDown;
        this.isHoldDownInteraction = other.isHoldDownInteraction;
        this.isDoServerRaytraceForPosition = other.isDoServerRaytraceForPosition;
        this.maxLengthToolIgnoreHistory = other.maxLengthToolIgnoreHistory;
        this.raycastOriginX = other.raycastOriginX;
        this.raycastOriginY = other.raycastOriginY;
        this.raycastOriginZ = other.raycastOriginZ;
        this.raycastDirectionX = other.raycastDirectionX;
        this.raycastDirectionY = other.raycastDirectionY;
        this.raycastDirectionZ = other.raycastDirectionZ;
        this.undoGroupSize = other.undoGroupSize;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolOnUseInteraction", offset, (int) mem.byteSize());
        long needed = (long) offset + 58;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolOnUseInteraction", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static InteractionType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static InteractionType getType(MemorySegment mem, int offset) {
        return InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0));
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
    
    public static int getOffsetForPaintModeX(MemorySegment mem) {
        return getOffsetForPaintModeX(mem, 0);
    }
    
    public static int getOffsetForPaintModeX(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 13);
    }
    
    public static int getOffsetForPaintModeY(MemorySegment mem) {
        return getOffsetForPaintModeY(mem, 0);
    }
    
    public static int getOffsetForPaintModeY(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 17);
    }
    
    public static int getOffsetForPaintModeZ(MemorySegment mem) {
        return getOffsetForPaintModeZ(mem, 0);
    }
    
    public static int getOffsetForPaintModeZ(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 21);
    }
    
    public static boolean getIsAltPlaySculptBrushModDown(MemorySegment mem) {
        return getIsAltPlaySculptBrushModDown(mem, 0);
    }
    
    public static boolean getIsAltPlaySculptBrushModDown(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 25) & 0x01) != 0;
    }
    
    public static boolean getIsHoldDownInteraction(MemorySegment mem) {
        return getIsHoldDownInteraction(mem, 0);
    }
    
    public static boolean getIsHoldDownInteraction(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 25) & 0x02) != 0;
    }
    
    public static boolean getIsDoServerRaytraceForPosition(MemorySegment mem) {
        return getIsDoServerRaytraceForPosition(mem, 0);
    }
    
    public static boolean getIsDoServerRaytraceForPosition(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 25) & 0x04) != 0;
    }
    
    public static int getMaxLengthToolIgnoreHistory(MemorySegment mem) {
        return getMaxLengthToolIgnoreHistory(mem, 0);
    }
    
    public static int getMaxLengthToolIgnoreHistory(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 26);
    }
    
    public static float getRaycastOriginX(MemorySegment mem) {
        return getRaycastOriginX(mem, 0);
    }
    
    public static float getRaycastOriginX(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 30), "RaycastOriginX");
    }
    
    public static float getRaycastOriginY(MemorySegment mem) {
        return getRaycastOriginY(mem, 0);
    }
    
    public static float getRaycastOriginY(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 34), "RaycastOriginY");
    }
    
    public static float getRaycastOriginZ(MemorySegment mem) {
        return getRaycastOriginZ(mem, 0);
    }
    
    public static float getRaycastOriginZ(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 38), "RaycastOriginZ");
    }
    
    public static float getRaycastDirectionX(MemorySegment mem) {
        return getRaycastDirectionX(mem, 0);
    }
    
    public static float getRaycastDirectionX(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 42), "RaycastDirectionX");
    }
    
    public static float getRaycastDirectionY(MemorySegment mem) {
        return getRaycastDirectionY(mem, 0);
    }
    
    public static float getRaycastDirectionY(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 46), "RaycastDirectionY");
    }
    
    public static float getRaycastDirectionZ(MemorySegment mem) {
        return getRaycastDirectionZ(mem, 0);
    }
    
    public static float getRaycastDirectionZ(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 50), "RaycastDirectionZ");
    }
    
    public static int getUndoGroupSize(MemorySegment mem) {
        return getUndoGroupSize(mem, 0);
    }
    
    public static int getUndoGroupSize(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 54);
    }
    
    
    
    
    
    public static BuilderToolOnUseInteraction toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolOnUseInteraction toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolOnUseInteraction and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolOnUseInteraction toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BuilderToolOnUseInteraction(
            InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0)),
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            mem.get(PacketIO.PROTO_INT, offset + 9),
            mem.get(PacketIO.PROTO_INT, offset + 13),
            mem.get(PacketIO.PROTO_INT, offset + 17),
            mem.get(PacketIO.PROTO_INT, offset + 21),
            (mem.get(PacketIO.PROTO_BYTE, offset + 25) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 25) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 25) & 0x04) != 0,
            mem.get(PacketIO.PROTO_INT, offset + 26),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 30), "RaycastOriginX"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 34), "RaycastOriginY"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 38), "RaycastOriginZ"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 42), "RaycastDirectionX"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 46), "RaycastDirectionY"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 50), "RaycastDirectionZ"),
            mem.get(PacketIO.PROTO_INT, offset + 54)
        );
        if (cursor != null) cursor.position = offset + 58;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, (byte) this.type.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 1, this.x);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.y);
        mem.set(PacketIO.PROTO_INT, offset + 9, this.z);
        mem.set(PacketIO.PROTO_INT, offset + 13, this.offsetForPaintModeX);
        mem.set(PacketIO.PROTO_INT, offset + 17, this.offsetForPaintModeY);
        mem.set(PacketIO.PROTO_INT, offset + 21, this.offsetForPaintModeZ);
        byte boolBits0_0 = 0;
        if (this.isAltPlaySculptBrushModDown) boolBits0_0 |= 0x01;
        if (this.isHoldDownInteraction) boolBits0_0 |= 0x02;
        if (this.isDoServerRaytraceForPosition) boolBits0_0 |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 25 + 0, boolBits0_0);
        mem.set(PacketIO.PROTO_INT, offset + 26, this.maxLengthToolIgnoreHistory);
        PacketIO.requireFinite(this.raycastOriginX, "RaycastOriginX"); mem.set(PacketIO.PROTO_FLOAT, offset + 30, this.raycastOriginX);
        PacketIO.requireFinite(this.raycastOriginY, "RaycastOriginY"); mem.set(PacketIO.PROTO_FLOAT, offset + 34, this.raycastOriginY);
        PacketIO.requireFinite(this.raycastOriginZ, "RaycastOriginZ"); mem.set(PacketIO.PROTO_FLOAT, offset + 38, this.raycastOriginZ);
        PacketIO.requireFinite(this.raycastDirectionX, "RaycastDirectionX"); mem.set(PacketIO.PROTO_FLOAT, offset + 42, this.raycastDirectionX);
        PacketIO.requireFinite(this.raycastDirectionY, "RaycastDirectionY"); mem.set(PacketIO.PROTO_FLOAT, offset + 46, this.raycastDirectionY);
        PacketIO.requireFinite(this.raycastDirectionZ, "RaycastDirectionZ"); mem.set(PacketIO.PROTO_FLOAT, offset + 50, this.raycastDirectionZ);
        mem.set(PacketIO.PROTO_INT, offset + 54, this.undoGroupSize);
        
        
    
       return 58;
    }
    public int computeSize() {
        return 58;
    }

    public BuilderToolOnUseInteraction clone() {
        BuilderToolOnUseInteraction copy = new BuilderToolOnUseInteraction();
        copy.type = this.type;
        copy.x = this.x;
        copy.y = this.y;
        copy.z = this.z;
        copy.offsetForPaintModeX = this.offsetForPaintModeX;
        copy.offsetForPaintModeY = this.offsetForPaintModeY;
        copy.offsetForPaintModeZ = this.offsetForPaintModeZ;
        copy.isAltPlaySculptBrushModDown = this.isAltPlaySculptBrushModDown;
        copy.isHoldDownInteraction = this.isHoldDownInteraction;
        copy.isDoServerRaytraceForPosition = this.isDoServerRaytraceForPosition;
        copy.maxLengthToolIgnoreHistory = this.maxLengthToolIgnoreHistory;
        copy.raycastOriginX = this.raycastOriginX;
        copy.raycastOriginY = this.raycastOriginY;
        copy.raycastOriginZ = this.raycastOriginZ;
        copy.raycastDirectionX = this.raycastDirectionX;
        copy.raycastDirectionY = this.raycastDirectionY;
        copy.raycastDirectionZ = this.raycastDirectionZ;
        copy.undoGroupSize = this.undoGroupSize;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolOnUseInteraction other)) return false;
        return java.util.Objects.equals(this.type, other.type) && this.x == other.x && this.y == other.y && this.z == other.z && this.offsetForPaintModeX == other.offsetForPaintModeX && this.offsetForPaintModeY == other.offsetForPaintModeY && this.offsetForPaintModeZ == other.offsetForPaintModeZ && this.isAltPlaySculptBrushModDown == other.isAltPlaySculptBrushModDown && this.isHoldDownInteraction == other.isHoldDownInteraction && this.isDoServerRaytraceForPosition == other.isDoServerRaytraceForPosition && this.maxLengthToolIgnoreHistory == other.maxLengthToolIgnoreHistory && this.raycastOriginX == other.raycastOriginX && this.raycastOriginY == other.raycastOriginY && this.raycastOriginZ == other.raycastOriginZ && this.raycastDirectionX == other.raycastDirectionX && this.raycastDirectionY == other.raycastDirectionY && this.raycastDirectionZ == other.raycastDirectionZ && this.undoGroupSize == other.undoGroupSize;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(type, x, y, z, offsetForPaintModeX, offsetForPaintModeY, offsetForPaintModeZ, isAltPlaySculptBrushModDown, isHoldDownInteraction, isDoServerRaytraceForPosition, maxLengthToolIgnoreHistory, raycastOriginX, raycastOriginY, raycastOriginZ, raycastDirectionX, raycastDirectionY, raycastDirectionZ, undoGroupSize);
    }

}