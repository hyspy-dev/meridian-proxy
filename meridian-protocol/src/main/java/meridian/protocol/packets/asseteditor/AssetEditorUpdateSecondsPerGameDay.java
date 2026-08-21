// Auto-generated - do not edit
package meridian.protocol.packets.asseteditor;

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


public class AssetEditorUpdateSecondsPerGameDay implements Packet, ToClientPacket {
    public static final int PACKET_ID = 353;
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

    public int daytimeDurationSeconds;
    public int nighttimeDurationSeconds;

    public AssetEditorUpdateSecondsPerGameDay() {
    }

    public AssetEditorUpdateSecondsPerGameDay(int daytimeDurationSeconds, int nighttimeDurationSeconds) {
        this.daytimeDurationSeconds = daytimeDurationSeconds;
        this.nighttimeDurationSeconds = nighttimeDurationSeconds;
    }

    public AssetEditorUpdateSecondsPerGameDay(@Nonnull AssetEditorUpdateSecondsPerGameDay other) {
        this.daytimeDurationSeconds = other.daytimeDurationSeconds;
        this.nighttimeDurationSeconds = other.nighttimeDurationSeconds;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorUpdateSecondsPerGameDay", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorUpdateSecondsPerGameDay", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
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
    
    
    
    
    
    public static AssetEditorUpdateSecondsPerGameDay toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorUpdateSecondsPerGameDay toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorUpdateSecondsPerGameDay and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorUpdateSecondsPerGameDay toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new AssetEditorUpdateSecondsPerGameDay(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4)
        );
        if (cursor != null) cursor.position = offset + 8;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.daytimeDurationSeconds);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.nighttimeDurationSeconds);
        
        
    
       return 8;
    }
    public int computeSize() {
        return 8;
    }

    public AssetEditorUpdateSecondsPerGameDay clone() {
        AssetEditorUpdateSecondsPerGameDay copy = new AssetEditorUpdateSecondsPerGameDay();
        copy.daytimeDurationSeconds = this.daytimeDurationSeconds;
        copy.nighttimeDurationSeconds = this.nighttimeDurationSeconds;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorUpdateSecondsPerGameDay other)) return false;
        return this.daytimeDurationSeconds == other.daytimeDurationSeconds && this.nighttimeDurationSeconds == other.nighttimeDurationSeconds;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(daytimeDurationSeconds, nighttimeDurationSeconds);
    }

}