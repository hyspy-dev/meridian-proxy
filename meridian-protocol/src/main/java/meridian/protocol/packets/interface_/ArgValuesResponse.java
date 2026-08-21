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


public class ArgValuesResponse implements Packet, ToClientPacket {
    public static final int PACKET_ID = 247;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 14;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public String argTypeId;
    @Nullable public String[] values;
    @Nullable public boolean[] continuations;
    public boolean isComplete;

    public ArgValuesResponse() {
    }

    public ArgValuesResponse(@Nullable String argTypeId, @Nullable String[] values, @Nullable boolean[] continuations, boolean isComplete) {
        this.argTypeId = argTypeId;
        this.values = values;
        this.continuations = continuations;
        this.isComplete = isComplete;
    }

    public ArgValuesResponse(@Nonnull ArgValuesResponse other) {
        this.argTypeId = other.argTypeId;
        this.values = other.values;
        this.continuations = other.continuations;
        this.isComplete = other.isComplete;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ArgValuesResponse", offset, (int) mem.byteSize());
        long needed = (long) offset + 14;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ArgValuesResponse", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getArgTypeId(MemorySegment mem) {
        return getArgTypeId(mem, 0);
    }
    
    @Nullable
    public static String getArgTypeId(MemorySegment mem, int offset) {
        return hasArgTypeId(mem, offset) ? PacketIO.readVarString("ArgTypeId", mem, offset + getValidatedOffset(mem, offset, 2, 14, "ArgTypeId"), 4096000): null;
    }
    
    @Nullable
    public static String[] getValues(MemorySegment mem) {
        return getValues(mem, 0);
    }
    
    @Nullable
    public static String[] getValues(MemorySegment mem, int offset) {
        if (!hasValues(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 6, 14, "Values");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Values");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Values", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Values", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("Values", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    @Nullable
    public static boolean[] getContinuations(MemorySegment mem) {
        return getContinuations(mem, 0);
    }
    
    @Nullable
    public static boolean[] getContinuations(MemorySegment mem, int offset) {
        if (!hasContinuations(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 10, 14, "Continuations");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Continuations");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Continuations", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Continuations", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new boolean[len];
        for (var i = 0; i < len; i++) {
            data[i] = mem.get(PacketIO.PROTO_BOOL, off + i);
        }
        return data;
    }
    
    public static boolean getIsComplete(MemorySegment mem) {
        return getIsComplete(mem, 0);
    }
    
    public static boolean getIsComplete(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 1);
    }
    
    public static boolean hasArgTypeId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasValues(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasContinuations(MemorySegment mem, int offset) {
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
    
    public static ArgValuesResponse toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ArgValuesResponse toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ArgValuesResponse and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ArgValuesResponse toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 14;
        var varPos = 0;
        String v0 = null;
        if (hasArgTypeId(mem, offset)) {
            requireSlot(mem, offset + 2, varPos, "ArgTypeId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("ArgTypeId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 2, -1, "ArgTypeId");
        }
        
        String[] v1 = null;
        if (hasValues(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "Values");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Values");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Values", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Values", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v1[i] = PacketIO.readVarString("Values", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 6, -1, "Values");
        }
        
        boolean[] v2 = null;
        if (hasContinuations(mem, offset)) {
            requireSlot(mem, offset + 10, varPos, "Continuations");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Continuations");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Continuations", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Continuations", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new boolean[len];
            for (var i = 0; i < len; i++) {
                v2[i] = mem.get(PacketIO.PROTO_BOOL, off + i);
            }
            varPos = off + len - varBase;
        } else {
            requireSlot(mem, offset + 10, -1, "Continuations");
        }
        var result = new ArgValuesResponse(
            v0,
            v1,
            v2,
            mem.get(PacketIO.PROTO_BOOL, offset + 1)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.argTypeId != null) nullBits |= 0x01;
        if (this.values != null) nullBits |= 0x02;
        if (this.continuations != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BOOL, offset + 1, this.isComplete);
        var varOffset = offset + 14;
        if (this.argTypeId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 2, varOffset - offset - 14);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.argTypeId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 2, -1);
        }
        if (this.values != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 14);
            if (values.length > 4096000) throw ProtocolException.arrayTooLong("Values", values.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.values.length);
            
            var valuesValueOffset = 0;
            for (var i = 0; i < this.values.length; i++) {
                valuesValueOffset += PacketIO.writeVarString(mem, varOffset + valuesValueOffset, this.values[i], 4096000);
            }
            varOffset += valuesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
        if (this.continuations != null) {
            mem.set(PacketIO.PROTO_INT, offset + 10, varOffset - offset - 14);
            if (continuations.length > 4096000) throw ProtocolException.arrayTooLong("Continuations", continuations.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.continuations.length);
            
            for (var i = 0; i < this.continuations.length; i++) {
                mem.set(PacketIO.PROTO_BOOL, varOffset + i, this.continuations[i]);
            }
            varOffset += this.continuations.length;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 10, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 14;
        if (argTypeId != null) size += PacketIO.stringSize(argTypeId);
    if (values != null) {
        int valuesSize = 0;
for (var elem : values) valuesSize += PacketIO.stringSize(elem);
size += VarInt.size(values.length) + valuesSize;
    }
    if (continuations != null) size += VarInt.size(continuations.length) + continuations.length * 1;

        return size;
    }

    public ArgValuesResponse clone() {
        ArgValuesResponse copy = new ArgValuesResponse();
        copy.argTypeId = this.argTypeId;
        copy.values = this.values != null ? java.util.Arrays.copyOf(this.values, this.values.length) : null;
        copy.continuations = this.continuations != null ? java.util.Arrays.copyOf(this.continuations, this.continuations.length) : null;
        copy.isComplete = this.isComplete;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ArgValuesResponse other)) return false;
        return java.util.Objects.equals(this.argTypeId, other.argTypeId) && java.util.Arrays.equals(this.values, other.values) && java.util.Arrays.equals(this.continuations, other.continuations) && this.isComplete == other.isComplete;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(argTypeId);
        result = 31 * result + java.util.Arrays.hashCode(values);
        result = 31 * result + java.util.Arrays.hashCode(continuations);
        result = 31 * result + Boolean.hashCode(isComplete);
        return result;
    }

}