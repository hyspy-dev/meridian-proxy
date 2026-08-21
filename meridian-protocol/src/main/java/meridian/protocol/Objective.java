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
import java.util.UUID;

public class Objective {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 17;
    public static final int VARIABLE_FIELD_COUNT = 4;
    public static final int VARIABLE_BLOCK_START = 33;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public java.util.UUID objectiveUuid = new java.util.UUID(0L, 0L);
    @Nullable public FormattedMessage objectiveTitleKey;
    @Nullable public FormattedMessage objectiveDescriptionKey;
    @Nullable public String objectiveLineId;
    @Nullable public ObjectiveTask[] tasks;

    public Objective() {
    }

    public Objective(@Nonnull java.util.UUID objectiveUuid, @Nullable FormattedMessage objectiveTitleKey, @Nullable FormattedMessage objectiveDescriptionKey, @Nullable String objectiveLineId, @Nullable ObjectiveTask[] tasks) {
        this.objectiveUuid = objectiveUuid;
        this.objectiveTitleKey = objectiveTitleKey;
        this.objectiveDescriptionKey = objectiveDescriptionKey;
        this.objectiveLineId = objectiveLineId;
        this.tasks = tasks;
    }

    public Objective(@Nonnull Objective other) {
        this.objectiveUuid = other.objectiveUuid;
        this.objectiveTitleKey = other.objectiveTitleKey;
        this.objectiveDescriptionKey = other.objectiveDescriptionKey;
        this.objectiveLineId = other.objectiveLineId;
        this.tasks = other.tasks;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Objective", offset, (int) mem.byteSize());
        long needed = (long) offset + 33;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Objective", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static java.util.UUID getObjectiveUuid(MemorySegment mem) {
        return getObjectiveUuid(mem, 0);
    }
    
    public static java.util.UUID getObjectiveUuid(MemorySegment mem, int offset) {
        return PacketIO.readUUID(mem, offset + 1);
    }
    
    @Nullable
    public static FormattedMessage getObjectiveTitleKey(MemorySegment mem) {
        return getObjectiveTitleKey(mem, 0);
    }
    
    @Nullable
    public static FormattedMessage getObjectiveTitleKey(MemorySegment mem, int offset) {
        return hasObjectiveTitleKey(mem, offset) ? FormattedMessage.toObject(mem, offset + getValidatedOffset(mem, offset, 17, 33, "ObjectiveTitleKey")): null;
    }
    
    @Nullable
    public static FormattedMessage getObjectiveDescriptionKey(MemorySegment mem) {
        return getObjectiveDescriptionKey(mem, 0);
    }
    
    @Nullable
    public static FormattedMessage getObjectiveDescriptionKey(MemorySegment mem, int offset) {
        return hasObjectiveDescriptionKey(mem, offset) ? FormattedMessage.toObject(mem, offset + getValidatedOffset(mem, offset, 21, 33, "ObjectiveDescriptionKey")): null;
    }
    
    @Nullable
    public static String getObjectiveLineId(MemorySegment mem) {
        return getObjectiveLineId(mem, 0);
    }
    
    @Nullable
    public static String getObjectiveLineId(MemorySegment mem, int offset) {
        return hasObjectiveLineId(mem, offset) ? PacketIO.readVarString("ObjectiveLineId", mem, offset + getValidatedOffset(mem, offset, 25, 33, "ObjectiveLineId"), 4096000): null;
    }
    
    @Nullable
    public static ObjectiveTask[] getTasks(MemorySegment mem) {
        return getTasks(mem, 0);
    }
    
    @Nullable
    public static ObjectiveTask[] getTasks(MemorySegment mem, int offset) {
        if (!hasTasks(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 29, 33, "Tasks");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Tasks");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Tasks", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 9 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Tasks", (int) java.lang.Math.min(off + lenOffset + (long) len * 9, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ObjectiveTask[len];
        for (var i = 0; i < len; i++) {
            data[i] = ObjectiveTask.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasObjectiveTitleKey(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasObjectiveDescriptionKey(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasObjectiveLineId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasTasks(MemorySegment mem, int offset) {
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
    
    public static Objective toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Objective toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Objective and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Objective toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 33;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        FormattedMessage v1 = null;
        if (hasObjectiveTitleKey(mem, offset)) {
            requireSlot(mem, offset + 17, varPos, "ObjectiveTitleKey");
            v1 = FormattedMessage.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 17, -1, "ObjectiveTitleKey");
        }
        
        FormattedMessage v2 = null;
        if (hasObjectiveDescriptionKey(mem, offset)) {
            requireSlot(mem, offset + 21, varPos, "ObjectiveDescriptionKey");
            v2 = FormattedMessage.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 21, -1, "ObjectiveDescriptionKey");
        }
        
        String v3 = null;
        if (hasObjectiveLineId(mem, offset)) {
            requireSlot(mem, offset + 25, varPos, "ObjectiveLineId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readVarString("ObjectiveLineId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 25, -1, "ObjectiveLineId");
        }
        
        ObjectiveTask[] v4 = null;
        if (hasTasks(mem, offset)) {
            requireSlot(mem, offset + 29, varPos, "Tasks");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Tasks");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Tasks", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 9 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Tasks", (int) java.lang.Math.min(off + lenOffset + (long) len * 9, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v4 = new ObjectiveTask[len];
            for (var i = 0; i < len; i++) {
                v4[i] = ObjectiveTask.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 29, -1, "Tasks");
        }
        var result = new Objective(
            PacketIO.readUUID(mem, offset + 1),
            v1,
            v2,
            v3,
            v4
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.objectiveTitleKey != null) nullBits |= 0x01;
        if (this.objectiveDescriptionKey != null) nullBits |= 0x02;
        if (this.objectiveLineId != null) nullBits |= 0x04;
        if (this.tasks != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.writeUUID(mem, offset + 1, this.objectiveUuid);
        var varOffset = offset + 33;
        if (this.objectiveTitleKey != null) {
            mem.set(PacketIO.PROTO_INT, offset + 17, varOffset - offset - 33);
            varOffset += this.objectiveTitleKey.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 17, -1);
        }
        if (this.objectiveDescriptionKey != null) {
            mem.set(PacketIO.PROTO_INT, offset + 21, varOffset - offset - 33);
            varOffset += this.objectiveDescriptionKey.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 21, -1);
        }
        if (this.objectiveLineId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 25, varOffset - offset - 33);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.objectiveLineId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 25, -1);
        }
        if (this.tasks != null) {
            mem.set(PacketIO.PROTO_INT, offset + 29, varOffset - offset - 33);
            if (tasks.length > 4096000) throw ProtocolException.arrayTooLong("Tasks", tasks.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.tasks.length);
            
            var tasksValueOffset = 0;
            for (var i = 0; i < this.tasks.length; i++) {
                tasksValueOffset += this.tasks[i].serialize(mem, varOffset + tasksValueOffset);
            }
            varOffset += tasksValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 29, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 33;
        if (objectiveTitleKey != null) size += objectiveTitleKey.computeSize();
    if (objectiveDescriptionKey != null) size += objectiveDescriptionKey.computeSize();
    if (objectiveLineId != null) size += PacketIO.stringSize(objectiveLineId);
    if (tasks != null) {
        int tasksSize = 0;
for (var elem : tasks) tasksSize += elem.computeSize();
size += VarInt.size(tasks.length) + tasksSize;
    }

        return size;
    }

    public Objective clone() {
        Objective copy = new Objective();
        copy.objectiveUuid = this.objectiveUuid;
        copy.objectiveTitleKey = this.objectiveTitleKey != null ? this.objectiveTitleKey.clone() : null;
        copy.objectiveDescriptionKey = this.objectiveDescriptionKey != null ? this.objectiveDescriptionKey.clone() : null;
        copy.objectiveLineId = this.objectiveLineId;
        copy.tasks = this.tasks != null ? java.util.Arrays.stream(this.tasks).map(e -> e.clone()).toArray(ObjectiveTask[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Objective other)) return false;
        return java.util.Objects.equals(this.objectiveUuid, other.objectiveUuid) && java.util.Objects.equals(this.objectiveTitleKey, other.objectiveTitleKey) && java.util.Objects.equals(this.objectiveDescriptionKey, other.objectiveDescriptionKey) && java.util.Objects.equals(this.objectiveLineId, other.objectiveLineId) && java.util.Arrays.equals(this.tasks, other.tasks);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(objectiveUuid);
        result = 31 * result + java.util.Objects.hashCode(objectiveTitleKey);
        result = 31 * result + java.util.Objects.hashCode(objectiveDescriptionKey);
        result = 31 * result + java.util.Objects.hashCode(objectiveLineId);
        result = 31 * result + java.util.Arrays.hashCode(tasks);
        return result;
    }

}