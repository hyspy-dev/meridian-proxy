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


public class HitboxCollisionConfig {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 6;
    public static final int MAX_SIZE = 6;

    @Nonnull public CollisionType collisionType = CollisionType.Hard;
    public float softCollisionOffsetRatio;
    public boolean rotateHitbox;
    public boolean allowEntityAnchoring;
    public boolean rotateAnchoredEntities;

    public HitboxCollisionConfig() {
    }

    public HitboxCollisionConfig(@Nonnull CollisionType collisionType, float softCollisionOffsetRatio, boolean rotateHitbox, boolean allowEntityAnchoring, boolean rotateAnchoredEntities) {
        this.collisionType = collisionType;
        this.softCollisionOffsetRatio = softCollisionOffsetRatio;
        this.rotateHitbox = rotateHitbox;
        this.allowEntityAnchoring = allowEntityAnchoring;
        this.rotateAnchoredEntities = rotateAnchoredEntities;
    }

    public HitboxCollisionConfig(@Nonnull HitboxCollisionConfig other) {
        this.collisionType = other.collisionType;
        this.softCollisionOffsetRatio = other.softCollisionOffsetRatio;
        this.rotateHitbox = other.rotateHitbox;
        this.allowEntityAnchoring = other.allowEntityAnchoring;
        this.rotateAnchoredEntities = other.rotateAnchoredEntities;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("HitboxCollisionConfig", offset, (int) mem.byteSize());
        long needed = (long) offset + 6;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("HitboxCollisionConfig", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static CollisionType getCollisionType(MemorySegment mem) {
        return getCollisionType(mem, 0);
    }
    
    public static CollisionType getCollisionType(MemorySegment mem, int offset) {
        return CollisionType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0));
    }
    
    public static float getSoftCollisionOffsetRatio(MemorySegment mem) {
        return getSoftCollisionOffsetRatio(mem, 0);
    }
    
    public static float getSoftCollisionOffsetRatio(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "SoftCollisionOffsetRatio");
    }
    
    public static boolean getRotateHitbox(MemorySegment mem) {
        return getRotateHitbox(mem, 0);
    }
    
    public static boolean getRotateHitbox(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 5) & 0x01) != 0;
    }
    
    public static boolean getAllowEntityAnchoring(MemorySegment mem) {
        return getAllowEntityAnchoring(mem, 0);
    }
    
    public static boolean getAllowEntityAnchoring(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 5) & 0x02) != 0;
    }
    
    public static boolean getRotateAnchoredEntities(MemorySegment mem) {
        return getRotateAnchoredEntities(mem, 0);
    }
    
    public static boolean getRotateAnchoredEntities(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 5) & 0x04) != 0;
    }
    
    
    
    
    
    public static HitboxCollisionConfig toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static HitboxCollisionConfig toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one HitboxCollisionConfig and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static HitboxCollisionConfig toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new HitboxCollisionConfig(
            CollisionType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0)),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "SoftCollisionOffsetRatio"),
            (mem.get(PacketIO.PROTO_BYTE, offset + 5) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 5) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 5) & 0x04) != 0
        );
        if (cursor != null) cursor.position = offset + 6;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, (byte) this.collisionType.getValue());
        PacketIO.requireFinite(this.softCollisionOffsetRatio, "SoftCollisionOffsetRatio"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.softCollisionOffsetRatio);
        byte boolBits0_0 = 0;
        if (this.rotateHitbox) boolBits0_0 |= 0x01;
        if (this.allowEntityAnchoring) boolBits0_0 |= 0x02;
        if (this.rotateAnchoredEntities) boolBits0_0 |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 5 + 0, boolBits0_0);
        
        
    
       return 6;
    }
    public int computeSize() {
        return 6;
    }

    public HitboxCollisionConfig clone() {
        HitboxCollisionConfig copy = new HitboxCollisionConfig();
        copy.collisionType = this.collisionType;
        copy.softCollisionOffsetRatio = this.softCollisionOffsetRatio;
        copy.rotateHitbox = this.rotateHitbox;
        copy.allowEntityAnchoring = this.allowEntityAnchoring;
        copy.rotateAnchoredEntities = this.rotateAnchoredEntities;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof HitboxCollisionConfig other)) return false;
        return java.util.Objects.equals(this.collisionType, other.collisionType) && this.softCollisionOffsetRatio == other.softCollisionOffsetRatio && this.rotateHitbox == other.rotateHitbox && this.allowEntityAnchoring == other.allowEntityAnchoring && this.rotateAnchoredEntities == other.rotateAnchoredEntities;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(collisionType, softCollisionOffsetRatio, rotateHitbox, allowEntityAnchoring, rotateAnchoredEntities);
    }

}