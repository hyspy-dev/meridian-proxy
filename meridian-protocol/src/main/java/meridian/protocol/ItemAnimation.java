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


public class ItemAnimation {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 11;
    public static final int VARIABLE_FIELD_COUNT = 5;
    public static final int VARIABLE_BLOCK_START = 31;
    public static final int MAX_SIZE = 81920056;

    @Nullable public String thirdPerson;
    @Nullable public String thirdPersonMoving;
    @Nullable public String thirdPersonFace;
    @Nullable public String firstPerson;
    @Nullable public String firstPersonOverride;
    public boolean keepPreviousFirstPersonAnimation;
    public float speed;
    public float blendingDuration = 0.2f;
    public boolean looping;
    public boolean clipsGeometry;

    public ItemAnimation() {
    }

    public ItemAnimation(@Nullable String thirdPerson, @Nullable String thirdPersonMoving, @Nullable String thirdPersonFace, @Nullable String firstPerson, @Nullable String firstPersonOverride, boolean keepPreviousFirstPersonAnimation, float speed, float blendingDuration, boolean looping, boolean clipsGeometry) {
        this.thirdPerson = thirdPerson;
        this.thirdPersonMoving = thirdPersonMoving;
        this.thirdPersonFace = thirdPersonFace;
        this.firstPerson = firstPerson;
        this.firstPersonOverride = firstPersonOverride;
        this.keepPreviousFirstPersonAnimation = keepPreviousFirstPersonAnimation;
        this.speed = speed;
        this.blendingDuration = blendingDuration;
        this.looping = looping;
        this.clipsGeometry = clipsGeometry;
    }

    public ItemAnimation(@Nonnull ItemAnimation other) {
        this.thirdPerson = other.thirdPerson;
        this.thirdPersonMoving = other.thirdPersonMoving;
        this.thirdPersonFace = other.thirdPersonFace;
        this.firstPerson = other.firstPerson;
        this.firstPersonOverride = other.firstPersonOverride;
        this.keepPreviousFirstPersonAnimation = other.keepPreviousFirstPersonAnimation;
        this.speed = other.speed;
        this.blendingDuration = other.blendingDuration;
        this.looping = other.looping;
        this.clipsGeometry = other.clipsGeometry;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemAnimation", offset, (int) mem.byteSize());
        long needed = (long) offset + 31;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemAnimation", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getThirdPerson(MemorySegment mem) {
        return getThirdPerson(mem, 0);
    }
    
    @Nullable
    public static String getThirdPerson(MemorySegment mem, int offset) {
        return hasThirdPerson(mem, offset) ? PacketIO.readVarString("ThirdPerson", mem, offset + getValidatedOffset(mem, offset, 11, 31, "ThirdPerson"), 4096000): null;
    }
    
    @Nullable
    public static String getThirdPersonMoving(MemorySegment mem) {
        return getThirdPersonMoving(mem, 0);
    }
    
    @Nullable
    public static String getThirdPersonMoving(MemorySegment mem, int offset) {
        return hasThirdPersonMoving(mem, offset) ? PacketIO.readVarString("ThirdPersonMoving", mem, offset + getValidatedOffset(mem, offset, 15, 31, "ThirdPersonMoving"), 4096000): null;
    }
    
    @Nullable
    public static String getThirdPersonFace(MemorySegment mem) {
        return getThirdPersonFace(mem, 0);
    }
    
    @Nullable
    public static String getThirdPersonFace(MemorySegment mem, int offset) {
        return hasThirdPersonFace(mem, offset) ? PacketIO.readVarString("ThirdPersonFace", mem, offset + getValidatedOffset(mem, offset, 19, 31, "ThirdPersonFace"), 4096000): null;
    }
    
    @Nullable
    public static String getFirstPerson(MemorySegment mem) {
        return getFirstPerson(mem, 0);
    }
    
    @Nullable
    public static String getFirstPerson(MemorySegment mem, int offset) {
        return hasFirstPerson(mem, offset) ? PacketIO.readVarString("FirstPerson", mem, offset + getValidatedOffset(mem, offset, 23, 31, "FirstPerson"), 4096000): null;
    }
    
    @Nullable
    public static String getFirstPersonOverride(MemorySegment mem) {
        return getFirstPersonOverride(mem, 0);
    }
    
    @Nullable
    public static String getFirstPersonOverride(MemorySegment mem, int offset) {
        return hasFirstPersonOverride(mem, offset) ? PacketIO.readVarString("FirstPersonOverride", mem, offset + getValidatedOffset(mem, offset, 27, 31, "FirstPersonOverride"), 4096000): null;
    }
    
    public static boolean getKeepPreviousFirstPersonAnimation(MemorySegment mem) {
        return getKeepPreviousFirstPersonAnimation(mem, 0);
    }
    
    public static boolean getKeepPreviousFirstPersonAnimation(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 1);
    }
    
    public static float getSpeed(MemorySegment mem) {
        return getSpeed(mem, 0);
    }
    
    public static float getSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "Speed");
    }
    
    public static float getBlendingDuration(MemorySegment mem) {
        return getBlendingDuration(mem, 0);
    }
    
    public static float getBlendingDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 6), "BlendingDuration");
    }
    
    public static boolean getLooping(MemorySegment mem) {
        return getLooping(mem, 0);
    }
    
    public static boolean getLooping(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 10) & 0x01) != 0;
    }
    
    public static boolean getClipsGeometry(MemorySegment mem) {
        return getClipsGeometry(mem, 0);
    }
    
    public static boolean getClipsGeometry(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 10) & 0x02) != 0;
    }
    
    public static boolean hasThirdPerson(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasThirdPersonMoving(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasThirdPersonFace(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasFirstPerson(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasFirstPersonOverride(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
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
    
    public static ItemAnimation toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemAnimation toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemAnimation and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemAnimation toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 31;
        var varPos = 0;
        String v0 = null;
        if (hasThirdPerson(mem, offset)) {
            requireSlot(mem, offset + 11, varPos, "ThirdPerson");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("ThirdPerson", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 11, -1, "ThirdPerson");
        }
        
        String v1 = null;
        if (hasThirdPersonMoving(mem, offset)) {
            requireSlot(mem, offset + 15, varPos, "ThirdPersonMoving");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("ThirdPersonMoving", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 15, -1, "ThirdPersonMoving");
        }
        
        String v2 = null;
        if (hasThirdPersonFace(mem, offset)) {
            requireSlot(mem, offset + 19, varPos, "ThirdPersonFace");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("ThirdPersonFace", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 19, -1, "ThirdPersonFace");
        }
        
        String v3 = null;
        if (hasFirstPerson(mem, offset)) {
            requireSlot(mem, offset + 23, varPos, "FirstPerson");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readVarString("FirstPerson", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 23, -1, "FirstPerson");
        }
        
        String v4 = null;
        if (hasFirstPersonOverride(mem, offset)) {
            requireSlot(mem, offset + 27, varPos, "FirstPersonOverride");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v4 = PacketIO.readVarString("FirstPersonOverride", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 27, -1, "FirstPersonOverride");
        }
        var result = new ItemAnimation(
            v0,
            v1,
            v2,
            v3,
            v4,
            mem.get(PacketIO.PROTO_BOOL, offset + 1),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "Speed"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 6), "BlendingDuration"),
            (mem.get(PacketIO.PROTO_BYTE, offset + 10) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 10) & 0x02) != 0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.thirdPerson != null) nullBits |= 0x01;
        if (this.thirdPersonMoving != null) nullBits |= 0x02;
        if (this.thirdPersonFace != null) nullBits |= 0x04;
        if (this.firstPerson != null) nullBits |= 0x08;
        if (this.firstPersonOverride != null) nullBits |= 0x10;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BOOL, offset + 1, this.keepPreviousFirstPersonAnimation);
        PacketIO.requireFinite(this.speed, "Speed"); mem.set(PacketIO.PROTO_FLOAT, offset + 2, this.speed);
        PacketIO.requireFinite(this.blendingDuration, "BlendingDuration"); mem.set(PacketIO.PROTO_FLOAT, offset + 6, this.blendingDuration);
        byte boolBits0_0 = 0;
        if (this.looping) boolBits0_0 |= 0x01;
        if (this.clipsGeometry) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 10 + 0, boolBits0_0);
        var varOffset = offset + 31;
        if (this.thirdPerson != null) {
            mem.set(PacketIO.PROTO_INT, offset + 11, varOffset - offset - 31);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.thirdPerson, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 11, -1);
        }
        if (this.thirdPersonMoving != null) {
            mem.set(PacketIO.PROTO_INT, offset + 15, varOffset - offset - 31);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.thirdPersonMoving, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 15, -1);
        }
        if (this.thirdPersonFace != null) {
            mem.set(PacketIO.PROTO_INT, offset + 19, varOffset - offset - 31);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.thirdPersonFace, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 19, -1);
        }
        if (this.firstPerson != null) {
            mem.set(PacketIO.PROTO_INT, offset + 23, varOffset - offset - 31);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.firstPerson, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 23, -1);
        }
        if (this.firstPersonOverride != null) {
            mem.set(PacketIO.PROTO_INT, offset + 27, varOffset - offset - 31);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.firstPersonOverride, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 27, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 31;
        if (thirdPerson != null) size += PacketIO.stringSize(thirdPerson);
    if (thirdPersonMoving != null) size += PacketIO.stringSize(thirdPersonMoving);
    if (thirdPersonFace != null) size += PacketIO.stringSize(thirdPersonFace);
    if (firstPerson != null) size += PacketIO.stringSize(firstPerson);
    if (firstPersonOverride != null) size += PacketIO.stringSize(firstPersonOverride);

        return size;
    }

    public ItemAnimation clone() {
        ItemAnimation copy = new ItemAnimation();
        copy.thirdPerson = this.thirdPerson;
        copy.thirdPersonMoving = this.thirdPersonMoving;
        copy.thirdPersonFace = this.thirdPersonFace;
        copy.firstPerson = this.firstPerson;
        copy.firstPersonOverride = this.firstPersonOverride;
        copy.keepPreviousFirstPersonAnimation = this.keepPreviousFirstPersonAnimation;
        copy.speed = this.speed;
        copy.blendingDuration = this.blendingDuration;
        copy.looping = this.looping;
        copy.clipsGeometry = this.clipsGeometry;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemAnimation other)) return false;
        return java.util.Objects.equals(this.thirdPerson, other.thirdPerson) && java.util.Objects.equals(this.thirdPersonMoving, other.thirdPersonMoving) && java.util.Objects.equals(this.thirdPersonFace, other.thirdPersonFace) && java.util.Objects.equals(this.firstPerson, other.firstPerson) && java.util.Objects.equals(this.firstPersonOverride, other.firstPersonOverride) && this.keepPreviousFirstPersonAnimation == other.keepPreviousFirstPersonAnimation && this.speed == other.speed && this.blendingDuration == other.blendingDuration && this.looping == other.looping && this.clipsGeometry == other.clipsGeometry;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(thirdPerson, thirdPersonMoving, thirdPersonFace, firstPerson, firstPersonOverride, keepPreviousFirstPersonAnimation, speed, blendingDuration, looping, clipsGeometry);
    }

}