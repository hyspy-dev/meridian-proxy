// Auto-generated - do not edit
package meridian.protocol.packets.connection;

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
import meridian.protocol.HostAddress;

public class Connect implements Packet, ToServerPacket {
    public static final int PACKET_ID = 0;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 30;
    public static final int VARIABLE_FIELD_COUNT = 4;
    public static final int VARIABLE_BLOCK_START = 46;
    public static final int MAX_SIZE = 37972;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int protocolCrc;
    public int protocolBuildNumber;
    @Nonnull public String clientVersion = "";
    @Nonnull public ClientType clientType = ClientType.Game;
    @Nullable public String identityToken;
    @Nonnull public String language = "";
    @Nullable public byte[] referralData;
    @Nullable public HostAddress referralSource;

    public Connect() {
    }

    public Connect(int protocolCrc, int protocolBuildNumber, @Nonnull String clientVersion, @Nonnull ClientType clientType, @Nullable String identityToken, @Nonnull String language, @Nullable byte[] referralData, @Nullable HostAddress referralSource) {
        this.protocolCrc = protocolCrc;
        this.protocolBuildNumber = protocolBuildNumber;
        this.clientVersion = clientVersion;
        this.clientType = clientType;
        this.identityToken = identityToken;
        this.language = language;
        this.referralData = referralData;
        this.referralSource = referralSource;
    }

    public Connect(@Nonnull Connect other) {
        this.protocolCrc = other.protocolCrc;
        this.protocolBuildNumber = other.protocolBuildNumber;
        this.clientVersion = other.clientVersion;
        this.clientType = other.clientType;
        this.identityToken = other.identityToken;
        this.language = other.language;
        this.referralData = other.referralData;
        this.referralSource = other.referralSource;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Connect", offset, (int) mem.byteSize());
        long needed = (long) offset + 46;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Connect", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getProtocolCrc(MemorySegment mem) {
        return getProtocolCrc(mem, 0);
    }
    
    public static int getProtocolCrc(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getProtocolBuildNumber(MemorySegment mem) {
        return getProtocolBuildNumber(mem, 0);
    }
    
    public static int getProtocolBuildNumber(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static String getClientVersion(MemorySegment mem) {
        return getClientVersion(mem, 0);
    }
    
    public static String getClientVersion(MemorySegment mem, int offset) {
        return PacketIO.readFixedAsciiString(mem, offset + 9, 20);
    }
    
    public static ClientType getClientType(MemorySegment mem) {
        return getClientType(mem, 0);
    }
    
    public static ClientType getClientType(MemorySegment mem, int offset) {
        return ClientType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 29));
    }
    
    @Nullable
    public static String getIdentityToken(MemorySegment mem) {
        return getIdentityToken(mem, 0);
    }
    
    @Nullable
    public static String getIdentityToken(MemorySegment mem, int offset) {
        return hasIdentityToken(mem, offset) ? PacketIO.readVarString("IdentityToken", mem, offset + getValidatedOffset(mem, offset, 30, 46, "IdentityToken"), 8192): null;
    }
    
    public static String getLanguage(MemorySegment mem) {
        return getLanguage(mem, 0);
    }
    
    public static String getLanguage(MemorySegment mem, int offset) {
        return PacketIO.readValidatedAsciiString("Language", mem, offset + getValidatedOffset(mem, offset, 34, 46, "Language"), 16);
    }
    
    @Nullable
    public static byte[] getReferralData(MemorySegment mem) {
        return getReferralData(mem, 0);
    }
    
    @Nullable
    public static byte[] getReferralData(MemorySegment mem, int offset) {
        if (!hasReferralData(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 38, 46, "ReferralData");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ReferralData");
        var len = (int) packed;
        if (len > 4096) throw ProtocolException.arrayTooLong("ReferralData", len, 4096);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("ReferralData", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new byte[len];
        MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, data, 0, len);
        return data;
    }
    
    @Nullable
    public static HostAddress getReferralSource(MemorySegment mem) {
        return getReferralSource(mem, 0);
    }
    
    @Nullable
    public static HostAddress getReferralSource(MemorySegment mem, int offset) {
        return hasReferralSource(mem, offset) ? HostAddress.toObject(mem, offset + getValidatedOffset(mem, offset, 42, 46, "ReferralSource")): null;
    }
    
    public static boolean hasIdentityToken(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasReferralData(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasReferralSource(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
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
    
    public static Connect toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Connect toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Connect and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Connect toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 46;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v4 = null;
        if (hasIdentityToken(mem, offset)) {
            requireSlot(mem, offset + 30, varPos, "IdentityToken");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v4 = PacketIO.readVarString("IdentityToken", mem, off, 0, 8192, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 30, -1, "IdentityToken");
        }
        
        String v5;
        requireSlot(mem, offset + 34, varPos, "Language");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v5 = PacketIO.readValidatedAsciiString("Language", mem, off, 0, 16, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        byte[] v6 = null;
        if (hasReferralData(mem, offset)) {
            requireSlot(mem, offset + 38, varPos, "ReferralData");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ReferralData");
            var len = (int) packed;
            if (len > 4096) throw ProtocolException.arrayTooLong("ReferralData", len, 4096);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("ReferralData", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v6 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v6, 0, len);
            varPos = off + len - varBase;
        } else {
            requireSlot(mem, offset + 38, -1, "ReferralData");
        }
        
        HostAddress v7 = null;
        if (hasReferralSource(mem, offset)) {
            requireSlot(mem, offset + 42, varPos, "ReferralSource");
            v7 = HostAddress.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 42, -1, "ReferralSource");
        }
        var result = new Connect(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            PacketIO.readFixedAsciiString(mem, offset + 9, 20),
            ClientType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 29)),
            v4,
            v5,
            v6,
            v7
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.identityToken != null) nullBits |= 0x01;
        if (this.referralData != null) nullBits |= 0x02;
        if (this.referralSource != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.protocolCrc);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.protocolBuildNumber);
        PacketIO.writeFixedAsciiString(mem, offset + 9, this.clientVersion, 20);
        mem.set(PacketIO.PROTO_BYTE, offset + 29, (byte) this.clientType.getValue());
        var varOffset = offset + 46;
        if (this.identityToken != null) {
            mem.set(PacketIO.PROTO_INT, offset + 30, varOffset - offset - 46);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.identityToken, 8192);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 30, -1);
        }
        mem.set(PacketIO.PROTO_INT, offset + 34, varOffset - offset - 46);
        varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.language, 16);
        if (this.referralData != null) {
            mem.set(PacketIO.PROTO_INT, offset + 38, varOffset - offset - 46);
            if (referralData.length > 4096) throw ProtocolException.arrayTooLong("ReferralData", referralData.length, 4096);
            varOffset += VarInt.set(mem, varOffset, this.referralData.length);
            
            MemorySegment.copy(this.referralData, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.referralData.length);
            varOffset += this.referralData.length * 1;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 38, -1);
        }
        if (this.referralSource != null) {
            mem.set(PacketIO.PROTO_INT, offset + 42, varOffset - offset - 46);
            varOffset += this.referralSource.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 42, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 46;
        if (identityToken != null) size += PacketIO.stringSize(identityToken);
    size += VarInt.size(language.length()) + language.length();
    if (referralData != null) size += VarInt.size(referralData.length) + referralData.length * 1;
    if (referralSource != null) size += referralSource.computeSize();

        return size;
    }

    public Connect clone() {
        Connect copy = new Connect();
        copy.protocolCrc = this.protocolCrc;
        copy.protocolBuildNumber = this.protocolBuildNumber;
        copy.clientVersion = this.clientVersion;
        copy.clientType = this.clientType;
        copy.identityToken = this.identityToken;
        copy.language = this.language;
        copy.referralData = this.referralData != null ? java.util.Arrays.copyOf(this.referralData, this.referralData.length) : null;
        copy.referralSource = this.referralSource != null ? this.referralSource.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Connect other)) return false;
        return this.protocolCrc == other.protocolCrc && this.protocolBuildNumber == other.protocolBuildNumber && java.util.Objects.equals(this.clientVersion, other.clientVersion) && java.util.Objects.equals(this.clientType, other.clientType) && java.util.Objects.equals(this.identityToken, other.identityToken) && java.util.Objects.equals(this.language, other.language) && java.util.Arrays.equals(this.referralData, other.referralData) && java.util.Objects.equals(this.referralSource, other.referralSource);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(protocolCrc);
        result = 31 * result + Integer.hashCode(protocolBuildNumber);
        result = 31 * result + java.util.Objects.hashCode(clientVersion);
        result = 31 * result + java.util.Objects.hashCode(clientType);
        result = 31 * result + java.util.Objects.hashCode(identityToken);
        result = 31 * result + java.util.Objects.hashCode(language);
        result = 31 * result + java.util.Arrays.hashCode(referralData);
        result = 31 * result + java.util.Objects.hashCode(referralSource);
        return result;
    }

}