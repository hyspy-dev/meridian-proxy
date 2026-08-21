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


public class UpdateWeather implements Packet, ToClientPacket {
    public static final int PACKET_ID = 149;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 8;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 8;
    public static final int MAX_SIZE = 8;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int weatherIndex;
    public float transitionSeconds;

    public UpdateWeather() {
    }

    public UpdateWeather(int weatherIndex, float transitionSeconds) {
        this.weatherIndex = weatherIndex;
        this.transitionSeconds = transitionSeconds;
    }

    public UpdateWeather(@Nonnull UpdateWeather other) {
        this.weatherIndex = other.weatherIndex;
        this.transitionSeconds = other.transitionSeconds;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateWeather", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateWeather", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getWeatherIndex(MemorySegment mem) {
        return getWeatherIndex(mem, 0);
    }
    
    public static int getWeatherIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static float getTransitionSeconds(MemorySegment mem) {
        return getTransitionSeconds(mem, 0);
    }
    
    public static float getTransitionSeconds(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "TransitionSeconds");
    }
    
    
    
    
    
    public static UpdateWeather toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateWeather toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateWeather and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateWeather toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new UpdateWeather(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "TransitionSeconds")
        );
        if (cursor != null) cursor.position = offset + 8;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.weatherIndex);
        PacketIO.requireFinite(this.transitionSeconds, "TransitionSeconds"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.transitionSeconds);
        
        
    
       return 8;
    }
    public int computeSize() {
        return 8;
    }

    public UpdateWeather clone() {
        UpdateWeather copy = new UpdateWeather();
        copy.weatherIndex = this.weatherIndex;
        copy.transitionSeconds = this.transitionSeconds;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateWeather other)) return false;
        return this.weatherIndex == other.weatherIndex && this.transitionSeconds == other.transitionSeconds;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(weatherIndex, transitionSeconds);
    }

}