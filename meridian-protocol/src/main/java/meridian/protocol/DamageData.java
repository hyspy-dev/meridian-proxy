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


public class DamageData {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public DamageEntry[] entries;

    public DamageData() {
    }

    public DamageData(@Nullable DamageEntry[] entries) {
        this.entries = entries;
    }

    public DamageData(@Nonnull DamageData other) {
        this.entries = other.entries;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("DamageData", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("DamageData", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static DamageEntry[] getEntries(MemorySegment mem) {
        return getEntries(mem, 0);
    }
    
    @Nullable
    public static DamageEntry[] getEntries(MemorySegment mem, int offset) {
        if (!hasEntries(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Entries");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Entries", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 9 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Entries", (int) java.lang.Math.min(off + lenOffset + (long) len * 9, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new DamageEntry[len];
        for (var i = 0; i < len; i++) {
            data[i] = DamageEntry.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasEntries(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static DamageData toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static DamageData toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one DamageData and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static DamageData toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        DamageEntry[] v0 = null;
        if (hasEntries(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Entries");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Entries", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 9 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Entries", (int) java.lang.Math.min(off + lenOffset + (long) len * 9, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new DamageEntry[len];
            for (var i = 0; i < len; i++) {
                v0[i] = DamageEntry.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new DamageData(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.entries != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.entries != null) {
            
            if (entries.length > 4096000) throw ProtocolException.arrayTooLong("Entries", entries.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.entries.length);
            
            var entriesValueOffset = 0;
            for (var i = 0; i < this.entries.length; i++) {
                entriesValueOffset += this.entries[i].serialize(mem, varOffset + entriesValueOffset);
            }
            varOffset += entriesValueOffset;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (entries != null) {
        int entriesSize = 0;
for (var elem : entries) entriesSize += elem.computeSize();
size += VarInt.size(entries.length) + entriesSize;
    }

        return size;
    }

    public DamageData clone() {
        DamageData copy = new DamageData();
        copy.entries = this.entries != null ? java.util.Arrays.stream(this.entries).map(e -> e.clone()).toArray(DamageEntry[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DamageData other)) return false;
        return java.util.Arrays.equals(this.entries, other.entries);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(entries);
        return result;
    }

}