// Auto-generated - do not edit
package meridian.protocol.packets.entities;

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
import meridian.protocol.EntityUpdate;

public class EntityUpdates implements Packet, ToClientPacket {
    public static final int PACKET_ID = 161;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public int[] removed;
    @Nullable public EntityUpdate[] updates;

    public EntityUpdates() {
    }

    public EntityUpdates(@Nullable int[] removed, @Nullable EntityUpdate[] updates) {
        this.removed = removed;
        this.updates = updates;
    }

    public EntityUpdates(@Nonnull EntityUpdates other) {
        this.removed = other.removed;
        this.updates = other.updates;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("EntityUpdates", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("EntityUpdates", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static int[] getRemoved(MemorySegment mem) {
        return getRemoved(mem, 0);
    }
    
    @Nullable
    public static int[] getRemoved(MemorySegment mem, int offset) {
        if (!hasRemoved(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 1, 9, "Removed");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Removed");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Removed", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Removed", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    @Nullable
    public static EntityUpdate[] getUpdates(MemorySegment mem) {
        return getUpdates(mem, 0);
    }
    
    @Nullable
    public static EntityUpdate[] getUpdates(MemorySegment mem, int offset) {
        if (!hasUpdates(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 5, 9, "Updates");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Updates");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Updates", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 13 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Updates", (int) java.lang.Math.min(off + lenOffset + (long) len * 13, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new EntityUpdate[len];
        for (var i = 0; i < len; i++) {
            data[i] = EntityUpdate.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasRemoved(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasUpdates(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
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
    
    public static EntityUpdates toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static EntityUpdates toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one EntityUpdates and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static EntityUpdates toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        int[] v0 = null;
        if (hasRemoved(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "Removed");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Removed");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Removed", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Removed", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v0, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 1, -1, "Removed");
        }
        
        EntityUpdate[] v1 = null;
        if (hasUpdates(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Updates");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Updates");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Updates", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 13 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Updates", (int) java.lang.Math.min(off + lenOffset + (long) len * 13, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new EntityUpdate[len];
            for (var i = 0; i < len; i++) {
                v1[i] = EntityUpdate.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "Updates");
        }
        var result = new EntityUpdates(
            v0,
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.removed != null) nullBits |= 0x01;
        if (this.updates != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 9;
        if (this.removed != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 9);
            if (removed.length > 4096000) throw ProtocolException.arrayTooLong("Removed", removed.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.removed.length);
            
            MemorySegment.copy(this.removed, 0, mem, PacketIO.PROTO_INT, varOffset, this.removed.length);
            varOffset += this.removed.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.updates != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 9);
            if (updates.length > 4096000) throw ProtocolException.arrayTooLong("Updates", updates.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.updates.length);
            
            var updatesValueOffset = 0;
            for (var i = 0; i < this.updates.length; i++) {
                updatesValueOffset += this.updates[i].serialize(mem, varOffset + updatesValueOffset);
            }
            varOffset += updatesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (removed != null) size += VarInt.size(removed.length) + removed.length * 4;
    if (updates != null) {
        int updatesSize = 0;
for (var elem : updates) updatesSize += elem.computeSize();
size += VarInt.size(updates.length) + updatesSize;
    }

        return size;
    }

    public EntityUpdates clone() {
        EntityUpdates copy = new EntityUpdates();
        copy.removed = this.removed != null ? java.util.Arrays.copyOf(this.removed, this.removed.length) : null;
        copy.updates = this.updates != null ? java.util.Arrays.stream(this.updates).map(e -> e.clone()).toArray(EntityUpdate[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EntityUpdates other)) return false;
        return java.util.Arrays.equals(this.removed, other.removed) && java.util.Arrays.equals(this.updates, other.updates);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(removed);
        result = 31 * result + java.util.Arrays.hashCode(updates);
        return result;
    }

}