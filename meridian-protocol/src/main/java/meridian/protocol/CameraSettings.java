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
import org.joml.*;

public class CameraSettings {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 13;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 21;
    public static final int MAX_SIZE = 8192049;

    @Nullable public Vector3fc positionOffset;
    @Nullable public CameraAxis yaw;
    @Nullable public CameraAxis pitch;

    public CameraSettings() {
    }

    public CameraSettings(@Nullable Vector3fc positionOffset, @Nullable CameraAxis yaw, @Nullable CameraAxis pitch) {
        this.positionOffset = positionOffset;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public CameraSettings(@Nonnull CameraSettings other) {
        this.positionOffset = other.positionOffset;
        this.yaw = other.yaw;
        this.pitch = other.pitch;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CameraSettings", offset, (int) mem.byteSize());
        long needed = (long) offset + 21;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CameraSettings", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static Vector3fc getPositionOffset(MemorySegment mem) {
        return getPositionOffset(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getPositionOffset(MemorySegment mem, int offset) {
        return hasPositionOffset(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 1), "PositionOffset"): null;
    }
    
    @Nullable
    public static CameraAxis getYaw(MemorySegment mem) {
        return getYaw(mem, 0);
    }
    
    @Nullable
    public static CameraAxis getYaw(MemorySegment mem, int offset) {
        return hasYaw(mem, offset) ? CameraAxis.toObject(mem, offset + getValidatedOffset(mem, offset, 13, 21, "Yaw")): null;
    }
    
    @Nullable
    public static CameraAxis getPitch(MemorySegment mem) {
        return getPitch(mem, 0);
    }
    
    @Nullable
    public static CameraAxis getPitch(MemorySegment mem, int offset) {
        return hasPitch(mem, offset) ? CameraAxis.toObject(mem, offset + getValidatedOffset(mem, offset, 17, 21, "Pitch")): null;
    }
    
    public static boolean hasPositionOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasYaw(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasPitch(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
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
    
    public static CameraSettings toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CameraSettings toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CameraSettings and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CameraSettings toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 21;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        CameraAxis v1 = null;
        if (hasYaw(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "Yaw");
            v1 = CameraAxis.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 13, -1, "Yaw");
        }
        
        CameraAxis v2 = null;
        if (hasPitch(mem, offset)) {
            requireSlot(mem, offset + 17, varPos, "Pitch");
            v2 = CameraAxis.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 17, -1, "Pitch");
        }
        var result = new CameraSettings(
            hasPositionOffset(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 1), "PositionOffset") : null,
            v1,
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.positionOffset != null) nullBits |= 0x01;
        if (this.yaw != null) nullBits |= 0x02;
        if (this.pitch != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.positionOffset != null) {
            PacketIO.requireFinite(this.positionOffset, "PositionOffset"); PacketIO.writeVector3f(mem, offset + 1, this.positionOffset);
        } else {
            mem.asSlice(offset + 1, 12).fill((byte) 0); 
        }
        var varOffset = offset + 21;
        if (this.yaw != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 21);
            varOffset += this.yaw.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
        if (this.pitch != null) {
            mem.set(PacketIO.PROTO_INT, offset + 17, varOffset - offset - 21);
            varOffset += this.pitch.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 17, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 21;
        if (yaw != null) size += yaw.computeSize();
    if (pitch != null) size += pitch.computeSize();

        return size;
    }

    public CameraSettings clone() {
        CameraSettings copy = new CameraSettings();
        copy.positionOffset = this.positionOffset;
        copy.yaw = this.yaw != null ? this.yaw.clone() : null;
        copy.pitch = this.pitch != null ? this.pitch.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CameraSettings other)) return false;
        return java.util.Objects.equals(this.positionOffset, other.positionOffset) && java.util.Objects.equals(this.yaw, other.yaw) && java.util.Objects.equals(this.pitch, other.pitch);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(positionOffset, yaw, pitch);
    }

}