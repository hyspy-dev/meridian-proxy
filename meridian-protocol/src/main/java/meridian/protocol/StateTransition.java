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


public class StateTransition {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 15;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 15;
    public static final int MAX_SIZE = 16384020;

    public int fromValueIndex;
    public int toValueIndex;
    public float durationMs;
    @Nonnull public FadeCurve curve = FadeCurve.Linear;
    @Nullable public SyncPoint syncTo;
    @Nullable public String postEvent;

    public StateTransition() {
    }

    public StateTransition(int fromValueIndex, int toValueIndex, float durationMs, @Nonnull FadeCurve curve, @Nullable SyncPoint syncTo, @Nullable String postEvent) {
        this.fromValueIndex = fromValueIndex;
        this.toValueIndex = toValueIndex;
        this.durationMs = durationMs;
        this.curve = curve;
        this.syncTo = syncTo;
        this.postEvent = postEvent;
    }

    public StateTransition(@Nonnull StateTransition other) {
        this.fromValueIndex = other.fromValueIndex;
        this.toValueIndex = other.toValueIndex;
        this.durationMs = other.durationMs;
        this.curve = other.curve;
        this.syncTo = other.syncTo;
        this.postEvent = other.postEvent;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("StateTransition", offset, (int) mem.byteSize());
        long needed = (long) offset + 15;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("StateTransition", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getFromValueIndex(MemorySegment mem) {
        return getFromValueIndex(mem, 0);
    }
    
    public static int getFromValueIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getToValueIndex(MemorySegment mem) {
        return getToValueIndex(mem, 0);
    }
    
    public static int getToValueIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static float getDurationMs(MemorySegment mem) {
        return getDurationMs(mem, 0);
    }
    
    public static float getDurationMs(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "DurationMs");
    }
    
    public static FadeCurve getCurve(MemorySegment mem) {
        return getCurve(mem, 0);
    }
    
    public static FadeCurve getCurve(MemorySegment mem, int offset) {
        return FadeCurve.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 13));
    }
    
    @Nullable
    public static SyncPoint getSyncTo(MemorySegment mem) {
        return getSyncTo(mem, 0);
    }
    
    @Nullable
    public static SyncPoint getSyncTo(MemorySegment mem, int offset) {
        return hasSyncTo(mem, offset) ? SyncPoint.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 14)): null;
    }
    
    @Nullable
    public static String getPostEvent(MemorySegment mem) {
        return getPostEvent(mem, 0);
    }
    
    @Nullable
    public static String getPostEvent(MemorySegment mem, int offset) {
        return hasPostEvent(mem, offset) ? PacketIO.readVarString("PostEvent", mem, offset + 15, 4096000): null;
    }
    
    public static boolean hasSyncTo(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasPostEvent(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    
    
    public static StateTransition toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static StateTransition toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one StateTransition and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static StateTransition toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 15;
        var varPos = 0;
        String v5 = null;
        if (hasPostEvent(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v5 = PacketIO.readVarString("PostEvent", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new StateTransition(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "DurationMs"),
            FadeCurve.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 13)),
            hasSyncTo(mem, offset) ? SyncPoint.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 14)) : null,
            v5
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.syncTo != null) nullBits |= 0x01;
        if (this.postEvent != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.fromValueIndex);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.toValueIndex);
        PacketIO.requireFinite(this.durationMs, "DurationMs"); mem.set(PacketIO.PROTO_FLOAT, offset + 9, this.durationMs);
        mem.set(PacketIO.PROTO_BYTE, offset + 13, (byte) this.curve.getValue());
        if (this.syncTo != null) {
            mem.set(PacketIO.PROTO_BYTE, offset + 14, (byte) this.syncTo.getValue());
        } else {
            mem.asSlice(offset + 14, 1).fill((byte) 0); 
        }
        var varOffset = offset + 15;
        if (this.postEvent != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.postEvent, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 15;
        if (postEvent != null) size += PacketIO.stringSize(postEvent);

        return size;
    }

    public StateTransition clone() {
        StateTransition copy = new StateTransition();
        copy.fromValueIndex = this.fromValueIndex;
        copy.toValueIndex = this.toValueIndex;
        copy.durationMs = this.durationMs;
        copy.curve = this.curve;
        copy.syncTo = this.syncTo;
        copy.postEvent = this.postEvent;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof StateTransition other)) return false;
        return this.fromValueIndex == other.fromValueIndex && this.toValueIndex == other.toValueIndex && this.durationMs == other.durationMs && java.util.Objects.equals(this.curve, other.curve) && java.util.Objects.equals(this.syncTo, other.syncTo) && java.util.Objects.equals(this.postEvent, other.postEvent);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(fromValueIndex, toValueIndex, durationMs, curve, syncTo, postEvent);
    }

}