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


public class HostAddress {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 2;
    public static final int MAX_SIZE = 1031;

    @Nonnull public String host = "";
    public short port;

    public HostAddress() {
    }

    public HostAddress(@Nonnull String host, short port) {
        this.host = host;
        this.port = port;
    }

    public HostAddress(@Nonnull HostAddress other) {
        this.host = other.host;
        this.port = other.port;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("HostAddress", offset, (int) mem.byteSize());
        long needed = (long) offset + 2;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("HostAddress", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getHost(MemorySegment mem) {
        return getHost(mem, 0);
    }
    
    public static String getHost(MemorySegment mem, int offset) {
        return PacketIO.readVarString("Host", mem, offset + 2, 256);
    }
    
    public static short getPort(MemorySegment mem) {
        return getPort(mem, 0);
    }
    
    public static short getPort(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_SHORT, offset + 0);
    }
    
    
    
    
    
    public static HostAddress toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static HostAddress toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one HostAddress and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static HostAddress toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 2;
        var varPos = 0;
        String v0;
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Host", mem, off, 0, 256, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new HostAddress(
            v0,
            mem.get(PacketIO.PROTO_SHORT, offset + 0)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_SHORT, offset + 0, this.port);
        var varOffset = offset + 2;
        varOffset += PacketIO.writeVarString(mem, varOffset, this.host, 256);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 2;
        size += PacketIO.stringSize(host);

        return size;
    }

    public HostAddress clone() {
        HostAddress copy = new HostAddress();
        copy.host = this.host;
        copy.port = this.port;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof HostAddress other)) return false;
        return java.util.Objects.equals(this.host, other.host) && this.port == other.port;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(host, port);
    }

}