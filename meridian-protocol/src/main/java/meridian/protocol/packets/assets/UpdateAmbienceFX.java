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
import meridian.protocol.AmbienceFX;
import meridian.protocol.UpdateType;
import java.util.HashMap;

public class UpdateAmbienceFX implements Packet, ToClientPacket {
    public static final int PACKET_ID = 62;
    public static final boolean IS_COMPRESSED = true;
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

    @Nonnull public UpdateType type = UpdateType.Init;
    public int maxId;
    @Nullable public java.util.Map<Integer, AmbienceFX> ambienceFX;

    public UpdateAmbienceFX() {
    }

    public UpdateAmbienceFX(@Nonnull UpdateType type, int maxId, @Nullable java.util.Map<Integer, AmbienceFX> ambienceFX) {
        this.type = type;
        this.maxId = maxId;
        this.ambienceFX = ambienceFX;
    }

    public UpdateAmbienceFX(@Nonnull UpdateAmbienceFX other) {
        this.type = other.type;
        this.maxId = other.maxId;
        this.ambienceFX = other.ambienceFX;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateAmbienceFX", offset, (int) mem.byteSize());
        long needed = (long) offset + 6;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateAmbienceFX", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
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
    public static java.util.Map<Integer, AmbienceFX> getAmbienceFX(MemorySegment mem) {
        return getAmbienceFX(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Integer, AmbienceFX> getAmbienceFX(MemorySegment mem, int offset) {
        if (!hasAmbienceFX(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 6;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("AmbienceFX");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("AmbienceFX", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 50 > mem.byteSize()) throw ProtocolException.bufferTooSmall("AmbienceFX", (int) java.lang.Math.min(off + (long) len * 50, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Integer, AmbienceFX> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            var value = AmbienceFX.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("AmbienceFX", key);
            }
        }
        return data;
    }
    
    public static boolean hasAmbienceFX(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static UpdateAmbienceFX toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateAmbienceFX toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateAmbienceFX and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateAmbienceFX toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 6;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        java.util.Map<Integer, AmbienceFX> v2 = null;
        if (hasAmbienceFX(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("AmbienceFX");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("AmbienceFX", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 50 > mem.byteSize()) throw ProtocolException.bufferTooSmall("AmbienceFX", (int) java.lang.Math.min(off + (long) len * 50, Integer.MAX_VALUE), (int) mem.byteSize());
            v2 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                var value = AmbienceFX.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v2.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("AmbienceFX", key);
                }
            }
            varPos = off - varBase;
        }
        var result = new UpdateAmbienceFX(
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
        if (this.ambienceFX != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 2, this.maxId);
        var varOffset = offset + 6;
        if (this.ambienceFX != null) {
            
            if (this.ambienceFX.size() > 4096000) throw ProtocolException.dictionaryTooLarge("AmbienceFX", ambienceFX.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.ambienceFX.size());
            for (var e : this.ambienceFX.entrySet()) {
                mem.set(PacketIO.PROTO_INT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 6;
        if (ambienceFX != null) {
        int ambienceFXSize = 0;
for (var kvp : ambienceFX.entrySet()) ambienceFXSize += 4 + kvp.getValue().computeSize();
size += VarInt.size(ambienceFX.size()) + ambienceFXSize;
    }

        return size;
    }

    public UpdateAmbienceFX clone() {
        UpdateAmbienceFX copy = new UpdateAmbienceFX();
        copy.type = this.type;
        copy.maxId = this.maxId;
        if (this.ambienceFX != null) {
            java.util.Map<Integer, AmbienceFX> m = new java.util.HashMap<>();
            for (var e : this.ambienceFX.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.ambienceFX = m;
        }
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateAmbienceFX other)) return false;
        return java.util.Objects.equals(this.type, other.type) && this.maxId == other.maxId && java.util.Objects.equals(this.ambienceFX, other.ambienceFX);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(type, maxId, ambienceFX);
    }

}