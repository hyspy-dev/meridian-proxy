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


public class ServerAuthToken implements Packet, ToClientPacket {
    public static final int PACKET_ID = 13;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 32851;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public String serverAccessToken;
    @Nullable public byte[] passwordChallenge;

    public ServerAuthToken() {
    }

    public ServerAuthToken(@Nullable String serverAccessToken, @Nullable byte[] passwordChallenge) {
        this.serverAccessToken = serverAccessToken;
        this.passwordChallenge = passwordChallenge;
    }

    public ServerAuthToken(@Nonnull ServerAuthToken other) {
        this.serverAccessToken = other.serverAccessToken;
        this.passwordChallenge = other.passwordChallenge;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ServerAuthToken", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ServerAuthToken", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getServerAccessToken(MemorySegment mem) {
        return getServerAccessToken(mem, 0);
    }
    
    @Nullable
    public static String getServerAccessToken(MemorySegment mem, int offset) {
        return hasServerAccessToken(mem, offset) ? PacketIO.readVarString("ServerAccessToken", mem, offset + getValidatedOffset(mem, offset, 1, 9, "ServerAccessToken"), 8192): null;
    }
    
    @Nullable
    public static byte[] getPasswordChallenge(MemorySegment mem) {
        return getPasswordChallenge(mem, 0);
    }
    
    @Nullable
    public static byte[] getPasswordChallenge(MemorySegment mem, int offset) {
        if (!hasPasswordChallenge(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 5, 9, "PasswordChallenge");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("PasswordChallenge");
        var len = (int) packed;
        if (len > 64) throw ProtocolException.arrayTooLong("PasswordChallenge", len, 64);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("PasswordChallenge", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new byte[len];
        MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, data, 0, len);
        return data;
    }
    
    public static boolean hasServerAccessToken(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasPasswordChallenge(MemorySegment mem, int offset) {
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
    
    public static ServerAuthToken toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ServerAuthToken toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ServerAuthToken and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ServerAuthToken toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        String v0 = null;
        if (hasServerAccessToken(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "ServerAccessToken");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("ServerAccessToken", mem, off, 0, 8192, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 1, -1, "ServerAccessToken");
        }
        
        byte[] v1 = null;
        if (hasPasswordChallenge(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "PasswordChallenge");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("PasswordChallenge");
            var len = (int) packed;
            if (len > 64) throw ProtocolException.arrayTooLong("PasswordChallenge", len, 64);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("PasswordChallenge", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v1, 0, len);
            varPos = off + len - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "PasswordChallenge");
        }
        var result = new ServerAuthToken(
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
        if (this.serverAccessToken != null) nullBits |= 0x01;
        if (this.passwordChallenge != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 9;
        if (this.serverAccessToken != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 9);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.serverAccessToken, 8192);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.passwordChallenge != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 9);
            if (passwordChallenge.length > 64) throw ProtocolException.arrayTooLong("PasswordChallenge", passwordChallenge.length, 64);
            varOffset += VarInt.set(mem, varOffset, this.passwordChallenge.length);
            
            MemorySegment.copy(this.passwordChallenge, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.passwordChallenge.length);
            varOffset += this.passwordChallenge.length * 1;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (serverAccessToken != null) size += PacketIO.stringSize(serverAccessToken);
    if (passwordChallenge != null) size += VarInt.size(passwordChallenge.length) + passwordChallenge.length * 1;

        return size;
    }

    public ServerAuthToken clone() {
        ServerAuthToken copy = new ServerAuthToken();
        copy.serverAccessToken = this.serverAccessToken;
        copy.passwordChallenge = this.passwordChallenge != null ? java.util.Arrays.copyOf(this.passwordChallenge, this.passwordChallenge.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ServerAuthToken other)) return false;
        return java.util.Objects.equals(this.serverAccessToken, other.serverAccessToken) && java.util.Arrays.equals(this.passwordChallenge, other.passwordChallenge);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(serverAccessToken);
        result = 31 * result + java.util.Arrays.hashCode(passwordChallenge);
        return result;
    }

}