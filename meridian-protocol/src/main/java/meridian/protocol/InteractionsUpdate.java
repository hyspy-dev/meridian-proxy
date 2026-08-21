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
import java.util.HashMap;

public class InteractionsUpdate extends ComponentUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 10;
    public static final int MAX_SIZE = 36864020;

    @Nonnull public java.util.Map<InteractionType, Integer> interactions = new java.util.HashMap<>();
    @Nullable public String interactionHint;
    public boolean overrideAll;

    public InteractionsUpdate() {
    }

    public InteractionsUpdate(@Nonnull java.util.Map<InteractionType, Integer> interactions, @Nullable String interactionHint, boolean overrideAll) {
        this.interactions = interactions;
        this.interactionHint = interactionHint;
        this.overrideAll = overrideAll;
    }

    public InteractionsUpdate(@Nonnull InteractionsUpdate other) {
        this.interactions = other.interactions;
        this.interactionHint = other.interactionHint;
        this.overrideAll = other.overrideAll;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("InteractionsUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 10;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InteractionsUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static java.util.Map<InteractionType, Integer> getInteractions(MemorySegment mem) {
        return getInteractions(mem, 0);
    }
    
    public static java.util.Map<InteractionType, Integer> getInteractions(MemorySegment mem, int offset) {
        var off = offset + getValidatedOffset(mem, offset, 2, 10, "Interactions");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Interactions");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Interactions", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Interactions", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<InteractionType, Integer> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                off += 1;
            var value = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Interactions", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static String getInteractionHint(MemorySegment mem) {
        return getInteractionHint(mem, 0);
    }
    
    @Nullable
    public static String getInteractionHint(MemorySegment mem, int offset) {
        return hasInteractionHint(mem, offset) ? PacketIO.readVarString("InteractionHint", mem, offset + getValidatedOffset(mem, offset, 6, 10, "InteractionHint"), 4096000): null;
    }
    
    public static boolean getOverrideAll(MemorySegment mem) {
        return getOverrideAll(mem, 0);
    }
    
    public static boolean getOverrideAll(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 1);
    }
    
    public static boolean hasInteractionHint(MemorySegment mem, int offset) {
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
    
    public static InteractionsUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static InteractionsUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one InteractionsUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static InteractionsUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 10;
        var varPos = 0;
        java.util.Map<InteractionType, Integer> v0;
        requireSlot(mem, offset + 2, varPos, "Interactions");
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Interactions");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Interactions", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Interactions", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v0 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                    off += 1;
                var value = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                if (v0.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Interactions", key);
                }
            }
            varPos = off - varBase;
        }
        
        String v1 = null;
        if (hasInteractionHint(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "InteractionHint");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("InteractionHint", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 6, -1, "InteractionHint");
        }
        var result = new InteractionsUpdate(
            v0,
            v1,
            mem.get(PacketIO.PROTO_BOOL, offset + 1)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.interactionHint != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BOOL, offset + 1, this.overrideAll);
        var varOffset = offset + 10;
        mem.set(PacketIO.PROTO_INT, offset + 2, varOffset - offset - 10);
        if (this.interactions.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Interactions", interactions.size(), 4096000);
        varOffset += VarInt.set(mem, varOffset, this.interactions.size());
        for (var e : this.interactions.entrySet()) {
            mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
            varOffset += 1;
            mem.set(PacketIO.PROTO_INT, varOffset, e.getValue());
            varOffset += 4;
        }
        if (this.interactionHint != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 10);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.interactionHint, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 10;
        size += VarInt.size(interactions.size()) + interactions.size() * (1 + 4);
    if (interactionHint != null) size += PacketIO.stringSize(interactionHint);

        return size;
    }

    public InteractionsUpdate clone() {
        InteractionsUpdate copy = new InteractionsUpdate();
        copy.interactions = new java.util.HashMap<>(this.interactions);
        copy.interactionHint = this.interactionHint;
        copy.overrideAll = this.overrideAll;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InteractionsUpdate other)) return false;
        return java.util.Objects.equals(this.interactions, other.interactions) && java.util.Objects.equals(this.interactionHint, other.interactionHint) && this.overrideAll == other.overrideAll;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(interactions, interactionHint, overrideAll);
    }

}