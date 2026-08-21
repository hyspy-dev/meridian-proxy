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


public class InteractionRules {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 17;
    public static final int VARIABLE_FIELD_COUNT = 4;
    public static final int VARIABLE_BLOCK_START = 33;
    public static final int MAX_SIZE = 16384053;

    @Nullable public InteractionType[] blockedBy;
    @Nullable public InteractionType[] blocking;
    @Nullable public InteractionType[] interruptedBy;
    @Nullable public InteractionType[] interrupting;
    public int blockedByBypassIndex;
    public int blockingBypassIndex;
    public int interruptedByBypassIndex;
    public int interruptingBypassIndex;

    public InteractionRules() {
    }

    public InteractionRules(@Nullable InteractionType[] blockedBy, @Nullable InteractionType[] blocking, @Nullable InteractionType[] interruptedBy, @Nullable InteractionType[] interrupting, int blockedByBypassIndex, int blockingBypassIndex, int interruptedByBypassIndex, int interruptingBypassIndex) {
        this.blockedBy = blockedBy;
        this.blocking = blocking;
        this.interruptedBy = interruptedBy;
        this.interrupting = interrupting;
        this.blockedByBypassIndex = blockedByBypassIndex;
        this.blockingBypassIndex = blockingBypassIndex;
        this.interruptedByBypassIndex = interruptedByBypassIndex;
        this.interruptingBypassIndex = interruptingBypassIndex;
    }

    public InteractionRules(@Nonnull InteractionRules other) {
        this.blockedBy = other.blockedBy;
        this.blocking = other.blocking;
        this.interruptedBy = other.interruptedBy;
        this.interrupting = other.interrupting;
        this.blockedByBypassIndex = other.blockedByBypassIndex;
        this.blockingBypassIndex = other.blockingBypassIndex;
        this.interruptedByBypassIndex = other.interruptedByBypassIndex;
        this.interruptingBypassIndex = other.interruptingBypassIndex;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("InteractionRules", offset, (int) mem.byteSize());
        long needed = (long) offset + 33;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InteractionRules", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static InteractionType[] getBlockedBy(MemorySegment mem) {
        return getBlockedBy(mem, 0);
    }
    
    @Nullable
    public static InteractionType[] getBlockedBy(MemorySegment mem, int offset) {
        if (!hasBlockedBy(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 17, 33, "BlockedBy");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("BlockedBy");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("BlockedBy", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockedBy", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new InteractionType[len];
        for (var i = 0; i < len; i++) {
            data[i] = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
        }
        return data;
    }
    
    @Nullable
    public static InteractionType[] getBlocking(MemorySegment mem) {
        return getBlocking(mem, 0);
    }
    
    @Nullable
    public static InteractionType[] getBlocking(MemorySegment mem, int offset) {
        if (!hasBlocking(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 21, 33, "Blocking");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Blocking");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Blocking", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Blocking", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new InteractionType[len];
        for (var i = 0; i < len; i++) {
            data[i] = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
        }
        return data;
    }
    
    @Nullable
    public static InteractionType[] getInterruptedBy(MemorySegment mem) {
        return getInterruptedBy(mem, 0);
    }
    
    @Nullable
    public static InteractionType[] getInterruptedBy(MemorySegment mem, int offset) {
        if (!hasInterruptedBy(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 25, 33, "InterruptedBy");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("InterruptedBy");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("InterruptedBy", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("InterruptedBy", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new InteractionType[len];
        for (var i = 0; i < len; i++) {
            data[i] = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
        }
        return data;
    }
    
    @Nullable
    public static InteractionType[] getInterrupting(MemorySegment mem) {
        return getInterrupting(mem, 0);
    }
    
    @Nullable
    public static InteractionType[] getInterrupting(MemorySegment mem, int offset) {
        if (!hasInterrupting(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 29, 33, "Interrupting");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Interrupting");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Interrupting", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Interrupting", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new InteractionType[len];
        for (var i = 0; i < len; i++) {
            data[i] = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
        }
        return data;
    }
    
    public static int getBlockedByBypassIndex(MemorySegment mem) {
        return getBlockedByBypassIndex(mem, 0);
    }
    
    public static int getBlockedByBypassIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getBlockingBypassIndex(MemorySegment mem) {
        return getBlockingBypassIndex(mem, 0);
    }
    
    public static int getBlockingBypassIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static int getInterruptedByBypassIndex(MemorySegment mem) {
        return getInterruptedByBypassIndex(mem, 0);
    }
    
    public static int getInterruptedByBypassIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 9);
    }
    
    public static int getInterruptingBypassIndex(MemorySegment mem) {
        return getInterruptingBypassIndex(mem, 0);
    }
    
    public static int getInterruptingBypassIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 13);
    }
    
    public static boolean hasBlockedBy(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasBlocking(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasInterruptedBy(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasInterrupting(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
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
    
    public static InteractionRules toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static InteractionRules toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one InteractionRules and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static InteractionRules toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 33;
        var varPos = 0;
        InteractionType[] v0 = null;
        if (hasBlockedBy(mem, offset)) {
            requireSlot(mem, offset + 17, varPos, "BlockedBy");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("BlockedBy");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("BlockedBy", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockedBy", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new InteractionType[len];
            for (var i = 0; i < len; i++) {
                v0[i] = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
            }
            varPos = off + len - varBase;
        } else {
            requireSlot(mem, offset + 17, -1, "BlockedBy");
        }
        
        InteractionType[] v1 = null;
        if (hasBlocking(mem, offset)) {
            requireSlot(mem, offset + 21, varPos, "Blocking");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Blocking");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Blocking", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Blocking", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new InteractionType[len];
            for (var i = 0; i < len; i++) {
                v1[i] = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
            }
            varPos = off + len - varBase;
        } else {
            requireSlot(mem, offset + 21, -1, "Blocking");
        }
        
        InteractionType[] v2 = null;
        if (hasInterruptedBy(mem, offset)) {
            requireSlot(mem, offset + 25, varPos, "InterruptedBy");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("InterruptedBy");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("InterruptedBy", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("InterruptedBy", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new InteractionType[len];
            for (var i = 0; i < len; i++) {
                v2[i] = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
            }
            varPos = off + len - varBase;
        } else {
            requireSlot(mem, offset + 25, -1, "InterruptedBy");
        }
        
        InteractionType[] v3 = null;
        if (hasInterrupting(mem, offset)) {
            requireSlot(mem, offset + 29, varPos, "Interrupting");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Interrupting");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Interrupting", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Interrupting", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v3 = new InteractionType[len];
            for (var i = 0; i < len; i++) {
                v3[i] = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
            }
            varPos = off + len - varBase;
        } else {
            requireSlot(mem, offset + 29, -1, "Interrupting");
        }
        var result = new InteractionRules(
            v0,
            v1,
            v2,
            v3,
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            mem.get(PacketIO.PROTO_INT, offset + 9),
            mem.get(PacketIO.PROTO_INT, offset + 13)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.blockedBy != null) nullBits |= 0x01;
        if (this.blocking != null) nullBits |= 0x02;
        if (this.interruptedBy != null) nullBits |= 0x04;
        if (this.interrupting != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.blockedByBypassIndex);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.blockingBypassIndex);
        mem.set(PacketIO.PROTO_INT, offset + 9, this.interruptedByBypassIndex);
        mem.set(PacketIO.PROTO_INT, offset + 13, this.interruptingBypassIndex);
        var varOffset = offset + 33;
        if (this.blockedBy != null) {
            mem.set(PacketIO.PROTO_INT, offset + 17, varOffset - offset - 33);
            if (blockedBy.length > 4096000) throw ProtocolException.arrayTooLong("BlockedBy", blockedBy.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.blockedBy.length);
            
            for (var i = 0; i < this.blockedBy.length; i++) {
                mem.set(PacketIO.PROTO_BYTE, varOffset + i * 1, (byte) this.blockedBy[i].getValue());
            }
            varOffset += this.blockedBy.length * 1;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 17, -1);
        }
        if (this.blocking != null) {
            mem.set(PacketIO.PROTO_INT, offset + 21, varOffset - offset - 33);
            if (blocking.length > 4096000) throw ProtocolException.arrayTooLong("Blocking", blocking.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.blocking.length);
            
            for (var i = 0; i < this.blocking.length; i++) {
                mem.set(PacketIO.PROTO_BYTE, varOffset + i * 1, (byte) this.blocking[i].getValue());
            }
            varOffset += this.blocking.length * 1;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 21, -1);
        }
        if (this.interruptedBy != null) {
            mem.set(PacketIO.PROTO_INT, offset + 25, varOffset - offset - 33);
            if (interruptedBy.length > 4096000) throw ProtocolException.arrayTooLong("InterruptedBy", interruptedBy.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.interruptedBy.length);
            
            for (var i = 0; i < this.interruptedBy.length; i++) {
                mem.set(PacketIO.PROTO_BYTE, varOffset + i * 1, (byte) this.interruptedBy[i].getValue());
            }
            varOffset += this.interruptedBy.length * 1;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 25, -1);
        }
        if (this.interrupting != null) {
            mem.set(PacketIO.PROTO_INT, offset + 29, varOffset - offset - 33);
            if (interrupting.length > 4096000) throw ProtocolException.arrayTooLong("Interrupting", interrupting.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.interrupting.length);
            
            for (var i = 0; i < this.interrupting.length; i++) {
                mem.set(PacketIO.PROTO_BYTE, varOffset + i * 1, (byte) this.interrupting[i].getValue());
            }
            varOffset += this.interrupting.length * 1;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 29, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 33;
        if (blockedBy != null) size += VarInt.size(blockedBy.length) + blockedBy.length * 1;
    if (blocking != null) size += VarInt.size(blocking.length) + blocking.length * 1;
    if (interruptedBy != null) size += VarInt.size(interruptedBy.length) + interruptedBy.length * 1;
    if (interrupting != null) size += VarInt.size(interrupting.length) + interrupting.length * 1;

        return size;
    }

    public InteractionRules clone() {
        InteractionRules copy = new InteractionRules();
        copy.blockedBy = this.blockedBy != null ? java.util.Arrays.copyOf(this.blockedBy, this.blockedBy.length) : null;
        copy.blocking = this.blocking != null ? java.util.Arrays.copyOf(this.blocking, this.blocking.length) : null;
        copy.interruptedBy = this.interruptedBy != null ? java.util.Arrays.copyOf(this.interruptedBy, this.interruptedBy.length) : null;
        copy.interrupting = this.interrupting != null ? java.util.Arrays.copyOf(this.interrupting, this.interrupting.length) : null;
        copy.blockedByBypassIndex = this.blockedByBypassIndex;
        copy.blockingBypassIndex = this.blockingBypassIndex;
        copy.interruptedByBypassIndex = this.interruptedByBypassIndex;
        copy.interruptingBypassIndex = this.interruptingBypassIndex;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InteractionRules other)) return false;
        return java.util.Arrays.equals(this.blockedBy, other.blockedBy) && java.util.Arrays.equals(this.blocking, other.blocking) && java.util.Arrays.equals(this.interruptedBy, other.interruptedBy) && java.util.Arrays.equals(this.interrupting, other.interrupting) && this.blockedByBypassIndex == other.blockedByBypassIndex && this.blockingBypassIndex == other.blockingBypassIndex && this.interruptedByBypassIndex == other.interruptedByBypassIndex && this.interruptingBypassIndex == other.interruptingBypassIndex;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(blockedBy);
        result = 31 * result + java.util.Arrays.hashCode(blocking);
        result = 31 * result + java.util.Arrays.hashCode(interruptedBy);
        result = 31 * result + java.util.Arrays.hashCode(interrupting);
        result = 31 * result + Integer.hashCode(blockedByBypassIndex);
        result = 31 * result + Integer.hashCode(blockingBypassIndex);
        result = 31 * result + Integer.hashCode(interruptedByBypassIndex);
        result = 31 * result + Integer.hashCode(interruptingBypassIndex);
        return result;
    }

}