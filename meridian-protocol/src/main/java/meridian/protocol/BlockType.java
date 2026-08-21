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
import java.util.HashMap;

public class BlockType {
    public static final int NULLABLE_BIT_FIELD_SIZE = 4;
    public static final int FIXED_BLOCK_SIZE = 177;
    public static final int VARIABLE_FIELD_COUNT = 25;
    public static final int VARIABLE_BLOCK_START = 277;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String item;
    @Nullable public String name;
    public boolean unknown;
    @Nonnull public DrawType drawType = DrawType.Empty;
    @Nonnull public BlockMaterial material = BlockMaterial.Empty;
    @Nonnull public Opacity opacity = Opacity.Solid;
    @Nullable public ShaderType[] shaderEffect;
    public int hitbox;
    public int interactionHitbox;
    @Nullable public String model;
    @Nullable public ModelTexture[] modelTexture;
    public float modelScale;
    @Nullable public String modelAnimation;
    public float modelAnimationSpeed = 1f;
    public boolean looping;
    public int maxSupportDistance;
    @Nonnull public BlockSupportsRequiredForType blockSupportsRequiredFor = BlockSupportsRequiredForType.Any;
    @Nullable public java.util.Map<BlockNeighbor, RequiredBlockFaceSupport[]> support;
    @Nullable public java.util.Map<BlockNeighbor, BlockFaceSupport[]> supporting;
    public boolean requiresAlphaBlending;
    @Nullable public BlockTextures[] cubeTextures;
    @Nullable public String cubeSideMaskTexture;
    @Nonnull public ShadingMode cubeShadingMode = ShadingMode.Standard;
    @Nonnull public RandomRotation randomRotation = RandomRotation.None;
    @Nonnull public VariantRotation variantRotation = VariantRotation.None;
    @Nonnull public Rotation rotationYawPlacementOffset = Rotation.None;
    public int blockSoundSetIndex;
    public int physicalMaterialIndex;
    public float soundOcclusionOpacity;
    public int ambientSoundEventIndex;
    @Nullable public ConditionalBlockSound[] conditionalSounds;
    @Nullable public ModelParticle[] particles;
    @Nullable public String blockParticleSetId;
    @Nullable public String blockBreakingDecalId;
    @Nullable public Color particleColor;
    @Nullable public Color textureComputedColor;
    @Nullable public ColorLight light;
    @Nullable public Tint tint;
    @Nullable public Tint biomeTint;
    public int group;
    @Nullable public String transitionTexture;
    @Nullable public int[] transitionToGroups;
    @Nonnull public BlockMovementSettings movementSettings = new BlockMovementSettings();
    @Nullable public String interactionHint;
    @Nullable public BlockGathering gathering;
    @Nullable public BlockPlacementSettings placementSettings;
    @Nullable public ModelDisplay display;
    @Nullable public RailConfig rail;
    public boolean ignoreSupportWhenPlaced;
    @Nullable public java.util.Map<InteractionType, Integer> interactions;
    @Nullable public java.util.Map<String, Integer> states;
    public int transitionToTag;
    @Nullable public int[] tagIndexes;
    @Nullable public Bench bench;
    @Nullable public ConnectedBlockRuleSet connectedBlockRuleSet;

    public BlockType() {
    }

    public BlockType(@Nullable String item, @Nullable String name, boolean unknown, @Nonnull DrawType drawType, @Nonnull BlockMaterial material, @Nonnull Opacity opacity, @Nullable ShaderType[] shaderEffect, int hitbox, int interactionHitbox, @Nullable String model, @Nullable ModelTexture[] modelTexture, float modelScale, @Nullable String modelAnimation, float modelAnimationSpeed, boolean looping, int maxSupportDistance, @Nonnull BlockSupportsRequiredForType blockSupportsRequiredFor, @Nullable java.util.Map<BlockNeighbor, RequiredBlockFaceSupport[]> support, @Nullable java.util.Map<BlockNeighbor, BlockFaceSupport[]> supporting, boolean requiresAlphaBlending, @Nullable BlockTextures[] cubeTextures, @Nullable String cubeSideMaskTexture, @Nonnull ShadingMode cubeShadingMode, @Nonnull RandomRotation randomRotation, @Nonnull VariantRotation variantRotation, @Nonnull Rotation rotationYawPlacementOffset, int blockSoundSetIndex, int physicalMaterialIndex, float soundOcclusionOpacity, int ambientSoundEventIndex, @Nullable ConditionalBlockSound[] conditionalSounds, @Nullable ModelParticle[] particles, @Nullable String blockParticleSetId, @Nullable String blockBreakingDecalId, @Nullable Color particleColor, @Nullable Color textureComputedColor, @Nullable ColorLight light, @Nullable Tint tint, @Nullable Tint biomeTint, int group, @Nullable String transitionTexture, @Nullable int[] transitionToGroups, @Nonnull BlockMovementSettings movementSettings, @Nullable String interactionHint, @Nullable BlockGathering gathering, @Nullable BlockPlacementSettings placementSettings, @Nullable ModelDisplay display, @Nullable RailConfig rail, boolean ignoreSupportWhenPlaced, @Nullable java.util.Map<InteractionType, Integer> interactions, @Nullable java.util.Map<String, Integer> states, int transitionToTag, @Nullable int[] tagIndexes, @Nullable Bench bench, @Nullable ConnectedBlockRuleSet connectedBlockRuleSet) {
        this.item = item;
        this.name = name;
        this.unknown = unknown;
        this.drawType = drawType;
        this.material = material;
        this.opacity = opacity;
        this.shaderEffect = shaderEffect;
        this.hitbox = hitbox;
        this.interactionHitbox = interactionHitbox;
        this.model = model;
        this.modelTexture = modelTexture;
        this.modelScale = modelScale;
        this.modelAnimation = modelAnimation;
        this.modelAnimationSpeed = modelAnimationSpeed;
        this.looping = looping;
        this.maxSupportDistance = maxSupportDistance;
        this.blockSupportsRequiredFor = blockSupportsRequiredFor;
        this.support = support;
        this.supporting = supporting;
        this.requiresAlphaBlending = requiresAlphaBlending;
        this.cubeTextures = cubeTextures;
        this.cubeSideMaskTexture = cubeSideMaskTexture;
        this.cubeShadingMode = cubeShadingMode;
        this.randomRotation = randomRotation;
        this.variantRotation = variantRotation;
        this.rotationYawPlacementOffset = rotationYawPlacementOffset;
        this.blockSoundSetIndex = blockSoundSetIndex;
        this.physicalMaterialIndex = physicalMaterialIndex;
        this.soundOcclusionOpacity = soundOcclusionOpacity;
        this.ambientSoundEventIndex = ambientSoundEventIndex;
        this.conditionalSounds = conditionalSounds;
        this.particles = particles;
        this.blockParticleSetId = blockParticleSetId;
        this.blockBreakingDecalId = blockBreakingDecalId;
        this.particleColor = particleColor;
        this.textureComputedColor = textureComputedColor;
        this.light = light;
        this.tint = tint;
        this.biomeTint = biomeTint;
        this.group = group;
        this.transitionTexture = transitionTexture;
        this.transitionToGroups = transitionToGroups;
        this.movementSettings = movementSettings;
        this.interactionHint = interactionHint;
        this.gathering = gathering;
        this.placementSettings = placementSettings;
        this.display = display;
        this.rail = rail;
        this.ignoreSupportWhenPlaced = ignoreSupportWhenPlaced;
        this.interactions = interactions;
        this.states = states;
        this.transitionToTag = transitionToTag;
        this.tagIndexes = tagIndexes;
        this.bench = bench;
        this.connectedBlockRuleSet = connectedBlockRuleSet;
    }

    public BlockType(@Nonnull BlockType other) {
        this.item = other.item;
        this.name = other.name;
        this.unknown = other.unknown;
        this.drawType = other.drawType;
        this.material = other.material;
        this.opacity = other.opacity;
        this.shaderEffect = other.shaderEffect;
        this.hitbox = other.hitbox;
        this.interactionHitbox = other.interactionHitbox;
        this.model = other.model;
        this.modelTexture = other.modelTexture;
        this.modelScale = other.modelScale;
        this.modelAnimation = other.modelAnimation;
        this.modelAnimationSpeed = other.modelAnimationSpeed;
        this.looping = other.looping;
        this.maxSupportDistance = other.maxSupportDistance;
        this.blockSupportsRequiredFor = other.blockSupportsRequiredFor;
        this.support = other.support;
        this.supporting = other.supporting;
        this.requiresAlphaBlending = other.requiresAlphaBlending;
        this.cubeTextures = other.cubeTextures;
        this.cubeSideMaskTexture = other.cubeSideMaskTexture;
        this.cubeShadingMode = other.cubeShadingMode;
        this.randomRotation = other.randomRotation;
        this.variantRotation = other.variantRotation;
        this.rotationYawPlacementOffset = other.rotationYawPlacementOffset;
        this.blockSoundSetIndex = other.blockSoundSetIndex;
        this.physicalMaterialIndex = other.physicalMaterialIndex;
        this.soundOcclusionOpacity = other.soundOcclusionOpacity;
        this.ambientSoundEventIndex = other.ambientSoundEventIndex;
        this.conditionalSounds = other.conditionalSounds;
        this.particles = other.particles;
        this.blockParticleSetId = other.blockParticleSetId;
        this.blockBreakingDecalId = other.blockBreakingDecalId;
        this.particleColor = other.particleColor;
        this.textureComputedColor = other.textureComputedColor;
        this.light = other.light;
        this.tint = other.tint;
        this.biomeTint = other.biomeTint;
        this.group = other.group;
        this.transitionTexture = other.transitionTexture;
        this.transitionToGroups = other.transitionToGroups;
        this.movementSettings = other.movementSettings;
        this.interactionHint = other.interactionHint;
        this.gathering = other.gathering;
        this.placementSettings = other.placementSettings;
        this.display = other.display;
        this.rail = other.rail;
        this.ignoreSupportWhenPlaced = other.ignoreSupportWhenPlaced;
        this.interactions = other.interactions;
        this.states = other.states;
        this.transitionToTag = other.transitionToTag;
        this.tagIndexes = other.tagIndexes;
        this.bench = other.bench;
        this.connectedBlockRuleSet = other.connectedBlockRuleSet;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BlockType", offset, (int) mem.byteSize());
        long needed = (long) offset + 277;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockType", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getItem(MemorySegment mem) {
        return getItem(mem, 0);
    }
    
    @Nullable
    public static String getItem(MemorySegment mem, int offset) {
        return hasItem(mem, offset) ? PacketIO.readVarString("Item", mem, offset + getValidatedOffset(mem, offset, 177, 277, "Item"), 4096000): null;
    }
    
    @Nullable
    public static String getName(MemorySegment mem) {
        return getName(mem, 0);
    }
    
    @Nullable
    public static String getName(MemorySegment mem, int offset) {
        return hasName(mem, offset) ? PacketIO.readVarString("Name", mem, offset + getValidatedOffset(mem, offset, 181, 277, "Name"), 4096000): null;
    }
    
    public static boolean getUnknown(MemorySegment mem) {
        return getUnknown(mem, 0);
    }
    
    public static boolean getUnknown(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 4);
    }
    
    public static DrawType getDrawType(MemorySegment mem) {
        return getDrawType(mem, 0);
    }
    
    public static DrawType getDrawType(MemorySegment mem, int offset) {
        return DrawType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 5));
    }
    
    public static BlockMaterial getMaterial(MemorySegment mem) {
        return getMaterial(mem, 0);
    }
    
    public static BlockMaterial getMaterial(MemorySegment mem, int offset) {
        return BlockMaterial.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 6));
    }
    
    public static Opacity getOpacity(MemorySegment mem) {
        return getOpacity(mem, 0);
    }
    
    public static Opacity getOpacity(MemorySegment mem, int offset) {
        return Opacity.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 7));
    }
    
    @Nullable
    public static ShaderType[] getShaderEffect(MemorySegment mem) {
        return getShaderEffect(mem, 0);
    }
    
    @Nullable
    public static ShaderType[] getShaderEffect(MemorySegment mem, int offset) {
        if (!hasShaderEffect(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 185, 277, "ShaderEffect");
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
    
    public static int getHitbox(MemorySegment mem) {
        return getHitbox(mem, 0);
    }
    
    public static int getHitbox(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 8);
    }
    
    public static int getInteractionHitbox(MemorySegment mem) {
        return getInteractionHitbox(mem, 0);
    }
    
    public static int getInteractionHitbox(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 12);
    }
    
    @Nullable
    public static String getModel(MemorySegment mem) {
        return getModel(mem, 0);
    }
    
    @Nullable
    public static String getModel(MemorySegment mem, int offset) {
        return hasModel(mem, offset) ? PacketIO.readVarString("Model", mem, offset + getValidatedOffset(mem, offset, 189, 277, "Model"), 4096000): null;
    }
    
    @Nullable
    public static ModelTexture[] getModelTexture(MemorySegment mem) {
        return getModelTexture(mem, 0);
    }
    
    @Nullable
    public static ModelTexture[] getModelTexture(MemorySegment mem, int offset) {
        if (!hasModelTexture(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 193, 277, "ModelTexture");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ModelTexture");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("ModelTexture", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ModelTexture", (int) java.lang.Math.min(off + lenOffset + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ModelTexture[len];
        for (var i = 0; i < len; i++) {
            data[i] = ModelTexture.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static float getModelScale(MemorySegment mem) {
        return getModelScale(mem, 0);
    }
    
    public static float getModelScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "ModelScale");
    }
    
    @Nullable
    public static String getModelAnimation(MemorySegment mem) {
        return getModelAnimation(mem, 0);
    }
    
    @Nullable
    public static String getModelAnimation(MemorySegment mem, int offset) {
        return hasModelAnimation(mem, offset) ? PacketIO.readVarString("ModelAnimation", mem, offset + getValidatedOffset(mem, offset, 197, 277, "ModelAnimation"), 4096000): null;
    }
    
    public static float getModelAnimationSpeed(MemorySegment mem) {
        return getModelAnimationSpeed(mem, 0);
    }
    
    public static float getModelAnimationSpeed(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "ModelAnimationSpeed");
    }
    
    public static boolean getLooping(MemorySegment mem) {
        return getLooping(mem, 0);
    }
    
    public static boolean getLooping(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 24);
    }
    
    public static int getMaxSupportDistance(MemorySegment mem) {
        return getMaxSupportDistance(mem, 0);
    }
    
    public static int getMaxSupportDistance(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 25);
    }
    
    public static BlockSupportsRequiredForType getBlockSupportsRequiredFor(MemorySegment mem) {
        return getBlockSupportsRequiredFor(mem, 0);
    }
    
    public static BlockSupportsRequiredForType getBlockSupportsRequiredFor(MemorySegment mem, int offset) {
        return BlockSupportsRequiredForType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 29));
    }
    
    @Nullable
    public static java.util.Map<BlockNeighbor, RequiredBlockFaceSupport[]> getSupport(MemorySegment mem) {
        return getSupport(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<BlockNeighbor, RequiredBlockFaceSupport[]> getSupport(MemorySegment mem, int offset) {
        if (!hasSupport(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 201, 277, "Support");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Support");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Support", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Support", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<BlockNeighbor, RequiredBlockFaceSupport[]> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = BlockNeighbor.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                off += 1;
            var valuePacked = VarInt.getWithLength(mem, off);
                if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                var valueLen = (int) valuePacked;
                var valueVarLen = (int) (valuePacked >>> 32);
                if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                if (off + valueVarLen + (long) valueLen * 32 > mem.byteSize())
                    throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 32, (int) mem.byteSize());
                off += valueVarLen;
                var value = new RequiredBlockFaceSupport[valueLen];
                for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                    value[valueIdx] = RequiredBlockFaceSupport.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                }
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Support", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<BlockNeighbor, BlockFaceSupport[]> getSupporting(MemorySegment mem) {
        return getSupporting(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<BlockNeighbor, BlockFaceSupport[]> getSupporting(MemorySegment mem, int offset) {
        if (!hasSupporting(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 205, 277, "Supporting");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Supporting");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Supporting", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Supporting", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<BlockNeighbor, BlockFaceSupport[]> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = BlockNeighbor.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                off += 1;
            var valuePacked = VarInt.getWithLength(mem, off);
                if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                var valueLen = (int) valuePacked;
                var valueVarLen = (int) (valuePacked >>> 32);
                if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                if (off + valueVarLen + (long) valueLen * 9 > mem.byteSize())
                    throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 9, (int) mem.byteSize());
                off += valueVarLen;
                var value = new BlockFaceSupport[valueLen];
                for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                    value[valueIdx] = BlockFaceSupport.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                }
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Supporting", key);
            }
        }
        return data;
    }
    
    public static boolean getRequiresAlphaBlending(MemorySegment mem) {
        return getRequiresAlphaBlending(mem, 0);
    }
    
    public static boolean getRequiresAlphaBlending(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 30);
    }
    
    @Nullable
    public static BlockTextures[] getCubeTextures(MemorySegment mem) {
        return getCubeTextures(mem, 0);
    }
    
    @Nullable
    public static BlockTextures[] getCubeTextures(MemorySegment mem, int offset) {
        if (!hasCubeTextures(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 209, 277, "CubeTextures");
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
    
    @Nullable
    public static String getCubeSideMaskTexture(MemorySegment mem) {
        return getCubeSideMaskTexture(mem, 0);
    }
    
    @Nullable
    public static String getCubeSideMaskTexture(MemorySegment mem, int offset) {
        return hasCubeSideMaskTexture(mem, offset) ? PacketIO.readVarString("CubeSideMaskTexture", mem, offset + getValidatedOffset(mem, offset, 213, 277, "CubeSideMaskTexture"), 4096000): null;
    }
    
    public static ShadingMode getCubeShadingMode(MemorySegment mem) {
        return getCubeShadingMode(mem, 0);
    }
    
    public static ShadingMode getCubeShadingMode(MemorySegment mem, int offset) {
        return ShadingMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 31));
    }
    
    public static RandomRotation getRandomRotation(MemorySegment mem) {
        return getRandomRotation(mem, 0);
    }
    
    public static RandomRotation getRandomRotation(MemorySegment mem, int offset) {
        return RandomRotation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 32));
    }
    
    public static VariantRotation getVariantRotation(MemorySegment mem) {
        return getVariantRotation(mem, 0);
    }
    
    public static VariantRotation getVariantRotation(MemorySegment mem, int offset) {
        return VariantRotation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 33));
    }
    
    public static Rotation getRotationYawPlacementOffset(MemorySegment mem) {
        return getRotationYawPlacementOffset(mem, 0);
    }
    
    public static Rotation getRotationYawPlacementOffset(MemorySegment mem, int offset) {
        return Rotation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 34));
    }
    
    public static int getBlockSoundSetIndex(MemorySegment mem) {
        return getBlockSoundSetIndex(mem, 0);
    }
    
    public static int getBlockSoundSetIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 35);
    }
    
    public static int getPhysicalMaterialIndex(MemorySegment mem) {
        return getPhysicalMaterialIndex(mem, 0);
    }
    
    public static int getPhysicalMaterialIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 39);
    }
    
    public static float getSoundOcclusionOpacity(MemorySegment mem) {
        return getSoundOcclusionOpacity(mem, 0);
    }
    
    public static float getSoundOcclusionOpacity(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 43), "SoundOcclusionOpacity");
    }
    
    public static int getAmbientSoundEventIndex(MemorySegment mem) {
        return getAmbientSoundEventIndex(mem, 0);
    }
    
    public static int getAmbientSoundEventIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 47);
    }
    
    @Nullable
    public static ConditionalBlockSound[] getConditionalSounds(MemorySegment mem) {
        return getConditionalSounds(mem, 0);
    }
    
    @Nullable
    public static ConditionalBlockSound[] getConditionalSounds(MemorySegment mem, int offset) {
        if (!hasConditionalSounds(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 217, 277, "ConditionalSounds");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ConditionalSounds");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("ConditionalSounds", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ConditionalSounds", (int) java.lang.Math.min(off + lenOffset + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ConditionalBlockSound[len];
        for (var i = 0; i < len; i++) {
            data[i] = ConditionalBlockSound.toObject(mem, off + i * 8);
        }
        return data;
    }
    
    @Nullable
    public static ModelParticle[] getParticles(MemorySegment mem) {
        return getParticles(mem, 0);
    }
    
    @Nullable
    public static ModelParticle[] getParticles(MemorySegment mem, int offset) {
        if (!hasParticles(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 221, 277, "Particles");
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
    
    @Nullable
    public static String getBlockParticleSetId(MemorySegment mem) {
        return getBlockParticleSetId(mem, 0);
    }
    
    @Nullable
    public static String getBlockParticleSetId(MemorySegment mem, int offset) {
        return hasBlockParticleSetId(mem, offset) ? PacketIO.readVarString("BlockParticleSetId", mem, offset + getValidatedOffset(mem, offset, 225, 277, "BlockParticleSetId"), 4096000): null;
    }
    
    @Nullable
    public static String getBlockBreakingDecalId(MemorySegment mem) {
        return getBlockBreakingDecalId(mem, 0);
    }
    
    @Nullable
    public static String getBlockBreakingDecalId(MemorySegment mem, int offset) {
        return hasBlockBreakingDecalId(mem, offset) ? PacketIO.readVarString("BlockBreakingDecalId", mem, offset + getValidatedOffset(mem, offset, 229, 277, "BlockBreakingDecalId"), 4096000): null;
    }
    
    @Nullable
    public static Color getParticleColor(MemorySegment mem) {
        return getParticleColor(mem, 0);
    }
    
    @Nullable
    public static Color getParticleColor(MemorySegment mem, int offset) {
        return hasParticleColor(mem, offset) ? Color.toObject(mem, offset + 51): null;
    }
    
    @Nullable
    public static Color getTextureComputedColor(MemorySegment mem) {
        return getTextureComputedColor(mem, 0);
    }
    
    @Nullable
    public static Color getTextureComputedColor(MemorySegment mem, int offset) {
        return hasTextureComputedColor(mem, offset) ? Color.toObject(mem, offset + 54): null;
    }
    
    @Nullable
    public static ColorLight getLight(MemorySegment mem) {
        return getLight(mem, 0);
    }
    
    @Nullable
    public static ColorLight getLight(MemorySegment mem, int offset) {
        return hasLight(mem, offset) ? ColorLight.toObject(mem, offset + 57): null;
    }
    
    @Nullable
    public static Tint getTint(MemorySegment mem) {
        return getTint(mem, 0);
    }
    
    @Nullable
    public static Tint getTint(MemorySegment mem, int offset) {
        return hasTint(mem, offset) ? Tint.toObject(mem, offset + 61): null;
    }
    
    @Nullable
    public static Tint getBiomeTint(MemorySegment mem) {
        return getBiomeTint(mem, 0);
    }
    
    @Nullable
    public static Tint getBiomeTint(MemorySegment mem, int offset) {
        return hasBiomeTint(mem, offset) ? Tint.toObject(mem, offset + 85): null;
    }
    
    public static int getGroup(MemorySegment mem) {
        return getGroup(mem, 0);
    }
    
    public static int getGroup(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 109);
    }
    
    @Nullable
    public static String getTransitionTexture(MemorySegment mem) {
        return getTransitionTexture(mem, 0);
    }
    
    @Nullable
    public static String getTransitionTexture(MemorySegment mem, int offset) {
        return hasTransitionTexture(mem, offset) ? PacketIO.readVarString("TransitionTexture", mem, offset + getValidatedOffset(mem, offset, 233, 277, "TransitionTexture"), 4096000): null;
    }
    
    @Nullable
    public static int[] getTransitionToGroups(MemorySegment mem) {
        return getTransitionToGroups(mem, 0);
    }
    
    @Nullable
    public static int[] getTransitionToGroups(MemorySegment mem, int offset) {
        if (!hasTransitionToGroups(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 237, 277, "TransitionToGroups");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("TransitionToGroups");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("TransitionToGroups", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("TransitionToGroups", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    public static BlockMovementSettings getMovementSettings(MemorySegment mem) {
        return getMovementSettings(mem, 0);
    }
    
    public static BlockMovementSettings getMovementSettings(MemorySegment mem, int offset) {
        return BlockMovementSettings.toObject(mem, offset + 113);
    }
    
    @Nullable
    public static String getInteractionHint(MemorySegment mem) {
        return getInteractionHint(mem, 0);
    }
    
    @Nullable
    public static String getInteractionHint(MemorySegment mem, int offset) {
        return hasInteractionHint(mem, offset) ? PacketIO.readVarString("InteractionHint", mem, offset + getValidatedOffset(mem, offset, 241, 277, "InteractionHint"), 4096000): null;
    }
    
    @Nullable
    public static BlockGathering getGathering(MemorySegment mem) {
        return getGathering(mem, 0);
    }
    
    @Nullable
    public static BlockGathering getGathering(MemorySegment mem, int offset) {
        return hasGathering(mem, offset) ? BlockGathering.toObject(mem, offset + getValidatedOffset(mem, offset, 245, 277, "Gathering")): null;
    }
    
    @Nullable
    public static BlockPlacementSettings getPlacementSettings(MemorySegment mem) {
        return getPlacementSettings(mem, 0);
    }
    
    @Nullable
    public static BlockPlacementSettings getPlacementSettings(MemorySegment mem, int offset) {
        return hasPlacementSettings(mem, offset) ? BlockPlacementSettings.toObject(mem, offset + 156): null;
    }
    
    @Nullable
    public static ModelDisplay getDisplay(MemorySegment mem) {
        return getDisplay(mem, 0);
    }
    
    @Nullable
    public static ModelDisplay getDisplay(MemorySegment mem, int offset) {
        return hasDisplay(mem, offset) ? ModelDisplay.toObject(mem, offset + getValidatedOffset(mem, offset, 249, 277, "Display")): null;
    }
    
    @Nullable
    public static RailConfig getRail(MemorySegment mem) {
        return getRail(mem, 0);
    }
    
    @Nullable
    public static RailConfig getRail(MemorySegment mem, int offset) {
        return hasRail(mem, offset) ? RailConfig.toObject(mem, offset + getValidatedOffset(mem, offset, 253, 277, "Rail")): null;
    }
    
    public static boolean getIgnoreSupportWhenPlaced(MemorySegment mem) {
        return getIgnoreSupportWhenPlaced(mem, 0);
    }
    
    public static boolean getIgnoreSupportWhenPlaced(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 172);
    }
    
    @Nullable
    public static java.util.Map<InteractionType, Integer> getInteractions(MemorySegment mem) {
        return getInteractions(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<InteractionType, Integer> getInteractions(MemorySegment mem, int offset) {
        if (!hasInteractions(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 257, 277, "Interactions");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Interactions");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Interactions", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Interactions", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<InteractionType, Integer> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                off += 1;
            var value = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Interactions", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<String, Integer> getStates(MemorySegment mem) {
        return getStates(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, Integer> getStates(MemorySegment mem, int offset) {
        if (!hasStates(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 261, 277, "States");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("States");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("States", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("States", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, Integer> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("States", key);
            }
        }
        return data;
    }
    
    public static int getTransitionToTag(MemorySegment mem) {
        return getTransitionToTag(mem, 0);
    }
    
    public static int getTransitionToTag(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 173);
    }
    
    @Nullable
    public static int[] getTagIndexes(MemorySegment mem) {
        return getTagIndexes(mem, 0);
    }
    
    @Nullable
    public static int[] getTagIndexes(MemorySegment mem, int offset) {
        if (!hasTagIndexes(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 265, 277, "TagIndexes");
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
    
    @Nullable
    public static Bench getBench(MemorySegment mem) {
        return getBench(mem, 0);
    }
    
    @Nullable
    public static Bench getBench(MemorySegment mem, int offset) {
        return hasBench(mem, offset) ? Bench.toObject(mem, offset + getValidatedOffset(mem, offset, 269, 277, "Bench")): null;
    }
    
    @Nullable
    public static ConnectedBlockRuleSet getConnectedBlockRuleSet(MemorySegment mem) {
        return getConnectedBlockRuleSet(mem, 0);
    }
    
    @Nullable
    public static ConnectedBlockRuleSet getConnectedBlockRuleSet(MemorySegment mem, int offset) {
        return hasConnectedBlockRuleSet(mem, offset) ? ConnectedBlockRuleSet.toObject(mem, offset + getValidatedOffset(mem, offset, 273, 277, "ConnectedBlockRuleSet")): null;
    }
    
    public static boolean hasParticleColor(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasTextureComputedColor(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasLight(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasTint(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasBiomeTint(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasPlacementSettings(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasItem(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasShaderEffect(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasModel(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasModelTexture(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasModelAnimation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasSupport(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasSupporting(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasCubeTextures(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasCubeSideMaskTexture(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasConditionalSounds(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasParticles(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasBlockParticleSetId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasBlockBreakingDecalId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasTransitionTexture(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasTransitionToGroups(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasInteractionHint(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasGathering(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasDisplay(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 3);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasRail(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 3);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasInteractions(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 3);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasStates(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 3);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasTagIndexes(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 3);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasBench(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 3);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasConnectedBlockRuleSet(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 3);
        return (b & 0x40) != 0;
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
    
    public static BlockType toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BlockType toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BlockType and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BlockType toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 277;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasItem(mem, offset)) {
            requireSlot(mem, offset + 177, varPos, "Item");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Item", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 177, -1, "Item");
        }
        
        String v1 = null;
        if (hasName(mem, offset)) {
            requireSlot(mem, offset + 181, varPos, "Name");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Name", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 181, -1, "Name");
        }
        
        ShaderType[] v6 = null;
        if (hasShaderEffect(mem, offset)) {
            requireSlot(mem, offset + 185, varPos, "ShaderEffect");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ShaderEffect");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("ShaderEffect", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("ShaderEffect", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v6 = new ShaderType[len];
            for (var i = 0; i < len; i++) {
                v6[i] = ShaderType.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
            }
            varPos = off + len - varBase;
        } else {
            requireSlot(mem, offset + 185, -1, "ShaderEffect");
        }
        
        String v9 = null;
        if (hasModel(mem, offset)) {
            requireSlot(mem, offset + 189, varPos, "Model");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v9 = PacketIO.readVarString("Model", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 189, -1, "Model");
        }
        
        ModelTexture[] v10 = null;
        if (hasModelTexture(mem, offset)) {
            requireSlot(mem, offset + 193, varPos, "ModelTexture");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ModelTexture");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("ModelTexture", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ModelTexture", (int) java.lang.Math.min(off + lenOffset + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v10 = new ModelTexture[len];
            for (var i = 0; i < len; i++) {
                v10[i] = ModelTexture.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 193, -1, "ModelTexture");
        }
        
        String v12 = null;
        if (hasModelAnimation(mem, offset)) {
            requireSlot(mem, offset + 197, varPos, "ModelAnimation");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v12 = PacketIO.readVarString("ModelAnimation", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 197, -1, "ModelAnimation");
        }
        
        java.util.Map<BlockNeighbor, RequiredBlockFaceSupport[]> v17 = null;
        if (hasSupport(mem, offset)) {
            requireSlot(mem, offset + 201, varPos, "Support");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Support");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Support", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Support", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            v17 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = BlockNeighbor.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                    off += 1;
                var valuePacked = VarInt.getWithLength(mem, off);
                    if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                    var valueLen = (int) valuePacked;
                    var valueVarLen = (int) (valuePacked >>> 32);
                    if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                    if (off + valueVarLen + (long) valueLen * 32 > mem.byteSize())
                        throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 32, (int) mem.byteSize());
                    off += valueVarLen;
                    var value = new RequiredBlockFaceSupport[valueLen];
                    for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                        value[valueIdx] = RequiredBlockFaceSupport.toObject(mem, off, walkCursor);
                        off = walkCursor.position;
                    }
                if (v17.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Support", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 201, -1, "Support");
        }
        
        java.util.Map<BlockNeighbor, BlockFaceSupport[]> v18 = null;
        if (hasSupporting(mem, offset)) {
            requireSlot(mem, offset + 205, varPos, "Supporting");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Supporting");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Supporting", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Supporting", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            v18 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = BlockNeighbor.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                    off += 1;
                var valuePacked = VarInt.getWithLength(mem, off);
                    if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                    var valueLen = (int) valuePacked;
                    var valueVarLen = (int) (valuePacked >>> 32);
                    if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                    if (off + valueVarLen + (long) valueLen * 9 > mem.byteSize())
                        throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 9, (int) mem.byteSize());
                    off += valueVarLen;
                    var value = new BlockFaceSupport[valueLen];
                    for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                        value[valueIdx] = BlockFaceSupport.toObject(mem, off, walkCursor);
                        off = walkCursor.position;
                    }
                if (v18.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Supporting", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 205, -1, "Supporting");
        }
        
        BlockTextures[] v20 = null;
        if (hasCubeTextures(mem, offset)) {
            requireSlot(mem, offset + 209, varPos, "CubeTextures");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("CubeTextures");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("CubeTextures", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 29 > mem.byteSize()) throw ProtocolException.bufferTooSmall("CubeTextures", (int) java.lang.Math.min(off + lenOffset + (long) len * 29, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v20 = new BlockTextures[len];
            for (var i = 0; i < len; i++) {
                v20[i] = BlockTextures.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 209, -1, "CubeTextures");
        }
        
        String v21 = null;
        if (hasCubeSideMaskTexture(mem, offset)) {
            requireSlot(mem, offset + 213, varPos, "CubeSideMaskTexture");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v21 = PacketIO.readVarString("CubeSideMaskTexture", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 213, -1, "CubeSideMaskTexture");
        }
        
        ConditionalBlockSound[] v30 = null;
        if (hasConditionalSounds(mem, offset)) {
            requireSlot(mem, offset + 217, varPos, "ConditionalSounds");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ConditionalSounds");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("ConditionalSounds", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ConditionalSounds", (int) java.lang.Math.min(off + lenOffset + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v30 = new ConditionalBlockSound[len];
            for (var i = 0; i < len; i++) {
                v30[i] = ConditionalBlockSound.toObject(mem, off + i * 8);
            }
            varPos = off + len * 8 - varBase;
        } else {
            requireSlot(mem, offset + 217, -1, "ConditionalSounds");
        }
        
        ModelParticle[] v31 = null;
        if (hasParticles(mem, offset)) {
            requireSlot(mem, offset + 221, varPos, "Particles");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Particles");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Particles", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Particles", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v31 = new ModelParticle[len];
            for (var i = 0; i < len; i++) {
                v31[i] = ModelParticle.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 221, -1, "Particles");
        }
        
        String v32 = null;
        if (hasBlockParticleSetId(mem, offset)) {
            requireSlot(mem, offset + 225, varPos, "BlockParticleSetId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v32 = PacketIO.readVarString("BlockParticleSetId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 225, -1, "BlockParticleSetId");
        }
        
        String v33 = null;
        if (hasBlockBreakingDecalId(mem, offset)) {
            requireSlot(mem, offset + 229, varPos, "BlockBreakingDecalId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v33 = PacketIO.readVarString("BlockBreakingDecalId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 229, -1, "BlockBreakingDecalId");
        }
        
        String v40 = null;
        if (hasTransitionTexture(mem, offset)) {
            requireSlot(mem, offset + 233, varPos, "TransitionTexture");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v40 = PacketIO.readVarString("TransitionTexture", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 233, -1, "TransitionTexture");
        }
        
        int[] v41 = null;
        if (hasTransitionToGroups(mem, offset)) {
            requireSlot(mem, offset + 237, varPos, "TransitionToGroups");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("TransitionToGroups");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("TransitionToGroups", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("TransitionToGroups", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v41 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v41, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 237, -1, "TransitionToGroups");
        }
        
        String v43 = null;
        if (hasInteractionHint(mem, offset)) {
            requireSlot(mem, offset + 241, varPos, "InteractionHint");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v43 = PacketIO.readVarString("InteractionHint", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 241, -1, "InteractionHint");
        }
        
        BlockGathering v44 = null;
        if (hasGathering(mem, offset)) {
            requireSlot(mem, offset + 245, varPos, "Gathering");
            v44 = BlockGathering.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 245, -1, "Gathering");
        }
        
        ModelDisplay v46 = null;
        if (hasDisplay(mem, offset)) {
            requireSlot(mem, offset + 249, varPos, "Display");
            v46 = ModelDisplay.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 249, -1, "Display");
        }
        
        RailConfig v47 = null;
        if (hasRail(mem, offset)) {
            requireSlot(mem, offset + 253, varPos, "Rail");
            v47 = RailConfig.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 253, -1, "Rail");
        }
        
        java.util.Map<InteractionType, Integer> v49 = null;
        if (hasInteractions(mem, offset)) {
            requireSlot(mem, offset + 257, varPos, "Interactions");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Interactions");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Interactions", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Interactions", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v49 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                    off += 1;
                var value = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                if (v49.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Interactions", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 257, -1, "Interactions");
        }
        
        java.util.Map<String, Integer> v50 = null;
        if (hasStates(mem, offset)) {
            requireSlot(mem, offset + 261, varPos, "States");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("States");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("States", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("States", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v50 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                if (v50.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("States", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 261, -1, "States");
        }
        
        int[] v52 = null;
        if (hasTagIndexes(mem, offset)) {
            requireSlot(mem, offset + 265, varPos, "TagIndexes");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("TagIndexes");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("TagIndexes", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("TagIndexes", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v52 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v52, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 265, -1, "TagIndexes");
        }
        
        Bench v53 = null;
        if (hasBench(mem, offset)) {
            requireSlot(mem, offset + 269, varPos, "Bench");
            v53 = Bench.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 269, -1, "Bench");
        }
        
        ConnectedBlockRuleSet v54 = null;
        if (hasConnectedBlockRuleSet(mem, offset)) {
            requireSlot(mem, offset + 273, varPos, "ConnectedBlockRuleSet");
            v54 = ConnectedBlockRuleSet.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 273, -1, "ConnectedBlockRuleSet");
        }
        var result = new BlockType(
            v0,
            v1,
            mem.get(PacketIO.PROTO_BOOL, offset + 4),
            DrawType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 5)),
            BlockMaterial.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 6)),
            Opacity.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 7)),
            v6,
            mem.get(PacketIO.PROTO_INT, offset + 8),
            mem.get(PacketIO.PROTO_INT, offset + 12),
            v9,
            v10,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "ModelScale"),
            v12,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "ModelAnimationSpeed"),
            mem.get(PacketIO.PROTO_BOOL, offset + 24),
            mem.get(PacketIO.PROTO_INT, offset + 25),
            BlockSupportsRequiredForType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 29)),
            v17,
            v18,
            mem.get(PacketIO.PROTO_BOOL, offset + 30),
            v20,
            v21,
            ShadingMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 31)),
            RandomRotation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 32)),
            VariantRotation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 33)),
            Rotation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 34)),
            mem.get(PacketIO.PROTO_INT, offset + 35),
            mem.get(PacketIO.PROTO_INT, offset + 39),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 43), "SoundOcclusionOpacity"),
            mem.get(PacketIO.PROTO_INT, offset + 47),
            v30,
            v31,
            v32,
            v33,
            hasParticleColor(mem, offset) ? Color.toObject(mem, offset + 51) : null,
            hasTextureComputedColor(mem, offset) ? Color.toObject(mem, offset + 54) : null,
            hasLight(mem, offset) ? ColorLight.toObject(mem, offset + 57) : null,
            hasTint(mem, offset) ? Tint.toObject(mem, offset + 61) : null,
            hasBiomeTint(mem, offset) ? Tint.toObject(mem, offset + 85) : null,
            mem.get(PacketIO.PROTO_INT, offset + 109),
            v40,
            v41,
            BlockMovementSettings.toObject(mem, offset + 113),
            v43,
            v44,
            hasPlacementSettings(mem, offset) ? BlockPlacementSettings.toObject(mem, offset + 156) : null,
            v46,
            v47,
            mem.get(PacketIO.PROTO_BOOL, offset + 172),
            v49,
            v50,
            mem.get(PacketIO.PROTO_INT, offset + 173),
            v52,
            v53,
            v54
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.particleColor != null) nullBits |= 0x01;
        if (this.textureComputedColor != null) nullBits |= 0x02;
        if (this.light != null) nullBits |= 0x04;
        if (this.tint != null) nullBits |= 0x08;
        if (this.biomeTint != null) nullBits |= 0x10;
        if (this.placementSettings != null) nullBits |= 0x20;
        if (this.item != null) nullBits |= 0x40;
        if (this.name != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        nullBits = 0;
        if (this.shaderEffect != null) nullBits |= 0x01;
        if (this.model != null) nullBits |= 0x02;
        if (this.modelTexture != null) nullBits |= 0x04;
        if (this.modelAnimation != null) nullBits |= 0x08;
        if (this.support != null) nullBits |= 0x10;
        if (this.supporting != null) nullBits |= 0x20;
        if (this.cubeTextures != null) nullBits |= 0x40;
        if (this.cubeSideMaskTexture != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 1, nullBits);
        nullBits = 0;
        if (this.conditionalSounds != null) nullBits |= 0x01;
        if (this.particles != null) nullBits |= 0x02;
        if (this.blockParticleSetId != null) nullBits |= 0x04;
        if (this.blockBreakingDecalId != null) nullBits |= 0x08;
        if (this.transitionTexture != null) nullBits |= 0x10;
        if (this.transitionToGroups != null) nullBits |= 0x20;
        if (this.interactionHint != null) nullBits |= 0x40;
        if (this.gathering != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 2, nullBits);
        nullBits = 0;
        if (this.display != null) nullBits |= 0x01;
        if (this.rail != null) nullBits |= 0x02;
        if (this.interactions != null) nullBits |= 0x04;
        if (this.states != null) nullBits |= 0x08;
        if (this.tagIndexes != null) nullBits |= 0x10;
        if (this.bench != null) nullBits |= 0x20;
        if (this.connectedBlockRuleSet != null) nullBits |= 0x40;
        mem.set(PacketIO.PROTO_BYTE, offset + 3, nullBits);
        
        mem.set(PacketIO.PROTO_BOOL, offset + 4, this.unknown);
        mem.set(PacketIO.PROTO_BYTE, offset + 5, (byte) this.drawType.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 6, (byte) this.material.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 7, (byte) this.opacity.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 8, this.hitbox);
        mem.set(PacketIO.PROTO_INT, offset + 12, this.interactionHitbox);
        PacketIO.requireFinite(this.modelScale, "ModelScale"); mem.set(PacketIO.PROTO_FLOAT, offset + 16, this.modelScale);
        PacketIO.requireFinite(this.modelAnimationSpeed, "ModelAnimationSpeed"); mem.set(PacketIO.PROTO_FLOAT, offset + 20, this.modelAnimationSpeed);
        mem.set(PacketIO.PROTO_BOOL, offset + 24, this.looping);
        mem.set(PacketIO.PROTO_INT, offset + 25, this.maxSupportDistance);
        mem.set(PacketIO.PROTO_BYTE, offset + 29, (byte) this.blockSupportsRequiredFor.getValue());
        mem.set(PacketIO.PROTO_BOOL, offset + 30, this.requiresAlphaBlending);
        mem.set(PacketIO.PROTO_BYTE, offset + 31, (byte) this.cubeShadingMode.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 32, (byte) this.randomRotation.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 33, (byte) this.variantRotation.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 34, (byte) this.rotationYawPlacementOffset.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 35, this.blockSoundSetIndex);
        mem.set(PacketIO.PROTO_INT, offset + 39, this.physicalMaterialIndex);
        PacketIO.requireFinite(this.soundOcclusionOpacity, "SoundOcclusionOpacity"); mem.set(PacketIO.PROTO_FLOAT, offset + 43, this.soundOcclusionOpacity);
        mem.set(PacketIO.PROTO_INT, offset + 47, this.ambientSoundEventIndex);
        if (this.particleColor != null) {
            this.particleColor.serialize(mem, offset + 51);
        } else {
            mem.asSlice(offset + 51, 3).fill((byte) 0); 
        }
        if (this.textureComputedColor != null) {
            this.textureComputedColor.serialize(mem, offset + 54);
        } else {
            mem.asSlice(offset + 54, 3).fill((byte) 0); 
        }
        if (this.light != null) {
            this.light.serialize(mem, offset + 57);
        } else {
            mem.asSlice(offset + 57, 4).fill((byte) 0); 
        }
        if (this.tint != null) {
            this.tint.serialize(mem, offset + 61);
        } else {
            mem.asSlice(offset + 61, 24).fill((byte) 0); 
        }
        if (this.biomeTint != null) {
            this.biomeTint.serialize(mem, offset + 85);
        } else {
            mem.asSlice(offset + 85, 24).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_INT, offset + 109, this.group);
        this.movementSettings.serialize(mem, offset + 113);
        if (this.placementSettings != null) {
            this.placementSettings.serialize(mem, offset + 156);
        } else {
            mem.asSlice(offset + 156, 16).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BOOL, offset + 172, this.ignoreSupportWhenPlaced);
        mem.set(PacketIO.PROTO_INT, offset + 173, this.transitionToTag);
        var varOffset = offset + 277;
        if (this.item != null) {
            mem.set(PacketIO.PROTO_INT, offset + 177, varOffset - offset - 277);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.item, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 177, -1);
        }
        if (this.name != null) {
            mem.set(PacketIO.PROTO_INT, offset + 181, varOffset - offset - 277);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.name, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 181, -1);
        }
        if (this.shaderEffect != null) {
            mem.set(PacketIO.PROTO_INT, offset + 185, varOffset - offset - 277);
            if (shaderEffect.length > 4096000) throw ProtocolException.arrayTooLong("ShaderEffect", shaderEffect.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.shaderEffect.length);
            
            for (var i = 0; i < this.shaderEffect.length; i++) {
                mem.set(PacketIO.PROTO_BYTE, varOffset + i * 1, (byte) this.shaderEffect[i].getValue());
            }
            varOffset += this.shaderEffect.length * 1;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 185, -1);
        }
        if (this.model != null) {
            mem.set(PacketIO.PROTO_INT, offset + 189, varOffset - offset - 277);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.model, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 189, -1);
        }
        if (this.modelTexture != null) {
            mem.set(PacketIO.PROTO_INT, offset + 193, varOffset - offset - 277);
            if (modelTexture.length > 4096000) throw ProtocolException.arrayTooLong("ModelTexture", modelTexture.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.modelTexture.length);
            
            var modelTextureValueOffset = 0;
            for (var i = 0; i < this.modelTexture.length; i++) {
                modelTextureValueOffset += this.modelTexture[i].serialize(mem, varOffset + modelTextureValueOffset);
            }
            varOffset += modelTextureValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 193, -1);
        }
        if (this.modelAnimation != null) {
            mem.set(PacketIO.PROTO_INT, offset + 197, varOffset - offset - 277);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.modelAnimation, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 197, -1);
        }
        if (this.support != null) {
            mem.set(PacketIO.PROTO_INT, offset + 201, varOffset - offset - 277);
            if (this.support.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Support", support.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.support.size());
            for (var e : this.support.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                varOffset += VarInt.set(mem, varOffset, e.getValue().length);
                for (var arrItem : e.getValue()) {
                    varOffset += arrItem.serialize(mem, varOffset);
                }
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 201, -1);
        }
        if (this.supporting != null) {
            mem.set(PacketIO.PROTO_INT, offset + 205, varOffset - offset - 277);
            if (this.supporting.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Supporting", supporting.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.supporting.size());
            for (var e : this.supporting.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                varOffset += VarInt.set(mem, varOffset, e.getValue().length);
                for (var arrItem : e.getValue()) {
                    varOffset += arrItem.serialize(mem, varOffset);
                }
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 205, -1);
        }
        if (this.cubeTextures != null) {
            mem.set(PacketIO.PROTO_INT, offset + 209, varOffset - offset - 277);
            if (cubeTextures.length > 4096000) throw ProtocolException.arrayTooLong("CubeTextures", cubeTextures.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.cubeTextures.length);
            
            var cubeTexturesValueOffset = 0;
            for (var i = 0; i < this.cubeTextures.length; i++) {
                cubeTexturesValueOffset += this.cubeTextures[i].serialize(mem, varOffset + cubeTexturesValueOffset);
            }
            varOffset += cubeTexturesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 209, -1);
        }
        if (this.cubeSideMaskTexture != null) {
            mem.set(PacketIO.PROTO_INT, offset + 213, varOffset - offset - 277);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.cubeSideMaskTexture, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 213, -1);
        }
        if (this.conditionalSounds != null) {
            mem.set(PacketIO.PROTO_INT, offset + 217, varOffset - offset - 277);
            if (conditionalSounds.length > 4096000) throw ProtocolException.arrayTooLong("ConditionalSounds", conditionalSounds.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.conditionalSounds.length);
            
            var conditionalSoundsValueOffset = 0;
            for (var i = 0; i < this.conditionalSounds.length; i++) {
                conditionalSoundsValueOffset += this.conditionalSounds[i].serialize(mem, varOffset + conditionalSoundsValueOffset);
            }
            varOffset += conditionalSoundsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 217, -1);
        }
        if (this.particles != null) {
            mem.set(PacketIO.PROTO_INT, offset + 221, varOffset - offset - 277);
            if (particles.length > 4096000) throw ProtocolException.arrayTooLong("Particles", particles.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.particles.length);
            
            var particlesValueOffset = 0;
            for (var i = 0; i < this.particles.length; i++) {
                particlesValueOffset += this.particles[i].serialize(mem, varOffset + particlesValueOffset);
            }
            varOffset += particlesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 221, -1);
        }
        if (this.blockParticleSetId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 225, varOffset - offset - 277);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.blockParticleSetId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 225, -1);
        }
        if (this.blockBreakingDecalId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 229, varOffset - offset - 277);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.blockBreakingDecalId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 229, -1);
        }
        if (this.transitionTexture != null) {
            mem.set(PacketIO.PROTO_INT, offset + 233, varOffset - offset - 277);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.transitionTexture, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 233, -1);
        }
        if (this.transitionToGroups != null) {
            mem.set(PacketIO.PROTO_INT, offset + 237, varOffset - offset - 277);
            if (transitionToGroups.length > 4096000) throw ProtocolException.arrayTooLong("TransitionToGroups", transitionToGroups.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.transitionToGroups.length);
            
            MemorySegment.copy(this.transitionToGroups, 0, mem, PacketIO.PROTO_INT, varOffset, this.transitionToGroups.length);
            varOffset += this.transitionToGroups.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 237, -1);
        }
        if (this.interactionHint != null) {
            mem.set(PacketIO.PROTO_INT, offset + 241, varOffset - offset - 277);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.interactionHint, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 241, -1);
        }
        if (this.gathering != null) {
            mem.set(PacketIO.PROTO_INT, offset + 245, varOffset - offset - 277);
            varOffset += this.gathering.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 245, -1);
        }
        if (this.display != null) {
            mem.set(PacketIO.PROTO_INT, offset + 249, varOffset - offset - 277);
            varOffset += this.display.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 249, -1);
        }
        if (this.rail != null) {
            mem.set(PacketIO.PROTO_INT, offset + 253, varOffset - offset - 277);
            varOffset += this.rail.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 253, -1);
        }
        if (this.interactions != null) {
            mem.set(PacketIO.PROTO_INT, offset + 257, varOffset - offset - 277);
            if (this.interactions.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Interactions", interactions.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.interactions.size());
            for (var e : this.interactions.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                mem.set(PacketIO.PROTO_INT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 257, -1);
        }
        if (this.states != null) {
            mem.set(PacketIO.PROTO_INT, offset + 261, varOffset - offset - 277);
            if (this.states.size() > 4096000) throw ProtocolException.dictionaryTooLarge("States", states.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.states.size());
            for (var e : this.states.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                mem.set(PacketIO.PROTO_INT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 261, -1);
        }
        if (this.tagIndexes != null) {
            mem.set(PacketIO.PROTO_INT, offset + 265, varOffset - offset - 277);
            if (tagIndexes.length > 4096000) throw ProtocolException.arrayTooLong("TagIndexes", tagIndexes.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.tagIndexes.length);
            
            MemorySegment.copy(this.tagIndexes, 0, mem, PacketIO.PROTO_INT, varOffset, this.tagIndexes.length);
            varOffset += this.tagIndexes.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 265, -1);
        }
        if (this.bench != null) {
            mem.set(PacketIO.PROTO_INT, offset + 269, varOffset - offset - 277);
            varOffset += this.bench.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 269, -1);
        }
        if (this.connectedBlockRuleSet != null) {
            mem.set(PacketIO.PROTO_INT, offset + 273, varOffset - offset - 277);
            varOffset += this.connectedBlockRuleSet.serializeWithTypeId(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 273, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 277;
        if (item != null) size += PacketIO.stringSize(item);
    if (name != null) size += PacketIO.stringSize(name);
    if (shaderEffect != null) size += VarInt.size(shaderEffect.length) + shaderEffect.length * 1;
    if (model != null) size += PacketIO.stringSize(model);
    if (modelTexture != null) {
        int modelTextureSize = 0;
for (var elem : modelTexture) modelTextureSize += elem.computeSize();
size += VarInt.size(modelTexture.length) + modelTextureSize;
    }
    if (modelAnimation != null) size += PacketIO.stringSize(modelAnimation);
    if (support != null) {
        int supportSize = 0;
for (var kvp : support.entrySet()) supportSize += 1 + VarInt.size(kvp.getValue().length) + java.util.Arrays.stream(kvp.getValue()).mapToInt(inner -> inner.computeSize()).sum();
size += VarInt.size(support.size()) + supportSize;
    }
    if (supporting != null) {
        int supportingSize = 0;
for (var kvp : supporting.entrySet()) supportingSize += 1 + VarInt.size(kvp.getValue().length) + java.util.Arrays.stream(kvp.getValue()).mapToInt(inner -> inner.computeSize()).sum();
size += VarInt.size(supporting.size()) + supportingSize;
    }
    if (cubeTextures != null) {
        int cubeTexturesSize = 0;
for (var elem : cubeTextures) cubeTexturesSize += elem.computeSize();
size += VarInt.size(cubeTextures.length) + cubeTexturesSize;
    }
    if (cubeSideMaskTexture != null) size += PacketIO.stringSize(cubeSideMaskTexture);
    if (conditionalSounds != null) size += VarInt.size(conditionalSounds.length) + conditionalSounds.length * 8;
    if (particles != null) {
        int particlesSize = 0;
for (var elem : particles) particlesSize += elem.computeSize();
size += VarInt.size(particles.length) + particlesSize;
    }
    if (blockParticleSetId != null) size += PacketIO.stringSize(blockParticleSetId);
    if (blockBreakingDecalId != null) size += PacketIO.stringSize(blockBreakingDecalId);
    if (transitionTexture != null) size += PacketIO.stringSize(transitionTexture);
    if (transitionToGroups != null) size += VarInt.size(transitionToGroups.length) + transitionToGroups.length * 4;
    if (interactionHint != null) size += PacketIO.stringSize(interactionHint);
    if (gathering != null) size += gathering.computeSize();
    if (display != null) size += display.computeSize();
    if (rail != null) size += rail.computeSize();
    if (interactions != null) size += VarInt.size(interactions.size()) + interactions.size() * (1 + 4);
    if (states != null) {
        int statesSize = 0;
for (var kvp : states.entrySet()) statesSize += PacketIO.stringSize(kvp.getKey()) + 4;
size += VarInt.size(states.size()) + statesSize;
    }
    if (tagIndexes != null) size += VarInt.size(tagIndexes.length) + tagIndexes.length * 4;
    if (bench != null) size += bench.computeSize();
    if (connectedBlockRuleSet != null) size += connectedBlockRuleSet.computeSizeWithTypeId();

        return size;
    }

    public BlockType clone() {
        BlockType copy = new BlockType();
        copy.item = this.item;
        copy.name = this.name;
        copy.unknown = this.unknown;
        copy.drawType = this.drawType;
        copy.material = this.material;
        copy.opacity = this.opacity;
        copy.shaderEffect = this.shaderEffect != null ? java.util.Arrays.copyOf(this.shaderEffect, this.shaderEffect.length) : null;
        copy.hitbox = this.hitbox;
        copy.interactionHitbox = this.interactionHitbox;
        copy.model = this.model;
        copy.modelTexture = this.modelTexture != null ? java.util.Arrays.stream(this.modelTexture).map(e -> e.clone()).toArray(ModelTexture[]::new) : null;
        copy.modelScale = this.modelScale;
        copy.modelAnimation = this.modelAnimation;
        copy.modelAnimationSpeed = this.modelAnimationSpeed;
        copy.looping = this.looping;
        copy.maxSupportDistance = this.maxSupportDistance;
        copy.blockSupportsRequiredFor = this.blockSupportsRequiredFor;
        if (this.support != null) {
            java.util.Map<BlockNeighbor, RequiredBlockFaceSupport[]> m = new java.util.HashMap<>();
            for (var e : this.support.entrySet()) { m.put(e.getKey(), java.util.Arrays.stream(e.getValue()).map(x -> x.clone()).toArray(RequiredBlockFaceSupport[]::new)); }
            copy.support = m;
        }
        if (this.supporting != null) {
            java.util.Map<BlockNeighbor, BlockFaceSupport[]> m = new java.util.HashMap<>();
            for (var e : this.supporting.entrySet()) { m.put(e.getKey(), java.util.Arrays.stream(e.getValue()).map(x -> x.clone()).toArray(BlockFaceSupport[]::new)); }
            copy.supporting = m;
        }
        copy.requiresAlphaBlending = this.requiresAlphaBlending;
        copy.cubeTextures = this.cubeTextures != null ? java.util.Arrays.stream(this.cubeTextures).map(e -> e.clone()).toArray(BlockTextures[]::new) : null;
        copy.cubeSideMaskTexture = this.cubeSideMaskTexture;
        copy.cubeShadingMode = this.cubeShadingMode;
        copy.randomRotation = this.randomRotation;
        copy.variantRotation = this.variantRotation;
        copy.rotationYawPlacementOffset = this.rotationYawPlacementOffset;
        copy.blockSoundSetIndex = this.blockSoundSetIndex;
        copy.physicalMaterialIndex = this.physicalMaterialIndex;
        copy.soundOcclusionOpacity = this.soundOcclusionOpacity;
        copy.ambientSoundEventIndex = this.ambientSoundEventIndex;
        copy.conditionalSounds = this.conditionalSounds != null ? java.util.Arrays.stream(this.conditionalSounds).map(e -> e.clone()).toArray(ConditionalBlockSound[]::new) : null;
        copy.particles = this.particles != null ? java.util.Arrays.stream(this.particles).map(e -> e.clone()).toArray(ModelParticle[]::new) : null;
        copy.blockParticleSetId = this.blockParticleSetId;
        copy.blockBreakingDecalId = this.blockBreakingDecalId;
        copy.particleColor = this.particleColor != null ? this.particleColor.clone() : null;
        copy.textureComputedColor = this.textureComputedColor != null ? this.textureComputedColor.clone() : null;
        copy.light = this.light != null ? this.light.clone() : null;
        copy.tint = this.tint != null ? this.tint.clone() : null;
        copy.biomeTint = this.biomeTint != null ? this.biomeTint.clone() : null;
        copy.group = this.group;
        copy.transitionTexture = this.transitionTexture;
        copy.transitionToGroups = this.transitionToGroups != null ? java.util.Arrays.copyOf(this.transitionToGroups, this.transitionToGroups.length) : null;
        copy.movementSettings = this.movementSettings.clone();
        copy.interactionHint = this.interactionHint;
        copy.gathering = this.gathering != null ? this.gathering.clone() : null;
        copy.placementSettings = this.placementSettings != null ? this.placementSettings.clone() : null;
        copy.display = this.display != null ? this.display.clone() : null;
        copy.rail = this.rail != null ? this.rail.clone() : null;
        copy.ignoreSupportWhenPlaced = this.ignoreSupportWhenPlaced;
        copy.interactions = this.interactions != null ? new java.util.HashMap<>(this.interactions) : null;
        copy.states = this.states != null ? new java.util.HashMap<>(this.states) : null;
        copy.transitionToTag = this.transitionToTag;
        copy.tagIndexes = this.tagIndexes != null ? java.util.Arrays.copyOf(this.tagIndexes, this.tagIndexes.length) : null;
        copy.bench = this.bench != null ? this.bench.clone() : null;
        copy.connectedBlockRuleSet = this.connectedBlockRuleSet;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BlockType other)) return false;
        return java.util.Objects.equals(this.item, other.item) && java.util.Objects.equals(this.name, other.name) && this.unknown == other.unknown && java.util.Objects.equals(this.drawType, other.drawType) && java.util.Objects.equals(this.material, other.material) && java.util.Objects.equals(this.opacity, other.opacity) && java.util.Arrays.equals(this.shaderEffect, other.shaderEffect) && this.hitbox == other.hitbox && this.interactionHitbox == other.interactionHitbox && java.util.Objects.equals(this.model, other.model) && java.util.Arrays.equals(this.modelTexture, other.modelTexture) && this.modelScale == other.modelScale && java.util.Objects.equals(this.modelAnimation, other.modelAnimation) && this.modelAnimationSpeed == other.modelAnimationSpeed && this.looping == other.looping && this.maxSupportDistance == other.maxSupportDistance && java.util.Objects.equals(this.blockSupportsRequiredFor, other.blockSupportsRequiredFor) && java.util.Objects.equals(this.support, other.support) && java.util.Objects.equals(this.supporting, other.supporting) && this.requiresAlphaBlending == other.requiresAlphaBlending && java.util.Arrays.equals(this.cubeTextures, other.cubeTextures) && java.util.Objects.equals(this.cubeSideMaskTexture, other.cubeSideMaskTexture) && java.util.Objects.equals(this.cubeShadingMode, other.cubeShadingMode) && java.util.Objects.equals(this.randomRotation, other.randomRotation) && java.util.Objects.equals(this.variantRotation, other.variantRotation) && java.util.Objects.equals(this.rotationYawPlacementOffset, other.rotationYawPlacementOffset) && this.blockSoundSetIndex == other.blockSoundSetIndex && this.physicalMaterialIndex == other.physicalMaterialIndex && this.soundOcclusionOpacity == other.soundOcclusionOpacity && this.ambientSoundEventIndex == other.ambientSoundEventIndex && java.util.Arrays.equals(this.conditionalSounds, other.conditionalSounds) && java.util.Arrays.equals(this.particles, other.particles) && java.util.Objects.equals(this.blockParticleSetId, other.blockParticleSetId) && java.util.Objects.equals(this.blockBreakingDecalId, other.blockBreakingDecalId) && java.util.Objects.equals(this.particleColor, other.particleColor) && java.util.Objects.equals(this.textureComputedColor, other.textureComputedColor) && java.util.Objects.equals(this.light, other.light) && java.util.Objects.equals(this.tint, other.tint) && java.util.Objects.equals(this.biomeTint, other.biomeTint) && this.group == other.group && java.util.Objects.equals(this.transitionTexture, other.transitionTexture) && java.util.Arrays.equals(this.transitionToGroups, other.transitionToGroups) && java.util.Objects.equals(this.movementSettings, other.movementSettings) && java.util.Objects.equals(this.interactionHint, other.interactionHint) && java.util.Objects.equals(this.gathering, other.gathering) && java.util.Objects.equals(this.placementSettings, other.placementSettings) && java.util.Objects.equals(this.display, other.display) && java.util.Objects.equals(this.rail, other.rail) && this.ignoreSupportWhenPlaced == other.ignoreSupportWhenPlaced && java.util.Objects.equals(this.interactions, other.interactions) && java.util.Objects.equals(this.states, other.states) && this.transitionToTag == other.transitionToTag && java.util.Arrays.equals(this.tagIndexes, other.tagIndexes) && java.util.Objects.equals(this.bench, other.bench) && java.util.Objects.equals(this.connectedBlockRuleSet, other.connectedBlockRuleSet);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(item);
        result = 31 * result + java.util.Objects.hashCode(name);
        result = 31 * result + Boolean.hashCode(unknown);
        result = 31 * result + java.util.Objects.hashCode(drawType);
        result = 31 * result + java.util.Objects.hashCode(material);
        result = 31 * result + java.util.Objects.hashCode(opacity);
        result = 31 * result + java.util.Arrays.hashCode(shaderEffect);
        result = 31 * result + Integer.hashCode(hitbox);
        result = 31 * result + Integer.hashCode(interactionHitbox);
        result = 31 * result + java.util.Objects.hashCode(model);
        result = 31 * result + java.util.Arrays.hashCode(modelTexture);
        result = 31 * result + Float.hashCode(modelScale);
        result = 31 * result + java.util.Objects.hashCode(modelAnimation);
        result = 31 * result + Float.hashCode(modelAnimationSpeed);
        result = 31 * result + Boolean.hashCode(looping);
        result = 31 * result + Integer.hashCode(maxSupportDistance);
        result = 31 * result + java.util.Objects.hashCode(blockSupportsRequiredFor);
        result = 31 * result + java.util.Objects.hashCode(support);
        result = 31 * result + java.util.Objects.hashCode(supporting);
        result = 31 * result + Boolean.hashCode(requiresAlphaBlending);
        result = 31 * result + java.util.Arrays.hashCode(cubeTextures);
        result = 31 * result + java.util.Objects.hashCode(cubeSideMaskTexture);
        result = 31 * result + java.util.Objects.hashCode(cubeShadingMode);
        result = 31 * result + java.util.Objects.hashCode(randomRotation);
        result = 31 * result + java.util.Objects.hashCode(variantRotation);
        result = 31 * result + java.util.Objects.hashCode(rotationYawPlacementOffset);
        result = 31 * result + Integer.hashCode(blockSoundSetIndex);
        result = 31 * result + Integer.hashCode(physicalMaterialIndex);
        result = 31 * result + Float.hashCode(soundOcclusionOpacity);
        result = 31 * result + Integer.hashCode(ambientSoundEventIndex);
        result = 31 * result + java.util.Arrays.hashCode(conditionalSounds);
        result = 31 * result + java.util.Arrays.hashCode(particles);
        result = 31 * result + java.util.Objects.hashCode(blockParticleSetId);
        result = 31 * result + java.util.Objects.hashCode(blockBreakingDecalId);
        result = 31 * result + java.util.Objects.hashCode(particleColor);
        result = 31 * result + java.util.Objects.hashCode(textureComputedColor);
        result = 31 * result + java.util.Objects.hashCode(light);
        result = 31 * result + java.util.Objects.hashCode(tint);
        result = 31 * result + java.util.Objects.hashCode(biomeTint);
        result = 31 * result + Integer.hashCode(group);
        result = 31 * result + java.util.Objects.hashCode(transitionTexture);
        result = 31 * result + java.util.Arrays.hashCode(transitionToGroups);
        result = 31 * result + java.util.Objects.hashCode(movementSettings);
        result = 31 * result + java.util.Objects.hashCode(interactionHint);
        result = 31 * result + java.util.Objects.hashCode(gathering);
        result = 31 * result + java.util.Objects.hashCode(placementSettings);
        result = 31 * result + java.util.Objects.hashCode(display);
        result = 31 * result + java.util.Objects.hashCode(rail);
        result = 31 * result + Boolean.hashCode(ignoreSupportWhenPlaced);
        result = 31 * result + java.util.Objects.hashCode(interactions);
        result = 31 * result + java.util.Objects.hashCode(states);
        result = 31 * result + Integer.hashCode(transitionToTag);
        result = 31 * result + java.util.Arrays.hashCode(tagIndexes);
        result = 31 * result + java.util.Objects.hashCode(bench);
        result = 31 * result + java.util.Objects.hashCode(connectedBlockRuleSet);
        return result;
    }

}