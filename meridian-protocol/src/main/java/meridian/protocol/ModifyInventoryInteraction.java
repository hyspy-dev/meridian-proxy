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

public class ModifyInventoryInteraction extends SimpleInteraction {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 35;
    public static final int VARIABLE_FIELD_COUNT = 8;
    public static final int VARIABLE_BLOCK_START = 67;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public GameMode requiredGameMode;
    @Nullable public ItemWithAllMetadata itemToRemove;
    public int adjustHeldItemQuantity;
    @Nullable public ItemWithAllMetadata itemToAdd;
    @Nullable public String brokenItem;
    public double adjustHeldItemDurability;

    public ModifyInventoryInteraction() {
    }

    public ModifyInventoryInteraction(@Nonnull WaitForDataFrom waitForDataFrom, @Nullable InteractionEffects effects, float horizontalSpeedMultiplier, float runTime, @Nonnull InteractionItemChangeBehavior onItemChangeBehavior, @Nullable java.util.Map<GameMode, InteractionSettings> settings, @Nonnull InteractionRules rules, @Nullable int[] tags, @Nullable InteractionCameraSettings camera, int next, int failed, @Nullable GameMode requiredGameMode, @Nullable ItemWithAllMetadata itemToRemove, int adjustHeldItemQuantity, @Nullable ItemWithAllMetadata itemToAdd, @Nullable String brokenItem, double adjustHeldItemDurability) {
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
        this.requiredGameMode = requiredGameMode;
        this.itemToRemove = itemToRemove;
        this.adjustHeldItemQuantity = adjustHeldItemQuantity;
        this.itemToAdd = itemToAdd;
        this.brokenItem = brokenItem;
        this.adjustHeldItemDurability = adjustHeldItemDurability;
    }

    public ModifyInventoryInteraction(@Nonnull ModifyInventoryInteraction other) {
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
        this.requiredGameMode = other.requiredGameMode;
        this.itemToRemove = other.itemToRemove;
        this.adjustHeldItemQuantity = other.adjustHeldItemQuantity;
        this.itemToAdd = other.itemToAdd;
        this.brokenItem = other.brokenItem;
        this.adjustHeldItemDurability = other.adjustHeldItemDurability;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ModifyInventoryInteraction", offset, (int) mem.byteSize());
        long needed = (long) offset + 67;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ModifyInventoryInteraction", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
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
        return hasEffects(mem, offset) ? InteractionEffects.toObject(mem, offset + getValidatedOffset(mem, offset, 35, 67, "Effects")): null;
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
        var off = offset + getValidatedOffset(mem, offset, 39, 67, "Settings");
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
        return InteractionRules.toObject(mem, offset + getValidatedOffset(mem, offset, 43, 67, "Rules"));
    }
    
    @Nullable
    public static int[] getTags(MemorySegment mem) {
        return getTags(mem, 0);
    }
    
    @Nullable
    public static int[] getTags(MemorySegment mem, int offset) {
        if (!hasTags(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 47, 67, "Tags");
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
        return hasCamera(mem, offset) ? InteractionCameraSettings.toObject(mem, offset + getValidatedOffset(mem, offset, 51, 67, "Camera")): null;
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
    
    @Nullable
    public static GameMode getRequiredGameMode(MemorySegment mem) {
        return getRequiredGameMode(mem, 0);
    }
    
    @Nullable
    public static GameMode getRequiredGameMode(MemorySegment mem, int offset) {
        return hasRequiredGameMode(mem, offset) ? GameMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 22)): null;
    }
    
    @Nullable
    public static ItemWithAllMetadata getItemToRemove(MemorySegment mem) {
        return getItemToRemove(mem, 0);
    }
    
    @Nullable
    public static ItemWithAllMetadata getItemToRemove(MemorySegment mem, int offset) {
        return hasItemToRemove(mem, offset) ? ItemWithAllMetadata.toObject(mem, offset + getValidatedOffset(mem, offset, 55, 67, "ItemToRemove")): null;
    }
    
    public static int getAdjustHeldItemQuantity(MemorySegment mem) {
        return getAdjustHeldItemQuantity(mem, 0);
    }
    
    public static int getAdjustHeldItemQuantity(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 23);
    }
    
    @Nullable
    public static ItemWithAllMetadata getItemToAdd(MemorySegment mem) {
        return getItemToAdd(mem, 0);
    }
    
    @Nullable
    public static ItemWithAllMetadata getItemToAdd(MemorySegment mem, int offset) {
        return hasItemToAdd(mem, offset) ? ItemWithAllMetadata.toObject(mem, offset + getValidatedOffset(mem, offset, 59, 67, "ItemToAdd")): null;
    }
    
    @Nullable
    public static String getBrokenItem(MemorySegment mem) {
        return getBrokenItem(mem, 0);
    }
    
    @Nullable
    public static String getBrokenItem(MemorySegment mem, int offset) {
        return hasBrokenItem(mem, offset) ? PacketIO.readVarString("BrokenItem", mem, offset + getValidatedOffset(mem, offset, 63, 67, "BrokenItem"), 4096000): null;
    }
    
    public static double getAdjustHeldItemDurability(MemorySegment mem) {
        return getAdjustHeldItemDurability(mem, 0);
    }
    
    public static double getAdjustHeldItemDurability(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 27), "AdjustHeldItemDurability");
    }
    
    public static boolean hasRequiredGameMode(MemorySegment mem, int offset) {
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
    
    public static boolean hasItemToRemove(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasItemToAdd(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasBrokenItem(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
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
    
    public static ModifyInventoryInteraction toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ModifyInventoryInteraction toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ModifyInventoryInteraction and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ModifyInventoryInteraction toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 67;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        InteractionEffects v1 = null;
        if (hasEffects(mem, offset)) {
            requireSlot(mem, offset + 35, varPos, "Effects");
            v1 = InteractionEffects.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 35, -1, "Effects");
        }
        
        java.util.Map<GameMode, InteractionSettings> v5 = null;
        if (hasSettings(mem, offset)) {
            requireSlot(mem, offset + 39, varPos, "Settings");
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
            requireSlot(mem, offset + 39, -1, "Settings");
        }
        
        InteractionRules v6;
        requireSlot(mem, offset + 43, varPos, "Rules");
        {
            v6 = InteractionRules.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        
        int[] v7 = null;
        if (hasTags(mem, offset)) {
            requireSlot(mem, offset + 47, varPos, "Tags");
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
            requireSlot(mem, offset + 47, -1, "Tags");
        }
        
        InteractionCameraSettings v8 = null;
        if (hasCamera(mem, offset)) {
            requireSlot(mem, offset + 51, varPos, "Camera");
            v8 = InteractionCameraSettings.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 51, -1, "Camera");
        }
        
        ItemWithAllMetadata v12 = null;
        if (hasItemToRemove(mem, offset)) {
            requireSlot(mem, offset + 55, varPos, "ItemToRemove");
            v12 = ItemWithAllMetadata.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 55, -1, "ItemToRemove");
        }
        
        ItemWithAllMetadata v14 = null;
        if (hasItemToAdd(mem, offset)) {
            requireSlot(mem, offset + 59, varPos, "ItemToAdd");
            v14 = ItemWithAllMetadata.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 59, -1, "ItemToAdd");
        }
        
        String v15 = null;
        if (hasBrokenItem(mem, offset)) {
            requireSlot(mem, offset + 63, varPos, "BrokenItem");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v15 = PacketIO.readVarString("BrokenItem", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 63, -1, "BrokenItem");
        }
        var result = new ModifyInventoryInteraction(
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
            hasRequiredGameMode(mem, offset) ? GameMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 22)) : null,
            v12,
            mem.get(PacketIO.PROTO_INT, offset + 23),
            v14,
            v15,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 27), "AdjustHeldItemDurability")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.requiredGameMode != null) nullBits |= 0x01;
        if (this.effects != null) nullBits |= 0x02;
        if (this.settings != null) nullBits |= 0x04;
        if (this.tags != null) nullBits |= 0x08;
        if (this.camera != null) nullBits |= 0x10;
        if (this.itemToRemove != null) nullBits |= 0x20;
        if (this.itemToAdd != null) nullBits |= 0x40;
        if (this.brokenItem != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.waitForDataFrom.getValue());
        PacketIO.requireFinite(this.horizontalSpeedMultiplier, "HorizontalSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 2, this.horizontalSpeedMultiplier);
        PacketIO.requireFinite(this.runTime, "RunTime"); mem.set(PacketIO.PROTO_FLOAT, offset + 6, this.runTime);
        mem.set(PacketIO.PROTO_INT, offset + 10, this.onItemChangeBehavior.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 14, this.next);
        mem.set(PacketIO.PROTO_INT, offset + 18, this.failed);
        if (this.requiredGameMode != null) {
            mem.set(PacketIO.PROTO_BYTE, offset + 22, (byte) this.requiredGameMode.getValue());
        } else {
            mem.asSlice(offset + 22, 1).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_INT, offset + 23, this.adjustHeldItemQuantity);
        PacketIO.requireFinite(this.adjustHeldItemDurability, "AdjustHeldItemDurability"); mem.set(PacketIO.PROTO_DOUBLE, offset + 27, this.adjustHeldItemDurability);
        var varOffset = offset + 67;
        if (this.effects != null) {
            mem.set(PacketIO.PROTO_INT, offset + 35, varOffset - offset - 67);
            varOffset += this.effects.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 35, -1);
        }
        if (this.settings != null) {
            mem.set(PacketIO.PROTO_INT, offset + 39, varOffset - offset - 67);
            if (this.settings.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Settings", settings.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.settings.size());
            for (var e : this.settings.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 39, -1);
        }
        mem.set(PacketIO.PROTO_INT, offset + 43, varOffset - offset - 67);
        varOffset += this.rules.serialize(mem, varOffset);
        if (this.tags != null) {
            mem.set(PacketIO.PROTO_INT, offset + 47, varOffset - offset - 67);
            if (tags.length > 4096000) throw ProtocolException.arrayTooLong("Tags", tags.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.tags.length);
            
            MemorySegment.copy(this.tags, 0, mem, PacketIO.PROTO_INT, varOffset, this.tags.length);
            varOffset += this.tags.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 47, -1);
        }
        if (this.camera != null) {
            mem.set(PacketIO.PROTO_INT, offset + 51, varOffset - offset - 67);
            varOffset += this.camera.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 51, -1);
        }
        if (this.itemToRemove != null) {
            mem.set(PacketIO.PROTO_INT, offset + 55, varOffset - offset - 67);
            varOffset += this.itemToRemove.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 55, -1);
        }
        if (this.itemToAdd != null) {
            mem.set(PacketIO.PROTO_INT, offset + 59, varOffset - offset - 67);
            varOffset += this.itemToAdd.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 59, -1);
        }
        if (this.brokenItem != null) {
            mem.set(PacketIO.PROTO_INT, offset + 63, varOffset - offset - 67);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.brokenItem, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 63, -1);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 67;
        if (effects != null) size += effects.computeSize();
    if (settings != null) size += VarInt.size(settings.size()) + settings.size() * (1 + 1);
    size += rules.computeSize();
    if (tags != null) size += VarInt.size(tags.length) + tags.length * 4;
    if (camera != null) size += camera.computeSize();
    if (itemToRemove != null) size += itemToRemove.computeSize();
    if (itemToAdd != null) size += itemToAdd.computeSize();
    if (brokenItem != null) size += PacketIO.stringSize(brokenItem);

        return size;
    }

    public ModifyInventoryInteraction clone() {
        ModifyInventoryInteraction copy = new ModifyInventoryInteraction();
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
        copy.requiredGameMode = this.requiredGameMode;
        copy.itemToRemove = this.itemToRemove != null ? this.itemToRemove.clone() : null;
        copy.adjustHeldItemQuantity = this.adjustHeldItemQuantity;
        copy.itemToAdd = this.itemToAdd != null ? this.itemToAdd.clone() : null;
        copy.brokenItem = this.brokenItem;
        copy.adjustHeldItemDurability = this.adjustHeldItemDurability;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ModifyInventoryInteraction other)) return false;
        return java.util.Objects.equals(this.waitForDataFrom, other.waitForDataFrom) && java.util.Objects.equals(this.effects, other.effects) && this.horizontalSpeedMultiplier == other.horizontalSpeedMultiplier && this.runTime == other.runTime && java.util.Objects.equals(this.onItemChangeBehavior, other.onItemChangeBehavior) && java.util.Objects.equals(this.settings, other.settings) && java.util.Objects.equals(this.rules, other.rules) && java.util.Arrays.equals(this.tags, other.tags) && java.util.Objects.equals(this.camera, other.camera) && this.next == other.next && this.failed == other.failed && java.util.Objects.equals(this.requiredGameMode, other.requiredGameMode) && java.util.Objects.equals(this.itemToRemove, other.itemToRemove) && this.adjustHeldItemQuantity == other.adjustHeldItemQuantity && java.util.Objects.equals(this.itemToAdd, other.itemToAdd) && java.util.Objects.equals(this.brokenItem, other.brokenItem) && this.adjustHeldItemDurability == other.adjustHeldItemDurability;
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
        result = 31 * result + java.util.Objects.hashCode(requiredGameMode);
        result = 31 * result + java.util.Objects.hashCode(itemToRemove);
        result = 31 * result + Integer.hashCode(adjustHeldItemQuantity);
        result = 31 * result + java.util.Objects.hashCode(itemToAdd);
        result = 31 * result + java.util.Objects.hashCode(brokenItem);
        result = 31 * result + Double.hashCode(adjustHeldItemDurability);
        return result;
    }

}