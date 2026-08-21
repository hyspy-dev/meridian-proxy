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
import meridian.protocol.FormattedMessage;

public class UpdateBossBar implements Packet, ToClientPacket {
    public static final int PACKET_ID = 236;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 6;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int entityNetworkId;
    @Nullable public FormattedMessage name;
    public boolean hide;

    public UpdateBossBar() {
    }

    public UpdateBossBar(int entityNetworkId, @Nullable FormattedMessage name, boolean hide) {
        this.entityNetworkId = entityNetworkId;
        this.name = name;
        this.hide = hide;
    }

    public UpdateBossBar(@Nonnull UpdateBossBar other) {
        this.entityNetworkId = other.entityNetworkId;
        this.name = other.name;
        this.hide = other.hide;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateBossBar", offset, (int) mem.byteSize());
        long needed = (long) offset + 6;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateBossBar", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getEntityNetworkId(MemorySegment mem) {
        return getEntityNetworkId(mem, 0);
    }
    
    public static int getEntityNetworkId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static FormattedMessage getName(MemorySegment mem) {
        return getName(mem, 0);
    }
    
    @Nullable
    public static FormattedMessage getName(MemorySegment mem, int offset) {
        return hasName(mem, offset) ? FormattedMessage.toObject(mem, offset + 6): null;
    }
    
    public static boolean getHide(MemorySegment mem) {
        return getHide(mem, 0);
    }
    
    public static boolean getHide(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 5);
    }
    
    public static boolean hasName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static UpdateBossBar toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateBossBar toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateBossBar and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateBossBar toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 6;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        FormattedMessage v1 = null;
        if (hasName(mem, offset)) {
            v1 = FormattedMessage.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new UpdateBossBar(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v1,
            mem.get(PacketIO.PROTO_BOOL, offset + 5)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.name != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.entityNetworkId);
        mem.set(PacketIO.PROTO_BOOL, offset + 5, this.hide);
        var varOffset = offset + 6;
        if (this.name != null) {
            
            varOffset += this.name.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 6;
        if (name != null) size += name.computeSize();

        return size;
    }

    public UpdateBossBar clone() {
        UpdateBossBar copy = new UpdateBossBar();
        copy.entityNetworkId = this.entityNetworkId;
        copy.name = this.name != null ? this.name.clone() : null;
        copy.hide = this.hide;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateBossBar other)) return false;
        return this.entityNetworkId == other.entityNetworkId && java.util.Objects.equals(this.name, other.name) && this.hide == other.hide;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(entityNetworkId, name, hide);
    }

}