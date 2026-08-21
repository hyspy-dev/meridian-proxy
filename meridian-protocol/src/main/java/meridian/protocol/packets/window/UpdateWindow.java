// Auto-generated - do not edit
package meridian.protocol.packets.window;

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
import meridian.protocol.ExtraResources;
import meridian.protocol.InventorySection;

public class UpdateWindow implements Packet, ToClientPacket {
    public static final int PACKET_ID = 201;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 17;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int id;
    @Nullable public String windowData;
    @Nullable public InventorySection inventory;
    @Nullable public ExtraResources extraResources;

    public UpdateWindow() {
    }

    public UpdateWindow(int id, @Nullable String windowData, @Nullable InventorySection inventory, @Nullable ExtraResources extraResources) {
        this.id = id;
        this.windowData = windowData;
        this.inventory = inventory;
        this.extraResources = extraResources;
    }

    public UpdateWindow(@Nonnull UpdateWindow other) {
        this.id = other.id;
        this.windowData = other.windowData;
        this.inventory = other.inventory;
        this.extraResources = other.extraResources;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateWindow", offset, (int) mem.byteSize());
        long needed = (long) offset + 17;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateWindow", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    public static int getId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static String getWindowData(MemorySegment mem) {
        return getWindowData(mem, 0);
    }
    
    @Nullable
    public static String getWindowData(MemorySegment mem, int offset) {
        return hasWindowData(mem, offset) ? PacketIO.readVarString("WindowData", mem, offset + getValidatedOffset(mem, offset, 5, 17, "WindowData"), 4096000): null;
    }
    
    @Nullable
    public static InventorySection getInventory(MemorySegment mem) {
        return getInventory(mem, 0);
    }
    
    @Nullable
    public static InventorySection getInventory(MemorySegment mem, int offset) {
        return hasInventory(mem, offset) ? InventorySection.toObject(mem, offset + getValidatedOffset(mem, offset, 9, 17, "Inventory")): null;
    }
    
    @Nullable
    public static ExtraResources getExtraResources(MemorySegment mem) {
        return getExtraResources(mem, 0);
    }
    
    @Nullable
    public static ExtraResources getExtraResources(MemorySegment mem, int offset) {
        return hasExtraResources(mem, offset) ? ExtraResources.toObject(mem, offset + getValidatedOffset(mem, offset, 13, 17, "ExtraResources")): null;
    }
    
    public static boolean hasWindowData(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasInventory(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasExtraResources(MemorySegment mem, int offset) {
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
    
    public static UpdateWindow toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateWindow toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateWindow and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateWindow toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 17;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v1 = null;
        if (hasWindowData(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "WindowData");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("WindowData", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 5, -1, "WindowData");
        }
        
        InventorySection v2 = null;
        if (hasInventory(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "Inventory");
            v2 = InventorySection.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 9, -1, "Inventory");
        }
        
        ExtraResources v3 = null;
        if (hasExtraResources(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "ExtraResources");
            v3 = ExtraResources.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 13, -1, "ExtraResources");
        }
        var result = new UpdateWindow(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v1,
            v2,
            v3
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.windowData != null) nullBits |= 0x01;
        if (this.inventory != null) nullBits |= 0x02;
        if (this.extraResources != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.id);
        var varOffset = offset + 17;
        if (this.windowData != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 17);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.windowData, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.inventory != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 17);
            varOffset += this.inventory.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
        if (this.extraResources != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 17);
            varOffset += this.extraResources.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 17;
        if (windowData != null) size += PacketIO.stringSize(windowData);
    if (inventory != null) size += inventory.computeSize();
    if (extraResources != null) size += extraResources.computeSize();

        return size;
    }

    public UpdateWindow clone() {
        UpdateWindow copy = new UpdateWindow();
        copy.id = this.id;
        copy.windowData = this.windowData;
        copy.inventory = this.inventory != null ? this.inventory.clone() : null;
        copy.extraResources = this.extraResources != null ? this.extraResources.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateWindow other)) return false;
        return this.id == other.id && java.util.Objects.equals(this.windowData, other.windowData) && java.util.Objects.equals(this.inventory, other.inventory) && java.util.Objects.equals(this.extraResources, other.extraResources);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, windowData, inventory, extraResources);
    }

}