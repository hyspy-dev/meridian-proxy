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
import meridian.protocol.packets.camera.CameraShakeEffect;

public class InteractionEffects {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 30;
    public static final int VARIABLE_FIELD_COUNT = 6;
    public static final int VARIABLE_BLOCK_START = 54;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public ModelParticle[] particles;
    @Nullable public ModelParticle[] firstPersonParticles;
    public int worldSoundEventIndex;
    public int localSoundEventIndex;
    @Nullable public ModelTrail[] trails;
    public boolean waitForAnimationToFinish = true;
    @Nullable public String itemPlayerAnimationsId;
    @Nullable public String itemAnimationId;
    public boolean clearAnimationOnFinish;
    public boolean clearSoundEventOnFinish;
    public boolean hideFirstPersonHeldItem;
    @Nullable public CameraShakeEffect cameraShake;
    @Nullable public MovementEffects movementEffects;
    @Nullable public ZoomConfig zoom;
    public boolean persistZoom;
    public float startDelay;

    public InteractionEffects() {
    }

    public InteractionEffects(@Nullable ModelParticle[] particles, @Nullable ModelParticle[] firstPersonParticles, int worldSoundEventIndex, int localSoundEventIndex, @Nullable ModelTrail[] trails, boolean waitForAnimationToFinish, @Nullable String itemPlayerAnimationsId, @Nullable String itemAnimationId, boolean clearAnimationOnFinish, boolean clearSoundEventOnFinish, boolean hideFirstPersonHeldItem, @Nullable CameraShakeEffect cameraShake, @Nullable MovementEffects movementEffects, @Nullable ZoomConfig zoom, boolean persistZoom, float startDelay) {
        this.particles = particles;
        this.firstPersonParticles = firstPersonParticles;
        this.worldSoundEventIndex = worldSoundEventIndex;
        this.localSoundEventIndex = localSoundEventIndex;
        this.trails = trails;
        this.waitForAnimationToFinish = waitForAnimationToFinish;
        this.itemPlayerAnimationsId = itemPlayerAnimationsId;
        this.itemAnimationId = itemAnimationId;
        this.clearAnimationOnFinish = clearAnimationOnFinish;
        this.clearSoundEventOnFinish = clearSoundEventOnFinish;
        this.hideFirstPersonHeldItem = hideFirstPersonHeldItem;
        this.cameraShake = cameraShake;
        this.movementEffects = movementEffects;
        this.zoom = zoom;
        this.persistZoom = persistZoom;
        this.startDelay = startDelay;
    }

    public InteractionEffects(@Nonnull InteractionEffects other) {
        this.particles = other.particles;
        this.firstPersonParticles = other.firstPersonParticles;
        this.worldSoundEventIndex = other.worldSoundEventIndex;
        this.localSoundEventIndex = other.localSoundEventIndex;
        this.trails = other.trails;
        this.waitForAnimationToFinish = other.waitForAnimationToFinish;
        this.itemPlayerAnimationsId = other.itemPlayerAnimationsId;
        this.itemAnimationId = other.itemAnimationId;
        this.clearAnimationOnFinish = other.clearAnimationOnFinish;
        this.clearSoundEventOnFinish = other.clearSoundEventOnFinish;
        this.hideFirstPersonHeldItem = other.hideFirstPersonHeldItem;
        this.cameraShake = other.cameraShake;
        this.movementEffects = other.movementEffects;
        this.zoom = other.zoom;
        this.persistZoom = other.persistZoom;
        this.startDelay = other.startDelay;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("InteractionEffects", offset, (int) mem.byteSize());
        long needed = (long) offset + 54;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InteractionEffects", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static ModelParticle[] getParticles(MemorySegment mem) {
        return getParticles(mem, 0);
    }
    
    @Nullable
    public static ModelParticle[] getParticles(MemorySegment mem, int offset) {
        if (!hasParticles(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 30, 54, "Particles");
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
        var off = offset + getValidatedOffset(mem, offset, 34, 54, "FirstPersonParticles");
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
    
    public static int getWorldSoundEventIndex(MemorySegment mem) {
        return getWorldSoundEventIndex(mem, 0);
    }
    
    public static int getWorldSoundEventIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getLocalSoundEventIndex(MemorySegment mem) {
        return getLocalSoundEventIndex(mem, 0);
    }
    
    public static int getLocalSoundEventIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    @Nullable
    public static ModelTrail[] getTrails(MemorySegment mem) {
        return getTrails(mem, 0);
    }
    
    @Nullable
    public static ModelTrail[] getTrails(MemorySegment mem, int offset) {
        if (!hasTrails(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 38, 54, "Trails");
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
    
    public static boolean getWaitForAnimationToFinish(MemorySegment mem) {
        return getWaitForAnimationToFinish(mem, 0);
    }
    
    public static boolean getWaitForAnimationToFinish(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 9);
    }
    
    @Nullable
    public static String getItemPlayerAnimationsId(MemorySegment mem) {
        return getItemPlayerAnimationsId(mem, 0);
    }
    
    @Nullable
    public static String getItemPlayerAnimationsId(MemorySegment mem, int offset) {
        return hasItemPlayerAnimationsId(mem, offset) ? PacketIO.readVarString("ItemPlayerAnimationsId", mem, offset + getValidatedOffset(mem, offset, 42, 54, "ItemPlayerAnimationsId"), 4096000): null;
    }
    
    @Nullable
    public static String getItemAnimationId(MemorySegment mem) {
        return getItemAnimationId(mem, 0);
    }
    
    @Nullable
    public static String getItemAnimationId(MemorySegment mem, int offset) {
        return hasItemAnimationId(mem, offset) ? PacketIO.readVarString("ItemAnimationId", mem, offset + getValidatedOffset(mem, offset, 46, 54, "ItemAnimationId"), 4096000): null;
    }
    
    public static boolean getClearAnimationOnFinish(MemorySegment mem) {
        return getClearAnimationOnFinish(mem, 0);
    }
    
    public static boolean getClearAnimationOnFinish(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 10) & 0x01) != 0;
    }
    
    public static boolean getClearSoundEventOnFinish(MemorySegment mem) {
        return getClearSoundEventOnFinish(mem, 0);
    }
    
    public static boolean getClearSoundEventOnFinish(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 10) & 0x02) != 0;
    }
    
    public static boolean getHideFirstPersonHeldItem(MemorySegment mem) {
        return getHideFirstPersonHeldItem(mem, 0);
    }
    
    public static boolean getHideFirstPersonHeldItem(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 10) & 0x04) != 0;
    }
    
    @Nullable
    public static CameraShakeEffect getCameraShake(MemorySegment mem) {
        return getCameraShake(mem, 0);
    }
    
    @Nullable
    public static CameraShakeEffect getCameraShake(MemorySegment mem, int offset) {
        return hasCameraShake(mem, offset) ? CameraShakeEffect.toObject(mem, offset + 11): null;
    }
    
    @Nullable
    public static MovementEffects getMovementEffects(MemorySegment mem) {
        return getMovementEffects(mem, 0);
    }
    
    @Nullable
    public static MovementEffects getMovementEffects(MemorySegment mem, int offset) {
        return hasMovementEffects(mem, offset) ? MovementEffects.toObject(mem, offset + 20): null;
    }
    
    @Nullable
    public static ZoomConfig getZoom(MemorySegment mem) {
        return getZoom(mem, 0);
    }
    
    @Nullable
    public static ZoomConfig getZoom(MemorySegment mem, int offset) {
        return hasZoom(mem, offset) ? ZoomConfig.toObject(mem, offset + getValidatedOffset(mem, offset, 50, 54, "Zoom")): null;
    }
    
    public static boolean getPersistZoom(MemorySegment mem) {
        return getPersistZoom(mem, 0);
    }
    
    public static boolean getPersistZoom(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 25);
    }
    
    public static float getStartDelay(MemorySegment mem) {
        return getStartDelay(mem, 0);
    }
    
    public static float getStartDelay(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 26), "StartDelay");
    }
    
    public static boolean hasCameraShake(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasMovementEffects(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasParticles(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasFirstPersonParticles(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasTrails(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasItemPlayerAnimationsId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasItemAnimationId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasZoom(MemorySegment mem, int offset) {
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
    
    public static InteractionEffects toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static InteractionEffects toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one InteractionEffects and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static InteractionEffects toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 54;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ModelParticle[] v0 = null;
        if (hasParticles(mem, offset)) {
            requireSlot(mem, offset + 30, varPos, "Particles");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Particles");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Particles", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Particles", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new ModelParticle[len];
            for (var i = 0; i < len; i++) {
                v0[i] = ModelParticle.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 30, -1, "Particles");
        }
        
        ModelParticle[] v1 = null;
        if (hasFirstPersonParticles(mem, offset)) {
            requireSlot(mem, offset + 34, varPos, "FirstPersonParticles");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("FirstPersonParticles");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("FirstPersonParticles", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FirstPersonParticles", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new ModelParticle[len];
            for (var i = 0; i < len; i++) {
                v1[i] = ModelParticle.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 34, -1, "FirstPersonParticles");
        }
        
        ModelTrail[] v4 = null;
        if (hasTrails(mem, offset)) {
            requireSlot(mem, offset + 38, varPos, "Trails");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Trails");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Trails", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 35 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Trails", (int) java.lang.Math.min(off + lenOffset + (long) len * 35, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v4 = new ModelTrail[len];
            for (var i = 0; i < len; i++) {
                v4[i] = ModelTrail.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 38, -1, "Trails");
        }
        
        String v6 = null;
        if (hasItemPlayerAnimationsId(mem, offset)) {
            requireSlot(mem, offset + 42, varPos, "ItemPlayerAnimationsId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v6 = PacketIO.readVarString("ItemPlayerAnimationsId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 42, -1, "ItemPlayerAnimationsId");
        }
        
        String v7 = null;
        if (hasItemAnimationId(mem, offset)) {
            requireSlot(mem, offset + 46, varPos, "ItemAnimationId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v7 = PacketIO.readVarString("ItemAnimationId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 46, -1, "ItemAnimationId");
        }
        
        ZoomConfig v13 = null;
        if (hasZoom(mem, offset)) {
            requireSlot(mem, offset + 50, varPos, "Zoom");
            v13 = ZoomConfig.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 50, -1, "Zoom");
        }
        var result = new InteractionEffects(
            v0,
            v1,
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            v4,
            mem.get(PacketIO.PROTO_BOOL, offset + 9),
            v6,
            v7,
            (mem.get(PacketIO.PROTO_BYTE, offset + 10) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 10) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 10) & 0x04) != 0,
            hasCameraShake(mem, offset) ? CameraShakeEffect.toObject(mem, offset + 11) : null,
            hasMovementEffects(mem, offset) ? MovementEffects.toObject(mem, offset + 20) : null,
            v13,
            mem.get(PacketIO.PROTO_BOOL, offset + 25),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 26), "StartDelay")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.cameraShake != null) nullBits |= 0x01;
        if (this.movementEffects != null) nullBits |= 0x02;
        if (this.particles != null) nullBits |= 0x04;
        if (this.firstPersonParticles != null) nullBits |= 0x08;
        if (this.trails != null) nullBits |= 0x10;
        if (this.itemPlayerAnimationsId != null) nullBits |= 0x20;
        if (this.itemAnimationId != null) nullBits |= 0x40;
        if (this.zoom != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.worldSoundEventIndex);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.localSoundEventIndex);
        mem.set(PacketIO.PROTO_BOOL, offset + 9, this.waitForAnimationToFinish);
        byte boolBits0_0 = 0;
        if (this.clearAnimationOnFinish) boolBits0_0 |= 0x01;
        if (this.clearSoundEventOnFinish) boolBits0_0 |= 0x02;
        if (this.hideFirstPersonHeldItem) boolBits0_0 |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 10 + 0, boolBits0_0);
        if (this.cameraShake != null) {
            this.cameraShake.serialize(mem, offset + 11);
        } else {
            mem.asSlice(offset + 11, 9).fill((byte) 0); 
        }
        if (this.movementEffects != null) {
            this.movementEffects.serialize(mem, offset + 20);
        } else {
            mem.asSlice(offset + 20, 5).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BOOL, offset + 25, this.persistZoom);
        PacketIO.requireFinite(this.startDelay, "StartDelay"); mem.set(PacketIO.PROTO_FLOAT, offset + 26, this.startDelay);
        var varOffset = offset + 54;
        if (this.particles != null) {
            mem.set(PacketIO.PROTO_INT, offset + 30, varOffset - offset - 54);
            if (particles.length > 4096000) throw ProtocolException.arrayTooLong("Particles", particles.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.particles.length);
            
            var particlesValueOffset = 0;
            for (var i = 0; i < this.particles.length; i++) {
                particlesValueOffset += this.particles[i].serialize(mem, varOffset + particlesValueOffset);
            }
            varOffset += particlesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 30, -1);
        }
        if (this.firstPersonParticles != null) {
            mem.set(PacketIO.PROTO_INT, offset + 34, varOffset - offset - 54);
            if (firstPersonParticles.length > 4096000) throw ProtocolException.arrayTooLong("FirstPersonParticles", firstPersonParticles.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.firstPersonParticles.length);
            
            var firstPersonParticlesValueOffset = 0;
            for (var i = 0; i < this.firstPersonParticles.length; i++) {
                firstPersonParticlesValueOffset += this.firstPersonParticles[i].serialize(mem, varOffset + firstPersonParticlesValueOffset);
            }
            varOffset += firstPersonParticlesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 34, -1);
        }
        if (this.trails != null) {
            mem.set(PacketIO.PROTO_INT, offset + 38, varOffset - offset - 54);
            if (trails.length > 4096000) throw ProtocolException.arrayTooLong("Trails", trails.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.trails.length);
            
            var trailsValueOffset = 0;
            for (var i = 0; i < this.trails.length; i++) {
                trailsValueOffset += this.trails[i].serialize(mem, varOffset + trailsValueOffset);
            }
            varOffset += trailsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 38, -1);
        }
        if (this.itemPlayerAnimationsId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 42, varOffset - offset - 54);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.itemPlayerAnimationsId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 42, -1);
        }
        if (this.itemAnimationId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 46, varOffset - offset - 54);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.itemAnimationId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 46, -1);
        }
        if (this.zoom != null) {
            mem.set(PacketIO.PROTO_INT, offset + 50, varOffset - offset - 54);
            varOffset += this.zoom.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 50, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 54;
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
    if (itemPlayerAnimationsId != null) size += PacketIO.stringSize(itemPlayerAnimationsId);
    if (itemAnimationId != null) size += PacketIO.stringSize(itemAnimationId);
    if (zoom != null) size += zoom.computeSize();

        return size;
    }

    public InteractionEffects clone() {
        InteractionEffects copy = new InteractionEffects();
        copy.particles = this.particles != null ? java.util.Arrays.stream(this.particles).map(e -> e.clone()).toArray(ModelParticle[]::new) : null;
        copy.firstPersonParticles = this.firstPersonParticles != null ? java.util.Arrays.stream(this.firstPersonParticles).map(e -> e.clone()).toArray(ModelParticle[]::new) : null;
        copy.worldSoundEventIndex = this.worldSoundEventIndex;
        copy.localSoundEventIndex = this.localSoundEventIndex;
        copy.trails = this.trails != null ? java.util.Arrays.stream(this.trails).map(e -> e.clone()).toArray(ModelTrail[]::new) : null;
        copy.waitForAnimationToFinish = this.waitForAnimationToFinish;
        copy.itemPlayerAnimationsId = this.itemPlayerAnimationsId;
        copy.itemAnimationId = this.itemAnimationId;
        copy.clearAnimationOnFinish = this.clearAnimationOnFinish;
        copy.clearSoundEventOnFinish = this.clearSoundEventOnFinish;
        copy.hideFirstPersonHeldItem = this.hideFirstPersonHeldItem;
        copy.cameraShake = this.cameraShake != null ? this.cameraShake.clone() : null;
        copy.movementEffects = this.movementEffects != null ? this.movementEffects.clone() : null;
        copy.zoom = this.zoom != null ? this.zoom.clone() : null;
        copy.persistZoom = this.persistZoom;
        copy.startDelay = this.startDelay;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InteractionEffects other)) return false;
        return java.util.Arrays.equals(this.particles, other.particles) && java.util.Arrays.equals(this.firstPersonParticles, other.firstPersonParticles) && this.worldSoundEventIndex == other.worldSoundEventIndex && this.localSoundEventIndex == other.localSoundEventIndex && java.util.Arrays.equals(this.trails, other.trails) && this.waitForAnimationToFinish == other.waitForAnimationToFinish && java.util.Objects.equals(this.itemPlayerAnimationsId, other.itemPlayerAnimationsId) && java.util.Objects.equals(this.itemAnimationId, other.itemAnimationId) && this.clearAnimationOnFinish == other.clearAnimationOnFinish && this.clearSoundEventOnFinish == other.clearSoundEventOnFinish && this.hideFirstPersonHeldItem == other.hideFirstPersonHeldItem && java.util.Objects.equals(this.cameraShake, other.cameraShake) && java.util.Objects.equals(this.movementEffects, other.movementEffects) && java.util.Objects.equals(this.zoom, other.zoom) && this.persistZoom == other.persistZoom && this.startDelay == other.startDelay;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(particles);
        result = 31 * result + java.util.Arrays.hashCode(firstPersonParticles);
        result = 31 * result + Integer.hashCode(worldSoundEventIndex);
        result = 31 * result + Integer.hashCode(localSoundEventIndex);
        result = 31 * result + java.util.Arrays.hashCode(trails);
        result = 31 * result + Boolean.hashCode(waitForAnimationToFinish);
        result = 31 * result + java.util.Objects.hashCode(itemPlayerAnimationsId);
        result = 31 * result + java.util.Objects.hashCode(itemAnimationId);
        result = 31 * result + Boolean.hashCode(clearAnimationOnFinish);
        result = 31 * result + Boolean.hashCode(clearSoundEventOnFinish);
        result = 31 * result + Boolean.hashCode(hideFirstPersonHeldItem);
        result = 31 * result + java.util.Objects.hashCode(cameraShake);
        result = 31 * result + java.util.Objects.hashCode(movementEffects);
        result = 31 * result + java.util.Objects.hashCode(zoom);
        result = 31 * result + Boolean.hashCode(persistZoom);
        result = 31 * result + Float.hashCode(startDelay);
        return result;
    }

}