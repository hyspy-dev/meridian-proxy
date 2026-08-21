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


public class UpdatePortal implements Packet, ToClientPacket {
    public static final int PACKET_ID = 229;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 6;
    public static final int MAX_SIZE = 16384020;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public PortalState state;
    @Nullable public PortalDef definition;

    public UpdatePortal() {
    }

    public UpdatePortal(@Nullable PortalState state, @Nullable PortalDef definition) {
        this.state = state;
        this.definition = definition;
    }

    public UpdatePortal(@Nonnull UpdatePortal other) {
        this.state = other.state;
        this.definition = other.definition;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdatePortal", offset, (int) mem.byteSize());
        long needed = (long) offset + 6;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdatePortal", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static PortalState getState(MemorySegment mem) {
        return getState(mem, 0);
    }
    
    @Nullable
    public static PortalState getState(MemorySegment mem, int offset) {
        return hasState(mem, offset) ? PortalState.toObject(mem, offset + 1): null;
    }
    
    @Nullable
    public static PortalDef getDefinition(MemorySegment mem) {
        return getDefinition(mem, 0);
    }
    
    @Nullable
    public static PortalDef getDefinition(MemorySegment mem, int offset) {
        return hasDefinition(mem, offset) ? PortalDef.toObject(mem, offset + 6): null;
    }
    
    public static boolean hasState(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasDefinition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    
    
    public static UpdatePortal toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdatePortal toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdatePortal and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdatePortal toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 6;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        PortalDef v1 = null;
        if (hasDefinition(mem, offset)) {
            v1 = PortalDef.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new UpdatePortal(
            hasState(mem, offset) ? PortalState.toObject(mem, offset + 1) : null,
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.state != null) nullBits |= 0x01;
        if (this.definition != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.state != null) {
            this.state.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 5).fill((byte) 0); 
        }
        var varOffset = offset + 6;
        if (this.definition != null) {
            
            varOffset += this.definition.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 6;
        if (definition != null) size += definition.computeSize();

        return size;
    }

    public UpdatePortal clone() {
        UpdatePortal copy = new UpdatePortal();
        copy.state = this.state != null ? this.state.clone() : null;
        copy.definition = this.definition != null ? this.definition.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdatePortal other)) return false;
        return java.util.Objects.equals(this.state, other.state) && java.util.Objects.equals(this.definition, other.definition);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(state, definition);
    }

}