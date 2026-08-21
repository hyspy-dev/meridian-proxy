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

public class ShowEventTitle implements Packet, ToClientPacket {
    public static final int PACKET_ID = 214;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 14;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 26;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public float fadeInDuration;
    public float fadeOutDuration;
    public float duration;
    @Nullable public String icon;
    public boolean isMajor;
    @Nullable public FormattedMessage primaryTitle;
    @Nullable public FormattedMessage secondaryTitle;

    public ShowEventTitle() {
    }

    public ShowEventTitle(float fadeInDuration, float fadeOutDuration, float duration, @Nullable String icon, boolean isMajor, @Nullable FormattedMessage primaryTitle, @Nullable FormattedMessage secondaryTitle) {
        this.fadeInDuration = fadeInDuration;
        this.fadeOutDuration = fadeOutDuration;
        this.duration = duration;
        this.icon = icon;
        this.isMajor = isMajor;
        this.primaryTitle = primaryTitle;
        this.secondaryTitle = secondaryTitle;
    }

    public ShowEventTitle(@Nonnull ShowEventTitle other) {
        this.fadeInDuration = other.fadeInDuration;
        this.fadeOutDuration = other.fadeOutDuration;
        this.duration = other.duration;
        this.icon = other.icon;
        this.isMajor = other.isMajor;
        this.primaryTitle = other.primaryTitle;
        this.secondaryTitle = other.secondaryTitle;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ShowEventTitle", offset, (int) mem.byteSize());
        long needed = (long) offset + 26;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ShowEventTitle", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getFadeInDuration(MemorySegment mem) {
        return getFadeInDuration(mem, 0);
    }
    
    public static float getFadeInDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "FadeInDuration");
    }
    
    public static float getFadeOutDuration(MemorySegment mem) {
        return getFadeOutDuration(mem, 0);
    }
    
    public static float getFadeOutDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "FadeOutDuration");
    }
    
    public static float getDuration(MemorySegment mem) {
        return getDuration(mem, 0);
    }
    
    public static float getDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "Duration");
    }
    
    @Nullable
    public static String getIcon(MemorySegment mem) {
        return getIcon(mem, 0);
    }
    
    @Nullable
    public static String getIcon(MemorySegment mem, int offset) {
        return hasIcon(mem, offset) ? PacketIO.readVarString("Icon", mem, offset + getValidatedOffset(mem, offset, 14, 26, "Icon"), 4096000): null;
    }
    
    public static boolean getIsMajor(MemorySegment mem) {
        return getIsMajor(mem, 0);
    }
    
    public static boolean getIsMajor(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 13);
    }
    
    @Nullable
    public static FormattedMessage getPrimaryTitle(MemorySegment mem) {
        return getPrimaryTitle(mem, 0);
    }
    
    @Nullable
    public static FormattedMessage getPrimaryTitle(MemorySegment mem, int offset) {
        return hasPrimaryTitle(mem, offset) ? FormattedMessage.toObject(mem, offset + getValidatedOffset(mem, offset, 18, 26, "PrimaryTitle")): null;
    }
    
    @Nullable
    public static FormattedMessage getSecondaryTitle(MemorySegment mem) {
        return getSecondaryTitle(mem, 0);
    }
    
    @Nullable
    public static FormattedMessage getSecondaryTitle(MemorySegment mem, int offset) {
        return hasSecondaryTitle(mem, offset) ? FormattedMessage.toObject(mem, offset + getValidatedOffset(mem, offset, 22, 26, "SecondaryTitle")): null;
    }
    
    public static boolean hasIcon(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasPrimaryTitle(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasSecondaryTitle(MemorySegment mem, int offset) {
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
    
    public static ShowEventTitle toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ShowEventTitle toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ShowEventTitle and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ShowEventTitle toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 26;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v3 = null;
        if (hasIcon(mem, offset)) {
            requireSlot(mem, offset + 14, varPos, "Icon");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readVarString("Icon", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 14, -1, "Icon");
        }
        
        FormattedMessage v5 = null;
        if (hasPrimaryTitle(mem, offset)) {
            requireSlot(mem, offset + 18, varPos, "PrimaryTitle");
            v5 = FormattedMessage.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 18, -1, "PrimaryTitle");
        }
        
        FormattedMessage v6 = null;
        if (hasSecondaryTitle(mem, offset)) {
            requireSlot(mem, offset + 22, varPos, "SecondaryTitle");
            v6 = FormattedMessage.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 22, -1, "SecondaryTitle");
        }
        var result = new ShowEventTitle(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "FadeInDuration"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "FadeOutDuration"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "Duration"),
            v3,
            mem.get(PacketIO.PROTO_BOOL, offset + 13),
            v5,
            v6
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.icon != null) nullBits |= 0x01;
        if (this.primaryTitle != null) nullBits |= 0x02;
        if (this.secondaryTitle != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.fadeInDuration, "FadeInDuration"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.fadeInDuration);
        PacketIO.requireFinite(this.fadeOutDuration, "FadeOutDuration"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.fadeOutDuration);
        PacketIO.requireFinite(this.duration, "Duration"); mem.set(PacketIO.PROTO_FLOAT, offset + 9, this.duration);
        mem.set(PacketIO.PROTO_BOOL, offset + 13, this.isMajor);
        var varOffset = offset + 26;
        if (this.icon != null) {
            mem.set(PacketIO.PROTO_INT, offset + 14, varOffset - offset - 26);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.icon, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 14, -1);
        }
        if (this.primaryTitle != null) {
            mem.set(PacketIO.PROTO_INT, offset + 18, varOffset - offset - 26);
            varOffset += this.primaryTitle.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 18, -1);
        }
        if (this.secondaryTitle != null) {
            mem.set(PacketIO.PROTO_INT, offset + 22, varOffset - offset - 26);
            varOffset += this.secondaryTitle.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 22, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 26;
        if (icon != null) size += PacketIO.stringSize(icon);
    if (primaryTitle != null) size += primaryTitle.computeSize();
    if (secondaryTitle != null) size += secondaryTitle.computeSize();

        return size;
    }

    public ShowEventTitle clone() {
        ShowEventTitle copy = new ShowEventTitle();
        copy.fadeInDuration = this.fadeInDuration;
        copy.fadeOutDuration = this.fadeOutDuration;
        copy.duration = this.duration;
        copy.icon = this.icon;
        copy.isMajor = this.isMajor;
        copy.primaryTitle = this.primaryTitle != null ? this.primaryTitle.clone() : null;
        copy.secondaryTitle = this.secondaryTitle != null ? this.secondaryTitle.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ShowEventTitle other)) return false;
        return this.fadeInDuration == other.fadeInDuration && this.fadeOutDuration == other.fadeOutDuration && this.duration == other.duration && java.util.Objects.equals(this.icon, other.icon) && this.isMajor == other.isMajor && java.util.Objects.equals(this.primaryTitle, other.primaryTitle) && java.util.Objects.equals(this.secondaryTitle, other.secondaryTitle);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(fadeInDuration, fadeOutDuration, duration, icon, isMajor, primaryTitle, secondaryTitle);
    }

}