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
import meridian.protocol.BlockPosition;
import meridian.protocol.MusicEmitterConfig;

public class SetBlockMusicEmitter implements Packet, ToClientPacket {
    public static final int PACKET_ID = 169;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 50;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 50;
    public static final int MAX_SIZE = 50;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Chunks;
    }

    @Nullable public BlockPosition position;
    @Nullable public MusicEmitterConfig emitter;
    public long playbackOffsetMillis;

    public SetBlockMusicEmitter() {
    }

    public SetBlockMusicEmitter(@Nullable BlockPosition position, @Nullable MusicEmitterConfig emitter, long playbackOffsetMillis) {
        this.position = position;
        this.emitter = emitter;
        this.playbackOffsetMillis = playbackOffsetMillis;
    }

    public SetBlockMusicEmitter(@Nonnull SetBlockMusicEmitter other) {
        this.position = other.position;
        this.emitter = other.emitter;
        this.playbackOffsetMillis = other.playbackOffsetMillis;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SetBlockMusicEmitter", offset, (int) mem.byteSize());
        long needed = (long) offset + 50;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SetBlockMusicEmitter", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static BlockPosition getPosition(MemorySegment mem) {
        return getPosition(mem, 0);
    }
    
    @Nullable
    public static BlockPosition getPosition(MemorySegment mem, int offset) {
        return hasPosition(mem, offset) ? BlockPosition.toObject(mem, offset + 1): null;
    }
    
    @Nullable
    public static MusicEmitterConfig getEmitter(MemorySegment mem) {
        return getEmitter(mem, 0);
    }
    
    @Nullable
    public static MusicEmitterConfig getEmitter(MemorySegment mem, int offset) {
        return hasEmitter(mem, offset) ? MusicEmitterConfig.toObject(mem, offset + 13): null;
    }
    
    public static long getPlaybackOffsetMillis(MemorySegment mem) {
        return getPlaybackOffsetMillis(mem, 0);
    }
    
    public static long getPlaybackOffsetMillis(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_LONG, offset + 42);
    }
    
    public static boolean hasPosition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasEmitter(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    
    
    public static SetBlockMusicEmitter toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SetBlockMusicEmitter toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SetBlockMusicEmitter and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SetBlockMusicEmitter toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new SetBlockMusicEmitter(
            hasPosition(mem, offset) ? BlockPosition.toObject(mem, offset + 1) : null,
            hasEmitter(mem, offset) ? MusicEmitterConfig.toObject(mem, offset + 13) : null,
            mem.get(PacketIO.PROTO_LONG, offset + 42)
        );
        if (cursor != null) cursor.position = offset + 50;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.position != null) nullBits |= 0x01;
        if (this.emitter != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.position != null) {
            this.position.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 12).fill((byte) 0); 
        }
        if (this.emitter != null) {
            this.emitter.serialize(mem, offset + 13);
        } else {
            mem.asSlice(offset + 13, 29).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_LONG, offset + 42, this.playbackOffsetMillis);
        
        
    
       return 50;
    }
    public int computeSize() {
        return 50;
    }

    public SetBlockMusicEmitter clone() {
        SetBlockMusicEmitter copy = new SetBlockMusicEmitter();
        copy.position = this.position != null ? this.position.clone() : null;
        copy.emitter = this.emitter != null ? this.emitter.clone() : null;
        copy.playbackOffsetMillis = this.playbackOffsetMillis;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SetBlockMusicEmitter other)) return false;
        return java.util.Objects.equals(this.position, other.position) && java.util.Objects.equals(this.emitter, other.emitter) && this.playbackOffsetMillis == other.playbackOffsetMillis;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(position, emitter, playbackOffsetMillis);
    }

}