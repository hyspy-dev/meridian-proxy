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


public class AuthToken implements Packet, ToServerPacket {
    public static final int PACKET_ID = 12;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 49171;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public String accessToken;
    @Nullable public String serverAuthorizationGrant;

    public AuthToken() {
    }

    public AuthToken(@Nullable String accessToken, @Nullable String serverAuthorizationGrant) {
        this.accessToken = accessToken;
        this.serverAuthorizationGrant = serverAuthorizationGrant;
    }

    public AuthToken(@Nonnull AuthToken other) {
        this.accessToken = other.accessToken;
        this.serverAuthorizationGrant = other.serverAuthorizationGrant;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AuthToken", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AuthToken", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getAccessToken(MemorySegment mem) {
        return getAccessToken(mem, 0);
    }
    
    @Nullable
    public static String getAccessToken(MemorySegment mem, int offset) {
        return hasAccessToken(mem, offset) ? PacketIO.readVarString("AccessToken", mem, offset + getValidatedOffset(mem, offset, 1, 9, "AccessToken"), 8192): null;
    }
    
    @Nullable
    public static String getServerAuthorizationGrant(MemorySegment mem) {
        return getServerAuthorizationGrant(mem, 0);
    }
    
    @Nullable
    public static String getServerAuthorizationGrant(MemorySegment mem, int offset) {
        return hasServerAuthorizationGrant(mem, offset) ? PacketIO.readVarString("ServerAuthorizationGrant", mem, offset + getValidatedOffset(mem, offset, 5, 9, "ServerAuthorizationGrant"), 4096): null;
    }
    
    public static boolean hasAccessToken(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasServerAuthorizationGrant(MemorySegment mem, int offset) {
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
    
    public static AuthToken toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AuthToken toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AuthToken and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AuthToken toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        String v0 = null;
        if (hasAccessToken(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "AccessToken");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("AccessToken", mem, off, 0, 8192, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 1, -1, "AccessToken");
        }
        
        String v1 = null;
        if (hasServerAuthorizationGrant(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "ServerAuthorizationGrant");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("ServerAuthorizationGrant", mem, off, 0, 4096, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 5, -1, "ServerAuthorizationGrant");
        }
        var result = new AuthToken(
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
        if (this.accessToken != null) nullBits |= 0x01;
        if (this.serverAuthorizationGrant != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 9;
        if (this.accessToken != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 9);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.accessToken, 8192);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.serverAuthorizationGrant != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 9);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.serverAuthorizationGrant, 4096);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (accessToken != null) size += PacketIO.stringSize(accessToken);
    if (serverAuthorizationGrant != null) size += PacketIO.stringSize(serverAuthorizationGrant);

        return size;
    }

    public AuthToken clone() {
        AuthToken copy = new AuthToken();
        copy.accessToken = this.accessToken;
        copy.serverAuthorizationGrant = this.serverAuthorizationGrant;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AuthToken other)) return false;
        return java.util.Objects.equals(this.accessToken, other.accessToken) && java.util.Objects.equals(this.serverAuthorizationGrant, other.serverAuthorizationGrant);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(accessToken, serverAuthorizationGrant);
    }

}