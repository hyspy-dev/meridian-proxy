// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

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


public class HideEventTitle implements Packet, ToClientPacket {
    public static final int PACKET_ID = 215;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 4;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 4;
    public static final int MAX_SIZE = 4;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public float fadeOutDuration;

    public HideEventTitle() {
    }

    public HideEventTitle(float fadeOutDuration) {
        this.fadeOutDuration = fadeOutDuration;
    }

    public HideEventTitle(@Nonnull HideEventTitle other) {
        this.fadeOutDuration = other.fadeOutDuration;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("HideEventTitle", offset, (int) mem.byteSize());
        long needed = (long) offset + 4;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("HideEventTitle", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getFadeOutDuration(MemorySegment mem) {
        return getFadeOutDuration(mem, 0);
    }
    
    public static float getFadeOutDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "FadeOutDuration");
    }
    
    
    
    
    
    public static HideEventTitle toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static HideEventTitle toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one HideEventTitle and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static HideEventTitle toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new HideEventTitle(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "FadeOutDuration")
        );
        if (cursor != null) cursor.position = offset + 4;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.fadeOutDuration, "FadeOutDuration"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.fadeOutDuration);
        
        
    
       return 4;
    }
    public int computeSize() {
        return 4;
    }

    public HideEventTitle clone() {
        HideEventTitle copy = new HideEventTitle();
        copy.fadeOutDuration = this.fadeOutDuration;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof HideEventTitle other)) return false;
        return this.fadeOutDuration == other.fadeOutDuration;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(fadeOutDuration);
    }

}