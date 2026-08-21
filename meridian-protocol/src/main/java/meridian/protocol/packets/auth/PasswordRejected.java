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


public class PasswordRejected implements Packet, ToClientPacket {
    public static final int PACKET_ID = 17;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 5;
    public static final int MAX_SIZE = 74;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public byte[] newChallenge;
    public int attemptsRemaining;

    public PasswordRejected() {
    }

    public PasswordRejected(@Nullable byte[] newChallenge, int attemptsRemaining) {
        this.newChallenge = newChallenge;
        this.attemptsRemaining = attemptsRemaining;
    }

    public PasswordRejected(@Nonnull PasswordRejected other) {
        this.newChallenge = other.newChallenge;
        this.attemptsRemaining = other.attemptsRemaining;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PasswordRejected", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PasswordRejected", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static byte[] getNewChallenge(MemorySegment mem) {
        return getNewChallenge(mem, 0);
    }
    
    @Nullable
    public static byte[] getNewChallenge(MemorySegment mem, int offset) {
        if (!hasNewChallenge(mem, offset)) return null;
        var off = offset + 5;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("NewChallenge");
        var len = (int) packed;
        if (len > 64) throw ProtocolException.arrayTooLong("NewChallenge", len, 64);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("NewChallenge", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new byte[len];
        MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, data, 0, len);
        return data;
    }
    
    public static int getAttemptsRemaining(MemorySegment mem) {
        return getAttemptsRemaining(mem, 0);
    }
    
    public static int getAttemptsRemaining(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static boolean hasNewChallenge(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static PasswordRejected toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PasswordRejected toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PasswordRejected and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PasswordRejected toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 5;
        var varPos = 0;
        byte[] v0 = null;
        if (hasNewChallenge(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("NewChallenge");
            var len = (int) packed;
            if (len > 64) throw ProtocolException.arrayTooLong("NewChallenge", len, 64);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("NewChallenge", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v0, 0, len);
            varPos = off + len - varBase;
        }
        var result = new PasswordRejected(
            v0,
            mem.get(PacketIO.PROTO_INT, offset + 1)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.newChallenge != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.attemptsRemaining);
        var varOffset = offset + 5;
        if (this.newChallenge != null) {
            
            if (newChallenge.length > 64) throw ProtocolException.arrayTooLong("NewChallenge", newChallenge.length, 64);
            varOffset += VarInt.set(mem, varOffset, this.newChallenge.length);
            
            MemorySegment.copy(this.newChallenge, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.newChallenge.length);
            varOffset += this.newChallenge.length * 1;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 5;
        if (newChallenge != null) size += VarInt.size(newChallenge.length) + newChallenge.length * 1;

        return size;
    }

    public PasswordRejected clone() {
        PasswordRejected copy = new PasswordRejected();
        copy.newChallenge = this.newChallenge != null ? java.util.Arrays.copyOf(this.newChallenge, this.newChallenge.length) : null;
        copy.attemptsRemaining = this.attemptsRemaining;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PasswordRejected other)) return false;
        return java.util.Arrays.equals(this.newChallenge, other.newChallenge) && this.attemptsRemaining == other.attemptsRemaining;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(newChallenge);
        result = 31 * result + Integer.hashCode(attemptsRemaining);
        return result;
    }

}