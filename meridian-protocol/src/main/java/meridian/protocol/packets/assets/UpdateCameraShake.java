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
import meridian.protocol.CameraShake;
import meridian.protocol.UpdateType;
import java.util.HashMap;

public class UpdateCameraShake implements Packet, ToClientPacket {
    public static final int PACKET_ID = 77;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 2;
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
    @Nullable public java.util.Map<Integer, CameraShake> profiles;

    public UpdateCameraShake() {
    }

    public UpdateCameraShake(@Nonnull UpdateType type, @Nullable java.util.Map<Integer, CameraShake> profiles) {
        this.type = type;
        this.profiles = profiles;
    }

    public UpdateCameraShake(@Nonnull UpdateCameraShake other) {
        this.type = other.type;
        this.profiles = other.profiles;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateCameraShake", offset, (int) mem.byteSize());
        long needed = (long) offset + 2;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateCameraShake", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static UpdateType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static UpdateType getType(MemorySegment mem, int offset) {
        return UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static java.util.Map<Integer, CameraShake> getProfiles(MemorySegment mem) {
        return getProfiles(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Integer, CameraShake> getProfiles(MemorySegment mem, int offset) {
        if (!hasProfiles(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 2;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Profiles");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Profiles", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 12 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Profiles", (int) java.lang.Math.min(off + (long) len * 12, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Integer, CameraShake> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            var value = CameraShake.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Profiles", key);
            }
        }
        return data;
    }
    
    public static boolean hasProfiles(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static UpdateCameraShake toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateCameraShake toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateCameraShake and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateCameraShake toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 2;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        java.util.Map<Integer, CameraShake> v1 = null;
        if (hasProfiles(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Profiles");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Profiles", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 12 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Profiles", (int) java.lang.Math.min(off + (long) len * 12, Integer.MAX_VALUE), (int) mem.byteSize());
            v1 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                var value = CameraShake.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v1.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Profiles", key);
                }
            }
            varPos = off - varBase;
        }
        var result = new UpdateCameraShake(
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
        if (this.profiles != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        var varOffset = offset + 2;
        if (this.profiles != null) {
            
            if (this.profiles.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Profiles", profiles.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.profiles.size());
            for (var e : this.profiles.entrySet()) {
                mem.set(PacketIO.PROTO_INT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 2;
        if (profiles != null) {
        int profilesSize = 0;
for (var kvp : profiles.entrySet()) profilesSize += 4 + kvp.getValue().computeSize();
size += VarInt.size(profiles.size()) + profilesSize;
    }

        return size;
    }

    public UpdateCameraShake clone() {
        UpdateCameraShake copy = new UpdateCameraShake();
        copy.type = this.type;
        if (this.profiles != null) {
            java.util.Map<Integer, CameraShake> m = new java.util.HashMap<>();
            for (var e : this.profiles.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.profiles = m;
        }
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateCameraShake other)) return false;
        return java.util.Objects.equals(this.type, other.type) && java.util.Objects.equals(this.profiles, other.profiles);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(type, profiles);
    }

}