// Auto-generated - do not edit
package meridian.protocol.packets.buildertools;

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


public class BuilderToolsEnabledTools implements Packet, ToClientPacket {
    public static final int PACKET_ID = 432;
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

    @Nullable public String[] toolIds;

    public BuilderToolsEnabledTools() {
    }

    public BuilderToolsEnabledTools(@Nullable String[] toolIds) {
        this.toolIds = toolIds;
    }

    public BuilderToolsEnabledTools(@Nonnull BuilderToolsEnabledTools other) {
        this.toolIds = other.toolIds;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolsEnabledTools", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolsEnabledTools", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String[] getToolIds(MemorySegment mem) {
        return getToolIds(mem, 0);
    }
    
    @Nullable
    public static String[] getToolIds(MemorySegment mem, int offset) {
        if (!hasToolIds(mem, offset)) return null;
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ToolIds");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("ToolIds", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("ToolIds", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("ToolIds", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    public static boolean hasToolIds(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static BuilderToolsEnabledTools toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolsEnabledTools toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolsEnabledTools and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolsEnabledTools toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        String[] v0 = null;
        if (hasToolIds(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ToolIds");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("ToolIds", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("ToolIds", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v0[i] = PacketIO.readVarString("ToolIds", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        }
        var result = new BuilderToolsEnabledTools(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.toolIds != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.toolIds != null) {
            
            if (toolIds.length > 4096000) throw ProtocolException.arrayTooLong("ToolIds", toolIds.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.toolIds.length);
            
            var toolIdsValueOffset = 0;
            for (var i = 0; i < this.toolIds.length; i++) {
                toolIdsValueOffset += PacketIO.writeVarString(mem, varOffset + toolIdsValueOffset, this.toolIds[i], 4096000);
            }
            varOffset += toolIdsValueOffset;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (toolIds != null) {
        int toolIdsSize = 0;
for (var elem : toolIds) toolIdsSize += PacketIO.stringSize(elem);
size += VarInt.size(toolIds.length) + toolIdsSize;
    }

        return size;
    }

    public BuilderToolsEnabledTools clone() {
        BuilderToolsEnabledTools copy = new BuilderToolsEnabledTools();
        copy.toolIds = this.toolIds != null ? java.util.Arrays.copyOf(this.toolIds, this.toolIds.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolsEnabledTools other)) return false;
        return java.util.Arrays.equals(this.toolIds, other.toolIds);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(toolIds);
        return result;
    }

}