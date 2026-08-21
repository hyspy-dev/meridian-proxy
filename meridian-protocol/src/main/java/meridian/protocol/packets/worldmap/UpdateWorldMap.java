// Auto-generated - do not edit
package meridian.protocol.packets.worldmap;

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


public class UpdateWorldMap implements Packet, ToClientPacket {
    public static final int PACKET_ID = 241;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.WorldMap;
    }

    @Nullable public MapChunk[] chunks;
    @Nullable public MapMarker[] addedMarkers;
    @Nullable public String[] removedMarkers;

    public UpdateWorldMap() {
    }

    public UpdateWorldMap(@Nullable MapChunk[] chunks, @Nullable MapMarker[] addedMarkers, @Nullable String[] removedMarkers) {
        this.chunks = chunks;
        this.addedMarkers = addedMarkers;
        this.removedMarkers = removedMarkers;
    }

    public UpdateWorldMap(@Nonnull UpdateWorldMap other) {
        this.chunks = other.chunks;
        this.addedMarkers = other.addedMarkers;
        this.removedMarkers = other.removedMarkers;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateWorldMap", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateWorldMap", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static MapChunk[] getChunks(MemorySegment mem) {
        return getChunks(mem, 0);
    }
    
    @Nullable
    public static MapChunk[] getChunks(MemorySegment mem, int offset) {
        if (!hasChunks(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 1, 13, "Chunks");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Chunks");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Chunks", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 9 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Chunks", (int) java.lang.Math.min(off + lenOffset + (long) len * 9, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new MapChunk[len];
        for (var i = 0; i < len; i++) {
            data[i] = MapChunk.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static MapMarker[] getAddedMarkers(MemorySegment mem) {
        return getAddedMarkers(mem, 0);
    }
    
    @Nullable
    public static MapMarker[] getAddedMarkers(MemorySegment mem, int offset) {
        if (!hasAddedMarkers(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 5, 13, "AddedMarkers");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("AddedMarkers");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("AddedMarkers", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 58 > mem.byteSize()) throw ProtocolException.bufferTooSmall("AddedMarkers", (int) java.lang.Math.min(off + lenOffset + (long) len * 58, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new MapMarker[len];
        for (var i = 0; i < len; i++) {
            data[i] = MapMarker.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static String[] getRemovedMarkers(MemorySegment mem) {
        return getRemovedMarkers(mem, 0);
    }
    
    @Nullable
    public static String[] getRemovedMarkers(MemorySegment mem, int offset) {
        if (!hasRemovedMarkers(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 9, 13, "RemovedMarkers");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("RemovedMarkers");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("RemovedMarkers", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("RemovedMarkers", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("RemovedMarkers", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    public static boolean hasChunks(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasAddedMarkers(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasRemovedMarkers(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
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
    
    public static UpdateWorldMap toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateWorldMap toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateWorldMap and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateWorldMap toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 13;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        MapChunk[] v0 = null;
        if (hasChunks(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "Chunks");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Chunks");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Chunks", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 9 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Chunks", (int) java.lang.Math.min(off + lenOffset + (long) len * 9, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new MapChunk[len];
            for (var i = 0; i < len; i++) {
                v0[i] = MapChunk.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 1, -1, "Chunks");
        }
        
        MapMarker[] v1 = null;
        if (hasAddedMarkers(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "AddedMarkers");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("AddedMarkers");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("AddedMarkers", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 58 > mem.byteSize()) throw ProtocolException.bufferTooSmall("AddedMarkers", (int) java.lang.Math.min(off + lenOffset + (long) len * 58, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new MapMarker[len];
            for (var i = 0; i < len; i++) {
                v1[i] = MapMarker.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "AddedMarkers");
        }
        
        String[] v2 = null;
        if (hasRemovedMarkers(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "RemovedMarkers");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("RemovedMarkers");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("RemovedMarkers", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("RemovedMarkers", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v2[i] = PacketIO.readVarString("RemovedMarkers", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 9, -1, "RemovedMarkers");
        }
        var result = new UpdateWorldMap(
            v0,
            v1,
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.chunks != null) nullBits |= 0x01;
        if (this.addedMarkers != null) nullBits |= 0x02;
        if (this.removedMarkers != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 13;
        if (this.chunks != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 13);
            if (chunks.length > 4096000) throw ProtocolException.arrayTooLong("Chunks", chunks.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.chunks.length);
            
            var chunksValueOffset = 0;
            for (var i = 0; i < this.chunks.length; i++) {
                chunksValueOffset += this.chunks[i].serialize(mem, varOffset + chunksValueOffset);
            }
            varOffset += chunksValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.addedMarkers != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 13);
            if (addedMarkers.length > 4096000) throw ProtocolException.arrayTooLong("AddedMarkers", addedMarkers.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.addedMarkers.length);
            
            var addedMarkersValueOffset = 0;
            for (var i = 0; i < this.addedMarkers.length; i++) {
                addedMarkersValueOffset += this.addedMarkers[i].serialize(mem, varOffset + addedMarkersValueOffset);
            }
            varOffset += addedMarkersValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.removedMarkers != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 13);
            if (removedMarkers.length > 4096000) throw ProtocolException.arrayTooLong("RemovedMarkers", removedMarkers.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.removedMarkers.length);
            
            var removedMarkersValueOffset = 0;
            for (var i = 0; i < this.removedMarkers.length; i++) {
                removedMarkersValueOffset += PacketIO.writeVarString(mem, varOffset + removedMarkersValueOffset, this.removedMarkers[i], 4096000);
            }
            varOffset += removedMarkersValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 13;
        if (chunks != null) {
        int chunksSize = 0;
for (var elem : chunks) chunksSize += elem.computeSize();
size += VarInt.size(chunks.length) + chunksSize;
    }
    if (addedMarkers != null) {
        int addedMarkersSize = 0;
for (var elem : addedMarkers) addedMarkersSize += elem.computeSize();
size += VarInt.size(addedMarkers.length) + addedMarkersSize;
    }
    if (removedMarkers != null) {
        int removedMarkersSize = 0;
for (var elem : removedMarkers) removedMarkersSize += PacketIO.stringSize(elem);
size += VarInt.size(removedMarkers.length) + removedMarkersSize;
    }

        return size;
    }

    public UpdateWorldMap clone() {
        UpdateWorldMap copy = new UpdateWorldMap();
        copy.chunks = this.chunks != null ? java.util.Arrays.stream(this.chunks).map(e -> e.clone()).toArray(MapChunk[]::new) : null;
        copy.addedMarkers = this.addedMarkers != null ? java.util.Arrays.stream(this.addedMarkers).map(e -> e.clone()).toArray(MapMarker[]::new) : null;
        copy.removedMarkers = this.removedMarkers != null ? java.util.Arrays.copyOf(this.removedMarkers, this.removedMarkers.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateWorldMap other)) return false;
        return java.util.Arrays.equals(this.chunks, other.chunks) && java.util.Arrays.equals(this.addedMarkers, other.addedMarkers) && java.util.Arrays.equals(this.removedMarkers, other.removedMarkers);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(chunks);
        result = 31 * result + java.util.Arrays.hashCode(addedMarkers);
        result = 31 * result + java.util.Arrays.hashCode(removedMarkers);
        return result;
    }

}