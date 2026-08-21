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
import meridian.protocol.RepulsionConfig;
import meridian.protocol.UpdateType;
import java.util.HashMap;

public class UpdateRepulsionConfig implements Packet, ToClientPacket {
    public static final int PACKET_ID = 75;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 6;
    public static final int MAX_SIZE = 65536011;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public UpdateType type = UpdateType.Init;
    public int maxId;
    @Nullable public java.util.Map<Integer, RepulsionConfig> repulsionConfigs;

    public UpdateRepulsionConfig() {
    }

    public UpdateRepulsionConfig(@Nonnull UpdateType type, int maxId, @Nullable java.util.Map<Integer, RepulsionConfig> repulsionConfigs) {
        this.type = type;
        this.maxId = maxId;
        this.repulsionConfigs = repulsionConfigs;
    }

    public UpdateRepulsionConfig(@Nonnull UpdateRepulsionConfig other) {
        this.type = other.type;
        this.maxId = other.maxId;
        this.repulsionConfigs = other.repulsionConfigs;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateRepulsionConfig", offset, (int) mem.byteSize());
        long needed = (long) offset + 6;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateRepulsionConfig", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static UpdateType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static UpdateType getType(MemorySegment mem, int offset) {
        return UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static int getMaxId(MemorySegment mem) {
        return getMaxId(mem, 0);
    }
    
    public static int getMaxId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 2);
    }
    
    @Nullable
    public static java.util.Map<Integer, RepulsionConfig> getRepulsionConfigs(MemorySegment mem) {
        return getRepulsionConfigs(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Integer, RepulsionConfig> getRepulsionConfigs(MemorySegment mem, int offset) {
        if (!hasRepulsionConfigs(mem, offset)) return null;
        var off = offset + 6;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("RepulsionConfigs");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("RepulsionConfigs", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 16 > mem.byteSize()) throw ProtocolException.bufferTooSmall("RepulsionConfigs", (int) java.lang.Math.min(off + (long) len * 16, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Integer, RepulsionConfig> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            var value = RepulsionConfig.toObject(mem, off);
                off += 12;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("RepulsionConfigs", key);
            }
        }
        return data;
    }
    
    public static boolean hasRepulsionConfigs(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static UpdateRepulsionConfig toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateRepulsionConfig toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateRepulsionConfig and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateRepulsionConfig toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 6;
        var varPos = 0;
        java.util.Map<Integer, RepulsionConfig> v2 = null;
        if (hasRepulsionConfigs(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("RepulsionConfigs");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("RepulsionConfigs", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 16 > mem.byteSize()) throw ProtocolException.bufferTooSmall("RepulsionConfigs", (int) java.lang.Math.min(off + (long) len * 16, Integer.MAX_VALUE), (int) mem.byteSize());
            v2 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                var value = RepulsionConfig.toObject(mem, off);
                    off += 12;
                if (v2.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("RepulsionConfigs", key);
                }
            }
            varPos = off - varBase;
        }
        var result = new UpdateRepulsionConfig(
            UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            mem.get(PacketIO.PROTO_INT, offset + 2),
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.repulsionConfigs != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 2, this.maxId);
        var varOffset = offset + 6;
        if (this.repulsionConfigs != null) {
            
            if (this.repulsionConfigs.size() > 4096000) throw ProtocolException.dictionaryTooLarge("RepulsionConfigs", repulsionConfigs.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.repulsionConfigs.size());
            for (var e : this.repulsionConfigs.entrySet()) {
                mem.set(PacketIO.PROTO_INT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 6;
        if (repulsionConfigs != null) size += VarInt.size(repulsionConfigs.size()) + repulsionConfigs.size() * (4 + 12);

        return size;
    }

    public UpdateRepulsionConfig clone() {
        UpdateRepulsionConfig copy = new UpdateRepulsionConfig();
        copy.type = this.type;
        copy.maxId = this.maxId;
        if (this.repulsionConfigs != null) {
            java.util.Map<Integer, RepulsionConfig> m = new java.util.HashMap<>();
            for (var e : this.repulsionConfigs.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.repulsionConfigs = m;
        }
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateRepulsionConfig other)) return false;
        return java.util.Objects.equals(this.type, other.type) && this.maxId == other.maxId && java.util.Objects.equals(this.repulsionConfigs, other.repulsionConfigs);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(type, maxId, repulsionConfigs);
    }

}