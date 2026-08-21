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


public class SyncInteractionChains implements Packet, ToServerPacket, ToClientPacket {
    public static final int PACKET_ID = 290;
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

    @Nonnull public SyncInteractionChain[] updates = new SyncInteractionChain[0];

    public SyncInteractionChains() {
    }

    public SyncInteractionChains(@Nonnull SyncInteractionChain[] updates) {
        this.updates = updates;
    }

    public SyncInteractionChains(@Nonnull SyncInteractionChains other) {
        this.updates = other.updates;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SyncInteractionChains", offset, (int) mem.byteSize());
        long needed = (long) offset + 0;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SyncInteractionChains", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static SyncInteractionChain[] getUpdates(MemorySegment mem) {
        return getUpdates(mem, 0);
    }
    
    public static SyncInteractionChain[] getUpdates(MemorySegment mem, int offset) {
        var walkCursor = new ReadCursor();
        var off = offset + 0;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Updates");
        var len = (int) packed;
        if (len > 128) throw ProtocolException.arrayTooLong("Updates", len, 128);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 60 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Updates", (int) java.lang.Math.min(off + lenOffset + (long) len * 60, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new SyncInteractionChain[len];
        for (var i = 0; i < len; i++) {
            data[i] = SyncInteractionChain.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    
    
    
    
    public static SyncInteractionChains toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SyncInteractionChains toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SyncInteractionChains and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SyncInteractionChains toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 0;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        SyncInteractionChain[] v0;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Updates");
            var len = (int) packed;
            if (len > 128) throw ProtocolException.arrayTooLong("Updates", len, 128);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 60 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Updates", (int) java.lang.Math.min(off + lenOffset + (long) len * 60, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new SyncInteractionChain[len];
            for (var i = 0; i < len; i++) {
                v0[i] = SyncInteractionChain.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new SyncInteractionChains(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 0;
        if (updates.length > 128) throw ProtocolException.arrayTooLong("Updates", updates.length, 128);
        varOffset += VarInt.set(mem, varOffset, this.updates.length);
        
        var updatesValueOffset = 0;
        for (var i = 0; i < this.updates.length; i++) {
            updatesValueOffset += this.updates[i].serialize(mem, varOffset + updatesValueOffset);
        }
        varOffset += updatesValueOffset;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 0;
        int updatesSize = 0;
for (var elem : updates) updatesSize += elem.computeSize();
size += VarInt.size(updates.length) + updatesSize;

        return size;
    }

    public SyncInteractionChains clone() {
        SyncInteractionChains copy = new SyncInteractionChains();
        copy.updates = java.util.Arrays.stream(this.updates).map(e -> e.clone()).toArray(SyncInteractionChain[]::new);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SyncInteractionChains other)) return false;
        return java.util.Arrays.equals(this.updates, other.updates);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(updates);
        return result;
    }

}