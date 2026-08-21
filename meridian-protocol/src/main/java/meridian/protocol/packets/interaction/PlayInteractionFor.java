// Auto-generated - do not edit
package meridian.protocol.packets.interaction;

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
import meridian.protocol.ForkedChainId;
import meridian.protocol.InteractionType;

public class PlayInteractionFor implements Packet, ToClientPacket {
    public static final int PACKET_ID = 292;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 19;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 27;
    public static final int MAX_SIZE = 16385065;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int entityId;
    public int chainId;
    @Nullable public ForkedChainId forkedId;
    public int operationIndex;
    public int interactionId;
    @Nullable public String interactedItemId;
    @Nonnull public InteractionType interactionType = InteractionType.Primary;
    public boolean cancel;

    public PlayInteractionFor() {
    }

    public PlayInteractionFor(int entityId, int chainId, @Nullable ForkedChainId forkedId, int operationIndex, int interactionId, @Nullable String interactedItemId, @Nonnull InteractionType interactionType, boolean cancel) {
        this.entityId = entityId;
        this.chainId = chainId;
        this.forkedId = forkedId;
        this.operationIndex = operationIndex;
        this.interactionId = interactionId;
        this.interactedItemId = interactedItemId;
        this.interactionType = interactionType;
        this.cancel = cancel;
    }

    public PlayInteractionFor(@Nonnull PlayInteractionFor other) {
        this.entityId = other.entityId;
        this.chainId = other.chainId;
        this.forkedId = other.forkedId;
        this.operationIndex = other.operationIndex;
        this.interactionId = other.interactionId;
        this.interactedItemId = other.interactedItemId;
        this.interactionType = other.interactionType;
        this.cancel = other.cancel;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PlayInteractionFor", offset, (int) mem.byteSize());
        long needed = (long) offset + 27;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PlayInteractionFor", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getEntityId(MemorySegment mem) {
        return getEntityId(mem, 0);
    }
    
    public static int getEntityId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getChainId(MemorySegment mem) {
        return getChainId(mem, 0);
    }
    
    public static int getChainId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    @Nullable
    public static ForkedChainId getForkedId(MemorySegment mem) {
        return getForkedId(mem, 0);
    }
    
    @Nullable
    public static ForkedChainId getForkedId(MemorySegment mem, int offset) {
        return hasForkedId(mem, offset) ? ForkedChainId.toObject(mem, offset + getValidatedOffset(mem, offset, 19, 27, "ForkedId")): null;
    }
    
    public static int getOperationIndex(MemorySegment mem) {
        return getOperationIndex(mem, 0);
    }
    
    public static int getOperationIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 9);
    }
    
    public static int getInteractionId(MemorySegment mem) {
        return getInteractionId(mem, 0);
    }
    
    public static int getInteractionId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 13);
    }
    
    @Nullable
    public static String getInteractedItemId(MemorySegment mem) {
        return getInteractedItemId(mem, 0);
    }
    
    @Nullable
    public static String getInteractedItemId(MemorySegment mem, int offset) {
        return hasInteractedItemId(mem, offset) ? PacketIO.readVarString("InteractedItemId", mem, offset + getValidatedOffset(mem, offset, 23, 27, "InteractedItemId"), 4096000): null;
    }
    
    public static InteractionType getInteractionType(MemorySegment mem) {
        return getInteractionType(mem, 0);
    }
    
    public static InteractionType getInteractionType(MemorySegment mem, int offset) {
        return InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 17));
    }
    
    public static boolean getCancel(MemorySegment mem) {
        return getCancel(mem, 0);
    }
    
    public static boolean getCancel(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 18);
    }
    
    public static boolean hasForkedId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasInteractedItemId(MemorySegment mem, int offset) {
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
    
    public static PlayInteractionFor toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PlayInteractionFor toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PlayInteractionFor and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PlayInteractionFor toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 27;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ForkedChainId v2 = null;
        if (hasForkedId(mem, offset)) {
            requireSlot(mem, offset + 19, varPos, "ForkedId");
            v2 = ForkedChainId.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 19, -1, "ForkedId");
        }
        
        String v5 = null;
        if (hasInteractedItemId(mem, offset)) {
            requireSlot(mem, offset + 23, varPos, "InteractedItemId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v5 = PacketIO.readVarString("InteractedItemId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 23, -1, "InteractedItemId");
        }
        var result = new PlayInteractionFor(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            v2,
            mem.get(PacketIO.PROTO_INT, offset + 9),
            mem.get(PacketIO.PROTO_INT, offset + 13),
            v5,
            InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 17)),
            mem.get(PacketIO.PROTO_BOOL, offset + 18)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.forkedId != null) nullBits |= 0x01;
        if (this.interactedItemId != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.entityId);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.chainId);
        mem.set(PacketIO.PROTO_INT, offset + 9, this.operationIndex);
        mem.set(PacketIO.PROTO_INT, offset + 13, this.interactionId);
        mem.set(PacketIO.PROTO_BYTE, offset + 17, (byte) this.interactionType.getValue());
        mem.set(PacketIO.PROTO_BOOL, offset + 18, this.cancel);
        var varOffset = offset + 27;
        if (this.forkedId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 19, varOffset - offset - 27);
            varOffset += this.forkedId.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 19, -1);
        }
        if (this.interactedItemId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 23, varOffset - offset - 27);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.interactedItemId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 23, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 27;
        if (forkedId != null) size += forkedId.computeSize();
    if (interactedItemId != null) size += PacketIO.stringSize(interactedItemId);

        return size;
    }

    public PlayInteractionFor clone() {
        PlayInteractionFor copy = new PlayInteractionFor();
        copy.entityId = this.entityId;
        copy.chainId = this.chainId;
        copy.forkedId = this.forkedId != null ? this.forkedId.clone() : null;
        copy.operationIndex = this.operationIndex;
        copy.interactionId = this.interactionId;
        copy.interactedItemId = this.interactedItemId;
        copy.interactionType = this.interactionType;
        copy.cancel = this.cancel;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PlayInteractionFor other)) return false;
        return this.entityId == other.entityId && this.chainId == other.chainId && java.util.Objects.equals(this.forkedId, other.forkedId) && this.operationIndex == other.operationIndex && this.interactionId == other.interactionId && java.util.Objects.equals(this.interactedItemId, other.interactedItemId) && java.util.Objects.equals(this.interactionType, other.interactionType) && this.cancel == other.cancel;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(entityId, chainId, forkedId, operationIndex, interactionId, interactedItemId, interactionType, cancel);
    }

}