// Auto-generated - do not edit
package meridian.protocol.packets.worldmap;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class MapChunk {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 20480037;

    public int chunkX;
    public int chunkZ;
    @Nullable public MapImage image;

    public MapChunk() {
    }

    public MapChunk(int chunkX, int chunkZ, @Nullable MapImage image) {
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
        this.image = image;
    }

    public MapChunk(@Nonnull MapChunk other) {
        this.chunkX = other.chunkX;
        this.chunkZ = other.chunkZ;
        this.image = other.image;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("MapChunk", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("MapChunk", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getChunkX(MemorySegment mem) {
        return getChunkX(mem, 0);
    }
    
    public static int getChunkX(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getChunkZ(MemorySegment mem) {
        return getChunkZ(mem, 0);
    }
    
    public static int getChunkZ(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    @Nullable
    public static MapImage getImage(MemorySegment mem) {
        return getImage(mem, 0);
    }
    
    @Nullable
    public static MapImage getImage(MemorySegment mem, int offset) {
        return hasImage(mem, offset) ? MapImage.toObject(mem, offset + 9): null;
    }
    
    public static boolean hasImage(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static MapChunk toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static MapChunk toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one MapChunk and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static MapChunk toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        MapImage v2 = null;
        if (hasImage(mem, offset)) {
            v2 = MapImage.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new MapChunk(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.image != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.chunkX);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.chunkZ);
        var varOffset = offset + 9;
        if (this.image != null) {
            
            varOffset += this.image.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (image != null) size += image.computeSize();

        return size;
    }

    public MapChunk clone() {
        MapChunk copy = new MapChunk();
        copy.chunkX = this.chunkX;
        copy.chunkZ = this.chunkZ;
        copy.image = this.image != null ? this.image.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MapChunk other)) return false;
        return this.chunkX == other.chunkX && this.chunkZ == other.chunkZ && java.util.Objects.equals(this.image, other.image);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(chunkX, chunkZ, image);
    }

}