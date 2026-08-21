// Auto-generated - do not edit
package meridian.protocol.packets.buildertools;

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


public class BuilderToolRotateClipboard implements Packet, ToServerPacket {
    public static final int PACKET_ID = 406;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 5;
    public static final int MAX_SIZE = 5;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int angle;
    @Nonnull public Axis axis = Axis.X;

    public BuilderToolRotateClipboard() {
    }

    public BuilderToolRotateClipboard(int angle, @Nonnull Axis axis) {
        this.angle = angle;
        this.axis = axis;
    }

    public BuilderToolRotateClipboard(@Nonnull BuilderToolRotateClipboard other) {
        this.angle = other.angle;
        this.axis = other.axis;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolRotateClipboard", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolRotateClipboard", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getAngle(MemorySegment mem) {
        return getAngle(mem, 0);
    }
    
    public static int getAngle(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static Axis getAxis(MemorySegment mem) {
        return getAxis(mem, 0);
    }
    
    public static Axis getAxis(MemorySegment mem, int offset) {
        return Axis.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 4));
    }
    
    
    
    
    
    public static BuilderToolRotateClipboard toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolRotateClipboard toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolRotateClipboard and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolRotateClipboard toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BuilderToolRotateClipboard(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            Axis.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 4))
        );
        if (cursor != null) cursor.position = offset + 5;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.angle);
        mem.set(PacketIO.PROTO_BYTE, offset + 4, (byte) this.axis.getValue());
        
        
    
       return 5;
    }
    public int computeSize() {
        return 5;
    }

    public BuilderToolRotateClipboard clone() {
        BuilderToolRotateClipboard copy = new BuilderToolRotateClipboard();
        copy.angle = this.angle;
        copy.axis = this.axis;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolRotateClipboard other)) return false;
        return this.angle == other.angle && java.util.Objects.equals(this.axis, other.axis);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(angle, axis);
    }

}