// Auto-generated - do not edit
package meridian.protocol.packets.player;

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


public class UpdatePointDisplay implements Packet, ToClientPacket {
    public static final int PACKET_ID = 518;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public PointDisplayEntry[] points;

    public UpdatePointDisplay() {
    }

    public UpdatePointDisplay(@Nullable PointDisplayEntry[] points) {
        this.points = points;
    }

    public UpdatePointDisplay(@Nonnull UpdatePointDisplay other) {
        this.points = other.points;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdatePointDisplay", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdatePointDisplay", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static PointDisplayEntry[] getPoints(MemorySegment mem) {
        return getPoints(mem, 0);
    }
    
    @Nullable
    public static PointDisplayEntry[] getPoints(MemorySegment mem, int offset) {
        if (!hasPoints(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Points");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Points", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 38 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Points", (int) java.lang.Math.min(off + lenOffset + (long) len * 38, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new PointDisplayEntry[len];
        for (var i = 0; i < len; i++) {
            data[i] = PointDisplayEntry.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasPoints(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static UpdatePointDisplay toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdatePointDisplay toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdatePointDisplay and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdatePointDisplay toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        PointDisplayEntry[] v0 = null;
        if (hasPoints(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Points");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Points", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 38 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Points", (int) java.lang.Math.min(off + lenOffset + (long) len * 38, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new PointDisplayEntry[len];
            for (var i = 0; i < len; i++) {
                v0[i] = PointDisplayEntry.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new UpdatePointDisplay(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.points != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.points != null) {
            
            if (points.length > 4096000) throw ProtocolException.arrayTooLong("Points", points.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.points.length);
            
            var pointsValueOffset = 0;
            for (var i = 0; i < this.points.length; i++) {
                pointsValueOffset += this.points[i].serialize(mem, varOffset + pointsValueOffset);
            }
            varOffset += pointsValueOffset;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (points != null) {
        int pointsSize = 0;
for (var elem : points) pointsSize += elem.computeSize();
size += VarInt.size(points.length) + pointsSize;
    }

        return size;
    }

    public UpdatePointDisplay clone() {
        UpdatePointDisplay copy = new UpdatePointDisplay();
        copy.points = this.points != null ? java.util.Arrays.stream(this.points).map(e -> e.clone()).toArray(PointDisplayEntry[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdatePointDisplay other)) return false;
        return java.util.Arrays.equals(this.points, other.points);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(points);
        return result;
    }

}