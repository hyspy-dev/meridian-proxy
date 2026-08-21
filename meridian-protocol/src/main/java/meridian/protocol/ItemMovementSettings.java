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


public class ItemMovementSettings {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 16384014;

    public int extraJumpCount;
    @Nullable public String extraJumpParticleSystem;
    public int extraJumpSoundEventIndex;

    public ItemMovementSettings() {
    }

    public ItemMovementSettings(int extraJumpCount, @Nullable String extraJumpParticleSystem, int extraJumpSoundEventIndex) {
        this.extraJumpCount = extraJumpCount;
        this.extraJumpParticleSystem = extraJumpParticleSystem;
        this.extraJumpSoundEventIndex = extraJumpSoundEventIndex;
    }

    public ItemMovementSettings(@Nonnull ItemMovementSettings other) {
        this.extraJumpCount = other.extraJumpCount;
        this.extraJumpParticleSystem = other.extraJumpParticleSystem;
        this.extraJumpSoundEventIndex = other.extraJumpSoundEventIndex;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemMovementSettings", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemMovementSettings", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getExtraJumpCount(MemorySegment mem) {
        return getExtraJumpCount(mem, 0);
    }
    
    public static int getExtraJumpCount(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static String getExtraJumpParticleSystem(MemorySegment mem) {
        return getExtraJumpParticleSystem(mem, 0);
    }
    
    @Nullable
    public static String getExtraJumpParticleSystem(MemorySegment mem, int offset) {
        return hasExtraJumpParticleSystem(mem, offset) ? PacketIO.readVarString("ExtraJumpParticleSystem", mem, offset + 9, 4096000): null;
    }
    
    public static int getExtraJumpSoundEventIndex(MemorySegment mem) {
        return getExtraJumpSoundEventIndex(mem, 0);
    }
    
    public static int getExtraJumpSoundEventIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static boolean hasExtraJumpParticleSystem(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static ItemMovementSettings toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemMovementSettings toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemMovementSettings and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemMovementSettings toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        String v1 = null;
        if (hasExtraJumpParticleSystem(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("ExtraJumpParticleSystem", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new ItemMovementSettings(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v1,
            mem.get(PacketIO.PROTO_INT, offset + 5)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.extraJumpParticleSystem != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.extraJumpCount);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.extraJumpSoundEventIndex);
        var varOffset = offset + 9;
        if (this.extraJumpParticleSystem != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.extraJumpParticleSystem, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (extraJumpParticleSystem != null) size += PacketIO.stringSize(extraJumpParticleSystem);

        return size;
    }

    public ItemMovementSettings clone() {
        ItemMovementSettings copy = new ItemMovementSettings();
        copy.extraJumpCount = this.extraJumpCount;
        copy.extraJumpParticleSystem = this.extraJumpParticleSystem;
        copy.extraJumpSoundEventIndex = this.extraJumpSoundEventIndex;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemMovementSettings other)) return false;
        return this.extraJumpCount == other.extraJumpCount && java.util.Objects.equals(this.extraJumpParticleSystem, other.extraJumpParticleSystem) && this.extraJumpSoundEventIndex == other.extraJumpSoundEventIndex;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(extraJumpCount, extraJumpParticleSystem, extraJumpSoundEventIndex);
    }

}