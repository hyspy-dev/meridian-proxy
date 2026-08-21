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


public class BlockTextures {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 6;
    public static final int VARIABLE_BLOCK_START = 29;
    public static final int MAX_SIZE = 98304059;

    @Nullable public String top;
    @Nullable public String bottom;
    @Nullable public String front;
    @Nullable public String back;
    @Nullable public String left;
    @Nullable public String right;
    public float weight;

    public BlockTextures() {
    }

    public BlockTextures(@Nullable String top, @Nullable String bottom, @Nullable String front, @Nullable String back, @Nullable String left, @Nullable String right, float weight) {
        this.top = top;
        this.bottom = bottom;
        this.front = front;
        this.back = back;
        this.left = left;
        this.right = right;
        this.weight = weight;
    }

    public BlockTextures(@Nonnull BlockTextures other) {
        this.top = other.top;
        this.bottom = other.bottom;
        this.front = other.front;
        this.back = other.back;
        this.left = other.left;
        this.right = other.right;
        this.weight = other.weight;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BlockTextures", offset, (int) mem.byteSize());
        long needed = (long) offset + 29;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockTextures", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getTop(MemorySegment mem) {
        return getTop(mem, 0);
    }
    
    @Nullable
    public static String getTop(MemorySegment mem, int offset) {
        return hasTop(mem, offset) ? PacketIO.readVarString("Top", mem, offset + getValidatedOffset(mem, offset, 5, 29, "Top"), 4096000): null;
    }
    
    @Nullable
    public static String getBottom(MemorySegment mem) {
        return getBottom(mem, 0);
    }
    
    @Nullable
    public static String getBottom(MemorySegment mem, int offset) {
        return hasBottom(mem, offset) ? PacketIO.readVarString("Bottom", mem, offset + getValidatedOffset(mem, offset, 9, 29, "Bottom"), 4096000): null;
    }
    
    @Nullable
    public static String getFront(MemorySegment mem) {
        return getFront(mem, 0);
    }
    
    @Nullable
    public static String getFront(MemorySegment mem, int offset) {
        return hasFront(mem, offset) ? PacketIO.readVarString("Front", mem, offset + getValidatedOffset(mem, offset, 13, 29, "Front"), 4096000): null;
    }
    
    @Nullable
    public static String getBack(MemorySegment mem) {
        return getBack(mem, 0);
    }
    
    @Nullable
    public static String getBack(MemorySegment mem, int offset) {
        return hasBack(mem, offset) ? PacketIO.readVarString("Back", mem, offset + getValidatedOffset(mem, offset, 17, 29, "Back"), 4096000): null;
    }
    
    @Nullable
    public static String getLeft(MemorySegment mem) {
        return getLeft(mem, 0);
    }
    
    @Nullable
    public static String getLeft(MemorySegment mem, int offset) {
        return hasLeft(mem, offset) ? PacketIO.readVarString("Left", mem, offset + getValidatedOffset(mem, offset, 21, 29, "Left"), 4096000): null;
    }
    
    @Nullable
    public static String getRight(MemorySegment mem) {
        return getRight(mem, 0);
    }
    
    @Nullable
    public static String getRight(MemorySegment mem, int offset) {
        return hasRight(mem, offset) ? PacketIO.readVarString("Right", mem, offset + getValidatedOffset(mem, offset, 25, 29, "Right"), 4096000): null;
    }
    
    public static float getWeight(MemorySegment mem) {
        return getWeight(mem, 0);
    }
    
    public static float getWeight(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Weight");
    }
    
    public static boolean hasTop(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasBottom(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasFront(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasBack(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasLeft(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasRight(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
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
    
    public static BlockTextures toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BlockTextures toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BlockTextures and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BlockTextures toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 29;
        var varPos = 0;
        String v0 = null;
        if (hasTop(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Top");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Top", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 5, -1, "Top");
        }
        
        String v1 = null;
        if (hasBottom(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "Bottom");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Bottom", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 9, -1, "Bottom");
        }
        
        String v2 = null;
        if (hasFront(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "Front");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("Front", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 13, -1, "Front");
        }
        
        String v3 = null;
        if (hasBack(mem, offset)) {
            requireSlot(mem, offset + 17, varPos, "Back");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readVarString("Back", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 17, -1, "Back");
        }
        
        String v4 = null;
        if (hasLeft(mem, offset)) {
            requireSlot(mem, offset + 21, varPos, "Left");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v4 = PacketIO.readVarString("Left", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 21, -1, "Left");
        }
        
        String v5 = null;
        if (hasRight(mem, offset)) {
            requireSlot(mem, offset + 25, varPos, "Right");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v5 = PacketIO.readVarString("Right", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 25, -1, "Right");
        }
        var result = new BlockTextures(
            v0,
            v1,
            v2,
            v3,
            v4,
            v5,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Weight")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.top != null) nullBits |= 0x01;
        if (this.bottom != null) nullBits |= 0x02;
        if (this.front != null) nullBits |= 0x04;
        if (this.back != null) nullBits |= 0x08;
        if (this.left != null) nullBits |= 0x10;
        if (this.right != null) nullBits |= 0x20;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.weight, "Weight"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.weight);
        var varOffset = offset + 29;
        if (this.top != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 29);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.top, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.bottom != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 29);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.bottom, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
        if (this.front != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 29);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.front, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
        if (this.back != null) {
            mem.set(PacketIO.PROTO_INT, offset + 17, varOffset - offset - 29);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.back, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 17, -1);
        }
        if (this.left != null) {
            mem.set(PacketIO.PROTO_INT, offset + 21, varOffset - offset - 29);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.left, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 21, -1);
        }
        if (this.right != null) {
            mem.set(PacketIO.PROTO_INT, offset + 25, varOffset - offset - 29);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.right, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 25, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 29;
        if (top != null) size += PacketIO.stringSize(top);
    if (bottom != null) size += PacketIO.stringSize(bottom);
    if (front != null) size += PacketIO.stringSize(front);
    if (back != null) size += PacketIO.stringSize(back);
    if (left != null) size += PacketIO.stringSize(left);
    if (right != null) size += PacketIO.stringSize(right);

        return size;
    }

    public BlockTextures clone() {
        BlockTextures copy = new BlockTextures();
        copy.top = this.top;
        copy.bottom = this.bottom;
        copy.front = this.front;
        copy.back = this.back;
        copy.left = this.left;
        copy.right = this.right;
        copy.weight = this.weight;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BlockTextures other)) return false;
        return java.util.Objects.equals(this.top, other.top) && java.util.Objects.equals(this.bottom, other.bottom) && java.util.Objects.equals(this.front, other.front) && java.util.Objects.equals(this.back, other.back) && java.util.Objects.equals(this.left, other.left) && java.util.Objects.equals(this.right, other.right) && this.weight == other.weight;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(top, bottom, front, back, left, right, weight);
    }

}