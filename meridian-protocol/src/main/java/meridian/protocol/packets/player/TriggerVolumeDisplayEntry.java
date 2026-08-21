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

public class TriggerVolumeDisplayEntry {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 70;
    public static final int VARIABLE_FIELD_COUNT = 4;
    public static final int VARIABLE_BLOCK_START = 86;
    public static final int MAX_SIZE = 65536106;

    @Nonnull public String volumeId = "";
    @Nonnull public TriggerVolumeShapeType shapeType = TriggerVolumeShapeType.Box;
    @Nonnull public Vector3fc position = PacketIO.ZERO_VECTOR3;
    @Nonnull public Vector3fc dimensions = PacketIO.ZERO_VECTOR3;
    @Nonnull public Vector3fc color = PacketIO.ZERO_VECTOR3;
    public float opacity;
    @Nullable public String name;
    @Nullable public String groupId;
    public int groupColor;
    @Nullable public String effectAssetRef;
    public byte targetTypes;
    public boolean keepLoaded;
    public boolean cancelDelayedOnExit;
    public float cooldown;
    public byte cooldownMode;
    public float activationDelay;
    @Nonnull public TriggerVolumeConditionTiming conditionTiming = TriggerVolumeConditionTiming.BeforeVolumeDelay;
    @Nonnull public Vector3fc rotation = PacketIO.ZERO_VECTOR3;

    public TriggerVolumeDisplayEntry() {
    }

    public TriggerVolumeDisplayEntry(@Nonnull String volumeId, @Nonnull TriggerVolumeShapeType shapeType, @Nonnull Vector3fc position, @Nonnull Vector3fc dimensions, @Nonnull Vector3fc color, float opacity, @Nullable String name, @Nullable String groupId, int groupColor, @Nullable String effectAssetRef, byte targetTypes, boolean keepLoaded, boolean cancelDelayedOnExit, float cooldown, byte cooldownMode, float activationDelay, @Nonnull TriggerVolumeConditionTiming conditionTiming, @Nonnull Vector3fc rotation) {
        this.volumeId = volumeId;
        this.shapeType = shapeType;
        this.position = position;
        this.dimensions = dimensions;
        this.color = color;
        this.opacity = opacity;
        this.name = name;
        this.groupId = groupId;
        this.groupColor = groupColor;
        this.effectAssetRef = effectAssetRef;
        this.targetTypes = targetTypes;
        this.keepLoaded = keepLoaded;
        this.cancelDelayedOnExit = cancelDelayedOnExit;
        this.cooldown = cooldown;
        this.cooldownMode = cooldownMode;
        this.activationDelay = activationDelay;
        this.conditionTiming = conditionTiming;
        this.rotation = rotation;
    }

    public TriggerVolumeDisplayEntry(@Nonnull TriggerVolumeDisplayEntry other) {
        this.volumeId = other.volumeId;
        this.shapeType = other.shapeType;
        this.position = other.position;
        this.dimensions = other.dimensions;
        this.color = other.color;
        this.opacity = other.opacity;
        this.name = other.name;
        this.groupId = other.groupId;
        this.groupColor = other.groupColor;
        this.effectAssetRef = other.effectAssetRef;
        this.targetTypes = other.targetTypes;
        this.keepLoaded = other.keepLoaded;
        this.cancelDelayedOnExit = other.cancelDelayedOnExit;
        this.cooldown = other.cooldown;
        this.cooldownMode = other.cooldownMode;
        this.activationDelay = other.activationDelay;
        this.conditionTiming = other.conditionTiming;
        this.rotation = other.rotation;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("TriggerVolumeDisplayEntry", offset, (int) mem.byteSize());
        long needed = (long) offset + 86;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("TriggerVolumeDisplayEntry", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getVolumeId(MemorySegment mem) {
        return getVolumeId(mem, 0);
    }
    
    public static String getVolumeId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("VolumeId", mem, offset + getValidatedOffset(mem, offset, 70, 86, "VolumeId"), 4096000);
    }
    
    public static TriggerVolumeShapeType getShapeType(MemorySegment mem) {
        return getShapeType(mem, 0);
    }
    
    public static TriggerVolumeShapeType getShapeType(MemorySegment mem, int offset) {
        return TriggerVolumeShapeType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static Vector3fc getPosition(MemorySegment mem) {
        return getPosition(mem, 0);
    }
    
    public static Vector3fc getPosition(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 2), "Position");
    }
    
    public static Vector3fc getDimensions(MemorySegment mem) {
        return getDimensions(mem, 0);
    }
    
    public static Vector3fc getDimensions(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 14), "Dimensions");
    }
    
    public static Vector3fc getColor(MemorySegment mem) {
        return getColor(mem, 0);
    }
    
    public static Vector3fc getColor(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 26), "Color");
    }
    
    public static float getOpacity(MemorySegment mem) {
        return getOpacity(mem, 0);
    }
    
    public static float getOpacity(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 38), "Opacity");
    }
    
    @Nullable
    public static String getName(MemorySegment mem) {
        return getName(mem, 0);
    }
    
    @Nullable
    public static String getName(MemorySegment mem, int offset) {
        return hasName(mem, offset) ? PacketIO.readVarString("Name", mem, offset + getValidatedOffset(mem, offset, 74, 86, "Name"), 4096000): null;
    }
    
    @Nullable
    public static String getGroupId(MemorySegment mem) {
        return getGroupId(mem, 0);
    }
    
    @Nullable
    public static String getGroupId(MemorySegment mem, int offset) {
        return hasGroupId(mem, offset) ? PacketIO.readVarString("GroupId", mem, offset + getValidatedOffset(mem, offset, 78, 86, "GroupId"), 4096000): null;
    }
    
    public static int getGroupColor(MemorySegment mem) {
        return getGroupColor(mem, 0);
    }
    
    public static int getGroupColor(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 42);
    }
    
    @Nullable
    public static String getEffectAssetRef(MemorySegment mem) {
        return getEffectAssetRef(mem, 0);
    }
    
    @Nullable
    public static String getEffectAssetRef(MemorySegment mem, int offset) {
        return hasEffectAssetRef(mem, offset) ? PacketIO.readVarString("EffectAssetRef", mem, offset + getValidatedOffset(mem, offset, 82, 86, "EffectAssetRef"), 4096000): null;
    }
    
    public static byte getTargetTypes(MemorySegment mem) {
        return getTargetTypes(mem, 0);
    }
    
    public static byte getTargetTypes(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 46);
    }
    
    public static boolean getKeepLoaded(MemorySegment mem) {
        return getKeepLoaded(mem, 0);
    }
    
    public static boolean getKeepLoaded(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 47) & 0x01) != 0;
    }
    
    public static boolean getCancelDelayedOnExit(MemorySegment mem) {
        return getCancelDelayedOnExit(mem, 0);
    }
    
    public static boolean getCancelDelayedOnExit(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 47) & 0x02) != 0;
    }
    
    public static float getCooldown(MemorySegment mem) {
        return getCooldown(mem, 0);
    }
    
    public static float getCooldown(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 48), "Cooldown");
    }
    
    public static byte getCooldownMode(MemorySegment mem) {
        return getCooldownMode(mem, 0);
    }
    
    public static byte getCooldownMode(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 52);
    }
    
    public static float getActivationDelay(MemorySegment mem) {
        return getActivationDelay(mem, 0);
    }
    
    public static float getActivationDelay(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 53), "ActivationDelay");
    }
    
    public static TriggerVolumeConditionTiming getConditionTiming(MemorySegment mem) {
        return getConditionTiming(mem, 0);
    }
    
    public static TriggerVolumeConditionTiming getConditionTiming(MemorySegment mem, int offset) {
        return TriggerVolumeConditionTiming.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 57));
    }
    
    public static Vector3fc getRotation(MemorySegment mem) {
        return getRotation(mem, 0);
    }
    
    public static Vector3fc getRotation(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 58), "Rotation");
    }
    
    public static boolean hasName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasGroupId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasEffectAssetRef(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
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
    
    public static TriggerVolumeDisplayEntry toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static TriggerVolumeDisplayEntry toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one TriggerVolumeDisplayEntry and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static TriggerVolumeDisplayEntry toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 86;
        var varPos = 0;
        String v0;
        requireSlot(mem, offset + 70, varPos, "VolumeId");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("VolumeId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        String v6 = null;
        if (hasName(mem, offset)) {
            requireSlot(mem, offset + 74, varPos, "Name");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v6 = PacketIO.readVarString("Name", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 74, -1, "Name");
        }
        
        String v7 = null;
        if (hasGroupId(mem, offset)) {
            requireSlot(mem, offset + 78, varPos, "GroupId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v7 = PacketIO.readVarString("GroupId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 78, -1, "GroupId");
        }
        
        String v9 = null;
        if (hasEffectAssetRef(mem, offset)) {
            requireSlot(mem, offset + 82, varPos, "EffectAssetRef");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v9 = PacketIO.readVarString("EffectAssetRef", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 82, -1, "EffectAssetRef");
        }
        var result = new TriggerVolumeDisplayEntry(
            v0,
            TriggerVolumeShapeType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 2), "Position"),
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 14), "Dimensions"),
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 26), "Color"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 38), "Opacity"),
            v6,
            v7,
            mem.get(PacketIO.PROTO_INT, offset + 42),
            v9,
            mem.get(PacketIO.PROTO_BYTE, offset + 46),
            (mem.get(PacketIO.PROTO_BYTE, offset + 47) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 47) & 0x02) != 0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 48), "Cooldown"),
            mem.get(PacketIO.PROTO_BYTE, offset + 52),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 53), "ActivationDelay"),
            TriggerVolumeConditionTiming.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 57)),
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 58), "Rotation")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.name != null) nullBits |= 0x01;
        if (this.groupId != null) nullBits |= 0x02;
        if (this.effectAssetRef != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.shapeType.getValue());
        PacketIO.requireFinite(this.position, "Position"); PacketIO.writeVector3f(mem, offset + 2, this.position);
        PacketIO.requireFinite(this.dimensions, "Dimensions"); PacketIO.writeVector3f(mem, offset + 14, this.dimensions);
        PacketIO.requireFinite(this.color, "Color"); PacketIO.writeVector3f(mem, offset + 26, this.color);
        PacketIO.requireFinite(this.opacity, "Opacity"); mem.set(PacketIO.PROTO_FLOAT, offset + 38, this.opacity);
        mem.set(PacketIO.PROTO_INT, offset + 42, this.groupColor);
        mem.set(PacketIO.PROTO_BYTE, offset + 46, this.targetTypes);
        byte boolBits0_0 = 0;
        if (this.keepLoaded) boolBits0_0 |= 0x01;
        if (this.cancelDelayedOnExit) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 47 + 0, boolBits0_0);
        PacketIO.requireFinite(this.cooldown, "Cooldown"); mem.set(PacketIO.PROTO_FLOAT, offset + 48, this.cooldown);
        mem.set(PacketIO.PROTO_BYTE, offset + 52, this.cooldownMode);
        PacketIO.requireFinite(this.activationDelay, "ActivationDelay"); mem.set(PacketIO.PROTO_FLOAT, offset + 53, this.activationDelay);
        mem.set(PacketIO.PROTO_BYTE, offset + 57, (byte) this.conditionTiming.getValue());
        PacketIO.requireFinite(this.rotation, "Rotation"); PacketIO.writeVector3f(mem, offset + 58, this.rotation);
        var varOffset = offset + 86;
        mem.set(PacketIO.PROTO_INT, offset + 70, varOffset - offset - 86);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.volumeId, 4096000);
        if (this.name != null) {
            mem.set(PacketIO.PROTO_INT, offset + 74, varOffset - offset - 86);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.name, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 74, -1);
        }
        if (this.groupId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 78, varOffset - offset - 86);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.groupId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 78, -1);
        }
        if (this.effectAssetRef != null) {
            mem.set(PacketIO.PROTO_INT, offset + 82, varOffset - offset - 86);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.effectAssetRef, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 82, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 86;
        size += PacketIO.stringSize(volumeId);
    if (name != null) size += PacketIO.stringSize(name);
    if (groupId != null) size += PacketIO.stringSize(groupId);
    if (effectAssetRef != null) size += PacketIO.stringSize(effectAssetRef);

        return size;
    }

    public TriggerVolumeDisplayEntry clone() {
        TriggerVolumeDisplayEntry copy = new TriggerVolumeDisplayEntry();
        copy.volumeId = this.volumeId;
        copy.shapeType = this.shapeType;
        copy.position = this.position;
        copy.dimensions = this.dimensions;
        copy.color = this.color;
        copy.opacity = this.opacity;
        copy.name = this.name;
        copy.groupId = this.groupId;
        copy.groupColor = this.groupColor;
        copy.effectAssetRef = this.effectAssetRef;
        copy.targetTypes = this.targetTypes;
        copy.keepLoaded = this.keepLoaded;
        copy.cancelDelayedOnExit = this.cancelDelayedOnExit;
        copy.cooldown = this.cooldown;
        copy.cooldownMode = this.cooldownMode;
        copy.activationDelay = this.activationDelay;
        copy.conditionTiming = this.conditionTiming;
        copy.rotation = this.rotation;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TriggerVolumeDisplayEntry other)) return false;
        return java.util.Objects.equals(this.volumeId, other.volumeId) && java.util.Objects.equals(this.shapeType, other.shapeType) && java.util.Objects.equals(this.position, other.position) && java.util.Objects.equals(this.dimensions, other.dimensions) && java.util.Objects.equals(this.color, other.color) && this.opacity == other.opacity && java.util.Objects.equals(this.name, other.name) && java.util.Objects.equals(this.groupId, other.groupId) && this.groupColor == other.groupColor && java.util.Objects.equals(this.effectAssetRef, other.effectAssetRef) && this.targetTypes == other.targetTypes && this.keepLoaded == other.keepLoaded && this.cancelDelayedOnExit == other.cancelDelayedOnExit && this.cooldown == other.cooldown && this.cooldownMode == other.cooldownMode && this.activationDelay == other.activationDelay && java.util.Objects.equals(this.conditionTiming, other.conditionTiming) && java.util.Objects.equals(this.rotation, other.rotation);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(volumeId, shapeType, position, dimensions, color, opacity, name, groupId, groupColor, effectAssetRef, targetTypes, keepLoaded, cancelDelayedOnExit, cooldown, cooldownMode, activationDelay, conditionTiming, rotation);
    }

}