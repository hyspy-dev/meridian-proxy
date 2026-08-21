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
import meridian.protocol.packets.buildertools.BuilderToolState;
import java.util.HashMap;

public class ItemBase {
    public static final int NULLABLE_BIT_FIELD_SIZE = 5;
    public static final int FIXED_BLOCK_SIZE = 146;
    public static final int VARIABLE_FIELD_COUNT = 30;
    public static final int VARIABLE_BLOCK_START = 266;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String id;
    @Nullable public String model;
    public float scale;
    @Nullable public String texture;
    @Nullable public String animation;
    @Nullable public String playerAnimationsId;
    public boolean usePlayerAnimations;
    public int maxStack;
    public int reticleIndex;
    @Nullable public String icon;
    @Nullable public AssetIconProperties iconProperties;
    @Nullable public ItemTranslationProperties translationProperties;
    public int itemLevel;
    public int qualityIndex;
    @Nullable public ItemResourceType[] resourceTypes;
    public boolean consumable;
    public boolean variant;
    public int blockId;
    @Nullable public ItemTool tool;
    @Nullable public ItemWeapon weapon;
    @Nullable public ItemArmor armor;
    @Nullable public ItemGlider gliderConfig;
    @Nullable public ItemUtility utility;
    @Nullable public BlockSelectorToolData blockSelectorTool;
    @Nullable public BuilderToolState builderToolData;
    @Nullable public ItemEntityConfig itemEntity;
    @Nullable public String set;
    @Nullable public String[] categories;
    @Nullable public String subCategory;
    @Nullable public ModelParticle[] particles;
    @Nullable public ModelParticle[] firstPersonParticles;
    @Nullable public ModelTrail[] trails;
    @Nullable public ColorLight light;
    public double durability;
    public int soundEventIndex;
    public int itemSoundSetIndex;
    @Nullable public java.util.Map<InteractionType, Integer> interactions;
    @Nullable public java.util.Map<InteractionType, Integer> carryInteractions;
    @Nullable public java.util.Map<InteractionType, String> carryHudInputBindings;
    @Nullable public java.util.Map<String, Integer> interactionVars;
    @Nullable public InteractionConfiguration interactionConfig;
    @Nullable public String droppedItemAnimation;
    @Nullable public int[] tagIndexes;
    @Nullable public java.util.Map<Integer, ItemAppearanceCondition[]> itemAppearanceConditions;
    @Nullable public int[] displayEntityStatsHUD;
    @Nullable public ItemPullbackConfiguration pullbackConfig;
    public boolean clipsGeometry;
    public boolean renderDeployablePreview;
    @Nullable public ItemHudUI[] hudUI;

    public ItemBase() {
    }

    public ItemBase(@Nullable String id, @Nullable String model, float scale, @Nullable String texture, @Nullable String animation, @Nullable String playerAnimationsId, boolean usePlayerAnimations, int maxStack, int reticleIndex, @Nullable String icon, @Nullable AssetIconProperties iconProperties, @Nullable ItemTranslationProperties translationProperties, int itemLevel, int qualityIndex, @Nullable ItemResourceType[] resourceTypes, boolean consumable, boolean variant, int blockId, @Nullable ItemTool tool, @Nullable ItemWeapon weapon, @Nullable ItemArmor armor, @Nullable ItemGlider gliderConfig, @Nullable ItemUtility utility, @Nullable BlockSelectorToolData blockSelectorTool, @Nullable BuilderToolState builderToolData, @Nullable ItemEntityConfig itemEntity, @Nullable String set, @Nullable String[] categories, @Nullable String subCategory, @Nullable ModelParticle[] particles, @Nullable ModelParticle[] firstPersonParticles, @Nullable ModelTrail[] trails, @Nullable ColorLight light, double durability, int soundEventIndex, int itemSoundSetIndex, @Nullable java.util.Map<InteractionType, Integer> interactions, @Nullable java.util.Map<InteractionType, Integer> carryInteractions, @Nullable java.util.Map<InteractionType, String> carryHudInputBindings, @Nullable java.util.Map<String, Integer> interactionVars, @Nullable InteractionConfiguration interactionConfig, @Nullable String droppedItemAnimation, @Nullable int[] tagIndexes, @Nullable java.util.Map<Integer, ItemAppearanceCondition[]> itemAppearanceConditions, @Nullable int[] displayEntityStatsHUD, @Nullable ItemPullbackConfiguration pullbackConfig, boolean clipsGeometry, boolean renderDeployablePreview, @Nullable ItemHudUI[] hudUI) {
        this.id = id;
        this.model = model;
        this.scale = scale;
        this.texture = texture;
        this.animation = animation;
        this.playerAnimationsId = playerAnimationsId;
        this.usePlayerAnimations = usePlayerAnimations;
        this.maxStack = maxStack;
        this.reticleIndex = reticleIndex;
        this.icon = icon;
        this.iconProperties = iconProperties;
        this.translationProperties = translationProperties;
        this.itemLevel = itemLevel;
        this.qualityIndex = qualityIndex;
        this.resourceTypes = resourceTypes;
        this.consumable = consumable;
        this.variant = variant;
        this.blockId = blockId;
        this.tool = tool;
        this.weapon = weapon;
        this.armor = armor;
        this.gliderConfig = gliderConfig;
        this.utility = utility;
        this.blockSelectorTool = blockSelectorTool;
        this.builderToolData = builderToolData;
        this.itemEntity = itemEntity;
        this.set = set;
        this.categories = categories;
        this.subCategory = subCategory;
        this.particles = particles;
        this.firstPersonParticles = firstPersonParticles;
        this.trails = trails;
        this.light = light;
        this.durability = durability;
        this.soundEventIndex = soundEventIndex;
        this.itemSoundSetIndex = itemSoundSetIndex;
        this.interactions = interactions;
        this.carryInteractions = carryInteractions;
        this.carryHudInputBindings = carryHudInputBindings;
        this.interactionVars = interactionVars;
        this.interactionConfig = interactionConfig;
        this.droppedItemAnimation = droppedItemAnimation;
        this.tagIndexes = tagIndexes;
        this.itemAppearanceConditions = itemAppearanceConditions;
        this.displayEntityStatsHUD = displayEntityStatsHUD;
        this.pullbackConfig = pullbackConfig;
        this.clipsGeometry = clipsGeometry;
        this.renderDeployablePreview = renderDeployablePreview;
        this.hudUI = hudUI;
    }

    public ItemBase(@Nonnull ItemBase other) {
        this.id = other.id;
        this.model = other.model;
        this.scale = other.scale;
        this.texture = other.texture;
        this.animation = other.animation;
        this.playerAnimationsId = other.playerAnimationsId;
        this.usePlayerAnimations = other.usePlayerAnimations;
        this.maxStack = other.maxStack;
        this.reticleIndex = other.reticleIndex;
        this.icon = other.icon;
        this.iconProperties = other.iconProperties;
        this.translationProperties = other.translationProperties;
        this.itemLevel = other.itemLevel;
        this.qualityIndex = other.qualityIndex;
        this.resourceTypes = other.resourceTypes;
        this.consumable = other.consumable;
        this.variant = other.variant;
        this.blockId = other.blockId;
        this.tool = other.tool;
        this.weapon = other.weapon;
        this.armor = other.armor;
        this.gliderConfig = other.gliderConfig;
        this.utility = other.utility;
        this.blockSelectorTool = other.blockSelectorTool;
        this.builderToolData = other.builderToolData;
        this.itemEntity = other.itemEntity;
        this.set = other.set;
        this.categories = other.categories;
        this.subCategory = other.subCategory;
        this.particles = other.particles;
        this.firstPersonParticles = other.firstPersonParticles;
        this.trails = other.trails;
        this.light = other.light;
        this.durability = other.durability;
        this.soundEventIndex = other.soundEventIndex;
        this.itemSoundSetIndex = other.itemSoundSetIndex;
        this.interactions = other.interactions;
        this.carryInteractions = other.carryInteractions;
        this.carryHudInputBindings = other.carryHudInputBindings;
        this.interactionVars = other.interactionVars;
        this.interactionConfig = other.interactionConfig;
        this.droppedItemAnimation = other.droppedItemAnimation;
        this.tagIndexes = other.tagIndexes;
        this.itemAppearanceConditions = other.itemAppearanceConditions;
        this.displayEntityStatsHUD = other.displayEntityStatsHUD;
        this.pullbackConfig = other.pullbackConfig;
        this.clipsGeometry = other.clipsGeometry;
        this.renderDeployablePreview = other.renderDeployablePreview;
        this.hudUI = other.hudUI;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemBase", offset, (int) mem.byteSize());
        long needed = (long) offset + 266;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemBase", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 146, 266, "Id"), 4096000): null;
    }
    
    @Nullable
    public static String getModel(MemorySegment mem) {
        return getModel(mem, 0);
    }
    
    @Nullable
    public static String getModel(MemorySegment mem, int offset) {
        return hasModel(mem, offset) ? PacketIO.readVarString("Model", mem, offset + getValidatedOffset(mem, offset, 150, 266, "Model"), 4096000): null;
    }
    
    public static float getScale(MemorySegment mem) {
        return getScale(mem, 0);
    }
    
    public static float getScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "Scale");
    }
    
    @Nullable
    public static String getTexture(MemorySegment mem) {
        return getTexture(mem, 0);
    }
    
    @Nullable
    public static String getTexture(MemorySegment mem, int offset) {
        return hasTexture(mem, offset) ? PacketIO.readVarString("Texture", mem, offset + getValidatedOffset(mem, offset, 154, 266, "Texture"), 4096000): null;
    }
    
    @Nullable
    public static String getAnimation(MemorySegment mem) {
        return getAnimation(mem, 0);
    }
    
    @Nullable
    public static String getAnimation(MemorySegment mem, int offset) {
        return hasAnimation(mem, offset) ? PacketIO.readVarString("Animation", mem, offset + getValidatedOffset(mem, offset, 158, 266, "Animation"), 4096000): null;
    }
    
    @Nullable
    public static String getPlayerAnimationsId(MemorySegment mem) {
        return getPlayerAnimationsId(mem, 0);
    }
    
    @Nullable
    public static String getPlayerAnimationsId(MemorySegment mem, int offset) {
        return hasPlayerAnimationsId(mem, offset) ? PacketIO.readVarString("PlayerAnimationsId", mem, offset + getValidatedOffset(mem, offset, 162, 266, "PlayerAnimationsId"), 4096000): null;
    }
    
    public static boolean getUsePlayerAnimations(MemorySegment mem) {
        return getUsePlayerAnimations(mem, 0);
    }
    
    public static boolean getUsePlayerAnimations(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 9);
    }
    
    public static int getMaxStack(MemorySegment mem) {
        return getMaxStack(mem, 0);
    }
    
    public static int getMaxStack(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 10);
    }
    
    public static int getReticleIndex(MemorySegment mem) {
        return getReticleIndex(mem, 0);
    }
    
    public static int getReticleIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 14);
    }
    
    @Nullable
    public static String getIcon(MemorySegment mem) {
        return getIcon(mem, 0);
    }
    
    @Nullable
    public static String getIcon(MemorySegment mem, int offset) {
        return hasIcon(mem, offset) ? PacketIO.readVarString("Icon", mem, offset + getValidatedOffset(mem, offset, 166, 266, "Icon"), 4096000): null;
    }
    
    @Nullable
    public static AssetIconProperties getIconProperties(MemorySegment mem) {
        return getIconProperties(mem, 0);
    }
    
    @Nullable
    public static AssetIconProperties getIconProperties(MemorySegment mem, int offset) {
        return hasIconProperties(mem, offset) ? AssetIconProperties.toObject(mem, offset + 18): null;
    }
    
    @Nullable
    public static ItemTranslationProperties getTranslationProperties(MemorySegment mem) {
        return getTranslationProperties(mem, 0);
    }
    
    @Nullable
    public static ItemTranslationProperties getTranslationProperties(MemorySegment mem, int offset) {
        return hasTranslationProperties(mem, offset) ? ItemTranslationProperties.toObject(mem, offset + getValidatedOffset(mem, offset, 170, 266, "TranslationProperties")): null;
    }
    
    public static int getItemLevel(MemorySegment mem) {
        return getItemLevel(mem, 0);
    }
    
    public static int getItemLevel(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 43);
    }
    
    public static int getQualityIndex(MemorySegment mem) {
        return getQualityIndex(mem, 0);
    }
    
    public static int getQualityIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 47);
    }
    
    @Nullable
    public static ItemResourceType[] getResourceTypes(MemorySegment mem) {
        return getResourceTypes(mem, 0);
    }
    
    @Nullable
    public static ItemResourceType[] getResourceTypes(MemorySegment mem, int offset) {
        if (!hasResourceTypes(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 174, 266, "ResourceTypes");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ResourceTypes");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("ResourceTypes", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ResourceTypes", (int) java.lang.Math.min(off + lenOffset + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ItemResourceType[len];
        for (var i = 0; i < len; i++) {
            data[i] = ItemResourceType.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean getConsumable(MemorySegment mem) {
        return getConsumable(mem, 0);
    }
    
    public static boolean getConsumable(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 51) & 0x01) != 0;
    }
    
    public static boolean getVariant(MemorySegment mem) {
        return getVariant(mem, 0);
    }
    
    public static boolean getVariant(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 51) & 0x02) != 0;
    }
    
    public static int getBlockId(MemorySegment mem) {
        return getBlockId(mem, 0);
    }
    
    public static int getBlockId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 52);
    }
    
    @Nullable
    public static ItemTool getTool(MemorySegment mem) {
        return getTool(mem, 0);
    }
    
    @Nullable
    public static ItemTool getTool(MemorySegment mem, int offset) {
        return hasTool(mem, offset) ? ItemTool.toObject(mem, offset + getValidatedOffset(mem, offset, 178, 266, "Tool")): null;
    }
    
    @Nullable
    public static ItemWeapon getWeapon(MemorySegment mem) {
        return getWeapon(mem, 0);
    }
    
    @Nullable
    public static ItemWeapon getWeapon(MemorySegment mem, int offset) {
        return hasWeapon(mem, offset) ? ItemWeapon.toObject(mem, offset + getValidatedOffset(mem, offset, 182, 266, "Weapon")): null;
    }
    
    @Nullable
    public static ItemArmor getArmor(MemorySegment mem) {
        return getArmor(mem, 0);
    }
    
    @Nullable
    public static ItemArmor getArmor(MemorySegment mem, int offset) {
        return hasArmor(mem, offset) ? ItemArmor.toObject(mem, offset + getValidatedOffset(mem, offset, 186, 266, "Armor")): null;
    }
    
    @Nullable
    public static ItemGlider getGliderConfig(MemorySegment mem) {
        return getGliderConfig(mem, 0);
    }
    
    @Nullable
    public static ItemGlider getGliderConfig(MemorySegment mem, int offset) {
        return hasGliderConfig(mem, offset) ? ItemGlider.toObject(mem, offset + 56): null;
    }
    
    @Nullable
    public static ItemUtility getUtility(MemorySegment mem) {
        return getUtility(mem, 0);
    }
    
    @Nullable
    public static ItemUtility getUtility(MemorySegment mem, int offset) {
        return hasUtility(mem, offset) ? ItemUtility.toObject(mem, offset + getValidatedOffset(mem, offset, 190, 266, "Utility")): null;
    }
    
    @Nullable
    public static BlockSelectorToolData getBlockSelectorTool(MemorySegment mem) {
        return getBlockSelectorTool(mem, 0);
    }
    
    @Nullable
    public static BlockSelectorToolData getBlockSelectorTool(MemorySegment mem, int offset) {
        return hasBlockSelectorTool(mem, offset) ? BlockSelectorToolData.toObject(mem, offset + 72): null;
    }
    
    @Nullable
    public static BuilderToolState getBuilderToolData(MemorySegment mem) {
        return getBuilderToolData(mem, 0);
    }
    
    @Nullable
    public static BuilderToolState getBuilderToolData(MemorySegment mem, int offset) {
        return hasBuilderToolData(mem, offset) ? BuilderToolState.toObject(mem, offset + getValidatedOffset(mem, offset, 194, 266, "BuilderToolData")): null;
    }
    
    @Nullable
    public static ItemEntityConfig getItemEntity(MemorySegment mem) {
        return getItemEntity(mem, 0);
    }
    
    @Nullable
    public static ItemEntityConfig getItemEntity(MemorySegment mem, int offset) {
        return hasItemEntity(mem, offset) ? ItemEntityConfig.toObject(mem, offset + getValidatedOffset(mem, offset, 198, 266, "ItemEntity")): null;
    }
    
    @Nullable
    public static String getSet(MemorySegment mem) {
        return getSet(mem, 0);
    }
    
    @Nullable
    public static String getSet(MemorySegment mem, int offset) {
        return hasSet(mem, offset) ? PacketIO.readVarString("Set", mem, offset + getValidatedOffset(mem, offset, 202, 266, "Set"), 4096000): null;
    }
    
    @Nullable
    public static String[] getCategories(MemorySegment mem) {
        return getCategories(mem, 0);
    }
    
    @Nullable
    public static String[] getCategories(MemorySegment mem, int offset) {
        if (!hasCategories(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 206, 266, "Categories");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Categories");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Categories", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Categories", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("Categories", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    @Nullable
    public static String getSubCategory(MemorySegment mem) {
        return getSubCategory(mem, 0);
    }
    
    @Nullable
    public static String getSubCategory(MemorySegment mem, int offset) {
        return hasSubCategory(mem, offset) ? PacketIO.readVarString("SubCategory", mem, offset + getValidatedOffset(mem, offset, 210, 266, "SubCategory"), 4096000): null;
    }
    
    @Nullable
    public static ModelParticle[] getParticles(MemorySegment mem) {
        return getParticles(mem, 0);
    }
    
    @Nullable
    public static ModelParticle[] getParticles(MemorySegment mem, int offset) {
        if (!hasParticles(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 214, 266, "Particles");
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
    public static ModelParticle[] getFirstPersonParticles(MemorySegment mem) {
        return getFirstPersonParticles(mem, 0);
    }
    
    @Nullable
    public static ModelParticle[] getFirstPersonParticles(MemorySegment mem, int offset) {
        if (!hasFirstPersonParticles(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 218, 266, "FirstPersonParticles");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("FirstPersonParticles");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("FirstPersonParticles", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FirstPersonParticles", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ModelParticle[len];
        for (var i = 0; i < len; i++) {
            data[i] = ModelParticle.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static ModelTrail[] getTrails(MemorySegment mem) {
        return getTrails(mem, 0);
    }
    
    @Nullable
    public static ModelTrail[] getTrails(MemorySegment mem, int offset) {
        if (!hasTrails(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 222, 266, "Trails");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Trails");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Trails", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 35 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Trails", (int) java.lang.Math.min(off + lenOffset + (long) len * 35, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ModelTrail[len];
        for (var i = 0; i < len; i++) {
            data[i] = ModelTrail.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static ColorLight getLight(MemorySegment mem) {
        return getLight(mem, 0);
    }
    
    @Nullable
    public static ColorLight getLight(MemorySegment mem, int offset) {
        return hasLight(mem, offset) ? ColorLight.toObject(mem, offset + 76): null;
    }
    
    public static double getDurability(MemorySegment mem) {
        return getDurability(mem, 0);
    }
    
    public static double getDurability(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 80), "Durability");
    }
    
    public static int getSoundEventIndex(MemorySegment mem) {
        return getSoundEventIndex(mem, 0);
    }
    
    public static int getSoundEventIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 88);
    }
    
    public static int getItemSoundSetIndex(MemorySegment mem) {
        return getItemSoundSetIndex(mem, 0);
    }
    
    public static int getItemSoundSetIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 92);
    }
    
    @Nullable
    public static java.util.Map<InteractionType, Integer> getInteractions(MemorySegment mem) {
        return getInteractions(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<InteractionType, Integer> getInteractions(MemorySegment mem, int offset) {
        if (!hasInteractions(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 226, 266, "Interactions");
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
    public static java.util.Map<InteractionType, Integer> getCarryInteractions(MemorySegment mem) {
        return getCarryInteractions(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<InteractionType, Integer> getCarryInteractions(MemorySegment mem, int offset) {
        if (!hasCarryInteractions(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 230, 266, "CarryInteractions");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("CarryInteractions");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("CarryInteractions", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("CarryInteractions", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<InteractionType, Integer> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                off += 1;
            var value = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("CarryInteractions", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<InteractionType, String> getCarryHudInputBindings(MemorySegment mem) {
        return getCarryHudInputBindings(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<InteractionType, String> getCarryHudInputBindings(MemorySegment mem, int offset) {
        if (!hasCarryHudInputBindings(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 234, 266, "CarryHudInputBindings");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("CarryHudInputBindings");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("CarryHudInputBindings", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("CarryHudInputBindings", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<InteractionType, String> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                off += 1;
            var valuePacked = VarInt.getWithLength(mem, off);
                var value = PacketIO.readVarString("value", mem, off, 0, 4096000, valuePacked);
                off += (int) valuePacked + (int) (valuePacked >>> 32);
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("CarryHudInputBindings", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<String, Integer> getInteractionVars(MemorySegment mem) {
        return getInteractionVars(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, Integer> getInteractionVars(MemorySegment mem, int offset) {
        if (!hasInteractionVars(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 238, 266, "InteractionVars");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("InteractionVars");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("InteractionVars", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("InteractionVars", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, Integer> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("InteractionVars", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static InteractionConfiguration getInteractionConfig(MemorySegment mem) {
        return getInteractionConfig(mem, 0);
    }
    
    @Nullable
    public static InteractionConfiguration getInteractionConfig(MemorySegment mem, int offset) {
        return hasInteractionConfig(mem, offset) ? InteractionConfiguration.toObject(mem, offset + getValidatedOffset(mem, offset, 242, 266, "InteractionConfig")): null;
    }
    
    @Nullable
    public static String getDroppedItemAnimation(MemorySegment mem) {
        return getDroppedItemAnimation(mem, 0);
    }
    
    @Nullable
    public static String getDroppedItemAnimation(MemorySegment mem, int offset) {
        return hasDroppedItemAnimation(mem, offset) ? PacketIO.readVarString("DroppedItemAnimation", mem, offset + getValidatedOffset(mem, offset, 246, 266, "DroppedItemAnimation"), 4096000): null;
    }
    
    @Nullable
    public static int[] getTagIndexes(MemorySegment mem) {
        return getTagIndexes(mem, 0);
    }
    
    @Nullable
    public static int[] getTagIndexes(MemorySegment mem, int offset) {
        if (!hasTagIndexes(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 250, 266, "TagIndexes");
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
    public static java.util.Map<Integer, ItemAppearanceCondition[]> getItemAppearanceConditions(MemorySegment mem) {
        return getItemAppearanceConditions(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Integer, ItemAppearanceCondition[]> getItemAppearanceConditions(MemorySegment mem, int offset) {
        if (!hasItemAppearanceConditions(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 254, 266, "ItemAppearanceConditions");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ItemAppearanceConditions");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ItemAppearanceConditions", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemAppearanceConditions", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Integer, ItemAppearanceCondition[]> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            var valuePacked = VarInt.getWithLength(mem, off);
                if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                var valueLen = (int) valuePacked;
                var valueVarLen = (int) (valuePacked >>> 32);
                if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                if (off + valueVarLen + (long) valueLen * 38 > mem.byteSize())
                    throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 38, (int) mem.byteSize());
                off += valueVarLen;
                var value = new ItemAppearanceCondition[valueLen];
                for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                    value[valueIdx] = ItemAppearanceCondition.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                }
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("ItemAppearanceConditions", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static int[] getDisplayEntityStatsHUD(MemorySegment mem) {
        return getDisplayEntityStatsHUD(mem, 0);
    }
    
    @Nullable
    public static int[] getDisplayEntityStatsHUD(MemorySegment mem, int offset) {
        if (!hasDisplayEntityStatsHUD(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 258, 266, "DisplayEntityStatsHUD");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("DisplayEntityStatsHUD");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("DisplayEntityStatsHUD", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("DisplayEntityStatsHUD", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    @Nullable
    public static ItemPullbackConfiguration getPullbackConfig(MemorySegment mem) {
        return getPullbackConfig(mem, 0);
    }
    
    @Nullable
    public static ItemPullbackConfiguration getPullbackConfig(MemorySegment mem, int offset) {
        return hasPullbackConfig(mem, offset) ? ItemPullbackConfiguration.toObject(mem, offset + 96): null;
    }
    
    public static boolean getClipsGeometry(MemorySegment mem) {
        return getClipsGeometry(mem, 0);
    }
    
    public static boolean getClipsGeometry(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 145) & 0x01) != 0;
    }
    
    public static boolean getRenderDeployablePreview(MemorySegment mem) {
        return getRenderDeployablePreview(mem, 0);
    }
    
    public static boolean getRenderDeployablePreview(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 145) & 0x02) != 0;
    }
    
    @Nullable
    public static ItemHudUI[] getHudUI(MemorySegment mem) {
        return getHudUI(mem, 0);
    }
    
    @Nullable
    public static ItemHudUI[] getHudUI(MemorySegment mem, int offset) {
        if (!hasHudUI(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 262, 266, "HudUI");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("HudUI");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("HudUI", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("HudUI", (int) java.lang.Math.min(off + lenOffset + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ItemHudUI[len];
        for (var i = 0; i < len; i++) {
            data[i] = ItemHudUI.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasIconProperties(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasGliderConfig(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasBlockSelectorTool(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasLight(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasPullbackConfig(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasModel(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasTexture(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasAnimation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasPlayerAnimationsId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasIcon(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasTranslationProperties(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasResourceTypes(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasTool(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasWeapon(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasArmor(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasUtility(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasBuilderToolData(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasItemEntity(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasSet(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasCategories(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasSubCategory(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasParticles(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasFirstPersonParticles(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasTrails(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 3);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasInteractions(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 3);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasCarryInteractions(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 3);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasCarryHudInputBindings(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 3);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasInteractionVars(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 3);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasInteractionConfig(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 3);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasDroppedItemAnimation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 3);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasTagIndexes(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 3);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasItemAppearanceConditions(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 4);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasDisplayEntityStatsHUD(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 4);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasHudUI(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 4);
        return (b & 0x04) != 0;
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
    
    public static ItemBase toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemBase toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemBase and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemBase toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 266;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 146, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 146, -1, "Id");
        }
        
        String v1 = null;
        if (hasModel(mem, offset)) {
            requireSlot(mem, offset + 150, varPos, "Model");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Model", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 150, -1, "Model");
        }
        
        String v3 = null;
        if (hasTexture(mem, offset)) {
            requireSlot(mem, offset + 154, varPos, "Texture");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readVarString("Texture", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 154, -1, "Texture");
        }
        
        String v4 = null;
        if (hasAnimation(mem, offset)) {
            requireSlot(mem, offset + 158, varPos, "Animation");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v4 = PacketIO.readVarString("Animation", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 158, -1, "Animation");
        }
        
        String v5 = null;
        if (hasPlayerAnimationsId(mem, offset)) {
            requireSlot(mem, offset + 162, varPos, "PlayerAnimationsId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v5 = PacketIO.readVarString("PlayerAnimationsId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 162, -1, "PlayerAnimationsId");
        }
        
        String v9 = null;
        if (hasIcon(mem, offset)) {
            requireSlot(mem, offset + 166, varPos, "Icon");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v9 = PacketIO.readVarString("Icon", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 166, -1, "Icon");
        }
        
        ItemTranslationProperties v11 = null;
        if (hasTranslationProperties(mem, offset)) {
            requireSlot(mem, offset + 170, varPos, "TranslationProperties");
            v11 = ItemTranslationProperties.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 170, -1, "TranslationProperties");
        }
        
        ItemResourceType[] v14 = null;
        if (hasResourceTypes(mem, offset)) {
            requireSlot(mem, offset + 174, varPos, "ResourceTypes");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ResourceTypes");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("ResourceTypes", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ResourceTypes", (int) java.lang.Math.min(off + lenOffset + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v14 = new ItemResourceType[len];
            for (var i = 0; i < len; i++) {
                v14[i] = ItemResourceType.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 174, -1, "ResourceTypes");
        }
        
        ItemTool v18 = null;
        if (hasTool(mem, offset)) {
            requireSlot(mem, offset + 178, varPos, "Tool");
            v18 = ItemTool.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 178, -1, "Tool");
        }
        
        ItemWeapon v19 = null;
        if (hasWeapon(mem, offset)) {
            requireSlot(mem, offset + 182, varPos, "Weapon");
            v19 = ItemWeapon.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 182, -1, "Weapon");
        }
        
        ItemArmor v20 = null;
        if (hasArmor(mem, offset)) {
            requireSlot(mem, offset + 186, varPos, "Armor");
            v20 = ItemArmor.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 186, -1, "Armor");
        }
        
        ItemUtility v22 = null;
        if (hasUtility(mem, offset)) {
            requireSlot(mem, offset + 190, varPos, "Utility");
            v22 = ItemUtility.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 190, -1, "Utility");
        }
        
        BuilderToolState v24 = null;
        if (hasBuilderToolData(mem, offset)) {
            requireSlot(mem, offset + 194, varPos, "BuilderToolData");
            v24 = BuilderToolState.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 194, -1, "BuilderToolData");
        }
        
        ItemEntityConfig v25 = null;
        if (hasItemEntity(mem, offset)) {
            requireSlot(mem, offset + 198, varPos, "ItemEntity");
            v25 = ItemEntityConfig.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 198, -1, "ItemEntity");
        }
        
        String v26 = null;
        if (hasSet(mem, offset)) {
            requireSlot(mem, offset + 202, varPos, "Set");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v26 = PacketIO.readVarString("Set", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 202, -1, "Set");
        }
        
        String[] v27 = null;
        if (hasCategories(mem, offset)) {
            requireSlot(mem, offset + 206, varPos, "Categories");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Categories");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Categories", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Categories", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v27 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v27[i] = PacketIO.readVarString("Categories", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 206, -1, "Categories");
        }
        
        String v28 = null;
        if (hasSubCategory(mem, offset)) {
            requireSlot(mem, offset + 210, varPos, "SubCategory");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v28 = PacketIO.readVarString("SubCategory", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 210, -1, "SubCategory");
        }
        
        ModelParticle[] v29 = null;
        if (hasParticles(mem, offset)) {
            requireSlot(mem, offset + 214, varPos, "Particles");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Particles");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Particles", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Particles", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v29 = new ModelParticle[len];
            for (var i = 0; i < len; i++) {
                v29[i] = ModelParticle.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 214, -1, "Particles");
        }
        
        ModelParticle[] v30 = null;
        if (hasFirstPersonParticles(mem, offset)) {
            requireSlot(mem, offset + 218, varPos, "FirstPersonParticles");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("FirstPersonParticles");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("FirstPersonParticles", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FirstPersonParticles", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v30 = new ModelParticle[len];
            for (var i = 0; i < len; i++) {
                v30[i] = ModelParticle.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 218, -1, "FirstPersonParticles");
        }
        
        ModelTrail[] v31 = null;
        if (hasTrails(mem, offset)) {
            requireSlot(mem, offset + 222, varPos, "Trails");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Trails");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Trails", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 35 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Trails", (int) java.lang.Math.min(off + lenOffset + (long) len * 35, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v31 = new ModelTrail[len];
            for (var i = 0; i < len; i++) {
                v31[i] = ModelTrail.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 222, -1, "Trails");
        }
        
        java.util.Map<InteractionType, Integer> v36 = null;
        if (hasInteractions(mem, offset)) {
            requireSlot(mem, offset + 226, varPos, "Interactions");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Interactions");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Interactions", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Interactions", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v36 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                    off += 1;
                var value = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                if (v36.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Interactions", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 226, -1, "Interactions");
        }
        
        java.util.Map<InteractionType, Integer> v37 = null;
        if (hasCarryInteractions(mem, offset)) {
            requireSlot(mem, offset + 230, varPos, "CarryInteractions");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("CarryInteractions");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("CarryInteractions", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("CarryInteractions", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v37 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                    off += 1;
                var value = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                if (v37.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("CarryInteractions", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 230, -1, "CarryInteractions");
        }
        
        java.util.Map<InteractionType, String> v38 = null;
        if (hasCarryHudInputBindings(mem, offset)) {
            requireSlot(mem, offset + 234, varPos, "CarryHudInputBindings");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("CarryHudInputBindings");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("CarryHudInputBindings", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("CarryHudInputBindings", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            v38 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                    off += 1;
                var valuePacked = VarInt.getWithLength(mem, off);
                    var value = PacketIO.readVarString("value", mem, off, 0, 4096000, valuePacked);
                    off += (int) valuePacked + (int) (valuePacked >>> 32);
                if (v38.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("CarryHudInputBindings", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 234, -1, "CarryHudInputBindings");
        }
        
        java.util.Map<String, Integer> v39 = null;
        if (hasInteractionVars(mem, offset)) {
            requireSlot(mem, offset + 238, varPos, "InteractionVars");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("InteractionVars");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("InteractionVars", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("InteractionVars", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v39 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                if (v39.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("InteractionVars", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 238, -1, "InteractionVars");
        }
        
        InteractionConfiguration v40 = null;
        if (hasInteractionConfig(mem, offset)) {
            requireSlot(mem, offset + 242, varPos, "InteractionConfig");
            v40 = InteractionConfiguration.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 242, -1, "InteractionConfig");
        }
        
        String v41 = null;
        if (hasDroppedItemAnimation(mem, offset)) {
            requireSlot(mem, offset + 246, varPos, "DroppedItemAnimation");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v41 = PacketIO.readVarString("DroppedItemAnimation", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 246, -1, "DroppedItemAnimation");
        }
        
        int[] v42 = null;
        if (hasTagIndexes(mem, offset)) {
            requireSlot(mem, offset + 250, varPos, "TagIndexes");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("TagIndexes");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("TagIndexes", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("TagIndexes", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v42 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v42, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 250, -1, "TagIndexes");
        }
        
        java.util.Map<Integer, ItemAppearanceCondition[]> v43 = null;
        if (hasItemAppearanceConditions(mem, offset)) {
            requireSlot(mem, offset + 254, varPos, "ItemAppearanceConditions");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ItemAppearanceConditions");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ItemAppearanceConditions", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemAppearanceConditions", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v43 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                var valuePacked = VarInt.getWithLength(mem, off);
                    if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                    var valueLen = (int) valuePacked;
                    var valueVarLen = (int) (valuePacked >>> 32);
                    if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                    if (off + valueVarLen + (long) valueLen * 38 > mem.byteSize())
                        throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 38, (int) mem.byteSize());
                    off += valueVarLen;
                    var value = new ItemAppearanceCondition[valueLen];
                    for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                        value[valueIdx] = ItemAppearanceCondition.toObject(mem, off, walkCursor);
                        off = walkCursor.position;
                    }
                if (v43.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("ItemAppearanceConditions", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 254, -1, "ItemAppearanceConditions");
        }
        
        int[] v44 = null;
        if (hasDisplayEntityStatsHUD(mem, offset)) {
            requireSlot(mem, offset + 258, varPos, "DisplayEntityStatsHUD");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("DisplayEntityStatsHUD");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("DisplayEntityStatsHUD", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("DisplayEntityStatsHUD", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v44 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v44, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 258, -1, "DisplayEntityStatsHUD");
        }
        
        ItemHudUI[] v48 = null;
        if (hasHudUI(mem, offset)) {
            requireSlot(mem, offset + 262, varPos, "HudUI");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("HudUI");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("HudUI", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("HudUI", (int) java.lang.Math.min(off + lenOffset + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v48 = new ItemHudUI[len];
            for (var i = 0; i < len; i++) {
                v48[i] = ItemHudUI.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 262, -1, "HudUI");
        }
        var result = new ItemBase(
            v0,
            v1,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "Scale"),
            v3,
            v4,
            v5,
            mem.get(PacketIO.PROTO_BOOL, offset + 9),
            mem.get(PacketIO.PROTO_INT, offset + 10),
            mem.get(PacketIO.PROTO_INT, offset + 14),
            v9,
            hasIconProperties(mem, offset) ? AssetIconProperties.toObject(mem, offset + 18) : null,
            v11,
            mem.get(PacketIO.PROTO_INT, offset + 43),
            mem.get(PacketIO.PROTO_INT, offset + 47),
            v14,
            (mem.get(PacketIO.PROTO_BYTE, offset + 51) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 51) & 0x02) != 0,
            mem.get(PacketIO.PROTO_INT, offset + 52),
            v18,
            v19,
            v20,
            hasGliderConfig(mem, offset) ? ItemGlider.toObject(mem, offset + 56) : null,
            v22,
            hasBlockSelectorTool(mem, offset) ? BlockSelectorToolData.toObject(mem, offset + 72) : null,
            v24,
            v25,
            v26,
            v27,
            v28,
            v29,
            v30,
            v31,
            hasLight(mem, offset) ? ColorLight.toObject(mem, offset + 76) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 80), "Durability"),
            mem.get(PacketIO.PROTO_INT, offset + 88),
            mem.get(PacketIO.PROTO_INT, offset + 92),
            v36,
            v37,
            v38,
            v39,
            v40,
            v41,
            v42,
            v43,
            v44,
            hasPullbackConfig(mem, offset) ? ItemPullbackConfiguration.toObject(mem, offset + 96) : null,
            (mem.get(PacketIO.PROTO_BYTE, offset + 145) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 145) & 0x02) != 0,
            v48
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.iconProperties != null) nullBits |= 0x01;
        if (this.gliderConfig != null) nullBits |= 0x02;
        if (this.blockSelectorTool != null) nullBits |= 0x04;
        if (this.light != null) nullBits |= 0x08;
        if (this.pullbackConfig != null) nullBits |= 0x10;
        if (this.id != null) nullBits |= 0x20;
        if (this.model != null) nullBits |= 0x40;
        if (this.texture != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        nullBits = 0;
        if (this.animation != null) nullBits |= 0x01;
        if (this.playerAnimationsId != null) nullBits |= 0x02;
        if (this.icon != null) nullBits |= 0x04;
        if (this.translationProperties != null) nullBits |= 0x08;
        if (this.resourceTypes != null) nullBits |= 0x10;
        if (this.tool != null) nullBits |= 0x20;
        if (this.weapon != null) nullBits |= 0x40;
        if (this.armor != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 1, nullBits);
        nullBits = 0;
        if (this.utility != null) nullBits |= 0x01;
        if (this.builderToolData != null) nullBits |= 0x02;
        if (this.itemEntity != null) nullBits |= 0x04;
        if (this.set != null) nullBits |= 0x08;
        if (this.categories != null) nullBits |= 0x10;
        if (this.subCategory != null) nullBits |= 0x20;
        if (this.particles != null) nullBits |= 0x40;
        if (this.firstPersonParticles != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 2, nullBits);
        nullBits = 0;
        if (this.trails != null) nullBits |= 0x01;
        if (this.interactions != null) nullBits |= 0x02;
        if (this.carryInteractions != null) nullBits |= 0x04;
        if (this.carryHudInputBindings != null) nullBits |= 0x08;
        if (this.interactionVars != null) nullBits |= 0x10;
        if (this.interactionConfig != null) nullBits |= 0x20;
        if (this.droppedItemAnimation != null) nullBits |= 0x40;
        if (this.tagIndexes != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 3, nullBits);
        nullBits = 0;
        if (this.itemAppearanceConditions != null) nullBits |= 0x01;
        if (this.displayEntityStatsHUD != null) nullBits |= 0x02;
        if (this.hudUI != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 4, nullBits);
        
        PacketIO.requireFinite(this.scale, "Scale"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.scale);
        mem.set(PacketIO.PROTO_BOOL, offset + 9, this.usePlayerAnimations);
        mem.set(PacketIO.PROTO_INT, offset + 10, this.maxStack);
        mem.set(PacketIO.PROTO_INT, offset + 14, this.reticleIndex);
        if (this.iconProperties != null) {
            this.iconProperties.serialize(mem, offset + 18);
        } else {
            mem.asSlice(offset + 18, 25).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_INT, offset + 43, this.itemLevel);
        mem.set(PacketIO.PROTO_INT, offset + 47, this.qualityIndex);
        byte boolBits0_0 = 0;
        if (this.consumable) boolBits0_0 |= 0x01;
        if (this.variant) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 51 + 0, boolBits0_0);
        mem.set(PacketIO.PROTO_INT, offset + 52, this.blockId);
        if (this.gliderConfig != null) {
            this.gliderConfig.serialize(mem, offset + 56);
        } else {
            mem.asSlice(offset + 56, 16).fill((byte) 0); 
        }
        if (this.blockSelectorTool != null) {
            this.blockSelectorTool.serialize(mem, offset + 72);
        } else {
            mem.asSlice(offset + 72, 4).fill((byte) 0); 
        }
        if (this.light != null) {
            this.light.serialize(mem, offset + 76);
        } else {
            mem.asSlice(offset + 76, 4).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.durability, "Durability"); mem.set(PacketIO.PROTO_DOUBLE, offset + 80, this.durability);
        mem.set(PacketIO.PROTO_INT, offset + 88, this.soundEventIndex);
        mem.set(PacketIO.PROTO_INT, offset + 92, this.itemSoundSetIndex);
        if (this.pullbackConfig != null) {
            this.pullbackConfig.serialize(mem, offset + 96);
        } else {
            mem.asSlice(offset + 96, 49).fill((byte) 0); 
        }
        byte boolBits1_0 = 0;
        if (this.clipsGeometry) boolBits1_0 |= 0x01;
        if (this.renderDeployablePreview) boolBits1_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 145 + 0, boolBits1_0);
        var varOffset = offset + 266;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 146, varOffset - offset - 266);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 146, -1);
        }
        if (this.model != null) {
            mem.set(PacketIO.PROTO_INT, offset + 150, varOffset - offset - 266);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.model, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 150, -1);
        }
        if (this.texture != null) {
            mem.set(PacketIO.PROTO_INT, offset + 154, varOffset - offset - 266);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.texture, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 154, -1);
        }
        if (this.animation != null) {
            mem.set(PacketIO.PROTO_INT, offset + 158, varOffset - offset - 266);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.animation, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 158, -1);
        }
        if (this.playerAnimationsId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 162, varOffset - offset - 266);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.playerAnimationsId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 162, -1);
        }
        if (this.icon != null) {
            mem.set(PacketIO.PROTO_INT, offset + 166, varOffset - offset - 266);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.icon, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 166, -1);
        }
        if (this.translationProperties != null) {
            mem.set(PacketIO.PROTO_INT, offset + 170, varOffset - offset - 266);
            varOffset += this.translationProperties.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 170, -1);
        }
        if (this.resourceTypes != null) {
            mem.set(PacketIO.PROTO_INT, offset + 174, varOffset - offset - 266);
            if (resourceTypes.length > 4096000) throw ProtocolException.arrayTooLong("ResourceTypes", resourceTypes.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.resourceTypes.length);
            
            var resourceTypesValueOffset = 0;
            for (var i = 0; i < this.resourceTypes.length; i++) {
                resourceTypesValueOffset += this.resourceTypes[i].serialize(mem, varOffset + resourceTypesValueOffset);
            }
            varOffset += resourceTypesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 174, -1);
        }
        if (this.tool != null) {
            mem.set(PacketIO.PROTO_INT, offset + 178, varOffset - offset - 266);
            varOffset += this.tool.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 178, -1);
        }
        if (this.weapon != null) {
            mem.set(PacketIO.PROTO_INT, offset + 182, varOffset - offset - 266);
            varOffset += this.weapon.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 182, -1);
        }
        if (this.armor != null) {
            mem.set(PacketIO.PROTO_INT, offset + 186, varOffset - offset - 266);
            varOffset += this.armor.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 186, -1);
        }
        if (this.utility != null) {
            mem.set(PacketIO.PROTO_INT, offset + 190, varOffset - offset - 266);
            varOffset += this.utility.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 190, -1);
        }
        if (this.builderToolData != null) {
            mem.set(PacketIO.PROTO_INT, offset + 194, varOffset - offset - 266);
            varOffset += this.builderToolData.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 194, -1);
        }
        if (this.itemEntity != null) {
            mem.set(PacketIO.PROTO_INT, offset + 198, varOffset - offset - 266);
            varOffset += this.itemEntity.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 198, -1);
        }
        if (this.set != null) {
            mem.set(PacketIO.PROTO_INT, offset + 202, varOffset - offset - 266);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.set, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 202, -1);
        }
        if (this.categories != null) {
            mem.set(PacketIO.PROTO_INT, offset + 206, varOffset - offset - 266);
            if (categories.length > 4096000) throw ProtocolException.arrayTooLong("Categories", categories.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.categories.length);
            
            var categoriesValueOffset = 0;
            for (var i = 0; i < this.categories.length; i++) {
                categoriesValueOffset += PacketIO.writeVarString(mem, varOffset + categoriesValueOffset, this.categories[i], 4096000);
            }
            varOffset += categoriesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 206, -1);
        }
        if (this.subCategory != null) {
            mem.set(PacketIO.PROTO_INT, offset + 210, varOffset - offset - 266);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.subCategory, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 210, -1);
        }
        if (this.particles != null) {
            mem.set(PacketIO.PROTO_INT, offset + 214, varOffset - offset - 266);
            if (particles.length > 4096000) throw ProtocolException.arrayTooLong("Particles", particles.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.particles.length);
            
            var particlesValueOffset = 0;
            for (var i = 0; i < this.particles.length; i++) {
                particlesValueOffset += this.particles[i].serialize(mem, varOffset + particlesValueOffset);
            }
            varOffset += particlesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 214, -1);
        }
        if (this.firstPersonParticles != null) {
            mem.set(PacketIO.PROTO_INT, offset + 218, varOffset - offset - 266);
            if (firstPersonParticles.length > 4096000) throw ProtocolException.arrayTooLong("FirstPersonParticles", firstPersonParticles.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.firstPersonParticles.length);
            
            var firstPersonParticlesValueOffset = 0;
            for (var i = 0; i < this.firstPersonParticles.length; i++) {
                firstPersonParticlesValueOffset += this.firstPersonParticles[i].serialize(mem, varOffset + firstPersonParticlesValueOffset);
            }
            varOffset += firstPersonParticlesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 218, -1);
        }
        if (this.trails != null) {
            mem.set(PacketIO.PROTO_INT, offset + 222, varOffset - offset - 266);
            if (trails.length > 4096000) throw ProtocolException.arrayTooLong("Trails", trails.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.trails.length);
            
            var trailsValueOffset = 0;
            for (var i = 0; i < this.trails.length; i++) {
                trailsValueOffset += this.trails[i].serialize(mem, varOffset + trailsValueOffset);
            }
            varOffset += trailsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 222, -1);
        }
        if (this.interactions != null) {
            mem.set(PacketIO.PROTO_INT, offset + 226, varOffset - offset - 266);
            if (this.interactions.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Interactions", interactions.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.interactions.size());
            for (var e : this.interactions.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                mem.set(PacketIO.PROTO_INT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 226, -1);
        }
        if (this.carryInteractions != null) {
            mem.set(PacketIO.PROTO_INT, offset + 230, varOffset - offset - 266);
            if (this.carryInteractions.size() > 4096000) throw ProtocolException.dictionaryTooLarge("CarryInteractions", carryInteractions.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.carryInteractions.size());
            for (var e : this.carryInteractions.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                mem.set(PacketIO.PROTO_INT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 230, -1);
        }
        if (this.carryHudInputBindings != null) {
            mem.set(PacketIO.PROTO_INT, offset + 234, varOffset - offset - 266);
            if (this.carryHudInputBindings.size() > 4096000) throw ProtocolException.dictionaryTooLarge("CarryHudInputBindings", carryHudInputBindings.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.carryHudInputBindings.size());
            for (var e : this.carryHudInputBindings.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getValue(), 4096000);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 234, -1);
        }
        if (this.interactionVars != null) {
            mem.set(PacketIO.PROTO_INT, offset + 238, varOffset - offset - 266);
            if (this.interactionVars.size() > 4096000) throw ProtocolException.dictionaryTooLarge("InteractionVars", interactionVars.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.interactionVars.size());
            for (var e : this.interactionVars.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                mem.set(PacketIO.PROTO_INT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 238, -1);
        }
        if (this.interactionConfig != null) {
            mem.set(PacketIO.PROTO_INT, offset + 242, varOffset - offset - 266);
            varOffset += this.interactionConfig.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 242, -1);
        }
        if (this.droppedItemAnimation != null) {
            mem.set(PacketIO.PROTO_INT, offset + 246, varOffset - offset - 266);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.droppedItemAnimation, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 246, -1);
        }
        if (this.tagIndexes != null) {
            mem.set(PacketIO.PROTO_INT, offset + 250, varOffset - offset - 266);
            if (tagIndexes.length > 4096000) throw ProtocolException.arrayTooLong("TagIndexes", tagIndexes.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.tagIndexes.length);
            
            MemorySegment.copy(this.tagIndexes, 0, mem, PacketIO.PROTO_INT, varOffset, this.tagIndexes.length);
            varOffset += this.tagIndexes.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 250, -1);
        }
        if (this.itemAppearanceConditions != null) {
            mem.set(PacketIO.PROTO_INT, offset + 254, varOffset - offset - 266);
            if (this.itemAppearanceConditions.size() > 4096000) throw ProtocolException.dictionaryTooLarge("ItemAppearanceConditions", itemAppearanceConditions.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.itemAppearanceConditions.size());
            for (var e : this.itemAppearanceConditions.entrySet()) {
                mem.set(PacketIO.PROTO_INT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += VarInt.set(mem, varOffset, e.getValue().length);
                for (var arrItem : e.getValue()) {
                    varOffset += arrItem.serialize(mem, varOffset);
                }
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 254, -1);
        }
        if (this.displayEntityStatsHUD != null) {
            mem.set(PacketIO.PROTO_INT, offset + 258, varOffset - offset - 266);
            if (displayEntityStatsHUD.length > 4096000) throw ProtocolException.arrayTooLong("DisplayEntityStatsHUD", displayEntityStatsHUD.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.displayEntityStatsHUD.length);
            
            MemorySegment.copy(this.displayEntityStatsHUD, 0, mem, PacketIO.PROTO_INT, varOffset, this.displayEntityStatsHUD.length);
            varOffset += this.displayEntityStatsHUD.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 258, -1);
        }
        if (this.hudUI != null) {
            mem.set(PacketIO.PROTO_INT, offset + 262, varOffset - offset - 266);
            if (hudUI.length > 4096000) throw ProtocolException.arrayTooLong("HudUI", hudUI.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.hudUI.length);
            
            var hudUIValueOffset = 0;
            for (var i = 0; i < this.hudUI.length; i++) {
                hudUIValueOffset += this.hudUI[i].serialize(mem, varOffset + hudUIValueOffset);
            }
            varOffset += hudUIValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 262, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 266;
        if (id != null) size += PacketIO.stringSize(id);
    if (model != null) size += PacketIO.stringSize(model);
    if (texture != null) size += PacketIO.stringSize(texture);
    if (animation != null) size += PacketIO.stringSize(animation);
    if (playerAnimationsId != null) size += PacketIO.stringSize(playerAnimationsId);
    if (icon != null) size += PacketIO.stringSize(icon);
    if (translationProperties != null) size += translationProperties.computeSize();
    if (resourceTypes != null) {
        int resourceTypesSize = 0;
for (var elem : resourceTypes) resourceTypesSize += elem.computeSize();
size += VarInt.size(resourceTypes.length) + resourceTypesSize;
    }
    if (tool != null) size += tool.computeSize();
    if (weapon != null) size += weapon.computeSize();
    if (armor != null) size += armor.computeSize();
    if (utility != null) size += utility.computeSize();
    if (builderToolData != null) size += builderToolData.computeSize();
    if (itemEntity != null) size += itemEntity.computeSize();
    if (set != null) size += PacketIO.stringSize(set);
    if (categories != null) {
        int categoriesSize = 0;
for (var elem : categories) categoriesSize += PacketIO.stringSize(elem);
size += VarInt.size(categories.length) + categoriesSize;
    }
    if (subCategory != null) size += PacketIO.stringSize(subCategory);
    if (particles != null) {
        int particlesSize = 0;
for (var elem : particles) particlesSize += elem.computeSize();
size += VarInt.size(particles.length) + particlesSize;
    }
    if (firstPersonParticles != null) {
        int firstPersonParticlesSize = 0;
for (var elem : firstPersonParticles) firstPersonParticlesSize += elem.computeSize();
size += VarInt.size(firstPersonParticles.length) + firstPersonParticlesSize;
    }
    if (trails != null) {
        int trailsSize = 0;
for (var elem : trails) trailsSize += elem.computeSize();
size += VarInt.size(trails.length) + trailsSize;
    }
    if (interactions != null) size += VarInt.size(interactions.size()) + interactions.size() * (1 + 4);
    if (carryInteractions != null) size += VarInt.size(carryInteractions.size()) + carryInteractions.size() * (1 + 4);
    if (carryHudInputBindings != null) {
        int carryHudInputBindingsSize = 0;
for (var kvp : carryHudInputBindings.entrySet()) carryHudInputBindingsSize += 1 + PacketIO.stringSize(kvp.getValue());
size += VarInt.size(carryHudInputBindings.size()) + carryHudInputBindingsSize;
    }
    if (interactionVars != null) {
        int interactionVarsSize = 0;
for (var kvp : interactionVars.entrySet()) interactionVarsSize += PacketIO.stringSize(kvp.getKey()) + 4;
size += VarInt.size(interactionVars.size()) + interactionVarsSize;
    }
    if (interactionConfig != null) size += interactionConfig.computeSize();
    if (droppedItemAnimation != null) size += PacketIO.stringSize(droppedItemAnimation);
    if (tagIndexes != null) size += VarInt.size(tagIndexes.length) + tagIndexes.length * 4;
    if (itemAppearanceConditions != null) {
        int itemAppearanceConditionsSize = 0;
for (var kvp : itemAppearanceConditions.entrySet()) itemAppearanceConditionsSize += 4 + VarInt.size(kvp.getValue().length) + java.util.Arrays.stream(kvp.getValue()).mapToInt(inner -> inner.computeSize()).sum();
size += VarInt.size(itemAppearanceConditions.size()) + itemAppearanceConditionsSize;
    }
    if (displayEntityStatsHUD != null) size += VarInt.size(displayEntityStatsHUD.length) + displayEntityStatsHUD.length * 4;
    if (hudUI != null) {
        int hudUISize = 0;
for (var elem : hudUI) hudUISize += elem.computeSize();
size += VarInt.size(hudUI.length) + hudUISize;
    }

        return size;
    }

    public ItemBase clone() {
        ItemBase copy = new ItemBase();
        copy.id = this.id;
        copy.model = this.model;
        copy.scale = this.scale;
        copy.texture = this.texture;
        copy.animation = this.animation;
        copy.playerAnimationsId = this.playerAnimationsId;
        copy.usePlayerAnimations = this.usePlayerAnimations;
        copy.maxStack = this.maxStack;
        copy.reticleIndex = this.reticleIndex;
        copy.icon = this.icon;
        copy.iconProperties = this.iconProperties != null ? this.iconProperties.clone() : null;
        copy.translationProperties = this.translationProperties != null ? this.translationProperties.clone() : null;
        copy.itemLevel = this.itemLevel;
        copy.qualityIndex = this.qualityIndex;
        copy.resourceTypes = this.resourceTypes != null ? java.util.Arrays.stream(this.resourceTypes).map(e -> e.clone()).toArray(ItemResourceType[]::new) : null;
        copy.consumable = this.consumable;
        copy.variant = this.variant;
        copy.blockId = this.blockId;
        copy.tool = this.tool != null ? this.tool.clone() : null;
        copy.weapon = this.weapon != null ? this.weapon.clone() : null;
        copy.armor = this.armor != null ? this.armor.clone() : null;
        copy.gliderConfig = this.gliderConfig != null ? this.gliderConfig.clone() : null;
        copy.utility = this.utility != null ? this.utility.clone() : null;
        copy.blockSelectorTool = this.blockSelectorTool != null ? this.blockSelectorTool.clone() : null;
        copy.builderToolData = this.builderToolData != null ? this.builderToolData.clone() : null;
        copy.itemEntity = this.itemEntity != null ? this.itemEntity.clone() : null;
        copy.set = this.set;
        copy.categories = this.categories != null ? java.util.Arrays.copyOf(this.categories, this.categories.length) : null;
        copy.subCategory = this.subCategory;
        copy.particles = this.particles != null ? java.util.Arrays.stream(this.particles).map(e -> e.clone()).toArray(ModelParticle[]::new) : null;
        copy.firstPersonParticles = this.firstPersonParticles != null ? java.util.Arrays.stream(this.firstPersonParticles).map(e -> e.clone()).toArray(ModelParticle[]::new) : null;
        copy.trails = this.trails != null ? java.util.Arrays.stream(this.trails).map(e -> e.clone()).toArray(ModelTrail[]::new) : null;
        copy.light = this.light != null ? this.light.clone() : null;
        copy.durability = this.durability;
        copy.soundEventIndex = this.soundEventIndex;
        copy.itemSoundSetIndex = this.itemSoundSetIndex;
        copy.interactions = this.interactions != null ? new java.util.HashMap<>(this.interactions) : null;
        copy.carryInteractions = this.carryInteractions != null ? new java.util.HashMap<>(this.carryInteractions) : null;
        copy.carryHudInputBindings = this.carryHudInputBindings != null ? new java.util.HashMap<>(this.carryHudInputBindings) : null;
        copy.interactionVars = this.interactionVars != null ? new java.util.HashMap<>(this.interactionVars) : null;
        copy.interactionConfig = this.interactionConfig != null ? this.interactionConfig.clone() : null;
        copy.droppedItemAnimation = this.droppedItemAnimation;
        copy.tagIndexes = this.tagIndexes != null ? java.util.Arrays.copyOf(this.tagIndexes, this.tagIndexes.length) : null;
        if (this.itemAppearanceConditions != null) {
            java.util.Map<Integer, ItemAppearanceCondition[]> m = new java.util.HashMap<>();
            for (var e : this.itemAppearanceConditions.entrySet()) { m.put(e.getKey(), java.util.Arrays.stream(e.getValue()).map(x -> x.clone()).toArray(ItemAppearanceCondition[]::new)); }
            copy.itemAppearanceConditions = m;
        }
        copy.displayEntityStatsHUD = this.displayEntityStatsHUD != null ? java.util.Arrays.copyOf(this.displayEntityStatsHUD, this.displayEntityStatsHUD.length) : null;
        copy.pullbackConfig = this.pullbackConfig != null ? this.pullbackConfig.clone() : null;
        copy.clipsGeometry = this.clipsGeometry;
        copy.renderDeployablePreview = this.renderDeployablePreview;
        copy.hudUI = this.hudUI != null ? java.util.Arrays.stream(this.hudUI).map(e -> e.clone()).toArray(ItemHudUI[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemBase other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.model, other.model) && this.scale == other.scale && java.util.Objects.equals(this.texture, other.texture) && java.util.Objects.equals(this.animation, other.animation) && java.util.Objects.equals(this.playerAnimationsId, other.playerAnimationsId) && this.usePlayerAnimations == other.usePlayerAnimations && this.maxStack == other.maxStack && this.reticleIndex == other.reticleIndex && java.util.Objects.equals(this.icon, other.icon) && java.util.Objects.equals(this.iconProperties, other.iconProperties) && java.util.Objects.equals(this.translationProperties, other.translationProperties) && this.itemLevel == other.itemLevel && this.qualityIndex == other.qualityIndex && java.util.Arrays.equals(this.resourceTypes, other.resourceTypes) && this.consumable == other.consumable && this.variant == other.variant && this.blockId == other.blockId && java.util.Objects.equals(this.tool, other.tool) && java.util.Objects.equals(this.weapon, other.weapon) && java.util.Objects.equals(this.armor, other.armor) && java.util.Objects.equals(this.gliderConfig, other.gliderConfig) && java.util.Objects.equals(this.utility, other.utility) && java.util.Objects.equals(this.blockSelectorTool, other.blockSelectorTool) && java.util.Objects.equals(this.builderToolData, other.builderToolData) && java.util.Objects.equals(this.itemEntity, other.itemEntity) && java.util.Objects.equals(this.set, other.set) && java.util.Arrays.equals(this.categories, other.categories) && java.util.Objects.equals(this.subCategory, other.subCategory) && java.util.Arrays.equals(this.particles, other.particles) && java.util.Arrays.equals(this.firstPersonParticles, other.firstPersonParticles) && java.util.Arrays.equals(this.trails, other.trails) && java.util.Objects.equals(this.light, other.light) && this.durability == other.durability && this.soundEventIndex == other.soundEventIndex && this.itemSoundSetIndex == other.itemSoundSetIndex && java.util.Objects.equals(this.interactions, other.interactions) && java.util.Objects.equals(this.carryInteractions, other.carryInteractions) && java.util.Objects.equals(this.carryHudInputBindings, other.carryHudInputBindings) && java.util.Objects.equals(this.interactionVars, other.interactionVars) && java.util.Objects.equals(this.interactionConfig, other.interactionConfig) && java.util.Objects.equals(this.droppedItemAnimation, other.droppedItemAnimation) && java.util.Arrays.equals(this.tagIndexes, other.tagIndexes) && java.util.Objects.equals(this.itemAppearanceConditions, other.itemAppearanceConditions) && java.util.Arrays.equals(this.displayEntityStatsHUD, other.displayEntityStatsHUD) && java.util.Objects.equals(this.pullbackConfig, other.pullbackConfig) && this.clipsGeometry == other.clipsGeometry && this.renderDeployablePreview == other.renderDeployablePreview && java.util.Arrays.equals(this.hudUI, other.hudUI);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(id);
        result = 31 * result + java.util.Objects.hashCode(model);
        result = 31 * result + Float.hashCode(scale);
        result = 31 * result + java.util.Objects.hashCode(texture);
        result = 31 * result + java.util.Objects.hashCode(animation);
        result = 31 * result + java.util.Objects.hashCode(playerAnimationsId);
        result = 31 * result + Boolean.hashCode(usePlayerAnimations);
        result = 31 * result + Integer.hashCode(maxStack);
        result = 31 * result + Integer.hashCode(reticleIndex);
        result = 31 * result + java.util.Objects.hashCode(icon);
        result = 31 * result + java.util.Objects.hashCode(iconProperties);
        result = 31 * result + java.util.Objects.hashCode(translationProperties);
        result = 31 * result + Integer.hashCode(itemLevel);
        result = 31 * result + Integer.hashCode(qualityIndex);
        result = 31 * result + java.util.Arrays.hashCode(resourceTypes);
        result = 31 * result + Boolean.hashCode(consumable);
        result = 31 * result + Boolean.hashCode(variant);
        result = 31 * result + Integer.hashCode(blockId);
        result = 31 * result + java.util.Objects.hashCode(tool);
        result = 31 * result + java.util.Objects.hashCode(weapon);
        result = 31 * result + java.util.Objects.hashCode(armor);
        result = 31 * result + java.util.Objects.hashCode(gliderConfig);
        result = 31 * result + java.util.Objects.hashCode(utility);
        result = 31 * result + java.util.Objects.hashCode(blockSelectorTool);
        result = 31 * result + java.util.Objects.hashCode(builderToolData);
        result = 31 * result + java.util.Objects.hashCode(itemEntity);
        result = 31 * result + java.util.Objects.hashCode(set);
        result = 31 * result + java.util.Arrays.hashCode(categories);
        result = 31 * result + java.util.Objects.hashCode(subCategory);
        result = 31 * result + java.util.Arrays.hashCode(particles);
        result = 31 * result + java.util.Arrays.hashCode(firstPersonParticles);
        result = 31 * result + java.util.Arrays.hashCode(trails);
        result = 31 * result + java.util.Objects.hashCode(light);
        result = 31 * result + Double.hashCode(durability);
        result = 31 * result + Integer.hashCode(soundEventIndex);
        result = 31 * result + Integer.hashCode(itemSoundSetIndex);
        result = 31 * result + java.util.Objects.hashCode(interactions);
        result = 31 * result + java.util.Objects.hashCode(carryInteractions);
        result = 31 * result + java.util.Objects.hashCode(carryHudInputBindings);
        result = 31 * result + java.util.Objects.hashCode(interactionVars);
        result = 31 * result + java.util.Objects.hashCode(interactionConfig);
        result = 31 * result + java.util.Objects.hashCode(droppedItemAnimation);
        result = 31 * result + java.util.Arrays.hashCode(tagIndexes);
        result = 31 * result + java.util.Objects.hashCode(itemAppearanceConditions);
        result = 31 * result + java.util.Arrays.hashCode(displayEntityStatsHUD);
        result = 31 * result + java.util.Objects.hashCode(pullbackConfig);
        result = 31 * result + Boolean.hashCode(clipsGeometry);
        result = 31 * result + Boolean.hashCode(renderDeployablePreview);
        result = 31 * result + java.util.Arrays.hashCode(hudUI);
        return result;
    }

}