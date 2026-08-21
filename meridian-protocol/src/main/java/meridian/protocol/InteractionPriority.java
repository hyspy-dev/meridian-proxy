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
import java.util.HashMap;

public class InteractionPriority {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 20480006;

    @Nullable public java.util.Map<PrioritySlot, Integer> values;

    public InteractionPriority() {
    }

    public InteractionPriority(@Nullable java.util.Map<PrioritySlot, Integer> values) {
        this.values = values;
    }

    public InteractionPriority(@Nonnull InteractionPriority other) {
        this.values = other.values;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("InteractionPriority", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InteractionPriority", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static java.util.Map<PrioritySlot, Integer> getValues(MemorySegment mem) {
        return getValues(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<PrioritySlot, Integer> getValues(MemorySegment mem, int offset) {
        if (!hasValues(mem, offset)) return null;
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Values");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Values", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Values", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<PrioritySlot, Integer> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = PrioritySlot.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                off += 1;
            var value = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Values", key);
            }
        }
        return data;
    }
    
    public static boolean hasValues(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static InteractionPriority toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static InteractionPriority toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one InteractionPriority and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static InteractionPriority toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        java.util.Map<PrioritySlot, Integer> v0 = null;
        if (hasValues(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Values");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Values", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Values", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v0 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = PrioritySlot.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                    off += 1;
                var value = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                if (v0.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Values", key);
                }
            }
            varPos = off - varBase;
        }
        var result = new InteractionPriority(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.values != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.values != null) {
            
            if (this.values.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Values", values.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.values.size());
            for (var e : this.values.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                mem.set(PacketIO.PROTO_INT, varOffset, e.getValue());
                varOffset += 4;
            }
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (values != null) size += VarInt.size(values.size()) + values.size() * (1 + 4);

        return size;
    }

    public InteractionPriority clone() {
        InteractionPriority copy = new InteractionPriority();
        copy.values = this.values != null ? new java.util.HashMap<>(this.values) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InteractionPriority other)) return false;
        return java.util.Objects.equals(this.values, other.values);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(values);
    }

}