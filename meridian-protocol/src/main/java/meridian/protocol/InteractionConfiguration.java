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
import java.util.HashMap;

public class InteractionConfiguration {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 3;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 11;
    public static final int MAX_SIZE = 1677721600;

    public boolean displayOutlines = true;
    public boolean debugOutlines;
    @Nullable public java.util.Map<GameMode, Float> useDistance;
    public boolean allEntities;
    @Nullable public java.util.Map<InteractionType, InteractionPriority> priorities;

    public InteractionConfiguration() {
    }

    public InteractionConfiguration(boolean displayOutlines, boolean debugOutlines, @Nullable java.util.Map<GameMode, Float> useDistance, boolean allEntities, @Nullable java.util.Map<InteractionType, InteractionPriority> priorities) {
        this.displayOutlines = displayOutlines;
        this.debugOutlines = debugOutlines;
        this.useDistance = useDistance;
        this.allEntities = allEntities;
        this.priorities = priorities;
    }

    public InteractionConfiguration(@Nonnull InteractionConfiguration other) {
        this.displayOutlines = other.displayOutlines;
        this.debugOutlines = other.debugOutlines;
        this.useDistance = other.useDistance;
        this.allEntities = other.allEntities;
        this.priorities = other.priorities;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("InteractionConfiguration", offset, (int) mem.byteSize());
        long needed = (long) offset + 11;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InteractionConfiguration", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getDisplayOutlines(MemorySegment mem) {
        return getDisplayOutlines(mem, 0);
    }
    
    public static boolean getDisplayOutlines(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x01) != 0;
    }
    
    public static boolean getDebugOutlines(MemorySegment mem) {
        return getDebugOutlines(mem, 0);
    }
    
    public static boolean getDebugOutlines(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x02) != 0;
    }
    
    @Nullable
    public static java.util.Map<GameMode, Float> getUseDistance(MemorySegment mem) {
        return getUseDistance(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<GameMode, Float> getUseDistance(MemorySegment mem, int offset) {
        if (!hasUseDistance(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 3, 11, "UseDistance");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("UseDistance");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("UseDistance", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("UseDistance", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<GameMode, Float> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = GameMode.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                off += 1;
            var value = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("UseDistance", key);
            }
        }
        return data;
    }
    
    public static boolean getAllEntities(MemorySegment mem) {
        return getAllEntities(mem, 0);
    }
    
    public static boolean getAllEntities(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 2);
    }
    
    @Nullable
    public static java.util.Map<InteractionType, InteractionPriority> getPriorities(MemorySegment mem) {
        return getPriorities(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<InteractionType, InteractionPriority> getPriorities(MemorySegment mem, int offset) {
        if (!hasPriorities(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 7, 11, "Priorities");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Priorities");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Priorities", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Priorities", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<InteractionType, InteractionPriority> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                off += 1;
            var value = InteractionPriority.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Priorities", key);
            }
        }
        return data;
    }
    
    public static boolean hasUseDistance(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasPriorities(MemorySegment mem, int offset) {
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
    
    public static InteractionConfiguration toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static InteractionConfiguration toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one InteractionConfiguration and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static InteractionConfiguration toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 11;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        java.util.Map<GameMode, Float> v2 = null;
        if (hasUseDistance(mem, offset)) {
            requireSlot(mem, offset + 3, varPos, "UseDistance");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("UseDistance");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("UseDistance", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("UseDistance", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v2 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = GameMode.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                    off += 1;
                var value = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                if (v2.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("UseDistance", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 3, -1, "UseDistance");
        }
        
        java.util.Map<InteractionType, InteractionPriority> v4 = null;
        if (hasPriorities(mem, offset)) {
            requireSlot(mem, offset + 7, varPos, "Priorities");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Priorities");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Priorities", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Priorities", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            v4 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                    off += 1;
                var value = InteractionPriority.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v4.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Priorities", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 7, -1, "Priorities");
        }
        var result = new InteractionConfiguration(
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x02) != 0,
            v2,
            mem.get(PacketIO.PROTO_BOOL, offset + 2),
            v4
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.useDistance != null) nullBits |= 0x01;
        if (this.priorities != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        byte boolBits0_0 = 0;
        if (this.displayOutlines) boolBits0_0 |= 0x01;
        if (this.debugOutlines) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 1 + 0, boolBits0_0);
        mem.set(PacketIO.PROTO_BOOL, offset + 2, this.allEntities);
        var varOffset = offset + 11;
        if (this.useDistance != null) {
            mem.set(PacketIO.PROTO_INT, offset + 3, varOffset - offset - 11);
            if (this.useDistance.size() > 4096000) throw ProtocolException.dictionaryTooLarge("UseDistance", useDistance.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.useDistance.size());
            for (var e : this.useDistance.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 3, -1);
        }
        if (this.priorities != null) {
            mem.set(PacketIO.PROTO_INT, offset + 7, varOffset - offset - 11);
            if (this.priorities.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Priorities", priorities.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.priorities.size());
            for (var e : this.priorities.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 7, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 11;
        if (useDistance != null) size += VarInt.size(useDistance.size()) + useDistance.size() * (1 + 4);
    if (priorities != null) {
        int prioritiesSize = 0;
for (var kvp : priorities.entrySet()) prioritiesSize += 1 + kvp.getValue().computeSize();
size += VarInt.size(priorities.size()) + prioritiesSize;
    }

        return size;
    }

    public InteractionConfiguration clone() {
        InteractionConfiguration copy = new InteractionConfiguration();
        copy.displayOutlines = this.displayOutlines;
        copy.debugOutlines = this.debugOutlines;
        copy.useDistance = this.useDistance != null ? new java.util.HashMap<>(this.useDistance) : null;
        copy.allEntities = this.allEntities;
        if (this.priorities != null) {
            java.util.Map<InteractionType, InteractionPriority> m = new java.util.HashMap<>();
            for (var e : this.priorities.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.priorities = m;
        }
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InteractionConfiguration other)) return false;
        return this.displayOutlines == other.displayOutlines && this.debugOutlines == other.debugOutlines && java.util.Objects.equals(this.useDistance, other.useDistance) && this.allEntities == other.allEntities && java.util.Objects.equals(this.priorities, other.priorities);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(displayOutlines, debugOutlines, useDistance, allEntities, priorities);
    }

}