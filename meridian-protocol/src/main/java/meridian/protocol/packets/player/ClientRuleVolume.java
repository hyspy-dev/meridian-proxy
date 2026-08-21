// Auto-generated - do not edit
package meridian.protocol.packets.player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import org.joml.*;

public class ClientRuleVolume {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 39;
    public static final int VARIABLE_FIELD_COUNT = 4;
    public static final int VARIABLE_BLOCK_START = 55;
    public static final int MAX_SIZE = 1677721600;

    public byte rules;
    @Nonnull public TriggerVolumeShapeType shapeType = TriggerVolumeShapeType.Box;
    @Nonnull public Vector3fc position = PacketIO.ZERO_VECTOR3;
    @Nonnull public Vector3fc dimensions = PacketIO.ZERO_VECTOR3;
    @Nonnull public Vector3fc rotation = PacketIO.ZERO_VECTOR3;
    @Nullable public int[] buildExceptBlocks;
    @Nullable public int[] destroyExceptBlocks;
    @Nullable public String[] destroyExceptTools;
    @Nullable public int[] harvestExceptBlocks;

    public ClientRuleVolume() {
    }

    public ClientRuleVolume(byte rules, @Nonnull TriggerVolumeShapeType shapeType, @Nonnull Vector3fc position, @Nonnull Vector3fc dimensions, @Nonnull Vector3fc rotation, @Nullable int[] buildExceptBlocks, @Nullable int[] destroyExceptBlocks, @Nullable String[] destroyExceptTools, @Nullable int[] harvestExceptBlocks) {
        this.rules = rules;
        this.shapeType = shapeType;
        this.position = position;
        this.dimensions = dimensions;
        this.rotation = rotation;
        this.buildExceptBlocks = buildExceptBlocks;
        this.destroyExceptBlocks = destroyExceptBlocks;
        this.destroyExceptTools = destroyExceptTools;
        this.harvestExceptBlocks = harvestExceptBlocks;
    }

    public ClientRuleVolume(@Nonnull ClientRuleVolume other) {
        this.rules = other.rules;
        this.shapeType = other.shapeType;
        this.position = other.position;
        this.dimensions = other.dimensions;
        this.rotation = other.rotation;
        this.buildExceptBlocks = other.buildExceptBlocks;
        this.destroyExceptBlocks = other.destroyExceptBlocks;
        this.destroyExceptTools = other.destroyExceptTools;
        this.harvestExceptBlocks = other.harvestExceptBlocks;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ClientRuleVolume", offset, (int) mem.byteSize());
        long needed = (long) offset + 55;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ClientRuleVolume", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static byte getRules(MemorySegment mem) {
        return getRules(mem, 0);
    }
    
    public static byte getRules(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 1);
    }
    
    public static TriggerVolumeShapeType getShapeType(MemorySegment mem) {
        return getShapeType(mem, 0);
    }
    
    public static TriggerVolumeShapeType getShapeType(MemorySegment mem, int offset) {
        return TriggerVolumeShapeType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2));
    }
    
    public static Vector3fc getPosition(MemorySegment mem) {
        return getPosition(mem, 0);
    }
    
    public static Vector3fc getPosition(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 3), "Position");
    }
    
    public static Vector3fc getDimensions(MemorySegment mem) {
        return getDimensions(mem, 0);
    }
    
    public static Vector3fc getDimensions(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 15), "Dimensions");
    }
    
    public static Vector3fc getRotation(MemorySegment mem) {
        return getRotation(mem, 0);
    }
    
    public static Vector3fc getRotation(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 27), "Rotation");
    }
    
    @Nullable
    public static int[] getBuildExceptBlocks(MemorySegment mem) {
        return getBuildExceptBlocks(mem, 0);
    }
    
    @Nullable
    public static int[] getBuildExceptBlocks(MemorySegment mem, int offset) {
        if (!hasBuildExceptBlocks(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 39, 55, "BuildExceptBlocks");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("BuildExceptBlocks");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("BuildExceptBlocks", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuildExceptBlocks", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    @Nullable
    public static int[] getDestroyExceptBlocks(MemorySegment mem) {
        return getDestroyExceptBlocks(mem, 0);
    }
    
    @Nullable
    public static int[] getDestroyExceptBlocks(MemorySegment mem, int offset) {
        if (!hasDestroyExceptBlocks(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 43, 55, "DestroyExceptBlocks");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("DestroyExceptBlocks");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("DestroyExceptBlocks", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("DestroyExceptBlocks", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    @Nullable
    public static String[] getDestroyExceptTools(MemorySegment mem) {
        return getDestroyExceptTools(mem, 0);
    }
    
    @Nullable
    public static String[] getDestroyExceptTools(MemorySegment mem, int offset) {
        if (!hasDestroyExceptTools(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 47, 55, "DestroyExceptTools");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("DestroyExceptTools");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("DestroyExceptTools", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("DestroyExceptTools", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("DestroyExceptTools", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    @Nullable
    public static int[] getHarvestExceptBlocks(MemorySegment mem) {
        return getHarvestExceptBlocks(mem, 0);
    }
    
    @Nullable
    public static int[] getHarvestExceptBlocks(MemorySegment mem, int offset) {
        if (!hasHarvestExceptBlocks(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 51, 55, "HarvestExceptBlocks");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("HarvestExceptBlocks");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("HarvestExceptBlocks", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("HarvestExceptBlocks", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    public static boolean hasBuildExceptBlocks(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasDestroyExceptBlocks(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasDestroyExceptTools(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasHarvestExceptBlocks(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
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
    
    public static ClientRuleVolume toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ClientRuleVolume toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ClientRuleVolume and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ClientRuleVolume toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 55;
        var varPos = 0;
        int[] v5 = null;
        if (hasBuildExceptBlocks(mem, offset)) {
            requireSlot(mem, offset + 39, varPos, "BuildExceptBlocks");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("BuildExceptBlocks");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("BuildExceptBlocks", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuildExceptBlocks", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v5 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v5, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 39, -1, "BuildExceptBlocks");
        }
        
        int[] v6 = null;
        if (hasDestroyExceptBlocks(mem, offset)) {
            requireSlot(mem, offset + 43, varPos, "DestroyExceptBlocks");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("DestroyExceptBlocks");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("DestroyExceptBlocks", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("DestroyExceptBlocks", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v6 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v6, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 43, -1, "DestroyExceptBlocks");
        }
        
        String[] v7 = null;
        if (hasDestroyExceptTools(mem, offset)) {
            requireSlot(mem, offset + 47, varPos, "DestroyExceptTools");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("DestroyExceptTools");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("DestroyExceptTools", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("DestroyExceptTools", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v7 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v7[i] = PacketIO.readVarString("DestroyExceptTools", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 47, -1, "DestroyExceptTools");
        }
        
        int[] v8 = null;
        if (hasHarvestExceptBlocks(mem, offset)) {
            requireSlot(mem, offset + 51, varPos, "HarvestExceptBlocks");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("HarvestExceptBlocks");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("HarvestExceptBlocks", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("HarvestExceptBlocks", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v8 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v8, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 51, -1, "HarvestExceptBlocks");
        }
        var result = new ClientRuleVolume(
            mem.get(PacketIO.PROTO_BYTE, offset + 1),
            TriggerVolumeShapeType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2)),
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 3), "Position"),
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 15), "Dimensions"),
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 27), "Rotation"),
            v5,
            v6,
            v7,
            v8
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.buildExceptBlocks != null) nullBits |= 0x01;
        if (this.destroyExceptBlocks != null) nullBits |= 0x02;
        if (this.destroyExceptTools != null) nullBits |= 0x04;
        if (this.harvestExceptBlocks != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, this.rules);
        mem.set(PacketIO.PROTO_BYTE, offset + 2, (byte) this.shapeType.getValue());
        PacketIO.requireFinite(this.position, "Position"); PacketIO.writeVector3f(mem, offset + 3, this.position);
        PacketIO.requireFinite(this.dimensions, "Dimensions"); PacketIO.writeVector3f(mem, offset + 15, this.dimensions);
        PacketIO.requireFinite(this.rotation, "Rotation"); PacketIO.writeVector3f(mem, offset + 27, this.rotation);
        var varOffset = offset + 55;
        if (this.buildExceptBlocks != null) {
            mem.set(PacketIO.PROTO_INT, offset + 39, varOffset - offset - 55);
            if (buildExceptBlocks.length > 4096000) throw ProtocolException.arrayTooLong("BuildExceptBlocks", buildExceptBlocks.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.buildExceptBlocks.length);
            
            MemorySegment.copy(this.buildExceptBlocks, 0, mem, PacketIO.PROTO_INT, varOffset, this.buildExceptBlocks.length);
            varOffset += this.buildExceptBlocks.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 39, -1);
        }
        if (this.destroyExceptBlocks != null) {
            mem.set(PacketIO.PROTO_INT, offset + 43, varOffset - offset - 55);
            if (destroyExceptBlocks.length > 4096000) throw ProtocolException.arrayTooLong("DestroyExceptBlocks", destroyExceptBlocks.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.destroyExceptBlocks.length);
            
            MemorySegment.copy(this.destroyExceptBlocks, 0, mem, PacketIO.PROTO_INT, varOffset, this.destroyExceptBlocks.length);
            varOffset += this.destroyExceptBlocks.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 43, -1);
        }
        if (this.destroyExceptTools != null) {
            mem.set(PacketIO.PROTO_INT, offset + 47, varOffset - offset - 55);
            if (destroyExceptTools.length > 4096000) throw ProtocolException.arrayTooLong("DestroyExceptTools", destroyExceptTools.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.destroyExceptTools.length);
            
            var destroyExceptToolsValueOffset = 0;
            for (var i = 0; i < this.destroyExceptTools.length; i++) {
                destroyExceptToolsValueOffset += PacketIO.writeVarString(mem, varOffset + destroyExceptToolsValueOffset, this.destroyExceptTools[i], 4096000);
            }
            varOffset += destroyExceptToolsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 47, -1);
        }
        if (this.harvestExceptBlocks != null) {
            mem.set(PacketIO.PROTO_INT, offset + 51, varOffset - offset - 55);
            if (harvestExceptBlocks.length > 4096000) throw ProtocolException.arrayTooLong("HarvestExceptBlocks", harvestExceptBlocks.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.harvestExceptBlocks.length);
            
            MemorySegment.copy(this.harvestExceptBlocks, 0, mem, PacketIO.PROTO_INT, varOffset, this.harvestExceptBlocks.length);
            varOffset += this.harvestExceptBlocks.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 51, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 55;
        if (buildExceptBlocks != null) size += VarInt.size(buildExceptBlocks.length) + buildExceptBlocks.length * 4;
    if (destroyExceptBlocks != null) size += VarInt.size(destroyExceptBlocks.length) + destroyExceptBlocks.length * 4;
    if (destroyExceptTools != null) {
        int destroyExceptToolsSize = 0;
for (var elem : destroyExceptTools) destroyExceptToolsSize += PacketIO.stringSize(elem);
size += VarInt.size(destroyExceptTools.length) + destroyExceptToolsSize;
    }
    if (harvestExceptBlocks != null) size += VarInt.size(harvestExceptBlocks.length) + harvestExceptBlocks.length * 4;

        return size;
    }

    public ClientRuleVolume clone() {
        ClientRuleVolume copy = new ClientRuleVolume();
        copy.rules = this.rules;
        copy.shapeType = this.shapeType;
        copy.position = this.position;
        copy.dimensions = this.dimensions;
        copy.rotation = this.rotation;
        copy.buildExceptBlocks = this.buildExceptBlocks != null ? java.util.Arrays.copyOf(this.buildExceptBlocks, this.buildExceptBlocks.length) : null;
        copy.destroyExceptBlocks = this.destroyExceptBlocks != null ? java.util.Arrays.copyOf(this.destroyExceptBlocks, this.destroyExceptBlocks.length) : null;
        copy.destroyExceptTools = this.destroyExceptTools != null ? java.util.Arrays.copyOf(this.destroyExceptTools, this.destroyExceptTools.length) : null;
        copy.harvestExceptBlocks = this.harvestExceptBlocks != null ? java.util.Arrays.copyOf(this.harvestExceptBlocks, this.harvestExceptBlocks.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ClientRuleVolume other)) return false;
        return this.rules == other.rules && java.util.Objects.equals(this.shapeType, other.shapeType) && java.util.Objects.equals(this.position, other.position) && java.util.Objects.equals(this.dimensions, other.dimensions) && java.util.Objects.equals(this.rotation, other.rotation) && java.util.Arrays.equals(this.buildExceptBlocks, other.buildExceptBlocks) && java.util.Arrays.equals(this.destroyExceptBlocks, other.destroyExceptBlocks) && java.util.Arrays.equals(this.destroyExceptTools, other.destroyExceptTools) && java.util.Arrays.equals(this.harvestExceptBlocks, other.harvestExceptBlocks);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Byte.hashCode(rules);
        result = 31 * result + java.util.Objects.hashCode(shapeType);
        result = 31 * result + java.util.Objects.hashCode(position);
        result = 31 * result + java.util.Objects.hashCode(dimensions);
        result = 31 * result + java.util.Objects.hashCode(rotation);
        result = 31 * result + java.util.Arrays.hashCode(buildExceptBlocks);
        result = 31 * result + java.util.Arrays.hashCode(destroyExceptBlocks);
        result = 31 * result + java.util.Arrays.hashCode(destroyExceptTools);
        result = 31 * result + java.util.Arrays.hashCode(harvestExceptBlocks);
        return result;
    }

}