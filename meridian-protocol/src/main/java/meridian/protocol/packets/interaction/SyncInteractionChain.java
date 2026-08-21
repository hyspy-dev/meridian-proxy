// Auto-generated - do not edit
package meridian.protocol.packets.interaction;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import meridian.protocol.ForkedChainId;
import meridian.protocol.InteractionChainData;
import meridian.protocol.InteractionState;
import meridian.protocol.InteractionSyncData;
import meridian.protocol.InteractionType;

public class SyncInteractionChain {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 32;
    public static final int VARIABLE_FIELD_COUNT = 7;
    public static final int VARIABLE_BLOCK_START = 60;
    public static final int MAX_SIZE = 1677721600;

    public int activeHotbarSlot;
    public int activeUtilitySlot;
    public int activeToolsSlot;
    @Nullable public String itemInHandId;
    @Nullable public String utilityItemId;
    @Nullable public String toolsItemId;
    public boolean initial;
    public boolean desync;
    public int overrideRootInteraction = Integer.MIN_VALUE;
    @Nonnull public InteractionType interactionType = InteractionType.Primary;
    public int equipSlot;
    public int chainId;
    @Nullable public ForkedChainId forkedId;
    @Nullable public InteractionChainData data;
    @Nonnull public InteractionState state = InteractionState.Finished;
    @Nullable public SyncInteractionChain[] newForks;
    public int operationBaseIndex;
    @Nullable public InteractionSyncData[] interactionData;

    public SyncInteractionChain() {
    }

    public SyncInteractionChain(int activeHotbarSlot, int activeUtilitySlot, int activeToolsSlot, @Nullable String itemInHandId, @Nullable String utilityItemId, @Nullable String toolsItemId, boolean initial, boolean desync, int overrideRootInteraction, @Nonnull InteractionType interactionType, int equipSlot, int chainId, @Nullable ForkedChainId forkedId, @Nullable InteractionChainData data, @Nonnull InteractionState state, @Nullable SyncInteractionChain[] newForks, int operationBaseIndex, @Nullable InteractionSyncData[] interactionData) {
        this.activeHotbarSlot = activeHotbarSlot;
        this.activeUtilitySlot = activeUtilitySlot;
        this.activeToolsSlot = activeToolsSlot;
        this.itemInHandId = itemInHandId;
        this.utilityItemId = utilityItemId;
        this.toolsItemId = toolsItemId;
        this.initial = initial;
        this.desync = desync;
        this.overrideRootInteraction = overrideRootInteraction;
        this.interactionType = interactionType;
        this.equipSlot = equipSlot;
        this.chainId = chainId;
        this.forkedId = forkedId;
        this.data = data;
        this.state = state;
        this.newForks = newForks;
        this.operationBaseIndex = operationBaseIndex;
        this.interactionData = interactionData;
    }

    public SyncInteractionChain(@Nonnull SyncInteractionChain other) {
        this.activeHotbarSlot = other.activeHotbarSlot;
        this.activeUtilitySlot = other.activeUtilitySlot;
        this.activeToolsSlot = other.activeToolsSlot;
        this.itemInHandId = other.itemInHandId;
        this.utilityItemId = other.utilityItemId;
        this.toolsItemId = other.toolsItemId;
        this.initial = other.initial;
        this.desync = other.desync;
        this.overrideRootInteraction = other.overrideRootInteraction;
        this.interactionType = other.interactionType;
        this.equipSlot = other.equipSlot;
        this.chainId = other.chainId;
        this.forkedId = other.forkedId;
        this.data = other.data;
        this.state = other.state;
        this.newForks = other.newForks;
        this.operationBaseIndex = other.operationBaseIndex;
        this.interactionData = other.interactionData;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SyncInteractionChain", offset, (int) mem.byteSize());
        long needed = (long) offset + 60;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SyncInteractionChain", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getActiveHotbarSlot(MemorySegment mem) {
        return getActiveHotbarSlot(mem, 0);
    }
    
    public static int getActiveHotbarSlot(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getActiveUtilitySlot(MemorySegment mem) {
        return getActiveUtilitySlot(mem, 0);
    }
    
    public static int getActiveUtilitySlot(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static int getActiveToolsSlot(MemorySegment mem) {
        return getActiveToolsSlot(mem, 0);
    }
    
    public static int getActiveToolsSlot(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 9);
    }
    
    @Nullable
    public static String getItemInHandId(MemorySegment mem) {
        return getItemInHandId(mem, 0);
    }
    
    @Nullable
    public static String getItemInHandId(MemorySegment mem, int offset) {
        return hasItemInHandId(mem, offset) ? PacketIO.readVarString("ItemInHandId", mem, offset + getValidatedOffset(mem, offset, 32, 60, "ItemInHandId"), 4096000): null;
    }
    
    @Nullable
    public static String getUtilityItemId(MemorySegment mem) {
        return getUtilityItemId(mem, 0);
    }
    
    @Nullable
    public static String getUtilityItemId(MemorySegment mem, int offset) {
        return hasUtilityItemId(mem, offset) ? PacketIO.readVarString("UtilityItemId", mem, offset + getValidatedOffset(mem, offset, 36, 60, "UtilityItemId"), 4096000): null;
    }
    
    @Nullable
    public static String getToolsItemId(MemorySegment mem) {
        return getToolsItemId(mem, 0);
    }
    
    @Nullable
    public static String getToolsItemId(MemorySegment mem, int offset) {
        return hasToolsItemId(mem, offset) ? PacketIO.readVarString("ToolsItemId", mem, offset + getValidatedOffset(mem, offset, 40, 60, "ToolsItemId"), 4096000): null;
    }
    
    public static boolean getInitial(MemorySegment mem) {
        return getInitial(mem, 0);
    }
    
    public static boolean getInitial(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 13) & 0x01) != 0;
    }
    
    public static boolean getDesync(MemorySegment mem) {
        return getDesync(mem, 0);
    }
    
    public static boolean getDesync(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 13) & 0x02) != 0;
    }
    
    public static int getOverrideRootInteraction(MemorySegment mem) {
        return getOverrideRootInteraction(mem, 0);
    }
    
    public static int getOverrideRootInteraction(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 14);
    }
    
    public static InteractionType getInteractionType(MemorySegment mem) {
        return getInteractionType(mem, 0);
    }
    
    public static InteractionType getInteractionType(MemorySegment mem, int offset) {
        return InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 18));
    }
    
    public static int getEquipSlot(MemorySegment mem) {
        return getEquipSlot(mem, 0);
    }
    
    public static int getEquipSlot(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 19);
    }
    
    public static int getChainId(MemorySegment mem) {
        return getChainId(mem, 0);
    }
    
    public static int getChainId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 23);
    }
    
    @Nullable
    public static ForkedChainId getForkedId(MemorySegment mem) {
        return getForkedId(mem, 0);
    }
    
    @Nullable
    public static ForkedChainId getForkedId(MemorySegment mem, int offset) {
        return hasForkedId(mem, offset) ? ForkedChainId.toObject(mem, offset + getValidatedOffset(mem, offset, 44, 60, "ForkedId")): null;
    }
    
    @Nullable
    public static InteractionChainData getData(MemorySegment mem) {
        return getData(mem, 0);
    }
    
    @Nullable
    public static InteractionChainData getData(MemorySegment mem, int offset) {
        return hasData(mem, offset) ? InteractionChainData.toObject(mem, offset + getValidatedOffset(mem, offset, 48, 60, "Data")): null;
    }
    
    public static InteractionState getState(MemorySegment mem) {
        return getState(mem, 0);
    }
    
    public static InteractionState getState(MemorySegment mem, int offset) {
        return InteractionState.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 27));
    }
    
    @Nullable
    public static SyncInteractionChain[] getNewForks(MemorySegment mem) {
        return getNewForks(mem, 0);
    }
    
    @Nullable
    public static SyncInteractionChain[] getNewForks(MemorySegment mem, int offset) {
        if (!hasNewForks(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 52, 60, "NewForks");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("NewForks");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("NewForks", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 60 > mem.byteSize()) throw ProtocolException.bufferTooSmall("NewForks", (int) java.lang.Math.min(off + lenOffset + (long) len * 60, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new SyncInteractionChain[len];
        for (var i = 0; i < len; i++) {
            data[i] = SyncInteractionChain.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static int getOperationBaseIndex(MemorySegment mem) {
        return getOperationBaseIndex(mem, 0);
    }
    
    public static int getOperationBaseIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 28);
    }
    
    @Nullable
    public static InteractionSyncData[] getInteractionData(MemorySegment mem) {
        return getInteractionData(mem, 0);
    }
    
    @Nullable
    public static InteractionSyncData[] getInteractionData(MemorySegment mem, int offset) {
        if (!hasInteractionData(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 56, 60, "InteractionData");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("InteractionData");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("InteractionData", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (len + 7) / 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("InteractionData", (int) java.lang.Math.min(off + lenOffset + (len + 7) / 8, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var bitfieldSize = (len + 7) / 8;
        var bitfieldOff = off;
        off += bitfieldSize;
        if (bitfieldOff + bitfieldSize > mem.byteSize()) throw ProtocolException.bufferTooSmall("InteractionData", bitfieldOff + bitfieldSize, (int) mem.byteSize());
        var present = 0;
        for (var b = 0; b < bitfieldSize; b++) {
            present += Integer.bitCount(mem.get(PacketIO.PROTO_BYTE, bitfieldOff + b) & 0xFF);
        }
        if ((len & 7) != 0) present -= Integer.bitCount((mem.get(PacketIO.PROTO_BYTE, bitfieldOff + bitfieldSize - 1) & 0xFF) >>> (len & 7));
        var needed = off + (long) present * 165;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InteractionData", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
        var data = new InteractionSyncData[len];
        for (var i = 0; i < len;) {
            byte bits = mem.get(PacketIO.PROTO_BYTE, bitfieldOff + i / 8);
            int batchEnd = Math.min(len, (i & ~7) + 8);
            for (; i < batchEnd; i++) {
                if ((bits & (1 << (i & 7))) != 0) {
                data[i] = InteractionSyncData.toObject(mem, off, walkCursor);
                off = walkCursor.position;
                }
            }
        }
        return data;
    }
    
    public static boolean hasItemInHandId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasUtilityItemId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasToolsItemId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasForkedId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasData(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasNewForks(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasInteractionData(MemorySegment mem, int offset) {
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
    
    public static SyncInteractionChain toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SyncInteractionChain toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SyncInteractionChain and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SyncInteractionChain toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 60;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v3 = null;
        if (hasItemInHandId(mem, offset)) {
            requireSlot(mem, offset + 32, varPos, "ItemInHandId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readVarString("ItemInHandId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 32, -1, "ItemInHandId");
        }
        
        String v4 = null;
        if (hasUtilityItemId(mem, offset)) {
            requireSlot(mem, offset + 36, varPos, "UtilityItemId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v4 = PacketIO.readVarString("UtilityItemId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 36, -1, "UtilityItemId");
        }
        
        String v5 = null;
        if (hasToolsItemId(mem, offset)) {
            requireSlot(mem, offset + 40, varPos, "ToolsItemId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v5 = PacketIO.readVarString("ToolsItemId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 40, -1, "ToolsItemId");
        }
        
        ForkedChainId v12 = null;
        if (hasForkedId(mem, offset)) {
            requireSlot(mem, offset + 44, varPos, "ForkedId");
            v12 = ForkedChainId.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 44, -1, "ForkedId");
        }
        
        InteractionChainData v13 = null;
        if (hasData(mem, offset)) {
            requireSlot(mem, offset + 48, varPos, "Data");
            v13 = InteractionChainData.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 48, -1, "Data");
        }
        
        SyncInteractionChain[] v15 = null;
        if (hasNewForks(mem, offset)) {
            requireSlot(mem, offset + 52, varPos, "NewForks");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("NewForks");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("NewForks", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 60 > mem.byteSize()) throw ProtocolException.bufferTooSmall("NewForks", (int) java.lang.Math.min(off + lenOffset + (long) len * 60, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v15 = new SyncInteractionChain[len];
            for (var i = 0; i < len; i++) {
                v15[i] = SyncInteractionChain.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 52, -1, "NewForks");
        }
        
        InteractionSyncData[] v17 = null;
        if (hasInteractionData(mem, offset)) {
            requireSlot(mem, offset + 56, varPos, "InteractionData");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("InteractionData");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("InteractionData", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (len + 7) / 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("InteractionData", (int) java.lang.Math.min(off + lenOffset + (len + 7) / 8, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            var bitfieldSize = (len + 7) / 8;
            var bitfieldOff = off;
            off += bitfieldSize;
            if (bitfieldOff + bitfieldSize > mem.byteSize()) throw ProtocolException.bufferTooSmall("InteractionData", bitfieldOff + bitfieldSize, (int) mem.byteSize());
            var present = 0;
            for (var b = 0; b < bitfieldSize; b++) {
                present += Integer.bitCount(mem.get(PacketIO.PROTO_BYTE, bitfieldOff + b) & 0xFF);
            }
            if ((len & 7) != 0) present -= Integer.bitCount((mem.get(PacketIO.PROTO_BYTE, bitfieldOff + bitfieldSize - 1) & 0xFF) >>> (len & 7));
            var needed = off + (long) present * 165;
            if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InteractionData", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
            v17 = new InteractionSyncData[len];
            for (var i = 0; i < len;) {
                byte bits = mem.get(PacketIO.PROTO_BYTE, bitfieldOff + i / 8);
                int batchEnd = Math.min(len, (i & ~7) + 8);
                for (; i < batchEnd; i++) {
                    if ((bits & (1 << (i & 7))) != 0) {
                    v17[i] = InteractionSyncData.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                    }
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 56, -1, "InteractionData");
        }
        var result = new SyncInteractionChain(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            mem.get(PacketIO.PROTO_INT, offset + 9),
            v3,
            v4,
            v5,
            (mem.get(PacketIO.PROTO_BYTE, offset + 13) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 13) & 0x02) != 0,
            mem.get(PacketIO.PROTO_INT, offset + 14),
            InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 18)),
            mem.get(PacketIO.PROTO_INT, offset + 19),
            mem.get(PacketIO.PROTO_INT, offset + 23),
            v12,
            v13,
            InteractionState.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 27)),
            v15,
            mem.get(PacketIO.PROTO_INT, offset + 28),
            v17
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.itemInHandId != null) nullBits |= 0x01;
        if (this.utilityItemId != null) nullBits |= 0x02;
        if (this.toolsItemId != null) nullBits |= 0x04;
        if (this.forkedId != null) nullBits |= 0x08;
        if (this.data != null) nullBits |= 0x10;
        if (this.newForks != null) nullBits |= 0x20;
        if (this.interactionData != null) nullBits |= 0x40;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.activeHotbarSlot);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.activeUtilitySlot);
        mem.set(PacketIO.PROTO_INT, offset + 9, this.activeToolsSlot);
        byte boolBits0_0 = 0;
        if (this.initial) boolBits0_0 |= 0x01;
        if (this.desync) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 13 + 0, boolBits0_0);
        mem.set(PacketIO.PROTO_INT, offset + 14, this.overrideRootInteraction);
        mem.set(PacketIO.PROTO_BYTE, offset + 18, (byte) this.interactionType.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 19, this.equipSlot);
        mem.set(PacketIO.PROTO_INT, offset + 23, this.chainId);
        mem.set(PacketIO.PROTO_BYTE, offset + 27, (byte) this.state.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 28, this.operationBaseIndex);
        var varOffset = offset + 60;
        if (this.itemInHandId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 32, varOffset - offset - 60);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.itemInHandId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 32, -1);
        }
        if (this.utilityItemId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 36, varOffset - offset - 60);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.utilityItemId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 36, -1);
        }
        if (this.toolsItemId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 40, varOffset - offset - 60);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.toolsItemId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 40, -1);
        }
        if (this.forkedId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 44, varOffset - offset - 60);
            varOffset += this.forkedId.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 44, -1);
        }
        if (this.data != null) {
            mem.set(PacketIO.PROTO_INT, offset + 48, varOffset - offset - 60);
            varOffset += this.data.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 48, -1);
        }
        if (this.newForks != null) {
            mem.set(PacketIO.PROTO_INT, offset + 52, varOffset - offset - 60);
            if (newForks.length > 4096000) throw ProtocolException.arrayTooLong("NewForks", newForks.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.newForks.length);
            
            var newForksValueOffset = 0;
            for (var i = 0; i < this.newForks.length; i++) {
                newForksValueOffset += this.newForks[i].serialize(mem, varOffset + newForksValueOffset);
            }
            varOffset += newForksValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 52, -1);
        }
        if (this.interactionData != null) {
            mem.set(PacketIO.PROTO_INT, offset + 56, varOffset - offset - 60);
            if (interactionData.length > 4096000) throw ProtocolException.arrayTooLong("InteractionData", interactionData.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.interactionData.length);
            
            var interactionDataBitfieldSize = (this.interactionData.length + 7) / 8;
            for (var bi = 0; bi < interactionDataBitfieldSize; bi++) {
                byte bits = 0;
                for (var j = bi * 8; j < Math.min(this.interactionData.length, bi * 8 + 8); j++) {
                    if (this.interactionData[j] != null) bits |= (byte) (1 << (j & 7));
                }
                mem.set(PacketIO.PROTO_BYTE, varOffset + bi, bits);
            }
            varOffset += interactionDataBitfieldSize;
            for (var i = 0; i < this.interactionData.length; i++) {
                if (this.interactionData[i] != null) {
                    varOffset += this.interactionData[i].serialize(mem, varOffset);
                }
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 56, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 60;
        if (itemInHandId != null) size += PacketIO.stringSize(itemInHandId);
    if (utilityItemId != null) size += PacketIO.stringSize(utilityItemId);
    if (toolsItemId != null) size += PacketIO.stringSize(toolsItemId);
    if (forkedId != null) size += forkedId.computeSize();
    if (data != null) size += data.computeSize();
    if (newForks != null) {
        int newForksSize = 0;
for (var elem : newForks) newForksSize += elem.computeSize();
size += VarInt.size(newForks.length) + newForksSize;
    }
    if (interactionData != null) {
        int interactionDataSize = 0;
for (var elem : interactionData) if (elem != null) interactionDataSize += elem.computeSize();
size += VarInt.size(interactionData.length) + (interactionData.length + 7) / 8 + interactionDataSize;
    }

        return size;
    }

    public SyncInteractionChain clone() {
        SyncInteractionChain copy = new SyncInteractionChain();
        copy.activeHotbarSlot = this.activeHotbarSlot;
        copy.activeUtilitySlot = this.activeUtilitySlot;
        copy.activeToolsSlot = this.activeToolsSlot;
        copy.itemInHandId = this.itemInHandId;
        copy.utilityItemId = this.utilityItemId;
        copy.toolsItemId = this.toolsItemId;
        copy.initial = this.initial;
        copy.desync = this.desync;
        copy.overrideRootInteraction = this.overrideRootInteraction;
        copy.interactionType = this.interactionType;
        copy.equipSlot = this.equipSlot;
        copy.chainId = this.chainId;
        copy.forkedId = this.forkedId != null ? this.forkedId.clone() : null;
        copy.data = this.data != null ? this.data.clone() : null;
        copy.state = this.state;
        copy.newForks = this.newForks != null ? java.util.Arrays.stream(this.newForks).map(e -> e.clone()).toArray(SyncInteractionChain[]::new) : null;
        copy.operationBaseIndex = this.operationBaseIndex;
        copy.interactionData = this.interactionData != null ? java.util.Arrays.stream(this.interactionData).map(e -> e != null ? e.clone() : null).toArray(InteractionSyncData[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SyncInteractionChain other)) return false;
        return this.activeHotbarSlot == other.activeHotbarSlot && this.activeUtilitySlot == other.activeUtilitySlot && this.activeToolsSlot == other.activeToolsSlot && java.util.Objects.equals(this.itemInHandId, other.itemInHandId) && java.util.Objects.equals(this.utilityItemId, other.utilityItemId) && java.util.Objects.equals(this.toolsItemId, other.toolsItemId) && this.initial == other.initial && this.desync == other.desync && this.overrideRootInteraction == other.overrideRootInteraction && java.util.Objects.equals(this.interactionType, other.interactionType) && this.equipSlot == other.equipSlot && this.chainId == other.chainId && java.util.Objects.equals(this.forkedId, other.forkedId) && java.util.Objects.equals(this.data, other.data) && java.util.Objects.equals(this.state, other.state) && java.util.Arrays.equals(this.newForks, other.newForks) && this.operationBaseIndex == other.operationBaseIndex && java.util.Arrays.equals(this.interactionData, other.interactionData);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(activeHotbarSlot);
        result = 31 * result + Integer.hashCode(activeUtilitySlot);
        result = 31 * result + Integer.hashCode(activeToolsSlot);
        result = 31 * result + java.util.Objects.hashCode(itemInHandId);
        result = 31 * result + java.util.Objects.hashCode(utilityItemId);
        result = 31 * result + java.util.Objects.hashCode(toolsItemId);
        result = 31 * result + Boolean.hashCode(initial);
        result = 31 * result + Boolean.hashCode(desync);
        result = 31 * result + Integer.hashCode(overrideRootInteraction);
        result = 31 * result + java.util.Objects.hashCode(interactionType);
        result = 31 * result + Integer.hashCode(equipSlot);
        result = 31 * result + Integer.hashCode(chainId);
        result = 31 * result + java.util.Objects.hashCode(forkedId);
        result = 31 * result + java.util.Objects.hashCode(data);
        result = 31 * result + java.util.Objects.hashCode(state);
        result = 31 * result + java.util.Arrays.hashCode(newForks);
        result = 31 * result + Integer.hashCode(operationBaseIndex);
        result = 31 * result + java.util.Arrays.hashCode(interactionData);
        return result;
    }

}