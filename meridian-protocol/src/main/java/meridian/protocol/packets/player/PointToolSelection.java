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


public class PointToolSelection implements Packet, ToClientPacket {
    public static final int PACKET_ID = 522;
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

    @Nullable public String primaryPointId;
    @Nullable public String[] pointIds;

    public PointToolSelection() {
    }

    public PointToolSelection(@Nullable String primaryPointId, @Nullable String[] pointIds) {
        this.primaryPointId = primaryPointId;
        this.pointIds = pointIds;
    }

    public PointToolSelection(@Nonnull PointToolSelection other) {
        this.primaryPointId = other.primaryPointId;
        this.pointIds = other.pointIds;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PointToolSelection", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PointToolSelection", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getPrimaryPointId(MemorySegment mem) {
        return getPrimaryPointId(mem, 0);
    }
    
    @Nullable
    public static String getPrimaryPointId(MemorySegment mem, int offset) {
        return hasPrimaryPointId(mem, offset) ? PacketIO.readVarString("PrimaryPointId", mem, offset + getValidatedOffset(mem, offset, 1, 9, "PrimaryPointId"), 4096000): null;
    }
    
    @Nullable
    public static String[] getPointIds(MemorySegment mem) {
        return getPointIds(mem, 0);
    }
    
    @Nullable
    public static String[] getPointIds(MemorySegment mem, int offset) {
        if (!hasPointIds(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 5, 9, "PointIds");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("PointIds");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("PointIds", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("PointIds", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("PointIds", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    public static boolean hasPrimaryPointId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasPointIds(MemorySegment mem, int offset) {
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
    
    public static PointToolSelection toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PointToolSelection toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PointToolSelection and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PointToolSelection toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        String v0 = null;
        if (hasPrimaryPointId(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "PrimaryPointId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("PrimaryPointId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 1, -1, "PrimaryPointId");
        }
        
        String[] v1 = null;
        if (hasPointIds(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "PointIds");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("PointIds");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("PointIds", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("PointIds", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v1[i] = PacketIO.readVarString("PointIds", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "PointIds");
        }
        var result = new PointToolSelection(
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
        if (this.primaryPointId != null) nullBits |= 0x01;
        if (this.pointIds != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 9;
        if (this.primaryPointId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 9);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.primaryPointId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.pointIds != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 9);
            if (pointIds.length > 4096000) throw ProtocolException.arrayTooLong("PointIds", pointIds.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.pointIds.length);
            
            var pointIdsValueOffset = 0;
            for (var i = 0; i < this.pointIds.length; i++) {
                pointIdsValueOffset += PacketIO.writeVarString(mem, varOffset + pointIdsValueOffset, this.pointIds[i], 4096000);
            }
            varOffset += pointIdsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (primaryPointId != null) size += PacketIO.stringSize(primaryPointId);
    if (pointIds != null) {
        int pointIdsSize = 0;
for (var elem : pointIds) pointIdsSize += PacketIO.stringSize(elem);
size += VarInt.size(pointIds.length) + pointIdsSize;
    }

        return size;
    }

    public PointToolSelection clone() {
        PointToolSelection copy = new PointToolSelection();
        copy.primaryPointId = this.primaryPointId;
        copy.pointIds = this.pointIds != null ? java.util.Arrays.copyOf(this.pointIds, this.pointIds.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PointToolSelection other)) return false;
        return java.util.Objects.equals(this.primaryPointId, other.primaryPointId) && java.util.Arrays.equals(this.pointIds, other.pointIds);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(primaryPointId);
        result = 31 * result + java.util.Arrays.hashCode(pointIds);
        return result;
    }

}