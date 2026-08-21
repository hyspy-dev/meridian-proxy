// Auto-generated - do not edit
package meridian.protocol.packets.buildertools;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.NetworkChannel;
import meridian.protocol.Packet;
import meridian.protocol.ToServerPacket;
import meridian.protocol.ToClientPacket;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import meridian.protocol.BlockPosition;

public class BuilderToolStackArea implements Packet, ToServerPacket {
    public static final int PACKET_ID = 404;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 41;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 41;
    public static final int MAX_SIZE = 41;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public BlockPosition selectionMin;
    @Nullable public BlockPosition selectionMax;
    public int xNormal;
    public int yNormal;
    public int zNormal;
    public int numStacks;

    public BuilderToolStackArea() {
    }

    public BuilderToolStackArea(@Nullable BlockPosition selectionMin, @Nullable BlockPosition selectionMax, int xNormal, int yNormal, int zNormal, int numStacks) {
        this.selectionMin = selectionMin;
        this.selectionMax = selectionMax;
        this.xNormal = xNormal;
        this.yNormal = yNormal;
        this.zNormal = zNormal;
        this.numStacks = numStacks;
    }

    public BuilderToolStackArea(@Nonnull BuilderToolStackArea other) {
        this.selectionMin = other.selectionMin;
        this.selectionMax = other.selectionMax;
        this.xNormal = other.xNormal;
        this.yNormal = other.yNormal;
        this.zNormal = other.zNormal;
        this.numStacks = other.numStacks;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolStackArea", offset, (int) mem.byteSize());
        long needed = (long) offset + 41;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolStackArea", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static BlockPosition getSelectionMin(MemorySegment mem) {
        return getSelectionMin(mem, 0);
    }
    
    @Nullable
    public static BlockPosition getSelectionMin(MemorySegment mem, int offset) {
        return hasSelectionMin(mem, offset) ? BlockPosition.toObject(mem, offset + 1): null;
    }
    
    @Nullable
    public static BlockPosition getSelectionMax(MemorySegment mem) {
        return getSelectionMax(mem, 0);
    }
    
    @Nullable
    public static BlockPosition getSelectionMax(MemorySegment mem, int offset) {
        return hasSelectionMax(mem, offset) ? BlockPosition.toObject(mem, offset + 13): null;
    }
    
    public static int getXNormal(MemorySegment mem) {
        return getXNormal(mem, 0);
    }
    
    public static int getXNormal(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 25);
    }
    
    public static int getYNormal(MemorySegment mem) {
        return getYNormal(mem, 0);
    }
    
    public static int getYNormal(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 29);
    }
    
    public static int getZNormal(MemorySegment mem) {
        return getZNormal(mem, 0);
    }
    
    public static int getZNormal(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 33);
    }
    
    public static int getNumStacks(MemorySegment mem) {
        return getNumStacks(mem, 0);
    }
    
    public static int getNumStacks(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 37);
    }
    
    public static boolean hasSelectionMin(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasSelectionMax(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    
    
    public static BuilderToolStackArea toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolStackArea toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolStackArea and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolStackArea toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BuilderToolStackArea(
            hasSelectionMin(mem, offset) ? BlockPosition.toObject(mem, offset + 1) : null,
            hasSelectionMax(mem, offset) ? BlockPosition.toObject(mem, offset + 13) : null,
            mem.get(PacketIO.PROTO_INT, offset + 25),
            mem.get(PacketIO.PROTO_INT, offset + 29),
            mem.get(PacketIO.PROTO_INT, offset + 33),
            mem.get(PacketIO.PROTO_INT, offset + 37)
        );
        if (cursor != null) cursor.position = offset + 41;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.selectionMin != null) nullBits |= 0x01;
        if (this.selectionMax != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.selectionMin != null) {
            this.selectionMin.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 12).fill((byte) 0); 
        }
        if (this.selectionMax != null) {
            this.selectionMax.serialize(mem, offset + 13);
        } else {
            mem.asSlice(offset + 13, 12).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_INT, offset + 25, this.xNormal);
        mem.set(PacketIO.PROTO_INT, offset + 29, this.yNormal);
        mem.set(PacketIO.PROTO_INT, offset + 33, this.zNormal);
        mem.set(PacketIO.PROTO_INT, offset + 37, this.numStacks);
        
        
    
       return 41;
    }
    public int computeSize() {
        return 41;
    }

    public BuilderToolStackArea clone() {
        BuilderToolStackArea copy = new BuilderToolStackArea();
        copy.selectionMin = this.selectionMin != null ? this.selectionMin.clone() : null;
        copy.selectionMax = this.selectionMax != null ? this.selectionMax.clone() : null;
        copy.xNormal = this.xNormal;
        copy.yNormal = this.yNormal;
        copy.zNormal = this.zNormal;
        copy.numStacks = this.numStacks;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolStackArea other)) return false;
        return java.util.Objects.equals(this.selectionMin, other.selectionMin) && java.util.Objects.equals(this.selectionMax, other.selectionMax) && this.xNormal == other.xNormal && this.yNormal == other.yNormal && this.zNormal == other.zNormal && this.numStacks == other.numStacks;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(selectionMin, selectionMax, xNormal, yNormal, zNormal, numStacks);
    }

}