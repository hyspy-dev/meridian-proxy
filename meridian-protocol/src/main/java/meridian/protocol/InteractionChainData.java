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
import java.util.UUID;
import org.joml.*;

public class InteractionChainData {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 61;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 61;
    public static final int MAX_SIZE = 16384066;

    public int entityId = -1;
    @Nonnull public java.util.UUID proxyId = new java.util.UUID(0L, 0L);
    @Nullable public Vector3fc hitLocation;
    @Nullable public String hitDetail;
    @Nullable public BlockPosition blockPosition;
    public int targetSlot = Integer.MIN_VALUE;
    @Nullable public Vector3fc hitNormal;

    public InteractionChainData() {
    }

    public InteractionChainData(int entityId, @Nonnull java.util.UUID proxyId, @Nullable Vector3fc hitLocation, @Nullable String hitDetail, @Nullable BlockPosition blockPosition, int targetSlot, @Nullable Vector3fc hitNormal) {
        this.entityId = entityId;
        this.proxyId = proxyId;
        this.hitLocation = hitLocation;
        this.hitDetail = hitDetail;
        this.blockPosition = blockPosition;
        this.targetSlot = targetSlot;
        this.hitNormal = hitNormal;
    }

    public InteractionChainData(@Nonnull InteractionChainData other) {
        this.entityId = other.entityId;
        this.proxyId = other.proxyId;
        this.hitLocation = other.hitLocation;
        this.hitDetail = other.hitDetail;
        this.blockPosition = other.blockPosition;
        this.targetSlot = other.targetSlot;
        this.hitNormal = other.hitNormal;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("InteractionChainData", offset, (int) mem.byteSize());
        long needed = (long) offset + 61;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InteractionChainData", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getEntityId(MemorySegment mem) {
        return getEntityId(mem, 0);
    }
    
    public static int getEntityId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static java.util.UUID getProxyId(MemorySegment mem) {
        return getProxyId(mem, 0);
    }
    
    public static java.util.UUID getProxyId(MemorySegment mem, int offset) {
        return PacketIO.readUUID(mem, offset + 5);
    }
    
    @Nullable
    public static Vector3fc getHitLocation(MemorySegment mem) {
        return getHitLocation(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getHitLocation(MemorySegment mem, int offset) {
        return hasHitLocation(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 21), "HitLocation"): null;
    }
    
    @Nullable
    public static String getHitDetail(MemorySegment mem) {
        return getHitDetail(mem, 0);
    }
    
    @Nullable
    public static String getHitDetail(MemorySegment mem, int offset) {
        return hasHitDetail(mem, offset) ? PacketIO.readVarString("HitDetail", mem, offset + 61, 4096000): null;
    }
    
    @Nullable
    public static BlockPosition getBlockPosition(MemorySegment mem) {
        return getBlockPosition(mem, 0);
    }
    
    @Nullable
    public static BlockPosition getBlockPosition(MemorySegment mem, int offset) {
        return hasBlockPosition(mem, offset) ? BlockPosition.toObject(mem, offset + 33): null;
    }
    
    public static int getTargetSlot(MemorySegment mem) {
        return getTargetSlot(mem, 0);
    }
    
    public static int getTargetSlot(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 45);
    }
    
    @Nullable
    public static Vector3fc getHitNormal(MemorySegment mem) {
        return getHitNormal(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getHitNormal(MemorySegment mem, int offset) {
        return hasHitNormal(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 49), "HitNormal"): null;
    }
    
    public static boolean hasHitLocation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasBlockPosition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasHitNormal(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasHitDetail(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    
    
    public static InteractionChainData toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static InteractionChainData toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one InteractionChainData and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static InteractionChainData toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 61;
        var varPos = 0;
        String v3 = null;
        if (hasHitDetail(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readVarString("HitDetail", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new InteractionChainData(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            PacketIO.readUUID(mem, offset + 5),
            hasHitLocation(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 21), "HitLocation") : null,
            v3,
            hasBlockPosition(mem, offset) ? BlockPosition.toObject(mem, offset + 33) : null,
            mem.get(PacketIO.PROTO_INT, offset + 45),
            hasHitNormal(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 49), "HitNormal") : null
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.hitLocation != null) nullBits |= 0x01;
        if (this.blockPosition != null) nullBits |= 0x02;
        if (this.hitNormal != null) nullBits |= 0x04;
        if (this.hitDetail != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.entityId);
        PacketIO.writeUUID(mem, offset + 5, this.proxyId);
        if (this.hitLocation != null) {
            PacketIO.requireFinite(this.hitLocation, "HitLocation"); PacketIO.writeVector3f(mem, offset + 21, this.hitLocation);
        } else {
            mem.asSlice(offset + 21, 12).fill((byte) 0); 
        }
        if (this.blockPosition != null) {
            this.blockPosition.serialize(mem, offset + 33);
        } else {
            mem.asSlice(offset + 33, 12).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_INT, offset + 45, this.targetSlot);
        if (this.hitNormal != null) {
            PacketIO.requireFinite(this.hitNormal, "HitNormal"); PacketIO.writeVector3f(mem, offset + 49, this.hitNormal);
        } else {
            mem.asSlice(offset + 49, 12).fill((byte) 0); 
        }
        var varOffset = offset + 61;
        if (this.hitDetail != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.hitDetail, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 61;
        if (hitDetail != null) size += PacketIO.stringSize(hitDetail);

        return size;
    }

    public InteractionChainData clone() {
        InteractionChainData copy = new InteractionChainData();
        copy.entityId = this.entityId;
        copy.proxyId = this.proxyId;
        copy.hitLocation = this.hitLocation;
        copy.hitDetail = this.hitDetail;
        copy.blockPosition = this.blockPosition != null ? this.blockPosition.clone() : null;
        copy.targetSlot = this.targetSlot;
        copy.hitNormal = this.hitNormal;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InteractionChainData other)) return false;
        return this.entityId == other.entityId && java.util.Objects.equals(this.proxyId, other.proxyId) && java.util.Objects.equals(this.hitLocation, other.hitLocation) && java.util.Objects.equals(this.hitDetail, other.hitDetail) && java.util.Objects.equals(this.blockPosition, other.blockPosition) && this.targetSlot == other.targetSlot && java.util.Objects.equals(this.hitNormal, other.hitNormal);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(entityId, proxyId, hitLocation, hitDetail, blockPosition, targetSlot, hitNormal);
    }

}