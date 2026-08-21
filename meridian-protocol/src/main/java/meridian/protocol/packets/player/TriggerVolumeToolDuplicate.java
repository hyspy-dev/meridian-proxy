// Auto-generated - do not edit
package meridian.protocol.packets.player;

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


public class TriggerVolumeToolDuplicate implements Packet, ToServerPacket {
    public static final int PACKET_ID = 505;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 0;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public String[] volumeIds = new String[0];

    public TriggerVolumeToolDuplicate() {
    }

    public TriggerVolumeToolDuplicate(@Nonnull String[] volumeIds) {
        this.volumeIds = volumeIds;
    }

    public TriggerVolumeToolDuplicate(@Nonnull TriggerVolumeToolDuplicate other) {
        this.volumeIds = other.volumeIds;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("TriggerVolumeToolDuplicate", offset, (int) mem.byteSize());
        long needed = (long) offset + 0;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("TriggerVolumeToolDuplicate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String[] getVolumeIds(MemorySegment mem) {
        return getVolumeIds(mem, 0);
    }
    
    public static String[] getVolumeIds(MemorySegment mem, int offset) {
        var off = offset + 0;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("VolumeIds");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("VolumeIds", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("VolumeIds", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("VolumeIds", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    
    
    
    
    public static TriggerVolumeToolDuplicate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static TriggerVolumeToolDuplicate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one TriggerVolumeToolDuplicate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static TriggerVolumeToolDuplicate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 0;
        var varPos = 0;
        String[] v0;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("VolumeIds");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("VolumeIds", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("VolumeIds", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v0[i] = PacketIO.readVarString("VolumeIds", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        }
        var result = new TriggerVolumeToolDuplicate(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 0;
        if (volumeIds.length > 4096000) throw ProtocolException.arrayTooLong("VolumeIds", volumeIds.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.volumeIds.length);
        
        var volumeIdsValueOffset = 0;
        for (var i = 0; i < this.volumeIds.length; i++) {
            volumeIdsValueOffset += PacketIO.writeVarString(mem, varOffset + volumeIdsValueOffset, this.volumeIds[i], 4096000);
        }
        varOffset += volumeIdsValueOffset;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 0;
        int volumeIdsSize = 0;
for (var elem : volumeIds) volumeIdsSize += PacketIO.stringSize(elem);
size += VarInt.size(volumeIds.length) + volumeIdsSize;

        return size;
    }

    public TriggerVolumeToolDuplicate clone() {
        TriggerVolumeToolDuplicate copy = new TriggerVolumeToolDuplicate();
        copy.volumeIds = java.util.Arrays.copyOf(this.volumeIds, this.volumeIds.length);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TriggerVolumeToolDuplicate other)) return false;
        return java.util.Arrays.equals(this.volumeIds, other.volumeIds);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(volumeIds);
        return result;
    }

}