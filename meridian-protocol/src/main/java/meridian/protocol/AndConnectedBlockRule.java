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


public class AndConnectedBlockRule extends ConnectedBlockRule {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public ConnectedBlockRule[] rules;

    public AndConnectedBlockRule() {
    }

    public AndConnectedBlockRule(@Nullable ConnectedBlockRule[] rules) {
        this.rules = rules;
    }

    public AndConnectedBlockRule(@Nonnull AndConnectedBlockRule other) {
        this.rules = other.rules;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AndConnectedBlockRule", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AndConnectedBlockRule", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static ConnectedBlockRule[] getRules(MemorySegment mem) {
        return getRules(mem, 0);
    }
    
    @Nullable
    public static ConnectedBlockRule[] getRules(MemorySegment mem, int offset) {
        if (!hasRules(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Rules");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Rules", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Rules", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ConnectedBlockRule[len];
        for (var i = 0; i < len; i++) {
            data[i] = ConnectedBlockRule.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasRules(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static AndConnectedBlockRule toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AndConnectedBlockRule toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AndConnectedBlockRule and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AndConnectedBlockRule toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ConnectedBlockRule[] v0 = null;
        if (hasRules(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Rules");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Rules", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Rules", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new ConnectedBlockRule[len];
            for (var i = 0; i < len; i++) {
                v0[i] = ConnectedBlockRule.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new AndConnectedBlockRule(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.rules != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.rules != null) {
            
            if (rules.length > 4096000) throw ProtocolException.arrayTooLong("Rules", rules.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.rules.length);
            
            var rulesValueOffset = 0;
            for (var i = 0; i < this.rules.length; i++) {
                rulesValueOffset += this.rules[i].serializeWithTypeId(mem, varOffset + rulesValueOffset);
            }
            varOffset += rulesValueOffset;
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 1;
        if (rules != null) {
        int rulesSize = 0;
for (var elem : rules) rulesSize += elem.computeSizeWithTypeId();
size += VarInt.size(rules.length) + rulesSize;
    }

        return size;
    }

    public AndConnectedBlockRule clone() {
        AndConnectedBlockRule copy = new AndConnectedBlockRule();
        copy.rules = this.rules != null ? java.util.Arrays.copyOf(this.rules, this.rules.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AndConnectedBlockRule other)) return false;
        return java.util.Arrays.equals(this.rules, other.rules);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(rules);
        return result;
    }

}