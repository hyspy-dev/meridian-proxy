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
import meridian.protocol.ItemWithAllMetadata;

public class Notification implements Packet, ToClientPacket {
    public static final int PACKET_ID = 212;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 5;
    public static final int VARIABLE_BLOCK_START = 22;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public FormattedMessage message;
    @Nullable public FormattedMessage secondaryMessage;
    @Nullable public String icon;
    @Nullable public ItemWithAllMetadata item;
    @Nonnull public NotificationStyle style = NotificationStyle.Default;
    @Nullable public String tag;

    public Notification() {
    }

    public Notification(@Nullable FormattedMessage message, @Nullable FormattedMessage secondaryMessage, @Nullable String icon, @Nullable ItemWithAllMetadata item, @Nonnull NotificationStyle style, @Nullable String tag) {
        this.message = message;
        this.secondaryMessage = secondaryMessage;
        this.icon = icon;
        this.item = item;
        this.style = style;
        this.tag = tag;
    }

    public Notification(@Nonnull Notification other) {
        this.message = other.message;
        this.secondaryMessage = other.secondaryMessage;
        this.icon = other.icon;
        this.item = other.item;
        this.style = other.style;
        this.tag = other.tag;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Notification", offset, (int) mem.byteSize());
        long needed = (long) offset + 22;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Notification", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static FormattedMessage getMessage(MemorySegment mem) {
        return getMessage(mem, 0);
    }
    
    @Nullable
    public static FormattedMessage getMessage(MemorySegment mem, int offset) {
        return hasMessage(mem, offset) ? FormattedMessage.toObject(mem, offset + getValidatedOffset(mem, offset, 2, 22, "Message")): null;
    }
    
    @Nullable
    public static FormattedMessage getSecondaryMessage(MemorySegment mem) {
        return getSecondaryMessage(mem, 0);
    }
    
    @Nullable
    public static FormattedMessage getSecondaryMessage(MemorySegment mem, int offset) {
        return hasSecondaryMessage(mem, offset) ? FormattedMessage.toObject(mem, offset + getValidatedOffset(mem, offset, 6, 22, "SecondaryMessage")): null;
    }
    
    @Nullable
    public static String getIcon(MemorySegment mem) {
        return getIcon(mem, 0);
    }
    
    @Nullable
    public static String getIcon(MemorySegment mem, int offset) {
        return hasIcon(mem, offset) ? PacketIO.readVarString("Icon", mem, offset + getValidatedOffset(mem, offset, 10, 22, "Icon"), 4096000): null;
    }
    
    @Nullable
    public static ItemWithAllMetadata getItem(MemorySegment mem) {
        return getItem(mem, 0);
    }
    
    @Nullable
    public static ItemWithAllMetadata getItem(MemorySegment mem, int offset) {
        return hasItem(mem, offset) ? ItemWithAllMetadata.toObject(mem, offset + getValidatedOffset(mem, offset, 14, 22, "Item")): null;
    }
    
    public static NotificationStyle getStyle(MemorySegment mem) {
        return getStyle(mem, 0);
    }
    
    public static NotificationStyle getStyle(MemorySegment mem, int offset) {
        return NotificationStyle.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static String getTag(MemorySegment mem) {
        return getTag(mem, 0);
    }
    
    @Nullable
    public static String getTag(MemorySegment mem, int offset) {
        return hasTag(mem, offset) ? PacketIO.readVarString("Tag", mem, offset + getValidatedOffset(mem, offset, 18, 22, "Tag"), 4096000): null;
    }
    
    public static boolean hasMessage(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasSecondaryMessage(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasIcon(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasItem(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasTag(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
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
    
    public static Notification toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Notification toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Notification and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Notification toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 22;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        FormattedMessage v0 = null;
        if (hasMessage(mem, offset)) {
            requireSlot(mem, offset + 2, varPos, "Message");
            v0 = FormattedMessage.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 2, -1, "Message");
        }
        
        FormattedMessage v1 = null;
        if (hasSecondaryMessage(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "SecondaryMessage");
            v1 = FormattedMessage.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 6, -1, "SecondaryMessage");
        }
        
        String v2 = null;
        if (hasIcon(mem, offset)) {
            requireSlot(mem, offset + 10, varPos, "Icon");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("Icon", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 10, -1, "Icon");
        }
        
        ItemWithAllMetadata v3 = null;
        if (hasItem(mem, offset)) {
            requireSlot(mem, offset + 14, varPos, "Item");
            v3 = ItemWithAllMetadata.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 14, -1, "Item");
        }
        
        String v5 = null;
        if (hasTag(mem, offset)) {
            requireSlot(mem, offset + 18, varPos, "Tag");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v5 = PacketIO.readVarString("Tag", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 18, -1, "Tag");
        }
        var result = new Notification(
            v0,
            v1,
            v2,
            v3,
            NotificationStyle.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v5
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.message != null) nullBits |= 0x01;
        if (this.secondaryMessage != null) nullBits |= 0x02;
        if (this.icon != null) nullBits |= 0x04;
        if (this.item != null) nullBits |= 0x08;
        if (this.tag != null) nullBits |= 0x10;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.style.getValue());
        var varOffset = offset + 22;
        if (this.message != null) {
            mem.set(PacketIO.PROTO_INT, offset + 2, varOffset - offset - 22);
            varOffset += this.message.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 2, -1);
        }
        if (this.secondaryMessage != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 22);
            varOffset += this.secondaryMessage.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
        if (this.icon != null) {
            mem.set(PacketIO.PROTO_INT, offset + 10, varOffset - offset - 22);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.icon, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 10, -1);
        }
        if (this.item != null) {
            mem.set(PacketIO.PROTO_INT, offset + 14, varOffset - offset - 22);
            varOffset += this.item.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 14, -1);
        }
        if (this.tag != null) {
            mem.set(PacketIO.PROTO_INT, offset + 18, varOffset - offset - 22);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.tag, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 18, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 22;
        if (message != null) size += message.computeSize();
    if (secondaryMessage != null) size += secondaryMessage.computeSize();
    if (icon != null) size += PacketIO.stringSize(icon);
    if (item != null) size += item.computeSize();
    if (tag != null) size += PacketIO.stringSize(tag);

        return size;
    }

    public Notification clone() {
        Notification copy = new Notification();
        copy.message = this.message != null ? this.message.clone() : null;
        copy.secondaryMessage = this.secondaryMessage != null ? this.secondaryMessage.clone() : null;
        copy.icon = this.icon;
        copy.item = this.item != null ? this.item.clone() : null;
        copy.style = this.style;
        copy.tag = this.tag;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Notification other)) return false;
        return java.util.Objects.equals(this.message, other.message) && java.util.Objects.equals(this.secondaryMessage, other.secondaryMessage) && java.util.Objects.equals(this.icon, other.icon) && java.util.Objects.equals(this.item, other.item) && java.util.Objects.equals(this.style, other.style) && java.util.Objects.equals(this.tag, other.tag);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(message, secondaryMessage, icon, item, style, tag);
    }

}