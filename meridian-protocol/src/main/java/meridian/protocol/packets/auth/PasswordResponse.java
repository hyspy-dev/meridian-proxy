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


public class PasswordResponse implements Packet, ToServerPacket {
    public static final int PACKET_ID = 15;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 70;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public byte[] hash;

    public PasswordResponse() {
    }

    public PasswordResponse(@Nullable byte[] hash) {
        this.hash = hash;
    }

    public PasswordResponse(@Nonnull PasswordResponse other) {
        this.hash = other.hash;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PasswordResponse", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PasswordResponse", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static byte[] getHash(MemorySegment mem) {
        return getHash(mem, 0);
    }
    
    @Nullable
    public static byte[] getHash(MemorySegment mem, int offset) {
        if (!hasHash(mem, offset)) return null;
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Hash");
        var len = (int) packed;
        if (len > 64) throw ProtocolException.arrayTooLong("Hash", len, 64);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Hash", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new byte[len];
        MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, data, 0, len);
        return data;
    }
    
    public static boolean hasHash(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static PasswordResponse toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PasswordResponse toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PasswordResponse and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PasswordResponse toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        byte[] v0 = null;
        if (hasHash(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Hash");
            var len = (int) packed;
            if (len > 64) throw ProtocolException.arrayTooLong("Hash", len, 64);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Hash", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v0, 0, len);
            varPos = off + len - varBase;
        }
        var result = new PasswordResponse(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.hash != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.hash != null) {
            
            if (hash.length > 64) throw ProtocolException.arrayTooLong("Hash", hash.length, 64);
            varOffset += VarInt.set(mem, varOffset, this.hash.length);
            
            MemorySegment.copy(this.hash, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.hash.length);
            varOffset += this.hash.length * 1;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (hash != null) size += VarInt.size(hash.length) + hash.length * 1;

        return size;
    }

    public PasswordResponse clone() {
        PasswordResponse copy = new PasswordResponse();
        copy.hash = this.hash != null ? java.util.Arrays.copyOf(this.hash, this.hash.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PasswordResponse other)) return false;
        return java.util.Arrays.equals(this.hash, other.hash);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(hash);
        return result;
    }

}