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

public class WieldingInteraction extends ChargingInteraction {
    public static final int NULLABLE_BIT_FIELD_SIZE = 2;
    public static final int FIXED_BLOCK_SIZE = 58;
    public static final int VARIABLE_FIELD_COUNT = 8;
    public static final int VARIABLE_BLOCK_START = 90;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public DamageEffects blockedEffects;
    public boolean hasModifiers;
    @Nullable public AngledWielding angledWielding;

    public WieldingInteraction() {
    }

    public WieldingInteraction(@Nonnull WaitForDataFrom waitForDataFrom, @Nullable InteractionEffects effects, float horizontalSpeedMultiplier, float runTime, @Nonnull InteractionItemChangeBehavior onItemChangeBehavior, @Nullable java.util.Map<GameMode, InteractionSettings> settings, @Nonnull InteractionRules rules, @Nullable int[] tags, @Nullable InteractionCameraSettings camera, int failed, boolean allowIndefiniteHold, boolean displayProgress, boolean cancelOnOtherClick, boolean failOnDamage, float mouseSensitivityAdjustmentTarget, float mouseSensitivityAdjustmentDuration, @Nullable java.util.Map<Float, Integer> chargedNext, @Nullable java.util.Map<InteractionType, Integer> forks, @Nullable ChargingDelay chargingDelay, @Nullable DamageEffects blockedEffects, boolean hasModifiers, @Nullable AngledWielding angledWielding) {
        this.waitForDataFrom = waitForDataFrom;
        this.effects = effects;
        this.horizontalSpeedMultiplier = horizontalSpeedMultiplier;
        this.runTime = runTime;
        this.onItemChangeBehavior = onItemChangeBehavior;
        this.settings = settings;
        this.rules = rules;
        this.tags = tags;
        this.camera = camera;
        this.failed = failed;
        this.allowIndefiniteHold = allowIndefiniteHold;
        this.displayProgress = displayProgress;
        this.cancelOnOtherClick = cancelOnOtherClick;
        this.failOnDamage = failOnDamage;
        this.mouseSensitivityAdjustmentTarget = mouseSensitivityAdjustmentTarget;
        this.mouseSensitivityAdjustmentDuration = mouseSensitivityAdjustmentDuration;
        this.chargedNext = chargedNext;
        this.forks = forks;
        this.chargingDelay = chargingDelay;
        this.blockedEffects = blockedEffects;
        this.hasModifiers = hasModifiers;
        this.angledWielding = angledWielding;
    }

    public WieldingInteraction(@Nonnull WieldingInteraction other) {
        this.waitForDataFrom = other.waitForDataFrom;
        this.effects = other.effects;
        this.horizontalSpeedMultiplier = other.horizontalSpeedMultiplier;
        this.runTime = other.runTime;
        this.onItemChangeBehavior = other.onItemChangeBehavior;
        this.settings = other.settings;
        this.rules = other.rules;
        this.tags = other.tags;
        this.camera = other.camera;
        this.failed = other.failed;
        this.allowIndefiniteHold = other.allowIndefiniteHold;
        this.displayProgress = other.displayProgress;
        this.cancelOnOtherClick = other.cancelOnOtherClick;
        this.failOnDamage = other.failOnDamage;
        this.mouseSensitivityAdjustmentTarget = other.mouseSensitivityAdjustmentTarget;
        this.mouseSensitivityAdjustmentDuration = other.mouseSensitivityAdjustmentDuration;
        this.chargedNext = other.chargedNext;
        this.forks = other.forks;
        this.chargingDelay = other.chargingDelay;
        this.blockedEffects = other.blockedEffects;
        this.hasModifiers = other.hasModifiers;
        this.angledWielding = other.angledWielding;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("WieldingInteraction", offset, (int) mem.byteSize());
        long needed = (long) offset + 90;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("WieldingInteraction", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static WaitForDataFrom getWaitForDataFrom(MemorySegment mem) {
        return getWaitForDataFrom(mem, 0);
    }
    
    public static WaitForDataFrom getWaitForDataFrom(MemorySegment mem, int offset) {
        return WaitForDataFrom.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2));
    }
    
    @Nullable
    public static InteractionEffects getEffects(MemorySegment mem) {
        return getEffects(mem, 0);
    }
    
    @Nullable
    public static InteractionEffects getEffects(MemorySegment mem, int offset) {
        return hasEffects(mem, offset) ? InteractionEffects.toObject(mem, offset + getValidatedOffset(mem, offset, 58, 90, "Effects")): null;
    }
    
    public static float getHorizontalSpeedMultiplier(MemorySegment mem) {
        return getHorizontalSpeedMultiplier(mem, 0);
    }
    
    public static float getHorizontalSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 3), "HorizontalSpeedMultiplier");
    }
    
    public static float getRunTime(MemorySegment mem) {
        return getRunTime(mem, 0);
    }
    
    public static float getRunTime(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 7), "RunTime");
    }
    
    public static InteractionItemChangeBehavior getOnItemChangeBehavior(MemorySegment mem) {
        return getOnItemChangeBehavior(mem, 0);
    }
    
    public static InteractionItemChangeBehavior getOnItemChangeBehavior(MemorySegment mem, int offset) {
        return InteractionItemChangeBehavior.fromValue(mem.get(PacketIO.PROTO_INT, offset + 11));
    }
    
    @Nullable
    public static java.util.Map<GameMode, InteractionSettings> getSettings(MemorySegment mem) {
        return getSettings(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<GameMode, InteractionSettings> getSettings(MemorySegment mem, int offset) {
        if (!hasSettings(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 62, 90, "Settings");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Settings");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Settings", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Settings", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<GameMode, InteractionSettings> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = GameMode.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                off += 1;
            var value = InteractionSettings.toObject(mem, off);
                off += 1;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Settings", key);
            }
        }
        return data;
    }
    
    public static InteractionRules getRules(MemorySegment mem) {
        return getRules(mem, 0);
    }
    
    public static InteractionRules getRules(MemorySegment mem, int offset) {
        return InteractionRules.toObject(mem, offset + getValidatedOffset(mem, offset, 66, 90, "Rules"));
    }
    
    @Nullable
    public static int[] getTags(MemorySegment mem) {
        return getTags(mem, 0);
    }
    
    @Nullable
    public static int[] getTags(MemorySegment mem, int offset) {
        if (!hasTags(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 70, 90, "Tags");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Tags");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Tags", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Tags", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    @Nullable
    public static InteractionCameraSettings getCamera(MemorySegment mem) {
        return getCamera(mem, 0);
    }
    
    @Nullable
    public static InteractionCameraSettings getCamera(MemorySegment mem, int offset) {
        return hasCamera(mem, offset) ? InteractionCameraSettings.toObject(mem, offset + getValidatedOffset(mem, offset, 74, 90, "Camera")): null;
    }
    
    public static int getFailed(MemorySegment mem) {
        return getFailed(mem, 0);
    }
    
    public static int getFailed(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 15);
    }
    
    public static boolean getAllowIndefiniteHold(MemorySegment mem) {
        return getAllowIndefiniteHold(mem, 0);
    }
    
    public static boolean getAllowIndefiniteHold(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 19) & 0x01) != 0;
    }
    
    public static boolean getDisplayProgress(MemorySegment mem) {
        return getDisplayProgress(mem, 0);
    }
    
    public static boolean getDisplayProgress(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 19) & 0x02) != 0;
    }
    
    public static boolean getCancelOnOtherClick(MemorySegment mem) {
        return getCancelOnOtherClick(mem, 0);
    }
    
    public static boolean getCancelOnOtherClick(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 19) & 0x04) != 0;
    }
    
    public static boolean getFailOnDamage(MemorySegment mem) {
        return getFailOnDamage(mem, 0);
    }
    
    public static boolean getFailOnDamage(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 19) & 0x08) != 0;
    }
    
    public static float getMouseSensitivityAdjustmentTarget(MemorySegment mem) {
        return getMouseSensitivityAdjustmentTarget(mem, 0);
    }
    
    public static float getMouseSensitivityAdjustmentTarget(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "MouseSensitivityAdjustmentTarget");
    }
    
    public static float getMouseSensitivityAdjustmentDuration(MemorySegment mem) {
        return getMouseSensitivityAdjustmentDuration(mem, 0);
    }
    
    public static float getMouseSensitivityAdjustmentDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 24), "MouseSensitivityAdjustmentDuration");
    }
    
    @Nullable
    public static java.util.Map<Float, Integer> getChargedNext(MemorySegment mem) {
        return getChargedNext(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Float, Integer> getChargedNext(MemorySegment mem, int offset) {
        if (!hasChargedNext(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 78, 90, "ChargedNext");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ChargedNext");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ChargedNext", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ChargedNext", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Float, Integer> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            var value = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("ChargedNext", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<InteractionType, Integer> getForks(MemorySegment mem) {
        return getForks(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<InteractionType, Integer> getForks(MemorySegment mem, int offset) {
        if (!hasForks(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 82, 90, "Forks");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Forks");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Forks", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Forks", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<InteractionType, Integer> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                off += 1;
            var value = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Forks", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static ChargingDelay getChargingDelay(MemorySegment mem) {
        return getChargingDelay(mem, 0);
    }
    
    @Nullable
    public static ChargingDelay getChargingDelay(MemorySegment mem, int offset) {
        return hasChargingDelay(mem, offset) ? ChargingDelay.toObject(mem, offset + 28): null;
    }
    
    @Nullable
    public static DamageEffects getBlockedEffects(MemorySegment mem) {
        return getBlockedEffects(mem, 0);
    }
    
    @Nullable
    public static DamageEffects getBlockedEffects(MemorySegment mem, int offset) {
        return hasBlockedEffects(mem, offset) ? DamageEffects.toObject(mem, offset + getValidatedOffset(mem, offset, 86, 90, "BlockedEffects")): null;
    }
    
    public static boolean getHasModifiers(MemorySegment mem) {
        return getHasModifiers(mem, 0);
    }
    
    public static boolean getHasModifiers(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 48);
    }
    
    @Nullable
    public static AngledWielding getAngledWielding(MemorySegment mem) {
        return getAngledWielding(mem, 0);
    }
    
    @Nullable
    public static AngledWielding getAngledWielding(MemorySegment mem, int offset) {
        return hasAngledWielding(mem, offset) ? AngledWielding.toObject(mem, offset + 49): null;
    }
    
    public static boolean hasChargingDelay(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasAngledWielding(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasEffects(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasSettings(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasTags(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasCamera(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasChargedNext(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasForks(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasBlockedEffects(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x01) != 0;
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
    
    public static WieldingInteraction toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static WieldingInteraction toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one WieldingInteraction and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static WieldingInteraction toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 90;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        InteractionEffects v1 = null;
        if (hasEffects(mem, offset)) {
            requireSlot(mem, offset + 58, varPos, "Effects");
            v1 = InteractionEffects.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 58, -1, "Effects");
        }
        
        java.util.Map<GameMode, InteractionSettings> v5 = null;
        if (hasSettings(mem, offset)) {
            requireSlot(mem, offset + 62, varPos, "Settings");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Settings");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Settings", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Settings", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            v5 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = GameMode.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                    off += 1;
                var value = InteractionSettings.toObject(mem, off);
                    off += 1;
                if (v5.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Settings", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 62, -1, "Settings");
        }
        
        InteractionRules v6;
        requireSlot(mem, offset + 66, varPos, "Rules");
        {
            v6 = InteractionRules.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        
        int[] v7 = null;
        if (hasTags(mem, offset)) {
            requireSlot(mem, offset + 70, varPos, "Tags");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Tags");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Tags", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Tags", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v7 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v7, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 70, -1, "Tags");
        }
        
        InteractionCameraSettings v8 = null;
        if (hasCamera(mem, offset)) {
            requireSlot(mem, offset + 74, varPos, "Camera");
            v8 = InteractionCameraSettings.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 74, -1, "Camera");
        }
        
        java.util.Map<Float, Integer> v16 = null;
        if (hasChargedNext(mem, offset)) {
            requireSlot(mem, offset + 78, varPos, "ChargedNext");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ChargedNext");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ChargedNext", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ChargedNext", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
            v16 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                var value = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                if (v16.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("ChargedNext", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 78, -1, "ChargedNext");
        }
        
        java.util.Map<InteractionType, Integer> v17 = null;
        if (hasForks(mem, offset)) {
            requireSlot(mem, offset + 82, varPos, "Forks");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Forks");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Forks", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Forks", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v17 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                    off += 1;
                var value = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                if (v17.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Forks", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 82, -1, "Forks");
        }
        
        DamageEffects v19 = null;
        if (hasBlockedEffects(mem, offset)) {
            requireSlot(mem, offset + 86, varPos, "BlockedEffects");
            v19 = DamageEffects.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 86, -1, "BlockedEffects");
        }
        var result = new WieldingInteraction(
            WaitForDataFrom.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2)),
            v1,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 3), "HorizontalSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 7), "RunTime"),
            InteractionItemChangeBehavior.fromValue(mem.get(PacketIO.PROTO_INT, offset + 11)),
            v5,
            v6,
            v7,
            v8,
            mem.get(PacketIO.PROTO_INT, offset + 15),
            (mem.get(PacketIO.PROTO_BYTE, offset + 19) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 19) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 19) & 0x04) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 19) & 0x08) != 0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "MouseSensitivityAdjustmentTarget"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 24), "MouseSensitivityAdjustmentDuration"),
            v16,
            v17,
            hasChargingDelay(mem, offset) ? ChargingDelay.toObject(mem, offset + 28) : null,
            v19,
            mem.get(PacketIO.PROTO_BOOL, offset + 48),
            hasAngledWielding(mem, offset) ? AngledWielding.toObject(mem, offset + 49) : null
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.chargingDelay != null) nullBits |= 0x01;
        if (this.angledWielding != null) nullBits |= 0x02;
        if (this.effects != null) nullBits |= 0x04;
        if (this.settings != null) nullBits |= 0x08;
        if (this.tags != null) nullBits |= 0x10;
        if (this.camera != null) nullBits |= 0x20;
        if (this.chargedNext != null) nullBits |= 0x40;
        if (this.forks != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        nullBits = 0;
        if (this.blockedEffects != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 1, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 2, (byte) this.waitForDataFrom.getValue());
        PacketIO.requireFinite(this.horizontalSpeedMultiplier, "HorizontalSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 3, this.horizontalSpeedMultiplier);
        PacketIO.requireFinite(this.runTime, "RunTime"); mem.set(PacketIO.PROTO_FLOAT, offset + 7, this.runTime);
        mem.set(PacketIO.PROTO_INT, offset + 11, this.onItemChangeBehavior.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 15, this.failed);
        byte boolBits0_0 = 0;
        if (this.allowIndefiniteHold) boolBits0_0 |= 0x01;
        if (this.displayProgress) boolBits0_0 |= 0x02;
        if (this.cancelOnOtherClick) boolBits0_0 |= 0x04;
        if (this.failOnDamage) boolBits0_0 |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 19 + 0, boolBits0_0);
        PacketIO.requireFinite(this.mouseSensitivityAdjustmentTarget, "MouseSensitivityAdjustmentTarget"); mem.set(PacketIO.PROTO_FLOAT, offset + 20, this.mouseSensitivityAdjustmentTarget);
        PacketIO.requireFinite(this.mouseSensitivityAdjustmentDuration, "MouseSensitivityAdjustmentDuration"); mem.set(PacketIO.PROTO_FLOAT, offset + 24, this.mouseSensitivityAdjustmentDuration);
        if (this.chargingDelay != null) {
            this.chargingDelay.serialize(mem, offset + 28);
        } else {
            mem.asSlice(offset + 28, 20).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BOOL, offset + 48, this.hasModifiers);
        if (this.angledWielding != null) {
            this.angledWielding.serialize(mem, offset + 49);
        } else {
            mem.asSlice(offset + 49, 9).fill((byte) 0); 
        }
        var varOffset = offset + 90;
        if (this.effects != null) {
            mem.set(PacketIO.PROTO_INT, offset + 58, varOffset - offset - 90);
            varOffset += this.effects.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 58, -1);
        }
        if (this.settings != null) {
            mem.set(PacketIO.PROTO_INT, offset + 62, varOffset - offset - 90);
            if (this.settings.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Settings", settings.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.settings.size());
            for (var e : this.settings.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 62, -1);
        }
        mem.set(PacketIO.PROTO_INT, offset + 66, varOffset - offset - 90);
        varOffset += this.rules.serialize(mem, varOffset);
        if (this.tags != null) {
            mem.set(PacketIO.PROTO_INT, offset + 70, varOffset - offset - 90);
            if (tags.length > 4096000) throw ProtocolException.arrayTooLong("Tags", tags.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.tags.length);
            
            MemorySegment.copy(this.tags, 0, mem, PacketIO.PROTO_INT, varOffset, this.tags.length);
            varOffset += this.tags.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 70, -1);
        }
        if (this.camera != null) {
            mem.set(PacketIO.PROTO_INT, offset + 74, varOffset - offset - 90);
            varOffset += this.camera.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 74, -1);
        }
        if (this.chargedNext != null) {
            mem.set(PacketIO.PROTO_INT, offset + 78, varOffset - offset - 90);
            if (this.chargedNext.size() > 4096000) throw ProtocolException.dictionaryTooLarge("ChargedNext", chargedNext.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.chargedNext.size());
            for (var e : this.chargedNext.entrySet()) {
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getKey());
                varOffset += 4;
                mem.set(PacketIO.PROTO_INT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 78, -1);
        }
        if (this.forks != null) {
            mem.set(PacketIO.PROTO_INT, offset + 82, varOffset - offset - 90);
            if (this.forks.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Forks", forks.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.forks.size());
            for (var e : this.forks.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                mem.set(PacketIO.PROTO_INT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 82, -1);
        }
        if (this.blockedEffects != null) {
            mem.set(PacketIO.PROTO_INT, offset + 86, varOffset - offset - 90);
            varOffset += this.blockedEffects.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 86, -1);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 90;
        if (effects != null) size += effects.computeSize();
    if (settings != null) size += VarInt.size(settings.size()) + settings.size() * (1 + 1);
    size += rules.computeSize();
    if (tags != null) size += VarInt.size(tags.length) + tags.length * 4;
    if (camera != null) size += camera.computeSize();
    if (chargedNext != null) size += VarInt.size(chargedNext.size()) + chargedNext.size() * (4 + 4);
    if (forks != null) size += VarInt.size(forks.size()) + forks.size() * (1 + 4);
    if (blockedEffects != null) size += blockedEffects.computeSize();

        return size;
    }

    public WieldingInteraction clone() {
        WieldingInteraction copy = new WieldingInteraction();
        copy.waitForDataFrom = this.waitForDataFrom;
        copy.effects = this.effects != null ? this.effects.clone() : null;
        copy.horizontalSpeedMultiplier = this.horizontalSpeedMultiplier;
        copy.runTime = this.runTime;
        copy.onItemChangeBehavior = this.onItemChangeBehavior;
        if (this.settings != null) {
            java.util.Map<GameMode, InteractionSettings> m = new java.util.HashMap<>();
            for (var e : this.settings.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.settings = m;
        }
        copy.rules = this.rules.clone();
        copy.tags = this.tags != null ? java.util.Arrays.copyOf(this.tags, this.tags.length) : null;
        copy.camera = this.camera != null ? this.camera.clone() : null;
        copy.failed = this.failed;
        copy.allowIndefiniteHold = this.allowIndefiniteHold;
        copy.displayProgress = this.displayProgress;
        copy.cancelOnOtherClick = this.cancelOnOtherClick;
        copy.failOnDamage = this.failOnDamage;
        copy.mouseSensitivityAdjustmentTarget = this.mouseSensitivityAdjustmentTarget;
        copy.mouseSensitivityAdjustmentDuration = this.mouseSensitivityAdjustmentDuration;
        copy.chargedNext = this.chargedNext != null ? new java.util.HashMap<>(this.chargedNext) : null;
        copy.forks = this.forks != null ? new java.util.HashMap<>(this.forks) : null;
        copy.chargingDelay = this.chargingDelay != null ? this.chargingDelay.clone() : null;
        copy.blockedEffects = this.blockedEffects != null ? this.blockedEffects.clone() : null;
        copy.hasModifiers = this.hasModifiers;
        copy.angledWielding = this.angledWielding != null ? this.angledWielding.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof WieldingInteraction other)) return false;
        return java.util.Objects.equals(this.waitForDataFrom, other.waitForDataFrom) && java.util.Objects.equals(this.effects, other.effects) && this.horizontalSpeedMultiplier == other.horizontalSpeedMultiplier && this.runTime == other.runTime && java.util.Objects.equals(this.onItemChangeBehavior, other.onItemChangeBehavior) && java.util.Objects.equals(this.settings, other.settings) && java.util.Objects.equals(this.rules, other.rules) && java.util.Arrays.equals(this.tags, other.tags) && java.util.Objects.equals(this.camera, other.camera) && this.failed == other.failed && this.allowIndefiniteHold == other.allowIndefiniteHold && this.displayProgress == other.displayProgress && this.cancelOnOtherClick == other.cancelOnOtherClick && this.failOnDamage == other.failOnDamage && this.mouseSensitivityAdjustmentTarget == other.mouseSensitivityAdjustmentTarget && this.mouseSensitivityAdjustmentDuration == other.mouseSensitivityAdjustmentDuration && java.util.Objects.equals(this.chargedNext, other.chargedNext) && java.util.Objects.equals(this.forks, other.forks) && java.util.Objects.equals(this.chargingDelay, other.chargingDelay) && java.util.Objects.equals(this.blockedEffects, other.blockedEffects) && this.hasModifiers == other.hasModifiers && java.util.Objects.equals(this.angledWielding, other.angledWielding);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(waitForDataFrom);
        result = 31 * result + java.util.Objects.hashCode(effects);
        result = 31 * result + Float.hashCode(horizontalSpeedMultiplier);
        result = 31 * result + Float.hashCode(runTime);
        result = 31 * result + java.util.Objects.hashCode(onItemChangeBehavior);
        result = 31 * result + java.util.Objects.hashCode(settings);
        result = 31 * result + java.util.Objects.hashCode(rules);
        result = 31 * result + java.util.Arrays.hashCode(tags);
        result = 31 * result + java.util.Objects.hashCode(camera);
        result = 31 * result + Integer.hashCode(failed);
        result = 31 * result + Boolean.hashCode(allowIndefiniteHold);
        result = 31 * result + Boolean.hashCode(displayProgress);
        result = 31 * result + Boolean.hashCode(cancelOnOtherClick);
        result = 31 * result + Boolean.hashCode(failOnDamage);
        result = 31 * result + Float.hashCode(mouseSensitivityAdjustmentTarget);
        result = 31 * result + Float.hashCode(mouseSensitivityAdjustmentDuration);
        result = 31 * result + java.util.Objects.hashCode(chargedNext);
        result = 31 * result + java.util.Objects.hashCode(forks);
        result = 31 * result + java.util.Objects.hashCode(chargingDelay);
        result = 31 * result + java.util.Objects.hashCode(blockedEffects);
        result = 31 * result + Boolean.hashCode(hasModifiers);
        result = 31 * result + java.util.Objects.hashCode(angledWielding);
        return result;
    }

}