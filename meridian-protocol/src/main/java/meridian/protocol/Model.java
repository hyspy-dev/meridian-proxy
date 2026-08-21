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

public class Model {
    public static final int NULLABLE_BIT_FIELD_SIZE = 2;
    public static final int FIXED_BLOCK_SIZE = 51;
    public static final int VARIABLE_FIELD_COUNT = 12;
    public static final int VARIABLE_BLOCK_START = 99;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String assetId;
    @Nullable public String path;
    @Nullable public String texture;
    @Nullable public String gradientSet;
    @Nullable public String gradientId;
    @Nullable public CameraSettings camera;
    public float scale;
    public float eyeHeight;
    public float crouchOffset;
    public float sittingOffset;
    public float sleepingOffset;
    @Nullable public java.util.Map<String, AnimationSet> animationSets;
    @Nullable public ModelAttachment[] attachments;
    @Nullable public Hitbox hitbox;
    @Nullable public ModelParticle[] particles;
    @Nullable public ModelTrail[] trails;
    @Nullable public ColorLight light;
    @Nullable public java.util.Map<String, DetailBox[]> detailBoxes;
    @Nonnull public Phobia phobia = Phobia.None;
    @Nullable public Model phobiaModel;

    public Model() {
    }

    public Model(@Nullable String assetId, @Nullable String path, @Nullable String texture, @Nullable String gradientSet, @Nullable String gradientId, @Nullable CameraSettings camera, float scale, float eyeHeight, float crouchOffset, float sittingOffset, float sleepingOffset, @Nullable java.util.Map<String, AnimationSet> animationSets, @Nullable ModelAttachment[] attachments, @Nullable Hitbox hitbox, @Nullable ModelParticle[] particles, @Nullable ModelTrail[] trails, @Nullable ColorLight light, @Nullable java.util.Map<String, DetailBox[]> detailBoxes, @Nonnull Phobia phobia, @Nullable Model phobiaModel) {
        this.assetId = assetId;
        this.path = path;
        this.texture = texture;
        this.gradientSet = gradientSet;
        this.gradientId = gradientId;
        this.camera = camera;
        this.scale = scale;
        this.eyeHeight = eyeHeight;
        this.crouchOffset = crouchOffset;
        this.sittingOffset = sittingOffset;
        this.sleepingOffset = sleepingOffset;
        this.animationSets = animationSets;
        this.attachments = attachments;
        this.hitbox = hitbox;
        this.particles = particles;
        this.trails = trails;
        this.light = light;
        this.detailBoxes = detailBoxes;
        this.phobia = phobia;
        this.phobiaModel = phobiaModel;
    }

    public Model(@Nonnull Model other) {
        this.assetId = other.assetId;
        this.path = other.path;
        this.texture = other.texture;
        this.gradientSet = other.gradientSet;
        this.gradientId = other.gradientId;
        this.camera = other.camera;
        this.scale = other.scale;
        this.eyeHeight = other.eyeHeight;
        this.crouchOffset = other.crouchOffset;
        this.sittingOffset = other.sittingOffset;
        this.sleepingOffset = other.sleepingOffset;
        this.animationSets = other.animationSets;
        this.attachments = other.attachments;
        this.hitbox = other.hitbox;
        this.particles = other.particles;
        this.trails = other.trails;
        this.light = other.light;
        this.detailBoxes = other.detailBoxes;
        this.phobia = other.phobia;
        this.phobiaModel = other.phobiaModel;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Model", offset, (int) mem.byteSize());
        long needed = (long) offset + 99;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Model", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getAssetId(MemorySegment mem) {
        return getAssetId(mem, 0);
    }
    
    @Nullable
    public static String getAssetId(MemorySegment mem, int offset) {
        return hasAssetId(mem, offset) ? PacketIO.readVarString("AssetId", mem, offset + getValidatedOffset(mem, offset, 51, 99, "AssetId"), 4096000): null;
    }
    
    @Nullable
    public static String getPath(MemorySegment mem) {
        return getPath(mem, 0);
    }
    
    @Nullable
    public static String getPath(MemorySegment mem, int offset) {
        return hasPath(mem, offset) ? PacketIO.readVarString("Path", mem, offset + getValidatedOffset(mem, offset, 55, 99, "Path"), 4096000): null;
    }
    
    @Nullable
    public static String getTexture(MemorySegment mem) {
        return getTexture(mem, 0);
    }
    
    @Nullable
    public static String getTexture(MemorySegment mem, int offset) {
        return hasTexture(mem, offset) ? PacketIO.readVarString("Texture", mem, offset + getValidatedOffset(mem, offset, 59, 99, "Texture"), 4096000): null;
    }
    
    @Nullable
    public static String getGradientSet(MemorySegment mem) {
        return getGradientSet(mem, 0);
    }
    
    @Nullable
    public static String getGradientSet(MemorySegment mem, int offset) {
        return hasGradientSet(mem, offset) ? PacketIO.readVarString("GradientSet", mem, offset + getValidatedOffset(mem, offset, 63, 99, "GradientSet"), 4096000): null;
    }
    
    @Nullable
    public static String getGradientId(MemorySegment mem) {
        return getGradientId(mem, 0);
    }
    
    @Nullable
    public static String getGradientId(MemorySegment mem, int offset) {
        return hasGradientId(mem, offset) ? PacketIO.readVarString("GradientId", mem, offset + getValidatedOffset(mem, offset, 67, 99, "GradientId"), 4096000): null;
    }
    
    @Nullable
    public static CameraSettings getCamera(MemorySegment mem) {
        return getCamera(mem, 0);
    }
    
    @Nullable
    public static CameraSettings getCamera(MemorySegment mem, int offset) {
        return hasCamera(mem, offset) ? CameraSettings.toObject(mem, offset + getValidatedOffset(mem, offset, 71, 99, "Camera")): null;
    }
    
    public static float getScale(MemorySegment mem) {
        return getScale(mem, 0);
    }
    
    public static float getScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "Scale");
    }
    
    public static float getEyeHeight(MemorySegment mem) {
        return getEyeHeight(mem, 0);
    }
    
    public static float getEyeHeight(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 6), "EyeHeight");
    }
    
    public static float getCrouchOffset(MemorySegment mem) {
        return getCrouchOffset(mem, 0);
    }
    
    public static float getCrouchOffset(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 10), "CrouchOffset");
    }
    
    public static float getSittingOffset(MemorySegment mem) {
        return getSittingOffset(mem, 0);
    }
    
    public static float getSittingOffset(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 14), "SittingOffset");
    }
    
    public static float getSleepingOffset(MemorySegment mem) {
        return getSleepingOffset(mem, 0);
    }
    
    public static float getSleepingOffset(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 18), "SleepingOffset");
    }
    
    @Nullable
    public static java.util.Map<String, AnimationSet> getAnimationSets(MemorySegment mem) {
        return getAnimationSets(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, AnimationSet> getAnimationSets(MemorySegment mem, int offset) {
        if (!hasAnimationSets(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 75, 99, "AnimationSets");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("AnimationSets");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("AnimationSets", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 18 > mem.byteSize()) throw ProtocolException.bufferTooSmall("AnimationSets", (int) java.lang.Math.min(off + (long) len * 18, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, AnimationSet> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = AnimationSet.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("AnimationSets", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static ModelAttachment[] getAttachments(MemorySegment mem) {
        return getAttachments(mem, 0);
    }
    
    @Nullable
    public static ModelAttachment[] getAttachments(MemorySegment mem, int offset) {
        if (!hasAttachments(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 79, 99, "Attachments");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Attachments");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Attachments", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Attachments", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ModelAttachment[len];
        for (var i = 0; i < len; i++) {
            data[i] = ModelAttachment.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static Hitbox getHitbox(MemorySegment mem) {
        return getHitbox(mem, 0);
    }
    
    @Nullable
    public static Hitbox getHitbox(MemorySegment mem, int offset) {
        return hasHitbox(mem, offset) ? Hitbox.toObject(mem, offset + 22): null;
    }
    
    @Nullable
    public static ModelParticle[] getParticles(MemorySegment mem) {
        return getParticles(mem, 0);
    }
    
    @Nullable
    public static ModelParticle[] getParticles(MemorySegment mem, int offset) {
        if (!hasParticles(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 83, 99, "Particles");
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
    public static ModelTrail[] getTrails(MemorySegment mem) {
        return getTrails(mem, 0);
    }
    
    @Nullable
    public static ModelTrail[] getTrails(MemorySegment mem, int offset) {
        if (!hasTrails(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 87, 99, "Trails");
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
        return hasLight(mem, offset) ? ColorLight.toObject(mem, offset + 46): null;
    }
    
    @Nullable
    public static java.util.Map<String, DetailBox[]> getDetailBoxes(MemorySegment mem) {
        return getDetailBoxes(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, DetailBox[]> getDetailBoxes(MemorySegment mem, int offset) {
        if (!hasDetailBoxes(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 91, 99, "DetailBoxes");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("DetailBoxes");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("DetailBoxes", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("DetailBoxes", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, DetailBox[]> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var valuePacked = VarInt.getWithLength(mem, off);
                if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                var valueLen = (int) valuePacked;
                var valueVarLen = (int) (valuePacked >>> 32);
                if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                if (off + valueVarLen + (long) valueLen * 37 > mem.byteSize())
                    throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 37, (int) mem.byteSize());
                off += valueVarLen;
                var value = new DetailBox[valueLen];
                for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                    value[valueIdx] = DetailBox.toObject(mem, off);
                    off += 37;
                }
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("DetailBoxes", key);
            }
        }
        return data;
    }
    
    public static Phobia getPhobia(MemorySegment mem) {
        return getPhobia(mem, 0);
    }
    
    public static Phobia getPhobia(MemorySegment mem, int offset) {
        return Phobia.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 50));
    }
    
    @Nullable
    public static Model getPhobiaModel(MemorySegment mem) {
        return getPhobiaModel(mem, 0);
    }
    
    @Nullable
    public static Model getPhobiaModel(MemorySegment mem, int offset) {
        return hasPhobiaModel(mem, offset) ? Model.toObject(mem, offset + getValidatedOffset(mem, offset, 95, 99, "PhobiaModel")): null;
    }
    
    public static boolean hasHitbox(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasLight(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasAssetId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasPath(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasTexture(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasGradientSet(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasGradientId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasCamera(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasAnimationSets(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasAttachments(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasParticles(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasTrails(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasDetailBoxes(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasPhobiaModel(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
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
    
    public static Model toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Model toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Model and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Model toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 99;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasAssetId(mem, offset)) {
            requireSlot(mem, offset + 51, varPos, "AssetId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("AssetId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 51, -1, "AssetId");
        }
        
        String v1 = null;
        if (hasPath(mem, offset)) {
            requireSlot(mem, offset + 55, varPos, "Path");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Path", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 55, -1, "Path");
        }
        
        String v2 = null;
        if (hasTexture(mem, offset)) {
            requireSlot(mem, offset + 59, varPos, "Texture");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("Texture", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 59, -1, "Texture");
        }
        
        String v3 = null;
        if (hasGradientSet(mem, offset)) {
            requireSlot(mem, offset + 63, varPos, "GradientSet");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readVarString("GradientSet", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 63, -1, "GradientSet");
        }
        
        String v4 = null;
        if (hasGradientId(mem, offset)) {
            requireSlot(mem, offset + 67, varPos, "GradientId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v4 = PacketIO.readVarString("GradientId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 67, -1, "GradientId");
        }
        
        CameraSettings v5 = null;
        if (hasCamera(mem, offset)) {
            requireSlot(mem, offset + 71, varPos, "Camera");
            v5 = CameraSettings.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 71, -1, "Camera");
        }
        
        java.util.Map<String, AnimationSet> v11 = null;
        if (hasAnimationSets(mem, offset)) {
            requireSlot(mem, offset + 75, varPos, "AnimationSets");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("AnimationSets");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("AnimationSets", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 18 > mem.byteSize()) throw ProtocolException.bufferTooSmall("AnimationSets", (int) java.lang.Math.min(off + (long) len * 18, Integer.MAX_VALUE), (int) mem.byteSize());
            v11 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = AnimationSet.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v11.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("AnimationSets", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 75, -1, "AnimationSets");
        }
        
        ModelAttachment[] v12 = null;
        if (hasAttachments(mem, offset)) {
            requireSlot(mem, offset + 79, varPos, "Attachments");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Attachments");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Attachments", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Attachments", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v12 = new ModelAttachment[len];
            for (var i = 0; i < len; i++) {
                v12[i] = ModelAttachment.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 79, -1, "Attachments");
        }
        
        ModelParticle[] v14 = null;
        if (hasParticles(mem, offset)) {
            requireSlot(mem, offset + 83, varPos, "Particles");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Particles");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Particles", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Particles", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v14 = new ModelParticle[len];
            for (var i = 0; i < len; i++) {
                v14[i] = ModelParticle.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 83, -1, "Particles");
        }
        
        ModelTrail[] v15 = null;
        if (hasTrails(mem, offset)) {
            requireSlot(mem, offset + 87, varPos, "Trails");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Trails");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Trails", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 35 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Trails", (int) java.lang.Math.min(off + lenOffset + (long) len * 35, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v15 = new ModelTrail[len];
            for (var i = 0; i < len; i++) {
                v15[i] = ModelTrail.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 87, -1, "Trails");
        }
        
        java.util.Map<String, DetailBox[]> v17 = null;
        if (hasDetailBoxes(mem, offset)) {
            requireSlot(mem, offset + 91, varPos, "DetailBoxes");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("DetailBoxes");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("DetailBoxes", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("DetailBoxes", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            v17 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var valuePacked = VarInt.getWithLength(mem, off);
                    if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                    var valueLen = (int) valuePacked;
                    var valueVarLen = (int) (valuePacked >>> 32);
                    if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                    if (off + valueVarLen + (long) valueLen * 37 > mem.byteSize())
                        throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 37, (int) mem.byteSize());
                    off += valueVarLen;
                    var value = new DetailBox[valueLen];
                    for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                        value[valueIdx] = DetailBox.toObject(mem, off);
                        off += 37;
                    }
                if (v17.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("DetailBoxes", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 91, -1, "DetailBoxes");
        }
        
        Model v19 = null;
        if (hasPhobiaModel(mem, offset)) {
            requireSlot(mem, offset + 95, varPos, "PhobiaModel");
            v19 = Model.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 95, -1, "PhobiaModel");
        }
        var result = new Model(
            v0,
            v1,
            v2,
            v3,
            v4,
            v5,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "Scale"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 6), "EyeHeight"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 10), "CrouchOffset"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 14), "SittingOffset"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 18), "SleepingOffset"),
            v11,
            v12,
            hasHitbox(mem, offset) ? Hitbox.toObject(mem, offset + 22) : null,
            v14,
            v15,
            hasLight(mem, offset) ? ColorLight.toObject(mem, offset + 46) : null,
            v17,
            Phobia.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 50)),
            v19
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.hitbox != null) nullBits |= 0x01;
        if (this.light != null) nullBits |= 0x02;
        if (this.assetId != null) nullBits |= 0x04;
        if (this.path != null) nullBits |= 0x08;
        if (this.texture != null) nullBits |= 0x10;
        if (this.gradientSet != null) nullBits |= 0x20;
        if (this.gradientId != null) nullBits |= 0x40;
        if (this.camera != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        nullBits = 0;
        if (this.animationSets != null) nullBits |= 0x01;
        if (this.attachments != null) nullBits |= 0x02;
        if (this.particles != null) nullBits |= 0x04;
        if (this.trails != null) nullBits |= 0x08;
        if (this.detailBoxes != null) nullBits |= 0x10;
        if (this.phobiaModel != null) nullBits |= 0x20;
        mem.set(PacketIO.PROTO_BYTE, offset + 1, nullBits);
        
        PacketIO.requireFinite(this.scale, "Scale"); mem.set(PacketIO.PROTO_FLOAT, offset + 2, this.scale);
        PacketIO.requireFinite(this.eyeHeight, "EyeHeight"); mem.set(PacketIO.PROTO_FLOAT, offset + 6, this.eyeHeight);
        PacketIO.requireFinite(this.crouchOffset, "CrouchOffset"); mem.set(PacketIO.PROTO_FLOAT, offset + 10, this.crouchOffset);
        PacketIO.requireFinite(this.sittingOffset, "SittingOffset"); mem.set(PacketIO.PROTO_FLOAT, offset + 14, this.sittingOffset);
        PacketIO.requireFinite(this.sleepingOffset, "SleepingOffset"); mem.set(PacketIO.PROTO_FLOAT, offset + 18, this.sleepingOffset);
        if (this.hitbox != null) {
            this.hitbox.serialize(mem, offset + 22);
        } else {
            mem.asSlice(offset + 22, 24).fill((byte) 0); 
        }
        if (this.light != null) {
            this.light.serialize(mem, offset + 46);
        } else {
            mem.asSlice(offset + 46, 4).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BYTE, offset + 50, (byte) this.phobia.getValue());
        var varOffset = offset + 99;
        if (this.assetId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 51, varOffset - offset - 99);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.assetId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 51, -1);
        }
        if (this.path != null) {
            mem.set(PacketIO.PROTO_INT, offset + 55, varOffset - offset - 99);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.path, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 55, -1);
        }
        if (this.texture != null) {
            mem.set(PacketIO.PROTO_INT, offset + 59, varOffset - offset - 99);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.texture, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 59, -1);
        }
        if (this.gradientSet != null) {
            mem.set(PacketIO.PROTO_INT, offset + 63, varOffset - offset - 99);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.gradientSet, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 63, -1);
        }
        if (this.gradientId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 67, varOffset - offset - 99);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.gradientId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 67, -1);
        }
        if (this.camera != null) {
            mem.set(PacketIO.PROTO_INT, offset + 71, varOffset - offset - 99);
            varOffset += this.camera.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 71, -1);
        }
        if (this.animationSets != null) {
            mem.set(PacketIO.PROTO_INT, offset + 75, varOffset - offset - 99);
            if (this.animationSets.size() > 4096000) throw ProtocolException.dictionaryTooLarge("AnimationSets", animationSets.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.animationSets.size());
            for (var e : this.animationSets.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 75, -1);
        }
        if (this.attachments != null) {
            mem.set(PacketIO.PROTO_INT, offset + 79, varOffset - offset - 99);
            if (attachments.length > 4096000) throw ProtocolException.arrayTooLong("Attachments", attachments.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.attachments.length);
            
            var attachmentsValueOffset = 0;
            for (var i = 0; i < this.attachments.length; i++) {
                attachmentsValueOffset += this.attachments[i].serialize(mem, varOffset + attachmentsValueOffset);
            }
            varOffset += attachmentsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 79, -1);
        }
        if (this.particles != null) {
            mem.set(PacketIO.PROTO_INT, offset + 83, varOffset - offset - 99);
            if (particles.length > 4096000) throw ProtocolException.arrayTooLong("Particles", particles.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.particles.length);
            
            var particlesValueOffset = 0;
            for (var i = 0; i < this.particles.length; i++) {
                particlesValueOffset += this.particles[i].serialize(mem, varOffset + particlesValueOffset);
            }
            varOffset += particlesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 83, -1);
        }
        if (this.trails != null) {
            mem.set(PacketIO.PROTO_INT, offset + 87, varOffset - offset - 99);
            if (trails.length > 4096000) throw ProtocolException.arrayTooLong("Trails", trails.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.trails.length);
            
            var trailsValueOffset = 0;
            for (var i = 0; i < this.trails.length; i++) {
                trailsValueOffset += this.trails[i].serialize(mem, varOffset + trailsValueOffset);
            }
            varOffset += trailsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 87, -1);
        }
        if (this.detailBoxes != null) {
            mem.set(PacketIO.PROTO_INT, offset + 91, varOffset - offset - 99);
            if (this.detailBoxes.size() > 4096000) throw ProtocolException.dictionaryTooLarge("DetailBoxes", detailBoxes.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.detailBoxes.size());
            for (var e : this.detailBoxes.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                varOffset += VarInt.set(mem, varOffset, e.getValue().length);
                for (var arrItem : e.getValue()) {
                    varOffset += arrItem.serialize(mem, varOffset);
                }
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 91, -1);
        }
        if (this.phobiaModel != null) {
            mem.set(PacketIO.PROTO_INT, offset + 95, varOffset - offset - 99);
            varOffset += this.phobiaModel.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 95, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 99;
        if (assetId != null) size += PacketIO.stringSize(assetId);
    if (path != null) size += PacketIO.stringSize(path);
    if (texture != null) size += PacketIO.stringSize(texture);
    if (gradientSet != null) size += PacketIO.stringSize(gradientSet);
    if (gradientId != null) size += PacketIO.stringSize(gradientId);
    if (camera != null) size += camera.computeSize();
    if (animationSets != null) {
        int animationSetsSize = 0;
for (var kvp : animationSets.entrySet()) animationSetsSize += PacketIO.stringSize(kvp.getKey()) + kvp.getValue().computeSize();
size += VarInt.size(animationSets.size()) + animationSetsSize;
    }
    if (attachments != null) {
        int attachmentsSize = 0;
for (var elem : attachments) attachmentsSize += elem.computeSize();
size += VarInt.size(attachments.length) + attachmentsSize;
    }
    if (particles != null) {
        int particlesSize = 0;
for (var elem : particles) particlesSize += elem.computeSize();
size += VarInt.size(particles.length) + particlesSize;
    }
    if (trails != null) {
        int trailsSize = 0;
for (var elem : trails) trailsSize += elem.computeSize();
size += VarInt.size(trails.length) + trailsSize;
    }
    if (detailBoxes != null) {
        int detailBoxesSize = 0;
for (var kvp : detailBoxes.entrySet()) detailBoxesSize += PacketIO.stringSize(kvp.getKey()) + VarInt.size(kvp.getValue().length) + kvp.getValue().length * 37;
size += VarInt.size(detailBoxes.size()) + detailBoxesSize;
    }
    if (phobiaModel != null) size += phobiaModel.computeSize();

        return size;
    }

    public Model clone() {
        Model copy = new Model();
        copy.assetId = this.assetId;
        copy.path = this.path;
        copy.texture = this.texture;
        copy.gradientSet = this.gradientSet;
        copy.gradientId = this.gradientId;
        copy.camera = this.camera != null ? this.camera.clone() : null;
        copy.scale = this.scale;
        copy.eyeHeight = this.eyeHeight;
        copy.crouchOffset = this.crouchOffset;
        copy.sittingOffset = this.sittingOffset;
        copy.sleepingOffset = this.sleepingOffset;
        if (this.animationSets != null) {
            java.util.Map<String, AnimationSet> m = new java.util.HashMap<>();
            for (var e : this.animationSets.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.animationSets = m;
        }
        copy.attachments = this.attachments != null ? java.util.Arrays.stream(this.attachments).map(e -> e.clone()).toArray(ModelAttachment[]::new) : null;
        copy.hitbox = this.hitbox != null ? this.hitbox.clone() : null;
        copy.particles = this.particles != null ? java.util.Arrays.stream(this.particles).map(e -> e.clone()).toArray(ModelParticle[]::new) : null;
        copy.trails = this.trails != null ? java.util.Arrays.stream(this.trails).map(e -> e.clone()).toArray(ModelTrail[]::new) : null;
        copy.light = this.light != null ? this.light.clone() : null;
        if (this.detailBoxes != null) {
            java.util.Map<String, DetailBox[]> m = new java.util.HashMap<>();
            for (var e : this.detailBoxes.entrySet()) { m.put(e.getKey(), java.util.Arrays.stream(e.getValue()).map(x -> x.clone()).toArray(DetailBox[]::new)); }
            copy.detailBoxes = m;
        }
        copy.phobia = this.phobia;
        copy.phobiaModel = this.phobiaModel != null ? this.phobiaModel.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Model other)) return false;
        return java.util.Objects.equals(this.assetId, other.assetId) && java.util.Objects.equals(this.path, other.path) && java.util.Objects.equals(this.texture, other.texture) && java.util.Objects.equals(this.gradientSet, other.gradientSet) && java.util.Objects.equals(this.gradientId, other.gradientId) && java.util.Objects.equals(this.camera, other.camera) && this.scale == other.scale && this.eyeHeight == other.eyeHeight && this.crouchOffset == other.crouchOffset && this.sittingOffset == other.sittingOffset && this.sleepingOffset == other.sleepingOffset && java.util.Objects.equals(this.animationSets, other.animationSets) && java.util.Arrays.equals(this.attachments, other.attachments) && java.util.Objects.equals(this.hitbox, other.hitbox) && java.util.Arrays.equals(this.particles, other.particles) && java.util.Arrays.equals(this.trails, other.trails) && java.util.Objects.equals(this.light, other.light) && java.util.Objects.equals(this.detailBoxes, other.detailBoxes) && java.util.Objects.equals(this.phobia, other.phobia) && java.util.Objects.equals(this.phobiaModel, other.phobiaModel);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(assetId);
        result = 31 * result + java.util.Objects.hashCode(path);
        result = 31 * result + java.util.Objects.hashCode(texture);
        result = 31 * result + java.util.Objects.hashCode(gradientSet);
        result = 31 * result + java.util.Objects.hashCode(gradientId);
        result = 31 * result + java.util.Objects.hashCode(camera);
        result = 31 * result + Float.hashCode(scale);
        result = 31 * result + Float.hashCode(eyeHeight);
        result = 31 * result + Float.hashCode(crouchOffset);
        result = 31 * result + Float.hashCode(sittingOffset);
        result = 31 * result + Float.hashCode(sleepingOffset);
        result = 31 * result + java.util.Objects.hashCode(animationSets);
        result = 31 * result + java.util.Arrays.hashCode(attachments);
        result = 31 * result + java.util.Objects.hashCode(hitbox);
        result = 31 * result + java.util.Arrays.hashCode(particles);
        result = 31 * result + java.util.Arrays.hashCode(trails);
        result = 31 * result + java.util.Objects.hashCode(light);
        result = 31 * result + java.util.Objects.hashCode(detailBoxes);
        result = 31 * result + java.util.Objects.hashCode(phobia);
        result = 31 * result + java.util.Objects.hashCode(phobiaModel);
        return result;
    }

}