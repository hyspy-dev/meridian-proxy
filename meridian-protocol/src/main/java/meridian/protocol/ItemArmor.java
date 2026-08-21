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
import java.util.HashMap;

public class ItemArmor {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 10;
    public static final int VARIABLE_FIELD_COUNT = 6;
    public static final int VARIABLE_BLOCK_START = 34;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public ItemArmorSlot armorSlot = ItemArmorSlot.Head;
    @Nullable public Cosmetic[] cosmeticsToHide;
    @Nullable public java.util.Map<Integer, Modifier[]> statModifiers;
    public double baseDamageResistance;
    @Nullable public java.util.Map<String, ResistanceModifier[]> damageResistance;
    @Nullable public java.util.Map<String, Modifier[]> damageEnhancement;
    @Nullable public java.util.Map<String, Modifier[]> damageClassEnhancement;
    @Nullable public ItemMovementSettings movementSettings;

    public ItemArmor() {
    }

    public ItemArmor(@Nonnull ItemArmorSlot armorSlot, @Nullable Cosmetic[] cosmeticsToHide, @Nullable java.util.Map<Integer, Modifier[]> statModifiers, double baseDamageResistance, @Nullable java.util.Map<String, ResistanceModifier[]> damageResistance, @Nullable java.util.Map<String, Modifier[]> damageEnhancement, @Nullable java.util.Map<String, Modifier[]> damageClassEnhancement, @Nullable ItemMovementSettings movementSettings) {
        this.armorSlot = armorSlot;
        this.cosmeticsToHide = cosmeticsToHide;
        this.statModifiers = statModifiers;
        this.baseDamageResistance = baseDamageResistance;
        this.damageResistance = damageResistance;
        this.damageEnhancement = damageEnhancement;
        this.damageClassEnhancement = damageClassEnhancement;
        this.movementSettings = movementSettings;
    }

    public ItemArmor(@Nonnull ItemArmor other) {
        this.armorSlot = other.armorSlot;
        this.cosmeticsToHide = other.cosmeticsToHide;
        this.statModifiers = other.statModifiers;
        this.baseDamageResistance = other.baseDamageResistance;
        this.damageResistance = other.damageResistance;
        this.damageEnhancement = other.damageEnhancement;
        this.damageClassEnhancement = other.damageClassEnhancement;
        this.movementSettings = other.movementSettings;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemArmor", offset, (int) mem.byteSize());
        long needed = (long) offset + 34;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemArmor", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static ItemArmorSlot getArmorSlot(MemorySegment mem) {
        return getArmorSlot(mem, 0);
    }
    
    public static ItemArmorSlot getArmorSlot(MemorySegment mem, int offset) {
        return ItemArmorSlot.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static Cosmetic[] getCosmeticsToHide(MemorySegment mem) {
        return getCosmeticsToHide(mem, 0);
    }
    
    @Nullable
    public static Cosmetic[] getCosmeticsToHide(MemorySegment mem, int offset) {
        if (!hasCosmeticsToHide(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 10, 34, "CosmeticsToHide");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("CosmeticsToHide");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("CosmeticsToHide", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("CosmeticsToHide", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new Cosmetic[len];
        for (var i = 0; i < len; i++) {
            data[i] = Cosmetic.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<Integer, Modifier[]> getStatModifiers(MemorySegment mem) {
        return getStatModifiers(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Integer, Modifier[]> getStatModifiers(MemorySegment mem, int offset) {
        if (!hasStatModifiers(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 14, 34, "StatModifiers");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("StatModifiers");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("StatModifiers", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("StatModifiers", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Integer, Modifier[]> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            var valuePacked = VarInt.getWithLength(mem, off);
                if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                var valueLen = (int) valuePacked;
                var valueVarLen = (int) (valuePacked >>> 32);
                if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                if (off + valueVarLen + (long) valueLen * 6 > mem.byteSize())
                    throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 6, (int) mem.byteSize());
                off += valueVarLen;
                var value = new Modifier[valueLen];
                for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                    value[valueIdx] = Modifier.toObject(mem, off);
                    off += 6;
                }
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("StatModifiers", key);
            }
        }
        return data;
    }
    
    public static double getBaseDamageResistance(MemorySegment mem) {
        return getBaseDamageResistance(mem, 0);
    }
    
    public static double getBaseDamageResistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 2), "BaseDamageResistance");
    }
    
    @Nullable
    public static java.util.Map<String, ResistanceModifier[]> getDamageResistance(MemorySegment mem) {
        return getDamageResistance(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, ResistanceModifier[]> getDamageResistance(MemorySegment mem, int offset) {
        if (!hasDamageResistance(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 18, 34, "DamageResistance");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("DamageResistance");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("DamageResistance", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("DamageResistance", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, ResistanceModifier[]> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var valuePacked = VarInt.getWithLength(mem, off);
                if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                var valueLen = (int) valuePacked;
                var valueVarLen = (int) (valuePacked >>> 32);
                if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                if (off + valueVarLen + (long) valueLen * 5 > mem.byteSize())
                    throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 5, (int) mem.byteSize());
                off += valueVarLen;
                var value = new ResistanceModifier[valueLen];
                for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                    value[valueIdx] = ResistanceModifier.toObject(mem, off);
                    off += 5;
                }
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("DamageResistance", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<String, Modifier[]> getDamageEnhancement(MemorySegment mem) {
        return getDamageEnhancement(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, Modifier[]> getDamageEnhancement(MemorySegment mem, int offset) {
        if (!hasDamageEnhancement(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 22, 34, "DamageEnhancement");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("DamageEnhancement");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("DamageEnhancement", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("DamageEnhancement", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, Modifier[]> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var valuePacked = VarInt.getWithLength(mem, off);
                if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                var valueLen = (int) valuePacked;
                var valueVarLen = (int) (valuePacked >>> 32);
                if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                if (off + valueVarLen + (long) valueLen * 6 > mem.byteSize())
                    throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 6, (int) mem.byteSize());
                off += valueVarLen;
                var value = new Modifier[valueLen];
                for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                    value[valueIdx] = Modifier.toObject(mem, off);
                    off += 6;
                }
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("DamageEnhancement", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<String, Modifier[]> getDamageClassEnhancement(MemorySegment mem) {
        return getDamageClassEnhancement(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, Modifier[]> getDamageClassEnhancement(MemorySegment mem, int offset) {
        if (!hasDamageClassEnhancement(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 26, 34, "DamageClassEnhancement");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("DamageClassEnhancement");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("DamageClassEnhancement", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("DamageClassEnhancement", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, Modifier[]> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var valuePacked = VarInt.getWithLength(mem, off);
                if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                var valueLen = (int) valuePacked;
                var valueVarLen = (int) (valuePacked >>> 32);
                if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                if (off + valueVarLen + (long) valueLen * 6 > mem.byteSize())
                    throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 6, (int) mem.byteSize());
                off += valueVarLen;
                var value = new Modifier[valueLen];
                for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                    value[valueIdx] = Modifier.toObject(mem, off);
                    off += 6;
                }
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("DamageClassEnhancement", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static ItemMovementSettings getMovementSettings(MemorySegment mem) {
        return getMovementSettings(mem, 0);
    }
    
    @Nullable
    public static ItemMovementSettings getMovementSettings(MemorySegment mem, int offset) {
        return hasMovementSettings(mem, offset) ? ItemMovementSettings.toObject(mem, offset + getValidatedOffset(mem, offset, 30, 34, "MovementSettings")): null;
    }
    
    public static boolean hasCosmeticsToHide(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasStatModifiers(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasDamageResistance(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasDamageEnhancement(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasDamageClassEnhancement(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasMovementSettings(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
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
    
    public static ItemArmor toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemArmor toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemArmor and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemArmor toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 34;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        Cosmetic[] v1 = null;
        if (hasCosmeticsToHide(mem, offset)) {
            requireSlot(mem, offset + 10, varPos, "CosmeticsToHide");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("CosmeticsToHide");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("CosmeticsToHide", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("CosmeticsToHide", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new Cosmetic[len];
            for (var i = 0; i < len; i++) {
                v1[i] = Cosmetic.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
            }
            varPos = off + len - varBase;
        } else {
            requireSlot(mem, offset + 10, -1, "CosmeticsToHide");
        }
        
        java.util.Map<Integer, Modifier[]> v2 = null;
        if (hasStatModifiers(mem, offset)) {
            requireSlot(mem, offset + 14, varPos, "StatModifiers");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("StatModifiers");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("StatModifiers", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("StatModifiers", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v2 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                var valuePacked = VarInt.getWithLength(mem, off);
                    if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                    var valueLen = (int) valuePacked;
                    var valueVarLen = (int) (valuePacked >>> 32);
                    if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                    if (off + valueVarLen + (long) valueLen * 6 > mem.byteSize())
                        throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 6, (int) mem.byteSize());
                    off += valueVarLen;
                    var value = new Modifier[valueLen];
                    for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                        value[valueIdx] = Modifier.toObject(mem, off);
                        off += 6;
                    }
                if (v2.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("StatModifiers", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 14, -1, "StatModifiers");
        }
        
        java.util.Map<String, ResistanceModifier[]> v4 = null;
        if (hasDamageResistance(mem, offset)) {
            requireSlot(mem, offset + 18, varPos, "DamageResistance");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("DamageResistance");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("DamageResistance", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("DamageResistance", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            v4 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var valuePacked = VarInt.getWithLength(mem, off);
                    if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                    var valueLen = (int) valuePacked;
                    var valueVarLen = (int) (valuePacked >>> 32);
                    if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                    if (off + valueVarLen + (long) valueLen * 5 > mem.byteSize())
                        throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 5, (int) mem.byteSize());
                    off += valueVarLen;
                    var value = new ResistanceModifier[valueLen];
                    for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                        value[valueIdx] = ResistanceModifier.toObject(mem, off);
                        off += 5;
                    }
                if (v4.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("DamageResistance", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 18, -1, "DamageResistance");
        }
        
        java.util.Map<String, Modifier[]> v5 = null;
        if (hasDamageEnhancement(mem, offset)) {
            requireSlot(mem, offset + 22, varPos, "DamageEnhancement");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("DamageEnhancement");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("DamageEnhancement", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("DamageEnhancement", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            v5 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var valuePacked = VarInt.getWithLength(mem, off);
                    if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                    var valueLen = (int) valuePacked;
                    var valueVarLen = (int) (valuePacked >>> 32);
                    if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                    if (off + valueVarLen + (long) valueLen * 6 > mem.byteSize())
                        throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 6, (int) mem.byteSize());
                    off += valueVarLen;
                    var value = new Modifier[valueLen];
                    for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                        value[valueIdx] = Modifier.toObject(mem, off);
                        off += 6;
                    }
                if (v5.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("DamageEnhancement", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 22, -1, "DamageEnhancement");
        }
        
        java.util.Map<String, Modifier[]> v6 = null;
        if (hasDamageClassEnhancement(mem, offset)) {
            requireSlot(mem, offset + 26, varPos, "DamageClassEnhancement");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("DamageClassEnhancement");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("DamageClassEnhancement", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("DamageClassEnhancement", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            v6 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var valuePacked = VarInt.getWithLength(mem, off);
                    if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                    var valueLen = (int) valuePacked;
                    var valueVarLen = (int) (valuePacked >>> 32);
                    if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                    if (off + valueVarLen + (long) valueLen * 6 > mem.byteSize())
                        throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 6, (int) mem.byteSize());
                    off += valueVarLen;
                    var value = new Modifier[valueLen];
                    for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                        value[valueIdx] = Modifier.toObject(mem, off);
                        off += 6;
                    }
                if (v6.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("DamageClassEnhancement", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 26, -1, "DamageClassEnhancement");
        }
        
        ItemMovementSettings v7 = null;
        if (hasMovementSettings(mem, offset)) {
            requireSlot(mem, offset + 30, varPos, "MovementSettings");
            v7 = ItemMovementSettings.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 30, -1, "MovementSettings");
        }
        var result = new ItemArmor(
            ItemArmorSlot.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v1,
            v2,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 2), "BaseDamageResistance"),
            v4,
            v5,
            v6,
            v7
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.cosmeticsToHide != null) nullBits |= 0x01;
        if (this.statModifiers != null) nullBits |= 0x02;
        if (this.damageResistance != null) nullBits |= 0x04;
        if (this.damageEnhancement != null) nullBits |= 0x08;
        if (this.damageClassEnhancement != null) nullBits |= 0x10;
        if (this.movementSettings != null) nullBits |= 0x20;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.armorSlot.getValue());
        PacketIO.requireFinite(this.baseDamageResistance, "BaseDamageResistance"); mem.set(PacketIO.PROTO_DOUBLE, offset + 2, this.baseDamageResistance);
        var varOffset = offset + 34;
        if (this.cosmeticsToHide != null) {
            mem.set(PacketIO.PROTO_INT, offset + 10, varOffset - offset - 34);
            if (cosmeticsToHide.length > 4096000) throw ProtocolException.arrayTooLong("CosmeticsToHide", cosmeticsToHide.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.cosmeticsToHide.length);
            
            for (var i = 0; i < this.cosmeticsToHide.length; i++) {
                mem.set(PacketIO.PROTO_BYTE, varOffset + i * 1, (byte) this.cosmeticsToHide[i].getValue());
            }
            varOffset += this.cosmeticsToHide.length * 1;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 10, -1);
        }
        if (this.statModifiers != null) {
            mem.set(PacketIO.PROTO_INT, offset + 14, varOffset - offset - 34);
            if (this.statModifiers.size() > 4096000) throw ProtocolException.dictionaryTooLarge("StatModifiers", statModifiers.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.statModifiers.size());
            for (var e : this.statModifiers.entrySet()) {
                mem.set(PacketIO.PROTO_INT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += VarInt.set(mem, varOffset, e.getValue().length);
                for (var arrItem : e.getValue()) {
                    varOffset += arrItem.serialize(mem, varOffset);
                }
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 14, -1);
        }
        if (this.damageResistance != null) {
            mem.set(PacketIO.PROTO_INT, offset + 18, varOffset - offset - 34);
            if (this.damageResistance.size() > 4096000) throw ProtocolException.dictionaryTooLarge("DamageResistance", damageResistance.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.damageResistance.size());
            for (var e : this.damageResistance.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                varOffset += VarInt.set(mem, varOffset, e.getValue().length);
                for (var arrItem : e.getValue()) {
                    varOffset += arrItem.serialize(mem, varOffset);
                }
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 18, -1);
        }
        if (this.damageEnhancement != null) {
            mem.set(PacketIO.PROTO_INT, offset + 22, varOffset - offset - 34);
            if (this.damageEnhancement.size() > 4096000) throw ProtocolException.dictionaryTooLarge("DamageEnhancement", damageEnhancement.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.damageEnhancement.size());
            for (var e : this.damageEnhancement.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                varOffset += VarInt.set(mem, varOffset, e.getValue().length);
                for (var arrItem : e.getValue()) {
                    varOffset += arrItem.serialize(mem, varOffset);
                }
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 22, -1);
        }
        if (this.damageClassEnhancement != null) {
            mem.set(PacketIO.PROTO_INT, offset + 26, varOffset - offset - 34);
            if (this.damageClassEnhancement.size() > 4096000) throw ProtocolException.dictionaryTooLarge("DamageClassEnhancement", damageClassEnhancement.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.damageClassEnhancement.size());
            for (var e : this.damageClassEnhancement.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                varOffset += VarInt.set(mem, varOffset, e.getValue().length);
                for (var arrItem : e.getValue()) {
                    varOffset += arrItem.serialize(mem, varOffset);
                }
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 26, -1);
        }
        if (this.movementSettings != null) {
            mem.set(PacketIO.PROTO_INT, offset + 30, varOffset - offset - 34);
            varOffset += this.movementSettings.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 30, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 34;
        if (cosmeticsToHide != null) size += VarInt.size(cosmeticsToHide.length) + cosmeticsToHide.length * 1;
    if (statModifiers != null) {
        int statModifiersSize = 0;
for (var kvp : statModifiers.entrySet()) statModifiersSize += 4 + VarInt.size(kvp.getValue().length) + kvp.getValue().length * 6;
size += VarInt.size(statModifiers.size()) + statModifiersSize;
    }
    if (damageResistance != null) {
        int damageResistanceSize = 0;
for (var kvp : damageResistance.entrySet()) damageResistanceSize += PacketIO.stringSize(kvp.getKey()) + VarInt.size(kvp.getValue().length) + kvp.getValue().length * 5;
size += VarInt.size(damageResistance.size()) + damageResistanceSize;
    }
    if (damageEnhancement != null) {
        int damageEnhancementSize = 0;
for (var kvp : damageEnhancement.entrySet()) damageEnhancementSize += PacketIO.stringSize(kvp.getKey()) + VarInt.size(kvp.getValue().length) + kvp.getValue().length * 6;
size += VarInt.size(damageEnhancement.size()) + damageEnhancementSize;
    }
    if (damageClassEnhancement != null) {
        int damageClassEnhancementSize = 0;
for (var kvp : damageClassEnhancement.entrySet()) damageClassEnhancementSize += PacketIO.stringSize(kvp.getKey()) + VarInt.size(kvp.getValue().length) + kvp.getValue().length * 6;
size += VarInt.size(damageClassEnhancement.size()) + damageClassEnhancementSize;
    }
    if (movementSettings != null) size += movementSettings.computeSize();

        return size;
    }

    public ItemArmor clone() {
        ItemArmor copy = new ItemArmor();
        copy.armorSlot = this.armorSlot;
        copy.cosmeticsToHide = this.cosmeticsToHide != null ? java.util.Arrays.copyOf(this.cosmeticsToHide, this.cosmeticsToHide.length) : null;
        if (this.statModifiers != null) {
            java.util.Map<Integer, Modifier[]> m = new java.util.HashMap<>();
            for (var e : this.statModifiers.entrySet()) { m.put(e.getKey(), java.util.Arrays.stream(e.getValue()).map(x -> x.clone()).toArray(Modifier[]::new)); }
            copy.statModifiers = m;
        }
        copy.baseDamageResistance = this.baseDamageResistance;
        if (this.damageResistance != null) {
            java.util.Map<String, ResistanceModifier[]> m = new java.util.HashMap<>();
            for (var e : this.damageResistance.entrySet()) { m.put(e.getKey(), java.util.Arrays.stream(e.getValue()).map(x -> x.clone()).toArray(ResistanceModifier[]::new)); }
            copy.damageResistance = m;
        }
        if (this.damageEnhancement != null) {
            java.util.Map<String, Modifier[]> m = new java.util.HashMap<>();
            for (var e : this.damageEnhancement.entrySet()) { m.put(e.getKey(), java.util.Arrays.stream(e.getValue()).map(x -> x.clone()).toArray(Modifier[]::new)); }
            copy.damageEnhancement = m;
        }
        if (this.damageClassEnhancement != null) {
            java.util.Map<String, Modifier[]> m = new java.util.HashMap<>();
            for (var e : this.damageClassEnhancement.entrySet()) { m.put(e.getKey(), java.util.Arrays.stream(e.getValue()).map(x -> x.clone()).toArray(Modifier[]::new)); }
            copy.damageClassEnhancement = m;
        }
        copy.movementSettings = this.movementSettings != null ? this.movementSettings.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemArmor other)) return false;
        return java.util.Objects.equals(this.armorSlot, other.armorSlot) && java.util.Arrays.equals(this.cosmeticsToHide, other.cosmeticsToHide) && java.util.Objects.equals(this.statModifiers, other.statModifiers) && this.baseDamageResistance == other.baseDamageResistance && java.util.Objects.equals(this.damageResistance, other.damageResistance) && java.util.Objects.equals(this.damageEnhancement, other.damageEnhancement) && java.util.Objects.equals(this.damageClassEnhancement, other.damageClassEnhancement) && java.util.Objects.equals(this.movementSettings, other.movementSettings);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(armorSlot);
        result = 31 * result + java.util.Arrays.hashCode(cosmeticsToHide);
        result = 31 * result + java.util.Objects.hashCode(statModifiers);
        result = 31 * result + Double.hashCode(baseDamageResistance);
        result = 31 * result + java.util.Objects.hashCode(damageResistance);
        result = 31 * result + java.util.Objects.hashCode(damageEnhancement);
        result = 31 * result + java.util.Objects.hashCode(damageClassEnhancement);
        result = 31 * result + java.util.Objects.hashCode(movementSettings);
        return result;
    }

}