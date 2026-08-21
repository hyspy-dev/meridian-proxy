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


public class UpdateTimeSettings implements Packet, ToClientPacket {
    public static final int PACKET_ID = 145;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 10;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 10;
    public static final int MAX_SIZE = 10;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int daytimeDurationSeconds;
    public int nighttimeDurationSeconds;
    public byte totalMoonPhases;
    public boolean timePaused;

    public UpdateTimeSettings() {
    }

    public UpdateTimeSettings(int daytimeDurationSeconds, int nighttimeDurationSeconds, byte totalMoonPhases, boolean timePaused) {
        this.daytimeDurationSeconds = daytimeDurationSeconds;
        this.nighttimeDurationSeconds = nighttimeDurationSeconds;
        this.totalMoonPhases = totalMoonPhases;
        this.timePaused = timePaused;
    }

    public UpdateTimeSettings(@Nonnull UpdateTimeSettings other) {
        this.daytimeDurationSeconds = other.daytimeDurationSeconds;
        this.nighttimeDurationSeconds = other.nighttimeDurationSeconds;
        this.totalMoonPhases = other.totalMoonPhases;
        this.timePaused = other.timePaused;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateTimeSettings", offset, (int) mem.byteSize());
        long needed = (long) offset + 10;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateTimeSettings", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getDaytimeDurationSeconds(MemorySegment mem) {
        return getDaytimeDurationSeconds(mem, 0);
    }
    
    public static int getDaytimeDurationSeconds(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static int getNighttimeDurationSeconds(MemorySegment mem) {
        return getNighttimeDurationSeconds(mem, 0);
    }
    
    public static int getNighttimeDurationSeconds(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 4);
    }
    
    public static byte getTotalMoonPhases(MemorySegment mem) {
        return getTotalMoonPhases(mem, 0);
    }
    
    public static byte getTotalMoonPhases(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 8);
    }
    
    public static boolean getTimePaused(MemorySegment mem) {
        return getTimePaused(mem, 0);
    }
    
    public static boolean getTimePaused(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 9);
    }
    
    
    
    
    
    public static UpdateTimeSettings toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateTimeSettings toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateTimeSettings and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateTimeSettings toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new UpdateTimeSettings(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4),
            mem.get(PacketIO.PROTO_BYTE, offset + 8),
            mem.get(PacketIO.PROTO_BOOL, offset + 9)
        );
        if (cursor != null) cursor.position = offset + 10;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.daytimeDurationSeconds);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.nighttimeDurationSeconds);
        mem.set(PacketIO.PROTO_BYTE, offset + 8, this.totalMoonPhases);
        mem.set(PacketIO.PROTO_BOOL, offset + 9, this.timePaused);
        
        
    
       return 10;
    }
    public int computeSize() {
        return 10;
    }

    public UpdateTimeSettings clone() {
        UpdateTimeSettings copy = new UpdateTimeSettings();
        copy.daytimeDurationSeconds = this.daytimeDurationSeconds;
        copy.nighttimeDurationSeconds = this.nighttimeDurationSeconds;
        copy.totalMoonPhases = this.totalMoonPhases;
        copy.timePaused = this.timePaused;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateTimeSettings other)) return false;
        return this.daytimeDurationSeconds == other.daytimeDurationSeconds && this.nighttimeDurationSeconds == other.nighttimeDurationSeconds && this.totalMoonPhases == other.totalMoonPhases && this.timePaused == other.timePaused;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(daytimeDurationSeconds, nighttimeDurationSeconds, totalMoonPhases, timePaused);
    }

}