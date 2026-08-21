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
import meridian.protocol.HostAddress;

public class UpdateServerAccess implements Packet, ToServerPacket {
    public static final int PACKET_ID = 251;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
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

    @Nonnull public Access access = Access.Private;
    @Nonnull public HostAddress[] hosts = new HostAddress[0];

    public UpdateServerAccess() {
    }

    public UpdateServerAccess(@Nonnull Access access, @Nonnull HostAddress[] hosts) {
        this.access = access;
        this.hosts = hosts;
    }

    public UpdateServerAccess(@Nonnull UpdateServerAccess other) {
        this.access = other.access;
        this.hosts = other.hosts;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateServerAccess", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateServerAccess", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static Access getAccess(MemorySegment mem) {
        return getAccess(mem, 0);
    }
    
    public static Access getAccess(MemorySegment mem, int offset) {
        return Access.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0));
    }
    
    public static HostAddress[] getHosts(MemorySegment mem) {
        return getHosts(mem, 0);
    }
    
    public static HostAddress[] getHosts(MemorySegment mem, int offset) {
        var walkCursor = new ReadCursor();
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Hosts");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Hosts", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Hosts", (int) java.lang.Math.min(off + lenOffset + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new HostAddress[len];
        for (var i = 0; i < len; i++) {
            data[i] = HostAddress.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    
    
    
    
    public static UpdateServerAccess toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateServerAccess toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateServerAccess and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateServerAccess toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        HostAddress[] v1;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Hosts");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Hosts", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Hosts", (int) java.lang.Math.min(off + lenOffset + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new HostAddress[len];
            for (var i = 0; i < len; i++) {
                v1[i] = HostAddress.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new UpdateServerAccess(
            Access.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0)),
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, (byte) this.access.getValue());
        var varOffset = offset + 1;
        if (hosts.length > 4096000) throw ProtocolException.arrayTooLong("Hosts", hosts.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.hosts.length);
        
        var hostsValueOffset = 0;
        for (var i = 0; i < this.hosts.length; i++) {
            hostsValueOffset += this.hosts[i].serialize(mem, varOffset + hostsValueOffset);
        }
        varOffset += hostsValueOffset;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        int hostsSize = 0;
for (var elem : hosts) hostsSize += elem.computeSize();
size += VarInt.size(hosts.length) + hostsSize;

        return size;
    }

    public UpdateServerAccess clone() {
        UpdateServerAccess copy = new UpdateServerAccess();
        copy.access = this.access;
        copy.hosts = java.util.Arrays.stream(this.hosts).map(e -> e.clone()).toArray(HostAddress[]::new);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateServerAccess other)) return false;
        return java.util.Objects.equals(this.access, other.access) && java.util.Arrays.equals(this.hosts, other.hosts);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(access);
        result = 31 * result + java.util.Arrays.hashCode(hosts);
        return result;
    }

}