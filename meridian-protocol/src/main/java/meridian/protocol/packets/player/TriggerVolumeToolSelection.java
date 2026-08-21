// Auto-generated - do not edit
package meridian.protocol.packets.player;

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


public class TriggerVolumeToolSelection implements Packet, ToClientPacket {
    public static final int PACKET_ID = 507;
    public static final boolean IS_COMPRESSED = false;
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

    @Nullable public String primaryVolumeId;
    @Nullable public String[] volumeIds;

    public TriggerVolumeToolSelection() {
    }

    public TriggerVolumeToolSelection(@Nullable String primaryVolumeId, @Nullable String[] volumeIds) {
        this.primaryVolumeId = primaryVolumeId;
        this.volumeIds = volumeIds;
    }

    public TriggerVolumeToolSelection(@Nonnull TriggerVolumeToolSelection other) {
        this.primaryVolumeId = other.primaryVolumeId;
        this.volumeIds = other.volumeIds;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("TriggerVolumeToolSelection", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("TriggerVolumeToolSelection", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getPrimaryVolumeId(MemorySegment mem) {
        return getPrimaryVolumeId(mem, 0);
    }
    
    @Nullable
    public static String getPrimaryVolumeId(MemorySegment mem, int offset) {
        return hasPrimaryVolumeId(mem, offset) ? PacketIO.readVarString("PrimaryVolumeId", mem, offset + getValidatedOffset(mem, offset, 1, 9, "PrimaryVolumeId"), 4096000): null;
    }
    
    @Nullable
    public static String[] getVolumeIds(MemorySegment mem) {
        return getVolumeIds(mem, 0);
    }
    
    @Nullable
    public static String[] getVolumeIds(MemorySegment mem, int offset) {
        if (!hasVolumeIds(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 5, 9, "VolumeIds");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("VolumeIds");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("VolumeIds", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("VolumeIds", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("VolumeIds", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    public static boolean hasPrimaryVolumeId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasVolumeIds(MemorySegment mem, int offset) {
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
    
    public static TriggerVolumeToolSelection toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static TriggerVolumeToolSelection toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one TriggerVolumeToolSelection and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static TriggerVolumeToolSelection toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        String v0 = null;
        if (hasPrimaryVolumeId(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "PrimaryVolumeId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("PrimaryVolumeId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 1, -1, "PrimaryVolumeId");
        }
        
        String[] v1 = null;
        if (hasVolumeIds(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "VolumeIds");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("VolumeIds");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("VolumeIds", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("VolumeIds", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v1[i] = PacketIO.readVarString("VolumeIds", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "VolumeIds");
        }
        var result = new TriggerVolumeToolSelection(
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
        if (this.primaryVolumeId != null) nullBits |= 0x01;
        if (this.volumeIds != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 9;
        if (this.primaryVolumeId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 9);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.primaryVolumeId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.volumeIds != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 9);
            if (volumeIds.length > 4096000) throw ProtocolException.arrayTooLong("VolumeIds", volumeIds.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.volumeIds.length);
            
            var volumeIdsValueOffset = 0;
            for (var i = 0; i < this.volumeIds.length; i++) {
                volumeIdsValueOffset += PacketIO.writeVarString(mem, varOffset + volumeIdsValueOffset, this.volumeIds[i], 4096000);
            }
            varOffset += volumeIdsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (primaryVolumeId != null) size += PacketIO.stringSize(primaryVolumeId);
    if (volumeIds != null) {
        int volumeIdsSize = 0;
for (var elem : volumeIds) volumeIdsSize += PacketIO.stringSize(elem);
size += VarInt.size(volumeIds.length) + volumeIdsSize;
    }

        return size;
    }

    public TriggerVolumeToolSelection clone() {
        TriggerVolumeToolSelection copy = new TriggerVolumeToolSelection();
        copy.primaryVolumeId = this.primaryVolumeId;
        copy.volumeIds = this.volumeIds != null ? java.util.Arrays.copyOf(this.volumeIds, this.volumeIds.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TriggerVolumeToolSelection other)) return false;
        return java.util.Objects.equals(this.primaryVolumeId, other.primaryVolumeId) && java.util.Arrays.equals(this.volumeIds, other.volumeIds);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(primaryVolumeId);
        result = 31 * result + java.util.Arrays.hashCode(volumeIds);
        return result;
    }

}