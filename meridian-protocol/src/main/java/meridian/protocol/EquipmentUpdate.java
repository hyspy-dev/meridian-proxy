// Auto-generated - do not edit
package meridian.protocol;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class EquipmentUpdate extends ComponentUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String[] armorIds;
    @Nullable public String rightHandItemId;
    @Nullable public String leftHandItemId;

    public EquipmentUpdate() {
    }

    public EquipmentUpdate(@Nullable String[] armorIds, @Nullable String rightHandItemId, @Nullable String leftHandItemId) {
        this.armorIds = armorIds;
        this.rightHandItemId = rightHandItemId;
        this.leftHandItemId = leftHandItemId;
    }

    public EquipmentUpdate(@Nonnull EquipmentUpdate other) {
        this.armorIds = other.armorIds;
        this.rightHandItemId = other.rightHandItemId;
        this.leftHandItemId = other.leftHandItemId;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("EquipmentUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("EquipmentUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String[] getArmorIds(MemorySegment mem) {
        return getArmorIds(mem, 0);
    }
    
    @Nullable
    public static String[] getArmorIds(MemorySegment mem, int offset) {
        if (!hasArmorIds(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 1, 13, "ArmorIds");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ArmorIds");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("ArmorIds", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("ArmorIds", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("ArmorIds", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    @Nullable
    public static String getRightHandItemId(MemorySegment mem) {
        return getRightHandItemId(mem, 0);
    }
    
    @Nullable
    public static String getRightHandItemId(MemorySegment mem, int offset) {
        return hasRightHandItemId(mem, offset) ? PacketIO.readVarString("RightHandItemId", mem, offset + getValidatedOffset(mem, offset, 5, 13, "RightHandItemId"), 4096000): null;
    }
    
    @Nullable
    public static String getLeftHandItemId(MemorySegment mem) {
        return getLeftHandItemId(mem, 0);
    }
    
    @Nullable
    public static String getLeftHandItemId(MemorySegment mem, int offset) {
        return hasLeftHandItemId(mem, offset) ? PacketIO.readVarString("LeftHandItemId", mem, offset + getValidatedOffset(mem, offset, 9, 13, "LeftHandItemId"), 4096000): null;
    }
    
    public static boolean hasArmorIds(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasRightHandItemId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasLeftHandItemId(MemorySegment mem, int offset) {
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
    
    public static EquipmentUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static EquipmentUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one EquipmentUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static EquipmentUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 13;
        var varPos = 0;
        String[] v0 = null;
        if (hasArmorIds(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "ArmorIds");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ArmorIds");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("ArmorIds", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("ArmorIds", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v0[i] = PacketIO.readVarString("ArmorIds", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 1, -1, "ArmorIds");
        }
        
        String v1 = null;
        if (hasRightHandItemId(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "RightHandItemId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("RightHandItemId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 5, -1, "RightHandItemId");
        }
        
        String v2 = null;
        if (hasLeftHandItemId(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "LeftHandItemId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("LeftHandItemId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 9, -1, "LeftHandItemId");
        }
        var result = new EquipmentUpdate(
            v0,
            v1,
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.armorIds != null) nullBits |= 0x01;
        if (this.rightHandItemId != null) nullBits |= 0x02;
        if (this.leftHandItemId != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 13;
        if (this.armorIds != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 13);
            if (armorIds.length > 4096000) throw ProtocolException.arrayTooLong("ArmorIds", armorIds.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.armorIds.length);
            
            var armorIdsValueOffset = 0;
            for (var i = 0; i < this.armorIds.length; i++) {
                armorIdsValueOffset += PacketIO.writeVarString(mem, varOffset + armorIdsValueOffset, this.armorIds[i], 4096000);
            }
            varOffset += armorIdsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.rightHandItemId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 13);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.rightHandItemId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.leftHandItemId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 13);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.leftHandItemId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 13;
        if (armorIds != null) {
        int armorIdsSize = 0;
for (var elem : armorIds) armorIdsSize += PacketIO.stringSize(elem);
size += VarInt.size(armorIds.length) + armorIdsSize;
    }
    if (rightHandItemId != null) size += PacketIO.stringSize(rightHandItemId);
    if (leftHandItemId != null) size += PacketIO.stringSize(leftHandItemId);

        return size;
    }

    public EquipmentUpdate clone() {
        EquipmentUpdate copy = new EquipmentUpdate();
        copy.armorIds = this.armorIds != null ? java.util.Arrays.copyOf(this.armorIds, this.armorIds.length) : null;
        copy.rightHandItemId = this.rightHandItemId;
        copy.leftHandItemId = this.leftHandItemId;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EquipmentUpdate other)) return false;
        return java.util.Arrays.equals(this.armorIds, other.armorIds) && java.util.Objects.equals(this.rightHandItemId, other.rightHandItemId) && java.util.Objects.equals(this.leftHandItemId, other.leftHandItemId);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(armorIds);
        result = 31 * result + java.util.Objects.hashCode(rightHandItemId);
        result = 31 * result + java.util.Objects.hashCode(leftHandItemId);
        return result;
    }

}