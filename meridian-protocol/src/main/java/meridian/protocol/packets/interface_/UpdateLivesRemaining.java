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


public class UpdateLivesRemaining implements Packet, ToClientPacket {
    public static final int PACKET_ID = 249;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
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

    @Nullable public Integer remaining;

    public UpdateLivesRemaining() {
    }

    public UpdateLivesRemaining(@Nullable Integer remaining) {
        this.remaining = remaining;
    }

    public UpdateLivesRemaining(@Nonnull UpdateLivesRemaining other) {
        this.remaining = other.remaining;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateLivesRemaining", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateLivesRemaining", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static Integer getRemaining(MemorySegment mem) {
        return getRemaining(mem, 0);
    }
    
    @Nullable
    public static Integer getRemaining(MemorySegment mem, int offset) {
        return hasRemaining(mem, offset) ? mem.get(PacketIO.PROTO_INT, offset + 1): null;
    }
    
    public static boolean hasRemaining(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static UpdateLivesRemaining toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateLivesRemaining toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateLivesRemaining and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateLivesRemaining toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new UpdateLivesRemaining(
            hasRemaining(mem, offset) ? mem.get(PacketIO.PROTO_INT, offset + 1) : null
        );
        if (cursor != null) cursor.position = offset + 5;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.remaining != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.remaining != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, this.remaining);
        } else {
            mem.asSlice(offset + 1, 4).fill((byte) 0); 
        }
        
        
    
       return 5;
    }
    public int computeSize() {
        return 5;
    }

    public UpdateLivesRemaining clone() {
        UpdateLivesRemaining copy = new UpdateLivesRemaining();
        copy.remaining = this.remaining;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateLivesRemaining other)) return false;
        return java.util.Objects.equals(this.remaining, other.remaining);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(remaining);
    }

}