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


public class UpdateSunSettings implements Packet, ToClientPacket {
    public static final int PACKET_ID = 360;
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

    public float heightPercentage;
    public float angleRadians;

    public UpdateSunSettings() {
    }

    public UpdateSunSettings(float heightPercentage, float angleRadians) {
        this.heightPercentage = heightPercentage;
        this.angleRadians = angleRadians;
    }

    public UpdateSunSettings(@Nonnull UpdateSunSettings other) {
        this.heightPercentage = other.heightPercentage;
        this.angleRadians = other.angleRadians;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateSunSettings", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateSunSettings", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getHeightPercentage(MemorySegment mem) {
        return getHeightPercentage(mem, 0);
    }
    
    public static float getHeightPercentage(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "HeightPercentage");
    }
    
    public static float getAngleRadians(MemorySegment mem) {
        return getAngleRadians(mem, 0);
    }
    
    public static float getAngleRadians(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "AngleRadians");
    }
    
    
    
    
    
    public static UpdateSunSettings toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateSunSettings toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateSunSettings and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateSunSettings toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new UpdateSunSettings(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "HeightPercentage"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "AngleRadians")
        );
        if (cursor != null) cursor.position = offset + 8;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.heightPercentage, "HeightPercentage"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.heightPercentage);
        PacketIO.requireFinite(this.angleRadians, "AngleRadians"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.angleRadians);
        
        
    
       return 8;
    }
    public int computeSize() {
        return 8;
    }

    public UpdateSunSettings clone() {
        UpdateSunSettings copy = new UpdateSunSettings();
        copy.heightPercentage = this.heightPercentage;
        copy.angleRadians = this.angleRadians;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateSunSettings other)) return false;
        return this.heightPercentage == other.heightPercentage && this.angleRadians == other.angleRadians;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(heightPercentage, angleRadians);
    }

}