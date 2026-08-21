// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

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


public class ArgCacheInvalidation implements Packet, ToClientPacket {
    public static final int PACKET_ID = 248;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public String[] argTypeIds;

    public ArgCacheInvalidation() {
    }

    public ArgCacheInvalidation(@Nullable String[] argTypeIds) {
        this.argTypeIds = argTypeIds;
    }

    public ArgCacheInvalidation(@Nonnull ArgCacheInvalidation other) {
        this.argTypeIds = other.argTypeIds;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ArgCacheInvalidation", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ArgCacheInvalidation", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String[] getArgTypeIds(MemorySegment mem) {
        return getArgTypeIds(mem, 0);
    }
    
    @Nullable
    public static String[] getArgTypeIds(MemorySegment mem, int offset) {
        if (!hasArgTypeIds(mem, offset)) return null;
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ArgTypeIds");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("ArgTypeIds", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("ArgTypeIds", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("ArgTypeIds", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    public static boolean hasArgTypeIds(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static ArgCacheInvalidation toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ArgCacheInvalidation toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ArgCacheInvalidation and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ArgCacheInvalidation toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        String[] v0 = null;
        if (hasArgTypeIds(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ArgTypeIds");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("ArgTypeIds", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("ArgTypeIds", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v0[i] = PacketIO.readVarString("ArgTypeIds", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        }
        var result = new ArgCacheInvalidation(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.argTypeIds != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.argTypeIds != null) {
            
            if (argTypeIds.length > 4096000) throw ProtocolException.arrayTooLong("ArgTypeIds", argTypeIds.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.argTypeIds.length);
            
            var argTypeIdsValueOffset = 0;
            for (var i = 0; i < this.argTypeIds.length; i++) {
                argTypeIdsValueOffset += PacketIO.writeVarString(mem, varOffset + argTypeIdsValueOffset, this.argTypeIds[i], 4096000);
            }
            varOffset += argTypeIdsValueOffset;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (argTypeIds != null) {
        int argTypeIdsSize = 0;
for (var elem : argTypeIds) argTypeIdsSize += PacketIO.stringSize(elem);
size += VarInt.size(argTypeIds.length) + argTypeIdsSize;
    }

        return size;
    }

    public ArgCacheInvalidation clone() {
        ArgCacheInvalidation copy = new ArgCacheInvalidation();
        copy.argTypeIds = this.argTypeIds != null ? java.util.Arrays.copyOf(this.argTypeIds, this.argTypeIds.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ArgCacheInvalidation other)) return false;
        return java.util.Arrays.equals(this.argTypeIds, other.argTypeIds);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(argTypeIds);
        return result;
    }

}