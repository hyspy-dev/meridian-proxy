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


public class RotationNoise {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 12;
    public static final int MAX_SIZE = 270336027;

    @Nonnull public NoiseConfig[] pitch = new NoiseConfig[0];
    @Nonnull public NoiseConfig[] yaw = new NoiseConfig[0];
    @Nonnull public NoiseConfig[] roll = new NoiseConfig[0];

    public RotationNoise() {
    }

    public RotationNoise(@Nonnull NoiseConfig[] pitch, @Nonnull NoiseConfig[] yaw, @Nonnull NoiseConfig[] roll) {
        this.pitch = pitch;
        this.yaw = yaw;
        this.roll = roll;
    }

    public RotationNoise(@Nonnull RotationNoise other) {
        this.pitch = other.pitch;
        this.yaw = other.yaw;
        this.roll = other.roll;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("RotationNoise", offset, (int) mem.byteSize());
        long needed = (long) offset + 12;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("RotationNoise", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static NoiseConfig[] getPitch(MemorySegment mem) {
        return getPitch(mem, 0);
    }
    
    public static NoiseConfig[] getPitch(MemorySegment mem, int offset) {
        var off = offset + getValidatedOffset(mem, offset, 0, 12, "Pitch");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Pitch");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Pitch", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 22 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Pitch", (int) java.lang.Math.min(off + lenOffset + (long) len * 22, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new NoiseConfig[len];
        for (var i = 0; i < len; i++) {
            data[i] = NoiseConfig.toObject(mem, off + i * 22);
        }
        return data;
    }
    
    public static NoiseConfig[] getYaw(MemorySegment mem) {
        return getYaw(mem, 0);
    }
    
    public static NoiseConfig[] getYaw(MemorySegment mem, int offset) {
        var off = offset + getValidatedOffset(mem, offset, 4, 12, "Yaw");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Yaw");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Yaw", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 22 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Yaw", (int) java.lang.Math.min(off + lenOffset + (long) len * 22, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new NoiseConfig[len];
        for (var i = 0; i < len; i++) {
            data[i] = NoiseConfig.toObject(mem, off + i * 22);
        }
        return data;
    }
    
    public static NoiseConfig[] getRoll(MemorySegment mem) {
        return getRoll(mem, 0);
    }
    
    public static NoiseConfig[] getRoll(MemorySegment mem, int offset) {
        var off = offset + getValidatedOffset(mem, offset, 8, 12, "Roll");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Roll");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Roll", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 22 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Roll", (int) java.lang.Math.min(off + lenOffset + (long) len * 22, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new NoiseConfig[len];
        for (var i = 0; i < len; i++) {
            data[i] = NoiseConfig.toObject(mem, off + i * 22);
        }
        return data;
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
    
    public static RotationNoise toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static RotationNoise toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one RotationNoise and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static RotationNoise toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 12;
        var varPos = 0;
        NoiseConfig[] v0;
        requireSlot(mem, offset + 0, varPos, "Pitch");
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Pitch");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Pitch", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 22 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Pitch", (int) java.lang.Math.min(off + lenOffset + (long) len * 22, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new NoiseConfig[len];
            for (var i = 0; i < len; i++) {
                v0[i] = NoiseConfig.toObject(mem, off + i * 22);
            }
            varPos = off + len * 22 - varBase;
        }
        
        NoiseConfig[] v1;
        requireSlot(mem, offset + 4, varPos, "Yaw");
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Yaw");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Yaw", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 22 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Yaw", (int) java.lang.Math.min(off + lenOffset + (long) len * 22, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new NoiseConfig[len];
            for (var i = 0; i < len; i++) {
                v1[i] = NoiseConfig.toObject(mem, off + i * 22);
            }
            varPos = off + len * 22 - varBase;
        }
        
        NoiseConfig[] v2;
        requireSlot(mem, offset + 8, varPos, "Roll");
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Roll");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Roll", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 22 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Roll", (int) java.lang.Math.min(off + lenOffset + (long) len * 22, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new NoiseConfig[len];
            for (var i = 0; i < len; i++) {
                v2[i] = NoiseConfig.toObject(mem, off + i * 22);
            }
            varPos = off + len * 22 - varBase;
        }
        var result = new RotationNoise(
            v0,
            v1,
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 12;
        mem.set(PacketIO.PROTO_INT, offset + 0, varOffset - offset - 12);
        if (pitch.length > 4096000) throw ProtocolException.arrayTooLong("Pitch", pitch.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.pitch.length);
        
        var pitchValueOffset = 0;
        for (var i = 0; i < this.pitch.length; i++) {
            pitchValueOffset += this.pitch[i].serialize(mem, varOffset + pitchValueOffset);
        }
        varOffset += pitchValueOffset;
        mem.set(PacketIO.PROTO_INT, offset + 4, varOffset - offset - 12);
        if (yaw.length > 4096000) throw ProtocolException.arrayTooLong("Yaw", yaw.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.yaw.length);
        
        var yawValueOffset = 0;
        for (var i = 0; i < this.yaw.length; i++) {
            yawValueOffset += this.yaw[i].serialize(mem, varOffset + yawValueOffset);
        }
        varOffset += yawValueOffset;
        mem.set(PacketIO.PROTO_INT, offset + 8, varOffset - offset - 12);
        if (roll.length > 4096000) throw ProtocolException.arrayTooLong("Roll", roll.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.roll.length);
        
        var rollValueOffset = 0;
        for (var i = 0; i < this.roll.length; i++) {
            rollValueOffset += this.roll[i].serialize(mem, varOffset + rollValueOffset);
        }
        varOffset += rollValueOffset;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 12;
        size += VarInt.size(pitch.length) + pitch.length * 22;
    size += VarInt.size(yaw.length) + yaw.length * 22;
    size += VarInt.size(roll.length) + roll.length * 22;

        return size;
    }

    public RotationNoise clone() {
        RotationNoise copy = new RotationNoise();
        copy.pitch = java.util.Arrays.stream(this.pitch).map(e -> e.clone()).toArray(NoiseConfig[]::new);
        copy.yaw = java.util.Arrays.stream(this.yaw).map(e -> e.clone()).toArray(NoiseConfig[]::new);
        copy.roll = java.util.Arrays.stream(this.roll).map(e -> e.clone()).toArray(NoiseConfig[]::new);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RotationNoise other)) return false;
        return java.util.Arrays.equals(this.pitch, other.pitch) && java.util.Arrays.equals(this.yaw, other.yaw) && java.util.Arrays.equals(this.roll, other.roll);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(pitch);
        result = 31 * result + java.util.Arrays.hashCode(yaw);
        result = 31 * result + java.util.Arrays.hashCode(roll);
        return result;
    }

}