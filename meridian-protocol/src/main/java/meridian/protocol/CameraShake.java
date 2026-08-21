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


public class CameraShake {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 8;
    public static final int MAX_SIZE = 1081344170;

    @Nonnull public CameraShakeConfig firstPerson = new CameraShakeConfig();
    @Nonnull public CameraShakeConfig thirdPerson = new CameraShakeConfig();

    public CameraShake() {
    }

    public CameraShake(@Nonnull CameraShakeConfig firstPerson, @Nonnull CameraShakeConfig thirdPerson) {
        this.firstPerson = firstPerson;
        this.thirdPerson = thirdPerson;
    }

    public CameraShake(@Nonnull CameraShake other) {
        this.firstPerson = other.firstPerson;
        this.thirdPerson = other.thirdPerson;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CameraShake", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CameraShake", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static CameraShakeConfig getFirstPerson(MemorySegment mem) {
        return getFirstPerson(mem, 0);
    }
    
    public static CameraShakeConfig getFirstPerson(MemorySegment mem, int offset) {
        return CameraShakeConfig.toObject(mem, offset + getValidatedOffset(mem, offset, 0, 8, "FirstPerson"));
    }
    
    public static CameraShakeConfig getThirdPerson(MemorySegment mem) {
        return getThirdPerson(mem, 0);
    }
    
    public static CameraShakeConfig getThirdPerson(MemorySegment mem, int offset) {
        return CameraShakeConfig.toObject(mem, offset + getValidatedOffset(mem, offset, 4, 8, "ThirdPerson"));
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
    
    public static CameraShake toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CameraShake toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CameraShake and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CameraShake toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 8;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        CameraShakeConfig v0;
        requireSlot(mem, offset + 0, varPos, "FirstPerson");
        {
            v0 = CameraShakeConfig.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        
        CameraShakeConfig v1;
        requireSlot(mem, offset + 4, varPos, "ThirdPerson");
        {
            v1 = CameraShakeConfig.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new CameraShake(
            v0,
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 8;
        mem.set(PacketIO.PROTO_INT, offset + 0, varOffset - offset - 8);
        varOffset += this.firstPerson.serialize(mem, varOffset);
        mem.set(PacketIO.PROTO_INT, offset + 4, varOffset - offset - 8);
        varOffset += this.thirdPerson.serialize(mem, varOffset);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 8;
        size += firstPerson.computeSize();
    size += thirdPerson.computeSize();

        return size;
    }

    public CameraShake clone() {
        CameraShake copy = new CameraShake();
        copy.firstPerson = this.firstPerson.clone();
        copy.thirdPerson = this.thirdPerson.clone();
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CameraShake other)) return false;
        return java.util.Objects.equals(this.firstPerson, other.firstPerson) && java.util.Objects.equals(this.thirdPerson, other.thirdPerson);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(firstPerson, thirdPerson);
    }

}