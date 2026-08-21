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

public class RaycastSelector extends Selector {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 22;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 22;
    public static final int MAX_SIZE = 22;

    @Nullable public Vector3fc offset;
    public int distance;
    public int blockTagIndex = Integer.MIN_VALUE;
    public boolean ignoreFluids;
    public boolean ignoreEmptyCollisionMaterial;

    public RaycastSelector() {
    }

    public RaycastSelector(@Nullable Vector3fc offset, int distance, int blockTagIndex, boolean ignoreFluids, boolean ignoreEmptyCollisionMaterial) {
        this.offset = offset;
        this.distance = distance;
        this.blockTagIndex = blockTagIndex;
        this.ignoreFluids = ignoreFluids;
        this.ignoreEmptyCollisionMaterial = ignoreEmptyCollisionMaterial;
    }

    public RaycastSelector(@Nonnull RaycastSelector other) {
        this.offset = other.offset;
        this.distance = other.distance;
        this.blockTagIndex = other.blockTagIndex;
        this.ignoreFluids = other.ignoreFluids;
        this.ignoreEmptyCollisionMaterial = other.ignoreEmptyCollisionMaterial;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("RaycastSelector", offset, (int) mem.byteSize());
        long needed = (long) offset + 22;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("RaycastSelector", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static Vector3fc getOffset(MemorySegment mem) {
        return getOffset(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getOffset(MemorySegment mem, int offset) {
        return hasOffset(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 1), "Offset"): null;
    }
    
    public static int getDistance(MemorySegment mem) {
        return getDistance(mem, 0);
    }
    
    public static int getDistance(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 13);
    }
    
    public static int getBlockTagIndex(MemorySegment mem) {
        return getBlockTagIndex(mem, 0);
    }
    
    public static int getBlockTagIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 17);
    }
    
    public static boolean getIgnoreFluids(MemorySegment mem) {
        return getIgnoreFluids(mem, 0);
    }
    
    public static boolean getIgnoreFluids(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 21) & 0x01) != 0;
    }
    
    public static boolean getIgnoreEmptyCollisionMaterial(MemorySegment mem) {
        return getIgnoreEmptyCollisionMaterial(mem, 0);
    }
    
    public static boolean getIgnoreEmptyCollisionMaterial(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 21) & 0x02) != 0;
    }
    
    public static boolean hasOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static RaycastSelector toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static RaycastSelector toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one RaycastSelector and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static RaycastSelector toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new RaycastSelector(
            hasOffset(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 1), "Offset") : null,
            mem.get(PacketIO.PROTO_INT, offset + 13),
            mem.get(PacketIO.PROTO_INT, offset + 17),
            (mem.get(PacketIO.PROTO_BYTE, offset + 21) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 21) & 0x02) != 0
        );
        if (cursor != null) cursor.position = offset + 22;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.offset != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.offset != null) {
            PacketIO.requireFinite(this.offset, "Offset"); PacketIO.writeVector3f(mem, offset + 1, this.offset);
        } else {
            mem.asSlice(offset + 1, 12).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_INT, offset + 13, this.distance);
        mem.set(PacketIO.PROTO_INT, offset + 17, this.blockTagIndex);
        byte boolBits0_0 = 0;
        if (this.ignoreFluids) boolBits0_0 |= 0x01;
        if (this.ignoreEmptyCollisionMaterial) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 21 + 0, boolBits0_0);
        
        
    
       return 22;
    }
    @Override
    public int computeSize() {
        return 22;
    }

    public RaycastSelector clone() {
        RaycastSelector copy = new RaycastSelector();
        copy.offset = this.offset;
        copy.distance = this.distance;
        copy.blockTagIndex = this.blockTagIndex;
        copy.ignoreFluids = this.ignoreFluids;
        copy.ignoreEmptyCollisionMaterial = this.ignoreEmptyCollisionMaterial;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RaycastSelector other)) return false;
        return java.util.Objects.equals(this.offset, other.offset) && this.distance == other.distance && this.blockTagIndex == other.blockTagIndex && this.ignoreFluids == other.ignoreFluids && this.ignoreEmptyCollisionMaterial == other.ignoreEmptyCollisionMaterial;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(offset, distance, blockTagIndex, ignoreFluids, ignoreEmptyCollisionMaterial);
    }

}