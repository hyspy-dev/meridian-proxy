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


public class InteractionCameraSettings {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 237568019;

    @Nullable public InteractionCamera[] firstPerson;
    @Nullable public InteractionCamera[] thirdPerson;

    public InteractionCameraSettings() {
    }

    public InteractionCameraSettings(@Nullable InteractionCamera[] firstPerson, @Nullable InteractionCamera[] thirdPerson) {
        this.firstPerson = firstPerson;
        this.thirdPerson = thirdPerson;
    }

    public InteractionCameraSettings(@Nonnull InteractionCameraSettings other) {
        this.firstPerson = other.firstPerson;
        this.thirdPerson = other.thirdPerson;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("InteractionCameraSettings", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InteractionCameraSettings", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static InteractionCamera[] getFirstPerson(MemorySegment mem) {
        return getFirstPerson(mem, 0);
    }
    
    @Nullable
    public static InteractionCamera[] getFirstPerson(MemorySegment mem, int offset) {
        if (!hasFirstPerson(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 1, 9, "FirstPerson");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("FirstPerson");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("FirstPerson", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 29 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FirstPerson", (int) java.lang.Math.min(off + lenOffset + (long) len * 29, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new InteractionCamera[len];
        for (var i = 0; i < len; i++) {
            data[i] = InteractionCamera.toObject(mem, off + i * 29);
        }
        return data;
    }
    
    @Nullable
    public static InteractionCamera[] getThirdPerson(MemorySegment mem) {
        return getThirdPerson(mem, 0);
    }
    
    @Nullable
    public static InteractionCamera[] getThirdPerson(MemorySegment mem, int offset) {
        if (!hasThirdPerson(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 5, 9, "ThirdPerson");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ThirdPerson");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("ThirdPerson", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 29 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ThirdPerson", (int) java.lang.Math.min(off + lenOffset + (long) len * 29, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new InteractionCamera[len];
        for (var i = 0; i < len; i++) {
            data[i] = InteractionCamera.toObject(mem, off + i * 29);
        }
        return data;
    }
    
    public static boolean hasFirstPerson(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasThirdPerson(MemorySegment mem, int offset) {
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
    
    public static InteractionCameraSettings toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static InteractionCameraSettings toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one InteractionCameraSettings and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static InteractionCameraSettings toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        InteractionCamera[] v0 = null;
        if (hasFirstPerson(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "FirstPerson");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("FirstPerson");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("FirstPerson", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 29 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FirstPerson", (int) java.lang.Math.min(off + lenOffset + (long) len * 29, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new InteractionCamera[len];
            for (var i = 0; i < len; i++) {
                v0[i] = InteractionCamera.toObject(mem, off + i * 29);
            }
            varPos = off + len * 29 - varBase;
        } else {
            requireSlot(mem, offset + 1, -1, "FirstPerson");
        }
        
        InteractionCamera[] v1 = null;
        if (hasThirdPerson(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "ThirdPerson");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ThirdPerson");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("ThirdPerson", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 29 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ThirdPerson", (int) java.lang.Math.min(off + lenOffset + (long) len * 29, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new InteractionCamera[len];
            for (var i = 0; i < len; i++) {
                v1[i] = InteractionCamera.toObject(mem, off + i * 29);
            }
            varPos = off + len * 29 - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "ThirdPerson");
        }
        var result = new InteractionCameraSettings(
            v0,
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.firstPerson != null) nullBits |= 0x01;
        if (this.thirdPerson != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 9;
        if (this.firstPerson != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 9);
            if (firstPerson.length > 4096000) throw ProtocolException.arrayTooLong("FirstPerson", firstPerson.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.firstPerson.length);
            
            var firstPersonValueOffset = 0;
            for (var i = 0; i < this.firstPerson.length; i++) {
                firstPersonValueOffset += this.firstPerson[i].serialize(mem, varOffset + firstPersonValueOffset);
            }
            varOffset += firstPersonValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.thirdPerson != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 9);
            if (thirdPerson.length > 4096000) throw ProtocolException.arrayTooLong("ThirdPerson", thirdPerson.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.thirdPerson.length);
            
            var thirdPersonValueOffset = 0;
            for (var i = 0; i < this.thirdPerson.length; i++) {
                thirdPersonValueOffset += this.thirdPerson[i].serialize(mem, varOffset + thirdPersonValueOffset);
            }
            varOffset += thirdPersonValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (firstPerson != null) size += VarInt.size(firstPerson.length) + firstPerson.length * 29;
    if (thirdPerson != null) size += VarInt.size(thirdPerson.length) + thirdPerson.length * 29;

        return size;
    }

    public InteractionCameraSettings clone() {
        InteractionCameraSettings copy = new InteractionCameraSettings();
        copy.firstPerson = this.firstPerson != null ? java.util.Arrays.stream(this.firstPerson).map(e -> e.clone()).toArray(InteractionCamera[]::new) : null;
        copy.thirdPerson = this.thirdPerson != null ? java.util.Arrays.stream(this.thirdPerson).map(e -> e.clone()).toArray(InteractionCamera[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InteractionCameraSettings other)) return false;
        return java.util.Arrays.equals(this.firstPerson, other.firstPerson) && java.util.Arrays.equals(this.thirdPerson, other.thirdPerson);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(firstPerson);
        result = 31 * result + java.util.Arrays.hashCode(thirdPerson);
        return result;
    }

}