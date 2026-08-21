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

public class ChargingInteraction extends Interaction {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 47;
    public static final int VARIABLE_FIELD_COUNT = 7;
    public static final int VARIABLE_BLOCK_START = 75;
    public static final int MAX_SIZE = 1677721600;

    public int failed = Integer.MIN_VALUE;
    public boolean allowIndefiniteHold;
    public boolean displayProgress;
    public boolean cancelOnOtherClick;
    public boolean failOnDamage;
    public float mouseSensitivityAdjustmentTarget;
    public float mouseSensitivityAdjustmentDuration;
    @Nullable public java.util.Map<Float, Integer> chargedNext;
    @Nullable public java.util.Map<InteractionType, Integer> forks;
    @Nullable public ChargingDelay chargingDelay;

    public ChargingInteraction() {
    }

    public ChargingInteraction(@Nonnull WaitForDataFrom waitForDataFrom, @Nullable InteractionEffects effects, float horizontalSpeedMultiplier, float runTime, @Nonnull InteractionItemChangeBehavior onItemChangeBehavior, @Nullable java.util.Map<GameMode, InteractionSettings> settings, @Nonnull InteractionRules rules, @Nullable int[] tags, @Nullable InteractionCameraSettings camera, int failed, boolean allowIndefiniteHold, boolean displayProgress, boolean cancelOnOtherClick, boolean failOnDamage, float mouseSensitivityAdjustmentTarget, float mouseSensitivityAdjustmentDuration, @Nullable java.util.Map<Float, Integer> chargedNext, @Nullable java.util.Map<InteractionType, Integer> forks, @Nullable ChargingDelay chargingDelay) {
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
    }

    public ChargingInteraction(@Nonnull ChargingInteraction other) {
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
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ChargingInteraction", offset, (int) mem.byteSize());
        long needed = (long) offset + 75;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ChargingInteraction", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static WaitForDataFrom getWaitForDataFrom(MemorySegment mem) {
        return getWaitForDataFrom(mem, 0);
    }
    
    public static WaitForDataFrom getWaitForDataFrom(MemorySegment mem, int offset) {
        return WaitForDataFrom.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static InteractionEffects getEffects(MemorySegment mem) {
        return getEffects(mem, 0);
    }
    
    @Nullable
    public static InteractionEffects getEffects(MemorySegment mem, int offset) {
        return hasEffects(mem, offset) ? InteractionEffects.toObject(mem, offset + getValidatedOffset(mem, offset, 47, 75, "Effects")): null;
    }
    
    public static float getHorizontalSpeedMultiplier(MemorySegment mem) {
        return getHorizontalSpeedMultiplier(mem, 0);
    }
    
    public static float getHorizontalSpeedMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "HorizontalSpeedMultiplier");
    }
    
    public static float getRunTime(MemorySegment mem) {
        return getRunTime(mem, 0);
    }
    
    public static float getRunTime(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 6), "RunTime");
    }
    
    public static InteractionItemChangeBehavior getOnItemChangeBehavior(MemorySegment mem) {
        return getOnItemChangeBehavior(mem, 0);
    }
    
    public static InteractionItemChangeBehavior getOnItemChangeBehavior(MemorySegment mem, int offset) {
        return InteractionItemChangeBehavior.fromValue(mem.get(PacketIO.PROTO_INT, offset + 10));
    }
    
    @Nullable
    public static java.util.Map<GameMode, InteractionSettings> getSettings(MemorySegment mem) {
        return getSettings(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<GameMode, InteractionSettings> getSettings(MemorySegment mem, int offset) {
        if (!hasSettings(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 51, 75, "Settings");
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
        return InteractionRules.toObject(mem, offset + getValidatedOffset(mem, offset, 55, 75, "Rules"));
    }
    
    @Nullable
    public static int[] getTags(MemorySegment mem) {
        return getTags(mem, 0);
    }
    
    @Nullable
    public static int[] getTags(MemorySegment mem, int offset) {
        if (!hasTags(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 59, 75, "Tags");
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
        return hasCamera(mem, offset) ? InteractionCameraSettings.toObject(mem, offset + getValidatedOffset(mem, offset, 63, 75, "Camera")): null;
    }
    
    public static int getFailed(MemorySegment mem) {
        return getFailed(mem, 0);
    }
    
    public static int getFailed(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 14);
    }
    
    public static boolean getAllowIndefiniteHold(MemorySegment mem) {
        return getAllowIndefiniteHold(mem, 0);
    }
    
    public static boolean getAllowIndefiniteHold(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 18) & 0x01) != 0;
    }
    
    public static boolean getDisplayProgress(MemorySegment mem) {
        return getDisplayProgress(mem, 0);
    }
    
    public static boolean getDisplayProgress(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 18) & 0x02) != 0;
    }
    
    public static boolean getCancelOnOtherClick(MemorySegment mem) {
        return getCancelOnOtherClick(mem, 0);
    }
    
    public static boolean getCancelOnOtherClick(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 18) & 0x04) != 0;
    }
    
    public static boolean getFailOnDamage(MemorySegment mem) {
        return getFailOnDamage(mem, 0);
    }
    
    public static boolean getFailOnDamage(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 18) & 0x08) != 0;
    }
    
    public static float getMouseSensitivityAdjustmentTarget(MemorySegment mem) {
        return getMouseSensitivityAdjustmentTarget(mem, 0);
    }
    
    public static float getMouseSensitivityAdjustmentTarget(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 19), "MouseSensitivityAdjustmentTarget");
    }
    
    public static float getMouseSensitivityAdjustmentDuration(MemorySegment mem) {
        return getMouseSensitivityAdjustmentDuration(mem, 0);
    }
    
    public static float getMouseSensitivityAdjustmentDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 23), "MouseSensitivityAdjustmentDuration");
    }
    
    @Nullable
    public static java.util.Map<Float, Integer> getChargedNext(MemorySegment mem) {
        return getChargedNext(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Float, Integer> getChargedNext(MemorySegment mem, int offset) {
        if (!hasChargedNext(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 67, 75, "ChargedNext");
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
        var off = offset + getValidatedOffset(mem, offset, 71, 75, "Forks");
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
        return hasChargingDelay(mem, offset) ? ChargingDelay.toObject(mem, offset + 27): null;
    }
    
    public static boolean hasChargingDelay(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasEffects(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasSettings(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasTags(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasCamera(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasChargedNext(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasForks(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
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
    
    public static ChargingInteraction toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ChargingInteraction toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ChargingInteraction and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ChargingInteraction toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 75;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        InteractionEffects v1 = null;
        if (hasEffects(mem, offset)) {
            requireSlot(mem, offset + 47, varPos, "Effects");
            v1 = InteractionEffects.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 47, -1, "Effects");
        }
        
        java.util.Map<GameMode, InteractionSettings> v5 = null;
        if (hasSettings(mem, offset)) {
            requireSlot(mem, offset + 51, varPos, "Settings");
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
            requireSlot(mem, offset + 51, -1, "Settings");
        }
        
        InteractionRules v6;
        requireSlot(mem, offset + 55, varPos, "Rules");
        {
            v6 = InteractionRules.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        
        int[] v7 = null;
        if (hasTags(mem, offset)) {
            requireSlot(mem, offset + 59, varPos, "Tags");
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
            requireSlot(mem, offset + 59, -1, "Tags");
        }
        
        InteractionCameraSettings v8 = null;
        if (hasCamera(mem, offset)) {
            requireSlot(mem, offset + 63, varPos, "Camera");
            v8 = InteractionCameraSettings.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 63, -1, "Camera");
        }
        
        java.util.Map<Float, Integer> v16 = null;
        if (hasChargedNext(mem, offset)) {
            requireSlot(mem, offset + 67, varPos, "ChargedNext");
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
            requireSlot(mem, offset + 67, -1, "ChargedNext");
        }
        
        java.util.Map<InteractionType, Integer> v17 = null;
        if (hasForks(mem, offset)) {
            requireSlot(mem, offset + 71, varPos, "Forks");
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
            requireSlot(mem, offset + 71, -1, "Forks");
        }
        var result = new ChargingInteraction(
            WaitForDataFrom.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v1,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "HorizontalSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 6), "RunTime"),
            InteractionItemChangeBehavior.fromValue(mem.get(PacketIO.PROTO_INT, offset + 10)),
            v5,
            v6,
            v7,
            v8,
            mem.get(PacketIO.PROTO_INT, offset + 14),
            (mem.get(PacketIO.PROTO_BYTE, offset + 18) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 18) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 18) & 0x04) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 18) & 0x08) != 0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 19), "MouseSensitivityAdjustmentTarget"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 23), "MouseSensitivityAdjustmentDuration"),
            v16,
            v17,
            hasChargingDelay(mem, offset) ? ChargingDelay.toObject(mem, offset + 27) : null
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.chargingDelay != null) nullBits |= 0x01;
        if (this.effects != null) nullBits |= 0x02;
        if (this.settings != null) nullBits |= 0x04;
        if (this.tags != null) nullBits |= 0x08;
        if (this.camera != null) nullBits |= 0x10;
        if (this.chargedNext != null) nullBits |= 0x20;
        if (this.forks != null) nullBits |= 0x40;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.waitForDataFrom.getValue());
        PacketIO.requireFinite(this.horizontalSpeedMultiplier, "HorizontalSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 2, this.horizontalSpeedMultiplier);
        PacketIO.requireFinite(this.runTime, "RunTime"); mem.set(PacketIO.PROTO_FLOAT, offset + 6, this.runTime);
        mem.set(PacketIO.PROTO_INT, offset + 10, this.onItemChangeBehavior.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 14, this.failed);
        byte boolBits0_0 = 0;
        if (this.allowIndefiniteHold) boolBits0_0 |= 0x01;
        if (this.displayProgress) boolBits0_0 |= 0x02;
        if (this.cancelOnOtherClick) boolBits0_0 |= 0x04;
        if (this.failOnDamage) boolBits0_0 |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 18 + 0, boolBits0_0);
        PacketIO.requireFinite(this.mouseSensitivityAdjustmentTarget, "MouseSensitivityAdjustmentTarget"); mem.set(PacketIO.PROTO_FLOAT, offset + 19, this.mouseSensitivityAdjustmentTarget);
        PacketIO.requireFinite(this.mouseSensitivityAdjustmentDuration, "MouseSensitivityAdjustmentDuration"); mem.set(PacketIO.PROTO_FLOAT, offset + 23, this.mouseSensitivityAdjustmentDuration);
        if (this.chargingDelay != null) {
            this.chargingDelay.serialize(mem, offset + 27);
        } else {
            mem.asSlice(offset + 27, 20).fill((byte) 0); 
        }
        var varOffset = offset + 75;
        if (this.effects != null) {
            mem.set(PacketIO.PROTO_INT, offset + 47, varOffset - offset - 75);
            varOffset += this.effects.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 47, -1);
        }
        if (this.settings != null) {
            mem.set(PacketIO.PROTO_INT, offset + 51, varOffset - offset - 75);
            if (this.settings.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Settings", settings.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.settings.size());
            for (var e : this.settings.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 51, -1);
        }
        mem.set(PacketIO.PROTO_INT, offset + 55, varOffset - offset - 75);
        varOffset += this.rules.serialize(mem, varOffset);
        if (this.tags != null) {
            mem.set(PacketIO.PROTO_INT, offset + 59, varOffset - offset - 75);
            if (tags.length > 4096000) throw ProtocolException.arrayTooLong("Tags", tags.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.tags.length);
            
            MemorySegment.copy(this.tags, 0, mem, PacketIO.PROTO_INT, varOffset, this.tags.length);
            varOffset += this.tags.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 59, -1);
        }
        if (this.camera != null) {
            mem.set(PacketIO.PROTO_INT, offset + 63, varOffset - offset - 75);
            varOffset += this.camera.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 63, -1);
        }
        if (this.chargedNext != null) {
            mem.set(PacketIO.PROTO_INT, offset + 67, varOffset - offset - 75);
            if (this.chargedNext.size() > 4096000) throw ProtocolException.dictionaryTooLarge("ChargedNext", chargedNext.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.chargedNext.size());
            for (var e : this.chargedNext.entrySet()) {
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getKey());
                varOffset += 4;
                mem.set(PacketIO.PROTO_INT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 67, -1);
        }
        if (this.forks != null) {
            mem.set(PacketIO.PROTO_INT, offset + 71, varOffset - offset - 75);
            if (this.forks.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Forks", forks.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.forks.size());
            for (var e : this.forks.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                mem.set(PacketIO.PROTO_INT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 71, -1);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 75;
        if (effects != null) size += effects.computeSize();
    if (settings != null) size += VarInt.size(settings.size()) + settings.size() * (1 + 1);
    size += rules.computeSize();
    if (tags != null) size += VarInt.size(tags.length) + tags.length * 4;
    if (camera != null) size += camera.computeSize();
    if (chargedNext != null) size += VarInt.size(chargedNext.size()) + chargedNext.size() * (4 + 4);
    if (forks != null) size += VarInt.size(forks.size()) + forks.size() * (1 + 4);

        return size;
    }

    public ChargingInteraction clone() {
        ChargingInteraction copy = new ChargingInteraction();
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
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ChargingInteraction other)) return false;
        return java.util.Objects.equals(this.waitForDataFrom, other.waitForDataFrom) && java.util.Objects.equals(this.effects, other.effects) && this.horizontalSpeedMultiplier == other.horizontalSpeedMultiplier && this.runTime == other.runTime && java.util.Objects.equals(this.onItemChangeBehavior, other.onItemChangeBehavior) && java.util.Objects.equals(this.settings, other.settings) && java.util.Objects.equals(this.rules, other.rules) && java.util.Arrays.equals(this.tags, other.tags) && java.util.Objects.equals(this.camera, other.camera) && this.failed == other.failed && this.allowIndefiniteHold == other.allowIndefiniteHold && this.displayProgress == other.displayProgress && this.cancelOnOtherClick == other.cancelOnOtherClick && this.failOnDamage == other.failOnDamage && this.mouseSensitivityAdjustmentTarget == other.mouseSensitivityAdjustmentTarget && this.mouseSensitivityAdjustmentDuration == other.mouseSensitivityAdjustmentDuration && java.util.Objects.equals(this.chargedNext, other.chargedNext) && java.util.Objects.equals(this.forks, other.forks) && java.util.Objects.equals(this.chargingDelay, other.chargingDelay);
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
        return result;
    }

}