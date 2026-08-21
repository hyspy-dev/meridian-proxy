// Auto-generated - do not edit
package meridian.protocol.packets.world;

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


public class SetChunk implements Packet, ToClientPacket {
    public static final int PACKET_ID = 131;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 13;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 25;
    public static final int MAX_SIZE = 12288040;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Chunks;
    }

    public int x;
    public int y;
    public int z;
    @Nullable public byte[] localLight;
    @Nullable public byte[] globalLight;
    @Nullable public byte[] data;

    public SetChunk() {
    }

    public SetChunk(int x, int y, int z, @Nullable byte[] localLight, @Nullable byte[] globalLight, @Nullable byte[] data) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.localLight = localLight;
        this.globalLight = globalLight;
        this.data = data;
    }

    public SetChunk(@Nonnull SetChunk other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
        this.localLight = other.localLight;
        this.globalLight = other.globalLight;
        this.data = other.data;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SetChunk", offset, (int) mem.byteSize());
        long needed = (long) offset + 25;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SetChunk", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getX(MemorySegment mem) {
        return getX(mem, 0);
    }
    
    public static int getX(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getY(MemorySegment mem) {
        return getY(mem, 0);
    }
    
    public static int getY(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static int getZ(MemorySegment mem) {
        return getZ(mem, 0);
    }
    
    public static int getZ(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 9);
    }
    
    @Nullable
    public static byte[] getLocalLight(MemorySegment mem) {
        return getLocalLight(mem, 0);
    }
    
    @Nullable
    public static byte[] getLocalLight(MemorySegment mem, int offset) {
        if (!hasLocalLight(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 13, 25, "LocalLight");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("LocalLight");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("LocalLight", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("LocalLight", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new byte[len];
        MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, data, 0, len);
        return data;
    }
    
    @Nullable
    public static byte[] getGlobalLight(MemorySegment mem) {
        return getGlobalLight(mem, 0);
    }
    
    @Nullable
    public static byte[] getGlobalLight(MemorySegment mem, int offset) {
        if (!hasGlobalLight(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 17, 25, "GlobalLight");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("GlobalLight");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("GlobalLight", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("GlobalLight", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new byte[len];
        MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, data, 0, len);
        return data;
    }
    
    @Nullable
    public static byte[] getData(MemorySegment mem) {
        return getData(mem, 0);
    }
    
    @Nullable
    public static byte[] getData(MemorySegment mem, int offset) {
        if (!hasData(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 21, 25, "Data");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Data");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Data", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Data", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new byte[len];
        MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, data, 0, len);
        return data;
    }
    
    public static boolean hasLocalLight(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasGlobalLight(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasData(MemorySegment mem, int offset) {
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
    
    public static SetChunk toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SetChunk toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SetChunk and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SetChunk toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 25;
        var varPos = 0;
        byte[] v3 = null;
        if (hasLocalLight(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "LocalLight");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("LocalLight");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("LocalLight", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("LocalLight", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v3 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v3, 0, len);
            varPos = off + len - varBase;
        } else {
            requireSlot(mem, offset + 13, -1, "LocalLight");
        }
        
        byte[] v4 = null;
        if (hasGlobalLight(mem, offset)) {
            requireSlot(mem, offset + 17, varPos, "GlobalLight");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("GlobalLight");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("GlobalLight", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("GlobalLight", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v4 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v4, 0, len);
            varPos = off + len - varBase;
        } else {
            requireSlot(mem, offset + 17, -1, "GlobalLight");
        }
        
        byte[] v5 = null;
        if (hasData(mem, offset)) {
            requireSlot(mem, offset + 21, varPos, "Data");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Data");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Data", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Data", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v5 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v5, 0, len);
            varPos = off + len - varBase;
        } else {
            requireSlot(mem, offset + 21, -1, "Data");
        }
        var result = new SetChunk(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            mem.get(PacketIO.PROTO_INT, offset + 9),
            v3,
            v4,
            v5
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.localLight != null) nullBits |= 0x01;
        if (this.globalLight != null) nullBits |= 0x02;
        if (this.data != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.x);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.y);
        mem.set(PacketIO.PROTO_INT, offset + 9, this.z);
        var varOffset = offset + 25;
        if (this.localLight != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 25);
            if (localLight.length > 4096000) throw ProtocolException.arrayTooLong("LocalLight", localLight.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.localLight.length);
            
            MemorySegment.copy(this.localLight, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.localLight.length);
            varOffset += this.localLight.length * 1;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
        if (this.globalLight != null) {
            mem.set(PacketIO.PROTO_INT, offset + 17, varOffset - offset - 25);
            if (globalLight.length > 4096000) throw ProtocolException.arrayTooLong("GlobalLight", globalLight.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.globalLight.length);
            
            MemorySegment.copy(this.globalLight, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.globalLight.length);
            varOffset += this.globalLight.length * 1;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 17, -1);
        }
        if (this.data != null) {
            mem.set(PacketIO.PROTO_INT, offset + 21, varOffset - offset - 25);
            if (data.length > 4096000) throw ProtocolException.arrayTooLong("Data", data.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.data.length);
            
            MemorySegment.copy(this.data, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.data.length);
            varOffset += this.data.length * 1;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 21, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 25;
        if (localLight != null) size += VarInt.size(localLight.length) + localLight.length * 1;
    if (globalLight != null) size += VarInt.size(globalLight.length) + globalLight.length * 1;
    if (data != null) size += VarInt.size(data.length) + data.length * 1;

        return size;
    }

    public SetChunk clone() {
        SetChunk copy = new SetChunk();
        copy.x = this.x;
        copy.y = this.y;
        copy.z = this.z;
        copy.localLight = this.localLight != null ? java.util.Arrays.copyOf(this.localLight, this.localLight.length) : null;
        copy.globalLight = this.globalLight != null ? java.util.Arrays.copyOf(this.globalLight, this.globalLight.length) : null;
        copy.data = this.data != null ? java.util.Arrays.copyOf(this.data, this.data.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SetChunk other)) return false;
        return this.x == other.x && this.y == other.y && this.z == other.z && java.util.Arrays.equals(this.localLight, other.localLight) && java.util.Arrays.equals(this.globalLight, other.globalLight) && java.util.Arrays.equals(this.data, other.data);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(x);
        result = 31 * result + Integer.hashCode(y);
        result = 31 * result + Integer.hashCode(z);
        result = 31 * result + java.util.Arrays.hashCode(localLight);
        result = 31 * result + java.util.Arrays.hashCode(globalLight);
        result = 31 * result + java.util.Arrays.hashCode(data);
        return result;
    }

}