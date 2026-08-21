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


public class AudioState {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 8;
    public static final int VARIABLE_FIELD_COUNT = 4;
    public static final int VARIABLE_BLOCK_START = 24;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String id;
    @Nonnull public AudioStateAuthority authority = AudioStateAuthority.Server;
    @Nullable public String[] values;
    public int defaultValueIndex;
    @Nonnull public SyncPoint defaultSyncTo = SyncPoint.Immediate;
    @Nullable public StateTransition defaultTransition;
    @Nullable public StateTransition[] transitions;
    public boolean revertWhenInactive;

    public AudioState() {
    }

    public AudioState(@Nullable String id, @Nonnull AudioStateAuthority authority, @Nullable String[] values, int defaultValueIndex, @Nonnull SyncPoint defaultSyncTo, @Nullable StateTransition defaultTransition, @Nullable StateTransition[] transitions, boolean revertWhenInactive) {
        this.id = id;
        this.authority = authority;
        this.values = values;
        this.defaultValueIndex = defaultValueIndex;
        this.defaultSyncTo = defaultSyncTo;
        this.defaultTransition = defaultTransition;
        this.transitions = transitions;
        this.revertWhenInactive = revertWhenInactive;
    }

    public AudioState(@Nonnull AudioState other) {
        this.id = other.id;
        this.authority = other.authority;
        this.values = other.values;
        this.defaultValueIndex = other.defaultValueIndex;
        this.defaultSyncTo = other.defaultSyncTo;
        this.defaultTransition = other.defaultTransition;
        this.transitions = other.transitions;
        this.revertWhenInactive = other.revertWhenInactive;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AudioState", offset, (int) mem.byteSize());
        long needed = (long) offset + 24;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AudioState", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 8, 24, "Id"), 4096000): null;
    }
    
    public static AudioStateAuthority getAuthority(MemorySegment mem) {
        return getAuthority(mem, 0);
    }
    
    public static AudioStateAuthority getAuthority(MemorySegment mem, int offset) {
        return AudioStateAuthority.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static String[] getValues(MemorySegment mem) {
        return getValues(mem, 0);
    }
    
    @Nullable
    public static String[] getValues(MemorySegment mem, int offset) {
        if (!hasValues(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 12, 24, "Values");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Values");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Values", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Values", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("Values", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    public static int getDefaultValueIndex(MemorySegment mem) {
        return getDefaultValueIndex(mem, 0);
    }
    
    public static int getDefaultValueIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 2);
    }
    
    public static SyncPoint getDefaultSyncTo(MemorySegment mem) {
        return getDefaultSyncTo(mem, 0);
    }
    
    public static SyncPoint getDefaultSyncTo(MemorySegment mem, int offset) {
        return SyncPoint.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 6));
    }
    
    @Nullable
    public static StateTransition getDefaultTransition(MemorySegment mem) {
        return getDefaultTransition(mem, 0);
    }
    
    @Nullable
    public static StateTransition getDefaultTransition(MemorySegment mem, int offset) {
        return hasDefaultTransition(mem, offset) ? StateTransition.toObject(mem, offset + getValidatedOffset(mem, offset, 16, 24, "DefaultTransition")): null;
    }
    
    @Nullable
    public static StateTransition[] getTransitions(MemorySegment mem) {
        return getTransitions(mem, 0);
    }
    
    @Nullable
    public static StateTransition[] getTransitions(MemorySegment mem, int offset) {
        if (!hasTransitions(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 20, 24, "Transitions");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Transitions");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Transitions", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 15 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Transitions", (int) java.lang.Math.min(off + lenOffset + (long) len * 15, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new StateTransition[len];
        for (var i = 0; i < len; i++) {
            data[i] = StateTransition.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean getRevertWhenInactive(MemorySegment mem) {
        return getRevertWhenInactive(mem, 0);
    }
    
    public static boolean getRevertWhenInactive(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 7);
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasValues(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasDefaultTransition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasTransitions(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
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
    
    public static AudioState toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AudioState toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AudioState and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AudioState toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 24;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 8, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 8, -1, "Id");
        }
        
        String[] v2 = null;
        if (hasValues(mem, offset)) {
            requireSlot(mem, offset + 12, varPos, "Values");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Values");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Values", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Values", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v2[i] = PacketIO.readVarString("Values", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 12, -1, "Values");
        }
        
        StateTransition v5 = null;
        if (hasDefaultTransition(mem, offset)) {
            requireSlot(mem, offset + 16, varPos, "DefaultTransition");
            v5 = StateTransition.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 16, -1, "DefaultTransition");
        }
        
        StateTransition[] v6 = null;
        if (hasTransitions(mem, offset)) {
            requireSlot(mem, offset + 20, varPos, "Transitions");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Transitions");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Transitions", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 15 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Transitions", (int) java.lang.Math.min(off + lenOffset + (long) len * 15, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v6 = new StateTransition[len];
            for (var i = 0; i < len; i++) {
                v6[i] = StateTransition.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 20, -1, "Transitions");
        }
        var result = new AudioState(
            v0,
            AudioStateAuthority.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v2,
            mem.get(PacketIO.PROTO_INT, offset + 2),
            SyncPoint.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 6)),
            v5,
            v6,
            mem.get(PacketIO.PROTO_BOOL, offset + 7)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        if (this.values != null) nullBits |= 0x02;
        if (this.defaultTransition != null) nullBits |= 0x04;
        if (this.transitions != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.authority.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 2, this.defaultValueIndex);
        mem.set(PacketIO.PROTO_BYTE, offset + 6, (byte) this.defaultSyncTo.getValue());
        mem.set(PacketIO.PROTO_BOOL, offset + 7, this.revertWhenInactive);
        var varOffset = offset + 24;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 8, varOffset - offset - 24);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 8, -1);
        }
        if (this.values != null) {
            mem.set(PacketIO.PROTO_INT, offset + 12, varOffset - offset - 24);
            if (values.length > 4096000) throw ProtocolException.arrayTooLong("Values", values.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.values.length);
            
            var valuesValueOffset = 0;
            for (var i = 0; i < this.values.length; i++) {
                valuesValueOffset += PacketIO.writeVarString(mem, varOffset + valuesValueOffset, this.values[i], 4096000);
            }
            varOffset += valuesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 12, -1);
        }
        if (this.defaultTransition != null) {
            mem.set(PacketIO.PROTO_INT, offset + 16, varOffset - offset - 24);
            varOffset += this.defaultTransition.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 16, -1);
        }
        if (this.transitions != null) {
            mem.set(PacketIO.PROTO_INT, offset + 20, varOffset - offset - 24);
            if (transitions.length > 4096000) throw ProtocolException.arrayTooLong("Transitions", transitions.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.transitions.length);
            
            var transitionsValueOffset = 0;
            for (var i = 0; i < this.transitions.length; i++) {
                transitionsValueOffset += this.transitions[i].serialize(mem, varOffset + transitionsValueOffset);
            }
            varOffset += transitionsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 20, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 24;
        if (id != null) size += PacketIO.stringSize(id);
    if (values != null) {
        int valuesSize = 0;
for (var elem : values) valuesSize += PacketIO.stringSize(elem);
size += VarInt.size(values.length) + valuesSize;
    }
    if (defaultTransition != null) size += defaultTransition.computeSize();
    if (transitions != null) {
        int transitionsSize = 0;
for (var elem : transitions) transitionsSize += elem.computeSize();
size += VarInt.size(transitions.length) + transitionsSize;
    }

        return size;
    }

    public AudioState clone() {
        AudioState copy = new AudioState();
        copy.id = this.id;
        copy.authority = this.authority;
        copy.values = this.values != null ? java.util.Arrays.copyOf(this.values, this.values.length) : null;
        copy.defaultValueIndex = this.defaultValueIndex;
        copy.defaultSyncTo = this.defaultSyncTo;
        copy.defaultTransition = this.defaultTransition != null ? this.defaultTransition.clone() : null;
        copy.transitions = this.transitions != null ? java.util.Arrays.stream(this.transitions).map(e -> e.clone()).toArray(StateTransition[]::new) : null;
        copy.revertWhenInactive = this.revertWhenInactive;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AudioState other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.authority, other.authority) && java.util.Arrays.equals(this.values, other.values) && this.defaultValueIndex == other.defaultValueIndex && java.util.Objects.equals(this.defaultSyncTo, other.defaultSyncTo) && java.util.Objects.equals(this.defaultTransition, other.defaultTransition) && java.util.Arrays.equals(this.transitions, other.transitions) && this.revertWhenInactive == other.revertWhenInactive;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(id);
        result = 31 * result + java.util.Objects.hashCode(authority);
        result = 31 * result + java.util.Arrays.hashCode(values);
        result = 31 * result + Integer.hashCode(defaultValueIndex);
        result = 31 * result + java.util.Objects.hashCode(defaultSyncTo);
        result = 31 * result + java.util.Objects.hashCode(defaultTransition);
        result = 31 * result + java.util.Arrays.hashCode(transitions);
        result = 31 * result + Boolean.hashCode(revertWhenInactive);
        return result;
    }

}