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
import meridian.protocol.MovementSettings;

public class UpdateMovementSettings implements Packet, ToClientPacket {
    public static final int PACKET_ID = 110;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 259;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 259;
    public static final int MAX_SIZE = 259;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public MovementSettings movementSettings = new MovementSettings();

    public UpdateMovementSettings() {
    }

    public UpdateMovementSettings(@Nonnull MovementSettings movementSettings) {
        this.movementSettings = movementSettings;
    }

    public UpdateMovementSettings(@Nonnull UpdateMovementSettings other) {
        this.movementSettings = other.movementSettings;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateMovementSettings", offset, (int) mem.byteSize());
        long needed = (long) offset + 259;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateMovementSettings", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static MovementSettings getMovementSettings(MemorySegment mem) {
        return getMovementSettings(mem, 0);
    }
    
    public static MovementSettings getMovementSettings(MemorySegment mem, int offset) {
        return MovementSettings.toObject(mem, offset + 0);
    }
    
    
    
    
    
    public static UpdateMovementSettings toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateMovementSettings toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateMovementSettings and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateMovementSettings toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new UpdateMovementSettings(
            MovementSettings.toObject(mem, offset + 0)
        );
        if (cursor != null) cursor.position = offset + 259;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        this.movementSettings.serialize(mem, offset + 0);
        
        
    
       return 259;
    }
    public int computeSize() {
        return 259;
    }

    public UpdateMovementSettings clone() {
        UpdateMovementSettings copy = new UpdateMovementSettings();
        copy.movementSettings = this.movementSettings.clone();
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateMovementSettings other)) return false;
        return java.util.Objects.equals(this.movementSettings, other.movementSettings);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(movementSettings);
    }

}