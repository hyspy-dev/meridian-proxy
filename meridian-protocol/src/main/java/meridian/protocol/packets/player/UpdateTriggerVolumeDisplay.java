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


public class UpdateTriggerVolumeDisplay implements Packet, ToClientPacket {
    public static final int PACKET_ID = 470;
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

    @Nullable public TriggerVolumeDisplayEntry[] volumes;

    public UpdateTriggerVolumeDisplay() {
    }

    public UpdateTriggerVolumeDisplay(@Nullable TriggerVolumeDisplayEntry[] volumes) {
        this.volumes = volumes;
    }

    public UpdateTriggerVolumeDisplay(@Nonnull UpdateTriggerVolumeDisplay other) {
        this.volumes = other.volumes;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateTriggerVolumeDisplay", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateTriggerVolumeDisplay", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static TriggerVolumeDisplayEntry[] getVolumes(MemorySegment mem) {
        return getVolumes(mem, 0);
    }
    
    @Nullable
    public static TriggerVolumeDisplayEntry[] getVolumes(MemorySegment mem, int offset) {
        if (!hasVolumes(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Volumes");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Volumes", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 86 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Volumes", (int) java.lang.Math.min(off + lenOffset + (long) len * 86, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new TriggerVolumeDisplayEntry[len];
        for (var i = 0; i < len; i++) {
            data[i] = TriggerVolumeDisplayEntry.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasVolumes(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static UpdateTriggerVolumeDisplay toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateTriggerVolumeDisplay toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateTriggerVolumeDisplay and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateTriggerVolumeDisplay toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        TriggerVolumeDisplayEntry[] v0 = null;
        if (hasVolumes(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Volumes");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Volumes", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 86 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Volumes", (int) java.lang.Math.min(off + lenOffset + (long) len * 86, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new TriggerVolumeDisplayEntry[len];
            for (var i = 0; i < len; i++) {
                v0[i] = TriggerVolumeDisplayEntry.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new UpdateTriggerVolumeDisplay(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.volumes != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.volumes != null) {
            
            if (volumes.length > 4096000) throw ProtocolException.arrayTooLong("Volumes", volumes.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.volumes.length);
            
            var volumesValueOffset = 0;
            for (var i = 0; i < this.volumes.length; i++) {
                volumesValueOffset += this.volumes[i].serialize(mem, varOffset + volumesValueOffset);
            }
            varOffset += volumesValueOffset;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (volumes != null) {
        int volumesSize = 0;
for (var elem : volumes) volumesSize += elem.computeSize();
size += VarInt.size(volumes.length) + volumesSize;
    }

        return size;
    }

    public UpdateTriggerVolumeDisplay clone() {
        UpdateTriggerVolumeDisplay copy = new UpdateTriggerVolumeDisplay();
        copy.volumes = this.volumes != null ? java.util.Arrays.stream(this.volumes).map(e -> e.clone()).toArray(TriggerVolumeDisplayEntry[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateTriggerVolumeDisplay other)) return false;
        return java.util.Arrays.equals(this.volumes, other.volumes);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(volumes);
        return result;
    }

}