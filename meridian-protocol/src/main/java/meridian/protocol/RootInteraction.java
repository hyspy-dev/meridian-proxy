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

public class RootInteraction {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 7;
    public static final int VARIABLE_BLOCK_START = 34;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String id;
    @Nonnull public int[] interactions = new int[0];
    @Nullable public InteractionCooldown cooldown;
    @Nullable public java.util.Map<GameMode, RootInteractionSettings> settings;
    @Nonnull public InteractionRules rules = new InteractionRules();
    @Nullable public int[] tags;
    public float clickQueuingTimeout;
    public boolean requireNewClick;
    @Nullable public String hudInputBindingEntry;

    public RootInteraction() {
    }

    public RootInteraction(@Nullable String id, @Nonnull int[] interactions, @Nullable InteractionCooldown cooldown, @Nullable java.util.Map<GameMode, RootInteractionSettings> settings, @Nonnull InteractionRules rules, @Nullable int[] tags, float clickQueuingTimeout, boolean requireNewClick, @Nullable String hudInputBindingEntry) {
        this.id = id;
        this.interactions = interactions;
        this.cooldown = cooldown;
        this.settings = settings;
        this.rules = rules;
        this.tags = tags;
        this.clickQueuingTimeout = clickQueuingTimeout;
        this.requireNewClick = requireNewClick;
        this.hudInputBindingEntry = hudInputBindingEntry;
    }

    public RootInteraction(@Nonnull RootInteraction other) {
        this.id = other.id;
        this.interactions = other.interactions;
        this.cooldown = other.cooldown;
        this.settings = other.settings;
        this.rules = other.rules;
        this.tags = other.tags;
        this.clickQueuingTimeout = other.clickQueuingTimeout;
        this.requireNewClick = other.requireNewClick;
        this.hudInputBindingEntry = other.hudInputBindingEntry;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("RootInteraction", offset, (int) mem.byteSize());
        long needed = (long) offset + 34;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("RootInteraction", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 6, 34, "Id"), 4096000): null;
    }
    
    public static int[] getInteractions(MemorySegment mem) {
        return getInteractions(mem, 0);
    }
    
    public static int[] getInteractions(MemorySegment mem, int offset) {
        var off = offset + getValidatedOffset(mem, offset, 10, 34, "Interactions");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Interactions");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Interactions", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Interactions", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    @Nullable
    public static InteractionCooldown getCooldown(MemorySegment mem) {
        return getCooldown(mem, 0);
    }
    
    @Nullable
    public static InteractionCooldown getCooldown(MemorySegment mem, int offset) {
        return hasCooldown(mem, offset) ? InteractionCooldown.toObject(mem, offset + getValidatedOffset(mem, offset, 14, 34, "Cooldown")): null;
    }
    
    @Nullable
    public static java.util.Map<GameMode, RootInteractionSettings> getSettings(MemorySegment mem) {
        return getSettings(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<GameMode, RootInteractionSettings> getSettings(MemorySegment mem, int offset) {
        if (!hasSettings(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 18, 34, "Settings");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Settings");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Settings", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 3 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Settings", (int) java.lang.Math.min(off + (long) len * 3, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<GameMode, RootInteractionSettings> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = GameMode.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                off += 1;
            var value = RootInteractionSettings.toObject(mem, off, walkCursor);
                off = walkCursor.position;
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
        return InteractionRules.toObject(mem, offset + getValidatedOffset(mem, offset, 22, 34, "Rules"));
    }
    
    @Nullable
    public static int[] getTags(MemorySegment mem) {
        return getTags(mem, 0);
    }
    
    @Nullable
    public static int[] getTags(MemorySegment mem, int offset) {
        if (!hasTags(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 26, 34, "Tags");
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
    
    public static float getClickQueuingTimeout(MemorySegment mem) {
        return getClickQueuingTimeout(mem, 0);
    }
    
    public static float getClickQueuingTimeout(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "ClickQueuingTimeout");
    }
    
    public static boolean getRequireNewClick(MemorySegment mem) {
        return getRequireNewClick(mem, 0);
    }
    
    public static boolean getRequireNewClick(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 5);
    }
    
    @Nullable
    public static String getHudInputBindingEntry(MemorySegment mem) {
        return getHudInputBindingEntry(mem, 0);
    }
    
    @Nullable
    public static String getHudInputBindingEntry(MemorySegment mem, int offset) {
        return hasHudInputBindingEntry(mem, offset) ? PacketIO.readVarString("HudInputBindingEntry", mem, offset + getValidatedOffset(mem, offset, 30, 34, "HudInputBindingEntry"), 4096000): null;
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasCooldown(MemorySegment mem, int offset) {
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
    
    public static boolean hasHudInputBindingEntry(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
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
    
    public static RootInteraction toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static RootInteraction toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one RootInteraction and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static RootInteraction toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 34;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 6, -1, "Id");
        }
        
        int[] v1;
        requireSlot(mem, offset + 10, varPos, "Interactions");
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Interactions");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Interactions", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Interactions", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v1, 0, len);
            varPos = off + len * 4 - varBase;
        }
        
        InteractionCooldown v2 = null;
        if (hasCooldown(mem, offset)) {
            requireSlot(mem, offset + 14, varPos, "Cooldown");
            v2 = InteractionCooldown.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 14, -1, "Cooldown");
        }
        
        java.util.Map<GameMode, RootInteractionSettings> v3 = null;
        if (hasSettings(mem, offset)) {
            requireSlot(mem, offset + 18, varPos, "Settings");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Settings");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Settings", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 3 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Settings", (int) java.lang.Math.min(off + (long) len * 3, Integer.MAX_VALUE), (int) mem.byteSize());
            v3 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = GameMode.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                    off += 1;
                var value = RootInteractionSettings.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v3.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Settings", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 18, -1, "Settings");
        }
        
        InteractionRules v4;
        requireSlot(mem, offset + 22, varPos, "Rules");
        {
            v4 = InteractionRules.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        
        int[] v5 = null;
        if (hasTags(mem, offset)) {
            requireSlot(mem, offset + 26, varPos, "Tags");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Tags");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Tags", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Tags", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v5 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v5, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 26, -1, "Tags");
        }
        
        String v8 = null;
        if (hasHudInputBindingEntry(mem, offset)) {
            requireSlot(mem, offset + 30, varPos, "HudInputBindingEntry");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v8 = PacketIO.readVarString("HudInputBindingEntry", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 30, -1, "HudInputBindingEntry");
        }
        var result = new RootInteraction(
            v0,
            v1,
            v2,
            v3,
            v4,
            v5,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "ClickQueuingTimeout"),
            mem.get(PacketIO.PROTO_BOOL, offset + 5),
            v8
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        if (this.cooldown != null) nullBits |= 0x02;
        if (this.settings != null) nullBits |= 0x04;
        if (this.tags != null) nullBits |= 0x08;
        if (this.hudInputBindingEntry != null) nullBits |= 0x10;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.clickQueuingTimeout, "ClickQueuingTimeout"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.clickQueuingTimeout);
        mem.set(PacketIO.PROTO_BOOL, offset + 5, this.requireNewClick);
        var varOffset = offset + 34;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 34);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
        mem.set(PacketIO.PROTO_INT, offset + 10, varOffset - offset - 34);
        if (interactions.length > 4096000) throw ProtocolException.arrayTooLong("Interactions", interactions.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.interactions.length);
        
        MemorySegment.copy(this.interactions, 0, mem, PacketIO.PROTO_INT, varOffset, this.interactions.length);
        varOffset += this.interactions.length * 4;
        if (this.cooldown != null) {
            mem.set(PacketIO.PROTO_INT, offset + 14, varOffset - offset - 34);
            varOffset += this.cooldown.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 14, -1);
        }
        if (this.settings != null) {
            mem.set(PacketIO.PROTO_INT, offset + 18, varOffset - offset - 34);
            if (this.settings.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Settings", settings.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.settings.size());
            for (var e : this.settings.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 18, -1);
        }
        mem.set(PacketIO.PROTO_INT, offset + 22, varOffset - offset - 34);
        varOffset += this.rules.serialize(mem, varOffset);
        if (this.tags != null) {
            mem.set(PacketIO.PROTO_INT, offset + 26, varOffset - offset - 34);
            if (tags.length > 4096000) throw ProtocolException.arrayTooLong("Tags", tags.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.tags.length);
            
            MemorySegment.copy(this.tags, 0, mem, PacketIO.PROTO_INT, varOffset, this.tags.length);
            varOffset += this.tags.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 26, -1);
        }
        if (this.hudInputBindingEntry != null) {
            mem.set(PacketIO.PROTO_INT, offset + 30, varOffset - offset - 34);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.hudInputBindingEntry, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 30, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 34;
        if (id != null) size += PacketIO.stringSize(id);
    size += VarInt.size(interactions.length) + interactions.length * 4;
    if (cooldown != null) size += cooldown.computeSize();
    if (settings != null) {
        int settingsSize = 0;
for (var kvp : settings.entrySet()) settingsSize += 1 + kvp.getValue().computeSize();
size += VarInt.size(settings.size()) + settingsSize;
    }
    size += rules.computeSize();
    if (tags != null) size += VarInt.size(tags.length) + tags.length * 4;
    if (hudInputBindingEntry != null) size += PacketIO.stringSize(hudInputBindingEntry);

        return size;
    }

    public RootInteraction clone() {
        RootInteraction copy = new RootInteraction();
        copy.id = this.id;
        copy.interactions = java.util.Arrays.copyOf(this.interactions, this.interactions.length);
        copy.cooldown = this.cooldown != null ? this.cooldown.clone() : null;
        if (this.settings != null) {
            java.util.Map<GameMode, RootInteractionSettings> m = new java.util.HashMap<>();
            for (var e : this.settings.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.settings = m;
        }
        copy.rules = this.rules.clone();
        copy.tags = this.tags != null ? java.util.Arrays.copyOf(this.tags, this.tags.length) : null;
        copy.clickQueuingTimeout = this.clickQueuingTimeout;
        copy.requireNewClick = this.requireNewClick;
        copy.hudInputBindingEntry = this.hudInputBindingEntry;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RootInteraction other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Arrays.equals(this.interactions, other.interactions) && java.util.Objects.equals(this.cooldown, other.cooldown) && java.util.Objects.equals(this.settings, other.settings) && java.util.Objects.equals(this.rules, other.rules) && java.util.Arrays.equals(this.tags, other.tags) && this.clickQueuingTimeout == other.clickQueuingTimeout && this.requireNewClick == other.requireNewClick && java.util.Objects.equals(this.hudInputBindingEntry, other.hudInputBindingEntry);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(id);
        result = 31 * result + java.util.Arrays.hashCode(interactions);
        result = 31 * result + java.util.Objects.hashCode(cooldown);
        result = 31 * result + java.util.Objects.hashCode(settings);
        result = 31 * result + java.util.Objects.hashCode(rules);
        result = 31 * result + java.util.Arrays.hashCode(tags);
        result = 31 * result + Float.hashCode(clickQueuingTimeout);
        result = 31 * result + Boolean.hashCode(requireNewClick);
        result = 31 * result + java.util.Objects.hashCode(hudInputBindingEntry);
        return result;
    }

}