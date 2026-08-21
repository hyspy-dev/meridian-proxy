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


public class BuilderToolColorAction implements Packet, ToServerPacket {
    public static final int PACKET_ID = 433;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 55;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 63;
    public static final int MAX_SIZE = 32768073;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public ColorToolMode mode = ColorToolMode.Coloring;
    public int x;
    public int y;
    public int z;
    public int gradientStartX;
    public int gradientStartY;
    public int gradientStartZ;
    public int gradientEndX;
    public int gradientEndY;
    public int gradientEndZ;
    @Nullable public String gradientMaterials;
    @Nullable public String gradientShape;
    public float playerX;
    public float playerY;
    public float playerZ;
    public boolean shadingLighten;
    public boolean isHoldDownInteraction;
    public int undoGroupSize;

    public BuilderToolColorAction() {
    }

    public BuilderToolColorAction(@Nonnull ColorToolMode mode, int x, int y, int z, int gradientStartX, int gradientStartY, int gradientStartZ, int gradientEndX, int gradientEndY, int gradientEndZ, @Nullable String gradientMaterials, @Nullable String gradientShape, float playerX, float playerY, float playerZ, boolean shadingLighten, boolean isHoldDownInteraction, int undoGroupSize) {
        this.mode = mode;
        this.x = x;
        this.y = y;
        this.z = z;
        this.gradientStartX = gradientStartX;
        this.gradientStartY = gradientStartY;
        this.gradientStartZ = gradientStartZ;
        this.gradientEndX = gradientEndX;
        this.gradientEndY = gradientEndY;
        this.gradientEndZ = gradientEndZ;
        this.gradientMaterials = gradientMaterials;
        this.gradientShape = gradientShape;
        this.playerX = playerX;
        this.playerY = playerY;
        this.playerZ = playerZ;
        this.shadingLighten = shadingLighten;
        this.isHoldDownInteraction = isHoldDownInteraction;
        this.undoGroupSize = undoGroupSize;
    }

    public BuilderToolColorAction(@Nonnull BuilderToolColorAction other) {
        this.mode = other.mode;
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
        this.gradientStartX = other.gradientStartX;
        this.gradientStartY = other.gradientStartY;
        this.gradientStartZ = other.gradientStartZ;
        this.gradientEndX = other.gradientEndX;
        this.gradientEndY = other.gradientEndY;
        this.gradientEndZ = other.gradientEndZ;
        this.gradientMaterials = other.gradientMaterials;
        this.gradientShape = other.gradientShape;
        this.playerX = other.playerX;
        this.playerY = other.playerY;
        this.playerZ = other.playerZ;
        this.shadingLighten = other.shadingLighten;
        this.isHoldDownInteraction = other.isHoldDownInteraction;
        this.undoGroupSize = other.undoGroupSize;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolColorAction", offset, (int) mem.byteSize());
        long needed = (long) offset + 63;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolColorAction", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static ColorToolMode getMode(MemorySegment mem) {
        return getMode(mem, 0);
    }
    
    public static ColorToolMode getMode(MemorySegment mem, int offset) {
        return ColorToolMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static int getX(MemorySegment mem) {
        return getX(mem, 0);
    }
    
    public static int getX(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 2);
    }
    
    public static int getY(MemorySegment mem) {
        return getY(mem, 0);
    }
    
    public static int getY(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 6);
    }
    
    public static int getZ(MemorySegment mem) {
        return getZ(mem, 0);
    }
    
    public static int getZ(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 10);
    }
    
    public static int getGradientStartX(MemorySegment mem) {
        return getGradientStartX(mem, 0);
    }
    
    public static int getGradientStartX(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 14);
    }
    
    public static int getGradientStartY(MemorySegment mem) {
        return getGradientStartY(mem, 0);
    }
    
    public static int getGradientStartY(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 18);
    }
    
    public static int getGradientStartZ(MemorySegment mem) {
        return getGradientStartZ(mem, 0);
    }
    
    public static int getGradientStartZ(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 22);
    }
    
    public static int getGradientEndX(MemorySegment mem) {
        return getGradientEndX(mem, 0);
    }
    
    public static int getGradientEndX(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 26);
    }
    
    public static int getGradientEndY(MemorySegment mem) {
        return getGradientEndY(mem, 0);
    }
    
    public static int getGradientEndY(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 30);
    }
    
    public static int getGradientEndZ(MemorySegment mem) {
        return getGradientEndZ(mem, 0);
    }
    
    public static int getGradientEndZ(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 34);
    }
    
    @Nullable
    public static String getGradientMaterials(MemorySegment mem) {
        return getGradientMaterials(mem, 0);
    }
    
    @Nullable
    public static String getGradientMaterials(MemorySegment mem, int offset) {
        return hasGradientMaterials(mem, offset) ? PacketIO.readVarString("GradientMaterials", mem, offset + getValidatedOffset(mem, offset, 55, 63, "GradientMaterials"), 4096000): null;
    }
    
    @Nullable
    public static String getGradientShape(MemorySegment mem) {
        return getGradientShape(mem, 0);
    }
    
    @Nullable
    public static String getGradientShape(MemorySegment mem, int offset) {
        return hasGradientShape(mem, offset) ? PacketIO.readVarString("GradientShape", mem, offset + getValidatedOffset(mem, offset, 59, 63, "GradientShape"), 4096000): null;
    }
    
    public static float getPlayerX(MemorySegment mem) {
        return getPlayerX(mem, 0);
    }
    
    public static float getPlayerX(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 38), "PlayerX");
    }
    
    public static float getPlayerY(MemorySegment mem) {
        return getPlayerY(mem, 0);
    }
    
    public static float getPlayerY(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 42), "PlayerY");
    }
    
    public static float getPlayerZ(MemorySegment mem) {
        return getPlayerZ(mem, 0);
    }
    
    public static float getPlayerZ(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 46), "PlayerZ");
    }
    
    public static boolean getShadingLighten(MemorySegment mem) {
        return getShadingLighten(mem, 0);
    }
    
    public static boolean getShadingLighten(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 50) & 0x01) != 0;
    }
    
    public static boolean getIsHoldDownInteraction(MemorySegment mem) {
        return getIsHoldDownInteraction(mem, 0);
    }
    
    public static boolean getIsHoldDownInteraction(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 50) & 0x02) != 0;
    }
    
    public static int getUndoGroupSize(MemorySegment mem) {
        return getUndoGroupSize(mem, 0);
    }
    
    public static int getUndoGroupSize(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 51);
    }
    
    public static boolean hasGradientMaterials(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasGradientShape(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    private static int getValidatedOffset(MemorySegment buffer, int base, int slotPosition, int varBlockStart, String fieldName) {
        int offset = buffer.get(PacketIO.PROTO_INT, base + slotPosition);
        if (offset < 0 || offset > buffer.byteSize() - base - varBlockStart)
            throw ProtocolException.invalidOffset(fieldName, offset, (int) buffer.byteSize());
        return varBlockStart + offset;
    }
    
    /**
     * Rejects an offset slot that does not name the position the field-order walk reached. A
     * present field must sit where the previous field ended, and an absent field carries -1, so
     * the slot a random-access getter resolves and the walk describe the same bytes.
     */
    private static void requireSlot(MemorySegment mem, int slotPosition, int expected, String fieldName) {
        int slot = mem.get(PacketIO.PROTO_INT, slotPosition);
        if (slot != expected) throw ProtocolException.nonCanonicalLayout(fieldName, slot, expected);
    }
    
    public static BuilderToolColorAction toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolColorAction toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolColorAction and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolColorAction toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 63;
        var varPos = 0;
        String v10 = null;
        if (hasGradientMaterials(mem, offset)) {
            requireSlot(mem, offset + 55, varPos, "GradientMaterials");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v10 = PacketIO.readVarString("GradientMaterials", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 55, -1, "GradientMaterials");
        }
        
        String v11 = null;
        if (hasGradientShape(mem, offset)) {
            requireSlot(mem, offset + 59, varPos, "GradientShape");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v11 = PacketIO.readVarString("GradientShape", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 59, -1, "GradientShape");
        }
        var result = new BuilderToolColorAction(
            ColorToolMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            mem.get(PacketIO.PROTO_INT, offset + 2),
            mem.get(PacketIO.PROTO_INT, offset + 6),
            mem.get(PacketIO.PROTO_INT, offset + 10),
            mem.get(PacketIO.PROTO_INT, offset + 14),
            mem.get(PacketIO.PROTO_INT, offset + 18),
            mem.get(PacketIO.PROTO_INT, offset + 22),
            mem.get(PacketIO.PROTO_INT, offset + 26),
            mem.get(PacketIO.PROTO_INT, offset + 30),
            mem.get(PacketIO.PROTO_INT, offset + 34),
            v10,
            v11,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 38), "PlayerX"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 42), "PlayerY"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 46), "PlayerZ"),
            (mem.get(PacketIO.PROTO_BYTE, offset + 50) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 50) & 0x02) != 0,
            mem.get(PacketIO.PROTO_INT, offset + 51)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.gradientMaterials != null) nullBits |= 0x01;
        if (this.gradientShape != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.mode.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 2, this.x);
        mem.set(PacketIO.PROTO_INT, offset + 6, this.y);
        mem.set(PacketIO.PROTO_INT, offset + 10, this.z);
        mem.set(PacketIO.PROTO_INT, offset + 14, this.gradientStartX);
        mem.set(PacketIO.PROTO_INT, offset + 18, this.gradientStartY);
        mem.set(PacketIO.PROTO_INT, offset + 22, this.gradientStartZ);
        mem.set(PacketIO.PROTO_INT, offset + 26, this.gradientEndX);
        mem.set(PacketIO.PROTO_INT, offset + 30, this.gradientEndY);
        mem.set(PacketIO.PROTO_INT, offset + 34, this.gradientEndZ);
        PacketIO.requireFinite(this.playerX, "PlayerX"); mem.set(PacketIO.PROTO_FLOAT, offset + 38, this.playerX);
        PacketIO.requireFinite(this.playerY, "PlayerY"); mem.set(PacketIO.PROTO_FLOAT, offset + 42, this.playerY);
        PacketIO.requireFinite(this.playerZ, "PlayerZ"); mem.set(PacketIO.PROTO_FLOAT, offset + 46, this.playerZ);
        byte boolBits0_0 = 0;
        if (this.shadingLighten) boolBits0_0 |= 0x01;
        if (this.isHoldDownInteraction) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 50 + 0, boolBits0_0);
        mem.set(PacketIO.PROTO_INT, offset + 51, this.undoGroupSize);
        var varOffset = offset + 63;
        if (this.gradientMaterials != null) {
            mem.set(PacketIO.PROTO_INT, offset + 55, varOffset - offset - 63);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.gradientMaterials, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 55, -1);
        }
        if (this.gradientShape != null) {
            mem.set(PacketIO.PROTO_INT, offset + 59, varOffset - offset - 63);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.gradientShape, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 59, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 63;
        if (gradientMaterials != null) size += PacketIO.stringSize(gradientMaterials);
    if (gradientShape != null) size += PacketIO.stringSize(gradientShape);

        return size;
    }

    public BuilderToolColorAction clone() {
        BuilderToolColorAction copy = new BuilderToolColorAction();
        copy.mode = this.mode;
        copy.x = this.x;
        copy.y = this.y;
        copy.z = this.z;
        copy.gradientStartX = this.gradientStartX;
        copy.gradientStartY = this.gradientStartY;
        copy.gradientStartZ = this.gradientStartZ;
        copy.gradientEndX = this.gradientEndX;
        copy.gradientEndY = this.gradientEndY;
        copy.gradientEndZ = this.gradientEndZ;
        copy.gradientMaterials = this.gradientMaterials;
        copy.gradientShape = this.gradientShape;
        copy.playerX = this.playerX;
        copy.playerY = this.playerY;
        copy.playerZ = this.playerZ;
        copy.shadingLighten = this.shadingLighten;
        copy.isHoldDownInteraction = this.isHoldDownInteraction;
        copy.undoGroupSize = this.undoGroupSize;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolColorAction other)) return false;
        return java.util.Objects.equals(this.mode, other.mode) && this.x == other.x && this.y == other.y && this.z == other.z && this.gradientStartX == other.gradientStartX && this.gradientStartY == other.gradientStartY && this.gradientStartZ == other.gradientStartZ && this.gradientEndX == other.gradientEndX && this.gradientEndY == other.gradientEndY && this.gradientEndZ == other.gradientEndZ && java.util.Objects.equals(this.gradientMaterials, other.gradientMaterials) && java.util.Objects.equals(this.gradientShape, other.gradientShape) && this.playerX == other.playerX && this.playerY == other.playerY && this.playerZ == other.playerZ && this.shadingLighten == other.shadingLighten && this.isHoldDownInteraction == other.isHoldDownInteraction && this.undoGroupSize == other.undoGroupSize;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(mode, x, y, z, gradientStartX, gradientStartY, gradientStartZ, gradientEndX, gradientEndY, gradientEndZ, gradientMaterials, gradientShape, playerX, playerY, playerZ, shadingLighten, isHoldDownInteraction, undoGroupSize);
    }

}