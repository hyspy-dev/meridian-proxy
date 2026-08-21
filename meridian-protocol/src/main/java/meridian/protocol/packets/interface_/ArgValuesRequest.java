// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

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


public class ArgValuesRequest implements Packet, ToServerPacket {
    public static final int PACKET_ID = 239;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 32768019;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public String argTypeId;
    @Nullable public String partial;

    public ArgValuesRequest() {
    }

    public ArgValuesRequest(@Nullable String argTypeId, @Nullable String partial) {
        this.argTypeId = argTypeId;
        this.partial = partial;
    }

    public ArgValuesRequest(@Nonnull ArgValuesRequest other) {
        this.argTypeId = other.argTypeId;
        this.partial = other.partial;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ArgValuesRequest", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ArgValuesRequest", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getArgTypeId(MemorySegment mem) {
        return getArgTypeId(mem, 0);
    }
    
    @Nullable
    public static String getArgTypeId(MemorySegment mem, int offset) {
        return hasArgTypeId(mem, offset) ? PacketIO.readVarString("ArgTypeId", mem, offset + getValidatedOffset(mem, offset, 1, 9, "ArgTypeId"), 4096000): null;
    }
    
    @Nullable
    public static String getPartial(MemorySegment mem) {
        return getPartial(mem, 0);
    }
    
    @Nullable
    public static String getPartial(MemorySegment mem, int offset) {
        return hasPartial(mem, offset) ? PacketIO.readVarString("Partial", mem, offset + getValidatedOffset(mem, offset, 5, 9, "Partial"), 4096000): null;
    }
    
    public static boolean hasArgTypeId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasPartial(MemorySegment mem, int offset) {
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
    
    public static ArgValuesRequest toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ArgValuesRequest toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ArgValuesRequest and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ArgValuesRequest toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        String v0 = null;
        if (hasArgTypeId(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "ArgTypeId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("ArgTypeId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 1, -1, "ArgTypeId");
        }
        
        String v1 = null;
        if (hasPartial(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Partial");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Partial", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 5, -1, "Partial");
        }
        var result = new ArgValuesRequest(
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
        if (this.argTypeId != null) nullBits |= 0x01;
        if (this.partial != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 9;
        if (this.argTypeId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 9);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.argTypeId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.partial != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 9);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.partial, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (argTypeId != null) size += PacketIO.stringSize(argTypeId);
    if (partial != null) size += PacketIO.stringSize(partial);

        return size;
    }

    public ArgValuesRequest clone() {
        ArgValuesRequest copy = new ArgValuesRequest();
        copy.argTypeId = this.argTypeId;
        copy.partial = this.partial;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ArgValuesRequest other)) return false;
        return java.util.Objects.equals(this.argTypeId, other.argTypeId) && java.util.Objects.equals(this.partial, other.partial);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(argTypeId, partial);
    }

}