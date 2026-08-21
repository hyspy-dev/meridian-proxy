// Auto-generated - do not edit
package meridian.protocol.packets.inventory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.NetworkChannel;
import meridian.protocol.Packet;
import meridian.protocol.ToServerPacket;
import meridian.protocol.ToClientPacket;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import meridian.protocol.InventorySection;

public class UpdatePlayerInventory implements Packet, ToClientPacket {
    public static final int PACKET_ID = 170;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 6;
    public static final int VARIABLE_BLOCK_START = 25;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public InventorySection storage;
    @Nullable public InventorySection armor;
    @Nullable public InventorySection hotbar;
    @Nullable public InventorySection utility;
    @Nullable public InventorySection tools;
    @Nullable public InventorySection backpack;

    public UpdatePlayerInventory() {
    }

    public UpdatePlayerInventory(@Nullable InventorySection storage, @Nullable InventorySection armor, @Nullable InventorySection hotbar, @Nullable InventorySection utility, @Nullable InventorySection tools, @Nullable InventorySection backpack) {
        this.storage = storage;
        this.armor = armor;
        this.hotbar = hotbar;
        this.utility = utility;
        this.tools = tools;
        this.backpack = backpack;
    }

    public UpdatePlayerInventory(@Nonnull UpdatePlayerInventory other) {
        this.storage = other.storage;
        this.armor = other.armor;
        this.hotbar = other.hotbar;
        this.utility = other.utility;
        this.tools = other.tools;
        this.backpack = other.backpack;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdatePlayerInventory", offset, (int) mem.byteSize());
        long needed = (long) offset + 25;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdatePlayerInventory", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static InventorySection getStorage(MemorySegment mem) {
        return getStorage(mem, 0);
    }
    
    @Nullable
    public static InventorySection getStorage(MemorySegment mem, int offset) {
        return hasStorage(mem, offset) ? InventorySection.toObject(mem, offset + getValidatedOffset(mem, offset, 1, 25, "Storage")): null;
    }
    
    @Nullable
    public static InventorySection getArmor(MemorySegment mem) {
        return getArmor(mem, 0);
    }
    
    @Nullable
    public static InventorySection getArmor(MemorySegment mem, int offset) {
        return hasArmor(mem, offset) ? InventorySection.toObject(mem, offset + getValidatedOffset(mem, offset, 5, 25, "Armor")): null;
    }
    
    @Nullable
    public static InventorySection getHotbar(MemorySegment mem) {
        return getHotbar(mem, 0);
    }
    
    @Nullable
    public static InventorySection getHotbar(MemorySegment mem, int offset) {
        return hasHotbar(mem, offset) ? InventorySection.toObject(mem, offset + getValidatedOffset(mem, offset, 9, 25, "Hotbar")): null;
    }
    
    @Nullable
    public static InventorySection getUtility(MemorySegment mem) {
        return getUtility(mem, 0);
    }
    
    @Nullable
    public static InventorySection getUtility(MemorySegment mem, int offset) {
        return hasUtility(mem, offset) ? InventorySection.toObject(mem, offset + getValidatedOffset(mem, offset, 13, 25, "Utility")): null;
    }
    
    @Nullable
    public static InventorySection getTools(MemorySegment mem) {
        return getTools(mem, 0);
    }
    
    @Nullable
    public static InventorySection getTools(MemorySegment mem, int offset) {
        return hasTools(mem, offset) ? InventorySection.toObject(mem, offset + getValidatedOffset(mem, offset, 17, 25, "Tools")): null;
    }
    
    @Nullable
    public static InventorySection getBackpack(MemorySegment mem) {
        return getBackpack(mem, 0);
    }
    
    @Nullable
    public static InventorySection getBackpack(MemorySegment mem, int offset) {
        return hasBackpack(mem, offset) ? InventorySection.toObject(mem, offset + getValidatedOffset(mem, offset, 21, 25, "Backpack")): null;
    }
    
    public static boolean hasStorage(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasArmor(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasHotbar(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasUtility(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasTools(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasBackpack(MemorySegment mem, int offset) {
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
    
    public static UpdatePlayerInventory toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdatePlayerInventory toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdatePlayerInventory and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdatePlayerInventory toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 25;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        InventorySection v0 = null;
        if (hasStorage(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "Storage");
            v0 = InventorySection.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 1, -1, "Storage");
        }
        
        InventorySection v1 = null;
        if (hasArmor(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Armor");
            v1 = InventorySection.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "Armor");
        }
        
        InventorySection v2 = null;
        if (hasHotbar(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "Hotbar");
            v2 = InventorySection.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 9, -1, "Hotbar");
        }
        
        InventorySection v3 = null;
        if (hasUtility(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "Utility");
            v3 = InventorySection.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 13, -1, "Utility");
        }
        
        InventorySection v4 = null;
        if (hasTools(mem, offset)) {
            requireSlot(mem, offset + 17, varPos, "Tools");
            v4 = InventorySection.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 17, -1, "Tools");
        }
        
        InventorySection v5 = null;
        if (hasBackpack(mem, offset)) {
            requireSlot(mem, offset + 21, varPos, "Backpack");
            v5 = InventorySection.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 21, -1, "Backpack");
        }
        var result = new UpdatePlayerInventory(
            v0,
            v1,
            v2,
            v3,
            v4,
            v5
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.storage != null) nullBits |= 0x01;
        if (this.armor != null) nullBits |= 0x02;
        if (this.hotbar != null) nullBits |= 0x04;
        if (this.utility != null) nullBits |= 0x08;
        if (this.tools != null) nullBits |= 0x10;
        if (this.backpack != null) nullBits |= 0x20;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 25;
        if (this.storage != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 25);
            varOffset += this.storage.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.armor != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 25);
            varOffset += this.armor.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.hotbar != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 25);
            varOffset += this.hotbar.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
        if (this.utility != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 25);
            varOffset += this.utility.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
        if (this.tools != null) {
            mem.set(PacketIO.PROTO_INT, offset + 17, varOffset - offset - 25);
            varOffset += this.tools.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 17, -1);
        }
        if (this.backpack != null) {
            mem.set(PacketIO.PROTO_INT, offset + 21, varOffset - offset - 25);
            varOffset += this.backpack.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 21, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 25;
        if (storage != null) size += storage.computeSize();
    if (armor != null) size += armor.computeSize();
    if (hotbar != null) size += hotbar.computeSize();
    if (utility != null) size += utility.computeSize();
    if (tools != null) size += tools.computeSize();
    if (backpack != null) size += backpack.computeSize();

        return size;
    }

    public UpdatePlayerInventory clone() {
        UpdatePlayerInventory copy = new UpdatePlayerInventory();
        copy.storage = this.storage != null ? this.storage.clone() : null;
        copy.armor = this.armor != null ? this.armor.clone() : null;
        copy.hotbar = this.hotbar != null ? this.hotbar.clone() : null;
        copy.utility = this.utility != null ? this.utility.clone() : null;
        copy.tools = this.tools != null ? this.tools.clone() : null;
        copy.backpack = this.backpack != null ? this.backpack.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdatePlayerInventory other)) return false;
        return java.util.Objects.equals(this.storage, other.storage) && java.util.Objects.equals(this.armor, other.armor) && java.util.Objects.equals(this.hotbar, other.hotbar) && java.util.Objects.equals(this.utility, other.utility) && java.util.Objects.equals(this.tools, other.tools) && java.util.Objects.equals(this.backpack, other.backpack);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(storage, armor, hotbar, utility, tools, backpack);
    }

}