// Auto-generated - do not edit
package meridian.protocol.packets.assets;

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
import meridian.protocol.InteractionType;
import meridian.protocol.UpdateType;
import java.util.HashMap;

public class UpdateUnarmedInteractions implements Packet, ToClientPacket {
    public static final int PACKET_ID = 68;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 2;
    public static final int MAX_SIZE = 20480007;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public UpdateType type = UpdateType.Init;
    @Nullable public java.util.Map<InteractionType, Integer> interactions;

    public UpdateUnarmedInteractions() {
    }

    public UpdateUnarmedInteractions(@Nonnull UpdateType type, @Nullable java.util.Map<InteractionType, Integer> interactions) {
        this.type = type;
        this.interactions = interactions;
    }

    public UpdateUnarmedInteractions(@Nonnull UpdateUnarmedInteractions other) {
        this.type = other.type;
        this.interactions = other.interactions;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateUnarmedInteractions", offset, (int) mem.byteSize());
        long needed = (long) offset + 2;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateUnarmedInteractions", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static UpdateType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static UpdateType getType(MemorySegment mem, int offset) {
        return UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static java.util.Map<InteractionType, Integer> getInteractions(MemorySegment mem) {
        return getInteractions(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<InteractionType, Integer> getInteractions(MemorySegment mem, int offset) {
        if (!hasInteractions(mem, offset)) return null;
        var off = offset + 2;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Interactions");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Interactions", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Interactions", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<InteractionType, Integer> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                off += 1;
            var value = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Interactions", key);
            }
        }
        return data;
    }
    
    public static boolean hasInteractions(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static UpdateUnarmedInteractions toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateUnarmedInteractions toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateUnarmedInteractions and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateUnarmedInteractions toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 2;
        var varPos = 0;
        java.util.Map<InteractionType, Integer> v1 = null;
        if (hasInteractions(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Interactions");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Interactions", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Interactions", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v1 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = InteractionType.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                    off += 1;
                var value = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                if (v1.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Interactions", key);
                }
            }
            varPos = off - varBase;
        }
        var result = new UpdateUnarmedInteractions(
            UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.interactions != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        var varOffset = offset + 2;
        if (this.interactions != null) {
            
            if (this.interactions.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Interactions", interactions.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.interactions.size());
            for (var e : this.interactions.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                mem.set(PacketIO.PROTO_INT, varOffset, e.getValue());
                varOffset += 4;
            }
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 2;
        if (interactions != null) size += VarInt.size(interactions.size()) + interactions.size() * (1 + 4);

        return size;
    }

    public UpdateUnarmedInteractions clone() {
        UpdateUnarmedInteractions copy = new UpdateUnarmedInteractions();
        copy.type = this.type;
        copy.interactions = this.interactions != null ? new java.util.HashMap<>(this.interactions) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateUnarmedInteractions other)) return false;
        return java.util.Objects.equals(this.type, other.type) && java.util.Objects.equals(this.interactions, other.interactions);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(type, interactions);
    }

}