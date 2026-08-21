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


public class Asset {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 64;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 64;
    public static final int MAX_SIZE = 2117;

    @Nonnull public String hash = "";
    @Nonnull public String name = "";

    public Asset() {
    }

    public Asset(@Nonnull String hash, @Nonnull String name) {
        this.hash = hash;
        this.name = name;
    }

    public Asset(@Nonnull Asset other) {
        this.hash = other.hash;
        this.name = other.name;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Asset", offset, (int) mem.byteSize());
        long needed = (long) offset + 64;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Asset", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getHash(MemorySegment mem) {
        return getHash(mem, 0);
    }
    
    public static String getHash(MemorySegment mem, int offset) {
        return PacketIO.readFixedAsciiString(mem, offset + 0, 64);
    }
    
    public static String getName(MemorySegment mem) {
        return getName(mem, 0);
    }
    
    public static String getName(MemorySegment mem, int offset) {
        return PacketIO.readVarString("Name", mem, offset + 64, 512);
    }
    
    
    
    
    
    public static Asset toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Asset toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Asset and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Asset toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 64;
        var varPos = 0;
        String v1;
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Name", mem, off, 0, 512, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new Asset(
            PacketIO.readFixedAsciiString(mem, offset + 0, 64),
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.writeFixedAsciiString(mem, offset + 0, this.hash, 64);
        var varOffset = offset + 64;
        varOffset += PacketIO.writeVarString(mem, varOffset, this.name, 512);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 64;
        size += PacketIO.stringSize(name);

        return size;
    }

    public Asset clone() {
        Asset copy = new Asset();
        copy.hash = this.hash;
        copy.name = this.name;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Asset other)) return false;
        return java.util.Objects.equals(this.hash, other.hash) && java.util.Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(hash, name);
    }

}