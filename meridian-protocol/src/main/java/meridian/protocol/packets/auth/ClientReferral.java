// Auto-generated - do not edit
package meridian.protocol.packets.auth;

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
import meridian.protocol.HostAddress;

public class ClientReferral implements Packet, ToClientPacket {
    public static final int PACKET_ID = 18;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 5141;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public HostAddress hostTo;
    @Nullable public byte[] data;

    public ClientReferral() {
    }

    public ClientReferral(@Nullable HostAddress hostTo, @Nullable byte[] data) {
        this.hostTo = hostTo;
        this.data = data;
    }

    public ClientReferral(@Nonnull ClientReferral other) {
        this.hostTo = other.hostTo;
        this.data = other.data;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ClientReferral", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ClientReferral", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static HostAddress getHostTo(MemorySegment mem) {
        return getHostTo(mem, 0);
    }
    
    @Nullable
    public static HostAddress getHostTo(MemorySegment mem, int offset) {
        return hasHostTo(mem, offset) ? HostAddress.toObject(mem, offset + getValidatedOffset(mem, offset, 1, 9, "HostTo")): null;
    }
    
    @Nullable
    public static byte[] getData(MemorySegment mem) {
        return getData(mem, 0);
    }
    
    @Nullable
    public static byte[] getData(MemorySegment mem, int offset) {
        if (!hasData(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 5, 9, "Data");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Data");
        var len = (int) packed;
        if (len > 4096) throw ProtocolException.arrayTooLong("Data", len, 4096);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Data", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new byte[len];
        MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, data, 0, len);
        return data;
    }
    
    public static boolean hasHostTo(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasData(MemorySegment mem, int offset) {
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
    
    public static ClientReferral toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ClientReferral toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ClientReferral and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ClientReferral toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        HostAddress v0 = null;
        if (hasHostTo(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "HostTo");
            v0 = HostAddress.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 1, -1, "HostTo");
        }
        
        byte[] v1 = null;
        if (hasData(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Data");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Data");
            var len = (int) packed;
            if (len > 4096) throw ProtocolException.arrayTooLong("Data", len, 4096);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Data", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v1, 0, len);
            varPos = off + len - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "Data");
        }
        var result = new ClientReferral(
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
        if (this.hostTo != null) nullBits |= 0x01;
        if (this.data != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 9;
        if (this.hostTo != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 9);
            varOffset += this.hostTo.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.data != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 9);
            if (data.length > 4096) throw ProtocolException.arrayTooLong("Data", data.length, 4096);
            varOffset += VarInt.set(mem, varOffset, this.data.length);
            
            MemorySegment.copy(this.data, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.data.length);
            varOffset += this.data.length * 1;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (hostTo != null) size += hostTo.computeSize();
    if (data != null) size += VarInt.size(data.length) + data.length * 1;

        return size;
    }

    public ClientReferral clone() {
        ClientReferral copy = new ClientReferral();
        copy.hostTo = this.hostTo != null ? this.hostTo.clone() : null;
        copy.data = this.data != null ? java.util.Arrays.copyOf(this.data, this.data.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ClientReferral other)) return false;
        return java.util.Objects.equals(this.hostTo, other.hostTo) && java.util.Arrays.equals(this.data, other.data);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(hostTo);
        result = 31 * result + java.util.Arrays.hashCode(data);
        return result;
    }

}