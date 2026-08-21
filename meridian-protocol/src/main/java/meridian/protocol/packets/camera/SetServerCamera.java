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
import meridian.protocol.ClientCameraView;
import meridian.protocol.ServerCameraSettings;

public class SetServerCamera implements Packet, ToClientPacket {
    public static final int PACKET_ID = 280;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 182;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 182;
    public static final int MAX_SIZE = 182;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public ClientCameraView clientCameraView = ClientCameraView.FirstPerson;
    public boolean isLocked;
    @Nullable public ServerCameraSettings cameraSettings;

    public SetServerCamera() {
    }

    public SetServerCamera(@Nonnull ClientCameraView clientCameraView, boolean isLocked, @Nullable ServerCameraSettings cameraSettings) {
        this.clientCameraView = clientCameraView;
        this.isLocked = isLocked;
        this.cameraSettings = cameraSettings;
    }

    public SetServerCamera(@Nonnull SetServerCamera other) {
        this.clientCameraView = other.clientCameraView;
        this.isLocked = other.isLocked;
        this.cameraSettings = other.cameraSettings;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SetServerCamera", offset, (int) mem.byteSize());
        long needed = (long) offset + 182;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SetServerCamera", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static ClientCameraView getClientCameraView(MemorySegment mem) {
        return getClientCameraView(mem, 0);
    }
    
    public static ClientCameraView getClientCameraView(MemorySegment mem, int offset) {
        return ClientCameraView.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static boolean getIsLocked(MemorySegment mem) {
        return getIsLocked(mem, 0);
    }
    
    public static boolean getIsLocked(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 2);
    }
    
    @Nullable
    public static ServerCameraSettings getCameraSettings(MemorySegment mem) {
        return getCameraSettings(mem, 0);
    }
    
    @Nullable
    public static ServerCameraSettings getCameraSettings(MemorySegment mem, int offset) {
        return hasCameraSettings(mem, offset) ? ServerCameraSettings.toObject(mem, offset + 3): null;
    }
    
    public static boolean hasCameraSettings(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static SetServerCamera toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SetServerCamera toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SetServerCamera and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SetServerCamera toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new SetServerCamera(
            ClientCameraView.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            mem.get(PacketIO.PROTO_BOOL, offset + 2),
            hasCameraSettings(mem, offset) ? ServerCameraSettings.toObject(mem, offset + 3) : null
        );
        if (cursor != null) cursor.position = offset + 182;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.cameraSettings != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.clientCameraView.getValue());
        mem.set(PacketIO.PROTO_BOOL, offset + 2, this.isLocked);
        if (this.cameraSettings != null) {
            this.cameraSettings.serialize(mem, offset + 3);
        } else {
            mem.asSlice(offset + 3, 179).fill((byte) 0); 
        }
        
        
    
       return 182;
    }
    public int computeSize() {
        return 182;
    }

    public SetServerCamera clone() {
        SetServerCamera copy = new SetServerCamera();
        copy.clientCameraView = this.clientCameraView;
        copy.isLocked = this.isLocked;
        copy.cameraSettings = this.cameraSettings != null ? this.cameraSettings.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SetServerCamera other)) return false;
        return java.util.Objects.equals(this.clientCameraView, other.clientCameraView) && this.isLocked == other.isLocked && java.util.Objects.equals(this.cameraSettings, other.cameraSettings);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(clientCameraView, isLocked, cameraSettings);
    }

}