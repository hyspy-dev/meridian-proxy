// Auto-generated - do not edit
package meridian.protocol;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class ProtocolEmote {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 4;
    public static final int VARIABLE_BLOCK_START = 18;
    public static final int MAX_SIZE = 65536038;

    @Nullable public String id;
    @Nullable public String name;
    @Nullable public String animation;
    @Nullable public String icon;
    public boolean isLooping;
    public boolean hideItemInHand;

    public ProtocolEmote() {
    }

    public ProtocolEmote(@Nullable String id, @Nullable String name, @Nullable String animation, @Nullable String icon, boolean isLooping, boolean hideItemInHand) {
        this.id = id;
        this.name = name;
        this.animation = animation;
        this.icon = icon;
        this.isLooping = isLooping;
        this.hideItemInHand = hideItemInHand;
    }

    public ProtocolEmote(@Nonnull ProtocolEmote other) {
        this.id = other.id;
        this.name = other.name;
        this.animation = other.animation;
        this.icon = other.icon;
        this.isLooping = other.isLooping;
        this.hideItemInHand = other.hideItemInHand;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ProtocolEmote", offset, (int) mem.byteSize());
        long needed = (long) offset + 18;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ProtocolEmote", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 2, 18, "Id"), 4096000): null;
    }
    
    @Nullable
    public static String getName(MemorySegment mem) {
        return getName(mem, 0);
    }
    
    @Nullable
    public static String getName(MemorySegment mem, int offset) {
        return hasName(mem, offset) ? PacketIO.readVarString("Name", mem, offset + getValidatedOffset(mem, offset, 6, 18, "Name"), 4096000): null;
    }
    
    @Nullable
    public static String getAnimation(MemorySegment mem) {
        return getAnimation(mem, 0);
    }
    
    @Nullable
    public static String getAnimation(MemorySegment mem, int offset) {
        return hasAnimation(mem, offset) ? PacketIO.readVarString("Animation", mem, offset + getValidatedOffset(mem, offset, 10, 18, "Animation"), 4096000): null;
    }
    
    @Nullable
    public static String getIcon(MemorySegment mem) {
        return getIcon(mem, 0);
    }
    
    @Nullable
    public static String getIcon(MemorySegment mem, int offset) {
        return hasIcon(mem, offset) ? PacketIO.readVarString("Icon", mem, offset + getValidatedOffset(mem, offset, 14, 18, "Icon"), 4096000): null;
    }
    
    public static boolean getIsLooping(MemorySegment mem) {
        return getIsLooping(mem, 0);
    }
    
    public static boolean getIsLooping(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x01) != 0;
    }
    
    public static boolean getHideItemInHand(MemorySegment mem) {
        return getHideItemInHand(mem, 0);
    }
    
    public static boolean getHideItemInHand(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x02) != 0;
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasAnimation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasIcon(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
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
    
    public static ProtocolEmote toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ProtocolEmote toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ProtocolEmote and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ProtocolEmote toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 18;
        var varPos = 0;
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 2, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 2, -1, "Id");
        }
        
        String v1 = null;
        if (hasName(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "Name");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Name", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 6, -1, "Name");
        }
        
        String v2 = null;
        if (hasAnimation(mem, offset)) {
            requireSlot(mem, offset + 10, varPos, "Animation");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("Animation", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 10, -1, "Animation");
        }
        
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
        var result = new ProtocolEmote(
            v0,
            v1,
            v2,
            v3,
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x02) != 0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        if (this.name != null) nullBits |= 0x02;
        if (this.animation != null) nullBits |= 0x04;
        if (this.icon != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        byte boolBits0_0 = 0;
        if (this.isLooping) boolBits0_0 |= 0x01;
        if (this.hideItemInHand) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 1 + 0, boolBits0_0);
        var varOffset = offset + 18;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 2, varOffset - offset - 18);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 2, -1);
        }
        if (this.name != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 18);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.name, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
        if (this.animation != null) {
            mem.set(PacketIO.PROTO_INT, offset + 10, varOffset - offset - 18);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.animation, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 10, -1);
        }
        if (this.icon != null) {
            mem.set(PacketIO.PROTO_INT, offset + 14, varOffset - offset - 18);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.icon, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 14, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 18;
        if (id != null) size += PacketIO.stringSize(id);
    if (name != null) size += PacketIO.stringSize(name);
    if (animation != null) size += PacketIO.stringSize(animation);
    if (icon != null) size += PacketIO.stringSize(icon);

        return size;
    }

    public ProtocolEmote clone() {
        ProtocolEmote copy = new ProtocolEmote();
        copy.id = this.id;
        copy.name = this.name;
        copy.animation = this.animation;
        copy.icon = this.icon;
        copy.isLooping = this.isLooping;
        copy.hideItemInHand = this.hideItemInHand;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ProtocolEmote other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.name, other.name) && java.util.Objects.equals(this.animation, other.animation) && java.util.Objects.equals(this.icon, other.icon) && this.isLooping == other.isLooping && this.hideItemInHand == other.hideItemInHand;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, name, animation, icon, isLooping, hideItemInHand);
    }

}