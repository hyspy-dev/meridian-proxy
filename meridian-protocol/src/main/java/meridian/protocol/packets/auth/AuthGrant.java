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


public class AuthGrant implements Packet, ToClientPacket {
    public static final int PACKET_ID = 11;
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

    @Nullable public String authorizationGrant;
    @Nullable public String serverIdentityToken;

    public AuthGrant() {
    }

    public AuthGrant(@Nullable String authorizationGrant, @Nullable String serverIdentityToken) {
        this.authorizationGrant = authorizationGrant;
        this.serverIdentityToken = serverIdentityToken;
    }

    public AuthGrant(@Nonnull AuthGrant other) {
        this.authorizationGrant = other.authorizationGrant;
        this.serverIdentityToken = other.serverIdentityToken;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AuthGrant", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AuthGrant", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getAuthorizationGrant(MemorySegment mem) {
        return getAuthorizationGrant(mem, 0);
    }
    
    @Nullable
    public static String getAuthorizationGrant(MemorySegment mem, int offset) {
        return hasAuthorizationGrant(mem, offset) ? PacketIO.readVarString("AuthorizationGrant", mem, offset + getValidatedOffset(mem, offset, 1, 9, "AuthorizationGrant"), 4096): null;
    }
    
    @Nullable
    public static String getServerIdentityToken(MemorySegment mem) {
        return getServerIdentityToken(mem, 0);
    }
    
    @Nullable
    public static String getServerIdentityToken(MemorySegment mem, int offset) {
        return hasServerIdentityToken(mem, offset) ? PacketIO.readVarString("ServerIdentityToken", mem, offset + getValidatedOffset(mem, offset, 5, 9, "ServerIdentityToken"), 8192): null;
    }
    
    public static boolean hasAuthorizationGrant(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasServerIdentityToken(MemorySegment mem, int offset) {
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
    
    public static AuthGrant toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AuthGrant toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AuthGrant and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AuthGrant toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        String v0 = null;
        if (hasAuthorizationGrant(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "AuthorizationGrant");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("AuthorizationGrant", mem, off, 0, 4096, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 1, -1, "AuthorizationGrant");
        }
        
        String v1 = null;
        if (hasServerIdentityToken(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "ServerIdentityToken");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("ServerIdentityToken", mem, off, 0, 8192, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 5, -1, "ServerIdentityToken");
        }
        var result = new AuthGrant(
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
        if (this.authorizationGrant != null) nullBits |= 0x01;
        if (this.serverIdentityToken != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 9;
        if (this.authorizationGrant != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 9);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.authorizationGrant, 4096);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.serverIdentityToken != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 9);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.serverIdentityToken, 8192);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (authorizationGrant != null) size += PacketIO.stringSize(authorizationGrant);
    if (serverIdentityToken != null) size += PacketIO.stringSize(serverIdentityToken);

        return size;
    }

    public AuthGrant clone() {
        AuthGrant copy = new AuthGrant();
        copy.authorizationGrant = this.authorizationGrant;
        copy.serverIdentityToken = this.serverIdentityToken;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AuthGrant other)) return false;
        return java.util.Objects.equals(this.authorizationGrant, other.authorizationGrant) && java.util.Objects.equals(this.serverIdentityToken, other.serverIdentityToken);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(authorizationGrant, serverIdentityToken);
    }

}