// Auto-generated - do not edit
package meridian.protocol.packets.world;

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
import meridian.protocol.InstantData;

public class UpdateEditorTimeOverride implements Packet, ToClientPacket {
    public static final int PACKET_ID = 147;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 13;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 13;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public InstantData gameTime = new InstantData();
    public boolean paused;

    public UpdateEditorTimeOverride() {
    }

    public UpdateEditorTimeOverride(@Nonnull InstantData gameTime, boolean paused) {
        this.gameTime = gameTime;
        this.paused = paused;
    }

    public UpdateEditorTimeOverride(@Nonnull UpdateEditorTimeOverride other) {
        this.gameTime = other.gameTime;
        this.paused = other.paused;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateEditorTimeOverride", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateEditorTimeOverride", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static InstantData getGameTime(MemorySegment mem) {
        return getGameTime(mem, 0);
    }
    
    public static InstantData getGameTime(MemorySegment mem, int offset) {
        return InstantData.toObject(mem, offset + 0);
    }
    
    public static boolean getPaused(MemorySegment mem) {
        return getPaused(mem, 0);
    }
    
    public static boolean getPaused(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 12);
    }
    
    
    
    
    
    public static UpdateEditorTimeOverride toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateEditorTimeOverride toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateEditorTimeOverride and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateEditorTimeOverride toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new UpdateEditorTimeOverride(
            InstantData.toObject(mem, offset + 0),
            mem.get(PacketIO.PROTO_BOOL, offset + 12)
        );
        if (cursor != null) cursor.position = offset + 13;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        this.gameTime.serialize(mem, offset + 0);
        mem.set(PacketIO.PROTO_BOOL, offset + 12, this.paused);
        
        
    
       return 13;
    }
    public int computeSize() {
        return 13;
    }

    public UpdateEditorTimeOverride clone() {
        UpdateEditorTimeOverride copy = new UpdateEditorTimeOverride();
        copy.gameTime = this.gameTime.clone();
        copy.paused = this.paused;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateEditorTimeOverride other)) return false;
        return java.util.Objects.equals(this.gameTime, other.gameTime) && this.paused == other.paused;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(gameTime, paused);
    }

}