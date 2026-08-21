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
import java.util.UUID;
import org.joml.*;

public class InteractionSyncData {
    public static final int NULLABLE_BIT_FIELD_SIZE = 2;
    public static final int FIXED_BLOCK_SIZE = 157;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 165;
    public static final int MAX_SIZE = 237568175;

    @Nonnull public InteractionState state = InteractionState.Finished;
    public float progress;
    public int operationCounter;
    public int rootInteraction;
    public int totalForks;
    public int entityId;
    public int enteredRootInteraction = Integer.MIN_VALUE;
    @Nullable public BlockPosition blockPosition;
    @Nonnull public BlockFace blockFace = BlockFace.None;
    @Nullable public BlockRotation blockRotation;
    public int placedBlockId = Integer.MIN_VALUE;
    public float chargeValue = -1;
    @Nullable public java.util.Map<InteractionType, Integer> forkCounts;
    public int chainingIndex = -1;
    public int flagIndex = -1;
    @Nullable public SelectedHitEntity[] hitEntities;
    @Nullable public Position attackerPos;
    @Nullable public Direction attackerRot;
    @Nullable public Position raycastHit;
    public float raycastDistance;
    @Nullable public Vector3fc raycastNormal;
    @Nonnull public MovementDirection movementDirection = MovementDirection.None;
    @Nonnull public ApplyForceState applyForceState = ApplyForceState.Waiting;
    public int nextLabel;
    @Nullable public java.util.UUID generatedUUID = null;

    public InteractionSyncData() {
    }

    public InteractionSyncData(@Nonnull InteractionState state, float progress, int operationCounter, int rootInteraction, int totalForks, int entityId, int enteredRootInteraction, @Nullable BlockPosition blockPosition, @Nonnull BlockFace blockFace, @Nullable BlockRotation blockRotation, int placedBlockId, float chargeValue, @Nullable java.util.Map<InteractionType, Integer> forkCounts, int chainingIndex, int flagIndex, @Nullable SelectedHitEntity[] hitEntities, @Nullable Position attackerPos, @Nullable Direction attackerRot, @Nullable Position raycastHit, float raycastDistance, @Nullable Vector3fc raycastNormal, @Nonnull MovementDirection movementDirection, @Nonnull ApplyForceState applyForceState, int nextLabel, @Nullable java.util.UUID generatedUUID) {
        this.state = state;
        this.progress = progress;
        this.operationCounter = operationCounter;
        this.rootInteraction = rootInteraction;
        this.totalForks = totalForks;
        this.entityId = entityId;
        this.enteredRootInteraction = enteredRootInteraction;
        this.blockPosition = blockPosition;
        this.blockFace = blockFace;
        this.blockRotation = blockRotation;
        this.placedBlockId = placedBlockId;
        this.chargeValue = chargeValue;
        this.forkCounts = forkCounts;
        this.chainingIndex = chainingIndex;
        this.flagIndex = flagIndex;
        this.hitEntities = hitEntities;
        this.attackerPos = attackerPos;
        this.attackerRot = attackerRot;
        this.raycastHit = raycastHit;
        this.raycastDistance = raycastDistance;
        this.raycastNormal = raycastNormal;
        this.movementDirection = movementDirection;
        this.applyForceState = applyForceState;
        this.nextLabel = nextLabel;
        this.generatedUUID = generatedUUID;
    }

    public InteractionSyncData(@Nonnull InteractionSyncData other) {
        this.state = other.state;
        this.progress = other.progress;
        this.operationCounter = other.operationCounter;
        this.rootInteraction = other.rootInteraction;
        this.totalForks = other.totalForks;
        this.entityId = other.entityId;
        this.enteredRootInteraction = other.enteredRootInteraction;
        this.blockPosition = other.blockPosition;
        this.blockFace = other.blockFace;
        this.blockRotation = other.blockRotation;
        this.placedBlockId = other.placedBlockId;
        this.chargeValue = other.chargeValue;
        this.forkCounts = other.forkCounts;
        this.chainingIndex = other.chainingIndex;
        this.flagIndex = other.flagIndex;
        this.hitEntities = other.hitEntities;
        this.attackerPos = other.attackerPos;
        this.attackerRot = other.attackerRot;
        this.raycastHit = other.raycastHit;
        this.raycastDistance = other.raycastDistance;
        this.raycastNormal = other.raycastNormal;
        this.movementDirection = other.movementDirection;
        this.applyForceState = other.applyForceState;
        this.nextLabel = other.nextLabel;
        this.generatedUUID = other.generatedUUID;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("InteractionSyncData", offset, (int) mem.byteSize());
        long needed = (long) offset + 165;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InteractionSyncData", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static InteractionState getState(MemorySegment mem) {
        return getState(mem, 0);
    }
    
    public static InteractionState getState(MemorySegment mem, int offset) {
        return InteractionState.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2));
    }
    
    public static float getProgress(MemorySegment mem) {
        return getProgress(mem, 0);
    }
    
    public static float getProgress(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 3), "Progress");
    }
    
    public static int getOperationCounter(MemorySegment mem) {
        return getOperationCounter(mem, 0);
    }
    
    public static int getOperationCounter(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 7);
    }
    
    public static int getRootInteraction(MemorySegment mem) {
        return getRootInteraction(mem, 0);
    }
    
    public static int getRootInteraction(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 11);
    }
    
    public static int getTotalForks(MemorySegment mem) {
        return getTotalForks(mem, 0);
    }
    
    public static int getTotalForks(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 15);
    }
    
    public static int getEntityId(MemorySegment mem) {
        return getEntityId(mem, 0);
    }
    
    public static int getEntityId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 19);
    }
    
    public static int getEnteredRootInteraction(MemorySegment mem) {
        return getEnteredRootInteraction(mem, 0);
    }
    
    public static int getEnteredRootInteraction(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 23);
    }
    
    @Nullable
    public static BlockPosition getBlockPosition(MemorySegment mem) {
        return getBlockPosition(mem, 0);
    }
    
    @Nullable
    public static BlockPosition getBlockPosition(MemorySegment mem, int offset) {
        return hasBlockPosition(mem, offset) ? BlockPosition.toObject(mem, offset + 27): null;
    }
    
    public static BlockFace getBlockFace(MemorySegment mem) {
        return getBlockFace(mem, 0);
    }
    
    public static BlockFace getBlockFace(MemorySegment mem, int offset) {
        return BlockFace.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 39));
    }
    
    @Nullable
    public static BlockRotation getBlockRotation(MemorySegment mem) {
        return getBlockRotation(mem, 0);
    }
    
    @Nullable
    public static BlockRotation getBlockRotation(MemorySegment mem, int offset) {
        return hasBlockRotation(mem, offset) ? BlockRotation.toObject(mem, offset + 40): null;
    }
    
    public static int getPlacedBlockId(MemorySegment mem) {
        return getPlacedBlockId(mem, 0);
    }
    
    public static int getPlacedBlockId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 43);
    }
    
    public static float getChargeValue(MemorySegment mem) {
        return getChargeValue(mem, 0);
    }
    
    public static float getChargeValue(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 47), "ChargeValue");
    }
    
    @Nullable
    public static java.util.Map<InteractionType, Integer> getForkCounts(MemorySegment mem) {
        return getForkCounts(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<InteractionType, Integer> getForkCounts(MemorySegment mem, int offset) {
        if (!hasForkCounts(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 157, 165, "ForkCounts");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ForkCounts");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ForkCounts", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ForkCounts", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<InteractionType, Integer> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                off += 1;
            var value = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("ForkCounts", key);
            }
        }
        return data;
    }
    
    public static int getChainingIndex(MemorySegment mem) {
        return getChainingIndex(mem, 0);
    }
    
    public static int getChainingIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 51);
    }
    
    public static int getFlagIndex(MemorySegment mem) {
        return getFlagIndex(mem, 0);
    }
    
    public static int getFlagIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 55);
    }
    
    @Nullable
    public static SelectedHitEntity[] getHitEntities(MemorySegment mem) {
        return getHitEntities(mem, 0);
    }
    
    @Nullable
    public static SelectedHitEntity[] getHitEntities(MemorySegment mem, int offset) {
        if (!hasHitEntities(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 161, 165, "HitEntities");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("HitEntities");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("HitEntities", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 53 > mem.byteSize()) throw ProtocolException.bufferTooSmall("HitEntities", (int) java.lang.Math.min(off + lenOffset + (long) len * 53, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new SelectedHitEntity[len];
        for (var i = 0; i < len; i++) {
            data[i] = SelectedHitEntity.toObject(mem, off + i * 53);
        }
        return data;
    }
    
    @Nullable
    public static Position getAttackerPos(MemorySegment mem) {
        return getAttackerPos(mem, 0);
    }
    
    @Nullable
    public static Position getAttackerPos(MemorySegment mem, int offset) {
        return hasAttackerPos(mem, offset) ? Position.toObject(mem, offset + 59): null;
    }
    
    @Nullable
    public static Direction getAttackerRot(MemorySegment mem) {
        return getAttackerRot(mem, 0);
    }
    
    @Nullable
    public static Direction getAttackerRot(MemorySegment mem, int offset) {
        return hasAttackerRot(mem, offset) ? Direction.toObject(mem, offset + 83): null;
    }
    
    @Nullable
    public static Position getRaycastHit(MemorySegment mem) {
        return getRaycastHit(mem, 0);
    }
    
    @Nullable
    public static Position getRaycastHit(MemorySegment mem, int offset) {
        return hasRaycastHit(mem, offset) ? Position.toObject(mem, offset + 95): null;
    }
    
    public static float getRaycastDistance(MemorySegment mem) {
        return getRaycastDistance(mem, 0);
    }
    
    public static float getRaycastDistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 119), "RaycastDistance");
    }
    
    @Nullable
    public static Vector3fc getRaycastNormal(MemorySegment mem) {
        return getRaycastNormal(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getRaycastNormal(MemorySegment mem, int offset) {
        return hasRaycastNormal(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 123), "RaycastNormal"): null;
    }
    
    public static MovementDirection getMovementDirection(MemorySegment mem) {
        return getMovementDirection(mem, 0);
    }
    
    public static MovementDirection getMovementDirection(MemorySegment mem, int offset) {
        return MovementDirection.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 135));
    }
    
    public static ApplyForceState getApplyForceState(MemorySegment mem) {
        return getApplyForceState(mem, 0);
    }
    
    public static ApplyForceState getApplyForceState(MemorySegment mem, int offset) {
        return ApplyForceState.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 136));
    }
    
    public static int getNextLabel(MemorySegment mem) {
        return getNextLabel(mem, 0);
    }
    
    public static int getNextLabel(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 137);
    }
    
    @Nullable
    public static java.util.UUID getGeneratedUUID(MemorySegment mem) {
        return getGeneratedUUID(mem, 0);
    }
    
    @Nullable
    public static java.util.UUID getGeneratedUUID(MemorySegment mem, int offset) {
        return hasGeneratedUUID(mem, offset) ? PacketIO.readUUID(mem, offset + 141): null;
    }
    
    public static boolean hasBlockPosition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasBlockRotation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasAttackerPos(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasAttackerRot(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasRaycastHit(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasRaycastNormal(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasGeneratedUUID(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasForkCounts(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasHitEntities(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x01) != 0;
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
    
    public static InteractionSyncData toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static InteractionSyncData toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one InteractionSyncData and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static InteractionSyncData toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 165;
        var varPos = 0;
        java.util.Map<InteractionType, Integer> v12 = null;
        if (hasForkCounts(mem, offset)) {
            requireSlot(mem, offset + 157, varPos, "ForkCounts");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ForkCounts");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ForkCounts", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ForkCounts", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v12 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                    off += 1;
                var value = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                if (v12.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("ForkCounts", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 157, -1, "ForkCounts");
        }
        
        SelectedHitEntity[] v15 = null;
        if (hasHitEntities(mem, offset)) {
            requireSlot(mem, offset + 161, varPos, "HitEntities");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("HitEntities");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("HitEntities", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 53 > mem.byteSize()) throw ProtocolException.bufferTooSmall("HitEntities", (int) java.lang.Math.min(off + lenOffset + (long) len * 53, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v15 = new SelectedHitEntity[len];
            for (var i = 0; i < len; i++) {
                v15[i] = SelectedHitEntity.toObject(mem, off + i * 53);
            }
            varPos = off + len * 53 - varBase;
        } else {
            requireSlot(mem, offset + 161, -1, "HitEntities");
        }
        var result = new InteractionSyncData(
            InteractionState.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2)),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 3), "Progress"),
            mem.get(PacketIO.PROTO_INT, offset + 7),
            mem.get(PacketIO.PROTO_INT, offset + 11),
            mem.get(PacketIO.PROTO_INT, offset + 15),
            mem.get(PacketIO.PROTO_INT, offset + 19),
            mem.get(PacketIO.PROTO_INT, offset + 23),
            hasBlockPosition(mem, offset) ? BlockPosition.toObject(mem, offset + 27) : null,
            BlockFace.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 39)),
            hasBlockRotation(mem, offset) ? BlockRotation.toObject(mem, offset + 40) : null,
            mem.get(PacketIO.PROTO_INT, offset + 43),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 47), "ChargeValue"),
            v12,
            mem.get(PacketIO.PROTO_INT, offset + 51),
            mem.get(PacketIO.PROTO_INT, offset + 55),
            v15,
            hasAttackerPos(mem, offset) ? Position.toObject(mem, offset + 59) : null,
            hasAttackerRot(mem, offset) ? Direction.toObject(mem, offset + 83) : null,
            hasRaycastHit(mem, offset) ? Position.toObject(mem, offset + 95) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 119), "RaycastDistance"),
            hasRaycastNormal(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 123), "RaycastNormal") : null,
            MovementDirection.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 135)),
            ApplyForceState.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 136)),
            mem.get(PacketIO.PROTO_INT, offset + 137),
            hasGeneratedUUID(mem, offset) ? PacketIO.readUUID(mem, offset + 141) : null
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.blockPosition != null) nullBits |= 0x01;
        if (this.blockRotation != null) nullBits |= 0x02;
        if (this.attackerPos != null) nullBits |= 0x04;
        if (this.attackerRot != null) nullBits |= 0x08;
        if (this.raycastHit != null) nullBits |= 0x10;
        if (this.raycastNormal != null) nullBits |= 0x20;
        if (this.generatedUUID != null) nullBits |= 0x40;
        if (this.forkCounts != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        nullBits = 0;
        if (this.hitEntities != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 1, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 2, (byte) this.state.getValue());
        PacketIO.requireFinite(this.progress, "Progress"); mem.set(PacketIO.PROTO_FLOAT, offset + 3, this.progress);
        mem.set(PacketIO.PROTO_INT, offset + 7, this.operationCounter);
        mem.set(PacketIO.PROTO_INT, offset + 11, this.rootInteraction);
        mem.set(PacketIO.PROTO_INT, offset + 15, this.totalForks);
        mem.set(PacketIO.PROTO_INT, offset + 19, this.entityId);
        mem.set(PacketIO.PROTO_INT, offset + 23, this.enteredRootInteraction);
        if (this.blockPosition != null) {
            this.blockPosition.serialize(mem, offset + 27);
        } else {
            mem.asSlice(offset + 27, 12).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BYTE, offset + 39, (byte) this.blockFace.getValue());
        if (this.blockRotation != null) {
            this.blockRotation.serialize(mem, offset + 40);
        } else {
            mem.asSlice(offset + 40, 3).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_INT, offset + 43, this.placedBlockId);
        PacketIO.requireFinite(this.chargeValue, "ChargeValue"); mem.set(PacketIO.PROTO_FLOAT, offset + 47, this.chargeValue);
        mem.set(PacketIO.PROTO_INT, offset + 51, this.chainingIndex);
        mem.set(PacketIO.PROTO_INT, offset + 55, this.flagIndex);
        if (this.attackerPos != null) {
            this.attackerPos.serialize(mem, offset + 59);
        } else {
            mem.asSlice(offset + 59, 24).fill((byte) 0); 
        }
        if (this.attackerRot != null) {
            this.attackerRot.serialize(mem, offset + 83);
        } else {
            mem.asSlice(offset + 83, 12).fill((byte) 0); 
        }
        if (this.raycastHit != null) {
            this.raycastHit.serialize(mem, offset + 95);
        } else {
            mem.asSlice(offset + 95, 24).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.raycastDistance, "RaycastDistance"); mem.set(PacketIO.PROTO_FLOAT, offset + 119, this.raycastDistance);
        if (this.raycastNormal != null) {
            PacketIO.requireFinite(this.raycastNormal, "RaycastNormal"); PacketIO.writeVector3f(mem, offset + 123, this.raycastNormal);
        } else {
            mem.asSlice(offset + 123, 12).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BYTE, offset + 135, (byte) this.movementDirection.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 136, (byte) this.applyForceState.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 137, this.nextLabel);
        if (this.generatedUUID != null) {
            PacketIO.writeUUID(mem, offset + 141, this.generatedUUID);
        } else {
            mem.asSlice(offset + 141, 16).fill((byte) 0); 
        }
        var varOffset = offset + 165;
        if (this.forkCounts != null) {
            mem.set(PacketIO.PROTO_INT, offset + 157, varOffset - offset - 165);
            if (this.forkCounts.size() > 4096000) throw ProtocolException.dictionaryTooLarge("ForkCounts", forkCounts.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.forkCounts.size());
            for (var e : this.forkCounts.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                mem.set(PacketIO.PROTO_INT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 157, -1);
        }
        if (this.hitEntities != null) {
            mem.set(PacketIO.PROTO_INT, offset + 161, varOffset - offset - 165);
            if (hitEntities.length > 4096000) throw ProtocolException.arrayTooLong("HitEntities", hitEntities.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.hitEntities.length);
            
            var hitEntitiesValueOffset = 0;
            for (var i = 0; i < this.hitEntities.length; i++) {
                hitEntitiesValueOffset += this.hitEntities[i].serialize(mem, varOffset + hitEntitiesValueOffset);
            }
            varOffset += hitEntitiesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 161, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 165;
        if (forkCounts != null) size += VarInt.size(forkCounts.size()) + forkCounts.size() * (1 + 4);
    if (hitEntities != null) size += VarInt.size(hitEntities.length) + hitEntities.length * 53;

        return size;
    }

    public InteractionSyncData clone() {
        InteractionSyncData copy = new InteractionSyncData();
        copy.state = this.state;
        copy.progress = this.progress;
        copy.operationCounter = this.operationCounter;
        copy.rootInteraction = this.rootInteraction;
        copy.totalForks = this.totalForks;
        copy.entityId = this.entityId;
        copy.enteredRootInteraction = this.enteredRootInteraction;
        copy.blockPosition = this.blockPosition != null ? this.blockPosition.clone() : null;
        copy.blockFace = this.blockFace;
        copy.blockRotation = this.blockRotation != null ? this.blockRotation.clone() : null;
        copy.placedBlockId = this.placedBlockId;
        copy.chargeValue = this.chargeValue;
        copy.forkCounts = this.forkCounts != null ? new java.util.HashMap<>(this.forkCounts) : null;
        copy.chainingIndex = this.chainingIndex;
        copy.flagIndex = this.flagIndex;
        copy.hitEntities = this.hitEntities != null ? java.util.Arrays.stream(this.hitEntities).map(e -> e.clone()).toArray(SelectedHitEntity[]::new) : null;
        copy.attackerPos = this.attackerPos != null ? this.attackerPos.clone() : null;
        copy.attackerRot = this.attackerRot != null ? this.attackerRot.clone() : null;
        copy.raycastHit = this.raycastHit != null ? this.raycastHit.clone() : null;
        copy.raycastDistance = this.raycastDistance;
        copy.raycastNormal = this.raycastNormal;
        copy.movementDirection = this.movementDirection;
        copy.applyForceState = this.applyForceState;
        copy.nextLabel = this.nextLabel;
        copy.generatedUUID = this.generatedUUID;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InteractionSyncData other)) return false;
        return java.util.Objects.equals(this.state, other.state) && this.progress == other.progress && this.operationCounter == other.operationCounter && this.rootInteraction == other.rootInteraction && this.totalForks == other.totalForks && this.entityId == other.entityId && this.enteredRootInteraction == other.enteredRootInteraction && java.util.Objects.equals(this.blockPosition, other.blockPosition) && java.util.Objects.equals(this.blockFace, other.blockFace) && java.util.Objects.equals(this.blockRotation, other.blockRotation) && this.placedBlockId == other.placedBlockId && this.chargeValue == other.chargeValue && java.util.Objects.equals(this.forkCounts, other.forkCounts) && this.chainingIndex == other.chainingIndex && this.flagIndex == other.flagIndex && java.util.Arrays.equals(this.hitEntities, other.hitEntities) && java.util.Objects.equals(this.attackerPos, other.attackerPos) && java.util.Objects.equals(this.attackerRot, other.attackerRot) && java.util.Objects.equals(this.raycastHit, other.raycastHit) && this.raycastDistance == other.raycastDistance && java.util.Objects.equals(this.raycastNormal, other.raycastNormal) && java.util.Objects.equals(this.movementDirection, other.movementDirection) && java.util.Objects.equals(this.applyForceState, other.applyForceState) && this.nextLabel == other.nextLabel && java.util.Objects.equals(this.generatedUUID, other.generatedUUID);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(state);
        result = 31 * result + Float.hashCode(progress);
        result = 31 * result + Integer.hashCode(operationCounter);
        result = 31 * result + Integer.hashCode(rootInteraction);
        result = 31 * result + Integer.hashCode(totalForks);
        result = 31 * result + Integer.hashCode(entityId);
        result = 31 * result + Integer.hashCode(enteredRootInteraction);
        result = 31 * result + java.util.Objects.hashCode(blockPosition);
        result = 31 * result + java.util.Objects.hashCode(blockFace);
        result = 31 * result + java.util.Objects.hashCode(blockRotation);
        result = 31 * result + Integer.hashCode(placedBlockId);
        result = 31 * result + Float.hashCode(chargeValue);
        result = 31 * result + java.util.Objects.hashCode(forkCounts);
        result = 31 * result + Integer.hashCode(chainingIndex);
        result = 31 * result + Integer.hashCode(flagIndex);
        result = 31 * result + java.util.Arrays.hashCode(hitEntities);
        result = 31 * result + java.util.Objects.hashCode(attackerPos);
        result = 31 * result + java.util.Objects.hashCode(attackerRot);
        result = 31 * result + java.util.Objects.hashCode(raycastHit);
        result = 31 * result + Float.hashCode(raycastDistance);
        result = 31 * result + java.util.Objects.hashCode(raycastNormal);
        result = 31 * result + java.util.Objects.hashCode(movementDirection);
        result = 31 * result + java.util.Objects.hashCode(applyForceState);
        result = 31 * result + Integer.hashCode(nextLabel);
        result = 31 * result + java.util.Objects.hashCode(generatedUUID);
        return result;
    }

}