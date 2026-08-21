// Auto-generated - do not edit
package meridian.protocol.packets.setup;

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
import java.util.HashMap;

public class UpdateFeatures implements Packet, ToClientPacket {
    public static final int PACKET_ID = 31;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 8192006;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public java.util.Map<ClientFeature, Boolean> features;

    public UpdateFeatures() {
    }

    public UpdateFeatures(@Nullable java.util.Map<ClientFeature, Boolean> features) {
        this.features = features;
    }

    public UpdateFeatures(@Nonnull UpdateFeatures other) {
        this.features = other.features;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateFeatures", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateFeatures", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static java.util.Map<ClientFeature, Boolean> getFeatures(MemorySegment mem) {
        return getFeatures(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<ClientFeature, Boolean> getFeatures(MemorySegment mem, int offset) {
        if (!hasFeatures(mem, offset)) return null;
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Features");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Features", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Features", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<ClientFeature, Boolean> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = ClientFeature.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                off += 1;
            var value = mem.get(PacketIO.PROTO_BOOL, off);
                off += 1;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Features", key);
            }
        }
        return data;
    }
    
    public static boolean hasFeatures(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static UpdateFeatures toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateFeatures toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateFeatures and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateFeatures toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        java.util.Map<ClientFeature, Boolean> v0 = null;
        if (hasFeatures(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Features");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Features", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Features", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            v0 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = ClientFeature.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                    off += 1;
                var value = mem.get(PacketIO.PROTO_BOOL, off);
                    off += 1;
                if (v0.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Features", key);
                }
            }
            varPos = off - varBase;
        }
        var result = new UpdateFeatures(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.features != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.features != null) {
            
            if (this.features.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Features", features.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.features.size());
            for (var e : this.features.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                mem.set(PacketIO.PROTO_BOOL, varOffset, e.getValue());
                varOffset += 1;
            }
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (features != null) size += VarInt.size(features.size()) + features.size() * (1 + 1);

        return size;
    }

    public UpdateFeatures clone() {
        UpdateFeatures copy = new UpdateFeatures();
        copy.features = this.features != null ? new java.util.HashMap<>(this.features) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateFeatures other)) return false;
        return java.util.Objects.equals(this.features, other.features);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(features);
    }

}