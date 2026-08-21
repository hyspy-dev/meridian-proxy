// Auto-generated - do not edit
package meridian.protocol.packets.camera;

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
import meridian.protocol.AccumulationMode;

public class CameraShakeEffect implements Packet, ToClientPacket {
    public static final int PACKET_ID = 281;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 9;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int cameraShakeId;
    public float intensity;
    @Nonnull public AccumulationMode mode = AccumulationMode.Set;

    public CameraShakeEffect() {
    }

    public CameraShakeEffect(int cameraShakeId, float intensity, @Nonnull AccumulationMode mode) {
        this.cameraShakeId = cameraShakeId;
        this.intensity = intensity;
        this.mode = mode;
    }

    public CameraShakeEffect(@Nonnull CameraShakeEffect other) {
        this.cameraShakeId = other.cameraShakeId;
        this.intensity = other.intensity;
        this.mode = other.mode;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CameraShakeEffect", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CameraShakeEffect", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getCameraShakeId(MemorySegment mem) {
        return getCameraShakeId(mem, 0);
    }
    
    public static int getCameraShakeId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static float getIntensity(MemorySegment mem) {
        return getIntensity(mem, 0);
    }
    
    public static float getIntensity(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "Intensity");
    }
    
    public static AccumulationMode getMode(MemorySegment mem) {
        return getMode(mem, 0);
    }
    
    public static AccumulationMode getMode(MemorySegment mem, int offset) {
        return AccumulationMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 8));
    }
    
    
    
    
    
    public static CameraShakeEffect toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CameraShakeEffect toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CameraShakeEffect and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CameraShakeEffect toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new CameraShakeEffect(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "Intensity"),
            AccumulationMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 8))
        );
        if (cursor != null) cursor.position = offset + 9;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.cameraShakeId);
        PacketIO.requireFinite(this.intensity, "Intensity"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.intensity);
        mem.set(PacketIO.PROTO_BYTE, offset + 8, (byte) this.mode.getValue());
        
        
    
       return 9;
    }
    public int computeSize() {
        return 9;
    }

    public CameraShakeEffect clone() {
        CameraShakeEffect copy = new CameraShakeEffect();
        copy.cameraShakeId = this.cameraShakeId;
        copy.intensity = this.intensity;
        copy.mode = this.mode;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CameraShakeEffect other)) return false;
        return this.cameraShakeId == other.cameraShakeId && this.intensity == other.intensity && java.util.Objects.equals(this.mode, other.mode);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(cameraShakeId, intensity, mode);
    }

}