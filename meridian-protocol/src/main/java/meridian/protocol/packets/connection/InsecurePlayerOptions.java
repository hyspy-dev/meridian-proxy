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
import meridian.protocol.PlayerSkin;
import java.util.UUID;

public class InsecurePlayerOptions implements Packet, ToServerPacket {
    public static final int PACKET_ID = 363;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 17;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 25;
    public static final int MAX_SIZE = 2149;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public java.util.UUID uuid = new java.util.UUID(0L, 0L);
    @Nonnull public String username = "";
    @Nullable public PlayerSkin skin;

    public InsecurePlayerOptions() {
    }

    public InsecurePlayerOptions(@Nonnull java.util.UUID uuid, @Nonnull String username, @Nullable PlayerSkin skin) {
        this.uuid = uuid;
        this.username = username;
        this.skin = skin;
    }

    public InsecurePlayerOptions(@Nonnull InsecurePlayerOptions other) {
        this.uuid = other.uuid;
        this.username = other.username;
        this.skin = other.skin;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("InsecurePlayerOptions", offset, (int) mem.byteSize());
        long needed = (long) offset + 25;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InsecurePlayerOptions", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static java.util.UUID getUuid(MemorySegment mem) {
        return getUuid(mem, 0);
    }
    
    public static java.util.UUID getUuid(MemorySegment mem, int offset) {
        return PacketIO.readUUID(mem, offset + 1);
    }
    
    public static String getUsername(MemorySegment mem) {
        return getUsername(mem, 0);
    }
    
    public static String getUsername(MemorySegment mem, int offset) {
        return PacketIO.readValidatedAsciiString("Username", mem, offset + getValidatedOffset(mem, offset, 17, 25, "Username"), 16);
    }
    
    @Nullable
    public static PlayerSkin getSkin(MemorySegment mem) {
        return getSkin(mem, 0);
    }
    
    @Nullable
    public static PlayerSkin getSkin(MemorySegment mem, int offset) {
        return hasSkin(mem, offset) ? PlayerSkin.toObject(mem, offset + getValidatedOffset(mem, offset, 21, 25, "Skin")): null;
    }
    
    public static boolean hasSkin(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
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
    
    public static InsecurePlayerOptions toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static InsecurePlayerOptions toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one InsecurePlayerOptions and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static InsecurePlayerOptions toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 25;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v1;
        requireSlot(mem, offset + 17, varPos, "Username");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readValidatedAsciiString("Username", mem, off, 0, 16, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        PlayerSkin v2 = null;
        if (hasSkin(mem, offset)) {
            requireSlot(mem, offset + 21, varPos, "Skin");
            v2 = PlayerSkin.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 21, -1, "Skin");
        }
        var result = new InsecurePlayerOptions(
            PacketIO.readUUID(mem, offset + 1),
            v1,
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.skin != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.writeUUID(mem, offset + 1, this.uuid);
        var varOffset = offset + 25;
        mem.set(PacketIO.PROTO_INT, offset + 17, varOffset - offset - 25);
        varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.username, 16);
        if (this.skin != null) {
            mem.set(PacketIO.PROTO_INT, offset + 21, varOffset - offset - 25);
            varOffset += this.skin.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 21, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 25;
        size += VarInt.size(username.length()) + username.length();
    if (skin != null) size += skin.computeSize();

        return size;
    }

    public InsecurePlayerOptions clone() {
        InsecurePlayerOptions copy = new InsecurePlayerOptions();
        copy.uuid = this.uuid;
        copy.username = this.username;
        copy.skin = this.skin != null ? this.skin.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InsecurePlayerOptions other)) return false;
        return java.util.Objects.equals(this.uuid, other.uuid) && java.util.Objects.equals(this.username, other.username) && java.util.Objects.equals(this.skin, other.skin);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(uuid, username, skin);
    }

}