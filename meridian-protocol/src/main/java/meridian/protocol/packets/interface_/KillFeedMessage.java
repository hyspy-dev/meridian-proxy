// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

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
import meridian.protocol.FormattedMessage;

public class KillFeedMessage implements Packet, ToClientPacket {
    public static final int PACKET_ID = 213;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public FormattedMessage killer;
    @Nullable public FormattedMessage decedent;
    @Nullable public String icon;

    public KillFeedMessage() {
    }

    public KillFeedMessage(@Nullable FormattedMessage killer, @Nullable FormattedMessage decedent, @Nullable String icon) {
        this.killer = killer;
        this.decedent = decedent;
        this.icon = icon;
    }

    public KillFeedMessage(@Nonnull KillFeedMessage other) {
        this.killer = other.killer;
        this.decedent = other.decedent;
        this.icon = other.icon;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("KillFeedMessage", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("KillFeedMessage", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static FormattedMessage getKiller(MemorySegment mem) {
        return getKiller(mem, 0);
    }
    
    @Nullable
    public static FormattedMessage getKiller(MemorySegment mem, int offset) {
        return hasKiller(mem, offset) ? FormattedMessage.toObject(mem, offset + getValidatedOffset(mem, offset, 1, 13, "Killer")): null;
    }
    
    @Nullable
    public static FormattedMessage getDecedent(MemorySegment mem) {
        return getDecedent(mem, 0);
    }
    
    @Nullable
    public static FormattedMessage getDecedent(MemorySegment mem, int offset) {
        return hasDecedent(mem, offset) ? FormattedMessage.toObject(mem, offset + getValidatedOffset(mem, offset, 5, 13, "Decedent")): null;
    }
    
    @Nullable
    public static String getIcon(MemorySegment mem) {
        return getIcon(mem, 0);
    }
    
    @Nullable
    public static String getIcon(MemorySegment mem, int offset) {
        return hasIcon(mem, offset) ? PacketIO.readVarString("Icon", mem, offset + getValidatedOffset(mem, offset, 9, 13, "Icon"), 4096000): null;
    }
    
    public static boolean hasKiller(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasDecedent(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasIcon(MemorySegment mem, int offset) {
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
    
    public static KillFeedMessage toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static KillFeedMessage toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one KillFeedMessage and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static KillFeedMessage toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 13;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        FormattedMessage v0 = null;
        if (hasKiller(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "Killer");
            v0 = FormattedMessage.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 1, -1, "Killer");
        }
        
        FormattedMessage v1 = null;
        if (hasDecedent(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Decedent");
            v1 = FormattedMessage.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "Decedent");
        }
        
        String v2 = null;
        if (hasIcon(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "Icon");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("Icon", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 9, -1, "Icon");
        }
        var result = new KillFeedMessage(
            v0,
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
        if (this.killer != null) nullBits |= 0x01;
        if (this.decedent != null) nullBits |= 0x02;
        if (this.icon != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 13;
        if (this.killer != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 13);
            varOffset += this.killer.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.decedent != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 13);
            varOffset += this.decedent.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.icon != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 13);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.icon, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 13;
        if (killer != null) size += killer.computeSize();
    if (decedent != null) size += decedent.computeSize();
    if (icon != null) size += PacketIO.stringSize(icon);

        return size;
    }

    public KillFeedMessage clone() {
        KillFeedMessage copy = new KillFeedMessage();
        copy.killer = this.killer != null ? this.killer.clone() : null;
        copy.decedent = this.decedent != null ? this.decedent.clone() : null;
        copy.icon = this.icon;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof KillFeedMessage other)) return false;
        return java.util.Objects.equals(this.killer, other.killer) && java.util.Objects.equals(this.decedent, other.decedent) && java.util.Objects.equals(this.icon, other.icon);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(killer, decedent, icon);
    }

}