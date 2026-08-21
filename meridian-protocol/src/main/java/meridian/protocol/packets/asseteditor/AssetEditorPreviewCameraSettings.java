// Auto-generated - do not edit
package meridian.protocol.packets.asseteditor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import org.joml.*;

public class AssetEditorPreviewCameraSettings {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 28;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 28;
    public static final int MAX_SIZE = 28;

    public float modelScale;
    @Nonnull public Vector3fc cameraPosition = PacketIO.ZERO_VECTOR3;
    @Nonnull public Vector3fc cameraOrientation = PacketIO.ZERO_VECTOR3;

    public AssetEditorPreviewCameraSettings() {
    }

    public AssetEditorPreviewCameraSettings(float modelScale, @Nonnull Vector3fc cameraPosition, @Nonnull Vector3fc cameraOrientation) {
        this.modelScale = modelScale;
        this.cameraPosition = cameraPosition;
        this.cameraOrientation = cameraOrientation;
    }

    public AssetEditorPreviewCameraSettings(@Nonnull AssetEditorPreviewCameraSettings other) {
        this.modelScale = other.modelScale;
        this.cameraPosition = other.cameraPosition;
        this.cameraOrientation = other.cameraOrientation;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorPreviewCameraSettings", offset, (int) mem.byteSize());
        long needed = (long) offset + 28;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorPreviewCameraSettings", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getModelScale(MemorySegment mem) {
        return getModelScale(mem, 0);
    }
    
    public static float getModelScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "ModelScale");
    }
    
    public static Vector3fc getCameraPosition(MemorySegment mem) {
        return getCameraPosition(mem, 0);
    }
    
    public static Vector3fc getCameraPosition(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 4), "CameraPosition");
    }
    
    public static Vector3fc getCameraOrientation(MemorySegment mem) {
        return getCameraOrientation(mem, 0);
    }
    
    public static Vector3fc getCameraOrientation(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 16), "CameraOrientation");
    }
    
    
    
    
    
    public static AssetEditorPreviewCameraSettings toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorPreviewCameraSettings toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorPreviewCameraSettings and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorPreviewCameraSettings toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new AssetEditorPreviewCameraSettings(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "ModelScale"),
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 4), "CameraPosition"),
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 16), "CameraOrientation")
        );
        if (cursor != null) cursor.position = offset + 28;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.modelScale, "ModelScale"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.modelScale);
        PacketIO.requireFinite(this.cameraPosition, "CameraPosition"); PacketIO.writeVector3f(mem, offset + 4, this.cameraPosition);
        PacketIO.requireFinite(this.cameraOrientation, "CameraOrientation"); PacketIO.writeVector3f(mem, offset + 16, this.cameraOrientation);
        
        
    
       return 28;
    }
    public int computeSize() {
        return 28;
    }

    public AssetEditorPreviewCameraSettings clone() {
        AssetEditorPreviewCameraSettings copy = new AssetEditorPreviewCameraSettings();
        copy.modelScale = this.modelScale;
        copy.cameraPosition = this.cameraPosition;
        copy.cameraOrientation = this.cameraOrientation;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorPreviewCameraSettings other)) return false;
        return this.modelScale == other.modelScale && java.util.Objects.equals(this.cameraPosition, other.cameraPosition) && java.util.Objects.equals(this.cameraOrientation, other.cameraOrientation);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(modelScale, cameraPosition, cameraOrientation);
    }

}