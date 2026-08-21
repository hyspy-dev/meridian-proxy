// Auto-generated - do not edit
package meridian.protocol.packets.entities;

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
import meridian.protocol.AnimationSlot;

public class PlayAnimation implements Packet, ToClientPacket {
    public static final int PACKET_ID = 162;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 14;
    public static final int MAX_SIZE = 32768024;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int entityId;
    @Nullable public String itemAnimationsId;
    @Nullable public String animationId;
    @Nonnull public AnimationSlot slot = AnimationSlot.Movement;

    public PlayAnimation() {
    }

    public PlayAnimation(int entityId, @Nullable String itemAnimationsId, @Nullable String animationId, @Nonnull AnimationSlot slot) {
        this.entityId = entityId;
        this.itemAnimationsId = itemAnimationsId;
        this.animationId = animationId;
        this.slot = slot;
    }

    public PlayAnimation(@Nonnull PlayAnimation other) {
        this.entityId = other.entityId;
        this.itemAnimationsId = other.itemAnimationsId;
        this.animationId = other.animationId;
        this.slot = other.slot;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PlayAnimation", offset, (int) mem.byteSize());
        long needed = (long) offset + 14;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PlayAnimation", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getEntityId(MemorySegment mem) {
        return getEntityId(mem, 0);
    }
    
    public static int getEntityId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static String getItemAnimationsId(MemorySegment mem) {
        return getItemAnimationsId(mem, 0);
    }
    
    @Nullable
    public static String getItemAnimationsId(MemorySegment mem, int offset) {
        return hasItemAnimationsId(mem, offset) ? PacketIO.readVarString("ItemAnimationsId", mem, offset + getValidatedOffset(mem, offset, 6, 14, "ItemAnimationsId"), 4096000): null;
    }
    
    @Nullable
    public static String getAnimationId(MemorySegment mem) {
        return getAnimationId(mem, 0);
    }
    
    @Nullable
    public static String getAnimationId(MemorySegment mem, int offset) {
        return hasAnimationId(mem, offset) ? PacketIO.readVarString("AnimationId", mem, offset + getValidatedOffset(mem, offset, 10, 14, "AnimationId"), 4096000): null;
    }
    
    public static AnimationSlot getSlot(MemorySegment mem) {
        return getSlot(mem, 0);
    }
    
    public static AnimationSlot getSlot(MemorySegment mem, int offset) {
        return AnimationSlot.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 5));
    }
    
    public static boolean hasItemAnimationsId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasAnimationId(MemorySegment mem, int offset) {
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
    
    public static PlayAnimation toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PlayAnimation toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PlayAnimation and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PlayAnimation toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 14;
        var varPos = 0;
        String v1 = null;
        if (hasItemAnimationsId(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "ItemAnimationsId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("ItemAnimationsId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 6, -1, "ItemAnimationsId");
        }
        
        String v2 = null;
        if (hasAnimationId(mem, offset)) {
            requireSlot(mem, offset + 10, varPos, "AnimationId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("AnimationId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 10, -1, "AnimationId");
        }
        var result = new PlayAnimation(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v1,
            v2,
            AnimationSlot.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 5))
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.itemAnimationsId != null) nullBits |= 0x01;
        if (this.animationId != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.entityId);
        mem.set(PacketIO.PROTO_BYTE, offset + 5, (byte) this.slot.getValue());
        var varOffset = offset + 14;
        if (this.itemAnimationsId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 14);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.itemAnimationsId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
        if (this.animationId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 10, varOffset - offset - 14);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.animationId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 10, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 14;
        if (itemAnimationsId != null) size += PacketIO.stringSize(itemAnimationsId);
    if (animationId != null) size += PacketIO.stringSize(animationId);

        return size;
    }

    public PlayAnimation clone() {
        PlayAnimation copy = new PlayAnimation();
        copy.entityId = this.entityId;
        copy.itemAnimationsId = this.itemAnimationsId;
        copy.animationId = this.animationId;
        copy.slot = this.slot;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PlayAnimation other)) return false;
        return this.entityId == other.entityId && java.util.Objects.equals(this.itemAnimationsId, other.itemAnimationsId) && java.util.Objects.equals(this.animationId, other.animationId) && java.util.Objects.equals(this.slot, other.slot);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(entityId, itemAnimationsId, animationId, slot);
    }

}