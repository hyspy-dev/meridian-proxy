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


public class BuilderToolResetClipboardRotation implements Packet, ToServerPacket {
    public static final int PACKET_ID = 427;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 0;
    public static final int MAX_SIZE = 0;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }



    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolResetClipboardRotation", offset, (int) mem.byteSize());
        long needed = (long) offset + 0;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolResetClipboardRotation", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    
    
    
    
    
    
    public static BuilderToolResetClipboardRotation toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolResetClipboardRotation toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolResetClipboardRotation and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolResetClipboardRotation toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BuilderToolResetClipboardRotation(
            
        );
        if (cursor != null) cursor.position = offset + 0;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        
        
    
       return 0;
    }
    public int computeSize() {
        return 0;
    }

    public BuilderToolResetClipboardRotation clone() {
        return new BuilderToolResetClipboardRotation();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolResetClipboardRotation other)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

}