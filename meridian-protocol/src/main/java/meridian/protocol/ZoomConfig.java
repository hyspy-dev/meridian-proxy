// Auto-generated - do not edit
package meridian.protocol;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class ZoomConfig {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 32;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 32;
    public static final int MAX_SIZE = 16384037;

    public float magnificationMultiplier;
    public float mouseSensitivityMultiplier;
    @Nullable public String overlayTexture;
    public boolean depthOfField;
    public boolean allowCameraOrbit;
    @Nonnull public ForcedPerspective forcePerspective = ForcedPerspective.None;
    public float lodMultiplier;
    public float inLerp;
    public float outLerp;
    public boolean overlayFade;
    public float overlayFadeInPerSecond;
    public float overlayFadeOutPerSecond;

    public ZoomConfig() {
    }

    public ZoomConfig(float magnificationMultiplier, float mouseSensitivityMultiplier, @Nullable String overlayTexture, boolean depthOfField, boolean allowCameraOrbit, @Nonnull ForcedPerspective forcePerspective, float lodMultiplier, float inLerp, float outLerp, boolean overlayFade, float overlayFadeInPerSecond, float overlayFadeOutPerSecond) {
        this.magnificationMultiplier = magnificationMultiplier;
        this.mouseSensitivityMultiplier = mouseSensitivityMultiplier;
        this.overlayTexture = overlayTexture;
        this.depthOfField = depthOfField;
        this.allowCameraOrbit = allowCameraOrbit;
        this.forcePerspective = forcePerspective;
        this.lodMultiplier = lodMultiplier;
        this.inLerp = inLerp;
        this.outLerp = outLerp;
        this.overlayFade = overlayFade;
        this.overlayFadeInPerSecond = overlayFadeInPerSecond;
        this.overlayFadeOutPerSecond = overlayFadeOutPerSecond;
    }

    public ZoomConfig(@Nonnull ZoomConfig other) {
        this.magnificationMultiplier = other.magnificationMultiplier;
        this.mouseSensitivityMultiplier = other.mouseSensitivityMultiplier;
        this.overlayTexture = other.overlayTexture;
        this.depthOfField = other.depthOfField;
        this.allowCameraOrbit = other.allowCameraOrbit;
        this.forcePerspective = other.forcePerspective;
        this.lodMultiplier = other.lodMultiplier;
        this.inLerp = other.inLerp;
        this.outLerp = other.outLerp;
        this.overlayFade = other.overlayFade;
        this.overlayFadeInPerSecond = other.overlayFadeInPerSecond;
        this.overlayFadeOutPerSecond = other.overlayFadeOutPerSecond;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ZoomConfig", offset, (int) mem.byteSize());
        long needed = (long) offset + 32;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ZoomConfig", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getMagnificationMultiplier(MemorySegment mem) {
        return getMagnificationMultiplier(mem, 0);
    }
    
    public static float getMagnificationMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "MagnificationMultiplier");
    }
    
    public static float getMouseSensitivityMultiplier(MemorySegment mem) {
        return getMouseSensitivityMultiplier(mem, 0);
    }
    
    public static float getMouseSensitivityMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "MouseSensitivityMultiplier");
    }
    
    @Nullable
    public static String getOverlayTexture(MemorySegment mem) {
        return getOverlayTexture(mem, 0);
    }
    
    @Nullable
    public static String getOverlayTexture(MemorySegment mem, int offset) {
        return hasOverlayTexture(mem, offset) ? PacketIO.readVarString("OverlayTexture", mem, offset + 32, 4096000): null;
    }
    
    public static boolean getDepthOfField(MemorySegment mem) {
        return getDepthOfField(mem, 0);
    }
    
    public static boolean getDepthOfField(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 9) & 0x01) != 0;
    }
    
    public static boolean getAllowCameraOrbit(MemorySegment mem) {
        return getAllowCameraOrbit(mem, 0);
    }
    
    public static boolean getAllowCameraOrbit(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 9) & 0x02) != 0;
    }
    
    public static ForcedPerspective getForcePerspective(MemorySegment mem) {
        return getForcePerspective(mem, 0);
    }
    
    public static ForcedPerspective getForcePerspective(MemorySegment mem, int offset) {
        return ForcedPerspective.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 10));
    }
    
    public static float getLodMultiplier(MemorySegment mem) {
        return getLodMultiplier(mem, 0);
    }
    
    public static float getLodMultiplier(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 11), "LodMultiplier");
    }
    
    public static float getInLerp(MemorySegment mem) {
        return getInLerp(mem, 0);
    }
    
    public static float getInLerp(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 15), "InLerp");
    }
    
    public static float getOutLerp(MemorySegment mem) {
        return getOutLerp(mem, 0);
    }
    
    public static float getOutLerp(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 19), "OutLerp");
    }
    
    public static boolean getOverlayFade(MemorySegment mem) {
        return getOverlayFade(mem, 0);
    }
    
    public static boolean getOverlayFade(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 23);
    }
    
    public static float getOverlayFadeInPerSecond(MemorySegment mem) {
        return getOverlayFadeInPerSecond(mem, 0);
    }
    
    public static float getOverlayFadeInPerSecond(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 24), "OverlayFadeInPerSecond");
    }
    
    public static float getOverlayFadeOutPerSecond(MemorySegment mem) {
        return getOverlayFadeOutPerSecond(mem, 0);
    }
    
    public static float getOverlayFadeOutPerSecond(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 28), "OverlayFadeOutPerSecond");
    }
    
    public static boolean hasOverlayTexture(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static ZoomConfig toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ZoomConfig toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ZoomConfig and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ZoomConfig toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 32;
        var varPos = 0;
        String v2 = null;
        if (hasOverlayTexture(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("OverlayTexture", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new ZoomConfig(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "MagnificationMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "MouseSensitivityMultiplier"),
            v2,
            (mem.get(PacketIO.PROTO_BYTE, offset + 9) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 9) & 0x02) != 0,
            ForcedPerspective.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 10)),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 11), "LodMultiplier"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 15), "InLerp"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 19), "OutLerp"),
            mem.get(PacketIO.PROTO_BOOL, offset + 23),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 24), "OverlayFadeInPerSecond"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 28), "OverlayFadeOutPerSecond")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.overlayTexture != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.magnificationMultiplier, "MagnificationMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.magnificationMultiplier);
        PacketIO.requireFinite(this.mouseSensitivityMultiplier, "MouseSensitivityMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.mouseSensitivityMultiplier);
        byte boolBits0_0 = 0;
        if (this.depthOfField) boolBits0_0 |= 0x01;
        if (this.allowCameraOrbit) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 9 + 0, boolBits0_0);
        mem.set(PacketIO.PROTO_BYTE, offset + 10, (byte) this.forcePerspective.getValue());
        PacketIO.requireFinite(this.lodMultiplier, "LodMultiplier"); mem.set(PacketIO.PROTO_FLOAT, offset + 11, this.lodMultiplier);
        PacketIO.requireFinite(this.inLerp, "InLerp"); mem.set(PacketIO.PROTO_FLOAT, offset + 15, this.inLerp);
        PacketIO.requireFinite(this.outLerp, "OutLerp"); mem.set(PacketIO.PROTO_FLOAT, offset + 19, this.outLerp);
        mem.set(PacketIO.PROTO_BOOL, offset + 23, this.overlayFade);
        PacketIO.requireFinite(this.overlayFadeInPerSecond, "OverlayFadeInPerSecond"); mem.set(PacketIO.PROTO_FLOAT, offset + 24, this.overlayFadeInPerSecond);
        PacketIO.requireFinite(this.overlayFadeOutPerSecond, "OverlayFadeOutPerSecond"); mem.set(PacketIO.PROTO_FLOAT, offset + 28, this.overlayFadeOutPerSecond);
        var varOffset = offset + 32;
        if (this.overlayTexture != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.overlayTexture, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 32;
        if (overlayTexture != null) size += PacketIO.stringSize(overlayTexture);

        return size;
    }

    public ZoomConfig clone() {
        ZoomConfig copy = new ZoomConfig();
        copy.magnificationMultiplier = this.magnificationMultiplier;
        copy.mouseSensitivityMultiplier = this.mouseSensitivityMultiplier;
        copy.overlayTexture = this.overlayTexture;
        copy.depthOfField = this.depthOfField;
        copy.allowCameraOrbit = this.allowCameraOrbit;
        copy.forcePerspective = this.forcePerspective;
        copy.lodMultiplier = this.lodMultiplier;
        copy.inLerp = this.inLerp;
        copy.outLerp = this.outLerp;
        copy.overlayFade = this.overlayFade;
        copy.overlayFadeInPerSecond = this.overlayFadeInPerSecond;
        copy.overlayFadeOutPerSecond = this.overlayFadeOutPerSecond;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ZoomConfig other)) return false;
        return this.magnificationMultiplier == other.magnificationMultiplier && this.mouseSensitivityMultiplier == other.mouseSensitivityMultiplier && java.util.Objects.equals(this.overlayTexture, other.overlayTexture) && this.depthOfField == other.depthOfField && this.allowCameraOrbit == other.allowCameraOrbit && java.util.Objects.equals(this.forcePerspective, other.forcePerspective) && this.lodMultiplier == other.lodMultiplier && this.inLerp == other.inLerp && this.outLerp == other.outLerp && this.overlayFade == other.overlayFade && this.overlayFadeInPerSecond == other.overlayFadeInPerSecond && this.overlayFadeOutPerSecond == other.overlayFadeOutPerSecond;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(magnificationMultiplier, mouseSensitivityMultiplier, overlayTexture, depthOfField, allowCameraOrbit, forcePerspective, lodMultiplier, inLerp, outLerp, overlayFade, overlayFadeInPerSecond, overlayFadeOutPerSecond);
    }

}