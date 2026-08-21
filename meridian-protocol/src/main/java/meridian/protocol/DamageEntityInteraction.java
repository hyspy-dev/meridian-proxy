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

public class DamageEntityInteraction extends Interaction {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 26;
    public static final int VARIABLE_FIELD_COUNT = 9;
    public static final int VARIABLE_BLOCK_START = 62;
    public static final int MAX_SIZE = 1677721600;

    public int next = Integer.MIN_VALUE;
    public int failed = Integer.MIN_VALUE;
    public int blocked = Integer.MIN_VALUE;
    @Nullable public DamageEffects damageEffects;
    @Nullable public AngledDamage[] angledDamage;
    @Nonnull public java.util.Map<String, TargetedDamage> targetedDamage = new java.util.HashMap<>();
    @Nullable public EntityStatOnHit[] entityStatsOnHit;

    public DamageEntityInteraction() {
    }

    public DamageEntityInteraction(@Nonnull WaitForDataFrom waitForDataFrom, @Nullable InteractionEffects effects, float horizontalSpeedMultiplier, float runTime, @Nonnull InteractionItemChangeBehavior onItemChangeBehavior, @Nullable java.util.Map<GameMode, InteractionSettings> settings, @Nonnull InteractionRules rules, @Nullable int[] tags, @Nullable InteractionCameraSettings camera, int next, int failed, int blocked, @Nullable DamageEffects damageEffects, @Nullable AngledDamage[] angledDamage, @Nonnull java.util.Map<String, TargetedDamage> targetedDamage, @Nullable EntityStatOnHit[] entityStatsOnHit) {
        this.waitForDataFrom = waitForDataFrom;
        this.effects = effects;
        this.horizontalSpeedMultiplier = horizontalSpeedMultiplier;
        this.runTime = runTime;
        this.onItemChangeBehavior = onItemChangeBehavior;
        this.settings = settings;
        this.rules = rules;
        this.tags = tags;
        this.camera = camera;
        this.next = next;
        this.failed = failed;
        this.blocked = blocked;
        this.damageEffects = damageEffects;
        this.angledDamage = angledDamage;
        this.targetedDamage = targetedDamage;
        this.entityStatsOnHit = entityStatsOnHit;
    }

    public DamageEntityInteraction(@Nonnull DamageEntityInteraction other) {
        this.waitForDataFrom = other.waitForDataFrom;
        this.effects = other.effects;
        this.horizontalSpeedMultiplier = other.horizontalSpeedMultiplier;
        this.runTime = other.runTime;
        this.onItemChangeBehavior = other.onItemChangeBehavior;
        this.settings = other.settings;
        this.rules = other.rules;
        this.tags = other.tags;
        this.camera = other.camera;
        this.next = other.next;
        this.failed = other.failed;
        this.blocked = other.blocked;
        this.damageEffects = other.damageEffects;
        this.angledDamage = other.angledDamage;
        this.targetedDamage = other.targetedDamage;
        this.entityStatsOnHit = other.entityStatsOnHit;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("DamageEntityInteraction", offset, (int) mem.byteSize());
        long needed = (long) offset + 62;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("DamageEntityInteraction", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
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
        return hasEffects(mem, offset) ? InteractionEffects.toObject(mem, offset + getValidatedOffset(mem, offset, 26, 62, "Effects")): null;
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
        var off = offset + getValidatedOffset(mem, offset, 30, 62, "Settings");
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
        return InteractionRules.toObject(mem, offset + getValidatedOffset(mem, offset, 34, 62, "Rules"));
    }
    
    @Nullable
    public static int[] getTags(MemorySegment mem) {
        return getTags(mem, 0);
    }
    
    @Nullable
    public static int[] getTags(MemorySegment mem, int offset) {
        if (!hasTags(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 38, 62, "Tags");
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
        return hasCamera(mem, offset) ? InteractionCameraSettings.toObject(mem, offset + getValidatedOffset(mem, offset, 42, 62, "Camera")): null;
    }
    
    public static int getNext(MemorySegment mem) {
        return getNext(mem, 0);
    }
    
    public static int getNext(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 14);
    }
    
    public static int getFailed(MemorySegment mem) {
        return getFailed(mem, 0);
    }
    
    public static int getFailed(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 18);
    }
    
    public static int getBlocked(MemorySegment mem) {
        return getBlocked(mem, 0);
    }
    
    public static int getBlocked(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 22);
    }
    
    @Nullable
    public static DamageEffects getDamageEffects(MemorySegment mem) {
        return getDamageEffects(mem, 0);
    }
    
    @Nullable
    public static DamageEffects getDamageEffects(MemorySegment mem, int offset) {
        return hasDamageEffects(mem, offset) ? DamageEffects.toObject(mem, offset + getValidatedOffset(mem, offset, 46, 62, "DamageEffects")): null;
    }
    
    @Nullable
    public static AngledDamage[] getAngledDamage(MemorySegment mem) {
        return getAngledDamage(mem, 0);
    }
    
    @Nullable
    public static AngledDamage[] getAngledDamage(MemorySegment mem, int offset) {
        if (!hasAngledDamage(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 50, 62, "AngledDamage");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("AngledDamage");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("AngledDamage", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 21 > mem.byteSize()) throw ProtocolException.bufferTooSmall("AngledDamage", (int) java.lang.Math.min(off + lenOffset + (long) len * 21, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new AngledDamage[len];
        for (var i = 0; i < len; i++) {
            data[i] = AngledDamage.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static java.util.Map<String, TargetedDamage> getTargetedDamage(MemorySegment mem) {
        return getTargetedDamage(mem, 0);
    }
    
    public static java.util.Map<String, TargetedDamage> getTargetedDamage(MemorySegment mem, int offset) {
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 54, 62, "TargetedDamage");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("TargetedDamage");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("TargetedDamage", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 10 > mem.byteSize()) throw ProtocolException.bufferTooSmall("TargetedDamage", (int) java.lang.Math.min(off + (long) len * 10, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, TargetedDamage> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = TargetedDamage.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("TargetedDamage", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static EntityStatOnHit[] getEntityStatsOnHit(MemorySegment mem) {
        return getEntityStatsOnHit(mem, 0);
    }
    
    @Nullable
    public static EntityStatOnHit[] getEntityStatsOnHit(MemorySegment mem, int offset) {
        if (!hasEntityStatsOnHit(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 58, 62, "EntityStatsOnHit");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("EntityStatsOnHit");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("EntityStatsOnHit", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 12 > mem.byteSize()) throw ProtocolException.bufferTooSmall("EntityStatsOnHit", (int) java.lang.Math.min(off + lenOffset + (long) len * 12, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new EntityStatOnHit[len];
        for (var i = 0; i < len; i++) {
            data[i] = EntityStatOnHit.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasEffects(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasSettings(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasTags(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasCamera(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasDamageEffects(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasAngledDamage(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasEntityStatsOnHit(MemorySegment mem, int offset) {
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
    
    public static DamageEntityInteraction toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static DamageEntityInteraction toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one DamageEntityInteraction and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static DamageEntityInteraction toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 62;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        InteractionEffects v1 = null;
        if (hasEffects(mem, offset)) {
            requireSlot(mem, offset + 26, varPos, "Effects");
            v1 = InteractionEffects.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 26, -1, "Effects");
        }
        
        java.util.Map<GameMode, InteractionSettings> v5 = null;
        if (hasSettings(mem, offset)) {
            requireSlot(mem, offset + 30, varPos, "Settings");
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
            requireSlot(mem, offset + 30, -1, "Settings");
        }
        
        InteractionRules v6;
        requireSlot(mem, offset + 34, varPos, "Rules");
        {
            v6 = InteractionRules.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        
        int[] v7 = null;
        if (hasTags(mem, offset)) {
            requireSlot(mem, offset + 38, varPos, "Tags");
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
            requireSlot(mem, offset + 38, -1, "Tags");
        }
        
        InteractionCameraSettings v8 = null;
        if (hasCamera(mem, offset)) {
            requireSlot(mem, offset + 42, varPos, "Camera");
            v8 = InteractionCameraSettings.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 42, -1, "Camera");
        }
        
        DamageEffects v12 = null;
        if (hasDamageEffects(mem, offset)) {
            requireSlot(mem, offset + 46, varPos, "DamageEffects");
            v12 = DamageEffects.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 46, -1, "DamageEffects");
        }
        
        AngledDamage[] v13 = null;
        if (hasAngledDamage(mem, offset)) {
            requireSlot(mem, offset + 50, varPos, "AngledDamage");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("AngledDamage");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("AngledDamage", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 21 > mem.byteSize()) throw ProtocolException.bufferTooSmall("AngledDamage", (int) java.lang.Math.min(off + lenOffset + (long) len * 21, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v13 = new AngledDamage[len];
            for (var i = 0; i < len; i++) {
                v13[i] = AngledDamage.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 50, -1, "AngledDamage");
        }
        
        java.util.Map<String, TargetedDamage> v14;
        requireSlot(mem, offset + 54, varPos, "TargetedDamage");
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("TargetedDamage");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("TargetedDamage", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 10 > mem.byteSize()) throw ProtocolException.bufferTooSmall("TargetedDamage", (int) java.lang.Math.min(off + (long) len * 10, Integer.MAX_VALUE), (int) mem.byteSize());
            v14 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = TargetedDamage.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v14.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("TargetedDamage", key);
                }
            }
            varPos = off - varBase;
        }
        
        EntityStatOnHit[] v15 = null;
        if (hasEntityStatsOnHit(mem, offset)) {
            requireSlot(mem, offset + 58, varPos, "EntityStatsOnHit");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("EntityStatsOnHit");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("EntityStatsOnHit", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 12 > mem.byteSize()) throw ProtocolException.bufferTooSmall("EntityStatsOnHit", (int) java.lang.Math.min(off + lenOffset + (long) len * 12, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v15 = new EntityStatOnHit[len];
            for (var i = 0; i < len; i++) {
                v15[i] = EntityStatOnHit.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 58, -1, "EntityStatsOnHit");
        }
        var result = new DamageEntityInteraction(
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
            mem.get(PacketIO.PROTO_INT, offset + 18),
            mem.get(PacketIO.PROTO_INT, offset + 22),
            v12,
            v13,
            v14,
            v15
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.effects != null) nullBits |= 0x01;
        if (this.settings != null) nullBits |= 0x02;
        if (this.tags != null) nullBits |= 0x04;
        if (this.camera != null) nullBits |= 0x08;
        if (this.damageEffects != null) nullBits |= 0x10;
        if (this.angledDamage != null) nullBits |= 0x20;
        if (this.entityStatsOnHit != null) nullBits |= 0x40;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.waitForDataFrom.getValue());
        PacketIO.requireFinite(this.horizontalSpeedMultiplier, "HorizontalSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 2, this.horizontalSpeedMultiplier);
        PacketIO.requireFinite(this.runTime, "RunTime"); mem.set(PacketIO.PROTO_FLOAT, offset + 6, this.runTime);
        mem.set(PacketIO.PROTO_INT, offset + 10, this.onItemChangeBehavior.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 14, this.next);
        mem.set(PacketIO.PROTO_INT, offset + 18, this.failed);
        mem.set(PacketIO.PROTO_INT, offset + 22, this.blocked);
        var varOffset = offset + 62;
        if (this.effects != null) {
            mem.set(PacketIO.PROTO_INT, offset + 26, varOffset - offset - 62);
            varOffset += this.effects.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 26, -1);
        }
        if (this.settings != null) {
            mem.set(PacketIO.PROTO_INT, offset + 30, varOffset - offset - 62);
            if (this.settings.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Settings", settings.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.settings.size());
            for (var e : this.settings.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 30, -1);
        }
        mem.set(PacketIO.PROTO_INT, offset + 34, varOffset - offset - 62);
        varOffset += this.rules.serialize(mem, varOffset);
        if (this.tags != null) {
            mem.set(PacketIO.PROTO_INT, offset + 38, varOffset - offset - 62);
            if (tags.length > 4096000) throw ProtocolException.arrayTooLong("Tags", tags.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.tags.length);
            
            MemorySegment.copy(this.tags, 0, mem, PacketIO.PROTO_INT, varOffset, this.tags.length);
            varOffset += this.tags.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 38, -1);
        }
        if (this.camera != null) {
            mem.set(PacketIO.PROTO_INT, offset + 42, varOffset - offset - 62);
            varOffset += this.camera.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 42, -1);
        }
        if (this.damageEffects != null) {
            mem.set(PacketIO.PROTO_INT, offset + 46, varOffset - offset - 62);
            varOffset += this.damageEffects.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 46, -1);
        }
        if (this.angledDamage != null) {
            mem.set(PacketIO.PROTO_INT, offset + 50, varOffset - offset - 62);
            if (angledDamage.length > 4096000) throw ProtocolException.arrayTooLong("AngledDamage", angledDamage.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.angledDamage.length);
            
            var angledDamageValueOffset = 0;
            for (var i = 0; i < this.angledDamage.length; i++) {
                angledDamageValueOffset += this.angledDamage[i].serialize(mem, varOffset + angledDamageValueOffset);
            }
            varOffset += angledDamageValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 50, -1);
        }
        mem.set(PacketIO.PROTO_INT, offset + 54, varOffset - offset - 62);
        if (this.targetedDamage.size() > 4096000) throw ProtocolException.dictionaryTooLarge("TargetedDamage", targetedDamage.size(), 4096000);
        varOffset += VarInt.set(mem, varOffset, this.targetedDamage.size());
        for (var e : this.targetedDamage.entrySet()) {
            varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
            varOffset += e.getValue().serialize(mem, varOffset);
        }
        if (this.entityStatsOnHit != null) {
            mem.set(PacketIO.PROTO_INT, offset + 58, varOffset - offset - 62);
            if (entityStatsOnHit.length > 4096000) throw ProtocolException.arrayTooLong("EntityStatsOnHit", entityStatsOnHit.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.entityStatsOnHit.length);
            
            var entityStatsOnHitValueOffset = 0;
            for (var i = 0; i < this.entityStatsOnHit.length; i++) {
                entityStatsOnHitValueOffset += this.entityStatsOnHit[i].serialize(mem, varOffset + entityStatsOnHitValueOffset);
            }
            varOffset += entityStatsOnHitValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 58, -1);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 62;
        if (effects != null) size += effects.computeSize();
    if (settings != null) size += VarInt.size(settings.size()) + settings.size() * (1 + 1);
    size += rules.computeSize();
    if (tags != null) size += VarInt.size(tags.length) + tags.length * 4;
    if (camera != null) size += camera.computeSize();
    if (damageEffects != null) size += damageEffects.computeSize();
    if (angledDamage != null) {
        int angledDamageSize = 0;
for (var elem : angledDamage) angledDamageSize += elem.computeSize();
size += VarInt.size(angledDamage.length) + angledDamageSize;
    }
    int targetedDamageSize = 0;
for (var kvp : targetedDamage.entrySet()) targetedDamageSize += PacketIO.stringSize(kvp.getKey()) + kvp.getValue().computeSize();
size += VarInt.size(targetedDamage.size()) + targetedDamageSize;
    if (entityStatsOnHit != null) {
        int entityStatsOnHitSize = 0;
for (var elem : entityStatsOnHit) entityStatsOnHitSize += elem.computeSize();
size += VarInt.size(entityStatsOnHit.length) + entityStatsOnHitSize;
    }

        return size;
    }

    public DamageEntityInteraction clone() {
        DamageEntityInteraction copy = new DamageEntityInteraction();
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
        copy.next = this.next;
        copy.failed = this.failed;
        copy.blocked = this.blocked;
        copy.damageEffects = this.damageEffects != null ? this.damageEffects.clone() : null;
        copy.angledDamage = this.angledDamage != null ? java.util.Arrays.stream(this.angledDamage).map(e -> e.clone()).toArray(AngledDamage[]::new) : null;
        {
            java.util.Map<String, TargetedDamage> m = new java.util.HashMap<>();
            for (var e : this.targetedDamage.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.targetedDamage = m;
        }
        copy.entityStatsOnHit = this.entityStatsOnHit != null ? java.util.Arrays.stream(this.entityStatsOnHit).map(e -> e.clone()).toArray(EntityStatOnHit[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DamageEntityInteraction other)) return false;
        return java.util.Objects.equals(this.waitForDataFrom, other.waitForDataFrom) && java.util.Objects.equals(this.effects, other.effects) && this.horizontalSpeedMultiplier == other.horizontalSpeedMultiplier && this.runTime == other.runTime && java.util.Objects.equals(this.onItemChangeBehavior, other.onItemChangeBehavior) && java.util.Objects.equals(this.settings, other.settings) && java.util.Objects.equals(this.rules, other.rules) && java.util.Arrays.equals(this.tags, other.tags) && java.util.Objects.equals(this.camera, other.camera) && this.next == other.next && this.failed == other.failed && this.blocked == other.blocked && java.util.Objects.equals(this.damageEffects, other.damageEffects) && java.util.Arrays.equals(this.angledDamage, other.angledDamage) && java.util.Objects.equals(this.targetedDamage, other.targetedDamage) && java.util.Arrays.equals(this.entityStatsOnHit, other.entityStatsOnHit);
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
        result = 31 * result + Integer.hashCode(next);
        result = 31 * result + Integer.hashCode(failed);
        result = 31 * result + Integer.hashCode(blocked);
        result = 31 * result + java.util.Objects.hashCode(damageEffects);
        result = 31 * result + java.util.Arrays.hashCode(angledDamage);
        result = 31 * result + java.util.Objects.hashCode(targetedDamage);
        result = 31 * result + java.util.Arrays.hashCode(entityStatsOnHit);
        return result;
    }

}