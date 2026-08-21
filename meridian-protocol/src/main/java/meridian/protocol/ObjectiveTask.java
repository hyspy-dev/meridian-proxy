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


public class ObjectiveTask {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public FormattedMessage taskDescriptionKey;
    public int currentCompletion;
    public int completionNeeded;

    public ObjectiveTask() {
    }

    public ObjectiveTask(@Nullable FormattedMessage taskDescriptionKey, int currentCompletion, int completionNeeded) {
        this.taskDescriptionKey = taskDescriptionKey;
        this.currentCompletion = currentCompletion;
        this.completionNeeded = completionNeeded;
    }

    public ObjectiveTask(@Nonnull ObjectiveTask other) {
        this.taskDescriptionKey = other.taskDescriptionKey;
        this.currentCompletion = other.currentCompletion;
        this.completionNeeded = other.completionNeeded;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ObjectiveTask", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ObjectiveTask", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static FormattedMessage getTaskDescriptionKey(MemorySegment mem) {
        return getTaskDescriptionKey(mem, 0);
    }
    
    @Nullable
    public static FormattedMessage getTaskDescriptionKey(MemorySegment mem, int offset) {
        return hasTaskDescriptionKey(mem, offset) ? FormattedMessage.toObject(mem, offset + 9): null;
    }
    
    public static int getCurrentCompletion(MemorySegment mem) {
        return getCurrentCompletion(mem, 0);
    }
    
    public static int getCurrentCompletion(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getCompletionNeeded(MemorySegment mem) {
        return getCompletionNeeded(mem, 0);
    }
    
    public static int getCompletionNeeded(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static boolean hasTaskDescriptionKey(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static ObjectiveTask toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ObjectiveTask toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ObjectiveTask and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ObjectiveTask toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        FormattedMessage v0 = null;
        if (hasTaskDescriptionKey(mem, offset)) {
            v0 = FormattedMessage.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new ObjectiveTask(
            v0,
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.taskDescriptionKey != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.currentCompletion);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.completionNeeded);
        var varOffset = offset + 9;
        if (this.taskDescriptionKey != null) {
            
            varOffset += this.taskDescriptionKey.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (taskDescriptionKey != null) size += taskDescriptionKey.computeSize();

        return size;
    }

    public ObjectiveTask clone() {
        ObjectiveTask copy = new ObjectiveTask();
        copy.taskDescriptionKey = this.taskDescriptionKey != null ? this.taskDescriptionKey.clone() : null;
        copy.currentCompletion = this.currentCompletion;
        copy.completionNeeded = this.completionNeeded;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ObjectiveTask other)) return false;
        return java.util.Objects.equals(this.taskDescriptionKey, other.taskDescriptionKey) && this.currentCompletion == other.currentCompletion && this.completionNeeded == other.completionNeeded;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(taskDescriptionKey, currentCompletion, completionNeeded);
    }

}