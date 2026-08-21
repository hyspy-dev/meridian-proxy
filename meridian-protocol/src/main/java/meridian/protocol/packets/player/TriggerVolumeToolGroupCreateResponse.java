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


public class TriggerVolumeToolGroupCreateResponse implements Packet, ToClientPacket {
    public static final int PACKET_ID = 487;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 16384014;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public String groupId = "";
    public int color;
    public boolean success;
    public int skippedCount;

    public TriggerVolumeToolGroupCreateResponse() {
    }

    public TriggerVolumeToolGroupCreateResponse(@Nonnull String groupId, int color, boolean success, int skippedCount) {
        this.groupId = groupId;
        this.color = color;
        this.success = success;
        this.skippedCount = skippedCount;
    }

    public TriggerVolumeToolGroupCreateResponse(@Nonnull TriggerVolumeToolGroupCreateResponse other) {
        this.groupId = other.groupId;
        this.color = other.color;
        this.success = other.success;
        this.skippedCount = other.skippedCount;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("TriggerVolumeToolGroupCreateResponse", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("TriggerVolumeToolGroupCreateResponse", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getGroupId(MemorySegment mem) {
        return getGroupId(mem, 0);
    }
    
    public static String getGroupId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("GroupId", mem, offset + 9, 4096000);
    }
    
    public static int getColor(MemorySegment mem) {
        return getColor(mem, 0);
    }
    
    public static int getColor(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static boolean getSuccess(MemorySegment mem) {
        return getSuccess(mem, 0);
    }
    
    public static boolean getSuccess(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 4);
    }
    
    public static int getSkippedCount(MemorySegment mem) {
        return getSkippedCount(mem, 0);
    }
    
    public static int getSkippedCount(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    
    
    
    
    public static TriggerVolumeToolGroupCreateResponse toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static TriggerVolumeToolGroupCreateResponse toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one TriggerVolumeToolGroupCreateResponse and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static TriggerVolumeToolGroupCreateResponse toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        String v0;
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("GroupId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new TriggerVolumeToolGroupCreateResponse(
            v0,
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_BOOL, offset + 4),
            mem.get(PacketIO.PROTO_INT, offset + 5)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.color);
        mem.set(PacketIO.PROTO_BOOL, offset + 4, this.success);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.skippedCount);
        var varOffset = offset + 9;
        varOffset += PacketIO.writeVarString(mem, varOffset, this.groupId, 4096000);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        size += PacketIO.stringSize(groupId);

        return size;
    }

    public TriggerVolumeToolGroupCreateResponse clone() {
        TriggerVolumeToolGroupCreateResponse copy = new TriggerVolumeToolGroupCreateResponse();
        copy.groupId = this.groupId;
        copy.color = this.color;
        copy.success = this.success;
        copy.skippedCount = this.skippedCount;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TriggerVolumeToolGroupCreateResponse other)) return false;
        return java.util.Objects.equals(this.groupId, other.groupId) && this.color == other.color && this.success == other.success && this.skippedCount == other.skippedCount;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(groupId, color, success, skippedCount);
    }

}