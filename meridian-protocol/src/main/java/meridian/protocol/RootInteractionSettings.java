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


public class RootInteractionSettings {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 2;
    public static final int MAX_SIZE = 32768027;

    public boolean allowSkipChainOnClick;
    @Nullable public InteractionCooldown cooldown;

    public RootInteractionSettings() {
    }

    public RootInteractionSettings(boolean allowSkipChainOnClick, @Nullable InteractionCooldown cooldown) {
        this.allowSkipChainOnClick = allowSkipChainOnClick;
        this.cooldown = cooldown;
    }

    public RootInteractionSettings(@Nonnull RootInteractionSettings other) {
        this.allowSkipChainOnClick = other.allowSkipChainOnClick;
        this.cooldown = other.cooldown;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("RootInteractionSettings", offset, (int) mem.byteSize());
        long needed = (long) offset + 2;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("RootInteractionSettings", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getAllowSkipChainOnClick(MemorySegment mem) {
        return getAllowSkipChainOnClick(mem, 0);
    }
    
    public static boolean getAllowSkipChainOnClick(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 1);
    }
    
    @Nullable
    public static InteractionCooldown getCooldown(MemorySegment mem) {
        return getCooldown(mem, 0);
    }
    
    @Nullable
    public static InteractionCooldown getCooldown(MemorySegment mem, int offset) {
        return hasCooldown(mem, offset) ? InteractionCooldown.toObject(mem, offset + 2): null;
    }
    
    public static boolean hasCooldown(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static RootInteractionSettings toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static RootInteractionSettings toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one RootInteractionSettings and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static RootInteractionSettings toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 2;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        InteractionCooldown v1 = null;
        if (hasCooldown(mem, offset)) {
            v1 = InteractionCooldown.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new RootInteractionSettings(
            mem.get(PacketIO.PROTO_BOOL, offset + 1),
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.cooldown != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BOOL, offset + 1, this.allowSkipChainOnClick);
        var varOffset = offset + 2;
        if (this.cooldown != null) {
            
            varOffset += this.cooldown.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 2;
        if (cooldown != null) size += cooldown.computeSize();

        return size;
    }

    public RootInteractionSettings clone() {
        RootInteractionSettings copy = new RootInteractionSettings();
        copy.allowSkipChainOnClick = this.allowSkipChainOnClick;
        copy.cooldown = this.cooldown != null ? this.cooldown.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RootInteractionSettings other)) return false;
        return this.allowSkipChainOnClick == other.allowSkipChainOnClick && java.util.Objects.equals(this.cooldown, other.cooldown);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(allowSkipChainOnClick, cooldown);
    }

}