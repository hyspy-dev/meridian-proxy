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


public class Fluid {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 23;
    public static final int VARIABLE_FIELD_COUNT = 6;
    public static final int VARIABLE_BLOCK_START = 47;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String id;
    public int maxFluidLevel;
    @Nullable public BlockTextures[] cubeTextures;
    public boolean requiresAlphaBlending;
    @Nonnull public Opacity opacity = Opacity.Solid;
    @Nullable public ShaderType[] shaderEffect;
    @Nullable public ColorLight light;
    @Nullable public ModelParticle[] particles;
    @Nonnull public FluidDrawType drawType = FluidDrawType.None;
    public int fluidFXIndex;
    public int blockSoundSetIndex;
    @Nullable public String blockParticleSetId;
    @Nullable public Color particleColor;
    @Nullable public int[] tagIndexes;

    public Fluid() {
    }

    public Fluid(@Nullable String id, int maxFluidLevel, @Nullable BlockTextures[] cubeTextures, boolean requiresAlphaBlending, @Nonnull Opacity opacity, @Nullable ShaderType[] shaderEffect, @Nullable ColorLight light, @Nullable ModelParticle[] particles, @Nonnull FluidDrawType drawType, int fluidFXIndex, int blockSoundSetIndex, @Nullable String blockParticleSetId, @Nullable Color particleColor, @Nullable int[] tagIndexes) {
        this.id = id;
        this.maxFluidLevel = maxFluidLevel;
        this.cubeTextures = cubeTextures;
        this.requiresAlphaBlending = requiresAlphaBlending;
        this.opacity = opacity;
        this.shaderEffect = shaderEffect;
        this.light = light;
        this.particles = particles;
        this.drawType = drawType;
        this.fluidFXIndex = fluidFXIndex;
        this.blockSoundSetIndex = blockSoundSetIndex;
        this.blockParticleSetId = blockParticleSetId;
        this.particleColor = particleColor;
        this.tagIndexes = tagIndexes;
    }

    public Fluid(@Nonnull Fluid other) {
        this.id = other.id;
        this.maxFluidLevel = other.maxFluidLevel;
        this.cubeTextures = other.cubeTextures;
        this.requiresAlphaBlending = other.requiresAlphaBlending;
        this.opacity = other.opacity;
        this.shaderEffect = other.shaderEffect;
        this.light = other.light;
        this.particles = other.particles;
        this.drawType = other.drawType;
        this.fluidFXIndex = other.fluidFXIndex;
        this.blockSoundSetIndex = other.blockSoundSetIndex;
        this.blockParticleSetId = other.blockParticleSetId;
        this.particleColor = other.particleColor;
        this.tagIndexes = other.tagIndexes;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Fluid", offset, (int) mem.byteSize());
        long needed = (long) offset + 47;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Fluid", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 23, 47, "Id"), 4096000): null;
    }
    
    public static int getMaxFluidLevel(MemorySegment mem) {
        return getMaxFluidLevel(mem, 0);
    }
    
    public static int getMaxFluidLevel(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static BlockTextures[] getCubeTextures(MemorySegment mem) {
        return getCubeTextures(mem, 0);
    }
    
    @Nullable
    public static BlockTextures[] getCubeTextures(MemorySegment mem, int offset) {
        if (!hasCubeTextures(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 27, 47, "CubeTextures");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("CubeTextures");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("CubeTextures", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 29 > mem.byteSize()) throw ProtocolException.bufferTooSmall("CubeTextures", (int) java.lang.Math.min(off + lenOffset + (long) len * 29, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new BlockTextures[len];
        for (var i = 0; i < len; i++) {
            data[i] = BlockTextures.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean getRequiresAlphaBlending(MemorySegment mem) {
        return getRequiresAlphaBlending(mem, 0);
    }
    
    public static boolean getRequiresAlphaBlending(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 5);
    }
    
    public static Opacity getOpacity(MemorySegment mem) {
        return getOpacity(mem, 0);
    }
    
    public static Opacity getOpacity(MemorySegment mem, int offset) {
        return Opacity.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 6));
    }
    
    @Nullable
    public static ShaderType[] getShaderEffect(MemorySegment mem) {
        return getShaderEffect(mem, 0);
    }
    
    @Nullable
    public static ShaderType[] getShaderEffect(MemorySegment mem, int offset) {
        if (!hasShaderEffect(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 31, 47, "ShaderEffect");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ShaderEffect");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("ShaderEffect", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("ShaderEffect", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ShaderType[len];
        for (var i = 0; i < len; i++) {
            data[i] = ShaderType.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
        }
        return data;
    }
    
    @Nullable
    public static ColorLight getLight(MemorySegment mem) {
        return getLight(mem, 0);
    }
    
    @Nullable
    public static ColorLight getLight(MemorySegment mem, int offset) {
        return hasLight(mem, offset) ? ColorLight.toObject(mem, offset + 7): null;
    }
    
    @Nullable
    public static ModelParticle[] getParticles(MemorySegment mem) {
        return getParticles(mem, 0);
    }
    
    @Nullable
    public static ModelParticle[] getParticles(MemorySegment mem, int offset) {
        if (!hasParticles(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 35, 47, "Particles");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Particles");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Particles", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Particles", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ModelParticle[len];
        for (var i = 0; i < len; i++) {
            data[i] = ModelParticle.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static FluidDrawType getDrawType(MemorySegment mem) {
        return getDrawType(mem, 0);
    }
    
    public static FluidDrawType getDrawType(MemorySegment mem, int offset) {
        return FluidDrawType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 11));
    }
    
    public static int getFluidFXIndex(MemorySegment mem) {
        return getFluidFXIndex(mem, 0);
    }
    
    public static int getFluidFXIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 12);
    }
    
    public static int getBlockSoundSetIndex(MemorySegment mem) {
        return getBlockSoundSetIndex(mem, 0);
    }
    
    public static int getBlockSoundSetIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 16);
    }
    
    @Nullable
    public static String getBlockParticleSetId(MemorySegment mem) {
        return getBlockParticleSetId(mem, 0);
    }
    
    @Nullable
    public static String getBlockParticleSetId(MemorySegment mem, int offset) {
        return hasBlockParticleSetId(mem, offset) ? PacketIO.readVarString("BlockParticleSetId", mem, offset + getValidatedOffset(mem, offset, 39, 47, "BlockParticleSetId"), 4096000): null;
    }
    
    @Nullable
    public static Color getParticleColor(MemorySegment mem) {
        return getParticleColor(mem, 0);
    }
    
    @Nullable
    public static Color getParticleColor(MemorySegment mem, int offset) {
        return hasParticleColor(mem, offset) ? Color.toObject(mem, offset + 20): null;
    }
    
    @Nullable
    public static int[] getTagIndexes(MemorySegment mem) {
        return getTagIndexes(mem, 0);
    }
    
    @Nullable
    public static int[] getTagIndexes(MemorySegment mem, int offset) {
        if (!hasTagIndexes(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 43, 47, "TagIndexes");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("TagIndexes");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("TagIndexes", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("TagIndexes", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    public static boolean hasLight(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasParticleColor(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasCubeTextures(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasShaderEffect(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasParticles(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasBlockParticleSetId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasTagIndexes(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
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
    
    public static Fluid toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Fluid toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Fluid and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Fluid toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 47;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 23, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 23, -1, "Id");
        }
        
        BlockTextures[] v2 = null;
        if (hasCubeTextures(mem, offset)) {
            requireSlot(mem, offset + 27, varPos, "CubeTextures");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("CubeTextures");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("CubeTextures", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 29 > mem.byteSize()) throw ProtocolException.bufferTooSmall("CubeTextures", (int) java.lang.Math.min(off + lenOffset + (long) len * 29, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new BlockTextures[len];
            for (var i = 0; i < len; i++) {
                v2[i] = BlockTextures.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 27, -1, "CubeTextures");
        }
        
        ShaderType[] v5 = null;
        if (hasShaderEffect(mem, offset)) {
            requireSlot(mem, offset + 31, varPos, "ShaderEffect");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ShaderEffect");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("ShaderEffect", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("ShaderEffect", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v5 = new ShaderType[len];
            for (var i = 0; i < len; i++) {
                v5[i] = ShaderType.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
            }
            varPos = off + len - varBase;
        } else {
            requireSlot(mem, offset + 31, -1, "ShaderEffect");
        }
        
        ModelParticle[] v7 = null;
        if (hasParticles(mem, offset)) {
            requireSlot(mem, offset + 35, varPos, "Particles");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Particles");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Particles", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Particles", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v7 = new ModelParticle[len];
            for (var i = 0; i < len; i++) {
                v7[i] = ModelParticle.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 35, -1, "Particles");
        }
        
        String v11 = null;
        if (hasBlockParticleSetId(mem, offset)) {
            requireSlot(mem, offset + 39, varPos, "BlockParticleSetId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v11 = PacketIO.readVarString("BlockParticleSetId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 39, -1, "BlockParticleSetId");
        }
        
        int[] v13 = null;
        if (hasTagIndexes(mem, offset)) {
            requireSlot(mem, offset + 43, varPos, "TagIndexes");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("TagIndexes");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("TagIndexes", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("TagIndexes", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v13 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v13, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 43, -1, "TagIndexes");
        }
        var result = new Fluid(
            v0,
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v2,
            mem.get(PacketIO.PROTO_BOOL, offset + 5),
            Opacity.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 6)),
            v5,
            hasLight(mem, offset) ? ColorLight.toObject(mem, offset + 7) : null,
            v7,
            FluidDrawType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 11)),
            mem.get(PacketIO.PROTO_INT, offset + 12),
            mem.get(PacketIO.PROTO_INT, offset + 16),
            v11,
            hasParticleColor(mem, offset) ? Color.toObject(mem, offset + 20) : null,
            v13
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.light != null) nullBits |= 0x01;
        if (this.particleColor != null) nullBits |= 0x02;
        if (this.id != null) nullBits |= 0x04;
        if (this.cubeTextures != null) nullBits |= 0x08;
        if (this.shaderEffect != null) nullBits |= 0x10;
        if (this.particles != null) nullBits |= 0x20;
        if (this.blockParticleSetId != null) nullBits |= 0x40;
        if (this.tagIndexes != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.maxFluidLevel);
        mem.set(PacketIO.PROTO_BOOL, offset + 5, this.requiresAlphaBlending);
        mem.set(PacketIO.PROTO_BYTE, offset + 6, (byte) this.opacity.getValue());
        if (this.light != null) {
            this.light.serialize(mem, offset + 7);
        } else {
            mem.asSlice(offset + 7, 4).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BYTE, offset + 11, (byte) this.drawType.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 12, this.fluidFXIndex);
        mem.set(PacketIO.PROTO_INT, offset + 16, this.blockSoundSetIndex);
        if (this.particleColor != null) {
            this.particleColor.serialize(mem, offset + 20);
        } else {
            mem.asSlice(offset + 20, 3).fill((byte) 0); 
        }
        var varOffset = offset + 47;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 23, varOffset - offset - 47);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 23, -1);
        }
        if (this.cubeTextures != null) {
            mem.set(PacketIO.PROTO_INT, offset + 27, varOffset - offset - 47);
            if (cubeTextures.length > 4096000) throw ProtocolException.arrayTooLong("CubeTextures", cubeTextures.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.cubeTextures.length);
            
            var cubeTexturesValueOffset = 0;
            for (var i = 0; i < this.cubeTextures.length; i++) {
                cubeTexturesValueOffset += this.cubeTextures[i].serialize(mem, varOffset + cubeTexturesValueOffset);
            }
            varOffset += cubeTexturesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 27, -1);
        }
        if (this.shaderEffect != null) {
            mem.set(PacketIO.PROTO_INT, offset + 31, varOffset - offset - 47);
            if (shaderEffect.length > 4096000) throw ProtocolException.arrayTooLong("ShaderEffect", shaderEffect.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.shaderEffect.length);
            
            for (var i = 0; i < this.shaderEffect.length; i++) {
                mem.set(PacketIO.PROTO_BYTE, varOffset + i * 1, (byte) this.shaderEffect[i].getValue());
            }
            varOffset += this.shaderEffect.length * 1;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 31, -1);
        }
        if (this.particles != null) {
            mem.set(PacketIO.PROTO_INT, offset + 35, varOffset - offset - 47);
            if (particles.length > 4096000) throw ProtocolException.arrayTooLong("Particles", particles.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.particles.length);
            
            var particlesValueOffset = 0;
            for (var i = 0; i < this.particles.length; i++) {
                particlesValueOffset += this.particles[i].serialize(mem, varOffset + particlesValueOffset);
            }
            varOffset += particlesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 35, -1);
        }
        if (this.blockParticleSetId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 39, varOffset - offset - 47);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.blockParticleSetId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 39, -1);
        }
        if (this.tagIndexes != null) {
            mem.set(PacketIO.PROTO_INT, offset + 43, varOffset - offset - 47);
            if (tagIndexes.length > 4096000) throw ProtocolException.arrayTooLong("TagIndexes", tagIndexes.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.tagIndexes.length);
            
            MemorySegment.copy(this.tagIndexes, 0, mem, PacketIO.PROTO_INT, varOffset, this.tagIndexes.length);
            varOffset += this.tagIndexes.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 43, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 47;
        if (id != null) size += PacketIO.stringSize(id);
    if (cubeTextures != null) {
        int cubeTexturesSize = 0;
for (var elem : cubeTextures) cubeTexturesSize += elem.computeSize();
size += VarInt.size(cubeTextures.length) + cubeTexturesSize;
    }
    if (shaderEffect != null) size += VarInt.size(shaderEffect.length) + shaderEffect.length * 1;
    if (particles != null) {
        int particlesSize = 0;
for (var elem : particles) particlesSize += elem.computeSize();
size += VarInt.size(particles.length) + particlesSize;
    }
    if (blockParticleSetId != null) size += PacketIO.stringSize(blockParticleSetId);
    if (tagIndexes != null) size += VarInt.size(tagIndexes.length) + tagIndexes.length * 4;

        return size;
    }

    public Fluid clone() {
        Fluid copy = new Fluid();
        copy.id = this.id;
        copy.maxFluidLevel = this.maxFluidLevel;
        copy.cubeTextures = this.cubeTextures != null ? java.util.Arrays.stream(this.cubeTextures).map(e -> e.clone()).toArray(BlockTextures[]::new) : null;
        copy.requiresAlphaBlending = this.requiresAlphaBlending;
        copy.opacity = this.opacity;
        copy.shaderEffect = this.shaderEffect != null ? java.util.Arrays.copyOf(this.shaderEffect, this.shaderEffect.length) : null;
        copy.light = this.light != null ? this.light.clone() : null;
        copy.particles = this.particles != null ? java.util.Arrays.stream(this.particles).map(e -> e.clone()).toArray(ModelParticle[]::new) : null;
        copy.drawType = this.drawType;
        copy.fluidFXIndex = this.fluidFXIndex;
        copy.blockSoundSetIndex = this.blockSoundSetIndex;
        copy.blockParticleSetId = this.blockParticleSetId;
        copy.particleColor = this.particleColor != null ? this.particleColor.clone() : null;
        copy.tagIndexes = this.tagIndexes != null ? java.util.Arrays.copyOf(this.tagIndexes, this.tagIndexes.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Fluid other)) return false;
        return java.util.Objects.equals(this.id, other.id) && this.maxFluidLevel == other.maxFluidLevel && java.util.Arrays.equals(this.cubeTextures, other.cubeTextures) && this.requiresAlphaBlending == other.requiresAlphaBlending && java.util.Objects.equals(this.opacity, other.opacity) && java.util.Arrays.equals(this.shaderEffect, other.shaderEffect) && java.util.Objects.equals(this.light, other.light) && java.util.Arrays.equals(this.particles, other.particles) && java.util.Objects.equals(this.drawType, other.drawType) && this.fluidFXIndex == other.fluidFXIndex && this.blockSoundSetIndex == other.blockSoundSetIndex && java.util.Objects.equals(this.blockParticleSetId, other.blockParticleSetId) && java.util.Objects.equals(this.particleColor, other.particleColor) && java.util.Arrays.equals(this.tagIndexes, other.tagIndexes);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(id);
        result = 31 * result + Integer.hashCode(maxFluidLevel);
        result = 31 * result + java.util.Arrays.hashCode(cubeTextures);
        result = 31 * result + Boolean.hashCode(requiresAlphaBlending);
        result = 31 * result + java.util.Objects.hashCode(opacity);
        result = 31 * result + java.util.Arrays.hashCode(shaderEffect);
        result = 31 * result + java.util.Objects.hashCode(light);
        result = 31 * result + java.util.Arrays.hashCode(particles);
        result = 31 * result + java.util.Objects.hashCode(drawType);
        result = 31 * result + Integer.hashCode(fluidFXIndex);
        result = 31 * result + Integer.hashCode(blockSoundSetIndex);
        result = 31 * result + java.util.Objects.hashCode(blockParticleSetId);
        result = 31 * result + java.util.Objects.hashCode(particleColor);
        result = 31 * result + java.util.Arrays.hashCode(tagIndexes);
        return result;
    }

}