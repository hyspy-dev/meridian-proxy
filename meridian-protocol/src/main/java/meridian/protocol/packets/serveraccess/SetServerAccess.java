// Auto-generated - do not edit
package meridian.protocol.packets.serveraccess;

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


public class SetServerAccess implements Packet, ToServerPacket {
    public static final int PACKET_ID = 252;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 2;
    public static final int MAX_SIZE = 16384007;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public Access access = Access.Private;
    @Nullable public String password;

    public SetServerAccess() {
    }

    public SetServerAccess(@Nonnull Access access, @Nullable String password) {
        this.access = access;
        this.password = password;
    }

    public SetServerAccess(@Nonnull SetServerAccess other) {
        this.access = other.access;
        this.password = other.password;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SetServerAccess", offset, (int) mem.byteSize());
        long needed = (long) offset + 2;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SetServerAccess", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static Access getAccess(MemorySegment mem) {
        return getAccess(mem, 0);
    }
    
    public static Access getAccess(MemorySegment mem, int offset) {
        return Access.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static String getPassword(MemorySegment mem) {
        return getPassword(mem, 0);
    }
    
    @Nullable
    public static String getPassword(MemorySegment mem, int offset) {
        return hasPassword(mem, offset) ? PacketIO.readVarString("Password", mem, offset + 2, 4096000): null;
    }
    
    public static boolean hasPassword(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static SetServerAccess toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SetServerAccess toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SetServerAccess and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SetServerAccess toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 2;
        var varPos = 0;
        String v1 = null;
        if (hasPassword(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Password", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new SetServerAccess(
            Access.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.password != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.access.getValue());
        var varOffset = offset + 2;
        if (this.password != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.password, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 2;
        if (password != null) size += PacketIO.stringSize(password);

        return size;
    }

    public SetServerAccess clone() {
        SetServerAccess copy = new SetServerAccess();
        copy.access = this.access;
        copy.password = this.password;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SetServerAccess other)) return false;
        return java.util.Objects.equals(this.access, other.access) && java.util.Objects.equals(this.password, other.password);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(access, password);
    }

}