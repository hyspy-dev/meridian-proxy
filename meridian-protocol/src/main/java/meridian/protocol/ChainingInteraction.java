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

public class ChainingInteraction extends Interaction {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 18;
    public static final int VARIABLE_FIELD_COUNT = 8;
    public static final int VARIABLE_BLOCK_START = 50;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String chainId;
    public float chainingAllowance;
    @Nonnull public int[] chainingNext = new int[0];
    @Nullable public java.util.Map<String, Integer> flags;

    public ChainingInteraction() {
    }

    public ChainingInteraction(@Nonnull WaitForDataFrom waitForDataFrom, @Nullable InteractionEffects effects, float horizontalSpeedMultiplier, float runTime, @Nonnull InteractionItemChangeBehavior onItemChangeBehavior, @Nullable java.util.Map<GameMode, InteractionSettings> settings, @Nonnull InteractionRules rules, @Nullable int[] tags, @Nullable InteractionCameraSettings camera, @Nullable String chainId, float chainingAllowance, @Nonnull int[] chainingNext, @Nullable java.util.Map<String, Integer> flags) {
        this.waitForDataFrom = waitForDataFrom;
        this.effects = effects;
        this.horizontalSpeedMultiplier = horizontalSpeedMultiplier;
        this.runTime = runTime;
        this.onItemChangeBehavior = onItemChangeBehavior;
        this.settings = settings;
        this.rules = rules;
        this.tags = tags;
        this.camera = camera;
        this.chainId = chainId;
        this.chainingAllowance = chainingAllowance;
        this.chainingNext = chainingNext;
        this.flags = flags;
    }

    public ChainingInteraction(@Nonnull ChainingInteraction other) {
        this.waitForDataFrom = other.waitForDataFrom;
        this.effects = other.effects;
        this.horizontalSpeedMultiplier = other.horizontalSpeedMultiplier;
        this.runTime = other.runTime;
        this.onItemChangeBehavior = other.onItemChangeBehavior;
        this.settings = other.settings;
        this.rules = other.rules;
        this.tags = other.tags;
        this.camera = other.camera;
        this.chainId = other.chainId;
        this.chainingAllowance = other.chainingAllowance;
        this.chainingNext = other.chainingNext;
        this.flags = other.flags;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ChainingInteraction", offset, (int) mem.byteSize());
        long needed = (long) offset + 50;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ChainingInteraction", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
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
        return hasEffects(mem, offset) ? InteractionEffects.toObject(mem, offset + getValidatedOffset(mem, offset, 18, 50, "Effects")): null;
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
        var off = offset + getValidatedOffset(mem, offset, 22, 50, "Settings");
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
        return InteractionRules.toObject(mem, offset + getValidatedOffset(mem, offset, 26, 50, "Rules"));
    }
    
    @Nullable
    public static int[] getTags(MemorySegment mem) {
        return getTags(mem, 0);
    }
    
    @Nullable
    public static int[] getTags(MemorySegment mem, int offset) {
        if (!hasTags(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 30, 50, "Tags");
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
        return hasCamera(mem, offset) ? InteractionCameraSettings.toObject(mem, offset + getValidatedOffset(mem, offset, 34, 50, "Camera")): null;
    }
    
    @Nullable
    public static String getChainId(MemorySegment mem) {
        return getChainId(mem, 0);
    }
    
    @Nullable
    public static String getChainId(MemorySegment mem, int offset) {
        return hasChainId(mem, offset) ? PacketIO.readVarString("ChainId", mem, offset + getValidatedOffset(mem, offset, 38, 50, "ChainId"), 4096000): null;
    }
    
    public static float getChainingAllowance(MemorySegment mem) {
        return getChainingAllowance(mem, 0);
    }
    
    public static float getChainingAllowance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 14), "ChainingAllowance");
    }
    
    public static int[] getChainingNext(MemorySegment mem) {
        return getChainingNext(mem, 0);
    }
    
    public static int[] getChainingNext(MemorySegment mem, int offset) {
        var off = offset + getValidatedOffset(mem, offset, 42, 50, "ChainingNext");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ChainingNext");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("ChainingNext", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ChainingNext", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    @Nullable
    public static java.util.Map<String, Integer> getFlags(MemorySegment mem) {
        return getFlags(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, Integer> getFlags(MemorySegment mem, int offset) {
        if (!hasFlags(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 46, 50, "Flags");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Flags");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Flags", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Flags", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, Integer> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Flags", key);
            }
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
    
    public static boolean hasChainId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasFlags(MemorySegment mem, int offset) {
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
    
    public static ChainingInteraction toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ChainingInteraction toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ChainingInteraction and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ChainingInteraction toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 50;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        InteractionEffects v1 = null;
        if (hasEffects(mem, offset)) {
            requireSlot(mem, offset + 18, varPos, "Effects");
            v1 = InteractionEffects.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 18, -1, "Effects");
        }
        
        java.util.Map<GameMode, InteractionSettings> v5 = null;
        if (hasSettings(mem, offset)) {
            requireSlot(mem, offset + 22, varPos, "Settings");
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
            requireSlot(mem, offset + 22, -1, "Settings");
        }
        
        InteractionRules v6;
        requireSlot(mem, offset + 26, varPos, "Rules");
        {
            v6 = InteractionRules.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        
        int[] v7 = null;
        if (hasTags(mem, offset)) {
            requireSlot(mem, offset + 30, varPos, "Tags");
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
            requireSlot(mem, offset + 30, -1, "Tags");
        }
        
        InteractionCameraSettings v8 = null;
        if (hasCamera(mem, offset)) {
            requireSlot(mem, offset + 34, varPos, "Camera");
            v8 = InteractionCameraSettings.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 34, -1, "Camera");
        }
        
        String v9 = null;
        if (hasChainId(mem, offset)) {
            requireSlot(mem, offset + 38, varPos, "ChainId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v9 = PacketIO.readVarString("ChainId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 38, -1, "ChainId");
        }
        
        int[] v11;
        requireSlot(mem, offset + 42, varPos, "ChainingNext");
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ChainingNext");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("ChainingNext", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ChainingNext", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v11 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v11, 0, len);
            varPos = off + len * 4 - varBase;
        }
        
        java.util.Map<String, Integer> v12 = null;
        if (hasFlags(mem, offset)) {
            requireSlot(mem, offset + 46, varPos, "Flags");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Flags");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Flags", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Flags", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v12 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                if (v12.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Flags", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 46, -1, "Flags");
        }
        var result = new ChainingInteraction(
            WaitForDataFrom.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v1,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "HorizontalSpeedMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 6), "RunTime"),
            InteractionItemChangeBehavior.fromValue(mem.get(PacketIO.PROTO_INT, offset + 10)),
            v5,
            v6,
            v7,
            v8,
            v9,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 14), "ChainingAllowance"),
            v11,
            v12
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
        if (this.chainId != null) nullBits |= 0x10;
        if (this.flags != null) nullBits |= 0x20;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.waitForDataFrom.getValue());
        PacketIO.requireFinite(this.horizontalSpeedMultiplier, "HorizontalSpeedMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 2, this.horizontalSpeedMultiplier);
        PacketIO.requireFinite(this.runTime, "RunTime"); mem.set(PacketIO.PROTO_FLOAT, offset + 6, this.runTime);
        mem.set(PacketIO.PROTO_INT, offset + 10, this.onItemChangeBehavior.getValue());
        PacketIO.requireFinite(this.chainingAllowance, "ChainingAllowance"); mem.set(PacketIO.PROTO_FLOAT, offset + 14, this.chainingAllowance);
        var varOffset = offset + 50;
        if (this.effects != null) {
            mem.set(PacketIO.PROTO_INT, offset + 18, varOffset - offset - 50);
            varOffset += this.effects.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 18, -1);
        }
        if (this.settings != null) {
            mem.set(PacketIO.PROTO_INT, offset + 22, varOffset - offset - 50);
            if (this.settings.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Settings", settings.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.settings.size());
            for (var e : this.settings.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 22, -1);
        }
        mem.set(PacketIO.PROTO_INT, offset + 26, varOffset - offset - 50);
        varOffset += this.rules.serialize(mem, varOffset);
        if (this.tags != null) {
            mem.set(PacketIO.PROTO_INT, offset + 30, varOffset - offset - 50);
            if (tags.length > 4096000) throw ProtocolException.arrayTooLong("Tags", tags.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.tags.length);
            
            MemorySegment.copy(this.tags, 0, mem, PacketIO.PROTO_INT, varOffset, this.tags.length);
            varOffset += this.tags.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 30, -1);
        }
        if (this.camera != null) {
            mem.set(PacketIO.PROTO_INT, offset + 34, varOffset - offset - 50);
            varOffset += this.camera.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 34, -1);
        }
        if (this.chainId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 38, varOffset - offset - 50);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.chainId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 38, -1);
        }
        mem.set(PacketIO.PROTO_INT, offset + 42, varOffset - offset - 50);
        if (chainingNext.length > 4096000) throw ProtocolException.arrayTooLong("ChainingNext", chainingNext.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.chainingNext.length);
        
        MemorySegment.copy(this.chainingNext, 0, mem, PacketIO.PROTO_INT, varOffset, this.chainingNext.length);
        varOffset += this.chainingNext.length * 4;
        if (this.flags != null) {
            mem.set(PacketIO.PROTO_INT, offset + 46, varOffset - offset - 50);
            if (this.flags.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Flags", flags.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.flags.size());
            for (var e : this.flags.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                mem.set(PacketIO.PROTO_INT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 46, -1);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 50;
        if (effects != null) size += effects.computeSize();
    if (settings != null) size += VarInt.size(settings.size()) + settings.size() * (1 + 1);
    size += rules.computeSize();
    if (tags != null) size += VarInt.size(tags.length) + tags.length * 4;
    if (camera != null) size += camera.computeSize();
    if (chainId != null) size += PacketIO.stringSize(chainId);
    size += VarInt.size(chainingNext.length) + chainingNext.length * 4;
    if (flags != null) {
        int flagsSize = 0;
for (var kvp : flags.entrySet()) flagsSize += PacketIO.stringSize(kvp.getKey()) + 4;
size += VarInt.size(flags.size()) + flagsSize;
    }

        return size;
    }

    public ChainingInteraction clone() {
        ChainingInteraction copy = new ChainingInteraction();
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
        copy.chainId = this.chainId;
        copy.chainingAllowance = this.chainingAllowance;
        copy.chainingNext = java.util.Arrays.copyOf(this.chainingNext, this.chainingNext.length);
        copy.flags = this.flags != null ? new java.util.HashMap<>(this.flags) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ChainingInteraction other)) return false;
        return java.util.Objects.equals(this.waitForDataFrom, other.waitForDataFrom) && java.util.Objects.equals(this.effects, other.effects) && this.horizontalSpeedMultiplier == other.horizontalSpeedMultiplier && this.runTime == other.runTime && java.util.Objects.equals(this.onItemChangeBehavior, other.onItemChangeBehavior) && java.util.Objects.equals(this.settings, other.settings) && java.util.Objects.equals(this.rules, other.rules) && java.util.Arrays.equals(this.tags, other.tags) && java.util.Objects.equals(this.camera, other.camera) && java.util.Objects.equals(this.chainId, other.chainId) && this.chainingAllowance == other.chainingAllowance && java.util.Arrays.equals(this.chainingNext, other.chainingNext) && java.util.Objects.equals(this.flags, other.flags);
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
        result = 31 * result + java.util.Objects.hashCode(chainId);
        result = 31 * result + Float.hashCode(chainingAllowance);
        result = 31 * result + java.util.Arrays.hashCode(chainingNext);
        result = 31 * result + java.util.Objects.hashCode(flags);
        return result;
    }

}