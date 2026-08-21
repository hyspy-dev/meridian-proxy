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
import meridian.protocol.GameMode;

public class SetGameMode implements Packet, ToClientPacket {
    public static final int PACKET_ID = 101;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public GameMode gameMode = GameMode.Adventure;

    public SetGameMode() {
    }

    public SetGameMode(@Nonnull GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public SetGameMode(@Nonnull SetGameMode other) {
        this.gameMode = other.gameMode;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SetGameMode", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SetGameMode", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static GameMode getGameMode(MemorySegment mem) {
        return getGameMode(mem, 0);
    }
    
    public static GameMode getGameMode(MemorySegment mem, int offset) {
        return GameMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0));
    }
    
    
    
    
    
    public static SetGameMode toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SetGameMode toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SetGameMode and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SetGameMode toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new SetGameMode(
            GameMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0))
        );
        if (cursor != null) cursor.position = offset + 1;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, (byte) this.gameMode.getValue());
        
        
    
       return 1;
    }
    public int computeSize() {
        return 1;
    }

    public SetGameMode clone() {
        SetGameMode copy = new SetGameMode();
        copy.gameMode = this.gameMode;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SetGameMode other)) return false;
        return java.util.Objects.equals(this.gameMode, other.gameMode);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(gameMode);
    }

}