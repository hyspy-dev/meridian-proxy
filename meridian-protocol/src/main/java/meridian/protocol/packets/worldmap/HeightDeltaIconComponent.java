// Auto-generated - do not edit
package meridian.protocol.packets.worldmap;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class HeightDeltaIconComponent extends MapMarkerComponent {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 17;
    public static final int MAX_SIZE = 32768027;

    public int upDelta;
    @Nullable public String upImage;
    public int downDelta;
    @Nullable public String downImage;

    public HeightDeltaIconComponent() {
    }

    public HeightDeltaIconComponent(int upDelta, @Nullable String upImage, int downDelta, @Nullable String downImage) {
        this.upDelta = upDelta;
        this.upImage = upImage;
        this.downDelta = downDelta;
        this.downImage = downImage;
    }

    public HeightDeltaIconComponent(@Nonnull HeightDeltaIconComponent other) {
        this.upDelta = other.upDelta;
        this.upImage = other.upImage;
        this.downDelta = other.downDelta;
        this.downImage = other.downImage;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("HeightDeltaIconComponent", offset, (int) mem.byteSize());
        long needed = (long) offset + 17;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("HeightDeltaIconComponent", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getUpDelta(MemorySegment mem) {
        return getUpDelta(mem, 0);
    }
    
    public static int getUpDelta(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static String getUpImage(MemorySegment mem) {
        return getUpImage(mem, 0);
    }
    
    @Nullable
    public static String getUpImage(MemorySegment mem, int offset) {
        return hasUpImage(mem, offset) ? PacketIO.readVarString("UpImage", mem, offset + getValidatedOffset(mem, offset, 9, 17, "UpImage"), 4096000): null;
    }
    
    public static int getDownDelta(MemorySegment mem) {
        return getDownDelta(mem, 0);
    }
    
    public static int getDownDelta(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    @Nullable
    public static String getDownImage(MemorySegment mem) {
        return getDownImage(mem, 0);
    }
    
    @Nullable
    public static String getDownImage(MemorySegment mem, int offset) {
        return hasDownImage(mem, offset) ? PacketIO.readVarString("DownImage", mem, offset + getValidatedOffset(mem, offset, 13, 17, "DownImage"), 4096000): null;
    }
    
    public static boolean hasUpImage(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasDownImage(MemorySegment mem, int offset) {
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
    
    public static HeightDeltaIconComponent toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static HeightDeltaIconComponent toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one HeightDeltaIconComponent and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static HeightDeltaIconComponent toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 17;
        var varPos = 0;
        String v1 = null;
        if (hasUpImage(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "UpImage");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("UpImage", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 9, -1, "UpImage");
        }
        
        String v3 = null;
        if (hasDownImage(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "DownImage");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readVarString("DownImage", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 13, -1, "DownImage");
        }
        var result = new HeightDeltaIconComponent(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v1,
            mem.get(PacketIO.PROTO_INT, offset + 5),
            v3
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.upImage != null) nullBits |= 0x01;
        if (this.downImage != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.upDelta);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.downDelta);
        var varOffset = offset + 17;
        if (this.upImage != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 17);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.upImage, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
        if (this.downImage != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 17);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.downImage, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 17;
        if (upImage != null) size += PacketIO.stringSize(upImage);
    if (downImage != null) size += PacketIO.stringSize(downImage);

        return size;
    }

    public HeightDeltaIconComponent clone() {
        HeightDeltaIconComponent copy = new HeightDeltaIconComponent();
        copy.upDelta = this.upDelta;
        copy.upImage = this.upImage;
        copy.downDelta = this.downDelta;
        copy.downImage = this.downImage;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof HeightDeltaIconComponent other)) return false;
        return this.upDelta == other.upDelta && java.util.Objects.equals(this.upImage, other.upImage) && this.downDelta == other.downDelta && java.util.Objects.equals(this.downImage, other.downImage);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(upDelta, upImage, downDelta, downImage);
    }

}