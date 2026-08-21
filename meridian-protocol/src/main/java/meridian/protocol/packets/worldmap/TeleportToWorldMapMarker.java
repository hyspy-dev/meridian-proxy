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


public class TeleportToWorldMapMarker implements Packet, ToServerPacket {
    public static final int PACKET_ID = 244;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 0;
    public static final int MAX_SIZE = 16384005;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public String id = "";

    public TeleportToWorldMapMarker() {
    }

    public TeleportToWorldMapMarker(@Nonnull String id) {
        this.id = id;
    }

    public TeleportToWorldMapMarker(@Nonnull TeleportToWorldMapMarker other) {
        this.id = other.id;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("TeleportToWorldMapMarker", offset, (int) mem.byteSize());
        long needed = (long) offset + 0;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("TeleportToWorldMapMarker", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    public static String getId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("Id", mem, offset + 0, 4096000);
    }
    
    
    
    
    
    public static TeleportToWorldMapMarker toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static TeleportToWorldMapMarker toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one TeleportToWorldMapMarker and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static TeleportToWorldMapMarker toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 0;
        var varPos = 0;
        String v0;
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new TeleportToWorldMapMarker(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 0;
        varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 0;
        size += PacketIO.stringSize(id);

        return size;
    }

    public TeleportToWorldMapMarker clone() {
        TeleportToWorldMapMarker copy = new TeleportToWorldMapMarker();
        copy.id = this.id;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TeleportToWorldMapMarker other)) return false;
        return java.util.Objects.equals(this.id, other.id);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }

}