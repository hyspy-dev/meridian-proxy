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


public class LayerPlacement {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 17;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 25;
    public static final int MAX_SIZE = 1677721600;

    public int containerIndex;
    @Nullable public String name;
    @Nullable public BarBeatDuration clipStart;
    @Nullable public StateBinding[] stateBindings;

    public LayerPlacement() {
    }

    public LayerPlacement(int containerIndex, @Nullable String name, @Nullable BarBeatDuration clipStart, @Nullable StateBinding[] stateBindings) {
        this.containerIndex = containerIndex;
        this.name = name;
        this.clipStart = clipStart;
        this.stateBindings = stateBindings;
    }

    public LayerPlacement(@Nonnull LayerPlacement other) {
        this.containerIndex = other.containerIndex;
        this.name = other.name;
        this.clipStart = other.clipStart;
        this.stateBindings = other.stateBindings;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("LayerPlacement", offset, (int) mem.byteSize());
        long needed = (long) offset + 25;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("LayerPlacement", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getContainerIndex(MemorySegment mem) {
        return getContainerIndex(mem, 0);
    }
    
    public static int getContainerIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static String getName(MemorySegment mem) {
        return getName(mem, 0);
    }
    
    @Nullable
    public static String getName(MemorySegment mem, int offset) {
        return hasName(mem, offset) ? PacketIO.readVarString("Name", mem, offset + getValidatedOffset(mem, offset, 17, 25, "Name"), 4096000): null;
    }
    
    @Nullable
    public static BarBeatDuration getClipStart(MemorySegment mem) {
        return getClipStart(mem, 0);
    }
    
    @Nullable
    public static BarBeatDuration getClipStart(MemorySegment mem, int offset) {
        return hasClipStart(mem, offset) ? BarBeatDuration.toObject(mem, offset + 5): null;
    }
    
    @Nullable
    public static StateBinding[] getStateBindings(MemorySegment mem) {
        return getStateBindings(mem, 0);
    }
    
    @Nullable
    public static StateBinding[] getStateBindings(MemorySegment mem, int offset) {
        if (!hasStateBindings(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 21, 25, "StateBindings");
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
    
    public static boolean hasClipStart(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasStateBindings(MemorySegment mem, int offset) {
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
    
    public static LayerPlacement toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static LayerPlacement toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one LayerPlacement and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static LayerPlacement toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 25;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v1 = null;
        if (hasName(mem, offset)) {
            requireSlot(mem, offset + 17, varPos, "Name");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Name", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 17, -1, "Name");
        }
        
        StateBinding[] v3 = null;
        if (hasStateBindings(mem, offset)) {
            requireSlot(mem, offset + 21, varPos, "StateBindings");
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
            requireSlot(mem, offset + 21, -1, "StateBindings");
        }
        var result = new LayerPlacement(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v1,
            hasClipStart(mem, offset) ? BarBeatDuration.toObject(mem, offset + 5) : null,
            v3
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.clipStart != null) nullBits |= 0x01;
        if (this.name != null) nullBits |= 0x02;
        if (this.stateBindings != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.containerIndex);
        if (this.clipStart != null) {
            this.clipStart.serialize(mem, offset + 5);
        } else {
            mem.asSlice(offset + 5, 12).fill((byte) 0); 
        }
        var varOffset = offset + 25;
        if (this.name != null) {
            mem.set(PacketIO.PROTO_INT, offset + 17, varOffset - offset - 25);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.name, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 17, -1);
        }
        if (this.stateBindings != null) {
            mem.set(PacketIO.PROTO_INT, offset + 21, varOffset - offset - 25);
            if (stateBindings.length > 4096000) throw ProtocolException.arrayTooLong("StateBindings", stateBindings.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.stateBindings.length);
            
            var stateBindingsValueOffset = 0;
            for (var i = 0; i < this.stateBindings.length; i++) {
                stateBindingsValueOffset += this.stateBindings[i].serialize(mem, varOffset + stateBindingsValueOffset);
            }
            varOffset += stateBindingsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 21, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 25;
        if (name != null) size += PacketIO.stringSize(name);
    if (stateBindings != null) {
        int stateBindingsSize = 0;
for (var elem : stateBindings) stateBindingsSize += elem.computeSize();
size += VarInt.size(stateBindings.length) + stateBindingsSize;
    }

        return size;
    }

    public LayerPlacement clone() {
        LayerPlacement copy = new LayerPlacement();
        copy.containerIndex = this.containerIndex;
        copy.name = this.name;
        copy.clipStart = this.clipStart != null ? this.clipStart.clone() : null;
        copy.stateBindings = this.stateBindings != null ? java.util.Arrays.stream(this.stateBindings).map(e -> e.clone()).toArray(StateBinding[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof LayerPlacement other)) return false;
        return this.containerIndex == other.containerIndex && java.util.Objects.equals(this.name, other.name) && java.util.Objects.equals(this.clipStart, other.clipStart) && java.util.Arrays.equals(this.stateBindings, other.stateBindings);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(containerIndex);
        result = 31 * result + java.util.Objects.hashCode(name);
        result = 31 * result + java.util.Objects.hashCode(clipStart);
        result = 31 * result + java.util.Arrays.hashCode(stateBindings);
        return result;
    }

}