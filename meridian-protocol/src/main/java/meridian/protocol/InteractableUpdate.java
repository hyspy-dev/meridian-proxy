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


public class InteractableUpdate extends ComponentUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 16384006;

    @Nullable public String interactionHint;

    public InteractableUpdate() {
    }

    public InteractableUpdate(@Nullable String interactionHint) {
        this.interactionHint = interactionHint;
    }

    public InteractableUpdate(@Nonnull InteractableUpdate other) {
        this.interactionHint = other.interactionHint;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("InteractableUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InteractableUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getInteractionHint(MemorySegment mem) {
        return getInteractionHint(mem, 0);
    }
    
    @Nullable
    public static String getInteractionHint(MemorySegment mem, int offset) {
        return hasInteractionHint(mem, offset) ? PacketIO.readVarString("InteractionHint", mem, offset + 1, 4096000): null;
    }
    
    public static boolean hasInteractionHint(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static InteractableUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static InteractableUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one InteractableUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static InteractableUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        String v0 = null;
        if (hasInteractionHint(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("InteractionHint", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new InteractableUpdate(
            v0
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
        
        
        var varOffset = offset + 1;
        if (this.interactionHint != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.interactionHint, 4096000);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 1;
        if (interactionHint != null) size += PacketIO.stringSize(interactionHint);

        return size;
    }

    public InteractableUpdate clone() {
        InteractableUpdate copy = new InteractableUpdate();
        copy.interactionHint = this.interactionHint;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InteractableUpdate other)) return false;
        return java.util.Objects.equals(this.interactionHint, other.interactionHint);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(interactionHint);
    }

}