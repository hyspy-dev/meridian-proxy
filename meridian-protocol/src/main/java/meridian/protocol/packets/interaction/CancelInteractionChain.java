// Auto-generated - do not edit
package meridian.protocol.packets.interaction;

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
import meridian.protocol.ForkedChainId;

public class CancelInteractionChain implements Packet, ToClientPacket {
    public static final int PACKET_ID = 291;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 5;
    public static final int MAX_SIZE = 1038;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int chainId;
    @Nullable public ForkedChainId forkedId;

    public CancelInteractionChain() {
    }

    public CancelInteractionChain(int chainId, @Nullable ForkedChainId forkedId) {
        this.chainId = chainId;
        this.forkedId = forkedId;
    }

    public CancelInteractionChain(@Nonnull CancelInteractionChain other) {
        this.chainId = other.chainId;
        this.forkedId = other.forkedId;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CancelInteractionChain", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CancelInteractionChain", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getChainId(MemorySegment mem) {
        return getChainId(mem, 0);
    }
    
    public static int getChainId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static ForkedChainId getForkedId(MemorySegment mem) {
        return getForkedId(mem, 0);
    }
    
    @Nullable
    public static ForkedChainId getForkedId(MemorySegment mem, int offset) {
        return hasForkedId(mem, offset) ? ForkedChainId.toObject(mem, offset + 5): null;
    }
    
    public static boolean hasForkedId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static CancelInteractionChain toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CancelInteractionChain toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CancelInteractionChain and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CancelInteractionChain toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 5;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ForkedChainId v1 = null;
        if (hasForkedId(mem, offset)) {
            v1 = ForkedChainId.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new CancelInteractionChain(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.forkedId != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.chainId);
        var varOffset = offset + 5;
        if (this.forkedId != null) {
            
            varOffset += this.forkedId.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 5;
        if (forkedId != null) size += forkedId.computeSize();

        return size;
    }

    public CancelInteractionChain clone() {
        CancelInteractionChain copy = new CancelInteractionChain();
        copy.chainId = this.chainId;
        copy.forkedId = this.forkedId != null ? this.forkedId.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CancelInteractionChain other)) return false;
        return this.chainId == other.chainId && java.util.Objects.equals(this.forkedId, other.forkedId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(chainId, forkedId);
    }

}