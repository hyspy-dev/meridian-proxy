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
import org.joml.*;

public class SelectedHitEntity {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 53;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 53;
    public static final int MAX_SIZE = 53;

    public int networkId;
    @Nullable public Vector3fc hitLocation;
    @Nullable public Position position;
    @Nullable public Direction bodyRotation;

    public SelectedHitEntity() {
    }

    public SelectedHitEntity(int networkId, @Nullable Vector3fc hitLocation, @Nullable Position position, @Nullable Direction bodyRotation) {
        this.networkId = networkId;
        this.hitLocation = hitLocation;
        this.position = position;
        this.bodyRotation = bodyRotation;
    }

    public SelectedHitEntity(@Nonnull SelectedHitEntity other) {
        this.networkId = other.networkId;
        this.hitLocation = other.hitLocation;
        this.position = other.position;
        this.bodyRotation = other.bodyRotation;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SelectedHitEntity", offset, (int) mem.byteSize());
        long needed = (long) offset + 53;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SelectedHitEntity", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getNetworkId(MemorySegment mem) {
        return getNetworkId(mem, 0);
    }
    
    public static int getNetworkId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static Vector3fc getHitLocation(MemorySegment mem) {
        return getHitLocation(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getHitLocation(MemorySegment mem, int offset) {
        return hasHitLocation(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 5), "HitLocation"): null;
    }
    
    @Nullable
    public static Position getPosition(MemorySegment mem) {
        return getPosition(mem, 0);
    }
    
    @Nullable
    public static Position getPosition(MemorySegment mem, int offset) {
        return hasPosition(mem, offset) ? Position.toObject(mem, offset + 17): null;
    }
    
    @Nullable
    public static Direction getBodyRotation(MemorySegment mem) {
        return getBodyRotation(mem, 0);
    }
    
    @Nullable
    public static Direction getBodyRotation(MemorySegment mem, int offset) {
        return hasBodyRotation(mem, offset) ? Direction.toObject(mem, offset + 41): null;
    }
    
    public static boolean hasHitLocation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasPosition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasBodyRotation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    
    
    public static SelectedHitEntity toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SelectedHitEntity toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SelectedHitEntity and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SelectedHitEntity toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new SelectedHitEntity(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            hasHitLocation(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 5), "HitLocation") : null,
            hasPosition(mem, offset) ? Position.toObject(mem, offset + 17) : null,
            hasBodyRotation(mem, offset) ? Direction.toObject(mem, offset + 41) : null
        );
        if (cursor != null) cursor.position = offset + 53;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.hitLocation != null) nullBits |= 0x01;
        if (this.position != null) nullBits |= 0x02;
        if (this.bodyRotation != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.networkId);
        if (this.hitLocation != null) {
            PacketIO.requireFinite(this.hitLocation, "HitLocation"); PacketIO.writeVector3f(mem, offset + 5, this.hitLocation);
        } else {
            mem.asSlice(offset + 5, 12).fill((byte) 0); 
        }
        if (this.position != null) {
            this.position.serialize(mem, offset + 17);
        } else {
            mem.asSlice(offset + 17, 24).fill((byte) 0); 
        }
        if (this.bodyRotation != null) {
            this.bodyRotation.serialize(mem, offset + 41);
        } else {
            mem.asSlice(offset + 41, 12).fill((byte) 0); 
        }
        
        
    
       return 53;
    }
    public int computeSize() {
        return 53;
    }

    public SelectedHitEntity clone() {
        SelectedHitEntity copy = new SelectedHitEntity();
        copy.networkId = this.networkId;
        copy.hitLocation = this.hitLocation;
        copy.position = this.position != null ? this.position.clone() : null;
        copy.bodyRotation = this.bodyRotation != null ? this.bodyRotation.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SelectedHitEntity other)) return false;
        return this.networkId == other.networkId && java.util.Objects.equals(this.hitLocation, other.hitLocation) && java.util.Objects.equals(this.position, other.position) && java.util.Objects.equals(this.bodyRotation, other.bodyRotation);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(networkId, hitLocation, position, bodyRotation);
    }

}