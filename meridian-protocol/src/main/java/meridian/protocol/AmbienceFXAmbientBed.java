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


public class AmbienceFXAmbientBed {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 14;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String track;
    public float volume;
    @Nonnull public AmbienceTransitionSpeed transitionSpeed = AmbienceTransitionSpeed.Default;
    @Nullable public StateBinding[] stateBindings;

    public AmbienceFXAmbientBed() {
    }

    public AmbienceFXAmbientBed(@Nullable String track, float volume, @Nonnull AmbienceTransitionSpeed transitionSpeed, @Nullable StateBinding[] stateBindings) {
        this.track = track;
        this.volume = volume;
        this.transitionSpeed = transitionSpeed;
        this.stateBindings = stateBindings;
    }

    public AmbienceFXAmbientBed(@Nonnull AmbienceFXAmbientBed other) {
        this.track = other.track;
        this.volume = other.volume;
        this.transitionSpeed = other.transitionSpeed;
        this.stateBindings = other.stateBindings;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AmbienceFXAmbientBed", offset, (int) mem.byteSize());
        long needed = (long) offset + 14;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AmbienceFXAmbientBed", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getTrack(MemorySegment mem) {
        return getTrack(mem, 0);
    }
    
    @Nullable
    public static String getTrack(MemorySegment mem, int offset) {
        return hasTrack(mem, offset) ? PacketIO.readVarString("Track", mem, offset + getValidatedOffset(mem, offset, 6, 14, "Track"), 4096000): null;
    }
    
    public static float getVolume(MemorySegment mem) {
        return getVolume(mem, 0);
    }
    
    public static float getVolume(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Volume");
    }
    
    public static AmbienceTransitionSpeed getTransitionSpeed(MemorySegment mem) {
        return getTransitionSpeed(mem, 0);
    }
    
    public static AmbienceTransitionSpeed getTransitionSpeed(MemorySegment mem, int offset) {
        return AmbienceTransitionSpeed.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 5));
    }
    
    @Nullable
    public static StateBinding[] getStateBindings(MemorySegment mem) {
        return getStateBindings(mem, 0);
    }
    
    @Nullable
    public static StateBinding[] getStateBindings(MemorySegment mem, int offset) {
        if (!hasStateBindings(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 10, 14, "StateBindings");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("StateBindings");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("StateBindings", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("StateBindings", (int) java.lang.Math.min(off + lenOffset + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new StateBinding[len];
        for (var i = 0; i < len; i++) {
            data[i] = StateBinding.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasTrack(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasStateBindings(MemorySegment mem, int offset) {
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
    
    public static AmbienceFXAmbientBed toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AmbienceFXAmbientBed toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AmbienceFXAmbientBed and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AmbienceFXAmbientBed toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 14;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasTrack(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "Track");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Track", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 6, -1, "Track");
        }
        
        StateBinding[] v3 = null;
        if (hasStateBindings(mem, offset)) {
            requireSlot(mem, offset + 10, varPos, "StateBindings");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("StateBindings");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("StateBindings", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("StateBindings", (int) java.lang.Math.min(off + lenOffset + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v3 = new StateBinding[len];
            for (var i = 0; i < len; i++) {
                v3[i] = StateBinding.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 10, -1, "StateBindings");
        }
        var result = new AmbienceFXAmbientBed(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Volume"),
            AmbienceTransitionSpeed.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 5)),
            v3
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.track != null) nullBits |= 0x01;
        if (this.stateBindings != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.volume, "Volume"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.volume);
        mem.set(PacketIO.PROTO_BYTE, offset + 5, (byte) this.transitionSpeed.getValue());
        var varOffset = offset + 14;
        if (this.track != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 14);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.track, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
        if (this.stateBindings != null) {
            mem.set(PacketIO.PROTO_INT, offset + 10, varOffset - offset - 14);
            if (stateBindings.length > 4096000) throw ProtocolException.arrayTooLong("StateBindings", stateBindings.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.stateBindings.length);
            
            var stateBindingsValueOffset = 0;
            for (var i = 0; i < this.stateBindings.length; i++) {
                stateBindingsValueOffset += this.stateBindings[i].serialize(mem, varOffset + stateBindingsValueOffset);
            }
            varOffset += stateBindingsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 10, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 14;
        if (track != null) size += PacketIO.stringSize(track);
    if (stateBindings != null) {
        int stateBindingsSize = 0;
for (var elem : stateBindings) stateBindingsSize += elem.computeSize();
size += VarInt.size(stateBindings.length) + stateBindingsSize;
    }

        return size;
    }

    public AmbienceFXAmbientBed clone() {
        AmbienceFXAmbientBed copy = new AmbienceFXAmbientBed();
        copy.track = this.track;
        copy.volume = this.volume;
        copy.transitionSpeed = this.transitionSpeed;
        copy.stateBindings = this.stateBindings != null ? java.util.Arrays.stream(this.stateBindings).map(e -> e.clone()).toArray(StateBinding[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AmbienceFXAmbientBed other)) return false;
        return java.util.Objects.equals(this.track, other.track) && this.volume == other.volume && java.util.Objects.equals(this.transitionSpeed, other.transitionSpeed) && java.util.Arrays.equals(this.stateBindings, other.stateBindings);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(track);
        result = 31 * result + Float.hashCode(volume);
        result = 31 * result + java.util.Objects.hashCode(transitionSpeed);
        result = 31 * result + java.util.Arrays.hashCode(stateBindings);
        return result;
    }

}