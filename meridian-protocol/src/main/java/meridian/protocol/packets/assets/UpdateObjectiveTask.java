// Auto-generated - do not edit
package meridian.protocol.packets.assets;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.NetworkChannel;
import meridian.protocol.Packet;
import meridian.protocol.ToServerPacket;
import meridian.protocol.ToClientPacket;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import meridian.protocol.ObjectiveTask;
import java.util.UUID;

public class UpdateObjectiveTask implements Packet, ToClientPacket {
    public static final int PACKET_ID = 71;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 21;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 21;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public java.util.UUID objectiveUuid = new java.util.UUID(0L, 0L);
    public int taskIndex;
    @Nullable public ObjectiveTask task;

    public UpdateObjectiveTask() {
    }

    public UpdateObjectiveTask(@Nonnull java.util.UUID objectiveUuid, int taskIndex, @Nullable ObjectiveTask task) {
        this.objectiveUuid = objectiveUuid;
        this.taskIndex = taskIndex;
        this.task = task;
    }

    public UpdateObjectiveTask(@Nonnull UpdateObjectiveTask other) {
        this.objectiveUuid = other.objectiveUuid;
        this.taskIndex = other.taskIndex;
        this.task = other.task;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateObjectiveTask", offset, (int) mem.byteSize());
        long needed = (long) offset + 21;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateObjectiveTask", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static java.util.UUID getObjectiveUuid(MemorySegment mem) {
        return getObjectiveUuid(mem, 0);
    }
    
    public static java.util.UUID getObjectiveUuid(MemorySegment mem, int offset) {
        return PacketIO.readUUID(mem, offset + 1);
    }
    
    public static int getTaskIndex(MemorySegment mem) {
        return getTaskIndex(mem, 0);
    }
    
    public static int getTaskIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 17);
    }
    
    @Nullable
    public static ObjectiveTask getTask(MemorySegment mem) {
        return getTask(mem, 0);
    }
    
    @Nullable
    public static ObjectiveTask getTask(MemorySegment mem, int offset) {
        return hasTask(mem, offset) ? ObjectiveTask.toObject(mem, offset + 21): null;
    }
    
    public static boolean hasTask(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static UpdateObjectiveTask toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateObjectiveTask toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateObjectiveTask and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateObjectiveTask toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 21;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ObjectiveTask v2 = null;
        if (hasTask(mem, offset)) {
            v2 = ObjectiveTask.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new UpdateObjectiveTask(
            PacketIO.readUUID(mem, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 17),
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.task != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.writeUUID(mem, offset + 1, this.objectiveUuid);
        mem.set(PacketIO.PROTO_INT, offset + 17, this.taskIndex);
        var varOffset = offset + 21;
        if (this.task != null) {
            
            varOffset += this.task.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 21;
        if (task != null) size += task.computeSize();

        return size;
    }

    public UpdateObjectiveTask clone() {
        UpdateObjectiveTask copy = new UpdateObjectiveTask();
        copy.objectiveUuid = this.objectiveUuid;
        copy.taskIndex = this.taskIndex;
        copy.task = this.task != null ? this.task.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateObjectiveTask other)) return false;
        return java.util.Objects.equals(this.objectiveUuid, other.objectiveUuid) && this.taskIndex == other.taskIndex && java.util.Objects.equals(this.task, other.task);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(objectiveUuid, taskIndex, task);
    }

}