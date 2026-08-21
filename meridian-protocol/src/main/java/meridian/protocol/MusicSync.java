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


public class MusicSync {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 18;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 18;
    public static final int MAX_SIZE = 16384023;

    @Nonnull public SyncPoint point = SyncPoint.Immediate;
    @Nullable public String markerName;
    @Nullable public BarBeatDuration offset;
    public int barMultiple;

    public MusicSync() {
    }

    public MusicSync(@Nonnull SyncPoint point, @Nullable String markerName, @Nullable BarBeatDuration offset, int barMultiple) {
        this.point = point;
        this.markerName = markerName;
        this.offset = offset;
        this.barMultiple = barMultiple;
    }

    public MusicSync(@Nonnull MusicSync other) {
        this.point = other.point;
        this.markerName = other.markerName;
        this.offset = other.offset;
        this.barMultiple = other.barMultiple;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("MusicSync", offset, (int) mem.byteSize());
        long needed = (long) offset + 18;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("MusicSync", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static SyncPoint getPoint(MemorySegment mem) {
        return getPoint(mem, 0);
    }
    
    public static SyncPoint getPoint(MemorySegment mem, int offset) {
        return SyncPoint.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static String getMarkerName(MemorySegment mem) {
        return getMarkerName(mem, 0);
    }
    
    @Nullable
    public static String getMarkerName(MemorySegment mem, int offset) {
        return hasMarkerName(mem, offset) ? PacketIO.readVarString("MarkerName", mem, offset + 18, 4096000): null;
    }
    
    @Nullable
    public static BarBeatDuration getOffset(MemorySegment mem) {
        return getOffset(mem, 0);
    }
    
    @Nullable
    public static BarBeatDuration getOffset(MemorySegment mem, int offset) {
        return hasOffset(mem, offset) ? BarBeatDuration.toObject(mem, offset + 2): null;
    }
    
    public static int getBarMultiple(MemorySegment mem) {
        return getBarMultiple(mem, 0);
    }
    
    public static int getBarMultiple(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 14);
    }
    
    public static boolean hasOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasMarkerName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    
    
    public static MusicSync toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static MusicSync toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one MusicSync and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static MusicSync toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 18;
        var varPos = 0;
        String v1 = null;
        if (hasMarkerName(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("MarkerName", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new MusicSync(
            SyncPoint.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v1,
            hasOffset(mem, offset) ? BarBeatDuration.toObject(mem, offset + 2) : null,
            mem.get(PacketIO.PROTO_INT, offset + 14)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.offset != null) nullBits |= 0x01;
        if (this.markerName != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.point.getValue());
        if (this.offset != null) {
            this.offset.serialize(mem, offset + 2);
        } else {
            mem.asSlice(offset + 2, 12).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_INT, offset + 14, this.barMultiple);
        var varOffset = offset + 18;
        if (this.markerName != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.markerName, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 18;
        if (markerName != null) size += PacketIO.stringSize(markerName);

        return size;
    }

    public MusicSync clone() {
        MusicSync copy = new MusicSync();
        copy.point = this.point;
        copy.markerName = this.markerName;
        copy.offset = this.offset != null ? this.offset.clone() : null;
        copy.barMultiple = this.barMultiple;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MusicSync other)) return false;
        return java.util.Objects.equals(this.point, other.point) && java.util.Objects.equals(this.markerName, other.markerName) && java.util.Objects.equals(this.offset, other.offset) && this.barMultiple == other.barMultiple;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(point, markerName, offset, barMultiple);
    }

}