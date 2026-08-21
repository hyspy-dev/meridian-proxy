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


public class FluidFX {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 61;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 69;
    public static final int MAX_SIZE = 32768087;

    @Nullable public String id;
    @Nonnull public ShaderType shader = ShaderType.None;
    @Nonnull public FluidFog fogMode = FluidFog.Color;
    @Nullable public Color fogColor;
    @Nullable public NearFar fogDistance;
    public float fogDepthStart;
    public float fogDepthFalloff;
    @Nullable public Color colorFilter;
    public float colorSaturation;
    public float distortionAmplitude;
    public float distortionFrequency;
    @Nullable public FluidParticle particle;
    @Nullable public FluidFXMovementSettings movementSettings;

    public FluidFX() {
    }

    public FluidFX(@Nullable String id, @Nonnull ShaderType shader, @Nonnull FluidFog fogMode, @Nullable Color fogColor, @Nullable NearFar fogDistance, float fogDepthStart, float fogDepthFalloff, @Nullable Color colorFilter, float colorSaturation, float distortionAmplitude, float distortionFrequency, @Nullable FluidParticle particle, @Nullable FluidFXMovementSettings movementSettings) {
        this.id = id;
        this.shader = shader;
        this.fogMode = fogMode;
        this.fogColor = fogColor;
        this.fogDistance = fogDistance;
        this.fogDepthStart = fogDepthStart;
        this.fogDepthFalloff = fogDepthFalloff;
        this.colorFilter = colorFilter;
        this.colorSaturation = colorSaturation;
        this.distortionAmplitude = distortionAmplitude;
        this.distortionFrequency = distortionFrequency;
        this.particle = particle;
        this.movementSettings = movementSettings;
    }

    public FluidFX(@Nonnull FluidFX other) {
        this.id = other.id;
        this.shader = other.shader;
        this.fogMode = other.fogMode;
        this.fogColor = other.fogColor;
        this.fogDistance = other.fogDistance;
        this.fogDepthStart = other.fogDepthStart;
        this.fogDepthFalloff = other.fogDepthFalloff;
        this.colorFilter = other.colorFilter;
        this.colorSaturation = other.colorSaturation;
        this.distortionAmplitude = other.distortionAmplitude;
        this.distortionFrequency = other.distortionFrequency;
        this.particle = other.particle;
        this.movementSettings = other.movementSettings;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("FluidFX", offset, (int) mem.byteSize());
        long needed = (long) offset + 69;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("FluidFX", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 61, 69, "Id"), 4096000): null;
    }
    
    public static ShaderType getShader(MemorySegment mem) {
        return getShader(mem, 0);
    }
    
    public static ShaderType getShader(MemorySegment mem, int offset) {
        return ShaderType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static FluidFog getFogMode(MemorySegment mem) {
        return getFogMode(mem, 0);
    }
    
    public static FluidFog getFogMode(MemorySegment mem, int offset) {
        return FluidFog.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2));
    }
    
    @Nullable
    public static Color getFogColor(MemorySegment mem) {
        return getFogColor(mem, 0);
    }
    
    @Nullable
    public static Color getFogColor(MemorySegment mem, int offset) {
        return hasFogColor(mem, offset) ? Color.toObject(mem, offset + 3): null;
    }
    
    @Nullable
    public static NearFar getFogDistance(MemorySegment mem) {
        return getFogDistance(mem, 0);
    }
    
    @Nullable
    public static NearFar getFogDistance(MemorySegment mem, int offset) {
        return hasFogDistance(mem, offset) ? NearFar.toObject(mem, offset + 6): null;
    }
    
    public static float getFogDepthStart(MemorySegment mem) {
        return getFogDepthStart(mem, 0);
    }
    
    public static float getFogDepthStart(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 14), "FogDepthStart");
    }
    
    public static float getFogDepthFalloff(MemorySegment mem) {
        return getFogDepthFalloff(mem, 0);
    }
    
    public static float getFogDepthFalloff(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 18), "FogDepthFalloff");
    }
    
    @Nullable
    public static Color getColorFilter(MemorySegment mem) {
        return getColorFilter(mem, 0);
    }
    
    @Nullable
    public static Color getColorFilter(MemorySegment mem, int offset) {
        return hasColorFilter(mem, offset) ? Color.toObject(mem, offset + 22): null;
    }
    
    public static float getColorSaturation(MemorySegment mem) {
        return getColorSaturation(mem, 0);
    }
    
    public static float getColorSaturation(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 25), "ColorSaturation");
    }
    
    public static float getDistortionAmplitude(MemorySegment mem) {
        return getDistortionAmplitude(mem, 0);
    }
    
    public static float getDistortionAmplitude(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 29), "DistortionAmplitude");
    }
    
    public static float getDistortionFrequency(MemorySegment mem) {
        return getDistortionFrequency(mem, 0);
    }
    
    public static float getDistortionFrequency(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 33), "DistortionFrequency");
    }
    
    @Nullable
    public static FluidParticle getParticle(MemorySegment mem) {
        return getParticle(mem, 0);
    }
    
    @Nullable
    public static FluidParticle getParticle(MemorySegment mem, int offset) {
        return hasParticle(mem, offset) ? FluidParticle.toObject(mem, offset + getValidatedOffset(mem, offset, 65, 69, "Particle")): null;
    }
    
    @Nullable
    public static FluidFXMovementSettings getMovementSettings(MemorySegment mem) {
        return getMovementSettings(mem, 0);
    }
    
    @Nullable
    public static FluidFXMovementSettings getMovementSettings(MemorySegment mem, int offset) {
        return hasMovementSettings(mem, offset) ? FluidFXMovementSettings.toObject(mem, offset + 37): null;
    }
    
    public static boolean hasFogColor(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasFogDistance(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasColorFilter(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasMovementSettings(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasParticle(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    private static int getValidatedOffset(MemorySegment buffer, int base, int slotPosition, int varBlockStart, String fieldName) {
        int offset = buffer.get(PacketIO.PROTO_INT, base + slotPosition);
        if (offset < 0 || offset > buffer.byteSize() - base - varBlockStart)
            throw ProtocolException.invalidOffset(fieldName, offset, (int) buffer.byteSize());
        return varBlockStart + offset;
    }
    
    /**
     * Rejects an offset slot that does not name the position the field-order walk reached. A
     * present field must sit where the previous field ended, and an absent field carries -1, so
     * the slot a random-access getter resolves and the walk describe the same bytes.
     */
    private static void requireSlot(MemorySegment mem, int slotPosition, int expected, String fieldName) {
        int slot = mem.get(PacketIO.PROTO_INT, slotPosition);
        if (slot != expected) throw ProtocolException.nonCanonicalLayout(fieldName, slot, expected);
    }
    
    public static FluidFX toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static FluidFX toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one FluidFX and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static FluidFX toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 69;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 61, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 61, -1, "Id");
        }
        
        FluidParticle v11 = null;
        if (hasParticle(mem, offset)) {
            requireSlot(mem, offset + 65, varPos, "Particle");
            v11 = FluidParticle.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 65, -1, "Particle");
        }
        var result = new FluidFX(
            v0,
            ShaderType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            FluidFog.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2)),
            hasFogColor(mem, offset) ? Color.toObject(mem, offset + 3) : null,
            hasFogDistance(mem, offset) ? NearFar.toObject(mem, offset + 6) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 14), "FogDepthStart"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 18), "FogDepthFalloff"),
            hasColorFilter(mem, offset) ? Color.toObject(mem, offset + 22) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 25), "ColorSaturation"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 29), "DistortionAmplitude"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 33), "DistortionFrequency"),
            v11,
            hasMovementSettings(mem, offset) ? FluidFXMovementSettings.toObject(mem, offset + 37) : null
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.fogColor != null) nullBits |= 0x01;
        if (this.fogDistance != null) nullBits |= 0x02;
        if (this.colorFilter != null) nullBits |= 0x04;
        if (this.movementSettings != null) nullBits |= 0x08;
        if (this.id != null) nullBits |= 0x10;
        if (this.particle != null) nullBits |= 0x20;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.shader.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 2, (byte) this.fogMode.getValue());
        if (this.fogColor != null) {
            this.fogColor.serialize(mem, offset + 3);
        } else {
            mem.asSlice(offset + 3, 3).fill((byte) 0); 
        }
        if (this.fogDistance != null) {
            this.fogDistance.serialize(mem, offset + 6);
        } else {
            mem.asSlice(offset + 6, 8).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.fogDepthStart, "FogDepthStart"); mem.set(PacketIO.PROTO_FLOAT, offset + 14, this.fogDepthStart);
        PacketIO.requireFinite(this.fogDepthFalloff, "FogDepthFalloff"); mem.set(PacketIO.PROTO_FLOAT, offset + 18, this.fogDepthFalloff);
        if (this.colorFilter != null) {
            this.colorFilter.serialize(mem, offset + 22);
        } else {
            mem.asSlice(offset + 22, 3).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.colorSaturation, "ColorSaturation"); mem.set(PacketIO.PROTO_FLOAT, offset + 25, this.colorSaturation);
        PacketIO.requireFinite(this.distortionAmplitude, "DistortionAmplitude"); mem.set(PacketIO.PROTO_FLOAT, offset + 29, this.distortionAmplitude);
        PacketIO.requireFinite(this.distortionFrequency, "DistortionFrequency"); mem.set(PacketIO.PROTO_FLOAT, offset + 33, this.distortionFrequency);
        if (this.movementSettings != null) {
            this.movementSettings.serialize(mem, offset + 37);
        } else {
            mem.asSlice(offset + 37, 24).fill((byte) 0); 
        }
        var varOffset = offset + 69;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 61, varOffset - offset - 69);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 61, -1);
        }
        if (this.particle != null) {
            mem.set(PacketIO.PROTO_INT, offset + 65, varOffset - offset - 69);
            varOffset += this.particle.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 65, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 69;
        if (id != null) size += PacketIO.stringSize(id);
    if (particle != null) size += particle.computeSize();

        return size;
    }

    public FluidFX clone() {
        FluidFX copy = new FluidFX();
        copy.id = this.id;
        copy.shader = this.shader;
        copy.fogMode = this.fogMode;
        copy.fogColor = this.fogColor != null ? this.fogColor.clone() : null;
        copy.fogDistance = this.fogDistance != null ? this.fogDistance.clone() : null;
        copy.fogDepthStart = this.fogDepthStart;
        copy.fogDepthFalloff = this.fogDepthFalloff;
        copy.colorFilter = this.colorFilter != null ? this.colorFilter.clone() : null;
        copy.colorSaturation = this.colorSaturation;
        copy.distortionAmplitude = this.distortionAmplitude;
        copy.distortionFrequency = this.distortionFrequency;
        copy.particle = this.particle != null ? this.particle.clone() : null;
        copy.movementSettings = this.movementSettings != null ? this.movementSettings.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FluidFX other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.shader, other.shader) && java.util.Objects.equals(this.fogMode, other.fogMode) && java.util.Objects.equals(this.fogColor, other.fogColor) && java.util.Objects.equals(this.fogDistance, other.fogDistance) && this.fogDepthStart == other.fogDepthStart && this.fogDepthFalloff == other.fogDepthFalloff && java.util.Objects.equals(this.colorFilter, other.colorFilter) && this.colorSaturation == other.colorSaturation && this.distortionAmplitude == other.distortionAmplitude && this.distortionFrequency == other.distortionFrequency && java.util.Objects.equals(this.particle, other.particle) && java.util.Objects.equals(this.movementSettings, other.movementSettings);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, shader, fogMode, fogColor, fogDistance, fogDepthStart, fogDepthFalloff, colorFilter, colorSaturation, distortionAmplitude, distortionFrequency, particle, movementSettings);
    }

}