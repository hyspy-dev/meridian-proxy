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


public class AnimationSet {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 17;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String id;
    @Nullable public Animation[] animations;
    @Nullable public Rangef nextAnimationDelay;

    public AnimationSet() {
    }

    public AnimationSet(@Nullable String id, @Nullable Animation[] animations, @Nullable Rangef nextAnimationDelay) {
        this.id = id;
        this.animations = animations;
        this.nextAnimationDelay = nextAnimationDelay;
    }

    public AnimationSet(@Nonnull AnimationSet other) {
        this.id = other.id;
        this.animations = other.animations;
        this.nextAnimationDelay = other.nextAnimationDelay;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AnimationSet", offset, (int) mem.byteSize());
        long needed = (long) offset + 17;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AnimationSet", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 9, 17, "Id"), 4096000): null;
    }
    
    @Nullable
    public static Animation[] getAnimations(MemorySegment mem) {
        return getAnimations(mem, 0);
    }
    
    @Nullable
    public static Animation[] getAnimations(MemorySegment mem, int offset) {
        if (!hasAnimations(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 13, 17, "Animations");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Animations");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Animations", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 30 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Animations", (int) java.lang.Math.min(off + lenOffset + (long) len * 30, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new Animation[len];
        for (var i = 0; i < len; i++) {
            data[i] = Animation.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static Rangef getNextAnimationDelay(MemorySegment mem) {
        return getNextAnimationDelay(mem, 0);
    }
    
    @Nullable
    public static Rangef getNextAnimationDelay(MemorySegment mem, int offset) {
        return hasNextAnimationDelay(mem, offset) ? Rangef.toObject(mem, offset + 1): null;
    }
    
    public static boolean hasNextAnimationDelay(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasAnimations(MemorySegment mem, int offset) {
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
    
    public static AnimationSet toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AnimationSet toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AnimationSet and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AnimationSet toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 17;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 9, -1, "Id");
        }
        
        Animation[] v1 = null;
        if (hasAnimations(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "Animations");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Animations");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Animations", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 30 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Animations", (int) java.lang.Math.min(off + lenOffset + (long) len * 30, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new Animation[len];
            for (var i = 0; i < len; i++) {
                v1[i] = Animation.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 13, -1, "Animations");
        }
        var result = new AnimationSet(
            v0,
            v1,
            hasNextAnimationDelay(mem, offset) ? Rangef.toObject(mem, offset + 1) : null
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.nextAnimationDelay != null) nullBits |= 0x01;
        if (this.id != null) nullBits |= 0x02;
        if (this.animations != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.nextAnimationDelay != null) {
            this.nextAnimationDelay.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 8).fill((byte) 0); 
        }
        var varOffset = offset + 17;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 17);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
        if (this.animations != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 17);
            if (animations.length > 4096000) throw ProtocolException.arrayTooLong("Animations", animations.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.animations.length);
            
            var animationsValueOffset = 0;
            for (var i = 0; i < this.animations.length; i++) {
                animationsValueOffset += this.animations[i].serialize(mem, varOffset + animationsValueOffset);
            }
            varOffset += animationsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 17;
        if (id != null) size += PacketIO.stringSize(id);
    if (animations != null) {
        int animationsSize = 0;
for (var elem : animations) animationsSize += elem.computeSize();
size += VarInt.size(animations.length) + animationsSize;
    }

        return size;
    }

    public AnimationSet clone() {
        AnimationSet copy = new AnimationSet();
        copy.id = this.id;
        copy.animations = this.animations != null ? java.util.Arrays.stream(this.animations).map(e -> e.clone()).toArray(Animation[]::new) : null;
        copy.nextAnimationDelay = this.nextAnimationDelay != null ? this.nextAnimationDelay.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AnimationSet other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Arrays.equals(this.animations, other.animations) && java.util.Objects.equals(this.nextAnimationDelay, other.nextAnimationDelay);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(id);
        result = 31 * result + java.util.Arrays.hashCode(animations);
        result = 31 * result + java.util.Objects.hashCode(nextAnimationDelay);
        return result;
    }

}