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


public class MouseButtonEvent {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 3;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 3;
    public static final int MAX_SIZE = 3;

    @Nonnull public MouseButtonType mouseButtonType = MouseButtonType.Left;
    @Nonnull public MouseButtonState state = MouseButtonState.Pressed;
    public byte clicks;

    public MouseButtonEvent() {
    }

    public MouseButtonEvent(@Nonnull MouseButtonType mouseButtonType, @Nonnull MouseButtonState state, byte clicks) {
        this.mouseButtonType = mouseButtonType;
        this.state = state;
        this.clicks = clicks;
    }

    public MouseButtonEvent(@Nonnull MouseButtonEvent other) {
        this.mouseButtonType = other.mouseButtonType;
        this.state = other.state;
        this.clicks = other.clicks;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("MouseButtonEvent", offset, (int) mem.byteSize());
        long needed = (long) offset + 3;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("MouseButtonEvent", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static MouseButtonType getMouseButtonType(MemorySegment mem) {
        return getMouseButtonType(mem, 0);
    }
    
    public static MouseButtonType getMouseButtonType(MemorySegment mem, int offset) {
        return MouseButtonType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0));
    }
    
    public static MouseButtonState getState(MemorySegment mem) {
        return getState(mem, 0);
    }
    
    public static MouseButtonState getState(MemorySegment mem, int offset) {
        return MouseButtonState.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static byte getClicks(MemorySegment mem) {
        return getClicks(mem, 0);
    }
    
    public static byte getClicks(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 2);
    }
    
    
    
    
    
    public static MouseButtonEvent toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static MouseButtonEvent toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one MouseButtonEvent and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static MouseButtonEvent toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new MouseButtonEvent(
            MouseButtonType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0)),
            MouseButtonState.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            mem.get(PacketIO.PROTO_BYTE, offset + 2)
        );
        if (cursor != null) cursor.position = offset + 3;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, (byte) this.mouseButtonType.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.state.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 2, this.clicks);
        
        
    
       return 3;
    }
    public int computeSize() {
        return 3;
    }

    public MouseButtonEvent clone() {
        MouseButtonEvent copy = new MouseButtonEvent();
        copy.mouseButtonType = this.mouseButtonType;
        copy.state = this.state;
        copy.clicks = this.clicks;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MouseButtonEvent other)) return false;
        return java.util.Objects.equals(this.mouseButtonType, other.mouseButtonType) && java.util.Objects.equals(this.state, other.state) && this.clicks == other.clicks;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(mouseButtonType, state, clicks);
    }

}