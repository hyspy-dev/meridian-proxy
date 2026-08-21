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


public class Animation {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 22;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 30;
    public static final int MAX_SIZE = 32768040;

    @Nullable public String name;
    public float speed;
    public float blendingDuration = 0.2f;
    public boolean looping;
    public float weight;
    @Nonnull public int[] footstepIntervals = new int[0];
    public int soundEventIndex;
    public int passiveLoopCount;

    public Animation() {
    }

    public Animation(@Nullable String name, float speed, float blendingDuration, boolean looping, float weight, @Nonnull int[] footstepIntervals, int soundEventIndex, int passiveLoopCount) {
        this.name = name;
        this.speed = speed;
        this.blendingDuration = blendingDuration;
        this.looping = looping;
        this.weight = weight;
        this.footstepIntervals = footstepIntervals;
        this.soundEventIndex = soundEventIndex;
        this.passiveLoopCount = passiveLoopCount;
    }

    public Animation(@Nonnull Animation other) {
        this.name = other.name;
        this.speed = other.speed;
        this.blendingDuration = other.blendingDuration;
        this.looping = other.looping;
        this.weight = other.weight;
        this.footstepIntervals = other.footstepIntervals;
        this.soundEventIndex = other.soundEventIndex;
        this.passiveLoopCount = other.passiveLoopCount;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Animation", offset, (int) mem.byteSize());
        long needed = (long) offset + 30;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Animation", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getName(MemorySegment mem) {
        return getName(mem, 0);
    }
    
    @Nullable
    public static String getName(MemorySegment mem, int offset) {
        return hasName(mem, offset) ? PacketIO.readVarString("Name", mem, offset + getValidatedOffset(mem, offset, 22, 30, "Name"), 4096000): null;
    }
    
    public static float getSpeed(MemorySegment mem) {
        return getSpeed(mem, 0);
    }
    
    public static float getSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Speed");
    }
    
    public static float getBlendingDuration(MemorySegment mem) {
        return getBlendingDuration(mem, 0);
    }
    
    public static float getBlendingDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "BlendingDuration");
    }
    
    public static boolean getLooping(MemorySegment mem) {
        return getLooping(mem, 0);
    }
    
    public static boolean getLooping(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 9);
    }
    
    public static float getWeight(MemorySegment mem) {
        return getWeight(mem, 0);
    }
    
    public static float getWeight(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 10), "Weight");
    }
    
    public static int[] getFootstepIntervals(MemorySegment mem) {
        return getFootstepIntervals(mem, 0);
    }
    
    public static int[] getFootstepIntervals(MemorySegment mem, int offset) {
        var off = offset + getValidatedOffset(mem, offset, 26, 30, "FootstepIntervals");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("FootstepIntervals");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("FootstepIntervals", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FootstepIntervals", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    public static int getSoundEventIndex(MemorySegment mem) {
        return getSoundEventIndex(mem, 0);
    }
    
    public static int getSoundEventIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 14);
    }
    
    public static int getPassiveLoopCount(MemorySegment mem) {
        return getPassiveLoopCount(mem, 0);
    }
    
    public static int getPassiveLoopCount(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 18);
    }
    
    public static boolean hasName(MemorySegment mem, int offset) {
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
    
    public static Animation toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Animation toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Animation and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Animation toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 30;
        var varPos = 0;
        String v0 = null;
        if (hasName(mem, offset)) {
            requireSlot(mem, offset + 22, varPos, "Name");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Name", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 22, -1, "Name");
        }
        
        int[] v5;
        requireSlot(mem, offset + 26, varPos, "FootstepIntervals");
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("FootstepIntervals");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("FootstepIntervals", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FootstepIntervals", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v5 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v5, 0, len);
            varPos = off + len * 4 - varBase;
        }
        var result = new Animation(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Speed"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "BlendingDuration"),
            mem.get(PacketIO.PROTO_BOOL, offset + 9),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 10), "Weight"),
            v5,
            mem.get(PacketIO.PROTO_INT, offset + 14),
            mem.get(PacketIO.PROTO_INT, offset + 18)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.name != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.speed, "Speed"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.speed);
        PacketIO.requireFinite(this.blendingDuration, "BlendingDuration"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.blendingDuration);
        mem.set(PacketIO.PROTO_BOOL, offset + 9, this.looping);
        PacketIO.requireFinite(this.weight, "Weight"); mem.set(PacketIO.PROTO_FLOAT, offset + 10, this.weight);
        mem.set(PacketIO.PROTO_INT, offset + 14, this.soundEventIndex);
        mem.set(PacketIO.PROTO_INT, offset + 18, this.passiveLoopCount);
        var varOffset = offset + 30;
        if (this.name != null) {
            mem.set(PacketIO.PROTO_INT, offset + 22, varOffset - offset - 30);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.name, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 22, -1);
        }
        mem.set(PacketIO.PROTO_INT, offset + 26, varOffset - offset - 30);
        if (footstepIntervals.length > 4096000) throw ProtocolException.arrayTooLong("FootstepIntervals", footstepIntervals.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.footstepIntervals.length);
        
        MemorySegment.copy(this.footstepIntervals, 0, mem, PacketIO.PROTO_INT, varOffset, this.footstepIntervals.length);
        varOffset += this.footstepIntervals.length * 4;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 30;
        if (name != null) size += PacketIO.stringSize(name);
    size += VarInt.size(footstepIntervals.length) + footstepIntervals.length * 4;

        return size;
    }

    public Animation clone() {
        Animation copy = new Animation();
        copy.name = this.name;
        copy.speed = this.speed;
        copy.blendingDuration = this.blendingDuration;
        copy.looping = this.looping;
        copy.weight = this.weight;
        copy.footstepIntervals = java.util.Arrays.copyOf(this.footstepIntervals, this.footstepIntervals.length);
        copy.soundEventIndex = this.soundEventIndex;
        copy.passiveLoopCount = this.passiveLoopCount;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Animation other)) return false;
        return java.util.Objects.equals(this.name, other.name) && this.speed == other.speed && this.blendingDuration == other.blendingDuration && this.looping == other.looping && this.weight == other.weight && java.util.Arrays.equals(this.footstepIntervals, other.footstepIntervals) && this.soundEventIndex == other.soundEventIndex && this.passiveLoopCount == other.passiveLoopCount;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(name);
        result = 31 * result + Float.hashCode(speed);
        result = 31 * result + Float.hashCode(blendingDuration);
        result = 31 * result + Boolean.hashCode(looping);
        result = 31 * result + Float.hashCode(weight);
        result = 31 * result + java.util.Arrays.hashCode(footstepIntervals);
        result = 31 * result + Integer.hashCode(soundEventIndex);
        result = 31 * result + Integer.hashCode(passiveLoopCount);
        return result;
    }

}