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


public class ConnectedBlockFaceTags {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 6;
    public static final int VARIABLE_BLOCK_START = 25;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String[] north;
    @Nullable public String[] east;
    @Nullable public String[] south;
    @Nullable public String[] west;
    @Nullable public String[] up;
    @Nullable public String[] down;

    public ConnectedBlockFaceTags() {
    }

    public ConnectedBlockFaceTags(@Nullable String[] north, @Nullable String[] east, @Nullable String[] south, @Nullable String[] west, @Nullable String[] up, @Nullable String[] down) {
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
        this.up = up;
        this.down = down;
    }

    public ConnectedBlockFaceTags(@Nonnull ConnectedBlockFaceTags other) {
        this.north = other.north;
        this.east = other.east;
        this.south = other.south;
        this.west = other.west;
        this.up = other.up;
        this.down = other.down;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ConnectedBlockFaceTags", offset, (int) mem.byteSize());
        long needed = (long) offset + 25;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ConnectedBlockFaceTags", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String[] getNorth(MemorySegment mem) {
        return getNorth(mem, 0);
    }
    
    @Nullable
    public static String[] getNorth(MemorySegment mem, int offset) {
        if (!hasNorth(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 1, 25, "North");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("North");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("North", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("North", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("North", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    @Nullable
    public static String[] getEast(MemorySegment mem) {
        return getEast(mem, 0);
    }
    
    @Nullable
    public static String[] getEast(MemorySegment mem, int offset) {
        if (!hasEast(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 5, 25, "East");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("East");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("East", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("East", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("East", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    @Nullable
    public static String[] getSouth(MemorySegment mem) {
        return getSouth(mem, 0);
    }
    
    @Nullable
    public static String[] getSouth(MemorySegment mem, int offset) {
        if (!hasSouth(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 9, 25, "South");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("South");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("South", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("South", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("South", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    @Nullable
    public static String[] getWest(MemorySegment mem) {
        return getWest(mem, 0);
    }
    
    @Nullable
    public static String[] getWest(MemorySegment mem, int offset) {
        if (!hasWest(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 13, 25, "West");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("West");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("West", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("West", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("West", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    @Nullable
    public static String[] getUp(MemorySegment mem) {
        return getUp(mem, 0);
    }
    
    @Nullable
    public static String[] getUp(MemorySegment mem, int offset) {
        if (!hasUp(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 17, 25, "Up");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Up");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Up", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Up", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("Up", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    @Nullable
    public static String[] getDown(MemorySegment mem) {
        return getDown(mem, 0);
    }
    
    @Nullable
    public static String[] getDown(MemorySegment mem, int offset) {
        if (!hasDown(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 21, 25, "Down");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Down");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Down", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Down", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("Down", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    public static boolean hasNorth(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasEast(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasSouth(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasWest(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasUp(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasDown(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
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
    
    public static ConnectedBlockFaceTags toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ConnectedBlockFaceTags toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ConnectedBlockFaceTags and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ConnectedBlockFaceTags toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 25;
        var varPos = 0;
        String[] v0 = null;
        if (hasNorth(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "North");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("North");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("North", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("North", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v0[i] = PacketIO.readVarString("North", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 1, -1, "North");
        }
        
        String[] v1 = null;
        if (hasEast(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "East");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("East");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("East", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("East", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v1[i] = PacketIO.readVarString("East", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "East");
        }
        
        String[] v2 = null;
        if (hasSouth(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "South");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("South");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("South", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("South", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v2[i] = PacketIO.readVarString("South", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 9, -1, "South");
        }
        
        String[] v3 = null;
        if (hasWest(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "West");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("West");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("West", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("West", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v3 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v3[i] = PacketIO.readVarString("West", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 13, -1, "West");
        }
        
        String[] v4 = null;
        if (hasUp(mem, offset)) {
            requireSlot(mem, offset + 17, varPos, "Up");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Up");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Up", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Up", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v4 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v4[i] = PacketIO.readVarString("Up", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 17, -1, "Up");
        }
        
        String[] v5 = null;
        if (hasDown(mem, offset)) {
            requireSlot(mem, offset + 21, varPos, "Down");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Down");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Down", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Down", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v5 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v5[i] = PacketIO.readVarString("Down", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 21, -1, "Down");
        }
        var result = new ConnectedBlockFaceTags(
            v0,
            v1,
            v2,
            v3,
            v4,
            v5
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.north != null) nullBits |= 0x01;
        if (this.east != null) nullBits |= 0x02;
        if (this.south != null) nullBits |= 0x04;
        if (this.west != null) nullBits |= 0x08;
        if (this.up != null) nullBits |= 0x10;
        if (this.down != null) nullBits |= 0x20;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 25;
        if (this.north != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 25);
            if (north.length > 4096000) throw ProtocolException.arrayTooLong("North", north.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.north.length);
            
            var northValueOffset = 0;
            for (var i = 0; i < this.north.length; i++) {
                northValueOffset += PacketIO.writeVarString(mem, varOffset + northValueOffset, this.north[i], 4096000);
            }
            varOffset += northValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.east != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 25);
            if (east.length > 4096000) throw ProtocolException.arrayTooLong("East", east.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.east.length);
            
            var eastValueOffset = 0;
            for (var i = 0; i < this.east.length; i++) {
                eastValueOffset += PacketIO.writeVarString(mem, varOffset + eastValueOffset, this.east[i], 4096000);
            }
            varOffset += eastValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.south != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 25);
            if (south.length > 4096000) throw ProtocolException.arrayTooLong("South", south.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.south.length);
            
            var southValueOffset = 0;
            for (var i = 0; i < this.south.length; i++) {
                southValueOffset += PacketIO.writeVarString(mem, varOffset + southValueOffset, this.south[i], 4096000);
            }
            varOffset += southValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
        if (this.west != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 25);
            if (west.length > 4096000) throw ProtocolException.arrayTooLong("West", west.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.west.length);
            
            var westValueOffset = 0;
            for (var i = 0; i < this.west.length; i++) {
                westValueOffset += PacketIO.writeVarString(mem, varOffset + westValueOffset, this.west[i], 4096000);
            }
            varOffset += westValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
        if (this.up != null) {
            mem.set(PacketIO.PROTO_INT, offset + 17, varOffset - offset - 25);
            if (up.length > 4096000) throw ProtocolException.arrayTooLong("Up", up.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.up.length);
            
            var upValueOffset = 0;
            for (var i = 0; i < this.up.length; i++) {
                upValueOffset += PacketIO.writeVarString(mem, varOffset + upValueOffset, this.up[i], 4096000);
            }
            varOffset += upValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 17, -1);
        }
        if (this.down != null) {
            mem.set(PacketIO.PROTO_INT, offset + 21, varOffset - offset - 25);
            if (down.length > 4096000) throw ProtocolException.arrayTooLong("Down", down.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.down.length);
            
            var downValueOffset = 0;
            for (var i = 0; i < this.down.length; i++) {
                downValueOffset += PacketIO.writeVarString(mem, varOffset + downValueOffset, this.down[i], 4096000);
            }
            varOffset += downValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 21, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 25;
        if (north != null) {
        int northSize = 0;
for (var elem : north) northSize += PacketIO.stringSize(elem);
size += VarInt.size(north.length) + northSize;
    }
    if (east != null) {
        int eastSize = 0;
for (var elem : east) eastSize += PacketIO.stringSize(elem);
size += VarInt.size(east.length) + eastSize;
    }
    if (south != null) {
        int southSize = 0;
for (var elem : south) southSize += PacketIO.stringSize(elem);
size += VarInt.size(south.length) + southSize;
    }
    if (west != null) {
        int westSize = 0;
for (var elem : west) westSize += PacketIO.stringSize(elem);
size += VarInt.size(west.length) + westSize;
    }
    if (up != null) {
        int upSize = 0;
for (var elem : up) upSize += PacketIO.stringSize(elem);
size += VarInt.size(up.length) + upSize;
    }
    if (down != null) {
        int downSize = 0;
for (var elem : down) downSize += PacketIO.stringSize(elem);
size += VarInt.size(down.length) + downSize;
    }

        return size;
    }

    public ConnectedBlockFaceTags clone() {
        ConnectedBlockFaceTags copy = new ConnectedBlockFaceTags();
        copy.north = this.north != null ? java.util.Arrays.copyOf(this.north, this.north.length) : null;
        copy.east = this.east != null ? java.util.Arrays.copyOf(this.east, this.east.length) : null;
        copy.south = this.south != null ? java.util.Arrays.copyOf(this.south, this.south.length) : null;
        copy.west = this.west != null ? java.util.Arrays.copyOf(this.west, this.west.length) : null;
        copy.up = this.up != null ? java.util.Arrays.copyOf(this.up, this.up.length) : null;
        copy.down = this.down != null ? java.util.Arrays.copyOf(this.down, this.down.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ConnectedBlockFaceTags other)) return false;
        return java.util.Arrays.equals(this.north, other.north) && java.util.Arrays.equals(this.east, other.east) && java.util.Arrays.equals(this.south, other.south) && java.util.Arrays.equals(this.west, other.west) && java.util.Arrays.equals(this.up, other.up) && java.util.Arrays.equals(this.down, other.down);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(north);
        result = 31 * result + java.util.Arrays.hashCode(east);
        result = 31 * result + java.util.Arrays.hashCode(south);
        result = 31 * result + java.util.Arrays.hashCode(west);
        result = 31 * result + java.util.Arrays.hashCode(up);
        result = 31 * result + java.util.Arrays.hashCode(down);
        return result;
    }

}