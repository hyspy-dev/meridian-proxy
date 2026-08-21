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

public class ItemPlayerAnimations {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 91;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 103;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String id;
    @Nonnull public java.util.Map<String, ItemAnimation> animations = new java.util.HashMap<>();
    @Nullable public WiggleWeights wiggleWeights;
    @Nullable public CameraSettings camera;
    @Nullable public ItemPullbackConfiguration pullbackConfig;
    public boolean useFirstPersonOverride;

    public ItemPlayerAnimations() {
    }

    public ItemPlayerAnimations(@Nullable String id, @Nonnull java.util.Map<String, ItemAnimation> animations, @Nullable WiggleWeights wiggleWeights, @Nullable CameraSettings camera, @Nullable ItemPullbackConfiguration pullbackConfig, boolean useFirstPersonOverride) {
        this.id = id;
        this.animations = animations;
        this.wiggleWeights = wiggleWeights;
        this.camera = camera;
        this.pullbackConfig = pullbackConfig;
        this.useFirstPersonOverride = useFirstPersonOverride;
    }

    public ItemPlayerAnimations(@Nonnull ItemPlayerAnimations other) {
        this.id = other.id;
        this.animations = other.animations;
        this.wiggleWeights = other.wiggleWeights;
        this.camera = other.camera;
        this.pullbackConfig = other.pullbackConfig;
        this.useFirstPersonOverride = other.useFirstPersonOverride;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemPlayerAnimations", offset, (int) mem.byteSize());
        long needed = (long) offset + 103;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemPlayerAnimations", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 91, 103, "Id"), 4096000): null;
    }
    
    public static java.util.Map<String, ItemAnimation> getAnimations(MemorySegment mem) {
        return getAnimations(mem, 0);
    }
    
    public static java.util.Map<String, ItemAnimation> getAnimations(MemorySegment mem, int offset) {
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 95, 103, "Animations");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Animations");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Animations", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 32 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Animations", (int) java.lang.Math.min(off + (long) len * 32, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, ItemAnimation> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = ItemAnimation.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Animations", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static WiggleWeights getWiggleWeights(MemorySegment mem) {
        return getWiggleWeights(mem, 0);
    }
    
    @Nullable
    public static WiggleWeights getWiggleWeights(MemorySegment mem, int offset) {
        return hasWiggleWeights(mem, offset) ? WiggleWeights.toObject(mem, offset + 1): null;
    }
    
    @Nullable
    public static CameraSettings getCamera(MemorySegment mem) {
        return getCamera(mem, 0);
    }
    
    @Nullable
    public static CameraSettings getCamera(MemorySegment mem, int offset) {
        return hasCamera(mem, offset) ? CameraSettings.toObject(mem, offset + getValidatedOffset(mem, offset, 99, 103, "Camera")): null;
    }
    
    @Nullable
    public static ItemPullbackConfiguration getPullbackConfig(MemorySegment mem) {
        return getPullbackConfig(mem, 0);
    }
    
    @Nullable
    public static ItemPullbackConfiguration getPullbackConfig(MemorySegment mem, int offset) {
        return hasPullbackConfig(mem, offset) ? ItemPullbackConfiguration.toObject(mem, offset + 41): null;
    }
    
    public static boolean getUseFirstPersonOverride(MemorySegment mem) {
        return getUseFirstPersonOverride(mem, 0);
    }
    
    public static boolean getUseFirstPersonOverride(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 90);
    }
    
    public static boolean hasWiggleWeights(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasPullbackConfig(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasCamera(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
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
    
    public static ItemPlayerAnimations toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemPlayerAnimations toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemPlayerAnimations and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemPlayerAnimations toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 103;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 91, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 91, -1, "Id");
        }
        
        java.util.Map<String, ItemAnimation> v1;
        requireSlot(mem, offset + 95, varPos, "Animations");
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Animations");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Animations", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 32 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Animations", (int) java.lang.Math.min(off + (long) len * 32, Integer.MAX_VALUE), (int) mem.byteSize());
            v1 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = ItemAnimation.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v1.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Animations", key);
                }
            }
            varPos = off - varBase;
        }
        
        CameraSettings v3 = null;
        if (hasCamera(mem, offset)) {
            requireSlot(mem, offset + 99, varPos, "Camera");
            v3 = CameraSettings.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 99, -1, "Camera");
        }
        var result = new ItemPlayerAnimations(
            v0,
            v1,
            hasWiggleWeights(mem, offset) ? WiggleWeights.toObject(mem, offset + 1) : null,
            v3,
            hasPullbackConfig(mem, offset) ? ItemPullbackConfiguration.toObject(mem, offset + 41) : null,
            mem.get(PacketIO.PROTO_BOOL, offset + 90)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.wiggleWeights != null) nullBits |= 0x01;
        if (this.pullbackConfig != null) nullBits |= 0x02;
        if (this.id != null) nullBits |= 0x04;
        if (this.camera != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.wiggleWeights != null) {
            this.wiggleWeights.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 40).fill((byte) 0); 
        }
        if (this.pullbackConfig != null) {
            this.pullbackConfig.serialize(mem, offset + 41);
        } else {
            mem.asSlice(offset + 41, 49).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BOOL, offset + 90, this.useFirstPersonOverride);
        var varOffset = offset + 103;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 91, varOffset - offset - 103);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 91, -1);
        }
        mem.set(PacketIO.PROTO_INT, offset + 95, varOffset - offset - 103);
        if (this.animations.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Animations", animations.size(), 4096000);
        varOffset += VarInt.set(mem, varOffset, this.animations.size());
        for (var e : this.animations.entrySet()) {
            varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
            varOffset += e.getValue().serialize(mem, varOffset);
        }
        if (this.camera != null) {
            mem.set(PacketIO.PROTO_INT, offset + 99, varOffset - offset - 103);
            varOffset += this.camera.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 99, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 103;
        if (id != null) size += PacketIO.stringSize(id);
    int animationsSize = 0;
for (var kvp : animations.entrySet()) animationsSize += PacketIO.stringSize(kvp.getKey()) + kvp.getValue().computeSize();
size += VarInt.size(animations.size()) + animationsSize;
    if (camera != null) size += camera.computeSize();

        return size;
    }

    public ItemPlayerAnimations clone() {
        ItemPlayerAnimations copy = new ItemPlayerAnimations();
        copy.id = this.id;
        {
            java.util.Map<String, ItemAnimation> m = new java.util.HashMap<>();
            for (var e : this.animations.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.animations = m;
        }
        copy.wiggleWeights = this.wiggleWeights != null ? this.wiggleWeights.clone() : null;
        copy.camera = this.camera != null ? this.camera.clone() : null;
        copy.pullbackConfig = this.pullbackConfig != null ? this.pullbackConfig.clone() : null;
        copy.useFirstPersonOverride = this.useFirstPersonOverride;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemPlayerAnimations other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.animations, other.animations) && java.util.Objects.equals(this.wiggleWeights, other.wiggleWeights) && java.util.Objects.equals(this.camera, other.camera) && java.util.Objects.equals(this.pullbackConfig, other.pullbackConfig) && this.useFirstPersonOverride == other.useFirstPersonOverride;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, animations, wiggleWeights, camera, pullbackConfig, useFirstPersonOverride);
    }

}